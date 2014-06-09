package com.ccb.dao;

import pub.platform.db.AbstractBasicBean;
import pub.platform.db.RecordSet;
import pub.platform.utils.ActionRequest;
import pub.platform.utils.ChangeFileds;
import pub.platform.utils.Field;

import java.util.List;

public class LNPCIF extends AbstractBasicBean implements Cloneable {
     public static List find(String sSqlWhere) {           return new LNPCIF().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere) {           return new LNPCIF().findAndLockByWhere(sSqlWhere);      }       public static LNPCIF findFirst(String sSqlWhere) {           return (LNPCIF)new LNPCIF().findFirstByWhere(sSqlWhere);      }       public static LNPCIF findFirstAndLock(String sSqlWhere) {           return (LNPCIF)new LNPCIF().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) {           return new LNPCIF().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease) {           LNPCIF bean = new LNPCIF();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) {           LNPCIF bean = new LNPCIF();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static LNPCIF findFirst(String sSqlWhere,boolean isAutoRelease) {           LNPCIF bean = new LNPCIF();           bean.setAutoRelease(isAutoRelease);           return (LNPCIF)bean.findFirstByWhere(sSqlWhere);      }       public static LNPCIF findFirstAndLock(String sSqlWhere,boolean isAutoRelease) {           LNPCIF bean = new LNPCIF();           bean.setAutoRelease(isAutoRelease);           return (LNPCIF)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease) {           LNPCIF bean = new LNPCIF();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      }      public static List findByRow(String sSqlWhere,int row) {           return new LNPCIF().findByWhereByRow(sSqlWhere,row);      } String custno;
String custname;
String sex;
String birthday;
String idtype;
String idno;
String corptype;
String corpname;
String corpfin;
String busifuture;
String corpzip;
String corptel;
String corpaddr;
String homeaddr;
String homezip;
String tel1;
String tel2;
String mobile1;
String mobile2;
String livetype;
String education;
String marista;
String postlevel;
String deptname;
String post;
String posttype;
int workyears;
int income;
int homeincome;
int homepersons;
int homeaveincome;
String health;
String memberflg;
String actflg;
String savbal;
String busirate;
String loansta;
String spousename;
String spouseidno;
String spousecorpaddr;
String spousetel;
int spouseincome;
String taxregno;
String busilicno;
String orgcode;
String remark;
String deptid;
String operid;
String operdate;
String updoperid;
String upddate;
String recsta;
int age;
String otherloansta;
String validitytime;
String validitytimetwo;
int seq;
public static final String TABLENAME ="ln_pcif";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
public void addObject(List list,RecordSet rs) {
LNPCIF abb = new LNPCIF();
abb.custno=rs.getString("custno");abb.setKeyValue("CUSTNO",""+abb.getCustno());
abb.custname=rs.getString("custname");abb.setKeyValue("CUSTNAME",""+abb.getCustname());
abb.sex=rs.getString("sex");abb.setKeyValue("SEX",""+abb.getSex());
abb.birthday=rs.getTimeString("birthday");abb.setKeyValue("BIRTHDAY",""+abb.getBirthday());
abb.idtype=rs.getString("idtype");abb.setKeyValue("IDTYPE",""+abb.getIdtype());
abb.idno=rs.getString("idno");abb.setKeyValue("IDNO",""+abb.getIdno());
abb.corptype=rs.getString("corptype");abb.setKeyValue("CORPTYPE",""+abb.getCorptype());
abb.corpname=rs.getString("corpname");abb.setKeyValue("CORPNAME",""+abb.getCorpname());
abb.corpfin=rs.getString("corpfin");abb.setKeyValue("CORPFIN",""+abb.getCorpfin());
abb.busifuture=rs.getString("busifuture");abb.setKeyValue("BUSIFUTURE",""+abb.getBusifuture());
abb.corpzip=rs.getString("corpzip");abb.setKeyValue("CORPZIP",""+abb.getCorpzip());
abb.corptel=rs.getString("corptel");abb.setKeyValue("CORPTEL",""+abb.getCorptel());
abb.corpaddr=rs.getString("corpaddr");abb.setKeyValue("CORPADDR",""+abb.getCorpaddr());
abb.homeaddr=rs.getString("homeaddr");abb.setKeyValue("HOMEADDR",""+abb.getHomeaddr());
abb.homezip=rs.getString("homezip");abb.setKeyValue("HOMEZIP",""+abb.getHomezip());
abb.tel1=rs.getString("tel1");abb.setKeyValue("TEL1",""+abb.getTel1());
abb.tel2=rs.getString("tel2");abb.setKeyValue("TEL2",""+abb.getTel2());
abb.mobile1=rs.getString("mobile1");abb.setKeyValue("MOBILE1",""+abb.getMobile1());
abb.mobile2=rs.getString("mobile2");abb.setKeyValue("MOBILE2",""+abb.getMobile2());
abb.livetype=rs.getString("livetype");abb.setKeyValue("LIVETYPE",""+abb.getLivetype());
abb.education=rs.getString("education");abb.setKeyValue("EDUCATION",""+abb.getEducation());
abb.marista=rs.getString("marista");abb.setKeyValue("MARISTA",""+abb.getMarista());
abb.postlevel=rs.getString("postlevel");abb.setKeyValue("POSTLEVEL",""+abb.getPostlevel());
abb.deptname=rs.getString("deptname");abb.setKeyValue("DEPTNAME",""+abb.getDeptname());
abb.post=rs.getString("post");abb.setKeyValue("POST",""+abb.getPost());
abb.posttype=rs.getString("posttype");abb.setKeyValue("POSTTYPE",""+abb.getPosttype());
abb.workyears=rs.getInt("workyears");abb.setKeyValue("WORKYEARS",""+abb.getWorkyears());
abb.income=rs.getInt("income");abb.setKeyValue("INCOME",""+abb.getIncome());
abb.homeincome=rs.getInt("homeincome");abb.setKeyValue("HOMEINCOME",""+abb.getHomeincome());
abb.homepersons=rs.getInt("homepersons");abb.setKeyValue("HOMEPERSONS",""+abb.getHomepersons());
abb.homeaveincome=rs.getInt("homeaveincome");abb.setKeyValue("HOMEAVEINCOME",""+abb.getHomeaveincome());
abb.health=rs.getString("health");abb.setKeyValue("HEALTH",""+abb.getHealth());
abb.memberflg=rs.getString("memberflg");abb.setKeyValue("MEMBERFLG",""+abb.getMemberflg());
abb.actflg=rs.getString("actflg");abb.setKeyValue("ACTFLG",""+abb.getActflg());
abb.savbal=rs.getString("savbal");abb.setKeyValue("SAVBAL",""+abb.getSavbal());
abb.busirate=rs.getString("busirate");abb.setKeyValue("BUSIRATE",""+abb.getBusirate());
abb.loansta=rs.getString("loansta");abb.setKeyValue("LOANSTA",""+abb.getLoansta());
abb.spousename=rs.getString("spousename");abb.setKeyValue("SPOUSENAME",""+abb.getSpousename());
abb.spouseidno=rs.getString("spouseidno");abb.setKeyValue("SPOUSEIDNO",""+abb.getSpouseidno());
abb.spousecorpaddr=rs.getString("spousecorpaddr");abb.setKeyValue("SPOUSECORPADDR",""+abb.getSpousecorpaddr());
abb.spousetel=rs.getString("spousetel");abb.setKeyValue("SPOUSETEL",""+abb.getSpousetel());
abb.spouseincome=rs.getInt("spouseincome");abb.setKeyValue("SPOUSEINCOME",""+abb.getSpouseincome());
abb.taxregno=rs.getString("taxregno");abb.setKeyValue("TAXREGNO",""+abb.getTaxregno());
abb.busilicno=rs.getString("busilicno");abb.setKeyValue("BUSILICNO",""+abb.getBusilicno());
abb.orgcode=rs.getString("orgcode");abb.setKeyValue("ORGCODE",""+abb.getOrgcode());
abb.remark=rs.getString("remark");abb.setKeyValue("REMARK",""+abb.getRemark());
abb.deptid=rs.getString("deptid");abb.setKeyValue("DEPTID",""+abb.getDeptid());
abb.operid=rs.getString("operid");abb.setKeyValue("OPERID",""+abb.getOperid());
abb.operdate=rs.getTimeString("operdate");abb.setKeyValue("OPERDATE",""+abb.getOperdate());
abb.updoperid=rs.getString("updoperid");abb.setKeyValue("UPDOPERID",""+abb.getUpdoperid());
abb.upddate=rs.getTimeString("upddate");abb.setKeyValue("UPDDATE",""+abb.getUpddate());
abb.recsta=rs.getString("recsta");abb.setKeyValue("RECSTA",""+abb.getRecsta());
abb.age=rs.getInt("age");abb.setKeyValue("AGE",""+abb.getAge());
abb.otherloansta=rs.getString("otherloansta");abb.setKeyValue("OTHERLOANSTA",""+abb.getOtherloansta());
abb.validitytime=rs.getTimeString("validitytime");abb.setKeyValue("VALIDITYTIME",""+abb.getValiditytime());
abb.validitytimetwo=rs.getTimeString("validitytimetwo");abb.setKeyValue("VALIDITYTIMETWO",""+abb.getValiditytimetwo());
abb.seq=rs.getInt("seq");abb.setKeyValue("SEQ",""+abb.getSeq());
list.add(abb);
abb.operate_mode = "edit";
}public String getCustno() { if ( this.custno == null ) return ""; return this.custno;}
public String getCustname() { if ( this.custname == null ) return ""; return this.custname;}
public String getSex() { if ( this.sex == null ) return ""; return this.sex;}
public String getBirthday() {  if ( this.birthday == null ) { return ""; } else { return this.birthday.trim().split(" ")[0];} }public String getBirthdayTime() {  if ( this.birthday == null ) return ""; return this.birthday.split("\\.")[0];}
public String getIdtype() { if ( this.idtype == null ) return ""; return this.idtype;}
public String getIdno() { if ( this.idno == null ) return ""; return this.idno;}
public String getCorptype() { if ( this.corptype == null ) return ""; return this.corptype;}
public String getCorpname() { if ( this.corpname == null ) return ""; return this.corpname;}
public String getCorpfin() { if ( this.corpfin == null ) return ""; return this.corpfin;}
public String getBusifuture() { if ( this.busifuture == null ) return ""; return this.busifuture;}
public String getCorpzip() { if ( this.corpzip == null ) return ""; return this.corpzip;}
public String getCorptel() { if ( this.corptel == null ) return ""; return this.corptel;}
public String getCorpaddr() { if ( this.corpaddr == null ) return ""; return this.corpaddr;}
public String getHomeaddr() { if ( this.homeaddr == null ) return ""; return this.homeaddr;}
public String getHomezip() { if ( this.homezip == null ) return ""; return this.homezip;}
public String getTel1() { if ( this.tel1 == null ) return ""; return this.tel1;}
public String getTel2() { if ( this.tel2 == null ) return ""; return this.tel2;}
public String getMobile1() { if ( this.mobile1 == null ) return ""; return this.mobile1;}
public String getMobile2() { if ( this.mobile2 == null ) return ""; return this.mobile2;}
public String getLivetype() { if ( this.livetype == null ) return ""; return this.livetype;}
public String getEducation() { if ( this.education == null ) return ""; return this.education;}
public String getMarista() { if ( this.marista == null ) return ""; return this.marista;}
public String getPostlevel() { if ( this.postlevel == null ) return ""; return this.postlevel;}
public String getDeptname() { if ( this.deptname == null ) return ""; return this.deptname;}
public String getPost() { if ( this.post == null ) return ""; return this.post;}
public String getPosttype() { if ( this.posttype == null ) return ""; return this.posttype;}
public int getWorkyears() { return this.workyears;}
public int getIncome() { return this.income;}
public int getHomeincome() { return this.homeincome;}
public int getHomepersons() { return this.homepersons;}
public int getHomeaveincome() { return this.homeaveincome;}
public String getHealth() { if ( this.health == null ) return ""; return this.health;}
public String getMemberflg() { if ( this.memberflg == null ) return ""; return this.memberflg;}
public String getActflg() { if ( this.actflg == null ) return ""; return this.actflg;}
public String getSavbal() { if ( this.savbal == null ) return ""; return this.savbal;}
public String getBusirate() { if ( this.busirate == null ) return ""; return this.busirate;}
public String getLoansta() { if ( this.loansta == null ) return ""; return this.loansta;}
public String getSpousename() { if ( this.spousename == null ) return ""; return this.spousename;}
public String getSpouseidno() { if ( this.spouseidno == null ) return ""; return this.spouseidno;}
public String getSpousecorpaddr() { if ( this.spousecorpaddr == null ) return ""; return this.spousecorpaddr;}
public String getSpousetel() { if ( this.spousetel == null ) return ""; return this.spousetel;}
public int getSpouseincome() { return this.spouseincome;}
public String getTaxregno() { if ( this.taxregno == null ) return ""; return this.taxregno;}
public String getBusilicno() { if ( this.busilicno == null ) return ""; return this.busilicno;}
public String getOrgcode() { if ( this.orgcode == null ) return ""; return this.orgcode;}
public String getRemark() { if ( this.remark == null ) return ""; return this.remark;}
public String getDeptid() { if ( this.deptid == null ) return ""; return this.deptid;}
public String getOperid() { if ( this.operid == null ) return ""; return this.operid;}
public String getOperdate() {  if ( this.operdate == null ) { return ""; } else { return this.operdate.trim().split(" ")[0];} }public String getOperdateTime() {  if ( this.operdate == null ) return ""; return this.operdate.split("\\.")[0];}
public String getUpdoperid() { if ( this.updoperid == null ) return ""; return this.updoperid;}
public String getUpddate() {  if ( this.upddate == null ) { return ""; } else { return this.upddate.trim().split(" ")[0];} }public String getUpddateTime() {  if ( this.upddate == null ) return ""; return this.upddate.split("\\.")[0];}
public String getRecsta() { if ( this.recsta == null ) return ""; return this.recsta;}
public int getAge() { return this.age;}
public String getOtherloansta() { if ( this.otherloansta == null ) return ""; return this.otherloansta;}
public String getValiditytime() {  if ( this.validitytime == null ) { return ""; } else { return this.validitytime.trim().split(" ")[0];} }public String getValiditytimeTime() {  if ( this.validitytime == null ) return ""; return this.validitytime.split("\\.")[0];}
public String getValiditytimetwo() {  if ( this.validitytimetwo == null ) { return ""; } else { return this.validitytimetwo.trim().split(" ")[0];} }public String getValiditytimetwoTime() {  if ( this.validitytimetwo == null ) return ""; return this.validitytimetwo.split("\\.")[0];}
public int getSeq() { return this.seq;}
public void setCustno(String custno) { sqlMaker.setField("custno",custno, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCustno().equals(custno)) cf.add("custno",this.custno,custno); } this.custno=custno;}
public void setCustname(String custname) { sqlMaker.setField("custname",custname, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCustname().equals(custname)) cf.add("custname",this.custname,custname); } this.custname=custname;}
public void setSex(String sex) { sqlMaker.setField("sex",sex, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSex().equals(sex)) cf.add("sex",this.sex,sex); } this.sex=sex;}
public void setBirthday(String birthday) { sqlMaker.setField("birthday",birthday, Field.DATE); if (this.operate_mode.equals("edit")) { if (!this.getBirthday().equals(birthday)) cf.add("birthday",this.birthday,birthday); } this.birthday=birthday;}
public void setIdtype(String idtype) { sqlMaker.setField("idtype",idtype, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getIdtype().equals(idtype)) cf.add("idtype",this.idtype,idtype); } this.idtype=idtype;}
public void setIdno(String idno) { sqlMaker.setField("idno",idno, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getIdno().equals(idno)) cf.add("idno",this.idno,idno); } this.idno=idno;}
public void setCorptype(String corptype) { sqlMaker.setField("corptype",corptype, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCorptype().equals(corptype)) cf.add("corptype",this.corptype,corptype); } this.corptype=corptype;}
public void setCorpname(String corpname) { sqlMaker.setField("corpname",corpname, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCorpname().equals(corpname)) cf.add("corpname",this.corpname,corpname); } this.corpname=corpname;}
public void setCorpfin(String corpfin) { sqlMaker.setField("corpfin",corpfin, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCorpfin().equals(corpfin)) cf.add("corpfin",this.corpfin,corpfin); } this.corpfin=corpfin;}
public void setBusifuture(String busifuture) { sqlMaker.setField("busifuture",busifuture, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getBusifuture().equals(busifuture)) cf.add("busifuture",this.busifuture,busifuture); } this.busifuture=busifuture;}
public void setCorpzip(String corpzip) { sqlMaker.setField("corpzip",corpzip, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCorpzip().equals(corpzip)) cf.add("corpzip",this.corpzip,corpzip); } this.corpzip=corpzip;}
public void setCorptel(String corptel) { sqlMaker.setField("corptel",corptel, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCorptel().equals(corptel)) cf.add("corptel",this.corptel,corptel); } this.corptel=corptel;}
public void setCorpaddr(String corpaddr) { sqlMaker.setField("corpaddr",corpaddr, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCorpaddr().equals(corpaddr)) cf.add("corpaddr",this.corpaddr,corpaddr); } this.corpaddr=corpaddr;}
public void setHomeaddr(String homeaddr) { sqlMaker.setField("homeaddr",homeaddr, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getHomeaddr().equals(homeaddr)) cf.add("homeaddr",this.homeaddr,homeaddr); } this.homeaddr=homeaddr;}
public void setHomezip(String homezip) { sqlMaker.setField("homezip",homezip, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getHomezip().equals(homezip)) cf.add("homezip",this.homezip,homezip); } this.homezip=homezip;}
public void setTel1(String tel1) { sqlMaker.setField("tel1",tel1, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getTel1().equals(tel1)) cf.add("tel1",this.tel1,tel1); } this.tel1=tel1;}
public void setTel2(String tel2) { sqlMaker.setField("tel2",tel2, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getTel2().equals(tel2)) cf.add("tel2",this.tel2,tel2); } this.tel2=tel2;}
public void setMobile1(String mobile1) { sqlMaker.setField("mobile1",mobile1, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getMobile1().equals(mobile1)) cf.add("mobile1",this.mobile1,mobile1); } this.mobile1=mobile1;}
public void setMobile2(String mobile2) { sqlMaker.setField("mobile2",mobile2, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getMobile2().equals(mobile2)) cf.add("mobile2",this.mobile2,mobile2); } this.mobile2=mobile2;}
public void setLivetype(String livetype) { sqlMaker.setField("livetype",livetype, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLivetype().equals(livetype)) cf.add("livetype",this.livetype,livetype); } this.livetype=livetype;}
public void setEducation(String education) { sqlMaker.setField("education",education, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getEducation().equals(education)) cf.add("education",this.education,education); } this.education=education;}
public void setMarista(String marista) { sqlMaker.setField("marista",marista, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getMarista().equals(marista)) cf.add("marista",this.marista,marista); } this.marista=marista;}
public void setPostlevel(String postlevel) { sqlMaker.setField("postlevel",postlevel, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getPostlevel().equals(postlevel)) cf.add("postlevel",this.postlevel,postlevel); } this.postlevel=postlevel;}
public void setDeptname(String deptname) { sqlMaker.setField("deptname",deptname, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getDeptname().equals(deptname)) cf.add("deptname",this.deptname,deptname); } this.deptname=deptname;}
public void setPost(String post) { sqlMaker.setField("post",post, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getPost().equals(post)) cf.add("post",this.post,post); } this.post=post;}
public void setPosttype(String posttype) { sqlMaker.setField("posttype",posttype, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getPosttype().equals(posttype)) cf.add("posttype",this.posttype,posttype); } this.posttype=posttype;}
public void setWorkyears(int workyears) { sqlMaker.setField("workyears",""+workyears, Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getWorkyears()!=workyears) cf.add("workyears",this.workyears+"",workyears+""); } this.workyears=workyears;}
public void setIncome(int income) { sqlMaker.setField("income",""+income, Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getIncome()!=income) cf.add("income",this.income+"",income+""); } this.income=income;}
public void setHomeincome(int homeincome) { sqlMaker.setField("homeincome",""+homeincome, Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getHomeincome()!=homeincome) cf.add("homeincome",this.homeincome+"",homeincome+""); } this.homeincome=homeincome;}
public void setHomepersons(int homepersons) { sqlMaker.setField("homepersons",""+homepersons, Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getHomepersons()!=homepersons) cf.add("homepersons",this.homepersons+"",homepersons+""); } this.homepersons=homepersons;}
public void setHomeaveincome(int homeaveincome) { sqlMaker.setField("homeaveincome",""+homeaveincome, Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getHomeaveincome()!=homeaveincome) cf.add("homeaveincome",this.homeaveincome+"",homeaveincome+""); } this.homeaveincome=homeaveincome;}
public void setHealth(String health) { sqlMaker.setField("health",health, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getHealth().equals(health)) cf.add("health",this.health,health); } this.health=health;}
public void setMemberflg(String memberflg) { sqlMaker.setField("memberflg",memberflg, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getMemberflg().equals(memberflg)) cf.add("memberflg",this.memberflg,memberflg); } this.memberflg=memberflg;}
public void setActflg(String actflg) { sqlMaker.setField("actflg",actflg, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getActflg().equals(actflg)) cf.add("actflg",this.actflg,actflg); } this.actflg=actflg;}
public void setSavbal(String savbal) { sqlMaker.setField("savbal",savbal, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSavbal().equals(savbal)) cf.add("savbal",this.savbal,savbal); } this.savbal=savbal;}
public void setBusirate(String busirate) { sqlMaker.setField("busirate",busirate, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getBusirate().equals(busirate)) cf.add("busirate",this.busirate,busirate); } this.busirate=busirate;}
public void setLoansta(String loansta) { sqlMaker.setField("loansta",loansta, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLoansta().equals(loansta)) cf.add("loansta",this.loansta,loansta); } this.loansta=loansta;}
public void setSpousename(String spousename) { sqlMaker.setField("spousename",spousename, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSpousename().equals(spousename)) cf.add("spousename",this.spousename,spousename); } this.spousename=spousename;}
public void setSpouseidno(String spouseidno) { sqlMaker.setField("spouseidno",spouseidno, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSpouseidno().equals(spouseidno)) cf.add("spouseidno",this.spouseidno,spouseidno); } this.spouseidno=spouseidno;}
public void setSpousecorpaddr(String spousecorpaddr) { sqlMaker.setField("spousecorpaddr",spousecorpaddr, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSpousecorpaddr().equals(spousecorpaddr)) cf.add("spousecorpaddr",this.spousecorpaddr,spousecorpaddr); } this.spousecorpaddr=spousecorpaddr;}
public void setSpousetel(String spousetel) { sqlMaker.setField("spousetel",spousetel, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSpousetel().equals(spousetel)) cf.add("spousetel",this.spousetel,spousetel); } this.spousetel=spousetel;}
public void setSpouseincome(int spouseincome) { sqlMaker.setField("spouseincome",""+spouseincome, Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getSpouseincome()!=spouseincome) cf.add("spouseincome",this.spouseincome+"",spouseincome+""); } this.spouseincome=spouseincome;}
public void setTaxregno(String taxregno) { sqlMaker.setField("taxregno",taxregno, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getTaxregno().equals(taxregno)) cf.add("taxregno",this.taxregno,taxregno); } this.taxregno=taxregno;}
public void setBusilicno(String busilicno) { sqlMaker.setField("busilicno",busilicno, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getBusilicno().equals(busilicno)) cf.add("busilicno",this.busilicno,busilicno); } this.busilicno=busilicno;}
public void setOrgcode(String orgcode) { sqlMaker.setField("orgcode",orgcode, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getOrgcode().equals(orgcode)) cf.add("orgcode",this.orgcode,orgcode); } this.orgcode=orgcode;}
public void setRemark(String remark) { sqlMaker.setField("remark",remark, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRemark().equals(remark)) cf.add("remark",this.remark,remark); } this.remark=remark;}
public void setDeptid(String deptid) { sqlMaker.setField("deptid",deptid, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getDeptid().equals(deptid)) cf.add("deptid",this.deptid,deptid); } this.deptid=deptid;}
public void setOperid(String operid) { sqlMaker.setField("operid",operid, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getOperid().equals(operid)) cf.add("operid",this.operid,operid); } this.operid=operid;}
public void setOperdate(String operdate) { sqlMaker.setField("operdate",operdate, Field.DATE); if (this.operate_mode.equals("edit")) { if (!this.getOperdate().equals(operdate)) cf.add("operdate",this.operdate,operdate); } this.operdate=operdate;}
public void setUpdoperid(String updoperid) { sqlMaker.setField("updoperid",updoperid, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getUpdoperid().equals(updoperid)) cf.add("updoperid",this.updoperid,updoperid); } this.updoperid=updoperid;}
public void setUpddate(String upddate) { sqlMaker.setField("upddate",upddate, Field.DATE); if (this.operate_mode.equals("edit")) { if (!this.getUpddate().equals(upddate)) cf.add("upddate",this.upddate,upddate); } this.upddate=upddate;}
public void setRecsta(String recsta) { sqlMaker.setField("recsta",recsta, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRecsta().equals(recsta)) cf.add("recsta",this.recsta,recsta); } this.recsta=recsta;}
public void setAge(int age) { sqlMaker.setField("age",""+age, Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getAge()!=age) cf.add("age",this.age+"",age+""); } this.age=age;}
public void setOtherloansta(String otherloansta) { sqlMaker.setField("otherloansta",otherloansta, Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getOtherloansta().equals(otherloansta)) cf.add("otherloansta",this.otherloansta,otherloansta); } this.otherloansta=otherloansta;}
public void setValiditytime(String validitytime) { sqlMaker.setField("validitytime",validitytime, Field.DATE); if (this.operate_mode.equals("edit")) { if (!this.getValiditytime().equals(validitytime)) cf.add("validitytime",this.validitytime,validitytime); } this.validitytime=validitytime;}
public void setValiditytimetwo(String validitytimetwo) { sqlMaker.setField("validitytimetwo",validitytimetwo, Field.DATE); if (this.operate_mode.equals("edit")) { if (!this.getValiditytimetwo().equals(validitytimetwo)) cf.add("validitytimetwo",this.validitytimetwo,validitytimetwo); } this.validitytimetwo=validitytimetwo;}
public void setSeq(int seq) { sqlMaker.setField("seq",""+seq, Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getSeq()!=seq) cf.add("seq",this.seq+"",seq+""); } this.seq=seq;}
public void init(int i,ActionRequest actionRequest) throws Exception { if ( actionRequest.getFieldValue(i,"custno") !=null ) {this.setCustno(actionRequest.getFieldValue(i,"custno"));}
if ( actionRequest.getFieldValue(i,"custname") !=null ) {this.setCustname(actionRequest.getFieldValue(i,"custname"));}
if ( actionRequest.getFieldValue(i,"sex") !=null ) {this.setSex(actionRequest.getFieldValue(i,"sex"));}
if ( actionRequest.getFieldValue(i,"birthday") !=null ) {this.setBirthday(actionRequest.getFieldValue(i,"birthday"));}
if ( actionRequest.getFieldValue(i,"idtype") !=null ) {this.setIdtype(actionRequest.getFieldValue(i,"idtype"));}
if ( actionRequest.getFieldValue(i,"idno") !=null ) {this.setIdno(actionRequest.getFieldValue(i,"idno"));}
if ( actionRequest.getFieldValue(i,"corptype") !=null ) {this.setCorptype(actionRequest.getFieldValue(i,"corptype"));}
if ( actionRequest.getFieldValue(i,"corpname") !=null ) {this.setCorpname(actionRequest.getFieldValue(i,"corpname"));}
if ( actionRequest.getFieldValue(i,"corpfin") !=null ) {this.setCorpfin(actionRequest.getFieldValue(i,"corpfin"));}
if ( actionRequest.getFieldValue(i,"busifuture") !=null ) {this.setBusifuture(actionRequest.getFieldValue(i,"busifuture"));}
if ( actionRequest.getFieldValue(i,"corpzip") !=null ) {this.setCorpzip(actionRequest.getFieldValue(i,"corpzip"));}
if ( actionRequest.getFieldValue(i,"corptel") !=null ) {this.setCorptel(actionRequest.getFieldValue(i,"corptel"));}
if ( actionRequest.getFieldValue(i,"corpaddr") !=null ) {this.setCorpaddr(actionRequest.getFieldValue(i,"corpaddr"));}
if ( actionRequest.getFieldValue(i,"homeaddr") !=null ) {this.setHomeaddr(actionRequest.getFieldValue(i,"homeaddr"));}
if ( actionRequest.getFieldValue(i,"homezip") !=null ) {this.setHomezip(actionRequest.getFieldValue(i,"homezip"));}
if ( actionRequest.getFieldValue(i,"tel1") !=null ) {this.setTel1(actionRequest.getFieldValue(i,"tel1"));}
if ( actionRequest.getFieldValue(i,"tel2") !=null ) {this.setTel2(actionRequest.getFieldValue(i,"tel2"));}
if ( actionRequest.getFieldValue(i,"mobile1") !=null ) {this.setMobile1(actionRequest.getFieldValue(i,"mobile1"));}
if ( actionRequest.getFieldValue(i,"mobile2") !=null ) {this.setMobile2(actionRequest.getFieldValue(i,"mobile2"));}
if ( actionRequest.getFieldValue(i,"livetype") !=null ) {this.setLivetype(actionRequest.getFieldValue(i,"livetype"));}
if ( actionRequest.getFieldValue(i,"education") !=null ) {this.setEducation(actionRequest.getFieldValue(i,"education"));}
if ( actionRequest.getFieldValue(i,"marista") !=null ) {this.setMarista(actionRequest.getFieldValue(i,"marista"));}
if ( actionRequest.getFieldValue(i,"postlevel") !=null ) {this.setPostlevel(actionRequest.getFieldValue(i,"postlevel"));}
if ( actionRequest.getFieldValue(i,"deptname") !=null ) {this.setDeptname(actionRequest.getFieldValue(i,"deptname"));}
if ( actionRequest.getFieldValue(i,"post") !=null ) {this.setPost(actionRequest.getFieldValue(i,"post"));}
if ( actionRequest.getFieldValue(i,"posttype") !=null ) {this.setPosttype(actionRequest.getFieldValue(i,"posttype"));}
if ( actionRequest.getFieldValue(i,"workyears") !=null && actionRequest.getFieldValue(i,"workyears").trim().length() > 0 ) {this.setWorkyears(Integer.parseInt(actionRequest.getFieldValue(i,"workyears")));}
if ( actionRequest.getFieldValue(i,"income") !=null && actionRequest.getFieldValue(i,"income").trim().length() > 0 ) {this.setIncome(Integer.parseInt(actionRequest.getFieldValue(i, "income")));}
if ( actionRequest.getFieldValue(i,"homeincome") !=null && actionRequest.getFieldValue(i,"homeincome").trim().length() > 0 ) {this.setHomeincome(Integer.parseInt(actionRequest.getFieldValue(i, "homeincome")));}
if ( actionRequest.getFieldValue(i,"homepersons") !=null && actionRequest.getFieldValue(i,"homepersons").trim().length() > 0 ) {this.setHomepersons(Integer.parseInt(actionRequest.getFieldValue(i,"homepersons")));}
if ( actionRequest.getFieldValue(i,"homeaveincome") !=null && actionRequest.getFieldValue(i,"homeaveincome").trim().length() > 0 ) {this.setHomeaveincome(Integer.parseInt(actionRequest.getFieldValue(i, "homeaveincome")));}
if ( actionRequest.getFieldValue(i,"health") !=null ) {this.setHealth(actionRequest.getFieldValue(i,"health"));}
if ( actionRequest.getFieldValue(i,"memberflg") !=null ) {this.setMemberflg(actionRequest.getFieldValue(i,"memberflg"));}
if ( actionRequest.getFieldValue(i,"actflg") !=null ) {this.setActflg(actionRequest.getFieldValue(i,"actflg"));}
if ( actionRequest.getFieldValue(i,"savbal") !=null ) {this.setSavbal(actionRequest.getFieldValue(i,"savbal"));}
if ( actionRequest.getFieldValue(i,"busirate") !=null ) {this.setBusirate(actionRequest.getFieldValue(i,"busirate"));}
if ( actionRequest.getFieldValue(i,"loansta") !=null ) {this.setLoansta(actionRequest.getFieldValue(i,"loansta"));}
if ( actionRequest.getFieldValue(i,"spousename") !=null ) {this.setSpousename(actionRequest.getFieldValue(i,"spousename"));}
if ( actionRequest.getFieldValue(i,"spouseidno") !=null ) {this.setSpouseidno(actionRequest.getFieldValue(i,"spouseidno"));}
if ( actionRequest.getFieldValue(i,"spousecorpaddr") !=null ) {this.setSpousecorpaddr(actionRequest.getFieldValue(i,"spousecorpaddr"));}
if ( actionRequest.getFieldValue(i,"spousetel") !=null ) {this.setSpousetel(actionRequest.getFieldValue(i,"spousetel"));}
if ( actionRequest.getFieldValue(i,"spouseincome") !=null && actionRequest.getFieldValue(i,"spouseincome").trim().length() > 0 ) {this.setSpouseincome(Integer.parseInt(actionRequest.getFieldValue(i,"spouseincome")));}
if ( actionRequest.getFieldValue(i,"taxregno") !=null ) {this.setTaxregno(actionRequest.getFieldValue(i,"taxregno"));}
if ( actionRequest.getFieldValue(i,"busilicno") !=null ) {this.setBusilicno(actionRequest.getFieldValue(i,"busilicno"));}
if ( actionRequest.getFieldValue(i,"orgcode") !=null ) {this.setOrgcode(actionRequest.getFieldValue(i,"orgcode"));}
if ( actionRequest.getFieldValue(i,"remark") !=null ) {this.setRemark(actionRequest.getFieldValue(i,"remark"));}
if ( actionRequest.getFieldValue(i,"deptid") !=null ) {this.setDeptid(actionRequest.getFieldValue(i,"deptid"));}
if ( actionRequest.getFieldValue(i,"operid") !=null ) {this.setOperid(actionRequest.getFieldValue(i,"operid"));}
if ( actionRequest.getFieldValue(i,"operdate") !=null ) {this.setOperdate(actionRequest.getFieldValue(i,"operdate"));}
if ( actionRequest.getFieldValue(i,"updoperid") !=null ) {this.setUpdoperid(actionRequest.getFieldValue(i,"updoperid"));}
if ( actionRequest.getFieldValue(i,"upddate") !=null ) {this.setUpddate(actionRequest.getFieldValue(i,"upddate"));}
if ( actionRequest.getFieldValue(i,"recsta") !=null ) {this.setRecsta(actionRequest.getFieldValue(i,"recsta"));}
if ( actionRequest.getFieldValue(i,"age") !=null && actionRequest.getFieldValue(i,"age").trim().length() > 0 ) {this.setAge(Integer.parseInt(actionRequest.getFieldValue(i,"age")));}
if ( actionRequest.getFieldValue(i,"otherloansta") !=null ) {this.setOtherloansta(actionRequest.getFieldValue(i,"otherloansta"));}
if ( actionRequest.getFieldValue(i,"validitytime") !=null ) {this.setValiditytime(actionRequest.getFieldValue(i,"validitytime"));}
if ( actionRequest.getFieldValue(i,"validitytimetwo") !=null ) {this.setValiditytimetwo(actionRequest.getFieldValue(i,"validitytimetwo"));}
if ( actionRequest.getFieldValue(i,"seq") !=null && actionRequest.getFieldValue(i,"seq").trim().length() > 0 ) {this.setSeq(Integer.parseInt(actionRequest.getFieldValue(i,"seq")));}
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { LNPCIF obj = (LNPCIF)super.clone();obj.setCustno(obj.custno);
obj.setCustname(obj.custname);
obj.setSex(obj.sex);
obj.setBirthday(obj.birthday);
obj.setIdtype(obj.idtype);
obj.setIdno(obj.idno);
obj.setCorptype(obj.corptype);
obj.setCorpname(obj.corpname);
obj.setCorpfin(obj.corpfin);
obj.setBusifuture(obj.busifuture);
obj.setCorpzip(obj.corpzip);
obj.setCorptel(obj.corptel);
obj.setCorpaddr(obj.corpaddr);
obj.setHomeaddr(obj.homeaddr);
obj.setHomezip(obj.homezip);
obj.setTel1(obj.tel1);
obj.setTel2(obj.tel2);
obj.setMobile1(obj.mobile1);
obj.setMobile2(obj.mobile2);
obj.setLivetype(obj.livetype);
obj.setEducation(obj.education);
obj.setMarista(obj.marista);
obj.setPostlevel(obj.postlevel);
obj.setDeptname(obj.deptname);
obj.setPost(obj.post);
obj.setPosttype(obj.posttype);
obj.setWorkyears(obj.workyears);
obj.setIncome(obj.income);
obj.setHomeincome(obj.homeincome);
obj.setHomepersons(obj.homepersons);
obj.setHomeaveincome(obj.homeaveincome);
obj.setHealth(obj.health);
obj.setMemberflg(obj.memberflg);
obj.setActflg(obj.actflg);
obj.setSavbal(obj.savbal);
obj.setBusirate(obj.busirate);
obj.setLoansta(obj.loansta);
obj.setSpousename(obj.spousename);
obj.setSpouseidno(obj.spouseidno);
obj.setSpousecorpaddr(obj.spousecorpaddr);
obj.setSpousetel(obj.spousetel);
obj.setSpouseincome(obj.spouseincome);
obj.setTaxregno(obj.taxregno);
obj.setBusilicno(obj.busilicno);
obj.setOrgcode(obj.orgcode);
obj.setRemark(obj.remark);
obj.setDeptid(obj.deptid);
obj.setOperid(obj.operid);
obj.setOperdate(obj.operdate);
obj.setUpdoperid(obj.updoperid);
obj.setUpddate(obj.upddate);
obj.setRecsta(obj.recsta);
obj.setAge(obj.age);
obj.setOtherloansta(obj.otherloansta);
obj.setValiditytime(obj.validitytime);
obj.setValiditytimetwo(obj.validitytimetwo);
obj.setSeq(obj.seq);
return obj;}}