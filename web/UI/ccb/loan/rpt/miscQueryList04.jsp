<!--
/*********************************************************************
* 功能描述: 组合查询统计四(签约放款超批复预警 小计表)
***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK" %>
<%@include file="/global.jsp" %>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title></title>
    <script language="javascript" src="miscQueryList04.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
    <script language="javascript" src="/UI/support/common.js"></script>
    <script language="javascript" src="/UI/support/DataWindow.js"></script>
    <LINK href="/css/newccb.css" type="text/css" rel="stylesheet">
    
</head>
<body onload="formInit()" bgcolor="#ffffff" class="Bodydefault">

<fieldset style="padding:40px 25px 0px 25px;margin:0px 20px 0px 20px">

    <%--<div class="title">按合作方、合作项目名称、经办行、未办抵押原因统计</div>--%>
    <legend>查询条件</legend>
        <br>
        <table border="0" cellspacing="0" cellpadding="0" width="100%">
        <form id="queryForm" name="queryForm">
 
            <!-- 组合查询统计类型一 -->
            <input type="hidden" value="miscRpt03" id="rptType" name="rptType"/>
            <tr>
                <td width="25%" nowrap="nowrap" class="lbl_right_padding">抵押接收日期</td>
                <td width="20%" nowrap="nowrap" class="data_input"><input type="text" id="MORTEXPIREDATE"
                                                                          name="MORTEXPIREDATE" onClick="WdatePicker()"
                                                                          fieldType="date" size="20"></td>
                <td width="5%" nowrap="nowrap" class="lbl_right_padding">至</td>
                <td width="50%" nowrap="nowrap" class="data_input"><input type="text" id="MORTEXPIREDATE2"
                                                                          name="MORTEXPIREDATE2" onClick="WdatePicker()"
                                                                          fieldType="date" size="20"></td>
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
        <H2>[抵押超批复预警汇总表]</H2>
    </DIV>
    <div class="help-info">
        <ul>
            <li>此统计表统计抵押超批复的贷款笔数及金额.</li>
            <li>超批复时间基准为当前日期.</li>
            <li>统计类别包括签约放款和组合签约放款两类.</li>
            <li>不输入抵押接收起始日期，系统默认为统计当前数据库中全部符合条件的信息数据.</li>
            <li>统计表以经办机构的机构编号排序.</li>
        </ul>
    </div>
</div>


</body>
</html>
