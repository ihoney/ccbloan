package com.ccb.dao;
import java.util.*;
import pub.platform.db.*;
import pub.platform.utils.*;
import pub.platform.db.AbstractBasicBean;
public class LNPROMOTIONCUSTOMERS extends AbstractBasicBean implements Cloneable {
     public static List find(String sSqlWhere) {           return new LNPROMOTIONCUSTOMERS().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere) {           return new LNPROMOTIONCUSTOMERS().findAndLockByWhere(sSqlWhere);      }       public static LNPROMOTIONCUSTOMERS findFirst(String sSqlWhere) {           return (LNPROMOTIONCUSTOMERS)new LNPROMOTIONCUSTOMERS().findFirstByWhere(sSqlWhere);      }       public static LNPROMOTIONCUSTOMERS findFirstAndLock(String sSqlWhere) {           return (LNPROMOTIONCUSTOMERS)new LNPROMOTIONCUSTOMERS().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) {           return new LNPROMOTIONCUSTOMERS().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease) {           LNPROMOTIONCUSTOMERS bean = new LNPROMOTIONCUSTOMERS();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) {           LNPROMOTIONCUSTOMERS bean = new LNPROMOTIONCUSTOMERS();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static LNPROMOTIONCUSTOMERS findFirst(String sSqlWhere,boolean isAutoRelease) {           LNPROMOTIONCUSTOMERS bean = new LNPROMOTIONCUSTOMERS();           bean.setAutoRelease(isAutoRelease);           return (LNPROMOTIONCUSTOMERS)bean.findFirstByWhere(sSqlWhere);      }       public static LNPROMOTIONCUSTOMERS findFirstAndLock(String sSqlWhere,boolean isAutoRelease) {           LNPROMOTIONCUSTOMERS bean = new LNPROMOTIONCUSTOMERS();           bean.setAutoRelease(isAutoRelease);           return (LNPROMOTIONCUSTOMERS)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease) {           LNPROMOTIONCUSTOMERS bean = new LNPROMOTIONCUSTOMERS();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      }      public static List findByRow(String sSqlWhere,int row) {           return new LNPROMOTIONCUSTOMERS().findByWhereByRow(sSqlWhere,row);      } String cust_name;
String cust_id;
String ln_typ;
String prommgr_id;
double rt_orig_loan_amt;
String custmgr_id;
int status;
String promcust_no;
String operid2;
String operdate;
int recversion;
String bankid;
String cust_phone;
int rt_term_incr;
String cust_bankid;
String remark;
String loanid;
String prommgr_name;
public static final String TABLENAME ="ln_promotioncustomers";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
public void addObject(List list,RecordSet rs) {
LNPROMOTIONCUSTOMERS abb = new LNPROMOTIONCUSTOMERS();
abb.cust_name=rs.getString("cust_name");abb.setKeyValue("CUST_NAME",""+abb.getCust_name());
abb.cust_id=rs.getString("cust_id");abb.setKeyValue("CUST_ID",""+abb.getCust_id());
abb.ln_typ=rs.getString("ln_typ");abb.setKeyValue("LN_TYP",""+abb.getLn_typ());
abb.prommgr_id=rs.getString("prommgr_id");abb.setKeyValue("PROMMGR_ID",""+abb.getPrommgr_id());
abb.rt_orig_loan_amt=rs.getDouble("rt_orig_loan_amt");abb.setKeyValue("RT_ORIG_LOAN_AMT",""+abb.getRt_orig_loan_amt());
abb.custmgr_id=rs.getString("custmgr_id");abb.setKeyValue("CUSTMGR_ID",""+abb.getCustmgr_id());
abb.status=rs.getInt("status");abb.setKeyValue("STATUS",""+abb.getStatus());
abb.promcust_no=rs.getString("promcust_no");abb.setKeyValue("PROMCUST_NO",""+abb.getPromcust_no());
abb.operid2=rs.getString("operid2");abb.setKeyValue("OPERID2",""+abb.getOperid2());
abb.operdate=rs.getString("operdate");abb.setKeyValue("OPERDATE",""+abb.getOperdate());
abb.recversion=rs.getInt("recversion");abb.setKeyValue("RECVERSION",""+abb.getRecversion());
abb.bankid=rs.getString("bankid");abb.setKeyValue("BANKID",""+abb.getBankid());
abb.cust_phone=rs.getString("cust_phone");abb.setKeyValue("CUST_PHONE",""+abb.getCust_phone());
abb.rt_term_incr=rs.getInt("rt_term_incr");abb.setKeyValue("RT_TERM_INCR",""+abb.getRt_term_incr());
abb.cust_bankid=rs.getString("cust_bankid");abb.setKeyValue("CUST_BANKID",""+abb.getCust_bankid());
abb.remark=rs.getString("remark");abb.setKeyValue("REMARK",""+abb.getRemark());
abb.loanid=rs.getString("loanid");abb.setKeyValue("LOANID",""+abb.getLoanid());
abb.prommgr_name=rs.getString("prommgr_name");abb.setKeyValue("PROMMGR_NAME",""+abb.getPrommgr_name());
list.add(abb);
abb.operate_mode = "edit";
}public String getCust_name() { if ( this.cust_name == null ) return ""; return this.cust_name;}
public String getCust_id() { if ( this.cust_id == null ) return ""; return this.cust_id;}
public String getLn_typ() { if ( this.ln_typ == null ) return ""; return this.ln_typ;}
public String getPrommgr_id() { if ( this.prommgr_id == null ) return ""; return this.prommgr_id;}
public double getRt_orig_loan_amt() { return this.rt_orig_loan_amt;}
public String getCustmgr_id() { if ( this.custmgr_id == null ) return ""; return this.custmgr_id;}
public int getStatus() { return this.status;}
public String getPromcust_no() { if ( this.promcust_no == null ) return ""; return this.promcust_no;}
public String getOperid2() { if ( this.operid2 == null ) return ""; return this.operid2;}
public String getOperdate() { if ( this.operdate == null ) return ""; return this.operdate;}
public int getRecversion() { return this.recversion;}
public String getBankid() { if ( this.bankid == null ) return ""; return this.bankid;}
public String getCust_phone() { if ( this.cust_phone == null ) return ""; return this.cust_phone;}
public int getRt_term_incr() { return this.rt_term_incr;}
public String getCust_bankid() { if ( this.cust_bankid == null ) return ""; return this.cust_bankid;}
public String getRemark() { if ( this.remark == null ) return ""; return this.remark;}
public String getLoanid() { if ( this.loanid == null ) return ""; return this.loanid;}
public String getPrommgr_name() { if ( this.prommgr_name == null ) return ""; return this.prommgr_name;}
public void setCust_name(String cust_name) { sqlMaker.setField("cust_name",cust_name,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCust_name().equals(cust_name)) cf.add("cust_name",this.cust_name,cust_name); } this.cust_name=cust_name;}
public void setCust_id(String cust_id) { sqlMaker.setField("cust_id",cust_id,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCust_id().equals(cust_id)) cf.add("cust_id",this.cust_id,cust_id); } this.cust_id=cust_id;}
public void setLn_typ(String ln_typ) { sqlMaker.setField("ln_typ",ln_typ,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLn_typ().equals(ln_typ)) cf.add("ln_typ",this.ln_typ,ln_typ); } this.ln_typ=ln_typ;}
public void setPrommgr_id(String prommgr_id) { sqlMaker.setField("prommgr_id",prommgr_id,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getPrommgr_id().equals(prommgr_id)) cf.add("prommgr_id",this.prommgr_id,prommgr_id); } this.prommgr_id=prommgr_id;}
public void setRt_orig_loan_amt(double rt_orig_loan_amt) { sqlMaker.setField("rt_orig_loan_amt",""+rt_orig_loan_amt,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRt_orig_loan_amt()!=rt_orig_loan_amt) cf.add("rt_orig_loan_amt",this.rt_orig_loan_amt+"",rt_orig_loan_amt+""); } this.rt_orig_loan_amt=rt_orig_loan_amt;}
public void setCustmgr_id(String custmgr_id) { sqlMaker.setField("custmgr_id",custmgr_id,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCustmgr_id().equals(custmgr_id)) cf.add("custmgr_id",this.custmgr_id,custmgr_id); } this.custmgr_id=custmgr_id;}
public void setStatus(int status) { sqlMaker.setField("status",""+status,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getStatus()!=status) cf.add("status",this.status+"",status+""); } this.status=status;}
public void setPromcust_no(String promcust_no) { sqlMaker.setField("promcust_no",promcust_no,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getPromcust_no().equals(promcust_no)) cf.add("promcust_no",this.promcust_no,promcust_no); } this.promcust_no=promcust_no;}
public void setOperid2(String operid2) { sqlMaker.setField("operid2",operid2,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getOperid2().equals(operid2)) cf.add("operid2",this.operid2,operid2); } this.operid2=operid2;}
public void setOperdate(String operdate) { sqlMaker.setField("operdate",operdate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getOperdate().equals(operdate)) cf.add("operdate",this.operdate,operdate); } this.operdate=operdate;}
public void setRecversion(int recversion) { sqlMaker.setField("recversion",""+recversion,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRecversion()!=recversion) cf.add("recversion",this.recversion+"",recversion+""); } this.recversion=recversion;}
public void setBankid(String bankid) { sqlMaker.setField("bankid",bankid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getBankid().equals(bankid)) cf.add("bankid",this.bankid,bankid); } this.bankid=bankid;}
public void setCust_phone(String cust_phone) { sqlMaker.setField("cust_phone",cust_phone,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCust_phone().equals(cust_phone)) cf.add("cust_phone",this.cust_phone,cust_phone); } this.cust_phone=cust_phone;}
public void setRt_term_incr(int rt_term_incr) { sqlMaker.setField("rt_term_incr",""+rt_term_incr,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRt_term_incr()!=rt_term_incr) cf.add("rt_term_incr",this.rt_term_incr+"",rt_term_incr+""); } this.rt_term_incr=rt_term_incr;}
public void setCust_bankid(String cust_bankid) { sqlMaker.setField("cust_bankid",cust_bankid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCust_bankid().equals(cust_bankid)) cf.add("cust_bankid",this.cust_bankid,cust_bankid); } this.cust_bankid=cust_bankid;}
public void setRemark(String remark) { sqlMaker.setField("remark",remark,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRemark().equals(remark)) cf.add("remark",this.remark,remark); } this.remark=remark;}
public void setLoanid(String loanid) { sqlMaker.setField("loanid",loanid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLoanid().equals(loanid)) cf.add("loanid",this.loanid,loanid); } this.loanid=loanid;}
public void setPrommgr_name(String prommgr_name) { sqlMaker.setField("prommgr_name",prommgr_name,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getPrommgr_name().equals(prommgr_name)) cf.add("prommgr_name",this.prommgr_name,prommgr_name); } this.prommgr_name=prommgr_name;}
public void init(int i,ActionRequest actionRequest) throws Exception { if ( actionRequest.getFieldValue(i,"cust_name") !=null ) {this.setCust_name(actionRequest.getFieldValue(i,"cust_name"));}
if ( actionRequest.getFieldValue(i,"cust_id") !=null ) {this.setCust_id(actionRequest.getFieldValue(i,"cust_id"));}
if ( actionRequest.getFieldValue(i,"ln_typ") !=null ) {this.setLn_typ(actionRequest.getFieldValue(i,"ln_typ"));}
if ( actionRequest.getFieldValue(i,"prommgr_id") !=null ) {this.setPrommgr_id(actionRequest.getFieldValue(i,"prommgr_id"));}
if ( actionRequest.getFieldValue(i,"rt_orig_loan_amt") !=null && actionRequest.getFieldValue(i,"rt_orig_loan_amt").trim().length() > 0 ) {this.setRt_orig_loan_amt(Double.parseDouble(actionRequest.getFieldValue(i,"rt_orig_loan_amt")));}
if ( actionRequest.getFieldValue(i,"custmgr_id") !=null ) {this.setCustmgr_id(actionRequest.getFieldValue(i,"custmgr_id"));}
if ( actionRequest.getFieldValue(i,"status") !=null && actionRequest.getFieldValue(i,"status").trim().length() > 0 ) {this.setStatus(Integer.parseInt(actionRequest.getFieldValue(i,"status")));}
if ( actionRequest.getFieldValue(i,"promcust_no") !=null ) {this.setPromcust_no(actionRequest.getFieldValue(i,"promcust_no"));}
if ( actionRequest.getFieldValue(i,"operid2") !=null ) {this.setOperid2(actionRequest.getFieldValue(i,"operid2"));}
if ( actionRequest.getFieldValue(i,"operdate") !=null ) {this.setOperdate(actionRequest.getFieldValue(i,"operdate"));}
if ( actionRequest.getFieldValue(i,"recversion") !=null && actionRequest.getFieldValue(i,"recversion").trim().length() > 0 ) {this.setRecversion(Integer.parseInt(actionRequest.getFieldValue(i,"recversion")));}
if ( actionRequest.getFieldValue(i,"bankid") !=null ) {this.setBankid(actionRequest.getFieldValue(i,"bankid"));}
if ( actionRequest.getFieldValue(i,"cust_phone") !=null ) {this.setCust_phone(actionRequest.getFieldValue(i,"cust_phone"));}
if ( actionRequest.getFieldValue(i,"rt_term_incr") !=null && actionRequest.getFieldValue(i,"rt_term_incr").trim().length() > 0 ) {this.setRt_term_incr(Integer.parseInt(actionRequest.getFieldValue(i,"rt_term_incr")));}
if ( actionRequest.getFieldValue(i,"cust_bankid") !=null ) {this.setCust_bankid(actionRequest.getFieldValue(i,"cust_bankid"));}
if ( actionRequest.getFieldValue(i,"remark") !=null ) {this.setRemark(actionRequest.getFieldValue(i,"remark"));}
if ( actionRequest.getFieldValue(i,"loanid") !=null ) {this.setLoanid(actionRequest.getFieldValue(i,"loanid"));}
if ( actionRequest.getFieldValue(i,"prommgr_name") !=null ) {this.setPrommgr_name(actionRequest.getFieldValue(i,"prommgr_name"));}
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { LNPROMOTIONCUSTOMERS obj = (LNPROMOTIONCUSTOMERS)super.clone();obj.setCust_name(obj.cust_name);
obj.setCust_id(obj.cust_id);
obj.setLn_typ(obj.ln_typ);
obj.setPrommgr_id(obj.prommgr_id);
obj.setRt_orig_loan_amt(obj.rt_orig_loan_amt);
obj.setCustmgr_id(obj.custmgr_id);
obj.setStatus(obj.status);
obj.setPromcust_no(obj.promcust_no);
obj.setOperid2(obj.operid2);
obj.setOperdate(obj.operdate);
obj.setRecversion(obj.recversion);
obj.setBankid(obj.bankid);
obj.setCust_phone(obj.cust_phone);
obj.setRt_term_incr(obj.rt_term_incr);
obj.setCust_bankid(obj.cust_bankid);
obj.setRemark(obj.remark);
obj.setLoanid(obj.loanid);
obj.setPrommgr_name(obj.prommgr_name);
return obj;}}