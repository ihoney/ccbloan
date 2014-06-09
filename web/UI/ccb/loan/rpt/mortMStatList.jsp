<!--
/*********************************************************************
* 功能描述: 抵押报送月统计表
* 开发日期: 2011/03/28
* 修 改 人:
* 修改日期:
***********************************************************************/
-->
<%@ page import="java.text.SimpleDateFormat" %>
<%@page contentType="text/html; charset=GBK" %>
<%@include file="/global.jsp" %>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title></title>
    <script language="javascript" src="mortMStatList.js"></script>
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
    Calendar calendar1 = new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) , 1);
    Date lastmonth = calendar1.getTime();
    String CUST_OPEN_DT = new SimpleDateFormat("yyyy-MM-dd").format(lastmonth);

    calendar1.set(Calendar.DAY_OF_MONTH, calendar1.getActualMaximum(Calendar.DAY_OF_MONTH));
    lastmonth = calendar1.getTime();
    String CUST_OPEN_DT2 = new SimpleDateFormat("yyyy-MM-dd").format(lastmonth);

%>

<body onLoad="formInit()" bgcolor="#ffffff" class="Bodydefault">

<br>

<div class="queryPanalDiv">
    <fieldset style="padding-top:30px;padding-bottom:0px;margin-top:0px">
        <legend>统计条件</legend>
        <form id="queryForm" name="queryForm">
            <div class="queryDiv">
                <table border="0" cellspacing="0" cellpadding="0" width="100%">
                    <tr>
                        <td width="40%" nowrap="nowrap" class="lbl_right_padding">起始日期</td>
                        <td width="60%" nowrap="nowrap" class="data_input">
                            <input type="text" id="CUST_OPEN_DT"
                                   name="CUST_OPEN_DT"
                                   value="<%=CUST_OPEN_DT%>"
                                   onClick="WdatePicker()"
                                   fieldType="date" style="width:40% " isNull="false">
                            <span class="red_star">*</span></td>
                    </tr>
                    <tr>
                        <td width="40%" nowrap="nowrap" class="lbl_right_padding">截止日期</td>
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
                <div class="queryButtonDiv" style="margin-top:10px;">
                    <table>
                        <tr>
                            <td colspan="8" nowrap="nowrap" align="right"><input name="expExcel" style="width:120px;"
                                                                                 class="buttonGrooveDisableExcel"
                                                                                 type="button" id="button"
                                                                                 onClick="loanTab_expExcel_click()"
                                                                                 value="导出Excel">
                            </td>
                        </tr>
                    </table>
                </div>
            </form>
        </fieldset>

<br/>
<br/>
<br/>
</div>
<div class="help-window">
    <DIV class=formSeparator>
        <H2>[抵押报送统计表]</H2>
    </DIV>
    <div class="help-info">
        <ul>
            <li>当月报送：指抵押内勤岗在统计期间内接收的且未办理抵押原因属于 1)抵押中 2)已抵押 3)材料已报送.</li>
            <li>当月回证：在统计期间内接收的且抵押登记状态不是“未登记的”.</li>
        </ul>
    </div>
</div>


</body>
</html>
