package com.ccb.dao;
import java.util.*;
import pub.platform.db.*;
import pub.platform.utils.*;
import pub.platform.db.AbstractBasicBean;
public class LNPROMMGRINFO extends AbstractBasicBean implements Cloneable {
     public static List find(String sSqlWhere) {           return new LNPROMMGRINFO().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere) {           return new LNPROMMGRINFO().findAndLockByWhere(sSqlWhere);      }       public static LNPROMMGRINFO findFirst(String sSqlWhere) {           return (LNPROMMGRINFO)new LNPROMMGRINFO().findFirstByWhere(sSqlWhere);      }       public static LNPROMMGRINFO findFirstAndLock(String sSqlWhere) {           return (LNPROMMGRINFO)new LNPROMMGRINFO().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) {           return new LNPROMMGRINFO().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease) {           LNPROMMGRINFO bean = new LNPROMMGRINFO();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) {           LNPROMMGRINFO bean = new LNPROMMGRINFO();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static LNPROMMGRINFO findFirst(String sSqlWhere,boolean isAutoRelease) {           LNPROMMGRINFO bean = new LNPROMMGRINFO();           bean.setAutoRelease(isAutoRelease);           return (LNPROMMGRINFO)bean.findFirstByWhere(sSqlWhere);      }       public static LNPROMMGRINFO findFirstAndLock(String sSqlWhere,boolean isAutoRelease) {           LNPROMMGRINFO bean = new LNPROMMGRINFO();           bean.setAutoRelease(isAutoRelease);           return (LNPROMMGRINFO)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease) {           LNPROMMGRINFO bean = new LNPROMMGRINFO();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      }      public static List findByRow(String sSqlWhere,int row) {           return new LNPROMMGRINFO().findByWhereByRow(sSqlWhere,row);      } String deptid;
String prommgr_id;
String prommgr_name;
public static final String TABLENAME ="ln_prommgrinfo";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
public void addObject(List list,RecordSet rs) {
LNPROMMGRINFO abb = new LNPROMMGRINFO();
abb.deptid=rs.getString("deptid");abb.setKeyValue("DEPTID",""+abb.getDeptid());
abb.prommgr_id=rs.getString("prommgr_id");abb.setKeyValue("PROMMGR_ID",""+abb.getPrommgr_id());
abb.prommgr_name=rs.getString("prommgr_name");abb.setKeyValue("PROMMGR_NAME",""+abb.getPrommgr_name());
list.add(abb);
abb.operate_mode = "edit";
}public String getDeptid() { if ( this.deptid == null ) return ""; return this.deptid;}
public String getPrommgr_id() { if ( this.prommgr_id == null ) return ""; return this.prommgr_id;}
public String getPrommgr_name() { if ( this.prommgr_name == null ) return ""; return this.prommgr_name;}
public void setDeptid(String deptid) { sqlMaker.setField("deptid",deptid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getDeptid().equals(deptid)) cf.add("deptid",this.deptid,deptid); } this.deptid=deptid;}
public void setPrommgr_id(String prommgr_id) { sqlMaker.setField("prommgr_id",prommgr_id,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getPrommgr_id().equals(prommgr_id)) cf.add("prommgr_id",this.prommgr_id,prommgr_id); } this.prommgr_id=prommgr_id;}
public void setPrommgr_name(String prommgr_name) { sqlMaker.setField("prommgr_name",prommgr_name,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getPrommgr_name().equals(prommgr_name)) cf.add("prommgr_name",this.prommgr_name,prommgr_name); } this.prommgr_name=prommgr_name;}
public void init(int i,ActionRequest actionRequest) throws Exception { if ( actionRequest.getFieldValue(i,"deptid") !=null ) {this.setDeptid(actionRequest.getFieldValue(i,"deptid"));}
if ( actionRequest.getFieldValue(i,"prommgr_id") !=null ) {this.setPrommgr_id(actionRequest.getFieldValue(i,"prommgr_id"));}
if ( actionRequest.getFieldValue(i,"prommgr_name") !=null ) {this.setPrommgr_name(actionRequest.getFieldValue(i,"prommgr_name"));}
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { LNPROMMGRINFO obj = (LNPROMMGRINFO)super.clone();obj.setDeptid(obj.deptid);
obj.setPrommgr_id(obj.prommgr_id);
obj.setPrommgr_name(obj.prommgr_name);
return obj;}}