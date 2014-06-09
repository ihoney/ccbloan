<%@ page import="java.text.SimpleDateFormat" %>
<!--
/*********************************************************************
* 功能描述: 买单工资查询统计项目17 表8
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
    <script language="javascript" src="payBillList17.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
    <script language="javascript" src="/UI/support/common.js"></script>
    <script language="javascript" src="/UI/support/DataWindow.js"></script>
    <LINK href="/css/newccb.css" type="text/css" rel="stylesheet">

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
<%--
                <table style="margin-top:20px;" border="0" cellspacing="0" cellpadding="0" width="100%">
                    <tr>
                        <td width="40%" nowrap="nowrap" class="lbl_right_padding">贷款利率计算公式权值</td>
                        <td width="60%" nowrap="nowrap" class="data_input">
                            <input type="text" id="weight"
                                   name="CUST_OPEN_DT2"
                                   value="<%=CUST_OPEN_DT2%>"
                                   fieldType="number" style="width:40% "
                                   isNull="false">
                            <span class="red_star">*</span></td>
                    </tr>
                    <tr>
                        <td width="40%" nowrap="nowrap" class="lbl_right_padding">个人住房贷款每万元买单基准价格</td>
                        <td width="60%" nowrap="nowrap" class="data_input">
                            <input type="text" id="standard1"
                                   name="CUST_OPEN_DT2"
                                   &lt;%&ndash;value="<%=CUST_OPEN_DT2%>"&ndash;%&gt;
                                   fieldType="number" style="width:40% "
                                   isNull="false">
                            <span class="red_star">*</span></td>
                    </tr>

                        <td width="30%" nowrap="nowrap" class="lbl_right_padding">个人助业贷款每万元买单基准价格</td>
                        <td width="60%" nowrap="nowrap" class="data_input">
                            <input type="text" id="standard2"
                                   name="CUST_OPEN_DT2"
                                   &lt;%&ndash;value="<%=CUST_OPEN_DT2%>"&ndash;%&gt;
                                   fieldType="number" style="width:40% "
                                   isNull="false">
                            <span class="red_star">*</span></td>
                    </tr>
                    
                        <td width="40%" nowrap="nowrap" class="lbl_right_padding">个人类其他贷款每万元买单基准价格</td>
                        <td width="60%" nowrap="nowrap" class="data_input">
                            <input type="text" id="standard3"
                                   name="CUST_OPEN_DT2"
                                   &lt;%&ndash;value="<%=CUST_OPEN_DT2%>"&ndash;%&gt;
                                   fieldType="number" style="width:40% "
                                   isNull="false">
                            <span class="red_star">*</span></td>
                    </tr>
                </table>
            </div>
--%>
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

<div class="help-window" style="margin-top: 30px">
    <DIV class=formSeparator>
        <H2>[客户经理买单工资统计表]</H2>
    </DIV>
    <div class="help-info">
        <ul>
            <li>2012-5-25：报表数据按照客户经理进行分组统计.</li>
        </ul>
    </div>
</div>

</body>
</html>
