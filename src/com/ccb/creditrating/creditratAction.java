package com.ccb.creditrating;

/**
 * <p>Title: 后台业务组件</p>
 * <p>Description: 后台业务组件</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: 公司</p>
 * @author
 * @version 1.0
 */

import com.ccb.dao.*;
import com.ccb.mortgage.MortUtil;
import com.ccb.util.CcbLoanConst;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import pub.platform.db.ConnectionManager;
import pub.platform.db.DatabaseConnection;
import pub.platform.db.RecordSet;
import pub.platform.form.control.Action;
import pub.platform.utils.BusinessDate;
import pub.platform.utils.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class creditratAction extends Action {
    LNPCIF pcif = null;
    LNUNCOMCREDIT uncomcredit = null;
    LNPSCOREMODEL lnpscoremodel = null;
    LNTASKINFO task = null;
    LNPSCOREDETAIL lnpscoredetail = null;
    ConnectionManager cm = ConnectionManager.getInstance();
    DatabaseConnection dc = cm.get();
    private static final Log logger = LogFactory.getLog(creditratAction.class);

    /**
     * 增加客户信息
     *
     * @return
     */
    public int add() {
        pcif = new LNPCIF();
        for (int i = 0; i < this.req.getRecorderCount(); i++) {
            try {
                pcif.initAll(i, req); // 初始化数据bean
                LNPCIF lnpcifTmp = LNPCIF.findFirst(" where  idno = '" + pcif.getIdno() + "' and recsta = '1' ");
                if (lnpcifTmp != null) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("增加客户出现错误, 此客户已存在！");
                    return -1;
                }

                int custSeq = 0;
                RecordSet rs = dc.executeQuery("select max(seq) as maxSeq from ln_pcif");
                while (rs.next()) {
                    custSeq = rs.getInt("maxSeq") + 1;
                }
                String coopSeq = StringUtils.toDateFormat(new Date(), "yyyyMMdd") + StringUtils.addPrefix(custSeq + "", "0", 9);
                pcif.setCustno(coopSeq);
                pcif.setDeptid(this.getDept().getDeptid());  // 建立机构号
                pcif.setOperdate(BusinessDate.getToday());    // 建立时间
                pcif.setOperid(this.getOperator().getOperid());   // 建立柜员id
                pcif.setSeq(custSeq);
                if (pcif.insert() < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("添加客户失败！");
                    return -1;
                }
                // 流水日志表
                task = MortUtil.getTaskObj(coopSeq, req.getFieldValue(i, "busiNode"), CcbLoanConst.OPER_ADD);
                task.setOperid(this.getOperator().getOperid());
                task.setBankid(this.getOperator().getDeptid());
                if (task.insert() < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("流水日志添加失败！");
                    return -1;
                }
            } catch (Exception ex1) {
                ex1.printStackTrace();
                logger.error("增加客户出现错误！");
                logger.error(ex1.getMessage());
                this.res.setType(0);
                this.res.setResult(false);
                this.res.setMessage("添加客户失败！");
                return -1;
            }
        }
        this.res.setType(0);
        this.res.setResult(true);
        this.res.setMessage("添加客户成功！");
        return 0;
    }

    /**
     * 客户信息编辑接口
     * 除了更新页面上的值之外，用户id、操作时间也一起更新；
     * 更新前进行版本号检查，控制并发问题
     *
     * @return
     */
    public int edit() {
        pcif = new LNPCIF();
        for (int i = 0; i < this.req.getRecorderCount(); i++) {
            try {
                pcif.initAll(i, req); // 初始化数据bean

                pcif.setUpddate(BusinessDate.getToday());    //修改时间
                pcif.setUpdoperid(this.getOperator().getOperid());   // 修改柜员

                if (pcif.updateByWhere(" where custno='" + req.getFieldValue(i, "custno") + "'") < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("更新客户信息失败！");
                    return -1;
                }

                // 流水日志表
                task = MortUtil.getTaskObj(req.getFieldValue(i, "custno"), req.getFieldValue(i, "busiNode"),
                        CcbLoanConst.OPER_EDIT);
                task.setOperid(this.getOperator().getOperid());
                task.setBankid(this.getOperator().getDeptid());
                if (task.insert() < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("流水日志添加失败！");
                    return -1;
                }
            } catch (Exception ex1) {
                ex1.printStackTrace();
                logger.error("编辑客户信息出现错误！");
                logger.error(ex1.getMessage());
                this.res.setType(0);
                this.res.setResult(false);
                this.res.setMessage("更新客户信息失败！");
                return -1;
            }
        }
        this.res.setType(0);
        this.res.setResult(true);
        this.res.setMessage("更新客户信息成功！");
        return 0;
    }

    //编辑客户等级信息
    public int editCreditLevel() {

        LNCREATLOG lncreatlog = new LNCREATLOG();
        lnpscoredetail = new LNPSCOREDETAIL();
        for (int i = 0; i < this.req.getRecorderCount(); i++) {
            try {
                lnpscoredetail.initAll(i, req);// 初始化数据bean
                LNUNCOMCREDIT uncomcreditTmp = LNUNCOMCREDIT.findFirst(" where  idno = '" + lnpscoredetail.getIdno() + "' and recsta = '1'");
                if (uncomcreditTmp != null) {
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    String validitytime = uncomcreditTmp.getEnddate();
                    Date tempdate = format.parse(validitytime);
                    tempdate.setDate(tempdate.getDate() - 30);
                    String validitytimeTwo = format.format(tempdate);
                    Date sysDate = new Date();
                    if (validitytime.length() > 0) {
                        if (validitytimeTwo.compareTo(format.format(sysDate)) <= 0 && validitytime.compareTo(format.format(sysDate)) >= 0) {
                            this.res.setMessage("此客户在非普通资信评定中已存在且已评信！\r\n 有效期为：" + validitytime + " 但可以记录！");
                        } else if (validitytimeTwo.compareTo(format.format(sysDate)) > 0) {
                            this.res.setType(0);
                            this.res.setResult(false);
                            this.res.setMessage("此客户在非普通资信评定中已存在且已评信！\r\n 有效期为：" + validitytime + " 若贷款已还清，请更改有效期！");
                            return -1;
                        } else if (validitytime.compareTo(format.format(sysDate)) < 0) {
                            this.res.setMessage("此客户在非普通资信评定中已存在且评信已过期！");
                        }
                    } else {
                        this.res.setMessage("此客户在非普通资信评定中已存在但未贷款！");
                    }
                }

                String finbegdate = lnpscoredetail.getFinbegdate();
                String finenddate = lnpscoredetail.getFinenddate();
                int finBegYear = Integer.parseInt(finbegdate.substring(0, 4));
                int finEndYear = Integer.parseInt(finenddate.substring(0, 4));
                int finBegMonth = Integer.parseInt(finbegdate.substring(5, 7));
                int finEndMonth = Integer.parseInt(finenddate.substring(5, 7));
                String timeLimit = ((finEndYear - finBegYear) * 12 + finEndMonth - finBegMonth) + "";
                lnpscoredetail.setTimelimit(timeLimit);

                if ("".equals(lnpscoredetail.getDocid())) {
                    rs = dc.executeQuery("select to_char(sysdate,'yyyy') || lpad(seq_n.nextval,9,'0') as docid from dual");
                    while (rs.next()) {
                        lnpscoredetail.setDocid(rs.getString("docid"));
                    }
                }

                if (lnpscoredetail.updateByWhere(" where creditratingno='" + req.getFieldValue(i, "creditratingno") + "'") < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("编辑失败！");
                    return -1;
                }

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date validitytime = null;
                LNPCIF lnpcif = LNPCIF.findFirst("where custno='" + lnpscoredetail.getCustno() + "'");
                lnpcif.setValiditytime(lnpscoredetail.getFinenddate());
                try {
                    Date dateTemp = simpleDateFormat.parse(lnpscoredetail.getFinenddate());
                    validitytime = new Date(dateTemp.getYear(), dateTemp.getMonth(), dateTemp.getDate() - 30);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                lnpcif.setValiditytimetwo(simpleDateFormat.format(validitytime));
                lnpcif.updateByWhere("where custno='" + lnpscoredetail.getCustno() + "'");

                // 流水日志表
                RecordSet rs = dc.executeQuery("select t.newdate as datevalue from ln_creatlog t where t.creditratingno = '" + lnpscoredetail.getCreditratingno() + "' and t.opertime = (select max(lc.opertime) from ln_creatlog lc where lc.creditratingno = t.creditratingno)");
                String datevalue = "";
                while (rs.next()) {
                    datevalue = rs.getTimeString("datevalue");
                }
                lncreatlog.setCreditratingno(lnpscoredetail.getCreditratingno());
                lncreatlog.setOpername(this.getOperator().getOpername());
                lncreatlog.setOpertime(BusinessDate.getToday());
                lncreatlog.setOlddate(datevalue);
                lncreatlog.setCreattype("0");
                lncreatlog.setNewdate(lnpscoredetail.getFinenddate());
                if (lncreatlog.insert() < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("添加日志失败！");
                    return -1;
                }

                task = MortUtil.getTaskObj(req.getFieldValue(i, "custno"), req.getFieldValue(i, "busiNode"),
                        CcbLoanConst.OPER_EDIT);
                task.setOperid(this.getOperator().getOperid());
                task.setBankid(this.getOperator().getDeptid());
                if (task.insert() < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("添加流水日志失败！");
                    return -1;
                }
            } catch (Exception ex1) {
                ex1.printStackTrace();
                logger.error("编辑失败！");
                logger.error(ex1.getMessage());
                this.res.setType(0);
                this.res.setResult(false);
                this.res.setMessage("编辑失败！");
                return -1;
            }
        }
        this.res.setType(0);
        this.res.setResult(true);
        this.res.setMessage("操作成功！");
        return 0;
    }

    /**
     * 客户信息置为失效接口
     *
     * @return
     */
    public int delete() {
        pcif = new LNPCIF();
        for (int i = 0; i < this.req.getRecorderCount(); i++) {
            try {
                pcif.initAll(i, req); // 初始化数据bean
                if (dc.executeUpdate("update ln_pcif set recsta = '2' where custno = '" + pcif.getCustno() + "'") < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("删除失败！");
                    return -1;
                }
                // 流水日志表
                task = MortUtil.getTaskObj(req.getFieldValue(i, "custno"), req.getFieldValue(i, "busiNode"),
                        CcbLoanConst.OPER_EDIT);
                task.setOperid(this.getOperator().getOperid());
                task.setBankid(this.getOperator().getDeptid());
                if (task.insert() < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("添加流水日志失败！");
                    return -1;
                }

            } catch (Exception ex1) {
                ex1.printStackTrace();
                logger.error("删除客户失败！");
                logger.error(ex1.getMessage());
                this.res.setType(0);
                this.res.setResult(false);
                this.res.setMessage("删除客户失败！");
                return -1;
            }
        }
        this.res.setType(0);
        this.res.setResult(true);
        this.res.setMessage("操作成功！");
        return 0;
    }

    //条形码中的保存函数
    public int savePscoreDetail() {
        lnpscoredetail = new LNPSCOREDETAIL();
        for (int i = 0; i < this.req.getRecorderCount(); i++) {
            try {
                lnpscoredetail.initAll(i, req); // 初始化数据bean
                if (lnpscoredetail.updateByWhere(" where creditratingno='" + req.getFieldValue(i, "creditratingno") + "'") < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("操作失败！");
                    return -1;
                }
                // 流水日志表
                task = MortUtil.getTaskObj(req.getFieldValue(i, "creditratingno"), req.getFieldValue(i, "busiNode"),
                        CcbLoanConst.OPER_EDIT);
                task.setOperid(this.getOperator().getOperid());
                task.setBankid(this.getOperator().getDeptid());
                if (task.insert() < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("添加流水日志失败！");
                    return -1;
                }
            } catch (Exception ex1) {
                ex1.printStackTrace();
                logger.error("操作失败！");
                logger.error(ex1.getMessage());
                this.res.setType(0);
                this.res.setResult(false);
                this.res.setMessage("操作失败！");
                return -1;
            }
        }
        this.res.setType(0);
        this.res.setResult(true);
        this.res.setMessage("操作成功！");
        return 0;
    }

    //对非普通资信评定的系列方法
    public int addUncomcredit() {
        uncomcredit = new LNUNCOMCREDIT();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < this.req.getRecorderCount(); i++) {
            try {
                uncomcredit.initAll(i, req); // 初始化数据bean
                RecordSet rs1 = dc.executeQuery("select max(t.enddate) as latestdate from ln_uncomcredit t where t.idno = '" + uncomcredit.getIdno() + "' and t.recsta = '1' ");
                while (rs1.next()) {
                    Date latestDate = rs1.getCalendar("latestdate");
                    if (latestDate != null) {
                        Date latestDate2 = new Date(latestDate.getYear(), latestDate.getMonth(), latestDate.getDate() - 30);
                        Date temp = new Date();
                        if (temp.before(latestDate2)) {
                            this.res.setType(0);
                            this.res.setResult(false);
                            this.res.setMessage("此客户已存在且已评信！\r\n 有效期为：" + format.format(latestDate) + " 若贷款已还清，请更改有效期！");
                            return -1;
                        } else if (temp.after(latestDate2) && temp.before(latestDate)) {
                            this.res.setMessage("此客户已存在且已评信！\r\n 有效期为：" + format.format(latestDate) + " 但可以记录！");
                        } else if (temp.after(latestDate)) {
                            this.res.setMessage("此客户已存在且评信已过期！");
                        }
                    }
                }
                LNPCIF lnpcifTmp = LNPCIF.findFirst(" where  idno = '" + uncomcredit.getIdno() + "' and recsta  = '1' ");
                if (lnpcifTmp != null) {
                    if (lnpcifTmp.getValiditytime().length() > 0) {
                        Date validitytime = format.parse(lnpcifTmp.getValiditytime());
                        Date validitytimeTwo = format.parse(lnpcifTmp.getValiditytimetwo());
                        Date sysDate = new Date();
                        if (sysDate.before(validitytimeTwo)) {
                            this.res.setType(0);
                            this.res.setResult(false);
                            this.res.setMessage("此客户在普通资信评定中已存在且已评信！\r\n 有效期为：" + format.format(validitytime) + " 若贷款已还清，请联系分行！");
                            return -1;
                        } else if (sysDate.after(validitytimeTwo) && sysDate.before(validitytime)) {
                            this.res.setMessage("此客户在普通资信评定中已存在且已评信！\r\n 有效期为：" + format.format(validitytime) + " 但可以评信！");
                        } else if (sysDate.after(validitytime)) {
                            this.res.setMessage("此客户在普通资信评定中已存在且评信已过期！");
                        }
                    } else {
                        this.res.setMessage("此客户在普通资信评定中已存在但未评信！");
                    }
                }
                // 客户序号
                int custseqnum = 0;
                RecordSet rs = dc.executeQuery("select max(seqnum) as custmax from ln_uncomcredit where judgedeptid = '" + this.getDept().getDeptid() + "' and (to_char(sysdate,'yyyy-mm-dd') = to_char(judgedate,'yyyy-mm-dd')) and recsta = '1' ");
                while (rs.next()) {
                    custseqnum = rs.getInt("custmax") + 1;
                }
                String coopSeq = this.getDept().getDeptid() + StringUtils.toDateFormat(new Date(), "yyyyMMdd") + StringUtils.addPrefix(custseqnum + "", "0", 3);
                String pkid = UUID.randomUUID().toString();
                uncomcredit.setPkid(pkid);
                uncomcredit.setCreditratingno(coopSeq);
                uncomcredit.setJudgedeptid(this.getDept().getDeptid());  // 建立机构号
                uncomcredit.setJudgedate(BusinessDate.getToday());    // 建立时间
                uncomcredit.setJudgeoperid(this.getOperator().getOperid());   // 建立柜员id
                uncomcredit.setSeqnum(custseqnum);
                if (uncomcredit.insert() < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("添加失败！");
                    return -1;
                }
                // 流水日志表
                task = MortUtil.getTaskObj(uncomcredit.getIdno(), req.getFieldValue(i, "busiNode"), CcbLoanConst.OPER_ADD);
                task.setOperid(this.getOperator().getOperid());
                task.setBankid(this.getOperator().getDeptid());
                if (task.insert() < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("添加流水日志失败！");
                    return -1;
                }
            } catch (Exception ex1) {
                ex1.printStackTrace();
                logger.error("添加失败！");
                logger.error(ex1.getMessage());
                this.res.setType(0);
                this.res.setResult(false);
                this.res.setMessage("添加失败！");
                return -1;
            }
        }
        this.res.setType(0);
        this.res.setResult(true);
        this.res.setMessage("操作成功！");
        return 0;
    }

    public int appendUncomcredit() {
        uncomcredit = new LNUNCOMCREDIT();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < this.req.getRecorderCount(); i++) {
            try {
                uncomcredit.initAll(i, req); // 初始化数据bean
                if (!uncomcredit.getJudgetype().equals("01")) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("此操作只适用于集体评信！");
                    return -1;
                }
                RecordSet rs1 = dc.executeQuery("select max(t.enddate) as latestdate from ln_uncomcredit t where t.idno = '" + uncomcredit.getIdno() + "' and t.recsta = '1'");
                while (rs1.next()) {
                    Date latestDate = rs1.getCalendar("latestdate");
                    if (latestDate != null) {
                        Date latestDate2 = new Date(latestDate.getYear(), latestDate.getMonth(), latestDate.getDate() - 30);
                        Date temp = new Date();
                        if (temp.before(latestDate2)) {
                            this.res.setType(0);
                            this.res.setResult(false);
                            this.res.setMessage("此客户已存在且已评信！\r\n 有效期为：" + format.format(latestDate) + " 若贷款已还清，请更改有效期！");
                            return -1;
                        } else if (temp.after(latestDate2) && temp.before(latestDate)) {
                            this.res.setMessage("此客户已存在且已评信！\r\n 有效期为：" + format.format(latestDate) + " 但可以记录！");
                        } else if (temp.after(latestDate)) {
                            this.res.setMessage("此客户已存在且评信已过期！");
                        }
                    }
                }
                LNPCIF lnpcifTmp = LNPCIF.findFirst(" where  idno = '" + uncomcredit.getIdno() + "' and recsta = '1'");
                if (lnpcifTmp != null) {
                    if (lnpcifTmp.getValiditytime().length() > 0) {
                        Date validitytime = format.parse(lnpcifTmp.getValiditytime());
                        Date validitytimeTwo = format.parse(lnpcifTmp.getValiditytimetwo());
                        Date sysDate = new Date();
                        if (sysDate.before(validitytimeTwo)) {
                            this.res.setType(0);
                            this.res.setResult(false);
                            this.res.setMessage("此客户在普通资信评定中已存在且已评信！\r\n 有效期为：" + format.format(validitytime) + " 若贷款已还清，请联系分行！");
                            return -1;
                        } else if (sysDate.after(validitytimeTwo) && sysDate.before(validitytime)) {
                            this.res.setMessage("此客户在普通资信评定中已存在且已评信！\r\n 有效期为：" + format.format(validitytime) + " 但可以评信！");
                        } else if (sysDate.after(validitytime)) {
                            this.res.setMessage("此客户在普通资信评定中已存在且评信已过期！");
                        }
                    } else {
                        this.res.setMessage("此客户在普通资信评定中已存在但未评信！");
                    }
                }
                String creditratingno = uncomcredit.getCreditratingno();
                int seqNum = Integer.parseInt(creditratingno.substring(creditratingno.length() - 3));
                String pkid = UUID.randomUUID().toString();
                uncomcredit.setPkid(pkid);
                uncomcredit.setJudgedeptid(this.getDept().getDeptid());  // 建立机构号
                uncomcredit.setJudgedate(BusinessDate.getToday());    // 建立时间
                uncomcredit.setJudgeoperid(this.getOperator().getOperid());   // 建立柜员id
                uncomcredit.setSeqnum(seqNum);
                if (uncomcredit.insert() < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("追加失败！");
                    return -1;
                }
                // 流水日志表
                task = MortUtil.getTaskObj(uncomcredit.getIdno(), req.getFieldValue(i, "busiNode"), CcbLoanConst.OPER_ADD);
                task.setOperid(this.getOperator().getOperid());
                task.setBankid(this.getOperator().getDeptid());
                if (task.insert() < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("添加流水日志失败！");
                    return -1;
                }
            } catch (Exception ex1) {
                ex1.printStackTrace();
                logger.error("追加客户失败！");
                logger.error(ex1.getMessage());
                this.res.setType(0);
                this.res.setResult(false);
                this.res.setMessage("追加客户失败！");
                return -1;
            }
        }
        this.res.setType(0);
        this.res.setResult(true);
        this.res.setMessage("操作成功！");
        return 0;
    }

    public int editUncomcredit() {
        uncomcredit = new LNUNCOMCREDIT();
        for (int i = 0; i < this.req.getRecorderCount(); i++) {
            try {
                uncomcredit.initAll(i, req); // 初始化数据bean
                if (uncomcredit.updateByWhere(" where pkid='" + req.getFieldValue(i, "pkid") + "'") < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("编辑失败！");
                    return -1;
                }

                // 流水日志表
                task = MortUtil.getTaskObj(req.getFieldValue(i, "pkid"), req.getFieldValue(i, "busiNode"),
                        CcbLoanConst.OPER_EDIT);
                task.setOperid(this.getOperator().getOperid());
                task.setBankid(this.getOperator().getDeptid());
                if (task.insert() < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("添加流水日志失败！");
                    return -1;
                }

            } catch (Exception ex1) {
                ex1.printStackTrace();
                logger.error("编辑失败！");
                logger.error(ex1.getMessage());
                this.res.setType(0);
                this.res.setResult(false);
                this.res.setMessage("编辑失败！");
                return -1;
            }
        }
        this.res.setType(0);
        this.res.setResult(true);
        this.res.setMessage("操作成功！");
        return 0;
    }

    public int deleteUncomcredit() {
        uncomcredit = new LNUNCOMCREDIT();
        for (int i = 0; i < this.req.getRecorderCount(); i++) {
            try {
                uncomcredit.initAll(i, req); // 初始化数据bean
                if (dc.executeUpdate("update ln_uncomcredit set recsta = '2' where pkid = '" + uncomcredit.getPkid() + "'") < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("操作失败！");
                    return -1;
                }
                // 流水日志表
                task = MortUtil.getTaskObj(req.getFieldValue(i, "creditratingno"), req.getFieldValue(i, "busiNode"),
                        CcbLoanConst.OPER_EDIT);
                task.setOperid(this.getOperator().getOperid());
                task.setBankid(this.getOperator().getDeptid());
                if (task.insert() < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("添加流水日志失败！");
                    return -1;
                }
            } catch (Exception ex1) {
                ex1.printStackTrace();
                logger.error("删除客户失败！");
                logger.error(ex1.getMessage());
                this.res.setType(0);
                this.res.setResult(false);
                this.res.setMessage("删除客户失败！");
                return -1;
            }
        }
        this.res.setType(0);
        this.res.setResult(true);
        this.res.setMessage("操作成功！");
        return 0;
    }

    /**
     * 非普通审核
     *
     * @return
     */
    public int uncomcreditCheck() {
        LNCREATLOG lncreatlog = new LNCREATLOG();
        uncomcredit = new LNUNCOMCREDIT();
        for (int i = 0; i < this.req.getRecorderCount(); i++) {
            try {
                uncomcredit.initAll(i, req); // 初始化数据bean
                String docID = null;
                if (uncomcredit.getJudgetype().equals("01")) {
                    String sqlMinDocid = "select min(t.docid) as mindocid from ln_uncomcredit t where t.judgetype = '01' and t.creditratingno = '" + uncomcredit.getCreditratingno() + "'";
                    rs = dc.executeQuery(sqlMinDocid);
                    while (rs.next()) {
                        docID = rs.getString("mindocid");
                    }
                }

                if (docID == null) {
                    docID = uncomcredit.getDocid();
                }

                if ("".equals(docID)) {
                    rs = dc.executeQuery("select to_char(sysdate,'yyyy') || lpad(seq_n.nextval,9,'0') as docid from dual");
                    while (rs.next()) {
                        docID = rs.getString("docid");
                    }
                }
                uncomcredit.setDocid(docID);
                if (uncomcredit.updateByWhere(" where pkid='" + req.getFieldValue(i, "pkid") + "'") < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("审核失败！");
                    return -1;
                }

                // 流水日志表
                RecordSet rs = dc.executeQuery("select t.newdate as datevalue from ln_creatlog t where t.creditratingno = '" + uncomcredit.getCreditratingno() + "' and t.opertime = (select max(lc.opertime) from ln_creatlog lc where lc.creditratingno = t.creditratingno)");
                String datevalue = "";
                while (rs.next()) {
                    datevalue = rs.getTimeString("datevalue");
                }
                lncreatlog.setCreditratingno(uncomcredit.getCreditratingno());
                lncreatlog.setOpername(this.getOperator().getOpername());
                lncreatlog.setOpertime(BusinessDate.getToday());
                lncreatlog.setOlddate(datevalue);
                lncreatlog.setCreattype("1");
                lncreatlog.setNewdate(uncomcredit.getEnddate());
                if (lncreatlog.insert() < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("添加操作日志失败！");
                    return -1;
                }

                // 流水日志表
                task = MortUtil.getTaskObj(req.getFieldValue(i, "pkid"), req.getFieldValue(i, "busiNode"),
                        CcbLoanConst.OPER_EDIT);
                task.setOperid(this.getOperator().getOperid());
                task.setBankid(this.getOperator().getDeptid());
                if (task.insert() < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage("添加流水日志失败！");
                    return -1;
                }

            } catch (Exception ex1) {
                ex1.printStackTrace();
                logger.error("编辑失败！");
                logger.error(ex1.getMessage());
                this.res.setType(0);
                this.res.setResult(false);
                this.res.setMessage("编辑失败！");
                return -1;
            }
        }
        this.res.setType(0);
        this.res.setResult(true);
        this.res.setMessage("审核成功！");
        return 0;
    }
}