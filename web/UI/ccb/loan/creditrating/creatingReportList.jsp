<%@page contentType="text/html; charset=GBK" %>
<%@include file="/global.jsp" %>

<%
    OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
%>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>资信评定报告</title>
    <script language="javascript" src="creatingReportList.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
    <script type="text/javascript">
        function queryClick() {
            var countDateBegVal = document.getElementById("countDateBeg").value;
            var countDateEndVal = document.getElementById("countDateEnd").value;
            var deptidVal = document.getElementById("deptid").value;
            window.showModalDialog("/servlet/StatisticsServlet?countDateBegVal=" + countDateBegVal + "&countDateEndVal=" + countDateEndVal + "&deptidVal=" + deptidVal, null, "dialogWidth:700px;status:no;");
        }
    </script>
</head>
<body bgcolor="#ffffff" class="Bodydefault">
<fieldset>
    <legend> 查询条件</legend>
    <table border="0" cellspacing="0" cellpadding="0" width="100%">
        <form id="queryForm" name="queryForm">
            <input type="hidden" id="busiNode"/>
            <tr>
                <td width="15%" class="lbl_right_padding">统计起始日期</td>
                <td width="15%" align="right" nowrap="nowrap" class="data_input">
                    <input type="text" id="countDateBeg" size="30" value=""
                           onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'countDateEnd\')}'})"
                           style="width:90% ">
                </td>
                <td width="15%" align="right" nowrap="nowrap" class="lbl_right_padding">统计截止日期</td>
                <td width="15%" align="right" nowrap="nowrap" class="data_input">
                    <input type="text" id="countDateEnd" size="60" value=""
                           onFocus="WdatePicker({minDate:'#F{$dp.$D(\'countDateBeg\')}'})"
                           style="width:90% ">
                </td>
                <td width="15%" align="right" nowrap="nowrap" class="lbl_right_padding">经办行</td>
                <td width="25%" class="data_input"><%
                    ZtSelect zs = new ZtSelect("deptid", "deptid", "");
                    zs.setSqlString("select deptid, LPad('&nbsp;', (level - 1) * 36, '&nbsp;') || deptname  from ptdept"
                            + " start with deptid = '" + omgr.getOperator().getDeptid() + "'"
                            + " connect by prior deptid = parentdeptid");
                    zs.addAttr("style", "width: 70%");
                    zs.addOption("", "");
                    zs.addAttr("fieldType", "text");
                    out.print(zs);
                %>
                </td>
            </tr>
        </form>
    </table>
</fieldset>

<FIELDSET>
    <LEGEND> 操作</LEGEND>
    <table width="100%" class="title1" cellspadding="2">
        <tr>
            <td align="right" nowrap="nowrap">
                <input name="cbRetrieve" type="button" class="buttonGrooveDisable" id="button"
                       onClick="queryClick();" onMouseOver="button_onmouseover()" onMouseOut="button_onmouseout()"
                       value="浏 览">
            </td>
            <td align="left">
                <button id="outputReport"
                        onclick="window.open('/servlet/ReportCountExcelServlet?countDateBegVal='+document.getElementById('countDateBeg').value+'&countDateEndVal='+document.getElementById('countDateEnd').value+'&deptidVal='+document.getElementById('deptid').value, null, null);">
                    输出统计表
                </button>
            </td>
        </tr>
    </table>
</FIELDSET>
</body>
</html>
