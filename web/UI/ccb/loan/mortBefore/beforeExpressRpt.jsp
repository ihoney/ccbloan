<!--
/*********************************************************************
* 功能描述: 快递输出excel
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
<%@page import="jxl.Cell" %>
<%@page import="jxl.format.Alignment" %>
<%@page import="jxl.format.Border" %>
<%@page import="jxl.format.VerticalAlignment" %>
<%@page import="jxl.format.BorderLineStyle" %>
<%@page import="pub.platform.db.DBUtil" %>
<%@page import="pub.platform.utils.BusinessDate" %>
<%

    OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);

//采用do while结构便于在主流程中监测错误发生后退出主程序；
    try {
        do {
            // 输出报表
            response.reset();
            response.setContentType("application/vnd.ms-excel");
            response.addHeader("Content-Disposition", "attachment; filename=" + CcbLoanConst.RPT_MODEL_EXPRESS + ".xls");
            // ----------------------------根据模板创建新workbook得到可操作的writableworkbook写到输出流中-----------------------------------
            //得到报表模板
            String rptModelPath = PropertyManager.getProperty("REPORT_ROOTPATH");
            String rptName = rptModelPath + CcbLoanConst.RPT_MODEL_EXPRESS + ".xls";
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
            //String targetFileName = CcbLoanConst.RPT_PAY_BILL_10+System.currentTimeMillis()+".xls";
            //String targetFile = PropertyManager.getProperty("cims")+"temp\\" + targetFileName;
            //File newFile = new File(targetFile);
            // 写到jsp中的输出流中
            WritableWorkbook wwb = Workbook.createWorkbook(response.getOutputStream(), rw, setting);
            // 得到第一个工作表
            WritableSheet ws = wwb.getSheet(0);

            // ----------------从数据库读取数据写入excel中--------------------------------------------------------------------------------
            // 查询字符串
            String whereStr = " ";
            // 快递类型
            String expressType = "";
            expressType = request.getParameter("expressType");
            if (expressType.equals("mortBefore")) {
                // 统计快递日期等于当天的数据
                whereStr += " and b.EXPRESSENDSDATE ='" + BusinessDate.getToday() + "'";
            } else {
                // 入库日期等于当天日期并且快递发出日期不为空
                whereStr += " and trim(b.EXPRESSENDSDATE) is not null and b.PAPERRTNDATE ='" + BusinessDate.getToday() + "'";
            }
            DatabaseConnection conn = ConnectionManager.getInstance().get();
            // 统计查询语句
            RecordSet rs = conn.executeQuery(""
                    + "select (select enuitemlabel from ptenudetail where enuitemvalue=b.MORTECENTERCD and enutype='MORTECENTERCD')as MORTECENTERCD,"
                    + "(select deptname from ptdept where deptid=a.bankid) as deptname,"
                    + "a.cust_name,a.RT_ORIG_LOAN_AMT,"
                    + "(select enuitemlabel from ptenudetail where enuitemvalue=b.RELEASECONDCD and enutype='RELEASECONDCD') as RELEASECONDCD,"
                    + " b.mortid,b.mortdate,b.BOXID,b.EXPRESSNOTE"
                    + " from ln_loanapply a,ln_mortinfo b where "
                    //+" a.loanid = b.loanid and b.mortstatus='"+CcbLoanConst.MORT_FLOW_SENT +"' and "
                    + " a.loanid = b.loanid "
                    + " and a.bankid in(select deptid from ptdept start with deptid='" + omgr.getOperator().getDeptid() + "' connect by prior deptid=parentdeptid) "

                    // 抵押交易中心过滤
                    //+ " and b.MORTECENTERCD in ('08','09','10','11','12') "
                    + " and b.MORTECENTERCD in (select mortecentercd from ln_morttype where typeflag='1' and deptid='" + omgr.getOperator().getDeptid() + "') "

                    + whereStr
                    + "  ");
            // 行计数器
            int i = 0;
            // 步长（每条记录输出一行）
            int step = 1;
            int cnt = i * step;
            // --------------字体样式--------------------
            // ---文字样式 居中对齐---
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
            WritableCellFormat wcf_right = new WritableCellFormat(new WritableFont(WritableFont.COURIER, 11, WritableFont.NO_BOLD, false));
            // 边框样式
            wcf_right.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
            // 折行
            wcf_right.setWrap(false);
            // 垂直对齐
            wcf_right.setVerticalAlignment(VerticalAlignment.CENTRE);
            // 水平对齐
            wcf_right.setAlignment(Alignment.RIGHT);
            // 行高
            int rowHeight = 300;
            // 开始行
            int beginRow = 1;
            // 开始列
            int beginCol = 1;
            while (rs.next()) {
                cnt = i * step;
                if (i > 0) {
                    cnt = cnt - i;
                }

                // 从第2行开始写数据
                //--------------------------第一行--------------------------------
                ws.setRowView(i + beginRow + cnt, rowHeight, false);
                // 交易中心
                Label lbl = new Label(beginCol, i + beginRow + cnt, rs.getString("MORTECENTERCD"), wcf_center);
                ws.addCell(lbl);
                // 机构
                lbl = new Label(beginCol + 1, i + beginRow + cnt, rs.getString("deptname"), wcf_center);
                ws.addCell(lbl);
                // 姓名
                lbl = new Label(beginCol + 2, i + beginRow + cnt, rs.getString("cust_name"), wcf_center);
                ws.addCell(lbl);
                // 金额
                lbl = new Label(beginCol + 3, i + beginRow + cnt, rs.getString("RT_ORIG_LOAN_AMT"), wcf_right);
                ws.addCell(lbl);
                // 放款方式
                lbl = new Label(beginCol + 4, i + beginRow + cnt, rs.getString("RELEASECONDCD"), wcf_center);
                ws.addCell(lbl);
                // 抵押编号
                lbl = new Label(beginCol + 5, i + beginRow + cnt, rs.getString("mortid"), wcf_center);
                ws.addCell(lbl);
                // 抵押日期
                lbl = new Label(beginCol + 6, i + beginRow + cnt, rs.getString("mortdate"), wcf_center);
                ws.addCell(lbl);
                // 柜号
                lbl = new Label(beginCol + 7, i + beginRow + cnt, rs.getString("BOXID"), wcf_center);
                ws.addCell(lbl);
                //备注
                lbl = new Label(beginCol + 8, i + beginRow + cnt, rs.getString("EXPRESSNOTE"), wcf_center);
                ws.addCell(lbl);

                // 行计数器加1
                i++;
            }
            // 释放数据库连接
            //ConnectionManager.getInstance().release();
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
    } finally {
        // 释放数据库连接
        ConnectionManager.getInstance().release();
    }
%>
