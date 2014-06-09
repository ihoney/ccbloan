<%--
  Created by IntelliJ IDEA.
  User: haiyuhuang
  Date: 11-7-29
  Time: 下午4:41
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=GBK" %>
<%@include file="/global.jsp" %>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title></title>
    <script language="javascript" src="coverrateList.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
</head>
<%
    OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
    String operid = omgr.getOperatorId();

    DBGrid dbGrid = new DBGrid();
    dbGrid.setGridID("deptTab");
    dbGrid.setGridType("edit");

    //只能编辑那些未做过抵押登记的
    String sql = "select t.deptid,t.deptname,t.filldbl2 from ptdept t" +
            " where " +
            " t.deptid in(select deptid from ptdept start with deptid='" + omgr.getOperator().getDeptid() + "' connect by prior deptid=parentdeptid) ";
    dbGrid.setfieldSQL(sql);
    dbGrid.setField("机构号","text","2","PROMCUST_NO","false","-1");
    dbGrid.setField("机构名", "center", "8", "deptname", "true", "0");
    dbGrid.setField("覆盖率(%)", "center", "14", "filldbl2", "true", "0");
    dbGrid.setWhereStr(" order by deptid");
//    dbGrid.setCheck(true);
    dbGrid.setpagesize(50);
    dbGrid.setdataPilotID("datapilot");
    dbGrid.setbuttons("导出Excel=excel,修改覆盖率=editRecord,moveFirst,prevPage,nextPage,moveLast");
%>
<body bgcolor="#ffffff" onLoad="body_resize()" onResize="body_resize();" class="Bodydefault">
<fieldset>
    <legend> 查询条件</legend>
    <table border="0" cellspacing="0" cellpadding="0" width="100%">
        <form id="queryForm" name="queryForm">
            <input type="hidden" id="hidoperid" value="<%=operid%>" />
            <tr height="20">

                <td width="10%" nowrap="nowrap" class="lbl_right_padding">机构</td>
                <td width="20%" nowrap="nowrap" class="data_input">
                    <%
                        ZtSelect zs = new ZtSelect("deptid", "", omgr.getOperator().getDeptid());
                        zs.setSqlString("select deptid, LPad('&nbsp;', (level - 1) * 36, '&nbsp;') || deptname  from ptdept"
                                + " start with deptid = '" + omgr.getOperator().getDeptid() + "'"
                                + " connect by prior deptid = parentdeptid");
                        zs.addAttr("style", "width: 90%");
                        zs.addAttr("fieldType", "text");
                        zs.addAttr("isNull", "false");
                        out.print(zs);
                    %>
                </td>
                <td align="center" nowrap="nowrap"><input name="cbRetrieve" type="button" class="buttonGrooveDisable"
                                                          id="button" onClick="cbRetrieve_Click(document.queryForm)"
                                                          value="检索">
                    <input name="Input" class="buttonGrooveDisable" type="reset" value="重填">
                </td>
            </tr>
        </form>
    </table>
</fieldset>
<fieldset>
    <legend> 贷款信息</legend>
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