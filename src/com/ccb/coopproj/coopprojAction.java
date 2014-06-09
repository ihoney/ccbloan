package com.ccb.coopproj;

/**
 * <p>Title: 后台业务组件</p>
 *
 * <p>Description: 后台业务组件</p>
 *
 * <p>Copyright: Copyright (c) 2010</p>
 *
 * <p>Company: 公司</p>
 *
 * @author
 * @version 1.0
 */

import com.ccb.dao.LNCOOPPROJ;
import com.ccb.dao.LNTASKINFO;
import com.ccb.mortgage.MortUtil;
import com.ccb.util.CcbLoanConst;
import com.ccb.util.SeqUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import pub.platform.advance.utils.PropertyManager;
import pub.platform.db.RecordSet;
import pub.platform.form.control.Action;
import pub.platform.utils.BusinessDate;

public class coopprojAction extends Action {
    // 抵押信息对象
    LNCOOPPROJ coopproj = null;
    // 系统日志表
    LNTASKINFO task = null;

    private static final Log logger = LogFactory.getLog(coopprojAction.class);

    /**
     * <p/>
     * 抵押信息增加接口
     * <p/>
     * 成功或失败均返回消息
     * <p/>
     * 部门id、用户id、操作时间均在后台赋值
     *
     * @return
     */

    public int add() {
        coopproj = new LNCOOPPROJ();
        for (int i = 0; i < this.req.getRecorderCount(); i++) {
            try {
                // 初始化数据bean
                coopproj.initAll(i, req);

                LNCOOPPROJ coopprojTmp = coopproj.findFirst(" where  proj_no = '" + coopproj.getProj_no() + "'");
                if (coopprojTmp != null) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("增加合作项目出现错误, 此项目已存在。");
                    return -1;
                }

                // 内部序号
                String coopSeq = SeqUtil.getCoop();
                coopproj.setProj_nbxh(coopSeq);
                // 部门id
                coopproj.setDeptid(this.getDept().getDeptid());
                // 操作时间
                coopproj.setOperdate(BusinessDate.getToday());
                // 用户id
                coopproj.setOperid(this.getOperator().getOperid());
                // 版本号
                coopproj.setRecversion(0);
                if (coopproj.insert() < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage(PropertyManager.getProperty("300"));
                    return -1;
                }
                // 流水日志表
                task = MortUtil.getTaskObj(coopSeq, req.getFieldValue(i, "busiNode"), CcbLoanConst.OPER_ADD);
                task.setOperid(this.getOperator().getOperid());
                task.setBankid(this.getOperator().getDeptid());
                if (task.insert() < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage(PropertyManager.getProperty("300"));
                    return -1;
                }

            } catch (Exception ex1) {
                ex1.printStackTrace();
                logger.error("增加合作项目出现错误！");
                logger.error(ex1.getMessage());
                this.res.setType(0);
                this.res.setResult(false);
                this.res.setMessage(PropertyManager.getProperty("300"));
                return -1;
            }
        }
        this.res.setType(0);
        this.res.setResult(true);
        this.res.setMessage(PropertyManager.getProperty("200"));
        return 0;
    }

    /**
     * <p/>
     * 抵押信息编辑接口
     * <p/>
     * 除了更新页面上的值之外，用户id、操作时间也一起更新；
     * <p/>
     * 更新前进行版本号检查，控制并发问题
     *
     * @return
     */
    public int edit() {

        coopproj = new LNCOOPPROJ();
        for (int i = 0; i < this.req.getRecorderCount(); i++) {
            try {
                // 初始化数据bean
                coopproj.initAll(i, req);

                LNCOOPPROJ coopprojTmp = coopproj.findFirst(" where  proj_no = '" + coopproj.getProj_no() + "'");
                if (coopprojTmp != null) {
                    if (!coopprojTmp.getProj_nbxh().equals(coopproj.getProj_nbxh())) {
                        this.res.setType(0);
                        this.res.setResult(false);
                        this.res.setMessage("修改合作项目出现错误, 此项目已存在。");
                        return -1;
                    }
                }

                // 操作时间
                coopproj.setOperdate(BusinessDate.getToday());
                // 用户id
                coopproj.setOperid(this.getOperator().getOperid());
                // 更新前版本号
                int iBeforeVersion = 0;
                if (req.getFieldValue(i, "recVersion") != null && !req.getFieldValue(i, "recVersion").equals("")) {
                    iBeforeVersion = Integer.parseInt(req.getFieldValue(i, "recVersion"));
                }
                int iAfterVersion = 0;
                RecordSet rs = dc.executeQuery("select recversion from ln_coopproj where proj_nbxh='"
                        + req.getFieldValue("proj_nbxh") + "'");
                while (rs.next()) {
                    iAfterVersion = rs.getInt("recVersion");
                    if (iBeforeVersion != iAfterVersion) {
                        this.res.setType(0);
                        this.res.setResult(false);
                        this.res.setMessage(PropertyManager.getProperty("301"));
                        return -1;
                    } else {
                        // 版本号加1
                        iBeforeVersion = iBeforeVersion + 1;
                        coopproj.setRecversion(iBeforeVersion);
                    }
                }

                if (coopproj.updateByWhere(" where proj_nbxh='" + req.getFieldValue(i, "proj_nbxh") + "'") < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage(PropertyManager.getProperty("300"));
                    return -1;
                }
                // 流水日志表
                task = MortUtil.getTaskObj(req.getFieldValue(i, "proj_nbxh"), req.getFieldValue(i, "busiNode"),
                        CcbLoanConst.OPER_EDIT);
                task.setOperid(this.getOperator().getOperid());
                task.setBankid(this.getOperator().getDeptid());
                if (task.insert() < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage(PropertyManager.getProperty("300"));
                    return -1;
                }

            } catch (Exception ex1) {
                ex1.printStackTrace();
                logger.error("编辑合作项目出现错误！");
                logger.error(ex1.getMessage());
                this.res.setType(0);
                this.res.setResult(false);
                this.res.setMessage(PropertyManager.getProperty("300"));
                return -1;
            }
        }
        this.res.setType(0);
        this.res.setResult(true);
        this.res.setMessage(PropertyManager.getProperty("200"));
        return 0;
    }

    /**
     * <p/>
     * 删除接口
     * <p/>
     */

    public int delete() {

        try {
            // 内部编号
            String proj_nbxh = req.getFieldValue("proj_nbxh");

            if (proj_nbxh == null || proj_nbxh.equalsIgnoreCase("null")) {
                this.res.setType(0);
                this.res.setResult(false);
                this.res.setMessage(PropertyManager.getProperty("300"));
                return -1;
            }

            dc.executeUpdate("delete from ln_coopproj where proj_nbxh='" + proj_nbxh + "'");
            // 流水日志表
            task = MortUtil.getTaskObj(proj_nbxh, req.getFieldValue("busiNode"), CcbLoanConst.OPER_DEL);
            task.setOperid(this.getOperator().getOperid());
            task.setBankid(this.getOperator().getDeptid());
            if (task.insert() < 0) {
                this.res.setType(0);
                this.res.setResult(false);
                this.res.setMessage(PropertyManager.getProperty("300"));
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除合作项目出现错误！");
            logger.error(e.getMessage());
            this.res.setType(0);
            this.res.setResult(false);
            this.res.setMessage(PropertyManager.getProperty("300"));
            return -1;
        }

        this.res.setType(0);
        return 0;
    }

}