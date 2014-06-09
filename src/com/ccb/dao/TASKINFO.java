package com.ccb.dao;
import java.util.*;
import pub.platform.db.*;
import pub.platform.utils.*;
import pub.platform.db.AbstractBasicBean;
public class TASKINFO extends AbstractBasicBean implements Cloneable {
     public static List find(String sSqlWhere) {           return new TASKINFO().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere) {           return new TASKINFO().findAndLockByWhere(sSqlWhere);      }       public static TASKINFO findFirst(String sSqlWhere) {           return (TASKINFO)new TASKINFO().findFirstByWhere(sSqlWhere);      }       public static TASKINFO findFirstAndLock(String sSqlWhere) {           return (TASKINFO)new TASKINFO().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) {           return new TASKINFO().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease) {           TASKINFO bean = new TASKINFO();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) {           TASKINFO bean = new TASKINFO();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static TASKINFO findFirst(String sSqlWhere,boolean isAutoRelease) {           TASKINFO bean = new TASKINFO();           bean.setAutoRelease(isAutoRelease);           return (TASKINFO)bean.findFirstByWhere(sSqlWhere);      }       public static TASKINFO findFirstAndLock(String sSqlWhere,boolean isAutoRelease) {           TASKINFO bean = new TASKINFO();           bean.setAutoRelease(isAutoRelease);           return (TASKINFO)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease) {           TASKINFO bean = new TASKINFO();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      }      public static List findByRow(String sSqlWhere,int row) {           return new TASKINFO().findByWhereByRow(sSqlWhere,row);      } String nbxh;
String taskcd;
public static final String TABLENAME ="taskinfo";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
public void addObject(List list,RecordSet rs) {
TASKINFO abb = new TASKINFO();
abb.nbxh=rs.getString("nbxh");abb.setKeyValue("NBXH",""+abb.getNbxh());
abb.taskcd=rs.getString("taskcd");abb.setKeyValue("TASKCD",""+abb.getTaskcd());
list.add(abb);
abb.operate_mode = "edit";
}public String getNbxh() { if ( this.nbxh == null ) return ""; return this.nbxh;}
public String getTaskcd() { if ( this.taskcd == null ) return ""; return this.taskcd;}
public void setNbxh(String nbxh) { sqlMaker.setField("nbxh",nbxh,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getNbxh().equals(nbxh)) cf.add("nbxh",this.nbxh,nbxh); } this.nbxh=nbxh;}
public void setTaskcd(String taskcd) { sqlMaker.setField("taskcd",taskcd,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getTaskcd().equals(taskcd)) cf.add("taskcd",this.taskcd,taskcd); } this.taskcd=taskcd;}
public void init(int i,ActionRequest actionRequest) throws Exception { if ( actionRequest.getFieldValue(i,"nbxh") !=null ) {this.setNbxh(actionRequest.getFieldValue(i,"nbxh"));}
if ( actionRequest.getFieldValue(i,"taskcd") !=null ) {this.setTaskcd(actionRequest.getFieldValue(i,"taskcd"));}
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { TASKINFO obj = (TASKINFO)super.clone();obj.setNbxh(obj.nbxh);
obj.setTaskcd(obj.taskcd);
return obj;}}