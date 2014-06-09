package com.ccb.servlet;

import com.ccb.creditrating.CountModel;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import pub.platform.advance.utils.PropertyManager;
import pub.platform.db.ConnectionManager;
import pub.platform.db.DatabaseConnection;
import pub.platform.db.RecordSet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportCountExcelServlet extends HttpServlet {
    private static final Log logger = LogFactory.getLog(ReportCountExcelServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        ServletOutputStream os = response.getOutputStream();

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
        String sql1 = "select (select t.deptname from ptdept t where t.deptid= tab1.judgedeptid) as deptName,(select count(lp.creditratingno) from ln_pscoredetail lp where lp.inideptid = tab1.judgedeptid and lp.finamt > 0 " + sqlWhere1 + ") as ptNum,sum(decode(tab1.judgetype,'01',tab1.recordNum,0)) jtNum,sum(decode(tab1.judgetype,'02',tab1.recordNum,0)) gdNum,sum(decode(tab1.judgetype,'03',tab1.recordNum,0)) jhNum,sum(decode(tab1.judgetype,'04',tab1.recordNum,0)) clNum,sum(decode(tab1.judgetype,'05',tab1.recordNum,0)) qtNum from (select tab.judgedeptid,tab.judgetype ,count(tab.judgetype) as recordNum from (select lu.creditratingno,lu.judgetype,lu.judgedeptid  from (select l.* from ln_uncomcredit l where l.recsta = '1' and l.begdate = (select min(t.begdate) from ln_uncomcredit t where t.creditratingno = l.creditratingno and t.judgeprice > 0 group by t.creditratingno)) lu " + sqlWhere2 + " group by lu.creditratingno,lu.judgetype,lu.judgedeptid order by lu.creditratingno,lu.judgetype) tab group by tab.judgedeptid,tab.judgetype order by tab.judgedeptid) tab1 group by tab1.judgedeptid";
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
        countModelList.add(new CountModel("合计", hjptNum, hjjtNum, hjgdNum, hjjhNum, hjclNum, hjqtNum, hjhjNum));
        String resultFileName = "资信评定统计表_" + System.currentTimeMillis() + ".xls";
//        String templateFileName = this.getServletContext().getRealPath("/report/creatReportCount.xls");
        String templateFileName = PropertyManager.getProperty("REPORT_ROOTPATH") + "creatReportCount.xls";
        Map<String, Object> attrsMaps = new HashMap<String, Object>();//存储属性和值
        attrsMaps.put("countModelList", countModelList);
        String countDateStr = "";
        if (countDateBegVal.length() == 0 && countDateEndVal.length() == 0) {
            countDateStr = "所有";
        } else if (countDateBegVal.length() > 0 && countDateEndVal.length() == 0) {
            countDateStr = "起始:" + countDateBegVal;
        } else if (countDateBegVal.length() == 0 && countDateEndVal.length() > 0) {
            countDateStr = "截止：" + countDateEndVal;
        } else if (countDateBegVal.length() > 0 && countDateEndVal.length() > 0) {
            countDateStr = countDateBegVal + "至" + countDateEndVal;
        }
        attrsMaps.put("countDate", countDateStr);
        InputStream is = null;
        try {
            XLSTransformer transformer = new XLSTransformer();
            is = new BufferedInputStream(new FileInputStream(templateFileName));
            HSSFWorkbook wb = transformer.transformXLS(is, attrsMaps);
            response.reset();
            response.setHeader("Content-disposition", "attachment; filename=" + java.net.URLEncoder.encode(resultFileName, "UTF-8"));
            response.setContentType("application/msexcel");
            wb.write(os);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("写入excel出现错误！");
            logger.error(e.getMessage());
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
