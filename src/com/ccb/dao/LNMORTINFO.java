package com.ccb.dao;
import java.util.*;
import pub.platform.db.*;
import pub.platform.utils.*;
import pub.platform.db.AbstractBasicBean;
public class LNMORTINFO extends AbstractBasicBean implements Cloneable {
     public static List find(String sSqlWhere) {           return new LNMORTINFO().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere) {           return new LNMORTINFO().findAndLockByWhere(sSqlWhere);      }       public static LNMORTINFO findFirst(String sSqlWhere) {           return (LNMORTINFO)new LNMORTINFO().findFirstByWhere(sSqlWhere);      }       public static LNMORTINFO findFirstAndLock(String sSqlWhere) {           return (LNMORTINFO)new LNMORTINFO().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) {           return new LNMORTINFO().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease) {           LNMORTINFO bean = new LNMORTINFO();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) {           LNMORTINFO bean = new LNMORTINFO();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static LNMORTINFO findFirst(String sSqlWhere,boolean isAutoRelease) {           LNMORTINFO bean = new LNMORTINFO();           bean.setAutoRelease(isAutoRelease);           return (LNMORTINFO)bean.findFirstByWhere(sSqlWhere);      }       public static LNMORTINFO findFirstAndLock(String sSqlWhere,boolean isAutoRelease) {           LNMORTINFO bean = new LNMORTINFO();           bean.setAutoRelease(isAutoRelease);           return (LNMORTINFO)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease) {           LNMORTINFO bean = new LNMORTINFO();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      }      public static List findByRow(String sSqlWhere,int row) {           return new LNMORTINFO().findByWhereByRow(sSqlWhere,row);      } String mortid;
String loanid;
String mortdate;
String mortecentercd;
String releasecondcd;
String keepcont;
String expressno;
String expressendsdate;
String paperrtndate;
String expressnote;
String nomortreason;
String sendflag;
String relayflag;
String mortstatus;
String operid;
String operdate;
int recversion;
String deptid;
String nomortreasoncd;
String rptmortdate;
String chgpaperdate;
String chgpaperreason;
String chgpaperreasoncd;
String chgpaperrtndate;
String clrpaperdate;
String mortexpiredate;
String mortoverrtndate;
String mortregstatus;
String receiptdate;
String receiptid;
String boxid;
String expressrtndate;
String rptnomortdate;
String documentid;
int warrantcnt;
String clrreasoncd;
String clrreasonremark;
String specialbizflag;
String specialbizoverflag;
String specialbizremark;
String exp_data_signin_date;
String exp_data_signin_remark;
String exp_paper_signin_date;
String exp_paper_signin_remark;
String flowsn;
String apptstatus;
String appt_biz_code;
String appt_hdl_date;
String appt_hdl_time;
String appt_remark;
String appt_valid_flag;
String appt_over_flag;
String appt_confirm_result;
String appt_sendback_reason;
String appt_sendback_remark;
int appt_cnt_sendback;
String appt_feedback_result;
String appt_feedback_remark;
String appt_date_apply;
String appt_time_apply;
String appt_date_feedback;
String appt_time_feedback;
String appt_date_confirm;
String appt_time_confirm;
String appt_oper_apply;
String appt_oper_confirm;
String appt_oper_feedback;
String sscm_status;
String sscm_date;
String sscm_nocancel_reason;
public static final String TABLENAME ="ln_mortinfo";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
public void addObject(List list,RecordSet rs) {
LNMORTINFO abb = new LNMORTINFO();
abb.mortid=rs.getString("mortid");abb.setKeyValue("MORTID",""+abb.getMortid());
abb.loanid=rs.getString("loanid");abb.setKeyValue("LOANID",""+abb.getLoanid());
abb.mortdate=rs.getString("mortdate");abb.setKeyValue("MORTDATE",""+abb.getMortdate());
abb.mortecentercd=rs.getString("mortecentercd");abb.setKeyValue("MORTECENTERCD",""+abb.getMortecentercd());
abb.releasecondcd=rs.getString("releasecondcd");abb.setKeyValue("RELEASECONDCD",""+abb.getReleasecondcd());
abb.keepcont=rs.getString("keepcont");abb.setKeyValue("KEEPCONT",""+abb.getKeepcont());
abb.expressno=rs.getString("expressno");abb.setKeyValue("EXPRESSNO",""+abb.getExpressno());
abb.expressendsdate=rs.getString("expressendsdate");abb.setKeyValue("EXPRESSENDSDATE",""+abb.getExpressendsdate());
abb.paperrtndate=rs.getString("paperrtndate");abb.setKeyValue("PAPERRTNDATE",""+abb.getPaperrtndate());
abb.expressnote=rs.getString("expressnote");abb.setKeyValue("EXPRESSNOTE",""+abb.getExpressnote());
abb.nomortreason=rs.getString("nomortreason");abb.setKeyValue("NOMORTREASON",""+abb.getNomortreason());
abb.sendflag=rs.getString("sendflag");abb.setKeyValue("SENDFLAG",""+abb.getSendflag());
abb.relayflag=rs.getString("relayflag");abb.setKeyValue("RELAYFLAG",""+abb.getRelayflag());
abb.mortstatus=rs.getString("mortstatus");abb.setKeyValue("MORTSTATUS",""+abb.getMortstatus());
abb.operid=rs.getString("operid");abb.setKeyValue("OPERID",""+abb.getOperid());
abb.operdate=rs.getTimeString("operdate");abb.setKeyValue("OPERDATE",""+abb.getOperdate());
abb.recversion=rs.getInt("recversion");abb.setKeyValue("RECVERSION",""+abb.getRecversion());
abb.deptid=rs.getString("deptid");abb.setKeyValue("DEPTID",""+abb.getDeptid());
abb.nomortreasoncd=rs.getString("nomortreasoncd");abb.setKeyValue("NOMORTREASONCD",""+abb.getNomortreasoncd());
abb.rptmortdate=rs.getString("rptmortdate");abb.setKeyValue("RPTMORTDATE",""+abb.getRptmortdate());
abb.chgpaperdate=rs.getString("chgpaperdate");abb.setKeyValue("CHGPAPERDATE",""+abb.getChgpaperdate());
abb.chgpaperreason=rs.getString("chgpaperreason");abb.setKeyValue("CHGPAPERREASON",""+abb.getChgpaperreason());
abb.chgpaperreasoncd=rs.getString("chgpaperreasoncd");abb.setKeyValue("CHGPAPERREASONCD",""+abb.getChgpaperreasoncd());
abb.chgpaperrtndate=rs.getString("chgpaperrtndate");abb.setKeyValue("CHGPAPERRTNDATE",""+abb.getChgpaperrtndate());
abb.clrpaperdate=rs.getString("clrpaperdate");abb.setKeyValue("CLRPAPERDATE",""+abb.getClrpaperdate());
abb.mortexpiredate=rs.getString("mortexpiredate");abb.setKeyValue("MORTEXPIREDATE",""+abb.getMortexpiredate());
abb.mortoverrtndate=rs.getString("mortoverrtndate");abb.setKeyValue("MORTOVERRTNDATE",""+abb.getMortoverrtndate());
abb.mortregstatus=rs.getString("mortregstatus");abb.setKeyValue("MORTREGSTATUS",""+abb.getMortregstatus());
abb.receiptdate=rs.getString("receiptdate");abb.setKeyValue("RECEIPTDATE",""+abb.getReceiptdate());
abb.receiptid=rs.getString("receiptid");abb.setKeyValue("RECEIPTID",""+abb.getReceiptid());
abb.boxid=rs.getString("boxid");abb.setKeyValue("BOXID",""+abb.getBoxid());
abb.expressrtndate=rs.getString("expressrtndate");abb.setKeyValue("EXPRESSRTNDATE",""+abb.getExpressrtndate());
abb.rptnomortdate=rs.getString("rptnomortdate");abb.setKeyValue("RPTNOMORTDATE",""+abb.getRptnomortdate());
abb.documentid=rs.getString("documentid");abb.setKeyValue("DOCUMENTID",""+abb.getDocumentid());
abb.warrantcnt=rs.getInt("warrantcnt");abb.setKeyValue("WARRANTCNT",""+abb.getWarrantcnt());
abb.clrreasoncd=rs.getString("clrreasoncd");abb.setKeyValue("CLRREASONCD",""+abb.getClrreasoncd());
abb.clrreasonremark=rs.getString("clrreasonremark");abb.setKeyValue("CLRREASONREMARK",""+abb.getClrreasonremark());
abb.specialbizflag=rs.getString("specialbizflag");abb.setKeyValue("SPECIALBIZFLAG",""+abb.getSpecialbizflag());
abb.specialbizoverflag=rs.getString("specialbizoverflag");abb.setKeyValue("SPECIALBIZOVERFLAG",""+abb.getSpecialbizoverflag());
abb.specialbizremark=rs.getString("specialbizremark");abb.setKeyValue("SPECIALBIZREMARK",""+abb.getSpecialbizremark());
abb.exp_data_signin_date=rs.getString("exp_data_signin_date");abb.setKeyValue("EXP_DATA_SIGNIN_DATE",""+abb.getExp_data_signin_date());
abb.exp_data_signin_remark=rs.getString("exp_data_signin_remark");abb.setKeyValue("EXP_DATA_SIGNIN_REMARK",""+abb.getExp_data_signin_remark());
abb.exp_paper_signin_date=rs.getString("exp_paper_signin_date");abb.setKeyValue("EXP_PAPER_SIGNIN_DATE",""+abb.getExp_paper_signin_date());
abb.exp_paper_signin_remark=rs.getString("exp_paper_signin_remark");abb.setKeyValue("EXP_PAPER_SIGNIN_REMARK",""+abb.getExp_paper_signin_remark());
abb.flowsn=rs.getString("flowsn");abb.setKeyValue("FLOWSN",""+abb.getFlowsn());
abb.apptstatus=rs.getString("apptstatus");abb.setKeyValue("APPTSTATUS",""+abb.getApptstatus());
abb.appt_biz_code=rs.getString("appt_biz_code");abb.setKeyValue("APPT_BIZ_CODE",""+abb.getAppt_biz_code());
abb.appt_hdl_date=rs.getString("appt_hdl_date");abb.setKeyValue("APPT_HDL_DATE",""+abb.getAppt_hdl_date());
abb.appt_hdl_time=rs.getString("appt_hdl_time");abb.setKeyValue("APPT_HDL_TIME",""+abb.getAppt_hdl_time());
abb.appt_remark=rs.getString("appt_remark");abb.setKeyValue("APPT_REMARK",""+abb.getAppt_remark());
abb.appt_valid_flag=rs.getString("appt_valid_flag");abb.setKeyValue("APPT_VALID_FLAG",""+abb.getAppt_valid_flag());
abb.appt_over_flag=rs.getString("appt_over_flag");abb.setKeyValue("APPT_OVER_FLAG",""+abb.getAppt_over_flag());
abb.appt_confirm_result=rs.getString("appt_confirm_result");abb.setKeyValue("APPT_CONFIRM_RESULT",""+abb.getAppt_confirm_result());
abb.appt_sendback_reason=rs.getString("appt_sendback_reason");abb.setKeyValue("APPT_SENDBACK_REASON",""+abb.getAppt_sendback_reason());
abb.appt_sendback_remark=rs.getString("appt_sendback_remark");abb.setKeyValue("APPT_SENDBACK_REMARK",""+abb.getAppt_sendback_remark());
abb.appt_cnt_sendback=rs.getInt("appt_cnt_sendback");abb.setKeyValue("APPT_CNT_SENDBACK",""+abb.getAppt_cnt_sendback());
abb.appt_feedback_result=rs.getString("appt_feedback_result");abb.setKeyValue("APPT_FEEDBACK_RESULT",""+abb.getAppt_feedback_result());
abb.appt_feedback_remark=rs.getString("appt_feedback_remark");abb.setKeyValue("APPT_FEEDBACK_REMARK",""+abb.getAppt_feedback_remark());
abb.appt_date_apply=rs.getString("appt_date_apply");abb.setKeyValue("APPT_DATE_APPLY",""+abb.getAppt_date_apply());
abb.appt_time_apply=rs.getString("appt_time_apply");abb.setKeyValue("APPT_TIME_APPLY",""+abb.getAppt_time_apply());
abb.appt_date_feedback=rs.getString("appt_date_feedback");abb.setKeyValue("APPT_DATE_FEEDBACK",""+abb.getAppt_date_feedback());
abb.appt_time_feedback=rs.getString("appt_time_feedback");abb.setKeyValue("APPT_TIME_FEEDBACK",""+abb.getAppt_time_feedback());
abb.appt_date_confirm=rs.getString("appt_date_confirm");abb.setKeyValue("APPT_DATE_CONFIRM",""+abb.getAppt_date_confirm());
abb.appt_time_confirm=rs.getString("appt_time_confirm");abb.setKeyValue("APPT_TIME_CONFIRM",""+abb.getAppt_time_confirm());
abb.appt_oper_apply=rs.getString("appt_oper_apply");abb.setKeyValue("APPT_OPER_APPLY",""+abb.getAppt_oper_apply());
abb.appt_oper_confirm=rs.getString("appt_oper_confirm");abb.setKeyValue("APPT_OPER_CONFIRM",""+abb.getAppt_oper_confirm());
abb.appt_oper_feedback=rs.getString("appt_oper_feedback");abb.setKeyValue("APPT_OPER_FEEDBACK",""+abb.getAppt_oper_feedback());
abb.sscm_status=rs.getString("sscm_status");abb.setKeyValue("SSCM_STATUS",""+abb.getSscm_status());
abb.sscm_date=rs.getString("sscm_date");abb.setKeyValue("SSCM_DATE",""+abb.getSscm_date());
abb.sscm_nocancel_reason=rs.getString("sscm_nocancel_reason");abb.setKeyValue("SSCM_NOCANCEL_REASON",""+abb.getSscm_nocancel_reason());
list.add(abb);
abb.operate_mode = "edit";
}public String getMortid() { if ( this.mortid == null ) return ""; return this.mortid;}
public String getLoanid() { if ( this.loanid == null ) return ""; return this.loanid;}
public String getMortdate() { if ( this.mortdate == null ) return ""; return this.mortdate;}
public String getMortecentercd() { if ( this.mortecentercd == null ) return ""; return this.mortecentercd;}
public String getReleasecondcd() { if ( this.releasecondcd == null ) return ""; return this.releasecondcd;}
public String getKeepcont() { if ( this.keepcont == null ) return ""; return this.keepcont;}
public String getExpressno() { if ( this.expressno == null ) return ""; return this.expressno;}
public String getExpressendsdate() { if ( this.expressendsdate == null ) return ""; return this.expressendsdate;}
public String getPaperrtndate() { if ( this.paperrtndate == null ) return ""; return this.paperrtndate;}
public String getExpressnote() { if ( this.expressnote == null ) return ""; return this.expressnote;}
public String getNomortreason() { if ( this.nomortreason == null ) return ""; return this.nomortreason;}
public String getSendflag() { if ( this.sendflag == null ) return ""; return this.sendflag;}
public String getRelayflag() { if ( this.relayflag == null ) return ""; return this.relayflag;}
public String getMortstatus() { if ( this.mortstatus == null ) return ""; return this.mortstatus;}
public String getOperid() { if ( this.operid == null ) return ""; return this.operid;}
public String getOperdate() {  if ( this.operdate == null ) { return ""; } else { return this.operdate.trim().split(" ")[0];} }public String getOperdateTime() {  if ( this.operdate == null ) return ""; return this.operdate.split("\\.")[0];}
public int getRecversion() { return this.recversion;}
public String getDeptid() { if ( this.deptid == null ) return ""; return this.deptid;}
public String getNomortreasoncd() { if ( this.nomortreasoncd == null ) return ""; return this.nomortreasoncd;}
public String getRptmortdate() { if ( this.rptmortdate == null ) return ""; return this.rptmortdate;}
public String getChgpaperdate() { if ( this.chgpaperdate == null ) return ""; return this.chgpaperdate;}
public String getChgpaperreason() { if ( this.chgpaperreason == null ) return ""; return this.chgpaperreason;}
public String getChgpaperreasoncd() { if ( this.chgpaperreasoncd == null ) return ""; return this.chgpaperreasoncd;}
public String getChgpaperrtndate() { if ( this.chgpaperrtndate == null ) return ""; return this.chgpaperrtndate;}
public String getClrpaperdate() { if ( this.clrpaperdate == null ) return ""; return this.clrpaperdate;}
public String getMortexpiredate() { if ( this.mortexpiredate == null ) return ""; return this.mortexpiredate;}
public String getMortoverrtndate() { if ( this.mortoverrtndate == null ) return ""; return this.mortoverrtndate;}
public String getMortregstatus() { if ( this.mortregstatus == null ) return ""; return this.mortregstatus;}
public String getReceiptdate() { if ( this.receiptdate == null ) return ""; return this.receiptdate;}
public String getReceiptid() { if ( this.receiptid == null ) return ""; return this.receiptid;}
public String getBoxid() { if ( this.boxid == null ) return ""; return this.boxid;}
public String getExpressrtndate() { if ( this.expressrtndate == null ) return ""; return this.expressrtndate;}
public String getRptnomortdate() { if ( this.rptnomortdate == null ) return ""; return this.rptnomortdate;}
public String getDocumentid() { if ( this.documentid == null ) return ""; return this.documentid;}
public int getWarrantcnt() { return this.warrantcnt;}
public String getClrreasoncd() { if ( this.clrreasoncd == null ) return ""; return this.clrreasoncd;}
public String getClrreasonremark() { if ( this.clrreasonremark == null ) return ""; return this.clrreasonremark;}
public String getSpecialbizflag() { if ( this.specialbizflag == null ) return ""; return this.specialbizflag;}
public String getSpecialbizoverflag() { if ( this.specialbizoverflag == null ) return ""; return this.specialbizoverflag;}
public String getSpecialbizremark() { if ( this.specialbizremark == null ) return ""; return this.specialbizremark;}
public String getExp_data_signin_date() { if ( this.exp_data_signin_date == null ) return ""; return this.exp_data_signin_date;}
public String getExp_data_signin_remark() { if ( this.exp_data_signin_remark == null ) return ""; return this.exp_data_signin_remark;}
public String getExp_paper_signin_date() { if ( this.exp_paper_signin_date == null ) return ""; return this.exp_paper_signin_date;}
public String getExp_paper_signin_remark() { if ( this.exp_paper_signin_remark == null ) return ""; return this.exp_paper_signin_remark;}
public String getFlowsn() { if ( this.flowsn == null ) return ""; return this.flowsn;}
public String getApptstatus() { if ( this.apptstatus == null ) return ""; return this.apptstatus;}
public String getAppt_biz_code() { if ( this.appt_biz_code == null ) return ""; return this.appt_biz_code;}
public String getAppt_hdl_date() { if ( this.appt_hdl_date == null ) return ""; return this.appt_hdl_date;}
public String getAppt_hdl_time() { if ( this.appt_hdl_time == null ) return ""; return this.appt_hdl_time;}
public String getAppt_remark() { if ( this.appt_remark == null ) return ""; return this.appt_remark;}
public String getAppt_valid_flag() { if ( this.appt_valid_flag == null ) return ""; return this.appt_valid_flag;}
public String getAppt_over_flag() { if ( this.appt_over_flag == null ) return ""; return this.appt_over_flag;}
public String getAppt_confirm_result() { if ( this.appt_confirm_result == null ) return ""; return this.appt_confirm_result;}
public String getAppt_sendback_reason() { if ( this.appt_sendback_reason == null ) return ""; return this.appt_sendback_reason;}
public String getAppt_sendback_remark() { if ( this.appt_sendback_remark == null ) return ""; return this.appt_sendback_remark;}
public int getAppt_cnt_sendback() { return this.appt_cnt_sendback;}
public String getAppt_feedback_result() { if ( this.appt_feedback_result == null ) return ""; return this.appt_feedback_result;}
public String getAppt_feedback_remark() { if ( this.appt_feedback_remark == null ) return ""; return this.appt_feedback_remark;}
public String getAppt_date_apply() { if ( this.appt_date_apply == null ) return ""; return this.appt_date_apply;}
public String getAppt_time_apply() { if ( this.appt_time_apply == null ) return ""; return this.appt_time_apply;}
public String getAppt_date_feedback() { if ( this.appt_date_feedback == null ) return ""; return this.appt_date_feedback;}
public String getAppt_time_feedback() { if ( this.appt_time_feedback == null ) return ""; return this.appt_time_feedback;}
public String getAppt_date_confirm() { if ( this.appt_date_confirm == null ) return ""; return this.appt_date_confirm;}
public String getAppt_time_confirm() { if ( this.appt_time_confirm == null ) return ""; return this.appt_time_confirm;}
public String getAppt_oper_apply() { if ( this.appt_oper_apply == null ) return ""; return this.appt_oper_apply;}
public String getAppt_oper_confirm() { if ( this.appt_oper_confirm == null ) return ""; return this.appt_oper_confirm;}
public String getAppt_oper_feedback() { if ( this.appt_oper_feedback == null ) return ""; return this.appt_oper_feedback;}
public String getSscm_status() { if ( this.sscm_status == null ) return ""; return this.sscm_status;}
public String getSscm_date() { if ( this.sscm_date == null ) return ""; return this.sscm_date;}
public String getSscm_nocancel_reason() { if ( this.sscm_nocancel_reason == null ) return ""; return this.sscm_nocancel_reason;}
public void setMortid(String mortid) { sqlMaker.setField("mortid",mortid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getMortid().equals(mortid)) cf.add("mortid",this.mortid,mortid); } this.mortid=mortid;}
public void setLoanid(String loanid) { sqlMaker.setField("loanid",loanid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLoanid().equals(loanid)) cf.add("loanid",this.loanid,loanid); } this.loanid=loanid;}
public void setMortdate(String mortdate) { sqlMaker.setField("mortdate",mortdate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getMortdate().equals(mortdate)) cf.add("mortdate",this.mortdate,mortdate); } this.mortdate=mortdate;}
public void setMortecentercd(String mortecentercd) { sqlMaker.setField("mortecentercd",mortecentercd,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getMortecentercd().equals(mortecentercd)) cf.add("mortecentercd",this.mortecentercd,mortecentercd); } this.mortecentercd=mortecentercd;}
public void setReleasecondcd(String releasecondcd) { sqlMaker.setField("releasecondcd",releasecondcd,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getReleasecondcd().equals(releasecondcd)) cf.add("releasecondcd",this.releasecondcd,releasecondcd); } this.releasecondcd=releasecondcd;}
public void setKeepcont(String keepcont) { sqlMaker.setField("keepcont",keepcont,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getKeepcont().equals(keepcont)) cf.add("keepcont",this.keepcont,keepcont); } this.keepcont=keepcont;}
public void setExpressno(String expressno) { sqlMaker.setField("expressno",expressno,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getExpressno().equals(expressno)) cf.add("expressno",this.expressno,expressno); } this.expressno=expressno;}
public void setExpressendsdate(String expressendsdate) { sqlMaker.setField("expressendsdate",expressendsdate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getExpressendsdate().equals(expressendsdate)) cf.add("expressendsdate",this.expressendsdate,expressendsdate); } this.expressendsdate=expressendsdate;}
public void setPaperrtndate(String paperrtndate) { sqlMaker.setField("paperrtndate",paperrtndate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getPaperrtndate().equals(paperrtndate)) cf.add("paperrtndate",this.paperrtndate,paperrtndate); } this.paperrtndate=paperrtndate;}
public void setExpressnote(String expressnote) { sqlMaker.setField("expressnote",expressnote,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getExpressnote().equals(expressnote)) cf.add("expressnote",this.expressnote,expressnote); } this.expressnote=expressnote;}
public void setNomortreason(String nomortreason) { sqlMaker.setField("nomortreason",nomortreason,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getNomortreason().equals(nomortreason)) cf.add("nomortreason",this.nomortreason,nomortreason); } this.nomortreason=nomortreason;}
public void setSendflag(String sendflag) { sqlMaker.setField("sendflag",sendflag,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSendflag().equals(sendflag)) cf.add("sendflag",this.sendflag,sendflag); } this.sendflag=sendflag;}
public void setRelayflag(String relayflag) { sqlMaker.setField("relayflag",relayflag,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRelayflag().equals(relayflag)) cf.add("relayflag",this.relayflag,relayflag); } this.relayflag=relayflag;}
public void setMortstatus(String mortstatus) { sqlMaker.setField("mortstatus",mortstatus,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getMortstatus().equals(mortstatus)) cf.add("mortstatus",this.mortstatus,mortstatus); } this.mortstatus=mortstatus;}
public void setOperid(String operid) { sqlMaker.setField("operid",operid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getOperid().equals(operid)) cf.add("operid",this.operid,operid); } this.operid=operid;}
public void setOperdate(String operdate) { sqlMaker.setField("operdate",operdate,Field.DATE); if (this.operate_mode.equals("edit")) { if (!this.getOperdate().equals(operdate)) cf.add("operdate",this.operdate,operdate); } this.operdate=operdate;}
public void setRecversion(int recversion) { sqlMaker.setField("recversion",""+recversion,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRecversion()!=recversion) cf.add("recversion",this.recversion+"",recversion+""); } this.recversion=recversion;}
public void setDeptid(String deptid) { sqlMaker.setField("deptid",deptid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getDeptid().equals(deptid)) cf.add("deptid",this.deptid,deptid); } this.deptid=deptid;}
public void setNomortreasoncd(String nomortreasoncd) { sqlMaker.setField("nomortreasoncd",nomortreasoncd,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getNomortreasoncd().equals(nomortreasoncd)) cf.add("nomortreasoncd",this.nomortreasoncd,nomortreasoncd); } this.nomortreasoncd=nomortreasoncd;}
public void setRptmortdate(String rptmortdate) { sqlMaker.setField("rptmortdate",rptmortdate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRptmortdate().equals(rptmortdate)) cf.add("rptmortdate",this.rptmortdate,rptmortdate); } this.rptmortdate=rptmortdate;}
public void setChgpaperdate(String chgpaperdate) { sqlMaker.setField("chgpaperdate",chgpaperdate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getChgpaperdate().equals(chgpaperdate)) cf.add("chgpaperdate",this.chgpaperdate,chgpaperdate); } this.chgpaperdate=chgpaperdate;}
public void setChgpaperreason(String chgpaperreason) { sqlMaker.setField("chgpaperreason",chgpaperreason,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getChgpaperreason().equals(chgpaperreason)) cf.add("chgpaperreason",this.chgpaperreason,chgpaperreason); } this.chgpaperreason=chgpaperreason;}
public void setChgpaperreasoncd(String chgpaperreasoncd) { sqlMaker.setField("chgpaperreasoncd",chgpaperreasoncd,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getChgpaperreasoncd().equals(chgpaperreasoncd)) cf.add("chgpaperreasoncd",this.chgpaperreasoncd,chgpaperreasoncd); } this.chgpaperreasoncd=chgpaperreasoncd;}
public void setChgpaperrtndate(String chgpaperrtndate) { sqlMaker.setField("chgpaperrtndate",chgpaperrtndate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getChgpaperrtndate().equals(chgpaperrtndate)) cf.add("chgpaperrtndate",this.chgpaperrtndate,chgpaperrtndate); } this.chgpaperrtndate=chgpaperrtndate;}
public void setClrpaperdate(String clrpaperdate) { sqlMaker.setField("clrpaperdate",clrpaperdate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getClrpaperdate().equals(clrpaperdate)) cf.add("clrpaperdate",this.clrpaperdate,clrpaperdate); } this.clrpaperdate=clrpaperdate;}
public void setMortexpiredate(String mortexpiredate) { sqlMaker.setField("mortexpiredate",mortexpiredate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getMortexpiredate().equals(mortexpiredate)) cf.add("mortexpiredate",this.mortexpiredate,mortexpiredate); } this.mortexpiredate=mortexpiredate;}
public void setMortoverrtndate(String mortoverrtndate) { sqlMaker.setField("mortoverrtndate",mortoverrtndate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getMortoverrtndate().equals(mortoverrtndate)) cf.add("mortoverrtndate",this.mortoverrtndate,mortoverrtndate); } this.mortoverrtndate=mortoverrtndate;}
public void setMortregstatus(String mortregstatus) { sqlMaker.setField("mortregstatus",mortregstatus,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getMortregstatus().equals(mortregstatus)) cf.add("mortregstatus",this.mortregstatus,mortregstatus); } this.mortregstatus=mortregstatus;}
public void setReceiptdate(String receiptdate) { sqlMaker.setField("receiptdate",receiptdate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getReceiptdate().equals(receiptdate)) cf.add("receiptdate",this.receiptdate,receiptdate); } this.receiptdate=receiptdate;}
public void setReceiptid(String receiptid) { sqlMaker.setField("receiptid",receiptid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getReceiptid().equals(receiptid)) cf.add("receiptid",this.receiptid,receiptid); } this.receiptid=receiptid;}
public void setBoxid(String boxid) { sqlMaker.setField("boxid",boxid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getBoxid().equals(boxid)) cf.add("boxid",this.boxid,boxid); } this.boxid=boxid;}
public void setExpressrtndate(String expressrtndate) { sqlMaker.setField("expressrtndate",expressrtndate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getExpressrtndate().equals(expressrtndate)) cf.add("expressrtndate",this.expressrtndate,expressrtndate); } this.expressrtndate=expressrtndate;}
public void setRptnomortdate(String rptnomortdate) { sqlMaker.setField("rptnomortdate",rptnomortdate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRptnomortdate().equals(rptnomortdate)) cf.add("rptnomortdate",this.rptnomortdate,rptnomortdate); } this.rptnomortdate=rptnomortdate;}
public void setDocumentid(String documentid) { sqlMaker.setField("documentid",documentid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getDocumentid().equals(documentid)) cf.add("documentid",this.documentid,documentid); } this.documentid=documentid;}
public void setWarrantcnt(int warrantcnt) { sqlMaker.setField("warrantcnt",""+warrantcnt,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getWarrantcnt()!=warrantcnt) cf.add("warrantcnt",this.warrantcnt+"",warrantcnt+""); } this.warrantcnt=warrantcnt;}
public void setClrreasoncd(String clrreasoncd) { sqlMaker.setField("clrreasoncd",clrreasoncd,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getClrreasoncd().equals(clrreasoncd)) cf.add("clrreasoncd",this.clrreasoncd,clrreasoncd); } this.clrreasoncd=clrreasoncd;}
public void setClrreasonremark(String clrreasonremark) { sqlMaker.setField("clrreasonremark",clrreasonremark,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getClrreasonremark().equals(clrreasonremark)) cf.add("clrreasonremark",this.clrreasonremark,clrreasonremark); } this.clrreasonremark=clrreasonremark;}
public void setSpecialbizflag(String specialbizflag) { sqlMaker.setField("specialbizflag",specialbizflag,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSpecialbizflag().equals(specialbizflag)) cf.add("specialbizflag",this.specialbizflag,specialbizflag); } this.specialbizflag=specialbizflag;}
public void setSpecialbizoverflag(String specialbizoverflag) { sqlMaker.setField("specialbizoverflag",specialbizoverflag,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSpecialbizoverflag().equals(specialbizoverflag)) cf.add("specialbizoverflag",this.specialbizoverflag,specialbizoverflag); } this.specialbizoverflag=specialbizoverflag;}
public void setSpecialbizremark(String specialbizremark) { sqlMaker.setField("specialbizremark",specialbizremark,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSpecialbizremark().equals(specialbizremark)) cf.add("specialbizremark",this.specialbizremark,specialbizremark); } this.specialbizremark=specialbizremark;}
public void setExp_data_signin_date(String exp_data_signin_date) { sqlMaker.setField("exp_data_signin_date",exp_data_signin_date,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getExp_data_signin_date().equals(exp_data_signin_date)) cf.add("exp_data_signin_date",this.exp_data_signin_date,exp_data_signin_date); } this.exp_data_signin_date=exp_data_signin_date;}
public void setExp_data_signin_remark(String exp_data_signin_remark) { sqlMaker.setField("exp_data_signin_remark",exp_data_signin_remark,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getExp_data_signin_remark().equals(exp_data_signin_remark)) cf.add("exp_data_signin_remark",this.exp_data_signin_remark,exp_data_signin_remark); } this.exp_data_signin_remark=exp_data_signin_remark;}
public void setExp_paper_signin_date(String exp_paper_signin_date) { sqlMaker.setField("exp_paper_signin_date",exp_paper_signin_date,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getExp_paper_signin_date().equals(exp_paper_signin_date)) cf.add("exp_paper_signin_date",this.exp_paper_signin_date,exp_paper_signin_date); } this.exp_paper_signin_date=exp_paper_signin_date;}
public void setExp_paper_signin_remark(String exp_paper_signin_remark) { sqlMaker.setField("exp_paper_signin_remark",exp_paper_signin_remark,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getExp_paper_signin_remark().equals(exp_paper_signin_remark)) cf.add("exp_paper_signin_remark",this.exp_paper_signin_remark,exp_paper_signin_remark); } this.exp_paper_signin_remark=exp_paper_signin_remark;}
public void setFlowsn(String flowsn) { sqlMaker.setField("flowsn",flowsn,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getFlowsn().equals(flowsn)) cf.add("flowsn",this.flowsn,flowsn); } this.flowsn=flowsn;}
public void setApptstatus(String apptstatus) { sqlMaker.setField("apptstatus",apptstatus,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getApptstatus().equals(apptstatus)) cf.add("apptstatus",this.apptstatus,apptstatus); } this.apptstatus=apptstatus;}
public void setAppt_biz_code(String appt_biz_code) { sqlMaker.setField("appt_biz_code",appt_biz_code,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAppt_biz_code().equals(appt_biz_code)) cf.add("appt_biz_code",this.appt_biz_code,appt_biz_code); } this.appt_biz_code=appt_biz_code;}
public void setAppt_hdl_date(String appt_hdl_date) { sqlMaker.setField("appt_hdl_date",appt_hdl_date,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAppt_hdl_date().equals(appt_hdl_date)) cf.add("appt_hdl_date",this.appt_hdl_date,appt_hdl_date); } this.appt_hdl_date=appt_hdl_date;}
public void setAppt_hdl_time(String appt_hdl_time) { sqlMaker.setField("appt_hdl_time",appt_hdl_time,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAppt_hdl_time().equals(appt_hdl_time)) cf.add("appt_hdl_time",this.appt_hdl_time,appt_hdl_time); } this.appt_hdl_time=appt_hdl_time;}
public void setAppt_remark(String appt_remark) { sqlMaker.setField("appt_remark",appt_remark,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAppt_remark().equals(appt_remark)) cf.add("appt_remark",this.appt_remark,appt_remark); } this.appt_remark=appt_remark;}
public void setAppt_valid_flag(String appt_valid_flag) { sqlMaker.setField("appt_valid_flag",appt_valid_flag,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAppt_valid_flag().equals(appt_valid_flag)) cf.add("appt_valid_flag",this.appt_valid_flag,appt_valid_flag); } this.appt_valid_flag=appt_valid_flag;}
public void setAppt_over_flag(String appt_over_flag) { sqlMaker.setField("appt_over_flag",appt_over_flag,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAppt_over_flag().equals(appt_over_flag)) cf.add("appt_over_flag",this.appt_over_flag,appt_over_flag); } this.appt_over_flag=appt_over_flag;}
public void setAppt_confirm_result(String appt_confirm_result) { sqlMaker.setField("appt_confirm_result",appt_confirm_result,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAppt_confirm_result().equals(appt_confirm_result)) cf.add("appt_confirm_result",this.appt_confirm_result,appt_confirm_result); } this.appt_confirm_result=appt_confirm_result;}
public void setAppt_sendback_reason(String appt_sendback_reason) { sqlMaker.setField("appt_sendback_reason",appt_sendback_reason,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAppt_sendback_reason().equals(appt_sendback_reason)) cf.add("appt_sendback_reason",this.appt_sendback_reason,appt_sendback_reason); } this.appt_sendback_reason=appt_sendback_reason;}
public void setAppt_sendback_remark(String appt_sendback_remark) { sqlMaker.setField("appt_sendback_remark",appt_sendback_remark,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAppt_sendback_remark().equals(appt_sendback_remark)) cf.add("appt_sendback_remark",this.appt_sendback_remark,appt_sendback_remark); } this.appt_sendback_remark=appt_sendback_remark;}
public void setAppt_cnt_sendback(int appt_cnt_sendback) { sqlMaker.setField("appt_cnt_sendback",""+appt_cnt_sendback,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getAppt_cnt_sendback()!=appt_cnt_sendback) cf.add("appt_cnt_sendback",this.appt_cnt_sendback+"",appt_cnt_sendback+""); } this.appt_cnt_sendback=appt_cnt_sendback;}
public void setAppt_feedback_result(String appt_feedback_result) { sqlMaker.setField("appt_feedback_result",appt_feedback_result,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAppt_feedback_result().equals(appt_feedback_result)) cf.add("appt_feedback_result",this.appt_feedback_result,appt_feedback_result); } this.appt_feedback_result=appt_feedback_result;}
public void setAppt_feedback_remark(String appt_feedback_remark) { sqlMaker.setField("appt_feedback_remark",appt_feedback_remark,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAppt_feedback_remark().equals(appt_feedback_remark)) cf.add("appt_feedback_remark",this.appt_feedback_remark,appt_feedback_remark); } this.appt_feedback_remark=appt_feedback_remark;}
public void setAppt_date_apply(String appt_date_apply) { sqlMaker.setField("appt_date_apply",appt_date_apply,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAppt_date_apply().equals(appt_date_apply)) cf.add("appt_date_apply",this.appt_date_apply,appt_date_apply); } this.appt_date_apply=appt_date_apply;}
public void setAppt_time_apply(String appt_time_apply) { sqlMaker.setField("appt_time_apply",appt_time_apply,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAppt_time_apply().equals(appt_time_apply)) cf.add("appt_time_apply",this.appt_time_apply,appt_time_apply); } this.appt_time_apply=appt_time_apply;}
public void setAppt_date_feedback(String appt_date_feedback) { sqlMaker.setField("appt_date_feedback",appt_date_feedback,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAppt_date_feedback().equals(appt_date_feedback)) cf.add("appt_date_feedback",this.appt_date_feedback,appt_date_feedback); } this.appt_date_feedback=appt_date_feedback;}
public void setAppt_time_feedback(String appt_time_feedback) { sqlMaker.setField("appt_time_feedback",appt_time_feedback,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAppt_time_feedback().equals(appt_time_feedback)) cf.add("appt_time_feedback",this.appt_time_feedback,appt_time_feedback); } this.appt_time_feedback=appt_time_feedback;}
public void setAppt_date_confirm(String appt_date_confirm) { sqlMaker.setField("appt_date_confirm",appt_date_confirm,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAppt_date_confirm().equals(appt_date_confirm)) cf.add("appt_date_confirm",this.appt_date_confirm,appt_date_confirm); } this.appt_date_confirm=appt_date_confirm;}
public void setAppt_time_confirm(String appt_time_confirm) { sqlMaker.setField("appt_time_confirm",appt_time_confirm,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAppt_time_confirm().equals(appt_time_confirm)) cf.add("appt_time_confirm",this.appt_time_confirm,appt_time_confirm); } this.appt_time_confirm=appt_time_confirm;}
public void setAppt_oper_apply(String appt_oper_apply) { sqlMaker.setField("appt_oper_apply",appt_oper_apply,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAppt_oper_apply().equals(appt_oper_apply)) cf.add("appt_oper_apply",this.appt_oper_apply,appt_oper_apply); } this.appt_oper_apply=appt_oper_apply;}
public void setAppt_oper_confirm(String appt_oper_confirm) { sqlMaker.setField("appt_oper_confirm",appt_oper_confirm,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAppt_oper_confirm().equals(appt_oper_confirm)) cf.add("appt_oper_confirm",this.appt_oper_confirm,appt_oper_confirm); } this.appt_oper_confirm=appt_oper_confirm;}
public void setAppt_oper_feedback(String appt_oper_feedback) { sqlMaker.setField("appt_oper_feedback",appt_oper_feedback,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAppt_oper_feedback().equals(appt_oper_feedback)) cf.add("appt_oper_feedback",this.appt_oper_feedback,appt_oper_feedback); } this.appt_oper_feedback=appt_oper_feedback;}
public void setSscm_status(String sscm_status) { sqlMaker.setField("sscm_status",sscm_status,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSscm_status().equals(sscm_status)) cf.add("sscm_status",this.sscm_status,sscm_status); } this.sscm_status=sscm_status;}
public void setSscm_date(String sscm_date) { sqlMaker.setField("sscm_date",sscm_date,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSscm_date().equals(sscm_date)) cf.add("sscm_date",this.sscm_date,sscm_date); } this.sscm_date=sscm_date;}
public void setSscm_nocancel_reason(String sscm_nocancel_reason) { sqlMaker.setField("sscm_nocancel_reason",sscm_nocancel_reason,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSscm_nocancel_reason().equals(sscm_nocancel_reason)) cf.add("sscm_nocancel_reason",this.sscm_nocancel_reason,sscm_nocancel_reason); } this.sscm_nocancel_reason=sscm_nocancel_reason;}
public void init(int i,ActionRequest actionRequest) throws Exception { if ( actionRequest.getFieldValue(i,"mortid") !=null ) {this.setMortid(actionRequest.getFieldValue(i,"mortid"));}
if ( actionRequest.getFieldValue(i,"loanid") !=null ) {this.setLoanid(actionRequest.getFieldValue(i,"loanid"));}
if ( actionRequest.getFieldValue(i,"mortdate") !=null ) {this.setMortdate(actionRequest.getFieldValue(i,"mortdate"));}
if ( actionRequest.getFieldValue(i,"mortecentercd") !=null ) {this.setMortecentercd(actionRequest.getFieldValue(i,"mortecentercd"));}
if ( actionRequest.getFieldValue(i,"releasecondcd") !=null ) {this.setReleasecondcd(actionRequest.getFieldValue(i,"releasecondcd"));}
if ( actionRequest.getFieldValue(i,"keepcont") !=null ) {this.setKeepcont(actionRequest.getFieldValue(i,"keepcont"));}
if ( actionRequest.getFieldValue(i,"expressno") !=null ) {this.setExpressno(actionRequest.getFieldValue(i,"expressno"));}
if ( actionRequest.getFieldValue(i,"expressendsdate") !=null ) {this.setExpressendsdate(actionRequest.getFieldValue(i,"expressendsdate"));}
if ( actionRequest.getFieldValue(i,"paperrtndate") !=null ) {this.setPaperrtndate(actionRequest.getFieldValue(i,"paperrtndate"));}
if ( actionRequest.getFieldValue(i,"expressnote") !=null ) {this.setExpressnote(actionRequest.getFieldValue(i,"expressnote"));}
if ( actionRequest.getFieldValue(i,"nomortreason") !=null ) {this.setNomortreason(actionRequest.getFieldValue(i,"nomortreason"));}
if ( actionRequest.getFieldValue(i,"sendflag") !=null ) {this.setSendflag(actionRequest.getFieldValue(i,"sendflag"));}
if ( actionRequest.getFieldValue(i,"relayflag") !=null ) {this.setRelayflag(actionRequest.getFieldValue(i,"relayflag"));}
if ( actionRequest.getFieldValue(i,"mortstatus") !=null ) {this.setMortstatus(actionRequest.getFieldValue(i,"mortstatus"));}
if ( actionRequest.getFieldValue(i,"operid") !=null ) {this.setOperid(actionRequest.getFieldValue(i,"operid"));}
if ( actionRequest.getFieldValue(i,"operdate") !=null ) {this.setOperdate(actionRequest.getFieldValue(i,"operdate"));}
if ( actionRequest.getFieldValue(i,"recversion") !=null && actionRequest.getFieldValue(i,"recversion").trim().length() > 0 ) {this.setRecversion(Integer.parseInt(actionRequest.getFieldValue(i,"recversion")));}
if ( actionRequest.getFieldValue(i,"deptid") !=null ) {this.setDeptid(actionRequest.getFieldValue(i,"deptid"));}
if ( actionRequest.getFieldValue(i,"nomortreasoncd") !=null ) {this.setNomortreasoncd(actionRequest.getFieldValue(i,"nomortreasoncd"));}
if ( actionRequest.getFieldValue(i,"rptmortdate") !=null ) {this.setRptmortdate(actionRequest.getFieldValue(i,"rptmortdate"));}
if ( actionRequest.getFieldValue(i,"chgpaperdate") !=null ) {this.setChgpaperdate(actionRequest.getFieldValue(i,"chgpaperdate"));}
if ( actionRequest.getFieldValue(i,"chgpaperreason") !=null ) {this.setChgpaperreason(actionRequest.getFieldValue(i,"chgpaperreason"));}
if ( actionRequest.getFieldValue(i,"chgpaperreasoncd") !=null ) {this.setChgpaperreasoncd(actionRequest.getFieldValue(i,"chgpaperreasoncd"));}
if ( actionRequest.getFieldValue(i,"chgpaperrtndate") !=null ) {this.setChgpaperrtndate(actionRequest.getFieldValue(i,"chgpaperrtndate"));}
if ( actionRequest.getFieldValue(i,"clrpaperdate") !=null ) {this.setClrpaperdate(actionRequest.getFieldValue(i,"clrpaperdate"));}
if ( actionRequest.getFieldValue(i,"mortexpiredate") !=null ) {this.setMortexpiredate(actionRequest.getFieldValue(i,"mortexpiredate"));}
if ( actionRequest.getFieldValue(i,"mortoverrtndate") !=null ) {this.setMortoverrtndate(actionRequest.getFieldValue(i,"mortoverrtndate"));}
if ( actionRequest.getFieldValue(i,"mortregstatus") !=null ) {this.setMortregstatus(actionRequest.getFieldValue(i,"mortregstatus"));}
if ( actionRequest.getFieldValue(i,"receiptdate") !=null ) {this.setReceiptdate(actionRequest.getFieldValue(i,"receiptdate"));}
if ( actionRequest.getFieldValue(i,"receiptid") !=null ) {this.setReceiptid(actionRequest.getFieldValue(i,"receiptid"));}
if ( actionRequest.getFieldValue(i,"boxid") !=null ) {this.setBoxid(actionRequest.getFieldValue(i,"boxid"));}
if ( actionRequest.getFieldValue(i,"expressrtndate") !=null ) {this.setExpressrtndate(actionRequest.getFieldValue(i,"expressrtndate"));}
if ( actionRequest.getFieldValue(i,"rptnomortdate") !=null ) {this.setRptnomortdate(actionRequest.getFieldValue(i,"rptnomortdate"));}
if ( actionRequest.getFieldValue(i,"documentid") !=null ) {this.setDocumentid(actionRequest.getFieldValue(i,"documentid"));}
if ( actionRequest.getFieldValue(i,"warrantcnt") !=null && actionRequest.getFieldValue(i,"warrantcnt").trim().length() > 0 ) {this.setWarrantcnt(Integer.parseInt(actionRequest.getFieldValue(i,"warrantcnt")));}
if ( actionRequest.getFieldValue(i,"clrreasoncd") !=null ) {this.setClrreasoncd(actionRequest.getFieldValue(i,"clrreasoncd"));}
if ( actionRequest.getFieldValue(i,"clrreasonremark") !=null ) {this.setClrreasonremark(actionRequest.getFieldValue(i,"clrreasonremark"));}
if ( actionRequest.getFieldValue(i,"specialbizflag") !=null ) {this.setSpecialbizflag(actionRequest.getFieldValue(i,"specialbizflag"));}
if ( actionRequest.getFieldValue(i,"specialbizoverflag") !=null ) {this.setSpecialbizoverflag(actionRequest.getFieldValue(i,"specialbizoverflag"));}
if ( actionRequest.getFieldValue(i,"specialbizremark") !=null ) {this.setSpecialbizremark(actionRequest.getFieldValue(i,"specialbizremark"));}
if ( actionRequest.getFieldValue(i,"exp_data_signin_date") !=null ) {this.setExp_data_signin_date(actionRequest.getFieldValue(i,"exp_data_signin_date"));}
if ( actionRequest.getFieldValue(i,"exp_data_signin_remark") !=null ) {this.setExp_data_signin_remark(actionRequest.getFieldValue(i,"exp_data_signin_remark"));}
if ( actionRequest.getFieldValue(i,"exp_paper_signin_date") !=null ) {this.setExp_paper_signin_date(actionRequest.getFieldValue(i,"exp_paper_signin_date"));}
if ( actionRequest.getFieldValue(i,"exp_paper_signin_remark") !=null ) {this.setExp_paper_signin_remark(actionRequest.getFieldValue(i,"exp_paper_signin_remark"));}
if ( actionRequest.getFieldValue(i,"flowsn") !=null ) {this.setFlowsn(actionRequest.getFieldValue(i,"flowsn"));}
if ( actionRequest.getFieldValue(i,"apptstatus") !=null ) {this.setApptstatus(actionRequest.getFieldValue(i,"apptstatus"));}
if ( actionRequest.getFieldValue(i,"appt_biz_code") !=null ) {this.setAppt_biz_code(actionRequest.getFieldValue(i,"appt_biz_code"));}
if ( actionRequest.getFieldValue(i,"appt_hdl_date") !=null ) {this.setAppt_hdl_date(actionRequest.getFieldValue(i,"appt_hdl_date"));}
if ( actionRequest.getFieldValue(i,"appt_hdl_time") !=null ) {this.setAppt_hdl_time(actionRequest.getFieldValue(i,"appt_hdl_time"));}
if ( actionRequest.getFieldValue(i,"appt_remark") !=null ) {this.setAppt_remark(actionRequest.getFieldValue(i,"appt_remark"));}
if ( actionRequest.getFieldValue(i,"appt_valid_flag") !=null ) {this.setAppt_valid_flag(actionRequest.getFieldValue(i,"appt_valid_flag"));}
if ( actionRequest.getFieldValue(i,"appt_over_flag") !=null ) {this.setAppt_over_flag(actionRequest.getFieldValue(i,"appt_over_flag"));}
if ( actionRequest.getFieldValue(i,"appt_confirm_result") !=null ) {this.setAppt_confirm_result(actionRequest.getFieldValue(i,"appt_confirm_result"));}
if ( actionRequest.getFieldValue(i,"appt_sendback_reason") !=null ) {this.setAppt_sendback_reason(actionRequest.getFieldValue(i,"appt_sendback_reason"));}
if ( actionRequest.getFieldValue(i,"appt_sendback_remark") !=null ) {this.setAppt_sendback_remark(actionRequest.getFieldValue(i,"appt_sendback_remark"));}
if ( actionRequest.getFieldValue(i,"appt_cnt_sendback") !=null && actionRequest.getFieldValue(i,"appt_cnt_sendback").trim().length() > 0 ) {this.setAppt_cnt_sendback(Integer.parseInt(actionRequest.getFieldValue(i,"appt_cnt_sendback")));}
if ( actionRequest.getFieldValue(i,"appt_feedback_result") !=null ) {this.setAppt_feedback_result(actionRequest.getFieldValue(i,"appt_feedback_result"));}
if ( actionRequest.getFieldValue(i,"appt_feedback_remark") !=null ) {this.setAppt_feedback_remark(actionRequest.getFieldValue(i,"appt_feedback_remark"));}
if ( actionRequest.getFieldValue(i,"appt_date_apply") !=null ) {this.setAppt_date_apply(actionRequest.getFieldValue(i,"appt_date_apply"));}
if ( actionRequest.getFieldValue(i,"appt_time_apply") !=null ) {this.setAppt_time_apply(actionRequest.getFieldValue(i,"appt_time_apply"));}
if ( actionRequest.getFieldValue(i,"appt_date_feedback") !=null ) {this.setAppt_date_feedback(actionRequest.getFieldValue(i,"appt_date_feedback"));}
if ( actionRequest.getFieldValue(i,"appt_time_feedback") !=null ) {this.setAppt_time_feedback(actionRequest.getFieldValue(i,"appt_time_feedback"));}
if ( actionRequest.getFieldValue(i,"appt_date_confirm") !=null ) {this.setAppt_date_confirm(actionRequest.getFieldValue(i,"appt_date_confirm"));}
if ( actionRequest.getFieldValue(i,"appt_time_confirm") !=null ) {this.setAppt_time_confirm(actionRequest.getFieldValue(i,"appt_time_confirm"));}
if ( actionRequest.getFieldValue(i,"appt_oper_apply") !=null ) {this.setAppt_oper_apply(actionRequest.getFieldValue(i,"appt_oper_apply"));}
if ( actionRequest.getFieldValue(i,"appt_oper_confirm") !=null ) {this.setAppt_oper_confirm(actionRequest.getFieldValue(i,"appt_oper_confirm"));}
if ( actionRequest.getFieldValue(i,"appt_oper_feedback") !=null ) {this.setAppt_oper_feedback(actionRequest.getFieldValue(i,"appt_oper_feedback"));}
if ( actionRequest.getFieldValue(i,"sscm_status") !=null ) {this.setSscm_status(actionRequest.getFieldValue(i,"sscm_status"));}
if ( actionRequest.getFieldValue(i,"sscm_date") !=null ) {this.setSscm_date(actionRequest.getFieldValue(i,"sscm_date"));}
if ( actionRequest.getFieldValue(i,"sscm_nocancel_reason") !=null ) {this.setSscm_nocancel_reason(actionRequest.getFieldValue(i,"sscm_nocancel_reason"));}
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { LNMORTINFO obj = (LNMORTINFO)super.clone();obj.setMortid(obj.mortid);
obj.setLoanid(obj.loanid);
obj.setMortdate(obj.mortdate);
obj.setMortecentercd(obj.mortecentercd);
obj.setReleasecondcd(obj.releasecondcd);
obj.setKeepcont(obj.keepcont);
obj.setExpressno(obj.expressno);
obj.setExpressendsdate(obj.expressendsdate);
obj.setPaperrtndate(obj.paperrtndate);
obj.setExpressnote(obj.expressnote);
obj.setNomortreason(obj.nomortreason);
obj.setSendflag(obj.sendflag);
obj.setRelayflag(obj.relayflag);
obj.setMortstatus(obj.mortstatus);
obj.setOperid(obj.operid);
obj.setOperdate(obj.operdate);
obj.setRecversion(obj.recversion);
obj.setDeptid(obj.deptid);
obj.setNomortreasoncd(obj.nomortreasoncd);
obj.setRptmortdate(obj.rptmortdate);
obj.setChgpaperdate(obj.chgpaperdate);
obj.setChgpaperreason(obj.chgpaperreason);
obj.setChgpaperreasoncd(obj.chgpaperreasoncd);
obj.setChgpaperrtndate(obj.chgpaperrtndate);
obj.setClrpaperdate(obj.clrpaperdate);
obj.setMortexpiredate(obj.mortexpiredate);
obj.setMortoverrtndate(obj.mortoverrtndate);
obj.setMortregstatus(obj.mortregstatus);
obj.setReceiptdate(obj.receiptdate);
obj.setReceiptid(obj.receiptid);
obj.setBoxid(obj.boxid);
obj.setExpressrtndate(obj.expressrtndate);
obj.setRptnomortdate(obj.rptnomortdate);
obj.setDocumentid(obj.documentid);
obj.setWarrantcnt(obj.warrantcnt);
obj.setClrreasoncd(obj.clrreasoncd);
obj.setClrreasonremark(obj.clrreasonremark);
obj.setSpecialbizflag(obj.specialbizflag);
obj.setSpecialbizoverflag(obj.specialbizoverflag);
obj.setSpecialbizremark(obj.specialbizremark);
obj.setExp_data_signin_date(obj.exp_data_signin_date);
obj.setExp_data_signin_remark(obj.exp_data_signin_remark);
obj.setExp_paper_signin_date(obj.exp_paper_signin_date);
obj.setExp_paper_signin_remark(obj.exp_paper_signin_remark);
obj.setFlowsn(obj.flowsn);
obj.setApptstatus(obj.apptstatus);
obj.setAppt_biz_code(obj.appt_biz_code);
obj.setAppt_hdl_date(obj.appt_hdl_date);
obj.setAppt_hdl_time(obj.appt_hdl_time);
obj.setAppt_remark(obj.appt_remark);
obj.setAppt_valid_flag(obj.appt_valid_flag);
obj.setAppt_over_flag(obj.appt_over_flag);
obj.setAppt_confirm_result(obj.appt_confirm_result);
obj.setAppt_sendback_reason(obj.appt_sendback_reason);
obj.setAppt_sendback_remark(obj.appt_sendback_remark);
obj.setAppt_cnt_sendback(obj.appt_cnt_sendback);
obj.setAppt_feedback_result(obj.appt_feedback_result);
obj.setAppt_feedback_remark(obj.appt_feedback_remark);
obj.setAppt_date_apply(obj.appt_date_apply);
obj.setAppt_time_apply(obj.appt_time_apply);
obj.setAppt_date_feedback(obj.appt_date_feedback);
obj.setAppt_time_feedback(obj.appt_time_feedback);
obj.setAppt_date_confirm(obj.appt_date_confirm);
obj.setAppt_time_confirm(obj.appt_time_confirm);
obj.setAppt_oper_apply(obj.appt_oper_apply);
obj.setAppt_oper_confirm(obj.appt_oper_confirm);
obj.setAppt_oper_feedback(obj.appt_oper_feedback);
obj.setSscm_status(obj.sscm_status);
obj.setSscm_date(obj.sscm_date);
obj.setSscm_nocancel_reason(obj.sscm_nocancel_reason);
return obj;}}