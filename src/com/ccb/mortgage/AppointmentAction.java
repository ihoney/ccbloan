package com.ccb.mortgage;

/**
 *抵押预约  zr 20130606
 */

import com.ccb.dao.LNMORTAPPT;
import com.ccb.dao.LNMORTINFO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import pub.platform.advance.utils.PropertyManager;
import pub.platform.db.RecordSet;
import pub.platform.form.control.Action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class AppointmentAction extends Action {
    private static final Log logger = LogFactory.getLog(AppointmentAction.class);

    public int batchEdit() {

        LNMORTINFO mortInfo = new LNMORTINFO();
        for (int i = 0; i < this.req.getRecorderCount(); i++) {
            try {
                mortInfo.initAll(i, req);
                String appt_remark_old = "";
                if (req.getFieldValue(i, "appt_date") != null) {
                    mortInfo.setAppt_hdl_date(req.getFieldValue(i, "appt_date"));
                }
                if (req.getFieldValue(i, "appt_time") != null) {
                    mortInfo.setAppt_hdl_time(req.getFieldValue(i, "appt_time"));
                }
                if (req.getFieldValue(i, "apptstatus") != null) {
                    mortInfo.setApptstatus(req.getFieldValue(i, "apptstatus"));
                }
                if (req.getFieldValue(i, "appt_remark") != null) {
                    mortInfo.setAppt_remark(req.getFieldValue(i, "appt_remark"));
                }
                if (req.getFieldValue(i, "appt_biz_code") != null) {
                    mortInfo.setAppt_biz_code(req.getFieldValue(i, "appt_biz_code"));
                }
                if (req.getFieldValue(i, "appt_sendback_reason") != null) {
                    mortInfo.setAppt_sendback_reason(req.getFieldValue(i, "appt_sendback_reason"));
                }
                if (req.getFieldValue(i, "appt_sendback_remark") != null) {
                    mortInfo.setAppt_sendback_remark(req.getFieldValue(i, "appt_sendback_remark"));
                }


                // 更新前版本号
                int iBeforeVersion = Integer.parseInt(req.getFieldValue(i, "recVersion"));
                int iAfterVersion = 0;
                RecordSet rs = dc.executeQuery("select recversion, appt_remark from ln_mortinfo where mortid='"
                        + req.getFieldValue(i, "mortid") + "'");
                while (rs.next()) {
                    iAfterVersion = rs.getInt("recVersion");
                    appt_remark_old = rs.getString("appt_remark");
                    if (iBeforeVersion != iAfterVersion) {
                        this.res.setType(0);
                        this.res.setResult(false);
                        this.res.setMessage(PropertyManager.getProperty("301"));
                        return -1;
                    } else {
                        iBeforeVersion = iBeforeVersion + 1;
                        mortInfo.setRecversion(iBeforeVersion);
                    }
                }
                rs.close();

                String action = req.getFieldValue(i, "action_type");
                if (action.equals("apply_add")) {//预约申请
                    mortInfo.setAppt_oper_apply(this.getOperator().getOperid());
                    mortInfo.setAppt_date_apply(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                    mortInfo.setAppt_time_apply(new SimpleDateFormat("HHmmss").format(new Date()));
                    //清理其它信息
                    mortInfo.setAppt_date_confirm("0000-00-00");
                    mortInfo.setAppt_date_feedback("0000-00-00");
                    mortInfo.setAppt_time_feedback("000000");
                } else if (action.equals("apply_cancel")) {//预约取消
                    mortInfo.setAppt_oper_apply(this.getOperator().getOperid());
                    mortInfo.setAppt_date_apply("0000-00-00");
                    mortInfo.setAppt_time_apply("000000");
                    mortInfo.setAppt_remark(appt_remark_old + "   ===预约取消备注:" + mortInfo.getAppt_remark());
                } else if (action.equals("signin")) {//预约确认
                    mortInfo.setAppt_oper_confirm(this.getOperator().getOperid());
                    mortInfo.setAppt_date_confirm(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                    mortInfo.setAppt_time_confirm(new SimpleDateFormat("HHmmss").format(new Date()));
                } else if (action.equals("sendback")) {//预约退回
                    mortInfo.setAppt_oper_confirm(this.getOperator().getOperid());
                    mortInfo.setAppt_date_confirm(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                    mortInfo.setAppt_time_confirm(new SimpleDateFormat("HHmmss").format(new Date()));
                    mortInfo.setAppt_cnt_sendback(mortInfo.getAppt_cnt_sendback() + 1);
                } else if (action.equals("feedback")) {//处理反馈
                    mortInfo.setAppt_oper_feedback(this.getOperator().getOperid());
                    mortInfo.setAppt_date_feedback(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                    mortInfo.setAppt_time_feedback(new SimpleDateFormat("HHmmss").format(new Date()));
                }

                if (mortInfo.updateByWhere(" where mortid='" + req.getFieldValue(i, "mortid") + "'") < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage(PropertyManager.getProperty("300"));
                    return -1;
                }

                //处理预约明细记录表
                LNMORTAPPT lnmortappt = new LNMORTAPPT();

                //TODO 先处理旧记录

                lnmortappt.setPkid(UUID.randomUUID().toString());
                lnmortappt.setMortid(mortInfo.getMortid());
                lnmortappt.setLoanid(mortInfo.getLoanid());

/*
                if (action.startsWith("apply")) {//预约申请
                    lnmortappt.setTxncode("apply");
                } else if (action.startsWith("signin")) {//预约确认
                    lnmortappt.setTxncode("signin");
                } else if (action.startsWith("sendback")) {//预约退回
                    lnmortappt.setTxncode("signin");
                } else if (action.startsWith("feedback")) {//处理反馈
                    lnmortappt.setTxncode("feedback");
                }
*/
                lnmortappt.setTxncode(action);

                lnmortappt.setTxn_proc_id("AppointmentAction.batchEdit");
                lnmortappt.setBiz_code(mortInfo.getAppt_biz_code());
                lnmortappt.setBiz_desc("");
                lnmortappt.setReamrk(mortInfo.getAppt_remark());
                lnmortappt.setAppt_date(mortInfo.getAppt_hdl_date());
                lnmortappt.setAppt_time(mortInfo.getAppt_hdl_time());
                lnmortappt.setOperdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                lnmortappt.setOpertime(new SimpleDateFormat("HHmmss").format(new Date()));
                lnmortappt.setOperid(this.getOperator().getOperid());
                lnmortappt.setSendback_reason(mortInfo.getAppt_sendback_reason());
                lnmortappt.setSendback_remark(mortInfo.getAppt_sendback_remark());
                lnmortappt.setFeedback_result(mortInfo.getAppt_feedback_result());
                lnmortappt.setFeedback_remark(mortInfo.getAppt_feedback_remark());
                lnmortappt.setRecstatus("1");//有效

                lnmortappt.insert();

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
