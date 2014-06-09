package com.ccb.flowmng;

import pub.platform.form.control.Action;

/**
 * Created with IntelliJ IDEA.
 * User: vincent
 * Date: 13-4-8
 * Time: 下午5:44
 * To change this template use File | Settings | File Templates.
 */
public class SelectLoanIDFlowsnAction extends Action {
    public int doBusiness() {
        String SQLStr = "select loanid from ln_loanapply where (loanid='" +
                this.req.getFieldValue("flowsn") + "')";

        this.rs = this.dc.executeQuery(SQLStr);

        if (this.rs.getRecordCount() == 0) {
            this.res.setType(0);
            this.res.setResult(false);
            this.res.setMessage("无此流水号明细记录。");
            return -1;
        } else {
            this.rs.next();
            this.res.setType(0);
            this.res.setResult(true);
            this.res.setMessage(this.rs.getString(0));
        }
        return 0;
    }
}
