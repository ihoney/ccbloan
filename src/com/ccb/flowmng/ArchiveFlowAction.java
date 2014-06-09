package com.ccb.flowmng;

import com.ccb.dao.LNARCHIVEFLOW;
import com.ccb.dao.LNARCHIVEINFO;
import com.ccb.dao.LNTASKINFO;
import com.ccb.mortgage.MortUtil;
import com.ccb.util.CcbLoanConst;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import pub.platform.form.control.Action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class ArchiveFlowAction extends Action {
    // 日志对象
    private static final Log logger = LogFactory.getLog(ArchiveFlowAction.class);
    // 贷款信息对象
    LNARCHIVEFLOW flow = null;
    // 流水日志表
    LNTASKINFO task = null;

    public int add() {
        flow = new LNARCHIVEFLOW();
        for (int i = 0; i < this.req.getRecorderCount(); i++) {
            try {
                String[] flowsnArr = req.getFieldValue(i, "flowsn").split("\r\n");

                //检查是否存在主档信息
                for (String flowsn : flowsnArr) {
                    LNARCHIVEINFO lnarchiveinfo = LNARCHIVEINFO.findFirst(" where flowsn='" + flowsn +"'");
                    if (lnarchiveinfo == null) {
                        this.res.setType(0);
                        this.res.setResult(false);
                        this.res.setMessage("LN_ARCHIVE_FLOW添加失败, 此笔贷款资料未初始化，流水号：" + flowsn);
                        return -1;
                    }
                }

                String flowstat = req.getFieldValue(i, "flowstat");
                String remark = req.getFieldValue(i, "AF_REMARK");
                for (String flowsn : flowsnArr) {
                    //档案流程表
                    LNARCHIVEFLOW flow = new LNARCHIVEFLOW();
                    flow.setPkid(UUID.randomUUID().toString());
                    flow.setFlowsn(flowsn.trim());
                    flow.setFlowstat(flowstat);
                    flow.setHanguptype("");
                    flow.setHangupreason("");
                    flow.setRemark(remark);
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
                    task = MortUtil.getTaskObj(flow.getPkid(), "ArchiveFlowAction:ADD", CcbLoanConst.OPER_ADD);
                    task.setOperid(this.getOperator().getOperid());
                    task.setBankid(this.getOperator().getDeptid());
                    if (task.insert() < 0) {
                        this.res.setType(0);
                        this.res.setResult(false);
                        this.res.setMessage("操作日志表处理错误.");
                        return -1;
                    }
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
}
