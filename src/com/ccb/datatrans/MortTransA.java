package com.ccb.datatrans;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import pub.platform.db.ConnectionManager;
import pub.platform.db.DatabaseConnection;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhanrui
 * Date: 2010-3-19
 * Time: 20:23:28
 * To change this template use File | Settings | File Templates.
 */
public class MortTransA {
    private static final Log logger = LogFactory.getLog(MortTransA.class);

    private static java.sql.Connection connect;


    private static void processTable(String tablename, String sql) {
        ConnectionManager cm = ConnectionManager.getInstance();
        connect = cm.getConnection().getConnection();

        try {
            Statement st = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            Statement stloan = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

//            ResultSet rs = st.executeQuery("select a.e,a.h,b.deptid, a.lineno from ln_tmp_mortinfa a left join ccb.ln_tmp_dept b on a.d=b.deptnm order by a.e");
            ResultSet rs = st.executeQuery(sql);

            List<MortResultBean> mortbeans = new ArrayList<MortResultBean>();

            String nameMort;
            String nameLoan;
            String bankidMort;
            String bankidLoan;

            String loanid;
            String stateLoan;  //贷款状态

            String dateMort;
            String dateLoan;
            String typeMort;
            String typeLoan;

            String receiptdateMort;


            Double termMort;
            int termLoan;

            double amtMort = 0.00;
            double guaramtMort = 0.00;
            double amtLoan = 0.00;
            int lineno = 0;

            int step = 0;
            int count = 0;
            int k = 0;

            //抵押信息
            while (rs.next()) {
                nameMort = dualName(rs.getString(1));

                amtMort = rs.getDouble(2);
                if (tablename.equals("A") || tablename.equals("C"))
                    amtMort = amtMort * 10000;
                bankidMort = rs.getString(3);
                lineno = rs.getInt(4);

                String gamt = rs.getString(5);     //担保物价值
                dateMort = rs.getString(6);     //抵押日期
                String strTermMort = rs.getString(7);     //贷款期限
                typeMort = rs.getString(8);     //贷款种类
                receiptdateMort = rs.getString(9);     //取回回执日期

                if (isDigits(gamt)) {
                    guaramtMort = Double.parseDouble(gamt);
                } else {
                    guaramtMort = -1;
                }

                if (strTermMort == null) {
                    termMort = -1.0;
                } else {
                    if (isDigits(strTermMort)) {
                        termMort = Double.parseDouble(strTermMort);
                        if (termMort <= 30) {
                            termMort = termMort * 12;
                        }
                    } else {
                        termMort = -1.0;
                        //TODO 判断汉字
                        int i = strTermMort.indexOf("月");
                        if (i > 0) {
                            strTermMort = strTermMort.substring(0, i);
                            termMort = Double.parseDouble(strTermMort);
                        }

                    }
                }

                //日期规范处理
                dateMort = getMortDate(dateMort);
                receiptdateMort = getMortDate(receiptdateMort);

                if (typeMort == null) {
                    typeMort = "011";
                }

                MortResultBean bean = new MortResultBean(lineno, nameMort, amtMort, bankidMort, "空",
                        guaramtMort, dateMort, termMort.intValue(), typeMort, receiptdateMort,
                        0, 0, 0);
                mortbeans.add(bean);
            }


            step = 0;
            //for 个贷中心
            //rs = st.executeQuery("select t.cust_name,t.rt_orig_loan_amt,t.bankid,t.loanid,t.loanstate,t.aply_dt,t.ln_typ,rt_term_incr from ln_odsb_loanapply t  order by t.cust_name  ");
            //for 开发区分中心  只有 保税区 开发区 崇明岛 胶南
            rs = st.executeQuery("select t.cust_name,t.rt_orig_loan_amt,t.bankid,t.loanid,t.loanstate,t.aply_dt,t.ln_typ,rt_term_incr from ln_odsb_loanapply t where bankid in ('371988109','371985600','371985700','371997809') order by t.cust_name  ");
            List<LoanResultBean> loanbeans = new ArrayList<LoanResultBean>();

            //ODSB 中截止到数据移植日期前最大贷款笔数
            int recordnum = 170000;
            String[] nameLoans = new String[recordnum];
            double[] amtLoans = new double[recordnum];
            String[] bankidLoans = new String[recordnum];
            String[] loanIDs = new String[recordnum];
            String[] dateLoans = new String[recordnum]; //贷款申请日期
            String[] stateLoans = new String[recordnum];
            String[] typeLoans = new String[recordnum];
            int[] termLoans = new int[recordnum];     //贷款期限

            int loanRecordsSize = 0;
            while (rs.next()) {
                nameLoan = rs.getString(1);
                amtLoan = rs.getDouble(2);
                bankidLoan = rs.getString(3);
                loanid = rs.getString(4);
                stateLoan = rs.getString(5);
                dateLoan = rs.getString(6);
                typeLoan = rs.getString(7);
                termLoan = rs.getInt(8);

                //LoanResultBean bean = new LoanResultBean(loanid, nameLoan, amtLoan, bankidLoan);
                //loanbeans.add(bean);

                nameLoans[loanRecordsSize] = nameLoan;
                amtLoans[loanRecordsSize] = amtLoan;
                bankidLoans[loanRecordsSize] = bankidLoan;
                if (loanid == null) {
                    loanid = "无";
                }
                loanIDs[loanRecordsSize] = loanid;
                dateLoans[loanRecordsSize] = dateLoan;
                stateLoans[loanRecordsSize] = stateLoan;
                typeLoans[loanRecordsSize] = typeLoan;
                termLoans[loanRecordsSize] = termLoan;
                loanRecordsSize++;
            }

            step = 0;

            //贷款遍历数组指针
            int loanstep = 0;
            int loansteptemp = 0;


            System.out.printf("================================================");

            for (MortResultBean mortbean : mortbeans) {
                String name = mortbean.getName();
                if (name == null) {
                    nameMort = "NULL";
                } else {
                    nameMort = name;
                }

                amtMort = mortbean.getAmt();
                bankidMort = mortbean.getBankid();

                step++;

                int foundname = 0;
                int foundnamebank = 0;
                int foundnamebankamt = 0;
                int foundnamebankamttype = 0;
                int foundnamebankamtterm = 0;
                int foundnamebankamtdate = 0;
                int loanstatenum_1 = 0;  // 贷款状态为1的次数（已开户）

                for (int j = loanstep; j < loanRecordsSize; j++) {
                    nameLoan = nameLoans[j];
                    amtLoan = amtLoans[j];
                    bankidLoan = bankidLoans[j];

                    //三种重复情况标志
                    int ABCflag = 0;
                    if (nameLoan.equals(nameMort)) {
                        mortbean.setLoanid(loanIDs[j]);
                        foundname++;
                        ABCflag = 1;
                        if (bankidMort.equals(bankidLoan)) {
                            mortbean.setLoanid(loanIDs[j]);
                            foundnamebank++;
                            ABCflag = 2;
                            if (amtMort == amtLoan) {
                                ABCflag = 3;
                                mortbean.setLoanid(loanIDs[j]);
                                foundnamebankamt++;
                                if (mortbean.getType().equals(typeLoans[j])) {
                                    foundnamebankamttype++;
                                }
                                if (mortbean.getTerm() == termLoans[j]) {
                                    foundnamebankamtterm++;
                                }

/*
                                if (mortbean.getMortdate().equals(dateLoans[j])) {
                                    foundnamebankamtdate++;
                                }
*/

                                if (getIntervalDays(mortbean.getMortdate(), dateLoans[j]) < 31) {
                                    foundnamebankamtdate++;
                                }
                                if (stateLoans[j].equals("1")) {
                                    loanstatenum_1++;
                                }
                            }
                        }
/*
                        switch (ABCflag) {
                            case 1:
                                mortbean.addLoanidA(loanIDs[j]);
                                break;
                            case 2:
                                mortbean.addLoanidB(loanIDs[j]);
                                break;
                            case 3:
                                mortbean.addLoanidC(loanIDs[j]);
                                break;
                            default:
                        }
*/
                        mortbean.addLoanids(loanIDs[j]);
                        mortbean.addLoandates(dateLoans[j]);
                        mortbean.addLoantypes(typeLoans[j]);
                        mortbean.addLoanterms(termLoans[j]);

                        //自当前位置起继续查找
                        for (int temp = j + 1; temp < loanRecordsSize; temp++) {
                            ABCflag = 0;
                            nameLoan = nameLoans[temp];
                            amtLoan = amtLoans[temp];
                            bankidLoan = bankidLoans[temp];
                            if (nameLoan.equals(nameMort)) {
                                ABCflag = 1;
                                foundname++;
                                if (bankidMort.equals(bankidLoan)) {
                                    ABCflag = 2;
                                    if (foundnamebankamt == 0)
                                        mortbean.setLoanid(loanIDs[temp]);
                                    foundnamebank++;
                                    if (amtMort == amtLoan) {
                                        ABCflag = 3;
                                        mortbean.setLoanid(loanIDs[temp]);
                                        foundnamebankamt++;
                                        if (mortbean.getType().equals(typeLoans[temp])) {
                                            foundnamebankamttype++;
                                        }
                                        if (mortbean.getTerm() == termLoans[temp]) {
                                            foundnamebankamtterm++;
                                        }
                                        if (getIntervalDays(mortbean.getMortdate(), dateLoans[temp]) < 31) {
                                            foundnamebankamtdate++;
                                        }
                                        if (stateLoans[temp].equals("1")) {
                                            loanstatenum_1++;
                                        }
                                    }
                                }
/*

                                switch (ABCflag) {
                                    case 1:
                                        mortbean.addLoanidA(loanIDs[temp]);
                                        break;
                                    case 2:
                                        mortbean.addLoanidB(loanIDs[temp]);
                                        break;
                                    case 3:
                                        mortbean.addLoanidC(loanIDs[temp]);
                                        mortbean.addLoandates(typeLoans[temp]);
                                        break;
                                    default:
                                }
*/
                                mortbean.addLoanids(loanIDs[temp]);
                                mortbean.addLoandates(dateLoans[temp]);
                                mortbean.addLoantypes(typeLoans[temp]);
                                mortbean.addLoanterms(termLoans[temp]);

                                //  loanstep++;
                                continue;
                            } else
                                break;
                        }
                        loansteptemp = loanstep;
                        break;
                    }
                    loanstep++;
                }

                mortbean.setRepeatname(foundname);
                mortbean.setRepeatname_bank(foundnamebank);
                mortbean.setRepeatname_bank_amt(foundnamebankamt);
                mortbean.setRepeatname_bank_amt_type(foundnamebankamttype);
                mortbean.setRepeatname_bank_amt_term(foundnamebankamtterm);
                mortbean.setRepeatname_bank_amt_date(foundnamebankamtdate);
                mortbean.setRepeatname_bank_amt_state(loanstatenum_1);

                System.out.println(
                        mortbean.getLoanid() + "|" +
                                mortbean.getLineno() + "|" +
                                mortbean.getName() + "|" +
                                mortbean.getRepeatname() + "|" +
                                mortbean.getRepeatname_bank() + "|" +
                                mortbean.getRepeatname_bank_amt()
                );

                if (foundname > 0) {
                    loanstep = loansteptemp;
                } else {
                    loanstep = 0;
                }
            }//end while

            System.out.printf("==================");
            doGuarAmt(mortbeans);
            writeFile("f:/temp/", "mort-" + tablename + ".txt", mortbeans);
            update_A_Loanid(mortbeans);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connect.close();
//                cm.release();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    private static String dualName(String name) {
        if (name == null) {
            return " ";
        }

        name = name.trim();
        String temp;
        int i = name.indexOf("（");
        if (i == -1) {
            i = name.indexOf("(");
            if (i == -1) {
                i = name.indexOf("／");
                if (i == -1) {
                    i = name.indexOf("/");
                    if (i == -1) {
                        i = name.indexOf("、");
                        if (i == -1) {
                            i = name.indexOf(" ");
                        }
                    }
                }
            }
        }

        //五个字以上，取前三个
        if (i == -1) {
            if (name.length() >= 5) {
                return name.substring(0, 3);
            } else
                return name;
        } else {
            temp = name.substring(0, i);
            if (temp.length() >= 5) {
                return temp.substring(0, 3);
            } else
                return temp;
        }
    }

    public static void writeFile(String filePath, String fileName, List<MortResultBean> mortbeans) throws IOException {
        FileWriter fw = new FileWriter(filePath + fileName);
        PrintWriter out = new PrintWriter(fw);

        List<String> loandates = new ArrayList<String>();
        List<String> loanids = new ArrayList<String>();

        out.write("贷款申请号|EXCEL行号|姓名|同名|同名同机构|同名同机构同金额|type|term|date|state|担保物价值|a|a|a|a|a|a|a|a|a|a|a");
        out.println();

        for (MortResultBean mortbean : mortbeans) {

            String infostr = "";
/*
            loanids = mortbean.getLoanidsC();
            for (String loanid : loanids) {
                infostr += "|"+loanid;
            }
*/

            loandates = mortbean.getLoandates();
            for (String loandate : loandates) {
                infostr += "|" + loandate;
            }

            out.write(
                    mortbean.getLoanid() + "|" +
                            mortbean.getLineno() + "|" +
                            mortbean.getName() + "|" +
                            mortbean.getRepeatname() + "|" +
                            mortbean.getRepeatname_bank() + "|" +
                            mortbean.getRepeatname_bank_amt()
                            + "|" + mortbean.getRepeatname_bank_amt_type()
                            + "|" + mortbean.getRepeatname_bank_amt_term()
                            + "|" + mortbean.getRepeatname_bank_amt_date()
                            + "|" + mortbean.getRepeatname_bank_amt_state()
                            + "|" + mortbean.getFoundGuaramtNum()
//                            + "|" + mortbean.getGuarAmt()
//                            + "|" + mortbean.getGuarAmt()
//                            + "|" + mortbean.getMortdate()
//                            + infostr
            );
            out.println();
        }

        System.out.println("写入成功！");
        fw.close();
        out.close();
    }

    //根据担保物价值查找LOANID

    public static void doGuarAmt(List<MortResultBean> mortbeans) throws IOException {
        ConnectionManager cm = ConnectionManager.getInstance();
        connect = cm.getConnection().getConnection();

        PreparedStatement pst = null;
        try {
//            st = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = null;
//            String sql = "select a.loanid,a.assuid,b.guar_amt,b.custname,b.bankid from ln_odsb_assu_ctrt_rela a,ln_odsb_assu_ccassuinfo b where a.assuid=b.assuid and a.loanid=? and b.guar_amt=?";
            String sql = "select b.guar_amt from ln_odsb_assu_ctrt_rela a,ln_odsb_assu_ccassuinfo b where a.assuid=b.assuid and a.loanid=? and b.guar_amt=?";
//            String sql = "select b.guar_amt from ln_odsb_assu_ctrt_rela a,ln_odsb_assu_ccassuinfo b where a.assuid=b.assuid and a.loanid=? and abs(b.guar_amt-?)<100000";

            pst = connect.prepareStatement(sql);
            List<String> loanids = new ArrayList<String>();
            int i = 0;
            for (MortResultBean mortbean : mortbeans) {
                if (mortbean.getRepeatname() == 1
                        || mortbean.getRepeatname_bank() == 1
                        || mortbean.getRepeatname_bank_amt() == 1) {
                    //
                } else {
//                    if (mortbean.getRepeatname_bank_amt() > 1) {
//                    if (mortbean.getRepeatname() > 0 && mortbean.getRepeatname_bank_amt() ==0) {
                    if (mortbean.getName().equals("葛秀军")) {
                        int inti=1;
                    }
                    if (mortbean.getRepeatname() > 0) {
                        loanids = mortbean.getLoanids();
                        double amt = mortbean.getGuarAmt();
                        int count = 0;
                        for (String loanid : loanids) {
                            if (loanid.equals("371201200100025470")) {
                                int iiii=0;
                            }
                            pst.setString(1, loanid);
                            pst.setDouble(2, amt);
                            rs = pst.executeQuery();
//                            int count = 0;
                            while (rs.next()) {
//                    double guaramt = rs.getDouble(1);
                                count++;
                                mortbean.setLoanid(loanid);
                            }
                            mortbean.setFoundGuaramtNum(count);
                        }
                        System.out.println("i==" + ++i);

                    }
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cm.release();
        }

//            Statement stloan = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

//            ResultSet rs = st.executeQuery("select a.e,a.h,b.deptid, a.lineno from ln_tmp_mortinfa a left join ccb.ln_tmp_dept b on a.d=b.deptnm order by a.e");


    }

    private static boolean isDigits(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!Character.isDigit(ch) && ch != '.') {
                return false;
            }
        }
        return true;
    }


    private static void updateTMPA() {
        ConnectionManager cm = ConnectionManager.getInstance();
        DatabaseConnection dc = cm.getConnection();
        PreparedStatement pst = null;
        pst = dc.getPreparedStatement("update ln_tmp_mortinfa ta set ta.j=? where ta.j like ?");

        try {
            pst.setString(1, "012");
            pst.setString(2, "%汽车%");
            pst.execute();
            pst.setString(1, "014");
            pst.setString(2, "%商用房%");
            pst.execute();
            pst.setString(1, "016");
            pst.setString(2, "%消费%");
            pst.execute();
            pst.setString(1, "026");
            pst.setString(2, "%再交易商用%");
            pst.execute();
            pst.setString(1, "013");
            pst.setString(2, "%再交易%");
            pst.execute();
            pst.setString(1, "022");
            pst.setString(2, "%质押%");
            pst.execute();
            pst.setString(1, "011");
            pst.setString(2, "%住房%");
            pst.execute();
            pst.setString(1, "033");
            pst.setString(2, "%助业%");
            pst.execute();
            pst.setString(1, "122");
            pst.setString(2, "%最高额%");
            pst.execute();

            pst = dc.getPreparedStatement("update ln_tmp_mortinfa ta set ta.j='011' where trim(ta.j) is null");
            pst.execute();

            pst.close();
            dc.close();
            cm.release();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }

    private static String getMortDate(String dt) {
        if (dt == null) {
            return "1899-12-31";
        }
        if (dt.length() >= 10) {
            return dt;
        } else {
            int s = dt.length();
            String yy;
            String mm;
            String dd;
            if (s == 4) {
                mm = dt.substring(0, 2);
                dd = dt.substring(2, 4);
                return "2007" + "-" + mm + "-" + dd;
            } else if (s == 6) {
                yy = dt.substring(0, 2);
                mm = dt.substring(2, 4);
                dd = dt.substring(4, 6);
                return "20" + yy + "-" + mm + "-" + dd;
            } else if (s == 8) {
                yy = dt.substring(0, 4);
                mm = dt.substring(4, 6);
                dd = dt.substring(6, 8);
                return yy + "-" + mm + "-" + dd;
            } else {
                return "1899-12-31";
            }
        }
    }


    /*
    根据MortBEANs 的数据更新 LN_TMP_MORTINFA中的LOANID
     */

    private static void update_A_Loanid(List<MortResultBean> mortbeans) {
        ConnectionManager cm = ConnectionManager.getInstance();
        DatabaseConnection dc = cm.getConnection();
        PreparedStatement pst = null;
        pst = dc.getPreparedStatement("update ln_tmp_mortinfa t set t.loanid=null");
        try {
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        pst = dc.getPreparedStatement("update ln_tmp_mortinfa t set " +
                " t.loanid=?,t.a=? " +
                " where t.lineno = ?");

        try {
            int i = 0;
            for (MortResultBean bean : mortbeans) {
                if (bean.getRepeatname() == 1
                        || bean.getRepeatname_bank() == 1
                        || bean.getRepeatname_bank_amt() == 1
                        ) {
                    pst.setString(1, bean.getLoanid());
                    pst.setString(2, bean.getMortdate());
                    pst.setInt(3, bean.getLineno());
                    pst.addBatch();
                    i++;
                    if (i % 1000 == 0) {
                        System.out.println("commited:" + i);
                        pst.executeBatch();
                        pst.clearParameters();
                        pst.clearBatch();
                    }
                }
                if (bean.getRepeatname_bank_amt() >= 2) {
                    if (bean.getRepeatname_bank_amt_state() == 1
                            || bean.getRepeatname_bank_type() == 1
                            || bean.getRepeatname_bank_term() == 1) {
                        pst.setString(1, bean.getLoanid());
                        pst.setString(2, bean.getMortdate());
                        pst.setInt(3, bean.getLineno());
                        pst.addBatch();
                    }
                }
            }

            // 非1000的倍数
            if (pst != null) {
                System.out.println("last commited:" + i);
                pst.executeBatch();
                pst.clearParameters();
                pst.clearBatch();
            }
            pst.close();
            dc.close();
            cm.release();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static int getIntervalDays(String strDate1, String strDate2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date1;
        java.util.Date date2;
        long ei = 0;
        try {
            date1 = sdf.parse(strDate1);
            date2 = sdf.parse(strDate2);
            long l1 = date1.getTime();
            long l2 = date2.getTime();
            ei = Math.abs(l2 - l1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return (int) (ei / (1000 * 60 * 60 * 24));
    }

    public static void main(String argv[]) {
        //处理A表      姓名 金额 机构 行号  担保物价值 抵押日期，贷款期限 贷款种类 取回回执日期    金额为万元
        String sql = "select a.e, a.h, b.deptid, a.lineno,a.k, a.a ,a.i,a.j,a.g from ln_tmp_mortinfa a left join ccb.ln_tmp_dept b on a.d=b.deptnm order by a.e";
//        updateTMPA();
        processTable("A", sql);

        //处理c表      姓名 金额 机构 行号    金额为万元
//        String sql = "select a.c, a.e, b.deptid, a.lineno from ln_tmp_mortinfc a left join ccb.ln_tmp_dept b on a.b=b.deptnm order by a.c";
//        processTable("C", sql);

        //处理D表      姓名 金额 机构 行号    金额为元
//       String sql = "select a.d, a.e, b.deptid, a.lineno from ln_tmp_mortinfd a left join ccb.ln_tmp_dept b on a.b=b.deptnm order by a.d";
//       processTable("D", sql);

    }

}