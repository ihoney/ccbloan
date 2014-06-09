<!--
/*********************************************************************
* 功能描述: 买单工资查询统计17 (表8)  
  20120524 zhanrui  按客户经理查询
* 作 者:
* 开发日期: 2011/03/06
* 修 改 人:
* 修改日期:
* 版 权:
***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK" %>
<%@page import="jxl.Workbook" %>
<%@page import="jxl.WorkbookSettings" %>
<%@page import="jxl.format.Alignment" %>
<%@page import="jxl.format.Border" %>
<%@page import="jxl.format.BorderLineStyle" %>
<%@page import="jxl.format.VerticalAlignment" %>
<%@page import="jxl.write.*" %>
<%@page import="jxl.write.Number" %>
<%@page import="org.apache.commons.logging.Log" %>
<%@page import="org.apache.commons.logging.LogFactory" %>
<%@page import="pub.platform.advance.utils.PropertyManager" %>
<%@page import="pub.platform.db.ConnectionManager" %>
<%@page import="pub.platform.db.DatabaseConnection" %>
<%@page import="pub.platform.db.RecordSet" %>
<%@page import="pub.platform.form.config.SystemAttributeNames" %>
<%@page import="pub.platform.security.OperatorManager" %>
<%@page import="java.io.File" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Locale" %>
<%
    Log logger = LogFactory.getLog("payBillReport17.jsp");

    OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
    String deptId = omgr.getOperator().getPtDeptBean().getDeptid();

    final String RPTLABEL01 = "个人住房贷款(仅含个人住房贷款、个人再交易住房贷款)";
    final String RPTLABEL02 = "个人助业贷款";
    final String RPTLABEL03 = "个人类其他贷款（含个人商用房、个人最高额、个人消费额度、个人汽车、个人质押贷款等）";

    //输入参数处理
    String startdate = request.getParameter("CUST_OPEN_DT").trim();
    String enddate = request.getParameter("CUST_OPEN_DT2").trim();

    //利率权值
    BigDecimal weight = new BigDecimal(5);
    //每万元买单价格基准
    BigDecimal baseprice1 =  new BigDecimal(0);
    BigDecimal baseprice2 = new BigDecimal(0);
    BigDecimal baseprice3 = new BigDecimal(0);

    try {
        do {
            // 输出报表
            response.reset();
            response.setContentType("application/vnd.ms-excel");
            response.addHeader("Content-Disposition", "attachment; filename=" + "payBill17_" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + ".xls");
            // ----------------------------根据模板创建输出流----------------------------------------------------------------
            //得到报表模板
            String rptModelPath = PropertyManager.getProperty("REPORT_ROOTPATH");
            String rptName = rptModelPath + "payBill17.xls";
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
            String whereStr = " where 1=1 and t.loanid = a.loanid  and t.LOANSTATE is not null and t.LOANSTATE <> '0' and a.custmgr_id is not null  ";
            if (!request.getParameter("CUST_OPEN_DT").trim().equals("")) {
                whereStr += " and t.CUST_OPEN_DT >='" + request.getParameter("CUST_OPEN_DT").trim() + "'";
            }
            if (!request.getParameter("CUST_OPEN_DT2").trim().equals("")) {
                whereStr += " and t.CUST_OPEN_DT <='" + request.getParameter("CUST_OPEN_DT2").trim() + "'";
            }

            String loantype1 = "t.ln_typ  in ('011','013')";
            String loantype2 = "t.ln_typ  in ('033','433')";
            String loantype3 = "t.ln_typ  in ('012','014','015','016','020','022','026','028','029','030','031','113','114','115','122')";

            //汇总平均值
            BigDecimal allOrgTotalAmt1 = new BigDecimal("0.00");
            BigDecimal allOrgTotalAmt2 = new BigDecimal("0.00");
            BigDecimal allOrgTotalAmt3 = new BigDecimal("0.00");
            BigDecimal averageRate1 = new BigDecimal("0.00");
            BigDecimal averageRate2 = new BigDecimal("0.00");
            BigDecimal averageRate3 = new BigDecimal("0.00");

            DatabaseConnection conn = ConnectionManager.getInstance().get();

            RecordSet rs = conn.executeQuery("select deptname from ptdept where deptid='" + deptId + "'");
            String deptName = "合计";
            while (rs.next()) {
                deptName = rs.getString(0);
            }
            rs.close();

            rs = conn.executeQuery("select enuitemexpand as name,to_number(enuitemvalue) as value from ptenudetail where enutype = 'PAYBILLRPTPARAM' ");
            while (rs.next()) {
                String name = rs.getString("name");
                BigDecimal value = BigDecimal.valueOf(rs.getDouble("value"));
                if ("weight".equals(name)) {
                    weight = value;
                }else if ("baseprice1".equals(name)) {
                    baseprice1 = value;
                }else if ("baseprice2".equals(name)) {
                    baseprice2 = value;
                }else if ("baseprice3".equals(name)) {
                    baseprice3 = value;
                }
            }
            rs.close();

            // 统计查询语句
            String sql = ""
                    + " select bankid,bankname,custmgr_name,amt1,amt2,amt3,round(rate1/amt1,2) as rate1,round(rate2/amt2,2) as rate2,round(rate3/amt3,2) as rate3 , " +
                    " rate1 as totalrate1, rate2 as totalrate2, rate3 as totalrate3 from ("
                    + " select t.bankid,"
                    + " (select deptname from ptdept where deptid=t.bankid)as bankname,"
                    + " (select opername from ptoper where operid = a.custmgr_id) as custmgr_name,"
                    //+ " (case when (select prommgr_name from ln_prommgrinfo where prommgr_id = t.custmgr_id) is null then" +
                    //"               (select opername from ptoper where operid=t.custmgr_id) else" +
                    //"                (select prommgr_name from ln_prommgrinfo where prommgr_id = t.custmgr_id) end) as custmgr_name,"
                    + " sum(case"
                    + "       when (" + loantype1 + ") then"
                    + "        t.rt_orig_loan_amt"
                    + "       else"
                    + "        null"
                    + "     end) as amt1,"
                    + " sum(case"
                    + "       when (" + loantype1 + " ) then"
                    + "        RATECALEVALUE*t.rt_orig_loan_amt"
                    + "       else"
                    + "        null"
                    + "     end) as rate1,"
                    + " sum(case"
                    + "       when (" + loantype2 + ") then"
                    + "        t.rt_orig_loan_amt"
                    + "       else"
                    + "        null"
                    + "     end) as amt2,"
                    + " sum(case"
                    + "       when (" + loantype2 + " ) then"
                    + "        RATECALEVALUE*t.rt_orig_loan_amt"
                    + "       else"
                    + "        null"
                    + "     end) as rate2,"
                    + " sum(case"
                    + "       when (" + loantype3 + ") then"
                    + "        t.rt_orig_loan_amt"
                    + "       else"
                    + "        null"
                    + "     end) as amt3,"
                    + "  sum(case"
                    + "       when (" + loantype3 + ") then"
                    + "        RATECALEVALUE*t.rt_orig_loan_amt"
                    + "       else"
                    + "        null"
                    + "     end) as rate3  "
                    + " from ln_loanapply t, ln_promotioncustomers a"
                    + whereStr
                    + " and t.bankid in(select deptid from ptdept start with deptid='" + omgr.getOperator().getDeptid() + "' connect by prior deptid=parentdeptid) "
                    + " group by t.bankid,a.custmgr_id"
                    + " order by t.bankid,a.custmgr_id"
                    + " ) ";

            String sumsql = "select sum(amt1) as amt1 ,sum(amt2) as amt2, sum(amt3) as amt3, round(sum(totalrate1) / sum(amt1), 2) as rate1, round(sum(totalrate2) / sum(amt2), 2) as rate2, round(sum(totalrate3) / sum(amt3), 2) as rate3  from (" + sql + ")";
            logger.info("BillRpt_17:" + sumsql);

            rs = conn.executeQuery(sumsql);
            while (rs.next()) {
                allOrgTotalAmt1 = BigDecimal.valueOf(rs.getDouble("amt1"));
                allOrgTotalAmt2 = BigDecimal.valueOf(rs.getDouble("amt2"));
                allOrgTotalAmt3 = BigDecimal.valueOf(rs.getDouble("amt3"));
                averageRate1 = BigDecimal.valueOf(rs.getDouble("rate1"));
                averageRate2 = BigDecimal.valueOf(rs.getDouble("rate2"));
                averageRate3 = BigDecimal.valueOf(rs.getDouble("rate3"));
            }
            rs.close();

            //开始输出表格
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
            ws.setRowView(2, 600, false);

            jxl.format.CellFormat fmtPt = ws.getCell(1, 2).getCellFormat();

            startdate = startdate.substring(0, 4) + "年" + Integer.parseInt(startdate.substring(5, 7)) + "月" + Integer.parseInt(startdate.substring(8, 10)) + "日";
            enddate = enddate.substring(0, 4) + "年" + Integer.parseInt(enddate.substring(5, 7)) + "月" + Integer.parseInt(enddate.substring(8, 10)) + "日";
            Label lbl_t = new Label(1, 2, startdate + "-" + enddate, fmtPt);
            ws.addCell(lbl_t);

            //执行买单价格（元/万元）
            BigDecimal execAmtStandard;
            //贷款发放额（万元）
            BigDecimal loanAmtWan;
            //绩效工资
            BigDecimal performPay;
            //机构绩效工资小计
            BigDecimal singleOrgPerformPaymPay = new BigDecimal(0);
            //各机构绩效工资总计
            BigDecimal allOrgPerformPaymPay = new BigDecimal(0);

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
                int coloffset = 0;
                ws.setRowView(i + beginRow + cnt, rowHeight, false);
                // 机构名称
                Label lbl = new Label(beginCol, i + beginRow + cnt, bankName, wcf_center);
                ws.addCell(lbl);
                //客户经理名称
                lbl = new Label(beginCol + ++coloffset, i + beginRow + cnt, custmgr_name, wcf_center);
                ws.addCell(lbl);
                // 贷款种类
                lbl = new Label(beginCol + ++coloffset, i + beginRow + cnt, RPTLABEL01, wcf_center);
                ws.addCell(lbl);
                // 贷款浮动比例
                Number nLbl = new Number(beginCol + ++coloffset, i + beginRow + cnt, rs.getDouble("rate1"), wcf_right);
                ws.addCell(nLbl);
                // 贷款发放额
                nLbl = new Number(beginCol + ++coloffset, i + beginRow + cnt, rs.getDouble("amt1"), wcf_right);
                ws.addCell(nLbl);
                //每万元买单价格（基准）
                nLbl = new Number(beginCol + ++coloffset, i + beginRow + cnt, baseprice1.doubleValue(), wcf_right);
                ws.addCell(nLbl);
                //执行买单价格（元/万元）
                execAmtStandard = baseprice1.multiply(getRateFormula(BigDecimal.valueOf(rs.getDouble("rate1")), averageRate1, weight));
                nLbl = new Number(beginCol + ++coloffset, i + beginRow + cnt, execAmtStandard.doubleValue(), wcf_right);
                ws.addCell(nLbl);
                //贷款发放额（万元）
                loanAmtWan = BigDecimal.valueOf(rs.getDouble("amt1")).divide(new BigDecimal(10000));
                //nLbl = new Number(beginCol + 6, i + beginRow + cnt, loanAmtWan.doubleValue(), wcf_right);
                //ws.addCell(nLbl);
                //绩效工资
                performPay = loanAmtWan.multiply(execAmtStandard);
                nLbl = new Number(beginCol + ++coloffset, i + beginRow + cnt, performPay.doubleValue(), wcf_right);
                ws.addCell(nLbl);
                //绩效工资合计
                singleOrgPerformPaymPay = new BigDecimal(0);
                singleOrgPerformPaymPay = singleOrgPerformPaymPay.add(performPay);

                // 计算总额
                totalAmt += rs.getDouble("amt1");
                totalAmt_1 += rs.getDouble("amt1");
                // 计算总浮动比例
                totalRate += rs.getDouble("rate1");
                totalRate_1 += rs.getDouble("rate1");
                //--------------------------第二行--------------------------------
                coloffset = 0;
                ws.setRowView(i + beginRow + 1 + cnt, rowHeight, false);
                // 机构名称
                lbl = new Label(beginCol, i + beginRow + 1 + cnt, bankName, wcf_center);
                ws.addCell(lbl);
                //客户经理名称
                lbl = new Label(beginCol + ++coloffset, i + beginRow + cnt, custmgr_name, wcf_center);
                ws.addCell(lbl);
                // 贷款种类
                lbl = new Label(beginCol + ++coloffset, i + beginRow + 1 + cnt, RPTLABEL02, wcf_center);
                ws.addCell(lbl);
                // 贷款浮动比例
                nLbl = new Number(beginCol + ++coloffset, i + beginRow + 1 + cnt, rs.getDouble("rate2"), wcf_right);
                ws.addCell(nLbl);
                // 贷款发放额
                nLbl = new Number(beginCol + ++coloffset, i + beginRow + 1 + cnt, rs.getDouble("amt2"), wcf_right);
                ws.addCell(nLbl);

                //每万元买单价格（基准）
                nLbl = new Number(beginCol + ++coloffset, i + beginRow + 1 + cnt, baseprice2.doubleValue(), wcf_right);
                ws.addCell(nLbl);
                //执行买单价格（元/万元）
                execAmtStandard = baseprice2.multiply(getRateFormula(BigDecimal.valueOf(rs.getDouble("rate2")), averageRate2, weight));
                nLbl = new Number(beginCol + ++coloffset, i + beginRow + 1 + cnt, execAmtStandard.doubleValue(), wcf_right);
                ws.addCell(nLbl);
                //贷款发放额（万元）
                loanAmtWan = BigDecimal.valueOf(rs.getDouble("amt2")).divide(new BigDecimal(10000));
                //nLbl = new Number(beginCol + 6, i + beginRow + 1 + cnt, loanAmtWan.doubleValue(), wcf_right);
                //ws.addCell(nLbl);
                //绩效工资
                performPay = loanAmtWan.multiply(execAmtStandard);
                nLbl = new Number(beginCol + ++coloffset, i + beginRow + 1 + cnt, performPay.doubleValue(), wcf_right);
                ws.addCell(nLbl);
                //绩效工资合计
                singleOrgPerformPaymPay = singleOrgPerformPaymPay.add(performPay);

                // 计算总额
                totalAmt += rs.getDouble("amt2");
                totalAmt_2 += rs.getDouble("amt2");
                // 计算总浮动比例
                totalRate += rs.getDouble("rate2");
                totalRate_2 += rs.getDouble("rate2");
                //---------------------------第三行-------------------------------
                coloffset = 0;
                ws.setRowView(i + beginRow + 2 + cnt, rowHeight, false);
                // 机构名称
                lbl = new Label(beginCol, i + beginRow + 2 + cnt, bankName, wcf_center);
                ws.addCell(lbl);
                //客户经理名称
                lbl = new Label(beginCol + ++coloffset, i + beginRow + cnt, custmgr_name, wcf_center);
                ws.addCell(lbl);
                // 客户经理名称合并
                ws.mergeCells(beginCol + coloffset, i + beginRow + cnt, beginCol + coloffset, i + beginRow + 2 + cnt);
                // 贷款种类
                lbl = new Label(beginCol + ++coloffset, i + beginRow + 2 + cnt, RPTLABEL03, wcf_center);
                ws.addCell(lbl);
                // 贷款浮动比例
                nLbl = new Number(beginCol + ++coloffset, i + beginRow + 2 + cnt, rs.getDouble("rate3"), wcf_right);
                ws.addCell(nLbl);
                // 贷款发放额
                nLbl = new Number(beginCol + ++coloffset, i + beginRow + 2 + cnt, rs.getDouble("amt3"), wcf_right);
                ws.addCell(nLbl);

                //每万元买单价格（基准）
                nLbl = new Number(beginCol + ++coloffset, i + beginRow + 2 + cnt, baseprice3.doubleValue(), wcf_right);
                ws.addCell(nLbl);
                //执行买单价格（元/万元）
                execAmtStandard = baseprice3.multiply(getRateFormula(BigDecimal.valueOf(rs.getDouble("rate3")), averageRate3, weight));
                nLbl = new Number(beginCol + ++coloffset, i + beginRow + 2 + cnt, execAmtStandard.doubleValue(), wcf_right);
                ws.addCell(nLbl);
                //贷款发放额（万元）
                loanAmtWan = BigDecimal.valueOf(rs.getDouble("amt3")).divide(new BigDecimal(10000));
                //nLbl = new Number(beginCol + 6, i + beginRow + 2 + cnt, loanAmtWan.doubleValue(), wcf_right);
                //ws.addCell(nLbl);
                //绩效工资
                performPay = loanAmtWan.multiply(execAmtStandard);
                nLbl = new Number(beginCol + ++coloffset, i + beginRow + 2 + cnt, performPay.doubleValue(), wcf_right);
                ws.addCell(nLbl);
                //绩效工资合计
                singleOrgPerformPaymPay = singleOrgPerformPaymPay.add(performPay);
                nLbl = new Number(beginCol + ++coloffset, i + beginRow + cnt, singleOrgPerformPaymPay.doubleValue(), wcf_right);
                ws.addCell(nLbl);
                // 绩效工资合计合并
                ws.mergeCells(beginCol + coloffset, i + beginRow + cnt, beginCol + coloffset, i + beginRow + 2 + cnt);

                allOrgPerformPaymPay = allOrgPerformPaymPay.add(singleOrgPerformPaymPay);

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


            //各机构总计   zhanrui 20110307
            ws.setRowView(i * step + beginRow, rowHeight, false);
            // 机构名称
            Label lbl = new Label(1, i * step + beginRow, "各机构合计", wcf_bold_center);
            ws.addCell(lbl);
            Number nLbl = new Number(beginCol + 8, i * step + beginRow, allOrgPerformPaymPay.doubleValue(), wcf_bold_right);
            ws.addCell(nLbl);


            cnt = i * step;
            cnt++;
            if (i > 0) {
                cnt = cnt - i;
            }
            // 经办行名称
            String bankName = deptName;
            // 从第4行开始写数据
            //--------------------------第一行--------------------------------
            int coloffset = 0;
            ws.setRowView(i + beginRow + cnt, rowHeight, false);
            // 机构名称
            lbl = new Label(beginCol, i + beginRow + cnt, bankName, wcf_bold_center);
            ws.addCell(lbl);
            //合计
            lbl = new Label(beginCol + ++coloffset, i + beginRow + cnt, "合计", wcf_bold_center);
            ws.addCell(lbl);
            // 贷款种类
            lbl = new Label(beginCol + ++coloffset, i + beginRow + cnt, RPTLABEL01, wcf_bold_center);
            ws.addCell(lbl);
            // 贷款浮动比例
            nLbl = new Number(beginCol + ++coloffset, i + beginRow + cnt, averageRate1.doubleValue(), wcf_bold_right);
            //lbl = new Label(beginCol + 2, i + beginRow + cnt, "平均" + (totalRate_1 / rowNum) , wcf_bold_right);
            ws.addCell(nLbl);
            // 贷款发放额
            nLbl = new Number(beginCol + ++coloffset, i + beginRow + cnt, allOrgTotalAmt1.doubleValue(), wcf_bold_right);
            ws.addCell(nLbl);

            //每万元买单价格（基准）
            nLbl = new Number(beginCol + ++coloffset, i + beginRow + cnt, baseprice1.doubleValue(), wcf_bold_right);
            ws.addCell(nLbl);
            //执行买单价格（元/万元）
            execAmtStandard = baseprice1.multiply(getRateFormula(averageRate1, averageRate1, weight));
            nLbl = new Number(beginCol + ++coloffset, i + beginRow + cnt, execAmtStandard.doubleValue(), wcf_bold_right);
            ws.addCell(nLbl);
            //贷款发放额（万元）
            loanAmtWan = allOrgTotalAmt1.divide(new BigDecimal(10000));
            //nLbl = new Number(beginCol + 6, i + beginRow + cnt, loanAmtWan.doubleValue(), wcf_right);
            //ws.addCell(nLbl);
            //绩效工资
            performPay = loanAmtWan.multiply(execAmtStandard);
            nLbl = new Number(beginCol + ++coloffset, i + beginRow + cnt, performPay.doubleValue(), wcf_bold_right);
            ws.addCell(nLbl);
            //绩效工资合计
            singleOrgPerformPaymPay = new BigDecimal(0);

            singleOrgPerformPaymPay = singleOrgPerformPaymPay.add(performPay);

            //---------------------------第二行-------------------------------
            coloffset = 0;
            ws.setRowView(i + beginRow + 1 + cnt, rowHeight, false);
            // 机构名称
            lbl = new Label(beginCol, i + beginRow + 1 + cnt, bankName, wcf_bold_center);
            ws.addCell(lbl);
            //合计
            lbl = new Label(beginCol + ++coloffset, i + beginRow + cnt, "合计", wcf_bold_center);
            ws.addCell(lbl);
            // 贷款种类
            lbl = new Label(beginCol + ++coloffset, i + beginRow + 1 + cnt, RPTLABEL02, wcf_bold_center);
            ws.addCell(lbl);
            // 贷款浮动比例
            nLbl = new Number(beginCol + ++coloffset, i + beginRow + 1 + cnt, averageRate2.doubleValue(), wcf_bold_right);
            ws.addCell(nLbl);
            // 贷款发放额
            nLbl = new Number(beginCol + ++coloffset, i + beginRow + 1 + cnt, allOrgTotalAmt2.doubleValue(), wcf_bold_right);
            ws.addCell(nLbl);

            //每万元买单价格（基准）
            nLbl = new Number(beginCol + ++coloffset, i + beginRow + 1 + cnt, baseprice2.doubleValue(), wcf_bold_right);
            ws.addCell(nLbl);
            //执行买单价格（元/万元）
            execAmtStandard = baseprice2.multiply(getRateFormula(averageRate2, averageRate2, weight));
            nLbl = new Number(beginCol + ++coloffset, i + beginRow + 1 + cnt, execAmtStandard.doubleValue(), wcf_bold_right);
            ws.addCell(nLbl);
            //贷款发放额（万元）
            loanAmtWan = allOrgTotalAmt2.divide(new BigDecimal(10000));
            //nLbl = new Number(beginCol + 6, i + beginRow + 1 + cnt, loanAmtWan.doubleValue(), wcf_right);
            //ws.addCell(nLbl);
            //绩效工资
            performPay = loanAmtWan.multiply(execAmtStandard);
            nLbl = new Number(beginCol + ++coloffset, i + beginRow + 1 + cnt, performPay.doubleValue(), wcf_bold_right);
            ws.addCell(nLbl);
            //绩效工资合计
            singleOrgPerformPaymPay = singleOrgPerformPaymPay.add(performPay);

            //---------------------------第三行-------------------------------
            coloffset = 0;
            ws.setRowView(i + beginRow + 2 + cnt, rowHeight, false);
            // 机构名称
            lbl = new Label(beginCol, i + beginRow + 2 + cnt, bankName, wcf_bold_center);
            ws.addCell(lbl);
            // 机构合并
            ws.mergeCells(beginCol, i + beginRow + cnt, beginCol, i + beginRow + 2 + cnt);
            //合计
            lbl = new Label(beginCol + ++coloffset, i + beginRow + cnt, "合计", wcf_bold_center);
            ws.addCell(lbl);
            //合计 合并
            ws.mergeCells(beginCol + coloffset, i + beginRow + cnt, beginCol + coloffset, i + beginRow + 2 + cnt);
            // 贷款种类
            lbl = new Label(beginCol + ++coloffset, i + beginRow + 2 + cnt, RPTLABEL03, wcf_bold_center);
            ws.addCell(lbl);
            // 贷款浮动比例
            nLbl = new Number(beginCol + ++coloffset, i + beginRow + 2 + cnt, averageRate3.doubleValue(), wcf_bold_right);
            ws.addCell(nLbl);
            // 贷款发放额
            nLbl = new Number(beginCol + ++coloffset, i + beginRow + 2 + cnt, allOrgTotalAmt3.doubleValue(), wcf_bold_right);
            ws.addCell(nLbl);

            //每万元买单价格（基准）
            nLbl = new Number(beginCol + ++coloffset, i + beginRow + 2 + cnt, baseprice3.doubleValue(), wcf_bold_right);
            ws.addCell(nLbl);
            //执行买单价格（元/万元）
            execAmtStandard = baseprice3.multiply(getRateFormula(averageRate3, averageRate3, weight));
            nLbl = new Number(beginCol + ++coloffset, i + beginRow + 2 + cnt, execAmtStandard.doubleValue(), wcf_bold_right);
            ws.addCell(nLbl);
            //贷款发放额（万元）
            loanAmtWan = allOrgTotalAmt3.divide(new BigDecimal(10000));
            //nLbl = new Number(beginCol + 6, i + beginRow + 2 + cnt, loanAmtWan.doubleValue(), wcf_right);
            //ws.addCell(nLbl);
            //绩效工资
            performPay = loanAmtWan.multiply(execAmtStandard);
            nLbl = new Number(beginCol + ++coloffset, i + beginRow + 2 + cnt, performPay.doubleValue(), wcf_bold_right);
            ws.addCell(nLbl);
            //绩效工资合计
            singleOrgPerformPaymPay = singleOrgPerformPaymPay.add(performPay);
            nLbl = new Number(beginCol + ++coloffset, i + beginRow + cnt, singleOrgPerformPaymPay.doubleValue(), wcf_bold_right);
            ws.addCell(nLbl);
            // 绩效工资合计合并
            ws.mergeCells(beginCol + coloffset, i + beginRow + cnt, beginCol + coloffset, i + beginRow + 2 + cnt);

            // 行计数器加1
            i++;

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
        logger.error("买单工资报表出现错误!",e);
    } finally {
        // 释放数据库连接
        ConnectionManager.getInstance().release();
    }
%>
<%!
    /**
     计算公式〔1+（T-R）*5〕
     贷款实际执行利率（T）
     分行平均利率（R）
     */
    BigDecimal getRateFormula(BigDecimal T, BigDecimal R, BigDecimal weight) {
        return T.subtract(R).multiply(weight).add(new BigDecimal("1"));
    }
%>