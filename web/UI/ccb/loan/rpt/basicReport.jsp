<!--
/*********************************************************************
* 功能描述: 基本查询统计
* 作 者:
* 开发日期: 2010/02/12
* 修 改 人:
* 修改日期:
* 版 权:
***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK" %>
<%@page import="pub.platform.db.ConnectionManager" %>
<%@page import="pub.platform.db.DatabaseConnection" %>
<%@page import="pub.platform.db.RecordSet" %>
<%@page import="pub.platform.utils.Basic" %>
<%@page import="com.ccb.util.*" %>
<%@page import="java.io.File" %>
<%@page import="pub.platform.advance.utils.PropertyManager" %>
<%@page import="java.io.InputStream" %>
<%@page import="java.io.FileInputStream" %>
<%@page import="jxl.Workbook" %>
<%@page import="jxl.write.WritableWorkbook" %>
<%@page import="java.io.OutputStream" %>
<%@page import="jxl.write.Label" %>
<%@page import="jxl.write.WritableSheet" %>
<%@page import="jxl.write.Number" %>
<%@page import="jxl.write.WritableCellFormat" %>
<%@page import="jxl.write.WritableFont" %>
<%@page import="jxl.WorkbookSettings" %>
<%@page import="java.util.Locale" %>
<%@page import="pub.platform.security.OperatorManager" %>
<%@page import="pub.platform.form.config.SystemAttributeNames" %>
<%@page import="jxl.format.Alignment" %>
<%@page import="jxl.format.VerticalAlignment"%>
<%

    OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
//采用do while结构便于在主流程中监测错误发生后退出主程序；
    try {
        do {
            // 输出报表
            response.reset();
            response.setContentType("application/vnd.ms-excel");
            response.addHeader("Content-Disposition", "attachment; filename=" + CcbLoanConst.BASIC_RPT_MODEL + ".xls");
            // ----------------------------根据模板----------------------------------------------------------------
            //得到报表模板
            String rptModelPath = PropertyManager.getProperty("REPORT_ROOTPATH");
            String rptName = rptModelPath + CcbLoanConst.BASIC_RPT_MODEL + ".xls";
            File file = new File(rptName);
            // 判断模板是否存在,不存在则退出
            if (!file.exists()) {
                out.println(rptName + PropertyManager.getProperty("304"));
                break;
            }
            WorkbookSettings setting = new WorkbookSettings();
            Locale locale = new Locale("zh", "CN");
            setting.setLocale(locale);
            setting.setEncoding("ISO-8859-1");
            // 得到excel的sheet
            File fileInput = new File(rptName);
            Workbook rw = Workbook.getWorkbook(fileInput, setting);
            WritableWorkbook wwb = Workbook.createWorkbook(response.getOutputStream(), rw, setting);
            // 得到第一个工作表
            WritableSheet ws = wwb.getSheet(0);

            // ----------------从数据库读取数据写入excel中--------------------------------------------------------------------------------
            // 查询字符串
            String whereStr = " where 1=1 ";
            if (!request.getParameter("MORTDATE").equals("")) {
                whereStr += " and b.MORTDATE >='" + request.getParameter("MORTDATE") + "'";
            }
            if (!request.getParameter("MORTDATE2").equals("")) {
                whereStr += " and b.MORTDATE <='" + request.getParameter("MORTDATE2") + "'";
            }
            if (!request.getParameter("EXPRESSENDSDATE").equals("")) {
                whereStr += " and b.EXPRESSENDSDATE >='" + request.getParameter("EXPRESSENDSDATE") + "'";
            }
            if (!request.getParameter("EXPRESSENDSDATE2").equals("")) {
                whereStr += " and b.EXPRESSENDSDATE <='" + request.getParameter("EXPRESSENDSDATE2") + "'";
            }
            if (!request.getParameter("PAPERRTNDATE").equals("")) {
                whereStr += " and b.PAPERRTNDATE >='" + request.getParameter("PAPERRTNDATE") + "'";
            }
            if (!request.getParameter("PAPERRTNDATE2").equals("")) {
                whereStr += " and b.PAPERRTNDATE <='" + request.getParameter("PAPERRTNDATE2") + "'";
            }
            // 取得回执日期
            if (!request.getParameter("RECEIPTDATE").equals("")) {
                whereStr += " and b.RECEIPTDATE >='" + request.getParameter("RECEIPTDATE") + "'";
            }
            if (!request.getParameter("RECEIPTDATE2").equals("")) {
                whereStr += " and b.RECEIPTDATE <='" + request.getParameter("RECEIPTDATE2") + "'";
            }

            if (!request.getParameter("CLRPAPERDATE").equals("")) {
                whereStr += " and b.CLRPAPERDATE >='" + request.getParameter("CLRPAPERDATE") + "'";
            }
            if (!request.getParameter("CLRPAPERDATE2").equals("")) {
                whereStr += " and b.CLRPAPERDATE <='" + request.getParameter("CLRPAPERDATE2") + "'";
            }
            if (!request.getParameter("RELEASECONDCD").equals("")) {
                whereStr += " and b.RELEASECONDCD ='" + request.getParameter("RELEASECONDCD") + "'";
            }
            if (!request.getParameter("MORTOVERRTNDATE").equals("")) {
                whereStr += " and b.MORTOVERRTNDATE >='" + request.getParameter("MORTOVERRTNDATE") + "'";
            }
            if (!request.getParameter("MORTOVERRTNDATE2").equals("")) {
                whereStr += " and b.MORTOVERRTNDATE <='" + request.getParameter("MORTOVERRTNDATE2") + "'";
            }
            if (request.getParameter("NOMORTREASONCD").equals("1")) {
                whereStr += " and trim(b.NOMORTREASONCD) is not null ";
            }else if(request.getParameter("NOMORTREASONCD").equals("0")){
                whereStr += " and trim(b.NOMORTREASONCD) is  null ";
            }
            if (!request.getParameter("MORTREGSTATUS").equals("")) {
                whereStr += " and b.MORTREGSTATUS ='" + request.getParameter("MORTREGSTATUS") + "'";
            }
            
            // 快递回证日期起始
            if (!request.getParameter("EXPRESSRTNDATE").equals("")) {
                whereStr += " and b.EXPRESSRTNDATE >='" + request.getParameter("EXPRESSRTNDATE") + "'";
            }
            if (!request.getParameter("EXPRESSRTNDATE2").equals("")) {
                whereStr += " and b.EXPRESSRTNDATE <='" +request.getParameter("EXPRESSRTNDATE2") + "'";
            }
            // 借证领用
            if (!request.getParameter("CHGPAPERDATE").equals("")) {
                whereStr += " and b.CHGPAPERDATE >='" + request.getParameter("CHGPAPERDATE")+ "'";
            }
            if (!request.getParameter("CHGPAPERDATE2").equals("")) {
                whereStr += " and b.CHGPAPERDATE <='" + request.getParameter("CHGPAPERDATE2") + "'";
            }
            // 借证归还
            if (!request.getParameter("CHGPAPERRTNDATE").equals("")) {
                whereStr += " and b.CHGPAPERRTNDATE >='" + request.getParameter("CHGPAPERRTNDATE") + "'";
            }
            if (!request.getParameter("CHGPAPERRTNDATE2").equals("")) {
                whereStr += " and b.CHGPAPERRTNDATE <='" + request.getParameter("CHGPAPERRTNDATE2") + "'";
            }
            
            DatabaseConnection conn = ConnectionManager.getInstance().get();
            // 模糊查询匹配规则：前端一致
            RecordSet rs = conn.executeQuery(""
                    // 贷款信息
                    + "select a.nbxh,"
//        +"a.bankid,"
                    + "(select deptname from ptdept where deptid=a.bankid) as bankname,"
                    + "a.cust_name,"
//        +"a.ln_typ,"
                    + "(select code_desc from ln_odsb_code_desc where code_type_id='053' and code_id=a.LN_TYP) as ln_typ_name,"
                    + "a.RT_ORIG_LOAN_AMT,a.RT_TERM_INCR,a.RATECALEVALUE,a.CUST_OPEN_DT,a.EXPIRING_DT,"
                    + "(select code_desc from ln_odsb_code_desc where code_type_id='807' and code_id = a.GUARANTY_TYPE)as GUARANTY_TYPE,"
                    + "a.PROJ_NO,"
                    + "(select proj_name from ln_coopproj where proj_no=a.proj_no)as proj_name,"
                    + "(select CORPNAME from ln_coopproj where proj_no=a.proj_no)as CORPNAME,"
                    + "(select opername from ptoper where operid=a.operid)as opername,"
                    //抵押信息
                    + "b.MORTDATE,b.MORTID,"
                    + "(select enuitemlabel from ptenudetail where enutype='MORTECENTERCD' and enuitemvalue=b.MORTECENTERCD)as MORTECENTERCD,"
                    + "(select enuitemlabel from ptenudetail where enutype='KEEPCONT' and enuitemvalue=b.KEEPCONT)as keepcont,"
                    + "b.EXPRESSNO,b.EXPRESSENDSDATE,b.EXPRESSNOTE,"
                    + "(select enuitemlabel from ptenudetail where enutype='RELAYFLAG' and enuitemvalue=b.RELAYFLAG) as RELAYFLAG,"
                    + "(select enuitemlabel from ptenudetail where enutype='SENDFLAG' and enuitemvalue=b.SENDFLAG) as SENDFLAG,"
                    + "(select enuitemlabel from ptenudetail where enutype='NOMORTREASONCD' and enuitemvalue=b.NOMORTREASONCD) as NOMORTREASONCD,"
                    + "(select enuitemlabel from ptenudetail where enutype='MORTREGSTATUS' and enuitemvalue=b.MORTREGSTATUS) as MORTREGSTATUS,"
                    + "b.MORTEXPIREDATE,b.MORTOVERRTNDATE,b.PAPERRTNDATE,b.CHGPAPERDATE,b.CHGPAPERRTNDATE,b.CLRPAPERDATE,expressrtndate,"
                    + "(select enuitemlabel from ptenudetail where enutype='CHGPAPERREASONCD' and enuitemvalue=b.CHGPAPERREASONCD) as CHGPAPERREASONCD "
                    //+"from ln_loanapply a left join ln_mortinfo b on a.loanid=b.loanid   "
                    //+"where exists (select 1 from ln_mortinfo  where loanid=a.loanid)  " ;
//        +" (select deptname from ptdept where deptid=a.deptid) as deptname "
                    + " from ln_loanapply a inner join ln_mortinfo b on a.loanid=b.loanid   "
                    + whereStr
                    + " and a.bankid in(select deptid from ptdept start with deptid='" + omgr.getOperator().getDeptid() + "' connect by prior deptid=parentdeptid) "
                    + " order by a.bankid,a.cust_name ");
            int i = 0;
            // 单元格样式
            WritableCellFormat wcf = new WritableCellFormat(new WritableFont(WritableFont.COURIER, 11, WritableFont.NO_BOLD, false));
            wcf.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
            wcf.setAlignment(Alignment.LEFT);
            wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
            wcf.setWrap(false);

            //居右对齐
            WritableCellFormat wcf_right = new WritableCellFormat(new WritableFont(WritableFont.COURIER, 11, WritableFont.NO_BOLD, false));
            wcf_right.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
            wcf_right.setAlignment(Alignment.RIGHT);
            wcf_right.setVerticalAlignment(VerticalAlignment.CENTRE);
            wcf_right.setWrap(false);
            //开始行
            int beginRow = 2;
            //开始列
            int beginCol = 1;
            int k = 0;
            while (rs.next()) {
                // 从第2行开始写数据
/*
                // 经办行代码
                Label label = new Label(beginCol+k, i + beginRow, rs.getString("bankid"), wcf);
                ws.addCell(label);
                k++;
*/

                // 经办行名称
               Label label = new Label(beginCol+k, i + beginRow, rs.getString("bankname"), wcf);
                ws.addCell(label);
                k++;
                // 借款人姓名
                label = new Label(beginCol+k, i + beginRow, rs.getString("cust_name"), wcf);
                ws.addCell(label);
                k++;
