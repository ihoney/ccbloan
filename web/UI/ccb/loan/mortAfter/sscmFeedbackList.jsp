<%@ page import="com.ccb.util.CcbLoanConst" %>
<!--
/*********************************************************************
* 功能描述: 单方撤押反馈    单方撤押(SingleSideCancelMort)状态 10:已单方撤押 20:未撤押
* 开发日期: 2013/05/22
***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK" %>
<%@include file="/global.jsp" %>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title></title>

    <script language="javascript" src="sscmFeedbackList.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
    <script language="javascript" src="/UI/support/common.js"></script>
    <script language="javascript" src="/UI/support/DataWindow.js"></script>

    <script language="javascript" src="/UI/support/suggest/js/ajaxSuggestions.js"></script>
    <style type="text/css" media="screen">
        @import url("/UI/support/suggest/css/ajax-suggestions.css");
    </style>

    <script type="text/javascript">
        // 把pulldown值复制到input中
        function setPullToInput(elm) {
            document.getElementById("cust_name").value = elm.innerText;
            document.getElementById("cust_name").focus();
        }

    </script>
</head>
<%
    OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
    String deptId = omgr.getOperator().getPtDeptBean().getDeptid();

    DBGrid dbGrid = new DBGrid();
    dbGrid.setGridID("mainTab");
    dbGrid.setGridType("edit");

    String sql = "select b.recVersion, a.nbxh, b.MORTECENTERCD,(select deptname from ptdept where deptid=a.bankid) as deptname," +
            "a.loanid,a.cust_name,a.RT_ORIG_LOAN_AMT,b.mortid,b.documentid,"
            + " b.mortregstatus, b.CLRPAPERDATE, b.CLRREASONCD, b.CLRREASONREMARK "
            + " from ln_loanapply a,ln_mortinfo b where  "
            + " a.loanid = b.loanid and b.mortstatus='" + CcbLoanConst.MORT_FLOW_CLEARED + "' "
            + " and SSCM_STATUS is  null ";
    dbGrid.setfieldSQL(sql);

    dbGrid.setField("版本号", "text", "4", "recVersion", "false", "0");
    dbGrid.setField("nbxh", "text", "4", "nbxh", "false", "0");
    dbGrid.setField("交易中心", "dropdown", "6", "MORTECENTERCD", "true", "MORTECENTERCD");
    dbGrid.setField("机构", "center", "10", "deptname", "true", "0");
    dbGrid.setField("贷款申请序号", "center", "12", "loanid", "true", "0");
    dbGrid.setField("借款人姓名", "text", "6", "cust_name", "true", "0");
    dbGrid.setField("贷款金额", "money", "8", "RT_ORIG_LOAN_AMT", "true", "0");
    dbGrid.setField("抵押编号", "center", "6", "mortid", "true", "-1");
    dbGrid.setField("档案编号", "center", "6", "DOCUMENTID", "true", "0");
    dbGrid.setField("抵押状态", "dropdown", "6", "mortregstatus", "true", "MORTREGSTATUS");
    dbGrid.setField("取证日期", "text", "8", "CLRPAPERDATE", "true", "0");
    dbGrid.setField("取证原因", "dropdown", "8", "CLRREASONCD", "true", "CLRREASONCD");
    dbGrid.setField("取证备注", "text", "12", "CLRREASONREMARK", "true", "0");

    dbGrid.setWhereStr(" 1!=1 ");

    dbGrid.setpagesize(50);
    dbGrid.setdataPilotID("datapilot");
    dbGrid.setCheck(true);
    dbGrid.setbuttons("查看贷款=loanQuery,查看抵押=query,办理结果反馈=batchEdit,moveFirst,prevPage,nextPage,moveLast");
%>
<body bgcolor="#ffffff" onload="body_resize()" onresize="body_resize();" class="Bodydefault">

<fieldset>
    <legend>
        查询条件
    </legend>
    <table border="0" cellspacing="0" cellpadding="0" width="100%">
        <form id="queryForm" name="queryForm">
        <!-- 报表使用 -->
        <input type="hidden" id="expressType" name="expressType" value=""/>
            <tr height="20">
                <td width="20%" align="right" nowrap="nowrap" class="lbl_right_padding">
                    借款人姓名
                </td>
                <td width="30%" align="right" nowrap="nowrap" class="data_input">
                    <input type="text" id="cust_name" name="cust_name" style="width:90%">
                </td>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">交易中心</td>
                <td width="30%" nowrap="nowrap" class="data_input">
                    <%
                        ZtSelect zs = new ZtSelect("mortecentercd", "mortecentercd", "");
                        zs.addAttr("style", "width: 90%");
                        zs.addAttr("fieldType", "text");
                        zs.addOption("", "");
                        out.print(zs);
                    %>
                </td>
                <td align="center" nowrap="nowrap">
                    <input name="cbRetrieve" type="button" class="buttonGrooveDisable" id="button"
                           onClick="cbRetrieve_Click(document.queryForm)" onMouseOver="button_onmouseover()"
                           onMouseOut="button_onmouseout()" value="检索">
                </td>
            </tr>
            <tr height="20">
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">经办机构</td>
                <td width="30%" nowrap="nowrap" class="data_input">
                    <%
                        zs = new ZtSelect("bankid", "", omgr.getOperator().getDeptid());
                        zs.setSqlString("select deptid, LPad('&nbsp;', (level - 1) * 36, '&nbsp;') || deptname  from ptdept"
                                + " start with deptid = '" + omgr.getOperator().getDeptid() + "'"
                                + " connect by prior deptid = parentdeptid");
                        zs.addAttr("style", "width: 90%");
                        zs.addAttr("fieldType", "text");
                        out.print(zs);
                    %>
                </td>
                <td width="20%" align="right" nowrap="nowrap" class="lbl_right_padding">
                    结清取证原因备注
                </td>
                <td width="30%" align="right" nowrap="nowrap" class="data_input">
                    <input type="text" id="clrreasonremark" name="clrreasonremark" style="width:90%" value="单方撤押">
                </td>

                <td align="center" nowrap="nowrap">
                    <input name="clear" type="button" class="buttonGrooveDisable"
                           onClick="clear_Click(document.queryForm)" onMouseOver="button_onmouseover()"
                           onMouseOut="button_onmouseout()" value="清空">
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
