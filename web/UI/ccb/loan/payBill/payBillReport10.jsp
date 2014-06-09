<!--
/*********************************************************************
* 功能描述: 买单工资统计项目表10
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
<%@page import="java.io.OutputStream" %>
<%@page import="jxl.WorkbookSettings" %>
<%@page import="java.util.Locale" %>
<%@page import="pub.platform.security.OperatorManager" %>
<%@page import="pub.platform.form.config.SystemAttributeNames" %>
<%@page import="jxl.Cell" %>
<%@page import="jxl.format.Alignment" %>
<%@page import="jxl.format.Border" %>
<%@page import="jxl.format.VerticalAlignment" %>
<%@page import="jxl.format.BorderLineStyle" %>
<%@page import="pub.platform.db.DBUtil" %>
<%@ page import="jxl.write.*" %>
<%@ page import="jxl.write.Number" %>
<%

    OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
    final String RPTLABEL01 = "个人住房贷款(仅含个人住房贷款、个人再交易住房贷款)";
    final String RPTLABEL02 = "个人助业贷款";
    final String RPTLABEL03 = "个人类其他贷款（含个人商用房、个人最高额、个人消费额度、个人汽车、个人质押贷款等）";
//采用do while结构便于在主流程中监测错误发生后退出主程序；
    try {
        do {
            // 输出报表
            response.reset();
            response.setContentType("application/vnd.ms-excel");
            response.addHeader("Content-Disposition", "attachment; filename=" + CcbLoanConst.RPT_PAY_BILL_10 + ".xls");
            // --------------根据模板创建新workbook得到可操作的writableworkbook写到输出流中-------------------------------
            //得到报表模板
            String rptModelPath = PropertyManager.getProperty("REPORT_ROOTPATH");
            String rptName = rptModelPath + CcbLoanConst.RPT_PAY_BILL_10 + ".xls";
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
            // 写到jsp中的输出流中
            WritableWorkbook wwb = Workbook.createWorkbook(response.getOutputStream(), rw, setting);
            // 得到第一个工作表
            WritableSheet ws = wwb.getSheet(0);

            // ----------------从数据库读取数据写入excel中--------------------------------------------------------------
            // 查询字符串
            String whereStr = " where 1=1  and t.LOANSTATE is not null  and t.LOANSTATE <> '0' ";
            if (!request.getParameter("CUST_OPEN_DT").trim().equals("")) {
                whereStr += " and t.CUST_OPEN_DT >='" + request.getParameter("CUST_OPEN_DT").trim() + "'";
            }
            if (!request.getParameter("CUST_OPEN_DT2").trim().equals("")) {
                whereStr += " and t.CUST_OPEN_DT <='" + request.getParameter("CUST_OPEN_DT2").trim() + "'";
            }

//            String loantype3="t.ln_typ not in ('013','011','033','117')";
            String loantype1="t.ln_typ  in ('011','013')";
            String loantype2="t.ln_typ  in ('033','433')";
            String loantype3="t.ln_typ  in ('012','014','015','016','020','022','026','028','029','030','031','113','114','115','122')";

            DatabaseConnection conn = ConnectionManager.getInstance().get();
            // 统计查询语句
            RecordSet rs = conn.executeQuery(""

                    + " select t.bankid,(select deptname from ptdept where deptid=t.bankid)as bankname,"

                    + " sum(case"
                    + "       when (" + loantype1 + " and t.RATECALEVALUE <= " + PropertyManager.getProperty("RATE_CODE_75") + ") then"
                    + "        rt_orig_loan_amt"
                    + "       else"
                    + "        null"
                    + "     end) as amt11,"


                    + " sum(case"
                    + "       when (" + loantype1 + " and t.RATECALEVALUE > " + PropertyManager.getProperty("RATE_CODE_75") + " and "
                    + " t.RATECALEVALUE < "+PropertyManager.getProperty("RATE_CODE_80")+") then"
                    + "        rt_orig_loan_amt"
                    + "       else"
                    + "        null"
                    + "     end) as amt12,"

                    + " sum(case"
                    + "       when (" + loantype1 + " and t.RATECALEVALUE >=" + PropertyManager.getProperty("RATE_CODE_80") + " and "
                    + " t.RATECALEVALUE < "+PropertyManager.getProperty("RATE_CODE_85")+") then"
                    + "        rt_orig_loan_amt"
                    + "       else"
                    + "        null"
                    + "     end) as amt13,"
                    
                    + " sum(case"
                    + "       when (" + loantype1 + " and t.RATECALEVALUE >=" + PropertyManager.getProperty("RATE_CODE_85") + ") then"
                    + "        rt_orig_loan_amt"
                    + "       else"
                    + "        null"
                    + "     end) as amt14,"
                    
                    + " sum(case"
                    + "       when (" + loantype2 + " and t.RATECALEVALUE <" + PropertyManager.getProperty("RATE_CODE_12") + ") then"
                    + "        rt_orig_loan_amt"
                    + "       else"
                    + "        null"
                    + "     end) as amt21,"
                    
                    + " sum(case"
                    + "       when (" + loantype2 + " and t.RATECALEVALUE >=" + PropertyManager.getProperty("RATE_CODE_12") + ") then"
                    + "        rt_orig_loan_amt"
                    + "       else"
                    + "        null"
                    + "     end) as amt22,"
                    
                    + " sum(case"
                    + "       when (" + loantype3 + " and t.RATECALEVALUE <" + PropertyManager.getProperty("RATE_CODE_10") + ") then"
                    + "        rt_orig_loan_amt"
                    + "       else"
                    + "        null"
                    + "     end) as amt31,"
                    
                    + " sum(case"
                    + "       when (" + loantype3 + " and t.RATECALEVALUE <" + PropertyManager.getProperty("RATE_CODE_11") + " and "
                    + " t.RATECALEVALUE>="+PropertyManager.getProperty("RATE_CODE_10")+" ) then"
                    + "        rt_orig_loan_amt"
                    + "       else"
                    + "        null"
                    + "     end) as amt32,"
                    
                    + " sum(case"
                    + "       when (" + loantype3 + " and t.RATECALEVALUE <" + PropertyManager.getProperty("RATE_CODE_12") + " and "
                    + " t.RATECALEVALUE>="+PropertyManager.getProperty("RATE_CODE_11")+" ) then"
                    + "        rt_orig_loan_amt"
                    + "       else"
                    + "        null"
                    + "     end) as amt33,"
                    
                    + " sum(case"
                    + "       when (" + loantype3 + " and t.RATECALEVALUE >=" + PropertyManager.getProperty("RATE_CODE_12") + ") then"
                    + "        rt_orig_loan_amt"
                    + "       else"
                    + "        null"
                    + "     end) as amt34 "
                    
                    + " from ln_loanapply t"
                    //+" where t.custmgr_id ='xujian.qd'"
                    + whereStr
                    + " and t.bankid in(select deptid from ptdept start with deptid='" + omgr.getOperator().getDeptid() + "' connect by prior deptid=parentdeptid) "
                    + " group by bankid"
                    + " order by bankid"
                    + "  ");
            // 行计数器
            int i = 0;
            // 步长（每条记录输出10行）
            int step = 10;
            int cnt = i * step;
            // --------------字体样式--------------------
            // ---文字样式 居中对齐----
            WritableFont NormalFont = new WritableFont(WritableFont.COURIER, 11);
            // 正常字体
            WritableCellFormat wcf_center = new WritableCellFormat(NormalFont);
            //  线条
            wcf_center.setBorder(Border.ALL, BorderLineStyle.THIN);
            //  垂直对齐
            wcf_center.setVerticalAlignment(VerticalAlignment.CENTRE);
            //水平居中对齐
            wcf_center.setAlignment(Alignment.CENTRE);
            wcf_center.setWrap(true);  //  是否换行

            // ----数值样式 居右对齐---///统一改为居中对齐
            WritableCellFormat wcf_right = new WritableCellFormat(new WritableFont(WritableFont.COURIER, 11, WritableFont.NO_BOLD, false));
            // 边框样式
            wcf_right.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
            // 折行
            wcf_right.setWrap(false);
            // 垂直对齐
            wcf_right.setVerticalAlignment(VerticalAlignment.CENTRE);
            // 水平对齐
            wcf_right.setAlignment(Alignment.RIGHT);


            //Number
            NumberFormat nf = new NumberFormat("#,###,###,##0.00");
            WritableCellFormat wcf_number = new WritableCellFormat(nf);
            wcf_number.setFont(new WritableFont(WritableFont.COURIER, 11, WritableFont.NO_BOLD, false));
            // 边框样式
            wcf_number.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
            // 折行
            wcf_number.setWrap(false);
            // 垂直对齐
            wcf_number.setVerticalAlignment(VerticalAlignment.CENTRE);
            // 水平对齐
            wcf_number.setAlignment(Alignment.RIGHT);


            // 总金额
            double totalAmt = 0;
            // 行高
            int rowHeight = 500;
            // 开始行
            int beginRow = 4;
            // 开始列
            int beginCol = 1;

            //题头
            String startdate = request.getParameter("CUST_OPEN_DT").trim();
            String enddate = request.getParameter("CUST_OPEN_DT2").trim();
            ws.setRowView(2, 600, false);

            jxl.format.CellFormat fmtPt = ws.getCell(1, 2).getCellFormat();

            startdate = startdate.substring(0, 4) + "年" + Integer.parseInt(startdate.substring(5, 7)) + "月" + Integer.parseInt(startdate.substring(8, 10)) + "日";
            enddate = enddate.substring(0, 4) + "年" + Integer.parseInt(enddate.substring(5, 7)) + "月" + Integer.parseInt(enddate.substring(8, 10)) + "日";
            Label lbl_t = new Label(1, 2, startdate + "-" + enddate, fmtPt);
            ws.addCell(lbl_t);

            while (rs.next()) {
                cnt = i * step;
                if (i > 0) {
                    cnt = cnt - i;
                }

                String bankName = rs.getString("bankname");
                //一个机构内的行数偏移值
                int rowoffset = 0;
                // 从第5行开始写数据
                //--------------------------第一行--------------------------------
                ws.setRowView(i + beginRow + cnt + rowoffset, rowHeight, false);
                // 机构名称
                Label lbl = new Label(beginCol, i + beginRow + cnt + rowoffset, bankName, wcf_center);
                ws.addCell(lbl);
                // 贷款种类
                lbl = new Label(beginCol + 1, i + beginRow + cnt + rowoffset, RPTLABEL01, wcf_center);
                ws.addCell(lbl);
                // 利率执行水平
                lbl = new Label(beginCol + 2, i + beginRow + cnt + rowoffset, "X<="+PropertyManager.getProperty("RATE_CODE_75"), wcf_center);
                ws.addCell(lbl);
                // 贷款发放额
                Number nLbl = new Number(beginCol + 3, i + beginRow + cnt + rowoffset, rs.getDouble("amt11"), wcf_number);
                ws.addCell(nLbl);
                // 计算总额
                totalAmt += rs.getDouble("amt11");

                rowoffset++;
                //--------------------------第2行--------------------------------
                ws.setRowView(i + beginRow + cnt + rowoffset, rowHeight, false);
                // 机构名称
                lbl = new Label(beginCol, i + beginRow + cnt + rowoffset, bankName, wcf_center);
                ws.addCell(lbl);
                // 贷款种类
                lbl = new Label(beginCol + 1, i + beginRow  + rowoffset + cnt, RPTLABEL01, wcf_center);
                ws.addCell(lbl);
                // 利率执行水平
                lbl = new Label(beginCol + 2, i + beginRow + cnt + rowoffset, PropertyManager.getProperty("RATE_CODE_75")+"<X<"+PropertyManager.getProperty("RATE_CODE_80"), wcf_center);
                ws.addCell(lbl);
                // 贷款发放额
                nLbl = new Number(beginCol + 3, i + beginRow + cnt + rowoffset, rs.getDouble("amt12"), wcf_number);
                ws.addCell(nLbl);
                // 计算总额
                totalAmt += rs.getDouble("amt12");

                rowoffset++;
                //---------------------------第3行-------------------------------
                ws.setRowView(i + beginRow  + rowoffset + cnt, rowHeight, false);
                // 机构名称
                lbl = new Label(beginCol, i + beginRow  + rowoffset + cnt, bankName, wcf_center);
                ws.addCell(lbl);
                // 贷款种类
                lbl = new Label(beginCol + 1, i + beginRow  + rowoffset + cnt, RPTLABEL01, wcf_center);
                ws.addCell(lbl);                
                // 利率执行水平
                lbl = new Label(beginCol + 2, i + beginRow  + rowoffset + cnt, PropertyManager.getProperty("RATE_CODE_80")+"<=X<"+PropertyManager.getProperty("RATE_CODE_85"), wcf_center);
                ws.addCell(lbl);
                // 贷款发放额
                nLbl = new Number(beginCol + 3, i + beginRow  + rowoffset + cnt, rs.getDouble("amt13"), wcf_number);
                ws.addCell(nLbl);
                // 计算总额
                totalAmt += rs.getDouble("amt13");

                rowoffset++;
                //---------------------------第4行-------------------------------
                ws.setRowView(i + beginRow  + rowoffset + cnt, rowHeight, false);
                // 机构名称
                lbl = new Label(beginCol, i + beginRow  + rowoffset+ cnt, bankName, wcf_center);
                ws.addCell(lbl);
                // 贷款种类
                lbl = new Label(beginCol + 1, i + beginRow  + rowoffset+ cnt, RPTLABEL01, wcf_center);
                ws.addCell(lbl);
                // 合并贷款种类
                ws.mergeCells(beginCol + 1, i + beginRow + cnt + rowoffset - 3 , beginCol + 1, i + beginRow  + rowoffset + cnt);
                // 利率执行水平
                lbl = new Label(beginCol + 2, i + beginRow  + rowoffset + cnt, "X>="+PropertyManager.getProperty("RATE_CODE_85"), wcf_center);
                ws.addCell(lbl);
                // 贷款发放额
                nLbl = new Number(beginCol + 3, i + beginRow + rowoffset + cnt, rs.getDouble("amt14"), wcf_number);
                ws.addCell(nLbl);
                // 计算总额
                totalAmt += rs.getDouble("amt14");

                rowoffset++;
                //---------------------------第5行-------------------------------
                ws.setRowView(i + beginRow  + rowoffset + cnt, rowHeight, false);
                // 机构名称
                lbl = new Label(beginCol, i + beginRow  + rowoffset+ cnt, bankName, wcf_center);
                ws.addCell(lbl);
                // 贷款种类
                lbl = new Label(beginCol + 1, i + beginRow + rowoffset + cnt, RPTLABEL02, wcf_center);
                ws.addCell(lbl);
                // 利率执行水平
                lbl = new Label(beginCol + 2, i + beginRow  + rowoffset+ cnt, "X<"+PropertyManager.getProperty("RATE_CODE_12"), wcf_center);
                ws.addCell(lbl);
                // 贷款发放额
                nLbl = new Number(beginCol + 3, i + beginRow  + rowoffset + cnt, rs.getDouble("amt21"), wcf_number);
                ws.addCell(nLbl);
                // 计算总额
                totalAmt += rs.getDouble("amt21");

                rowoffset++;
                //---------------------------第6行-------------------------------
                ws.setRowView(i + beginRow  + rowoffset + cnt, rowHeight, false);
                // 机构名称
                lbl = new Label(beginCol, i + beginRow  + rowoffset + cnt, bankName, wcf_center);
                ws.addCell(lbl);
                // 贷款种类
                lbl = new Label(beginCol + 1, i + beginRow  + rowoffset + cnt, RPTLABEL02, wcf_center);
                ws.addCell(lbl);
                // 合并贷款种类
                ws.mergeCells(beginCol + 1, i + beginRow  + rowoffset + cnt -1 , beginCol + 1, i + beginRow  + rowoffset + cnt);
                // 利率执行水平
                lbl = new Label(beginCol + 2, i + beginRow  + rowoffset + cnt, "X>="+PropertyManager.getProperty("RATE_CODE_12"), wcf_center);
                ws.addCell(lbl);
                // 贷款发放额
                nLbl = new Number(beginCol + 3, i + beginRow  + rowoffset + cnt, rs.getDouble("amt22"), wcf_number);
                ws.addCell(nLbl);
                // 计算总额
                totalAmt += rs.getDouble("amt22");

                rowoffset++;
                //---------------------------第7行-------------------------------
                ws.setRowView(i + beginRow  + rowoffset + cnt, rowHeight, false);
                // 机构名称
                lbl = new Label(beginCol, i + beginRow  + rowoffset + cnt, bankName, wcf_center);
                ws.addCell(lbl);
                // 贷款种类
                lbl = new Label(beginCol + 1, i + beginRow  + rowoffset + cnt, RPTLABEL03, wcf_center);
                ws.addCell(lbl);
                // 利率执行水平
                lbl = new Label(beginCol + 2, i + beginRow + rowoffset + cnt, "X<"+PropertyManager.getProperty("RATE_CODE_10"), wcf_center);
                ws.addCell(lbl);
                // 贷款发放额
                nLbl = new Number(beginCol + 3, i + beginRow  + rowoffset + cnt, rs.getDouble("amt31"), wcf_number);
                ws.addCell(nLbl);
                // 计算总额
                totalAmt += rs.getDouble("amt31");

                rowoffset++;
                //---------------------------第8行-------------------------------
                ws.setRowView(i + beginRow  + rowoffset + cnt, rowHeight, false);
                // 机构名称
                lbl = new Label(beginCol, i + beginRow  + rowoffset + cnt, bankName, wcf_center);
                ws.addCell(lbl);
                // 贷款种类
                lbl = new Label(beginCol + 1, i + beginRow  + rowoffset + cnt, RPTLABEL03, wcf_center);
                ws.addCell(lbl);
                // 利率执行水平
                lbl = new Label(beginCol + 2, i + beginRow  + rowoffset + cnt, PropertyManager.getProperty("RATE_CODE_10")+"<=X<"+PropertyManager.getProperty("RATE_CODE_11"), wcf_center);
                ws.addCell(lbl);
                // 贷款发放额
                nLbl = new Number(beginCol + 3, i + beginRow  + rowoffset + cnt, rs.getDouble("amt32"), wcf_number);
                ws.addCell(nLbl);
                // 计算总额
                totalAmt += rs.getDouble("amt32");

                rowoffset++;
              //---------------------------第9行-------------------------------
                ws.setRowView(i + beginRow  + rowoffset + cnt, rowHeight, false);
                // 机构名称
                lbl = new Label(beginCol, i + beginRow  + rowoffset + cnt, bankName, wcf_center);
                ws.addCell(lbl);
                // 贷款种类
                lbl = new Label(beginCol + 1, i + beginRow  + rowoffset + cnt, RPTLABEL03, wcf_center);
                ws.addCell(lbl);
                // 利率执行水平
                lbl = new Label(beginCol + 2, i + beginRow  + rowoffset + cnt, PropertyManager.getProperty("RATE_CODE_11")+"<=X<"+PropertyManager.getProperty("RATE_CODE_12"), wcf_center);
                ws.addCell(lbl);
                // 贷款发放额
                nLbl = new Number(beginCol + 3, i + beginRow  + rowoffset + cnt, rs.getDouble("amt33"), wcf_number);
                ws.addCell(nLbl);
                // 计算总额
                totalAmt += rs.getDouble("amt33");

                rowoffset++;
                //---------------------------第10行-------------------------------
                ws.setRowView(i + beginRow  + rowoffset + cnt, rowHeight, false);
                // 机构名称
                lbl = new Label(beginCol, i + beginRow  + rowoffset + cnt, bankName, wcf_center);
                ws.addCell(lbl);
                // 合并经办行
                ws.mergeCells(beginCol, i + beginRow + cnt, beginCol, i + beginRow  + rowoffset + cnt);
                // 贷款种类
                lbl = new Label(beginCol + 1, i + beginRow  + rowoffset + cnt, RPTLABEL03, wcf_center);
                ws.addCell(lbl);
                // 合并贷款种类
                ws.mergeCells(beginCol + 1, i + beginRow  + rowoffset + cnt -3 , beginCol + 1, i + beginRow  + rowoffset + cnt);
                // 利率执行水平
                lbl = new Label(beginCol + 2, i + beginRow  + rowoffset + cnt, "X>="+PropertyManager.getProperty("RATE_CODE_12"), wcf_center);
                ws.addCell(lbl);
                // 贷款发放额
                nLbl = new Number(beginCol + 3, i + beginRow  + rowoffset + cnt, rs.getDouble("amt34"), wcf_number);
                ws.addCell(nLbl);
                // 计算总额
                totalAmt += rs.getDouble("amt34");
                // 行计数器加1
                i++;
            }

            // 释放数据库连接
            // ConnectionManager.getInstance().release();
            //-----------------------------------输出总额-------------------------------------------------------------------------
            // ----居中显示--
            // 粗体字设置
            WritableCellFormat wcf_bold_center = new WritableCellFormat(new WritableFont(WritableFont.COURIER, 11, WritableFont.BOLD, false));
            wcf_bold_center.setBorder(Border.ALL, BorderLineStyle.THIN);
            wcf_bold_center.setAlignment(Alignment.CENTRE);
            wcf_bold_center.setVerticalAlignment(VerticalAlignment.CENTRE);
            // ----居右显示--
            WritableCellFormat wcf_bold_right = new WritableCellFormat(new WritableFont(WritableFont.COURIER, 11, WritableFont.BOLD, false));
            wcf_bold_right.setBorder(Border.ALL, BorderLineStyle.THIN);
            wcf_bold_right.setAlignment(Alignment.RIGHT);
            wcf_bold_right.setVerticalAlignment(VerticalAlignment.CENTRE);

            // 设置行高
            ws.setRowView(i + beginRow + 9 + cnt, rowHeight, false);
            Label lbl = new Label(beginCol, i + beginRow + 9 + cnt, "合  计", wcf_bold_center);
            ws.addCell(lbl);
            lbl = new Label(beginCol + 1, i + beginRow + 9 + cnt, "", wcf_bold_center);
            ws.addCell(lbl);
            lbl = new Label(beginCol + 2, i + beginRow + 9 + cnt, "", wcf_bold_center);
            ws.addCell(lbl);

            wcf_number.setFont(new WritableFont(WritableFont.COURIER, 11, WritableFont.BOLD, false));
            Number nLbl = new Number(beginCol + 3, i + beginRow + 9 + cnt, totalAmt, wcf_number);
            ws.addCell(nLbl);
            //--------------------------------关闭excel操作------------------------------------------------------------------------
            // 关闭excel
            wwb.write();
            wwb.close();
            rw.close();

            //--------------------------------输出报表-----------------------------------------------------------------------------
            out.flush();
            out.close();
        } while (false);
    } catch (Exception e) {
        e.printStackTrace();
    }finally {
        // 释放数据库连接
        ConnectionManager.getInstance().release();
    }
%>
