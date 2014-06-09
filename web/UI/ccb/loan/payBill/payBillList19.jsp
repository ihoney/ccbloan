<%@ page import="java.text.SimpleDateFormat" %>
<!--
/*********************************************************************
* 功能描述: 买单工资查询统计项目16 表7
* 作 者:
* 开发日期: 2011/03/06
* 修 改 人:
* 修改日期:
* 版 权: 公司
***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK" %>
<%@include file="/global.jsp" %>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title></title>
    <script language="javascript" src="payBillList19.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
    <script language="javascript" src="/UI/support/common.js"></script>
    <script language="javascript" src="/UI/support/DataWindow.js"></script>
    <style type="text/css">
        .queryPanalDiv {
            width: 100%;
            margin: 5px auto;
            padding: 2px, 20px, 2px, 20px;
            text-align: center; /*border: 1px #1E7ACE solid;*/
        }

        .queryDiv {
            width: 90%;
            margin: 0px auto;
            padding: 2px, 1px, 1px, 1px;
            text-align: center; /*border: 1px #1E7ACE solid;*/
        }

        .queryButtonDiv {
            width: 100%;
            margin: 5px auto;
            padding: 10px, 5px, 2px, 2px;
            text-align: center; /*border: 1px #1E7ACE solid;*/
        }
    </style>
</head>

<%
    Calendar calendar = new GregorianCalendar();
    Calendar calendar1 = new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - 1, 1);
    Date lastmonth = calendar1.getTime();
    String CUST_OPEN_DT = new SimpleDateFormat("yyyy-MM-dd").format(lastmonth);

    calendar1.set(Calendar.DAY_OF_MONTH, calendar1.getActualMaximum(Calendar.DAY_OF_MONTH));
    lastmonth = calendar1.getTime();
    String CUST_OPEN_DT2 = new SimpleDateFormat("yyyy-MM-dd").format(lastmonth);

%>

<body onLoad="payBillInit()" bgcolor="#ffffff" class="Bodydefault">

<br>

<div class="queryPanalDiv">
    <fieldset style="padding-top:30px;padding-bottom:0px;margin-top:0px">
        <legend>查询条件</legend>
        <form id="queryForm" name="queryForm">
            <div class="queryDiv">
                <table border="0" cellspacing="0" cellpadding="0" width="100%">
                    <tr>
                        <td width="40%" nowrap="nowrap" class="lbl_right_padding">起始开户日期</td>
                        <td width="60%" nowrap="nowrap" class="data_input">
                            <input type="text" id="CUST_OPEN_DT"
                                   name="CUST_OPEN_DT"
                                   value="<%=CUST_OPEN_DT%>"
                                   onClick="WdatePicker()"
                                   fieldType="date" style="width:40% " isNull="false">
                            <span class="red_star">*</span></td>
                    </tr>
                    <tr>
                        <td width="40%" nowrap="nowrap" class="lbl_right_padding">截至开户日期</td>
                        <td width="60%" nowrap="nowrap" class="data_input">
                            <input type="text" id="CUST_OPEN_DT2"
                                   name="CUST_OPEN_DT2"
                                   value="<%=CUST_OPEN_DT2%>"
                                   onClick="WdatePicker()"
                                   fieldType="date" style="width:40% "
                                   isNull="false">
                            <span class="red_star">*</span></td>
                    </tr>
                </table>
            </div>
            <div class="queryButtonDiv">
                <table>
                    <tr>
                        <td colspan="8" nowrap="nowrap" align="right"><input name="expExcel"
                                                                             class="buttonGrooveDisableExcel"
                                                                             type="button" id="button"
                                                                             onClick="loanTab_expExcel_click()"
                                                                             value="导出excel">
                            <input class="buttonGrooveDisableExcel" name="Input" type="reset" value="重填">
                        </td>
                    </tr>
                </table>
            </div>
        </form>
    </fieldset>
</div>
</body>
</html>
