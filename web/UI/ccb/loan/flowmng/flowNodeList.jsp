<!--
/*********************************************************************
* 功能描述: 贷款申请接收挂起处理
* 作 者: zr
* 开发日期: 2013/03/10
* 修 改 人:
* 修改日期:
***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK" %>
<%@include file="/global.jsp" %>

<%@ page import="com.ccb.dao.*" %>
<%
    // 用户对象
    PTOPER oper = null;
    // 客户经理ID
    String custmgrId = "";

    // 初始化页面
    LNARCHIVEINFO bean = new LNARCHIVEINFO();
    OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);

    //List
    DBGrid dbGrid = new DBGrid();
    dbGrid.setGridID("loanTab");
    dbGrid.setGridType("edit");
    String commSql = "select " +
            "  c.cust_name, " +
            " (select roledesc from ptrole where roleid = b.roleid) as roledesc," +
            "       a.operdate," +
            "       a.opertime," +
            "       (select opername from ptoper where operid = a.operid) as opername," +
            "       a.flowstat," +
            "       a.remark" +
            "  from ln_archive_flow a" +
            "  left join ptoperrole b" +
            "    on a.operid = b.operid " +
            "  left join ln_archive_info c" +
            "    on a.flowsn = c.flowsn" +
            " where " +
            "   b.roleid =" +
            "       (select min(roleid) from ptoperrole where operid = a.operid and roleid like 'WF%') ";
    //" and a.flowsn = '" + omgr.getOperatorId() +"'";
    dbGrid.setWhereStr(" and 1=1 order by a.operdate desc, opertime desc");
    dbGrid.setfieldSQL(commSql);

    dbGrid.setField("借款人", "center", "5", "cust_name", "true", "0");
    dbGrid.setField("岗位名称", "center", "5", "roledesc", "true", "0");
    dbGrid.setField("交接日期", "center", "5", "operdate", "true", "0");
    dbGrid.setField("交接时间", "center", "5", "opertime", "true", "0");
    dbGrid.setField("操作人员", "center", "5", "opername", "true", "0");
    dbGrid.setField("处理状态", "dropdown", "5", "flowstat", "true", "ARCHIVEFLOW");
    dbGrid.setField("操作说明", "center", "15", "remark", "true", "0");

    dbGrid.setpagesize(30);
    dbGrid.setdataPilotID("datapilot");
    dbGrid.setbuttons("moveFirst,prevPage,nextPage,moveLast");
%>
<html>

<head>

    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>贷款信息</title>

    <script language="javascript" src="/UI/support/pub.js"></script>
    <script language="javascript" src="/UI/support/tabpane.js"></script>
    <script language="javascript" src="/UI/support/common.js"></script>
    <script language="javascript" src="/UI/support/DataWindow.js"></script>
    <script language="javascript" src="flowNodeList.js"></script>

</head>
<%--<body onload="formInit();" class="Bodydefault">--%>
<body bgcolor="#ffffff" onLoad="body_resize()" onResize="body_resize();" class="Bodydefault">

<form id="queryForm" name="queryForm">
    <fieldset style="padding: 15px">
        <legend style="margin-bottom: 10px">业务流程接收挂起处理</legend>
        <table width="100%" cellspacing="0" border="0">

            <input type="hidden" id="recversion" value=""/>
            <input type="hidden" id="af_recversion" value=""/>
            <input type="hidden" id="af_pkid" value=""/>
            <input type="hidden" id="deptid" value="<%=omgr.getOperator().getDeptid()%>"/>
            <input type="hidden" id="busiNode" name="busiNode" value=""/>
            <tr>
                <td width="10%" nowrap="nowrap" class="lbl_right_padding">业务流水号</td>
                <td width="90%" class="data_input" colspan="3">
                    <textarea id="FLOWSN" name="FLOWSN" rows="10" value="" style="width:96%" textLength="5000" isNull="false">
                    </textarea>
                </td>
                </td>
            </tr>
            <tr>
                <td width="15%" nowrap="nowrap" class="lbl_right_padding">业务处理流程状态</td>
                <td width="35%" class="data_input" colspan="3">
                    <input id="FLOWSTAT1" type="radio" checked="checked" name="FLOWSTAT" value="10"/>正常接收
                    <input id="FLOWSTAT2" type="radio" name="FLOWSTAT" value="20"/>处理挂起
            </tr>
            <tr>
                <td width="15%" nowrap="nowrap" class="lbl_right_padding">业务处理流程备注</td>
                <td width="35%" class="data_input" colspan="3">
                    <textarea id="AF_REMARK" name="AF_REMARK" rows="15" value="" style="width:96%" textLength="500">
                    </textarea>
                </td>

            </tr>

        </table>
    </fieldset>

    <fieldset>
        <table width="100%" class="title1" cellspacing="0">
            <tr>
                <td align="center">
                    <!--增加，修改-->
                    <input id="savebut" class="buttonGrooveDisable" onmouseover="button_onmouseover()"
                           onmouseout="button_onmouseout()" type="button" value="提交" onclick="saveClick();">
                </td>
            </tr>
        </table>
    </fieldset>
</form>

<fieldset>
    <table width="100%">
        <tr>
            <td><%=dbGrid.getDBGrid()%>
            </td>
        </tr>
    </table>
</fieldset>
<FIELDSET>
    <table width="100%" class="title1">
        <tr>
            <td align="right"><%=dbGrid.getDataPilot()%>
            </td>
        </tr>
    </table>
</FIELDSET>
</body>
</html>
