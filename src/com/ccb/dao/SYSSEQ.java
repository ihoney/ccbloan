package com.ccb.dao;
import java.util.*;
import pub.platform.db.*;
import pub.platform.utils.*;
import pub.platform.db.AbstractBasicBean;
public class SYSSEQ extends AbstractBasicBean implements Cloneable {
     public static List find(String sSqlWhere) {           return new SYSSEQ().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere) {           return new SYSSEQ().findAndLockByWhere(sSqlWhere);      }       public static SYSSEQ findFirst(String sSqlWhere) {           return (SYSSEQ)new SYSSEQ().findFirstByWhere(sSqlWhere);      }       public static SYSSEQ findFirstAndLock(String sSqlWhere) {           return (SYSSEQ)new SYSSEQ().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) {           return new SYSSEQ().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease) {           SYSSEQ bean = new SYSSEQ();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) {           SYSSEQ bean = new SYSSEQ();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static SYSSEQ findFirst(String sSqlWhere,boolean isAutoRelease) {           SYSSEQ bean = new SYSSEQ();           bean.setAutoRelease(isAutoRelease);           return (SYSSEQ)bean.findFirstByWhere(sSqlWhere);      }       public static SYSSEQ findFirstAndLock(String sSqlWhere,boolean isAutoRelease) {           SYSSEQ bean = new SYSSEQ();           bean.setAutoRelease(isAutoRelease);           return (SYSSEQ)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease) {           SYSSEQ bean = new SYSSEQ();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      }      public static List findByRow(String sSqlWhere,int row) {           return new SYSSEQ().findByWhereByRow(sSqlWhere,row);      } String bhlx;
int qshh;
int jsbh;
int dqbh;
int bhws;
String rq;
public static final String TABLENAME ="sys_seq";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
public void addObject(List list,RecordSet rs) {
SYSSEQ abb = new SYSSEQ();
abb.bhlx=rs.getString("bhlx");abb.setKeyValue("BHLX",""+abb.getBhlx());
abb.qshh=rs.getInt("qshh");abb.setKeyValue("QSHH",""+abb.getQshh());
abb.jsbh=rs.getInt("jsbh");abb.setKeyValue("JSBH",""+abb.getJsbh());
abb.dqbh=rs.getInt("dqbh");abb.setKeyValue("DQBH",""+abb.getDqbh());
abb.bhws=rs.getInt("bhws");abb.setKeyValue("BHWS",""+abb.getBhws());
abb.rq=rs.getTimeString("rq");abb.setKeyValue("RQ",""+abb.getRq());
list.add(abb);
abb.operate_mode = "edit";
}public String getBhlx() { if ( this.bhlx == null ) return ""; return this.bhlx;}
public int getQshh() { return this.qshh;}
public int getJsbh() { return this.jsbh;}
public int getDqbh() { return this.dqbh;}
public int getBhws() { return this.bhws;}
public String getRq() {  if ( this.rq == null ) { return ""; } else { return this.rq.trim().split(" ")[0];} }public String getRqTime() {  if ( this.rq == null ) return ""; return this.rq.split("\\.")[0];}
public void setBhlx(String bhlx) { sqlMaker.setField("bhlx",bhlx,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getBhlx().equals(bhlx)) cf.add("bhlx",this.bhlx,bhlx); } this.bhlx=bhlx;}
public void setQshh(int qshh) { sqlMaker.setField("qshh",""+qshh,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getQshh()!=qshh) cf.add("qshh",this.qshh+"",qshh+""); } this.qshh=qshh;}
public void setJsbh(int jsbh) { sqlMaker.setField("jsbh",""+jsbh,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getJsbh()!=jsbh) cf.add("jsbh",this.jsbh+"",jsbh+""); } this.jsbh=jsbh;}
public void setDqbh(int dqbh) { sqlMaker.setField("dqbh",""+dqbh,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getDqbh()!=dqbh) cf.add("dqbh",this.dqbh+"",dqbh+""); } this.dqbh=dqbh;}
public void setBhws(int bhws) { sqlMaker.setField("bhws",""+bhws,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getBhws()!=bhws) cf.add("bhws",this.bhws+"",bhws+""); } this.bhws=bhws;}
public void setRq(String rq) { sqlMaker.setField("rq",rq,Field.DATE); if (this.operate_mode.equals("edit")) { if (!this.getRq().equals(rq)) cf.add("rq",this.rq,rq); } this.rq=rq;}
public void init(int i,ActionRequest actionRequest) throws Exception { if ( actionRequest.getFieldValue(i,"bhlx") !=null ) {this.setBhlx(actionRequest.getFieldValue(i,"bhlx"));}
if ( actionRequest.getFieldValue(i,"qshh") !=null && actionRequest.getFieldValue(i,"qshh").trim().length() > 0 ) {this.setQshh(Integer.parseInt(actionRequest.getFieldValue(i,"qshh")));}
if ( actionRequest.getFieldValue(i,"jsbh") !=null && actionRequest.getFieldValue(i,"jsbh").trim().length() > 0 ) {this.setJsbh(Integer.parseInt(actionRequest.getFieldValue(i,"jsbh")));}
if ( actionRequest.getFieldValue(i,"dqbh") !=null && actionRequest.getFieldValue(i,"dqbh").trim().length() > 0 ) {this.setDqbh(Integer.parseInt(actionRequest.getFieldValue(i,"dqbh")));}
if ( actionRequest.getFieldValue(i,"bhws") !=null && actionRequest.getFieldValue(i,"bhws").trim().length() > 0 ) {this.setBhws(Integer.parseInt(actionRequest.getFieldValue(i,"bhws")));}
if ( actionRequest.getFieldValue(i,"rq") !=null ) {this.setRq(actionRequest.getFieldValue(i,"rq"));}
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { SYSSEQ obj = (SYSSEQ)super.clone();obj.setBhlx(obj.bhlx);
obj.setQshh(obj.qshh);
obj.setJsbh(obj.jsbh);
obj.setDqbh(obj.dqbh);
obj.setBhws(obj.bhws);
obj.setRq(obj.rq);
return obj;}}