package com.ccb.dao;
import java.util.*;
import pub.platform.db.*;
import pub.platform.utils.*;
import pub.platform.db.AbstractBasicBean;
public class LNTASKINFO extends AbstractBasicBean implements Cloneable {
     public static List find(String sSqlWhere) {           return new LNTASKINFO().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere) {           return new LNTASKINFO().findAndLockByWhere(sSqlWhere);      }       public static LNTASKINFO findFirst(String sSqlWhere) {           return (LNTASKINFO)new LNTASKINFO().findFirstByWhere(sSqlWhere);      }       public static LNTASKINFO findFirstAndLock(String sSqlWhere) {           return (LNTASKINFO)new LNTASKINFO().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) {           return new LNTASKINFO().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease) {           LNTASKINFO bean = new LNTASKINFO();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) {           LNTASKINFO bean = new LNTASKINFO();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static LNTASKINFO findFirst(String sSqlWhere,boolean isAutoRelease) {           LNTASKINFO bean = new LNTASKINFO();           bean.setAutoRelease(isAutoRelease);           return (LNTASKINFO)bean.findFirstByWhere(sSqlWhere);      }       public static LNTASKINFO findFirstAndLock(String sSqlWhere,boolean isAutoRelease) {           LNTASKINFO bean = new LNTASKINFO();           bean.setAutoRelease(isAutoRelease);           return (LNTASKINFO)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease) {           LNTASKINFO bean = new LNTASKINFO();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      }      public static List findByRow(String sSqlWhere,int row) {           return new LNTASKINFO().findByWhereByRow(sSqlWhere,row);      } String taskid;
String loanrecordid;
String loan_id;
String tasktype;
String tasktime;
String bankid;
String operid;
String ipaddr;
String remarks;
public static final String TABLENAME ="ln_taskinfo";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
public void addObject(List list,RecordSet rs) {
LNTASKINFO abb = new LNTASKINFO();
abb.taskid=rs.getString("taskid");abb.setKeyValue("TASKID",""+abb.getTaskid());
abb.loanrecordid=rs.getString("loanrecordid");abb.setKeyValue("LOANRECORDID",""+abb.getLoanrecordid());
abb.loan_id=rs.getString("loan_id");abb.setKeyValue("LOAN_ID",""+abb.getLoan_id());
abb.tasktype=rs.getString("tasktype");abb.setKeyValue("TASKTYPE",""+abb.getTasktype());
abb.tasktime=rs.getTimeString("tasktime");abb.setKeyValue("TASKTIME",""+abb.getTasktime());
abb.bankid=rs.getString("bankid");abb.setKeyValue("BANKID",""+abb.getBankid());
abb.operid=rs.getString("operid");abb.setKeyValue("OPERID",""+abb.getOperid());
abb.ipaddr=rs.getString("ipaddr");abb.setKeyValue("IPADDR",""+abb.getIpaddr());
abb.remarks=rs.getString("remarks");abb.setKeyValue("REMARKS",""+abb.getRemarks());
list.add(abb);
abb.operate_mode = "edit";
}public String getTaskid() { if ( this.taskid == null ) return ""; return this.taskid;}
public String getLoanrecordid() { if ( this.loanrecordid == null ) return ""; return this.loanrecordid;}
public String getLoan_id() { if ( this.loan_id == null ) return ""; return this.loan_id;}
public String getTasktype() { if ( this.tasktype == null ) return ""; return this.tasktype;}
public String getTasktime() {  if ( this.tasktime == null ) { return ""; } else { return this.tasktime.trim().split(" ")[0];} }public String getTasktimeTime() {  if ( this.tasktime == null ) return ""; return this.tasktime.split("\\.")[0];}
public String getBankid() { if ( this.bankid == null ) return ""; return this.bankid;}
public String getOperid() { if ( this.operid == null ) return ""; return this.operid;}
public String getIpaddr() { if ( this.ipaddr == null ) return ""; return this.ipaddr;}
public String getRemarks() { if ( this.remarks == null ) return ""; return this.remarks;}
public void setTaskid(String taskid) { sqlMaker.setField("taskid",taskid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getTaskid().equals(taskid)) cf.add("taskid",this.taskid,taskid); } this.taskid=taskid;}
public void setLoanrecordid(String loanrecordid) { sqlMaker.setField("loanrecordid",loanrecordid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLoanrecordid().equals(loanrecordid)) cf.add("loanrecordid",this.loanrecordid,loanrecordid); } this.loanrecordid=loanrecordid;}
public void setLoan_id(String loan_id) { sqlMaker.setField("loan_id",loan_id,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLoan_id().equals(loan_id)) cf.add("loan_id",this.loan_id,loan_id); } this.loan_id=loan_id;}
public void setTasktype(String tasktype) { sqlMaker.setField("tasktype",tasktype,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getTasktype().equals(tasktype)) cf.add("tasktype",this.tasktype,tasktype); } this.tasktype=tasktype;}
public void setTasktime(String tasktime) { sqlMaker.setField("tasktime",tasktime,Field.DATE); if (this.operate_mode.equals("edit")) { if (!this.getTasktime().equals(tasktime)) cf.add("tasktime",this.tasktime,tasktime); } this.tasktime=tasktime;}
public void setBankid(String bankid) { sqlMaker.setField("bankid",bankid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getBankid().equals(bankid)) cf.add("bankid",this.bankid,bankid); } this.bankid=bankid;}
public void setOperid(String operid) { sqlMaker.setField("operid",operid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getOperid().equals(operid)) cf.add("operid",this.operid,operid); } this.operid=operid;}
public void setIpaddr(String ipaddr) { sqlMaker.setField("ipaddr",ipaddr,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getIpaddr().equals(ipaddr)) cf.add("ipaddr",this.ipaddr,ipaddr); } this.ipaddr=ipaddr;}
public void setRemarks(String remarks) { sqlMaker.setField("remarks",remarks,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRemarks().equals(remarks)) cf.add("remarks",this.remarks,remarks); } this.remarks=remarks;}
public void init(int i,ActionRequest actionRequest) throws Exception { if ( actionRequest.getFieldValue(i,"taskid") !=null ) {this.setTaskid(actionRequest.getFieldValue(i,"taskid"));}
if ( actionRequest.getFieldValue(i,"loanrecordid") !=null ) {this.setLoanrecordid(actionRequest.getFieldValue(i,"loanrecordid"));}
if ( actionRequest.getFieldValue(i,"loan_id") !=null ) {this.setLoan_id(actionRequest.getFieldValue(i,"loan_id"));}
if ( actionRequest.getFieldValue(i,"tasktype") !=null ) {this.setTasktype(actionRequest.getFieldValue(i,"tasktype"));}
if ( actionRequest.getFieldValue(i,"tasktime") !=null ) {this.setTasktime(actionRequest.getFieldValue(i,"tasktime"));}
if ( actionRequest.getFieldValue(i,"bankid") !=null ) {this.setBankid(actionRequest.getFieldValue(i,"bankid"));}
if ( actionRequest.getFieldValue(i,"operid") !=null ) {this.setOperid(actionRequest.getFieldValue(i,"operid"));}
if ( actionRequest.getFieldValue(i,"ipaddr") !=null ) {this.setIpaddr(actionRequest.getFieldValue(i,"ipaddr"));}
if ( actionRequest.getFieldValue(i,"remarks") !=null ) {this.setRemarks(actionRequest.getFieldValue(i,"remarks"));}
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { LNTASKINFO obj = (LNTASKINFO)super.clone();obj.setTaskid(obj.taskid);
obj.setLoanrecordid(obj.loanrecordid);
obj.setLoan_id(obj.loan_id);
obj.setTasktype(obj.tasktype);
obj.setTasktime(obj.tasktime);
obj.setBankid(obj.bankid);
obj.setOperid(obj.operid);
obj.setIpaddr(obj.ipaddr);
obj.setRemarks(obj.remarks);
return obj;}}