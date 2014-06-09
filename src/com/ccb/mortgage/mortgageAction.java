package com.ccb.mortgage;

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

import com.ccb.dao.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pub.platform.advance.utils.PropertyManager;
import pub.platform.db.RecordSet;
import pub.platform.db.SequenceManager;
import pub.platform.form.control.Action;
import pub.platform.utils.BusinessDate;

import com.ccb.util.CcbLoanConst;
import com.ccb.util.SeqUtil;
import pub.platform.utils.StringUtils;

import java.util.Date;

public class mortgageAction extends Action {
    // 日志对象
    private static final Log logger = LogFactory.getLog(mortgageAction.class);
    // 抵押信息对象
    LNMORTINFO mortInfo = null;
    //20120228 保险单信息表
    LNINSURANCE insurance = null;
    // 废号管理对象
    SYSSEQDISCARD seqInfoDiscard = null;
    // 贷款信息对象
    LNLOANAPPLY loan = null;
    // 流水记录表
    LNTASKINFO task = null;

    /**
     * <p/>
     * 抵押信息增加接口
     * <p/>
     * 成功或失败均返回消息
     * <p/>
     * 部门id、用户id、操作时间均在后台赋值
     *
     * @return
     */
    public int add() {
        mortInfo = new LNMORTINFO();
        insurance = new LNINSURANCE();
        // 取出抵押编号
        String mortID = "";
        for (int i = 0; i < this.req.getRecorderCount(); i++) {
            try {

                // 初始化数据bean
                mortInfo.initAll(i, req);
                // 部门id
                mortInfo.setDeptid(this.getDept().getDeptid());
                // 操作时间
                mortInfo.setOperdate(BusinessDate.getToday());
                // 用户id
                mortInfo.setOperid(this.getOperator().getOperid());
                // 登记状态
                // mortInfo.setMortstatus(CcbLoanConst.NODE_DOING);
                mortInfo.setMortstatus(CcbLoanConst.MORT_FLOW_REGISTED);

                //20130608 zhan 增加抵押预约状态的初始化
                mortInfo.setApptstatus("01");  //待预约申请
                /*
                //城阳”、“崂山”、“即墨”、“胶南”、“胶州”交易中心住房贷款(个人住房贷款011、个人商用房贷款014)抵押流转状态为“已登记资料”的，抵押预约及办理状态自动变为“待办理抵押”，除上之外抵押流转状态为“已登记资料”的都自动变为“待预约申请”。
                String mortecentercd = req.getFieldValue(i, "MORTECENTERCD");
                if ("05".equals(mortecentercd) //崂山
                        || "06".equals(mortecentercd) //城阳
                        || "07".equals(mortecentercd) //即墨
                        || "08".equals(mortecentercd) //胶州
                        || "12".equals(mortecentercd) //胶南
                        ) {
                    //查找贷款类型
                    loan = (LNLOANAPPLY) new LNLOANAPPLY().findFirstByWhere(" where loanid='" + req.getFieldValue(i, "loanid") + "'");
                    if (loan == null) {
                        this.res.setType(0);
                        this.res.setResult(false);
                        this.res.setMessage("未查找到该笔抵押对应的贷款信息，请确认该笔贷款是否已删除：loanid=" + req.getFieldValue(i, "loanid"));
                        return -1;
                    }

                    if ("011".equals(loan.getLn_typ()) || "014".equals(loan.getLn_typ())) {
                        mortInfo.setApptstatus("50");  //待办理抵押
                        //视作自动预约？
                        mortInfo.setAppt_valid_flag("1");  //有效记录
                        mortInfo.setAppt_over_flag("0");  //处理未完成
                    }
                }
                */


                // 未办妥抵押原因 默认值：其他
                //mortInfo.setNomortreasoncd("99");
                // 未办妥抵押原因 默认值：未报送 （20100722 zhanrui）
                //mortInfo.setNomortreasoncd("09");
                // TODO 未办理抵押原因 默认值：未报送 （20110704 zxb）
                // TODO 未办理抵押原因只保留8项，并没有“未报送”一项 , 暂时设置为空
                //mortInfo.setNomortreason("未报送");
                mortInfo.setNomortreasoncd(" ");

                // 抵押登记状态 默认为：未登记：1
                mortInfo.setMortregstatus("1");
                // 版本号
                mortInfo.setRecversion(0);

                // 抵押到日期
                // String mortExpireDate = getMortExpireDate(req);
                String releasecondcd = req.getFieldValue(i, "RELEASECONDCD");
                String mortExpireDate = MortUtil.getMortExpireDate(releasecondcd, req
                        .getFieldValue(i, "MORTDATE"), dc, req.getFieldValue(i, "loanID"), req.getFieldValue(i,
                        "MORTECENTERCD"));

                // TODO:抵押到期日取不出情况下，保存空值
                // 抵押到期日生成失败
                // if ("".equals(mortExpireDate)) {
                // this.res.setType(0);
                // this.res.setResult(false);
                // this.res.setMessage(PropertyManager.getProperty("305"));
                // return -1;
                // }

                mortInfo.setMortexpiredate(mortExpireDate);

                //20100403 zhan
                //如果为签约类 同时更新抵押超批复日期
                if (releasecondcd.equals("03") || releasecondcd.equals("06")) {
                    mortInfo.setMortoverrtndate(mortExpireDate);
                }

                // 是否从废号表取值
                boolean discardFlg = false;

                /*
                20100423 zhan  取消废号管理

                RecordSet rs = dc.executeQuery("select discardno from sys_seq_discard where bhlx='"
                        + CcbLoanConst.MORTTYPE + "' and useflg='0' order by discardno asc ");
                if (rs.next()) {
                    discardFlg = true;
                    mortID = rs.getString("discardno");
                } else {
                    mortID = SeqUtil.getMortID();
                }
                if (rs != null) {
                    rs.close();
                }
                */
                //20100423 zhan 取消废号管理 直接取号
                mortID = SeqUtil.getMortID();
                mortInfo.setMortid(mortID);

                if (mortInfo.insert() < 0) {
                    // ------已生成的抵押编号进废号管理表--------
                    seqInfoDiscard = new SYSSEQDISCARD();
                    // 使用标志：未使用
                    seqInfoDiscard.setUseflg(0);
                    // 贷款申请序号
                    seqInfoDiscard.setNseqno(req.getFieldValue(i, "loanid"));
                    // 进表时间
                    seqInfoDiscard.setIndate(BusinessDate.getNowDay());
                    // 进表操作人员
                    seqInfoDiscard.setInoperid(this.getOperator().getOperid());
                    // 抵押编号
                    seqInfoDiscard.setDiscardno(mortID);
                    // 废号码类型
                    seqInfoDiscard.setBhlx(CcbLoanConst.MORTTYPE);
                    // 进表类型
                    seqInfoDiscard.setDotype("add");

                    if (seqInfoDiscard.insert() < 0) {
                        this.res.setType(0);
                        this.res.setResult(false);
                        this.res.setMessage(PropertyManager.getProperty("300"));
                        return -1;
                    }

                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage(PropertyManager.getProperty("300"));
                    return -1;
                }

                //20120228 add 插入保险单信息数据
                String attendflag = req.getFieldValue(i, "attendflag");
                if (attendflag.equals("1")) {
                    insurance.setAttendflag(attendflag); //插入办理保险单标志
                    insurance.setLoanid(req.getFieldValue(i, "loanid"));
                    insurance.setMortid(mortID);
//                    0=未入库；1=已入库；2=已结清
                    insurance.setInsurancests("0");
                    insurance.setOperid2(this.getOperator().getOperid());
                    insurance.setOperdate(BusinessDate.getToday());
                    if (insurance.insert() < 0) {
                        this.res.setType(0);
                        this.res.setResult(false);
                        this.res.setMessage(PropertyManager.getProperty("300"));
                        return -1;
                    }
                }

                // 判断该序号是否从废弃表取得，如果是则更新废号管理表
                if (discardFlg) {
                    seqInfoDiscard = new SYSSEQDISCARD();
                    // 使用标志：已使用
                    seqInfoDiscard.setUseflg(1);
                    seqInfoDiscard.setNseqno(req.getFieldValue(i, "loanid"));
                    seqInfoDiscard.setUsedate(BusinessDate.getNowDay());
                    seqInfoDiscard.setUseoperid(this.getOperator().getOperid());
                    // 该处更新条件可以更唯一
                    if (seqInfoDiscard.updateByWhere(" where  bhlx='" + CcbLoanConst.MORTTYPE + "' and discardno='"
                            + mortID + "'") < 0) {
                        this.res.setType(0);
                        this.res.setResult(false);
                        this.res.setMessage(PropertyManager.getProperty("300"));
                        return -1;
                    }
                }
                // 更新贷款信息表
                loan = new LNLOANAPPLY();
                loan.init(i, req);
                if (loan.updateByWhere(" where loanid='" + req.getFieldValue(i, "loanid") + "'") <= 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("更新贷款表的放款方式失败，请确认该笔贷款是否已删除：loanid=" + req.getFieldValue(i, "loanid"));
                    return -1;
                }

                //更新档案信息表中的mortid
                LNARCHIVEINFO lnarchiveinfo = new LNARCHIVEINFO();
                lnarchiveinfo.setMortid(mortID);
                if (lnarchiveinfo.updateByWhere(" where loanid='" + req.getFieldValue(i, "loanid") + "'") < 0) {
                    logger.error("未找到对应的LN_ARCHIVE_INFO记录，可能是旧数据。");
                }

                // 流水日志表
                task = MortUtil.getTaskObj(req.getFieldValue(i, "loanid"), CcbLoanConst.BUSINODE_010,
                        CcbLoanConst.OPER_ADD);
                task.setOperid(this.getOperator().getOperid());
                task.setBankid(this.getOperator().getDeptid());
                if (task.insert() < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage(PropertyManager.getProperty("300"));
                    return -1;
                }

            } catch (Exception ex1) {
                ex1.printStackTrace();
                logger.error(ex1.getMessage());
                this.res.setType(0);
                this.res.setResult(false);
                this.res.setMessage(PropertyManager.getProperty("300"));
                return -1;
            }
        }
        // this.res.setType(0);
        // this.res.setResult(true);
        // this.res.setMessage(PropertyManager.getProperty("200"));
        // return 0;

        this.res.setFieldName("mortID");
        this.res.setFieldType("text");
        this.res.setEnumType("0");
        this.res.setFieldValue(mortID);
        this.res.setType(4);
        this.res.setResult(true);
        return 0;

    }

