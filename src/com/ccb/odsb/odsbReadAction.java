package com.ccb.odsb;

/**
 * <p>Title: 后台业务组件</p>
 *
 * <p>Description: 后台业务组件</p>
 *
 * <p>Copyright: Copyright (c) 2010</p>
 *
 * <p>Company: 公司</p>
 *
 * @author leonwoo
 * @version 1.0
 */

import com.ccb.mortgage.MortUtil;
import com.ccb.util.SeqUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import pub.platform.advance.utils.PropertyManager;
import pub.platform.db.DBUtil;
import pub.platform.db.RecordSet;
import pub.platform.form.control.Action;
import pub.platform.utils.BusinessDate;

import java.sql.PreparedStatement;

public class odsbReadAction extends Action {
    private static final Log logger = LogFactory.getLog(odsbReadAction.class);
    // 检查金额、姓名等
    final String CHECKAMT_SQL = "select count(*) checkResult "
            + " from LN_LOANAPPLY a inner join ln_odsb_loanapply b on a.loanid=b.loanid "
            + " where a.NEEDADDCD= '1' and (trim(a.cust_name) <> trim(b.cust_name) "
            + " or a.rt_orig_loan_amt <> b.rt_orig_loan_amt " + " or trim(a.bankid) <> trim(b.bankid)) ";
    // 检查合作方编号
    final String CHECKPROJ_SQL = "select count(*) checkProj from ln_odsb_loanapply a where not "
            + " exists(select 1 from ln_coopproj b where b.proj_no=a.proj_no) and trim(a.proj_no) is not null ";