/*
                // 贷款种类代码
                label = new Label(beginCol+k, i + beginRow, rs.getString("ln_typ"), wcf);
                ws.addCell(label);
                k++;
*/
                // 贷款种类
                label = new Label(beginCol+k, i + beginRow, rs.getString("ln_typ_name"), wcf);
                ws.addCell(label);
                k++;
                // 贷款金额
                label = new Label(beginCol+k, i + beginRow, rs.getString("RT_ORIG_LOAN_AMT"), wcf_right);
                ws.addCell(label);
                k++;
                // 贷款期限
                label = new Label(beginCol+k, i + beginRow, rs.getString("RT_TERM_INCR"), wcf_right);
                ws.addCell(label);
                k++;
                // 利率浮动比例
                label = new Label(beginCol+k, i + beginRow, rs.getString("RATECALEVALUE"), wcf_right);
                ws.addCell(label);
                k++;
                // 开户日期
                label = new Label(beginCol+k, i + beginRow, rs.getString("CUST_OPEN_DT"), wcf);
                ws.addCell(label);
                k++;
                // 到期日期
                label = new Label(beginCol+k, i + beginRow, rs.getString("EXPIRING_DT"), wcf);
                ws.addCell(label);
                k++;
                // 担保方式
                label = new Label(beginCol+k, i + beginRow, rs.getString("GUARANTY_TYPE"), wcf);
                ws.addCell(label);
                k++;
                // 担保物价值
                label = new Label(beginCol+k, i + beginRow, rs.getString("RT_TERM_INCR"), wcf_right);
                ws.addCell(label);
                k++;
                // 合作项目编号
                label = new Label(beginCol+k, i + beginRow, rs.getString("PROJ_NO"), wcf);
                ws.addCell(label);
                k++;
                // 合作项目名称
                label = new Label(beginCol+k, i + beginRow, rs.getString("proj_name"), wcf);
                ws.addCell(label);
                k++;
                // 合作方名称
                label = new Label(beginCol+k, i + beginRow, rs.getString("CORPNAME"), wcf);
                ws.addCell(label);
                k++;
                // 贷款经办人
                label = new Label(beginCol+k, i + beginRow, rs.getString("opername"), wcf);
                ws.addCell(label);
                k++;
                // 抵押接收日期
                label = new Label(beginCol+k, i + beginRow, rs.getString("MORTDATE"), wcf);
                ws.addCell(label);
                k++;
                // 抵押编号
                label = new Label(beginCol+k, i + beginRow, rs.getString("MORTID"), wcf);
                ws.addCell(label);
                k++;
                // 抵押交易中心
                label = new Label(beginCol+k, i + beginRow, rs.getString("MORTECENTERCD"), wcf);
                ws.addCell(label);
                k++;
                // 保管内容
                label = new Label(beginCol+k, i + beginRow, rs.getString("KEEPCONT"), wcf);
                ws.addCell(label);
                k++;
                // 快递编号
                label = new Label(beginCol+k, i + beginRow, rs.getString("EXPRESSNO"), wcf);
                ws.addCell(label);
                k++;
                // 快递发出日期
                label = new Label(beginCol+k, i + beginRow, rs.getString("EXPRESSENDSDATE"), wcf);
                ws.addCell(label);
                k++;
                // 快递备注
                label = new Label(beginCol+k, i + beginRow, rs.getString("EXPRESSNOTE"), wcf);
                ws.addCell(label);
                k++;
                // 不可报抵押资料交接标志
                label = new Label(beginCol+k, i + beginRow, rs.getString("RELAYFLAG"), wcf);
                ws.addCell(label);
                k++;
                // 可报抵押标志
                label = new Label(beginCol+k, i + beginRow, rs.getString("SENDFLAG"), wcf);
                ws.addCell(label);
                k++;
                // 未办理抵押原因
                label = new Label(beginCol+k, i + beginRow, rs.getString("NOMORTREASONCD"), wcf);
                ws.addCell(label);
                k++;
                // 抵押登记状态
                label = new Label(beginCol+k, i + beginRow, rs.getString("MORTREGSTATUS"), wcf);
                ws.addCell(label);
                k++;
                // 抵押到期日
                label = new Label(beginCol+k, i + beginRow, rs.getString("MORTEXPIREDATE"), wcf);
                ws.addCell(label);
                k++;
                // 抵押超批复日期
                label = new Label(beginCol+k, i + beginRow, rs.getString("MORTOVERRTNDATE"), wcf);
                ws.addCell(label);
                k++;
                // 入库日期
                label = new Label(beginCol+k, i + beginRow, rs.getString("PAPERRTNDATE"), wcf);
                ws.addCell(label);
                k++;
                // 借证领用日期
                label = new Label(beginCol+k, i + beginRow, rs.getString("CHGPAPERDATE"), wcf);
                ws.addCell(label);
                k++;
                // 借证归还日期
                label = new Label(beginCol+k, i + beginRow, rs.getString("CHGPAPERRTNDATE"), wcf);
                ws.addCell(label);
                k++;
                // 结清取证日期
                label = new Label(beginCol+k, i + beginRow, rs.getString("CLRPAPERDATE"), wcf);
                ws.addCell(label);
                k++;
                // 快递回证日期
                label = new Label(beginCol+k, i + beginRow, rs.getString("expressrtndate"), wcf);
                ws.addCell(label);
                k++;
                // 借证原因
                label = new Label(beginCol+k, i + beginRow, rs.getString("CHGPAPERREASONCD"), wcf);
                ws.addCell(label);
                k++;
/*

                // 机构
                label = new Label(beginCol+k, i + beginRow, rs.getString("deptname"), wcf);
                ws.addCell(label);
*/

                k=0;
                // 行计数器加1
                i++;
            }
            //--------------------------------关闭excel操作------------------------------------------------------------------------
            // 关闭excel
            wwb.write();
            wwb.close();
            rw.close();

            //--------------------------------输出报表-----------------------------------------------------------------------------
            // 输出报表
            out.flush();
            out.close();
        } while (false);
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // 释放数据库连接
        ConnectionManager.getInstance().release();
    }
%>
