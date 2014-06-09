package com.ccb.dao;
import java.util.*;
import pub.platform.db.*;
import pub.platform.utils.*;
import pub.platform.db.AbstractBasicBean;
public class LNODSBACCTTOTLDATA extends AbstractBasicBean implements Cloneable {
     public static List find(String sSqlWhere) {           return new LNODSBACCTTOTLDATA().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere) {           return new LNODSBACCTTOTLDATA().findAndLockByWhere(sSqlWhere);      }       public static LNODSBACCTTOTLDATA findFirst(String sSqlWhere) {           return (LNODSBACCTTOTLDATA)new LNODSBACCTTOTLDATA().findFirstByWhere(sSqlWhere);      }       public static LNODSBACCTTOTLDATA findFirstAndLock(String sSqlWhere) {           return (LNODSBACCTTOTLDATA)new LNODSBACCTTOTLDATA().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) {           return new LNODSBACCTTOTLDATA().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease) {           LNODSBACCTTOTLDATA bean = new LNODSBACCTTOTLDATA();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) {           LNODSBACCTTOTLDATA bean = new LNODSBACCTTOTLDATA();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static LNODSBACCTTOTLDATA findFirst(String sSqlWhere,boolean isAutoRelease) {           LNODSBACCTTOTLDATA bean = new LNODSBACCTTOTLDATA();           bean.setAutoRelease(isAutoRelease);           return (LNODSBACCTTOTLDATA)bean.findFirstByWhere(sSqlWhere);      }       public static LNODSBACCTTOTLDATA findFirstAndLock(String sSqlWhere,boolean isAutoRelease) {           LNODSBACCTTOTLDATA bean = new LNODSBACCTTOTLDATA();           bean.setAutoRelease(isAutoRelease);           return (LNODSBACCTTOTLDATA)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease) {           LNODSBACCTTOTLDATA bean = new LNODSBACCTTOTLDATA();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      }      public static List findByRow(String sSqlWhere,int row) {           return new LNODSBACCTTOTLDATA().findByWhereByRow(sSqlWhere,row);      } String ln_acct_no;
String ods_src_dt;
double bal_lastyear;
double bal_lastmonth;
double bal_yesterday;
double bal_today;
double relecapi_thisyear;
double payout_amt_thismonth;
double relecapi_today;
double racapi_thisyear;
double racapi_thismonth;
double racapi_today;
double rnbcapi_thisyear;
double rnbcapi_thismonth;
double rnbcapi_today;
double sintebal_lastyear;
double sintebal_lastterm;
double sintebal_thisterm2;
double sintebal_thisterm;
double dintebal_lastyear;
double dintebal_lastterm2;
double dintebal_lastterm;
double dintebal_thisterm;
double intebal;
public static final String TABLENAME ="ln_odsb_acct_totldata";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
public void addObject(List list,RecordSet rs) {
LNODSBACCTTOTLDATA abb = new LNODSBACCTTOTLDATA();
abb.ln_acct_no=rs.getString("ln_acct_no");abb.setKeyValue("LN_ACCT_NO",""+abb.getLn_acct_no());
abb.ods_src_dt=rs.getString("ods_src_dt");abb.setKeyValue("ODS_SRC_DT",""+abb.getOds_src_dt());
abb.bal_lastyear=rs.getDouble("bal_lastyear");abb.setKeyValue("BAL_LASTYEAR",""+abb.getBal_lastyear());
abb.bal_lastmonth=rs.getDouble("bal_lastmonth");abb.setKeyValue("BAL_LASTMONTH",""+abb.getBal_lastmonth());
abb.bal_yesterday=rs.getDouble("bal_yesterday");abb.setKeyValue("BAL_YESTERDAY",""+abb.getBal_yesterday());
abb.bal_today=rs.getDouble("bal_today");abb.setKeyValue("BAL_TODAY",""+abb.getBal_today());
abb.relecapi_thisyear=rs.getDouble("relecapi_thisyear");abb.setKeyValue("RELECAPI_THISYEAR",""+abb.getRelecapi_thisyear());
abb.payout_amt_thismonth=rs.getDouble("payout_amt_thismonth");abb.setKeyValue("PAYOUT_AMT_THISMONTH",""+abb.getPayout_amt_thismonth());
abb.relecapi_today=rs.getDouble("relecapi_today");abb.setKeyValue("RELECAPI_TODAY",""+abb.getRelecapi_today());
abb.racapi_thisyear=rs.getDouble("racapi_thisyear");abb.setKeyValue("RACAPI_THISYEAR",""+abb.getRacapi_thisyear());
abb.racapi_thismonth=rs.getDouble("racapi_thismonth");abb.setKeyValue("RACAPI_THISMONTH",""+abb.getRacapi_thismonth());
abb.racapi_today=rs.getDouble("racapi_today");abb.setKeyValue("RACAPI_TODAY",""+abb.getRacapi_today());
abb.rnbcapi_thisyear=rs.getDouble("rnbcapi_thisyear");abb.setKeyValue("RNBCAPI_THISYEAR",""+abb.getRnbcapi_thisyear());
abb.rnbcapi_thismonth=rs.getDouble("rnbcapi_thismonth");abb.setKeyValue("RNBCAPI_THISMONTH",""+abb.getRnbcapi_thismonth());
abb.rnbcapi_today=rs.getDouble("rnbcapi_today");abb.setKeyValue("RNBCAPI_TODAY",""+abb.getRnbcapi_today());
abb.sintebal_lastyear=rs.getDouble("sintebal_lastyear");abb.setKeyValue("SINTEBAL_LASTYEAR",""+abb.getSintebal_lastyear());
abb.sintebal_lastterm=rs.getDouble("sintebal_lastterm");abb.setKeyValue("SINTEBAL_LASTTERM",""+abb.getSintebal_lastterm());
abb.sintebal_thisterm2=rs.getDouble("sintebal_thisterm2");abb.setKeyValue("SINTEBAL_THISTERM2",""+abb.getSintebal_thisterm2());
abb.sintebal_thisterm=rs.getDouble("sintebal_thisterm");abb.setKeyValue("SINTEBAL_THISTERM",""+abb.getSintebal_thisterm());
abb.dintebal_lastyear=rs.getDouble("dintebal_lastyear");abb.setKeyValue("DINTEBAL_LASTYEAR",""+abb.getDintebal_lastyear());
abb.dintebal_lastterm2=rs.getDouble("dintebal_lastterm2");abb.setKeyValue("DINTEBAL_LASTTERM2",""+abb.getDintebal_lastterm2());
abb.dintebal_lastterm=rs.getDouble("dintebal_lastterm");abb.setKeyValue("DINTEBAL_LASTTERM",""+abb.getDintebal_lastterm());
abb.dintebal_thisterm=rs.getDouble("dintebal_thisterm");abb.setKeyValue("DINTEBAL_THISTERM",""+abb.getDintebal_thisterm());
abb.intebal=rs.getDouble("intebal");abb.setKeyValue("INTEBAL",""+abb.getIntebal());
list.add(abb);
abb.operate_mode = "edit";
}public String getLn_acct_no() { if ( this.ln_acct_no == null ) return ""; return this.ln_acct_no;}
public String getOds_src_dt() { if ( this.ods_src_dt == null ) return ""; return this.ods_src_dt;}
public double getBal_lastyear() { return this.bal_lastyear;}
public double getBal_lastmonth() { return this.bal_lastmonth;}
public double getBal_yesterday() { return this.bal_yesterday;}
public double getBal_today() { return this.bal_today;}
public double getRelecapi_thisyear() { return this.relecapi_thisyear;}
public double getPayout_amt_thismonth() { return this.payout_amt_thismonth;}
public double getRelecapi_today() { return this.relecapi_today;}
public double getRacapi_thisyear() { return this.racapi_thisyear;}
public double getRacapi_thismonth() { return this.racapi_thismonth;}
public double getRacapi_today() { return this.racapi_today;}
public double getRnbcapi_thisyear() { return this.rnbcapi_thisyear;}
public double getRnbcapi_thismonth() { return this.rnbcapi_thismonth;}
public double getRnbcapi_today() { return this.rnbcapi_today;}
public double getSintebal_lastyear() { return this.sintebal_lastyear;}
public double getSintebal_lastterm() { return this.sintebal_lastterm;}
public double getSintebal_thisterm2() { return this.sintebal_thisterm2;}
public double getSintebal_thisterm() { return this.sintebal_thisterm;}
public double getDintebal_lastyear() { return this.dintebal_lastyear;}
public double getDintebal_lastterm2() { return this.dintebal_lastterm2;}
public double getDintebal_lastterm() { return this.dintebal_lastterm;}
public double getDintebal_thisterm() { return this.dintebal_thisterm;}
public double getIntebal() { return this.intebal;}
public void setLn_acct_no(String ln_acct_no) { sqlMaker.setField("ln_acct_no",ln_acct_no,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLn_acct_no().equals(ln_acct_no)) cf.add("ln_acct_no",this.ln_acct_no,ln_acct_no); } this.ln_acct_no=ln_acct_no;}
public void setOds_src_dt(String ods_src_dt) { sqlMaker.setField("ods_src_dt",ods_src_dt,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getOds_src_dt().equals(ods_src_dt)) cf.add("ods_src_dt",this.ods_src_dt,ods_src_dt); } this.ods_src_dt=ods_src_dt;}
public void setBal_lastyear(double bal_lastyear) { sqlMaker.setField("bal_lastyear",""+bal_lastyear,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getBal_lastyear()!=bal_lastyear) cf.add("bal_lastyear",this.bal_lastyear+"",bal_lastyear+""); } this.bal_lastyear=bal_lastyear;}
public void setBal_lastmonth(double bal_lastmonth) { sqlMaker.setField("bal_lastmonth",""+bal_lastmonth,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getBal_lastmonth()!=bal_lastmonth) cf.add("bal_lastmonth",this.bal_lastmonth+"",bal_lastmonth+""); } this.bal_lastmonth=bal_lastmonth;}
public void setBal_yesterday(double bal_yesterday) { sqlMaker.setField("bal_yesterday",""+bal_yesterday,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getBal_yesterday()!=bal_yesterday) cf.add("bal_yesterday",this.bal_yesterday+"",bal_yesterday+""); } this.bal_yesterday=bal_yesterday;}
public void setBal_today(double bal_today) { sqlMaker.setField("bal_today",""+bal_today,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getBal_today()!=bal_today) cf.add("bal_today",this.bal_today+"",bal_today+""); } this.bal_today=bal_today;}
public void setRelecapi_thisyear(double relecapi_thisyear) { sqlMaker.setField("relecapi_thisyear",""+relecapi_thisyear,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRelecapi_thisyear()!=relecapi_thisyear) cf.add("relecapi_thisyear",this.relecapi_thisyear+"",relecapi_thisyear+""); } this.relecapi_thisyear=relecapi_thisyear;}
public void setPayout_amt_thismonth(double payout_amt_thismonth) { sqlMaker.setField("payout_amt_thismonth",""+payout_amt_thismonth,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getPayout_amt_thismonth()!=payout_amt_thismonth) cf.add("payout_amt_thismonth",this.payout_amt_thismonth+"",payout_amt_thismonth+""); } this.payout_amt_thismonth=payout_amt_thismonth;}
public void setRelecapi_today(double relecapi_today) { sqlMaker.setField("relecapi_today",""+relecapi_today,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRelecapi_today()!=relecapi_today) cf.add("relecapi_today",this.relecapi_today+"",relecapi_today+""); } this.relecapi_today=relecapi_today;}
public void setRacapi_thisyear(double racapi_thisyear) { sqlMaker.setField("racapi_thisyear",""+racapi_thisyear,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRacapi_thisyear()!=racapi_thisyear) cf.add("racapi_thisyear",this.racapi_thisyear+"",racapi_thisyear+""); } this.racapi_thisyear=racapi_thisyear;}
public void setRacapi_thismonth(double racapi_thismonth) { sqlMaker.setField("racapi_thismonth",""+racapi_thismonth,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRacapi_thismonth()!=racapi_thismonth) cf.add("racapi_thismonth",this.racapi_thismonth+"",racapi_thismonth+""); } this.racapi_thismonth=racapi_thismonth;}
public void setRacapi_today(double racapi_today) { sqlMaker.setField("racapi_today",""+racapi_today,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRacapi_today()!=racapi_today) cf.add("racapi_today",this.racapi_today+"",racapi_today+""); } this.racapi_today=racapi_today;}
public void setRnbcapi_thisyear(double rnbcapi_thisyear) { sqlMaker.setField("rnbcapi_thisyear",""+rnbcapi_thisyear,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRnbcapi_thisyear()!=rnbcapi_thisyear) cf.add("rnbcapi_thisyear",this.rnbcapi_thisyear+"",rnbcapi_thisyear+""); } this.rnbcapi_thisyear=rnbcapi_thisyear;}
public void setRnbcapi_thismonth(double rnbcapi_thismonth) { sqlMaker.setField("rnbcapi_thismonth",""+rnbcapi_thismonth,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRnbcapi_thismonth()!=rnbcapi_thismonth) cf.add("rnbcapi_thismonth",this.rnbcapi_thismonth+"",rnbcapi_thismonth+""); } this.rnbcapi_thismonth=rnbcapi_thismonth;}
public void setRnbcapi_today(double rnbcapi_today) { sqlMaker.setField("rnbcapi_today",""+rnbcapi_today,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRnbcapi_today()!=rnbcapi_today) cf.add("rnbcapi_today",this.rnbcapi_today+"",rnbcapi_today+""); } this.rnbcapi_today=rnbcapi_today;}
public void setSintebal_lastyear(double sintebal_lastyear) { sqlMaker.setField("sintebal_lastyear",""+sintebal_lastyear,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getSintebal_lastyear()!=sintebal_lastyear) cf.add("sintebal_lastyear",this.sintebal_lastyear+"",sintebal_lastyear+""); } this.sintebal_lastyear=sintebal_lastyear;}
public void setSintebal_lastterm(double sintebal_lastterm) { sqlMaker.setField("sintebal_lastterm",""+sintebal_lastterm,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getSintebal_lastterm()!=sintebal_lastterm) cf.add("sintebal_lastterm",this.sintebal_lastterm+"",sintebal_lastterm+""); } this.sintebal_lastterm=sintebal_lastterm;}
public void setSintebal_thisterm2(double sintebal_thisterm2) { sqlMaker.setField("sintebal_thisterm2",""+sintebal_thisterm2,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getSintebal_thisterm2()!=sintebal_thisterm2) cf.add("sintebal_thisterm2",this.sintebal_thisterm2+"",sintebal_thisterm2+""); } this.sintebal_thisterm2=sintebal_thisterm2;}
public void setSintebal_thisterm(double sintebal_thisterm) { sqlMaker.setField("sintebal_thisterm",""+sintebal_thisterm,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getSintebal_thisterm()!=sintebal_thisterm) cf.add("sintebal_thisterm",this.sintebal_thisterm+"",sintebal_thisterm+""); } this.sintebal_thisterm=sintebal_thisterm;}
public void setDintebal_lastyear(double dintebal_lastyear) { sqlMaker.setField("dintebal_lastyear",""+dintebal_lastyear,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getDintebal_lastyear()!=dintebal_lastyear) cf.add("dintebal_lastyear",this.dintebal_lastyear+"",dintebal_lastyear+""); } this.dintebal_lastyear=dintebal_lastyear;}
public void setDintebal_lastterm2(double dintebal_lastterm2) { sqlMaker.setField("dintebal_lastterm2",""+dintebal_lastterm2,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getDintebal_lastterm2()!=dintebal_lastterm2) cf.add("dintebal_lastterm2",this.dintebal_lastterm2+"",dintebal_lastterm2+""); } this.dintebal_lastterm2=dintebal_lastterm2;}
public void setDintebal_lastterm(double dintebal_lastterm) { sqlMaker.setField("dintebal_lastterm",""+dintebal_lastterm,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getDintebal_lastterm()!=dintebal_lastterm) cf.add("dintebal_lastterm",this.dintebal_lastterm+"",dintebal_lastterm+""); } this.dintebal_lastterm=dintebal_lastterm;}
public void setDintebal_thisterm(double dintebal_thisterm) { sqlMaker.setField("dintebal_thisterm",""+dintebal_thisterm,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getDintebal_thisterm()!=dintebal_thisterm) cf.add("dintebal_thisterm",this.dintebal_thisterm+"",dintebal_thisterm+""); } this.dintebal_thisterm=dintebal_thisterm;}
public void setIntebal(double intebal) { sqlMaker.setField("intebal",""+intebal,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getIntebal()!=intebal) cf.add("intebal",this.intebal+"",intebal+""); } this.intebal=intebal;}
public void init(int i,ActionRequest actionRequest) throws Exception { if ( actionRequest.getFieldValue(i,"ln_acct_no") !=null ) {this.setLn_acct_no(actionRequest.getFieldValue(i,"ln_acct_no"));}
if ( actionRequest.getFieldValue(i,"ods_src_dt") !=null ) {this.setOds_src_dt(actionRequest.getFieldValue(i,"ods_src_dt"));}
if ( actionRequest.getFieldValue(i,"bal_lastyear") !=null && actionRequest.getFieldValue(i,"bal_lastyear").trim().length() > 0 ) {this.setBal_lastyear(Double.parseDouble(actionRequest.getFieldValue(i,"bal_lastyear")));}
if ( actionRequest.getFieldValue(i,"bal_lastmonth") !=null && actionRequest.getFieldValue(i,"bal_lastmonth").trim().length() > 0 ) {this.setBal_lastmonth(Double.parseDouble(actionRequest.getFieldValue(i,"bal_lastmonth")));}
if ( actionRequest.getFieldValue(i,"bal_yesterday") !=null && actionRequest.getFieldValue(i,"bal_yesterday").trim().length() > 0 ) {this.setBal_yesterday(Double.parseDouble(actionRequest.getFieldValue(i,"bal_yesterday")));}
if ( actionRequest.getFieldValue(i,"bal_today") !=null && actionRequest.getFieldValue(i,"bal_today").trim().length() > 0 ) {this.setBal_today(Double.parseDouble(actionRequest.getFieldValue(i,"bal_today")));}
if ( actionRequest.getFieldValue(i,"relecapi_thisyear") !=null && actionRequest.getFieldValue(i,"relecapi_thisyear").trim().length() > 0 ) {this.setRelecapi_thisyear(Double.parseDouble(actionRequest.getFieldValue(i,"relecapi_thisyear")));}
if ( actionRequest.getFieldValue(i,"payout_amt_thismonth") !=null && actionRequest.getFieldValue(i,"payout_amt_thismonth").trim().length() > 0 ) {this.setPayout_amt_thismonth(Double.parseDouble(actionRequest.getFieldValue(i,"payout_amt_thismonth")));}
if ( actionRequest.getFieldValue(i,"relecapi_today") !=null && actionRequest.getFieldValue(i,"relecapi_today").trim().length() > 0 ) {this.setRelecapi_today(Double.parseDouble(actionRequest.getFieldValue(i,"relecapi_today")));}
if ( actionRequest.getFieldValue(i,"racapi_thisyear") !=null && actionRequest.getFieldValue(i,"racapi_thisyear").trim().length() > 0 ) {this.setRacapi_thisyear(Double.parseDouble(actionRequest.getFieldValue(i,"racapi_thisyear")));}
if ( actionRequest.getFieldValue(i,"racapi_thismonth") !=null && actionRequest.getFieldValue(i,"racapi_thismonth").trim().length() > 0 ) {this.setRacapi_thismonth(Double.parseDouble(actionRequest.getFieldValue(i,"racapi_thismonth")));}
if ( actionRequest.getFieldValue(i,"racapi_today") !=null && actionRequest.getFieldValue(i,"racapi_today").trim().length() > 0 ) {this.setRacapi_today(Double.parseDouble(actionRequest.getFieldValue(i,"racapi_today")));}
if ( actionRequest.getFieldValue(i,"rnbcapi_thisyear") !=null && actionRequest.getFieldValue(i,"rnbcapi_thisyear").trim().length() > 0 ) {this.setRnbcapi_thisyear(Double.parseDouble(actionRequest.getFieldValue(i,"rnbcapi_thisyear")));}
if ( actionRequest.getFieldValue(i,"rnbcapi_thismonth") !=null && actionRequest.getFieldValue(i,"rnbcapi_thismonth").trim().length() > 0 ) {this.setRnbcapi_thismonth(Double.parseDouble(actionRequest.getFieldValue(i,"rnbcapi_thismonth")));}
if ( actionRequest.getFieldValue(i,"rnbcapi_today") !=null && actionRequest.getFieldValue(i,"rnbcapi_today").trim().length() > 0 ) {this.setRnbcapi_today(Double.parseDouble(actionRequest.getFieldValue(i,"rnbcapi_today")));}
if ( actionRequest.getFieldValue(i,"sintebal_lastyear") !=null && actionRequest.getFieldValue(i,"sintebal_lastyear").trim().length() > 0 ) {this.setSintebal_lastyear(Double.parseDouble(actionRequest.getFieldValue(i,"sintebal_lastyear")));}
if ( actionRequest.getFieldValue(i,"sintebal_lastterm") !=null && actionRequest.getFieldValue(i,"sintebal_lastterm").trim().length() > 0 ) {this.setSintebal_lastterm(Double.parseDouble(actionRequest.getFieldValue(i,"sintebal_lastterm")));}
if ( actionRequest.getFieldValue(i,"sintebal_thisterm2") !=null && actionRequest.getFieldValue(i,"sintebal_thisterm2").trim().length() > 0 ) {this.setSintebal_thisterm2(Double.parseDouble(actionRequest.getFieldValue(i,"sintebal_thisterm2")));}
if ( actionRequest.getFieldValue(i,"sintebal_thisterm") !=null && actionRequest.getFieldValue(i,"sintebal_thisterm").trim().length() > 0 ) {this.setSintebal_thisterm(Double.parseDouble(actionRequest.getFieldValue(i,"sintebal_thisterm")));}
if ( actionRequest.getFieldValue(i,"dintebal_lastyear") !=null && actionRequest.getFieldValue(i,"dintebal_lastyear").trim().length() > 0 ) {this.setDintebal_lastyear(Double.parseDouble(actionRequest.getFieldValue(i,"dintebal_lastyear")));}
if ( actionRequest.getFieldValue(i,"dintebal_lastterm2") !=null && actionRequest.getFieldValue(i,"dintebal_lastterm2").trim().length() > 0 ) {this.setDintebal_lastterm2(Double.parseDouble(actionRequest.getFieldValue(i,"dintebal_lastterm2")));}
if ( actionRequest.getFieldValue(i,"dintebal_lastterm") !=null && actionRequest.getFieldValue(i,"dintebal_lastterm").trim().length() > 0 ) {this.setDintebal_lastterm(Double.parseDouble(actionRequest.getFieldValue(i,"dintebal_lastterm")));}
if ( actionRequest.getFieldValue(i,"dintebal_thisterm") !=null && actionRequest.getFieldValue(i,"dintebal_thisterm").trim().length() > 0 ) {this.setDintebal_thisterm(Double.parseDouble(actionRequest.getFieldValue(i,"dintebal_thisterm")));}
if ( actionRequest.getFieldValue(i,"intebal") !=null && actionRequest.getFieldValue(i,"intebal").trim().length() > 0 ) {this.setIntebal(Double.parseDouble(actionRequest.getFieldValue(i,"intebal")));}
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { LNODSBACCTTOTLDATA obj = (LNODSBACCTTOTLDATA)super.clone();obj.setLn_acct_no(obj.ln_acct_no);
obj.setOds_src_dt(obj.ods_src_dt);
obj.setBal_lastyear(obj.bal_lastyear);
obj.setBal_lastmonth(obj.bal_lastmonth);
obj.setBal_yesterday(obj.bal_yesterday);
obj.setBal_today(obj.bal_today);
obj.setRelecapi_thisyear(obj.relecapi_thisyear);
obj.setPayout_amt_thismonth(obj.payout_amt_thismonth);
obj.setRelecapi_today(obj.relecapi_today);
obj.setRacapi_thisyear(obj.racapi_thisyear);
obj.setRacapi_thismonth(obj.racapi_thismonth);
obj.setRacapi_today(obj.racapi_today);
obj.setRnbcapi_thisyear(obj.rnbcapi_thisyear);
obj.setRnbcapi_thismonth(obj.rnbcapi_thismonth);
obj.setRnbcapi_today(obj.rnbcapi_today);
obj.setSintebal_lastyear(obj.sintebal_lastyear);
obj.setSintebal_lastterm(obj.sintebal_lastterm);
obj.setSintebal_thisterm2(obj.sintebal_thisterm2);
obj.setSintebal_thisterm(obj.sintebal_thisterm);
obj.setDintebal_lastyear(obj.dintebal_lastyear);
obj.setDintebal_lastterm2(obj.dintebal_lastterm2);
obj.setDintebal_lastterm(obj.dintebal_lastterm);
obj.setDintebal_thisterm(obj.dintebal_thisterm);
obj.setIntebal(obj.intebal);
return obj;}}