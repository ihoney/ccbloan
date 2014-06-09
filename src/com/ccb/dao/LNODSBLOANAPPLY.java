package com.ccb.dao;
import java.util.*;
import pub.platform.db.*;
import pub.platform.utils.*;
import pub.platform.db.AbstractBasicBean;
public class LNODSBLOANAPPLY extends AbstractBasicBean implements Cloneable {
     public static List find(String sSqlWhere) {           return new LNODSBLOANAPPLY().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere) {           return new LNODSBLOANAPPLY().findAndLockByWhere(sSqlWhere);      }       public static LNODSBLOANAPPLY findFirst(String sSqlWhere) {           return (LNODSBLOANAPPLY)new LNODSBLOANAPPLY().findFirstByWhere(sSqlWhere);      }       public static LNODSBLOANAPPLY findFirstAndLock(String sSqlWhere) {           return (LNODSBLOANAPPLY)new LNODSBLOANAPPLY().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) {           return new LNODSBLOANAPPLY().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease) {           LNODSBLOANAPPLY bean = new LNODSBLOANAPPLY();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) {           LNODSBLOANAPPLY bean = new LNODSBLOANAPPLY();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static LNODSBLOANAPPLY findFirst(String sSqlWhere,boolean isAutoRelease) {           LNODSBLOANAPPLY bean = new LNODSBLOANAPPLY();           bean.setAutoRelease(isAutoRelease);           return (LNODSBLOANAPPLY)bean.findFirstByWhere(sSqlWhere);      }       public static LNODSBLOANAPPLY findFirstAndLock(String sSqlWhere,boolean isAutoRelease) {           LNODSBLOANAPPLY bean = new LNODSBLOANAPPLY();           bean.setAutoRelease(isAutoRelease);           return (LNODSBLOANAPPLY)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease) {           LNODSBLOANAPPLY bean = new LNODSBLOANAPPLY();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      }      public static List findByRow(String sSqlWhere,int row) {           return new LNODSBLOANAPPLY().findByWhereByRow(sSqlWhere,row);      } String loanid;
String ln_acct_no;
String ods_src_dt;
String cust_no;
String crlmt_no;
String iscommac;
String curr_cd;
String ln_prod_cod;
String ln_typ;
String zm_pkg_loan_nbr;
String relaloanid;
String zm_pmt_seq_nbr;
double payperc;
String fundsour;
String ln_purp;
String guaranty_type;
String aply_dt;
double crlmt_amt;
String cycflag;
double rt_orig_loan_amt;
double rt_orig_procd_amt;
String rt_term_freq;
int rt_term_incr;
String pay_type;
String trothdueday;
int fixrateterm;
String rt_frst_due_date;
String subsflag;
String isenousubs;
double firstpayamt;
double firstpayperc;
String proj_no;
String corpappid;
String releway;
String payee_acct_no;
String intecalckind;
String intemeth;
String intebase;
int bl_lead_days;
String ratecode;
double basicinterate;
String rateact;
double ratecalevalue;
double interate;
double intefineratefloat;
double capifineratefloat;
double finerate;
double capifinerate;
double foulrate;
double emberatefloat;
double progressive_addt_a;
double gainpct;
int progressive_intv;
int firstgainterm;
double int_dis_rate;
String int_dis_end_dt;
String fundcentno;
String manadept;
String zm_aflc_code;
String fundacno;
String capifundacno;
String intefundacno;
String schid;
String cf_addr_num;
String cust_open_dt;
String expiring_dt;
double cumulative_payout_amt;
String contno;
String bankid;
String operid;
String survname;
String auditing_name;
String main_operation;
String apprname;
String apprtabno;
String apprdate;
String apprflag;
String authid;
String apprstate;
String loanstate;
String apprtype;
String openbatchid;
String accounting_org;
String loanevaldate;
String agrflag;
double loanevalvalue;
double sumevalvalue;
String sumevaldate;
String agrname;
String account_no;
String intefreq;
String ratetype;
String corpid;
String cust_name;
public static final String TABLENAME ="ln_odsb_loanapply";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
public void addObject(List list,RecordSet rs) {
LNODSBLOANAPPLY abb = new LNODSBLOANAPPLY();
abb.loanid=rs.getString("loanid");abb.setKeyValue("LOANID",""+abb.getLoanid());
abb.ln_acct_no=rs.getString("ln_acct_no");abb.setKeyValue("LN_ACCT_NO",""+abb.getLn_acct_no());
abb.ods_src_dt=rs.getString("ods_src_dt");abb.setKeyValue("ODS_SRC_DT",""+abb.getOds_src_dt());
abb.cust_no=rs.getString("cust_no");abb.setKeyValue("CUST_NO",""+abb.getCust_no());
abb.crlmt_no=rs.getString("crlmt_no");abb.setKeyValue("CRLMT_NO",""+abb.getCrlmt_no());
abb.iscommac=rs.getString("iscommac");abb.setKeyValue("ISCOMMAC",""+abb.getIscommac());
abb.curr_cd=rs.getString("curr_cd");abb.setKeyValue("CURR_CD",""+abb.getCurr_cd());
abb.ln_prod_cod=rs.getString("ln_prod_cod");abb.setKeyValue("LN_PROD_COD",""+abb.getLn_prod_cod());
abb.ln_typ=rs.getString("ln_typ");abb.setKeyValue("LN_TYP",""+abb.getLn_typ());
abb.zm_pkg_loan_nbr=rs.getString("zm_pkg_loan_nbr");abb.setKeyValue("ZM_PKG_LOAN_NBR",""+abb.getZm_pkg_loan_nbr());
abb.relaloanid=rs.getString("relaloanid");abb.setKeyValue("RELALOANID",""+abb.getRelaloanid());
abb.zm_pmt_seq_nbr=rs.getString("zm_pmt_seq_nbr");abb.setKeyValue("ZM_PMT_SEQ_NBR",""+abb.getZm_pmt_seq_nbr());
abb.payperc=rs.getDouble("payperc");abb.setKeyValue("PAYPERC",""+abb.getPayperc());
abb.fundsour=rs.getString("fundsour");abb.setKeyValue("FUNDSOUR",""+abb.getFundsour());
abb.ln_purp=rs.getString("ln_purp");abb.setKeyValue("LN_PURP",""+abb.getLn_purp());
abb.guaranty_type=rs.getString("guaranty_type");abb.setKeyValue("GUARANTY_TYPE",""+abb.getGuaranty_type());
abb.aply_dt=rs.getString("aply_dt");abb.setKeyValue("APLY_DT",""+abb.getAply_dt());
abb.crlmt_amt=rs.getDouble("crlmt_amt");abb.setKeyValue("CRLMT_AMT",""+abb.getCrlmt_amt());
abb.cycflag=rs.getString("cycflag");abb.setKeyValue("CYCFLAG",""+abb.getCycflag());
abb.rt_orig_loan_amt=rs.getDouble("rt_orig_loan_amt");abb.setKeyValue("RT_ORIG_LOAN_AMT",""+abb.getRt_orig_loan_amt());
abb.rt_orig_procd_amt=rs.getDouble("rt_orig_procd_amt");abb.setKeyValue("RT_ORIG_PROCD_AMT",""+abb.getRt_orig_procd_amt());
abb.rt_term_freq=rs.getString("rt_term_freq");abb.setKeyValue("RT_TERM_FREQ",""+abb.getRt_term_freq());
abb.rt_term_incr=rs.getInt("rt_term_incr");abb.setKeyValue("RT_TERM_INCR",""+abb.getRt_term_incr());
abb.pay_type=rs.getString("pay_type");abb.setKeyValue("PAY_TYPE",""+abb.getPay_type());
abb.trothdueday=rs.getString("trothdueday");abb.setKeyValue("TROTHDUEDAY",""+abb.getTrothdueday());
abb.fixrateterm=rs.getInt("fixrateterm");abb.setKeyValue("FIXRATETERM",""+abb.getFixrateterm());
abb.rt_frst_due_date=rs.getString("rt_frst_due_date");abb.setKeyValue("RT_FRST_DUE_DATE",""+abb.getRt_frst_due_date());
abb.subsflag=rs.getString("subsflag");abb.setKeyValue("SUBSFLAG",""+abb.getSubsflag());
abb.isenousubs=rs.getString("isenousubs");abb.setKeyValue("ISENOUSUBS",""+abb.getIsenousubs());
abb.firstpayamt=rs.getDouble("firstpayamt");abb.setKeyValue("FIRSTPAYAMT",""+abb.getFirstpayamt());
abb.firstpayperc=rs.getDouble("firstpayperc");abb.setKeyValue("FIRSTPAYPERC",""+abb.getFirstpayperc());
abb.proj_no=rs.getString("proj_no");abb.setKeyValue("PROJ_NO",""+abb.getProj_no());
abb.corpappid=rs.getString("corpappid");abb.setKeyValue("CORPAPPID",""+abb.getCorpappid());
abb.releway=rs.getString("releway");abb.setKeyValue("RELEWAY",""+abb.getReleway());
abb.payee_acct_no=rs.getString("payee_acct_no");abb.setKeyValue("PAYEE_ACCT_NO",""+abb.getPayee_acct_no());
abb.intecalckind=rs.getString("intecalckind");abb.setKeyValue("INTECALCKIND",""+abb.getIntecalckind());
abb.intemeth=rs.getString("intemeth");abb.setKeyValue("INTEMETH",""+abb.getIntemeth());
abb.intebase=rs.getString("intebase");abb.setKeyValue("INTEBASE",""+abb.getIntebase());
abb.bl_lead_days=rs.getInt("bl_lead_days");abb.setKeyValue("BL_LEAD_DAYS",""+abb.getBl_lead_days());
abb.ratecode=rs.getString("ratecode");abb.setKeyValue("RATECODE",""+abb.getRatecode());
abb.basicinterate=rs.getDouble("basicinterate");abb.setKeyValue("BASICINTERATE",""+abb.getBasicinterate());
abb.rateact=rs.getString("rateact");abb.setKeyValue("RATEACT",""+abb.getRateact());
abb.ratecalevalue=rs.getDouble("ratecalevalue");abb.setKeyValue("RATECALEVALUE",""+abb.getRatecalevalue());
abb.interate=rs.getDouble("interate");abb.setKeyValue("INTERATE",""+abb.getInterate());
abb.intefineratefloat=rs.getDouble("intefineratefloat");abb.setKeyValue("INTEFINERATEFLOAT",""+abb.getIntefineratefloat());
abb.capifineratefloat=rs.getDouble("capifineratefloat");abb.setKeyValue("CAPIFINERATEFLOAT",""+abb.getCapifineratefloat());
abb.finerate=rs.getDouble("finerate");abb.setKeyValue("FINERATE",""+abb.getFinerate());
abb.capifinerate=rs.getDouble("capifinerate");abb.setKeyValue("CAPIFINERATE",""+abb.getCapifinerate());
abb.foulrate=rs.getDouble("foulrate");abb.setKeyValue("FOULRATE",""+abb.getFoulrate());
abb.emberatefloat=rs.getDouble("emberatefloat");abb.setKeyValue("EMBERATEFLOAT",""+abb.getEmberatefloat());
abb.progressive_addt_a=rs.getDouble("progressive_addt_a");abb.setKeyValue("PROGRESSIVE_ADDT_A",""+abb.getProgressive_addt_a());
abb.gainpct=rs.getDouble("gainpct");abb.setKeyValue("GAINPCT",""+abb.getGainpct());
abb.progressive_intv=rs.getInt("progressive_intv");abb.setKeyValue("PROGRESSIVE_INTV",""+abb.getProgressive_intv());
abb.firstgainterm=rs.getInt("firstgainterm");abb.setKeyValue("FIRSTGAINTERM",""+abb.getFirstgainterm());
abb.int_dis_rate=rs.getDouble("int_dis_rate");abb.setKeyValue("INT_DIS_RATE",""+abb.getInt_dis_rate());
abb.int_dis_end_dt=rs.getString("int_dis_end_dt");abb.setKeyValue("INT_DIS_END_DT",""+abb.getInt_dis_end_dt());
abb.fundcentno=rs.getString("fundcentno");abb.setKeyValue("FUNDCENTNO",""+abb.getFundcentno());
abb.manadept=rs.getString("manadept");abb.setKeyValue("MANADEPT",""+abb.getManadept());
abb.zm_aflc_code=rs.getString("zm_aflc_code");abb.setKeyValue("ZM_AFLC_CODE",""+abb.getZm_aflc_code());
abb.fundacno=rs.getString("fundacno");abb.setKeyValue("FUNDACNO",""+abb.getFundacno());
abb.capifundacno=rs.getString("capifundacno");abb.setKeyValue("CAPIFUNDACNO",""+abb.getCapifundacno());
abb.intefundacno=rs.getString("intefundacno");abb.setKeyValue("INTEFUNDACNO",""+abb.getIntefundacno());
abb.schid=rs.getString("schid");abb.setKeyValue("SCHID",""+abb.getSchid());
abb.cf_addr_num=rs.getString("cf_addr_num");abb.setKeyValue("CF_ADDR_NUM",""+abb.getCf_addr_num());
abb.cust_open_dt=rs.getString("cust_open_dt");abb.setKeyValue("CUST_OPEN_DT",""+abb.getCust_open_dt());
abb.expiring_dt=rs.getString("expiring_dt");abb.setKeyValue("EXPIRING_DT",""+abb.getExpiring_dt());
abb.cumulative_payout_amt=rs.getDouble("cumulative_payout_amt");abb.setKeyValue("CUMULATIVE_PAYOUT_AMT",""+abb.getCumulative_payout_amt());
abb.contno=rs.getString("contno");abb.setKeyValue("CONTNO",""+abb.getContno());
abb.bankid=rs.getString("bankid");abb.setKeyValue("BANKID",""+abb.getBankid());
abb.operid=rs.getString("operid");abb.setKeyValue("OPERID",""+abb.getOperid());
abb.survname=rs.getString("survname");abb.setKeyValue("SURVNAME",""+abb.getSurvname());
abb.auditing_name=rs.getString("auditing_name");abb.setKeyValue("AUDITING_NAME",""+abb.getAuditing_name());
abb.main_operation=rs.getString("main_operation");abb.setKeyValue("MAIN_OPERATION",""+abb.getMain_operation());
abb.apprname=rs.getString("apprname");abb.setKeyValue("APPRNAME",""+abb.getApprname());
abb.apprtabno=rs.getString("apprtabno");abb.setKeyValue("APPRTABNO",""+abb.getApprtabno());
abb.apprdate=rs.getString("apprdate");abb.setKeyValue("APPRDATE",""+abb.getApprdate());
abb.apprflag=rs.getString("apprflag");abb.setKeyValue("APPRFLAG",""+abb.getApprflag());
abb.authid=rs.getString("authid");abb.setKeyValue("AUTHID",""+abb.getAuthid());
abb.apprstate=rs.getString("apprstate");abb.setKeyValue("APPRSTATE",""+abb.getApprstate());
abb.loanstate=rs.getString("loanstate");abb.setKeyValue("LOANSTATE",""+abb.getLoanstate());
abb.apprtype=rs.getString("apprtype");abb.setKeyValue("APPRTYPE",""+abb.getApprtype());
abb.openbatchid=rs.getString("openbatchid");abb.setKeyValue("OPENBATCHID",""+abb.getOpenbatchid());
abb.accounting_org=rs.getString("accounting_org");abb.setKeyValue("ACCOUNTING_ORG",""+abb.getAccounting_org());
abb.loanevaldate=rs.getString("loanevaldate");abb.setKeyValue("LOANEVALDATE",""+abb.getLoanevaldate());
abb.agrflag=rs.getString("agrflag");abb.setKeyValue("AGRFLAG",""+abb.getAgrflag());
abb.loanevalvalue=rs.getDouble("loanevalvalue");abb.setKeyValue("LOANEVALVALUE",""+abb.getLoanevalvalue());
abb.sumevalvalue=rs.getDouble("sumevalvalue");abb.setKeyValue("SUMEVALVALUE",""+abb.getSumevalvalue());
abb.sumevaldate=rs.getString("sumevaldate");abb.setKeyValue("SUMEVALDATE",""+abb.getSumevaldate());
abb.agrname=rs.getString("agrname");abb.setKeyValue("AGRNAME",""+abb.getAgrname());
abb.account_no=rs.getString("account_no");abb.setKeyValue("ACCOUNT_NO",""+abb.getAccount_no());
abb.intefreq=rs.getString("intefreq");abb.setKeyValue("INTEFREQ",""+abb.getIntefreq());
abb.ratetype=rs.getString("ratetype");abb.setKeyValue("RATETYPE",""+abb.getRatetype());
abb.corpid=rs.getString("corpid");abb.setKeyValue("CORPID",""+abb.getCorpid());
abb.cust_name=rs.getString("cust_name");abb.setKeyValue("CUST_NAME",""+abb.getCust_name());
list.add(abb);
abb.operate_mode = "edit";
}public String getLoanid() { if ( this.loanid == null ) return ""; return this.loanid;}
public String getLn_acct_no() { if ( this.ln_acct_no == null ) return ""; return this.ln_acct_no;}
public String getOds_src_dt() { if ( this.ods_src_dt == null ) return ""; return this.ods_src_dt;}
public String getCust_no() { if ( this.cust_no == null ) return ""; return this.cust_no;}
public String getCrlmt_no() { if ( this.crlmt_no == null ) return ""; return this.crlmt_no;}
public String getIscommac() { if ( this.iscommac == null ) return ""; return this.iscommac;}
public String getCurr_cd() { if ( this.curr_cd == null ) return ""; return this.curr_cd;}
public String getLn_prod_cod() { if ( this.ln_prod_cod == null ) return ""; return this.ln_prod_cod;}
public String getLn_typ() { if ( this.ln_typ == null ) return ""; return this.ln_typ;}
public String getZm_pkg_loan_nbr() { if ( this.zm_pkg_loan_nbr == null ) return ""; return this.zm_pkg_loan_nbr;}
public String getRelaloanid() { if ( this.relaloanid == null ) return ""; return this.relaloanid;}
public String getZm_pmt_seq_nbr() { if ( this.zm_pmt_seq_nbr == null ) return ""; return this.zm_pmt_seq_nbr;}
public double getPayperc() { return this.payperc;}
public String getFundsour() { if ( this.fundsour == null ) return ""; return this.fundsour;}
public String getLn_purp() { if ( this.ln_purp == null ) return ""; return this.ln_purp;}
public String getGuaranty_type() { if ( this.guaranty_type == null ) return ""; return this.guaranty_type;}
public String getAply_dt() { if ( this.aply_dt == null ) return ""; return this.aply_dt;}
public double getCrlmt_amt() { return this.crlmt_amt;}
public String getCycflag() { if ( this.cycflag == null ) return ""; return this.cycflag;}
public double getRt_orig_loan_amt() { return this.rt_orig_loan_amt;}
public double getRt_orig_procd_amt() { return this.rt_orig_procd_amt;}
public String getRt_term_freq() { if ( this.rt_term_freq == null ) return ""; return this.rt_term_freq;}
public int getRt_term_incr() { return this.rt_term_incr;}
public String getPay_type() { if ( this.pay_type == null ) return ""; return this.pay_type;}
public String getTrothdueday() { if ( this.trothdueday == null ) return ""; return this.trothdueday;}
public int getFixrateterm() { return this.fixrateterm;}
public String getRt_frst_due_date() { if ( this.rt_frst_due_date == null ) return ""; return this.rt_frst_due_date;}
public String getSubsflag() { if ( this.subsflag == null ) return ""; return this.subsflag;}
public String getIsenousubs() { if ( this.isenousubs == null ) return ""; return this.isenousubs;}
public double getFirstpayamt() { return this.firstpayamt;}
public double getFirstpayperc() { return this.firstpayperc;}
public String getProj_no() { if ( this.proj_no == null ) return ""; return this.proj_no;}
public String getCorpappid() { if ( this.corpappid == null ) return ""; return this.corpappid;}
public String getReleway() { if ( this.releway == null ) return ""; return this.releway;}
public String getPayee_acct_no() { if ( this.payee_acct_no == null ) return ""; return this.payee_acct_no;}
public String getIntecalckind() { if ( this.intecalckind == null ) return ""; return this.intecalckind;}
public String getIntemeth() { if ( this.intemeth == null ) return ""; return this.intemeth;}
public String getIntebase() { if ( this.intebase == null ) return ""; return this.intebase;}
public int getBl_lead_days() { return this.bl_lead_days;}
public String getRatecode() { if ( this.ratecode == null ) return ""; return this.ratecode;}
public double getBasicinterate() { return this.basicinterate;}
public String getRateact() { if ( this.rateact == null ) return ""; return this.rateact;}
public double getRatecalevalue() { return this.ratecalevalue;}
public double getInterate() { return this.interate;}
public double getIntefineratefloat() { return this.intefineratefloat;}
public double getCapifineratefloat() { return this.capifineratefloat;}
public double getFinerate() { return this.finerate;}
public double getCapifinerate() { return this.capifinerate;}
public double getFoulrate() { return this.foulrate;}
public double getEmberatefloat() { return this.emberatefloat;}
public double getProgressive_addt_a() { return this.progressive_addt_a;}
public double getGainpct() { return this.gainpct;}
public int getProgressive_intv() { return this.progressive_intv;}
public int getFirstgainterm() { return this.firstgainterm;}
public double getInt_dis_rate() { return this.int_dis_rate;}
public String getInt_dis_end_dt() { if ( this.int_dis_end_dt == null ) return ""; return this.int_dis_end_dt;}
public String getFundcentno() { if ( this.fundcentno == null ) return ""; return this.fundcentno;}
public String getManadept() { if ( this.manadept == null ) return ""; return this.manadept;}
public String getZm_aflc_code() { if ( this.zm_aflc_code == null ) return ""; return this.zm_aflc_code;}
public String getFundacno() { if ( this.fundacno == null ) return ""; return this.fundacno;}
public String getCapifundacno() { if ( this.capifundacno == null ) return ""; return this.capifundacno;}
public String getIntefundacno() { if ( this.intefundacno == null ) return ""; return this.intefundacno;}
public String getSchid() { if ( this.schid == null ) return ""; return this.schid;}
public String getCf_addr_num() { if ( this.cf_addr_num == null ) return ""; return this.cf_addr_num;}
public String getCust_open_dt() { if ( this.cust_open_dt == null ) return ""; return this.cust_open_dt;}
public String getExpiring_dt() { if ( this.expiring_dt == null ) return ""; return this.expiring_dt;}
public double getCumulative_payout_amt() { return this.cumulative_payout_amt;}
public String getContno() { if ( this.contno == null ) return ""; return this.contno;}
public String getBankid() { if ( this.bankid == null ) return ""; return this.bankid;}
public String getOperid() { if ( this.operid == null ) return ""; return this.operid;}
public String getSurvname() { if ( this.survname == null ) return ""; return this.survname;}
public String getAuditing_name() { if ( this.auditing_name == null ) return ""; return this.auditing_name;}
public String getMain_operation() { if ( this.main_operation == null ) return ""; return this.main_operation;}
public String getApprname() { if ( this.apprname == null ) return ""; return this.apprname;}
public String getApprtabno() { if ( this.apprtabno == null ) return ""; return this.apprtabno;}
public String getApprdate() { if ( this.apprdate == null ) return ""; return this.apprdate;}
public String getApprflag() { if ( this.apprflag == null ) return ""; return this.apprflag;}
public String getAuthid() { if ( this.authid == null ) return ""; return this.authid;}
public String getApprstate() { if ( this.apprstate == null ) return ""; return this.apprstate;}
public String getLoanstate() { if ( this.loanstate == null ) return ""; return this.loanstate;}
public String getApprtype() { if ( this.apprtype == null ) return ""; return this.apprtype;}
public String getOpenbatchid() { if ( this.openbatchid == null ) return ""; return this.openbatchid;}
public String getAccounting_org() { if ( this.accounting_org == null ) return ""; return this.accounting_org;}
public String getLoanevaldate() { if ( this.loanevaldate == null ) return ""; return this.loanevaldate;}
public String getAgrflag() { if ( this.agrflag == null ) return ""; return this.agrflag;}
public double getLoanevalvalue() { return this.loanevalvalue;}
public double getSumevalvalue() { return this.sumevalvalue;}
public String getSumevaldate() { if ( this.sumevaldate == null ) return ""; return this.sumevaldate;}
public String getAgrname() { if ( this.agrname == null ) return ""; return this.agrname;}
public String getAccount_no() { if ( this.account_no == null ) return ""; return this.account_no;}
public String getIntefreq() { if ( this.intefreq == null ) return ""; return this.intefreq;}
public String getRatetype() { if ( this.ratetype == null ) return ""; return this.ratetype;}
public String getCorpid() { if ( this.corpid == null ) return ""; return this.corpid;}
public String getCust_name() { if ( this.cust_name == null ) return ""; return this.cust_name;}
public void setLoanid(String loanid) { sqlMaker.setField("loanid",loanid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLoanid().equals(loanid)) cf.add("loanid",this.loanid,loanid); } this.loanid=loanid;}
public void setLn_acct_no(String ln_acct_no) { sqlMaker.setField("ln_acct_no",ln_acct_no,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLn_acct_no().equals(ln_acct_no)) cf.add("ln_acct_no",this.ln_acct_no,ln_acct_no); } this.ln_acct_no=ln_acct_no;}
public void setOds_src_dt(String ods_src_dt) { sqlMaker.setField("ods_src_dt",ods_src_dt,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getOds_src_dt().equals(ods_src_dt)) cf.add("ods_src_dt",this.ods_src_dt,ods_src_dt); } this.ods_src_dt=ods_src_dt;}
public void setCust_no(String cust_no) { sqlMaker.setField("cust_no",cust_no,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCust_no().equals(cust_no)) cf.add("cust_no",this.cust_no,cust_no); } this.cust_no=cust_no;}
public void setCrlmt_no(String crlmt_no) { sqlMaker.setField("crlmt_no",crlmt_no,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCrlmt_no().equals(crlmt_no)) cf.add("crlmt_no",this.crlmt_no,crlmt_no); } this.crlmt_no=crlmt_no;}
public void setIscommac(String iscommac) { sqlMaker.setField("iscommac",iscommac,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getIscommac().equals(iscommac)) cf.add("iscommac",this.iscommac,iscommac); } this.iscommac=iscommac;}
public void setCurr_cd(String curr_cd) { sqlMaker.setField("curr_cd",curr_cd,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCurr_cd().equals(curr_cd)) cf.add("curr_cd",this.curr_cd,curr_cd); } this.curr_cd=curr_cd;}
public void setLn_prod_cod(String ln_prod_cod) { sqlMaker.setField("ln_prod_cod",ln_prod_cod,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLn_prod_cod().equals(ln_prod_cod)) cf.add("ln_prod_cod",this.ln_prod_cod,ln_prod_cod); } this.ln_prod_cod=ln_prod_cod;}
public void setLn_typ(String ln_typ) { sqlMaker.setField("ln_typ",ln_typ,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLn_typ().equals(ln_typ)) cf.add("ln_typ",this.ln_typ,ln_typ); } this.ln_typ=ln_typ;}
public void setZm_pkg_loan_nbr(String zm_pkg_loan_nbr) { sqlMaker.setField("zm_pkg_loan_nbr",zm_pkg_loan_nbr,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getZm_pkg_loan_nbr().equals(zm_pkg_loan_nbr)) cf.add("zm_pkg_loan_nbr",this.zm_pkg_loan_nbr,zm_pkg_loan_nbr); } this.zm_pkg_loan_nbr=zm_pkg_loan_nbr;}
public void setRelaloanid(String relaloanid) { sqlMaker.setField("relaloanid",relaloanid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRelaloanid().equals(relaloanid)) cf.add("relaloanid",this.relaloanid,relaloanid); } this.relaloanid=relaloanid;}
public void setZm_pmt_seq_nbr(String zm_pmt_seq_nbr) { sqlMaker.setField("zm_pmt_seq_nbr",zm_pmt_seq_nbr,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getZm_pmt_seq_nbr().equals(zm_pmt_seq_nbr)) cf.add("zm_pmt_seq_nbr",this.zm_pmt_seq_nbr,zm_pmt_seq_nbr); } this.zm_pmt_seq_nbr=zm_pmt_seq_nbr;}
public void setPayperc(double payperc) { sqlMaker.setField("payperc",""+payperc,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getPayperc()!=payperc) cf.add("payperc",this.payperc+"",payperc+""); } this.payperc=payperc;}
public void setFundsour(String fundsour) { sqlMaker.setField("fundsour",fundsour,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getFundsour().equals(fundsour)) cf.add("fundsour",this.fundsour,fundsour); } this.fundsour=fundsour;}
public void setLn_purp(String ln_purp) { sqlMaker.setField("ln_purp",ln_purp,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLn_purp().equals(ln_purp)) cf.add("ln_purp",this.ln_purp,ln_purp); } this.ln_purp=ln_purp;}
public void setGuaranty_type(String guaranty_type) { sqlMaker.setField("guaranty_type",guaranty_type,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getGuaranty_type().equals(guaranty_type)) cf.add("guaranty_type",this.guaranty_type,guaranty_type); } this.guaranty_type=guaranty_type;}
public void setAply_dt(String aply_dt) { sqlMaker.setField("aply_dt",aply_dt,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAply_dt().equals(aply_dt)) cf.add("aply_dt",this.aply_dt,aply_dt); } this.aply_dt=aply_dt;}
public void setCrlmt_amt(double crlmt_amt) { sqlMaker.setField("crlmt_amt",""+crlmt_amt,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getCrlmt_amt()!=crlmt_amt) cf.add("crlmt_amt",this.crlmt_amt+"",crlmt_amt+""); } this.crlmt_amt=crlmt_amt;}
public void setCycflag(String cycflag) { sqlMaker.setField("cycflag",cycflag,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCycflag().equals(cycflag)) cf.add("cycflag",this.cycflag,cycflag); } this.cycflag=cycflag;}
public void setRt_orig_loan_amt(double rt_orig_loan_amt) { sqlMaker.setField("rt_orig_loan_amt",""+rt_orig_loan_amt,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRt_orig_loan_amt()!=rt_orig_loan_amt) cf.add("rt_orig_loan_amt",this.rt_orig_loan_amt+"",rt_orig_loan_amt+""); } this.rt_orig_loan_amt=rt_orig_loan_amt;}
public void setRt_orig_procd_amt(double rt_orig_procd_amt) { sqlMaker.setField("rt_orig_procd_amt",""+rt_orig_procd_amt,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRt_orig_procd_amt()!=rt_orig_procd_amt) cf.add("rt_orig_procd_amt",this.rt_orig_procd_amt+"",rt_orig_procd_amt+""); } this.rt_orig_procd_amt=rt_orig_procd_amt;}
public void setRt_term_freq(String rt_term_freq) { sqlMaker.setField("rt_term_freq",rt_term_freq,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRt_term_freq().equals(rt_term_freq)) cf.add("rt_term_freq",this.rt_term_freq,rt_term_freq); } this.rt_term_freq=rt_term_freq;}
public void setRt_term_incr(int rt_term_incr) { sqlMaker.setField("rt_term_incr",""+rt_term_incr,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRt_term_incr()!=rt_term_incr) cf.add("rt_term_incr",this.rt_term_incr+"",rt_term_incr+""); } this.rt_term_incr=rt_term_incr;}
public void setPay_type(String pay_type) { sqlMaker.setField("pay_type",pay_type,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getPay_type().equals(pay_type)) cf.add("pay_type",this.pay_type,pay_type); } this.pay_type=pay_type;}
public void setTrothdueday(String trothdueday) { sqlMaker.setField("trothdueday",trothdueday,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getTrothdueday().equals(trothdueday)) cf.add("trothdueday",this.trothdueday,trothdueday); } this.trothdueday=trothdueday;}
public void setFixrateterm(int fixrateterm) { sqlMaker.setField("fixrateterm",""+fixrateterm,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getFixrateterm()!=fixrateterm) cf.add("fixrateterm",this.fixrateterm+"",fixrateterm+""); } this.fixrateterm=fixrateterm;}
public void setRt_frst_due_date(String rt_frst_due_date) { sqlMaker.setField("rt_frst_due_date",rt_frst_due_date,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRt_frst_due_date().equals(rt_frst_due_date)) cf.add("rt_frst_due_date",this.rt_frst_due_date,rt_frst_due_date); } this.rt_frst_due_date=rt_frst_due_date;}
public void setSubsflag(String subsflag) { sqlMaker.setField("subsflag",subsflag,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSubsflag().equals(subsflag)) cf.add("subsflag",this.subsflag,subsflag); } this.subsflag=subsflag;}
public void setIsenousubs(String isenousubs) { sqlMaker.setField("isenousubs",isenousubs,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getIsenousubs().equals(isenousubs)) cf.add("isenousubs",this.isenousubs,isenousubs); } this.isenousubs=isenousubs;}
public void setFirstpayamt(double firstpayamt) { sqlMaker.setField("firstpayamt",""+firstpayamt,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getFirstpayamt()!=firstpayamt) cf.add("firstpayamt",this.firstpayamt+"",firstpayamt+""); } this.firstpayamt=firstpayamt;}
public void setFirstpayperc(double firstpayperc) { sqlMaker.setField("firstpayperc",""+firstpayperc,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getFirstpayperc()!=firstpayperc) cf.add("firstpayperc",this.firstpayperc+"",firstpayperc+""); } this.firstpayperc=firstpayperc;}
public void setProj_no(String proj_no) { sqlMaker.setField("proj_no",proj_no,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getProj_no().equals(proj_no)) cf.add("proj_no",this.proj_no,proj_no); } this.proj_no=proj_no;}
public void setCorpappid(String corpappid) { sqlMaker.setField("corpappid",corpappid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCorpappid().equals(corpappid)) cf.add("corpappid",this.corpappid,corpappid); } this.corpappid=corpappid;}
public void setReleway(String releway) { sqlMaker.setField("releway",releway,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getReleway().equals(releway)) cf.add("releway",this.releway,releway); } this.releway=releway;}
public void setPayee_acct_no(String payee_acct_no) { sqlMaker.setField("payee_acct_no",payee_acct_no,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getPayee_acct_no().equals(payee_acct_no)) cf.add("payee_acct_no",this.payee_acct_no,payee_acct_no); } this.payee_acct_no=payee_acct_no;}
public void setIntecalckind(String intecalckind) { sqlMaker.setField("intecalckind",intecalckind,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getIntecalckind().equals(intecalckind)) cf.add("intecalckind",this.intecalckind,intecalckind); } this.intecalckind=intecalckind;}
public void setIntemeth(String intemeth) { sqlMaker.setField("intemeth",intemeth,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getIntemeth().equals(intemeth)) cf.add("intemeth",this.intemeth,intemeth); } this.intemeth=intemeth;}
public void setIntebase(String intebase) { sqlMaker.setField("intebase",intebase,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getIntebase().equals(intebase)) cf.add("intebase",this.intebase,intebase); } this.intebase=intebase;}
public void setBl_lead_days(int bl_lead_days) { sqlMaker.setField("bl_lead_days",""+bl_lead_days,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getBl_lead_days()!=bl_lead_days) cf.add("bl_lead_days",this.bl_lead_days+"",bl_lead_days+""); } this.bl_lead_days=bl_lead_days;}
public void setRatecode(String ratecode) { sqlMaker.setField("ratecode",ratecode,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRatecode().equals(ratecode)) cf.add("ratecode",this.ratecode,ratecode); } this.ratecode=ratecode;}
public void setBasicinterate(double basicinterate) { sqlMaker.setField("basicinterate",""+basicinterate,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getBasicinterate()!=basicinterate) cf.add("basicinterate",this.basicinterate+"",basicinterate+""); } this.basicinterate=basicinterate;}
public void setRateact(String rateact) { sqlMaker.setField("rateact",rateact,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRateact().equals(rateact)) cf.add("rateact",this.rateact,rateact); } this.rateact=rateact;}
public void setRatecalevalue(double ratecalevalue) { sqlMaker.setField("ratecalevalue",""+ratecalevalue,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRatecalevalue()!=ratecalevalue) cf.add("ratecalevalue",this.ratecalevalue+"",ratecalevalue+""); } this.ratecalevalue=ratecalevalue;}
public void setInterate(double interate) { sqlMaker.setField("interate",""+interate,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getInterate()!=interate) cf.add("interate",this.interate+"",interate+""); } this.interate=interate;}
public void setIntefineratefloat(double intefineratefloat) { sqlMaker.setField("intefineratefloat",""+intefineratefloat,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getIntefineratefloat()!=intefineratefloat) cf.add("intefineratefloat",this.intefineratefloat+"",intefineratefloat+""); } this.intefineratefloat=intefineratefloat;}
public void setCapifineratefloat(double capifineratefloat) { sqlMaker.setField("capifineratefloat",""+capifineratefloat,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getCapifineratefloat()!=capifineratefloat) cf.add("capifineratefloat",this.capifineratefloat+"",capifineratefloat+""); } this.capifineratefloat=capifineratefloat;}
public void setFinerate(double finerate) { sqlMaker.setField("finerate",""+finerate,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getFinerate()!=finerate) cf.add("finerate",this.finerate+"",finerate+""); } this.finerate=finerate;}
public void setCapifinerate(double capifinerate) { sqlMaker.setField("capifinerate",""+capifinerate,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getCapifinerate()!=capifinerate) cf.add("capifinerate",this.capifinerate+"",capifinerate+""); } this.capifinerate=capifinerate;}
public void setFoulrate(double foulrate) { sqlMaker.setField("foulrate",""+foulrate,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getFoulrate()!=foulrate) cf.add("foulrate",this.foulrate+"",foulrate+""); } this.foulrate=foulrate;}
public void setEmberatefloat(double emberatefloat) { sqlMaker.setField("emberatefloat",""+emberatefloat,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getEmberatefloat()!=emberatefloat) cf.add("emberatefloat",this.emberatefloat+"",emberatefloat+""); } this.emberatefloat=emberatefloat;}
public void setProgressive_addt_a(double progressive_addt_a) { sqlMaker.setField("progressive_addt_a",""+progressive_addt_a,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getProgressive_addt_a()!=progressive_addt_a) cf.add("progressive_addt_a",this.progressive_addt_a+"",progressive_addt_a+""); } this.progressive_addt_a=progressive_addt_a;}
public void setGainpct(double gainpct) { sqlMaker.setField("gainpct",""+gainpct,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getGainpct()!=gainpct) cf.add("gainpct",this.gainpct+"",gainpct+""); } this.gainpct=gainpct;}
public void setProgressive_intv(int progressive_intv) { sqlMaker.setField("progressive_intv",""+progressive_intv,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getProgressive_intv()!=progressive_intv) cf.add("progressive_intv",this.progressive_intv+"",progressive_intv+""); } this.progressive_intv=progressive_intv;}
public void setFirstgainterm(int firstgainterm) { sqlMaker.setField("firstgainterm",""+firstgainterm,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getFirstgainterm()!=firstgainterm) cf.add("firstgainterm",this.firstgainterm+"",firstgainterm+""); } this.firstgainterm=firstgainterm;}
public void setInt_dis_rate(double int_dis_rate) { sqlMaker.setField("int_dis_rate",""+int_dis_rate,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getInt_dis_rate()!=int_dis_rate) cf.add("int_dis_rate",this.int_dis_rate+"",int_dis_rate+""); } this.int_dis_rate=int_dis_rate;}
public void setInt_dis_end_dt(String int_dis_end_dt) { sqlMaker.setField("int_dis_end_dt",int_dis_end_dt,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getInt_dis_end_dt().equals(int_dis_end_dt)) cf.add("int_dis_end_dt",this.int_dis_end_dt,int_dis_end_dt); } this.int_dis_end_dt=int_dis_end_dt;}
public void setFundcentno(String fundcentno) { sqlMaker.setField("fundcentno",fundcentno,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getFundcentno().equals(fundcentno)) cf.add("fundcentno",this.fundcentno,fundcentno); } this.fundcentno=fundcentno;}
public void setManadept(String manadept) { sqlMaker.setField("manadept",manadept,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getManadept().equals(manadept)) cf.add("manadept",this.manadept,manadept); } this.manadept=manadept;}
public void setZm_aflc_code(String zm_aflc_code) { sqlMaker.setField("zm_aflc_code",zm_aflc_code,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getZm_aflc_code().equals(zm_aflc_code)) cf.add("zm_aflc_code",this.zm_aflc_code,zm_aflc_code); } this.zm_aflc_code=zm_aflc_code;}
public void setFundacno(String fundacno) { sqlMaker.setField("fundacno",fundacno,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getFundacno().equals(fundacno)) cf.add("fundacno",this.fundacno,fundacno); } this.fundacno=fundacno;}
public void setCapifundacno(String capifundacno) { sqlMaker.setField("capifundacno",capifundacno,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCapifundacno().equals(capifundacno)) cf.add("capifundacno",this.capifundacno,capifundacno); } this.capifundacno=capifundacno;}
public void setIntefundacno(String intefundacno) { sqlMaker.setField("intefundacno",intefundacno,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getIntefundacno().equals(intefundacno)) cf.add("intefundacno",this.intefundacno,intefundacno); } this.intefundacno=intefundacno;}
public void setSchid(String schid) { sqlMaker.setField("schid",schid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSchid().equals(schid)) cf.add("schid",this.schid,schid); } this.schid=schid;}
public void setCf_addr_num(String cf_addr_num) { sqlMaker.setField("cf_addr_num",cf_addr_num,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCf_addr_num().equals(cf_addr_num)) cf.add("cf_addr_num",this.cf_addr_num,cf_addr_num); } this.cf_addr_num=cf_addr_num;}
public void setCust_open_dt(String cust_open_dt) { sqlMaker.setField("cust_open_dt",cust_open_dt,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCust_open_dt().equals(cust_open_dt)) cf.add("cust_open_dt",this.cust_open_dt,cust_open_dt); } this.cust_open_dt=cust_open_dt;}
public void setExpiring_dt(String expiring_dt) { sqlMaker.setField("expiring_dt",expiring_dt,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getExpiring_dt().equals(expiring_dt)) cf.add("expiring_dt",this.expiring_dt,expiring_dt); } this.expiring_dt=expiring_dt;}
public void setCumulative_payout_amt(double cumulative_payout_amt) { sqlMaker.setField("cumulative_payout_amt",""+cumulative_payout_amt,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getCumulative_payout_amt()!=cumulative_payout_amt) cf.add("cumulative_payout_amt",this.cumulative_payout_amt+"",cumulative_payout_amt+""); } this.cumulative_payout_amt=cumulative_payout_amt;}
public void setContno(String contno) { sqlMaker.setField("contno",contno,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getContno().equals(contno)) cf.add("contno",this.contno,contno); } this.contno=contno;}
public void setBankid(String bankid) { sqlMaker.setField("bankid",bankid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getBankid().equals(bankid)) cf.add("bankid",this.bankid,bankid); } this.bankid=bankid;}
public void setOperid(String operid) { sqlMaker.setField("operid",operid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getOperid().equals(operid)) cf.add("operid",this.operid,operid); } this.operid=operid;}
public void setSurvname(String survname) { sqlMaker.setField("survname",survname,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSurvname().equals(survname)) cf.add("survname",this.survname,survname); } this.survname=survname;}
public void setAuditing_name(String auditing_name) { sqlMaker.setField("auditing_name",auditing_name,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAuditing_name().equals(auditing_name)) cf.add("auditing_name",this.auditing_name,auditing_name); } this.auditing_name=auditing_name;}
public void setMain_operation(String main_operation) { sqlMaker.setField("main_operation",main_operation,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getMain_operation().equals(main_operation)) cf.add("main_operation",this.main_operation,main_operation); } this.main_operation=main_operation;}
public void setApprname(String apprname) { sqlMaker.setField("apprname",apprname,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getApprname().equals(apprname)) cf.add("apprname",this.apprname,apprname); } this.apprname=apprname;}
public void setApprtabno(String apprtabno) { sqlMaker.setField("apprtabno",apprtabno,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getApprtabno().equals(apprtabno)) cf.add("apprtabno",this.apprtabno,apprtabno); } this.apprtabno=apprtabno;}
public void setApprdate(String apprdate) { sqlMaker.setField("apprdate",apprdate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getApprdate().equals(apprdate)) cf.add("apprdate",this.apprdate,apprdate); } this.apprdate=apprdate;}
public void setApprflag(String apprflag) { sqlMaker.setField("apprflag",apprflag,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getApprflag().equals(apprflag)) cf.add("apprflag",this.apprflag,apprflag); } this.apprflag=apprflag;}
public void setAuthid(String authid) { sqlMaker.setField("authid",authid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAuthid().equals(authid)) cf.add("authid",this.authid,authid); } this.authid=authid;}
public void setApprstate(String apprstate) { sqlMaker.setField("apprstate",apprstate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getApprstate().equals(apprstate)) cf.add("apprstate",this.apprstate,apprstate); } this.apprstate=apprstate;}
public void setLoanstate(String loanstate) { sqlMaker.setField("loanstate",loanstate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLoanstate().equals(loanstate)) cf.add("loanstate",this.loanstate,loanstate); } this.loanstate=loanstate;}
public void setApprtype(String apprtype) { sqlMaker.setField("apprtype",apprtype,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getApprtype().equals(apprtype)) cf.add("apprtype",this.apprtype,apprtype); } this.apprtype=apprtype;}
public void setOpenbatchid(String openbatchid) { sqlMaker.setField("openbatchid",openbatchid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getOpenbatchid().equals(openbatchid)) cf.add("openbatchid",this.openbatchid,openbatchid); } this.openbatchid=openbatchid;}
public void setAccounting_org(String accounting_org) { sqlMaker.setField("accounting_org",accounting_org,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAccounting_org().equals(accounting_org)) cf.add("accounting_org",this.accounting_org,accounting_org); } this.accounting_org=accounting_org;}
public void setLoanevaldate(String loanevaldate) { sqlMaker.setField("loanevaldate",loanevaldate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLoanevaldate().equals(loanevaldate)) cf.add("loanevaldate",this.loanevaldate,loanevaldate); } this.loanevaldate=loanevaldate;}
public void setAgrflag(String agrflag) { sqlMaker.setField("agrflag",agrflag,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAgrflag().equals(agrflag)) cf.add("agrflag",this.agrflag,agrflag); } this.agrflag=agrflag;}
public void setLoanevalvalue(double loanevalvalue) { sqlMaker.setField("loanevalvalue",""+loanevalvalue,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getLoanevalvalue()!=loanevalvalue) cf.add("loanevalvalue",this.loanevalvalue+"",loanevalvalue+""); } this.loanevalvalue=loanevalvalue;}
public void setSumevalvalue(double sumevalvalue) { sqlMaker.setField("sumevalvalue",""+sumevalvalue,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getSumevalvalue()!=sumevalvalue) cf.add("sumevalvalue",this.sumevalvalue+"",sumevalvalue+""); } this.sumevalvalue=sumevalvalue;}
public void setSumevaldate(String sumevaldate) { sqlMaker.setField("sumevaldate",sumevaldate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSumevaldate().equals(sumevaldate)) cf.add("sumevaldate",this.sumevaldate,sumevaldate); } this.sumevaldate=sumevaldate;}
public void setAgrname(String agrname) { sqlMaker.setField("agrname",agrname,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAgrname().equals(agrname)) cf.add("agrname",this.agrname,agrname); } this.agrname=agrname;}
public void setAccount_no(String account_no) { sqlMaker.setField("account_no",account_no,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAccount_no().equals(account_no)) cf.add("account_no",this.account_no,account_no); } this.account_no=account_no;}
public void setIntefreq(String intefreq) { sqlMaker.setField("intefreq",intefreq,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getIntefreq().equals(intefreq)) cf.add("intefreq",this.intefreq,intefreq); } this.intefreq=intefreq;}
public void setRatetype(String ratetype) { sqlMaker.setField("ratetype",ratetype,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRatetype().equals(ratetype)) cf.add("ratetype",this.ratetype,ratetype); } this.ratetype=ratetype;}
public void setCorpid(String corpid) { sqlMaker.setField("corpid",corpid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCorpid().equals(corpid)) cf.add("corpid",this.corpid,corpid); } this.corpid=corpid;}
public void setCust_name(String cust_name) { sqlMaker.setField("cust_name",cust_name,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCust_name().equals(cust_name)) cf.add("cust_name",this.cust_name,cust_name); } this.cust_name=cust_name;}
public void init(int i,ActionRequest actionRequest) throws Exception { if ( actionRequest.getFieldValue(i,"loanid") !=null ) {this.setLoanid(actionRequest.getFieldValue(i,"loanid"));}
if ( actionRequest.getFieldValue(i,"ln_acct_no") !=null ) {this.setLn_acct_no(actionRequest.getFieldValue(i,"ln_acct_no"));}
if ( actionRequest.getFieldValue(i,"ods_src_dt") !=null ) {this.setOds_src_dt(actionRequest.getFieldValue(i,"ods_src_dt"));}
if ( actionRequest.getFieldValue(i,"cust_no") !=null ) {this.setCust_no(actionRequest.getFieldValue(i,"cust_no"));}
if ( actionRequest.getFieldValue(i,"crlmt_no") !=null ) {this.setCrlmt_no(actionRequest.getFieldValue(i,"crlmt_no"));}
if ( actionRequest.getFieldValue(i,"iscommac") !=null ) {this.setIscommac(actionRequest.getFieldValue(i,"iscommac"));}
if ( actionRequest.getFieldValue(i,"curr_cd") !=null ) {this.setCurr_cd(actionRequest.getFieldValue(i,"curr_cd"));}
if ( actionRequest.getFieldValue(i,"ln_prod_cod") !=null ) {this.setLn_prod_cod(actionRequest.getFieldValue(i,"ln_prod_cod"));}
if ( actionRequest.getFieldValue(i,"ln_typ") !=null ) {this.setLn_typ(actionRequest.getFieldValue(i,"ln_typ"));}
if ( actionRequest.getFieldValue(i,"zm_pkg_loan_nbr") !=null ) {this.setZm_pkg_loan_nbr(actionRequest.getFieldValue(i,"zm_pkg_loan_nbr"));}
if ( actionRequest.getFieldValue(i,"relaloanid") !=null ) {this.setRelaloanid(actionRequest.getFieldValue(i,"relaloanid"));}
if ( actionRequest.getFieldValue(i,"zm_pmt_seq_nbr") !=null ) {this.setZm_pmt_seq_nbr(actionRequest.getFieldValue(i,"zm_pmt_seq_nbr"));}
if ( actionRequest.getFieldValue(i,"payperc") !=null && actionRequest.getFieldValue(i,"payperc").trim().length() > 0 ) {this.setPayperc(Double.parseDouble(actionRequest.getFieldValue(i,"payperc")));}
if ( actionRequest.getFieldValue(i,"fundsour") !=null ) {this.setFundsour(actionRequest.getFieldValue(i,"fundsour"));}
if ( actionRequest.getFieldValue(i,"ln_purp") !=null ) {this.setLn_purp(actionRequest.getFieldValue(i,"ln_purp"));}
if ( actionRequest.getFieldValue(i,"guaranty_type") !=null ) {this.setGuaranty_type(actionRequest.getFieldValue(i,"guaranty_type"));}
if ( actionRequest.getFieldValue(i,"aply_dt") !=null ) {this.setAply_dt(actionRequest.getFieldValue(i,"aply_dt"));}
if ( actionRequest.getFieldValue(i,"crlmt_amt") !=null && actionRequest.getFieldValue(i,"crlmt_amt").trim().length() > 0 ) {this.setCrlmt_amt(Double.parseDouble(actionRequest.getFieldValue(i,"crlmt_amt")));}
if ( actionRequest.getFieldValue(i,"cycflag") !=null ) {this.setCycflag(actionRequest.getFieldValue(i,"cycflag"));}
if ( actionRequest.getFieldValue(i,"rt_orig_loan_amt") !=null && actionRequest.getFieldValue(i,"rt_orig_loan_amt").trim().length() > 0 ) {this.setRt_orig_loan_amt(Double.parseDouble(actionRequest.getFieldValue(i,"rt_orig_loan_amt")));}
if ( actionRequest.getFieldValue(i,"rt_orig_procd_amt") !=null && actionRequest.getFieldValue(i,"rt_orig_procd_amt").trim().length() > 0 ) {this.setRt_orig_procd_amt(Double.parseDouble(actionRequest.getFieldValue(i,"rt_orig_procd_amt")));}
if ( actionRequest.getFieldValue(i,"rt_term_freq") !=null ) {this.setRt_term_freq(actionRequest.getFieldValue(i,"rt_term_freq"));}
if ( actionRequest.getFieldValue(i,"rt_term_incr") !=null && actionRequest.getFieldValue(i,"rt_term_incr").trim().length() > 0 ) {this.setRt_term_incr(Integer.parseInt(actionRequest.getFieldValue(i,"rt_term_incr")));}
if ( actionRequest.getFieldValue(i,"pay_type") !=null ) {this.setPay_type(actionRequest.getFieldValue(i,"pay_type"));}
if ( actionRequest.getFieldValue(i,"trothdueday") !=null ) {this.setTrothdueday(actionRequest.getFieldValue(i,"trothdueday"));}
if ( actionRequest.getFieldValue(i,"fixrateterm") !=null && actionRequest.getFieldValue(i,"fixrateterm").trim().length() > 0 ) {this.setFixrateterm(Integer.parseInt(actionRequest.getFieldValue(i,"fixrateterm")));}
if ( actionRequest.getFieldValue(i,"rt_frst_due_date") !=null ) {this.setRt_frst_due_date(actionRequest.getFieldValue(i,"rt_frst_due_date"));}
if ( actionRequest.getFieldValue(i,"subsflag") !=null ) {this.setSubsflag(actionRequest.getFieldValue(i,"subsflag"));}
if ( actionRequest.getFieldValue(i,"isenousubs") !=null ) {this.setIsenousubs(actionRequest.getFieldValue(i,"isenousubs"));}
if ( actionRequest.getFieldValue(i,"firstpayamt") !=null && actionRequest.getFieldValue(i,"firstpayamt").trim().length() > 0 ) {this.setFirstpayamt(Double.parseDouble(actionRequest.getFieldValue(i,"firstpayamt")));}
if ( actionRequest.getFieldValue(i,"firstpayperc") !=null && actionRequest.getFieldValue(i,"firstpayperc").trim().length() > 0 ) {this.setFirstpayperc(Double.parseDouble(actionRequest.getFieldValue(i,"firstpayperc")));}
if ( actionRequest.getFieldValue(i,"proj_no") !=null ) {this.setProj_no(actionRequest.getFieldValue(i,"proj_no"));}
if ( actionRequest.getFieldValue(i,"corpappid") !=null ) {this.setCorpappid(actionRequest.getFieldValue(i,"corpappid"));}
if ( actionRequest.getFieldValue(i,"releway") !=null ) {this.setReleway(actionRequest.getFieldValue(i,"releway"));}
if ( actionRequest.getFieldValue(i,"payee_acct_no") !=null ) {this.setPayee_acct_no(actionRequest.getFieldValue(i,"payee_acct_no"));}
if ( actionRequest.getFieldValue(i,"intecalckind") !=null ) {this.setIntecalckind(actionRequest.getFieldValue(i,"intecalckind"));}
if ( actionRequest.getFieldValue(i,"intemeth") !=null ) {this.setIntemeth(actionRequest.getFieldValue(i,"intemeth"));}
if ( actionRequest.getFieldValue(i,"intebase") !=null ) {this.setIntebase(actionRequest.getFieldValue(i,"intebase"));}
if ( actionRequest.getFieldValue(i,"bl_lead_days") !=null && actionRequest.getFieldValue(i,"bl_lead_days").trim().length() > 0 ) {this.setBl_lead_days(Integer.parseInt(actionRequest.getFieldValue(i,"bl_lead_days")));}
if ( actionRequest.getFieldValue(i,"ratecode") !=null ) {this.setRatecode(actionRequest.getFieldValue(i,"ratecode"));}
if ( actionRequest.getFieldValue(i,"basicinterate") !=null && actionRequest.getFieldValue(i,"basicinterate").trim().length() > 0 ) {this.setBasicinterate(Double.parseDouble(actionRequest.getFieldValue(i,"basicinterate")));}
if ( actionRequest.getFieldValue(i,"rateact") !=null ) {this.setRateact(actionRequest.getFieldValue(i,"rateact"));}
if ( actionRequest.getFieldValue(i,"ratecalevalue") !=null && actionRequest.getFieldValue(i,"ratecalevalue").trim().length() > 0 ) {this.setRatecalevalue(Double.parseDouble(actionRequest.getFieldValue(i,"ratecalevalue")));}
if ( actionRequest.getFieldValue(i,"interate") !=null && actionRequest.getFieldValue(i,"interate").trim().length() > 0 ) {this.setInterate(Double.parseDouble(actionRequest.getFieldValue(i,"interate")));}
if ( actionRequest.getFieldValue(i,"intefineratefloat") !=null && actionRequest.getFieldValue(i,"intefineratefloat").trim().length() > 0 ) {this.setIntefineratefloat(Double.parseDouble(actionRequest.getFieldValue(i,"intefineratefloat")));}
if ( actionRequest.getFieldValue(i,"capifineratefloat") !=null && actionRequest.getFieldValue(i,"capifineratefloat").trim().length() > 0 ) {this.setCapifineratefloat(Double.parseDouble(actionRequest.getFieldValue(i,"capifineratefloat")));}
if ( actionRequest.getFieldValue(i,"finerate") !=null && actionRequest.getFieldValue(i,"finerate").trim().length() > 0 ) {this.setFinerate(Double.parseDouble(actionRequest.getFieldValue(i,"finerate")));}
if ( actionRequest.getFieldValue(i,"capifinerate") !=null && actionRequest.getFieldValue(i,"capifinerate").trim().length() > 0 ) {this.setCapifinerate(Double.parseDouble(actionRequest.getFieldValue(i,"capifinerate")));}
if ( actionRequest.getFieldValue(i,"foulrate") !=null && actionRequest.getFieldValue(i,"foulrate").trim().length() > 0 ) {this.setFoulrate(Double.parseDouble(actionRequest.getFieldValue(i,"foulrate")));}
if ( actionRequest.getFieldValue(i,"emberatefloat") !=null && actionRequest.getFieldValue(i,"emberatefloat").trim().length() > 0 ) {this.setEmberatefloat(Double.parseDouble(actionRequest.getFieldValue(i,"emberatefloat")));}
if ( actionRequest.getFieldValue(i,"progressive_addt_a") !=null && actionRequest.getFieldValue(i,"progressive_addt_a").trim().length() > 0 ) {this.setProgressive_addt_a(Double.parseDouble(actionRequest.getFieldValue(i,"progressive_addt_a")));}
if ( actionRequest.getFieldValue(i,"gainpct") !=null && actionRequest.getFieldValue(i,"gainpct").trim().length() > 0 ) {this.setGainpct(Double.parseDouble(actionRequest.getFieldValue(i,"gainpct")));}
if ( actionRequest.getFieldValue(i,"progressive_intv") !=null && actionRequest.getFieldValue(i,"progressive_intv").trim().length() > 0 ) {this.setProgressive_intv(Integer.parseInt(actionRequest.getFieldValue(i,"progressive_intv")));}
if ( actionRequest.getFieldValue(i,"firstgainterm") !=null && actionRequest.getFieldValue(i,"firstgainterm").trim().length() > 0 ) {this.setFirstgainterm(Integer.parseInt(actionRequest.getFieldValue(i,"firstgainterm")));}
if ( actionRequest.getFieldValue(i,"int_dis_rate") !=null && actionRequest.getFieldValue(i,"int_dis_rate").trim().length() > 0 ) {this.setInt_dis_rate(Double.parseDouble(actionRequest.getFieldValue(i,"int_dis_rate")));}
if ( actionRequest.getFieldValue(i,"int_dis_end_dt") !=null ) {this.setInt_dis_end_dt(actionRequest.getFieldValue(i,"int_dis_end_dt"));}
if ( actionRequest.getFieldValue(i,"fundcentno") !=null ) {this.setFundcentno(actionRequest.getFieldValue(i,"fundcentno"));}
if ( actionRequest.getFieldValue(i,"manadept") !=null ) {this.setManadept(actionRequest.getFieldValue(i,"manadept"));}
if ( actionRequest.getFieldValue(i,"zm_aflc_code") !=null ) {this.setZm_aflc_code(actionRequest.getFieldValue(i,"zm_aflc_code"));}
if ( actionRequest.getFieldValue(i,"fundacno") !=null ) {this.setFundacno(actionRequest.getFieldValue(i,"fundacno"));}
if ( actionRequest.getFieldValue(i,"capifundacno") !=null ) {this.setCapifundacno(actionRequest.getFieldValue(i,"capifundacno"));}
if ( actionRequest.getFieldValue(i,"intefundacno") !=null ) {this.setIntefundacno(actionRequest.getFieldValue(i,"intefundacno"));}
if ( actionRequest.getFieldValue(i,"schid") !=null ) {this.setSchid(actionRequest.getFieldValue(i,"schid"));}
if ( actionRequest.getFieldValue(i,"cf_addr_num") !=null ) {this.setCf_addr_num(actionRequest.getFieldValue(i,"cf_addr_num"));}
if ( actionRequest.getFieldValue(i,"cust_open_dt") !=null ) {this.setCust_open_dt(actionRequest.getFieldValue(i,"cust_open_dt"));}
if ( actionRequest.getFieldValue(i,"expiring_dt") !=null ) {this.setExpiring_dt(actionRequest.getFieldValue(i,"expiring_dt"));}
if ( actionRequest.getFieldValue(i,"cumulative_payout_amt") !=null && actionRequest.getFieldValue(i,"cumulative_payout_amt").trim().length() > 0 ) {this.setCumulative_payout_amt(Double.parseDouble(actionRequest.getFieldValue(i,"cumulative_payout_amt")));}
if ( actionRequest.getFieldValue(i,"contno") !=null ) {this.setContno(actionRequest.getFieldValue(i,"contno"));}
if ( actionRequest.getFieldValue(i,"bankid") !=null ) {this.setBankid(actionRequest.getFieldValue(i,"bankid"));}
if ( actionRequest.getFieldValue(i,"operid") !=null ) {this.setOperid(actionRequest.getFieldValue(i,"operid"));}
if ( actionRequest.getFieldValue(i,"survname") !=null ) {this.setSurvname(actionRequest.getFieldValue(i,"survname"));}
if ( actionRequest.getFieldValue(i,"auditing_name") !=null ) {this.setAuditing_name(actionRequest.getFieldValue(i,"auditing_name"));}
if ( actionRequest.getFieldValue(i,"main_operation") !=null ) {this.setMain_operation(actionRequest.getFieldValue(i,"main_operation"));}
if ( actionRequest.getFieldValue(i,"apprname") !=null ) {this.setApprname(actionRequest.getFieldValue(i,"apprname"));}
if ( actionRequest.getFieldValue(i,"apprtabno") !=null ) {this.setApprtabno(actionRequest.getFieldValue(i,"apprtabno"));}
if ( actionRequest.getFieldValue(i,"apprdate") !=null ) {this.setApprdate(actionRequest.getFieldValue(i,"apprdate"));}
if ( actionRequest.getFieldValue(i,"apprflag") !=null ) {this.setApprflag(actionRequest.getFieldValue(i,"apprflag"));}
if ( actionRequest.getFieldValue(i,"authid") !=null ) {this.setAuthid(actionRequest.getFieldValue(i,"authid"));}
if ( actionRequest.getFieldValue(i,"apprstate") !=null ) {this.setApprstate(actionRequest.getFieldValue(i,"apprstate"));}
if ( actionRequest.getFieldValue(i,"loanstate") !=null ) {this.setLoanstate(actionRequest.getFieldValue(i,"loanstate"));}
if ( actionRequest.getFieldValue(i,"apprtype") !=null ) {this.setApprtype(actionRequest.getFieldValue(i,"apprtype"));}
if ( actionRequest.getFieldValue(i,"openbatchid") !=null ) {this.setOpenbatchid(actionRequest.getFieldValue(i,"openbatchid"));}
if ( actionRequest.getFieldValue(i,"accounting_org") !=null ) {this.setAccounting_org(actionRequest.getFieldValue(i,"accounting_org"));}
if ( actionRequest.getFieldValue(i,"loanevaldate") !=null ) {this.setLoanevaldate(actionRequest.getFieldValue(i,"loanevaldate"));}
if ( actionRequest.getFieldValue(i,"agrflag") !=null ) {this.setAgrflag(actionRequest.getFieldValue(i,"agrflag"));}
if ( actionRequest.getFieldValue(i,"loanevalvalue") !=null && actionRequest.getFieldValue(i,"loanevalvalue").trim().length() > 0 ) {this.setLoanevalvalue(Double.parseDouble(actionRequest.getFieldValue(i,"loanevalvalue")));}
if ( actionRequest.getFieldValue(i,"sumevalvalue") !=null && actionRequest.getFieldValue(i,"sumevalvalue").trim().length() > 0 ) {this.setSumevalvalue(Double.parseDouble(actionRequest.getFieldValue(i,"sumevalvalue")));}
if ( actionRequest.getFieldValue(i,"sumevaldate") !=null ) {this.setSumevaldate(actionRequest.getFieldValue(i,"sumevaldate"));}
if ( actionRequest.getFieldValue(i,"agrname") !=null ) {this.setAgrname(actionRequest.getFieldValue(i,"agrname"));}
if ( actionRequest.getFieldValue(i,"account_no") !=null ) {this.setAccount_no(actionRequest.getFieldValue(i,"account_no"));}
if ( actionRequest.getFieldValue(i,"intefreq") !=null ) {this.setIntefreq(actionRequest.getFieldValue(i,"intefreq"));}
if ( actionRequest.getFieldValue(i,"ratetype") !=null ) {this.setRatetype(actionRequest.getFieldValue(i,"ratetype"));}
if ( actionRequest.getFieldValue(i,"corpid") !=null ) {this.setCorpid(actionRequest.getFieldValue(i,"corpid"));}
if ( actionRequest.getFieldValue(i,"cust_name") !=null ) {this.setCust_name(actionRequest.getFieldValue(i,"cust_name"));}
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { LNODSBLOANAPPLY obj = (LNODSBLOANAPPLY)super.clone();obj.setLoanid(obj.loanid);
obj.setLn_acct_no(obj.ln_acct_no);
obj.setOds_src_dt(obj.ods_src_dt);
obj.setCust_no(obj.cust_no);
obj.setCrlmt_no(obj.crlmt_no);
obj.setIscommac(obj.iscommac);
obj.setCurr_cd(obj.curr_cd);
obj.setLn_prod_cod(obj.ln_prod_cod);
obj.setLn_typ(obj.ln_typ);
obj.setZm_pkg_loan_nbr(obj.zm_pkg_loan_nbr);
obj.setRelaloanid(obj.relaloanid);
obj.setZm_pmt_seq_nbr(obj.zm_pmt_seq_nbr);
obj.setPayperc(obj.payperc);
obj.setFundsour(obj.fundsour);
obj.setLn_purp(obj.ln_purp);
obj.setGuaranty_type(obj.guaranty_type);
obj.setAply_dt(obj.aply_dt);
obj.setCrlmt_amt(obj.crlmt_amt);
obj.setCycflag(obj.cycflag);
obj.setRt_orig_loan_amt(obj.rt_orig_loan_amt);
obj.setRt_orig_procd_amt(obj.rt_orig_procd_amt);
obj.setRt_term_freq(obj.rt_term_freq);
obj.setRt_term_incr(obj.rt_term_incr);
obj.setPay_type(obj.pay_type);
obj.setTrothdueday(obj.trothdueday);
obj.setFixrateterm(obj.fixrateterm);
obj.setRt_frst_due_date(obj.rt_frst_due_date);
obj.setSubsflag(obj.subsflag);
obj.setIsenousubs(obj.isenousubs);
obj.setFirstpayamt(obj.firstpayamt);
obj.setFirstpayperc(obj.firstpayperc);
obj.setProj_no(obj.proj_no);
obj.setCorpappid(obj.corpappid);
obj.setReleway(obj.releway);
obj.setPayee_acct_no(obj.payee_acct_no);
obj.setIntecalckind(obj.intecalckind);
obj.setIntemeth(obj.intemeth);
obj.setIntebase(obj.intebase);
obj.setBl_lead_days(obj.bl_lead_days);
obj.setRatecode(obj.ratecode);
obj.setBasicinterate(obj.basicinterate);
obj.setRateact(obj.rateact);
obj.setRatecalevalue(obj.ratecalevalue);
obj.setInterate(obj.interate);
obj.setIntefineratefloat(obj.intefineratefloat);
obj.setCapifineratefloat(obj.capifineratefloat);
obj.setFinerate(obj.finerate);
obj.setCapifinerate(obj.capifinerate);
obj.setFoulrate(obj.foulrate);
obj.setEmberatefloat(obj.emberatefloat);
obj.setProgressive_addt_a(obj.progressive_addt_a);
obj.setGainpct(obj.gainpct);
obj.setProgressive_intv(obj.progressive_intv);
obj.setFirstgainterm(obj.firstgainterm);
obj.setInt_dis_rate(obj.int_dis_rate);
obj.setInt_dis_end_dt(obj.int_dis_end_dt);
obj.setFundcentno(obj.fundcentno);
obj.setManadept(obj.manadept);
obj.setZm_aflc_code(obj.zm_aflc_code);
obj.setFundacno(obj.fundacno);
obj.setCapifundacno(obj.capifundacno);
obj.setIntefundacno(obj.intefundacno);
obj.setSchid(obj.schid);
obj.setCf_addr_num(obj.cf_addr_num);
obj.setCust_open_dt(obj.cust_open_dt);
obj.setExpiring_dt(obj.expiring_dt);
obj.setCumulative_payout_amt(obj.cumulative_payout_amt);
obj.setContno(obj.contno);
obj.setBankid(obj.bankid);
obj.setOperid(obj.operid);
obj.setSurvname(obj.survname);
obj.setAuditing_name(obj.auditing_name);
obj.setMain_operation(obj.main_operation);
obj.setApprname(obj.apprname);
obj.setApprtabno(obj.apprtabno);
obj.setApprdate(obj.apprdate);
obj.setApprflag(obj.apprflag);
obj.setAuthid(obj.authid);
obj.setApprstate(obj.apprstate);
obj.setLoanstate(obj.loanstate);
obj.setApprtype(obj.apprtype);
obj.setOpenbatchid(obj.openbatchid);
obj.setAccounting_org(obj.accounting_org);
obj.setLoanevaldate(obj.loanevaldate);
obj.setAgrflag(obj.agrflag);
obj.setLoanevalvalue(obj.loanevalvalue);
obj.setSumevalvalue(obj.sumevalvalue);
obj.setSumevaldate(obj.sumevaldate);
obj.setAgrname(obj.agrname);
obj.setAccount_no(obj.account_no);
obj.setIntefreq(obj.intefreq);
obj.setRatetype(obj.ratetype);
obj.setCorpid(obj.corpid);
obj.setCust_name(obj.cust_name);
return obj;}}