package com.ccb.dao;
import java.util.*;
import pub.platform.db.*;
import pub.platform.utils.*;
import pub.platform.db.AbstractBasicBean;
public class LNCOOPPROJ extends AbstractBasicBean implements Cloneable {
     public static List find(String sSqlWhere) {           return new LNCOOPPROJ().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere) {           return new LNCOOPPROJ().findAndLockByWhere(sSqlWhere);      }       public static LNCOOPPROJ findFirst(String sSqlWhere) {           return (LNCOOPPROJ)new LNCOOPPROJ().findFirstByWhere(sSqlWhere);      }       public static LNCOOPPROJ findFirstAndLock(String sSqlWhere) {           return (LNCOOPPROJ)new LNCOOPPROJ().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) {           return new LNCOOPPROJ().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease) {           LNCOOPPROJ bean = new LNCOOPPROJ();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) {           LNCOOPPROJ bean = new LNCOOPPROJ();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static LNCOOPPROJ findFirst(String sSqlWhere,boolean isAutoRelease) {           LNCOOPPROJ bean = new LNCOOPPROJ();           bean.setAutoRelease(isAutoRelease);           return (LNCOOPPROJ)bean.findFirstByWhere(sSqlWhere);      }       public static LNCOOPPROJ findFirstAndLock(String sSqlWhere,boolean isAutoRelease) {           LNCOOPPROJ bean = new LNCOOPPROJ();           bean.setAutoRelease(isAutoRelease);           return (LNCOOPPROJ)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease) {           LNCOOPPROJ bean = new LNCOOPPROJ();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      }      public static List findByRow(String sSqlWhere,int row) {           return new LNCOOPPROJ().findByWhereByRow(sSqlWhere,row);      } String proj_nbxh;
String proj_no;
String ods_src_dt;
String corpid;
String corpname;
String proj_name;
String builaddr;
String bankid;
String assustartdate;
String assuenddate;
double coopperiod;
double cooplimitamt;
double maxlnpercent;
double maxlnperiod;
String assuperiod;
String agreementno;
String releasecondcd;
String devlnbankcd;
String devlnstartdate;
String devlnenddate;
double assuamtpercent;
String assuamt;
String maturityflag;
String otherpromise;
String projdevlninfo;
String diffservpercent;
String followupmortperiod;
String apprbillno;
String apprbillcd;
String specialassuitem;
String commitmentflag;
String commitmentremarks;
String remarks;
String deptid;
String operid;
String operdate;
int recversion;
String projstatus;
String importinfo;
String bankflag;
String proj_name_abbr;
String presellid;
String adminacct;
String adminacctbank;
String agreementcd;
String inputdate;
String devlntimelimittye;
String cust_bankid;
public static final String TABLENAME ="ln_coopproj";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
public void addObject(List list,RecordSet rs) {
LNCOOPPROJ abb = new LNCOOPPROJ();
abb.proj_nbxh=rs.getString("proj_nbxh");abb.setKeyValue("PROJ_NBXH",""+abb.getProj_nbxh());
abb.proj_no=rs.getString("proj_no");abb.setKeyValue("PROJ_NO",""+abb.getProj_no());
abb.ods_src_dt=rs.getString("ods_src_dt");abb.setKeyValue("ODS_SRC_DT",""+abb.getOds_src_dt());
abb.corpid=rs.getString("corpid");abb.setKeyValue("CORPID",""+abb.getCorpid());
abb.corpname=rs.getString("corpname");abb.setKeyValue("CORPNAME",""+abb.getCorpname());
abb.proj_name=rs.getString("proj_name");abb.setKeyValue("PROJ_NAME",""+abb.getProj_name());
abb.builaddr=rs.getString("builaddr");abb.setKeyValue("BUILADDR",""+abb.getBuiladdr());
abb.bankid=rs.getString("bankid");abb.setKeyValue("BANKID",""+abb.getBankid());
abb.assustartdate=rs.getString("assustartdate");abb.setKeyValue("ASSUSTARTDATE",""+abb.getAssustartdate());
abb.assuenddate=rs.getString("assuenddate");abb.setKeyValue("ASSUENDDATE",""+abb.getAssuenddate());
abb.coopperiod=rs.getDouble("coopperiod");abb.setKeyValue("COOPPERIOD",""+abb.getCoopperiod());
abb.cooplimitamt=rs.getDouble("cooplimitamt");abb.setKeyValue("COOPLIMITAMT",""+abb.getCooplimitamt());
abb.maxlnpercent=rs.getDouble("maxlnpercent");abb.setKeyValue("MAXLNPERCENT",""+abb.getMaxlnpercent());
abb.maxlnperiod=rs.getDouble("maxlnperiod");abb.setKeyValue("MAXLNPERIOD",""+abb.getMaxlnperiod());
abb.assuperiod=rs.getString("assuperiod");abb.setKeyValue("ASSUPERIOD",""+abb.getAssuperiod());
abb.agreementno=rs.getString("agreementno");abb.setKeyValue("AGREEMENTNO",""+abb.getAgreementno());
abb.releasecondcd=rs.getString("releasecondcd");abb.setKeyValue("RELEASECONDCD",""+abb.getReleasecondcd());
abb.devlnbankcd=rs.getString("devlnbankcd");abb.setKeyValue("DEVLNBANKCD",""+abb.getDevlnbankcd());
abb.devlnstartdate=rs.getString("devlnstartdate");abb.setKeyValue("DEVLNSTARTDATE",""+abb.getDevlnstartdate());
abb.devlnenddate=rs.getString("devlnenddate");abb.setKeyValue("DEVLNENDDATE",""+abb.getDevlnenddate());
abb.assuamtpercent=rs.getDouble("assuamtpercent");abb.setKeyValue("ASSUAMTPERCENT",""+abb.getAssuamtpercent());
abb.assuamt=rs.getString("assuamt");abb.setKeyValue("ASSUAMT",""+abb.getAssuamt());
abb.maturityflag=rs.getString("maturityflag");abb.setKeyValue("MATURITYFLAG",""+abb.getMaturityflag());
abb.otherpromise=rs.getString("otherpromise");abb.setKeyValue("OTHERPROMISE",""+abb.getOtherpromise());
abb.projdevlninfo=rs.getString("projdevlninfo");abb.setKeyValue("PROJDEVLNINFO",""+abb.getProjdevlninfo());
abb.diffservpercent=rs.getString("diffservpercent");abb.setKeyValue("DIFFSERVPERCENT",""+abb.getDiffservpercent());
abb.followupmortperiod=rs.getString("followupmortperiod");abb.setKeyValue("FOLLOWUPMORTPERIOD",""+abb.getFollowupmortperiod());
abb.apprbillno=rs.getString("apprbillno");abb.setKeyValue("APPRBILLNO",""+abb.getApprbillno());
abb.apprbillcd=rs.getString("apprbillcd");abb.setKeyValue("APPRBILLCD",""+abb.getApprbillcd());
abb.specialassuitem=rs.getString("specialassuitem");abb.setKeyValue("SPECIALASSUITEM",""+abb.getSpecialassuitem());
abb.commitmentflag=rs.getString("commitmentflag");abb.setKeyValue("COMMITMENTFLAG",""+abb.getCommitmentflag());
abb.commitmentremarks=rs.getString("commitmentremarks");abb.setKeyValue("COMMITMENTREMARKS",""+abb.getCommitmentremarks());
abb.remarks=rs.getString("remarks");abb.setKeyValue("REMARKS",""+abb.getRemarks());
abb.deptid=rs.getString("deptid");abb.setKeyValue("DEPTID",""+abb.getDeptid());
abb.operid=rs.getString("operid");abb.setKeyValue("OPERID",""+abb.getOperid());
abb.operdate=rs.getTimeString("operdate");abb.setKeyValue("OPERDATE",""+abb.getOperdate());
abb.recversion=rs.getInt("recversion");abb.setKeyValue("RECVERSION",""+abb.getRecversion());
abb.projstatus=rs.getString("projstatus");abb.setKeyValue("PROJSTATUS",""+abb.getProjstatus());
abb.importinfo=rs.getString("importinfo");abb.setKeyValue("IMPORTINFO",""+abb.getImportinfo());
abb.bankflag=rs.getString("bankflag");abb.setKeyValue("BANKFLAG",""+abb.getBankflag());
abb.proj_name_abbr=rs.getString("proj_name_abbr");abb.setKeyValue("PROJ_NAME_ABBR",""+abb.getProj_name_abbr());
abb.presellid=rs.getString("presellid");abb.setKeyValue("PRESELLID",""+abb.getPresellid());
abb.adminacct=rs.getString("adminacct");abb.setKeyValue("ADMINACCT",""+abb.getAdminacct());
abb.adminacctbank=rs.getString("adminacctbank");abb.setKeyValue("ADMINACCTBANK",""+abb.getAdminacctbank());
abb.agreementcd=rs.getString("agreementcd");abb.setKeyValue("AGREEMENTCD",""+abb.getAgreementcd());
abb.inputdate=rs.getString("inputdate");abb.setKeyValue("INPUTDATE",""+abb.getInputdate());
abb.devlntimelimittye=rs.getString("devlntimelimittye");abb.setKeyValue("DEVLNTIMELIMITTYE",""+abb.getDevlntimelimittye());
abb.cust_bankid=rs.getString("cust_bankid");abb.setKeyValue("CUST_BANKID",""+abb.getCust_bankid());
list.add(abb);
abb.operate_mode = "edit";
}public String getProj_nbxh() { if ( this.proj_nbxh == null ) return ""; return this.proj_nbxh;}
public String getProj_no() { if ( this.proj_no == null ) return ""; return this.proj_no;}
public String getOds_src_dt() { if ( this.ods_src_dt == null ) return ""; return this.ods_src_dt;}
public String getCorpid() { if ( this.corpid == null ) return ""; return this.corpid;}
public String getCorpname() { if ( this.corpname == null ) return ""; return this.corpname;}
public String getProj_name() { if ( this.proj_name == null ) return ""; return this.proj_name;}
public String getBuiladdr() { if ( this.builaddr == null ) return ""; return this.builaddr;}
public String getBankid() { if ( this.bankid == null ) return ""; return this.bankid;}
public String getAssustartdate() { if ( this.assustartdate == null ) return ""; return this.assustartdate;}
public String getAssuenddate() { if ( this.assuenddate == null ) return ""; return this.assuenddate;}
public double getCoopperiod() { return this.coopperiod;}
public double getCooplimitamt() { return this.cooplimitamt;}
public double getMaxlnpercent() { return this.maxlnpercent;}
public double getMaxlnperiod() { return this.maxlnperiod;}
public String getAssuperiod() { if ( this.assuperiod == null ) return ""; return this.assuperiod;}
public String getAgreementno() { if ( this.agreementno == null ) return ""; return this.agreementno;}
public String getReleasecondcd() { if ( this.releasecondcd == null ) return ""; return this.releasecondcd;}
public String getDevlnbankcd() { if ( this.devlnbankcd == null ) return ""; return this.devlnbankcd;}
public String getDevlnstartdate() { if ( this.devlnstartdate == null ) return ""; return this.devlnstartdate;}
public String getDevlnenddate() { if ( this.devlnenddate == null ) return ""; return this.devlnenddate;}
public double getAssuamtpercent() { return this.assuamtpercent;}
public String getAssuamt() { if ( this.assuamt == null ) return ""; return this.assuamt;}
public String getMaturityflag() { if ( this.maturityflag == null ) return ""; return this.maturityflag;}
public String getOtherpromise() { if ( this.otherpromise == null ) return ""; return this.otherpromise;}
public String getProjdevlninfo() { if ( this.projdevlninfo == null ) return ""; return this.projdevlninfo;}
public String getDiffservpercent() { if ( this.diffservpercent == null ) return ""; return this.diffservpercent;}
public String getFollowupmortperiod() { if ( this.followupmortperiod == null ) return ""; return this.followupmortperiod;}
public String getApprbillno() { if ( this.apprbillno == null ) return ""; return this.apprbillno;}
public String getApprbillcd() { if ( this.apprbillcd == null ) return ""; return this.apprbillcd;}
public String getSpecialassuitem() { if ( this.specialassuitem == null ) return ""; return this.specialassuitem;}
public String getCommitmentflag() { if ( this.commitmentflag == null ) return ""; return this.commitmentflag;}
public String getCommitmentremarks() { if ( this.commitmentremarks == null ) return ""; return this.commitmentremarks;}
public String getRemarks() { if ( this.remarks == null ) return ""; return this.remarks;}
public String getDeptid() { if ( this.deptid == null ) return ""; return this.deptid;}
public String getOperid() { if ( this.operid == null ) return ""; return this.operid;}
public String getOperdate() {  if ( this.operdate == null ) { return ""; } else { return this.operdate.trim().split(" ")[0];} }public String getOperdateTime() {  if ( this.operdate == null ) return ""; return this.operdate.split("\\.")[0];}
public int getRecversion() { return this.recversion;}
public String getProjstatus() { if ( this.projstatus == null ) return ""; return this.projstatus;}
public String getImportinfo() { if ( this.importinfo == null ) return ""; return this.importinfo;}
public String getBankflag() { if ( this.bankflag == null ) return ""; return this.bankflag;}
public String getProj_name_abbr() { if ( this.proj_name_abbr == null ) return ""; return this.proj_name_abbr;}
public String getPresellid() { if ( this.presellid == null ) return ""; return this.presellid;}
public String getAdminacct() { if ( this.adminacct == null ) return ""; return this.adminacct;}
public String getAdminacctbank() { if ( this.adminacctbank == null ) return ""; return this.adminacctbank;}
public String getAgreementcd() { if ( this.agreementcd == null ) return ""; return this.agreementcd;}
public String getInputdate() { if ( this.inputdate == null ) return ""; return this.inputdate;}
public String getDevlntimelimittye() { if ( this.devlntimelimittye == null ) return ""; return this.devlntimelimittye;}
public String getCust_bankid() { if ( this.cust_bankid == null ) return ""; return this.cust_bankid;}
public void setProj_nbxh(String proj_nbxh) { sqlMaker.setField("proj_nbxh",proj_nbxh,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getProj_nbxh().equals(proj_nbxh)) cf.add("proj_nbxh",this.proj_nbxh,proj_nbxh); } this.proj_nbxh=proj_nbxh;}
public void setProj_no(String proj_no) { sqlMaker.setField("proj_no",proj_no,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getProj_no().equals(proj_no)) cf.add("proj_no",this.proj_no,proj_no); } this.proj_no=proj_no;}
public void setOds_src_dt(String ods_src_dt) { sqlMaker.setField("ods_src_dt",ods_src_dt,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getOds_src_dt().equals(ods_src_dt)) cf.add("ods_src_dt",this.ods_src_dt,ods_src_dt); } this.ods_src_dt=ods_src_dt;}
public void setCorpid(String corpid) { sqlMaker.setField("corpid",corpid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCorpid().equals(corpid)) cf.add("corpid",this.corpid,corpid); } this.corpid=corpid;}
public void setCorpname(String corpname) { sqlMaker.setField("corpname",corpname,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCorpname().equals(corpname)) cf.add("corpname",this.corpname,corpname); } this.corpname=corpname;}
public void setProj_name(String proj_name) { sqlMaker.setField("proj_name",proj_name,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getProj_name().equals(proj_name)) cf.add("proj_name",this.proj_name,proj_name); } this.proj_name=proj_name;}
public void setBuiladdr(String builaddr) { sqlMaker.setField("builaddr",builaddr,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getBuiladdr().equals(builaddr)) cf.add("builaddr",this.builaddr,builaddr); } this.builaddr=builaddr;}
public void setBankid(String bankid) { sqlMaker.setField("bankid",bankid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getBankid().equals(bankid)) cf.add("bankid",this.bankid,bankid); } this.bankid=bankid;}
public void setAssustartdate(String assustartdate) { sqlMaker.setField("assustartdate",assustartdate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAssustartdate().equals(assustartdate)) cf.add("assustartdate",this.assustartdate,assustartdate); } this.assustartdate=assustartdate;}
public void setAssuenddate(String assuenddate) { sqlMaker.setField("assuenddate",assuenddate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAssuenddate().equals(assuenddate)) cf.add("assuenddate",this.assuenddate,assuenddate); } this.assuenddate=assuenddate;}
public void setCoopperiod(double coopperiod) { sqlMaker.setField("coopperiod",""+coopperiod,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getCoopperiod()!=coopperiod) cf.add("coopperiod",this.coopperiod+"",coopperiod+""); } this.coopperiod=coopperiod;}
public void setCooplimitamt(double cooplimitamt) { sqlMaker.setField("cooplimitamt",""+cooplimitamt,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getCooplimitamt()!=cooplimitamt) cf.add("cooplimitamt",this.cooplimitamt+"",cooplimitamt+""); } this.cooplimitamt=cooplimitamt;}
public void setMaxlnpercent(double maxlnpercent) { sqlMaker.setField("maxlnpercent",""+maxlnpercent,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getMaxlnpercent()!=maxlnpercent) cf.add("maxlnpercent",this.maxlnpercent+"",maxlnpercent+""); } this.maxlnpercent=maxlnpercent;}
public void setMaxlnperiod(double maxlnperiod) { sqlMaker.setField("maxlnperiod",""+maxlnperiod,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getMaxlnperiod()!=maxlnperiod) cf.add("maxlnperiod",this.maxlnperiod+"",maxlnperiod+""); } this.maxlnperiod=maxlnperiod;}
public void setAssuperiod(String assuperiod) { sqlMaker.setField("assuperiod",assuperiod,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAssuperiod().equals(assuperiod)) cf.add("assuperiod",this.assuperiod,assuperiod); } this.assuperiod=assuperiod;}
public void setAgreementno(String agreementno) { sqlMaker.setField("agreementno",agreementno,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAgreementno().equals(agreementno)) cf.add("agreementno",this.agreementno,agreementno); } this.agreementno=agreementno;}
public void setReleasecondcd(String releasecondcd) { sqlMaker.setField("releasecondcd",releasecondcd,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getReleasecondcd().equals(releasecondcd)) cf.add("releasecondcd",this.releasecondcd,releasecondcd); } this.releasecondcd=releasecondcd;}
public void setDevlnbankcd(String devlnbankcd) { sqlMaker.setField("devlnbankcd",devlnbankcd,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getDevlnbankcd().equals(devlnbankcd)) cf.add("devlnbankcd",this.devlnbankcd,devlnbankcd); } this.devlnbankcd=devlnbankcd;}
public void setDevlnstartdate(String devlnstartdate) { sqlMaker.setField("devlnstartdate",devlnstartdate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getDevlnstartdate().equals(devlnstartdate)) cf.add("devlnstartdate",this.devlnstartdate,devlnstartdate); } this.devlnstartdate=devlnstartdate;}
public void setDevlnenddate(String devlnenddate) { sqlMaker.setField("devlnenddate",devlnenddate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getDevlnenddate().equals(devlnenddate)) cf.add("devlnenddate",this.devlnenddate,devlnenddate); } this.devlnenddate=devlnenddate;}
public void setAssuamtpercent(double assuamtpercent) { sqlMaker.setField("assuamtpercent",""+assuamtpercent,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getAssuamtpercent()!=assuamtpercent) cf.add("assuamtpercent",this.assuamtpercent+"",assuamtpercent+""); } this.assuamtpercent=assuamtpercent;}
public void setAssuamt(String assuamt) { sqlMaker.setField("assuamt",assuamt,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAssuamt().equals(assuamt)) cf.add("assuamt",this.assuamt,assuamt); } this.assuamt=assuamt;}
public void setMaturityflag(String maturityflag) { sqlMaker.setField("maturityflag",maturityflag,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getMaturityflag().equals(maturityflag)) cf.add("maturityflag",this.maturityflag,maturityflag); } this.maturityflag=maturityflag;}
public void setOtherpromise(String otherpromise) { sqlMaker.setField("otherpromise",otherpromise,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getOtherpromise().equals(otherpromise)) cf.add("otherpromise",this.otherpromise,otherpromise); } this.otherpromise=otherpromise;}
public void setProjdevlninfo(String projdevlninfo) { sqlMaker.setField("projdevlninfo",projdevlninfo,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getProjdevlninfo().equals(projdevlninfo)) cf.add("projdevlninfo",this.projdevlninfo,projdevlninfo); } this.projdevlninfo=projdevlninfo;}
public void setDiffservpercent(String diffservpercent) { sqlMaker.setField("diffservpercent",diffservpercent,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getDiffservpercent().equals(diffservpercent)) cf.add("diffservpercent",this.diffservpercent,diffservpercent); } this.diffservpercent=diffservpercent;}
public void setFollowupmortperiod(String followupmortperiod) { sqlMaker.setField("followupmortperiod",followupmortperiod,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getFollowupmortperiod().equals(followupmortperiod)) cf.add("followupmortperiod",this.followupmortperiod,followupmortperiod); } this.followupmortperiod=followupmortperiod;}
public void setApprbillno(String apprbillno) { sqlMaker.setField("apprbillno",apprbillno,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getApprbillno().equals(apprbillno)) cf.add("apprbillno",this.apprbillno,apprbillno); } this.apprbillno=apprbillno;}
public void setApprbillcd(String apprbillcd) { sqlMaker.setField("apprbillcd",apprbillcd,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getApprbillcd().equals(apprbillcd)) cf.add("apprbillcd",this.apprbillcd,apprbillcd); } this.apprbillcd=apprbillcd;}
public void setSpecialassuitem(String specialassuitem) { sqlMaker.setField("specialassuitem",specialassuitem,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSpecialassuitem().equals(specialassuitem)) cf.add("specialassuitem",this.specialassuitem,specialassuitem); } this.specialassuitem=specialassuitem;}
public void setCommitmentflag(String commitmentflag) { sqlMaker.setField("commitmentflag",commitmentflag,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCommitmentflag().equals(commitmentflag)) cf.add("commitmentflag",this.commitmentflag,commitmentflag); } this.commitmentflag=commitmentflag;}
public void setCommitmentremarks(String commitmentremarks) { sqlMaker.setField("commitmentremarks",commitmentremarks,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCommitmentremarks().equals(commitmentremarks)) cf.add("commitmentremarks",this.commitmentremarks,commitmentremarks); } this.commitmentremarks=commitmentremarks;}
public void setRemarks(String remarks) { sqlMaker.setField("remarks",remarks,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRemarks().equals(remarks)) cf.add("remarks",this.remarks,remarks); } this.remarks=remarks;}
public void setDeptid(String deptid) { sqlMaker.setField("deptid",deptid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getDeptid().equals(deptid)) cf.add("deptid",this.deptid,deptid); } this.deptid=deptid;}
public void setOperid(String operid) { sqlMaker.setField("operid",operid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getOperid().equals(operid)) cf.add("operid",this.operid,operid); } this.operid=operid;}
public void setOperdate(String operdate) { sqlMaker.setField("operdate",operdate,Field.DATE); if (this.operate_mode.equals("edit")) { if (!this.getOperdate().equals(operdate)) cf.add("operdate",this.operdate,operdate); } this.operdate=operdate;}
public void setRecversion(int recversion) { sqlMaker.setField("recversion",""+recversion,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRecversion()!=recversion) cf.add("recversion",this.recversion+"",recversion+""); } this.recversion=recversion;}
public void setProjstatus(String projstatus) { sqlMaker.setField("projstatus",projstatus,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getProjstatus().equals(projstatus)) cf.add("projstatus",this.projstatus,projstatus); } this.projstatus=projstatus;}
public void setImportinfo(String importinfo) { sqlMaker.setField("importinfo",importinfo,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getImportinfo().equals(importinfo)) cf.add("importinfo",this.importinfo,importinfo); } this.importinfo=importinfo;}
public void setBankflag(String bankflag) { sqlMaker.setField("bankflag",bankflag,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getBankflag().equals(bankflag)) cf.add("bankflag",this.bankflag,bankflag); } this.bankflag=bankflag;}
public void setProj_name_abbr(String proj_name_abbr) { sqlMaker.setField("proj_name_abbr",proj_name_abbr,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getProj_name_abbr().equals(proj_name_abbr)) cf.add("proj_name_abbr",this.proj_name_abbr,proj_name_abbr); } this.proj_name_abbr=proj_name_abbr;}
public void setPresellid(String presellid) { sqlMaker.setField("presellid",presellid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getPresellid().equals(presellid)) cf.add("presellid",this.presellid,presellid); } this.presellid=presellid;}
public void setAdminacct(String adminacct) { sqlMaker.setField("adminacct",adminacct,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAdminacct().equals(adminacct)) cf.add("adminacct",this.adminacct,adminacct); } this.adminacct=adminacct;}
public void setAdminacctbank(String adminacctbank) { sqlMaker.setField("adminacctbank",adminacctbank,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAdminacctbank().equals(adminacctbank)) cf.add("adminacctbank",this.adminacctbank,adminacctbank); } this.adminacctbank=adminacctbank;}
public void setAgreementcd(String agreementcd) { sqlMaker.setField("agreementcd",agreementcd,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAgreementcd().equals(agreementcd)) cf.add("agreementcd",this.agreementcd,agreementcd); } this.agreementcd=agreementcd;}
public void setInputdate(String inputdate) { sqlMaker.setField("inputdate",inputdate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getInputdate().equals(inputdate)) cf.add("inputdate",this.inputdate,inputdate); } this.inputdate=inputdate;}
public void setDevlntimelimittye(String devlntimelimittye) { sqlMaker.setField("devlntimelimittye",devlntimelimittye,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getDevlntimelimittye().equals(devlntimelimittye)) cf.add("devlntimelimittye",this.devlntimelimittye,devlntimelimittye); } this.devlntimelimittye=devlntimelimittye;}
public void setCust_bankid(String cust_bankid) { sqlMaker.setField("cust_bankid",cust_bankid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCust_bankid().equals(cust_bankid)) cf.add("cust_bankid",this.cust_bankid,cust_bankid); } this.cust_bankid=cust_bankid;}
public void init(int i,ActionRequest actionRequest) throws Exception { if ( actionRequest.getFieldValue(i,"proj_nbxh") !=null ) {this.setProj_nbxh(actionRequest.getFieldValue(i,"proj_nbxh"));}
if ( actionRequest.getFieldValue(i,"proj_no") !=null ) {this.setProj_no(actionRequest.getFieldValue(i,"proj_no"));}
if ( actionRequest.getFieldValue(i,"ods_src_dt") !=null ) {this.setOds_src_dt(actionRequest.getFieldValue(i,"ods_src_dt"));}
if ( actionRequest.getFieldValue(i,"corpid") !=null ) {this.setCorpid(actionRequest.getFieldValue(i,"corpid"));}
if ( actionRequest.getFieldValue(i,"corpname") !=null ) {this.setCorpname(actionRequest.getFieldValue(i,"corpname"));}
if ( actionRequest.getFieldValue(i,"proj_name") !=null ) {this.setProj_name(actionRequest.getFieldValue(i,"proj_name"));}
if ( actionRequest.getFieldValue(i,"builaddr") !=null ) {this.setBuiladdr(actionRequest.getFieldValue(i,"builaddr"));}
if ( actionRequest.getFieldValue(i,"bankid") !=null ) {this.setBankid(actionRequest.getFieldValue(i,"bankid"));}
if ( actionRequest.getFieldValue(i,"assustartdate") !=null ) {this.setAssustartdate(actionRequest.getFieldValue(i,"assustartdate"));}
if ( actionRequest.getFieldValue(i,"assuenddate") !=null ) {this.setAssuenddate(actionRequest.getFieldValue(i,"assuenddate"));}
if ( actionRequest.getFieldValue(i,"coopperiod") !=null && actionRequest.getFieldValue(i,"coopperiod").trim().length() > 0 ) {this.setCoopperiod(Double.parseDouble(actionRequest.getFieldValue(i,"coopperiod")));}
if ( actionRequest.getFieldValue(i,"cooplimitamt") !=null && actionRequest.getFieldValue(i,"cooplimitamt").trim().length() > 0 ) {this.setCooplimitamt(Double.parseDouble(actionRequest.getFieldValue(i,"cooplimitamt")));}
if ( actionRequest.getFieldValue(i,"maxlnpercent") !=null && actionRequest.getFieldValue(i,"maxlnpercent").trim().length() > 0 ) {this.setMaxlnpercent(Double.parseDouble(actionRequest.getFieldValue(i,"maxlnpercent")));}
if ( actionRequest.getFieldValue(i,"maxlnperiod") !=null && actionRequest.getFieldValue(i,"maxlnperiod").trim().length() > 0 ) {this.setMaxlnperiod(Double.parseDouble(actionRequest.getFieldValue(i,"maxlnperiod")));}
if ( actionRequest.getFieldValue(i,"assuperiod") !=null ) {this.setAssuperiod(actionRequest.getFieldValue(i,"assuperiod"));}
if ( actionRequest.getFieldValue(i,"agreementno") !=null ) {this.setAgreementno(actionRequest.getFieldValue(i,"agreementno"));}
if ( actionRequest.getFieldValue(i,"releasecondcd") !=null ) {this.setReleasecondcd(actionRequest.getFieldValue(i,"releasecondcd"));}
if ( actionRequest.getFieldValue(i,"devlnbankcd") !=null ) {this.setDevlnbankcd(actionRequest.getFieldValue(i,"devlnbankcd"));}
if ( actionRequest.getFieldValue(i,"devlnstartdate") !=null ) {this.setDevlnstartdate(actionRequest.getFieldValue(i,"devlnstartdate"));}
if ( actionRequest.getFieldValue(i,"devlnenddate") !=null ) {this.setDevlnenddate(actionRequest.getFieldValue(i,"devlnenddate"));}
if ( actionRequest.getFieldValue(i,"assuamtpercent") !=null && actionRequest.getFieldValue(i,"assuamtpercent").trim().length() > 0 ) {this.setAssuamtpercent(Double.parseDouble(actionRequest.getFieldValue(i,"assuamtpercent")));}
if ( actionRequest.getFieldValue(i,"assuamt") !=null ) {this.setAssuamt(actionRequest.getFieldValue(i,"assuamt"));}
if ( actionRequest.getFieldValue(i,"maturityflag") !=null ) {this.setMaturityflag(actionRequest.getFieldValue(i,"maturityflag"));}
if ( actionRequest.getFieldValue(i,"otherpromise") !=null ) {this.setOtherpromise(actionRequest.getFieldValue(i,"otherpromise"));}
if ( actionRequest.getFieldValue(i,"projdevlninfo") !=null ) {this.setProjdevlninfo(actionRequest.getFieldValue(i,"projdevlninfo"));}
if ( actionRequest.getFieldValue(i,"diffservpercent") !=null ) {this.setDiffservpercent(actionRequest.getFieldValue(i,"diffservpercent"));}
if ( actionRequest.getFieldValue(i,"followupmortperiod") !=null ) {this.setFollowupmortperiod(actionRequest.getFieldValue(i,"followupmortperiod"));}
if ( actionRequest.getFieldValue(i,"apprbillno") !=null ) {this.setApprbillno(actionRequest.getFieldValue(i,"apprbillno"));}
if ( actionRequest.getFieldValue(i,"apprbillcd") !=null ) {this.setApprbillcd(actionRequest.getFieldValue(i,"apprbillcd"));}
if ( actionRequest.getFieldValue(i,"specialassuitem") !=null ) {this.setSpecialassuitem(actionRequest.getFieldValue(i,"specialassuitem"));}
if ( actionRequest.getFieldValue(i,"commitmentflag") !=null ) {this.setCommitmentflag(actionRequest.getFieldValue(i,"commitmentflag"));}
if ( actionRequest.getFieldValue(i,"commitmentremarks") !=null ) {this.setCommitmentremarks(actionRequest.getFieldValue(i,"commitmentremarks"));}
if ( actionRequest.getFieldValue(i,"remarks") !=null ) {this.setRemarks(actionRequest.getFieldValue(i,"remarks"));}
if ( actionRequest.getFieldValue(i,"deptid") !=null ) {this.setDeptid(actionRequest.getFieldValue(i,"deptid"));}
if ( actionRequest.getFieldValue(i,"operid") !=null ) {this.setOperid(actionRequest.getFieldValue(i,"operid"));}
if ( actionRequest.getFieldValue(i,"operdate") !=null ) {this.setOperdate(actionRequest.getFieldValue(i,"operdate"));}
if ( actionRequest.getFieldValue(i,"recversion") !=null && actionRequest.getFieldValue(i,"recversion").trim().length() > 0 ) {this.setRecversion(Integer.parseInt(actionRequest.getFieldValue(i,"recversion")));}
if ( actionRequest.getFieldValue(i,"projstatus") !=null ) {this.setProjstatus(actionRequest.getFieldValue(i,"projstatus"));}
if ( actionRequest.getFieldValue(i,"importinfo") !=null ) {this.setImportinfo(actionRequest.getFieldValue(i,"importinfo"));}
if ( actionRequest.getFieldValue(i,"bankflag") !=null ) {this.setBankflag(actionRequest.getFieldValue(i,"bankflag"));}
if ( actionRequest.getFieldValue(i,"proj_name_abbr") !=null ) {this.setProj_name_abbr(actionRequest.getFieldValue(i,"proj_name_abbr"));}
if ( actionRequest.getFieldValue(i,"presellid") !=null ) {this.setPresellid(actionRequest.getFieldValue(i,"presellid"));}
if ( actionRequest.getFieldValue(i,"adminacct") !=null ) {this.setAdminacct(actionRequest.getFieldValue(i,"adminacct"));}
if ( actionRequest.getFieldValue(i,"adminacctbank") !=null ) {this.setAdminacctbank(actionRequest.getFieldValue(i,"adminacctbank"));}
if ( actionRequest.getFieldValue(i,"agreementcd") !=null ) {this.setAgreementcd(actionRequest.getFieldValue(i,"agreementcd"));}
if ( actionRequest.getFieldValue(i,"inputdate") !=null ) {this.setInputdate(actionRequest.getFieldValue(i,"inputdate"));}
if ( actionRequest.getFieldValue(i,"devlntimelimittye") !=null ) {this.setDevlntimelimittye(actionRequest.getFieldValue(i,"devlntimelimittye"));}
if ( actionRequest.getFieldValue(i,"cust_bankid") !=null ) {this.setCust_bankid(actionRequest.getFieldValue(i,"cust_bankid"));}
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { LNCOOPPROJ obj = (LNCOOPPROJ)super.clone();obj.setProj_nbxh(obj.proj_nbxh);
obj.setProj_no(obj.proj_no);
obj.setOds_src_dt(obj.ods_src_dt);
obj.setCorpid(obj.corpid);
obj.setCorpname(obj.corpname);
obj.setProj_name(obj.proj_name);
obj.setBuiladdr(obj.builaddr);
obj.setBankid(obj.bankid);
obj.setAssustartdate(obj.assustartdate);
obj.setAssuenddate(obj.assuenddate);
obj.setCoopperiod(obj.coopperiod);
obj.setCooplimitamt(obj.cooplimitamt);
obj.setMaxlnpercent(obj.maxlnpercent);
obj.setMaxlnperiod(obj.maxlnperiod);
obj.setAssuperiod(obj.assuperiod);
obj.setAgreementno(obj.agreementno);
obj.setReleasecondcd(obj.releasecondcd);
obj.setDevlnbankcd(obj.devlnbankcd);
obj.setDevlnstartdate(obj.devlnstartdate);
obj.setDevlnenddate(obj.devlnenddate);
obj.setAssuamtpercent(obj.assuamtpercent);
obj.setAssuamt(obj.assuamt);
obj.setMaturityflag(obj.maturityflag);
obj.setOtherpromise(obj.otherpromise);
obj.setProjdevlninfo(obj.projdevlninfo);
obj.setDiffservpercent(obj.diffservpercent);
obj.setFollowupmortperiod(obj.followupmortperiod);
obj.setApprbillno(obj.apprbillno);
obj.setApprbillcd(obj.apprbillcd);
obj.setSpecialassuitem(obj.specialassuitem);
obj.setCommitmentflag(obj.commitmentflag);
obj.setCommitmentremarks(obj.commitmentremarks);
obj.setRemarks(obj.remarks);
obj.setDeptid(obj.deptid);
obj.setOperid(obj.operid);
obj.setOperdate(obj.operdate);
obj.setRecversion(obj.recversion);
obj.setProjstatus(obj.projstatus);
obj.setImportinfo(obj.importinfo);
obj.setBankflag(obj.bankflag);
obj.setProj_name_abbr(obj.proj_name_abbr);
obj.setPresellid(obj.presellid);
obj.setAdminacct(obj.adminacct);
obj.setAdminacctbank(obj.adminacctbank);
obj.setAgreementcd(obj.agreementcd);
obj.setInputdate(obj.inputdate);
obj.setDevlntimelimittye(obj.devlntimelimittye);
obj.setCust_bankid(obj.cust_bankid);
return obj;}}