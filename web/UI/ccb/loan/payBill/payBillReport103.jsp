/*********************************************************************
* 功能描述: 买单工资统计项目表 机构利率浮动比例统计表  (按营销经理)
* 贷款分类分为5类
个人住房贷款(仅含个人住房贷款、个人再交易住房贷款)
个人消费经营类贷款（含个人消费额度、个人助业、个人汽车、个人质押贷款等）
个人商业用房贷款（仅含个人商业用房贷款、个人再交易商业用房贷款）
个人住房抵押额度贷款
个人类贷款合计
* 作 者: zr
* 开发日期: 2013/01/23
***********************************************************************/
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
<%@page import="java.util.List" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%
    OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
    String deptId = omgr.getOperator().getPtDeptBean().getDeptid();

    try {
        do {
            //得到报表模板
            String rptModelPath = PropertyManager.getProperty("REPORT_ROOTPATH");
            String rptName = rptModelPath +  "payBill13.xls";
            File file = new File(rptName);
            // 判断模板是否存在,不存在则退出
            if (!file.exists()) {
                out.println(rptName + PropertyManager.getProperty("304"));
                break;
            }
            // 输出报表
            response.reset();
            response.setContentType("application/vnd.ms-excel");
            response.addHeader("Content-Disposition", "attachment; filename="  + "payBill13.xls");
            // ----------------------------根据模板创建输出流----------------------------------------------------------------
            WorkbookSettings setting = new WorkbookSettings();
            Locale locale = new Locale("zh", "CN");
            setting.setLocale(locale);
            setting.setEncoding("ISO-8859-1");
            File fileInput = new File(rptName);
            Workbook rw = Workbook.getWorkbook(fileInput, setting);
            WritableWorkbook wwb = Workbook.createWorkbook(response.getOutputStream(), rw, setting);
            WritableSheet ws = wwb.getSheet(0);

            // --------------字体样式--------------------
            // ---文字样式 居中对齐----
            WritableFont NormalFont = new WritableFont(WritableFont.COURIER, 11);
            WritableCellFormat wcf_center = new WritableCellFormat(NormalFont);
            wcf_center.setBorder(Border.ALL, BorderLineStyle.THIN);
            wcf_center.setVerticalAlignment(VerticalAlignment.CENTRE);
            wcf_center.setAlignment(Alignment.CENTRE);
            wcf_center.setWrap(true);  //  是否换行

            // ----数值样式 居右对齐---
            NumberFormat nf = new NumberFormat("#,###,###,##0.00");
            NumberFormat nf_rate = new NumberFormat("#,###,###,##0.000000");
            WritableCellFormat wcf_right = new WritableCellFormat(nf);
            WritableCellFormat wcf_right_rate = new WritableCellFormat(nf_rate);
            wcf_right.setFont(new WritableFont(WritableFont.COURIER, 11, WritableFont.NO_BOLD, false));
            wcf_right_rate.setFont(new WritableFont(WritableFont.COURIER, 11, WritableFont.NO_BOLD, false));

            // 粗体字设置
            WritableCellFormat wcf_bold_center = new WritableCellFormat(new WritableFont(WritableFont.COURIER, 11, WritableFont.BOLD, false));
            wcf_bold_center.setBorder(Border.ALL, BorderLineStyle.THIN);
            wcf_bold_center.setAlignment(Alignment.CENTRE);
            wcf_bold_center.setVerticalAlignment(VerticalAlignment.CENTRE);
            wcf_bold_center.setWrap(true);  //  是否换行

            // ----居右显示--
            WritableCellFormat wcf_bold_right = new WritableCellFormat(nf);
            wcf_bold_right.setFont(new WritableFont(WritableFont.COURIER, 11, WritableFont.BOLD, false));
            wcf_bold_right.setBorder(Border.ALL, BorderLineStyle.THIN);
            wcf_bold_right.setAlignment(Alignment.RIGHT);
            wcf_bold_right.setVerticalAlignment(VerticalAlignment.CENTRE);
            WritableCellFormat wcf_bold_right_rate = new WritableCellFormat(nf_rate);
            wcf_bold_right_rate.setFont(new WritableFont(WritableFont.COURIER, 11, WritableFont.BOLD, false));
            wcf_bold_right_rate.setBorder(Border.ALL, BorderLineStyle.THIN);
            wcf_bold_right_rate.setAlignment(Alignment.RIGHT);
            wcf_bold_right_rate.setVerticalAlignment(VerticalAlignment.CENTRE);

            // 边框样式
            wcf_right.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
            wcf_right.setWrap(false);
            wcf_right.setVerticalAlignment(VerticalAlignment.CENTRE);
            wcf_right.setAlignment(Alignment.RIGHT);
            wcf_right_rate.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
            wcf_right_rate.setWrap(false);
            wcf_right_rate.setVerticalAlignment(VerticalAlignment.CENTRE);
            wcf_right_rate.setAlignment(Alignment.RIGHT);

            // 行高
            int rowHeight = 1000;
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

            //===================================================================
            // 组查询基本条件字符串
            String whereStr = " where 1=1  and t.LOANSTATE is not null and t.LOANSTATE <> '0' and t.custmgr_id is not null ";
            if (!request.getParameter("CUST_OPEN_DT").trim().equals("")) {
                whereStr += " and t.CUST_OPEN_DT >='" + request.getParameter("CUST_OPEN_DT").trim() + "'";
            }
            if (!request.getParameter("CUST_OPEN_DT2").trim().equals("")) {
                whereStr += " and t.CUST_OPEN_DT <='" + request.getParameter("CUST_OPEN_DT2").trim() + "'";
            }

            List<String> itemtitleList = new ArrayList<String>();
            List<String> itemcriteriaList = new ArrayList<String>();

            DatabaseConnection conn = ConnectionManager.getInstance().get();
            //获取表项目配置
            getItemConfig(itemtitleList, itemcriteriaList, conn);

            StringBuffer detailSql = new StringBuffer();
            //明细数据
            int itemSize = assembleSql(deptId, whereStr, itemcriteriaList, detailSql);
            RecordSet rs = conn.executeQuery(detailSql.toString());

            //步长（已输出的机构个数)
            int deptCount = 0;
            // 步长（输出的行数）
            int sheetRowCount = 0;

            while (rs.next()) {
                sheetRowCount = deptCount * itemSize;
                if (deptCount > 0) {
                    sheetRowCount = sheetRowCount - deptCount;
                }
                // 经办行名称
                String bankName = rs.getString("bankname");
                String custMgrName = rs.getString("custmgr_name");
                int k = 0;
                for (String title : itemtitleList) {
                    outputOneXlsRow(title, ws, rs, deptCount, sheetRowCount, rowHeight, beginRow, k, beginCol, wcf_center, wcf_right, wcf_right_rate, bankName,custMgrName);
                    k++;
                }
                ws.mergeCells(beginCol, deptCount + beginRow + sheetRowCount, beginCol, deptCount + beginRow + itemSize - 1  + sheetRowCount);
                ws.mergeCells(beginCol+1, deptCount + beginRow + sheetRowCount, beginCol+1, deptCount + beginRow + itemSize - 1  + sheetRowCount);
                deptCount++;
            }

            //----输出本机构及下属机构合计----------------------------------------------------------------
/*
            rs = conn.executeQuery("select deptname, fillstr10 from ptdept where deptid='" + deptId + "'");
            String deptNameTmp = "";
            String deptLevel = "";
            while (rs.next()) {
                deptNameTmp = rs.getString(0);
                deptLevel = rs.getString(1);
            }
            //在当前机构为分行时，逐个输出直属机构的汇总 (不包括虚拟管理机构 如个贷中心)
            if (StringUtils.isNotEmpty(deptLevel) && "1".equals(deptLevel)) {
                rs = conn.executeQuery("select deptid, deptname from ptdept where fillstr10='3' and fillstr20 is not null");
                while (rs.next()) {
                    String deptIdTmp = rs.getString(0);
                    deptNameTmp = rs.getString(1);
                    deptCount = outputOneDeptTotal(deptIdTmp, ws, wcf_bold_center, wcf_bold_right, rowHeight, beginRow, beginCol, whereStr, itemtitleList, itemcriteriaList, conn, itemSize, deptCount, deptNameTmp);
                }
            }
            //在当前机构为分行直属机构时，只输出当前机构的合计
            if (StringUtils.isNotEmpty(deptLevel) && "3".equals(deptLevel)) {
                deptCount = outputOneDeptTotal(deptId, ws, wcf_bold_center, wcf_bold_right, rowHeight, beginRow, beginCol, whereStr, itemtitleList, itemcriteriaList, conn, itemSize, deptCount, deptNameTmp);
            }

            //----固定输出市分行合计-------------------------------------------------------------------------
            deptCount = outputOneDeptTotal("371980000", ws, wcf_bold_center, wcf_bold_right, rowHeight, beginRow, beginCol, whereStr, itemtitleList, itemcriteriaList, conn, itemSize, deptCount, "市分行");

*/

            wwb.write();
            wwb.close();
            rw.close();
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

<%!
    //通过deptid 输出此机构的汇总信息
    private int outputOneDeptTotal(String deptId, WritableSheet ws, WritableCellFormat wcf_bold_center,
                                   WritableCellFormat wcf_bold_right,
                                   WritableCellFormat wcf_bold_right_rate,
                                   int rowHeight, int beginRow, int beginCol,
                                   String whereStr,
                                   List<String> itemtitleList, List<String> itemcriteriaList,
                                   DatabaseConnection conn, int itemSize, int row, String deptName) throws WriteException {
        RecordSet rs;
        int cnt;
        StringBuilder totalSql = new StringBuilder("select sysdate");
        assembleSqlHeader(itemcriteriaList, totalSql);

        StringBuffer  detailSql = new StringBuffer();
        assembleSql(deptId, whereStr, itemcriteriaList, detailSql);
        totalSql.append(" from (" + detailSql.toString() + ")");
        //合计时用到的机构清单
        String totalDeptName = deptName + "(合计)";

        rs = conn.executeQuery(totalSql.toString());
        while (rs.next()) {
            cnt = row * itemSize;
            if (row > 0) {
                cnt = cnt - row;
            }
            int k = 0;
            for (String title : itemtitleList) {
                outputOneXlsRow(title, ws, rs, row, cnt, rowHeight, beginRow, k, beginCol, wcf_bold_center, wcf_bold_right, wcf_bold_right_rate, totalDeptName,"");
                k++;
            }
            ws.mergeCells(beginCol, row + beginRow + cnt, beginCol, row + beginRow + itemSize - 1  + cnt);
            ws.mergeCells(beginCol+1, row + beginRow + cnt, beginCol+1, row + beginRow + itemSize - 1  + cnt);
            row++;
        }
        return row;
    }

    private void assembleSqlHeader(List<String> itemcriteriaList, StringBuilder totalSql) {
        int step = 0;
        for (String criterion : itemcriteriaList) {
            step++;
            totalSql.append(",sum(amt" + step + ") as amt" + step);
            totalSql.append(",round(sum(totalrate" + step + ")/sum(amt" + step + "),6) as rate" + step + " ");
        }
    }

    private int assembleSql(String deptId, String whereStr, List<String> itemcriteriaList, StringBuffer selectSQl) {
        int step = 0;
        //统计项目数
        int itemSize = 0;
        selectSQl.append("select bankid,bankname");
        selectSQl.append(",custmgr_name ");
        for (String criterion : itemcriteriaList) {
            step++;
            itemSize++;
            selectSQl.append(",amt" + step);
            selectSQl.append(",round(rate" + step + "/amt" + step + ",6) as rate" + step + " ");
            selectSQl.append(",rate" + step + " as totalrate" + step);
        }
        selectSQl.append(" from (select t.bankid, (select deptname from ptdept where deptid = t.bankid) as bankname ");
        selectSQl.append(",(select prommgr_name from ln_prommgrinfo where prommgr_id=t.custmgr_id) as custmgr_name ");
        step = 0;
        for (String criterion : itemcriteriaList) {
            step++;
            selectSQl.append(
                    " ,sum(case"
                            + "       when (" + criterion + ") then"
                            + "        rt_orig_loan_amt"
                            + "       else"
                            + "        null"
                            + "     end) as amt" + step
                            + "  ,sum(case"
                            + "       when (" + criterion + ") then"
                            + "        RATECALEVALUE*rt_orig_loan_amt"
                            + "       else"
                            + "        null"
                            + "     end) as rate" + step
                            + " "
            );
        }
        selectSQl.append(" from ln_loanapply t ");
        selectSQl.append(whereStr + " and t.bankid in(select deptid from ptdept start with deptid='" + deptId + "' connect by prior deptid=parentdeptid) ");
        selectSQl.append(" group by bankid,custmgr_id order by bankid,custmgr_id) ");
        return itemSize;
    }

    private void getItemConfig(List<String> itemtitleList, List<String> itemcriteriaList, DatabaseConnection conn) {
        //统计条件定义表处理
        String configSql = "select t.enuitemlabel as itemtitle, t.enuitemdesc as itemcriteria" +
                "  from PTENUDETAIL t" +
                " where t.enutype = 'PAYBILL_INTRRATE'" +
                " order by t.enuitemvalue";
        RecordSet configRs = conn.executeQuery(configSql);

        while (configRs.next()) {
            String itemtitle = configRs.getString("itemtitle");
            String itemcriteria = configRs.getString("itemcriteria");
            itemcriteriaList.add(itemcriteria);
            itemtitleList.add(itemtitle);
        }
    }

    private void outputOneXlsRow(String RPTLABEL01,
                                 WritableSheet ws, RecordSet rs,
                                 int i, int cnt,
                                 int rowHeight,
                                 int beginRow, int rowOffset, int beginCol,
                                 WritableCellFormat wcf_center, WritableCellFormat wcf_right,
                                 WritableCellFormat wcf_right_rate,
                                 String bankName, String custMgrName) throws WriteException {
        ws.setRowView(i + beginRow + rowOffset + cnt, rowHeight, false);
        // 机构名称
        Label lbl = new Label(beginCol, i + beginRow + rowOffset + cnt, bankName, wcf_center);
        ws.addCell(lbl);
        //营销经理名称
        lbl = new Label(beginCol+1, i + beginRow + rowOffset + cnt, custMgrName, wcf_center);
        ws.addCell(lbl);
        // 贷款种类
        lbl = new Label(beginCol + 2, i + beginRow + rowOffset + cnt, RPTLABEL01, wcf_center);
        ws.addCell(lbl);
        // 贷款浮动比例
        Number nLbl = new Number(beginCol + 3, i + beginRow + rowOffset + cnt, rs.getDouble("rate" + (rowOffset + 1)), wcf_right_rate);
        ws.addCell(nLbl);
        // 贷款发放额
        nLbl = new Number(beginCol + 4, i + beginRow + rowOffset + cnt, rs.getDouble("amt" + (rowOffset + 1)), wcf_right);
        ws.addCell(nLbl);
    }
%>