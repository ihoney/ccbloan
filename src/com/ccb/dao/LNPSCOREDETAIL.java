package com.ccb.dao;

import pub.platform.db.AbstractBasicBean;
import pub.platform.db.RecordSet;
import pub.platform.utils.ActionRequest;
import pub.platform.utils.ChangeFileds;
import pub.platform.utils.Field;

import java.util.List;

public class LNPSCOREDETAIL extends AbstractBasicBean implements Cloneable {
     public static List find(String sSqlWhere) {           return new LNPSCOREDETAIL().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere) {           return new LNPSCOREDETAIL().findAndLockByWhere(sSqlWhere);      }       public static LNPSCOREDETAIL findFirst(String sSqlWhere) {           return (LNPSCOREDETAIL)new LNPSCOREDETAIL().findFirstByWhere(sSqlWhere);      }       public static LNPSCOREDETAIL findFirstAndLock(String sSqlWhere) {           return (LNPSCOREDETAIL)new LNPSCOREDETAIL().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) {           return new LNPSCOREDETAIL().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease) {           LNPSCOREDETAIL bean = new LNPSCOREDETAIL();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) {           LNPSCOREDETAIL bean = new LNPSCOREDETAIL();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static LNPSCOREDETAIL findFirst(String sSqlWhere,boolean isAutoRelease) {           LNPSCOREDETAIL bean = new LNPSCOREDETAIL();           bean.setAutoRelease(isAutoRelease);           return (LNPSCOREDETAIL)bean.findFirstByWhere(sSqlWhere);      }       public static LNPSCOREDETAIL findFirstAndLock(String sSqlWhere,boolean isAutoRelease) {           LNPSCOREDETAIL bean = new LNPSCOREDETAIL();           bean.setAutoRelease(isAutoRelease);           return (LNPSCOREDETAIL)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease) {           LNPSCOREDETAIL bean = new LNPSCOREDETAIL();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      }      public static List findByRow(String sSqlWhere,int row) {           return new LNPSCOREDETAIL().findByWhereByRow(sSqlWhere,row);      } String creditratingno;
String custno;
String idno;
String custname;
String basescore;
String baselevel;
String iniscore;
String inilevel;
int iniamt;
String inioperid;
String inidate;
String inibegdate;
String inienddate;
String inideptid;
String finscore;
String finlevel;
int finamt;
String finoperid;
String findate;
String finbegdate;
String finenddate;
String findeptid;
String sta;
String timelimit;
int seqnum;
String docid;
public static final String TABLENAME ="ln_pscoredetail";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
public void addObject(List list,RecordSet rs) {
LNPSCOREDETAIL abb = new LNPSCOREDETAIL();
abb.creditratingno=rs.getString("creditratingno");abb.setKeyValue("CREDITRATINGNO",""+abb.getCreditratingno());
abb.custno=rs.getString("custno");abb.setKeyValue("CUSTNO",""+abb.getCustno());
abb.idno=rs.getString("idno");abb.setKeyValue("IDNO",""+abb.getIdno());
abb.custname=rs.getString("custname");abb.setKeyValue("CUSTNAME",""+abb.getCustname());
abb.basescore=rs.getString("basescore");abb.setKeyValue("BASESCORE",""+abb.getBasescore());
abb.baselevel=rs.getString("baselevel");abb.setKeyValue("BASELEVEL",""+abb.getBaselevel());
abb.iniscore=rs.getString("iniscore");abb.setKeyValue("INISCORE",""+abb.getIniscore());
abb.inilevel=rs.getString("inilevel");abb.setKeyValue("INILEVEL",""+abb.getInilevel());
abb.iniamt=rs.getInt("iniamt");abb.setKeyValue("INIAMT",""+abb.getIniamt());
abb.inioperid=rs.getString("inioperid");abb.setKeyValue("INIOPERID",""+abb.getInioperid());
abb.inidate=rs.getTimeString("inidate");abb.setKeyValue("INIDATE",""+abb.getInidate());
abb.inibegdate=rs.getTimeString("inibegdate");abb.setKeyValue("INIBEGDATE",""+abb.getInibegdate());
abb.inienddate=rs.getTimeString("inienddate");abb.setKeyValue("INIENDDATE",""+abb.getInienddate());
abb.inideptid=rs.getString("inideptid");abb.setKeyValue("INIDEPTID",""+abb.getInideptid());
abb.finscore=rs.getString("finscore");abb.setKeyValue("FINSCORE",""+abb.getFinscore());
abb.finlevel=rs.getString("finlevel");abb.setKeyValue("FINLEVEL",""+abb.getFinlevel());
abb.finamt=rs.getInt("finamt");abb.setKeyValue("FINAMT",""+abb.getFinamt());
abb.finoperid=rs.getString("finoperid");abb.setKeyValue("FINOPERID",""+abb.getFinoperid());
abb.findate=rs.getTimeString("findate");abb.setKeyValue("FINDATE",""+abb.getFindate());
abb.finbegdate=rs.getTimeString("finbegdate");abb.setKeyValue("FINBEGDATE",""+abb.getFinbegdate());
abb.finenddate=rs.getTimeString("finenddate");abb.setKeyValue("FINENDDATE",""+abb.getFinenddate());
abb.findeptid=rs.getString("findeptid");abb.setKeyValue("FINDEPTID",""+abb.getFindeptid());
abb.sta=rs.getString("sta");abb.setKeyValue("STA",""+abb.getSta());
abb.timelimit=rs.getString("timelimit");abb.setKeyValue("TIMELIMIT",""+abb.getTimelimit());
abb.seqnum=rs.getInt("seqnum");abb.setKeyValue("SEQNUM",""+abb.getSeqnum());
abb.docid=rs.getString("docid");abb.setKeyValue("DOCID",""+abb.getDocid());
list.add(abb);
abb.operate_mode = "edit";
}public String getCreditratingno() { if ( this.creditratingno == null ) return ""; return this.creditratingno;}
public String getCustno() { if ( this.custno == null ) return ""; return this.custno;}
public String getIdno() { if ( this.idno == null ) return ""; return this.idno;}
public String getCustname() { if ( this.custname == null ) return ""; return this.custname;}
public String getBasescore() { if ( this.basescore == null ) return ""; return this.basescore;}
public String getBaselevel() { if ( this.baselevel == null ) return ""; return this.baselevel;}
public String getIniscore() { if ( this.iniscore == null ) return ""; return this.iniscore;}
public String getInilevel() { if ( this.inilevel == null ) return ""; return this.inilevel;}
public int getIniamt() { return this.iniamt;}
public String getInioperid() { if ( this.inioperid == null ) return ""; return this.inioperid;}
public String getInidate() {  if ( this.inidate == null ) { return ""; } else { return this.inidate.trim().split(" ")[0];} }public String getInidateTime() {  if ( this.inidate == null ) return ""; return this.inidate.split("\\.")[0];}
public String getInibegdate() {  if ( this.inibegdate == null ) { return ""; } else { return this.inibegdate.trim().split(" ")[0];} }public String getInibegdateTime() {  if ( this.inibegdate == null ) return ""; return this.inibegdate.split("\\.")[0];}
public String getInienddate() {  if ( this.inienddate == null ) { return ""; } else { return this.inienddate.trim().split(" ")[0];} }public String getInienddateTime() {  if ( this.inienddate == null ) return ""; return this.inienddate.split("\\.")[0];}
public String getInideptid() { if ( this.inideptid == null ) return ""; return this.inideptid;}
public String getFinscore() { if ( this.finscore == null ) return ""; return this.finscore;}
public String getFinlevel() { if ( this.finlevel == null ) return ""; return this.finlevel;}
public int getFinamt() { return this.finamt;}
public String getFinoperid() { if ( this.finoperid == null ) return ""; return this.finoperid;}
public String getFindate() {  if ( this.findate == null ) { return ""; } else { return this.findate.trim().split(" ")[0];} }public String getFindateTime() {  if ( this.findate == null ) return ""; return this.findate.split("\\.")[0];}
public String getFinbegdate() {  if ( this.finbegdate == null ) { return ""; } else { return this.finbegdate.trim().split(" ")[0];} }public String getFinbegdateTime() {  if ( this.finbegdate == null ) return ""; return this.finbegdate.split("\\.")[0];}
public String getFinenddate() {  if ( this.finenddate == null ) { return ""; } else { return this.finenddate.trim().split(" ")[0];} }public String getFinenddateTime() {  if ( this.finenddate == null ) return ""; return this.finenddate.split("\\.")[0];}
public String getFindeptid() { if ( this.findeptid == null ) return ""; return this.findeptid;}
public String getSta() { if ( this.sta == null ) return ""; return this.sta;}
public String getTimelimit() { if ( this.timelimit == null ) return ""; return this.timelimit;}
public int getSeqnum() { return this.seqnum;}
public String getDocid() { if ( this.docid == null ) return ""; return this.docid;}
public void setCreditratingno(String creditratingno) { sqlMaker.setField("creditratingno",creditratingno, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCreditratingno().equals(creditratingno)) cf.add("creditratingno",this.creditratingno,creditratingno); } this.creditratingno=creditratingno;}
public void setCustno(String custno) { sqlMaker.setField("custno",custno, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCustno().equals(custno)) cf.add("custno",this.custno,custno); } this.custno=custno;}
public void setIdno(String idno) { sqlMaker.setField("idno",idno, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getIdno().equals(idno)) cf.add("idno",this.idno,idno); } this.idno=idno;}
public void setCustname(String custname) { sqlMaker.setField("custname",custname, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCustname().equals(custname)) cf.add("custname",this.custname,custname); } this.custname=custname;}
public void setBasescore(String basescore) { sqlMaker.setField("basescore",basescore, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getBasescore().equals(basescore)) cf.add("basescore",this.basescore,basescore); } this.basescore=basescore;}
public void setBaselevel(String baselevel) { sqlMaker.setField("baselevel",baselevel, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getBaselevel().equals(baselevel)) cf.add("baselevel",this.baselevel,baselevel); } this.baselevel=baselevel;}
public void setIniscore(String iniscore) { sqlMaker.setField("iniscore",iniscore, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getIniscore().equals(iniscore)) cf.add("iniscore",this.iniscore,iniscore); } this.iniscore=iniscore;}
public void setInilevel(String inilevel) { sqlMaker.setField("inilevel",inilevel, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getInilevel().equals(inilevel)) cf.add("inilevel",this.inilevel,inilevel); } this.inilevel=inilevel;}
public void setIniamt(int iniamt) { sqlMaker.setField("iniamt",""+iniamt, Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getIniamt()!=iniamt) cf.add("iniamt",this.iniamt+"",iniamt+""); } this.iniamt=iniamt;}
public void setInioperid(String inioperid) { sqlMaker.setField("inioperid",inioperid, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getInioperid().equals(inioperid)) cf.add("inioperid",this.inioperid,inioperid); } this.inioperid=inioperid;}
public void setInidate(String inidate) { sqlMaker.setField("inidate",inidate, Field.DATE); if (this.operate_mode.equals("edit")) { if (!this.getInidate().equals(inidate)) cf.add("inidate",this.inidate,inidate); } this.inidate=inidate;}
public void setInibegdate(String inibegdate) { sqlMaker.setField("inibegdate",inibegdate, Field.DATE); if (this.operate_mode.equals("edit")) { if (!this.getInibegdate().equals(inibegdate)) cf.add("inibegdate",this.inibegdate,inibegdate); } this.inibegdate=inibegdate;}
public void setInienddate(String inienddate) { sqlMaker.setField("inienddate",inienddate, Field.DATE); if (this.operate_mode.equals("edit")) { if (!this.getInienddate().equals(inienddate)) cf.add("inienddate",this.inienddate,inienddate); } this.inienddate=inienddate;}
public void setInideptid(String inideptid) { sqlMaker.setField("inideptid",inideptid, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getInideptid().equals(inideptid)) cf.add("inideptid",this.inideptid,inideptid); } this.inideptid=inideptid;}
public void setFinscore(String finscore) { sqlMaker.setField("finscore",finscore, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getFinscore().equals(finscore)) cf.add("finscore",this.finscore,finscore); } this.finscore=finscore;}
public void setFinlevel(String finlevel) { sqlMaker.setField("finlevel",finlevel, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getFinlevel().equals(finlevel)) cf.add("finlevel",this.finlevel,finlevel); } this.finlevel=finlevel;}
public void setFinamt(int finamt) { sqlMaker.setField("finamt",""+finamt, Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getFinamt()!=finamt) cf.add("finamt",this.finamt+"",finamt+""); } this.finamt=finamt;}
public void setFinoperid(String finoperid) { sqlMaker.setField("finoperid",finoperid, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getFinoperid().equals(finoperid)) cf.add("finoperid",this.finoperid,finoperid); } this.finoperid=finoperid;}
public void setFindate(String findate) { sqlMaker.setField("findate",findate, Field.DATE); if (this.operate_mode.equals("edit")) { if (!this.getFindate().equals(findate)) cf.add("findate",this.findate,findate); } this.findate=findate;}
public void setFinbegdate(String finbegdate) { sqlMaker.setField("finbegdate",finbegdate, Field.DATE); if (this.operate_mode.equals("edit")) { if (!this.getFinbegdate().equals(finbegdate)) cf.add("finbegdate",this.finbegdate,finbegdate); } this.finbegdate=finbegdate;}
public void setFinenddate(String finenddate) { sqlMaker.setField("finenddate",finenddate, Field.DATE); if (this.operate_mode.equals("edit")) { if (!this.getFinenddate().equals(finenddate)) cf.add("finenddate",this.finenddate,finenddate); } this.finenddate=finenddate;}
public void setFindeptid(String findeptid) { sqlMaker.setField("findeptid",findeptid, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getFindeptid().equals(findeptid)) cf.add("findeptid",this.findeptid,findeptid); } this.findeptid=findeptid;}
public void setSta(String sta) { sqlMaker.setField("sta",sta, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSta().equals(sta)) cf.add("sta",this.sta,sta); } this.sta=sta;}
public void setTimelimit(String timelimit) { sqlMaker.setField("timelimit",timelimit, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getTimelimit().equals(timelimit)) cf.add("timelimit",this.timelimit,timelimit); } this.timelimit=timelimit;}
public void setSeqnum(int seqnum) { sqlMaker.setField("seqnum",""+seqnum, Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getSeqnum()!=seqnum) cf.add("seqnum",this.seqnum+"",seqnum+""); } this.seqnum=seqnum;}
public void setDocid(String docid) { sqlMaker.setField("docid",docid, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getDocid().equals(docid)) cf.add("docid",this.docid,docid); } this.docid=docid;}
public void init(int i,ActionRequest actionRequest) throws Exception { if ( actionRequest.getFieldValue(i,"creditratingno") !=null ) {this.setCreditratingno(actionRequest.getFieldValue(i,"creditratingno"));}
if ( actionRequest.getFieldValue(i,"custno") !=null ) {this.setCustno(actionRequest.getFieldValue(i,"custno"));}
if ( actionRequest.getFieldValue(i,"idno") !=null ) {this.setIdno(actionRequest.getFieldValue(i,"idno"));}
if ( actionRequest.getFieldValue(i,"custname") !=null ) {this.setCustname(actionRequest.getFieldValue(i,"custname"));}
if ( actionRequest.getFieldValue(i,"basescore") !=null ) {this.setBasescore(actionRequest.getFieldValue(i,"basescore"));}
if ( actionRequest.getFieldValue(i,"baselevel") !=null ) {this.setBaselevel(actionRequest.getFieldValue(i,"baselevel"));}
if ( actionRequest.getFieldValue(i,"iniscore") !=null ) {this.setIniscore(actionRequest.getFieldValue(i,"iniscore"));}
if ( actionRequest.getFieldValue(i,"inilevel") !=null ) {this.setInilevel(actionRequest.getFieldValue(i,"inilevel"));}
if ( actionRequest.getFieldValue(i,"iniamt") !=null && actionRequest.getFieldValue(i,"iniamt").trim().length() > 0 ) {this.setIniamt(Integer.parseInt(actionRequest.getFieldValue(i, "iniamt")));}
if ( actionRequest.getFieldValue(i,"inioperid") !=null ) {this.setInioperid(actionRequest.getFieldValue(i,"inioperid"));}
if ( actionRequest.getFieldValue(i,"inidate") !=null ) {this.setInidate(actionRequest.getFieldValue(i,"inidate"));}
if ( actionRequest.getFieldValue(i,"inibegdate") !=null ) {this.setInibegdate(actionRequest.getFieldValue(i,"inibegdate"));}
if ( actionRequest.getFieldValue(i,"inienddate") !=null ) {this.setInienddate(actionRequest.getFieldValue(i,"inienddate"));}
if ( actionRequest.getFieldValue(i,"inideptid") !=null ) {this.setInideptid(actionRequest.getFieldValue(i,"inideptid"));}
if ( actionRequest.getFieldValue(i,"finscore") !=null ) {this.setFinscore(actionRequest.getFieldValue(i,"finscore"));}
if ( actionRequest.getFieldValue(i,"finlevel") !=null ) {this.setFinlevel(actionRequest.getFieldValue(i,"finlevel"));}
if ( actionRequest.getFieldValue(i,"finamt") !=null && actionRequest.getFieldValue(i,"finamt").trim().length() > 0 ) {this.setFinamt(Integer.parseInt(actionRequest.getFieldValue(i, "finamt")));}
if ( actionRequest.getFieldValue(i,"finoperid") !=null ) {this.setFinoperid(actionRequest.getFieldValue(i,"finoperid"));}
if ( actionRequest.getFieldValue(i,"findate") !=null ) {this.setFindate(actionRequest.getFieldValue(i,"findate"));}
if ( actionRequest.getFieldValue(i,"finbegdate") !=null ) {this.setFinbegdate(actionRequest.getFieldValue(i,"finbegdate"));}
if ( actionRequest.getFieldValue(i,"finenddate") !=null ) {this.setFinenddate(actionRequest.getFieldValue(i,"finenddate"));}
if ( actionRequest.getFieldValue(i,"findeptid") !=null ) {this.setFindeptid(actionRequest.getFieldValue(i,"findeptid"));}
if ( actionRequest.getFieldValue(i,"sta") !=null ) {this.setSta(actionRequest.getFieldValue(i,"sta"));}
if ( actionRequest.getFieldValue(i,"timelimit") !=null ) {this.setTimelimit(actionRequest.getFieldValue(i,"timelimit"));}
if ( actionRequest.getFieldValue(i,"seqnum") !=null && actionRequest.getFieldValue(i,"seqnum").trim().length() > 0 ) {this.setSeqnum(Integer.parseInt(actionRequest.getFieldValue(i,"seqnum")));}
if ( actionRequest.getFieldValue(i,"docid") !=null ) {this.setDocid(actionRequest.getFieldValue(i,"docid"));}
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { LNPSCOREDETAIL obj = (LNPSCOREDETAIL)super.clone();obj.setCreditratingno(obj.creditratingno);
obj.setCustno(obj.custno);
obj.setIdno(obj.idno);
obj.setCustname(obj.custname);
obj.setBasescore(obj.basescore);
obj.setBaselevel(obj.baselevel);
obj.setIniscore(obj.iniscore);
obj.setInilevel(obj.inilevel);
obj.setIniamt(obj.iniamt);
obj.setInioperid(obj.inioperid);
obj.setInidate(obj.inidate);
obj.setInibegdate(obj.inibegdate);
obj.setInienddate(obj.inienddate);
obj.setInideptid(obj.inideptid);
obj.setFinscore(obj.finscore);
obj.setFinlevel(obj.finlevel);
obj.setFinamt(obj.finamt);
obj.setFinoperid(obj.finoperid);
obj.setFindate(obj.findate);
obj.setFinbegdate(obj.finbegdate);
obj.setFinenddate(obj.finenddate);
obj.setFindeptid(obj.findeptid);
obj.setSta(obj.sta);
obj.setTimelimit(obj.timelimit);
obj.setSeqnum(obj.seqnum);
obj.setDocid(obj.docid);
return obj;}}