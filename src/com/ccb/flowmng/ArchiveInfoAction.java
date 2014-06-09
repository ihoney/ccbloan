package com.ccb.flowmng;

import com.ccb.dao.LNARCHIVEFLOW;
import com.ccb.dao.LNARCHIVEINFO;
import com.ccb.dao.LNTASKINFO;
import com.ccb.mortgage.MortUtil;
import com.ccb.util.CcbLoanConst;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import pub.platform.advance.utils.PropertyManager;
import pub.platform.db.RecordSet;
import pub.platform.form.control.Action;
import pub.platform.utils.BusinessDate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class ArchiveInfoAction extends Action {
    // 日志对象
    private static final Log logger = LogFactory.getLog(ArchiveInfoAction.class);
    // 贷款信息对象
    LNARCHIVEINFO loan = null;
    // 流水日志表
    LNTASKINFO task = null;

    public int add() {
        loan = new LNARCHIVEINFO();
        for (int i = 0; i < this.req.getRecorderCount(); i++) {
            try {
                // 初始化数据bean
                loan.initAll(i, req);
                loan.setOperdate(BusinessDate.getToday());
                loan.setOperid(this.getOperator().getOperid());
                loan.setRecversion(0);
                if (loan.insert() < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("LN_ARCHIVE_INFO添加失败，流水号重复或字段填写有误。");
                    return -1;
                }

                //档案流程表
                LNARCHIVEFLOW flow = new LNARCHIVEFLOW();
                flow.setPkid(UUID.randomUUID().toString());
                flow.setFlowsn(loan.getFlowsn());
                String  flowstat =  req.getFieldValue(i, "flowstat");
//                if (flowstat == null) {
//                    flowstat = req.getFieldValue(i, "flowstat2");
//                }
                flow.setFlowstat(flowstat);
                flow.setHanguptype("");
                flow.setHangupreason("");
                flow.setRemark(req.getFieldValue(i, "AF_REMARK"));
                flow.setOperdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                flow.setOpertime(new SimpleDateFormat("HH:mm:ss").format(new Date()));
                flow.setOperid(this.getOperator().getOperid());
                flow.setRecversion(0);
                if (flow.insert() < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("LN_ARCHIVE_FLOW添加失败。");
                    return -1;
                }


                // 流水日志表
                //task = MortUtil.getTaskObj(loan.getFlowsn(), req.getFieldValue(i, "busiNode"), CcbLoanConst.OPER_ADD);
                task = MortUtil.getTaskObj(loan.getFlowsn(), "Flow01:ADD", CcbLoanConst.OPER_ADD);
                task.setOperid(this.getOperator().getOperid());
                task.setBankid(this.getOperator().getDeptid());
                if (task.insert() < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("操作日志表处理错误.");
                    return -1;
                }
            } catch (Exception ex1) {
                logger.error(ex1.getMessage());
                this.res.setType(0);
                this.res.setResult(false);
                this.res.setMessage("处理异常.");
                return -1;
            }
        }
        this.res.setType(0);
        this.res.setResult(true);
        this.res.setMessage("处理成功.");
        return 0;
    }

    public int edit() {
        loan = new LNARCHIVEINFO();
        for (int i = 0; i < this.req.getRecorderCount(); i++) {
            try {
                // 初始化数据bean
                loan.initAll(i, req);

                // 操作时间
                loan.setOperdate(BusinessDate.getToday());
                // 用户id
                loan.setOperid(this.getOperator().getOperid());
                // 更新前版本号
                int iBeforeVersion = 0;
                if (req.getFieldValue(i, "recVersion") != null && !req.getFieldValue(i, "recVersion").equals("")) {
                    iBeforeVersion = Integer.parseInt(req.getFieldValue(i, "recVersion"));
                }
                int iAfterVersion = 0;
                RecordSet rs = dc.executeQuery("select recversion from ln_archive_info where flowsn='"
                        + req.getFieldValue(i, "flowsn") + "'");
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
                        loan.setRecversion(iBeforeVersion);
                    }
                }
                if (loan.updateByWhere(" where flowsn='" + req.getFieldValue(i, "flowsn") + "'") < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("保存ln_archive_info表出错。");
                    return -1;
                }

                //flow表
                LNARCHIVEFLOW flow = LNARCHIVEFLOW.findFirst( " where pkid='" + req.getFieldValue(i, "af_pkid") + "'");
                if (flow.getRecversion() != Integer.parseInt(req.getFieldValue(i, "af_recversion"))) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("LN_ARCHIVE_FLOW修改失败, 版本号检查错误。");
                    return -1;
                }
                String  flowstat =  req.getFieldValue(i, "flowstat");
//                if (flowstat == null) {
//                    flowstat = req.getFieldValue(i, "flowstat2");
//                }
                flow.setFlowstat(flowstat);

                flow.setRemark(req.getFieldValue(i, "af_remark"));
                flow.setOperdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                flow.setOpertime(new SimpleDateFormat("HH:mm:ss").format(new Date()));
                flow.setOperid(this.getOperator().getOperid());
                flow.setRecversion(flow.getRecversion() + 1);
                if (flow.updateByWhere(" where pkid='" + req.getFieldValue(i, "af_pkid") + "'") < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("LN_ARCHIVE_FLOW修改失败。");
                    return -1;
                }

                // 流水日志表
                task = MortUtil.getTaskObj(req.getFieldValue(i, "flowsn"), req.getFieldValue(i, "busiNode"),
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
                logger.error(ex1.getMessage());
                ex1.printStackTrace();
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
     * 删除一条记录
     */
    public int delete() {
        loan = new LNARCHIVEINFO();
        try {
            for (int i = 0; i < this.req.getRecorderCount(); i++) {
                loan.initAll(i, req);
                //判断流程信息
                RecordSet rs = dc.executeQuery("select count(*) as cnt from ln_archive_flow where flowsn='"
                        + req.getFieldValue(i, "flowsn") + "'");
                while (rs.next()) {
                    int cnt = rs.getInt("cnt");
                    if (cnt > 1) {
                        this.res.setType(0);
                        this.res.setResult(false);
                        this.res.setMessage("此笔贷款已进入下一流程，不能删除。");
                        return -1;
                    }
                }

                //删除基础信息信息和流程信息
                if (loan.deleteByWhere(" where flowsn='" + req.getFieldValue(i, "flowsn") + "' ") < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage(PropertyManager.getProperty("300"));
                    return -1;
                }

                LNARCHIVEFLOW flow = new LNARCHIVEFLOW();
                flow.setFlowsn(req.getFieldValue(i, "flowsn"));
                if (flow.deleteByWhere(" where flowsn='" + req.getFieldValue(i, "flowsn") + "' ") < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("删除贷款流程信息错误.");
                    return -1;
                }

                // 流水日志表
                task = MortUtil.getTaskObj(req.getFieldValue(i, "flowsn"), req.getFieldValue(i, "busiNode"),
                        CcbLoanConst.OPER_DEL);
                task.setOperid(this.getOperator().getOperid());
                task.setBankid(this.getOperator().getDeptid());
                if (task.insert() < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage(PropertyManager.getProperty("300"));
                    return -1;
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            this.res.setType(0);
            this.res.setResult(false);
            this.res.setMessage(PropertyManager.getProperty("300"));
            return -1;
        }

        this.res.setType(0);
        return 0;
    }

}
