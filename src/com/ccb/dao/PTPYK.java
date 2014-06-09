package com.ccb.dao;
import java.util.*;
import pub.platform.db.*;
import pub.platform.utils.*;
import pub.platform.db.AbstractBasicBean;
public class PTPYK extends AbstractBasicBean implements Cloneable {
     public static List find(String sSqlWhere) {           return new PTPYK().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere) {           return new PTPYK().findAndLockByWhere(sSqlWhere);      }       public static PTPYK findFirst(String sSqlWhere) {           return (PTPYK)new PTPYK().findFirstByWhere(sSqlWhere);      }       public static PTPYK findFirstAndLock(String sSqlWhere) {           return (PTPYK)new PTPYK().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) {           return new PTPYK().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease) {           PTPYK bean = new PTPYK();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) {           PTPYK bean = new PTPYK();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static PTPYK findFirst(String sSqlWhere,boolean isAutoRelease) {           PTPYK bean = new PTPYK();           bean.setAutoRelease(isAutoRelease);           return (PTPYK)bean.findFirstByWhere(sSqlWhere);      }       public static PTPYK findFirstAndLock(String sSqlWhere,boolean isAutoRelease) {           PTPYK bean = new PTPYK();           bean.setAutoRelease(isAutoRelease);           return (PTPYK)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease) {           PTPYK bean = new PTPYK();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      }      public static List findByRow(String sSqlWhere,int row) {           return new PTPYK().findByWhereByRow(sSqlWhere,row);      } String hz;
String py;
String fill1;
public static final String TABLENAME ="ptpyk";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
public void addObject(List list,RecordSet rs) {
PTPYK abb = new PTPYK();
abb.hz=rs.getString("hz");abb.setKeyValue("HZ",""+abb.getHz());
abb.py=rs.getString("py");abb.setKeyValue("PY",""+abb.getPy());
abb.fill1=rs.getString("fill1");abb.setKeyValue("FILL1",""+abb.getFill1());
list.add(abb);
abb.operate_mode = "edit";
}public String getHz() { if ( this.hz == null ) return ""; return this.hz;}
public String getPy() { if ( this.py == null ) return ""; return this.py;}
public String getFill1() { if ( this.fill1 == null ) return ""; return this.fill1;}
public void setHz(String hz) { sqlMaker.setField("hz",hz,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getHz().equals(hz)) cf.add("hz",this.hz,hz); } this.hz=hz;}
public void setPy(String py) { sqlMaker.setField("py",py,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getPy().equals(py)) cf.add("py",this.py,py); } this.py=py;}
public void setFill1(String fill1) { sqlMaker.setField("fill1",fill1,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getFill1().equals(fill1)) cf.add("fill1",this.fill1,fill1); } this.fill1=fill1;}
public void init(int i,ActionRequest actionRequest) throws Exception { if ( actionRequest.getFieldValue(i,"hz") !=null ) {this.setHz(actionRequest.getFieldValue(i,"hz"));}
if ( actionRequest.getFieldValue(i,"py") !=null ) {this.setPy(actionRequest.getFieldValue(i,"py"));}
if ( actionRequest.getFieldValue(i,"fill1") !=null ) {this.setFill1(actionRequest.getFieldValue(i,"fill1"));}
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { PTPYK obj = (PTPYK)super.clone();obj.setHz(obj.hz);
obj.setPy(obj.py);
obj.setFill1(obj.fill1);
return obj;}}