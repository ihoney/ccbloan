<%@page contentType="text/html; charset=GBK" %>
<%@page import="com.ccb.util.CcbLoanConst" %>
<%@include file="/global.jsp" %>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title></title>

    <script language="javascript" src="insuranceRtnPaperList.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
    <script language="javascript" src="/UI/support/suggest/js/ajaxSuggestions.js"></script>
    <style type="text/css" media="screen">
        @import url("/UI/support/suggest/css/ajax-suggestions.css");
    </style>
    <script type="text/javascript">

    </script>
</head>
<%
    OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
    String deptId = omgr.getOperator().getPtDeptBean().getDeptid();

    DBGrid dbGrid = new DBGrid();
    dbGrid.setGridID("loanRegistedTab");
    dbGrid.setGridType("edit");

    String sql = " select t.mortid,t.loanid,t.insuranceid,t.documentid,t.insurancests,t.paperrtndate " +
            " from ln_insurance t  left join ln_loanapply a on t.loanid=a.loanid where 1=1 ";
    dbGrid.setfieldSQL(sql);

    dbGrid.setField("抵押编号", "center", "8", "mortid", "true", "0");
    dbGrid.setField("贷款申请序号", "text", "12", "loanid", "true", "0");
    dbGrid.setField("保单号", "text", "8", "insuranceid", "true", "0");
    dbGrid.setField("档案编号", "text", "8", "documentid", "true", "0");
    dbGrid.setField("入库状态", "dropdown", "8", "INSURANCESTS", "true", "INSURANCESTS");
    dbGrid.setField("入库日期", "center", "8", "paperrtndate", "true", "0");
    dbGrid.setWhereStr(" and a.bankid in(select deptid from ptdept start with deptid='" + omgr.getOperator().getDeptid() + "' connect by prior deptid=parentdeptid) order by t.paperrtndate, a.bankid, t.mortid ");

    dbGrid.setpagesize(50);
    dbGrid.setdataPilotID("datapilot");
    dbGrid.setbuttons("入库登记=editRecord,moveFirst,prevPage,nextPage,moveLast");
%>
<body bgcolor="#ffffff" onload="body_resize()" onresize="body_resize();" class="Bodydefault">

<fieldset>
    <legend>
        查询条件
    </legend>
    <table border="0" cellspacing="0" cellpadding="0" width="100%">
        <form id="queryForm" name="queryForm">
            <tr height="20">

                <td width="10%" align="right" nowrap="nowrap" class="lbl_right_padding">
                    抵押编号
                </td>
                <td width="20%" align="right" nowrap="nowrap" class="data_input">
                    <input type="text" id="mortid" name="mortid" style="width:90%">
                           <%--class="ajax-suggestion url-getPull.jsp">--%>
                </td>

                <td width="10%" nowrap="nowrap" class="lbl_right_padding">入库状态</td>
                <td width="20%" nowrap="nowrap" class="data_input">
                    <%
                        ZtSelect zs = new ZtSelect("INSURANCESTS", "INSURANCESTS", "");
                        zs.addAttr("style", "width: 90%");
                        zs.addAttr("fieldType", "text");
                        zs.addOption("", "");
                        zs.addAttr("isNull", "false");
                        out.print(zs);
                    %>
                </td>
                <td width="10%" nowrap="nowrap" class="lbl_right_padding">机构</td>
                <td width="30%" nowrap="nowrap" class="data_input">
                    <%
                        zs = new ZtSelect("bankid", "", omgr.getOperator().getDeptid());
                        zs.setSqlString("select deptid, LPad('&nbsp;', (level - 1) * 36, '&nbsp;') || deptname  from ptdept"
                                + " start with deptid = '" + omgr.getOperator().getDeptid() + "'"
                                + " connect by prior deptid = parentdeptid");
                        zs.addAttr("style", "width: 90%");
                        zs.addAttr("fieldType", "text");
                        zs.addAttr("isNull", "false");
                        out.print(zs);
                    %>
                </td>

                <td align="center" nowrap="nowrap">
                    <input name="cbRetrieve" type="button" class="buttonGrooveDisable" id="button"
                           onClick="cbRetrieve_Click(document.queryForm)" onMouseOver="button_onmouseover()"
                           onMouseOut="button_onmouseout()" value="检索">
                    <input name="Input" class="buttonGrooveDisable" type="reset" value="重填"
                           onMouseOver="button_onmouseover()" onMouseOut="button_onmouseout()">
                </td>
            </tr>
        </form>
    </table>
</fieldset>
<fieldset>
    <legend>
        抵押信息
    </legend>
    <table width="100%">
        <tr>
            <td>
                <%=dbGrid.getDBGrid()%>
            </td>
        </tr>
    </table>
</fieldset>
<FIELDSET>
    <LEGEND>
        操作
    </LEGEND>
    <table width="100%" class="title1">
        <tr>
            <td align="right">
                <%=dbGrid.getDataPilot()%>
            </td>
        </tr>
    </table>
</FIELDSET>

<div id="search-result-suggestions">
    <div id="search-results">
    </div>
</div>
</body>
</html>
