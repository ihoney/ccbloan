package com.ccb.dao;

import pub.platform.db.AbstractBasicBean;
import pub.platform.db.RecordSet;
import pub.platform.utils.ActionRequest;
import pub.platform.utils.ChangeFileds;
import pub.platform.utils.Field;

import java.util.List;

public class LNPSCOREMODEL extends AbstractBasicBean implements Cloneable {
     public static List find(String sSqlWhere) {           return new LNPSCOREMODEL().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere) {           return new LNPSCOREMODEL().findAndLockByWhere(sSqlWhere);      }       public static LNPSCOREMODEL findFirst(String sSqlWhere) {           return (LNPSCOREMODEL)new LNPSCOREMODEL().findFirstByWhere(sSqlWhere);      }       public static LNPSCOREMODEL findFirstAndLock(String sSqlWhere) {           return (LNPSCOREMODEL)new LNPSCOREMODEL().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) {           return new LNPSCOREMODEL().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease) {           LNPSCOREMODEL bean = new LNPSCOREMODEL();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) {           LNPSCOREMODEL bean = new LNPSCOREMODEL();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static LNPSCOREMODEL findFirst(String sSqlWhere,boolean isAutoRelease) {           LNPSCOREMODEL bean = new LNPSCOREMODEL();           bean.setAutoRelease(isAutoRelease);           return (LNPSCOREMODEL)bean.findFirstByWhere(sSqlWhere);      }       public static LNPSCOREMODEL findFirstAndLock(String sSqlWhere,boolean isAutoRelease) {           LNPSCOREMODEL bean = new LNPSCOREMODEL();           bean.setAutoRelease(isAutoRelease);           return (LNPSCOREMODEL)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease) {           LNPSCOREMODEL bean = new LNPSCOREMODEL();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      }      public static List findByRow(String sSqlWhere,int row) {           return new LNPSCOREMODEL().findByWhereByRow(sSqlWhere,row);      } String enutype;
String enuitemvalue;
int enuminvalue;
int enumaxvalue;
int enuscore;
String enuremark;
String kid;
public static final String TABLENAME ="ln_pscoremodel";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
public void addObject(List list,RecordSet rs) {
LNPSCOREMODEL abb = new LNPSCOREMODEL();
abb.enutype=rs.getString("enutype");abb.setKeyValue("ENUTYPE",""+abb.getEnutype());
abb.enuitemvalue=rs.getString("enuitemvalue");abb.setKeyValue("ENUITEMVALUE",""+abb.getEnuitemvalue());
abb.enuminvalue=rs.getInt("enuminvalue");abb.setKeyValue("ENUMINVALUE",""+abb.getEnuminvalue());
abb.enumaxvalue=rs.getInt("enumaxvalue");abb.setKeyValue("ENUMAXVALUE",""+abb.getEnumaxvalue());
abb.enuscore=rs.getInt("enuscore");abb.setKeyValue("ENUSCORE",""+abb.getEnuscore());
abb.enuremark=rs.getString("enuremark");abb.setKeyValue("ENUREMARK",""+abb.getEnuremark());
abb.kid=rs.getString("kid");abb.setKeyValue("KID",""+abb.getKid());
list.add(abb);
abb.operate_mode = "edit";
}public String getEnutype() { if ( this.enutype == null ) return ""; return this.enutype;}
public String getEnuitemvalue() { if ( this.enuitemvalue == null ) return ""; return this.enuitemvalue;}
public int getEnuminvalue() { return this.enuminvalue;}
public int getEnumaxvalue() { return this.enumaxvalue;}
public int getEnuscore() { return this.enuscore;}
public String getEnuremark() { if ( this.enuremark == null ) return ""; return this.enuremark;}
public String getKid() { if ( this.kid == null ) return ""; return this.kid;}
public void setEnutype(String enutype) { sqlMaker.setField("enutype",enutype, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getEnutype().equals(enutype)) cf.add("enutype",this.enutype,enutype); } this.enutype=enutype;}
public void setEnuitemvalue(String enuitemvalue) { sqlMaker.setField("enuitemvalue",enuitemvalue, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getEnuitemvalue().equals(enuitemvalue)) cf.add("enuitemvalue",this.enuitemvalue,enuitemvalue); } this.enuitemvalue=enuitemvalue;}
public void setEnuminvalue(int enuminvalue) { sqlMaker.setField("enuminvalue",""+enuminvalue, Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getEnuminvalue()!=enuminvalue) cf.add("enuminvalue",this.enuminvalue+"",enuminvalue+""); } this.enuminvalue=enuminvalue;}
public void setEnumaxvalue(int enumaxvalue) { sqlMaker.setField("enumaxvalue",""+enumaxvalue, Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getEnumaxvalue()!=enumaxvalue) cf.add("enumaxvalue",this.enumaxvalue+"",enumaxvalue+""); } this.enumaxvalue=enumaxvalue;}
public void setEnuscore(int enuscore) { sqlMaker.setField("enuscore",""+enuscore, Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getEnuscore()!=enuscore) cf.add("enuscore",this.enuscore+"",enuscore+""); } this.enuscore=enuscore;}
public void setEnuremark(String enuremark) { sqlMaker.setField("enuremark",enuremark, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getEnuremark().equals(enuremark)) cf.add("enuremark",this.enuremark,enuremark); } this.enuremark=enuremark;}
public void setKid(String kid) { sqlMaker.setField("kid",kid, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getKid().equals(kid)) cf.add("kid",this.kid,kid); } this.kid=kid;}
public void init(int i,ActionRequest actionRequest) throws Exception { if ( actionRequest.getFieldValue(i,"enutype") !=null ) {this.setEnutype(actionRequest.getFieldValue(i,"enutype"));}
if ( actionRequest.getFieldValue(i,"enuitemvalue") !=null ) {this.setEnuitemvalue(actionRequest.getFieldValue(i,"enuitemvalue"));}
if ( actionRequest.getFieldValue(i,"enuminvalue") !=null && actionRequest.getFieldValue(i,"enuminvalue").trim().length() > 0 ) {this.setEnuminvalue(Integer.parseInt(actionRequest.getFieldValue(i,"enuminvalue")));}
if ( actionRequest.getFieldValue(i,"enumaxvalue") !=null && actionRequest.getFieldValue(i,"enumaxvalue").trim().length() > 0 ) {this.setEnumaxvalue(Integer.parseInt(actionRequest.getFieldValue(i,"enumaxvalue")));}
if ( actionRequest.getFieldValue(i,"enuscore") !=null && actionRequest.getFieldValue(i,"enuscore").trim().length() > 0 ) {this.setEnuscore(Integer.parseInt(actionRequest.getFieldValue(i,"enuscore")));}
if ( actionRequest.getFieldValue(i,"enuremark") !=null ) {this.setEnuremark(actionRequest.getFieldValue(i,"enuremark"));}
if ( actionRequest.getFieldValue(i,"kid") !=null ) {this.setKid(actionRequest.getFieldValue(i,"kid"));}
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { LNPSCOREMODEL obj = (LNPSCOREMODEL)super.clone();obj.setEnutype(obj.enutype);
obj.setEnuitemvalue(obj.enuitemvalue);
obj.setEnuminvalue(obj.enuminvalue);
obj.setEnumaxvalue(obj.enumaxvalue);
obj.setEnuscore(obj.enuscore);
obj.setEnuremark(obj.enuremark);
obj.setKid(obj.kid);
return obj;}}