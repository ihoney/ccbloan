package com.ccb.dao;
import java.util.*;
import pub.platform.db.*;
import pub.platform.utils.*;
import pub.platform.db.AbstractBasicBean;
public class LNMORTAPPT extends AbstractBasicBean implements Cloneable {
     public static List find(String sSqlWhere) {           return new LNMORTAPPT().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere) {           return new LNMORTAPPT().findAndLockByWhere(sSqlWhere);      }       public static LNMORTAPPT findFirst(String sSqlWhere) {           return (LNMORTAPPT)new LNMORTAPPT().findFirstByWhere(sSqlWhere);      }       public static LNMORTAPPT findFirstAndLock(String sSqlWhere) {           return (LNMORTAPPT)new LNMORTAPPT().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) {           return new LNMORTAPPT().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease) {           LNMORTAPPT bean = new LNMORTAPPT();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) {           LNMORTAPPT bean = new LNMORTAPPT();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static LNMORTAPPT findFirst(String sSqlWhere,boolean isAutoRelease) {           LNMORTAPPT bean = new LNMORTAPPT();           bean.setAutoRelease(isAutoRelease);           return (LNMORTAPPT)bean.findFirstByWhere(sSqlWhere);      }       public static LNMORTAPPT findFirstAndLock(String sSqlWhere,boolean isAutoRelease) {           LNMORTAPPT bean = new LNMORTAPPT();           bean.setAutoRelease(isAutoRelease);           return (LNMORTAPPT)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease) {           LNMORTAPPT bean = new LNMORTAPPT();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      }      public static List findByRow(String sSqlWhere,int row) {           return new LNMORTAPPT().findByWhereByRow(sSqlWhere,row);      } String pkid;
String mortid;
String loanid;
String txncode;
String txn_proc_id;
String biz_code;
String biz_desc;
String reamrk;
String appt_date;
String appt_time;
String operdate;
String opertime;
String operid;
String sendback_reason;
String sendback_remark;
String feedback_result;
String feedback_remark;
String recstatus;
public static final String TABLENAME ="ln_mort_appt";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
public void addObject(List list,RecordSet rs) {
LNMORTAPPT abb = new LNMORTAPPT();
abb.pkid=rs.getString("pkid");abb.setKeyValue("PKID",""+abb.getPkid());
abb.mortid=rs.getString("mortid");abb.setKeyValue("MORTID",""+abb.getMortid());
abb.loanid=rs.getString("loanid");abb.setKeyValue("LOANID",""+abb.getLoanid());
abb.txncode=rs.getString("txncode");abb.setKeyValue("TXNCODE",""+abb.getTxncode());
abb.txn_proc_id=rs.getString("txn_proc_id");abb.setKeyValue("TXN_PROC_ID",""+abb.getTxn_proc_id());
abb.biz_code=rs.getString("biz_code");abb.setKeyValue("BIZ_CODE",""+abb.getBiz_code());
abb.biz_desc=rs.getString("biz_desc");abb.setKeyValue("BIZ_DESC",""+abb.getBiz_desc());
abb.reamrk=rs.getString("reamrk");abb.setKeyValue("REAMRK",""+abb.getReamrk());
abb.appt_date=rs.getString("appt_date");abb.setKeyValue("APPT_DATE",""+abb.getAppt_date());
abb.appt_time=rs.getString("appt_time");abb.setKeyValue("APPT_TIME",""+abb.getAppt_time());
abb.operdate=rs.getString("operdate");abb.setKeyValue("OPERDATE",""+abb.getOperdate());
abb.opertime=rs.getString("opertime");abb.setKeyValue("OPERTIME",""+abb.getOpertime());
abb.operid=rs.getString("operid");abb.setKeyValue("OPERID",""+abb.getOperid());
abb.sendback_reason=rs.getString("sendback_reason");abb.setKeyValue("SENDBACK_REASON",""+abb.getSendback_reason());
abb.sendback_remark=rs.getString("sendback_remark");abb.setKeyValue("SENDBACK_REMARK",""+abb.getSendback_remark());
abb.feedback_result=rs.getString("feedback_result");abb.setKeyValue("FEEDBACK_RESULT",""+abb.getFeedback_result());
abb.feedback_remark=rs.getString("feedback_remark");abb.setKeyValue("FEEDBACK_REMARK",""+abb.getFeedback_remark());
abb.recstatus=rs.getString("recstatus");abb.setKeyValue("RECSTATUS",""+abb.getRecstatus());
list.add(abb);
abb.operate_mode = "edit";
}public String getPkid() { if ( this.pkid == null ) return ""; return this.pkid;}
public String getMortid() { if ( this.mortid == null ) return ""; return this.mortid;}
public String getLoanid() { if ( this.loanid == null ) return ""; return this.loanid;}
public String getTxncode() { if ( this.txncode == null ) return ""; return this.txncode;}
public String getTxn_proc_id() { if ( this.txn_proc_id == null ) return ""; return this.txn_proc_id;}
public String getBiz_code() { if ( this.biz_code == null ) return ""; return this.biz_code;}
public String getBiz_desc() { if ( this.biz_desc == null ) return ""; return this.biz_desc;}
public String getReamrk() { if ( this.reamrk == null ) return ""; return this.reamrk;}
public String getAppt_date() { if ( this.appt_date == null ) return ""; return this.appt_date;}
public String getAppt_time() { if ( this.appt_time == null ) return ""; return this.appt_time;}
public String getOperdate() { if ( this.operdate == null ) return ""; return this.operdate;}
public String getOpertime() { if ( this.opertime == null ) return ""; return this.opertime;}
public String getOperid() { if ( this.operid == null ) return ""; return this.operid;}
public String getSendback_reason() { if ( this.sendback_reason == null ) return ""; return this.sendback_reason;}
public String getSendback_remark() { if ( this.sendback_remark == null ) return ""; return this.sendback_remark;}
public String getFeedback_result() { if ( this.feedback_result == null ) return ""; return this.feedback_result;}
public String getFeedback_remark() { if ( this.feedback_remark == null ) return ""; return this.feedback_remark;}
public String getRecstatus() { if ( this.recstatus == null ) return ""; return this.recstatus;}
public void setPkid(String pkid) { sqlMaker.setField("pkid",pkid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getPkid().equals(pkid)) cf.add("pkid",this.pkid,pkid); } this.pkid=pkid;}
public void setMortid(String mortid) { sqlMaker.setField("mortid",mortid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getMortid().equals(mortid)) cf.add("mortid",this.mortid,mortid); } this.mortid=mortid;}
public void setLoanid(String loanid) { sqlMaker.setField("loanid",loanid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLoanid().equals(loanid)) cf.add("loanid",this.loanid,loanid); } this.loanid=loanid;}
public void setTxncode(String txncode) { sqlMaker.setField("txncode",txncode,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getTxncode().equals(txncode)) cf.add("txncode",this.txncode,txncode); } this.txncode=txncode;}
public void setTxn_proc_id(String txn_proc_id) { sqlMaker.setField("txn_proc_id",txn_proc_id,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getTxn_proc_id().equals(txn_proc_id)) cf.add("txn_proc_id",this.txn_proc_id,txn_proc_id); } this.txn_proc_id=txn_proc_id;}
public void setBiz_code(String biz_code) { sqlMaker.setField("biz_code",biz_code,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getBiz_code().equals(biz_code)) cf.add("biz_code",this.biz_code,biz_code); } this.biz_code=biz_code;}
public void setBiz_desc(String biz_desc) { sqlMaker.setField("biz_desc",biz_desc,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getBiz_desc().equals(biz_desc)) cf.add("biz_desc",this.biz_desc,biz_desc); } this.biz_desc=biz_desc;}
public void setReamrk(String reamrk) { sqlMaker.setField("reamrk",reamrk,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getReamrk().equals(reamrk)) cf.add("reamrk",this.reamrk,reamrk); } this.reamrk=reamrk;}
public void setAppt_date(String appt_date) { sqlMaker.setField("appt_date",appt_date,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAppt_date().equals(appt_date)) cf.add("appt_date",this.appt_date,appt_date); } this.appt_date=appt_date;}
public void setAppt_time(String appt_time) { sqlMaker.setField("appt_time",appt_time,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAppt_time().equals(appt_time)) cf.add("appt_time",this.appt_time,appt_time); } this.appt_time=appt_time;}
public void setOperdate(String operdate) { sqlMaker.setField("operdate",operdate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getOperdate().equals(operdate)) cf.add("operdate",this.operdate,operdate); } this.operdate=operdate;}
public void setOpertime(String opertime) { sqlMaker.setField("opertime",opertime,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getOpertime().equals(opertime)) cf.add("opertime",this.opertime,opertime); } this.opertime=opertime;}
public void setOperid(String operid) { sqlMaker.setField("operid",operid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getOperid().equals(operid)) cf.add("operid",this.operid,operid); } this.operid=operid;}
public void setSendback_reason(String sendback_reason) { sqlMaker.setField("sendback_reason",sendback_reason,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSendback_reason().equals(sendback_reason)) cf.add("sendback_reason",this.sendback_reason,sendback_reason); } this.sendback_reason=sendback_reason;}
public void setSendback_remark(String sendback_remark) { sqlMaker.setField("sendback_remark",sendback_remark,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSendback_remark().equals(sendback_remark)) cf.add("sendback_remark",this.sendback_remark,sendback_remark); } this.sendback_remark=sendback_remark;}
public void setFeedback_result(String feedback_result) { sqlMaker.setField("feedback_result",feedback_result,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getFeedback_result().equals(feedback_result)) cf.add("feedback_result",this.feedback_result,feedback_result); } this.feedback_result=feedback_result;}
public void setFeedback_remark(String feedback_remark) { sqlMaker.setField("feedback_remark",feedback_remark,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getFeedback_remark().equals(feedback_remark)) cf.add("feedback_remark",this.feedback_remark,feedback_remark); } this.feedback_remark=feedback_remark;}
public void setRecstatus(String recstatus) { sqlMaker.setField("recstatus",recstatus,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRecstatus().equals(recstatus)) cf.add("recstatus",this.recstatus,recstatus); } this.recstatus=recstatus;}
public void init(int i,ActionRequest actionRequest) throws Exception { if ( actionRequest.getFieldValue(i,"pkid") !=null ) {this.setPkid(actionRequest.getFieldValue(i,"pkid"));}
if ( actionRequest.getFieldValue(i,"mortid") !=null ) {this.setMortid(actionRequest.getFieldValue(i,"mortid"));}
if ( actionRequest.getFieldValue(i,"loanid") !=null ) {this.setLoanid(actionRequest.getFieldValue(i,"loanid"));}
if ( actionRequest.getFieldValue(i,"txncode") !=null ) {this.setTxncode(actionRequest.getFieldValue(i,"txncode"));}
if ( actionRequest.getFieldValue(i,"txn_proc_id") !=null ) {this.setTxn_proc_id(actionRequest.getFieldValue(i,"txn_proc_id"));}
if ( actionRequest.getFieldValue(i,"biz_code") !=null ) {this.setBiz_code(actionRequest.getFieldValue(i,"biz_code"));}
if ( actionRequest.getFieldValue(i,"biz_desc") !=null ) {this.setBiz_desc(actionRequest.getFieldValue(i,"biz_desc"));}
if ( actionRequest.getFieldValue(i,"reamrk") !=null ) {this.setReamrk(actionRequest.getFieldValue(i,"reamrk"));}
if ( actionRequest.getFieldValue(i,"appt_date") !=null ) {this.setAppt_date(actionRequest.getFieldValue(i,"appt_date"));}
if ( actionRequest.getFieldValue(i,"appt_time") !=null ) {this.setAppt_time(actionRequest.getFieldValue(i,"appt_time"));}
if ( actionRequest.getFieldValue(i,"operdate") !=null ) {this.setOperdate(actionRequest.getFieldValue(i,"operdate"));}
if ( actionRequest.getFieldValue(i,"opertime") !=null ) {this.setOpertime(actionRequest.getFieldValue(i,"opertime"));}
if ( actionRequest.getFieldValue(i,"operid") !=null ) {this.setOperid(actionRequest.getFieldValue(i,"operid"));}
if ( actionRequest.getFieldValue(i,"sendback_reason") !=null ) {this.setSendback_reason(actionRequest.getFieldValue(i,"sendback_reason"));}
if ( actionRequest.getFieldValue(i,"sendback_remark") !=null ) {this.setSendback_remark(actionRequest.getFieldValue(i,"sendback_remark"));}
if ( actionRequest.getFieldValue(i,"feedback_result") !=null ) {this.setFeedback_result(actionRequest.getFieldValue(i,"feedback_result"));}
if ( actionRequest.getFieldValue(i,"feedback_remark") !=null ) {this.setFeedback_remark(actionRequest.getFieldValue(i,"feedback_remark"));}
if ( actionRequest.getFieldValue(i,"recstatus") !=null ) {this.setRecstatus(actionRequest.getFieldValue(i,"recstatus"));}
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { LNMORTAPPT obj = (LNMORTAPPT)super.clone();obj.setPkid(obj.pkid);
obj.setMortid(obj.mortid);
obj.setLoanid(obj.loanid);
obj.setTxncode(obj.txncode);
obj.setTxn_proc_id(obj.txn_proc_id);
obj.setBiz_code(obj.biz_code);
obj.setBiz_desc(obj.biz_desc);
obj.setReamrk(obj.reamrk);
obj.setAppt_date(obj.appt_date);
obj.setAppt_time(obj.appt_time);
obj.setOperdate(obj.operdate);
obj.setOpertime(obj.opertime);
obj.setOperid(obj.operid);
obj.setSendback_reason(obj.sendback_reason);
obj.setSendback_remark(obj.sendback_remark);
obj.setFeedback_result(obj.feedback_result);
obj.setFeedback_remark(obj.feedback_remark);
obj.setRecstatus(obj.recstatus);
return obj;}}