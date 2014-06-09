<!--
/*********************************************************************
* 功能描述: 抵押报送月统计表
* 开发日期: 2011/03/28
* 修 改 人:
* 修改日期:
* 版 权:
***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK" %>
<%@page import="com.ccb.util.CcbLoanConst" %>
<%@page import="net.sf.jxls.report.ReportManager" %>
<%@page import="net.sf.jxls.report.ReportManagerImpl" %>
<%@page import="net.sf.jxls.transformer.XLSTransformer" %>
<%@page import="org.apache.commons.logging.Log" %>
<%@page import="org.apache.commons.logging.LogFactory" %>
<%@page import="org.apache.poi.hssf.usermodel.HSSFWorkbook" %>
<%@page import="pub.platform.advance.utils.PropertyManager" %>
<%@page import="pub.platform.db.ConnectionManager" %>
<%@page import="pub.platform.db.DatabaseConnection" %>
<%@page import="pub.platform.form.config.SystemAttributeNames" %>
<%@page import="pub.platform.security.OperatorManager" %>
<%@ page import="java.io.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%
    Log logger = LogFactory.getLog("mortMStatReprot.jsp");

    OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
//采用do while结构便于在主流程中监测错误发生后退出主程序；
    try {
        do {
            // 输出报表
            response.reset();
            response.setContentType("application/vnd.ms-excel");
            response.addHeader("Content-Disposition", "attachment; filename=" + "mortMStatModel.xls");
            // ----------------------------根据模板创建输出流----------------------------------------------------------------
            //得到报表模板
            String rptModelPath = PropertyManager.getProperty("REPORT_ROOTPATH");
            String rptName = rptModelPath + "mortMStatModel.xls";
            File file = new File(rptName);
            // 判断模板是否存在,不存在则退出
            if (!file.exists()) {
                out.println(rptName + PropertyManager.getProperty("304"));
                break;
            }

            Map beans = new HashMap();

            String startdate = request.getParameter("CUST_OPEN_DT");
            String enddate = request.getParameter("CUST_OPEN_DT2");
            //String basedate_kaohe = request.getParameter("basedate_kaohe");
            //beans.put("basedate_kaohe", basedate_kaohe);

            beans.put("startdate", startdate);
            beans.put("enddate", enddate);

            beans.put("condidate", " 统计期间:" + startdate + "至" + enddate);

            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String reportdate = df.format(date);
            //reportdate = reportdate.substring(0,4)+"年"+reportdate.substring(4,6)+"月"+reportdate.substring(6,8)+"日";
            beans.put("reportdate", "出表日期:" + reportdate);

            //生成统计表数据

            DatabaseConnection conn = ConnectionManager.getInstance().get();

            ReportManager reportManager = new ReportManagerImpl(conn.getConnection(), beans);
            beans.put("rm", reportManager);
            beans.put("deptid", omgr.getOperator().getDeptid());

            XLSTransformer transformer = new XLSTransformer();
            InputStream is = new BufferedInputStream(new FileInputStream(rptName));
            HSSFWorkbook workbook = transformer.transformXLS(is, beans);
            OutputStream os = response.getOutputStream();
            workbook.write(os);
            is.close();
            out.flush();
            out.close();
        } while (false);
    } catch (Exception e) {
        logger.error("生成抵押报送统计表时出现错误。");
        e.printStackTrace();
    } finally {
        //todo: 链接
        ConnectionManager.getInstance().release();
    }
%>
