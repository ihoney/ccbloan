package com.ccb.dao;
import java.util.*;
import pub.platform.db.*;
import pub.platform.utils.*;
import pub.platform.db.AbstractBasicBean;
public class LNODSBACCTARREARS extends AbstractBasicBean implements Cloneable {
     public static List find(String sSqlWhere) {           return new LNODSBACCTARREARS().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere) {           return new LNODSBACCTARREARS().findAndLockByWhere(sSqlWhere);      }       public static LNODSBACCTARREARS findFirst(String sSqlWhere) {           return (LNODSBACCTARREARS)new LNODSBACCTARREARS().findFirstByWhere(sSqlWhere);      }       public static LNODSBACCTARREARS findFirstAndLock(String sSqlWhere) {           return (LNODSBACCTARREARS)new LNODSBACCTARREARS().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) {           return new LNODSBACCTARREARS().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease) {           LNODSBACCTARREARS bean = new LNODSBACCTARREARS();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) {           LNODSBACCTARREARS bean = new LNODSBACCTARREARS();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static LNODSBACCTARREARS findFirst(String sSqlWhere,boolean isAutoRelease) {           LNODSBACCTARREARS bean = new LNODSBACCTARREARS();           bean.setAutoRelease(isAutoRelease);           return (LNODSBACCTARREARS)bean.findFirstByWhere(sSqlWhere);      }       public static LNODSBACCTARREARS findFirstAndLock(String sSqlWhere,boolean isAutoRelease) {           LNODSBACCTARREARS bean = new LNODSBACCTARREARS();           bean.setAutoRelease(isAutoRelease);           return (LNODSBACCTARREARS)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease) {           LNODSBACCTARREARS bean = new LNODSBACCTARREARS();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      }      public static List findByRow(String sSqlWhere,int row) {           return new LNODSBACCTARREARS().findByWhereByRow(sSqlWhere,row);      } String ln_acct_no;
String sdate;
String curr_cd;
int tterm;
String rdate;
double scapi;
double prin_pay_amt;
double sacapi;
double racapi;
double sinte;
double ret_fact_int;
double sainte;
double rainte;
double safine;
double rafine;
double sbfine;
double rbfine;
double rfoul;
String payoffdate;
String payoffflag;
String trad_bran;
String tranid;
int stoverduedays;
int dyoverduedays;
public static final String TABLENAME ="ln_odsb_acct_arrears";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
public void addObject(List list,RecordSet rs) {
LNODSBACCTARREARS abb = new LNODSBACCTARREARS();
abb.ln_acct_no=rs.getString("ln_acct_no");abb.setKeyValue("LN_ACCT_NO",""+abb.getLn_acct_no());
abb.sdate=rs.getString("sdate");abb.setKeyValue("SDATE",""+abb.getSdate());
abb.curr_cd=rs.getString("curr_cd");abb.setKeyValue("CURR_CD",""+abb.getCurr_cd());
abb.tterm=rs.getInt("tterm");abb.setKeyValue("TTERM",""+abb.getTterm());
abb.rdate=rs.getString("rdate");abb.setKeyValue("RDATE",""+abb.getRdate());
abb.scapi=rs.getDouble("scapi");abb.setKeyValue("SCAPI",""+abb.getScapi());
abb.prin_pay_amt=rs.getDouble("prin_pay_amt");abb.setKeyValue("PRIN_PAY_AMT",""+abb.getPrin_pay_amt());
abb.sacapi=rs.getDouble("sacapi");abb.setKeyValue("SACAPI",""+abb.getSacapi());
abb.racapi=rs.getDouble("racapi");abb.setKeyValue("RACAPI",""+abb.getRacapi());
abb.sinte=rs.getDouble("sinte");abb.setKeyValue("SINTE",""+abb.getSinte());
abb.ret_fact_int=rs.getDouble("ret_fact_int");abb.setKeyValue("RET_FACT_INT",""+abb.getRet_fact_int());
abb.sainte=rs.getDouble("sainte");abb.setKeyValue("SAINTE",""+abb.getSainte());
abb.rainte=rs.getDouble("rainte");abb.setKeyValue("RAINTE",""+abb.getRainte());
abb.safine=rs.getDouble("safine");abb.setKeyValue("SAFINE",""+abb.getSafine());
abb.rafine=rs.getDouble("rafine");abb.setKeyValue("RAFINE",""+abb.getRafine());
abb.sbfine=rs.getDouble("sbfine");abb.setKeyValue("SBFINE",""+abb.getSbfine());
abb.rbfine=rs.getDouble("rbfine");abb.setKeyValue("RBFINE",""+abb.getRbfine());
abb.rfoul=rs.getDouble("rfoul");abb.setKeyValue("RFOUL",""+abb.getRfoul());
abb.payoffdate=rs.getString("payoffdate");abb.setKeyValue("PAYOFFDATE",""+abb.getPayoffdate());
abb.payoffflag=rs.getString("payoffflag");abb.setKeyValue("PAYOFFFLAG",""+abb.getPayoffflag());
abb.trad_bran=rs.getString("trad_bran");abb.setKeyValue("TRAD_BRAN",""+abb.getTrad_bran());
abb.tranid=rs.getString("tranid");abb.setKeyValue("TRANID",""+abb.getTranid());
abb.stoverduedays=rs.getInt("stoverduedays");abb.setKeyValue("STOVERDUEDAYS",""+abb.getStoverduedays());
abb.dyoverduedays=rs.getInt("dyoverduedays");abb.setKeyValue("DYOVERDUEDAYS",""+abb.getDyoverduedays());
list.add(abb);
abb.operate_mode = "edit";
}public String getLn_acct_no() { if ( this.ln_acct_no == null ) return ""; return this.ln_acct_no;}
public String getSdate() { if ( this.sdate == null ) return ""; return this.sdate;}
public String getCurr_cd() { if ( this.curr_cd == null ) return ""; return this.curr_cd;}
public int getTterm() { return this.tterm;}
public String getRdate() { if ( this.rdate == null ) return ""; return this.rdate;}
public double getScapi() { return this.scapi;}
public double getPrin_pay_amt() { return this.prin_pay_amt;}
public double getSacapi() { return this.sacapi;}
public double getRacapi() { return this.racapi;}
public double getSinte() { return this.sinte;}
public double getRet_fact_int() { return this.ret_fact_int;}
public double getSainte() { return this.sainte;}
public double getRainte() { return this.rainte;}
public double getSafine() { return this.safine;}
public double getRafine() { return this.rafine;}
public double getSbfine() { return this.sbfine;}
public double getRbfine() { return this.rbfine;}
public double getRfoul() { return this.rfoul;}
public String getPayoffdate() { if ( this.payoffdate == null ) return ""; return this.payoffdate;}
public String getPayoffflag() { if ( this.payoffflag == null ) return ""; return this.payoffflag;}
public String getTrad_bran() { if ( this.trad_bran == null ) return ""; return this.trad_bran;}
public String getTranid() { if ( this.tranid == null ) return ""; return this.tranid;}
public int getStoverduedays() { return this.stoverduedays;}
public int getDyoverduedays() { return this.dyoverduedays;}
public void setLn_acct_no(String ln_acct_no) { sqlMaker.setField("ln_acct_no",ln_acct_no,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLn_acct_no().equals(ln_acct_no)) cf.add("ln_acct_no",this.ln_acct_no,ln_acct_no); } this.ln_acct_no=ln_acct_no;}
public void setSdate(String sdate) { sqlMaker.setField("sdate",sdate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSdate().equals(sdate)) cf.add("sdate",this.sdate,sdate); } this.sdate=sdate;}
public void setCurr_cd(String curr_cd) { sqlMaker.setField("curr_cd",curr_cd,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCurr_cd().equals(curr_cd)) cf.add("curr_cd",this.curr_cd,curr_cd); } this.curr_cd=curr_cd;}
public void setTterm(int tterm) { sqlMaker.setField("tterm",""+tterm,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getTterm()!=tterm) cf.add("tterm",this.tterm+"",tterm+""); } this.tterm=tterm;}
public void setRdate(String rdate) { sqlMaker.setField("rdate",rdate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRdate().equals(rdate)) cf.add("rdate",this.rdate,rdate); } this.rdate=rdate;}
public void setScapi(double scapi) { sqlMaker.setField("scapi",""+scapi,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getScapi()!=scapi) cf.add("scapi",this.scapi+"",scapi+""); } this.scapi=scapi;}
public void setPrin_pay_amt(double prin_pay_amt) { sqlMaker.setField("prin_pay_amt",""+prin_pay_amt,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getPrin_pay_amt()!=prin_pay_amt) cf.add("prin_pay_amt",this.prin_pay_amt+"",prin_pay_amt+""); } this.prin_pay_amt=prin_pay_amt;}
public void setSacapi(double sacapi) { sqlMaker.setField("sacapi",""+sacapi,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getSacapi()!=sacapi) cf.add("sacapi",this.sacapi+"",sacapi+""); } this.sacapi=sacapi;}
public void setRacapi(double racapi) { sqlMaker.setField("racapi",""+racapi,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRacapi()!=racapi) cf.add("racapi",this.racapi+"",racapi+""); } this.racapi=racapi;}
public void setSinte(double sinte) { sqlMaker.setField("sinte",""+sinte,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getSinte()!=sinte) cf.add("sinte",this.sinte+"",sinte+""); } this.sinte=sinte;}
public void setRet_fact_int(double ret_fact_int) { sqlMaker.setField("ret_fact_int",""+ret_fact_int,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRet_fact_int()!=ret_fact_int) cf.add("ret_fact_int",this.ret_fact_int+"",ret_fact_int+""); } this.ret_fact_int=ret_fact_int;}
public void setSainte(double sainte) { sqlMaker.setField("sainte",""+sainte,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getSainte()!=sainte) cf.add("sainte",this.sainte+"",sainte+""); } this.sainte=sainte;}
public void setRainte(double rainte) { sqlMaker.setField("rainte",""+rainte,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRainte()!=rainte) cf.add("rainte",this.rainte+"",rainte+""); } this.rainte=rainte;}
public void setSafine(double safine) { sqlMaker.setField("safine",""+safine,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getSafine()!=safine) cf.add("safine",this.safine+"",safine+""); } this.safine=safine;}
public void setRafine(double rafine) { sqlMaker.setField("rafine",""+rafine,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRafine()!=rafine) cf.add("rafine",this.rafine+"",rafine+""); } this.rafine=rafine;}
public void setSbfine(double sbfine) { sqlMaker.setField("sbfine",""+sbfine,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getSbfine()!=sbfine) cf.add("sbfine",this.sbfine+"",sbfine+""); } this.sbfine=sbfine;}
public void setRbfine(double rbfine) { sqlMaker.setField("rbfine",""+rbfine,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRbfine()!=rbfine) cf.add("rbfine",this.rbfine+"",rbfine+""); } this.rbfine=rbfine;}
public void setRfoul(double rfoul) { sqlMaker.setField("rfoul",""+rfoul,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRfoul()!=rfoul) cf.add("rfoul",this.rfoul+"",rfoul+""); } this.rfoul=rfoul;}
public void setPayoffdate(String payoffdate) { sqlMaker.setField("payoffdate",payoffdate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getPayoffdate().equals(payoffdate)) cf.add("payoffdate",this.payoffdate,payoffdate); } this.payoffdate=payoffdate;}
public void setPayoffflag(String payoffflag) { sqlMaker.setField("payoffflag",payoffflag,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getPayoffflag().equals(payoffflag)) cf.add("payoffflag",this.payoffflag,payoffflag); } this.payoffflag=payoffflag;}
public void setTrad_bran(String trad_bran) { sqlMaker.setField("trad_bran",trad_bran,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getTrad_bran().equals(trad_bran)) cf.add("trad_bran",this.trad_bran,trad_bran); } this.trad_bran=trad_bran;}
public void setTranid(String tranid) { sqlMaker.setField("tranid",tranid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getTranid().equals(tranid)) cf.add("tranid",this.tranid,tranid); } this.tranid=tranid;}
public void setStoverduedays(int stoverduedays) { sqlMaker.setField("stoverduedays",""+stoverduedays,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getStoverduedays()!=stoverduedays) cf.add("stoverduedays",this.stoverduedays+"",stoverduedays+""); } this.stoverduedays=stoverduedays;}
public void setDyoverduedays(int dyoverduedays) { sqlMaker.setField("dyoverduedays",""+dyoverduedays,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getDyoverduedays()!=dyoverduedays) cf.add("dyoverduedays",this.dyoverduedays+"",dyoverduedays+""); } this.dyoverduedays=dyoverduedays;}
public void init(int i,ActionRequest actionRequest) throws Exception { if ( actionRequest.getFieldValue(i,"ln_acct_no") !=null ) {this.setLn_acct_no(actionRequest.getFieldValue(i,"ln_acct_no"));}
if ( actionRequest.getFieldValue(i,"sdate") !=null ) {this.setSdate(actionRequest.getFieldValue(i,"sdate"));}
if ( actionRequest.getFieldValue(i,"curr_cd") !=null ) {this.setCurr_cd(actionRequest.getFieldValue(i,"curr_cd"));}
if ( actionRequest.getFieldValue(i,"tterm") !=null && actionRequest.getFieldValue(i,"tterm").trim().length() > 0 ) {this.setTterm(Integer.parseInt(actionRequest.getFieldValue(i,"tterm")));}
if ( actionRequest.getFieldValue(i,"rdate") !=null ) {this.setRdate(actionRequest.getFieldValue(i,"rdate"));}
if ( actionRequest.getFieldValue(i,"scapi") !=null && actionRequest.getFieldValue(i,"scapi").trim().length() > 0 ) {this.setScapi(Double.parseDouble(actionRequest.getFieldValue(i,"scapi")));}
if ( actionRequest.getFieldValue(i,"prin_pay_amt") !=null && actionRequest.getFieldValue(i,"prin_pay_amt").trim().length() > 0 ) {this.setPrin_pay_amt(Double.parseDouble(actionRequest.getFieldValue(i,"prin_pay_amt")));}
if ( actionRequest.getFieldValue(i,"sacapi") !=null && actionRequest.getFieldValue(i,"sacapi").trim().length() > 0 ) {this.setSacapi(Double.parseDouble(actionRequest.getFieldValue(i,"sacapi")));}
if ( actionRequest.getFieldValue(i,"racapi") !=null && actionRequest.getFieldValue(i,"racapi").trim().length() > 0 ) {this.setRacapi(Double.parseDouble(actionRequest.getFieldValue(i,"racapi")));}
if ( actionRequest.getFieldValue(i,"sinte") !=null && actionRequest.getFieldValue(i,"sinte").trim().length() > 0 ) {this.setSinte(Double.parseDouble(actionRequest.getFieldValue(i,"sinte")));}
if ( actionRequest.getFieldValue(i,"ret_fact_int") !=null && actionRequest.getFieldValue(i,"ret_fact_int").trim().length() > 0 ) {this.setRet_fact_int(Double.parseDouble(actionRequest.getFieldValue(i,"ret_fact_int")));}
if ( actionRequest.getFieldValue(i,"sainte") !=null && actionRequest.getFieldValue(i,"sainte").trim().length() > 0 ) {this.setSainte(Double.parseDouble(actionRequest.getFieldValue(i,"sainte")));}
if ( actionRequest.getFieldValue(i,"rainte") !=null && actionRequest.getFieldValue(i,"rainte").trim().length() > 0 ) {this.setRainte(Double.parseDouble(actionRequest.getFieldValue(i,"rainte")));}
if ( actionRequest.getFieldValue(i,"safine") !=null && actionRequest.getFieldValue(i,"safine").trim().length() > 0 ) {this.setSafine(Double.parseDouble(actionRequest.getFieldValue(i,"safine")));}
if ( actionRequest.getFieldValue(i,"rafine") !=null && actionRequest.getFieldValue(i,"rafine").trim().length() > 0 ) {this.setRafine(Double.parseDouble(actionRequest.getFieldValue(i,"rafine")));}
if ( actionRequest.getFieldValue(i,"sbfine") !=null && actionRequest.getFieldValue(i,"sbfine").trim().length() > 0 ) {this.setSbfine(Double.parseDouble(actionRequest.getFieldValue(i,"sbfine")));}
if ( actionRequest.getFieldValue(i,"rbfine") !=null && actionRequest.getFieldValue(i,"rbfine").trim().length() > 0 ) {this.setRbfine(Double.parseDouble(actionRequest.getFieldValue(i,"rbfine")));}
if ( actionRequest.getFieldValue(i,"rfoul") !=null && actionRequest.getFieldValue(i,"rfoul").trim().length() > 0 ) {this.setRfoul(Double.parseDouble(actionRequest.getFieldValue(i,"rfoul")));}
if ( actionRequest.getFieldValue(i,"payoffdate") !=null ) {this.setPayoffdate(actionRequest.getFieldValue(i,"payoffdate"));}
if ( actionRequest.getFieldValue(i,"payoffflag") !=null ) {this.setPayoffflag(actionRequest.getFieldValue(i,"payoffflag"));}
if ( actionRequest.getFieldValue(i,"trad_bran") !=null ) {this.setTrad_bran(actionRequest.getFieldValue(i,"trad_bran"));}
if ( actionRequest.getFieldValue(i,"tranid") !=null ) {this.setTranid(actionRequest.getFieldValue(i,"tranid"));}
if ( actionRequest.getFieldValue(i,"stoverduedays") !=null && actionRequest.getFieldValue(i,"stoverduedays").trim().length() > 0 ) {this.setStoverduedays(Integer.parseInt(actionRequest.getFieldValue(i,"stoverduedays")));}
if ( actionRequest.getFieldValue(i,"dyoverduedays") !=null && actionRequest.getFieldValue(i,"dyoverduedays").trim().length() > 0 ) {this.setDyoverduedays(Integer.parseInt(actionRequest.getFieldValue(i,"dyoverduedays")));}
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { LNODSBACCTARREARS obj = (LNODSBACCTARREARS)super.clone();obj.setLn_acct_no(obj.ln_acct_no);
obj.setSdate(obj.sdate);
obj.setCurr_cd(obj.curr_cd);
obj.setTterm(obj.tterm);
obj.setRdate(obj.rdate);
obj.setScapi(obj.scapi);
obj.setPrin_pay_amt(obj.prin_pay_amt);
obj.setSacapi(obj.sacapi);
obj.setRacapi(obj.racapi);
obj.setSinte(obj.sinte);
obj.setRet_fact_int(obj.ret_fact_int);
obj.setSainte(obj.sainte);
obj.setRainte(obj.rainte);
obj.setSafine(obj.safine);
obj.setRafine(obj.rafine);
obj.setSbfine(obj.sbfine);
obj.setRbfine(obj.rbfine);
obj.setRfoul(obj.rfoul);
obj.setPayoffdate(obj.payoffdate);
obj.setPayoffflag(obj.payoffflag);
obj.setTrad_bran(obj.trad_bran);
obj.setTranid(obj.tranid);
obj.setStoverduedays(obj.stoverduedays);
obj.setDyoverduedays(obj.dyoverduedays);
return obj;}}