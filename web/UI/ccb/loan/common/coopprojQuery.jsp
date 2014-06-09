<!--
/*********************************************************************
* 功能描述: 查询合作项目代号
***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK" %>
<%@include file="/global.jsp" %>
<%@page import="pub.platform.security.OperatorManager" %>
<%@page import="pub.platform.form.config.SystemAttributeNames" %>
<%@page import="pub.platform.db.DBGrid" %>
<%@page import="pub.platform.html.ZtSelect" %>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title></title>
    <script language="javascript" src="coopprojQuery.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>

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

    //test
    ConnectionManager cm = ConnectionManager.getInstance();
    DatabaseConnection dc = cm.get();

    StringBuilder deptAll = new StringBuilder(" ");
    try {
        RecordSet chrs = dc.executeQuery("select deptid from ptdept start with deptid='" + omgr.getOperator().getDeptid() + "' connect by prior deptid=parentdeptid");
        while (chrs != null && chrs.next()) {
            deptAll.append("'" + chrs.getString("deptid") + "',");
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        cm.release();
    }

    deptAll = deptAll.deleteCharAt(deptAll.length() - 1);

    DBGrid dbGrid = new DBGrid();
    dbGrid.setGridID("coopprojTable");
    dbGrid.setGridType("edit");

    String sql = "select proj_nbxh," +
            //"(select enuitemlabel from ptenudetail where enutype='COOPAGREEMENTCD' and enuitemvalue=a.AGREEMENTCD)||AGREEMENTNO as AGREEMENTCD," +
            //"otherpromise," +
            "proj_no,  " +
            "proj_name," +
            "proj_name_abbr," +
            "corpname," +
            //"(select enuitemlabel from ptenudetail where enutype='RELEASECONDCD' and enuitemvalue=a.RELEASECONDCD)as RELEASECONDCD," +
            //"MAXLNPERCENT," +
            //"coopperiod, " +
            //"COOPLIMITAMT," +
            "(select deptname from ptdept where deptid=a.bankid)as bankid " +
            "from ln_coopproj a where 1=1  " +
            " ";

    dbGrid.setfieldSQL(sql);

    dbGrid.setField("内部序号", "center", "10", "proj_nbxh", "false", "-1");
    //dbGrid.setField("合作协议", "text", "24", "agreementcd", "true", "0");
    //dbGrid.setField("其他特殊约定", "text", "10", "otherpromise", "true", "0");
    dbGrid.setField("合作项目编号", "center", "14", "proj_no", "true", "0");
    dbGrid.setField("合作项目名称", "text", "14", "proj_name", "true", "0");
    dbGrid.setField("合作项目简称", "text", "8", "proj_name_abbr", "true", "0");
    dbGrid.setField("合作机构名称", "text", "14", "corpname", "true", "0");
    //dbGrid.setField("约定放款方式", "center", "8", "releasecondcd", "true", "0");
    //dbGrid.setField("最高贷款比例", "number", "8", "maxlnpercent", "true", "0");
    //dbGrid.setField("合作期限(年)", "number", "8", "coopperiod", "true", "0");
    //dbGrid.setField("合作额度", "number", "8", "cooplimitamt", "true", "0");
    dbGrid.setField("经办行", "center", "10", "bankid", "true", "0");
    dbGrid.setWhereStr(" and a.bankid in(" + deptAll + ") order by proj_no asc ");
    dbGrid.setpagesize(50);
    dbGrid.setdataPilotID("datapilot");

    dbGrid.setbuttons("查看项目=query,moveFirst,prevPage,nextPage,moveLast");
%>
<body bgcolor="#ffffff" onLoad="body_resize()" onResize="body_resize();" class="Bodydefault">
<fieldset>
    <legend> 查询条件</legend>
    <table border="0" cellspacing="0" cellpadding="0" width="100%">
        <form id="queryForm" name="queryForm">
            <!-- 编号  该隐藏字段是为了删除之用 -->
            <input type="hidden" id="proj_nbxh" value="">
            <!-- 系统日志表使用 -->
            <input type="hidden" id="busiNode"/>
            <tr>
                <td width="20%" class="lbl_right_padding"> 合作项目简称</td>
                <td width="30%" align="right" nowrap="nowrap" class="data_input">
                    <input type="text" id="proj_name_abbr" size="30" style="width:90% ">
                </td>
                <td width="20%" align="right" nowrap="nowrap" class="lbl_right_padding"> 合作项目名称</td>
                <td width="30%" align="right" nowrap="nowrap"
                    class="data_input"><%--<input type="text" id="proj_name" size="40" class="ajax-suggestion url-getPull.jsp">--%>
                    <input type="text" id="proj_name" size="60" style="width:90% ">
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" nowrap="nowrap" class="lbl_right_padding"> 合作机构名称</td>
                <td width="30%" align="right" nowrap="nowrap" class="data_input"><input type="text" id="corpname"
                                                                                        size="60" style="width:90% ">
                </td>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">是否到期</td>
                <td width="30%" class="data_input"><%
                    ZtSelect zs = new ZtSelect("maturityflag", "coopmaturityflag", "");
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
                    zs.addOption("", "");
                    out.print(zs);
                %>
                </td>
                <td  align="right" nowrap="nowrap"><input name="cbRetrieve" type="button"
                                          id="button" onClick="queryClick()" value="  检索  ">
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" nowrap="nowrap" class="lbl_right_padding"> 经办行</td>
                <td width="30%" class="data_input"><%
                    zs = new ZtSelect("bankid", "", "");
                    zs.setSqlString("select deptid, LPad('&nbsp;', (level - 1) * 36, '&nbsp;') || deptname  from ptdept"
                            + " start with deptid = '" + omgr.getOperator().getDeptid() + "'"
                            + " connect by prior deptid = parentdeptid");
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
                    out.print(zs);
                %>
                </td>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">经营中心</td>
                <td width="30%" class="data_input"><%
                    zs = new ZtSelect("cust_bankid", "", "");
                    zs.setSqlString("select deptid, deptname  from ptdept where FILLSTR10='3'"
                            + " start with deptid = '" + omgr.getOperator().getDeptid() + "'"
                            + " connect by prior deptid = parentdeptid  order by deptid");
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
                    zs.addOption("", "");
                    out.print(zs);
                %>
                <td width="10%" align="right" nowrap="nowrap"><input name="Input" type="reset" value="  重填  ">
            </td>
            </tr>
        </form>
    </table>
</fieldset>
<fieldset>
    <legend> 合作项目信息</legend>
    <table width="100%">
        <tr>
            <td><%=dbGrid.getDBGrid()%></td>
        </tr>
    </table>
</fieldset>
<FIELDSET>
    <LEGEND>操作</LEGEND>
    <table width="100%" class="title1">
        <tr>
            <td align="right"><%=dbGrid.getDataPilot()%></td>
        </tr>
    </table>
</FIELDSET>
</body>
</html>
