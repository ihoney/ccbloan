<!--
/*********************************************************************
* 功能描述:
* 作 者: zhanrui
* 开发日期: 2012-04-07
* 修 改 人:
* 修改日期:
* 版 权:
***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK" %>
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
<%@ page import="java.util.*" %>
<%
    Log logger = LogFactory.getLog("flowInfoReport.jsp");

    OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
//采用do while结构便于在主流程中监测错误发生后退出主程序；
    try {
        do {
            // 输出报表
            String startdate = request.getParameter("MORTEXPIREDATE");
            String enddate = request.getParameter("MORTEXPIREDATE2");

            response.reset();
            response.setContentType("application/vnd.ms-excel");
            String exportName = new String("用印清单报表.xls".getBytes(), "ISO8859-1");
            response.addHeader("Content-Disposition", "attachment; filename=" + exportName);
            // ----------------------------根据模板创建输出流----------------------------------------------------------------
            //得到报表模板
            String rptModelPath = PropertyManager.getProperty("REPORT_ROOTPATH");
            String rptTemplateName = rptModelPath + "flowInfo.xls";
            File file = new File(rptTemplateName);
            // 判断模板是否存在,不存在则退出
            if (!file.exists()) {
                out.println(rptTemplateName + PropertyManager.getProperty("304"));
                break;
            }

            Map beans = new HashMap();
            String strWhere = "";
            if (startdate != null && !startdate.equals("")) {
                strWhere = " and a.operdate >= '"+startdate+"'";
            }

            if (enddate != null && !enddate.equals("")) {
                strWhere = strWhere + " and a.operdate <= '"+enddate+"'";
            }

            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String reportdate = df.format(date);
            //reportdate = reportdate.substring(0,4)+"年"+reportdate.substring(4,6)+"月"+reportdate.substring(6,8)+"日";
            beans.put("currdate", reportdate);
            beans.put("reportdate", "出表日期:" + reportdate); //报表TITLE使用

            DatabaseConnection conn = ConnectionManager.getInstance().get();
            ReportManager reportManager = new ReportManagerImpl(conn.getConnection(), beans);

            String sql ="select rownum,aa.* from (Select a.flowsn,a.operdate,b.cust_name " +
                    " from ln_archive_flow a " +
                    " Left outer join ln_archive_info b on a.flowsn=b.flowsn " +
                    " where 1= 1 "+
                    " and a.operid in (select a.operid from ptoper a where a.operid in" +
                    " (select b.operid from ptoperrole b where b.roleid='WF0007')" +
                    " and a.deptid in (" +
                    " select deptid from ptdept" +
                    " start with deptid = '" + omgr.getOperator().getDeptid() + "'" +
                    " connect by prior deptid = parentdeptid" +
                    ")) "+
                    " and exists (select  1 from (select deptid from ptdept start with deptid = '" + omgr.getOperator().getDeptid() + "' connect by prior deptid = parentdeptid)  where b.bankid = deptid)"+
                    strWhere+
                    " order by a.operdate)aa ";

            List reportList = new ArrayList();
            reportList = reportManager.exec(sql);
            beans.put("records",reportList);


            XLSTransformer transformer = new XLSTransformer();
            InputStream is = new BufferedInputStream(new FileInputStream(rptTemplateName));
            HSSFWorkbook workbook = transformer.transformXLS(is, beans);
            OutputStream os = response.getOutputStream();
            workbook.write(os);
            is.close();
            out.flush();
            out.close();

        } while (false);
    } catch (Exception e) {
        logger.error("生成报表时出现错误。", e);
        out.write("系统处理出现错误：" + e.getMessage());
    } finally {
        //TODO: 链接
        ConnectionManager.getInstance().release();
    }
%>
