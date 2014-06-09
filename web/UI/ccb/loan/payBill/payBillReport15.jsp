<!--
/*********************************************************************
* 功能描述: 买单工资统计项目15 表六
* 作 者:
* 开发日期: 2010/10/22
* 修 改 人:
* 修改日期:
* 版 权:
***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK" %>
<%@page import="com.ccb.util.CcbLoanConst" %>
<%@page import="jxl.Workbook" %>
<%@page import="jxl.WorkbookSettings" %>
<%@page import="jxl.format.Alignment" %>
<%@page import="jxl.format.Border" %>
<%@page import="jxl.format.BorderLineStyle" %>
<%@page import="jxl.format.VerticalAlignment" %>
<%@page import="jxl.write.*" %>
<%@page import="jxl.write.Number" %>
<%@page import="pub.platform.advance.utils.PropertyManager" %>
<%@page import="pub.platform.db.ConnectionManager" %>
<%@page import="pub.platform.db.DatabaseConnection" %>
<%@page import="pub.platform.db.RecordSet" %>
<%@page import="pub.platform.form.config.SystemAttributeNames" %>
<%@page import="pub.platform.security.OperatorManager" %>
<%@page import="java.io.File" %>
<%@page import="java.util.Locale" %>
<%

    OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
    String deptId = omgr.getOperator().getPtDeptBean().getDeptid();

    final String RPTLABEL01 = "个人住房贷款(仅含个人住房贷款、个人再交易住房贷款)";
    final String RPTLABEL02 = "个人助业贷款";
    final String RPTLABEL03 = "个人类其他贷款（含个人商用房、个人最高额、个人消费额度、个人汽车、个人质押贷款等）";

//采用do while结构便于在主流程中监测错误发生后退出主程序；
    try {
        do {
            // 输出报表
            response.reset();
            response.setContentType("application/vnd.ms-excel");
//            response.addHeader("Content-Disposition", "attachment; filename=" + CcbLoanConst.RPT_PAY_BILL_12 + ".xls");
            response.addHeader("Content-Disposition", "attachment; filename=" + "payBill15.xls");
            // ----------------------------根据模板创建输出流----------------------------------------------------------------
            //得到报表模板
            String rptModelPath = PropertyManager.getProperty("REPORT_ROOTPATH");
            String rptName = rptModelPath + "payBill15.xls";
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
            // 得到可写的workbook
            WritableWorkbook wwb = Workbook.createWorkbook(response.getOutputStream(), rw, setting);
            // 得到第一个工作表
            WritableSheet ws = wwb.getSheet(0);

            // ----------------从数据库读取数据写入excel中--------------------------------------------------------------------------------
            // 查询字符串
            String whereStr = " where 1=1  and t.LOANSTATE is not null and t.LOANSTATE <> '0' and t.custmgr_id is not null  ";
            if (!request.getParameter("CUST_OPEN_DT").trim().equals("")) {
                whereStr += " and t.CUST_OPEN_DT >='" + request.getParameter("CUST_OPEN_DT").trim() + "'";
            }
            if (!request.getParameter("CUST_OPEN_DT2").trim().equals("")) {
                whereStr += " and t.CUST_OPEN_DT <='" + request.getParameter("CUST_OPEN_DT2").trim() + "'";
            }

            String loantype1 = "t.ln_typ  in ('011','013')";
            String loantype2 = "t.ln_typ  in ('033','433')";
            String loantype3 = "t.ln_typ  in ('012','014','015','016','020','022','026','028','029','030','031','113','114','115','122')";

            DatabaseConnection conn = ConnectionManager.getInstance().get();
            RecordSet rs = conn.executeQuery("select deptname from ptdept where deptid='" + deptId + "'");
            String deptName = "合计";
            while (rs.next()) {
                deptName = rs.getString(0);
            }

            // 统计查询语句
            String sql = ""
                    + " select bankid,bankname,custmgr_name,amt1,amt2,amt3,round(rate1/amt1,2) as rate1,round(rate2/amt2,2) as rate2,round(rate3/amt3,2) as rate3 , " +
                    " rate1 as totalrate1, rate2 as totalrate2, rate3 as totalrate3 from ("
                    + " select t.bankid,"
                    + " (select deptname from ptdept where deptid=t.bankid)as bankname,"
                    + " (select opername from ptoper where operid=t.custmgr_id)as custmgr_name,"
                    + " sum(case"
                    + "       when (" + loantype1 + ") then"
                    + "        rt_orig_loan_amt"
                    + "       else"
                    + "        null"
                    + "     end) as amt1,"
                    + " sum(case"
                    + "       when (" + loantype1 + " ) then"
                    + "        RATECALEVALUE*rt_orig_loan_amt"
                    + "       else"
                    + "        null"
                    + "     end) as rate1,"
                    + " sum(case"
                    + "       when (" + loantype2 + ") then"
                    + "        rt_orig_loan_amt"
                    + "       else"
                    + "        null"
                    + "     end) as amt2,"
                    + " sum(case"
                    + "       when (" + loantype2 + " ) then"
                    + "        RATECALEVALUE*rt_orig_loan_amt"
                    + "       else"
                    + "        null"
                    + "     end) as rate2,"
                    + " sum(case"
                    + "       when (" + loantype3 + ") then"
                    + "        rt_orig_loan_amt"
                    + "       else"
                    + "        null"
                    + "     end) as amt3,"
                    + "  sum(case"
                    + "       when (" + loantype3 + ") then"
                    + "        RATECALEVALUE*rt_orig_loan_amt"
                    + "       else"
                    + "        null"
                    + "     end) as rate3  "
                    + " from ln_loanapply t"
                    //+" where t.custmgr_id ='xujian.qd'"
                    + whereStr
                    + " and t.bankid in(select deptid from ptdept start with deptid='" + omgr.getOperator().getDeptid() + "' connect by prior deptid=parentdeptid) "
                    + " group by bankid,custmgr_id"
                    + " order by bankid,custmgr_id"
                    + " ) ";

            rs = conn.executeQuery(sql);
            // 行计数器
            int i = 0;
            // 步长（每条记录输出二行）
            int step = 3;
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

            // ----数值样式 居右对齐---
            NumberFormat nf = new NumberFormat("#,###,###,##0.00");
            WritableCellFormat wcf_right = new WritableCellFormat(nf);
            wcf_right.setFont(new WritableFont(WritableFont.COURIER, 11, WritableFont.NO_BOLD, false));

            // 边框样式
            wcf_right.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
            // 折行
            wcf_right.setWrap(false);
            // 垂直对齐
            wcf_right.setVerticalAlignment(VerticalAlignment.CENTRE);
            // 水平对齐
            wcf_right.setAlignment(Alignment.RIGHT);
            // 行高
            int rowHeight = 1000;
            // 总金额
            double totalAmt = 0;
            double totalAmt_1 = 0;
            double totalAmt_2 = 0;
            double totalAmt_3 = 0;
            // 总浮动比例
            double totalRate = 0;
            double totalRate_1 = 0;
            double totalRate_2 = 0;
            double totalRate_3 = 0;
            // 开始行
            int beginRow = 4;
            // 开始列
            int beginCol = 1;
            // 输出记录行数，计算贷款浮动比例之用
            int rowNum = 0;
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
                rowNum++;
                cnt = i * step;
                if (i > 0) {
                    cnt = cnt - i;
                }
                // 经办行名称
                String bankName = rs.getString("bankname");
                // 客户经理名称
                String custmgr_name = rs.getString("custmgr_name");
                // 从第4行开始写数据
                //--------------------------第一行--------------------------------
                ws.setRowView(i + beginRow + cnt, rowHeight, false);
                // 机构名称
                Label lbl = new Label(beginCol, i + beginRow + cnt, bankName, wcf_center);
                ws.addCell(lbl);
                //客户经理名称
                lbl = new Label(beginCol + 1, i + beginRow + cnt, custmgr_name, wcf_center);
                ws.addCell(lbl);
                // 贷款种类
                lbl = new Label(beginCol + 2, i + beginRow + cnt, RPTLABEL01, wcf_center);
                ws.addCell(lbl);
                // 贷款浮动比例
                Number nLbl = new Number(beginCol + 3, i + beginRow + cnt, rs.getDouble("rate1"), wcf_right);
                ws.addCell(nLbl);
                // 贷款发放额
                nLbl = new Number(beginCol + 4, i + beginRow + cnt, rs.getDouble("amt1"), wcf_right);
                ws.addCell(nLbl);
                // 计算总额
                totalAmt += rs.getDouble("amt1");
                totalAmt_1 += rs.getDouble("amt1");
                // 计算总浮动比例
                totalRate += rs.getDouble("rate1");
                totalRate_1 += rs.getDouble("rate1");
                //---------------------------第二行-------------------------------
                ws.setRowView(i + beginRow + 1 + cnt, rowHeight, false);
                // 机构名称
                lbl = new Label(beginCol, i + beginRow + 1 + cnt, bankName, wcf_center);
                ws.addCell(lbl);
                // 客户经理名称
                lbl = new Label(beginCol + 1, i + beginRow + 1 + cnt, custmgr_name, wcf_center);
                ws.addCell(lbl);

                // 贷款种类
                lbl = new Label(beginCol + 2, i + beginRow + 1 + cnt, RPTLABEL02, wcf_center);
                ws.addCell(lbl);
                // 贷款浮动比例
                nLbl = new Number(beginCol + 3, i + beginRow + 1 + cnt, rs.getDouble("rate2"), wcf_right);
                ws.addCell(nLbl);
                // 贷款发放额
                nLbl = new Number(beginCol + 4, i + beginRow + 1 + cnt, rs.getDouble("amt2"), wcf_right);
                ws.addCell(nLbl);
                // 计算总额
                totalAmt += rs.getDouble("amt2");
                totalAmt_3 += rs.getDouble("amt2");
                // 计算总浮动比例
                totalRate += rs.getDouble("rate2");
                totalRate_3 += rs.getDouble("rate2");
                //---------------------------第三行-------------------------------
                ws.setRowView(i + beginRow + 2 + cnt, rowHeight, false);
                // 机构名称
                lbl = new Label(beginCol, i + beginRow + 2 + cnt, bankName, wcf_center);
                ws.addCell(lbl);
                // 机构合并
                ws.mergeCells(beginCol, i + beginRow + cnt, beginCol, i + beginRow + 2 + cnt);
                // 客户经理名称
                lbl = new Label(beginCol + 1, i + beginRow + 2 + cnt, custmgr_name, wcf_center);
                ws.addCell(lbl);
                // 客户经理名称合并
                ws.mergeCells(beginCol + 1, i + beginRow + cnt, beginCol + 1, i + beginRow + 2 + cnt);

                // 贷款种类
                lbl = new Label(beginCol + 2, i + beginRow + 2 + cnt, RPTLABEL03, wcf_center);
                ws.addCell(lbl);
                // 贷款浮动比例
                nLbl = new Number(beginCol + 3, i + beginRow + 2 + cnt, rs.getDouble("rate3"), wcf_right);
                ws.addCell(nLbl);
                // 贷款发放额
                nLbl = new Number(beginCol + 4, i + beginRow + 2 + cnt, rs.getDouble("amt3"), wcf_right);
                ws.addCell(nLbl);
                // 计算总额
                totalAmt += rs.getDouble("amt3");
                totalAmt_3 += rs.getDouble("amt3");
                // 计算总浮动比例
                totalRate += rs.getDouble("rate3");
                totalRate_3 += rs.getDouble("rate3");
                // 行计数器加1
                i++;
            }

            /*
            20100726  zhanrui  增加平均数计算
            */
            //-----------------------------------输出总计值-------------------------------------------------------------------------

            sql = "select sum(amt1) as amt1 ,sum(amt2) as amt2, sum(amt3) as amt3, round(sum(totalrate1) / sum(amt1), 2) as rate1, round(sum(totalrate2) / sum(amt2), 2) as rate2, round(sum(totalrate3) / sum(amt3), 2) as rate3  from (" + sql + ")";

            rs = conn.executeQuery(sql);
            while (rs.next()) {

                // ----居中显示--
                // 粗体字设置
                WritableCellFormat wcf_bold_center = new WritableCellFormat(new WritableFont(WritableFont.COURIER, 11, WritableFont.BOLD, false));
                wcf_bold_center.setBorder(Border.ALL, BorderLineStyle.THIN);
                wcf_bold_center.setAlignment(Alignment.CENTRE);
                //wcf_bold_center.setBackground(jxl.format.Colour.GRAY_25);
                wcf_bold_center.setVerticalAlignment(VerticalAlignment.CENTRE);
                wcf_bold_center.setWrap(true);  //  是否换行

                // ----居右显示--
                WritableCellFormat wcf_bold_right = new WritableCellFormat(nf);
                //WritableCellFormat wcf_bold_right = new WritableCellFormat(new WritableFont(WritableFont.COURIER,11,WritableFont.BOLD,false));
                wcf_bold_right.setFont(new WritableFont(WritableFont.COURIER, 11, WritableFont.BOLD, false));
                wcf_bold_right.setBorder(Border.ALL, BorderLineStyle.THIN);
                wcf_bold_right.setAlignment(Alignment.RIGHT);
                //wcf_bold_right.setBackground(jxl.format.Colour.GRAY_25);
                wcf_bold_right.setVerticalAlignment(VerticalAlignment.CENTRE);

                cnt = i * step;
                if (i > 0) {
                    cnt = cnt - i;
                }
                // 经办行名称
                String bankName = deptName;
                // 从第4行开始写数据
                //--------------------------第一行--------------------------------
                ws.setRowView(i + beginRow + cnt, rowHeight, false);
                // 机构名称
                Label lbl = new Label(beginCol, i + beginRow + cnt, bankName, wcf_bold_center);
                ws.addCell(lbl);
                // 合计
                lbl = new Label(beginCol+1, i + beginRow + cnt, "合计", wcf_bold_center);
                ws.addCell(lbl);
                // 贷款种类
                lbl = new Label(beginCol + 2, i + beginRow + cnt, RPTLABEL01, wcf_bold_center);
                ws.addCell(lbl);
                // 贷款浮动比例
                Number nLbl = new Number(beginCol + 3, i + beginRow + cnt, rs.getDouble("rate1"), wcf_bold_right);
                //lbl = new Label(beginCol + 2, i + beginRow + cnt, "平均" + (totalRate_1 / rowNum) , wcf_bold_right);
                ws.addCell(nLbl);
                // 贷款发放额
                nLbl = new Number(beginCol + 4, i + beginRow + cnt, rs.getDouble("amt1"), wcf_bold_right);
                ws.addCell(nLbl);
                //---------------------------第二行-------------------------------
                ws.setRowView(i + beginRow + 1 + cnt, rowHeight, false);
                // 机构名称
                lbl = new Label(beginCol, i + beginRow + 1 + cnt, bankName, wcf_bold_center);
                ws.addCell(lbl);
                // 合计
                lbl = new Label(beginCol+1, i + beginRow + cnt, "合计", wcf_bold_center);
                ws.addCell(lbl);
                // 贷款种类
                lbl = new Label(beginCol + 2, i + beginRow + 1 + cnt, RPTLABEL02, wcf_bold_center);
                ws.addCell(lbl);
                // 贷款浮动比例
                nLbl = new Number(beginCol + 3, i + beginRow + 1 + cnt, rs.getDouble("rate2"), wcf_bold_right);
                ws.addCell(nLbl);
                // 贷款发放额
                nLbl = new Number(beginCol + 4, i + beginRow + 1 + cnt, rs.getDouble("amt2"), wcf_bold_right);
                ws.addCell(nLbl);
                //---------------------------第三行-------------------------------
                ws.setRowView(i + beginRow + 2 + cnt, rowHeight, false);
                // 机构名称
                lbl = new Label(beginCol, i + beginRow + 2 + cnt, bankName, wcf_bold_center);
                ws.addCell(lbl);
                // 机构合并
                ws.mergeCells(beginCol, i + beginRow + cnt, beginCol, i + beginRow + 2 + cnt);
                // 合计
                lbl = new Label(beginCol+1, i + beginRow + cnt, "合计", wcf_bold_center);
                ws.addCell(lbl);
                // 合并
                ws.mergeCells(beginCol + 1, i + beginRow + cnt, beginCol + 1, i + beginRow + 2 + cnt);
                // 贷款种类
                lbl = new Label(beginCol + 2, i + beginRow + 2 + cnt, RPTLABEL03, wcf_bold_center);
                ws.addCell(lbl);
                // 贷款浮动比例
                nLbl = new Number(beginCol + 3, i + beginRow + 2 + cnt, rs.getDouble("rate3"), wcf_bold_right);
                ws.addCell(nLbl);
                // 贷款发放额
                nLbl = new Number(beginCol + 4, i + beginRow + 2 + cnt, rs.getDouble("amt3"), wcf_bold_right);
                ws.addCell(nLbl);
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