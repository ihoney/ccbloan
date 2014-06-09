<!--
/*********************************************************************
* 功能描述: 个贷客户列表
* 修改人: nanmeiying
* 修改日期: 2013/09/01
***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK" %>
<%@include file="/global.jsp" %>
<%@page import="pub.platform.db.DBGrid" %>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>操作日志</title>
    <script language="javascript" src="operLogQry.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
</head>
<%
    DBGrid dbGrid = new DBGrid();
    dbGrid.setGridID("creditraTable");
    dbGrid.setGridType("edit");
    String sql = "select a.creditratingno,decode(a.creattype,'0','普通评信','1','非普通评信') as creattype,a.opername,a.opertime,a.olddate,a.newdate from ln_creatlog a where 1=1 ";
    dbGrid.setfieldSQL(sql);
    dbGrid.setField("资信评定号", "center", "1", "creditratingno", "true", "-1");
    dbGrid.setField("评定类型", "center", "1", "creattype", "true", "-1");
    dbGrid.setField("操作人", "center", "1", "opername", "true", "0");
    dbGrid.setField("操作时间", "center", "1", "opertime", "true", "0");
    dbGrid.setField("旧有效期", "center", "1", "olddate", "true", "0");
    dbGrid.setField("新有效期", "center", "1", "newdate", "true", "0");
    dbGrid.setWhereStr(" order by opertime desc ");
    dbGrid.setpagesize(50);
    dbGrid.setdataPilotID("datapilot");
    dbGrid.setbuttons("moveFirst,prevPage,nextPage,moveLast");

%>
<body bgcolor="#ffffff" onLoad="body_resize()" onResize="body_resize();" class="Bodydefault">
<fieldset>
    <legend> 查询条件</legend>
    <table border="0" cellspacing="0" cellpadding="0" width="100%">
        <form id="queryForm" name="queryForm">
            <!-- 系统日志表使用 -->
            <input type="hidden" id="busiNode"/>
            <input type="hidden" id="pkid" name="pkid" value="">
            <tr>
                <td width="10%" class="lbl_right_padding">资信评定号</td>
                <td width="15%" align="right" nowrap="nowrap" class="data_input">
                    <input type="text" id="creditratingno" size="30" style="width:90% ">
                </td>
                <td width="10%" align="right" nowrap="nowrap" class="lbl_right_padding">操作人</td>
                <td width="15%" align="right" nowrap="nowrap" class="data_input">
                    <input type="text" id="opername" size="60" style="width:90% ">
                </td>
                <td width="10%" align="right" nowrap="nowrap" class="lbl_right_padding">评定类型</td>
                <td width="15%" align="right" nowrap="nowrap" class="data_input">
                    <select id="creattype">
                        <option value=""></option>
                        <option value="0">普通评定</option>
                        <option value="1">非普通评定</option>
                    </select>
                </td>
                <td width="25%" align="center" nowrap="nowrap">
                    <input name="cbRetrieve" type="button" class="buttonGrooveDisable" id="button"
                           onClick="queryClick();" onMouseOver="button_onmouseover()" onMouseOut="button_onmouseout()"
                           value="检 索">
                </td>
            </tr>
        </form>
    </table>
</fieldset>
<fieldset>
    <legend> 操作记录</legend>
    <table width="100%">
        <tr>
            <td><%=dbGrid.getDBGrid()%>
            </td>
        </tr>
    </table>
</fieldset>
<FIELDSET>
    <LEGEND> 操作</LEGEND>
    <table width="100%" class="title1">
        <tr>
            <td align="right"><%=dbGrid.getDataPilot()%>
            </td>
        </tr>
    </table>
</FIELDSET>
</body>
</html>
