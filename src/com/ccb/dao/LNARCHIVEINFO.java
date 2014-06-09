package com.ccb.dao;
import java.util.*;
import pub.platform.db.*;
import pub.platform.utils.*;
import pub.platform.db.AbstractBasicBean;
public class LNARCHIVEINFO extends AbstractBasicBean implements Cloneable {
     public static List find(String sSqlWhere) {           return new LNARCHIVEINFO().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere) {           return new LNARCHIVEINFO().findAndLockByWhere(sSqlWhere);      }       public static LNARCHIVEINFO findFirst(String sSqlWhere) {           return (LNARCHIVEINFO)new LNARCHIVEINFO().findFirstByWhere(sSqlWhere);      }       public static LNARCHIVEINFO findFirstAndLock(String sSqlWhere) {           return (LNARCHIVEINFO)new LNARCHIVEINFO().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) {           return new LNARCHIVEINFO().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease) {           LNARCHIVEINFO bean = new LNARCHIVEINFO();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) {           LNARCHIVEINFO bean = new LNARCHIVEINFO();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static LNARCHIVEINFO findFirst(String sSqlWhere,boolean isAutoRelease) {           LNARCHIVEINFO bean = new LNARCHIVEINFO();           bean.setAutoRelease(isAutoRelease);           return (LNARCHIVEINFO)bean.findFirstByWhere(sSqlWhere);      }       public static LNARCHIVEINFO findFirstAndLock(String sSqlWhere,boolean isAutoRelease) {           LNARCHIVEINFO bean = new LNARCHIVEINFO();           bean.setAutoRelease(isAutoRelease);           return (LNARCHIVEINFO)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease) {           LNARCHIVEINFO bean = new LNARCHIVEINFO();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      }      public static List findByRow(String sSqlWhere,int row) {           return new LNARCHIVEINFO().findByWhereByRow(sSqlWhere,row);      } String flowsn;
String loanid;
String mortid;
String curr_cd;
String ln_prod_cod;
String ln_typ;
String guaranty_type;
String aply_dt;
double rt_orig_loan_amt;
int rt_term_incr;
String pay_type;
String proj_no;
String cust_name;
String custmgr_id;
String realcustmgr_id;
String operid;
String operdate;
int recversion;
String bankid;
String cust_bankid;
String cust_tele;
String cust_mobile;
String coop_name;
String coop_tele;
String coop_mobile;
String sale_id;
String sale_name;
String sale_tele;
String survey_id;
String survey_name;
String survey_tele;
String info_name;
String info_num;
String info_remark;
public static final String TABLENAME ="ln_archive_info";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
public void addObject(List list,RecordSet rs) {
LNARCHIVEINFO abb = new LNARCHIVEINFO();
abb.flowsn=rs.getString("flowsn");abb.setKeyValue("FLOWSN",""+abb.getFlowsn());
abb.loanid=rs.getString("loanid");abb.setKeyValue("LOANID",""+abb.getLoanid());
abb.mortid=rs.getString("mortid");abb.setKeyValue("MORTID",""+abb.getMortid());
abb.curr_cd=rs.getString("curr_cd");abb.setKeyValue("CURR_CD",""+abb.getCurr_cd());
abb.ln_prod_cod=rs.getString("ln_prod_cod");abb.setKeyValue("LN_PROD_COD",""+abb.getLn_prod_cod());
abb.ln_typ=rs.getString("ln_typ");abb.setKeyValue("LN_TYP",""+abb.getLn_typ());
abb.guaranty_type=rs.getString("guaranty_type");abb.setKeyValue("GUARANTY_TYPE",""+abb.getGuaranty_type());
abb.aply_dt=rs.getString("aply_dt");abb.setKeyValue("APLY_DT",""+abb.getAply_dt());
abb.rt_orig_loan_amt=rs.getDouble("rt_orig_loan_amt");abb.setKeyValue("RT_ORIG_LOAN_AMT",""+abb.getRt_orig_loan_amt());
abb.rt_term_incr=rs.getInt("rt_term_incr");abb.setKeyValue("RT_TERM_INCR",""+abb.getRt_term_incr());
abb.pay_type=rs.getString("pay_type");abb.setKeyValue("PAY_TYPE",""+abb.getPay_type());
abb.proj_no=rs.getString("proj_no");abb.setKeyValue("PROJ_NO",""+abb.getProj_no());
abb.cust_name=rs.getString("cust_name");abb.setKeyValue("CUST_NAME",""+abb.getCust_name());
abb.custmgr_id=rs.getString("custmgr_id");abb.setKeyValue("CUSTMGR_ID",""+abb.getCustmgr_id());
abb.realcustmgr_id=rs.getString("realcustmgr_id");abb.setKeyValue("REALCUSTMGR_ID",""+abb.getRealcustmgr_id());
abb.operid=rs.getString("operid");abb.setKeyValue("OPERID",""+abb.getOperid());
abb.operdate=rs.getString("operdate");abb.setKeyValue("OPERDATE",""+abb.getOperdate());
abb.recversion=rs.getInt("recversion");abb.setKeyValue("RECVERSION",""+abb.getRecversion());
abb.bankid=rs.getString("bankid");abb.setKeyValue("BANKID",""+abb.getBankid());
abb.cust_bankid=rs.getString("cust_bankid");abb.setKeyValue("CUST_BANKID",""+abb.getCust_bankid());
abb.cust_tele=rs.getString("cust_tele");abb.setKeyValue("CUST_TELE",""+abb.getCust_tele());
abb.cust_mobile=rs.getString("cust_mobile");abb.setKeyValue("CUST_MOBILE",""+abb.getCust_mobile());
abb.coop_name=rs.getString("coop_name");abb.setKeyValue("COOP_NAME",""+abb.getCoop_name());
abb.coop_tele=rs.getString("coop_tele");abb.setKeyValue("COOP_TELE",""+abb.getCoop_tele());
abb.coop_mobile=rs.getString("coop_mobile");abb.setKeyValue("COOP_MOBILE",""+abb.getCoop_mobile());
abb.sale_id=rs.getString("sale_id");abb.setKeyValue("SALE_ID",""+abb.getSale_id());
abb.sale_name=rs.getString("sale_name");abb.setKeyValue("SALE_NAME",""+abb.getSale_name());
abb.sale_tele=rs.getString("sale_tele");abb.setKeyValue("SALE_TELE",""+abb.getSale_tele());
abb.survey_id=rs.getString("survey_id");abb.setKeyValue("SURVEY_ID",""+abb.getSurvey_id());
abb.survey_name=rs.getString("survey_name");abb.setKeyValue("SURVEY_NAME",""+abb.getSurvey_name());
abb.survey_tele=rs.getString("survey_tele");abb.setKeyValue("SURVEY_TELE",""+abb.getSurvey_tele());
abb.info_name=rs.getString("info_name");abb.setKeyValue("INFO_NAME",""+abb.getInfo_name());
abb.info_num=rs.getString("info_num");abb.setKeyValue("INFO_NUM",""+abb.getInfo_num());
abb.info_remark=rs.getString("info_remark");abb.setKeyValue("INFO_REMARK",""+abb.getInfo_remark());
list.add(abb);
abb.operate_mode = "edit";
}public String getFlowsn() { if ( this.flowsn == null ) return ""; return this.flowsn;}
public String getLoanid() { if ( this.loanid == null ) return ""; return this.loanid;}
public String getMortid() { if ( this.mortid == null ) return ""; return this.mortid;}
public String getCurr_cd() { if ( this.curr_cd == null ) return ""; return this.curr_cd;}
public String getLn_prod_cod() { if ( this.ln_prod_cod == null ) return ""; return this.ln_prod_cod;}
public String getLn_typ() { if ( this.ln_typ == null ) return ""; return this.ln_typ;}
public String getGuaranty_type() { if ( this.guaranty_type == null ) return ""; return this.guaranty_type;}
public String getAply_dt() { if ( this.aply_dt == null ) return ""; return this.aply_dt;}
public double getRt_orig_loan_amt() { return this.rt_orig_loan_amt;}
public int getRt_term_incr() { return this.rt_term_incr;}
public String getPay_type() { if ( this.pay_type == null ) return ""; return this.pay_type;}
public String getProj_no() { if ( this.proj_no == null ) return ""; return this.proj_no;}
public String getCust_name() { if ( this.cust_name == null ) return ""; return this.cust_name;}
public String getCustmgr_id() { if ( this.custmgr_id == null ) return ""; return this.custmgr_id;}
public String getRealcustmgr_id() { if ( this.realcustmgr_id == null ) return ""; return this.realcustmgr_id;}
public String getOperid() { if ( this.operid == null ) return ""; return this.operid;}
public String getOperdate() { if ( this.operdate == null ) return ""; return this.operdate;}
public int getRecversion() { return this.recversion;}
public String getBankid() { if ( this.bankid == null ) return ""; return this.bankid;}
public String getCust_bankid() { if ( this.cust_bankid == null ) return ""; return this.cust_bankid;}
public String getCust_tele() { if ( this.cust_tele == null ) return ""; return this.cust_tele;}
public String getCust_mobile() { if ( this.cust_mobile == null ) return ""; return this.cust_mobile;}
public String getCoop_name() { if ( this.coop_name == null ) return ""; return this.coop_name;}
public String getCoop_tele() { if ( this.coop_tele == null ) return ""; return this.coop_tele;}
public String getCoop_mobile() { if ( this.coop_mobile == null ) return ""; return this.coop_mobile;}
public String getSale_id() { if ( this.sale_id == null ) return ""; return this.sale_id;}
public String getSale_name() { if ( this.sale_name == null ) return ""; return this.sale_name;}
public String getSale_tele() { if ( this.sale_tele == null ) return ""; return this.sale_tele;}
public String getSurvey_id() { if ( this.survey_id == null ) return ""; return this.survey_id;}
public String getSurvey_name() { if ( this.survey_name == null ) return ""; return this.survey_name;}
public String getSurvey_tele() { if ( this.survey_tele == null ) return ""; return this.survey_tele;}
public String getInfo_name() { if ( this.info_name == null ) return ""; return this.info_name;}
public String getInfo_num() { if ( this.info_num == null ) return ""; return this.info_num;}
public String getInfo_remark() { if ( this.info_remark == null ) return ""; return this.info_remark;}
public void setFlowsn(String flowsn) { sqlMaker.setField("flowsn",flowsn,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getFlowsn().equals(flowsn)) cf.add("flowsn",this.flowsn,flowsn); } this.flowsn=flowsn;}
public void setLoanid(String loanid) { sqlMaker.setField("loanid",loanid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLoanid().equals(loanid)) cf.add("loanid",this.loanid,loanid); } this.loanid=loanid;}
public void setMortid(String mortid) { sqlMaker.setField("mortid",mortid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getMortid().equals(mortid)) cf.add("mortid",this.mortid,mortid); } this.mortid=mortid;}
public void setCurr_cd(String curr_cd) { sqlMaker.setField("curr_cd",curr_cd,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCurr_cd().equals(curr_cd)) cf.add("curr_cd",this.curr_cd,curr_cd); } this.curr_cd=curr_cd;}
public void setLn_prod_cod(String ln_prod_cod) { sqlMaker.setField("ln_prod_cod",ln_prod_cod,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLn_prod_cod().equals(ln_prod_cod)) cf.add("ln_prod_cod",this.ln_prod_cod,ln_prod_cod); } this.ln_prod_cod=ln_prod_cod;}
public void setLn_typ(String ln_typ) { sqlMaker.setField("ln_typ",ln_typ,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLn_typ().equals(ln_typ)) cf.add("ln_typ",this.ln_typ,ln_typ); } this.ln_typ=ln_typ;}
public void setGuaranty_type(String guaranty_type) { sqlMaker.setField("guaranty_type",guaranty_type,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getGuaranty_type().equals(guaranty_type)) cf.add("guaranty_type",this.guaranty_type,guaranty_type); } this.guaranty_type=guaranty_type;}
public void setAply_dt(String aply_dt) { sqlMaker.setField("aply_dt",aply_dt,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAply_dt().equals(aply_dt)) cf.add("aply_dt",this.aply_dt,aply_dt); } this.aply_dt=aply_dt;}
public void setRt_orig_loan_amt(double rt_orig_loan_amt) { sqlMaker.setField("rt_orig_loan_amt",""+rt_orig_loan_amt,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRt_orig_loan_amt()!=rt_orig_loan_amt) cf.add("rt_orig_loan_amt",this.rt_orig_loan_amt+"",rt_orig_loan_amt+""); } this.rt_orig_loan_amt=rt_orig_loan_amt;}
public void setRt_term_incr(int rt_term_incr) { sqlMaker.setField("rt_term_incr",""+rt_term_incr,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRt_term_incr()!=rt_term_incr) cf.add("rt_term_incr",this.rt_term_incr+"",rt_term_incr+""); } this.rt_term_incr=rt_term_incr;}
public void setPay_type(String pay_type) { sqlMaker.setField("pay_type",pay_type,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getPay_type().equals(pay_type)) cf.add("pay_type",this.pay_type,pay_type); } this.pay_type=pay_type;}
public void setProj_no(String proj_no) { sqlMaker.setField("proj_no",proj_no,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getProj_no().equals(proj_no)) cf.add("proj_no",this.proj_no,proj_no); } this.proj_no=proj_no;}
public void setCust_name(String cust_name) { sqlMaker.setField("cust_name",cust_name,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCust_name().equals(cust_name)) cf.add("cust_name",this.cust_name,cust_name); } this.cust_name=cust_name;}
public void setCustmgr_id(String custmgr_id) { sqlMaker.setField("custmgr_id",custmgr_id,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCustmgr_id().equals(custmgr_id)) cf.add("custmgr_id",this.custmgr_id,custmgr_id); } this.custmgr_id=custmgr_id;}
public void setRealcustmgr_id(String realcustmgr_id) { sqlMaker.setField("realcustmgr_id",realcustmgr_id,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRealcustmgr_id().equals(realcustmgr_id)) cf.add("realcustmgr_id",this.realcustmgr_id,realcustmgr_id); } this.realcustmgr_id=realcustmgr_id;}
public void setOperid(String operid) { sqlMaker.setField("operid",operid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getOperid().equals(operid)) cf.add("operid",this.operid,operid); } this.operid=operid;}
public void setOperdate(String operdate) { sqlMaker.setField("operdate",operdate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getOperdate().equals(operdate)) cf.add("operdate",this.operdate,operdate); } this.operdate=operdate;}
public void setRecversion(int recversion) { sqlMaker.setField("recversion",""+recversion,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRecversion()!=recversion) cf.add("recversion",this.recversion+"",recversion+""); } this.recversion=recversion;}
public void setBankid(String bankid) { sqlMaker.setField("bankid",bankid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getBankid().equals(bankid)) cf.add("bankid",this.bankid,bankid); } this.bankid=bankid;}
public void setCust_bankid(String cust_bankid) { sqlMaker.setField("cust_bankid",cust_bankid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCust_bankid().equals(cust_bankid)) cf.add("cust_bankid",this.cust_bankid,cust_bankid); } this.cust_bankid=cust_bankid;}
public void setCust_tele(String cust_tele) { sqlMaker.setField("cust_tele",cust_tele,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCust_tele().equals(cust_tele)) cf.add("cust_tele",this.cust_tele,cust_tele); } this.cust_tele=cust_tele;}
public void setCust_mobile(String cust_mobile) { sqlMaker.setField("cust_mobile",cust_mobile,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCust_mobile().equals(cust_mobile)) cf.add("cust_mobile",this.cust_mobile,cust_mobile); } this.cust_mobile=cust_mobile;}
public void setCoop_name(String coop_name) { sqlMaker.setField("coop_name",coop_name,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCoop_name().equals(coop_name)) cf.add("coop_name",this.coop_name,coop_name); } this.coop_name=coop_name;}
public void setCoop_tele(String coop_tele) { sqlMaker.setField("coop_tele",coop_tele,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCoop_tele().equals(coop_tele)) cf.add("coop_tele",this.coop_tele,coop_tele); } this.coop_tele=coop_tele;}
public void setCoop_mobile(String coop_mobile) { sqlMaker.setField("coop_mobile",coop_mobile,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCoop_mobile().equals(coop_mobile)) cf.add("coop_mobile",this.coop_mobile,coop_mobile); } this.coop_mobile=coop_mobile;}
public void setSale_id(String sale_id) { sqlMaker.setField("sale_id",sale_id,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSale_id().equals(sale_id)) cf.add("sale_id",this.sale_id,sale_id); } this.sale_id=sale_id;}
public void setSale_name(String sale_name) { sqlMaker.setField("sale_name",sale_name,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSale_name().equals(sale_name)) cf.add("sale_name",this.sale_name,sale_name); } this.sale_name=sale_name;}
public void setSale_tele(String sale_tele) { sqlMaker.setField("sale_tele",sale_tele,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSale_tele().equals(sale_tele)) cf.add("sale_tele",this.sale_tele,sale_tele); } this.sale_tele=sale_tele;}
public void setSurvey_id(String survey_id) { sqlMaker.setField("survey_id",survey_id,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSurvey_id().equals(survey_id)) cf.add("survey_id",this.survey_id,survey_id); } this.survey_id=survey_id;}
public void setSurvey_name(String survey_name) { sqlMaker.setField("survey_name",survey_name,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSurvey_name().equals(survey_name)) cf.add("survey_name",this.survey_name,survey_name); } this.survey_name=survey_name;}
public void setSurvey_tele(String survey_tele) { sqlMaker.setField("survey_tele",survey_tele,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSurvey_tele().equals(survey_tele)) cf.add("survey_tele",this.survey_tele,survey_tele); } this.survey_tele=survey_tele;}
public void setInfo_name(String info_name) { sqlMaker.setField("info_name",info_name,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getInfo_name().equals(info_name)) cf.add("info_name",this.info_name,info_name); } this.info_name=info_name;}
public void setInfo_num(String info_num) { sqlMaker.setField("info_num",info_num,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getInfo_num().equals(info_num)) cf.add("info_num",this.info_num,info_num); } this.info_num=info_num;}
public void setInfo_remark(String info_remark) { sqlMaker.setField("info_remark",info_remark,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getInfo_remark().equals(info_remark)) cf.add("info_remark",this.info_remark,info_remark); } this.info_remark=info_remark;}
public void init(int i,ActionRequest actionRequest) throws Exception { if ( actionRequest.getFieldValue(i,"flowsn") !=null ) {this.setFlowsn(actionRequest.getFieldValue(i,"flowsn"));}
if ( actionRequest.getFieldValue(i,"loanid") !=null ) {this.setLoanid(actionRequest.getFieldValue(i,"loanid"));}
if ( actionRequest.getFieldValue(i,"mortid") !=null ) {this.setMortid(actionRequest.getFieldValue(i,"mortid"));}
if ( actionRequest.getFieldValue(i,"curr_cd") !=null ) {this.setCurr_cd(actionRequest.getFieldValue(i,"curr_cd"));}
if ( actionRequest.getFieldValue(i,"ln_prod_cod") !=null ) {this.setLn_prod_cod(actionRequest.getFieldValue(i,"ln_prod_cod"));}
if ( actionRequest.getFieldValue(i,"ln_typ") !=null ) {this.setLn_typ(actionRequest.getFieldValue(i,"ln_typ"));}
if ( actionRequest.getFieldValue(i,"guaranty_type") !=null ) {this.setGuaranty_type(actionRequest.getFieldValue(i,"guaranty_type"));}
if ( actionRequest.getFieldValue(i,"aply_dt") !=null ) {this.setAply_dt(actionRequest.getFieldValue(i,"aply_dt"));}
if ( actionRequest.getFieldValue(i,"rt_orig_loan_amt") !=null && actionRequest.getFieldValue(i,"rt_orig_loan_amt").trim().length() > 0 ) {this.setRt_orig_loan_amt(Double.parseDouble(actionRequest.getFieldValue(i,"rt_orig_loan_amt")));}
if ( actionRequest.getFieldValue(i,"rt_term_incr") !=null && actionRequest.getFieldValue(i,"rt_term_incr").trim().length() > 0 ) {this.setRt_term_incr(Integer.parseInt(actionRequest.getFieldValue(i,"rt_term_incr")));}
if ( actionRequest.getFieldValue(i,"pay_type") !=null ) {this.setPay_type(actionRequest.getFieldValue(i,"pay_type"));}
if ( actionRequest.getFieldValue(i,"proj_no") !=null ) {this.setProj_no(actionRequest.getFieldValue(i,"proj_no"));}
if ( actionRequest.getFieldValue(i,"cust_name") !=null ) {this.setCust_name(actionRequest.getFieldValue(i,"cust_name"));}
if ( actionRequest.getFieldValue(i,"custmgr_id") !=null ) {this.setCustmgr_id(actionRequest.getFieldValue(i,"custmgr_id"));}
if ( actionRequest.getFieldValue(i,"realcustmgr_id") !=null ) {this.setRealcustmgr_id(actionRequest.getFieldValue(i,"realcustmgr_id"));}
if ( actionRequest.getFieldValue(i,"operid") !=null ) {this.setOperid(actionRequest.getFieldValue(i,"operid"));}
if ( actionRequest.getFieldValue(i,"operdate") !=null ) {this.setOperdate(actionRequest.getFieldValue(i,"operdate"));}
if ( actionRequest.getFieldValue(i,"recversion") !=null && actionRequest.getFieldValue(i,"recversion").trim().length() > 0 ) {this.setRecversion(Integer.parseInt(actionRequest.getFieldValue(i,"recversion")));}
if ( actionRequest.getFieldValue(i,"bankid") !=null ) {this.setBankid(actionRequest.getFieldValue(i,"bankid"));}
if ( actionRequest.getFieldValue(i,"cust_bankid") !=null ) {this.setCust_bankid(actionRequest.getFieldValue(i,"cust_bankid"));}
if ( actionRequest.getFieldValue(i,"cust_tele") !=null ) {this.setCust_tele(actionRequest.getFieldValue(i,"cust_tele"));}
if ( actionRequest.getFieldValue(i,"cust_mobile") !=null ) {this.setCust_mobile(actionRequest.getFieldValue(i,"cust_mobile"));}
if ( actionRequest.getFieldValue(i,"coop_name") !=null ) {this.setCoop_name(actionRequest.getFieldValue(i,"coop_name"));}
if ( actionRequest.getFieldValue(i,"coop_tele") !=null ) {this.setCoop_tele(actionRequest.getFieldValue(i,"coop_tele"));}
if ( actionRequest.getFieldValue(i,"coop_mobile") !=null ) {this.setCoop_mobile(actionRequest.getFieldValue(i,"coop_mobile"));}
if ( actionRequest.getFieldValue(i,"sale_id") !=null ) {this.setSale_id(actionRequest.getFieldValue(i,"sale_id"));}
if ( actionRequest.getFieldValue(i,"sale_name") !=null ) {this.setSale_name(actionRequest.getFieldValue(i,"sale_name"));}
if ( actionRequest.getFieldValue(i,"sale_tele") !=null ) {this.setSale_tele(actionRequest.getFieldValue(i,"sale_tele"));}
if ( actionRequest.getFieldValue(i,"survey_id") !=null ) {this.setSurvey_id(actionRequest.getFieldValue(i,"survey_id"));}
if ( actionRequest.getFieldValue(i,"survey_name") !=null ) {this.setSurvey_name(actionRequest.getFieldValue(i,"survey_name"));}
if ( actionRequest.getFieldValue(i,"survey_tele") !=null ) {this.setSurvey_tele(actionRequest.getFieldValue(i,"survey_tele"));}
if ( actionRequest.getFieldValue(i,"info_name") !=null ) {this.setInfo_name(actionRequest.getFieldValue(i,"info_name"));}
if ( actionRequest.getFieldValue(i,"info_num") !=null ) {this.setInfo_num(actionRequest.getFieldValue(i,"info_num"));}
if ( actionRequest.getFieldValue(i,"info_remark") !=null ) {this.setInfo_remark(actionRequest.getFieldValue(i,"info_remark"));}
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { LNARCHIVEINFO obj = (LNARCHIVEINFO)super.clone();obj.setFlowsn(obj.flowsn);
obj.setLoanid(obj.loanid);
obj.setMortid(obj.mortid);
obj.setCurr_cd(obj.curr_cd);
obj.setLn_prod_cod(obj.ln_prod_cod);
obj.setLn_typ(obj.ln_typ);
obj.setGuaranty_type(obj.guaranty_type);
obj.setAply_dt(obj.aply_dt);
obj.setRt_orig_loan_amt(obj.rt_orig_loan_amt);
obj.setRt_term_incr(obj.rt_term_incr);
obj.setPay_type(obj.pay_type);
obj.setProj_no(obj.proj_no);
obj.setCust_name(obj.cust_name);
obj.setCustmgr_id(obj.custmgr_id);
obj.setRealcustmgr_id(obj.realcustmgr_id);
obj.setOperid(obj.operid);
obj.setOperdate(obj.operdate);
obj.setRecversion(obj.recversion);
obj.setBankid(obj.bankid);
obj.setCust_bankid(obj.cust_bankid);
obj.setCust_tele(obj.cust_tele);
obj.setCust_mobile(obj.cust_mobile);
obj.setCoop_name(obj.coop_name);
obj.setCoop_tele(obj.coop_tele);
obj.setCoop_mobile(obj.coop_mobile);
obj.setSale_id(obj.sale_id);
obj.setSale_name(obj.sale_name);
obj.setSale_tele(obj.sale_tele);
obj.setSurvey_id(obj.survey_id);
obj.setSurvey_name(obj.survey_name);
obj.setSurvey_tele(obj.survey_tele);
obj.setInfo_name(obj.info_name);
obj.setInfo_num(obj.info_num);
obj.setInfo_remark(obj.info_remark);
return obj;}}