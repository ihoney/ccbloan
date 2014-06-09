package com.ccb.dao;

import pub.platform.db.AbstractBasicBean;
import pub.platform.db.RecordSet;
import pub.platform.utils.ActionRequest;
import pub.platform.utils.ChangeFileds;
import pub.platform.utils.Field;

import java.util.List;

public class LNCREATLOG extends AbstractBasicBean implements Cloneable {
     public static List find(String sSqlWhere) {           return new LNCREATLOG().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere) {           return new LNCREATLOG().findAndLockByWhere(sSqlWhere);      }       public static LNCREATLOG findFirst(String sSqlWhere) {           return (LNCREATLOG)new LNCREATLOG().findFirstByWhere(sSqlWhere);      }       public static LNCREATLOG findFirstAndLock(String sSqlWhere) {           return (LNCREATLOG)new LNCREATLOG().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) {           return new LNCREATLOG().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease) {           LNCREATLOG bean = new LNCREATLOG();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) {           LNCREATLOG bean = new LNCREATLOG();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static LNCREATLOG findFirst(String sSqlWhere,boolean isAutoRelease) {           LNCREATLOG bean = new LNCREATLOG();           bean.setAutoRelease(isAutoRelease);           return (LNCREATLOG)bean.findFirstByWhere(sSqlWhere);      }       public static LNCREATLOG findFirstAndLock(String sSqlWhere,boolean isAutoRelease) {           LNCREATLOG bean = new LNCREATLOG();           bean.setAutoRelease(isAutoRelease);           return (LNCREATLOG)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease) {           LNCREATLOG bean = new LNCREATLOG();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      }      public static List findByRow(String sSqlWhere,int row) {           return new LNCREATLOG().findByWhereByRow(sSqlWhere,row);      } String creditratingno;
String opername;
String opertime;
String olddate;
String newdate;
String creattype;
public static final String TABLENAME ="ln_creatlog";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
public void addObject(List list,RecordSet rs) {
LNCREATLOG abb = new LNCREATLOG();
abb.creditratingno=rs.getString("creditratingno");abb.setKeyValue("CREDITRATINGNO",""+abb.getCreditratingno());
abb.opername=rs.getString("opername");abb.setKeyValue("OPERNAME",""+abb.getOpername());
abb.opertime=rs.getTimeString("opertime");abb.setKeyValue("OPERTIME",""+abb.getOpertime());
abb.olddate=rs.getTimeString("olddate");abb.setKeyValue("OLDDATE",""+abb.getOlddate());
abb.newdate=rs.getTimeString("newdate");abb.setKeyValue("NEWDATE",""+abb.getNewdate());
abb.creattype=rs.getString("creattype");abb.setKeyValue("CREATTYPE",""+abb.getCreattype());
list.add(abb);
abb.operate_mode = "edit";
}public String getCreditratingno() { if ( this.creditratingno == null ) return ""; return this.creditratingno;}
public String getOpername() { if ( this.opername == null ) return ""; return this.opername;}
public String getOpertime() {  if ( this.opertime == null ) { return ""; } else { return this.opertime.trim().split(" ")[0];} }public String getOpertimeTime() {  if ( this.opertime == null ) return ""; return this.opertime.split("\\.")[0];}
public String getOlddate() {  if ( this.olddate == null ) { return ""; } else { return this.olddate.trim().split(" ")[0];} }public String getOlddateTime() {  if ( this.olddate == null ) return ""; return this.olddate.split("\\.")[0];}
public String getNewdate() {  if ( this.newdate == null ) { return ""; } else { return this.newdate.trim().split(" ")[0];} }public String getNewdateTime() {  if ( this.newdate == null ) return ""; return this.newdate.split("\\.")[0];}
public String getCreattype() { if ( this.creattype == null ) return ""; return this.creattype;}
public void setCreditratingno(String creditratingno) { sqlMaker.setField("creditratingno",creditratingno, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCreditratingno().equals(creditratingno)) cf.add("creditratingno",this.creditratingno,creditratingno); } this.creditratingno=creditratingno;}
public void setOpername(String opername) { sqlMaker.setField("opername",opername, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getOpername().equals(opername)) cf.add("opername",this.opername,opername); } this.opername=opername;}
public void setOpertime(String opertime) { sqlMaker.setField("opertime",opertime, Field.DATE); if (this.operate_mode.equals("edit")) { if (!this.getOpertime().equals(opertime)) cf.add("opertime",this.opertime,opertime); } this.opertime=opertime;}
public void setOlddate(String olddate) { sqlMaker.setField("olddate",olddate, Field.DATE); if (this.operate_mode.equals("edit")) { if (!this.getOlddate().equals(olddate)) cf.add("olddate",this.olddate,olddate); } this.olddate=olddate;}
public void setNewdate(String newdate) { sqlMaker.setField("newdate",newdate, Field.DATE); if (this.operate_mode.equals("edit")) { if (!this.getNewdate().equals(newdate)) cf.add("newdate",this.newdate,newdate); } this.newdate=newdate;}
public void setCreattype(String creattype) { sqlMaker.setField("creattype",creattype, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCreattype().equals(creattype)) cf.add("creattype",this.creattype,creattype); } this.creattype=creattype;}
public void init(int i,ActionRequest actionRequest) throws Exception { if ( actionRequest.getFieldValue(i,"creditratingno") !=null ) {this.setCreditratingno(actionRequest.getFieldValue(i,"creditratingno"));}
if ( actionRequest.getFieldValue(i,"opername") !=null ) {this.setOpername(actionRequest.getFieldValue(i,"opername"));}
if ( actionRequest.getFieldValue(i,"opertime") !=null ) {this.setOpertime(actionRequest.getFieldValue(i,"opertime"));}
if ( actionRequest.getFieldValue(i,"olddate") !=null ) {this.setOlddate(actionRequest.getFieldValue(i,"olddate"));}
if ( actionRequest.getFieldValue(i,"newdate") !=null ) {this.setNewdate(actionRequest.getFieldValue(i,"newdate"));}
if ( actionRequest.getFieldValue(i,"creattype") !=null ) {this.setCreattype(actionRequest.getFieldValue(i,"creattype"));}
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { LNCREATLOG obj = (LNCREATLOG)super.clone();obj.setCreditratingno(obj.creditratingno);
obj.setOpername(obj.opername);
obj.setOpertime(obj.opertime);
obj.setOlddate(obj.olddate);
obj.setNewdate(obj.newdate);
obj.setCreattype(obj.creattype);
return obj;}}