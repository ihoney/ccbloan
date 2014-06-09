package com.ccb.dao;
import java.util.*;
import pub.platform.db.*;
import pub.platform.utils.*;
import pub.platform.db.AbstractBasicBean;
public class LNLOANAPPLY extends AbstractBasicBean implements Cloneable {
     public static List find(String sSqlWhere) {           return new LNLOANAPPLY().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere) {           return new LNLOANAPPLY().findAndLockByWhere(sSqlWhere);      }       public static LNLOANAPPLY findFirst(String sSqlWhere) {           return (LNLOANAPPLY)new LNLOANAPPLY().findFirstByWhere(sSqlWhere);      }       public static LNLOANAPPLY findFirstAndLock(String sSqlWhere) {           return (LNLOANAPPLY)new LNLOANAPPLY().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) {           return new LNLOANAPPLY().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease) {           LNLOANAPPLY bean = new LNLOANAPPLY();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) {           LNLOANAPPLY bean = new LNLOANAPPLY();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static LNLOANAPPLY findFirst(String sSqlWhere,boolean isAutoRelease) {           LNLOANAPPLY bean = new LNLOANAPPLY();           bean.setAutoRelease(isAutoRelease);           return (LNLOANAPPLY)bean.findFirstByWhere(sSqlWhere);      }       public static LNLOANAPPLY findFirstAndLock(String sSqlWhere,boolean isAutoRelease) {           LNLOANAPPLY bean = new LNLOANAPPLY();           bean.setAutoRelease(isAutoRelease);           return (LNLOANAPPLY)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease) {           LNLOANAPPLY bean = new LNLOANAPPLY();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      }      public static List findByRow(String sSqlWhere,int row) {           return new LNLOANAPPLY().findByWhereByRow(sSqlWhere,row);      } String loanid;
String ln_acct_no;
String ods_src_dt;
String cust_no;
String crlmt_no;
String curr_cd;
String ln_prod_cod;
String ln_typ;
String guaranty_type;
String aply_dt;
double rt_orig_loan_amt;
int rt_term_incr;
String pay_type;
String proj_no;
String ratecode;
double basicinterate;
String rateact;
double ratecalevalue;
double interate;
String cust_open_dt;
String expiring_dt;
String bankid;
String operid;
String apprstate;
String loanstate;
String corpid;
String cust_name;
String custmgr_id;
String cust_py;
String nbxh;
String operid2;
String operdate;
int recversion;
String deptid;
String releasecondcd;
String releasedate;
String needaddcd;
public static final String TABLENAME ="ln_loanapply";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
public void addObject(List list,RecordSet rs) {
LNLOANAPPLY abb = new LNLOANAPPLY();
abb.loanid=rs.getString("loanid");abb.setKeyValue("LOANID",""+abb.getLoanid());
abb.ln_acct_no=rs.getString("ln_acct_no");abb.setKeyValue("LN_ACCT_NO",""+abb.getLn_acct_no());
abb.ods_src_dt=rs.getString("ods_src_dt");abb.setKeyValue("ODS_SRC_DT",""+abb.getOds_src_dt());
abb.cust_no=rs.getString("cust_no");abb.setKeyValue("CUST_NO",""+abb.getCust_no());
abb.crlmt_no=rs.getString("crlmt_no");abb.setKeyValue("CRLMT_NO",""+abb.getCrlmt_no());
abb.curr_cd=rs.getString("curr_cd");abb.setKeyValue("CURR_CD",""+abb.getCurr_cd());
abb.ln_prod_cod=rs.getString("ln_prod_cod");abb.setKeyValue("LN_PROD_COD",""+abb.getLn_prod_cod());
abb.ln_typ=rs.getString("ln_typ");abb.setKeyValue("LN_TYP",""+abb.getLn_typ());
abb.guaranty_type=rs.getString("guaranty_type");abb.setKeyValue("GUARANTY_TYPE",""+abb.getGuaranty_type());
abb.aply_dt=rs.getString("aply_dt");abb.setKeyValue("APLY_DT",""+abb.getAply_dt());
abb.rt_orig_loan_amt=rs.getDouble("rt_orig_loan_amt");abb.setKeyValue("RT_ORIG_LOAN_AMT",""+abb.getRt_orig_loan_amt());
abb.rt_term_incr=rs.getInt("rt_term_incr");abb.setKeyValue("RT_TERM_INCR",""+abb.getRt_term_incr());
abb.pay_type=rs.getString("pay_type");abb.setKeyValue("PAY_TYPE",""+abb.getPay_type());
abb.proj_no=rs.getString("proj_no");abb.setKeyValue("PROJ_NO",""+abb.getProj_no());
abb.ratecode=rs.getString("ratecode");abb.setKeyValue("RATECODE",""+abb.getRatecode());
abb.basicinterate=rs.getDouble("basicinterate");abb.setKeyValue("BASICINTERATE",""+abb.getBasicinterate());
abb.rateact=rs.getString("rateact");abb.setKeyValue("RATEACT",""+abb.getRateact());
abb.ratecalevalue=rs.getDouble("ratecalevalue");abb.setKeyValue("RATECALEVALUE",""+abb.getRatecalevalue());
abb.interate=rs.getDouble("interate");abb.setKeyValue("INTERATE",""+abb.getInterate());
abb.cust_open_dt=rs.getString("cust_open_dt");abb.setKeyValue("CUST_OPEN_DT",""+abb.getCust_open_dt());
abb.expiring_dt=rs.getString("expiring_dt");abb.setKeyValue("EXPIRING_DT",""+abb.getExpiring_dt());
abb.bankid=rs.getString("bankid");abb.setKeyValue("BANKID",""+abb.getBankid());
abb.operid=rs.getString("operid");abb.setKeyValue("OPERID",""+abb.getOperid());
abb.apprstate=rs.getString("apprstate");abb.setKeyValue("APPRSTATE",""+abb.getApprstate());
abb.loanstate=rs.getString("loanstate");abb.setKeyValue("LOANSTATE",""+abb.getLoanstate());
abb.corpid=rs.getString("corpid");abb.setKeyValue("CORPID",""+abb.getCorpid());
abb.cust_name=rs.getString("cust_name");abb.setKeyValue("CUST_NAME",""+abb.getCust_name());
abb.custmgr_id=rs.getString("custmgr_id");abb.setKeyValue("CUSTMGR_ID",""+abb.getCustmgr_id());
abb.cust_py=rs.getString("cust_py");abb.setKeyValue("CUST_PY",""+abb.getCust_py());
abb.nbxh=rs.getString("nbxh");abb.setKeyValue("NBXH",""+abb.getNbxh());
abb.operid2=rs.getString("operid2");abb.setKeyValue("OPERID2",""+abb.getOperid2());
abb.operdate=rs.getString("operdate");abb.setKeyValue("OPERDATE",""+abb.getOperdate());
abb.recversion=rs.getInt("recversion");abb.setKeyValue("RECVERSION",""+abb.getRecversion());
abb.deptid=rs.getString("deptid");abb.setKeyValue("DEPTID",""+abb.getDeptid());
abb.releasecondcd=rs.getString("releasecondcd");abb.setKeyValue("RELEASECONDCD",""+abb.getReleasecondcd());
abb.releasedate=rs.getString("releasedate");abb.setKeyValue("RELEASEDATE",""+abb.getReleasedate());
abb.needaddcd=rs.getString("needaddcd");abb.setKeyValue("NEEDADDCD",""+abb.getNeedaddcd());
list.add(abb);
abb.operate_mode = "edit";
}public String getLoanid() { if ( this.loanid == null ) return ""; return this.loanid;}
public String getLn_acct_no() { if ( this.ln_acct_no == null ) return ""; return this.ln_acct_no;}
public String getOds_src_dt() { if ( this.ods_src_dt == null ) return ""; return this.ods_src_dt;}
public String getCust_no() { if ( this.cust_no == null ) return ""; return this.cust_no;}
public String getCrlmt_no() { if ( this.crlmt_no == null ) return ""; return this.crlmt_no;}
public String getCurr_cd() { if ( this.curr_cd == null ) return ""; return this.curr_cd;}
public String getLn_prod_cod() { if ( this.ln_prod_cod == null ) return ""; return this.ln_prod_cod;}
public String getLn_typ() { if ( this.ln_typ == null ) return ""; return this.ln_typ;}
public String getGuaranty_type() { if ( this.guaranty_type == null ) return ""; return this.guaranty_type;}
public String getAply_dt() { if ( this.aply_dt == null ) return ""; return this.aply_dt;}
public double getRt_orig_loan_amt() { return this.rt_orig_loan_amt;}
public int getRt_term_incr() { return this.rt_term_incr;}
public String getPay_type() { if ( this.pay_type == null ) return ""; return this.pay_type;}
public String getProj_no() { if ( this.proj_no == null ) return ""; return this.proj_no;}
public String getRatecode() { if ( this.ratecode == null ) return ""; return this.ratecode;}
public double getBasicinterate() { return this.basicinterate;}
public String getRateact() { if ( this.rateact == null ) return ""; return this.rateact;}
public double getRatecalevalue() { return this.ratecalevalue;}
public double getInterate() { return this.interate;}
public String getCust_open_dt() { if ( this.cust_open_dt == null ) return ""; return this.cust_open_dt;}
public String getExpiring_dt() { if ( this.expiring_dt == null ) return ""; return this.expiring_dt;}
public String getBankid() { if ( this.bankid == null ) return ""; return this.bankid;}
public String getOperid() { if ( this.operid == null ) return ""; return this.operid;}
public String getApprstate() { if ( this.apprstate == null ) return ""; return this.apprstate;}
public String getLoanstate() { if ( this.loanstate == null ) return ""; return this.loanstate;}
public String getCorpid() { if ( this.corpid == null ) return ""; return this.corpid;}
public String getCust_name() { if ( this.cust_name == null ) return ""; return this.cust_name;}
public String getCustmgr_id() { if ( this.custmgr_id == null ) return ""; return this.custmgr_id;}
public String getCust_py() { if ( this.cust_py == null ) return ""; return this.cust_py;}
public String getNbxh() { if ( this.nbxh == null ) return ""; return this.nbxh;}
public String getOperid2() { if ( this.operid2 == null ) return ""; return this.operid2;}
public String getOperdate() { if ( this.operdate == null ) return ""; return this.operdate;}
public int getRecversion() { return this.recversion;}
public String getDeptid() { if ( this.deptid == null ) return ""; return this.deptid;}
public String getReleasecondcd() { if ( this.releasecondcd == null ) return ""; return this.releasecondcd;}
public String getReleasedate() { if ( this.releasedate == null ) return ""; return this.releasedate;}
public String getNeedaddcd() { if ( this.needaddcd == null ) return ""; return this.needaddcd;}
public void setLoanid(String loanid) { sqlMaker.setField("loanid",loanid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLoanid().equals(loanid)) cf.add("loanid",this.loanid,loanid); } this.loanid=loanid;}
public void setLn_acct_no(String ln_acct_no) { sqlMaker.setField("ln_acct_no",ln_acct_no,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLn_acct_no().equals(ln_acct_no)) cf.add("ln_acct_no",this.ln_acct_no,ln_acct_no); } this.ln_acct_no=ln_acct_no;}
public void setOds_src_dt(String ods_src_dt) { sqlMaker.setField("ods_src_dt",ods_src_dt,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getOds_src_dt().equals(ods_src_dt)) cf.add("ods_src_dt",this.ods_src_dt,ods_src_dt); } this.ods_src_dt=ods_src_dt;}
public void setCust_no(String cust_no) { sqlMaker.setField("cust_no",cust_no,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCust_no().equals(cust_no)) cf.add("cust_no",this.cust_no,cust_no); } this.cust_no=cust_no;}
public void setCrlmt_no(String crlmt_no) { sqlMaker.setField("crlmt_no",crlmt_no,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCrlmt_no().equals(crlmt_no)) cf.add("crlmt_no",this.crlmt_no,crlmt_no); } this.crlmt_no=crlmt_no;}
public void setCurr_cd(String curr_cd) { sqlMaker.setField("curr_cd",curr_cd,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCurr_cd().equals(curr_cd)) cf.add("curr_cd",this.curr_cd,curr_cd); } this.curr_cd=curr_cd;}
public void setLn_prod_cod(String ln_prod_cod) { sqlMaker.setField("ln_prod_cod",ln_prod_cod,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLn_prod_cod().equals(ln_prod_cod)) cf.add("ln_prod_cod",this.ln_prod_cod,ln_prod_cod); } this.ln_prod_cod=ln_prod_cod;}
public void setLn_typ(String ln_typ) { sqlMaker.setField("ln_typ",ln_typ,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLn_typ().equals(ln_typ)) cf.add("ln_typ",this.ln_typ,ln_typ); } this.ln_typ=ln_typ;}
public void setGuaranty_type(String guaranty_type) { sqlMaker.setField("guaranty_type",guaranty_type,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getGuaranty_type().equals(guaranty_type)) cf.add("guaranty_type",this.guaranty_type,guaranty_type); } this.guaranty_type=guaranty_type;}
public void setAply_dt(String aply_dt) { sqlMaker.setField("aply_dt",aply_dt,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAply_dt().equals(aply_dt)) cf.add("aply_dt",this.aply_dt,aply_dt); } this.aply_dt=aply_dt;}
public void setRt_orig_loan_amt(double rt_orig_loan_amt) { sqlMaker.setField("rt_orig_loan_amt",""+rt_orig_loan_amt,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRt_orig_loan_amt()!=rt_orig_loan_amt) cf.add("rt_orig_loan_amt",this.rt_orig_loan_amt+"",rt_orig_loan_amt+""); } this.rt_orig_loan_amt=rt_orig_loan_amt;}
public void setRt_term_incr(int rt_term_incr) { sqlMaker.setField("rt_term_incr",""+rt_term_incr,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRt_term_incr()!=rt_term_incr) cf.add("rt_term_incr",this.rt_term_incr+"",rt_term_incr+""); } this.rt_term_incr=rt_term_incr;}
public void setPay_type(String pay_type) { sqlMaker.setField("pay_type",pay_type,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getPay_type().equals(pay_type)) cf.add("pay_type",this.pay_type,pay_type); } this.pay_type=pay_type;}
public void setProj_no(String proj_no) { sqlMaker.setField("proj_no",proj_no,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getProj_no().equals(proj_no)) cf.add("proj_no",this.proj_no,proj_no); } this.proj_no=proj_no;}
public void setRatecode(String ratecode) { sqlMaker.setField("ratecode",ratecode,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRatecode().equals(ratecode)) cf.add("ratecode",this.ratecode,ratecode); } this.ratecode=ratecode;}
public void setBasicinterate(double basicinterate) { sqlMaker.setField("basicinterate",""+basicinterate,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getBasicinterate()!=basicinterate) cf.add("basicinterate",this.basicinterate+"",basicinterate+""); } this.basicinterate=basicinterate;}
public void setRateact(String rateact) { sqlMaker.setField("rateact",rateact,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRateact().equals(rateact)) cf.add("rateact",this.rateact,rateact); } this.rateact=rateact;}
public void setRatecalevalue(double ratecalevalue) { sqlMaker.setField("ratecalevalue",""+ratecalevalue,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRatecalevalue()!=ratecalevalue) cf.add("ratecalevalue",this.ratecalevalue+"",ratecalevalue+""); } this.ratecalevalue=ratecalevalue;}
public void setInterate(double interate) { sqlMaker.setField("interate",""+interate,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getInterate()!=interate) cf.add("interate",this.interate+"",interate+""); } this.interate=interate;}
public void setCust_open_dt(String cust_open_dt) { sqlMaker.setField("cust_open_dt",cust_open_dt,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCust_open_dt().equals(cust_open_dt)) cf.add("cust_open_dt",this.cust_open_dt,cust_open_dt); } this.cust_open_dt=cust_open_dt;}
public void setExpiring_dt(String expiring_dt) { sqlMaker.setField("expiring_dt",expiring_dt,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getExpiring_dt().equals(expiring_dt)) cf.add("expiring_dt",this.expiring_dt,expiring_dt); } this.expiring_dt=expiring_dt;}
public void setBankid(String bankid) { sqlMaker.setField("bankid",bankid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getBankid().equals(bankid)) cf.add("bankid",this.bankid,bankid); } this.bankid=bankid;}
public void setOperid(String operid) { sqlMaker.setField("operid",operid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getOperid().equals(operid)) cf.add("operid",this.operid,operid); } this.operid=operid;}
public void setApprstate(String apprstate) { sqlMaker.setField("apprstate",apprstate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getApprstate().equals(apprstate)) cf.add("apprstate",this.apprstate,apprstate); } this.apprstate=apprstate;}
public void setLoanstate(String loanstate) { sqlMaker.setField("loanstate",loanstate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLoanstate().equals(loanstate)) cf.add("loanstate",this.loanstate,loanstate); } this.loanstate=loanstate;}
public void setCorpid(String corpid) { sqlMaker.setField("corpid",corpid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCorpid().equals(corpid)) cf.add("corpid",this.corpid,corpid); } this.corpid=corpid;}
public void setCust_name(String cust_name) { sqlMaker.setField("cust_name",cust_name,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCust_name().equals(cust_name)) cf.add("cust_name",this.cust_name,cust_name); } this.cust_name=cust_name;}
public void setCustmgr_id(String custmgr_id) { sqlMaker.setField("custmgr_id",custmgr_id,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCustmgr_id().equals(custmgr_id)) cf.add("custmgr_id",this.custmgr_id,custmgr_id); } this.custmgr_id=custmgr_id;}
public void setCust_py(String cust_py) { sqlMaker.setField("cust_py",cust_py,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCust_py().equals(cust_py)) cf.add("cust_py",this.cust_py,cust_py); } this.cust_py=cust_py;}
public void setNbxh(String nbxh) { sqlMaker.setField("nbxh",nbxh,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getNbxh().equals(nbxh)) cf.add("nbxh",this.nbxh,nbxh); } this.nbxh=nbxh;}
public void setOperid2(String operid2) { sqlMaker.setField("operid2",operid2,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getOperid2().equals(operid2)) cf.add("operid2",this.operid2,operid2); } this.operid2=operid2;}
public void setOperdate(String operdate) { sqlMaker.setField("operdate",operdate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getOperdate().equals(operdate)) cf.add("operdate",this.operdate,operdate); } this.operdate=operdate;}
public void setRecversion(int recversion) { sqlMaker.setField("recversion",""+recversion,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRecversion()!=recversion) cf.add("recversion",this.recversion+"",recversion+""); } this.recversion=recversion;}
public void setDeptid(String deptid) { sqlMaker.setField("deptid",deptid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getDeptid().equals(deptid)) cf.add("deptid",this.deptid,deptid); } this.deptid=deptid;}
public void setReleasecondcd(String releasecondcd) { sqlMaker.setField("releasecondcd",releasecondcd,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getReleasecondcd().equals(releasecondcd)) cf.add("releasecondcd",this.releasecondcd,releasecondcd); } this.releasecondcd=releasecondcd;}
public void setReleasedate(String releasedate) { sqlMaker.setField("releasedate",releasedate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getReleasedate().equals(releasedate)) cf.add("releasedate",this.releasedate,releasedate); } this.releasedate=releasedate;}
public void setNeedaddcd(String needaddcd) { sqlMaker.setField("needaddcd",needaddcd,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getNeedaddcd().equals(needaddcd)) cf.add("needaddcd",this.needaddcd,needaddcd); } this.needaddcd=needaddcd;}
public void init(int i,ActionRequest actionRequest) throws Exception { if ( actionRequest.getFieldValue(i,"loanid") !=null ) {this.setLoanid(actionRequest.getFieldValue(i,"loanid"));}
if ( actionRequest.getFieldValue(i,"ln_acct_no") !=null ) {this.setLn_acct_no(actionRequest.getFieldValue(i,"ln_acct_no"));}
if ( actionRequest.getFieldValue(i,"ods_src_dt") !=null ) {this.setOds_src_dt(actionRequest.getFieldValue(i,"ods_src_dt"));}
if ( actionRequest.getFieldValue(i,"cust_no") !=null ) {this.setCust_no(actionRequest.getFieldValue(i,"cust_no"));}
if ( actionRequest.getFieldValue(i,"crlmt_no") !=null ) {this.setCrlmt_no(actionRequest.getFieldValue(i,"crlmt_no"));}
if ( actionRequest.getFieldValue(i,"curr_cd") !=null ) {this.setCurr_cd(actionRequest.getFieldValue(i,"curr_cd"));}
if ( actionRequest.getFieldValue(i,"ln_prod_cod") !=null ) {this.setLn_prod_cod(actionRequest.getFieldValue(i,"ln_prod_cod"));}
if ( actionRequest.getFieldValue(i,"ln_typ") !=null ) {this.setLn_typ(actionRequest.getFieldValue(i,"ln_typ"));}
if ( actionRequest.getFieldValue(i,"guaranty_type") !=null ) {this.setGuaranty_type(actionRequest.getFieldValue(i,"guaranty_type"));}
if ( actionRequest.getFieldValue(i,"aply_dt") !=null ) {this.setAply_dt(actionRequest.getFieldValue(i,"aply_dt"));}
if ( actionRequest.getFieldValue(i,"rt_orig_loan_amt") !=null && actionRequest.getFieldValue(i,"rt_orig_loan_amt").trim().length() > 0 ) {this.setRt_orig_loan_amt(Double.parseDouble(actionRequest.getFieldValue(i,"rt_orig_loan_amt")));}
if ( actionRequest.getFieldValue(i,"rt_term_incr") !=null && actionRequest.getFieldValue(i,"rt_term_incr").trim().length() > 0 ) {this.setRt_term_incr(Integer.parseInt(actionRequest.getFieldValue(i,"rt_term_incr")));}
if ( actionRequest.getFieldValue(i,"pay_type") !=null ) {this.setPay_type(actionRequest.getFieldValue(i,"pay_type"));}
if ( actionRequest.getFieldValue(i,"proj_no") !=null ) {this.setProj_no(actionRequest.getFieldValue(i,"proj_no"));}
if ( actionRequest.getFieldValue(i,"ratecode") !=null ) {this.setRatecode(actionRequest.getFieldValue(i,"ratecode"));}
if ( actionRequest.getFieldValue(i,"basicinterate") !=null && actionRequest.getFieldValue(i,"basicinterate").trim().length() > 0 ) {this.setBasicinterate(Double.parseDouble(actionRequest.getFieldValue(i,"basicinterate")));}
if ( actionRequest.getFieldValue(i,"rateact") !=null ) {this.setRateact(actionRequest.getFieldValue(i,"rateact"));}
if ( actionRequest.getFieldValue(i,"ratecalevalue") !=null && actionRequest.getFieldValue(i,"ratecalevalue").trim().length() > 0 ) {this.setRatecalevalue(Double.parseDouble(actionRequest.getFieldValue(i,"ratecalevalue")));}
if ( actionRequest.getFieldValue(i,"interate") !=null && actionRequest.getFieldValue(i,"interate").trim().length() > 0 ) {this.setInterate(Double.parseDouble(actionRequest.getFieldValue(i,"interate")));}
if ( actionRequest.getFieldValue(i,"cust_open_dt") !=null ) {this.setCust_open_dt(actionRequest.getFieldValue(i,"cust_open_dt"));}
if ( actionRequest.getFieldValue(i,"expiring_dt") !=null ) {this.setExpiring_dt(actionRequest.getFieldValue(i,"expiring_dt"));}
if ( actionRequest.getFieldValue(i,"bankid") !=null ) {this.setBankid(actionRequest.getFieldValue(i,"bankid"));}
if ( actionRequest.getFieldValue(i,"operid") !=null ) {this.setOperid(actionRequest.getFieldValue(i,"operid"));}
if ( actionRequest.getFieldValue(i,"apprstate") !=null ) {this.setApprstate(actionRequest.getFieldValue(i,"apprstate"));}
if ( actionRequest.getFieldValue(i,"loanstate") !=null ) {this.setLoanstate(actionRequest.getFieldValue(i,"loanstate"));}
if ( actionRequest.getFieldValue(i,"corpid") !=null ) {this.setCorpid(actionRequest.getFieldValue(i,"corpid"));}
if ( actionRequest.getFieldValue(i,"cust_name") !=null ) {this.setCust_name(actionRequest.getFieldValue(i,"cust_name"));}
if ( actionRequest.getFieldValue(i,"custmgr_id") !=null ) {this.setCustmgr_id(actionRequest.getFieldValue(i,"custmgr_id"));}
if ( actionRequest.getFieldValue(i,"cust_py") !=null ) {this.setCust_py(actionRequest.getFieldValue(i,"cust_py"));}
if ( actionRequest.getFieldValue(i,"nbxh") !=null ) {this.setNbxh(actionRequest.getFieldValue(i,"nbxh"));}
if ( actionRequest.getFieldValue(i,"operid2") !=null ) {this.setOperid2(actionRequest.getFieldValue(i,"operid2"));}
if ( actionRequest.getFieldValue(i,"operdate") !=null ) {this.setOperdate(actionRequest.getFieldValue(i,"operdate"));}
if ( actionRequest.getFieldValue(i,"recversion") !=null && actionRequest.getFieldValue(i,"recversion").trim().length() > 0 ) {this.setRecversion(Integer.parseInt(actionRequest.getFieldValue(i,"recversion")));}
if ( actionRequest.getFieldValue(i,"deptid") !=null ) {this.setDeptid(actionRequest.getFieldValue(i,"deptid"));}
if ( actionRequest.getFieldValue(i,"releasecondcd") !=null ) {this.setReleasecondcd(actionRequest.getFieldValue(i,"releasecondcd"));}
if ( actionRequest.getFieldValue(i,"releasedate") !=null ) {this.setReleasedate(actionRequest.getFieldValue(i,"releasedate"));}
if ( actionRequest.getFieldValue(i,"needaddcd") !=null ) {this.setNeedaddcd(actionRequest.getFieldValue(i,"needaddcd"));}
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { LNLOANAPPLY obj = (LNLOANAPPLY)super.clone();obj.setLoanid(obj.loanid);
obj.setLn_acct_no(obj.ln_acct_no);
obj.setOds_src_dt(obj.ods_src_dt);
obj.setCust_no(obj.cust_no);
obj.setCrlmt_no(obj.crlmt_no);
obj.setCurr_cd(obj.curr_cd);
obj.setLn_prod_cod(obj.ln_prod_cod);
obj.setLn_typ(obj.ln_typ);
obj.setGuaranty_type(obj.guaranty_type);
obj.setAply_dt(obj.aply_dt);
obj.setRt_orig_loan_amt(obj.rt_orig_loan_amt);
obj.setRt_term_incr(obj.rt_term_incr);
obj.setPay_type(obj.pay_type);
obj.setProj_no(obj.proj_no);
obj.setRatecode(obj.ratecode);
obj.setBasicinterate(obj.basicinterate);
obj.setRateact(obj.rateact);
obj.setRatecalevalue(obj.ratecalevalue);
obj.setInterate(obj.interate);
obj.setCust_open_dt(obj.cust_open_dt);
obj.setExpiring_dt(obj.expiring_dt);
obj.setBankid(obj.bankid);
obj.setOperid(obj.operid);
obj.setApprstate(obj.apprstate);
obj.setLoanstate(obj.loanstate);
obj.setCorpid(obj.corpid);
obj.setCust_name(obj.cust_name);
obj.setCustmgr_id(obj.custmgr_id);
obj.setCust_py(obj.cust_py);
obj.setNbxh(obj.nbxh);
obj.setOperid2(obj.operid2);
obj.setOperdate(obj.operdate);
obj.setRecversion(obj.recversion);
obj.setDeptid(obj.deptid);
obj.setReleasecondcd(obj.releasecondcd);
obj.setReleasedate(obj.releasedate);
obj.setNeedaddcd(obj.needaddcd);
return obj;}}