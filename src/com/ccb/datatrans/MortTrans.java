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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhanrui
 * Date: 2010-3-19
 * Time: 20:23:28
 * To change this template use File | Settings | File Templates.
 */
public class MortTrans {
    private static final Log logger = LogFactory.getLog(MortTrans.class);

    private static java.sql.Connection connect;


    private static void processTable(String tablename, String sql) {
        ConnectionManager cm = ConnectionManager.getInstance();
        connect = cm.getConnection().getConnection();

        try {
            Statement stMort = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            Statement stloan = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

//            ResultSet rsMort = stMort.executeQuery("select a.e,a.h,b.deptid, a.lineno from ln_tmp_mortinfa a left join ccb.ln_tmp_dept b on a.d=b.deptnm order by a.e");
            ResultSet rsMort = stMort.executeQuery(sql);

            List<MortResultBean> mortbeans = new ArrayList<MortResultBean>();

            String nameMort;
            String nameLoan;
            String bankidMort;
            String bankidLoan;
            String loanid;
            double amtMort = 0.00;
            double amtLoan = 0.00;
            int lineno = 0;

            int step = 0;
            int count = 0;
            int k = 0;

            //抵押信息
            while (rsMort.next()) {
                nameMort = dualName(rsMort.getString(1));

                amtMort = rsMort.getDouble(2);
                if (tablename.equals("A") || tablename.equals("C"))
                    amtMort = amtMort * 10000;
                bankidMort = rsMort.getString(3);
                lineno = rsMort.getInt(4);

                MortResultBean bean = new MortResultBean(lineno, nameMort, amtMort, bankidMort, "空", 0, 0, 0);
                mortbeans.add(bean);
            }

            step = 0;

            ResultSet rsLoan = stloan.executeQuery("select t.cust_name,t.rt_orig_loan_amt,t.bankid,t.loanid from ln_odsb_loanapply t  order by t.cust_name  ");
            List<LoanResultBean> loanbeans = new ArrayList<LoanResultBean>();

            //ODSB 中截止到数据移植日期前最大贷款笔数
            int recordnum = 170000;
            String[] nameLoans = new String[recordnum];
            double[] amtLoans = new double[recordnum];
            String[] bankidLoans = new String[recordnum];
            String[] loanIDs = new String[recordnum];

            int loanRecordsSize = 0;
            while (rsLoan.next()) {
                nameLoan = rsLoan.getString(1);
                amtLoan = rsLoan.getDouble(2);
                bankidLoan = rsLoan.getString(3);
                loanid = rsLoan.getString(4);

                //LoanResultBean bean = new LoanResultBean(loanid, nameLoan, amtLoan, bankidLoan);
                //loanbeans.add(bean);

                nameLoans[loanRecordsSize] = nameLoan;
                amtLoans[loanRecordsSize] = amtLoan;
                bankidLoans[loanRecordsSize] = bankidLoan;
                if (loanid == null) {
                    loanid = "无";
                }
                loanIDs[loanRecordsSize] = loanid;
                loanRecordsSize++;
            }

            step = 0;

            //贷款遍历数组指针
            int loanstep = 0;
            int loansteptemp = 0;

            System.out.printf("==================");

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

                for (int j = loanstep; j < loanRecordsSize; j++) {
                    nameLoan = nameLoans[j];
                    amtLoan = amtLoans[j];
                    bankidLoan = bankidLoans[j];


                    if (nameLoan.equals(nameMort)) {

                        if (nameLoan.equals("马金峰")) {
                            int ii = 0;
                        }


                        mortbean.setLoanid(loanIDs[j]);
                        foundname++;
                        if (bankidMort.equals(bankidLoan)) {
                            mortbean.setLoanid(loanIDs[j]);
                            foundnamebank++;
                            if (amtMort == amtLoan) {
                                mortbean.setLoanid(loanIDs[j]);
                                foundnamebankamt++;
                            }
                        }
                        //自当前位置起继续查找
                        for (int temp = j + 1; temp < loanRecordsSize; temp++) {
                            nameLoan = nameLoans[temp];
                            amtLoan = amtLoans[temp];
                            bankidLoan = bankidLoans[temp];
                            if (nameLoan.equals(nameMort)) {
                                foundname++;
                                if (bankidMort.equals(bankidLoan)) {
                                    if (foundnamebankamt == 0)
                                        mortbean.setLoanid(loanIDs[temp]);
                                    foundnamebank++;
                                    if (amtMort == amtLoan) {
                                        mortbean.setLoanid(loanIDs[temp]);
                                        foundnamebankamt++;
                                    }
                                }
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

            writeFile("f:/temp/", "mort-" + tablename + ".txt", mortbeans);
            if (tablename.equals("C")) {
                update_Loanid("LN_TMP_MORTINFC", mortbeans);
            }
            if (tablename.equals("D")) {
                update_Loanid("LN_TMP_MORTINFD", mortbeans);
            }

        } catch (Exception e) {
            e.printStackTrace();
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
        for (MortResultBean mortbean : mortbeans) {
            out.write(
                    mortbean.getLoanid() + "|" +
                            mortbean.getLineno() + "|" +
                            mortbean.getName() + "|" +
                            mortbean.getRepeatname() + "|" +
                            mortbean.getRepeatname_bank() + "|" +
                            mortbean.getRepeatname_bank_amt()
            );
            out.println();
        }

        System.out.println("写入成功！");
        fw.close();
        out.close();
    }

    /*
   根据MortBEANs 的数据更新 LN_TMP_MORTINFC D中的LOANID 及抵押编号
    */

    private static void update_Loanid(String tblname, List<MortResultBean> mortbeans) {
        ConnectionManager cm = ConnectionManager.getInstance();
        DatabaseConnection dc = cm.getConnection();
        PreparedStatement pst = null;
        pst = dc.getPreparedStatement("update " + tblname + " t set t.loanid=null");
        try {
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        pst = dc.getPreparedStatement("update " + tblname + " t set t.loanid=? where t.lineno = ?");

        try {
            int i = 0;
            for (MortResultBean bean : mortbeans) {
                if (bean.getRepeatname() == 1
                        || bean.getRepeatname_bank() == 1
                        || bean.getRepeatname_bank_amt() == 1
                        ) {
                    pst.setString(1, bean.getLoanid());
                    pst.setInt(2, bean.getLineno());
                    pst.addBatch();
                    i++;
                    if (i % 1000 == 0) {
                        System.out.println("commited:" + i);
                        pst.executeBatch();
                        pst.clearParameters();
                        pst.clearBatch();
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


    public static void main(String argv[]) {
        //处理A表      姓名 金额 机构 行号   金额为万元
//        String sql = "select a.e, a.h, b.deptid, a.lineno,a.k from ln_tmp_mortinfa a left join ccb.ln_tmp_dept b on a.d=b.deptnm order by a.e";
//        processTable("A", sql);

        //处理c表      姓名 金额 机构 行号    金额为万元
        String sql = "select a.c, a.e, b.deptid, a.lineno from ln_tmp_mortinfc a left join ccb.ln_tmp_dept b on a.b=b.deptnm order by a.c";
        processTable("C", sql);

        //处理D表      姓名 金额 机构 行号    金额为元
        sql = "select a.d, a.e, b.deptid, a.lineno from ln_tmp_mortinfd a left join ccb.ln_tmp_dept b on a.b=b.deptnm order by a.d";
        processTable("D", sql);

    }

}