    /**
     * <p/>
     * 抵押信息编辑接口
     * <p/>
     * 除了更新页面上的值之外，用户id、操作时间也一起更新；
     * <p/>
     * 更新前进行版本号检查，控制并发问题
     *
     * @return
     */
    public int edit() {

        mortInfo = new LNMORTINFO();
        for (int i = 0; i < this.req.getRecorderCount(); i++) {
            try {
                // 初始化数据bean
                mortInfo.initAll(i, req);
                /*
                 * // ---根据未办理抵押原因进行状态修改--- // 贷款已结清、已撤卷 抵押登记状态改为【贷款结清取证登记】已结清取证
                 * if (req.getFieldValue(i, "NOMORTREASONCD") != null) { if
                 * (req.getFieldValue(i, "NOMORTREASONCD").equals("08") ||
                 * req.getFieldValue(i, "NOMORTREASONCD").equals("17")) { //
                 * 已结清取证 mortInfo.setMortstatus("50"); } }
                 */
                // ---根据未办理抵押原因进行状态修改---
                // 贷款已结清、已撤卷 抵押登记状态改为【贷款结清取证登记】已结清取证
                if (req.getFieldValue(i, "NOMORTREASONCD") != null) {
                    if (req.getFieldValue(i, "NOMORTREASONCD").equals("08")) {
                        // 未抵押贷款已结清
                        mortInfo.setMortstatus(CcbLoanConst.MORT_FLOW_NOMORT_CLEARED);
                    } else if (req.getFieldValue(i, "NOMORTREASONCD").equals("17")) {
                        // 已撤卷
                        mortInfo.setMortstatus(CcbLoanConst.MORT_FLOW_NOMORT_GETBOOK);
                    }
                }

                //20100403  zhan   田琨
                //在处理他行开发贷不可报抵押时 同时将“未办理抵押原因” 修改为 “他行开发贷”:04
                String sendflag = req.getFieldValue(i, "SENDFLAG");
                if (sendflag != null) {
                    //可能为空字符串，或为“0”，或为“1”
                    if (sendflag.equals("0")) {
                        // bankflag=1 本行   03：土地未撤押 20110928 haiyu
                        // bankflag=2 他行   04 他行开发贷
                        String bankflag = req.getFieldValue(i, "bankflag");
                        if (bankflag == null) {
                            RecordSet projRs = dc.executeQuery("select b.bankflag from ln_loanapply a,ln_coopproj b where a.proj_no=b.proj_no and a.loanid = '"
                                    + req.getFieldValue(i, "loanid") + "'");
                            while (projRs.next()) {
                                bankflag = projRs.getString("bankflag");
                            }
                            projRs.close();
                        }
                        if (bankflag.equals("1")) {
                            mortInfo.setNomortreasoncd("03");
                        } else if (bankflag.equals("2")) {
                            mortInfo.setNomortreasoncd("04");
                        }
                    } else if (sendflag.equals("1")) {
                        //设置空格 空时数据=null 无法统计 20110928 haiyu
                        mortInfo.setNomortreasoncd(" ");
                    } else if (sendflag.equals("A")) {
                        //设置空格 空时数据=null 无法统计 20130408
                        mortInfo.setNomortreasoncd(" ");
                    }
                }

                //20130608 zhan 田琨
                //所有抵押流转状态为“权证已入库”， 抵押预约及办理状态也自动变为“权证已入库”
                if (CcbLoanConst.MORT_FLOW_SAVED.equals(mortInfo.getMortstatus())) {
                    mortInfo.setApptstatus("90");  //权证已入库
                    mortInfo.setAppt_over_flag("1"); //本次预约全部办理过程已完成
                }
                //20130721 zhan 仲景
                //所有抵押流转状态为“已借证回证”的， 抵押预约及办理状态也自动变为“已借证回证”
                if (CcbLoanConst.MORT_FLOW_CHANGED_RETURN.equals(mortInfo.getMortstatus())) {
                    mortInfo.setApptstatus("91");  //已借证回证
                    mortInfo.setAppt_over_flag("1"); //本次预约全部办理过程已完成
                }
                //20130624 zhan 仲景
                //抵押状态：抵押材料签收(20A)------>预约状态：待预约申请
                if (CcbLoanConst.MORT_FLOW_DATA_SIGNIN.equals(mortInfo.getMortstatus())) {
                    mortInfo.setApptstatus("01");  //待预约申请
                }


                // 操作时间
                mortInfo.setOperdate(BusinessDate.getToday());
                // 用户id
                mortInfo.setOperid(this.getOperator().getOperid());

                boolean isNeedCheckRecversion = true;
                // 更新前版本号
                int iBeforeVersion = 0;
                if (req.getFieldValue(i, "recVersion") != null && !req.getFieldValue(i, "recVersion").equals("")) {
                    iBeforeVersion = Integer.parseInt(req.getFieldValue(i, "recVersion"));
                } else {
                    //20130816 zr  若req中未置 recversion的值，暂时认为是不需要做版本检查（待完善）
                    isNeedCheckRecversion = false;
                }

                int iAfterVersion = 0;
                RecordSet rs = dc.executeQuery("select recversion,documentid,deptid from ln_mortinfo where mortid='"
                        + req.getFieldValue(i, "mortid") + "'");
                while (rs.next()) {
                    iAfterVersion = rs.getInt("recVersion");
                    if (iBeforeVersion != iAfterVersion) {
                        if (isNeedCheckRecversion) {
                            this.res.setType(0);
                            this.res.setResult(false);
                            this.res.setMessage(PropertyManager.getProperty("301"));
                            return -1;
                        }else{
                            logger.error("[ERRTYPE=1111]recversion不符：morid=" + req.getFieldValue(i, "mortid"));
                        }
                    }
                    // 版本号加1
                    iBeforeVersion = iBeforeVersion + 1;
                    mortInfo.setRecversion(iBeforeVersion);

                    //20130619 zr
                    //重要档案编号处理规则：先检查是否有变更，若有变更，需检查在相同deptid下号码是否重复
                    String uiDocumentid = req.getFieldValue(i, "documentid");
                    if (uiDocumentid != null && !"".equals(uiDocumentid)) {
                        String dbDeptid = rs.getString("deptid") == null ? "" : rs.getString("deptid");
                        String dbDocumentid = rs.getString("documentid") == null ? "" : rs.getString("documentid");
                        if (!dbDocumentid.equals(uiDocumentid)) {//有变更
                            rs = dc.executeQuery("select count(*) as cnt  from ln_mortinfo where mortid !='"
                                    + req.getFieldValue(i, "mortid") + "'"
                                    + " and deptid='" + dbDeptid + "' "
                                    + " and documentid='" + uiDocumentid + "' ");
                            while (rs.next()) {
                                int count = rs.getInt("cnt");
                                if (count > 0) {
                                    this.res.setType(0);
                                    this.res.setResult(false);
                                    this.res.setMessage("重要档案编号重复！");
                                    return -1;
                                }
                            }
                        }
                    } else {
                        //值为空的情况有两种，1：初值即为空 2：原值不为空，现置为空（特殊处理通道有可能发生）
                        //暂不处理.
                    }
                }
                if (rs != null) {
                    rs.close();
                }

                if (mortInfo.updateByWhere(" where mortid='" + req.getFieldValue(i, "mortid") + "'") < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage(PropertyManager.getProperty("300"));
                    return -1;
                }
                // 流水日志表
                task = MortUtil.getTaskObj(req.getFieldValue(i, "loanid"), req.getFieldValue(i, "busiNode"),
                        CcbLoanConst.OPER_EDIT);
                task.setOperid(this.getOperator().getOperid());
                task.setBankid(this.getOperator().getDeptid());
                if (task.insert() < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage(PropertyManager.getProperty("300"));
                    return -1;
                }

            } catch (Exception ex1) {
                ex1.printStackTrace();
                logger.error(ex1.getMessage());
                this.res.setType(0);
                this.res.setResult(false);
                //this.res.setMessage(PropertyManager.getProperty("300"));
                this.res.setMessage("处理失败：" + ex1.getMessage());
                return -1;
            }
        }
        this.res.setType(0);
        this.res.setResult(true);
        this.res.setMessage(PropertyManager.getProperty("200"));
        return 0;
    }

