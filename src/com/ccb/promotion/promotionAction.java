package com.ccb.promotion;

import com.ccb.dao.LNPROMMGRINFO;
import com.ccb.dao.LNPROMOTIONCUSTOMERS;
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

/**
 * Created by IntelliJ IDEA.
 * User: haiyuhuang
 * Date: 11-7-28
 * Time: 下午5:07
 * To change this template use File | Settings | File Templates.
 */
public class promotionAction extends Action {
    // 日志对象
    private static final Log logger = LogFactory.getLog(promotionAction.class);
    //营销客户表
    LNPROMOTIONCUSTOMERS lnpromcust = null;
    // 流水记录表
    LNTASKINFO task = null;
    //营销经理码表
    LNPROMMGRINFO lnprommgrinfo = null;

    public int add() {
        lnpromcust = new LNPROMOTIONCUSTOMERS();
        //推介客户顺序号
        String promotionCustNo = "";
        for (int i = 0; i < this.req.getRecorderCount(); i++) {
            try {
                lnpromcust.init(i, req);
                promotionCustNo = SeqUtil.getPromontioncustno();
                lnpromcust.setPromcust_no(promotionCustNo);
                //审核状态初始为 0
                lnpromcust.setStatus(0);
                //操作时间 到秒
                lnpromcust.setOperdate(BusinessDate.getTodaytime());
                //操作人员
                lnpromcust.setOperid2(this.getOperator().getOperid());
                //经办行
                lnpromcust.setBankid(this.getDept().getDeptid());

                if (lnpromcust.insert() < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage(PropertyManager.getProperty("300"));
                    return -1;
                }
                //流水日志
                task = MortUtil.getTaskObj(req.getFieldValue(i, "promcust_no"), req.getFieldValue(i, "busiNode"), CcbLoanConst.OPER_ADD);
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

    public int edit() {
        lnpromcust = new LNPROMOTIONCUSTOMERS();
        for (int i = 0; i < this.req.getRecorderCount(); i++) {
            try {
                lnpromcust.init(i, req);
                //操作时间 到秒
                lnpromcust.setOperdate(BusinessDate.getTodaytime());
                //操作人员
                lnpromcust.setOperid2(this.getOperator().getOperid());
                //营销中心
                lnpromcust.setCust_bankid(this.getDept().getDeptid());

                // 更新前版本号
                int iBeforeVersion = 0;
                if (req.getFieldValue(i, "recVersion") != null && !req.getFieldValue(i, "recVersion").equals("")) {
                    iBeforeVersion = Integer.parseInt(req.getFieldValue(i, "recVersion"));
                }
                int iAfterVersion = 0;
                RecordSet rs = dc.executeQuery("select recversion from ln_promotioncustomers where PROMCUST_NO='"
                        + req.getFieldValue(i, "PROMCUST_NO") + "'");
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
                        lnpromcust.setRecversion(iBeforeVersion);
                    }
                }
                if (rs != null) {
                    rs.close();
                }
                //状态为审核通过时 将营销经理信息插入营销经理码表
                if (lnpromcust.getStatus() == 2) {
                    LNPROMOTIONCUSTOMERS templnpromcust = LNPROMOTIONCUSTOMERS.findFirst("where PROMCUST_NO='" + req.getFieldValue(i, "PROMCUST_NO") + "'");
                    //验证营销经理码表是否已存在该营销经理名
                    boolean promgrIsExist = dc.isExist("select 1 from ln_prommgrinfo t where t.prommgr_name='" + templnpromcust.getPrommgr_name() + "'" +
                            " and t.deptid='" + templnpromcust.getBankid() + "'");
                    if (!promgrIsExist) {
                        lnprommgrinfo = new LNPROMMGRINFO();
                        String tempprommgrid = SeqUtil.getPrommgrid();
                        lnprommgrinfo.setDeptid(templnpromcust.getBankid());
                        lnprommgrinfo.setPrommgr_name(templnpromcust.getPrommgr_name());
                        lnprommgrinfo.setPrommgr_id(tempprommgrid);
                        //将营销经理id信息更新至营销客户表
                        lnpromcust.setPrommgr_id(tempprommgrid);
                        if (lnprommgrinfo.insert() < 0) {
                            this.res.setType(0);
                            this.res.setResult(false);
                            this.res.setMessage(PropertyManager.getProperty("300"));
                            return -1;
                        }
                    }

                }
                if (lnpromcust.updateByWhere(" where PROMCUST_NO='" + req.getFieldValue(i, "PROMCUST_NO") + "'") < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage(PropertyManager.getProperty("300"));
                    return -1;
                }

                //流水日志
                task = MortUtil.getTaskObj(req.getFieldValue(i, "promcust_no"), req.getFieldValue(i, "busiNode"), CcbLoanConst.OPER_EDIT);
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
}
