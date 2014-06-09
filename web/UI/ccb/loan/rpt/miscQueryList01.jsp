<!--
/*********************************************************************
* 功能描述: 组合查询统计一 签约放款未回证原因报表一 按经办行、合作方、合作项目名称、未办抵押原因统计
* 作 者: leonwoo
* 开发日期: 2010/01/16
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
    <script language="javascript" src="miscQueryList01.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
    <script language="javascript" src="/UI/support/common.js"></script>
    <script language="javascript" src="/UI/support/DataWindow.js"></script>

    <LINK href="/css/newccb.css" type="text/css" rel="stylesheet">

</head>
<body onload="formInit()" bgcolor="#ffffff" class="Bodydefault">
<%--     <div class="title">
       <br>
       按经办行、合作方、合作项目名称、未办抵押原因统计:<br>
       </div>--%>
<fieldset style="padding:40px 25px 0px 25px;margin:0px 20px 0px 20px">
    <legend>查询条件</legend>
    <br>
    <table border="0" cellspacing="0" cellpadding="0" width="100%">
        <form id="queryForm" name="queryForm">
            <!-- 组合查询统计类型一 -->
            <input type="hidden" value="miscRpt01" id="rptType" name="rptType"/>
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
        <H2>[签约放款未回证明细表，按经办机构统计]</H2>
    </DIV>
    <div class="help-info">
        <ul>
            <li>可实现按经办行、合作项目、未办妥抵押原因统计某一时间段内签约放款已放款未回证的清单.</li>
            <li>某一时间段是指进入抵押流程的时间段，而非PMIS系统中的开户日期期间.</li>
            <li>统计类别包括签约放款和组合签约放款两类.</li>
            <li>不输入抵押接收起始日期，系统默认为统计当前数据库中全部符合条件的信息数据.</li>
            <li>统计表以经办机构的机构编号排序.</li>
        </ul>
    </div>
</div>

</body>
</html>
