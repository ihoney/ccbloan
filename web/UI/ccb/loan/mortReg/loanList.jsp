<!--
/*********************************************************************
* 功能描述: 抵押办妥前信息管理，未进行抵押登记的贷款列表
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
    <script language="javascript" src="loanList.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
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
    dbGrid.setGridID("loanTab");
    dbGrid.setGridType("edit");

    String sql = "select a.nbxh,a.loanid,a.cust_name,a.RT_ORIG_LOAN_AMT,a.CUST_OPEN_DT,a.APLY_DT,"
            + " (select deptname from ptdept where deptid=a.bankid) as deptname "
            + " from ln_loanapply a where "
            + "  not exists (select 1 from ln_mortinfo b where b.loanid=a.loanid)  "
            + " and ("
            + "(a.cust_open_dt >= '2010-01-01' or a.aply_dt >= '2010-01-01' ) "
            + " and a.loanstate <> '2' "
            + " and a.apprstate not in ('08', '09', '07') "
            + " or  a.aply_dt is null"
            + " )"
            + " and a.deptid is not null ";

    dbGrid.setfieldSQL(sql);

    dbGrid.setField("内部序号", "text", "8", "nbxh", "false", "-1");
    dbGrid.setField("贷款申请序号", "center", "12", "loanid", "true", "0");
    dbGrid.setField("借款人姓名", "text", "8", "cust_name", "true", "0");
    dbGrid.setField("贷款金额", "money", "8", "RT_ORIG_LOAN_AMT", "true", "0");
    dbGrid.setField("开户日期", "center", "8", "CUST_OPEN_DT", "true", "0");
    dbGrid.setField("申请日期", "center", "8", "APLY_DT", "true", "0");
    dbGrid.setField("机构", "center", "10", "deptname", "true", "0");
    //dbGrid.setField("文件是否显示", "dropdown", "8", "isvisibled", "true", "BOOLTYPE");
    //dbGrid.setField("放款形式", "dropdown", "8", "file_type", "true", "impawnLoanType");

    dbGrid.setWhereStr(" and a.bankid in(select deptid from ptdept start with deptid='" + omgr.getOperator().getDeptid() + "' connect by prior deptid=parentdeptid) order by a.CUST_OPEN_DT desc,APLY_DT desc,a.cust_py asc ");
    dbGrid.setpagesize(30);
    dbGrid.setdataPilotID("datapilot");
    dbGrid.setbuttons("查看贷款=query,添加抵押=appendRecod,moveFirst,prevPage,nextPage,moveLast");
%>
<body bgcolor="#ffffff" onLoad="body_resize()" onResize="body_resize();" class="Bodydefault">
<fieldset>
    <legend> 查询条件</legend>
    <table border="0" cellspacing="0" cellpadding="0" width="100%">
        <form id="queryForm" name="queryForm">
            <tr height="20">
                <td width="8%" nowrap="nowrap" class="lbl_right_padding">业务流水号</td>
                <td width="25%" class="data_input"><input type="text" id="FLOWSN" name="FLOWSN" value="" style="width:96% ">
                </td>

                <td width="5%" align="right" nowrap="nowrap" class="lbl_right_padding"> 借款人姓名</td>
                <td width="15%" align="right" nowrap="nowrap" class="data_input"><input type="text" id="cust_name"
                                                                                        name="cust_name"
                                                                                        style="width:96%"
                                                                                        class="ajax-suggestion url-getPull.jsp">
                </td>
                <td width="5%" nowrap="nowrap" class="lbl_right_padding">机构</td>
                <td width="20%" nowrap="nowrap" class="data_input"><%
                    ZtSelect zs = new ZtSelect("bankid", "", omgr.getOperator().getDeptid());
                    zs.setSqlString("select deptid, LPad('&nbsp;', (level - 1) * 36, '&nbsp;') || deptname  from ptdept"
                            + " start with deptid = '" + omgr.getOperator().getDeptid() + "'"
                            + " connect by prior deptid = parentdeptid");
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
                    out.print(zs);
                %>
                </td>
                <td align="center" nowrap="nowrap"><input name="cbRetrieve" type="button" class="buttonGrooveDisable"
                                                          id="button" onClick="cbRetrieve_Click(document.queryForm)"
                                                          onMouseOver="button_onmouseover()"
                                                          onMouseOut="button_onmouseout()" value="检索">
                    <input name="Input" class="buttonGrooveDisable" type="reset" value="重填"
                           onMouseOver="button_onmouseover()" onMouseOut="button_onmouseout()">
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
<div id="search-result-suggestions">
    <div id="search-results"></div>
</div>
</body>
</html>