    /**
     * <p/>
     * 删除接口
     * <p/>
     * 删除一条记录后，抵押编号要保存进废弃号码管理表，以备下次继续使用
     */
    public int delete() {
        seqInfoDiscard = new SYSSEQDISCARD();

        try {
            // 抵押编号
            String mortID = req.getFieldValue("mortID");
            // 抵押编号得不到的情况下提示操作失败
            if (mortID == null || mortID.equalsIgnoreCase("null")) {
                this.res.setType(0);
                this.res.setResult(false);
                this.res.setMessage(PropertyManager.getProperty("300"));
                return -1;
            }

            /** 抵押编号保存进废弃号码管理表 */
            // 编号类型
            seqInfoDiscard.setBhlx(CcbLoanConst.MORTTYPE);
            // 抵押编号
            seqInfoDiscard.setDiscardno(mortID);
            // 使用标志: 未使用状态；
            seqInfoDiscard.setUseflg(0);
            // 原关系业务序号:贷款申请序号
            seqInfoDiscard.setOseqno(req.getFieldValue("loanID"));
            // 进表日期
            seqInfoDiscard.setIndate(BusinessDate.getNowDay());
            // 进表人员
            seqInfoDiscard.setInoperid(this.getOperator().getOperid());
            // 进表类型
            seqInfoDiscard.setDotype("delete");

            if (seqInfoDiscard.insert() < 0) {
                this.res.setType(0);
                this.res.setResult(false);
                this.res.setMessage(PropertyManager.getProperty("300"));
                return -1;
            }

            // 删除抵押信息
            dc.executeUpdate("delete from ln_mortinfo where mortid='" + mortID + "'");
            // 流水日志表
            task = MortUtil.getTaskObj(req.getFieldValue("loanid"), req.getFieldValue("busiNode"),
                    CcbLoanConst.OPER_DEL);
            task.setOperid(this.getOperator().getOperid());
            task.setBankid(this.getOperator().getDeptid());
            if (task.insert() < 0) {
                this.res.setType(0);
                this.res.setResult(false);
                this.res.setMessage(PropertyManager.getProperty("300"));
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            this.res.setType(0);
            this.res.setResult(false);
            this.res.setMessage(PropertyManager.getProperty("300"));
            return -1;
        }

        this.res.setType(0);
        return 0;
    }

    /**
     * <p/>
     * 如果用户直接退出抵押管理页面，则把已生成的抵押编号放进废弃表中以备下次使用
     * <p/>
     */
    public int saveMortID_bak() {
        seqInfoDiscard = new SYSSEQDISCARD();

        try {
            // 抵押编号
            String mortID = req.getFieldValue("mortID");
            /** 抵押编号保存进废弃号码管理表 */
            // 业务类型
            seqInfoDiscard.setBhlx(CcbLoanConst.MORTTYPE);
            // 编号
            seqInfoDiscard.setDiscardno(mortID);
            // 使用标志: 未使用状态；
            seqInfoDiscard.setUseflg(0);
            // 原关系业务序号:贷款申请序号
            seqInfoDiscard.setOseqno(req.getFieldValue("loanID"));

            /** 先判断废号管理表中有无该没有使用的序号，如果没有则增加 */
            RecordSet rs = dc.executeQuery("select 1 from sys_seq_discard where bhlx='" + CcbLoanConst.MORTTYPE
                    + "' and discardno='" + mortID + "' and useflg='0'");
            if (!rs.next()) {
                if (seqInfoDiscard.insert() < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage(PropertyManager.getProperty("300"));
                    return -1;
                }
            } else {
                // do nothing
            }
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            this.res.setType(0);
            this.res.setResult(false);
            this.res.setMessage(PropertyManager.getProperty("300"));
            return -1;
        }

        this.res.setType(0);
        return 0;
    }

    /**
     * <p/>
     * 批量快递
     * <p/>
     * 除了更新页面上的值之外，用户id、操作时间也一起更新；
     * <p/>
     * 更新前进行版本号检查，控制并发问题
     *
     * @return
     */
    public int batchEdit() {

        mortInfo = new LNMORTINFO();
        for (int i = 0; i < this.req.getRecorderCount(); i++) {
            try {
                // 初始化数据bean
                mortInfo.initAll(i, req);
                // 操作时间
                mortInfo.setOperdate(BusinessDate.getToday());
                // 用户id
                mortInfo.setOperid(this.getOperator().getOperid());
                // 柜号
                if (req.getFieldValue(i, "boxid") != null) {
                    mortInfo.setBoxid(req.getFieldValue(i, "boxid"));
                }
                // 更新前版本号
                int iBeforeVersion = Integer.parseInt(req.getFieldValue(i, "recVersion"));
                int iAfterVersion = 0;
                RecordSet rs = dc.executeQuery("select recversion from ln_mortinfo where mortid='"
                        + req.getFieldValue(i, "mortid") + "'");
                while (rs.next()) {
                    iAfterVersion = rs.getInt("recVersion");
                    if (iBeforeVersion != iAfterVersion) {
                        this.res.setType(0);
                        this.res.setResult(false);
                        this.res.setMessage(PropertyManager.getProperty("301"));
                        return -1;
                    } else {
                        // 版本号加1
                        iBeforeVersion = iBeforeVersion + 1;
                        mortInfo.setRecversion(iBeforeVersion);
                    }
                }
                if (rs != null) {
                    rs.close();
                }

                if (mortInfo.updateByWhere(" where mortid='" + req.getFieldValue(i, "mortid") + "'") < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage(PropertyManager.getProperty("300"));
                    return -1;
                }
                // 流水日志表
                task = MortUtil.getTaskObj(req.getFieldValue(i, "loanid"), req.getFieldValue(i, "busiNode"),
                        CcbLoanConst.OPER_BATCHEDIT);
                task.setOperid(this.getOperator().getOperid());
                task.setBankid(this.getOperator().getDeptid());
                if (task.insert() < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage(PropertyManager.getProperty("300"));
                    return -1;
                }

            } catch (Exception ex1) {
                ex1.printStackTrace();
                logger.error(ex1.getMessage());
                this.res.setType(0);
                this.res.setResult(false);
                this.res.setMessage(PropertyManager.getProperty("300"));
                return -1;
            }
        }

        this.res.setType(0);
        this.res.setResult(true);
        this.res.setMessage(PropertyManager.getProperty("200"));
        return 0;
    }

    /**
     * <p/>
     * 修改抵押信息中的贷款申请号
     * <p/>
     * 更新前进行版本号检查，控制并发问题
     *
     * @return
     */
    public int editLoanId() {

        mortInfo = new LNMORTINFO();
        for (int i = 0; i < this.req.getRecorderCount(); i++) {
            try {
                // 初始化数据bean
                mortInfo.initAll(i, req);

                LNMORTINFO mortTmp = mortInfo.findFirst(" where  loanid = '" + mortInfo.getLoanid() + "'");
                if (mortTmp != null) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("修改贷款申请号出现错误, 此申请号已关联到:" + mortTmp.getMortid() + "号抵押。");
                    return -1;
                }

                LNLOANAPPLY loanTmp = new LNLOANAPPLY();
                loanTmp = loanTmp.findFirst(" where  loanid = '" + mortInfo.getLoanid() + "'");
                if (loanTmp == null) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("修改贷款申请号出现错误, 此申请号不存在。");
                    return -1;
                }


                // 操作时间
                mortInfo.setOperdate(BusinessDate.getToday());
                // 用户id
                mortInfo.setOperid(this.getOperator().getOperid());
                // 更新前版本号
                int iBeforeVersion = 0;
                if (req.getFieldValue(i, "recVersion") != null && !req.getFieldValue(i, "recVersion").equals("")) {
                    iBeforeVersion = Integer.parseInt(req.getFieldValue(i, "recVersion"));
                }
                int iAfterVersion = 0;
                RecordSet rs = dc.executeQuery("select recversion from ln_mortinfo where mortid='"
                        + req.getFieldValue(i, "mortid") + "'");
                while (rs.next()) {
                    iAfterVersion = rs.getInt("recVersion");
                    if (iBeforeVersion != iAfterVersion) {
                        this.res.setType(0);
                        this.res.setResult(false);
                        this.res.setMessage(PropertyManager.getProperty("301"));
                        return -1;
                    } else {
                        // 版本号加1
                        iBeforeVersion = iBeforeVersion + 1;
                        mortInfo.setRecversion(iBeforeVersion);
                    }
                }
                if (rs != null) {
                    rs.close();
                }

                if (mortInfo.updateByWhere(" where mortid='" + req.getFieldValue(i, "mortid") + "'") < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage(PropertyManager.getProperty("300"));
                    return -1;
                }
                // 流水日志表
                task = MortUtil.getTaskObj(req.getFieldValue(i, "loanid"), req.getFieldValue(i, "busiNode"),
                        CcbLoanConst.OPER_EDIT);
                task.setOperid(this.getOperator().getOperid());
                task.setBankid(this.getOperator().getDeptid());
                if (task.insert() < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage(PropertyManager.getProperty("300"));
                    return -1;
                }

            } catch (Exception ex1) {
                ex1.printStackTrace();
                logger.error(ex1.getMessage());
                this.res.setType(0);
                this.res.setResult(false);
                this.res.setMessage(PropertyManager.getProperty("300"));
                return -1;
            }
        }
        this.res.setType(0);
        this.res.setResult(true);
        this.res.setMessage(PropertyManager.getProperty("200"));
        return 0;
    }

    //根据抵押信息里的deptid 分别生成重要档案编号序列。
    public int generateDocumentID() {
        mortInfo = new LNMORTINFO();
        try {
            String sn = "";
            String mortid = req.getFieldValue(0, "mortid");
            mortInfo = (LNMORTINFO) mortInfo.findFirstByWhere(" where mortid='" + mortid + "'");
            if (mortInfo != null) {
                String temp = "" + SequenceManager.nextID("DOCID_" + mortInfo.getDeptid());
                sn = StringUtils.toDateFormat(new Date(), "yyyy") + StringUtils.addPrefix(temp, "0", 5);
                this.res.setFieldName("docid");
                this.res.setFieldType("text");
                this.res.setEnumType("0");
                this.res.setFieldValue(sn);
                this.res.setType(4);
                this.res.setResult(true);
            } else {
                this.res.setType(0);
                this.res.setResult(false);
                this.res.setMessage("重要档案编号生成失败, 该笔抵押不存在:" + req.getFieldValue(0, "mortid"));
                return -1;
            }
        } catch (Exception e) {
            logger.error("重要档案编号生成失败:", e);
            this.res.setType(0);
            this.res.setResult(false);
            this.res.setMessage("重要档案编号生成失败:" + e.getMessage());
            return -1;
        }
        return 0;
    }
}
