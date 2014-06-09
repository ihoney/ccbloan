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
    Log logger = LogFactory.getLog("flowOperReport.jsp");

    OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
//采用do while结构便于在主流程中监测错误发生后退出主程序；
    try {
        do {
            // 输出报表
            String operid = request.getParameter("REALCUSTMGR_ID");
            String startdate = request.getParameter("STARTDATE");
            String enddate = request.getParameter("ENDDATE");

            response.reset();
            response.setContentType("application/vnd.ms-excel");
            String exportName = new String("个贷业务报表.xls".getBytes(), "ISO8859-1");
            response.addHeader("Content-Disposition", "attachment; filename=" + exportName);
            // ----------------------------根据模板创建输出流----------------------------------------------------------------
            //得到报表模板
            String rptModelPath = PropertyManager.getProperty("REPORT_ROOTPATH");
            String rptTemplateName = rptModelPath + "flowOperReport.xls";
            File file = new File(rptTemplateName);
            // 判断模板是否存在,不存在则退出
            if (!file.exists()) {
                out.println(rptTemplateName + PropertyManager.getProperty("304"));
                break;
            }

            Map beans = new HashMap();
            String strWhere = "";
            if (operid != null && !operid.equals("")) {
                strWhere =strWhere + " and d.operid = '"+operid+"'";
            }

            if (startdate != null && !startdate.equals("")) {
                strWhere =strWhere + " and d.operdate >= '"+startdate+"'";
            }

            if (enddate != null && !enddate.equals("")) {
                strWhere = strWhere + " and d.operdate <= '"+enddate+"'";
            }

            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String reportdate = df.format(date);
            //reportdate = reportdate.substring(0,4)+"年"+reportdate.substring(4,6)+"月"+reportdate.substring(6,8)+"日";
            beans.put("currdate", reportdate);
            beans.put("reportdate", "出表日期:" + reportdate); //报表TITLE使用

            DatabaseConnection conn = ConnectionManager.getInstance().get();
            ReportManager reportManager = new ReportManagerImpl(conn.getConnection(), beans);

            String infoSql = "select " +
                    "       (select opername from ptoper where operid = d.operid) as opername," +
                    "       (select roledesc from ptrole where roleid = (select min(roleid) from ptoperrole where operid = d.operid and roleid like 'WF%')) as roledesc," +
                    "       d.operdate," +
                    "       d.opertime," +
                    "       d.flowstat,(select enuitemlabel from ptenudetail where ENUITEMVALUE = d.flowstat and ENUTYPE='ARCHIVEFLOW') as enuitemlabel," +
                    "       d.remark," +
                    "       a.flowsn as keycode," +
                    "       decode(b.loanid, null, a.cust_name, b.cust_name) cust_name," +
                    "       decode(b.loanid, null, a.rt_orig_loan_amt, b.rt_orig_loan_amt) rt_orig_loan_amt," +
                    "       decode(b.loanid, null, a.rt_term_incr, b.rt_term_incr)  rt_term_incr," +
                    "       (select deptname from ptdept where deptid = decode(b.loanid, null, a.bankid, b.bankid)) as bankname," +
                    "       (select prommgr_name  from ln_prommgrinfo where prommgr_id = decode(b.loanid, null, a.custmgr_id, b.custmgr_id)) as custmgr_name," +
                    "       (select deptname from ptdept where deptid = decode(b.loanid, null, a.cust_bankid, c.cust_bankid)) as cust_bankname," +
                    "       (select opername from ptoper where operid = decode(b.loanid, null, a.realcustmgr_id, c.custmgr_id)) as realcustmgr_name," +
                    "       (select  code_desc  from ln_odsb_code_desc where code_type_id='053' and code_id = c.ln_typ) as ln_typ" +
                    "   from ln_archive_info a " +
                    "   Left outer join ln_loanapply b on a.loanid = b.loanid "+
                    "   Left outer join ln_promotioncustomers c on a.loanid = c.loanid "+
                    "   Left outer join ln_archive_flow d on a.flowsn = d.flowsn "+
                    "  where 1 = 1" +
                    " ";

            infoSql += "  and exists (select  1 from (select deptid from ptdept start with deptid = '" + omgr.getOperator().getDeptid() + "' connect by prior deptid = parentdeptid)  where a.bankid = deptid) ";

            infoSql = infoSql +strWhere;
            infoSql = infoSql +  " order by d.operdate desc,d.opertime desc ";

            List reportList = new ArrayList();
            reportList = reportManager.exec(infoSql);
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
