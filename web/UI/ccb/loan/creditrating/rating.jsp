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
<%@page import="pub.platform.system.manage.dao.PtDeptBean" %>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>终评录入</title>
    <script language="javascript" src="rating.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
</head>
<%
    DBGrid dbGrid = new DBGrid();
    dbGrid.setGridID("creditraTable");
    dbGrid.setGridType("edit");
    String sql = "select a.creditratingno,a.idno,a.custname,a.basescore,a.baselevel,a.iniscore,a.inilevel,a.iniamt,a.inioperid,a.inidate,a.inibegdate,a.inienddate,a.inideptid,a.finscore,a.finlevel,a.finamt,a.finoperid,a.findate,a.finbegdate,a.finenddate,a.findeptid,a.timelimit,a.docid from ln_pscoredetail a where 1=1";
    dbGrid.setfieldSQL(sql);
    dbGrid.setField("资信评定号", "center", "9", "creditratingno", "true", "-1");
    dbGrid.setField("证件号码", "center", "8", "idno", "true", "0");
    dbGrid.setField("客户名称", "text", "5", "custname", "true", "0");
    dbGrid.setField("基本得分", "number", "5", "basescore", "true", "0");
    dbGrid.setField("基本等级", "center", "5", "baselevel", "true", "0");
    dbGrid.setField("初评得分", "number", "5", "iniscore", "true", "0");
    dbGrid.setField("初评等级", "center", "5", "inilevel", "true", "0");
    dbGrid.setField("初评额度(万元)", "number", "6", "iniamt", "true", "0");
    dbGrid.setField("初评操作员", "center", "7", "inioperid", "true", "0");
    dbGrid.setField("初评日期", "center", "6", "inidate", "true", "0");
    dbGrid.setField("初评有效期起日", "center", "8", "inibegdate", "true", "0");
    dbGrid.setField("初评有效期止日", "center", "8", "inienddate", "true", "0");
    dbGrid.setField("初评机构号", "center", "6", "inideptid", "true", "0");
    dbGrid.setField("终评得分", "center", "5", "finscore", "true", "0");
    dbGrid.setField("终评等级", "center", "5", "finlevel", "true", "0");
    dbGrid.setField("终评额度(万元)", "number", "6", "finamt", "true", "0");
    dbGrid.setField("终评操作员", "center", "6", "finoperid", "true", "0");
    dbGrid.setField("终评日期", "center", "5", "findate", "true", "0");
    dbGrid.setField("终评有效期起日", "center", "8", "finbegdate", "true", "0");
    dbGrid.setField("终评有效期止日", "center", "8", "finenddate", "true", "0");
    dbGrid.setField("终评机构号", "center", "6", "findeptid", "true", "0");
    dbGrid.setField("期限(月)", "number", "4", "timelimit", "true", "0");
    dbGrid.setField("档案号", "center", "9", "docid", "true", "0");
    dbGrid.setWhereStr(" order by inidate desc ");
    dbGrid.setpagesize(50);
    dbGrid.setdataPilotID("datapilot");
    dbGrid.setbuttons("导出Excel=excel,终评录入=levelRating,moveFirst,prevPage,nextPage,moveLast");
%>
<body bgcolor="#ffffff" onLoad="body_resize()" onResize="body_resize();" class="Bodydefault">
<fieldset>
    <legend> 查询条件</legend>
    <table border="0" cellspacing="0" cellpadding="0" width="100%">
        <form id="queryForm" name="queryForm">
            <!-- 系统日志表使用 -->
            <input type="hidden" id="busiNode"/>
            <tr>
                <td width="20%" class="lbl_right_padding">资信评定号</td>
                <td width="30%" align="right" nowrap="nowrap" class="data_input">
                    <input type="text" id="creditratingno" size="30" style="width:90% ">
                </td>
                <td width="20%" align="right" nowrap="nowrap" class="lbl_right_padding">证件号码</td>
                <td width="30%" align="right" nowrap="nowrap" class="data_input">
                    <input type="text" id="idno" size="60" style="width:90% ">
                </td>
            </tr>
            <tr>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">客户姓名</td>
                <td width="30%" class="data_input">
                    <input type="text" id="custname" size="60" style="width:90% ">
                </td>
                <td width="20%" align="right" nowrap="nowrap" class="lbl_right_padding"> 初评机构号</td>
                <td width="30%" class="data_input">
                    <input type="text" id="inideptid" size="60" value="" style="width:90% ">
                </td>
                <td width="10%" align="right" nowrap="nowrap">
                    <input name="cbRetrieve" type="button" class="buttonGrooveDisable" id="button"
                           onClick="queryClick();" onMouseOver="button_onmouseover()" onMouseOut="button_onmouseout()"
                           value="检 索">
                </td>
            </tr>
            <tr>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">初评操作员</td>
                <td width="30%" class="data_input">
                    <input type="text" id="inioperid" size="60" style="width:90% ">
                </td>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">终评操作员</td>
                <td width="30%" class="data_input">
                    <input type="text" id="finoperid" size="60" style="width:90% ">
                </td>
                <td width="10%" align="right" nowrap="nowrap">
                    <input name="Input" class="buttonGrooveDisable" type="reset" value="重 填"
                           onMouseOver="button_onmouseover()" onMouseOut="button_onmouseout()">
                </td>
            </tr>
        </form>
    </table>
</fieldset>
<fieldset>
    <legend> 合作项目信息</legend>
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
