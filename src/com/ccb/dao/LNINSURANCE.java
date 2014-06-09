package com.ccb.dao;
import java.util.*;
import pub.platform.db.*;
import pub.platform.utils.*;
import pub.platform.db.AbstractBasicBean;
public class LNINSURANCE extends AbstractBasicBean implements Cloneable {
     public static List find(String sSqlWhere) {           return new LNINSURANCE().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere) {           return new LNINSURANCE().findAndLockByWhere(sSqlWhere);      }       public static LNINSURANCE findFirst(String sSqlWhere) {           return (LNINSURANCE)new LNINSURANCE().findFirstByWhere(sSqlWhere);      }       public static LNINSURANCE findFirstAndLock(String sSqlWhere) {           return (LNINSURANCE)new LNINSURANCE().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) {           return new LNINSURANCE().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease) {           LNINSURANCE bean = new LNINSURANCE();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) {           LNINSURANCE bean = new LNINSURANCE();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static LNINSURANCE findFirst(String sSqlWhere,boolean isAutoRelease) {           LNINSURANCE bean = new LNINSURANCE();           bean.setAutoRelease(isAutoRelease);           return (LNINSURANCE)bean.findFirstByWhere(sSqlWhere);      }       public static LNINSURANCE findFirstAndLock(String sSqlWhere,boolean isAutoRelease) {           LNINSURANCE bean = new LNINSURANCE();           bean.setAutoRelease(isAutoRelease);           return (LNINSURANCE)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease) {           LNINSURANCE bean = new LNINSURANCE();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      }      public static List findByRow(String sSqlWhere,int row) {           return new LNINSURANCE().findByWhereByRow(sSqlWhere,row);      } String mortid;
String loanid;
String insuranceid;
String documentid;
String attendflag;
String insurancests;
String paperrtndate;
String clrpaperdate;
String operid2;
String operdate;
public static final String TABLENAME ="ln_insurance";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
public void addObject(List list,RecordSet rs) {
LNINSURANCE abb = new LNINSURANCE();
abb.mortid=rs.getString("mortid");abb.setKeyValue("MORTID",""+abb.getMortid());
abb.loanid=rs.getString("loanid");abb.setKeyValue("LOANID",""+abb.getLoanid());
abb.insuranceid=rs.getString("insuranceid");abb.setKeyValue("INSURANCEID",""+abb.getInsuranceid());
abb.documentid=rs.getString("documentid");abb.setKeyValue("DOCUMENTID",""+abb.getDocumentid());
abb.attendflag=rs.getString("attendflag");abb.setKeyValue("ATTENDFLAG",""+abb.getAttendflag());
abb.insurancests=rs.getString("insurancests");abb.setKeyValue("INSURANCESTS",""+abb.getInsurancests());
abb.paperrtndate=rs.getString("paperrtndate");abb.setKeyValue("PAPERRTNDATE",""+abb.getPaperrtndate());
abb.clrpaperdate=rs.getString("clrpaperdate");abb.setKeyValue("CLRPAPERDATE",""+abb.getClrpaperdate());
abb.operid2=rs.getString("operid2");abb.setKeyValue("OPERID2",""+abb.getOperid2());
abb.operdate=rs.getTimeString("operdate");abb.setKeyValue("OPERDATE",""+abb.getOperdate());
list.add(abb);
abb.operate_mode = "edit";
}public String getMortid() { if ( this.mortid == null ) return ""; return this.mortid;}
public String getLoanid() { if ( this.loanid == null ) return ""; return this.loanid;}
public String getInsuranceid() { if ( this.insuranceid == null ) return ""; return this.insuranceid;}
public String getDocumentid() { if ( this.documentid == null ) return ""; return this.documentid;}
public String getAttendflag() { if ( this.attendflag == null ) return ""; return this.attendflag;}
public String getInsurancests() { if ( this.insurancests == null ) return ""; return this.insurancests;}
public String getPaperrtndate() { if ( this.paperrtndate == null ) return ""; return this.paperrtndate;}
public String getClrpaperdate() { if ( this.clrpaperdate == null ) return ""; return this.clrpaperdate;}
public String getOperid2() { if ( this.operid2 == null ) return ""; return this.operid2;}
public String getOperdate() {  if ( this.operdate == null ) { return ""; } else { return this.operdate.trim().split(" ")[0];} }public String getOperdateTime() {  if ( this.operdate == null ) return ""; return this.operdate.split("\\.")[0];}
public void setMortid(String mortid) { sqlMaker.setField("mortid",mortid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getMortid().equals(mortid)) cf.add("mortid",this.mortid,mortid); } this.mortid=mortid;}
public void setLoanid(String loanid) { sqlMaker.setField("loanid",loanid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLoanid().equals(loanid)) cf.add("loanid",this.loanid,loanid); } this.loanid=loanid;}
public void setInsuranceid(String insuranceid) { sqlMaker.setField("insuranceid",insuranceid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getInsuranceid().equals(insuranceid)) cf.add("insuranceid",this.insuranceid,insuranceid); } this.insuranceid=insuranceid;}
public void setDocumentid(String documentid) { sqlMaker.setField("documentid",documentid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getDocumentid().equals(documentid)) cf.add("documentid",this.documentid,documentid); } this.documentid=documentid;}
public void setAttendflag(String attendflag) { sqlMaker.setField("attendflag",attendflag,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAttendflag().equals(attendflag)) cf.add("attendflag",this.attendflag,attendflag); } this.attendflag=attendflag;}
public void setInsurancests(String insurancests) { sqlMaker.setField("insurancests",insurancests,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getInsurancests().equals(insurancests)) cf.add("insurancests",this.insurancests,insurancests); } this.insurancests=insurancests;}
public void setPaperrtndate(String paperrtndate) { sqlMaker.setField("paperrtndate",paperrtndate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getPaperrtndate().equals(paperrtndate)) cf.add("paperrtndate",this.paperrtndate,paperrtndate); } this.paperrtndate=paperrtndate;}
public void setClrpaperdate(String clrpaperdate) { sqlMaker.setField("clrpaperdate",clrpaperdate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getClrpaperdate().equals(clrpaperdate)) cf.add("clrpaperdate",this.clrpaperdate,clrpaperdate); } this.clrpaperdate=clrpaperdate;}
public void setOperid2(String operid2) { sqlMaker.setField("operid2",operid2,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getOperid2().equals(operid2)) cf.add("operid2",this.operid2,operid2); } this.operid2=operid2;}
public void setOperdate(String operdate) { sqlMaker.setField("operdate",operdate,Field.DATE); if (this.operate_mode.equals("edit")) { if (!this.getOperdate().equals(operdate)) cf.add("operdate",this.operdate,operdate); } this.operdate=operdate;}
public void init(int i,ActionRequest actionRequest) throws Exception { if ( actionRequest.getFieldValue(i,"mortid") !=null ) {this.setMortid(actionRequest.getFieldValue(i,"mortid"));}
if ( actionRequest.getFieldValue(i,"loanid") !=null ) {this.setLoanid(actionRequest.getFieldValue(i,"loanid"));}
if ( actionRequest.getFieldValue(i,"insuranceid") !=null ) {this.setInsuranceid(actionRequest.getFieldValue(i,"insuranceid"));}
if ( actionRequest.getFieldValue(i,"documentid") !=null ) {this.setDocumentid(actionRequest.getFieldValue(i,"documentid"));}
if ( actionRequest.getFieldValue(i,"attendflag") !=null ) {this.setAttendflag(actionRequest.getFieldValue(i,"attendflag"));}
if ( actionRequest.getFieldValue(i,"insurancests") !=null ) {this.setInsurancests(actionRequest.getFieldValue(i,"insurancests"));}
if ( actionRequest.getFieldValue(i,"paperrtndate") !=null ) {this.setPaperrtndate(actionRequest.getFieldValue(i,"paperrtndate"));}
if ( actionRequest.getFieldValue(i,"clrpaperdate") !=null ) {this.setClrpaperdate(actionRequest.getFieldValue(i,"clrpaperdate"));}
if ( actionRequest.getFieldValue(i,"operid2") !=null ) {this.setOperid2(actionRequest.getFieldValue(i,"operid2"));}
if ( actionRequest.getFieldValue(i,"operdate") !=null ) {this.setOperdate(actionRequest.getFieldValue(i,"operdate"));}
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { LNINSURANCE obj = (LNINSURANCE)super.clone();obj.setMortid(obj.mortid);
obj.setLoanid(obj.loanid);
obj.setInsuranceid(obj.insuranceid);
obj.setDocumentid(obj.documentid);
obj.setAttendflag(obj.attendflag);
obj.setInsurancests(obj.insurancests);
obj.setPaperrtndate(obj.paperrtndate);
obj.setClrpaperdate(obj.clrpaperdate);
obj.setOperid2(obj.operid2);
obj.setOperdate(obj.operdate);
return obj;}}