package com.ccb.flowmng;

import pub.platform.form.control.Action;

/**
 * 根据业务流水号查找档案卷宗资料数据
 */
public class SelectLoanIDAction extends Action {
    public int doBusiness() {
        String SQLStr = "select loanid from ln_archive_info where (flowsn='" +
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
