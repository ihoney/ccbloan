package com.ccb.dao;
import java.util.*;
import pub.platform.db.*;
import pub.platform.utils.*;
import pub.platform.db.AbstractBasicBean;
public class LNODSBACCTAMWKPL08 extends AbstractBasicBean implements Cloneable {
     public static List find(String sSqlWhere) {           return new LNODSBACCTAMWKPL08().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere) {           return new LNODSBACCTAMWKPL08().findAndLockByWhere(sSqlWhere);      }       public static LNODSBACCTAMWKPL08 findFirst(String sSqlWhere) {           return (LNODSBACCTAMWKPL08)new LNODSBACCTAMWKPL08().findFirstByWhere(sSqlWhere);      }       public static LNODSBACCTAMWKPL08 findFirstAndLock(String sSqlWhere) {           return (LNODSBACCTAMWKPL08)new LNODSBACCTAMWKPL08().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) {           return new LNODSBACCTAMWKPL08().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease) {           LNODSBACCTAMWKPL08 bean = new LNODSBACCTAMWKPL08();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) {           LNODSBACCTAMWKPL08 bean = new LNODSBACCTAMWKPL08();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static LNODSBACCTAMWKPL08 findFirst(String sSqlWhere,boolean isAutoRelease) {           LNODSBACCTAMWKPL08 bean = new LNODSBACCTAMWKPL08();           bean.setAutoRelease(isAutoRelease);           return (LNODSBACCTAMWKPL08)bean.findFirstByWhere(sSqlWhere);      }       public static LNODSBACCTAMWKPL08 findFirstAndLock(String sSqlWhere,boolean isAutoRelease) {           LNODSBACCTAMWKPL08 bean = new LNODSBACCTAMWKPL08();           bean.setAutoRelease(isAutoRelease);           return (LNODSBACCTAMWKPL08)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease) {           LNODSBACCTAMWKPL08 bean = new LNODSBACCTAMWKPL08();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      }      public static List findByRow(String sSqlWhere,int row) {           return new LNODSBACCTAMWKPL08().findByWhereByRow(sSqlWhere,row);      } String rt_ctl1;
String rtctl2;
String rt_ctl3;
String rtctl4;
String ln_acct_no;
String ods_src_dt;
String zm_notes_1;
String mi_set_acct_num;
String curr_cd;
String zm_desc_15_1;
String cust_name;
String rt_acct_prod;
String ins_type;
String insurance_num;
String acct_stat;
String coll_type_1_flag;
String coll_type_2_flag;
String guarantor_flag;
String per_credit_flag;
double is_cover_amt;
String insurance_company_name;
String is_agent_name;
String is_user_desc1;
String is_user_desc2;
String pay_type;
String mi_pay_acct_1;
String mi_pay_acct_2;
String mi_pay_acct_3;
String mi_pay_acct_4;
String mi_pay_acct_5;
String rt_proc_type;
String mi_auto_prin_flag;
String mi_auto_int_flag;
String cust_open_dt;
String expiring_dt;
int rt_num_pmts_made;
int curr_pmt_num;
int ln_totl_prd;
double rt_orig_loan_amt;
double cumulative_payout_amt;
int num_day_interval;
int prin_num_day_inter;
int int_num_day_interv;
double bl_flat_amt;
double tot_pay_amt;
int progressive_intv;
double progressive_addt_a;
String lst_progressive_da;
String entruster_fund_acc;
String entruster_sav_acct;
double bal_of_out_int;
double int_rec_acc;
String acct_open_date;
String rt_list_pmt_date;
String ac_start_date;
String acct_mark;
String cust_no;
String zipcode;
String customer_address;
String cont_tele;
String cf_bus_phone_data;
String auto_credit_acct;
String ln_intr_adj_sty;
double rt_loan_rate;
double ra_pct1;
double ac_rate;
int time_of_dq;
double bal_normal_prin;
double bal_of_past_due_pr;
double bal_dq_prin;
double bal_of_bad_prin;
double overbal;
double receivable_intr;
double dunning_intr;
double dq_of_brk_charge;
double dq_procedure_fee;
double ba_amt_pd_itd;
double pre_pay_amt;
double tot_penalty_pay_am;
double ac_amt_pd_itd;
double tot_pd_brk_fee;
double tot_pd_proce_fee;
double rt_tot_coff_amt;
double dq_alp_amt;
double col_ali_amt;
double past_due_alp;
double int_rec_ali;
String rt_oldst_due_date;
double sacapi31;
double sacapi61;
double sacapi91;
double pri_past_ov_180_da;
int num_of_time_dq;
String curr_mth_pay_statu;
int rt_num_due_seq;
double du_pmt_rem;
double ac_accr_bal;
String rt_sold_ind;
String rt_sold_cd;
double int_past_01_60_day;
double int_past_31_60_day;
double int_past_61_90_day;
double int_past_91_180_da;
double int_past_ov_180_da;
double zm_memo2_amt02_0;
double zm_memo2_amt02_1;
double du_pmt_bill_0;
double du_pmt_bill_1;
double ac_accr_mtd;
String cm_cmt_num;
String zm_pkg_loan_nbr;
String zm_pmt_seq_nbr;
double rt_orig_procd_amt;
String rt_term_freq;
int rt_term_incr;
int rt_actl_pmts_rem;
String rt_frst_due_date;
String poff_date;
double int_dis_rate;
String int_dis_end_dt;
String zm_aflc_code;
double zm_adj_penalty_int;
double zm_adj_penalty_pri;
String bd_nxt_due_date_0;
String bd_nxt_due_date_2;
int dq_grace_days;
double ac_accr_itd;
int dq_hist_day_ctr;
int dq_num_pmts_pdue;
String rt_user_grp3;
String rt_user_grp9;
double rt_user_amt1;
double rt_user_amt2;
String rt_sngl_balloon_cd;
int bl_lead_days;
String bd_meth;
String bd_bill_type;
String se_sale_num;
String rt_se_commit_date;
String rt_pool_cd;
String se_sale_date;
double zmepoffpctu;
double rtorigcmamt;
String action_flag;
String slsccd;
String cm_mult_adv_ind;
String zm_ful_par_pmt;
String cf_addr_num;
String sl_guar_agency_cd;
double ba_curr_cm_amt;
double available_amt;
String rt_date_lst_maint;
double tot_pri_payment_amt;
double zm_memo2_amt02_2;
double zm_memo2_amt02_3;
double ln_arfn_int;
double zm_memo2_amt02_4;
double zm_memo2_amt02_6;
double recooperinte;
double zm_memo2_amt02_21;
double rt_curr_due_amt;
String rt_coff_date;
String filler;
public static final String TABLENAME ="ln_odsb_acct_amwkpl08";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
public void addObject(List list,RecordSet rs) {
LNODSBACCTAMWKPL08 abb = new LNODSBACCTAMWKPL08();
abb.rt_ctl1=rs.getString("rt_ctl1");abb.setKeyValue("RT_CTL1",""+abb.getRt_ctl1());
abb.rtctl2=rs.getString("rtctl2");abb.setKeyValue("RTCTL2",""+abb.getRtctl2());
abb.rt_ctl3=rs.getString("rt_ctl3");abb.setKeyValue("RT_CTL3",""+abb.getRt_ctl3());
abb.rtctl4=rs.getString("rtctl4");abb.setKeyValue("RTCTL4",""+abb.getRtctl4());
abb.ln_acct_no=rs.getString("ln_acct_no");abb.setKeyValue("LN_ACCT_NO",""+abb.getLn_acct_no());
abb.ods_src_dt=rs.getString("ods_src_dt");abb.setKeyValue("ODS_SRC_DT",""+abb.getOds_src_dt());
abb.zm_notes_1=rs.getString("zm_notes_1");abb.setKeyValue("ZM_NOTES_1",""+abb.getZm_notes_1());
abb.mi_set_acct_num=rs.getString("mi_set_acct_num");abb.setKeyValue("MI_SET_ACCT_NUM",""+abb.getMi_set_acct_num());
abb.curr_cd=rs.getString("curr_cd");abb.setKeyValue("CURR_CD",""+abb.getCurr_cd());
abb.zm_desc_15_1=rs.getString("zm_desc_15_1");abb.setKeyValue("ZM_DESC_15_1",""+abb.getZm_desc_15_1());
abb.cust_name=rs.getString("cust_name");abb.setKeyValue("CUST_NAME",""+abb.getCust_name());
abb.rt_acct_prod=rs.getString("rt_acct_prod");abb.setKeyValue("RT_ACCT_PROD",""+abb.getRt_acct_prod());
abb.ins_type=rs.getString("ins_type");abb.setKeyValue("INS_TYPE",""+abb.getIns_type());
abb.insurance_num=rs.getString("insurance_num");abb.setKeyValue("INSURANCE_NUM",""+abb.getInsurance_num());
abb.acct_stat=rs.getString("acct_stat");abb.setKeyValue("ACCT_STAT",""+abb.getAcct_stat());
abb.coll_type_1_flag=rs.getString("coll_type_1_flag");abb.setKeyValue("COLL_TYPE_1_FLAG",""+abb.getColl_type_1_flag());
abb.coll_type_2_flag=rs.getString("coll_type_2_flag");abb.setKeyValue("COLL_TYPE_2_FLAG",""+abb.getColl_type_2_flag());
abb.guarantor_flag=rs.getString("guarantor_flag");abb.setKeyValue("GUARANTOR_FLAG",""+abb.getGuarantor_flag());
abb.per_credit_flag=rs.getString("per_credit_flag");abb.setKeyValue("PER_CREDIT_FLAG",""+abb.getPer_credit_flag());
abb.is_cover_amt=rs.getDouble("is_cover_amt");abb.setKeyValue("IS_COVER_AMT",""+abb.getIs_cover_amt());
abb.insurance_company_name=rs.getString("insurance_company_name");abb.setKeyValue("INSURANCE_COMPANY_NAME",""+abb.getInsurance_company_name());
abb.is_agent_name=rs.getString("is_agent_name");abb.setKeyValue("IS_AGENT_NAME",""+abb.getIs_agent_name());
abb.is_user_desc1=rs.getString("is_user_desc1");abb.setKeyValue("IS_USER_DESC1",""+abb.getIs_user_desc1());
abb.is_user_desc2=rs.getString("is_user_desc2");abb.setKeyValue("IS_USER_DESC2",""+abb.getIs_user_desc2());
abb.pay_type=rs.getString("pay_type");abb.setKeyValue("PAY_TYPE",""+abb.getPay_type());
abb.mi_pay_acct_1=rs.getString("mi_pay_acct_1");abb.setKeyValue("MI_PAY_ACCT_1",""+abb.getMi_pay_acct_1());
abb.mi_pay_acct_2=rs.getString("mi_pay_acct_2");abb.setKeyValue("MI_PAY_ACCT_2",""+abb.getMi_pay_acct_2());
abb.mi_pay_acct_3=rs.getString("mi_pay_acct_3");abb.setKeyValue("MI_PAY_ACCT_3",""+abb.getMi_pay_acct_3());
abb.mi_pay_acct_4=rs.getString("mi_pay_acct_4");abb.setKeyValue("MI_PAY_ACCT_4",""+abb.getMi_pay_acct_4());
abb.mi_pay_acct_5=rs.getString("mi_pay_acct_5");abb.setKeyValue("MI_PAY_ACCT_5",""+abb.getMi_pay_acct_5());
abb.rt_proc_type=rs.getString("rt_proc_type");abb.setKeyValue("RT_PROC_TYPE",""+abb.getRt_proc_type());
abb.mi_auto_prin_flag=rs.getString("mi_auto_prin_flag");abb.setKeyValue("MI_AUTO_PRIN_FLAG",""+abb.getMi_auto_prin_flag());
abb.mi_auto_int_flag=rs.getString("mi_auto_int_flag");abb.setKeyValue("MI_AUTO_INT_FLAG",""+abb.getMi_auto_int_flag());
abb.cust_open_dt=rs.getString("cust_open_dt");abb.setKeyValue("CUST_OPEN_DT",""+abb.getCust_open_dt());
abb.expiring_dt=rs.getString("expiring_dt");abb.setKeyValue("EXPIRING_DT",""+abb.getExpiring_dt());
abb.rt_num_pmts_made=rs.getInt("rt_num_pmts_made");abb.setKeyValue("RT_NUM_PMTS_MADE",""+abb.getRt_num_pmts_made());
abb.curr_pmt_num=rs.getInt("curr_pmt_num");abb.setKeyValue("CURR_PMT_NUM",""+abb.getCurr_pmt_num());
abb.ln_totl_prd=rs.getInt("ln_totl_prd");abb.setKeyValue("LN_TOTL_PRD",""+abb.getLn_totl_prd());
abb.rt_orig_loan_amt=rs.getDouble("rt_orig_loan_amt");abb.setKeyValue("RT_ORIG_LOAN_AMT",""+abb.getRt_orig_loan_amt());
abb.cumulative_payout_amt=rs.getDouble("cumulative_payout_amt");abb.setKeyValue("CUMULATIVE_PAYOUT_AMT",""+abb.getCumulative_payout_amt());
abb.num_day_interval=rs.getInt("num_day_interval");abb.setKeyValue("NUM_DAY_INTERVAL",""+abb.getNum_day_interval());
abb.prin_num_day_inter=rs.getInt("prin_num_day_inter");abb.setKeyValue("PRIN_NUM_DAY_INTER",""+abb.getPrin_num_day_inter());
abb.int_num_day_interv=rs.getInt("int_num_day_interv");abb.setKeyValue("INT_NUM_DAY_INTERV",""+abb.getInt_num_day_interv());
abb.bl_flat_amt=rs.getDouble("bl_flat_amt");abb.setKeyValue("BL_FLAT_AMT",""+abb.getBl_flat_amt());
abb.tot_pay_amt=rs.getDouble("tot_pay_amt");abb.setKeyValue("TOT_PAY_AMT",""+abb.getTot_pay_amt());
abb.progressive_intv=rs.getInt("progressive_intv");abb.setKeyValue("PROGRESSIVE_INTV",""+abb.getProgressive_intv());
abb.progressive_addt_a=rs.getDouble("progressive_addt_a");abb.setKeyValue("PROGRESSIVE_ADDT_A",""+abb.getProgressive_addt_a());
abb.lst_progressive_da=rs.getString("lst_progressive_da");abb.setKeyValue("LST_PROGRESSIVE_DA",""+abb.getLst_progressive_da());
abb.entruster_fund_acc=rs.getString("entruster_fund_acc");abb.setKeyValue("ENTRUSTER_FUND_ACC",""+abb.getEntruster_fund_acc());
abb.entruster_sav_acct=rs.getString("entruster_sav_acct");abb.setKeyValue("ENTRUSTER_SAV_ACCT",""+abb.getEntruster_sav_acct());
abb.bal_of_out_int=rs.getDouble("bal_of_out_int");abb.setKeyValue("BAL_OF_OUT_INT",""+abb.getBal_of_out_int());
abb.int_rec_acc=rs.getDouble("int_rec_acc");abb.setKeyValue("INT_REC_ACC",""+abb.getInt_rec_acc());
abb.acct_open_date=rs.getString("acct_open_date");abb.setKeyValue("ACCT_OPEN_DATE",""+abb.getAcct_open_date());
abb.rt_list_pmt_date=rs.getString("rt_list_pmt_date");abb.setKeyValue("RT_LIST_PMT_DATE",""+abb.getRt_list_pmt_date());
abb.ac_start_date=rs.getString("ac_start_date");abb.setKeyValue("AC_START_DATE",""+abb.getAc_start_date());
abb.acct_mark=rs.getString("acct_mark");abb.setKeyValue("ACCT_MARK",""+abb.getAcct_mark());
abb.cust_no=rs.getString("cust_no");abb.setKeyValue("CUST_NO",""+abb.getCust_no());
abb.zipcode=rs.getString("zipcode");abb.setKeyValue("ZIPCODE",""+abb.getZipcode());
abb.customer_address=rs.getString("customer_address");abb.setKeyValue("CUSTOMER_ADDRESS",""+abb.getCustomer_address());
abb.cont_tele=rs.getString("cont_tele");abb.setKeyValue("CONT_TELE",""+abb.getCont_tele());
abb.cf_bus_phone_data=rs.getString("cf_bus_phone_data");abb.setKeyValue("CF_BUS_PHONE_DATA",""+abb.getCf_bus_phone_data());
abb.auto_credit_acct=rs.getString("auto_credit_acct");abb.setKeyValue("AUTO_CREDIT_ACCT",""+abb.getAuto_credit_acct());
abb.ln_intr_adj_sty=rs.getString("ln_intr_adj_sty");abb.setKeyValue("LN_INTR_ADJ_STY",""+abb.getLn_intr_adj_sty());
abb.rt_loan_rate=rs.getDouble("rt_loan_rate");abb.setKeyValue("RT_LOAN_RATE",""+abb.getRt_loan_rate());
abb.ra_pct1=rs.getDouble("ra_pct1");abb.setKeyValue("RA_PCT1",""+abb.getRa_pct1());
abb.ac_rate=rs.getDouble("ac_rate");abb.setKeyValue("AC_RATE",""+abb.getAc_rate());
abb.time_of_dq=rs.getInt("time_of_dq");abb.setKeyValue("TIME_OF_DQ",""+abb.getTime_of_dq());
abb.bal_normal_prin=rs.getDouble("bal_normal_prin");abb.setKeyValue("BAL_NORMAL_PRIN",""+abb.getBal_normal_prin());
abb.bal_of_past_due_pr=rs.getDouble("bal_of_past_due_pr");abb.setKeyValue("BAL_OF_PAST_DUE_PR",""+abb.getBal_of_past_due_pr());
abb.bal_dq_prin=rs.getDouble("bal_dq_prin");abb.setKeyValue("BAL_DQ_PRIN",""+abb.getBal_dq_prin());
abb.bal_of_bad_prin=rs.getDouble("bal_of_bad_prin");abb.setKeyValue("BAL_OF_BAD_PRIN",""+abb.getBal_of_bad_prin());
abb.overbal=rs.getDouble("overbal");abb.setKeyValue("OVERBAL",""+abb.getOverbal());
abb.receivable_intr=rs.getDouble("receivable_intr");abb.setKeyValue("RECEIVABLE_INTR",""+abb.getReceivable_intr());
abb.dunning_intr=rs.getDouble("dunning_intr");abb.setKeyValue("DUNNING_INTR",""+abb.getDunning_intr());
abb.dq_of_brk_charge=rs.getDouble("dq_of_brk_charge");abb.setKeyValue("DQ_OF_BRK_CHARGE",""+abb.getDq_of_brk_charge());
abb.dq_procedure_fee=rs.getDouble("dq_procedure_fee");abb.setKeyValue("DQ_PROCEDURE_FEE",""+abb.getDq_procedure_fee());
abb.ba_amt_pd_itd=rs.getDouble("ba_amt_pd_itd");abb.setKeyValue("BA_AMT_PD_ITD",""+abb.getBa_amt_pd_itd());
abb.pre_pay_amt=rs.getDouble("pre_pay_amt");abb.setKeyValue("PRE_PAY_AMT",""+abb.getPre_pay_amt());
abb.tot_penalty_pay_am=rs.getDouble("tot_penalty_pay_am");abb.setKeyValue("TOT_PENALTY_PAY_AM",""+abb.getTot_penalty_pay_am());
abb.ac_amt_pd_itd=rs.getDouble("ac_amt_pd_itd");abb.setKeyValue("AC_AMT_PD_ITD",""+abb.getAc_amt_pd_itd());
abb.tot_pd_brk_fee=rs.getDouble("tot_pd_brk_fee");abb.setKeyValue("TOT_PD_BRK_FEE",""+abb.getTot_pd_brk_fee());
abb.tot_pd_proce_fee=rs.getDouble("tot_pd_proce_fee");abb.setKeyValue("TOT_PD_PROCE_FEE",""+abb.getTot_pd_proce_fee());
abb.rt_tot_coff_amt=rs.getDouble("rt_tot_coff_amt");abb.setKeyValue("RT_TOT_COFF_AMT",""+abb.getRt_tot_coff_amt());
abb.dq_alp_amt=rs.getDouble("dq_alp_amt");abb.setKeyValue("DQ_ALP_AMT",""+abb.getDq_alp_amt());
abb.col_ali_amt=rs.getDouble("col_ali_amt");abb.setKeyValue("COL_ALI_AMT",""+abb.getCol_ali_amt());
abb.past_due_alp=rs.getDouble("past_due_alp");abb.setKeyValue("PAST_DUE_ALP",""+abb.getPast_due_alp());
abb.int_rec_ali=rs.getDouble("int_rec_ali");abb.setKeyValue("INT_REC_ALI",""+abb.getInt_rec_ali());
abb.rt_oldst_due_date=rs.getString("rt_oldst_due_date");abb.setKeyValue("RT_OLDST_DUE_DATE",""+abb.getRt_oldst_due_date());
abb.sacapi31=rs.getDouble("sacapi31");abb.setKeyValue("SACAPI31",""+abb.getSacapi31());
abb.sacapi61=rs.getDouble("sacapi61");abb.setKeyValue("SACAPI61",""+abb.getSacapi61());
abb.sacapi91=rs.getDouble("sacapi91");abb.setKeyValue("SACAPI91",""+abb.getSacapi91());
abb.pri_past_ov_180_da=rs.getDouble("pri_past_ov_180_da");abb.setKeyValue("PRI_PAST_OV_180_DA",""+abb.getPri_past_ov_180_da());
abb.num_of_time_dq=rs.getInt("num_of_time_dq");abb.setKeyValue("NUM_OF_TIME_DQ",""+abb.getNum_of_time_dq());
abb.curr_mth_pay_statu=rs.getString("curr_mth_pay_statu");abb.setKeyValue("CURR_MTH_PAY_STATU",""+abb.getCurr_mth_pay_statu());
abb.rt_num_due_seq=rs.getInt("rt_num_due_seq");abb.setKeyValue("RT_NUM_DUE_SEQ",""+abb.getRt_num_due_seq());
abb.du_pmt_rem=rs.getDouble("du_pmt_rem");abb.setKeyValue("DU_PMT_REM",""+abb.getDu_pmt_rem());
abb.ac_accr_bal=rs.getDouble("ac_accr_bal");abb.setKeyValue("AC_ACCR_BAL",""+abb.getAc_accr_bal());
abb.rt_sold_ind=rs.getString("rt_sold_ind");abb.setKeyValue("RT_SOLD_IND",""+abb.getRt_sold_ind());
abb.rt_sold_cd=rs.getString("rt_sold_cd");abb.setKeyValue("RT_SOLD_CD",""+abb.getRt_sold_cd());
abb.int_past_01_60_day=rs.getDouble("int_past_01_60_day");abb.setKeyValue("INT_PAST_01_60_DAY",""+abb.getInt_past_01_60_day());
abb.int_past_31_60_day=rs.getDouble("int_past_31_60_day");abb.setKeyValue("INT_PAST_31_60_DAY",""+abb.getInt_past_31_60_day());
abb.int_past_61_90_day=rs.getDouble("int_past_61_90_day");abb.setKeyValue("INT_PAST_61_90_DAY",""+abb.getInt_past_61_90_day());
abb.int_past_91_180_da=rs.getDouble("int_past_91_180_da");abb.setKeyValue("INT_PAST_91_180_DA",""+abb.getInt_past_91_180_da());
abb.int_past_ov_180_da=rs.getDouble("int_past_ov_180_da");abb.setKeyValue("INT_PAST_OV_180_DA",""+abb.getInt_past_ov_180_da());
abb.zm_memo2_amt02_0=rs.getDouble("zm_memo2_amt02_0");abb.setKeyValue("ZM_MEMO2_AMT02_0",""+abb.getZm_memo2_amt02_0());
abb.zm_memo2_amt02_1=rs.getDouble("zm_memo2_amt02_1");abb.setKeyValue("ZM_MEMO2_AMT02_1",""+abb.getZm_memo2_amt02_1());
abb.du_pmt_bill_0=rs.getDouble("du_pmt_bill_0");abb.setKeyValue("DU_PMT_BILL_0",""+abb.getDu_pmt_bill_0());
abb.du_pmt_bill_1=rs.getDouble("du_pmt_bill_1");abb.setKeyValue("DU_PMT_BILL_1",""+abb.getDu_pmt_bill_1());
abb.ac_accr_mtd=rs.getDouble("ac_accr_mtd");abb.setKeyValue("AC_ACCR_MTD",""+abb.getAc_accr_mtd());
abb.cm_cmt_num=rs.getString("cm_cmt_num");abb.setKeyValue("CM_CMT_NUM",""+abb.getCm_cmt_num());
abb.zm_pkg_loan_nbr=rs.getString("zm_pkg_loan_nbr");abb.setKeyValue("ZM_PKG_LOAN_NBR",""+abb.getZm_pkg_loan_nbr());
abb.zm_pmt_seq_nbr=rs.getString("zm_pmt_seq_nbr");abb.setKeyValue("ZM_PMT_SEQ_NBR",""+abb.getZm_pmt_seq_nbr());
abb.rt_orig_procd_amt=rs.getDouble("rt_orig_procd_amt");abb.setKeyValue("RT_ORIG_PROCD_AMT",""+abb.getRt_orig_procd_amt());
abb.rt_term_freq=rs.getString("rt_term_freq");abb.setKeyValue("RT_TERM_FREQ",""+abb.getRt_term_freq());
abb.rt_term_incr=rs.getInt("rt_term_incr");abb.setKeyValue("RT_TERM_INCR",""+abb.getRt_term_incr());
abb.rt_actl_pmts_rem=rs.getInt("rt_actl_pmts_rem");abb.setKeyValue("RT_ACTL_PMTS_REM",""+abb.getRt_actl_pmts_rem());
abb.rt_frst_due_date=rs.getString("rt_frst_due_date");abb.setKeyValue("RT_FRST_DUE_DATE",""+abb.getRt_frst_due_date());
abb.poff_date=rs.getString("poff_date");abb.setKeyValue("POFF_DATE",""+abb.getPoff_date());
abb.int_dis_rate=rs.getDouble("int_dis_rate");abb.setKeyValue("INT_DIS_RATE",""+abb.getInt_dis_rate());
abb.int_dis_end_dt=rs.getString("int_dis_end_dt");abb.setKeyValue("INT_DIS_END_DT",""+abb.getInt_dis_end_dt());
abb.zm_aflc_code=rs.getString("zm_aflc_code");abb.setKeyValue("ZM_AFLC_CODE",""+abb.getZm_aflc_code());
abb.zm_adj_penalty_int=rs.getDouble("zm_adj_penalty_int");abb.setKeyValue("ZM_ADJ_PENALTY_INT",""+abb.getZm_adj_penalty_int());
abb.zm_adj_penalty_pri=rs.getDouble("zm_adj_penalty_pri");abb.setKeyValue("ZM_ADJ_PENALTY_PRI",""+abb.getZm_adj_penalty_pri());
abb.bd_nxt_due_date_0=rs.getString("bd_nxt_due_date_0");abb.setKeyValue("BD_NXT_DUE_DATE_0",""+abb.getBd_nxt_due_date_0());
abb.bd_nxt_due_date_2=rs.getString("bd_nxt_due_date_2");abb.setKeyValue("BD_NXT_DUE_DATE_2",""+abb.getBd_nxt_due_date_2());
abb.dq_grace_days=rs.getInt("dq_grace_days");abb.setKeyValue("DQ_GRACE_DAYS",""+abb.getDq_grace_days());
abb.ac_accr_itd=rs.getDouble("ac_accr_itd");abb.setKeyValue("AC_ACCR_ITD",""+abb.getAc_accr_itd());
abb.dq_hist_day_ctr=rs.getInt("dq_hist_day_ctr");abb.setKeyValue("DQ_HIST_DAY_CTR",""+abb.getDq_hist_day_ctr());
abb.dq_num_pmts_pdue=rs.getInt("dq_num_pmts_pdue");abb.setKeyValue("DQ_NUM_PMTS_PDUE",""+abb.getDq_num_pmts_pdue());
abb.rt_user_grp3=rs.getString("rt_user_grp3");abb.setKeyValue("RT_USER_GRP3",""+abb.getRt_user_grp3());
abb.rt_user_grp9=rs.getString("rt_user_grp9");abb.setKeyValue("RT_USER_GRP9",""+abb.getRt_user_grp9());
abb.rt_user_amt1=rs.getDouble("rt_user_amt1");abb.setKeyValue("RT_USER_AMT1",""+abb.getRt_user_amt1());
abb.rt_user_amt2=rs.getDouble("rt_user_amt2");abb.setKeyValue("RT_USER_AMT2",""+abb.getRt_user_amt2());
abb.rt_sngl_balloon_cd=rs.getString("rt_sngl_balloon_cd");abb.setKeyValue("RT_SNGL_BALLOON_CD",""+abb.getRt_sngl_balloon_cd());
abb.bl_lead_days=rs.getInt("bl_lead_days");abb.setKeyValue("BL_LEAD_DAYS",""+abb.getBl_lead_days());
abb.bd_meth=rs.getString("bd_meth");abb.setKeyValue("BD_METH",""+abb.getBd_meth());
abb.bd_bill_type=rs.getString("bd_bill_type");abb.setKeyValue("BD_BILL_TYPE",""+abb.getBd_bill_type());
abb.se_sale_num=rs.getString("se_sale_num");abb.setKeyValue("SE_SALE_NUM",""+abb.getSe_sale_num());
abb.rt_se_commit_date=rs.getString("rt_se_commit_date");abb.setKeyValue("RT_SE_COMMIT_DATE",""+abb.getRt_se_commit_date());
abb.rt_pool_cd=rs.getString("rt_pool_cd");abb.setKeyValue("RT_POOL_CD",""+abb.getRt_pool_cd());
abb.se_sale_date=rs.getString("se_sale_date");abb.setKeyValue("SE_SALE_DATE",""+abb.getSe_sale_date());
abb.zmepoffpctu=rs.getDouble("zmepoffpctu");abb.setKeyValue("ZMEPOFFPCTU",""+abb.getZmepoffpctu());
abb.rtorigcmamt=rs.getDouble("rtorigcmamt");abb.setKeyValue("RTORIGCMAMT",""+abb.getRtorigcmamt());
abb.action_flag=rs.getString("action_flag");abb.setKeyValue("ACTION_FLAG",""+abb.getAction_flag());
abb.slsccd=rs.getString("slsccd");abb.setKeyValue("SLSCCD",""+abb.getSlsccd());
abb.cm_mult_adv_ind=rs.getString("cm_mult_adv_ind");abb.setKeyValue("CM_MULT_ADV_IND",""+abb.getCm_mult_adv_ind());
abb.zm_ful_par_pmt=rs.getString("zm_ful_par_pmt");abb.setKeyValue("ZM_FUL_PAR_PMT",""+abb.getZm_ful_par_pmt());
abb.cf_addr_num=rs.getString("cf_addr_num");abb.setKeyValue("CF_ADDR_NUM",""+abb.getCf_addr_num());
abb.sl_guar_agency_cd=rs.getString("sl_guar_agency_cd");abb.setKeyValue("SL_GUAR_AGENCY_CD",""+abb.getSl_guar_agency_cd());
abb.ba_curr_cm_amt=rs.getDouble("ba_curr_cm_amt");abb.setKeyValue("BA_CURR_CM_AMT",""+abb.getBa_curr_cm_amt());
abb.available_amt=rs.getDouble("available_amt");abb.setKeyValue("AVAILABLE_AMT",""+abb.getAvailable_amt());
abb.rt_date_lst_maint=rs.getString("rt_date_lst_maint");abb.setKeyValue("RT_DATE_LST_MAINT",""+abb.getRt_date_lst_maint());
abb.tot_pri_payment_amt=rs.getDouble("tot_pri_payment_amt");abb.setKeyValue("TOT_PRI_PAYMENT_AMT",""+abb.getTot_pri_payment_amt());
abb.zm_memo2_amt02_2=rs.getDouble("zm_memo2_amt02_2");abb.setKeyValue("ZM_MEMO2_AMT02_2",""+abb.getZm_memo2_amt02_2());
abb.zm_memo2_amt02_3=rs.getDouble("zm_memo2_amt02_3");abb.setKeyValue("ZM_MEMO2_AMT02_3",""+abb.getZm_memo2_amt02_3());
abb.ln_arfn_int=rs.getDouble("ln_arfn_int");abb.setKeyValue("LN_ARFN_INT",""+abb.getLn_arfn_int());
abb.zm_memo2_amt02_4=rs.getDouble("zm_memo2_amt02_4");abb.setKeyValue("ZM_MEMO2_AMT02_4",""+abb.getZm_memo2_amt02_4());
abb.zm_memo2_amt02_6=rs.getDouble("zm_memo2_amt02_6");abb.setKeyValue("ZM_MEMO2_AMT02_6",""+abb.getZm_memo2_amt02_6());
abb.recooperinte=rs.getDouble("recooperinte");abb.setKeyValue("RECOOPERINTE",""+abb.getRecooperinte());
abb.zm_memo2_amt02_21=rs.getDouble("zm_memo2_amt02_21");abb.setKeyValue("ZM_MEMO2_AMT02_21",""+abb.getZm_memo2_amt02_21());
abb.rt_curr_due_amt=rs.getDouble("rt_curr_due_amt");abb.setKeyValue("RT_CURR_DUE_AMT",""+abb.getRt_curr_due_amt());
abb.rt_coff_date=rs.getString("rt_coff_date");abb.setKeyValue("RT_COFF_DATE",""+abb.getRt_coff_date());
abb.filler=rs.getString("filler");abb.setKeyValue("FILLER",""+abb.getFiller());
list.add(abb);
abb.operate_mode = "edit";
}public String getRt_ctl1() { if ( this.rt_ctl1 == null ) return ""; return this.rt_ctl1;}
public String getRtctl2() { if ( this.rtctl2 == null ) return ""; return this.rtctl2;}
public String getRt_ctl3() { if ( this.rt_ctl3 == null ) return ""; return this.rt_ctl3;}
public String getRtctl4() { if ( this.rtctl4 == null ) return ""; return this.rtctl4;}
public String getLn_acct_no() { if ( this.ln_acct_no == null ) return ""; return this.ln_acct_no;}
public String getOds_src_dt() { if ( this.ods_src_dt == null ) return ""; return this.ods_src_dt;}
public String getZm_notes_1() { if ( this.zm_notes_1 == null ) return ""; return this.zm_notes_1;}
public String getMi_set_acct_num() { if ( this.mi_set_acct_num == null ) return ""; return this.mi_set_acct_num;}
public String getCurr_cd() { if ( this.curr_cd == null ) return ""; return this.curr_cd;}
public String getZm_desc_15_1() { if ( this.zm_desc_15_1 == null ) return ""; return this.zm_desc_15_1;}
public String getCust_name() { if ( this.cust_name == null ) return ""; return this.cust_name;}
public String getRt_acct_prod() { if ( this.rt_acct_prod == null ) return ""; return this.rt_acct_prod;}
public String getIns_type() { if ( this.ins_type == null ) return ""; return this.ins_type;}
public String getInsurance_num() { if ( this.insurance_num == null ) return ""; return this.insurance_num;}
public String getAcct_stat() { if ( this.acct_stat == null ) return ""; return this.acct_stat;}
public String getColl_type_1_flag() { if ( this.coll_type_1_flag == null ) return ""; return this.coll_type_1_flag;}
public String getColl_type_2_flag() { if ( this.coll_type_2_flag == null ) return ""; return this.coll_type_2_flag;}
public String getGuarantor_flag() { if ( this.guarantor_flag == null ) return ""; return this.guarantor_flag;}
public String getPer_credit_flag() { if ( this.per_credit_flag == null ) return ""; return this.per_credit_flag;}
public double getIs_cover_amt() { return this.is_cover_amt;}
public String getInsurance_company_name() { if ( this.insurance_company_name == null ) return ""; return this.insurance_company_name;}
public String getIs_agent_name() { if ( this.is_agent_name == null ) return ""; return this.is_agent_name;}
public String getIs_user_desc1() { if ( this.is_user_desc1 == null ) return ""; return this.is_user_desc1;}
public String getIs_user_desc2() { if ( this.is_user_desc2 == null ) return ""; return this.is_user_desc2;}
public String getPay_type() { if ( this.pay_type == null ) return ""; return this.pay_type;}
public String getMi_pay_acct_1() { if ( this.mi_pay_acct_1 == null ) return ""; return this.mi_pay_acct_1;}
public String getMi_pay_acct_2() { if ( this.mi_pay_acct_2 == null ) return ""; return this.mi_pay_acct_2;}
public String getMi_pay_acct_3() { if ( this.mi_pay_acct_3 == null ) return ""; return this.mi_pay_acct_3;}
public String getMi_pay_acct_4() { if ( this.mi_pay_acct_4 == null ) return ""; return this.mi_pay_acct_4;}
public String getMi_pay_acct_5() { if ( this.mi_pay_acct_5 == null ) return ""; return this.mi_pay_acct_5;}
public String getRt_proc_type() { if ( this.rt_proc_type == null ) return ""; return this.rt_proc_type;}
public String getMi_auto_prin_flag() { if ( this.mi_auto_prin_flag == null ) return ""; return this.mi_auto_prin_flag;}
public String getMi_auto_int_flag() { if ( this.mi_auto_int_flag == null ) return ""; return this.mi_auto_int_flag;}
public String getCust_open_dt() { if ( this.cust_open_dt == null ) return ""; return this.cust_open_dt;}
public String getExpiring_dt() { if ( this.expiring_dt == null ) return ""; return this.expiring_dt;}
public int getRt_num_pmts_made() { return this.rt_num_pmts_made;}
public int getCurr_pmt_num() { return this.curr_pmt_num;}
public int getLn_totl_prd() { return this.ln_totl_prd;}
public double getRt_orig_loan_amt() { return this.rt_orig_loan_amt;}
public double getCumulative_payout_amt() { return this.cumulative_payout_amt;}
public int getNum_day_interval() { return this.num_day_interval;}
public int getPrin_num_day_inter() { return this.prin_num_day_inter;}
public int getInt_num_day_interv() { return this.int_num_day_interv;}
public double getBl_flat_amt() { return this.bl_flat_amt;}
public double getTot_pay_amt() { return this.tot_pay_amt;}
public int getProgressive_intv() { return this.progressive_intv;}
public double getProgressive_addt_a() { return this.progressive_addt_a;}
public String getLst_progressive_da() { if ( this.lst_progressive_da == null ) return ""; return this.lst_progressive_da;}
public String getEntruster_fund_acc() { if ( this.entruster_fund_acc == null ) return ""; return this.entruster_fund_acc;}
public String getEntruster_sav_acct() { if ( this.entruster_sav_acct == null ) return ""; return this.entruster_sav_acct;}
public double getBal_of_out_int() { return this.bal_of_out_int;}
public double getInt_rec_acc() { return this.int_rec_acc;}
public String getAcct_open_date() { if ( this.acct_open_date == null ) return ""; return this.acct_open_date;}
public String getRt_list_pmt_date() { if ( this.rt_list_pmt_date == null ) return ""; return this.rt_list_pmt_date;}
public String getAc_start_date() { if ( this.ac_start_date == null ) return ""; return this.ac_start_date;}
public String getAcct_mark() { if ( this.acct_mark == null ) return ""; return this.acct_mark;}
public String getCust_no() { if ( this.cust_no == null ) return ""; return this.cust_no;}
public String getZipcode() { if ( this.zipcode == null ) return ""; return this.zipcode;}
public String getCustomer_address() { if ( this.customer_address == null ) return ""; return this.customer_address;}
public String getCont_tele() { if ( this.cont_tele == null ) return ""; return this.cont_tele;}
public String getCf_bus_phone_data() { if ( this.cf_bus_phone_data == null ) return ""; return this.cf_bus_phone_data;}
public String getAuto_credit_acct() { if ( this.auto_credit_acct == null ) return ""; return this.auto_credit_acct;}
public String getLn_intr_adj_sty() { if ( this.ln_intr_adj_sty == null ) return ""; return this.ln_intr_adj_sty;}
public double getRt_loan_rate() { return this.rt_loan_rate;}
public double getRa_pct1() { return this.ra_pct1;}
public double getAc_rate() { return this.ac_rate;}
public int getTime_of_dq() { return this.time_of_dq;}
public double getBal_normal_prin() { return this.bal_normal_prin;}
public double getBal_of_past_due_pr() { return this.bal_of_past_due_pr;}
public double getBal_dq_prin() { return this.bal_dq_prin;}
public double getBal_of_bad_prin() { return this.bal_of_bad_prin;}
public double getOverbal() { return this.overbal;}
public double getReceivable_intr() { return this.receivable_intr;}
public double getDunning_intr() { return this.dunning_intr;}
public double getDq_of_brk_charge() { return this.dq_of_brk_charge;}
public double getDq_procedure_fee() { return this.dq_procedure_fee;}
public double getBa_amt_pd_itd() { return this.ba_amt_pd_itd;}
public double getPre_pay_amt() { return this.pre_pay_amt;}
public double getTot_penalty_pay_am() { return this.tot_penalty_pay_am;}
public double getAc_amt_pd_itd() { return this.ac_amt_pd_itd;}
public double getTot_pd_brk_fee() { return this.tot_pd_brk_fee;}
public double getTot_pd_proce_fee() { return this.tot_pd_proce_fee;}
public double getRt_tot_coff_amt() { return this.rt_tot_coff_amt;}
public double getDq_alp_amt() { return this.dq_alp_amt;}
public double getCol_ali_amt() { return this.col_ali_amt;}
public double getPast_due_alp() { return this.past_due_alp;}
public double getInt_rec_ali() { return this.int_rec_ali;}
public String getRt_oldst_due_date() { if ( this.rt_oldst_due_date == null ) return ""; return this.rt_oldst_due_date;}
public double getSacapi31() { return this.sacapi31;}
public double getSacapi61() { return this.sacapi61;}
public double getSacapi91() { return this.sacapi91;}
public double getPri_past_ov_180_da() { return this.pri_past_ov_180_da;}
public int getNum_of_time_dq() { return this.num_of_time_dq;}
public String getCurr_mth_pay_statu() { if ( this.curr_mth_pay_statu == null ) return ""; return this.curr_mth_pay_statu;}
public int getRt_num_due_seq() { return this.rt_num_due_seq;}
public double getDu_pmt_rem() { return this.du_pmt_rem;}
public double getAc_accr_bal() { return this.ac_accr_bal;}
public String getRt_sold_ind() { if ( this.rt_sold_ind == null ) return ""; return this.rt_sold_ind;}
public String getRt_sold_cd() { if ( this.rt_sold_cd == null ) return ""; return this.rt_sold_cd;}
public double getInt_past_01_60_day() { return this.int_past_01_60_day;}
public double getInt_past_31_60_day() { return this.int_past_31_60_day;}
public double getInt_past_61_90_day() { return this.int_past_61_90_day;}
public double getInt_past_91_180_da() { return this.int_past_91_180_da;}
public double getInt_past_ov_180_da() { return this.int_past_ov_180_da;}
public double getZm_memo2_amt02_0() { return this.zm_memo2_amt02_0;}
public double getZm_memo2_amt02_1() { return this.zm_memo2_amt02_1;}
public double getDu_pmt_bill_0() { return this.du_pmt_bill_0;}
public double getDu_pmt_bill_1() { return this.du_pmt_bill_1;}
public double getAc_accr_mtd() { return this.ac_accr_mtd;}
public String getCm_cmt_num() { if ( this.cm_cmt_num == null ) return ""; return this.cm_cmt_num;}
public String getZm_pkg_loan_nbr() { if ( this.zm_pkg_loan_nbr == null ) return ""; return this.zm_pkg_loan_nbr;}
public String getZm_pmt_seq_nbr() { if ( this.zm_pmt_seq_nbr == null ) return ""; return this.zm_pmt_seq_nbr;}
public double getRt_orig_procd_amt() { return this.rt_orig_procd_amt;}
public String getRt_term_freq() { if ( this.rt_term_freq == null ) return ""; return this.rt_term_freq;}
public int getRt_term_incr() { return this.rt_term_incr;}
public int getRt_actl_pmts_rem() { return this.rt_actl_pmts_rem;}
public String getRt_frst_due_date() { if ( this.rt_frst_due_date == null ) return ""; return this.rt_frst_due_date;}
public String getPoff_date() { if ( this.poff_date == null ) return ""; return this.poff_date;}
public double getInt_dis_rate() { return this.int_dis_rate;}
public String getInt_dis_end_dt() { if ( this.int_dis_end_dt == null ) return ""; return this.int_dis_end_dt;}
public String getZm_aflc_code() { if ( this.zm_aflc_code == null ) return ""; return this.zm_aflc_code;}
public double getZm_adj_penalty_int() { return this.zm_adj_penalty_int;}
public double getZm_adj_penalty_pri() { return this.zm_adj_penalty_pri;}
public String getBd_nxt_due_date_0() { if ( this.bd_nxt_due_date_0 == null ) return ""; return this.bd_nxt_due_date_0;}
public String getBd_nxt_due_date_2() { if ( this.bd_nxt_due_date_2 == null ) return ""; return this.bd_nxt_due_date_2;}
public int getDq_grace_days() { return this.dq_grace_days;}
public double getAc_accr_itd() { return this.ac_accr_itd;}
public int getDq_hist_day_ctr() { return this.dq_hist_day_ctr;}
public int getDq_num_pmts_pdue() { return this.dq_num_pmts_pdue;}
public String getRt_user_grp3() { if ( this.rt_user_grp3 == null ) return ""; return this.rt_user_grp3;}
public String getRt_user_grp9() { if ( this.rt_user_grp9 == null ) return ""; return this.rt_user_grp9;}
public double getRt_user_amt1() { return this.rt_user_amt1;}
public double getRt_user_amt2() { return this.rt_user_amt2;}
public String getRt_sngl_balloon_cd() { if ( this.rt_sngl_balloon_cd == null ) return ""; return this.rt_sngl_balloon_cd;}
public int getBl_lead_days() { return this.bl_lead_days;}
public String getBd_meth() { if ( this.bd_meth == null ) return ""; return this.bd_meth;}
public String getBd_bill_type() { if ( this.bd_bill_type == null ) return ""; return this.bd_bill_type;}
public String getSe_sale_num() { if ( this.se_sale_num == null ) return ""; return this.se_sale_num;}
public String getRt_se_commit_date() { if ( this.rt_se_commit_date == null ) return ""; return this.rt_se_commit_date;}
public String getRt_pool_cd() { if ( this.rt_pool_cd == null ) return ""; return this.rt_pool_cd;}
public String getSe_sale_date() { if ( this.se_sale_date == null ) return ""; return this.se_sale_date;}
public double getZmepoffpctu() { return this.zmepoffpctu;}
public double getRtorigcmamt() { return this.rtorigcmamt;}
public String getAction_flag() { if ( this.action_flag == null ) return ""; return this.action_flag;}
public String getSlsccd() { if ( this.slsccd == null ) return ""; return this.slsccd;}
public String getCm_mult_adv_ind() { if ( this.cm_mult_adv_ind == null ) return ""; return this.cm_mult_adv_ind;}
public String getZm_ful_par_pmt() { if ( this.zm_ful_par_pmt == null ) return ""; return this.zm_ful_par_pmt;}
public String getCf_addr_num() { if ( this.cf_addr_num == null ) return ""; return this.cf_addr_num;}
public String getSl_guar_agency_cd() { if ( this.sl_guar_agency_cd == null ) return ""; return this.sl_guar_agency_cd;}
public double getBa_curr_cm_amt() { return this.ba_curr_cm_amt;}
public double getAvailable_amt() { return this.available_amt;}
public String getRt_date_lst_maint() { if ( this.rt_date_lst_maint == null ) return ""; return this.rt_date_lst_maint;}
public double getTot_pri_payment_amt() { return this.tot_pri_payment_amt;}
public double getZm_memo2_amt02_2() { return this.zm_memo2_amt02_2;}
public double getZm_memo2_amt02_3() { return this.zm_memo2_amt02_3;}
public double getLn_arfn_int() { return this.ln_arfn_int;}
public double getZm_memo2_amt02_4() { return this.zm_memo2_amt02_4;}
public double getZm_memo2_amt02_6() { return this.zm_memo2_amt02_6;}
public double getRecooperinte() { return this.recooperinte;}
public double getZm_memo2_amt02_21() { return this.zm_memo2_amt02_21;}
public double getRt_curr_due_amt() { return this.rt_curr_due_amt;}
public String getRt_coff_date() { if ( this.rt_coff_date == null ) return ""; return this.rt_coff_date;}
public String getFiller() { if ( this.filler == null ) return ""; return this.filler;}
public void setRt_ctl1(String rt_ctl1) { sqlMaker.setField("rt_ctl1",rt_ctl1,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRt_ctl1().equals(rt_ctl1)) cf.add("rt_ctl1",this.rt_ctl1,rt_ctl1); } this.rt_ctl1=rt_ctl1;}
public void setRtctl2(String rtctl2) { sqlMaker.setField("rtctl2",rtctl2,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRtctl2().equals(rtctl2)) cf.add("rtctl2",this.rtctl2,rtctl2); } this.rtctl2=rtctl2;}
public void setRt_ctl3(String rt_ctl3) { sqlMaker.setField("rt_ctl3",rt_ctl3,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRt_ctl3().equals(rt_ctl3)) cf.add("rt_ctl3",this.rt_ctl3,rt_ctl3); } this.rt_ctl3=rt_ctl3;}
public void setRtctl4(String rtctl4) { sqlMaker.setField("rtctl4",rtctl4,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRtctl4().equals(rtctl4)) cf.add("rtctl4",this.rtctl4,rtctl4); } this.rtctl4=rtctl4;}
public void setLn_acct_no(String ln_acct_no) { sqlMaker.setField("ln_acct_no",ln_acct_no,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLn_acct_no().equals(ln_acct_no)) cf.add("ln_acct_no",this.ln_acct_no,ln_acct_no); } this.ln_acct_no=ln_acct_no;}
public void setOds_src_dt(String ods_src_dt) { sqlMaker.setField("ods_src_dt",ods_src_dt,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getOds_src_dt().equals(ods_src_dt)) cf.add("ods_src_dt",this.ods_src_dt,ods_src_dt); } this.ods_src_dt=ods_src_dt;}
public void setZm_notes_1(String zm_notes_1) { sqlMaker.setField("zm_notes_1",zm_notes_1,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getZm_notes_1().equals(zm_notes_1)) cf.add("zm_notes_1",this.zm_notes_1,zm_notes_1); } this.zm_notes_1=zm_notes_1;}
public void setMi_set_acct_num(String mi_set_acct_num) { sqlMaker.setField("mi_set_acct_num",mi_set_acct_num,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getMi_set_acct_num().equals(mi_set_acct_num)) cf.add("mi_set_acct_num",this.mi_set_acct_num,mi_set_acct_num); } this.mi_set_acct_num=mi_set_acct_num;}
public void setCurr_cd(String curr_cd) { sqlMaker.setField("curr_cd",curr_cd,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCurr_cd().equals(curr_cd)) cf.add("curr_cd",this.curr_cd,curr_cd); } this.curr_cd=curr_cd;}
public void setZm_desc_15_1(String zm_desc_15_1) { sqlMaker.setField("zm_desc_15_1",zm_desc_15_1,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getZm_desc_15_1().equals(zm_desc_15_1)) cf.add("zm_desc_15_1",this.zm_desc_15_1,zm_desc_15_1); } this.zm_desc_15_1=zm_desc_15_1;}
public void setCust_name(String cust_name) { sqlMaker.setField("cust_name",cust_name,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCust_name().equals(cust_name)) cf.add("cust_name",this.cust_name,cust_name); } this.cust_name=cust_name;}
public void setRt_acct_prod(String rt_acct_prod) { sqlMaker.setField("rt_acct_prod",rt_acct_prod,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRt_acct_prod().equals(rt_acct_prod)) cf.add("rt_acct_prod",this.rt_acct_prod,rt_acct_prod); } this.rt_acct_prod=rt_acct_prod;}
public void setIns_type(String ins_type) { sqlMaker.setField("ins_type",ins_type,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getIns_type().equals(ins_type)) cf.add("ins_type",this.ins_type,ins_type); } this.ins_type=ins_type;}
public void setInsurance_num(String insurance_num) { sqlMaker.setField("insurance_num",insurance_num,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getInsurance_num().equals(insurance_num)) cf.add("insurance_num",this.insurance_num,insurance_num); } this.insurance_num=insurance_num;}
public void setAcct_stat(String acct_stat) { sqlMaker.setField("acct_stat",acct_stat,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAcct_stat().equals(acct_stat)) cf.add("acct_stat",this.acct_stat,acct_stat); } this.acct_stat=acct_stat;}
public void setColl_type_1_flag(String coll_type_1_flag) { sqlMaker.setField("coll_type_1_flag",coll_type_1_flag,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getColl_type_1_flag().equals(coll_type_1_flag)) cf.add("coll_type_1_flag",this.coll_type_1_flag,coll_type_1_flag); } this.coll_type_1_flag=coll_type_1_flag;}
public void setColl_type_2_flag(String coll_type_2_flag) { sqlMaker.setField("coll_type_2_flag",coll_type_2_flag,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getColl_type_2_flag().equals(coll_type_2_flag)) cf.add("coll_type_2_flag",this.coll_type_2_flag,coll_type_2_flag); } this.coll_type_2_flag=coll_type_2_flag;}
public void setGuarantor_flag(String guarantor_flag) { sqlMaker.setField("guarantor_flag",guarantor_flag,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getGuarantor_flag().equals(guarantor_flag)) cf.add("guarantor_flag",this.guarantor_flag,guarantor_flag); } this.guarantor_flag=guarantor_flag;}
public void setPer_credit_flag(String per_credit_flag) { sqlMaker.setField("per_credit_flag",per_credit_flag,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getPer_credit_flag().equals(per_credit_flag)) cf.add("per_credit_flag",this.per_credit_flag,per_credit_flag); } this.per_credit_flag=per_credit_flag;}
public void setIs_cover_amt(double is_cover_amt) { sqlMaker.setField("is_cover_amt",""+is_cover_amt,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getIs_cover_amt()!=is_cover_amt) cf.add("is_cover_amt",this.is_cover_amt+"",is_cover_amt+""); } this.is_cover_amt=is_cover_amt;}
public void setInsurance_company_name(String insurance_company_name) { sqlMaker.setField("insurance_company_name",insurance_company_name,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getInsurance_company_name().equals(insurance_company_name)) cf.add("insurance_company_name",this.insurance_company_name,insurance_company_name); } this.insurance_company_name=insurance_company_name;}
public void setIs_agent_name(String is_agent_name) { sqlMaker.setField("is_agent_name",is_agent_name,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getIs_agent_name().equals(is_agent_name)) cf.add("is_agent_name",this.is_agent_name,is_agent_name); } this.is_agent_name=is_agent_name;}
public void setIs_user_desc1(String is_user_desc1) { sqlMaker.setField("is_user_desc1",is_user_desc1,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getIs_user_desc1().equals(is_user_desc1)) cf.add("is_user_desc1",this.is_user_desc1,is_user_desc1); } this.is_user_desc1=is_user_desc1;}
public void setIs_user_desc2(String is_user_desc2) { sqlMaker.setField("is_user_desc2",is_user_desc2,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getIs_user_desc2().equals(is_user_desc2)) cf.add("is_user_desc2",this.is_user_desc2,is_user_desc2); } this.is_user_desc2=is_user_desc2;}
public void setPay_type(String pay_type) { sqlMaker.setField("pay_type",pay_type,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getPay_type().equals(pay_type)) cf.add("pay_type",this.pay_type,pay_type); } this.pay_type=pay_type;}
public void setMi_pay_acct_1(String mi_pay_acct_1) { sqlMaker.setField("mi_pay_acct_1",mi_pay_acct_1,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getMi_pay_acct_1().equals(mi_pay_acct_1)) cf.add("mi_pay_acct_1",this.mi_pay_acct_1,mi_pay_acct_1); } this.mi_pay_acct_1=mi_pay_acct_1;}
public void setMi_pay_acct_2(String mi_pay_acct_2) { sqlMaker.setField("mi_pay_acct_2",mi_pay_acct_2,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getMi_pay_acct_2().equals(mi_pay_acct_2)) cf.add("mi_pay_acct_2",this.mi_pay_acct_2,mi_pay_acct_2); } this.mi_pay_acct_2=mi_pay_acct_2;}
public void setMi_pay_acct_3(String mi_pay_acct_3) { sqlMaker.setField("mi_pay_acct_3",mi_pay_acct_3,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getMi_pay_acct_3().equals(mi_pay_acct_3)) cf.add("mi_pay_acct_3",this.mi_pay_acct_3,mi_pay_acct_3); } this.mi_pay_acct_3=mi_pay_acct_3;}
public void setMi_pay_acct_4(String mi_pay_acct_4) { sqlMaker.setField("mi_pay_acct_4",mi_pay_acct_4,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getMi_pay_acct_4().equals(mi_pay_acct_4)) cf.add("mi_pay_acct_4",this.mi_pay_acct_4,mi_pay_acct_4); } this.mi_pay_acct_4=mi_pay_acct_4;}
public void setMi_pay_acct_5(String mi_pay_acct_5) { sqlMaker.setField("mi_pay_acct_5",mi_pay_acct_5,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getMi_pay_acct_5().equals(mi_pay_acct_5)) cf.add("mi_pay_acct_5",this.mi_pay_acct_5,mi_pay_acct_5); } this.mi_pay_acct_5=mi_pay_acct_5;}
public void setRt_proc_type(String rt_proc_type) { sqlMaker.setField("rt_proc_type",rt_proc_type,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRt_proc_type().equals(rt_proc_type)) cf.add("rt_proc_type",this.rt_proc_type,rt_proc_type); } this.rt_proc_type=rt_proc_type;}
public void setMi_auto_prin_flag(String mi_auto_prin_flag) { sqlMaker.setField("mi_auto_prin_flag",mi_auto_prin_flag,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getMi_auto_prin_flag().equals(mi_auto_prin_flag)) cf.add("mi_auto_prin_flag",this.mi_auto_prin_flag,mi_auto_prin_flag); } this.mi_auto_prin_flag=mi_auto_prin_flag;}
public void setMi_auto_int_flag(String mi_auto_int_flag) { sqlMaker.setField("mi_auto_int_flag",mi_auto_int_flag,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getMi_auto_int_flag().equals(mi_auto_int_flag)) cf.add("mi_auto_int_flag",this.mi_auto_int_flag,mi_auto_int_flag); } this.mi_auto_int_flag=mi_auto_int_flag;}
public void setCust_open_dt(String cust_open_dt) { sqlMaker.setField("cust_open_dt",cust_open_dt,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCust_open_dt().equals(cust_open_dt)) cf.add("cust_open_dt",this.cust_open_dt,cust_open_dt); } this.cust_open_dt=cust_open_dt;}
public void setExpiring_dt(String expiring_dt) { sqlMaker.setField("expiring_dt",expiring_dt,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getExpiring_dt().equals(expiring_dt)) cf.add("expiring_dt",this.expiring_dt,expiring_dt); } this.expiring_dt=expiring_dt;}
public void setRt_num_pmts_made(int rt_num_pmts_made) { sqlMaker.setField("rt_num_pmts_made",""+rt_num_pmts_made,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRt_num_pmts_made()!=rt_num_pmts_made) cf.add("rt_num_pmts_made",this.rt_num_pmts_made+"",rt_num_pmts_made+""); } this.rt_num_pmts_made=rt_num_pmts_made;}
public void setCurr_pmt_num(int curr_pmt_num) { sqlMaker.setField("curr_pmt_num",""+curr_pmt_num,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getCurr_pmt_num()!=curr_pmt_num) cf.add("curr_pmt_num",this.curr_pmt_num+"",curr_pmt_num+""); } this.curr_pmt_num=curr_pmt_num;}
public void setLn_totl_prd(int ln_totl_prd) { sqlMaker.setField("ln_totl_prd",""+ln_totl_prd,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getLn_totl_prd()!=ln_totl_prd) cf.add("ln_totl_prd",this.ln_totl_prd+"",ln_totl_prd+""); } this.ln_totl_prd=ln_totl_prd;}
public void setRt_orig_loan_amt(double rt_orig_loan_amt) { sqlMaker.setField("rt_orig_loan_amt",""+rt_orig_loan_amt,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRt_orig_loan_amt()!=rt_orig_loan_amt) cf.add("rt_orig_loan_amt",this.rt_orig_loan_amt+"",rt_orig_loan_amt+""); } this.rt_orig_loan_amt=rt_orig_loan_amt;}
public void setCumulative_payout_amt(double cumulative_payout_amt) { sqlMaker.setField("cumulative_payout_amt",""+cumulative_payout_amt,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getCumulative_payout_amt()!=cumulative_payout_amt) cf.add("cumulative_payout_amt",this.cumulative_payout_amt+"",cumulative_payout_amt+""); } this.cumulative_payout_amt=cumulative_payout_amt;}
public void setNum_day_interval(int num_day_interval) { sqlMaker.setField("num_day_interval",""+num_day_interval,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getNum_day_interval()!=num_day_interval) cf.add("num_day_interval",this.num_day_interval+"",num_day_interval+""); } this.num_day_interval=num_day_interval;}
public void setPrin_num_day_inter(int prin_num_day_inter) { sqlMaker.setField("prin_num_day_inter",""+prin_num_day_inter,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getPrin_num_day_inter()!=prin_num_day_inter) cf.add("prin_num_day_inter",this.prin_num_day_inter+"",prin_num_day_inter+""); } this.prin_num_day_inter=prin_num_day_inter;}
public void setInt_num_day_interv(int int_num_day_interv) { sqlMaker.setField("int_num_day_interv",""+int_num_day_interv,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getInt_num_day_interv()!=int_num_day_interv) cf.add("int_num_day_interv",this.int_num_day_interv+"",int_num_day_interv+""); } this.int_num_day_interv=int_num_day_interv;}
public void setBl_flat_amt(double bl_flat_amt) { sqlMaker.setField("bl_flat_amt",""+bl_flat_amt,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getBl_flat_amt()!=bl_flat_amt) cf.add("bl_flat_amt",this.bl_flat_amt+"",bl_flat_amt+""); } this.bl_flat_amt=bl_flat_amt;}
public void setTot_pay_amt(double tot_pay_amt) { sqlMaker.setField("tot_pay_amt",""+tot_pay_amt,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getTot_pay_amt()!=tot_pay_amt) cf.add("tot_pay_amt",this.tot_pay_amt+"",tot_pay_amt+""); } this.tot_pay_amt=tot_pay_amt;}
public void setProgressive_intv(int progressive_intv) { sqlMaker.setField("progressive_intv",""+progressive_intv,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getProgressive_intv()!=progressive_intv) cf.add("progressive_intv",this.progressive_intv+"",progressive_intv+""); } this.progressive_intv=progressive_intv;}
public void setProgressive_addt_a(double progressive_addt_a) { sqlMaker.setField("progressive_addt_a",""+progressive_addt_a,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getProgressive_addt_a()!=progressive_addt_a) cf.add("progressive_addt_a",this.progressive_addt_a+"",progressive_addt_a+""); } this.progressive_addt_a=progressive_addt_a;}
public void setLst_progressive_da(String lst_progressive_da) { sqlMaker.setField("lst_progressive_da",lst_progressive_da,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLst_progressive_da().equals(lst_progressive_da)) cf.add("lst_progressive_da",this.lst_progressive_da,lst_progressive_da); } this.lst_progressive_da=lst_progressive_da;}
public void setEntruster_fund_acc(String entruster_fund_acc) { sqlMaker.setField("entruster_fund_acc",entruster_fund_acc,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getEntruster_fund_acc().equals(entruster_fund_acc)) cf.add("entruster_fund_acc",this.entruster_fund_acc,entruster_fund_acc); } this.entruster_fund_acc=entruster_fund_acc;}
public void setEntruster_sav_acct(String entruster_sav_acct) { sqlMaker.setField("entruster_sav_acct",entruster_sav_acct,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getEntruster_sav_acct().equals(entruster_sav_acct)) cf.add("entruster_sav_acct",this.entruster_sav_acct,entruster_sav_acct); } this.entruster_sav_acct=entruster_sav_acct;}
public void setBal_of_out_int(double bal_of_out_int) { sqlMaker.setField("bal_of_out_int",""+bal_of_out_int,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getBal_of_out_int()!=bal_of_out_int) cf.add("bal_of_out_int",this.bal_of_out_int+"",bal_of_out_int+""); } this.bal_of_out_int=bal_of_out_int;}
public void setInt_rec_acc(double int_rec_acc) { sqlMaker.setField("int_rec_acc",""+int_rec_acc,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getInt_rec_acc()!=int_rec_acc) cf.add("int_rec_acc",this.int_rec_acc+"",int_rec_acc+""); } this.int_rec_acc=int_rec_acc;}
public void setAcct_open_date(String acct_open_date) { sqlMaker.setField("acct_open_date",acct_open_date,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAcct_open_date().equals(acct_open_date)) cf.add("acct_open_date",this.acct_open_date,acct_open_date); } this.acct_open_date=acct_open_date;}
public void setRt_list_pmt_date(String rt_list_pmt_date) { sqlMaker.setField("rt_list_pmt_date",rt_list_pmt_date,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRt_list_pmt_date().equals(rt_list_pmt_date)) cf.add("rt_list_pmt_date",this.rt_list_pmt_date,rt_list_pmt_date); } this.rt_list_pmt_date=rt_list_pmt_date;}
public void setAc_start_date(String ac_start_date) { sqlMaker.setField("ac_start_date",ac_start_date,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAc_start_date().equals(ac_start_date)) cf.add("ac_start_date",this.ac_start_date,ac_start_date); } this.ac_start_date=ac_start_date;}
public void setAcct_mark(String acct_mark) { sqlMaker.setField("acct_mark",acct_mark,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAcct_mark().equals(acct_mark)) cf.add("acct_mark",this.acct_mark,acct_mark); } this.acct_mark=acct_mark;}
public void setCust_no(String cust_no) { sqlMaker.setField("cust_no",cust_no,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCust_no().equals(cust_no)) cf.add("cust_no",this.cust_no,cust_no); } this.cust_no=cust_no;}
public void setZipcode(String zipcode) { sqlMaker.setField("zipcode",zipcode,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getZipcode().equals(zipcode)) cf.add("zipcode",this.zipcode,zipcode); } this.zipcode=zipcode;}
public void setCustomer_address(String customer_address) { sqlMaker.setField("customer_address",customer_address,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCustomer_address().equals(customer_address)) cf.add("customer_address",this.customer_address,customer_address); } this.customer_address=customer_address;}
public void setCont_tele(String cont_tele) { sqlMaker.setField("cont_tele",cont_tele,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCont_tele().equals(cont_tele)) cf.add("cont_tele",this.cont_tele,cont_tele); } this.cont_tele=cont_tele;}
public void setCf_bus_phone_data(String cf_bus_phone_data) { sqlMaker.setField("cf_bus_phone_data",cf_bus_phone_data,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCf_bus_phone_data().equals(cf_bus_phone_data)) cf.add("cf_bus_phone_data",this.cf_bus_phone_data,cf_bus_phone_data); } this.cf_bus_phone_data=cf_bus_phone_data;}
public void setAuto_credit_acct(String auto_credit_acct) { sqlMaker.setField("auto_credit_acct",auto_credit_acct,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAuto_credit_acct().equals(auto_credit_acct)) cf.add("auto_credit_acct",this.auto_credit_acct,auto_credit_acct); } this.auto_credit_acct=auto_credit_acct;}
public void setLn_intr_adj_sty(String ln_intr_adj_sty) { sqlMaker.setField("ln_intr_adj_sty",ln_intr_adj_sty,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getLn_intr_adj_sty().equals(ln_intr_adj_sty)) cf.add("ln_intr_adj_sty",this.ln_intr_adj_sty,ln_intr_adj_sty); } this.ln_intr_adj_sty=ln_intr_adj_sty;}
public void setRt_loan_rate(double rt_loan_rate) { sqlMaker.setField("rt_loan_rate",""+rt_loan_rate,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRt_loan_rate()!=rt_loan_rate) cf.add("rt_loan_rate",this.rt_loan_rate+"",rt_loan_rate+""); } this.rt_loan_rate=rt_loan_rate;}
public void setRa_pct1(double ra_pct1) { sqlMaker.setField("ra_pct1",""+ra_pct1,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRa_pct1()!=ra_pct1) cf.add("ra_pct1",this.ra_pct1+"",ra_pct1+""); } this.ra_pct1=ra_pct1;}
public void setAc_rate(double ac_rate) { sqlMaker.setField("ac_rate",""+ac_rate,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getAc_rate()!=ac_rate) cf.add("ac_rate",this.ac_rate+"",ac_rate+""); } this.ac_rate=ac_rate;}
public void setTime_of_dq(int time_of_dq) { sqlMaker.setField("time_of_dq",""+time_of_dq,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getTime_of_dq()!=time_of_dq) cf.add("time_of_dq",this.time_of_dq+"",time_of_dq+""); } this.time_of_dq=time_of_dq;}
public void setBal_normal_prin(double bal_normal_prin) { sqlMaker.setField("bal_normal_prin",""+bal_normal_prin,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getBal_normal_prin()!=bal_normal_prin) cf.add("bal_normal_prin",this.bal_normal_prin+"",bal_normal_prin+""); } this.bal_normal_prin=bal_normal_prin;}
public void setBal_of_past_due_pr(double bal_of_past_due_pr) { sqlMaker.setField("bal_of_past_due_pr",""+bal_of_past_due_pr,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getBal_of_past_due_pr()!=bal_of_past_due_pr) cf.add("bal_of_past_due_pr",this.bal_of_past_due_pr+"",bal_of_past_due_pr+""); } this.bal_of_past_due_pr=bal_of_past_due_pr;}
public void setBal_dq_prin(double bal_dq_prin) { sqlMaker.setField("bal_dq_prin",""+bal_dq_prin,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getBal_dq_prin()!=bal_dq_prin) cf.add("bal_dq_prin",this.bal_dq_prin+"",bal_dq_prin+""); } this.bal_dq_prin=bal_dq_prin;}
public void setBal_of_bad_prin(double bal_of_bad_prin) { sqlMaker.setField("bal_of_bad_prin",""+bal_of_bad_prin,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getBal_of_bad_prin()!=bal_of_bad_prin) cf.add("bal_of_bad_prin",this.bal_of_bad_prin+"",bal_of_bad_prin+""); } this.bal_of_bad_prin=bal_of_bad_prin;}
public void setOverbal(double overbal) { sqlMaker.setField("overbal",""+overbal,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getOverbal()!=overbal) cf.add("overbal",this.overbal+"",overbal+""); } this.overbal=overbal;}
public void setReceivable_intr(double receivable_intr) { sqlMaker.setField("receivable_intr",""+receivable_intr,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getReceivable_intr()!=receivable_intr) cf.add("receivable_intr",this.receivable_intr+"",receivable_intr+""); } this.receivable_intr=receivable_intr;}
public void setDunning_intr(double dunning_intr) { sqlMaker.setField("dunning_intr",""+dunning_intr,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getDunning_intr()!=dunning_intr) cf.add("dunning_intr",this.dunning_intr+"",dunning_intr+""); } this.dunning_intr=dunning_intr;}
public void setDq_of_brk_charge(double dq_of_brk_charge) { sqlMaker.setField("dq_of_brk_charge",""+dq_of_brk_charge,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getDq_of_brk_charge()!=dq_of_brk_charge) cf.add("dq_of_brk_charge",this.dq_of_brk_charge+"",dq_of_brk_charge+""); } this.dq_of_brk_charge=dq_of_brk_charge;}
public void setDq_procedure_fee(double dq_procedure_fee) { sqlMaker.setField("dq_procedure_fee",""+dq_procedure_fee,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getDq_procedure_fee()!=dq_procedure_fee) cf.add("dq_procedure_fee",this.dq_procedure_fee+"",dq_procedure_fee+""); } this.dq_procedure_fee=dq_procedure_fee;}
public void setBa_amt_pd_itd(double ba_amt_pd_itd) { sqlMaker.setField("ba_amt_pd_itd",""+ba_amt_pd_itd,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getBa_amt_pd_itd()!=ba_amt_pd_itd) cf.add("ba_amt_pd_itd",this.ba_amt_pd_itd+"",ba_amt_pd_itd+""); } this.ba_amt_pd_itd=ba_amt_pd_itd;}
public void setPre_pay_amt(double pre_pay_amt) { sqlMaker.setField("pre_pay_amt",""+pre_pay_amt,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getPre_pay_amt()!=pre_pay_amt) cf.add("pre_pay_amt",this.pre_pay_amt+"",pre_pay_amt+""); } this.pre_pay_amt=pre_pay_amt;}
public void setTot_penalty_pay_am(double tot_penalty_pay_am) { sqlMaker.setField("tot_penalty_pay_am",""+tot_penalty_pay_am,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getTot_penalty_pay_am()!=tot_penalty_pay_am) cf.add("tot_penalty_pay_am",this.tot_penalty_pay_am+"",tot_penalty_pay_am+""); } this.tot_penalty_pay_am=tot_penalty_pay_am;}
public void setAc_amt_pd_itd(double ac_amt_pd_itd) { sqlMaker.setField("ac_amt_pd_itd",""+ac_amt_pd_itd,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getAc_amt_pd_itd()!=ac_amt_pd_itd) cf.add("ac_amt_pd_itd",this.ac_amt_pd_itd+"",ac_amt_pd_itd+""); } this.ac_amt_pd_itd=ac_amt_pd_itd;}
public void setTot_pd_brk_fee(double tot_pd_brk_fee) { sqlMaker.setField("tot_pd_brk_fee",""+tot_pd_brk_fee,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getTot_pd_brk_fee()!=tot_pd_brk_fee) cf.add("tot_pd_brk_fee",this.tot_pd_brk_fee+"",tot_pd_brk_fee+""); } this.tot_pd_brk_fee=tot_pd_brk_fee;}
public void setTot_pd_proce_fee(double tot_pd_proce_fee) { sqlMaker.setField("tot_pd_proce_fee",""+tot_pd_proce_fee,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getTot_pd_proce_fee()!=tot_pd_proce_fee) cf.add("tot_pd_proce_fee",this.tot_pd_proce_fee+"",tot_pd_proce_fee+""); } this.tot_pd_proce_fee=tot_pd_proce_fee;}
public void setRt_tot_coff_amt(double rt_tot_coff_amt) { sqlMaker.setField("rt_tot_coff_amt",""+rt_tot_coff_amt,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRt_tot_coff_amt()!=rt_tot_coff_amt) cf.add("rt_tot_coff_amt",this.rt_tot_coff_amt+"",rt_tot_coff_amt+""); } this.rt_tot_coff_amt=rt_tot_coff_amt;}
public void setDq_alp_amt(double dq_alp_amt) { sqlMaker.setField("dq_alp_amt",""+dq_alp_amt,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getDq_alp_amt()!=dq_alp_amt) cf.add("dq_alp_amt",this.dq_alp_amt+"",dq_alp_amt+""); } this.dq_alp_amt=dq_alp_amt;}
public void setCol_ali_amt(double col_ali_amt) { sqlMaker.setField("col_ali_amt",""+col_ali_amt,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getCol_ali_amt()!=col_ali_amt) cf.add("col_ali_amt",this.col_ali_amt+"",col_ali_amt+""); } this.col_ali_amt=col_ali_amt;}
public void setPast_due_alp(double past_due_alp) { sqlMaker.setField("past_due_alp",""+past_due_alp,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getPast_due_alp()!=past_due_alp) cf.add("past_due_alp",this.past_due_alp+"",past_due_alp+""); } this.past_due_alp=past_due_alp;}
public void setInt_rec_ali(double int_rec_ali) { sqlMaker.setField("int_rec_ali",""+int_rec_ali,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getInt_rec_ali()!=int_rec_ali) cf.add("int_rec_ali",this.int_rec_ali+"",int_rec_ali+""); } this.int_rec_ali=int_rec_ali;}
public void setRt_oldst_due_date(String rt_oldst_due_date) { sqlMaker.setField("rt_oldst_due_date",rt_oldst_due_date,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRt_oldst_due_date().equals(rt_oldst_due_date)) cf.add("rt_oldst_due_date",this.rt_oldst_due_date,rt_oldst_due_date); } this.rt_oldst_due_date=rt_oldst_due_date;}
public void setSacapi31(double sacapi31) { sqlMaker.setField("sacapi31",""+sacapi31,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getSacapi31()!=sacapi31) cf.add("sacapi31",this.sacapi31+"",sacapi31+""); } this.sacapi31=sacapi31;}
public void setSacapi61(double sacapi61) { sqlMaker.setField("sacapi61",""+sacapi61,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getSacapi61()!=sacapi61) cf.add("sacapi61",this.sacapi61+"",sacapi61+""); } this.sacapi61=sacapi61;}
public void setSacapi91(double sacapi91) { sqlMaker.setField("sacapi91",""+sacapi91,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getSacapi91()!=sacapi91) cf.add("sacapi91",this.sacapi91+"",sacapi91+""); } this.sacapi91=sacapi91;}
public void setPri_past_ov_180_da(double pri_past_ov_180_da) { sqlMaker.setField("pri_past_ov_180_da",""+pri_past_ov_180_da,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getPri_past_ov_180_da()!=pri_past_ov_180_da) cf.add("pri_past_ov_180_da",this.pri_past_ov_180_da+"",pri_past_ov_180_da+""); } this.pri_past_ov_180_da=pri_past_ov_180_da;}
public void setNum_of_time_dq(int num_of_time_dq) { sqlMaker.setField("num_of_time_dq",""+num_of_time_dq,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getNum_of_time_dq()!=num_of_time_dq) cf.add("num_of_time_dq",this.num_of_time_dq+"",num_of_time_dq+""); } this.num_of_time_dq=num_of_time_dq;}
public void setCurr_mth_pay_statu(String curr_mth_pay_statu) { sqlMaker.setField("curr_mth_pay_statu",curr_mth_pay_statu,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCurr_mth_pay_statu().equals(curr_mth_pay_statu)) cf.add("curr_mth_pay_statu",this.curr_mth_pay_statu,curr_mth_pay_statu); } this.curr_mth_pay_statu=curr_mth_pay_statu;}
public void setRt_num_due_seq(int rt_num_due_seq) { sqlMaker.setField("rt_num_due_seq",""+rt_num_due_seq,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRt_num_due_seq()!=rt_num_due_seq) cf.add("rt_num_due_seq",this.rt_num_due_seq+"",rt_num_due_seq+""); } this.rt_num_due_seq=rt_num_due_seq;}
public void setDu_pmt_rem(double du_pmt_rem) { sqlMaker.setField("du_pmt_rem",""+du_pmt_rem,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getDu_pmt_rem()!=du_pmt_rem) cf.add("du_pmt_rem",this.du_pmt_rem+"",du_pmt_rem+""); } this.du_pmt_rem=du_pmt_rem;}
public void setAc_accr_bal(double ac_accr_bal) { sqlMaker.setField("ac_accr_bal",""+ac_accr_bal,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getAc_accr_bal()!=ac_accr_bal) cf.add("ac_accr_bal",this.ac_accr_bal+"",ac_accr_bal+""); } this.ac_accr_bal=ac_accr_bal;}
public void setRt_sold_ind(String rt_sold_ind) { sqlMaker.setField("rt_sold_ind",rt_sold_ind,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRt_sold_ind().equals(rt_sold_ind)) cf.add("rt_sold_ind",this.rt_sold_ind,rt_sold_ind); } this.rt_sold_ind=rt_sold_ind;}
public void setRt_sold_cd(String rt_sold_cd) { sqlMaker.setField("rt_sold_cd",rt_sold_cd,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRt_sold_cd().equals(rt_sold_cd)) cf.add("rt_sold_cd",this.rt_sold_cd,rt_sold_cd); } this.rt_sold_cd=rt_sold_cd;}
public void setInt_past_01_60_day(double int_past_01_60_day) { sqlMaker.setField("int_past_01_60_day",""+int_past_01_60_day,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getInt_past_01_60_day()!=int_past_01_60_day) cf.add("int_past_01_60_day",this.int_past_01_60_day+"",int_past_01_60_day+""); } this.int_past_01_60_day=int_past_01_60_day;}
public void setInt_past_31_60_day(double int_past_31_60_day) { sqlMaker.setField("int_past_31_60_day",""+int_past_31_60_day,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getInt_past_31_60_day()!=int_past_31_60_day) cf.add("int_past_31_60_day",this.int_past_31_60_day+"",int_past_31_60_day+""); } this.int_past_31_60_day=int_past_31_60_day;}
public void setInt_past_61_90_day(double int_past_61_90_day) { sqlMaker.setField("int_past_61_90_day",""+int_past_61_90_day,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getInt_past_61_90_day()!=int_past_61_90_day) cf.add("int_past_61_90_day",this.int_past_61_90_day+"",int_past_61_90_day+""); } this.int_past_61_90_day=int_past_61_90_day;}
public void setInt_past_91_180_da(double int_past_91_180_da) { sqlMaker.setField("int_past_91_180_da",""+int_past_91_180_da,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getInt_past_91_180_da()!=int_past_91_180_da) cf.add("int_past_91_180_da",this.int_past_91_180_da+"",int_past_91_180_da+""); } this.int_past_91_180_da=int_past_91_180_da;}
public void setInt_past_ov_180_da(double int_past_ov_180_da) { sqlMaker.setField("int_past_ov_180_da",""+int_past_ov_180_da,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getInt_past_ov_180_da()!=int_past_ov_180_da) cf.add("int_past_ov_180_da",this.int_past_ov_180_da+"",int_past_ov_180_da+""); } this.int_past_ov_180_da=int_past_ov_180_da;}
public void setZm_memo2_amt02_0(double zm_memo2_amt02_0) { sqlMaker.setField("zm_memo2_amt02_0",""+zm_memo2_amt02_0,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getZm_memo2_amt02_0()!=zm_memo2_amt02_0) cf.add("zm_memo2_amt02_0",this.zm_memo2_amt02_0+"",zm_memo2_amt02_0+""); } this.zm_memo2_amt02_0=zm_memo2_amt02_0;}
public void setZm_memo2_amt02_1(double zm_memo2_amt02_1) { sqlMaker.setField("zm_memo2_amt02_1",""+zm_memo2_amt02_1,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getZm_memo2_amt02_1()!=zm_memo2_amt02_1) cf.add("zm_memo2_amt02_1",this.zm_memo2_amt02_1+"",zm_memo2_amt02_1+""); } this.zm_memo2_amt02_1=zm_memo2_amt02_1;}
public void setDu_pmt_bill_0(double du_pmt_bill_0) { sqlMaker.setField("du_pmt_bill_0",""+du_pmt_bill_0,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getDu_pmt_bill_0()!=du_pmt_bill_0) cf.add("du_pmt_bill_0",this.du_pmt_bill_0+"",du_pmt_bill_0+""); } this.du_pmt_bill_0=du_pmt_bill_0;}
public void setDu_pmt_bill_1(double du_pmt_bill_1) { sqlMaker.setField("du_pmt_bill_1",""+du_pmt_bill_1,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getDu_pmt_bill_1()!=du_pmt_bill_1) cf.add("du_pmt_bill_1",this.du_pmt_bill_1+"",du_pmt_bill_1+""); } this.du_pmt_bill_1=du_pmt_bill_1;}
public void setAc_accr_mtd(double ac_accr_mtd) { sqlMaker.setField("ac_accr_mtd",""+ac_accr_mtd,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getAc_accr_mtd()!=ac_accr_mtd) cf.add("ac_accr_mtd",this.ac_accr_mtd+"",ac_accr_mtd+""); } this.ac_accr_mtd=ac_accr_mtd;}
public void setCm_cmt_num(String cm_cmt_num) { sqlMaker.setField("cm_cmt_num",cm_cmt_num,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCm_cmt_num().equals(cm_cmt_num)) cf.add("cm_cmt_num",this.cm_cmt_num,cm_cmt_num); } this.cm_cmt_num=cm_cmt_num;}
public void setZm_pkg_loan_nbr(String zm_pkg_loan_nbr) { sqlMaker.setField("zm_pkg_loan_nbr",zm_pkg_loan_nbr,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getZm_pkg_loan_nbr().equals(zm_pkg_loan_nbr)) cf.add("zm_pkg_loan_nbr",this.zm_pkg_loan_nbr,zm_pkg_loan_nbr); } this.zm_pkg_loan_nbr=zm_pkg_loan_nbr;}
public void setZm_pmt_seq_nbr(String zm_pmt_seq_nbr) { sqlMaker.setField("zm_pmt_seq_nbr",zm_pmt_seq_nbr,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getZm_pmt_seq_nbr().equals(zm_pmt_seq_nbr)) cf.add("zm_pmt_seq_nbr",this.zm_pmt_seq_nbr,zm_pmt_seq_nbr); } this.zm_pmt_seq_nbr=zm_pmt_seq_nbr;}
public void setRt_orig_procd_amt(double rt_orig_procd_amt) { sqlMaker.setField("rt_orig_procd_amt",""+rt_orig_procd_amt,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRt_orig_procd_amt()!=rt_orig_procd_amt) cf.add("rt_orig_procd_amt",this.rt_orig_procd_amt+"",rt_orig_procd_amt+""); } this.rt_orig_procd_amt=rt_orig_procd_amt;}
public void setRt_term_freq(String rt_term_freq) { sqlMaker.setField("rt_term_freq",rt_term_freq,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRt_term_freq().equals(rt_term_freq)) cf.add("rt_term_freq",this.rt_term_freq,rt_term_freq); } this.rt_term_freq=rt_term_freq;}
public void setRt_term_incr(int rt_term_incr) { sqlMaker.setField("rt_term_incr",""+rt_term_incr,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRt_term_incr()!=rt_term_incr) cf.add("rt_term_incr",this.rt_term_incr+"",rt_term_incr+""); } this.rt_term_incr=rt_term_incr;}
public void setRt_actl_pmts_rem(int rt_actl_pmts_rem) { sqlMaker.setField("rt_actl_pmts_rem",""+rt_actl_pmts_rem,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRt_actl_pmts_rem()!=rt_actl_pmts_rem) cf.add("rt_actl_pmts_rem",this.rt_actl_pmts_rem+"",rt_actl_pmts_rem+""); } this.rt_actl_pmts_rem=rt_actl_pmts_rem;}
public void setRt_frst_due_date(String rt_frst_due_date) { sqlMaker.setField("rt_frst_due_date",rt_frst_due_date,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRt_frst_due_date().equals(rt_frst_due_date)) cf.add("rt_frst_due_date",this.rt_frst_due_date,rt_frst_due_date); } this.rt_frst_due_date=rt_frst_due_date;}
public void setPoff_date(String poff_date) { sqlMaker.setField("poff_date",poff_date,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getPoff_date().equals(poff_date)) cf.add("poff_date",this.poff_date,poff_date); } this.poff_date=poff_date;}
public void setInt_dis_rate(double int_dis_rate) { sqlMaker.setField("int_dis_rate",""+int_dis_rate,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getInt_dis_rate()!=int_dis_rate) cf.add("int_dis_rate",this.int_dis_rate+"",int_dis_rate+""); } this.int_dis_rate=int_dis_rate;}
public void setInt_dis_end_dt(String int_dis_end_dt) { sqlMaker.setField("int_dis_end_dt",int_dis_end_dt,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getInt_dis_end_dt().equals(int_dis_end_dt)) cf.add("int_dis_end_dt",this.int_dis_end_dt,int_dis_end_dt); } this.int_dis_end_dt=int_dis_end_dt;}
public void setZm_aflc_code(String zm_aflc_code) { sqlMaker.setField("zm_aflc_code",zm_aflc_code,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getZm_aflc_code().equals(zm_aflc_code)) cf.add("zm_aflc_code",this.zm_aflc_code,zm_aflc_code); } this.zm_aflc_code=zm_aflc_code;}
public void setZm_adj_penalty_int(double zm_adj_penalty_int) { sqlMaker.setField("zm_adj_penalty_int",""+zm_adj_penalty_int,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getZm_adj_penalty_int()!=zm_adj_penalty_int) cf.add("zm_adj_penalty_int",this.zm_adj_penalty_int+"",zm_adj_penalty_int+""); } this.zm_adj_penalty_int=zm_adj_penalty_int;}
public void setZm_adj_penalty_pri(double zm_adj_penalty_pri) { sqlMaker.setField("zm_adj_penalty_pri",""+zm_adj_penalty_pri,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getZm_adj_penalty_pri()!=zm_adj_penalty_pri) cf.add("zm_adj_penalty_pri",this.zm_adj_penalty_pri+"",zm_adj_penalty_pri+""); } this.zm_adj_penalty_pri=zm_adj_penalty_pri;}
public void setBd_nxt_due_date_0(String bd_nxt_due_date_0) { sqlMaker.setField("bd_nxt_due_date_0",bd_nxt_due_date_0,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getBd_nxt_due_date_0().equals(bd_nxt_due_date_0)) cf.add("bd_nxt_due_date_0",this.bd_nxt_due_date_0,bd_nxt_due_date_0); } this.bd_nxt_due_date_0=bd_nxt_due_date_0;}
public void setBd_nxt_due_date_2(String bd_nxt_due_date_2) { sqlMaker.setField("bd_nxt_due_date_2",bd_nxt_due_date_2,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getBd_nxt_due_date_2().equals(bd_nxt_due_date_2)) cf.add("bd_nxt_due_date_2",this.bd_nxt_due_date_2,bd_nxt_due_date_2); } this.bd_nxt_due_date_2=bd_nxt_due_date_2;}
public void setDq_grace_days(int dq_grace_days) { sqlMaker.setField("dq_grace_days",""+dq_grace_days,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getDq_grace_days()!=dq_grace_days) cf.add("dq_grace_days",this.dq_grace_days+"",dq_grace_days+""); } this.dq_grace_days=dq_grace_days;}
public void setAc_accr_itd(double ac_accr_itd) { sqlMaker.setField("ac_accr_itd",""+ac_accr_itd,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getAc_accr_itd()!=ac_accr_itd) cf.add("ac_accr_itd",this.ac_accr_itd+"",ac_accr_itd+""); } this.ac_accr_itd=ac_accr_itd;}
public void setDq_hist_day_ctr(int dq_hist_day_ctr) { sqlMaker.setField("dq_hist_day_ctr",""+dq_hist_day_ctr,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getDq_hist_day_ctr()!=dq_hist_day_ctr) cf.add("dq_hist_day_ctr",this.dq_hist_day_ctr+"",dq_hist_day_ctr+""); } this.dq_hist_day_ctr=dq_hist_day_ctr;}
public void setDq_num_pmts_pdue(int dq_num_pmts_pdue) { sqlMaker.setField("dq_num_pmts_pdue",""+dq_num_pmts_pdue,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getDq_num_pmts_pdue()!=dq_num_pmts_pdue) cf.add("dq_num_pmts_pdue",this.dq_num_pmts_pdue+"",dq_num_pmts_pdue+""); } this.dq_num_pmts_pdue=dq_num_pmts_pdue;}
public void setRt_user_grp3(String rt_user_grp3) { sqlMaker.setField("rt_user_grp3",rt_user_grp3,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRt_user_grp3().equals(rt_user_grp3)) cf.add("rt_user_grp3",this.rt_user_grp3,rt_user_grp3); } this.rt_user_grp3=rt_user_grp3;}
public void setRt_user_grp9(String rt_user_grp9) { sqlMaker.setField("rt_user_grp9",rt_user_grp9,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRt_user_grp9().equals(rt_user_grp9)) cf.add("rt_user_grp9",this.rt_user_grp9,rt_user_grp9); } this.rt_user_grp9=rt_user_grp9;}
public void setRt_user_amt1(double rt_user_amt1) { sqlMaker.setField("rt_user_amt1",""+rt_user_amt1,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRt_user_amt1()!=rt_user_amt1) cf.add("rt_user_amt1",this.rt_user_amt1+"",rt_user_amt1+""); } this.rt_user_amt1=rt_user_amt1;}
public void setRt_user_amt2(double rt_user_amt2) { sqlMaker.setField("rt_user_amt2",""+rt_user_amt2,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRt_user_amt2()!=rt_user_amt2) cf.add("rt_user_amt2",this.rt_user_amt2+"",rt_user_amt2+""); } this.rt_user_amt2=rt_user_amt2;}
public void setRt_sngl_balloon_cd(String rt_sngl_balloon_cd) { sqlMaker.setField("rt_sngl_balloon_cd",rt_sngl_balloon_cd,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRt_sngl_balloon_cd().equals(rt_sngl_balloon_cd)) cf.add("rt_sngl_balloon_cd",this.rt_sngl_balloon_cd,rt_sngl_balloon_cd); } this.rt_sngl_balloon_cd=rt_sngl_balloon_cd;}
public void setBl_lead_days(int bl_lead_days) { sqlMaker.setField("bl_lead_days",""+bl_lead_days,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getBl_lead_days()!=bl_lead_days) cf.add("bl_lead_days",this.bl_lead_days+"",bl_lead_days+""); } this.bl_lead_days=bl_lead_days;}
public void setBd_meth(String bd_meth) { sqlMaker.setField("bd_meth",bd_meth,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getBd_meth().equals(bd_meth)) cf.add("bd_meth",this.bd_meth,bd_meth); } this.bd_meth=bd_meth;}
public void setBd_bill_type(String bd_bill_type) { sqlMaker.setField("bd_bill_type",bd_bill_type,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getBd_bill_type().equals(bd_bill_type)) cf.add("bd_bill_type",this.bd_bill_type,bd_bill_type); } this.bd_bill_type=bd_bill_type;}
public void setSe_sale_num(String se_sale_num) { sqlMaker.setField("se_sale_num",se_sale_num,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSe_sale_num().equals(se_sale_num)) cf.add("se_sale_num",this.se_sale_num,se_sale_num); } this.se_sale_num=se_sale_num;}
public void setRt_se_commit_date(String rt_se_commit_date) { sqlMaker.setField("rt_se_commit_date",rt_se_commit_date,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRt_se_commit_date().equals(rt_se_commit_date)) cf.add("rt_se_commit_date",this.rt_se_commit_date,rt_se_commit_date); } this.rt_se_commit_date=rt_se_commit_date;}
public void setRt_pool_cd(String rt_pool_cd) { sqlMaker.setField("rt_pool_cd",rt_pool_cd,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRt_pool_cd().equals(rt_pool_cd)) cf.add("rt_pool_cd",this.rt_pool_cd,rt_pool_cd); } this.rt_pool_cd=rt_pool_cd;}
public void setSe_sale_date(String se_sale_date) { sqlMaker.setField("se_sale_date",se_sale_date,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSe_sale_date().equals(se_sale_date)) cf.add("se_sale_date",this.se_sale_date,se_sale_date); } this.se_sale_date=se_sale_date;}
public void setZmepoffpctu(double zmepoffpctu) { sqlMaker.setField("zmepoffpctu",""+zmepoffpctu,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getZmepoffpctu()!=zmepoffpctu) cf.add("zmepoffpctu",this.zmepoffpctu+"",zmepoffpctu+""); } this.zmepoffpctu=zmepoffpctu;}
public void setRtorigcmamt(double rtorigcmamt) { sqlMaker.setField("rtorigcmamt",""+rtorigcmamt,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRtorigcmamt()!=rtorigcmamt) cf.add("rtorigcmamt",this.rtorigcmamt+"",rtorigcmamt+""); } this.rtorigcmamt=rtorigcmamt;}
public void setAction_flag(String action_flag) { sqlMaker.setField("action_flag",action_flag,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getAction_flag().equals(action_flag)) cf.add("action_flag",this.action_flag,action_flag); } this.action_flag=action_flag;}
public void setSlsccd(String slsccd) { sqlMaker.setField("slsccd",slsccd,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSlsccd().equals(slsccd)) cf.add("slsccd",this.slsccd,slsccd); } this.slsccd=slsccd;}
public void setCm_mult_adv_ind(String cm_mult_adv_ind) { sqlMaker.setField("cm_mult_adv_ind",cm_mult_adv_ind,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCm_mult_adv_ind().equals(cm_mult_adv_ind)) cf.add("cm_mult_adv_ind",this.cm_mult_adv_ind,cm_mult_adv_ind); } this.cm_mult_adv_ind=cm_mult_adv_ind;}
public void setZm_ful_par_pmt(String zm_ful_par_pmt) { sqlMaker.setField("zm_ful_par_pmt",zm_ful_par_pmt,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getZm_ful_par_pmt().equals(zm_ful_par_pmt)) cf.add("zm_ful_par_pmt",this.zm_ful_par_pmt,zm_ful_par_pmt); } this.zm_ful_par_pmt=zm_ful_par_pmt;}
public void setCf_addr_num(String cf_addr_num) { sqlMaker.setField("cf_addr_num",cf_addr_num,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCf_addr_num().equals(cf_addr_num)) cf.add("cf_addr_num",this.cf_addr_num,cf_addr_num); } this.cf_addr_num=cf_addr_num;}
public void setSl_guar_agency_cd(String sl_guar_agency_cd) { sqlMaker.setField("sl_guar_agency_cd",sl_guar_agency_cd,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSl_guar_agency_cd().equals(sl_guar_agency_cd)) cf.add("sl_guar_agency_cd",this.sl_guar_agency_cd,sl_guar_agency_cd); } this.sl_guar_agency_cd=sl_guar_agency_cd;}
public void setBa_curr_cm_amt(double ba_curr_cm_amt) { sqlMaker.setField("ba_curr_cm_amt",""+ba_curr_cm_amt,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getBa_curr_cm_amt()!=ba_curr_cm_amt) cf.add("ba_curr_cm_amt",this.ba_curr_cm_amt+"",ba_curr_cm_amt+""); } this.ba_curr_cm_amt=ba_curr_cm_amt;}
public void setAvailable_amt(double available_amt) { sqlMaker.setField("available_amt",""+available_amt,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getAvailable_amt()!=available_amt) cf.add("available_amt",this.available_amt+"",available_amt+""); } this.available_amt=available_amt;}
public void setRt_date_lst_maint(String rt_date_lst_maint) { sqlMaker.setField("rt_date_lst_maint",rt_date_lst_maint,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRt_date_lst_maint().equals(rt_date_lst_maint)) cf.add("rt_date_lst_maint",this.rt_date_lst_maint,rt_date_lst_maint); } this.rt_date_lst_maint=rt_date_lst_maint;}
public void setTot_pri_payment_amt(double tot_pri_payment_amt) { sqlMaker.setField("tot_pri_payment_amt",""+tot_pri_payment_amt,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getTot_pri_payment_amt()!=tot_pri_payment_amt) cf.add("tot_pri_payment_amt",this.tot_pri_payment_amt+"",tot_pri_payment_amt+""); } this.tot_pri_payment_amt=tot_pri_payment_amt;}
public void setZm_memo2_amt02_2(double zm_memo2_amt02_2) { sqlMaker.setField("zm_memo2_amt02_2",""+zm_memo2_amt02_2,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getZm_memo2_amt02_2()!=zm_memo2_amt02_2) cf.add("zm_memo2_amt02_2",this.zm_memo2_amt02_2+"",zm_memo2_amt02_2+""); } this.zm_memo2_amt02_2=zm_memo2_amt02_2;}
public void setZm_memo2_amt02_3(double zm_memo2_amt02_3) { sqlMaker.setField("zm_memo2_amt02_3",""+zm_memo2_amt02_3,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getZm_memo2_amt02_3()!=zm_memo2_amt02_3) cf.add("zm_memo2_amt02_3",this.zm_memo2_amt02_3+"",zm_memo2_amt02_3+""); } this.zm_memo2_amt02_3=zm_memo2_amt02_3;}
public void setLn_arfn_int(double ln_arfn_int) { sqlMaker.setField("ln_arfn_int",""+ln_arfn_int,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getLn_arfn_int()!=ln_arfn_int) cf.add("ln_arfn_int",this.ln_arfn_int+"",ln_arfn_int+""); } this.ln_arfn_int=ln_arfn_int;}
public void setZm_memo2_amt02_4(double zm_memo2_amt02_4) { sqlMaker.setField("zm_memo2_amt02_4",""+zm_memo2_amt02_4,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getZm_memo2_amt02_4()!=zm_memo2_amt02_4) cf.add("zm_memo2_amt02_4",this.zm_memo2_amt02_4+"",zm_memo2_amt02_4+""); } this.zm_memo2_amt02_4=zm_memo2_amt02_4;}
public void setZm_memo2_amt02_6(double zm_memo2_amt02_6) { sqlMaker.setField("zm_memo2_amt02_6",""+zm_memo2_amt02_6,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getZm_memo2_amt02_6()!=zm_memo2_amt02_6) cf.add("zm_memo2_amt02_6",this.zm_memo2_amt02_6+"",zm_memo2_amt02_6+""); } this.zm_memo2_amt02_6=zm_memo2_amt02_6;}
public void setRecooperinte(double recooperinte) { sqlMaker.setField("recooperinte",""+recooperinte,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRecooperinte()!=recooperinte) cf.add("recooperinte",this.recooperinte+"",recooperinte+""); } this.recooperinte=recooperinte;}
public void setZm_memo2_amt02_21(double zm_memo2_amt02_21) { sqlMaker.setField("zm_memo2_amt02_21",""+zm_memo2_amt02_21,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getZm_memo2_amt02_21()!=zm_memo2_amt02_21) cf.add("zm_memo2_amt02_21",this.zm_memo2_amt02_21+"",zm_memo2_amt02_21+""); } this.zm_memo2_amt02_21=zm_memo2_amt02_21;}
public void setRt_curr_due_amt(double rt_curr_due_amt) { sqlMaker.setField("rt_curr_due_amt",""+rt_curr_due_amt,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getRt_curr_due_amt()!=rt_curr_due_amt) cf.add("rt_curr_due_amt",this.rt_curr_due_amt+"",rt_curr_due_amt+""); } this.rt_curr_due_amt=rt_curr_due_amt;}
public void setRt_coff_date(String rt_coff_date) { sqlMaker.setField("rt_coff_date",rt_coff_date,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRt_coff_date().equals(rt_coff_date)) cf.add("rt_coff_date",this.rt_coff_date,rt_coff_date); } this.rt_coff_date=rt_coff_date;}
public void setFiller(String filler) { sqlMaker.setField("filler",filler,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getFiller().equals(filler)) cf.add("filler",this.filler,filler); } this.filler=filler;}
public void init(int i,ActionRequest actionRequest) throws Exception { if ( actionRequest.getFieldValue(i,"rt_ctl1") !=null ) {this.setRt_ctl1(actionRequest.getFieldValue(i,"rt_ctl1"));}
if ( actionRequest.getFieldValue(i,"rtctl2") !=null ) {this.setRtctl2(actionRequest.getFieldValue(i,"rtctl2"));}
if ( actionRequest.getFieldValue(i,"rt_ctl3") !=null ) {this.setRt_ctl3(actionRequest.getFieldValue(i,"rt_ctl3"));}
if ( actionRequest.getFieldValue(i,"rtctl4") !=null ) {this.setRtctl4(actionRequest.getFieldValue(i,"rtctl4"));}
if ( actionRequest.getFieldValue(i,"ln_acct_no") !=null ) {this.setLn_acct_no(actionRequest.getFieldValue(i,"ln_acct_no"));}
if ( actionRequest.getFieldValue(i,"ods_src_dt") !=null ) {this.setOds_src_dt(actionRequest.getFieldValue(i,"ods_src_dt"));}
if ( actionRequest.getFieldValue(i,"zm_notes_1") !=null ) {this.setZm_notes_1(actionRequest.getFieldValue(i,"zm_notes_1"));}
if ( actionRequest.getFieldValue(i,"mi_set_acct_num") !=null ) {this.setMi_set_acct_num(actionRequest.getFieldValue(i,"mi_set_acct_num"));}
if ( actionRequest.getFieldValue(i,"curr_cd") !=null ) {this.setCurr_cd(actionRequest.getFieldValue(i,"curr_cd"));}
if ( actionRequest.getFieldValue(i,"zm_desc_15_1") !=null ) {this.setZm_desc_15_1(actionRequest.getFieldValue(i,"zm_desc_15_1"));}
if ( actionRequest.getFieldValue(i,"cust_name") !=null ) {this.setCust_name(actionRequest.getFieldValue(i,"cust_name"));}
if ( actionRequest.getFieldValue(i,"rt_acct_prod") !=null ) {this.setRt_acct_prod(actionRequest.getFieldValue(i,"rt_acct_prod"));}
if ( actionRequest.getFieldValue(i,"ins_type") !=null ) {this.setIns_type(actionRequest.getFieldValue(i,"ins_type"));}
if ( actionRequest.getFieldValue(i,"insurance_num") !=null ) {this.setInsurance_num(actionRequest.getFieldValue(i,"insurance_num"));}
if ( actionRequest.getFieldValue(i,"acct_stat") !=null ) {this.setAcct_stat(actionRequest.getFieldValue(i,"acct_stat"));}
if ( actionRequest.getFieldValue(i,"coll_type_1_flag") !=null ) {this.setColl_type_1_flag(actionRequest.getFieldValue(i,"coll_type_1_flag"));}
if ( actionRequest.getFieldValue(i,"coll_type_2_flag") !=null ) {this.setColl_type_2_flag(actionRequest.getFieldValue(i,"coll_type_2_flag"));}
if ( actionRequest.getFieldValue(i,"guarantor_flag") !=null ) {this.setGuarantor_flag(actionRequest.getFieldValue(i,"guarantor_flag"));}
if ( actionRequest.getFieldValue(i,"per_credit_flag") !=null ) {this.setPer_credit_flag(actionRequest.getFieldValue(i,"per_credit_flag"));}
if ( actionRequest.getFieldValue(i,"is_cover_amt") !=null && actionRequest.getFieldValue(i,"is_cover_amt").trim().length() > 0 ) {this.setIs_cover_amt(Double.parseDouble(actionRequest.getFieldValue(i,"is_cover_amt")));}
if ( actionRequest.getFieldValue(i,"insurance_company_name") !=null ) {this.setInsurance_company_name(actionRequest.getFieldValue(i,"insurance_company_name"));}
if ( actionRequest.getFieldValue(i,"is_agent_name") !=null ) {this.setIs_agent_name(actionRequest.getFieldValue(i,"is_agent_name"));}
if ( actionRequest.getFieldValue(i,"is_user_desc1") !=null ) {this.setIs_user_desc1(actionRequest.getFieldValue(i,"is_user_desc1"));}
if ( actionRequest.getFieldValue(i,"is_user_desc2") !=null ) {this.setIs_user_desc2(actionRequest.getFieldValue(i,"is_user_desc2"));}
if ( actionRequest.getFieldValue(i,"pay_type") !=null ) {this.setPay_type(actionRequest.getFieldValue(i,"pay_type"));}
if ( actionRequest.getFieldValue(i,"mi_pay_acct_1") !=null ) {this.setMi_pay_acct_1(actionRequest.getFieldValue(i,"mi_pay_acct_1"));}
if ( actionRequest.getFieldValue(i,"mi_pay_acct_2") !=null ) {this.setMi_pay_acct_2(actionRequest.getFieldValue(i,"mi_pay_acct_2"));}
if ( actionRequest.getFieldValue(i,"mi_pay_acct_3") !=null ) {this.setMi_pay_acct_3(actionRequest.getFieldValue(i,"mi_pay_acct_3"));}
if ( actionRequest.getFieldValue(i,"mi_pay_acct_4") !=null ) {this.setMi_pay_acct_4(actionRequest.getFieldValue(i,"mi_pay_acct_4"));}
if ( actionRequest.getFieldValue(i,"mi_pay_acct_5") !=null ) {this.setMi_pay_acct_5(actionRequest.getFieldValue(i,"mi_pay_acct_5"));}
if ( actionRequest.getFieldValue(i,"rt_proc_type") !=null ) {this.setRt_proc_type(actionRequest.getFieldValue(i,"rt_proc_type"));}
if ( actionRequest.getFieldValue(i,"mi_auto_prin_flag") !=null ) {this.setMi_auto_prin_flag(actionRequest.getFieldValue(i,"mi_auto_prin_flag"));}
if ( actionRequest.getFieldValue(i,"mi_auto_int_flag") !=null ) {this.setMi_auto_int_flag(actionRequest.getFieldValue(i,"mi_auto_int_flag"));}
if ( actionRequest.getFieldValue(i,"cust_open_dt") !=null ) {this.setCust_open_dt(actionRequest.getFieldValue(i,"cust_open_dt"));}
if ( actionRequest.getFieldValue(i,"expiring_dt") !=null ) {this.setExpiring_dt(actionRequest.getFieldValue(i,"expiring_dt"));}
if ( actionRequest.getFieldValue(i,"rt_num_pmts_made") !=null && actionRequest.getFieldValue(i,"rt_num_pmts_made").trim().length() > 0 ) {this.setRt_num_pmts_made(Integer.parseInt(actionRequest.getFieldValue(i,"rt_num_pmts_made")));}
if ( actionRequest.getFieldValue(i,"curr_pmt_num") !=null && actionRequest.getFieldValue(i,"curr_pmt_num").trim().length() > 0 ) {this.setCurr_pmt_num(Integer.parseInt(actionRequest.getFieldValue(i,"curr_pmt_num")));}
if ( actionRequest.getFieldValue(i,"ln_totl_prd") !=null && actionRequest.getFieldValue(i,"ln_totl_prd").trim().length() > 0 ) {this.setLn_totl_prd(Integer.parseInt(actionRequest.getFieldValue(i,"ln_totl_prd")));}
if ( actionRequest.getFieldValue(i,"rt_orig_loan_amt") !=null && actionRequest.getFieldValue(i,"rt_orig_loan_amt").trim().length() > 0 ) {this.setRt_orig_loan_amt(Double.parseDouble(actionRequest.getFieldValue(i,"rt_orig_loan_amt")));}
if ( actionRequest.getFieldValue(i,"cumulative_payout_amt") !=null && actionRequest.getFieldValue(i,"cumulative_payout_amt").trim().length() > 0 ) {this.setCumulative_payout_amt(Double.parseDouble(actionRequest.getFieldValue(i,"cumulative_payout_amt")));}
if ( actionRequest.getFieldValue(i,"num_day_interval") !=null && actionRequest.getFieldValue(i,"num_day_interval").trim().length() > 0 ) {this.setNum_day_interval(Integer.parseInt(actionRequest.getFieldValue(i,"num_day_interval")));}
if ( actionRequest.getFieldValue(i,"prin_num_day_inter") !=null && actionRequest.getFieldValue(i,"prin_num_day_inter").trim().length() > 0 ) {this.setPrin_num_day_inter(Integer.parseInt(actionRequest.getFieldValue(i,"prin_num_day_inter")));}
if ( actionRequest.getFieldValue(i,"int_num_day_interv") !=null && actionRequest.getFieldValue(i,"int_num_day_interv").trim().length() > 0 ) {this.setInt_num_day_interv(Integer.parseInt(actionRequest.getFieldValue(i,"int_num_day_interv")));}
if ( actionRequest.getFieldValue(i,"bl_flat_amt") !=null && actionRequest.getFieldValue(i,"bl_flat_amt").trim().length() > 0 ) {this.setBl_flat_amt(Double.parseDouble(actionRequest.getFieldValue(i,"bl_flat_amt")));}
if ( actionRequest.getFieldValue(i,"tot_pay_amt") !=null && actionRequest.getFieldValue(i,"tot_pay_amt").trim().length() > 0 ) {this.setTot_pay_amt(Double.parseDouble(actionRequest.getFieldValue(i,"tot_pay_amt")));}
if ( actionRequest.getFieldValue(i,"progressive_intv") !=null && actionRequest.getFieldValue(i,"progressive_intv").trim().length() > 0 ) {this.setProgressive_intv(Integer.parseInt(actionRequest.getFieldValue(i,"progressive_intv")));}
if ( actionRequest.getFieldValue(i,"progressive_addt_a") !=null && actionRequest.getFieldValue(i,"progressive_addt_a").trim().length() > 0 ) {this.setProgressive_addt_a(Double.parseDouble(actionRequest.getFieldValue(i,"progressive_addt_a")));}
if ( actionRequest.getFieldValue(i,"lst_progressive_da") !=null ) {this.setLst_progressive_da(actionRequest.getFieldValue(i,"lst_progressive_da"));}
if ( actionRequest.getFieldValue(i,"entruster_fund_acc") !=null ) {this.setEntruster_fund_acc(actionRequest.getFieldValue(i,"entruster_fund_acc"));}
if ( actionRequest.getFieldValue(i,"entruster_sav_acct") !=null ) {this.setEntruster_sav_acct(actionRequest.getFieldValue(i,"entruster_sav_acct"));}
if ( actionRequest.getFieldValue(i,"bal_of_out_int") !=null && actionRequest.getFieldValue(i,"bal_of_out_int").trim().length() > 0 ) {this.setBal_of_out_int(Double.parseDouble(actionRequest.getFieldValue(i,"bal_of_out_int")));}
if ( actionRequest.getFieldValue(i,"int_rec_acc") !=null && actionRequest.getFieldValue(i,"int_rec_acc").trim().length() > 0 ) {this.setInt_rec_acc(Double.parseDouble(actionRequest.getFieldValue(i,"int_rec_acc")));}
if ( actionRequest.getFieldValue(i,"acct_open_date") !=null ) {this.setAcct_open_date(actionRequest.getFieldValue(i,"acct_open_date"));}
if ( actionRequest.getFieldValue(i,"rt_list_pmt_date") !=null ) {this.setRt_list_pmt_date(actionRequest.getFieldValue(i,"rt_list_pmt_date"));}
if ( actionRequest.getFieldValue(i,"ac_start_date") !=null ) {this.setAc_start_date(actionRequest.getFieldValue(i,"ac_start_date"));}
if ( actionRequest.getFieldValue(i,"acct_mark") !=null ) {this.setAcct_mark(actionRequest.getFieldValue(i,"acct_mark"));}
if ( actionRequest.getFieldValue(i,"cust_no") !=null ) {this.setCust_no(actionRequest.getFieldValue(i,"cust_no"));}
if ( actionRequest.getFieldValue(i,"zipcode") !=null ) {this.setZipcode(actionRequest.getFieldValue(i,"zipcode"));}
if ( actionRequest.getFieldValue(i,"customer_address") !=null ) {this.setCustomer_address(actionRequest.getFieldValue(i,"customer_address"));}
if ( actionRequest.getFieldValue(i,"cont_tele") !=null ) {this.setCont_tele(actionRequest.getFieldValue(i,"cont_tele"));}
if ( actionRequest.getFieldValue(i,"cf_bus_phone_data") !=null ) {this.setCf_bus_phone_data(actionRequest.getFieldValue(i,"cf_bus_phone_data"));}
if ( actionRequest.getFieldValue(i,"auto_credit_acct") !=null ) {this.setAuto_credit_acct(actionRequest.getFieldValue(i,"auto_credit_acct"));}
if ( actionRequest.getFieldValue(i,"ln_intr_adj_sty") !=null ) {this.setLn_intr_adj_sty(actionRequest.getFieldValue(i,"ln_intr_adj_sty"));}
if ( actionRequest.getFieldValue(i,"rt_loan_rate") !=null && actionRequest.getFieldValue(i,"rt_loan_rate").trim().length() > 0 ) {this.setRt_loan_rate(Double.parseDouble(actionRequest.getFieldValue(i,"rt_loan_rate")));}
if ( actionRequest.getFieldValue(i,"ra_pct1") !=null && actionRequest.getFieldValue(i,"ra_pct1").trim().length() > 0 ) {this.setRa_pct1(Double.parseDouble(actionRequest.getFieldValue(i,"ra_pct1")));}
if ( actionRequest.getFieldValue(i,"ac_rate") !=null && actionRequest.getFieldValue(i,"ac_rate").trim().length() > 0 ) {this.setAc_rate(Double.parseDouble(actionRequest.getFieldValue(i,"ac_rate")));}
if ( actionRequest.getFieldValue(i,"time_of_dq") !=null && actionRequest.getFieldValue(i,"time_of_dq").trim().length() > 0 ) {this.setTime_of_dq(Integer.parseInt(actionRequest.getFieldValue(i,"time_of_dq")));}
if ( actionRequest.getFieldValue(i,"bal_normal_prin") !=null && actionRequest.getFieldValue(i,"bal_normal_prin").trim().length() > 0 ) {this.setBal_normal_prin(Double.parseDouble(actionRequest.getFieldValue(i,"bal_normal_prin")));}
if ( actionRequest.getFieldValue(i,"bal_of_past_due_pr") !=null && actionRequest.getFieldValue(i,"bal_of_past_due_pr").trim().length() > 0 ) {this.setBal_of_past_due_pr(Double.parseDouble(actionRequest.getFieldValue(i,"bal_of_past_due_pr")));}
if ( actionRequest.getFieldValue(i,"bal_dq_prin") !=null && actionRequest.getFieldValue(i,"bal_dq_prin").trim().length() > 0 ) {this.setBal_dq_prin(Double.parseDouble(actionRequest.getFieldValue(i,"bal_dq_prin")));}
if ( actionRequest.getFieldValue(i,"bal_of_bad_prin") !=null && actionRequest.getFieldValue(i,"bal_of_bad_prin").trim().length() > 0 ) {this.setBal_of_bad_prin(Double.parseDouble(actionRequest.getFieldValue(i,"bal_of_bad_prin")));}
if ( actionRequest.getFieldValue(i,"overbal") !=null && actionRequest.getFieldValue(i,"overbal").trim().length() > 0 ) {this.setOverbal(Double.parseDouble(actionRequest.getFieldValue(i,"overbal")));}
if ( actionRequest.getFieldValue(i,"receivable_intr") !=null && actionRequest.getFieldValue(i,"receivable_intr").trim().length() > 0 ) {this.setReceivable_intr(Double.parseDouble(actionRequest.getFieldValue(i,"receivable_intr")));}
if ( actionRequest.getFieldValue(i,"dunning_intr") !=null && actionRequest.getFieldValue(i,"dunning_intr").trim().length() > 0 ) {this.setDunning_intr(Double.parseDouble(actionRequest.getFieldValue(i,"dunning_intr")));}
if ( actionRequest.getFieldValue(i,"dq_of_brk_charge") !=null && actionRequest.getFieldValue(i,"dq_of_brk_charge").trim().length() > 0 ) {this.setDq_of_brk_charge(Double.parseDouble(actionRequest.getFieldValue(i,"dq_of_brk_charge")));}
if ( actionRequest.getFieldValue(i,"dq_procedure_fee") !=null && actionRequest.getFieldValue(i,"dq_procedure_fee").trim().length() > 0 ) {this.setDq_procedure_fee(Double.parseDouble(actionRequest.getFieldValue(i,"dq_procedure_fee")));}
if ( actionRequest.getFieldValue(i,"ba_amt_pd_itd") !=null && actionRequest.getFieldValue(i,"ba_amt_pd_itd").trim().length() > 0 ) {this.setBa_amt_pd_itd(Double.parseDouble(actionRequest.getFieldValue(i,"ba_amt_pd_itd")));}
if ( actionRequest.getFieldValue(i,"pre_pay_amt") !=null && actionRequest.getFieldValue(i,"pre_pay_amt").trim().length() > 0 ) {this.setPre_pay_amt(Double.parseDouble(actionRequest.getFieldValue(i,"pre_pay_amt")));}
if ( actionRequest.getFieldValue(i,"tot_penalty_pay_am") !=null && actionRequest.getFieldValue(i,"tot_penalty_pay_am").trim().length() > 0 ) {this.setTot_penalty_pay_am(Double.parseDouble(actionRequest.getFieldValue(i,"tot_penalty_pay_am")));}
if ( actionRequest.getFieldValue(i,"ac_amt_pd_itd") !=null && actionRequest.getFieldValue(i,"ac_amt_pd_itd").trim().length() > 0 ) {this.setAc_amt_pd_itd(Double.parseDouble(actionRequest.getFieldValue(i,"ac_amt_pd_itd")));}
if ( actionRequest.getFieldValue(i,"tot_pd_brk_fee") !=null && actionRequest.getFieldValue(i,"tot_pd_brk_fee").trim().length() > 0 ) {this.setTot_pd_brk_fee(Double.parseDouble(actionRequest.getFieldValue(i,"tot_pd_brk_fee")));}
if ( actionRequest.getFieldValue(i,"tot_pd_proce_fee") !=null && actionRequest.getFieldValue(i,"tot_pd_proce_fee").trim().length() > 0 ) {this.setTot_pd_proce_fee(Double.parseDouble(actionRequest.getFieldValue(i,"tot_pd_proce_fee")));}
if ( actionRequest.getFieldValue(i,"rt_tot_coff_amt") !=null && actionRequest.getFieldValue(i,"rt_tot_coff_amt").trim().length() > 0 ) {this.setRt_tot_coff_amt(Double.parseDouble(actionRequest.getFieldValue(i,"rt_tot_coff_amt")));}
if ( actionRequest.getFieldValue(i,"dq_alp_amt") !=null && actionRequest.getFieldValue(i,"dq_alp_amt").trim().length() > 0 ) {this.setDq_alp_amt(Double.parseDouble(actionRequest.getFieldValue(i,"dq_alp_amt")));}
if ( actionRequest.getFieldValue(i,"col_ali_amt") !=null && actionRequest.getFieldValue(i,"col_ali_amt").trim().length() > 0 ) {this.setCol_ali_amt(Double.parseDouble(actionRequest.getFieldValue(i,"col_ali_amt")));}
if ( actionRequest.getFieldValue(i,"past_due_alp") !=null && actionRequest.getFieldValue(i,"past_due_alp").trim().length() > 0 ) {this.setPast_due_alp(Double.parseDouble(actionRequest.getFieldValue(i,"past_due_alp")));}
if ( actionRequest.getFieldValue(i,"int_rec_ali") !=null && actionRequest.getFieldValue(i,"int_rec_ali").trim().length() > 0 ) {this.setInt_rec_ali(Double.parseDouble(actionRequest.getFieldValue(i,"int_rec_ali")));}
if ( actionRequest.getFieldValue(i,"rt_oldst_due_date") !=null ) {this.setRt_oldst_due_date(actionRequest.getFieldValue(i,"rt_oldst_due_date"));}
if ( actionRequest.getFieldValue(i,"sacapi31") !=null && actionRequest.getFieldValue(i,"sacapi31").trim().length() > 0 ) {this.setSacapi31(Double.parseDouble(actionRequest.getFieldValue(i,"sacapi31")));}
if ( actionRequest.getFieldValue(i,"sacapi61") !=null && actionRequest.getFieldValue(i,"sacapi61").trim().length() > 0 ) {this.setSacapi61(Double.parseDouble(actionRequest.getFieldValue(i,"sacapi61")));}
if ( actionRequest.getFieldValue(i,"sacapi91") !=null && actionRequest.getFieldValue(i,"sacapi91").trim().length() > 0 ) {this.setSacapi91(Double.parseDouble(actionRequest.getFieldValue(i,"sacapi91")));}
if ( actionRequest.getFieldValue(i,"pri_past_ov_180_da") !=null && actionRequest.getFieldValue(i,"pri_past_ov_180_da").trim().length() > 0 ) {this.setPri_past_ov_180_da(Double.parseDouble(actionRequest.getFieldValue(i,"pri_past_ov_180_da")));}
if ( actionRequest.getFieldValue(i,"num_of_time_dq") !=null && actionRequest.getFieldValue(i,"num_of_time_dq").trim().length() > 0 ) {this.setNum_of_time_dq(Integer.parseInt(actionRequest.getFieldValue(i,"num_of_time_dq")));}
if ( actionRequest.getFieldValue(i,"curr_mth_pay_statu") !=null ) {this.setCurr_mth_pay_statu(actionRequest.getFieldValue(i,"curr_mth_pay_statu"));}
if ( actionRequest.getFieldValue(i,"rt_num_due_seq") !=null && actionRequest.getFieldValue(i,"rt_num_due_seq").trim().length() > 0 ) {this.setRt_num_due_seq(Integer.parseInt(actionRequest.getFieldValue(i,"rt_num_due_seq")));}
if ( actionRequest.getFieldValue(i,"du_pmt_rem") !=null && actionRequest.getFieldValue(i,"du_pmt_rem").trim().length() > 0 ) {this.setDu_pmt_rem(Double.parseDouble(actionRequest.getFieldValue(i,"du_pmt_rem")));}
if ( actionRequest.getFieldValue(i,"ac_accr_bal") !=null && actionRequest.getFieldValue(i,"ac_accr_bal").trim().length() > 0 ) {this.setAc_accr_bal(Double.parseDouble(actionRequest.getFieldValue(i,"ac_accr_bal")));}
if ( actionRequest.getFieldValue(i,"rt_sold_ind") !=null ) {this.setRt_sold_ind(actionRequest.getFieldValue(i,"rt_sold_ind"));}
if ( actionRequest.getFieldValue(i,"rt_sold_cd") !=null ) {this.setRt_sold_cd(actionRequest.getFieldValue(i,"rt_sold_cd"));}
if ( actionRequest.getFieldValue(i,"int_past_01_60_day") !=null && actionRequest.getFieldValue(i,"int_past_01_60_day").trim().length() > 0 ) {this.setInt_past_01_60_day(Double.parseDouble(actionRequest.getFieldValue(i,"int_past_01_60_day")));}
if ( actionRequest.getFieldValue(i,"int_past_31_60_day") !=null && actionRequest.getFieldValue(i,"int_past_31_60_day").trim().length() > 0 ) {this.setInt_past_31_60_day(Double.parseDouble(actionRequest.getFieldValue(i,"int_past_31_60_day")));}
if ( actionRequest.getFieldValue(i,"int_past_61_90_day") !=null && actionRequest.getFieldValue(i,"int_past_61_90_day").trim().length() > 0 ) {this.setInt_past_61_90_day(Double.parseDouble(actionRequest.getFieldValue(i,"int_past_61_90_day")));}
if ( actionRequest.getFieldValue(i,"int_past_91_180_da") !=null && actionRequest.getFieldValue(i,"int_past_91_180_da").trim().length() > 0 ) {this.setInt_past_91_180_da(Double.parseDouble(actionRequest.getFieldValue(i,"int_past_91_180_da")));}
if ( actionRequest.getFieldValue(i,"int_past_ov_180_da") !=null && actionRequest.getFieldValue(i,"int_past_ov_180_da").trim().length() > 0 ) {this.setInt_past_ov_180_da(Double.parseDouble(actionRequest.getFieldValue(i,"int_past_ov_180_da")));}
if ( actionRequest.getFieldValue(i,"zm_memo2_amt02_0") !=null && actionRequest.getFieldValue(i,"zm_memo2_amt02_0").trim().length() > 0 ) {this.setZm_memo2_amt02_0(Double.parseDouble(actionRequest.getFieldValue(i,"zm_memo2_amt02_0")));}
if ( actionRequest.getFieldValue(i,"zm_memo2_amt02_1") !=null && actionRequest.getFieldValue(i,"zm_memo2_amt02_1").trim().length() > 0 ) {this.setZm_memo2_amt02_1(Double.parseDouble(actionRequest.getFieldValue(i,"zm_memo2_amt02_1")));}
if ( actionRequest.getFieldValue(i,"du_pmt_bill_0") !=null && actionRequest.getFieldValue(i,"du_pmt_bill_0").trim().length() > 0 ) {this.setDu_pmt_bill_0(Double.parseDouble(actionRequest.getFieldValue(i,"du_pmt_bill_0")));}
if ( actionRequest.getFieldValue(i,"du_pmt_bill_1") !=null && actionRequest.getFieldValue(i,"du_pmt_bill_1").trim().length() > 0 ) {this.setDu_pmt_bill_1(Double.parseDouble(actionRequest.getFieldValue(i,"du_pmt_bill_1")));}
if ( actionRequest.getFieldValue(i,"ac_accr_mtd") !=null && actionRequest.getFieldValue(i,"ac_accr_mtd").trim().length() > 0 ) {this.setAc_accr_mtd(Double.parseDouble(actionRequest.getFieldValue(i,"ac_accr_mtd")));}
if ( actionRequest.getFieldValue(i,"cm_cmt_num") !=null ) {this.setCm_cmt_num(actionRequest.getFieldValue(i,"cm_cmt_num"));}
if ( actionRequest.getFieldValue(i,"zm_pkg_loan_nbr") !=null ) {this.setZm_pkg_loan_nbr(actionRequest.getFieldValue(i,"zm_pkg_loan_nbr"));}
if ( actionRequest.getFieldValue(i,"zm_pmt_seq_nbr") !=null ) {this.setZm_pmt_seq_nbr(actionRequest.getFieldValue(i,"zm_pmt_seq_nbr"));}
if ( actionRequest.getFieldValue(i,"rt_orig_procd_amt") !=null && actionRequest.getFieldValue(i,"rt_orig_procd_amt").trim().length() > 0 ) {this.setRt_orig_procd_amt(Double.parseDouble(actionRequest.getFieldValue(i,"rt_orig_procd_amt")));}
if ( actionRequest.getFieldValue(i,"rt_term_freq") !=null ) {this.setRt_term_freq(actionRequest.getFieldValue(i,"rt_term_freq"));}
if ( actionRequest.getFieldValue(i,"rt_term_incr") !=null && actionRequest.getFieldValue(i,"rt_term_incr").trim().length() > 0 ) {this.setRt_term_incr(Integer.parseInt(actionRequest.getFieldValue(i,"rt_term_incr")));}
if ( actionRequest.getFieldValue(i,"rt_actl_pmts_rem") !=null && actionRequest.getFieldValue(i,"rt_actl_pmts_rem").trim().length() > 0 ) {this.setRt_actl_pmts_rem(Integer.parseInt(actionRequest.getFieldValue(i,"rt_actl_pmts_rem")));}
if ( actionRequest.getFieldValue(i,"rt_frst_due_date") !=null ) {this.setRt_frst_due_date(actionRequest.getFieldValue(i,"rt_frst_due_date"));}
if ( actionRequest.getFieldValue(i,"poff_date") !=null ) {this.setPoff_date(actionRequest.getFieldValue(i,"poff_date"));}
if ( actionRequest.getFieldValue(i,"int_dis_rate") !=null && actionRequest.getFieldValue(i,"int_dis_rate").trim().length() > 0 ) {this.setInt_dis_rate(Double.parseDouble(actionRequest.getFieldValue(i,"int_dis_rate")));}
if ( actionRequest.getFieldValue(i,"int_dis_end_dt") !=null ) {this.setInt_dis_end_dt(actionRequest.getFieldValue(i,"int_dis_end_dt"));}
if ( actionRequest.getFieldValue(i,"zm_aflc_code") !=null ) {this.setZm_aflc_code(actionRequest.getFieldValue(i,"zm_aflc_code"));}
if ( actionRequest.getFieldValue(i,"zm_adj_penalty_int") !=null && actionRequest.getFieldValue(i,"zm_adj_penalty_int").trim().length() > 0 ) {this.setZm_adj_penalty_int(Double.parseDouble(actionRequest.getFieldValue(i,"zm_adj_penalty_int")));}
if ( actionRequest.getFieldValue(i,"zm_adj_penalty_pri") !=null && actionRequest.getFieldValue(i,"zm_adj_penalty_pri").trim().length() > 0 ) {this.setZm_adj_penalty_pri(Double.parseDouble(actionRequest.getFieldValue(i,"zm_adj_penalty_pri")));}
if ( actionRequest.getFieldValue(i,"bd_nxt_due_date_0") !=null ) {this.setBd_nxt_due_date_0(actionRequest.getFieldValue(i,"bd_nxt_due_date_0"));}
if ( actionRequest.getFieldValue(i,"bd_nxt_due_date_2") !=null ) {this.setBd_nxt_due_date_2(actionRequest.getFieldValue(i,"bd_nxt_due_date_2"));}
if ( actionRequest.getFieldValue(i,"dq_grace_days") !=null && actionRequest.getFieldValue(i,"dq_grace_days").trim().length() > 0 ) {this.setDq_grace_days(Integer.parseInt(actionRequest.getFieldValue(i,"dq_grace_days")));}
if ( actionRequest.getFieldValue(i,"ac_accr_itd") !=null && actionRequest.getFieldValue(i,"ac_accr_itd").trim().length() > 0 ) {this.setAc_accr_itd(Double.parseDouble(actionRequest.getFieldValue(i,"ac_accr_itd")));}
if ( actionRequest.getFieldValue(i,"dq_hist_day_ctr") !=null && actionRequest.getFieldValue(i,"dq_hist_day_ctr").trim().length() > 0 ) {this.setDq_hist_day_ctr(Integer.parseInt(actionRequest.getFieldValue(i,"dq_hist_day_ctr")));}
if ( actionRequest.getFieldValue(i,"dq_num_pmts_pdue") !=null && actionRequest.getFieldValue(i,"dq_num_pmts_pdue").trim().length() > 0 ) {this.setDq_num_pmts_pdue(Integer.parseInt(actionRequest.getFieldValue(i,"dq_num_pmts_pdue")));}
if ( actionRequest.getFieldValue(i,"rt_user_grp3") !=null ) {this.setRt_user_grp3(actionRequest.getFieldValue(i,"rt_user_grp3"));}
if ( actionRequest.getFieldValue(i,"rt_user_grp9") !=null ) {this.setRt_user_grp9(actionRequest.getFieldValue(i,"rt_user_grp9"));}
if ( actionRequest.getFieldValue(i,"rt_user_amt1") !=null && actionRequest.getFieldValue(i,"rt_user_amt1").trim().length() > 0 ) {this.setRt_user_amt1(Double.parseDouble(actionRequest.getFieldValue(i,"rt_user_amt1")));}
if ( actionRequest.getFieldValue(i,"rt_user_amt2") !=null && actionRequest.getFieldValue(i,"rt_user_amt2").trim().length() > 0 ) {this.setRt_user_amt2(Double.parseDouble(actionRequest.getFieldValue(i,"rt_user_amt2")));}
if ( actionRequest.getFieldValue(i,"rt_sngl_balloon_cd") !=null ) {this.setRt_sngl_balloon_cd(actionRequest.getFieldValue(i,"rt_sngl_balloon_cd"));}
if ( actionRequest.getFieldValue(i,"bl_lead_days") !=null && actionRequest.getFieldValue(i,"bl_lead_days").trim().length() > 0 ) {this.setBl_lead_days(Integer.parseInt(actionRequest.getFieldValue(i,"bl_lead_days")));}
if ( actionRequest.getFieldValue(i,"bd_meth") !=null ) {this.setBd_meth(actionRequest.getFieldValue(i,"bd_meth"));}
if ( actionRequest.getFieldValue(i,"bd_bill_type") !=null ) {this.setBd_bill_type(actionRequest.getFieldValue(i,"bd_bill_type"));}
if ( actionRequest.getFieldValue(i,"se_sale_num") !=null ) {this.setSe_sale_num(actionRequest.getFieldValue(i,"se_sale_num"));}
if ( actionRequest.getFieldValue(i,"rt_se_commit_date") !=null ) {this.setRt_se_commit_date(actionRequest.getFieldValue(i,"rt_se_commit_date"));}
if ( actionRequest.getFieldValue(i,"rt_pool_cd") !=null ) {this.setRt_pool_cd(actionRequest.getFieldValue(i,"rt_pool_cd"));}
if ( actionRequest.getFieldValue(i,"se_sale_date") !=null ) {this.setSe_sale_date(actionRequest.getFieldValue(i,"se_sale_date"));}
if ( actionRequest.getFieldValue(i,"zmepoffpctu") !=null && actionRequest.getFieldValue(i,"zmepoffpctu").trim().length() > 0 ) {this.setZmepoffpctu(Double.parseDouble(actionRequest.getFieldValue(i,"zmepoffpctu")));}
if ( actionRequest.getFieldValue(i,"rtorigcmamt") !=null && actionRequest.getFieldValue(i,"rtorigcmamt").trim().length() > 0 ) {this.setRtorigcmamt(Double.parseDouble(actionRequest.getFieldValue(i,"rtorigcmamt")));}
if ( actionRequest.getFieldValue(i,"action_flag") !=null ) {this.setAction_flag(actionRequest.getFieldValue(i,"action_flag"));}
if ( actionRequest.getFieldValue(i,"slsccd") !=null ) {this.setSlsccd(actionRequest.getFieldValue(i,"slsccd"));}
if ( actionRequest.getFieldValue(i,"cm_mult_adv_ind") !=null ) {this.setCm_mult_adv_ind(actionRequest.getFieldValue(i,"cm_mult_adv_ind"));}
if ( actionRequest.getFieldValue(i,"zm_ful_par_pmt") !=null ) {this.setZm_ful_par_pmt(actionRequest.getFieldValue(i,"zm_ful_par_pmt"));}
if ( actionRequest.getFieldValue(i,"cf_addr_num") !=null ) {this.setCf_addr_num(actionRequest.getFieldValue(i,"cf_addr_num"));}
if ( actionRequest.getFieldValue(i,"sl_guar_agency_cd") !=null ) {this.setSl_guar_agency_cd(actionRequest.getFieldValue(i,"sl_guar_agency_cd"));}
if ( actionRequest.getFieldValue(i,"ba_curr_cm_amt") !=null && actionRequest.getFieldValue(i,"ba_curr_cm_amt").trim().length() > 0 ) {this.setBa_curr_cm_amt(Double.parseDouble(actionRequest.getFieldValue(i,"ba_curr_cm_amt")));}
if ( actionRequest.getFieldValue(i,"available_amt") !=null && actionRequest.getFieldValue(i,"available_amt").trim().length() > 0 ) {this.setAvailable_amt(Double.parseDouble(actionRequest.getFieldValue(i,"available_amt")));}
if ( actionRequest.getFieldValue(i,"rt_date_lst_maint") !=null ) {this.setRt_date_lst_maint(actionRequest.getFieldValue(i,"rt_date_lst_maint"));}
if ( actionRequest.getFieldValue(i,"tot_pri_payment_amt") !=null && actionRequest.getFieldValue(i,"tot_pri_payment_amt").trim().length() > 0 ) {this.setTot_pri_payment_amt(Double.parseDouble(actionRequest.getFieldValue(i,"tot_pri_payment_amt")));}
if ( actionRequest.getFieldValue(i,"zm_memo2_amt02_2") !=null && actionRequest.getFieldValue(i,"zm_memo2_amt02_2").trim().length() > 0 ) {this.setZm_memo2_amt02_2(Double.parseDouble(actionRequest.getFieldValue(i,"zm_memo2_amt02_2")));}
if ( actionRequest.getFieldValue(i,"zm_memo2_amt02_3") !=null && actionRequest.getFieldValue(i,"zm_memo2_amt02_3").trim().length() > 0 ) {this.setZm_memo2_amt02_3(Double.parseDouble(actionRequest.getFieldValue(i,"zm_memo2_amt02_3")));}
if ( actionRequest.getFieldValue(i,"ln_arfn_int") !=null && actionRequest.getFieldValue(i,"ln_arfn_int").trim().length() > 0 ) {this.setLn_arfn_int(Double.parseDouble(actionRequest.getFieldValue(i,"ln_arfn_int")));}
if ( actionRequest.getFieldValue(i,"zm_memo2_amt02_4") !=null && actionRequest.getFieldValue(i,"zm_memo2_amt02_4").trim().length() > 0 ) {this.setZm_memo2_amt02_4(Double.parseDouble(actionRequest.getFieldValue(i,"zm_memo2_amt02_4")));}
if ( actionRequest.getFieldValue(i,"zm_memo2_amt02_6") !=null && actionRequest.getFieldValue(i,"zm_memo2_amt02_6").trim().length() > 0 ) {this.setZm_memo2_amt02_6(Double.parseDouble(actionRequest.getFieldValue(i,"zm_memo2_amt02_6")));}
if ( actionRequest.getFieldValue(i,"recooperinte") !=null && actionRequest.getFieldValue(i,"recooperinte").trim().length() > 0 ) {this.setRecooperinte(Double.parseDouble(actionRequest.getFieldValue(i,"recooperinte")));}
if ( actionRequest.getFieldValue(i,"zm_memo2_amt02_21") !=null && actionRequest.getFieldValue(i,"zm_memo2_amt02_21").trim().length() > 0 ) {this.setZm_memo2_amt02_21(Double.parseDouble(actionRequest.getFieldValue(i,"zm_memo2_amt02_21")));}
if ( actionRequest.getFieldValue(i,"rt_curr_due_amt") !=null && actionRequest.getFieldValue(i,"rt_curr_due_amt").trim().length() > 0 ) {this.setRt_curr_due_amt(Double.parseDouble(actionRequest.getFieldValue(i,"rt_curr_due_amt")));}
if ( actionRequest.getFieldValue(i,"rt_coff_date") !=null ) {this.setRt_coff_date(actionRequest.getFieldValue(i,"rt_coff_date"));}
if ( actionRequest.getFieldValue(i,"filler") !=null ) {this.setFiller(actionRequest.getFieldValue(i,"filler"));}
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { LNODSBACCTAMWKPL08 obj = (LNODSBACCTAMWKPL08)super.clone();obj.setRt_ctl1(obj.rt_ctl1);
obj.setRtctl2(obj.rtctl2);
obj.setRt_ctl3(obj.rt_ctl3);
obj.setRtctl4(obj.rtctl4);
obj.setLn_acct_no(obj.ln_acct_no);
obj.setOds_src_dt(obj.ods_src_dt);
obj.setZm_notes_1(obj.zm_notes_1);
obj.setMi_set_acct_num(obj.mi_set_acct_num);
obj.setCurr_cd(obj.curr_cd);
obj.setZm_desc_15_1(obj.zm_desc_15_1);
obj.setCust_name(obj.cust_name);
obj.setRt_acct_prod(obj.rt_acct_prod);
obj.setIns_type(obj.ins_type);
obj.setInsurance_num(obj.insurance_num);
obj.setAcct_stat(obj.acct_stat);
obj.setColl_type_1_flag(obj.coll_type_1_flag);
obj.setColl_type_2_flag(obj.coll_type_2_flag);
obj.setGuarantor_flag(obj.guarantor_flag);
obj.setPer_credit_flag(obj.per_credit_flag);
obj.setIs_cover_amt(obj.is_cover_amt);
obj.setInsurance_company_name(obj.insurance_company_name);
obj.setIs_agent_name(obj.is_agent_name);
obj.setIs_user_desc1(obj.is_user_desc1);
obj.setIs_user_desc2(obj.is_user_desc2);
obj.setPay_type(obj.pay_type);
obj.setMi_pay_acct_1(obj.mi_pay_acct_1);
obj.setMi_pay_acct_2(obj.mi_pay_acct_2);
obj.setMi_pay_acct_3(obj.mi_pay_acct_3);
obj.setMi_pay_acct_4(obj.mi_pay_acct_4);
obj.setMi_pay_acct_5(obj.mi_pay_acct_5);
obj.setRt_proc_type(obj.rt_proc_type);
obj.setMi_auto_prin_flag(obj.mi_auto_prin_flag);
obj.setMi_auto_int_flag(obj.mi_auto_int_flag);
obj.setCust_open_dt(obj.cust_open_dt);
obj.setExpiring_dt(obj.expiring_dt);
obj.setRt_num_pmts_made(obj.rt_num_pmts_made);
obj.setCurr_pmt_num(obj.curr_pmt_num);
obj.setLn_totl_prd(obj.ln_totl_prd);
obj.setRt_orig_loan_amt(obj.rt_orig_loan_amt);
obj.setCumulative_payout_amt(obj.cumulative_payout_amt);
obj.setNum_day_interval(obj.num_day_interval);
obj.setPrin_num_day_inter(obj.prin_num_day_inter);
obj.setInt_num_day_interv(obj.int_num_day_interv);
obj.setBl_flat_amt(obj.bl_flat_amt);
obj.setTot_pay_amt(obj.tot_pay_amt);
obj.setProgressive_intv(obj.progressive_intv);
obj.setProgressive_addt_a(obj.progressive_addt_a);
obj.setLst_progressive_da(obj.lst_progressive_da);
obj.setEntruster_fund_acc(obj.entruster_fund_acc);
obj.setEntruster_sav_acct(obj.entruster_sav_acct);
obj.setBal_of_out_int(obj.bal_of_out_int);
obj.setInt_rec_acc(obj.int_rec_acc);
obj.setAcct_open_date(obj.acct_open_date);
obj.setRt_list_pmt_date(obj.rt_list_pmt_date);
obj.setAc_start_date(obj.ac_start_date);
obj.setAcct_mark(obj.acct_mark);
obj.setCust_no(obj.cust_no);
obj.setZipcode(obj.zipcode);
obj.setCustomer_address(obj.customer_address);
obj.setCont_tele(obj.cont_tele);
obj.setCf_bus_phone_data(obj.cf_bus_phone_data);
obj.setAuto_credit_acct(obj.auto_credit_acct);
obj.setLn_intr_adj_sty(obj.ln_intr_adj_sty);
obj.setRt_loan_rate(obj.rt_loan_rate);
obj.setRa_pct1(obj.ra_pct1);
obj.setAc_rate(obj.ac_rate);
obj.setTime_of_dq(obj.time_of_dq);
obj.setBal_normal_prin(obj.bal_normal_prin);
obj.setBal_of_past_due_pr(obj.bal_of_past_due_pr);
obj.setBal_dq_prin(obj.bal_dq_prin);
obj.setBal_of_bad_prin(obj.bal_of_bad_prin);
obj.setOverbal(obj.overbal);
obj.setReceivable_intr(obj.receivable_intr);
obj.setDunning_intr(obj.dunning_intr);
obj.setDq_of_brk_charge(obj.dq_of_brk_charge);
obj.setDq_procedure_fee(obj.dq_procedure_fee);
obj.setBa_amt_pd_itd(obj.ba_amt_pd_itd);
obj.setPre_pay_amt(obj.pre_pay_amt);
obj.setTot_penalty_pay_am(obj.tot_penalty_pay_am);
obj.setAc_amt_pd_itd(obj.ac_amt_pd_itd);
obj.setTot_pd_brk_fee(obj.tot_pd_brk_fee);
obj.setTot_pd_proce_fee(obj.tot_pd_proce_fee);
obj.setRt_tot_coff_amt(obj.rt_tot_coff_amt);
obj.setDq_alp_amt(obj.dq_alp_amt);
obj.setCol_ali_amt(obj.col_ali_amt);
obj.setPast_due_alp(obj.past_due_alp);
obj.setInt_rec_ali(obj.int_rec_ali);
obj.setRt_oldst_due_date(obj.rt_oldst_due_date);
obj.setSacapi31(obj.sacapi31);
obj.setSacapi61(obj.sacapi61);
obj.setSacapi91(obj.sacapi91);
obj.setPri_past_ov_180_da(obj.pri_past_ov_180_da);
obj.setNum_of_time_dq(obj.num_of_time_dq);
obj.setCurr_mth_pay_statu(obj.curr_mth_pay_statu);
obj.setRt_num_due_seq(obj.rt_num_due_seq);
obj.setDu_pmt_rem(obj.du_pmt_rem);
obj.setAc_accr_bal(obj.ac_accr_bal);
obj.setRt_sold_ind(obj.rt_sold_ind);
obj.setRt_sold_cd(obj.rt_sold_cd);
obj.setInt_past_01_60_day(obj.int_past_01_60_day);
obj.setInt_past_31_60_day(obj.int_past_31_60_day);
obj.setInt_past_61_90_day(obj.int_past_61_90_day);
obj.setInt_past_91_180_da(obj.int_past_91_180_da);
obj.setInt_past_ov_180_da(obj.int_past_ov_180_da);
obj.setZm_memo2_amt02_0(obj.zm_memo2_amt02_0);
obj.setZm_memo2_amt02_1(obj.zm_memo2_amt02_1);
obj.setDu_pmt_bill_0(obj.du_pmt_bill_0);
obj.setDu_pmt_bill_1(obj.du_pmt_bill_1);
obj.setAc_accr_mtd(obj.ac_accr_mtd);
obj.setCm_cmt_num(obj.cm_cmt_num);
obj.setZm_pkg_loan_nbr(obj.zm_pkg_loan_nbr);
obj.setZm_pmt_seq_nbr(obj.zm_pmt_seq_nbr);
obj.setRt_orig_procd_amt(obj.rt_orig_procd_amt);
obj.setRt_term_freq(obj.rt_term_freq);
obj.setRt_term_incr(obj.rt_term_incr);
obj.setRt_actl_pmts_rem(obj.rt_actl_pmts_rem);
obj.setRt_frst_due_date(obj.rt_frst_due_date);
obj.setPoff_date(obj.poff_date);
obj.setInt_dis_rate(obj.int_dis_rate);
obj.setInt_dis_end_dt(obj.int_dis_end_dt);
obj.setZm_aflc_code(obj.zm_aflc_code);
obj.setZm_adj_penalty_int(obj.zm_adj_penalty_int);
obj.setZm_adj_penalty_pri(obj.zm_adj_penalty_pri);
obj.setBd_nxt_due_date_0(obj.bd_nxt_due_date_0);
obj.setBd_nxt_due_date_2(obj.bd_nxt_due_date_2);
obj.setDq_grace_days(obj.dq_grace_days);
obj.setAc_accr_itd(obj.ac_accr_itd);
obj.setDq_hist_day_ctr(obj.dq_hist_day_ctr);
obj.setDq_num_pmts_pdue(obj.dq_num_pmts_pdue);
obj.setRt_user_grp3(obj.rt_user_grp3);
obj.setRt_user_grp9(obj.rt_user_grp9);
obj.setRt_user_amt1(obj.rt_user_amt1);
obj.setRt_user_amt2(obj.rt_user_amt2);
obj.setRt_sngl_balloon_cd(obj.rt_sngl_balloon_cd);
obj.setBl_lead_days(obj.bl_lead_days);
obj.setBd_meth(obj.bd_meth);
obj.setBd_bill_type(obj.bd_bill_type);
obj.setSe_sale_num(obj.se_sale_num);
obj.setRt_se_commit_date(obj.rt_se_commit_date);
obj.setRt_pool_cd(obj.rt_pool_cd);
obj.setSe_sale_date(obj.se_sale_date);
obj.setZmepoffpctu(obj.zmepoffpctu);
obj.setRtorigcmamt(obj.rtorigcmamt);
obj.setAction_flag(obj.action_flag);
obj.setSlsccd(obj.slsccd);
obj.setCm_mult_adv_ind(obj.cm_mult_adv_ind);
obj.setZm_ful_par_pmt(obj.zm_ful_par_pmt);
obj.setCf_addr_num(obj.cf_addr_num);
obj.setSl_guar_agency_cd(obj.sl_guar_agency_cd);
obj.setBa_curr_cm_amt(obj.ba_curr_cm_amt);
obj.setAvailable_amt(obj.available_amt);
obj.setRt_date_lst_maint(obj.rt_date_lst_maint);
obj.setTot_pri_payment_amt(obj.tot_pri_payment_amt);
obj.setZm_memo2_amt02_2(obj.zm_memo2_amt02_2);
obj.setZm_memo2_amt02_3(obj.zm_memo2_amt02_3);
obj.setLn_arfn_int(obj.ln_arfn_int);
obj.setZm_memo2_amt02_4(obj.zm_memo2_amt02_4);
obj.setZm_memo2_amt02_6(obj.zm_memo2_amt02_6);
obj.setRecooperinte(obj.recooperinte);
obj.setZm_memo2_amt02_21(obj.zm_memo2_amt02_21);
obj.setRt_curr_due_amt(obj.rt_curr_due_amt);
obj.setRt_coff_date(obj.rt_coff_date);
obj.setFiller(obj.filler);
return obj;}}