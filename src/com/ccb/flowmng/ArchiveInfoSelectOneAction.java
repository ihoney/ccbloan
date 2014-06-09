package com.ccb.flowmng;

import pub.platform.form.control.Action;

/**
 * 根据业务流水号查找档案卷宗资料数据
 */
public class ArchiveInfoSelectOneAction extends Action {
    public int doBusiness() {
        String SQLStr = "select  flowsn,cust_name,rt_orig_loan_amt,rt_term_incr,bankid,cust_bankid,custmgr_id,realcustmgr_id from ln_archive_info where (flowsn='" +
                this.req.getFieldValue("flowsn") + "')";

        this.rs = this.dc.executeQuery(SQLStr);

        this.res.setFieldName("FLOWSN;CUST_NAME;RT_ORIG_LOAN_AMT;RT_TERM_INCR;BANKID;CUST_BANKID;CUSTMGR_ID;REALCUSTMGR_ID");
        this.res.setFieldType("text;text;text;text;text;text;text;text");
        this.res.setEnumType("0;0;0;0;0;0;0;0");
        //this.res.setType(1);

        if (this.rs.getRecordCount() == 0) {
            this.res.setType(0);
            this.res.setResult(false);
            this.res.setMessage("无此流水号明细记录。");
            return -1;
        } else {
            this.res.setType(1);
            this.res.setResult(true);
            this.res.setRecordset(this.rs);
        }
        return 0;
    }
}