    /**
     * <p/>
     * 从ODSB读入数据
     *
     * @return
     */
    public int readFromODSB() {
        int rtn = 0;
        for (int i = 0; i < this.req.getRecorderCount(); i++) {
            try {
                rtn = dc.executeUpdate(" truncate table ln_odsb_coopproj ");
                rtn = dc.executeUpdate(" insert into ln_odsb_coopproj  select " +
                        " PROJ_NO," +
                        "ODS_SRC_DT," +
                        "CORPID," +
                        "CORPNAME," +
                        "PROJ_NAME," +
                        "BUILADDR," +
                        "OUTLICENO," +
                        "PAPERNO," +
                        "INVEAMT," +
                        "REMARKS," +
                        "BANKID," +
                        "null as STD_OPUN_COD," +
                        "OPERID," +
                        "INVENUM," +
                        "USETIMELIMT " +
                        " from  ODSBDATA.BF_AGT_LNP_COOP_CAPROJINFO@odsb a ");
                if (rtn < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage(PropertyManager.getProperty("300"));
                    return -1;
                }
                //int rtn = dc.executeUpdate(" truncate table ln_odsb_loanapply  ");
//                rtn = dc.executeUpdate(" delete from  ln_odsb_loanapply  ");
                rtn = dc.executeUpdate(" truncate table ln_odsb_loanapply ");
                //odsb table name= ODSBDATA.BF_AGT_LNP_CTRT_APPLY
//                rtn = dc.executeUpdate(" insert into ln_odsb_loanapply  select * from  ODSBDATA.BF_AGT_LNP_CTRT_APPLY@odsb a "
//                        + " where a.APLY_DT>='2010-01-01' or a.CUST_OPEN_DT>='2010-01-01' ");
                rtn = dc.executeUpdate(" insert into ln_odsb_loanapply  select " +
                        "LOANID," +
                        "LN_ACCT_NO," +
                        "ODS_SRC_DT," +
                        "CUST_NO," +
                        "CRLMT_NO," +
                        "ISCOMMAC," +
                        "CURR_CD," +
                        "LN_PROD_COD," +
                        "LN_TYP," +
                        "ZM_PKG_LOAN_NBR," +
                        "RELALOANID," +
                        "ZM_PMT_SEQ_NBR," +
                        "PAYPERC," +
                        "FUNDSOUR," +
                        "LN_PURP," +
                        "GUARANTY_TYPE," +
                        "APLY_DT," +
                        "CRLMT_AMT," +
                        "CYCFLAG," +
                        "RT_ORIG_LOAN_AMT," +
                        "RT_ORIG_PROCD_AMT," +
                        "RT_TERM_FREQ," +
                        "RT_TERM_INCR," +
                        "PAY_TYPE," +
                        "TROTHDUEDAY," +
                        "FIXRATETERM," +
                        "RT_FRST_DUE_DATE," +
                        "SUBSFLAG," +
                        "ISENOUSUBS," +
                        "FIRSTPAYAMT," +
                        "FIRSTPAYPERC," +
                        "PROJ_NO," +
                        "CORPAPPID," +
                        "RELEWAY," +
                        "PAYEE_ACCT_NO," +
                        "INTECALCKIND," +
                        "INTEMETH," +
                        "INTEBASE," +
                        "BL_LEAD_DAYS," +
                        "RATECODE," +
                        "BASICINTERATE," +
                        "RATEACT," +
                        "RATECALEVALUE," +
                        "null as INTERATE," +
                        "INTEFINERATEFLOAT," +
                        "CAPIFINERATEFLOAT," +
                        "FINERATE," +
                        "CAPIFINERATE," +
                        "FOULRATE," +
                        "EMBERATEFLOAT," +
                        "PROGRESSIVE_ADDT_A," +
                        "GAINPCT," +
                        "PROGRESSIVE_INTV," +
                        "FIRSTGAINTERM," +
                        "INT_DIS_RATE," +
                        "INT_DIS_END_DT," +
                        "FUNDCENTNO," +
                        "MANADEPT," +
                        "ZM_AFLC_CODE," +
                        "FUNDACNO," +
                        "CAPIFUNDACNO," +
                        "INTEFUNDACNO," +
                        "SCHID," +
                        "CF_ADDR_NUM," +
                        "CUST_OPEN_DT," +
                        "EXPIRING_DT," +
                        "CUMULATIVE_PAYOUT_AMT," +
                        "CONTNO," +
                        "BANKID," +
                        "OPERID," +
                        "SURVNAME," +
                        "AUDITING_NAME," +
                        "MAIN_OPERATION," +
                        "APPRNAME," +
                        "APPRTABNO," +
                        "APPRDATE," +
                        "APPRFLAG," +
                        "AUTHID," +
                        "APPRSTATE," +
                        "LOANSTATE," +
                        "APPRTYPE," +
                        "OPENBATCHID," +
                        "ACCOUNTING_ORG," +
                        "LOANEVALDATE," +
                        "AGRFLAG," +
                        "LOANEVALVALUE," +
                        "SUMEVALVALUE," +
                        "SUMEVALDATE," +
                        "AGRNAME," +
                        "ACCOUNT_NO," +
                        "INTEFREQ," +
                        "RATETYPE," +
                        "CORPID," +
                        "CUST_NAME"+
                        " from  ODSBDATA.BF_AGT_LNP_CTRT_APPLY@odsb a ");
                if (rtn < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage(PropertyManager.getProperty("300"));
                    return -1;
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
                e.printStackTrace();
                this.res.setType(0);
                this.res.setResult(false);
                this.res.setMessage(PropertyManager.getProperty("300"));
                return -1;
            }
        }
        //返回读入记录数
        this.res.setFieldName("importCnt");
        this.res.setFieldType("text");
        this.res.setEnumType("0");
        this.res.setFieldValue(String.valueOf(rtn));
        this.res.setType(4);
        this.res.setResult(true);
        return 0;
    }

    /**
     * 检查ODSB读取的数据
     */

    public int ODSBCheck() {
        String checkResult = "0";
        String checkProj = "0";
        try {
            // ①根据ln_loanapply中“待补充资料标志”为“1”的记录， 与ln_odsb_loanapply中相同贷款申请号的记录比较
            // “姓名”“金额”“机构”，如有不同，弹出excel显示。
            RecordSet rs = dc.executeQuery(CHECKAMT_SQL);
            while (rs.next()) {
                checkResult = rs.getString("checkResult");
            }
            // ②查询ln_odsb_loanapply中的proj_no是否在抵押系统中存在（合作项目表），如果不存在则弹出excel。
            rs = dc.executeQuery(CHECKPROJ_SQL);
            while (rs.next()) {
                checkProj = rs.getString("checkProj");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            this.res.setType(0);
            this.res.setResult(false);
            this.res.setMessage(PropertyManager.getProperty("302"));
            return -1;
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        // 检查结果
        this.res.setFieldName("checkResult;checkProj");
        this.res.setFieldType("text;text");
        this.res.setEnumType("0;0");
        this.res.setFieldValue(checkResult + ";" + checkProj);
        this.res.setType(4);
        this.res.setResult(true);
        return 0;
    }

    /**
     * 根据ODSB更新贷款数据
     * <br>// --- 根据ln_loanapply中“待补充资料标志”不为“0” 的数据记录处理临时贷款申请表ln_odsb_loanapply，
     * <br>// 补充ln_loanapply相关信息（除了申请序号，客户经理，），并更新ln_mortinfo表（计算抵押到期日）
     */
    public int ODSBUpdate() {
        // 更新记录数
        int updateCnt = 0;
        // 更新抵押到日期记录数
        int updateMortDateCnt = 0;
        // 新增记录数
        int addCnt = 0;
        // 更新待补充资料记录数
        int updateNeedCDCnt = 0;
        try {
            for (int i = 0; i < this.req.getRecorderCount(); i++) {

                // 加系统锁
                // 系统锁单独事务，finally解锁
                dc.setAuto(false);
                dc.executeUpdate("update SYS_LOCK set SYSLOCKSTATUS ='1'");
                dc.commit();
                
                //---------------------------------------------运行检查，如果有不一致则返回并提示信息---------------------
                // ①根据ln_loanapply中“待补充资料标志”为“1”的记录， 与ln_odsb_loanapply中相同贷款申请号的记录比较
                // “姓名”“金额”“机构”，如有不同，弹出excel显示。
                
                logger.debug("check(“姓名”“金额”“机构) begin:"+BusinessDate.getTodaytime());
                RecordSet rs = dc.executeQuery(CHECKAMT_SQL);
                while (rs.next()) {
                    if (rs.getInt("checkResult") > 0) {
                        this.res.setType(0);
                        this.res.setResult(false);
                        this.res.setMessage(PropertyManager.getProperty("307"));
                        return -1;
                    }
                }
                logger.debug("check(“姓名”“金额”“机构) end:"+BusinessDate.getTodaytime());
                // ②查询ln_odsb_loanapply中的proj_no是否在抵押系统中存在（合作项目表），如果不存在则弹出excel。
                logger.debug("check(合作项目表) begin:"+BusinessDate.getTodaytime());
                rs = dc.executeQuery(CHECKPROJ_SQL);
                while (rs.next()) {
                    if (rs.getInt("checkProj") > 0) {
                        this.res.setType(0);
                        this.res.setResult(false);
                        this.res.setMessage(PropertyManager.getProperty("308"));
                        return -1;
                    }
                }
                logger.debug("check(合作项目表) end:"+BusinessDate.getTodaytime());
                dc.setAuto(false);
                //----------------------------------------------批量更新------------------------------------------------
                logger.debug("批量更新，数据完整标志不为0 begin:"+BusinessDate.getTodaytime());
                updateCnt = dc.executeUpdate(""
                        + "update ("
                        + "select /*+ BYPASS_UJVC */"
                        + "a.LN_ACCT_NO," //贷款账号
                        + "a.ODS_SRC_DT," //源系统业务日期
                        + "a.CUST_NO,"    //客户编号
                        + "a.CRLMT_NO,"   //额度编号
                        + "a.CURR_CD,"    //币种
                        + "a.LN_PROD_COD,"//产品代码
                        + "a.LN_TYP,"     //贷款种类
                        + "a.GUARANTY_TYPE,"//担保方式
                        + "a.APLY_DT,"     //申请日期
                        + "a.RT_ORIG_LOAN_AMT,"//贷款金额
                        + "a.RT_TERM_INCR,"  //贷款期限
                        + "a.PAY_TYPE,"      //还款方式
                        + "a.PROJ_NO,"       //项目编号
                        + "a.RATECODE,"      //利率代码
                        + "a.BASICINTERATE," //贷款基准利率
                        + "a.RATEACT,"       //利率运算代码
                        + "a.RATECALEVALUE," //利率运算值(利率浮动比例)
                        + "a.INTERATE,"      //执行利率
                        + "a.CUST_OPEN_DT,"  //开户日期
                        + "a.EXPIRING_DT,"   //到期日期
                        + "a.BANKID,"        //经办行
                        + "a.OPERID,"        //经办人
                        + "a.APPRSTATE,"     //审批状态
                        + "a.LOANSTATE,"     //贷款状态
                        + "a.CORPID,"        //合作方编号
                        + "a.CUST_NAME,"     //客户姓名
                        + "a.releasedate,"   //用开户日期

                        + "b.LN_ACCT_NO LN_ACCT_NO2,"
                        + "b.ODS_SRC_DT ODS_SRC_DT2,"
                        + "b.CUST_NO CUST_NO2,"
                        + "b.CRLMT_NO CRLMT_NO2,"
                        + "b.CURR_CD CURR_CD2,"
                        + "b.LN_PROD_COD LN_PROD_COD2,"
                        + "b.LN_TYP LN_TYP2,"
                        + "b.GUARANTY_TYPE GUARANTY_TYPE2,"
                        + "b.APLY_DT APLY_DT2,"
                        + "b.RT_ORIG_LOAN_AMT RT_ORIG_LOAN_AMT2,"
                        + "b.RT_TERM_INCR RT_TERM_INCR2,"
                        + "b.PAY_TYPE PAY_TYPE2,"
                        + "b.PROJ_NO PROJ_NO2,"
                        + "b.RATECODE RATECODE2,"
                        + "b.BASICINTERATE BASICINTERATE2,"
                        + "b.RATEACT RATEACT2,"
                        + "b.RATECALEVALUE RATECALEVALUE2,"
                        + "b.INTERATE INTERATE2,"
                        + "b.CUST_OPEN_DT CUST_OPEN_DT2,"
                        + "b.EXPIRING_DT EXPIRING_DT2,"
                        + "b.BANKID BANKID2,"
                        + "b.OPERID OPERID2,"
                        + "b.APPRSTATE APPRSTATE2,"
                        + "b.LOANSTATE LOANSTATE2,"
                        + "b.CORPID CORPID2,"
                        + "b.CUST_NAME CUST_NAME2"
                        + " from ln_loanapply a,ln_odsb_loanapply b"
                        + " where a.loanid=b.loanid"
                        + " and a.NEEDADDCD <>'0'"
                        + " and b.ln_typ not in ('033','433')"
                        + " )"
                        + " set"
                        + " LN_ACCT_NO = LN_ACCT_NO2,"
                        + " ODS_SRC_DT = ODS_SRC_DT2,"
                        + " CUST_NO = CUST_NO2,"
                        + " CRLMT_NO = CRLMT_NO2,"
                        + " CURR_CD = CURR_CD2,"
                        + " LN_PROD_COD = LN_PROD_COD2,"
                        + " LN_TYP = LN_TYP2,"
                        + " GUARANTY_TYPE = GUARANTY_TYPE2,"
                        + " APLY_DT = APLY_DT2,"
                        + " RT_ORIG_LOAN_AMT = RT_ORIG_LOAN_AMT2,"
                        + " RT_TERM_INCR = RT_TERM_INCR2,"
                        + " PAY_TYPE = PAY_TYPE2,"
                        + " PROJ_NO = PROJ_NO2,"
                        + " RATECODE = RATECODE2,"
                        + " BASICINTERATE = BASICINTERATE2,"
                        + " RATEACT = RATEACT2,"
                        + " RATECALEVALUE = RATECALEVALUE2,"
                        + " INTERATE = INTERATE2,"
                        + " CUST_OPEN_DT = CUST_OPEN_DT2,"
                        + " EXPIRING_DT = EXPIRING_DT2,"
                        + " BANKID = BANKID2,"
                        + " OPERID = OPERID2,"
                        + " APPRSTATE = APPRSTATE2,"
                        + " LOANSTATE = LOANSTATE2,"
                        + " CORPID = CORPID2,"
                        + " CUST_NAME = CUST_NAME2,"
                        + " releasedate=CUST_OPEN_DT2"
                        + "");
                dc.commit();
                if (updateCnt < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage(PropertyManager.getProperty("300"));
                    return -1;
                }
                updateCnt = dc.executeUpdate(""
                        + "update ("
                        + "select /*+ BYPASS_UJVC */"
                        + "a.LN_ACCT_NO," //贷款账号
                        + "a.ODS_SRC_DT," //源系统业务日期
                        + "a.CUST_NO,"    //客户编号
                        + "a.CRLMT_NO,"   //额度编号
                        + "a.CURR_CD,"    //币种
                        + "a.LN_PROD_COD,"//产品代码
                        + "a.LN_TYP,"     //贷款种类
                        + "a.GUARANTY_TYPE,"//担保方式
                        + "a.APLY_DT,"     //申请日期
                        + "a.RT_ORIG_LOAN_AMT,"//贷款金额
                        + "a.RT_TERM_INCR,"  //贷款期限
                        + "a.PAY_TYPE,"      //还款方式
                        + "a.PROJ_NO,"       //项目编号
                        + "a.RATECODE,"      //利率代码
                        + "a.BASICINTERATE," //贷款基准利率
                        + "a.RATEACT,"       //利率运算代码
                        + "a.RATECALEVALUE," //利率运算值(利率浮动比例)
                        + "a.INTERATE,"      //执行利率
                        + "a.CUST_OPEN_DT,"  //开户日期
                        + "a.EXPIRING_DT,"   //到期日期
                        + "a.OPERID,"        //经办人
                        + "a.APPRSTATE,"     //审批状态
                        + "a.LOANSTATE,"     //贷款状态
                        + "a.CORPID,"        //合作方编号
                        + "a.CUST_NAME,"     //客户姓名
                        + "a.releasedate,"   //用开户日期

                        + "b.LN_ACCT_NO LN_ACCT_NO2,"
                        + "b.ODS_SRC_DT ODS_SRC_DT2,"
                        + "b.CUST_NO CUST_NO2,"
                        + "b.CRLMT_NO CRLMT_NO2,"
                        + "b.CURR_CD CURR_CD2,"
                        + "b.LN_PROD_COD LN_PROD_COD2,"
                        + "b.LN_TYP LN_TYP2,"
                        + "b.GUARANTY_TYPE GUARANTY_TYPE2,"
                        + "b.APLY_DT APLY_DT2,"
                        + "b.RT_ORIG_LOAN_AMT RT_ORIG_LOAN_AMT2,"
                        + "b.RT_TERM_INCR RT_TERM_INCR2,"
                        + "b.PAY_TYPE PAY_TYPE2,"
                        + "b.PROJ_NO PROJ_NO2,"
                        + "b.RATECODE RATECODE2,"
                        + "b.BASICINTERATE BASICINTERATE2,"
                        + "b.RATEACT RATEACT2,"
                        + "b.RATECALEVALUE RATECALEVALUE2,"
                        + "b.INTERATE INTERATE2,"
                        + "b.CUST_OPEN_DT CUST_OPEN_DT2,"
                        + "b.EXPIRING_DT EXPIRING_DT2,"
                        + "b.OPERID OPERID2,"
                        + "b.APPRSTATE APPRSTATE2,"
                        + "b.LOANSTATE LOANSTATE2,"
                        + "b.CORPID CORPID2,"
                        + "b.CUST_NAME CUST_NAME2"
                        + " from ln_loanapply a,ln_odsb_loanapply b"
                        + " where a.loanid=b.loanid"
                        + " and a.NEEDADDCD <>'0'"
                        + " and b.ln_typ in ('033','433')"
                        + " )"
                        + " set"
                        + " LN_ACCT_NO = LN_ACCT_NO2,"
                        + " ODS_SRC_DT = ODS_SRC_DT2,"
                        + " CUST_NO = CUST_NO2,"
                        + " CRLMT_NO = CRLMT_NO2,"
                        + " CURR_CD = CURR_CD2,"
                        + " LN_PROD_COD = LN_PROD_COD2,"
                        + " LN_TYP = LN_TYP2,"
                        + " GUARANTY_TYPE = GUARANTY_TYPE2,"
                        + " APLY_DT = APLY_DT2,"
                        + " RT_ORIG_LOAN_AMT = RT_ORIG_LOAN_AMT2,"
                        + " RT_TERM_INCR = RT_TERM_INCR2,"
                        + " PAY_TYPE = PAY_TYPE2,"
                        + " PROJ_NO = PROJ_NO2,"
                        + " RATECODE = RATECODE2,"
                        + " BASICINTERATE = BASICINTERATE2,"
                        + " RATEACT = RATEACT2,"
                        + " RATECALEVALUE = RATECALEVALUE2,"
                        + " INTERATE = INTERATE2,"
                        + " CUST_OPEN_DT = CUST_OPEN_DT2,"
                        + " EXPIRING_DT = EXPIRING_DT2,"
                        + " OPERID = OPERID2,"
                        + " APPRSTATE = APPRSTATE2,"
                        + " LOANSTATE = LOANSTATE2,"
                        + " CORPID = CORPID2,"
                        + " CUST_NAME = CUST_NAME2,"
                        + " releasedate=CUST_OPEN_DT2"
                        + "");
                dc.commit();
                if (updateCnt < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage(PropertyManager.getProperty("300"));
                    return -1;
                }
                logger.debug("批量更新，数据完整标志不为0 end:"+BusinessDate.getTodaytime());
                //--------------------------------------- 更新抵押到期日-------------------------------------------------
                logger.debug("更新抵押到期日  begin:"+BusinessDate.getTodaytime());
                rs = dc.executeQuery(""
                        + " select b.RELEASECONDCD, b.mortDate, a.loanid, b.MORTECENTERCD"
                        + " from ln_loanapply a"
                        + " inner join ln_mortinfo b on a.loanid = b.loanid"
                        + " where a.NEEDADDCD <> '0'"
                        + "");
                // 放款方式
                String p_releaseCD = "";
                // 抵押日期
                String p_mortDate = "";
                // 抵押编号
                String p_loanid = "";
                // 抵押中心
                String p_center = "";
                // 抵押到日期
                String morteExpireDate = "";
                // 预编译语句
                PreparedStatement pst = null;
                dc.setAuto(true);
                pst = dc.getPreparedStatement("update ln_mortInfo set mortExpireDate = ?, mortoverrtndate = ? where loanid = ?");
                while (rs.next()) {
                    updateMortDateCnt++;
                    p_releaseCD = rs.getString("RELEASECONDCD");
                    if (p_releaseCD == null) {
                        p_releaseCD = "";
                    }
                    p_mortDate = rs.getString("mortDate");
                    if (p_mortDate == null) {
                        p_mortDate = "";
                    }
                    p_loanid = rs.getString("loanid");
                    p_center = rs.getString("MORTECENTERCD");
                    if (p_center == null) {
                        p_center = "";
                    }
                    //--- 更新抵押到期日---
                    morteExpireDate = MortUtil.getMortExpireDate(p_releaseCD, p_mortDate, dc, p_loanid, p_center);

/*
                    pst.setString(1, morteExpireDate);
                    pst.setString(2, p_loanid);
                    pst.addBatch();
*/
                    pst.setString(1, morteExpireDate);
                    pst.setString(3, p_loanid);
                    //20100403  zhan
                    //如果为签约类 同时更新抵押超批复日期
                    if (p_releaseCD.equals("03") || p_releaseCD.equals("06")) {
                        pst.setString(2, morteExpireDate);
                    } else {
                        pst.setString(2, "");
                    }
                    pst.addBatch();


                    // 每1000条提交一次数据
                    if (updateMortDateCnt % 1000 == 0 ) {
                      System.out.println(String.valueOf(updateMortDateCnt)+" add commited");
                      pst.executeBatch();
                      pst.clearParameters();
                      pst.clearBatch();
                    }                   
                }
                // 非1000的倍数
                if (pst != null) {
                  System.out.println(String.valueOf(updateMortDateCnt) + " update commited");
                  pst.executeBatch();
                  pst.clearParameters();
                  pst.clearBatch();
                }
                logger.debug("更新抵押到期日  end:"+BusinessDate.getTodaytime());
                //---------------------------------------------顺序处理临时贷款申请表 追加新数据---------------------------
                // 新导入的数据NEEDADDCD 为2
                // 每条新导入的数据生成一个唯一的nbxh
                logger.debug("贷款表新增数据  begin:"+BusinessDate.getTodaytime());
                pst = null;
                String strSQL = "";
                rs = dc.executeQuery(" select loanid,cust_name from ln_odsb_loanapply a where not "
                        + " exists(select 1 from ln_loanapply b where b.loanid = a.loanid)");
                // 记录数清零初始化
                addCnt  =0;
                strSQL =""
                  + "insert into ln_loanapply("
                  + "         loanid,"
                  + "         LN_ACCT_NO,"
                  + "         ODS_SRC_DT,"
                  + "         CUST_NO,"
                  + "         CRLMT_NO,"
                  + "         CURR_CD,"
                  + "         LN_PROD_COD,"
                  + "         LN_TYP,"
                  + "         GUARANTY_TYPE,"
                  + "         APLY_DT,"
                  + "         RT_ORIG_LOAN_AMT,"
                  + "         RT_TERM_INCR,"
                  + "         PAY_TYPE,"
                  + "         PROJ_NO,"
                  + "         RATECODE,"
                  + "         BASICINTERATE,"
                  + "         RATEACT,"
                  + "         RATECALEVALUE,"
                  + "         INTERATE,"
                  + "         CUST_OPEN_DT,"
                  + "         EXPIRING_DT,"
                  + "         BANKID,"
                  + "         OPERID,"
                  + "         APPRSTATE,"
                  + "         LOANSTATE,"
                  + "         CORPID,"
                  + "         CUST_NAME,"
                  + "         releasedate,"
                  + "         nbxh,"
                  + "         NEEDADDCD,"
                  + "         cust_py,"
                  + "         RECVERSION)"
                  //-----选待新增的数据-----
                  + "         select "
                  + "         b.loanid,"
                  + "         b.LN_ACCT_NO,"
                  + "         b.ODS_SRC_DT,"
                  + "         b.CUST_NO,"
                  + "         b.CRLMT_NO,"
                  + "         b.CURR_CD,"
                  + "         b.LN_PROD_COD,"
                  + "         b.LN_TYP,"
                  + "         b.GUARANTY_TYPE,"
                  + "         b.APLY_DT,"
                  + "         b.RT_ORIG_LOAN_AMT,"
                  + "         b.RT_TERM_INCR,"
                  + "         b.PAY_TYPE,"
                  + "         b.PROJ_NO,"
                  + "         b.RATECODE,"
                  + "         b.BASICINTERATE,"
                  + "         b.RATEACT,"
                  + "         b.RATECALEVALUE,"
                  + "         b.INTERATE,"
                  + "         b.CUST_OPEN_DT,"
                  + "         b.EXPIRING_DT,"
                  + "         b.BANKID,"
                  + "         b.OPERID,"
                  + "         b.APPRSTATE,"
                  + "         b.LOANSTATE,"
                  + "         b.CORPID,"
                  + "         b.CUST_NAME,"
                  + "         b.CUST_OPEN_DT,"
                  + "         ?,"
                  + "         '2',"
                  + "         ?,"
                  + "         0"
                  + "         from ln_odsb_loanapply b"
                  + "         where b.loanid = ? "
                  + "";
                dc.setAuto(true);
                pst = dc.getPreparedStatement(strSQL);
                while (rs.next()) {
                    // 新增记录数加1
                    addCnt++;                    
                    pst.setString(1, SeqUtil.getNbxh());
                    pst.setString(2, DBUtil.getSpell(dc, rs.getString("cust_name")));
                    pst.setString(3, rs.getString("loanid"));
                    pst.addBatch();
                    // 每1000条提交一次数据
                    if(addCnt % 1000 == 0){
                      System.out.println(String.valueOf(addCnt)+" add commited");
                      //logger.debug(String.valueOf(addCnt)+" add commited");
                      pst.executeBatch();     
                      pst.clearParameters();
                      pst.clearBatch();                     
                    }
                }
                // 非1000的倍数
                // logger.debug(String.valueOf(addCnt)+" add commited");
                System.out.println(String.valueOf(addCnt) + " add commited");
                pst.executeBatch();
                pst.clearParameters();
                pst.clearBatch();
                logger.debug("贷款表新增数据  end:"+BusinessDate.getTodaytime());
                logger.debug("更新数据完整状态标志位  begin:"+BusinessDate.getTodaytime());
                //如果贷款状态为2（已销户）则数据完整状态为0（完整），否则为导入不完整
                updateNeedCDCnt = dc.executeUpdate(""
                        + " update ( select /*+ BYPASS_UJVC */"
                        + "    a.NEEDADDCD,"
                        + "    decode(trim(b.LOANSTATE),'2',0,2) needaddcd2"
                        + "    from ln_loanapply a,ln_odsb_loanapply b"
                        + "    where a.loanid=b.loanid"
                        + "    )"
                        + "    set NEEDADDCD=needaddcd2"
                        + "");
                dc.commit();
                if (updateNeedCDCnt < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage(PropertyManager.getProperty("300"));
                    return -1;
                }
                logger.debug("更新数据完整状态标志位  end:"+BusinessDate.getTodaytime());
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
           // 异常情况下解锁
            dc.setAuto(true);
            dc.executeUpdate("update SYS_LOCK set SYSLOCKSTATUS ='0'");
            e.printStackTrace();
            this.res.setType(0);
            this.res.setResult(false);
            this.res.setMessage(PropertyManager.getProperty("300"));
            return -1;
        } finally {
            // 解除系统锁
            dc.setAuto(true);
            dc.executeUpdate("update SYS_LOCK set SYSLOCKSTATUS ='0'");
            // 关闭rs对象
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
            }
        }
        // 返回值
        //返回更新记录数、新增记录数、更新抵押到期日记录数、更新待补充资料标志记录数
        this.res.setFieldName("updateCnt;addCnt;updateMortDateCnt;updateNeedCDCnt");
        this.res.setFieldType("text;text;text;text");
        this.res.setEnumType("0;0;0;0");
        this.res.setFieldValue(String.valueOf(updateCnt) + ";" + String.valueOf(addCnt) + ";"
                + String.valueOf(updateMortDateCnt) + ";" + String.valueOf(updateNeedCDCnt));
        this.res.setType(4);
        this.res.setResult(true);
        return 0;
    }
}
