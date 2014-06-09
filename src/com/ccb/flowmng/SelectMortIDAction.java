package com.ccb.flowmng;

import pub.platform.form.control.Action;

/**
 * 根据业务流水号查找档案卷宗资料数据
 */
public class SelectMortIDAction extends Action {
    public int doBusiness() {
        String SQLStr = "select mortid from ln_archive_info where (flowsn='" +
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
            String mortid = this.rs.getString(0);
            if (mortid == null) {
                mortid = "null";
            }
            this.res.setMessage(mortid);
        }
        return 0;
    }
}
