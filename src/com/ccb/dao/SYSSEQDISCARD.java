package com.ccb.dao;
import java.util.*;
import pub.platform.db.*;
import pub.platform.utils.*;
import pub.platform.db.AbstractBasicBean;
public class SYSSEQDISCARD extends AbstractBasicBean implements Cloneable {
     public static List find(String sSqlWhere) {           return new SYSSEQDISCARD().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere) {           return new SYSSEQDISCARD().findAndLockByWhere(sSqlWhere);      }       public static SYSSEQDISCARD findFirst(String sSqlWhere) {           return (SYSSEQDISCARD)new SYSSEQDISCARD().findFirstByWhere(sSqlWhere);      }       public static SYSSEQDISCARD findFirstAndLock(String sSqlWhere) {           return (SYSSEQDISCARD)new SYSSEQDISCARD().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) {           return new SYSSEQDISCARD().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease) {           SYSSEQDISCARD bean = new SYSSEQDISCARD();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) {           SYSSEQDISCARD bean = new SYSSEQDISCARD();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static SYSSEQDISCARD findFirst(String sSqlWhere,boolean isAutoRelease) {           SYSSEQDISCARD bean = new SYSSEQDISCARD();           bean.setAutoRelease(isAutoRelease);           return (SYSSEQDISCARD)bean.findFirstByWhere(sSqlWhere);      }       public static SYSSEQDISCARD findFirstAndLock(String sSqlWhere,boolean isAutoRelease) {           SYSSEQDISCARD bean = new SYSSEQDISCARD();           bean.setAutoRelease(isAutoRelease);           return (SYSSEQDISCARD)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease) {           SYSSEQDISCARD bean = new SYSSEQDISCARD();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      }      public static List findByRow(String sSqlWhere,int row) {           return new SYSSEQDISCARD().findByWhereByRow(sSqlWhere,row);      } String bhlx;
String oseqno;
String nseqno;
int useflg;
String usedate;
String discardno;
String inoperid;
String indate;
String dotype;
String useoperid;
public static final String TABLENAME ="sys_seq_discard";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
public void addObject(List list,RecordSet rs) {
SYSSEQDISCARD abb = new SYSSEQDISCARD();
abb.bhlx=rs.getString("bhlx");abb.setKeyValue("BHLX",""+abb.getBhlx());
abb.oseqno=rs.getString("oseqno");abb.setKeyValue("OSEQNO",""+abb.getOseqno());
abb.nseqno=rs.getString("nseqno");abb.setKeyValue("NSEQNO",""+abb.getNseqno());
abb.useflg=rs.getInt("useflg");abb.setKeyValue("USEFLG",""+abb.getUseflg());
abb.usedate=rs.getTimeString("usedate");abb.setKeyValue("USEDATE",""+abb.getUsedate());
abb.discardno=rs.getString("discardno");abb.setKeyValue("DISCARDNO",""+abb.getDiscardno());
abb.inoperid=rs.getString("inoperid");abb.setKeyValue("INOPERID",""+abb.getInoperid());
abb.indate=rs.getTimeString("indate");abb.setKeyValue("INDATE",""+abb.getIndate());
abb.dotype=rs.getString("dotype");abb.setKeyValue("DOTYPE",""+abb.getDotype());
abb.useoperid=rs.getString("useoperid");abb.setKeyValue("USEOPERID",""+abb.getUseoperid());
list.add(abb);
abb.operate_mode = "edit";
}public String getBhlx() { if ( this.bhlx == null ) return ""; return this.bhlx;}
public String getOseqno() { if ( this.oseqno == null ) return ""; return this.oseqno;}
public String getNseqno() { if ( this.nseqno == null ) return ""; return this.nseqno;}
public int getUseflg() { return this.useflg;}
public String getUsedate() {  if ( this.usedate == null ) { return ""; } else { return this.usedate.trim().split(" ")[0];} }public String getUsedateTime() {  if ( this.usedate == null ) return ""; return this.usedate.split("\\.")[0];}
public String getDiscardno() { if ( this.discardno == null ) return ""; return this.discardno;}
public String getInoperid() { if ( this.inoperid == null ) return ""; return this.inoperid;}
public String getIndate() {  if ( this.indate == null ) { return ""; } else { return this.indate.trim().split(" ")[0];} }public String getIndateTime() {  if ( this.indate == null ) return ""; return this.indate.split("\\.")[0];}
public String getDotype() { if ( this.dotype == null ) return ""; return this.dotype;}
public String getUseoperid() { if ( this.useoperid == null ) return ""; return this.useoperid;}
public void setBhlx(String bhlx) { sqlMaker.setField("bhlx",bhlx,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getBhlx().equals(bhlx)) cf.add("bhlx",this.bhlx,bhlx); } this.bhlx=bhlx;}
public void setOseqno(String oseqno) { sqlMaker.setField("oseqno",oseqno,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getOseqno().equals(oseqno)) cf.add("oseqno",this.oseqno,oseqno); } this.oseqno=oseqno;}
public void setNseqno(String nseqno) { sqlMaker.setField("nseqno",nseqno,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getNseqno().equals(nseqno)) cf.add("nseqno",this.nseqno,nseqno); } this.nseqno=nseqno;}
public void setUseflg(int useflg) { sqlMaker.setField("useflg",""+useflg,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getUseflg()!=useflg) cf.add("useflg",this.useflg+"",useflg+""); } this.useflg=useflg;}
public void setUsedate(String usedate) { sqlMaker.setField("usedate",usedate,Field.DATE); if (this.operate_mode.equals("edit")) { if (!this.getUsedate().equals(usedate)) cf.add("usedate",this.usedate,usedate); } this.usedate=usedate;}
public void setDiscardno(String discardno) { sqlMaker.setField("discardno",discardno,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getDiscardno().equals(discardno)) cf.add("discardno",this.discardno,discardno); } this.discardno=discardno;}
public void setInoperid(String inoperid) { sqlMaker.setField("inoperid",inoperid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getInoperid().equals(inoperid)) cf.add("inoperid",this.inoperid,inoperid); } this.inoperid=inoperid;}
public void setIndate(String indate) { sqlMaker.setField("indate",indate,Field.DATE); if (this.operate_mode.equals("edit")) { if (!this.getIndate().equals(indate)) cf.add("indate",this.indate,indate); } this.indate=indate;}
public void setDotype(String dotype) { sqlMaker.setField("dotype",dotype,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getDotype().equals(dotype)) cf.add("dotype",this.dotype,dotype); } this.dotype=dotype;}
public void setUseoperid(String useoperid) { sqlMaker.setField("useoperid",useoperid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getUseoperid().equals(useoperid)) cf.add("useoperid",this.useoperid,useoperid); } this.useoperid=useoperid;}
public void init(int i,ActionRequest actionRequest) throws Exception { if ( actionRequest.getFieldValue(i,"bhlx") !=null ) {this.setBhlx(actionRequest.getFieldValue(i,"bhlx"));}
if ( actionRequest.getFieldValue(i,"oseqno") !=null ) {this.setOseqno(actionRequest.getFieldValue(i,"oseqno"));}
if ( actionRequest.getFieldValue(i,"nseqno") !=null ) {this.setNseqno(actionRequest.getFieldValue(i,"nseqno"));}
if ( actionRequest.getFieldValue(i,"useflg") !=null && actionRequest.getFieldValue(i,"useflg").trim().length() > 0 ) {this.setUseflg(Integer.parseInt(actionRequest.getFieldValue(i,"useflg")));}
if ( actionRequest.getFieldValue(i,"usedate") !=null ) {this.setUsedate(actionRequest.getFieldValue(i,"usedate"));}
if ( actionRequest.getFieldValue(i,"discardno") !=null ) {this.setDiscardno(actionRequest.getFieldValue(i,"discardno"));}
if ( actionRequest.getFieldValue(i,"inoperid") !=null ) {this.setInoperid(actionRequest.getFieldValue(i,"inoperid"));}
if ( actionRequest.getFieldValue(i,"indate") !=null ) {this.setIndate(actionRequest.getFieldValue(i,"indate"));}
if ( actionRequest.getFieldValue(i,"dotype") !=null ) {this.setDotype(actionRequest.getFieldValue(i,"dotype"));}
if ( actionRequest.getFieldValue(i,"useoperid") !=null ) {this.setUseoperid(actionRequest.getFieldValue(i,"useoperid"));}
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { SYSSEQDISCARD obj = (SYSSEQDISCARD)super.clone();obj.setBhlx(obj.bhlx);
obj.setOseqno(obj.oseqno);
obj.setNseqno(obj.nseqno);
obj.setUseflg(obj.useflg);
obj.setUsedate(obj.usedate);
obj.setDiscardno(obj.discardno);
obj.setInoperid(obj.inoperid);
obj.setIndate(obj.indate);
obj.setDotype(obj.dotype);
obj.setUseoperid(obj.useoperid);
return obj;}}