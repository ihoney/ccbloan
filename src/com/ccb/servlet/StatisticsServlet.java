package com.ccb.servlet;

import com.ccb.creditrating.CountModel;
import pub.platform.db.ConnectionManager;
import pub.platform.db.DatabaseConnection;
import pub.platform.db.RecordSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StatisticsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String countDateBegVal = request.getParameter("countDateBegVal");
        String countDateEndVal = request.getParameter("countDateEndVal");
        String deptidVal = request.getParameter("deptidVal");
        StringBuffer stringBuffer1 = new StringBuffer("");
        if (!countDateBegVal.equals("")) {
            stringBuffer1.append(" and to_char(lp.finbegdate,'yyyy-mm-dd') >= '" + countDateBegVal + "' ");
        }
        if (!countDateEndVal.equals("")) {
            stringBuffer1.append(" and to_char(lp.finbegdate,'yyyy-mm-dd') <= '" + countDateEndVal + "' ");
        }
        if (!deptidVal.equals("")) {
            stringBuffer1.append(" and lp.inideptid = '" + deptidVal + "' ");
        }
        String sqlWhere1 = stringBuffer1.toString();
        StringBuffer stringBuffer2 = new StringBuffer("");
        if (countDateBegVal.length() > 0 || countDateEndVal.length() > 0 || deptidVal.length() > 0) {
            stringBuffer2.append(" where 1 = 1 ");
            if (!countDateBegVal.equals("")) {
                stringBuffer2.append(" and to_char(lu.begdate,'yyyy-mm-dd') >= '" + countDateBegVal + "' ");
            }
            if (!countDateEndVal.equals("")) {
                stringBuffer2.append(" and to_char(lu.begdate,'yyyy-mm-dd') <= '" + countDateEndVal + "' ");
            }
            if (!deptidVal.equals("")) {
                stringBuffer2.append(" and lu.judgedeptid = '" + deptidVal + "' ");
            }
        }
        String sqlWhere2 = stringBuffer2.toString();
        StringBuffer stringBuffer3 = new StringBuffer("");
        if (!countDateBegVal.equals("")) {
            stringBuffer3.append(" and to_char(lp.finbegdate,'yyyy-mm-dd') >= '" + countDateBegVal + "' ");
        }
        if (!countDateEndVal.equals("")) {
            stringBuffer3.append(" and to_char(lp.finbegdate,'yyyy-mm-dd') <= '" + countDateEndVal + "' ");
        }
        if (!deptidVal.equals("")) {
            stringBuffer3.append(" and lp.inideptid = '" + deptidVal + "' ");
        }
        List<CountModel> countModelList = new ArrayList<CountModel>();
        ConnectionManager cm = ConnectionManager.getInstance();
        DatabaseConnection dc = cm.get();
        String sql1 = "select (select t.deptname from ptdept t where t.deptid= tab1.judgedeptid) as deptName,(select count(lp.creditratingno) from ln_pscoredetail lp where lp.inideptid = tab1.judgedeptid and lp.finamt > 0 " + sqlWhere1 + ") as ptNum,sum(decode(tab1.judgetype,'01',tab1.recordNum,0)) jtNum,sum(decode(tab1.judgetype,'02',tab1.recordNum,0)) gdNum,sum(decode(tab1.judgetype,'03',tab1.recordNum,0)) jhNum,sum(decode(tab1.judgetype,'04',tab1.recordNum,0)) clNum,sum(decode(tab1.judgetype,'05',tab1.recordNum,0)) qtNum from (select tab.judgedeptid,tab.judgetype ,count(tab.judgetype) as recordNum from (select lu.creditratingno,lu.judgetype,lu.judgedeptid  from (select l.* from ln_uncomcredit l where l.recsta = '1' and l.begdate = (select min(t.begdate) from ln_uncomcredit t where t.creditratingno = l.creditratingno group by t.creditratingno) and l.judgeprice > 0) lu " + sqlWhere2 + " group by lu.creditratingno,lu.judgetype,lu.judgedeptid order by lu.creditratingno,lu.judgetype) tab group by tab.judgedeptid,tab.judgetype order by tab.judgedeptid) tab1 group by tab1.judgedeptid union all select (select t.deptname from ptdept t where t.deptid= lp.inideptid) as deptName,count(lp.creditratingno) as ptNum,0 as jtNum,0 as gdNum,0 as jhNum,0 as clNum,0 as qtNum from ln_pscoredetail lp where lp.finamt > 0 and lp.inideptid not in (select lu.judgedeptid from ln_uncomcredit lu where lu.recsta = '1' and lu.judgeprice > 0 group by lu.judgedeptid) " + sqlWhere1 + " group by lp.inideptid";
        RecordSet rs = dc.executeQuery(sql1);
        int ptNum, jtNum, gdNum, jhNum, clNum, qtNum, hjNum;
        int hjptNum = 0, hjjtNum = 0, hjgdNum = 0, hjjhNum = 0, hjclNum = 0, hjqtNum = 0, hjhjNum = 0;
        while (rs.next()) {
            ptNum = rs.getInt("ptNum");
            jtNum = rs.getInt("jtNum");
            gdNum = rs.getInt("gdNum");
            jhNum = rs.getInt("jhNum");
            clNum = rs.getInt("clNum");
            qtNum = rs.getInt("qtNum");
            hjNum = ptNum + jtNum + gdNum + jhNum + clNum + qtNum;
            hjptNum += ptNum;
            hjjtNum += jtNum;
            hjgdNum += gdNum;
            hjjhNum += jhNum;
            hjclNum += clNum;
            hjqtNum += qtNum;
            hjhjNum += hjNum;
            countModelList.add(new CountModel(rs.getString("deptname"), ptNum, jtNum, gdNum, jhNum, clNum, qtNum, hjNum));
        }
        countModelList.add(new CountModel("ºÏ¼Æ", hjptNum, hjjtNum, hjgdNum, hjjhNum, hjclNum, hjqtNum, hjhjNum));
        request.setAttribute("countModelList", countModelList);
        request.getRequestDispatcher("/UI/ccb/loan/creditrating/showReportResult.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}