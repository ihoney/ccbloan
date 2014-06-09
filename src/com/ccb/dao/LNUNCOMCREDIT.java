package com.ccb.dao;

import pub.platform.db.AbstractBasicBean;
import pub.platform.db.RecordSet;
import pub.platform.utils.ActionRequest;
import pub.platform.utils.ChangeFileds;
import pub.platform.utils.Field;

import java.util.List;

public class LNUNCOMCREDIT extends AbstractBasicBean implements Cloneable {
     public static List find(String sSqlWhere) {           return new LNUNCOMCREDIT().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere) {           return new LNUNCOMCREDIT().findAndLockByWhere(sSqlWhere);      }       public static LNUNCOMCREDIT findFirst(String sSqlWhere) {           return (LNUNCOMCREDIT)new LNUNCOMCREDIT().findFirstByWhere(sSqlWhere);      }       public static LNUNCOMCREDIT findFirstAndLock(String sSqlWhere) {           return (LNUNCOMCREDIT)new LNUNCOMCREDIT().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) {           return new LNUNCOMCREDIT().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease) {           LNUNCOMCREDIT bean = new LNUNCOMCREDIT();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) {           LNUNCOMCREDIT bean = new LNUNCOMCREDIT();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static LNUNCOMCREDIT findFirst(String sSqlWhere,boolean isAutoRelease) {           LNUNCOMCREDIT bean = new LNUNCOMCREDIT();           bean.setAutoRelease(isAutoRelease);           return (LNUNCOMCREDIT)bean.findFirstByWhere(sSqlWhere);      }       public static LNUNCOMCREDIT findFirstAndLock(String sSqlWhere,boolean isAutoRelease) {           LNUNCOMCREDIT bean = new LNUNCOMCREDIT();           bean.setAutoRelease(isAutoRelease);           return (LNUNCOMCREDIT)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease) {           LNUNCOMCREDIT bean = new LNUNCOMCREDIT();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      }      public static List findByRow(String sSqlWhere,int row) {           return new LNUNCOMCREDIT().findByWhereByRow(sSqlWhere,row);      } String pkid;
String creditratingno;
String custname;
String idtype;
String idno;
String birthday;
String sex;
int age;
String judgetype;
String judgelevel;
String judgeoperid;
String judgedate;
String begdate;
String enddate;
String judgedeptid;
int judgeprice;
String timelimit;
int seqnum;
String recsta;
String post;
String formalworker;
int income;
String docid;
public static final String TABLENAME ="ln_uncomcredit";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
public void addObject(List list,RecordSet rs) {
LNUNCOMCREDIT abb = new LNUNCOMCREDIT();
abb.pkid=rs.getString("pkid");abb.setKeyValue("PKID",""+abb.getPkid());
abb.creditratingno=rs.getString("creditratingno");abb.setKeyValue("CREDITRATINGNO",""+abb.getCreditratingno());
abb.custname=rs.getString("custname");abb.setKeyValue("CUSTNAME",""+abb.getCustname());
abb.idtype=rs.getString("idtype");abb.setKeyValue("IDTYPE",""+abb.getIdtype());
abb.idno=rs.getString("idno");abb.setKeyValue("IDNO",""+abb.getIdno());
abb.birthday=rs.getTimeString("birthday");abb.setKeyValue("BIRTHDAY",""+abb.getBirthday());
abb.sex=rs.getString("sex");abb.setKeyValue("SEX",""+abb.getSex());
abb.age=rs.getInt("age");abb.setKeyValue("AGE",""+abb.getAge());
abb.judgetype=rs.getString("judgetype");abb.setKeyValue("JUDGETYPE",""+abb.getJudgetype());
abb.judgelevel=rs.getString("judgelevel");abb.setKeyValue("JUDGELEVEL",""+abb.getJudgelevel());
abb.judgeoperid=rs.getString("judgeoperid");abb.setKeyValue("JUDGEOPERID",""+abb.getJudgeoperid());
abb.judgedate=rs.getTimeString("judgedate");abb.setKeyValue("JUDGEDATE",""+abb.getJudgedate());
abb.begdate=rs.getTimeString("begdate");abb.setKeyValue("BEGDATE",""+abb.getBegdate());
abb.enddate=rs.getTimeString("enddate");abb.setKeyValue("ENDDATE",""+abb.getEnddate());
abb.judgedeptid=rs.getString("judgedeptid");abb.setKeyValue("JUDGEDEPTID",""+abb.getJudgedeptid());
abb.judgeprice=rs.getInt("judgeprice");abb.setKeyValue("JUDGEPRICE",""+abb.getJudgeprice());
abb.timelimit=rs.getString("timelimit");abb.setKeyValue("TIMELIMIT",""+abb.getTimelimit());
abb.seqnum=rs.getInt("seqnum");abb.setKeyValue("SEQNUM",""+abb.getSeqnum());
abb.recsta=rs.getString("recsta");abb.setKeyValue("RECSTA",""+abb.getRecsta());
abb.post=rs.getString("post");abb.setKeyValue("POST",""+abb.getPost());
abb.formalworker=rs.getString("formalworker");abb.setKeyValue("FORMALWORKER",""+abb.getFormalworker());
abb.income=rs.getInt("income");abb.setKeyValue("INCOME",""+abb.getIncome());
abb.docid=rs.getString("docid");abb.setKeyValue("DOCID",""+abb.getDocid());
list.add(abb);
abb.operate_mode = "edit";
}public String getPkid() { if ( this.pkid == null ) return ""; return this.pkid;}
public String getCreditratingno() { if ( this.creditratingno == null ) return ""; return this.creditratingno;}
public String getCustname() { if ( this.custname == null ) return ""; return this.custname;}
public String getIdtype() { if ( this.idtype == null ) return ""; return this.idtype;}
public String getIdno() { if ( this.idno == null ) return ""; return this.idno;}
public String getBirthday() {  if ( this.birthday == null ) { return ""; } else { return this.birthday.trim().split(" ")[0];} }public String getBirthdayTime() {  if ( this.birthday == null ) return ""; return this.birthday.split("\\.")[0];}
public String getSex() { if ( this.sex == null ) return ""; return this.sex;}
public int getAge() { return this.age;}
public String getJudgetype() { if ( this.judgetype == null ) return ""; return this.judgetype;}
public String getJudgelevel() { if ( this.judgelevel == null ) return ""; return this.judgelevel;}
public String getJudgeoperid() { if ( this.judgeoperid == null ) return ""; return this.judgeoperid;}
public String getJudgedate() {  if ( this.judgedate == null ) { return ""; } else { return this.judgedate.trim().split(" ")[0];} }public String getJudgedateTime() {  if ( this.judgedate == null ) return ""; return this.judgedate.split("\\.")[0];}
public String getBegdate() {  if ( this.begdate == null ) { return ""; } else { return this.begdate.trim().split(" ")[0];} }public String getBegdateTime() {  if ( this.begdate == null ) return ""; return this.begdate.split("\\.")[0];}
public String getEnddate() {  if ( this.enddate == null ) { return ""; } else { return this.enddate.trim().split(" ")[0];} }public String getEnddateTime() {  if ( this.enddate == null ) return ""; return this.enddate.split("\\.")[0];}
public String getJudgedeptid() { if ( this.judgedeptid == null ) return ""; return this.judgedeptid;}
public int getJudgeprice() { return this.judgeprice;}
public String getTimelimit() { if ( this.timelimit == null ) return ""; return this.timelimit;}
public int getSeqnum() { return this.seqnum;}
public String getRecsta() { if ( this.recsta == null ) return ""; return this.recsta;}
public String getPost() { if ( this.post == null ) return ""; return this.post;}
public String getFormalworker() { if ( this.formalworker == null ) return ""; return this.formalworker;}
public int getIncome() { return this.income;}
public String getDocid() { if ( this.docid == null ) return ""; return this.docid;}
public void setPkid(String pkid) { sqlMaker.setField("pkid",pkid, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getPkid().equals(pkid)) cf.add("pkid",this.pkid,pkid); } this.pkid=pkid;}
public void setCreditratingno(String creditratingno) { sqlMaker.setField("creditratingno",creditratingno, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCreditratingno().equals(creditratingno)) cf.add("creditratingno",this.creditratingno,creditratingno); } this.creditratingno=creditratingno;}
public void setCustname(String custname) { sqlMaker.setField("custname",custname, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCustname().equals(custname)) cf.add("custname",this.custname,custname); } this.custname=custname;}
public void setIdtype(String idtype) { sqlMaker.setField("idtype",idtype, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getIdtype().equals(idtype)) cf.add("idtype",this.idtype,idtype); } this.idtype=idtype;}
public void setIdno(String idno) { sqlMaker.setField("idno",idno, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getIdno().equals(idno)) cf.add("idno",this.idno,idno); } this.idno=idno;}
public void setBirthday(String birthday) { sqlMaker.setField("birthday",birthday, Field.DATE); if (this.operate_mode.equals("edit")) { if (!this.getBirthday().equals(birthday)) cf.add("birthday",this.birthday,birthday); } this.birthday=birthday;}
public void setSex(String sex) { sqlMaker.setField("sex",sex, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSex().equals(sex)) cf.add("sex",this.sex,sex); } this.sex=sex;}
public void setAge(int age) { sqlMaker.setField("age",""+age, Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getAge()!=age) cf.add("age",this.age+"",age+""); } this.age=age;}
public void setJudgetype(String judgetype) { sqlMaker.setField("judgetype",judgetype, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getJudgetype().equals(judgetype)) cf.add("judgetype",this.judgetype,judgetype); } this.judgetype=judgetype;}
public void setJudgelevel(String judgelevel) { sqlMaker.setField("judgelevel",judgelevel, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getJudgelevel().equals(judgelevel)) cf.add("judgelevel",this.judgelevel,judgelevel); } this.judgelevel=judgelevel;}
public void setJudgeoperid(String judgeoperid) { sqlMaker.setField("judgeoperid",judgeoperid, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getJudgeoperid().equals(judgeoperid)) cf.add("judgeoperid",this.judgeoperid,judgeoperid); } this.judgeoperid=judgeoperid;}
public void setJudgedate(String judgedate) { sqlMaker.setField("judgedate",judgedate, Field.DATE); if (this.operate_mode.equals("edit")) { if (!this.getJudgedate().equals(judgedate)) cf.add("judgedate",this.judgedate,judgedate); } this.judgedate=judgedate;}
public void setBegdate(String begdate) { sqlMaker.setField("begdate",begdate, Field.DATE); if (this.operate_mode.equals("edit")) { if (!this.getBegdate().equals(begdate)) cf.add("begdate",this.begdate,begdate); } this.begdate=begdate;}
public void setEnddate(String enddate) { sqlMaker.setField("enddate",enddate, Field.DATE); if (this.operate_mode.equals("edit")) { if (!this.getEnddate().equals(enddate)) cf.add("enddate",this.enddate,enddate); } this.enddate=enddate;}
public void setJudgedeptid(String judgedeptid) { sqlMaker.setField("judgedeptid",judgedeptid, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getJudgedeptid().equals(judgedeptid)) cf.add("judgedeptid",this.judgedeptid,judgedeptid); } this.judgedeptid=judgedeptid;}
public void setJudgeprice(int judgeprice) { sqlMaker.setField("judgeprice",""+judgeprice, Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getJudgeprice()!=judgeprice) cf.add("judgeprice",this.judgeprice+"",judgeprice+""); } this.judgeprice=judgeprice;}
public void setTimelimit(String timelimit) { sqlMaker.setField("timelimit",timelimit, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getTimelimit().equals(timelimit)) cf.add("timelimit",this.timelimit,timelimit); } this.timelimit=timelimit;}
public void setSeqnum(int seqnum) { sqlMaker.setField("seqnum",""+seqnum, Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getSeqnum()!=seqnum) cf.add("seqnum",this.seqnum+"",seqnum+""); } this.seqnum=seqnum;}
public void setRecsta(String recsta) { sqlMaker.setField("recsta",recsta, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRecsta().equals(recsta)) cf.add("recsta",this.recsta,recsta); } this.recsta=recsta;}
public void setPost(String post) { sqlMaker.setField("post",post, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getPost().equals(post)) cf.add("post",this.post,post); } this.post=post;}
public void setFormalworker(String formalworker) { sqlMaker.setField("formalworker",formalworker, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getFormalworker().equals(formalworker)) cf.add("formalworker",this.formalworker,formalworker); } this.formalworker=formalworker;}
public void setIncome(int income) { sqlMaker.setField("income",""+income, Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getIncome()!=income) cf.add("income",this.income+"",income+""); } this.income=income;}
public void setDocid(String docid) { sqlMaker.setField("docid",docid, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getDocid().equals(docid)) cf.add("docid",this.docid,docid); } this.docid=docid;}
public void init(int i,ActionRequest actionRequest) throws Exception { if ( actionRequest.getFieldValue(i,"pkid") !=null ) {this.setPkid(actionRequest.getFieldValue(i,"pkid"));}
if ( actionRequest.getFieldValue(i,"creditratingno") !=null ) {this.setCreditratingno(actionRequest.getFieldValue(i,"creditratingno"));}
if ( actionRequest.getFieldValue(i,"custname") !=null ) {this.setCustname(actionRequest.getFieldValue(i,"custname"));}
if ( actionRequest.getFieldValue(i,"idtype") !=null ) {this.setIdtype(actionRequest.getFieldValue(i,"idtype"));}
if ( actionRequest.getFieldValue(i,"idno") !=null ) {this.setIdno(actionRequest.getFieldValue(i,"idno"));}
if ( actionRequest.getFieldValue(i,"birthday") !=null ) {this.setBirthday(actionRequest.getFieldValue(i,"birthday"));}
if ( actionRequest.getFieldValue(i,"sex") !=null ) {this.setSex(actionRequest.getFieldValue(i,"sex"));}
if ( actionRequest.getFieldValue(i,"age") !=null && actionRequest.getFieldValue(i,"age").trim().length() > 0 ) {this.setAge(Integer.parseInt(actionRequest.getFieldValue(i,"age")));}
if ( actionRequest.getFieldValue(i,"judgetype") !=null ) {this.setJudgetype(actionRequest.getFieldValue(i,"judgetype"));}
if ( actionRequest.getFieldValue(i,"judgelevel") !=null ) {this.setJudgelevel(actionRequest.getFieldValue(i,"judgelevel"));}
if ( actionRequest.getFieldValue(i,"judgeoperid") !=null ) {this.setJudgeoperid(actionRequest.getFieldValue(i,"judgeoperid"));}
if ( actionRequest.getFieldValue(i,"judgedate") !=null ) {this.setJudgedate(actionRequest.getFieldValue(i,"judgedate"));}
if ( actionRequest.getFieldValue(i,"begdate") !=null ) {this.setBegdate(actionRequest.getFieldValue(i,"begdate"));}
if ( actionRequest.getFieldValue(i,"enddate") !=null ) {this.setEnddate(actionRequest.getFieldValue(i,"enddate"));}
if ( actionRequest.getFieldValue(i,"judgedeptid") !=null ) {this.setJudgedeptid(actionRequest.getFieldValue(i,"judgedeptid"));}
if ( actionRequest.getFieldValue(i,"judgeprice") !=null && actionRequest.getFieldValue(i,"judgeprice").trim().length() > 0 ) {this.setJudgeprice(Integer.parseInt(actionRequest.getFieldValue(i, "judgeprice")));}
if ( actionRequest.getFieldValue(i,"timelimit") !=null ) {this.setTimelimit(actionRequest.getFieldValue(i,"timelimit"));}
if ( actionRequest.getFieldValue(i,"seqnum") !=null && actionRequest.getFieldValue(i,"seqnum").trim().length() > 0 ) {this.setSeqnum(Integer.parseInt(actionRequest.getFieldValue(i,"seqnum")));}
if ( actionRequest.getFieldValue(i,"recsta") !=null ) {this.setRecsta(actionRequest.getFieldValue(i,"recsta"));}
if ( actionRequest.getFieldValue(i,"post") !=null ) {this.setPost(actionRequest.getFieldValue(i,"post"));}
if ( actionRequest.getFieldValue(i,"formalworker") !=null ) {this.setFormalworker(actionRequest.getFieldValue(i,"formalworker"));}
if ( actionRequest.getFieldValue(i,"income") !=null && actionRequest.getFieldValue(i,"income").trim().length() > 0 ) {this.setIncome(Integer.parseInt(actionRequest.getFieldValue(i, "income")));}
if ( actionRequest.getFieldValue(i,"docid") !=null ) {this.setDocid(actionRequest.getFieldValue(i,"docid"));}
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { LNUNCOMCREDIT obj = (LNUNCOMCREDIT)super.clone();obj.setPkid(obj.pkid);
obj.setCreditratingno(obj.creditratingno);
obj.setCustname(obj.custname);
obj.setIdtype(obj.idtype);
obj.setIdno(obj.idno);
obj.setBirthday(obj.birthday);
obj.setSex(obj.sex);
obj.setAge(obj.age);
obj.setJudgetype(obj.judgetype);
obj.setJudgelevel(obj.judgelevel);
obj.setJudgeoperid(obj.judgeoperid);
obj.setJudgedate(obj.judgedate);
obj.setBegdate(obj.begdate);
obj.setEnddate(obj.enddate);
obj.setJudgedeptid(obj.judgedeptid);
obj.setJudgeprice(obj.judgeprice);
obj.setTimelimit(obj.timelimit);
obj.setSeqnum(obj.seqnum);
obj.setRecsta(obj.recsta);
obj.setPost(obj.post);
obj.setFormalworker(obj.formalworker);
obj.setIncome(obj.income);
obj.setDocid(obj.docid);
return obj;}}