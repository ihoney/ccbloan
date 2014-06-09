<%@ page import="java.text.SimpleDateFormat" %>
<!--
/*********************************************************************
* 功能描述: 签约放款的未回证考核表一
* 作 者:
* 开发日期:
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
    <script language="javascript" src="noRtnQueryList01.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
    <script language="javascript" src="/UI/support/common.js"></script>
    <script language="javascript" src="/UI/support/DataWindow.js"></script>
    <LINK href="/css/newccb.css" type="text/css" rel="stylesheet">

</head>
<%
    Calendar calendar = new GregorianCalendar();
    Calendar calendar1 = new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - 1, 1);
    Date lastmonth = calendar1.getTime();
    String ACCTOPENDATE1 = new SimpleDateFormat("yyyy-MM-dd").format(lastmonth);

    calendar1.set(Calendar.DAY_OF_MONTH, calendar1.getActualMaximum(Calendar.DAY_OF_MONTH));
    lastmonth = calendar1.getTime();
    String basedate_kaohe = "2011-01-01";
    String ACCTOPENDATE2 = new SimpleDateFormat("yyyy-MM-dd").format(lastmonth);

    try {
        DatabaseConnection conn = ConnectionManager.getInstance().get();
        RecordSet rs = conn.executeQuery("select enuitemlabel from ptenudetail where enutype = 'PAYBILLBASEDATE'  and enuitemvalue = '01'");
        while (rs.next()) {
            basedate_kaohe = rs.getString(0);
        }
    } finally {
        ConnectionManager.getInstance().release();
    }
%>

<body onload="formInit()" bgcolor="#ffffff" class="Bodydefault">

<fieldset style="padding:40px 25px 0px 25px;margin:0px 20px 0px 20px">

    <legend>统计条件</legend>
    <br>
    <table border="0" cellspacing="0" cellpadding="0" width="100%">
        <form id="queryForm" name="queryForm">

            <!-- 组合查询统计类型一 -->
            <input type="hidden" value="miscRpt03" id="rptType" name="rptType"/>
            <input type="hidden" value="<%=basedate_kaohe%>" id="basedate_kaohe" name="basedate_kaohe"/>

            <tr>
                <%--
                                <td width="25%" nowrap="nowrap" class="lbl_right_padding">考核日期</td>
                                <td width="20%" nowrap="nowrap" class="data_input"><input type="text" id="ACCTOPENDATE1"
                                                                                          name="ACCTOPENDATE1" onClick="WdatePicker()" value="<%=ACCTOPENDATE1%>"
                                                                                          fieldType="date" size="20" isNull="false"><span class="red_star">*</span></td>
                                <td width="5%" nowrap="nowrap" class="lbl_right_padding">至</td>
                                <td width="50%" nowrap="nowrap" class="data_input"><input type="text" id="ACCTOPENDATE2"
                                                                                          name="ACCTOPENDATE2" onClick="WdatePicker()" value="<%=ACCTOPENDATE2%>"
                                                                                          fieldType="date" size="20" isNull="false"><span class="red_star">*</span></td>
                --%>
                <td width="30%" nowrap="nowrap" class="lbl_right_padding">考核统计截止日期:</td>
                <td width="70%" nowrap="nowrap" class="data_input">
                    <input type="text" id="ACCTOPENDATE2"
                           name="ACCTOPENDATE2" onClick="WdatePicker()"
                           value="<%=ACCTOPENDATE2%>"
                           fieldType="date" size="40"
                           isNull="false"/>
                    <span class="red_star">*</span>
                </td>

            </tr>
            <tr>
                <td colspan="4" nowrap="nowrap" align="center" style="padding:20px">
                    <input name="expExcel" class="buttonGrooveDisableExcel" type="button"
                           onClick="loanTab_expExcel_click()" value="导出excel">
                    <input type="reset" value="重填" class="buttonGrooveDisable">
                </td>
            </tr>

        </form>
    </table>
</fieldset>

<br/>
<br/>
<br/>

<div class="help-window">
    <DIV class=formSeparator>
        <H2>[签约放款回证考核表一]</H2>
    </DIV>
    <div class="help-info">
        <ul>
            <li>统计条件1：签约放款或组合签约放款.</li>
            <li>统计条件2：未回证或已回证但回证日期在考核统计截止日期之后.</li>
            <li>统计条件3：抵押超批复日期+60天宽限期在考核统计截止日期之前（含）.</li>
            <li>统计表的内表1为按机构总计表，并以经办机构的机构编号排序.</li>
            <li>统计表的内表2为按机构及客户经理合计表，并以经办机构的机构编号及客户经理的编号排序.</li>
            <li>统计表的内表3为按明细数据表，并以经办机构的机构编号、客户经理的编号、客户姓名排序.</li>

        </ul>
    </div>
</div>


</body>
</html>
