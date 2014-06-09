package com.ccb.dao;
import java.util.*;
import pub.platform.db.*;
import pub.platform.utils.*;
import pub.platform.db.AbstractBasicBean;
public class LNODSBACCTLNS extends AbstractBasicBean implements Cloneable {
     public static List find(String sSqlWhere) {           return new LNODSBACCTLNS().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere) {           return new LNODSBACCTLNS().findAndLockByWhere(sSqlWhere);      }       public static LNODSBACCTLNS findFirst(String sSqlWhere) {           return (LNODSBACCTLNS)new LNODSBACCTLNS().findFirstByWhere(sSqlWhere);      }       public static LNODSBACCTLNS findFirstAndLock(String sSqlWhere) {           return (LNODSBACCTLNS)new LNODSBACCTLNS().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) {           return new LNODSBACCTLNS().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease) {           LNODSBACCTLNS bean = new LNODSBACCTLNS();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) {           LNODSBACCTLNS bean = new LNODSBACCTLNS();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static LNODSBACCTLNS findFirst(String sSqlWhere,boolean isAutoRelease) {           LNODSBACCTLNS bean = new LNODSBACCTLNS();           bean.setAutoRelease(isAutoRelease);           return (LNODSBACCTLNS)bean.findFirstByWhere(sSqlWhere);      }       public static LNODSBACCTLNS findFirstAndLock(String sSqlWhere,boolean isAutoRelease) {           LNODSBACCTLNS bean = new LNODSBACCTLNS();           bean.setAutoRelease(isAutoRelease);           return (LNODSBACCTLNS)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease) {           LNODSBACCTLNS bean = new LNODSBACCTLNS();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      }      public static List findByRow(String sSqlWhere,int row) {           return new LNODSBACCTLNS().findByWhereByRow(sSqlWhere,row);      } String ln_acct_no;
String ods_src_dt;
String cust_no;
String cust_open_dt;
String expiring_dt;
String poff_date;
String lastchgtime;
String acct_open_date;
String afinestartdate;
String rt_frst_due_date;
String accounting_org;
String bankid;
String operid;
String dutyid;
String ln_prod_cod;
String loanclass;
String ln_typ;
String nor_subject;
String due_subject;
String nonaccrued_subject;
String receivable_intr_subject;
String dunning_intr_subject;
String apcl_baddebts_sub;
String apcl_badint_sub;
String rt_term_freq;
int rt_term_incr;
String guaranty_type;
String credit_limit_num;
String subsflag;
String pay_type;
int turngraceday;
String highrisktype;
String riskflag;
String acct_stat;
String curr_cd;
double rt_orig_loan_amt;
double amt;
double ln_bal;
double bal_normal_prin;
double aubal;
double bal_of_past_due_pr;
double bal_dq_prin;
String ctrt_no;
double bal_of_out_int;
double ainte;
double binte;
double rcapi;
double int_income;
double afoul;
double ac_amt_pd_itd;
double tot_pd_brk_fee;
double asafine2;
double asbfine2;
double asafine1;
double int_rec_ali;
String ratecode;
double float_rate;
String rateact;
double ratecalevalue;
String ln_intr_adj_sty;
double ln_rate;
double capifineratefloat;
double intefineratefloat;
double finerate;
double capifinerate;
String zm_pkg_loan_nbr;
int bl_lead_days;
double ac_accr_mtd;
int curr_pmt_num;
int rt_actl_pmts_rem;
double fbal;
double ln_hxlx;
double rt_tot_coff_amt;
double zm_memo2_amt02_2;
double zm_memo2_amt02_3;
double du_pmt_bill_0;
double du_pmt_bill_1;
double pre_pay_amt;
double tot_penalty_pay_am;
double cumulative_payout_amt;
double progressive_addt_a;
double gainpct;
int progressive_intv;
public static final String TABLENAME ="ln_odsb_acct_lns";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
public void addObject(List list,RecordSet rs) {
LNODSBACCTLNS abb = new LNODSBACCTLNS();
abb.ln_acct_no=rs.getString("ln_acct_no");abb.setKeyValue("LN_ACCT_NO",""+abb.getLn_acct_no());
abb.ods_src_dt=rs.getString("ods_src_dt");abb.setKeyValue("ODS_SRC_DT",""+abb.getOds_src_dt());
abb.cust_no=rs.getString("cust_no");abb.setKeyValue("CUST_NO",""+abb.getCust_no());
abb.cust_open_dt=rs.getString("cust_open_dt");abb.setKeyValue("CUST_OPEN_DT",""+abb.getCust_open_dt());
abb.expiring_dt=rs.getString("expiring_dt");abb.setKeyValue("EXPIRING_DT",""+abb.getExpiring_dt());
abb.poff_date=rs.getString("poff_date");abb.setKeyValue("POFF_DATE",""+abb.getPoff_date());
abb.lastchgtime=rs.getString("lastchgtime");abb.setKeyValue("LASTCHGTIME",""+abb.getLastchgtime());
abb.acct_open_date=rs.getString("acct_open_date");abb.setKeyValue("ACCT_OPEN_DATE",""+abb.getAcct_open_date());
abb.afinestartdate=rs.getString("afinestartdate");abb.setKeyValue("AFINESTARTDATE",""+abb.getAfinestartdate());
abb.rt_frst_due_date=rs.getString("rt_frst_due_date");abb.setKeyValue("RT_FRST_DUE_DATE",""+abb.getRt_frst_due_date());
abb.accounting_org=rs.getString("accounting_org");abb.setKeyValue("ACCOUNTING_ORG",""+abb.getAccounting_org());
abb.bankid=rs.getString("bankid");abb.setKeyValue("BANKID",""+abb.getBankid());
abb.operid=rs.getString("operid");abb.setKeyValue("OPERID",""+abb.getOperid());
abb.dutyid=rs.getString("dutyid");abb.setKeyValue("DUTYID",""+abb.getDutyid());
abb.ln_prod_cod=rs.getString("ln_prod_cod");abb.setKeyValue("LN_PROD_COD",""+abb.getLn_prod_cod());
abb.loanclass=rs.getString("loanclass");abb.setKeyValue("LOANCLASS",""+abb.getLoanclass());
abb.ln_typ=rs.getString("ln_typ");abb.setKeyValue("LN_TYP",""+abb.getLn_typ());
abb.nor_subject=rs.getString("nor_subject");abb.setKeyValue("NOR_SUBJECT",""+abb.getNor_subject());
abb.due_subject=rs.getString("due_subject");abb.setKeyValue("DUE_SUBJECT",""+abb.getDue_subject());
abb.nonaccrued_subject=rs.getString("nonaccrued_subject");abb.setKeyValue("NONACCRUED_SUBJECT",""+abb.getNonaccrued_subject());
abb.receivable_intr_subject=rs.getString("receivable_intr_subject");abb.setKeyValue("RECEIVABLE_INTR_SUBJECT",""+abb.getReceivable_intr_subject());
abb.dunning_intr_subject=rs.getString("dunning_intr_subject");abb.setKeyValue("DUNNING_INTR_SUBJECT",""+abb.getDunning_intr_subject());
abb.apcl_baddebts_sub=rs.getString("apcl_baddebts_sub");abb.setKeyValue("APCL_BADDEBTS_SUB",""+abb.getApcl_baddebts_sub());
abb.apcl_badint_sub=rs.getString("apcl_badint_sub");abb.setKeyValue("APCL_BADINT_SUB",""+abb.getApcl_badint_sub());
abb.rt_term_freq=rs.getString("rt_term_freq");abb.setKeyValue("RT_TERM_FREQ",""+abb.getRt_term_freq());
abb.rt_term_incr=rs.getInt("rt_term_incr");abb.setKeyValue("RT_TERM_INCR",""+abb.getRt_term_incr());
abb.guaranty_type=rs.getString("guaranty_type");abb.setKeyValue("GUARANTY_TYPE",""+abb.getGuaranty_type());
abb.credit_limit_num=rs.getString("credit_limit_num");abb.setKeyValue("CREDIT_LIMIT_NUM",""+abb.getCredit_limit_num());
abb.subsflag=rs.getString("subsflag");abb.setKeyValue("SUBSFLAG",""+abb.getSubsflag());
abb.pay_type=rs.getString("pay_type");abb.setKeyValue("PAY_TYPE",""+abb.getPay_type());
abb.turngraceday=rs.getInt("turngraceday");abb.setKeyValue("TURNGRACEDAY",""+abb.getTurngraceday());
abb.highrisktype=rs.getString("highrisktype");abb.setKeyValue("HIGHRISKTYPE",""+abb.getHighrisktype());
abb.riskflag=rs.getString("riskflag");abb.setKeyValue("RISKFLAG",""+abb.getRiskflag());
abb.acct_stat=rs.getString("acct_stat");abb.setKeyValue("ACCT_STAT",""+abb.getAcct_stat());
abb.curr_cd=rs.getString("curr_cd");abb.setKeyValue("CURR_CD",""+abb.getCurr_cd());
abb.rt_orig_loan_amt=rs.getDouble("rt_orig_loan_amt");abb.setKeyValue("RT_ORIG_LOAN_AMT",""+abb.getRt_orig_loan_amt());
abb.amt=rs.getDouble("amt");abb.setKeyValue("AMT",""+abb.getAmt());
abb.ln_bal=rs.getDouble("ln_bal");abb.setKeyValue("LN_BAL",""+abb.getLn_bal());
abb.bal_normal_prin=rs.getDouble("bal_normal_prin");abb.setKeyValue("BAL_NORMAL_PRIN",""+abb.getBal_normal_prin());
abb.aubal=rs.getDouble("aubal");abb.setKeyValue("AUBAL",""+abb.getAubal());
abb.bal_of_past_due_pr=rs.getDouble("bal_of_past_due_pr");abb.setKeyValue("BAL_OF_PAST_DUE_PR",""+abb.getBal_of_past_due_pr());
abb.bal_dq_prin=rs.getDouble("bal_dq_prin");abb.setKeyValue("BAL_DQ_PRIN",""+abb.getBal_dq_prin());
abb.ctrt_no=rs.getString("ctrt_no");abb.setKeyValue("CTRT_NO",""+abb.getCtrt_no());
abb.bal_of_out_int=rs.getDouble("bal_of_out_int");abb.setKeyValue("BAL_OF_OUT_INT",""+abb.getBal_of_out_int());
abb.ainte=rs.getDouble("ainte");abb.setKeyValue("AINTE",""+abb.getAinte());
abb.binte=rs.getDouble("binte");abb.setKeyValue("BINTE",""+abb.getBinte());
abb.rcapi=rs.getDouble("rcapi");abb.setKeyValue("RCAPI",""+abb.getRcapi());
abb.int_income=rs.getDouble("int_income");abb.setKeyValue("INT_INCOME",""+abb.getInt_income());
abb.afoul=rs.getDouble("afoul");abb.setKeyValue("AFOUL",""+abb.getAfoul());
abb.ac_amt_pd_itd=rs.getDouble("ac_amt_pd_itd");abb.setKeyValue("AC_AMT_PD_ITD",""+abb.getAc_amt_pd_itd());
abb.tot_pd_brk_fee=rs.getDouble("tot_pd_brk_fee");abb.setKeyValue("TOT_PD_BRK_FEE",""+abb.getTot_pd_brk_fee());
abb.asafine2=rs.getDouble("asafine2");abb.setKeyValue("ASAFINE2",""+abb.getAsafine2());
abb.asbfine2=rs.getDouble("asbfine2");abb.setKeyValue("ASBFINE2",""+abb.getAsbfine2());
abb.asafine1=rs.getDouble("asafine1");abb.setKeyValue("ASAFINE1",""+abb.getAsafine1());
abb.int_rec_ali=rs.getDouble("int_rec_ali");abb.setKeyValue("INT_REC_ALI",""+abb.getInt_rec_ali());
abb.ratecode=rs.getString("ratecode");abb.setKeyValue("RATECODE",""+abb.getRatecode());
abb.float_rate=rs.getDouble("float_rate");abb.setKeyValue("FLOAT_RATE",""+abb.getFloat_rate());
abb.rateact=rs.getString("rateact");abb.setKeyValue("RATEACT",""+abb.getRateact());
abb.ratecalevalue=rs.getDouble("ratecalevalue");abb.setKeyValue("RATECALEVALUE",""+abb.getRatecalevalue());
abb.ln_intr_adj_sty=rs.getString("ln_intr_adj_sty");abb.setKeyValue("LN_INTR_ADJ_STY",""+abb.getLn_intr_adj_sty());
abb.ln_rate=rs.getDouble("ln_rate");abb.setKeyValue("LN_RATE",""+abb.getLn_rate());
abb.capifineratefloat=rs.getDouble("capifineratefloat");abb.setKeyValue("CAPIFINERATEFLOAT",""+abb.getCapifineratefloat());
abb.intefineratefloat=rs.getDouble("intefineratefloat");abb.setKeyValue("INTEFINERATEFLOAT",""+abb.getIntefineratefloat());
abb.finerate=rs.getDouble("finerate");abb.setKeyValue("FINERATE",""+abb.getFinerate());
abb.capifinerate=rs.getDouble("capifinerate");abb.setKeyValue("CAPIFINERATE",""+abb.getCapifinerate());
abb.zm_pkg_loan_nbr=rs.getString("zm_pkg_loan_nbr");abb.setKeyValue("ZM_PKG_LOAN_NBR",""+abb.getZm_pkg_loan_nbr());
abb.bl_lead_days=rs.getInt("bl_lead_days");abb.setKeyValue("BL_LEAD_DAYS",""+abb.getBl_lead_days());
abb.ac_accr_mtd=rs.getDouble("ac_accr_mtd");abb.setKeyValue("AC_ACCR_MTD",""+abb.getAc_accr_mtd());
abb.curr_pmt_num=rs.getInt("curr_pmt_num");abb.setKeyValue("CURR_PMT_NUM",""+abb.getCurr_pmt_num());
abb.rt_actl_pmts_rem=rs.getInt("rt_actl_pmts_rem");abb.setKeyValue("RT_ACTL_PMTS_REM",""+abb.getRt_actl_pmts_rem());
abb.fbal=rs.getDouble("fbal");abb.setKeyValue("FBAL",""+abb.getFbal());
abb.ln_hxlx=rs.getDouble("ln_hxlx");abb.setKeyValue("LN_HXLX",""+abb.getLn_hxlx());
abb.rt_tot_coff_amt=rs.getDouble("rt_tot_coff_amt");abb.setKeyValue("RT_TOT_COFF_AMT",""+abb.getRt_tot_coff_amt());
abb.zm_memo2_amt02_2=rs.getDouble("zm_memo2_amt02_2");abb.setKeyValue("ZM_MEMO2_AMT02_2",""+abb.getZm_memo2_amt02_2());
abb.zm_memo2_amt02_3=rs.getDouble("zm_memo2_amt02_3");abb.setKeyValue("ZM_MEMO2_AMT02_3",""+abb.getZm_memo2_amt02_3());
abb.du_pmt_bill_0=rs.getDouble("du_pmt_bill_0");abb.setKeyValue("DU_PMT_BILL_0",""+abb.getDu_pmt_bill_0());
abb.du_pmt_bill_1=rs.getDouble("du_pmt_bill_1");abb.setKeyValue("DU_PMT_BILL_1",""+abb.getDu_pmt_bill_1());
abb.pre_pay_amt=rs.getDouble("pre_pay_amt");abb.setKeyValue("PRE_PAY_AMT",""+abb.getPre_pay_amt());
abb.tot_penalty_pay_am=rs.getDouble("tot_penalty_pay_am");abb.setKeyValue("TOT_PENALTY_PAY_AM",""+abb.getTot_penalty_pay_am());
abb.cumulative_payout_amt=rs.getDouble("cumulative_payout_amt");abb.setKeyValue("CUMULATIVE_PAYOUT_AMT",""+abb.getCumulative_payout_amt());
abb.progressive_addt_a=rs.getDouble("progressive_addt_a");abb.setKeyValue("PROGRESSIVE_ADDT_A",""+abb.getProgressive_addt_a());
abb.gainpct=rs.getDouble("gainpct");abb.setKeyValue("GAINPCT",""+abb.getGainpct());
abb.progressive_intv=rs.getInt("progressive_intv");abb.setKeyValue("PROGRESSIVE_INTV",""+abb.getProgressive_intv());
list.add(abb);
abb.operate_mode = "edit";
}public String getLn_acct_no() { if ( this.ln_acct_no == null ) return ""; return this.ln_acct_no;}
public String getOds_src_dt() { if ( this.ods_src_dt == null ) return ""; return this.ods_src_dt;}
public String getCust_no() { if ( this.cust_no == null ) return ""; return this.cust_no;}
public String getCust_open_dt() { if ( this.cust_open_dt == null ) return ""; return this.cust_open_dt;}
public String getExpiring_dt() { if ( this.expiring_dt == null ) return ""; return this.expiring_dt;}
public String getPoff_date() { if ( this.poff_date == null ) return ""; return this.poff_date;}
public String getLastchgtime() { if ( this.lastchgtime == null ) return ""; return this.lastchgtime;}
public String getAcct_open_date() { if ( this.acct_open_date == null ) return ""; return this.acct_open_date;}
public String getAfinestartdate() { if ( this.afinestartdate == null ) return ""; return this.afinestartdate;}
public String getRt_frst_due_date() { if ( this.rt_frst_due_date == null ) return ""; return this.rt_frst_due_date;}
public String getAccounting_org() { if ( this.accounting_org == null ) return ""; return this.accounting_org;}
public String getBankid() { if ( this.bankid == null ) return ""; return this.bankid;}
public String getOperid() { if ( this.operid == null ) return ""; return this.operid;}
public String getDutyid() { if ( this.dutyid == null ) return ""; return this.dutyid;}
public String getLn_prod_cod() { if ( this.ln_prod_cod == null ) return ""; return this.ln_prod_cod;}
public String getLoanclass() { if ( this.loanclass == null ) return ""; return this.loanclass;}
public String getLn_typ() { if ( this.ln_typ == null ) return ""; return this.ln_typ;}
public String getNor_subject() { if ( this.nor_subject == null ) return ""; return this.nor_subject;}
public String getDue_subject() { if ( this.due_subject == null ) return ""; return this.due_subject;}
public String getNonaccrued_subject() { if ( this.nonaccrued_subject == null ) return ""; return this.nonaccrued_subject;}
public String getReceivable_intr_subject() { if ( this.receivable_intr_subject == null ) return ""; return this.receivable_intr_subject;}
public String getDunning_intr_subject() { if ( this.dunning_intr_subject == null ) return ""; return this.dunning_intr_subject;}
public String getApcl_baddebts_sub() { if ( this.apcl_baddebts_sub == null ) return ""; return this.apcl_baddebts_sub;}
public String getApcl_badint_sub() { if ( this.apcl_badint_sub == null ) return ""; return this.apcl_badint_sub;}
public String getRt_term_freq() { if ( this.rt_term_freq == null ) return ""; return this.rt_term_freq;}
public int getRt_term_incr() { return this.rt_term_incr;}
public String getGuaranty_type() { if ( this.guaranty_type == null ) return ""; return this.guaranty_type;}
public String getCredit_limit_num() { if ( this.credit_limit_num == null ) return ""; return this.credit_limit_num;}
public String getSubsflag() { if ( this.subsflag == null ) return ""; return this.subsflag;}
public String getPay_type() { if ( this.pay_type == null ) return ""; return this.pay_type;}
public int getTurngraceday() { return this.turngraceday;}
public String getHighrisktype() { if ( this.highrisktype == null ) return ""; return this.highrisktype;}
public String getRiskflag() { if ( this.riskflag == null ) return ""; return this.riskflag;}
public String getAcct_stat() { if ( this.acct_stat == null ) return ""; return this.acct_stat;}
public String getCurr_cd() { if ( this.curr_cd == null ) return ""; return this.curr_cd;}
public double getRt_orig_loan_amt() { return this.rt_orig_loan_amt;}
public double getAmt() { return this.amt;}
public double getLn_bal() { return this.ln_bal;}
public double getBal_normal_prin() { return this.bal_normal_prin;}
public double getAubal() { return this.aubal;}
public double getBal_of_past_due_pr() { return this.bal_of_past_due_pr;}
public double getBal_dq_prin() { return this.bal_dq_prin;}
public String getCtrt_no() { if ( this.ctrt_no == null ) return ""; return this.ctrt_no;}
public double getBal_of_out_int() { return this.bal_of_out_int;}
public double getAinte() { return this.ainte;}
public double getBinte() { return this.binte;}
public double getRcapi() { return this.rcapi;}
public double getInt_income() { return this.int_income;}
public double getAfoul() { return this.afoul;}
public double getAc_amt_pd_itd() { return this.ac_amt_pd_itd;}
public double getTot_pd_brk_fee() { return this.tot_pd_brk_fee;}
public double getAsafine2() { return this.asafine2;}
public double getAsbfine2() { return this.asbfine2;}
public double getAsafine1() { return this.asafine1;}
public double getInt_rec_ali() { return this.int_rec_ali;}
public String getRatecode() { if ( this.ratecode == null ) return ""; return this.ratecode;}
public double getFloat_rate() { return this.float_rate;}
public String getRateact() { if ( this.rateact == null ) return ""; return this.rateact;}
public double getRatecalevalue() { return this.ratecalevalue;}
public String getLn_intr_adj_sty() { if ( this.ln_intr_adj_sty == null ) return ""; return this.ln_intr_adj_sty;}
public double getLn_rate() { return this.ln_rate;}
public double getCapifineratefloat() { return this.capifineratefloat;}
public double getIntefineratefloat() { return this.intefineratefloat;}
public double getFinerate() { return this.finerate;}
public double getCapifinerate() { return this.capifinerate;}
public String getZm_pkg_loan_nbr() { if ( this.zm_pkg_loan_nbr == null ) return ""; return this.zm_pkg_loan_nbr;}
public int getBl_lead_days() { return this.bl_lead_days;}
public double getAc_accr_mtd() { return this.ac_accr_mtd;}
public int getCurr_pmt_num() { return this.curr_pmt_num;}
public int getRt_actl_pmts_rem() { return this.rt_actl_pmts_rem;}
public double getFbal() { return this.fbal;}
public double getLn_hxlx() { return this.ln_hxlx;}
public double getRt_tot_coff_amt() { return this.rt_tot_coff_amt;}
public double getZm_memo2_amt02_2() { return this.zm_memo2_amt02_2;}
public double getZm_memo2_amt02_3() { return this.zm_memo2_amt02_3;}
public double getDu_pmt_bill_0() { return this.du_pmt_bill_0;}
public double getDu_pmt_bill_1() { return this.du_pmt_bill_1;}
public double getPre_pay_amt() { return this.pre_pay_amt;}
public double getTot_penalty_pay_am() { return this.tot_penalty_pay_am;}
public double getCumulative_payout_amt() { return this.cumulative_payout_amt;}
public double getProgressive_addt_a() { return this.progressive_addt_a;}
public double getGainpct() { return this.gainpct;}
public int getProgressive_intv() { return this.progressive_intv;}
public void setLn_acct_no(String ln_acct_no) { sqlMaker.setField("ln_acct_no",ln_acct_no,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLn_acct_no().equals(ln_acct_no)) cf.add("ln_acct_no",this.ln_acct_no,ln_acct_no); } this.ln_acct_no=ln_acct_no;}
public void setOds_src_dt(String ods_src_dt) { sqlMaker.setField("ods_src_dt",ods_src_dt,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getOds_src_dt().equals(ods_src_dt)) cf.add("ods_src_dt",this.ods_src_dt,ods_src_dt); } this.ods_src_dt=ods_src_dt;}
public void setCust_no(String cust_no) { sqlMaker.setField("cust_no",cust_no,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCust_no().equals(cust_no)) cf.add("cust_no",this.cust_no,cust_no); } this.cust_no=cust_no;}
public void setCust_open_dt(String cust_open_dt) { sqlMaker.setField("cust_open_dt",cust_open_dt,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCust_open_dt().equals(cust_open_dt)) cf.add("cust_open_dt",this.cust_open_dt,cust_open_dt); } this.cust_open_dt=cust_open_dt;}
public void setExpiring_dt(String expiring_dt) { sqlMaker.setField("expiring_dt",expiring_dt,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getExpiring_dt().equals(expiring_dt)) cf.add("expiring_dt",this.expiring_dt,expiring_dt); } this.expiring_dt=expiring_dt;}
public void setPoff_date(String poff_date) { sqlMaker.setField("poff_date",poff_date,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getPoff_date().equals(poff_date)) cf.add("poff_date",this.poff_date,poff_date); } this.poff_date=poff_date;}
public void setLastchgtime(String lastchgtime) { sqlMaker.setField("lastchgtime",lastchgtime,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLastchgtime().equals(lastchgtime)) cf.add("lastchgtime",this.lastchgtime,lastchgtime); } this.lastchgtime=lastchgtime;}
public void setAcct_open_date(String acct_open_date) { sqlMaker.setField("acct_open_date",acct_open_date,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAcct_open_date().equals(acct_open_date)) cf.add("acct_open_date",this.acct_open_date,acct_open_date); } this.acct_open_date=acct_open_date;}
public void setAfinestartdate(String afinestartdate) { sqlMaker.setField("afinestartdate",afinestartdate,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAfinestartdate().equals(afinestartdate)) cf.add("afinestartdate",this.afinestartdate,afinestartdate); } this.afinestartdate=afinestartdate;}
public void setRt_frst_due_date(String rt_frst_due_date) { sqlMaker.setField("rt_frst_due_date",rt_frst_due_date,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRt_frst_due_date().equals(rt_frst_due_date)) cf.add("rt_frst_due_date",this.rt_frst_due_date,rt_frst_due_date); } this.rt_frst_due_date=rt_frst_due_date;}
public void setAccounting_org(String accounting_org) { sqlMaker.setField("accounting_org",accounting_org,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAccounting_org().equals(accounting_org)) cf.add("accounting_org",this.accounting_org,accounting_org); } this.accounting_org=accounting_org;}
public void setBankid(String bankid) { sqlMaker.setField("bankid",bankid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getBankid().equals(bankid)) cf.add("bankid",this.bankid,bankid); } this.bankid=bankid;}
public void setOperid(String operid) { sqlMaker.setField("operid",operid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getOperid().equals(operid)) cf.add("operid",this.operid,operid); } this.operid=operid;}
public void setDutyid(String dutyid) { sqlMaker.setField("dutyid",dutyid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getDutyid().equals(dutyid)) cf.add("dutyid",this.dutyid,dutyid); } this.dutyid=dutyid;}
public void setLn_prod_cod(String ln_prod_cod) { sqlMaker.setField("ln_prod_cod",ln_prod_cod,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLn_prod_cod().equals(ln_prod_cod)) cf.add("ln_prod_cod",this.ln_prod_cod,ln_prod_cod); } this.ln_prod_cod=ln_prod_cod;}
public void setLoanclass(String loanclass) { sqlMaker.setField("loanclass",loanclass,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLoanclass().equals(loanclass)) cf.add("loanclass",this.loanclass,loanclass); } this.loanclass=loanclass;}
public void setLn_typ(String ln_typ) { sqlMaker.setField("ln_typ",ln_typ,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLn_typ().equals(ln_typ)) cf.add("ln_typ",this.ln_typ,ln_typ); } this.ln_typ=ln_typ;}
public void setNor_subject(String nor_subject) { sqlMaker.setField("nor_subject",nor_subject,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getNor_subject().equals(nor_subject)) cf.add("nor_subject",this.nor_subject,nor_subject); } this.nor_subject=nor_subject;}
public void setDue_subject(String due_subject) { sqlMaker.setField("due_subject",due_subject,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getDue_subject().equals(due_subject)) cf.add("due_subject",this.due_subject,due_subject); } this.due_subject=due_subject;}
public void setNonaccrued_subject(String nonaccrued_subject) { sqlMaker.setField("nonaccrued_subject",nonaccrued_subject,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getNonaccrued_subject().equals(nonaccrued_subject)) cf.add("nonaccrued_subject",this.nonaccrued_subject,nonaccrued_subject); } this.nonaccrued_subject=nonaccrued_subject;}
public void setReceivable_intr_subject(String receivable_intr_subject) { sqlMaker.setField("receivable_intr_subject",receivable_intr_subject,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getReceivable_intr_subject().equals(receivable_intr_subject)) cf.add("receivable_intr_subject",this.receivable_intr_subject,receivable_intr_subject); } this.receivable_intr_subject=receivable_intr_subject;}
public void setDunning_intr_subject(String dunning_intr_subject) { sqlMaker.setField("dunning_intr_subject",dunning_intr_subject,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getDunning_intr_subject().equals(dunning_intr_subject)) cf.add("dunning_intr_subject",this.dunning_intr_subject,dunning_intr_subject); } this.dunning_intr_subject=dunning_intr_subject;}
public void setApcl_baddebts_sub(String apcl_baddebts_sub) { sqlMaker.setField("apcl_baddebts_sub",apcl_baddebts_sub,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getApcl_baddebts_sub().equals(apcl_baddebts_sub)) cf.add("apcl_baddebts_sub",this.apcl_baddebts_sub,apcl_baddebts_sub); } this.apcl_baddebts_sub=apcl_baddebts_sub;}
public void setApcl_badint_sub(String apcl_badint_sub) { sqlMaker.setField("apcl_badint_sub",apcl_badint_sub,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getApcl_badint_sub().equals(apcl_badint_sub)) cf.add("apcl_badint_sub",this.apcl_badint_sub,apcl_badint_sub); } this.apcl_badint_sub=apcl_badint_sub;}
public void setRt_term_freq(String rt_term_freq) { sqlMaker.setField("rt_term_freq",rt_term_freq,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRt_term_freq().equals(rt_term_freq)) cf.add("rt_term_freq",this.rt_term_freq,rt_term_freq); } this.rt_term_freq=rt_term_freq;}
public void setRt_term_incr(int rt_term_incr) { sqlMaker.setField("rt_term_incr",""+rt_term_incr,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRt_term_incr()!=rt_term_incr) cf.add("rt_term_incr",this.rt_term_incr+"",rt_term_incr+""); } this.rt_term_incr=rt_term_incr;}
public void setGuaranty_type(String guaranty_type) { sqlMaker.setField("guaranty_type",guaranty_type,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getGuaranty_type().equals(guaranty_type)) cf.add("guaranty_type",this.guaranty_type,guaranty_type); } this.guaranty_type=guaranty_type;}
public void setCredit_limit_num(String credit_limit_num) { sqlMaker.setField("credit_limit_num",credit_limit_num,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCredit_limit_num().equals(credit_limit_num)) cf.add("credit_limit_num",this.credit_limit_num,credit_limit_num); } this.credit_limit_num=credit_limit_num;}
public void setSubsflag(String subsflag) { sqlMaker.setField("subsflag",subsflag,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSubsflag().equals(subsflag)) cf.add("subsflag",this.subsflag,subsflag); } this.subsflag=subsflag;}
public void setPay_type(String pay_type) { sqlMaker.setField("pay_type",pay_type,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getPay_type().equals(pay_type)) cf.add("pay_type",this.pay_type,pay_type); } this.pay_type=pay_type;}
public void setTurngraceday(int turngraceday) { sqlMaker.setField("turngraceday",""+turngraceday,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getTurngraceday()!=turngraceday) cf.add("turngraceday",this.turngraceday+"",turngraceday+""); } this.turngraceday=turngraceday;}
public void setHighrisktype(String highrisktype) { sqlMaker.setField("highrisktype",highrisktype,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getHighrisktype().equals(highrisktype)) cf.add("highrisktype",this.highrisktype,highrisktype); } this.highrisktype=highrisktype;}
public void setRiskflag(String riskflag) { sqlMaker.setField("riskflag",riskflag,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRiskflag().equals(riskflag)) cf.add("riskflag",this.riskflag,riskflag); } this.riskflag=riskflag;}
public void setAcct_stat(String acct_stat) { sqlMaker.setField("acct_stat",acct_stat,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAcct_stat().equals(acct_stat)) cf.add("acct_stat",this.acct_stat,acct_stat); } this.acct_stat=acct_stat;}
public void setCurr_cd(String curr_cd) { sqlMaker.setField("curr_cd",curr_cd,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCurr_cd().equals(curr_cd)) cf.add("curr_cd",this.curr_cd,curr_cd); } this.curr_cd=curr_cd;}
public void setRt_orig_loan_amt(double rt_orig_loan_amt) { sqlMaker.setField("rt_orig_loan_amt",""+rt_orig_loan_amt,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRt_orig_loan_amt()!=rt_orig_loan_amt) cf.add("rt_orig_loan_amt",this.rt_orig_loan_amt+"",rt_orig_loan_amt+""); } this.rt_orig_loan_amt=rt_orig_loan_amt;}
public void setAmt(double amt) { sqlMaker.setField("amt",""+amt,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getAmt()!=amt) cf.add("amt",this.amt+"",amt+""); } this.amt=amt;}
public void setLn_bal(double ln_bal) { sqlMaker.setField("ln_bal",""+ln_bal,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getLn_bal()!=ln_bal) cf.add("ln_bal",this.ln_bal+"",ln_bal+""); } this.ln_bal=ln_bal;}
public void setBal_normal_prin(double bal_normal_prin) { sqlMaker.setField("bal_normal_prin",""+bal_normal_prin,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getBal_normal_prin()!=bal_normal_prin) cf.add("bal_normal_prin",this.bal_normal_prin+"",bal_normal_prin+""); } this.bal_normal_prin=bal_normal_prin;}
public void setAubal(double aubal) { sqlMaker.setField("aubal",""+aubal,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getAubal()!=aubal) cf.add("aubal",this.aubal+"",aubal+""); } this.aubal=aubal;}
public void setBal_of_past_due_pr(double bal_of_past_due_pr) { sqlMaker.setField("bal_of_past_due_pr",""+bal_of_past_due_pr,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getBal_of_past_due_pr()!=bal_of_past_due_pr) cf.add("bal_of_past_due_pr",this.bal_of_past_due_pr+"",bal_of_past_due_pr+""); } this.bal_of_past_due_pr=bal_of_past_due_pr;}
public void setBal_dq_prin(double bal_dq_prin) { sqlMaker.setField("bal_dq_prin",""+bal_dq_prin,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getBal_dq_prin()!=bal_dq_prin) cf.add("bal_dq_prin",this.bal_dq_prin+"",bal_dq_prin+""); } this.bal_dq_prin=bal_dq_prin;}
public void setCtrt_no(String ctrt_no) { sqlMaker.setField("ctrt_no",ctrt_no,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCtrt_no().equals(ctrt_no)) cf.add("ctrt_no",this.ctrt_no,ctrt_no); } this.ctrt_no=ctrt_no;}
public void setBal_of_out_int(double bal_of_out_int) { sqlMaker.setField("bal_of_out_int",""+bal_of_out_int,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getBal_of_out_int()!=bal_of_out_int) cf.add("bal_of_out_int",this.bal_of_out_int+"",bal_of_out_int+""); } this.bal_of_out_int=bal_of_out_int;}
public void setAinte(double ainte) { sqlMaker.setField("ainte",""+ainte,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getAinte()!=ainte) cf.add("ainte",this.ainte+"",ainte+""); } this.ainte=ainte;}
public void setBinte(double binte) { sqlMaker.setField("binte",""+binte,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getBinte()!=binte) cf.add("binte",this.binte+"",binte+""); } this.binte=binte;}
public void setRcapi(double rcapi) { sqlMaker.setField("rcapi",""+rcapi,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRcapi()!=rcapi) cf.add("rcapi",this.rcapi+"",rcapi+""); } this.rcapi=rcapi;}
public void setInt_income(double int_income) { sqlMaker.setField("int_income",""+int_income,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getInt_income()!=int_income) cf.add("int_income",this.int_income+"",int_income+""); } this.int_income=int_income;}
public void setAfoul(double afoul) { sqlMaker.setField("afoul",""+afoul,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getAfoul()!=afoul) cf.add("afoul",this.afoul+"",afoul+""); } this.afoul=afoul;}
public void setAc_amt_pd_itd(double ac_amt_pd_itd) { sqlMaker.setField("ac_amt_pd_itd",""+ac_amt_pd_itd,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getAc_amt_pd_itd()!=ac_amt_pd_itd) cf.add("ac_amt_pd_itd",this.ac_amt_pd_itd+"",ac_amt_pd_itd+""); } this.ac_amt_pd_itd=ac_amt_pd_itd;}
public void setTot_pd_brk_fee(double tot_pd_brk_fee) { sqlMaker.setField("tot_pd_brk_fee",""+tot_pd_brk_fee,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getTot_pd_brk_fee()!=tot_pd_brk_fee) cf.add("tot_pd_brk_fee",this.tot_pd_brk_fee+"",tot_pd_brk_fee+""); } this.tot_pd_brk_fee=tot_pd_brk_fee;}
public void setAsafine2(double asafine2) { sqlMaker.setField("asafine2",""+asafine2,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getAsafine2()!=asafine2) cf.add("asafine2",this.asafine2+"",asafine2+""); } this.asafine2=asafine2;}
public void setAsbfine2(double asbfine2) { sqlMaker.setField("asbfine2",""+asbfine2,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getAsbfine2()!=asbfine2) cf.add("asbfine2",this.asbfine2+"",asbfine2+""); } this.asbfine2=asbfine2;}
public void setAsafine1(double asafine1) { sqlMaker.setField("asafine1",""+asafine1,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getAsafine1()!=asafine1) cf.add("asafine1",this.asafine1+"",asafine1+""); } this.asafine1=asafine1;}
public void setInt_rec_ali(double int_rec_ali) { sqlMaker.setField("int_rec_ali",""+int_rec_ali,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getInt_rec_ali()!=int_rec_ali) cf.add("int_rec_ali",this.int_rec_ali+"",int_rec_ali+""); } this.int_rec_ali=int_rec_ali;}
public void setRatecode(String ratecode) { sqlMaker.setField("ratecode",ratecode,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRatecode().equals(ratecode)) cf.add("ratecode",this.ratecode,ratecode); } this.ratecode=ratecode;}
public void setFloat_rate(double float_rate) { sqlMaker.setField("float_rate",""+float_rate,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getFloat_rate()!=float_rate) cf.add("float_rate",this.float_rate+"",float_rate+""); } this.float_rate=float_rate;}
public void setRateact(String rateact) { sqlMaker.setField("rateact",rateact,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRateact().equals(rateact)) cf.add("rateact",this.rateact,rateact); } this.rateact=rateact;}
public void setRatecalevalue(double ratecalevalue) { sqlMaker.setField("ratecalevalue",""+ratecalevalue,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRatecalevalue()!=ratecalevalue) cf.add("ratecalevalue",this.ratecalevalue+"",ratecalevalue+""); } this.ratecalevalue=ratecalevalue;}
public void setLn_intr_adj_sty(String ln_intr_adj_sty) { sqlMaker.setField("ln_intr_adj_sty",ln_intr_adj_sty,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLn_intr_adj_sty().equals(ln_intr_adj_sty)) cf.add("ln_intr_adj_sty",this.ln_intr_adj_sty,ln_intr_adj_sty); } this.ln_intr_adj_sty=ln_intr_adj_sty;}
public void setLn_rate(double ln_rate) { sqlMaker.setField("ln_rate",""+ln_rate,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getLn_rate()!=ln_rate) cf.add("ln_rate",this.ln_rate+"",ln_rate+""); } this.ln_rate=ln_rate;}
public void setCapifineratefloat(double capifineratefloat) { sqlMaker.setField("capifineratefloat",""+capifineratefloat,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getCapifineratefloat()!=capifineratefloat) cf.add("capifineratefloat",this.capifineratefloat+"",capifineratefloat+""); } this.capifineratefloat=capifineratefloat;}
public void setIntefineratefloat(double intefineratefloat) { sqlMaker.setField("intefineratefloat",""+intefineratefloat,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getIntefineratefloat()!=intefineratefloat) cf.add("intefineratefloat",this.intefineratefloat+"",intefineratefloat+""); } this.intefineratefloat=intefineratefloat;}
public void setFinerate(double finerate) { sqlMaker.setField("finerate",""+finerate,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getFinerate()!=finerate) cf.add("finerate",this.finerate+"",finerate+""); } this.finerate=finerate;}
public void setCapifinerate(double capifinerate) { sqlMaker.setField("capifinerate",""+capifinerate,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getCapifinerate()!=capifinerate) cf.add("capifinerate",this.capifinerate+"",capifinerate+""); } this.capifinerate=capifinerate;}
public void setZm_pkg_loan_nbr(String zm_pkg_loan_nbr) { sqlMaker.setField("zm_pkg_loan_nbr",zm_pkg_loan_nbr,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getZm_pkg_loan_nbr().equals(zm_pkg_loan_nbr)) cf.add("zm_pkg_loan_nbr",this.zm_pkg_loan_nbr,zm_pkg_loan_nbr); } this.zm_pkg_loan_nbr=zm_pkg_loan_nbr;}
public void setBl_lead_days(int bl_lead_days) { sqlMaker.setField("bl_lead_days",""+bl_lead_days,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getBl_lead_days()!=bl_lead_days) cf.add("bl_lead_days",this.bl_lead_days+"",bl_lead_days+""); } this.bl_lead_days=bl_lead_days;}
public void setAc_accr_mtd(double ac_accr_mtd) { sqlMaker.setField("ac_accr_mtd",""+ac_accr_mtd,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getAc_accr_mtd()!=ac_accr_mtd) cf.add("ac_accr_mtd",this.ac_accr_mtd+"",ac_accr_mtd+""); } this.ac_accr_mtd=ac_accr_mtd;}
public void setCurr_pmt_num(int curr_pmt_num) { sqlMaker.setField("curr_pmt_num",""+curr_pmt_num,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getCurr_pmt_num()!=curr_pmt_num) cf.add("curr_pmt_num",this.curr_pmt_num+"",curr_pmt_num+""); } this.curr_pmt_num=curr_pmt_num;}
public void setRt_actl_pmts_rem(int rt_actl_pmts_rem) { sqlMaker.setField("rt_actl_pmts_rem",""+rt_actl_pmts_rem,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRt_actl_pmts_rem()!=rt_actl_pmts_rem) cf.add("rt_actl_pmts_rem",this.rt_actl_pmts_rem+"",rt_actl_pmts_rem+""); } this.rt_actl_pmts_rem=rt_actl_pmts_rem;}
public void setFbal(double fbal) { sqlMaker.setField("fbal",""+fbal,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getFbal()!=fbal) cf.add("fbal",this.fbal+"",fbal+""); } this.fbal=fbal;}
public void setLn_hxlx(double ln_hxlx) { sqlMaker.setField("ln_hxlx",""+ln_hxlx,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getLn_hxlx()!=ln_hxlx) cf.add("ln_hxlx",this.ln_hxlx+"",ln_hxlx+""); } this.ln_hxlx=ln_hxlx;}
public void setRt_tot_coff_amt(double rt_tot_coff_amt) { sqlMaker.setField("rt_tot_coff_amt",""+rt_tot_coff_amt,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRt_tot_coff_amt()!=rt_tot_coff_amt) cf.add("rt_tot_coff_amt",this.rt_tot_coff_amt+"",rt_tot_coff_amt+""); } this.rt_tot_coff_amt=rt_tot_coff_amt;}
public void setZm_memo2_amt02_2(double zm_memo2_amt02_2) { sqlMaker.setField("zm_memo2_amt02_2",""+zm_memo2_amt02_2,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getZm_memo2_amt02_2()!=zm_memo2_amt02_2) cf.add("zm_memo2_amt02_2",this.zm_memo2_amt02_2+"",zm_memo2_amt02_2+""); } this.zm_memo2_amt02_2=zm_memo2_amt02_2;}
public void setZm_memo2_amt02_3(double zm_memo2_amt02_3) { sqlMaker.setField("zm_memo2_amt02_3",""+zm_memo2_amt02_3,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getZm_memo2_amt02_3()!=zm_memo2_amt02_3) cf.add("zm_memo2_amt02_3",this.zm_memo2_amt02_3+"",zm_memo2_amt02_3+""); } this.zm_memo2_amt02_3=zm_memo2_amt02_3;}
public void setDu_pmt_bill_0(double du_pmt_bill_0) { sqlMaker.setField("du_pmt_bill_0",""+du_pmt_bill_0,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getDu_pmt_bill_0()!=du_pmt_bill_0) cf.add("du_pmt_bill_0",this.du_pmt_bill_0+"",du_pmt_bill_0+""); } this.du_pmt_bill_0=du_pmt_bill_0;}
public void setDu_pmt_bill_1(double du_pmt_bill_1) { sqlMaker.setField("du_pmt_bill_1",""+du_pmt_bill_1,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getDu_pmt_bill_1()!=du_pmt_bill_1) cf.add("du_pmt_bill_1",this.du_pmt_bill_1+"",du_pmt_bill_1+""); } this.du_pmt_bill_1=du_pmt_bill_1;}
public void setPre_pay_amt(double pre_pay_amt) { sqlMaker.setField("pre_pay_amt",""+pre_pay_amt,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getPre_pay_amt()!=pre_pay_amt) cf.add("pre_pay_amt",this.pre_pay_amt+"",pre_pay_amt+""); } this.pre_pay_amt=pre_pay_amt;}
public void setTot_penalty_pay_am(double tot_penalty_pay_am) { sqlMaker.setField("tot_penalty_pay_am",""+tot_penalty_pay_am,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getTot_penalty_pay_am()!=tot_penalty_pay_am) cf.add("tot_penalty_pay_am",this.tot_penalty_pay_am+"",tot_penalty_pay_am+""); } this.tot_penalty_pay_am=tot_penalty_pay_am;}
public void setCumulative_payout_amt(double cumulative_payout_amt) { sqlMaker.setField("cumulative_payout_amt",""+cumulative_payout_amt,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getCumulative_payout_amt()!=cumulative_payout_amt) cf.add("cumulative_payout_amt",this.cumulative_payout_amt+"",cumulative_payout_amt+""); } this.cumulative_payout_amt=cumulative_payout_amt;}
public void setProgressive_addt_a(double progressive_addt_a) { sqlMaker.setField("progressive_addt_a",""+progressive_addt_a,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getProgressive_addt_a()!=progressive_addt_a) cf.add("progressive_addt_a",this.progressive_addt_a+"",progressive_addt_a+""); } this.progressive_addt_a=progressive_addt_a;}
public void setGainpct(double gainpct) { sqlMaker.setField("gainpct",""+gainpct,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getGainpct()!=gainpct) cf.add("gainpct",this.gainpct+"",gainpct+""); } this.gainpct=gainpct;}
public void setProgressive_intv(int progressive_intv) { sqlMaker.setField("progressive_intv",""+progressive_intv,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getProgressive_intv()!=progressive_intv) cf.add("progressive_intv",this.progressive_intv+"",progressive_intv+""); } this.progressive_intv=progressive_intv;}
public void init(int i,ActionRequest actionRequest) throws Exception { if ( actionRequest.getFieldValue(i,"ln_acct_no") !=null ) {this.setLn_acct_no(actionRequest.getFieldValue(i,"ln_acct_no"));}
if ( actionRequest.getFieldValue(i,"ods_src_dt") !=null ) {this.setOds_src_dt(actionRequest.getFieldValue(i,"ods_src_dt"));}
if ( actionRequest.getFieldValue(i,"cust_no") !=null ) {this.setCust_no(actionRequest.getFieldValue(i,"cust_no"));}
if ( actionRequest.getFieldValue(i,"cust_open_dt") !=null ) {this.setCust_open_dt(actionRequest.getFieldValue(i,"cust_open_dt"));}
if ( actionRequest.getFieldValue(i,"expiring_dt") !=null ) {this.setExpiring_dt(actionRequest.getFieldValue(i,"expiring_dt"));}
if ( actionRequest.getFieldValue(i,"poff_date") !=null ) {this.setPoff_date(actionRequest.getFieldValue(i,"poff_date"));}
if ( actionRequest.getFieldValue(i,"lastchgtime") !=null ) {this.setLastchgtime(actionRequest.getFieldValue(i,"lastchgtime"));}
if ( actionRequest.getFieldValue(i,"acct_open_date") !=null ) {this.setAcct_open_date(actionRequest.getFieldValue(i,"acct_open_date"));}
if ( actionRequest.getFieldValue(i,"afinestartdate") !=null ) {this.setAfinestartdate(actionRequest.getFieldValue(i,"afinestartdate"));}
if ( actionRequest.getFieldValue(i,"rt_frst_due_date") !=null ) {this.setRt_frst_due_date(actionRequest.getFieldValue(i,"rt_frst_due_date"));}
if ( actionRequest.getFieldValue(i,"accounting_org") !=null ) {this.setAccounting_org(actionRequest.getFieldValue(i,"accounting_org"));}
if ( actionRequest.getFieldValue(i,"bankid") !=null ) {this.setBankid(actionRequest.getFieldValue(i,"bankid"));}
if ( actionRequest.getFieldValue(i,"operid") !=null ) {this.setOperid(actionRequest.getFieldValue(i,"operid"));}
if ( actionRequest.getFieldValue(i,"dutyid") !=null ) {this.setDutyid(actionRequest.getFieldValue(i,"dutyid"));}
if ( actionRequest.getFieldValue(i,"ln_prod_cod") !=null ) {this.setLn_prod_cod(actionRequest.getFieldValue(i,"ln_prod_cod"));}
if ( actionRequest.getFieldValue(i,"loanclass") !=null ) {this.setLoanclass(actionRequest.getFieldValue(i,"loanclass"));}
if ( actionRequest.getFieldValue(i,"ln_typ") !=null ) {this.setLn_typ(actionRequest.getFieldValue(i,"ln_typ"));}
if ( actionRequest.getFieldValue(i,"nor_subject") !=null ) {this.setNor_subject(actionRequest.getFieldValue(i,"nor_subject"));}
if ( actionRequest.getFieldValue(i,"due_subject") !=null ) {this.setDue_subject(actionRequest.getFieldValue(i,"due_subject"));}
if ( actionRequest.getFieldValue(i,"nonaccrued_subject") !=null ) {this.setNonaccrued_subject(actionRequest.getFieldValue(i,"nonaccrued_subject"));}
if ( actionRequest.getFieldValue(i,"receivable_intr_subject") !=null ) {this.setReceivable_intr_subject(actionRequest.getFieldValue(i,"receivable_intr_subject"));}
if ( actionRequest.getFieldValue(i,"dunning_intr_subject") !=null ) {this.setDunning_intr_subject(actionRequest.getFieldValue(i,"dunning_intr_subject"));}
if ( actionRequest.getFieldValue(i,"apcl_baddebts_sub") !=null ) {this.setApcl_baddebts_sub(actionRequest.getFieldValue(i,"apcl_baddebts_sub"));}
if ( actionRequest.getFieldValue(i,"apcl_badint_sub") !=null ) {this.setApcl_badint_sub(actionRequest.getFieldValue(i,"apcl_badint_sub"));}
if ( actionRequest.getFieldValue(i,"rt_term_freq") !=null ) {this.setRt_term_freq(actionRequest.getFieldValue(i,"rt_term_freq"));}
if ( actionRequest.getFieldValue(i,"rt_term_incr") !=null && actionRequest.getFieldValue(i,"rt_term_incr").trim().length() > 0 ) {this.setRt_term_incr(Integer.parseInt(actionRequest.getFieldValue(i,"rt_term_incr")));}
if ( actionRequest.getFieldValue(i,"guaranty_type") !=null ) {this.setGuaranty_type(actionRequest.getFieldValue(i,"guaranty_type"));}
if ( actionRequest.getFieldValue(i,"credit_limit_num") !=null ) {this.setCredit_limit_num(actionRequest.getFieldValue(i,"credit_limit_num"));}
if ( actionRequest.getFieldValue(i,"subsflag") !=null ) {this.setSubsflag(actionRequest.getFieldValue(i,"subsflag"));}
if ( actionRequest.getFieldValue(i,"pay_type") !=null ) {this.setPay_type(actionRequest.getFieldValue(i,"pay_type"));}
if ( actionRequest.getFieldValue(i,"turngraceday") !=null && actionRequest.getFieldValue(i,"turngraceday").trim().length() > 0 ) {this.setTurngraceday(Integer.parseInt(actionRequest.getFieldValue(i,"turngraceday")));}
if ( actionRequest.getFieldValue(i,"highrisktype") !=null ) {this.setHighrisktype(actionRequest.getFieldValue(i,"highrisktype"));}
if ( actionRequest.getFieldValue(i,"riskflag") !=null ) {this.setRiskflag(actionRequest.getFieldValue(i,"riskflag"));}
if ( actionRequest.getFieldValue(i,"acct_stat") !=null ) {this.setAcct_stat(actionRequest.getFieldValue(i,"acct_stat"));}
if ( actionRequest.getFieldValue(i,"curr_cd") !=null ) {this.setCurr_cd(actionRequest.getFieldValue(i,"curr_cd"));}
if ( actionRequest.getFieldValue(i,"rt_orig_loan_amt") !=null && actionRequest.getFieldValue(i,"rt_orig_loan_amt").trim().length() > 0 ) {this.setRt_orig_loan_amt(Double.parseDouble(actionRequest.getFieldValue(i,"rt_orig_loan_amt")));}
if ( actionRequest.getFieldValue(i,"amt") !=null && actionRequest.getFieldValue(i,"amt").trim().length() > 0 ) {this.setAmt(Double.parseDouble(actionRequest.getFieldValue(i,"amt")));}
if ( actionRequest.getFieldValue(i,"ln_bal") !=null && actionRequest.getFieldValue(i,"ln_bal").trim().length() > 0 ) {this.setLn_bal(Double.parseDouble(actionRequest.getFieldValue(i,"ln_bal")));}
if ( actionRequest.getFieldValue(i,"bal_normal_prin") !=null && actionRequest.getFieldValue(i,"bal_normal_prin").trim().length() > 0 ) {this.setBal_normal_prin(Double.parseDouble(actionRequest.getFieldValue(i,"bal_normal_prin")));}
if ( actionRequest.getFieldValue(i,"aubal") !=null && actionRequest.getFieldValue(i,"aubal").trim().length() > 0 ) {this.setAubal(Double.parseDouble(actionRequest.getFieldValue(i,"aubal")));}
if ( actionRequest.getFieldValue(i,"bal_of_past_due_pr") !=null && actionRequest.getFieldValue(i,"bal_of_past_due_pr").trim().length() > 0 ) {this.setBal_of_past_due_pr(Double.parseDouble(actionRequest.getFieldValue(i,"bal_of_past_due_pr")));}
if ( actionRequest.getFieldValue(i,"bal_dq_prin") !=null && actionRequest.getFieldValue(i,"bal_dq_prin").trim().length() > 0 ) {this.setBal_dq_prin(Double.parseDouble(actionRequest.getFieldValue(i,"bal_dq_prin")));}
if ( actionRequest.getFieldValue(i,"ctrt_no") !=null ) {this.setCtrt_no(actionRequest.getFieldValue(i,"ctrt_no"));}
if ( actionRequest.getFieldValue(i,"bal_of_out_int") !=null && actionRequest.getFieldValue(i,"bal_of_out_int").trim().length() > 0 ) {this.setBal_of_out_int(Double.parseDouble(actionRequest.getFieldValue(i,"bal_of_out_int")));}
if ( actionRequest.getFieldValue(i,"ainte") !=null && actionRequest.getFieldValue(i,"ainte").trim().length() > 0 ) {this.setAinte(Double.parseDouble(actionRequest.getFieldValue(i,"ainte")));}
if ( actionRequest.getFieldValue(i,"binte") !=null && actionRequest.getFieldValue(i,"binte").trim().length() > 0 ) {this.setBinte(Double.parseDouble(actionRequest.getFieldValue(i,"binte")));}
if ( actionRequest.getFieldValue(i,"rcapi") !=null && actionRequest.getFieldValue(i,"rcapi").trim().length() > 0 ) {this.setRcapi(Double.parseDouble(actionRequest.getFieldValue(i,"rcapi")));}
if ( actionRequest.getFieldValue(i,"int_income") !=null && actionRequest.getFieldValue(i,"int_income").trim().length() > 0 ) {this.setInt_income(Double.parseDouble(actionRequest.getFieldValue(i,"int_income")));}
if ( actionRequest.getFieldValue(i,"afoul") !=null && actionRequest.getFieldValue(i,"afoul").trim().length() > 0 ) {this.setAfoul(Double.parseDouble(actionRequest.getFieldValue(i,"afoul")));}
if ( actionRequest.getFieldValue(i,"ac_amt_pd_itd") !=null && actionRequest.getFieldValue(i,"ac_amt_pd_itd").trim().length() > 0 ) {this.setAc_amt_pd_itd(Double.parseDouble(actionRequest.getFieldValue(i,"ac_amt_pd_itd")));}
if ( actionRequest.getFieldValue(i,"tot_pd_brk_fee") !=null && actionRequest.getFieldValue(i,"tot_pd_brk_fee").trim().length() > 0 ) {this.setTot_pd_brk_fee(Double.parseDouble(actionRequest.getFieldValue(i,"tot_pd_brk_fee")));}
if ( actionRequest.getFieldValue(i,"asafine2") !=null && actionRequest.getFieldValue(i,"asafine2").trim().length() > 0 ) {this.setAsafine2(Double.parseDouble(actionRequest.getFieldValue(i,"asafine2")));}
if ( actionRequest.getFieldValue(i,"asbfine2") !=null && actionRequest.getFieldValue(i,"asbfine2").trim().length() > 0 ) {this.setAsbfine2(Double.parseDouble(actionRequest.getFieldValue(i,"asbfine2")));}
if ( actionRequest.getFieldValue(i,"asafine1") !=null && actionRequest.getFieldValue(i,"asafine1").trim().length() > 0 ) {this.setAsafine1(Double.parseDouble(actionRequest.getFieldValue(i,"asafine1")));}
if ( actionRequest.getFieldValue(i,"int_rec_ali") !=null && actionRequest.getFieldValue(i,"int_rec_ali").trim().length() > 0 ) {this.setInt_rec_ali(Double.parseDouble(actionRequest.getFieldValue(i,"int_rec_ali")));}
if ( actionRequest.getFieldValue(i,"ratecode") !=null ) {this.setRatecode(actionRequest.getFieldValue(i,"ratecode"));}
if ( actionRequest.getFieldValue(i,"float_rate") !=null && actionRequest.getFieldValue(i,"float_rate").trim().length() > 0 ) {this.setFloat_rate(Double.parseDouble(actionRequest.getFieldValue(i,"float_rate")));}
if ( actionRequest.getFieldValue(i,"rateact") !=null ) {this.setRateact(actionRequest.getFieldValue(i,"rateact"));}
if ( actionRequest.getFieldValue(i,"ratecalevalue") !=null && actionRequest.getFieldValue(i,"ratecalevalue").trim().length() > 0 ) {this.setRatecalevalue(Double.parseDouble(actionRequest.getFieldValue(i,"ratecalevalue")));}
if ( actionRequest.getFieldValue(i,"ln_intr_adj_sty") !=null ) {this.setLn_intr_adj_sty(actionRequest.getFieldValue(i,"ln_intr_adj_sty"));}
if ( actionRequest.getFieldValue(i,"ln_rate") !=null && actionRequest.getFieldValue(i,"ln_rate").trim().length() > 0 ) {this.setLn_rate(Double.parseDouble(actionRequest.getFieldValue(i,"ln_rate")));}
if ( actionRequest.getFieldValue(i,"capifineratefloat") !=null && actionRequest.getFieldValue(i,"capifineratefloat").trim().length() > 0 ) {this.setCapifineratefloat(Double.parseDouble(actionRequest.getFieldValue(i,"capifineratefloat")));}
if ( actionRequest.getFieldValue(i,"intefineratefloat") !=null && actionRequest.getFieldValue(i,"intefineratefloat").trim().length() > 0 ) {this.setIntefineratefloat(Double.parseDouble(actionRequest.getFieldValue(i,"intefineratefloat")));}
if ( actionRequest.getFieldValue(i,"finerate") !=null && actionRequest.getFieldValue(i,"finerate").trim().length() > 0 ) {this.setFinerate(Double.parseDouble(actionRequest.getFieldValue(i,"finerate")));}
if ( actionRequest.getFieldValue(i,"capifinerate") !=null && actionRequest.getFieldValue(i,"capifinerate").trim().length() > 0 ) {this.setCapifinerate(Double.parseDouble(actionRequest.getFieldValue(i,"capifinerate")));}
if ( actionRequest.getFieldValue(i,"zm_pkg_loan_nbr") !=null ) {this.setZm_pkg_loan_nbr(actionRequest.getFieldValue(i,"zm_pkg_loan_nbr"));}
if ( actionRequest.getFieldValue(i,"bl_lead_days") !=null && actionRequest.getFieldValue(i,"bl_lead_days").trim().length() > 0 ) {this.setBl_lead_days(Integer.parseInt(actionRequest.getFieldValue(i,"bl_lead_days")));}
if ( actionRequest.getFieldValue(i,"ac_accr_mtd") !=null && actionRequest.getFieldValue(i,"ac_accr_mtd").trim().length() > 0 ) {this.setAc_accr_mtd(Double.parseDouble(actionRequest.getFieldValue(i,"ac_accr_mtd")));}
if ( actionRequest.getFieldValue(i,"curr_pmt_num") !=null && actionRequest.getFieldValue(i,"curr_pmt_num").trim().length() > 0 ) {this.setCurr_pmt_num(Integer.parseInt(actionRequest.getFieldValue(i,"curr_pmt_num")));}
if ( actionRequest.getFieldValue(i,"rt_actl_pmts_rem") !=null && actionRequest.getFieldValue(i,"rt_actl_pmts_rem").trim().length() > 0 ) {this.setRt_actl_pmts_rem(Integer.parseInt(actionRequest.getFieldValue(i,"rt_actl_pmts_rem")));}
if ( actionRequest.getFieldValue(i,"fbal") !=null && actionRequest.getFieldValue(i,"fbal").trim().length() > 0 ) {this.setFbal(Double.parseDouble(actionRequest.getFieldValue(i,"fbal")));}
if ( actionRequest.getFieldValue(i,"ln_hxlx") !=null && actionRequest.getFieldValue(i,"ln_hxlx").trim().length() > 0 ) {this.setLn_hxlx(Double.parseDouble(actionRequest.getFieldValue(i,"ln_hxlx")));}
if ( actionRequest.getFieldValue(i,"rt_tot_coff_amt") !=null && actionRequest.getFieldValue(i,"rt_tot_coff_amt").trim().length() > 0 ) {this.setRt_tot_coff_amt(Double.parseDouble(actionRequest.getFieldValue(i,"rt_tot_coff_amt")));}
if ( actionRequest.getFieldValue(i,"zm_memo2_amt02_2") !=null && actionRequest.getFieldValue(i,"zm_memo2_amt02_2").trim().length() > 0 ) {this.setZm_memo2_amt02_2(Double.parseDouble(actionRequest.getFieldValue(i,"zm_memo2_amt02_2")));}
if ( actionRequest.getFieldValue(i,"zm_memo2_amt02_3") !=null && actionRequest.getFieldValue(i,"zm_memo2_amt02_3").trim().length() > 0 ) {this.setZm_memo2_amt02_3(Double.parseDouble(actionRequest.getFieldValue(i,"zm_memo2_amt02_3")));}
if ( actionRequest.getFieldValue(i,"du_pmt_bill_0") !=null && actionRequest.getFieldValue(i,"du_pmt_bill_0").trim().length() > 0 ) {this.setDu_pmt_bill_0(Double.parseDouble(actionRequest.getFieldValue(i,"du_pmt_bill_0")));}
if ( actionRequest.getFieldValue(i,"du_pmt_bill_1") !=null && actionRequest.getFieldValue(i,"du_pmt_bill_1").trim().length() > 0 ) {this.setDu_pmt_bill_1(Double.parseDouble(actionRequest.getFieldValue(i,"du_pmt_bill_1")));}
if ( actionRequest.getFieldValue(i,"pre_pay_amt") !=null && actionRequest.getFieldValue(i,"pre_pay_amt").trim().length() > 0 ) {this.setPre_pay_amt(Double.parseDouble(actionRequest.getFieldValue(i,"pre_pay_amt")));}
if ( actionRequest.getFieldValue(i,"tot_penalty_pay_am") !=null && actionRequest.getFieldValue(i,"tot_penalty_pay_am").trim().length() > 0 ) {this.setTot_penalty_pay_am(Double.parseDouble(actionRequest.getFieldValue(i,"tot_penalty_pay_am")));}
if ( actionRequest.getFieldValue(i,"cumulative_payout_amt") !=null && actionRequest.getFieldValue(i,"cumulative_payout_amt").trim().length() > 0 ) {this.setCumulative_payout_amt(Double.parseDouble(actionRequest.getFieldValue(i,"cumulative_payout_amt")));}
if ( actionRequest.getFieldValue(i,"progressive_addt_a") !=null && actionRequest.getFieldValue(i,"progressive_addt_a").trim().length() > 0 ) {this.setProgressive_addt_a(Double.parseDouble(actionRequest.getFieldValue(i,"progressive_addt_a")));}
if ( actionRequest.getFieldValue(i,"gainpct") !=null && actionRequest.getFieldValue(i,"gainpct").trim().length() > 0 ) {this.setGainpct(Double.parseDouble(actionRequest.getFieldValue(i,"gainpct")));}
if ( actionRequest.getFieldValue(i,"progressive_intv") !=null && actionRequest.getFieldValue(i,"progressive_intv").trim().length() > 0 ) {this.setProgressive_intv(Integer.parseInt(actionRequest.getFieldValue(i,"progressive_intv")));}
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { LNODSBACCTLNS obj = (LNODSBACCTLNS)super.clone();obj.setLn_acct_no(obj.ln_acct_no);
obj.setOds_src_dt(obj.ods_src_dt);
obj.setCust_no(obj.cust_no);
obj.setCust_open_dt(obj.cust_open_dt);
obj.setExpiring_dt(obj.expiring_dt);
obj.setPoff_date(obj.poff_date);
obj.setLastchgtime(obj.lastchgtime);
obj.setAcct_open_date(obj.acct_open_date);
obj.setAfinestartdate(obj.afinestartdate);
obj.setRt_frst_due_date(obj.rt_frst_due_date);
obj.setAccounting_org(obj.accounting_org);
obj.setBankid(obj.bankid);
obj.setOperid(obj.operid);
obj.setDutyid(obj.dutyid);
obj.setLn_prod_cod(obj.ln_prod_cod);
obj.setLoanclass(obj.loanclass);
obj.setLn_typ(obj.ln_typ);
obj.setNor_subject(obj.nor_subject);
obj.setDue_subject(obj.due_subject);
obj.setNonaccrued_subject(obj.nonaccrued_subject);
obj.setReceivable_intr_subject(obj.receivable_intr_subject);
obj.setDunning_intr_subject(obj.dunning_intr_subject);
obj.setApcl_baddebts_sub(obj.apcl_baddebts_sub);
obj.setApcl_badint_sub(obj.apcl_badint_sub);
obj.setRt_term_freq(obj.rt_term_freq);
obj.setRt_term_incr(obj.rt_term_incr);
obj.setGuaranty_type(obj.guaranty_type);
obj.setCredit_limit_num(obj.credit_limit_num);
obj.setSubsflag(obj.subsflag);
obj.setPay_type(obj.pay_type);
obj.setTurngraceday(obj.turngraceday);
obj.setHighrisktype(obj.highrisktype);
obj.setRiskflag(obj.riskflag);
obj.setAcct_stat(obj.acct_stat);
obj.setCurr_cd(obj.curr_cd);
obj.setRt_orig_loan_amt(obj.rt_orig_loan_amt);
obj.setAmt(obj.amt);
obj.setLn_bal(obj.ln_bal);
obj.setBal_normal_prin(obj.bal_normal_prin);
obj.setAubal(obj.aubal);
obj.setBal_of_past_due_pr(obj.bal_of_past_due_pr);
obj.setBal_dq_prin(obj.bal_dq_prin);
obj.setCtrt_no(obj.ctrt_no);
obj.setBal_of_out_int(obj.bal_of_out_int);
obj.setAinte(obj.ainte);
obj.setBinte(obj.binte);
obj.setRcapi(obj.rcapi);
obj.setInt_income(obj.int_income);
obj.setAfoul(obj.afoul);
obj.setAc_amt_pd_itd(obj.ac_amt_pd_itd);
obj.setTot_pd_brk_fee(obj.tot_pd_brk_fee);
obj.setAsafine2(obj.asafine2);
obj.setAsbfine2(obj.asbfine2);
obj.setAsafine1(obj.asafine1);
obj.setInt_rec_ali(obj.int_rec_ali);
obj.setRatecode(obj.ratecode);
obj.setFloat_rate(obj.float_rate);
obj.setRateact(obj.rateact);
obj.setRatecalevalue(obj.ratecalevalue);
obj.setLn_intr_adj_sty(obj.ln_intr_adj_sty);
obj.setLn_rate(obj.ln_rate);
obj.setCapifineratefloat(obj.capifineratefloat);
obj.setIntefineratefloat(obj.intefineratefloat);
obj.setFinerate(obj.finerate);
obj.setCapifinerate(obj.capifinerate);
obj.setZm_pkg_loan_nbr(obj.zm_pkg_loan_nbr);
obj.setBl_lead_days(obj.bl_lead_days);
obj.setAc_accr_mtd(obj.ac_accr_mtd);
obj.setCurr_pmt_num(obj.curr_pmt_num);
obj.setRt_actl_pmts_rem(obj.rt_actl_pmts_rem);
obj.setFbal(obj.fbal);
obj.setLn_hxlx(obj.ln_hxlx);
obj.setRt_tot_coff_amt(obj.rt_tot_coff_amt);
obj.setZm_memo2_amt02_2(obj.zm_memo2_amt02_2);
obj.setZm_memo2_amt02_3(obj.zm_memo2_amt02_3);
obj.setDu_pmt_bill_0(obj.du_pmt_bill_0);
obj.setDu_pmt_bill_1(obj.du_pmt_bill_1);
obj.setPre_pay_amt(obj.pre_pay_amt);
obj.setTot_penalty_pay_am(obj.tot_penalty_pay_am);
obj.setCumulative_payout_amt(obj.cumulative_payout_amt);
obj.setProgressive_addt_a(obj.progressive_addt_a);
obj.setGainpct(obj.gainpct);
obj.setProgressive_intv(obj.progressive_intv);
return obj;}}