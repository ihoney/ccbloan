package com.ccb.dao;
import java.util.*;
import pub.platform.db.*;
import pub.platform.utils.*;
import pub.platform.db.AbstractBasicBean;
public class LNODSBCMPRODDEF extends AbstractBasicBean implements Cloneable {
     public static List find(String sSqlWhere) {           return new LNODSBCMPRODDEF().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere) {           return new LNODSBCMPRODDEF().findAndLockByWhere(sSqlWhere);      }       public static LNODSBCMPRODDEF findFirst(String sSqlWhere) {           return (LNODSBCMPRODDEF)new LNODSBCMPRODDEF().findFirstByWhere(sSqlWhere);      }       public static LNODSBCMPRODDEF findFirstAndLock(String sSqlWhere) {           return (LNODSBCMPRODDEF)new LNODSBCMPRODDEF().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) {           return new LNODSBCMPRODDEF().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease) {           LNODSBCMPRODDEF bean = new LNODSBCMPRODDEF();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) {           LNODSBCMPRODDEF bean = new LNODSBCMPRODDEF();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static LNODSBCMPRODDEF findFirst(String sSqlWhere,boolean isAutoRelease) {           LNODSBCMPRODDEF bean = new LNODSBCMPRODDEF();           bean.setAutoRelease(isAutoRelease);           return (LNODSBCMPRODDEF)bean.findFirstByWhere(sSqlWhere);      }       public static LNODSBCMPRODDEF findFirstAndLock(String sSqlWhere,boolean isAutoRelease) {           LNODSBCMPRODDEF bean = new LNODSBCMPRODDEF();           bean.setAutoRelease(isAutoRelease);           return (LNODSBCMPRODDEF)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease) {           LNODSBCMPRODDEF bean = new LNODSBCMPRODDEF();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      }      public static List findByRow(String sSqlWhere,int row) {           return new LNODSBCMPRODDEF().findByWhereByRow(sSqlWhere,row);      } String curr_cd;
String ln_prod_cod;
String product_name;
String loanclass;
String ln_typ;
String proddealtype;
String retutype;
String intemeth;
String intebase;
String ln_intr_adj_sty;
String ratecalckind;
String rateintebase;
String rateact;
double ratecalevalue;
double intefineratefloat;
double capifineratefloat;
double foulrate;
double emberatefloat;
String subsflag;
String retufreq;
int retuincr;
String pay_type;
String israteadjuplan;
String isbilldefi;
int retuday;
int aheadday;
int aheadsubsday;
int retryday;
int extenday;
int pastdueday;
double penaintperc;
int fixsubsday;
public static final String TABLENAME ="ln_odsb_cmproddef";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
public void addObject(List list,RecordSet rs) {
LNODSBCMPRODDEF abb = new LNODSBCMPRODDEF();
abb.curr_cd=rs.getString("curr_cd");abb.setKeyValue("CURR_CD",""+abb.getCurr_cd());
abb.ln_prod_cod=rs.getString("ln_prod_cod");abb.setKeyValue("LN_PROD_COD",""+abb.getLn_prod_cod());
abb.product_name=rs.getString("product_name");abb.setKeyValue("PRODUCT_NAME",""+abb.getProduct_name());
abb.loanclass=rs.getString("loanclass");abb.setKeyValue("LOANCLASS",""+abb.getLoanclass());
abb.ln_typ=rs.getString("ln_typ");abb.setKeyValue("LN_TYP",""+abb.getLn_typ());
abb.proddealtype=rs.getString("proddealtype");abb.setKeyValue("PRODDEALTYPE",""+abb.getProddealtype());
abb.retutype=rs.getString("retutype");abb.setKeyValue("RETUTYPE",""+abb.getRetutype());
abb.intemeth=rs.getString("intemeth");abb.setKeyValue("INTEMETH",""+abb.getIntemeth());
abb.intebase=rs.getString("intebase");abb.setKeyValue("INTEBASE",""+abb.getIntebase());
abb.ln_intr_adj_sty=rs.getString("ln_intr_adj_sty");abb.setKeyValue("LN_INTR_ADJ_STY",""+abb.getLn_intr_adj_sty());
abb.ratecalckind=rs.getString("ratecalckind");abb.setKeyValue("RATECALCKIND",""+abb.getRatecalckind());
abb.rateintebase=rs.getString("rateintebase");abb.setKeyValue("RATEINTEBASE",""+abb.getRateintebase());
abb.rateact=rs.getString("rateact");abb.setKeyValue("RATEACT",""+abb.getRateact());
abb.ratecalevalue=rs.getDouble("ratecalevalue");abb.setKeyValue("RATECALEVALUE",""+abb.getRatecalevalue());
abb.intefineratefloat=rs.getDouble("intefineratefloat");abb.setKeyValue("INTEFINERATEFLOAT",""+abb.getIntefineratefloat());
abb.capifineratefloat=rs.getDouble("capifineratefloat");abb.setKeyValue("CAPIFINERATEFLOAT",""+abb.getCapifineratefloat());
abb.foulrate=rs.getDouble("foulrate");abb.setKeyValue("FOULRATE",""+abb.getFoulrate());
abb.emberatefloat=rs.getDouble("emberatefloat");abb.setKeyValue("EMBERATEFLOAT",""+abb.getEmberatefloat());
abb.subsflag=rs.getString("subsflag");abb.setKeyValue("SUBSFLAG",""+abb.getSubsflag());
abb.retufreq=rs.getString("retufreq");abb.setKeyValue("RETUFREQ",""+abb.getRetufreq());
abb.retuincr=rs.getInt("retuincr");abb.setKeyValue("RETUINCR",""+abb.getRetuincr());
abb.pay_type=rs.getString("pay_type");abb.setKeyValue("PAY_TYPE",""+abb.getPay_type());
abb.israteadjuplan=rs.getString("israteadjuplan");abb.setKeyValue("ISRATEADJUPLAN",""+abb.getIsrateadjuplan());
abb.isbilldefi=rs.getString("isbilldefi");abb.setKeyValue("ISBILLDEFI",""+abb.getIsbilldefi());
abb.retuday=rs.getInt("retuday");abb.setKeyValue("RETUDAY",""+abb.getRetuday());
abb.aheadday=rs.getInt("aheadday");abb.setKeyValue("AHEADDAY",""+abb.getAheadday());
abb.aheadsubsday=rs.getInt("aheadsubsday");abb.setKeyValue("AHEADSUBSDAY",""+abb.getAheadsubsday());
abb.retryday=rs.getInt("retryday");abb.setKeyValue("RETRYDAY",""+abb.getRetryday());
abb.extenday=rs.getInt("extenday");abb.setKeyValue("EXTENDAY",""+abb.getExtenday());
abb.pastdueday=rs.getInt("pastdueday");abb.setKeyValue("PASTDUEDAY",""+abb.getPastdueday());
abb.penaintperc=rs.getDouble("penaintperc");abb.setKeyValue("PENAINTPERC",""+abb.getPenaintperc());
abb.fixsubsday=rs.getInt("fixsubsday");abb.setKeyValue("FIXSUBSDAY",""+abb.getFixsubsday());
list.add(abb);
abb.operate_mode = "edit";
}public String getCurr_cd() { if ( this.curr_cd == null ) return ""; return this.curr_cd;}
public String getLn_prod_cod() { if ( this.ln_prod_cod == null ) return ""; return this.ln_prod_cod;}
public String getProduct_name() { if ( this.product_name == null ) return ""; return this.product_name;}
public String getLoanclass() { if ( this.loanclass == null ) return ""; return this.loanclass;}
public String getLn_typ() { if ( this.ln_typ == null ) return ""; return this.ln_typ;}
public String getProddealtype() { if ( this.proddealtype == null ) return ""; return this.proddealtype;}
public String getRetutype() { if ( this.retutype == null ) return ""; return this.retutype;}
public String getIntemeth() { if ( this.intemeth == null ) return ""; return this.intemeth;}
public String getIntebase() { if ( this.intebase == null ) return ""; return this.intebase;}
public String getLn_intr_adj_sty() { if ( this.ln_intr_adj_sty == null ) return ""; return this.ln_intr_adj_sty;}
public String getRatecalckind() { if ( this.ratecalckind == null ) return ""; return this.ratecalckind;}
public String getRateintebase() { if ( this.rateintebase == null ) return ""; return this.rateintebase;}
public String getRateact() { if ( this.rateact == null ) return ""; return this.rateact;}
public double getRatecalevalue() { return this.ratecalevalue;}
public double getIntefineratefloat() { return this.intefineratefloat;}
public double getCapifineratefloat() { return this.capifineratefloat;}
public double getFoulrate() { return this.foulrate;}
public double getEmberatefloat() { return this.emberatefloat;}
public String getSubsflag() { if ( this.subsflag == null ) return ""; return this.subsflag;}
public String getRetufreq() { if ( this.retufreq == null ) return ""; return this.retufreq;}
public int getRetuincr() { return this.retuincr;}
public String getPay_type() { if ( this.pay_type == null ) return ""; return this.pay_type;}
public String getIsrateadjuplan() { if ( this.israteadjuplan == null ) return ""; return this.israteadjuplan;}
public String getIsbilldefi() { if ( this.isbilldefi == null ) return ""; return this.isbilldefi;}
public int getRetuday() { return this.retuday;}
public int getAheadday() { return this.aheadday;}
public int getAheadsubsday() { return this.aheadsubsday;}
public int getRetryday() { return this.retryday;}
public int getExtenday() { return this.extenday;}
public int getPastdueday() { return this.pastdueday;}
public double getPenaintperc() { return this.penaintperc;}
public int getFixsubsday() { return this.fixsubsday;}
public void setCurr_cd(String curr_cd) { sqlMaker.setField("curr_cd",curr_cd,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCurr_cd().equals(curr_cd)) cf.add("curr_cd",this.curr_cd,curr_cd); } this.curr_cd=curr_cd;}
public void setLn_prod_cod(String ln_prod_cod) { sqlMaker.setField("ln_prod_cod",ln_prod_cod,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLn_prod_cod().equals(ln_prod_cod)) cf.add("ln_prod_cod",this.ln_prod_cod,ln_prod_cod); } this.ln_prod_cod=ln_prod_cod;}
public void setProduct_name(String product_name) { sqlMaker.setField("product_name",product_name,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getProduct_name().equals(product_name)) cf.add("product_name",this.product_name,product_name); } this.product_name=product_name;}
public void setLoanclass(String loanclass) { sqlMaker.setField("loanclass",loanclass,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLoanclass().equals(loanclass)) cf.add("loanclass",this.loanclass,loanclass); } this.loanclass=loanclass;}
public void setLn_typ(String ln_typ) { sqlMaker.setField("ln_typ",ln_typ,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLn_typ().equals(ln_typ)) cf.add("ln_typ",this.ln_typ,ln_typ); } this.ln_typ=ln_typ;}
public void setProddealtype(String proddealtype) { sqlMaker.setField("proddealtype",proddealtype,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getProddealtype().equals(proddealtype)) cf.add("proddealtype",this.proddealtype,proddealtype); } this.proddealtype=proddealtype;}
public void setRetutype(String retutype) { sqlMaker.setField("retutype",retutype,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRetutype().equals(retutype)) cf.add("retutype",this.retutype,retutype); } this.retutype=retutype;}
public void setIntemeth(String intemeth) { sqlMaker.setField("intemeth",intemeth,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getIntemeth().equals(intemeth)) cf.add("intemeth",this.intemeth,intemeth); } this.intemeth=intemeth;}
public void setIntebase(String intebase) { sqlMaker.setField("intebase",intebase,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getIntebase().equals(intebase)) cf.add("intebase",this.intebase,intebase); } this.intebase=intebase;}
public void setLn_intr_adj_sty(String ln_intr_adj_sty) { sqlMaker.setField("ln_intr_adj_sty",ln_intr_adj_sty,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLn_intr_adj_sty().equals(ln_intr_adj_sty)) cf.add("ln_intr_adj_sty",this.ln_intr_adj_sty,ln_intr_adj_sty); } this.ln_intr_adj_sty=ln_intr_adj_sty;}
public void setRatecalckind(String ratecalckind) { sqlMaker.setField("ratecalckind",ratecalckind,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRatecalckind().equals(ratecalckind)) cf.add("ratecalckind",this.ratecalckind,ratecalckind); } this.ratecalckind=ratecalckind;}
public void setRateintebase(String rateintebase) { sqlMaker.setField("rateintebase",rateintebase,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRateintebase().equals(rateintebase)) cf.add("rateintebase",this.rateintebase,rateintebase); } this.rateintebase=rateintebase;}
public void setRateact(String rateact) { sqlMaker.setField("rateact",rateact,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRateact().equals(rateact)) cf.add("rateact",this.rateact,rateact); } this.rateact=rateact;}
public void setRatecalevalue(double ratecalevalue) { sqlMaker.setField("ratecalevalue",""+ratecalevalue,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRatecalevalue()!=ratecalevalue) cf.add("ratecalevalue",this.ratecalevalue+"",ratecalevalue+""); } this.ratecalevalue=ratecalevalue;}
public void setIntefineratefloat(double intefineratefloat) { sqlMaker.setField("intefineratefloat",""+intefineratefloat,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getIntefineratefloat()!=intefineratefloat) cf.add("intefineratefloat",this.intefineratefloat+"",intefineratefloat+""); } this.intefineratefloat=intefineratefloat;}
public void setCapifineratefloat(double capifineratefloat) { sqlMaker.setField("capifineratefloat",""+capifineratefloat,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getCapifineratefloat()!=capifineratefloat) cf.add("capifineratefloat",this.capifineratefloat+"",capifineratefloat+""); } this.capifineratefloat=capifineratefloat;}
public void setFoulrate(double foulrate) { sqlMaker.setField("foulrate",""+foulrate,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getFoulrate()!=foulrate) cf.add("foulrate",this.foulrate+"",foulrate+""); } this.foulrate=foulrate;}
public void setEmberatefloat(double emberatefloat) { sqlMaker.setField("emberatefloat",""+emberatefloat,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getEmberatefloat()!=emberatefloat) cf.add("emberatefloat",this.emberatefloat+"",emberatefloat+""); } this.emberatefloat=emberatefloat;}
public void setSubsflag(String subsflag) { sqlMaker.setField("subsflag",subsflag,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSubsflag().equals(subsflag)) cf.add("subsflag",this.subsflag,subsflag); } this.subsflag=subsflag;}
public void setRetufreq(String retufreq) { sqlMaker.setField("retufreq",retufreq,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRetufreq().equals(retufreq)) cf.add("retufreq",this.retufreq,retufreq); } this.retufreq=retufreq;}
public void setRetuincr(int retuincr) { sqlMaker.setField("retuincr",""+retuincr,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRetuincr()!=retuincr) cf.add("retuincr",this.retuincr+"",retuincr+""); } this.retuincr=retuincr;}
public void setPay_type(String pay_type) { sqlMaker.setField("pay_type",pay_type,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getPay_type().equals(pay_type)) cf.add("pay_type",this.pay_type,pay_type); } this.pay_type=pay_type;}
public void setIsrateadjuplan(String israteadjuplan) { sqlMaker.setField("israteadjuplan",israteadjuplan,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getIsrateadjuplan().equals(israteadjuplan)) cf.add("israteadjuplan",this.israteadjuplan,israteadjuplan); } this.israteadjuplan=israteadjuplan;}
public void setIsbilldefi(String isbilldefi) { sqlMaker.setField("isbilldefi",isbilldefi,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getIsbilldefi().equals(isbilldefi)) cf.add("isbilldefi",this.isbilldefi,isbilldefi); } this.isbilldefi=isbilldefi;}
public void setRetuday(int retuday) { sqlMaker.setField("retuday",""+retuday,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRetuday()!=retuday) cf.add("retuday",this.retuday+"",retuday+""); } this.retuday=retuday;}
public void setAheadday(int aheadday) { sqlMaker.setField("aheadday",""+aheadday,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getAheadday()!=aheadday) cf.add("aheadday",this.aheadday+"",aheadday+""); } this.aheadday=aheadday;}
public void setAheadsubsday(int aheadsubsday) { sqlMaker.setField("aheadsubsday",""+aheadsubsday,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getAheadsubsday()!=aheadsubsday) cf.add("aheadsubsday",this.aheadsubsday+"",aheadsubsday+""); } this.aheadsubsday=aheadsubsday;}
public void setRetryday(int retryday) { sqlMaker.setField("retryday",""+retryday,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRetryday()!=retryday) cf.add("retryday",this.retryday+"",retryday+""); } this.retryday=retryday;}
public void setExtenday(int extenday) { sqlMaker.setField("extenday",""+extenday,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getExtenday()!=extenday) cf.add("extenday",this.extenday+"",extenday+""); } this.extenday=extenday;}
public void setPastdueday(int pastdueday) { sqlMaker.setField("pastdueday",""+pastdueday,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getPastdueday()!=pastdueday) cf.add("pastdueday",this.pastdueday+"",pastdueday+""); } this.pastdueday=pastdueday;}
public void setPenaintperc(double penaintperc) { sqlMaker.setField("penaintperc",""+penaintperc,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getPenaintperc()!=penaintperc) cf.add("penaintperc",this.penaintperc+"",penaintperc+""); } this.penaintperc=penaintperc;}
public void setFixsubsday(int fixsubsday) { sqlMaker.setField("fixsubsday",""+fixsubsday,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getFixsubsday()!=fixsubsday) cf.add("fixsubsday",this.fixsubsday+"",fixsubsday+""); } this.fixsubsday=fixsubsday;}
public void init(int i,ActionRequest actionRequest) throws Exception { if ( actionRequest.getFieldValue(i,"curr_cd") !=null ) {this.setCurr_cd(actionRequest.getFieldValue(i,"curr_cd"));}
if ( actionRequest.getFieldValue(i,"ln_prod_cod") !=null ) {this.setLn_prod_cod(actionRequest.getFieldValue(i,"ln_prod_cod"));}
if ( actionRequest.getFieldValue(i,"product_name") !=null ) {this.setProduct_name(actionRequest.getFieldValue(i,"product_name"));}
if ( actionRequest.getFieldValue(i,"loanclass") !=null ) {this.setLoanclass(actionRequest.getFieldValue(i,"loanclass"));}
if ( actionRequest.getFieldValue(i,"ln_typ") !=null ) {this.setLn_typ(actionRequest.getFieldValue(i,"ln_typ"));}
if ( actionRequest.getFieldValue(i,"proddealtype") !=null ) {this.setProddealtype(actionRequest.getFieldValue(i,"proddealtype"));}
if ( actionRequest.getFieldValue(i,"retutype") !=null ) {this.setRetutype(actionRequest.getFieldValue(i,"retutype"));}
if ( actionRequest.getFieldValue(i,"intemeth") !=null ) {this.setIntemeth(actionRequest.getFieldValue(i,"intemeth"));}
if ( actionRequest.getFieldValue(i,"intebase") !=null ) {this.setIntebase(actionRequest.getFieldValue(i,"intebase"));}
if ( actionRequest.getFieldValue(i,"ln_intr_adj_sty") !=null ) {this.setLn_intr_adj_sty(actionRequest.getFieldValue(i,"ln_intr_adj_sty"));}
if ( actionRequest.getFieldValue(i,"ratecalckind") !=null ) {this.setRatecalckind(actionRequest.getFieldValue(i,"ratecalckind"));}
if ( actionRequest.getFieldValue(i,"rateintebase") !=null ) {this.setRateintebase(actionRequest.getFieldValue(i,"rateintebase"));}
if ( actionRequest.getFieldValue(i,"rateact") !=null ) {this.setRateact(actionRequest.getFieldValue(i,"rateact"));}
if ( actionRequest.getFieldValue(i,"ratecalevalue") !=null && actionRequest.getFieldValue(i,"ratecalevalue").trim().length() > 0 ) {this.setRatecalevalue(Double.parseDouble(actionRequest.getFieldValue(i,"ratecalevalue")));}
if ( actionRequest.getFieldValue(i,"intefineratefloat") !=null && actionRequest.getFieldValue(i,"intefineratefloat").trim().length() > 0 ) {this.setIntefineratefloat(Double.parseDouble(actionRequest.getFieldValue(i,"intefineratefloat")));}
if ( actionRequest.getFieldValue(i,"capifineratefloat") !=null && actionRequest.getFieldValue(i,"capifineratefloat").trim().length() > 0 ) {this.setCapifineratefloat(Double.parseDouble(actionRequest.getFieldValue(i,"capifineratefloat")));}
if ( actionRequest.getFieldValue(i,"foulrate") !=null && actionRequest.getFieldValue(i,"foulrate").trim().length() > 0 ) {this.setFoulrate(Double.parseDouble(actionRequest.getFieldValue(i,"foulrate")));}
if ( actionRequest.getFieldValue(i,"emberatefloat") !=null && actionRequest.getFieldValue(i,"emberatefloat").trim().length() > 0 ) {this.setEmberatefloat(Double.parseDouble(actionRequest.getFieldValue(i,"emberatefloat")));}
if ( actionRequest.getFieldValue(i,"subsflag") !=null ) {this.setSubsflag(actionRequest.getFieldValue(i,"subsflag"));}
if ( actionRequest.getFieldValue(i,"retufreq") !=null ) {this.setRetufreq(actionRequest.getFieldValue(i,"retufreq"));}
if ( actionRequest.getFieldValue(i,"retuincr") !=null && actionRequest.getFieldValue(i,"retuincr").trim().length() > 0 ) {this.setRetuincr(Integer.parseInt(actionRequest.getFieldValue(i,"retuincr")));}
if ( actionRequest.getFieldValue(i,"pay_type") !=null ) {this.setPay_type(actionRequest.getFieldValue(i,"pay_type"));}
if ( actionRequest.getFieldValue(i,"israteadjuplan") !=null ) {this.setIsrateadjuplan(actionRequest.getFieldValue(i,"israteadjuplan"));}
if ( actionRequest.getFieldValue(i,"isbilldefi") !=null ) {this.setIsbilldefi(actionRequest.getFieldValue(i,"isbilldefi"));}
if ( actionRequest.getFieldValue(i,"retuday") !=null && actionRequest.getFieldValue(i,"retuday").trim().length() > 0 ) {this.setRetuday(Integer.parseInt(actionRequest.getFieldValue(i,"retuday")));}
if ( actionRequest.getFieldValue(i,"aheadday") !=null && actionRequest.getFieldValue(i,"aheadday").trim().length() > 0 ) {this.setAheadday(Integer.parseInt(actionRequest.getFieldValue(i,"aheadday")));}
if ( actionRequest.getFieldValue(i,"aheadsubsday") !=null && actionRequest.getFieldValue(i,"aheadsubsday").trim().length() > 0 ) {this.setAheadsubsday(Integer.parseInt(actionRequest.getFieldValue(i,"aheadsubsday")));}
if ( actionRequest.getFieldValue(i,"retryday") !=null && actionRequest.getFieldValue(i,"retryday").trim().length() > 0 ) {this.setRetryday(Integer.parseInt(actionRequest.getFieldValue(i,"retryday")));}
if ( actionRequest.getFieldValue(i,"extenday") !=null && actionRequest.getFieldValue(i,"extenday").trim().length() > 0 ) {this.setExtenday(Integer.parseInt(actionRequest.getFieldValue(i,"extenday")));}
if ( actionRequest.getFieldValue(i,"pastdueday") !=null && actionRequest.getFieldValue(i,"pastdueday").trim().length() > 0 ) {this.setPastdueday(Integer.parseInt(actionRequest.getFieldValue(i,"pastdueday")));}
if ( actionRequest.getFieldValue(i,"penaintperc") !=null && actionRequest.getFieldValue(i,"penaintperc").trim().length() > 0 ) {this.setPenaintperc(Double.parseDouble(actionRequest.getFieldValue(i,"penaintperc")));}
if ( actionRequest.getFieldValue(i,"fixsubsday") !=null && actionRequest.getFieldValue(i,"fixsubsday").trim().length() > 0 ) {this.setFixsubsday(Integer.parseInt(actionRequest.getFieldValue(i,"fixsubsday")));}
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { LNODSBCMPRODDEF obj = (LNODSBCMPRODDEF)super.clone();obj.setCurr_cd(obj.curr_cd);
obj.setLn_prod_cod(obj.ln_prod_cod);
obj.setProduct_name(obj.product_name);
obj.setLoanclass(obj.loanclass);
obj.setLn_typ(obj.ln_typ);
obj.setProddealtype(obj.proddealtype);
obj.setRetutype(obj.retutype);
obj.setIntemeth(obj.intemeth);
obj.setIntebase(obj.intebase);
obj.setLn_intr_adj_sty(obj.ln_intr_adj_sty);
obj.setRatecalckind(obj.ratecalckind);
obj.setRateintebase(obj.rateintebase);
obj.setRateact(obj.rateact);
obj.setRatecalevalue(obj.ratecalevalue);
obj.setIntefineratefloat(obj.intefineratefloat);
obj.setCapifineratefloat(obj.capifineratefloat);
obj.setFoulrate(obj.foulrate);
obj.setEmberatefloat(obj.emberatefloat);
obj.setSubsflag(obj.subsflag);
obj.setRetufreq(obj.retufreq);
obj.setRetuincr(obj.retuincr);
obj.setPay_type(obj.pay_type);
obj.setIsrateadjuplan(obj.israteadjuplan);
obj.setIsbilldefi(obj.isbilldefi);
obj.setRetuday(obj.retuday);
obj.setAheadday(obj.aheadday);
obj.setAheadsubsday(obj.aheadsubsday);
obj.setRetryday(obj.retryday);
obj.setExtenday(obj.extenday);
obj.setPastdueday(obj.pastdueday);
obj.setPenaintperc(obj.penaintperc);
obj.setFixsubsday(obj.fixsubsday);
return obj;}}