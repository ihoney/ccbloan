<!--
/*********************************************************************
* 功能描述: 抵押办理预约申请
* 开发日期: 2013/05/22
***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK" %>
<%@page import="com.ccb.util.CcbLoanConst" %>
<%@include file="/global.jsp" %>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title></title>

    <script language="javascript" src="apptApplyList.js"></script>
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
    String deptId = omgr.getOperator().getDeptid();


    //判断是否个贷代理机构（个贷中心、个贷分中心、四个自办行）
    String ploanProxyDept = "0";
    ConnectionManager cm = ConnectionManager.getInstance();
    DatabaseConnection dc = cm.get();
    try {
        RecordSet chrs = dc.executeQuery("select count(*) as cnt from LN_MORTCENTER_APPT where deptid='" + deptId + "'");
        while (chrs != null && chrs.next()) {
            if (chrs.getInt(0) > 0) {
                ploanProxyDept = "1"; //个贷中心、个贷分中心、四个自办行
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        out.println("数据库处理错误" + e.getMessage());
        return;
    } finally {
        cm.release();
    }

    DBGrid dbGrid = new DBGrid();
    dbGrid.setGridID("mainTab");
    dbGrid.setGridType("edit");

    String sql = "select a.nbxh, b.mortecentercd, "
            + "     (select deptname from ptdept where deptid=a.bankid) as deptname,"
            + "     a.loanid,a.cust_name, "
            + "     (select code_desc as text  from ln_odsb_code_desc where code_type_id='053' and code_id = a.ln_typ) as ln_typ,"
            + "     a.RT_ORIG_LOAN_AMT, b.mortid,"
            + "     a.PROJ_NAME_ABBR, "
            + "     b.mortstatus, b.apptstatus,"
            + "     b.recVersion, b.FLOWSN, b.RELEASECONDCD "
            + " from (select t1.*, case t1.proj_no when null then  '' else (select proj_name_abbr from ln_coopproj where proj_no = t1.proj_no) end as proj_name_abbr from ln_loanapply t1) a,ln_mortinfo b  "
            + "  where a.loanid = b.loanid "
            + "   and (b.apptstatus is null or b.apptstatus = '01' or b.apptstatus = '02' or  b.apptstatus = '40' or  b.apptstatus = '90' or  b.apptstatus = '91')  "
            + " ";
/*
    String sql = "select a.nbxh, b.mortecentercd, "
            + "     (select deptname from ptdept where deptid=a.bankid) as deptname,"
            + "     a.loanid,a.cust_name, "
            + "     (select code_desc as text  from ln_odsb_code_desc where code_type_id='053' and code_id = a.ln_typ) as ln_typ,"
            + "     a.RT_ORIG_LOAN_AMT, b.mortid,"
            + "     c.PROJ_NAME_ABBR, "
            + "     b.mortstatus, b.apptstatus,"
            + "     b.recVersion, b.FLOWSN "
            + " from ln_loanapply a,ln_mortinfo b,ln_coopproj c  "
            + "  where a.loanid = b.loanid "
            + "   and a.proj_no = c.proj_no "
            + "   and (b.apptstatus is null or b.apptstatus = '01' or b.apptstatus = '02' or  b.apptstatus = '40')  "
            + " ";
*/
    dbGrid.setfieldSQL(sql);

    dbGrid.setField("nbxh", "center", "0", "nbxh", "false", "0");
    dbGrid.setField("交易中心", "dropdown", "6", "MORTECENTERCD", "true", "MORTECENTERCD");
    dbGrid.setField("机构", "center", "10", "deptname", "true", "0");
    dbGrid.setField("贷款申请号", "text", "12", "loanid", "true", "0");
    dbGrid.setField("借款人", "center", "6", "cust_name", "true", "0");
    dbGrid.setField("贷款种类", "center", "8", "ln_typ", "true", "0");
    dbGrid.setField("贷款金额", "money", "8", "RT_ORIG_LOAN_AMT", "true", "0");
    dbGrid.setField("抵押编号", "center", "6", "mortid", "true", "-1");
    dbGrid.setField("项目简称", "center", "10", "PROJ_NAME", "true", "0");
    dbGrid.setField("抵押状态", "dropdown", "8", "MORTSTATUS", "true", "MORTSTATUS");
    dbGrid.setField("预约状态", "dropdown", "8", "APPTSTATUS", "true", "APPTSTATUS");
    // 该字段是批量更新防止并发问题关键字段，不能删除，且顺序号固定：11
    dbGrid.setField("版本号", "text", "4", "recVersion", "false", "0");
    dbGrid.setField("业务流水号", "center", "12", "FLOWSN", "false", "0");
    dbGrid.setField("放款方式", "dropdown", "6", "RELEASECONDCD", "true", "RELEASECONDCD");

    dbGrid.setWhereStr(" and 1!=1 ");
    dbGrid.setpagesize(50);
    dbGrid.setdataPilotID("datapilot");
    dbGrid.setCheck(true);
    dbGrid.setbuttons("查看贷款=loanQuery,查看抵押=query,批量预约=batchEdit,moveFirst,prevPage,nextPage,moveLast");
%>
<body bgcolor="#ffffff" onload="body_resize()" onresize="body_resize();" class="Bodydefault">

<fieldset>
    <legend>
        查询条件
    </legend>
    <table border="0" cellspacing="0" cellpadding="0" width="100%">
        <form id="queryForm" name="queryForm">
            <!-- 报表使用 -->
            <input type="hidden" id="apptbizcode_tmp" name="apptbizcode_tmp" value=""/>
            <input type="hidden" id="user_deptid" name="user_deptid"  value="<%=deptId%>"/>
            <input type="hidden" id="ploanProxyDept" name="ploanProxyDept"  value="<%=ploanProxyDept%>"/>
            <tr height="20">
                <td width="10%" align="right" nowrap="nowrap" class="lbl_right_padding">
                    借款人姓名
                </td>
                <td width="15%" align="right" nowrap="nowrap" class="data_input">
                    <input type="text" id="cust_name" name="cust_name" style="width:90%">
                </td>
                <td width="10%" nowrap="nowrap" class="lbl_right_padding">交易中心</td>
                <td width="15%" nowrap="nowrap" class="data_input">
                    <%
                        ZtSelect zs;
                        if ("1".equals(ploanProxyDept)) {
                            zs = new ZtSelect("mortecentercd", "mortecentercd", "");
                            zs.setSqlString("select mortecentercd, (select t.enuitemlabel from PTENUDETAIL t where t.enutype = 'MORTECENTERCD' and t.enuitemvalue = mortecentercd) from LN_MORTCENTER_APPT where deptid='" + deptId + "' and typeflag='0' order by mortecentercd");
                        }else{
                            zs = new ZtSelect("mortecentercd", "mortecentercd", "MORTECENTERCD");
                        }
                        zs.addAttr("style", "width: 90%");
                        zs.addAttr("fieldType", "text");
                        zs.addOption("", "");
                        out.print(zs);
                    %>
                </td>
                <td width="10%" nowrap="nowrap" class="lbl_right_padding">经办机构</td>
                <td width="30%" nowrap="nowrap" class="data_input">
                    <%
                        if ("1".equals(ploanProxyDept)) {
                            zs = new ZtSelect("bankid", "", "371980000");
                            zs.setSqlString("select deptid, LPad('&nbsp;', (level - 1) * 36, '&nbsp;') || deptname  from ptdept"
                                    + " start with deptid = '" + "371980000" + "'"
                                    + " connect by prior deptid = parentdeptid");
                        }else{
                            zs = new ZtSelect("bankid", "", omgr.getOperator().getDeptid());
                            zs.setSqlString("select deptid, LPad('&nbsp;', (level - 1) * 36, '&nbsp;') || deptname  from ptdept"
                                    + " start with deptid = '" + deptId + "'"
                                    + " connect by prior deptid = parentdeptid");
                        }
                        zs.addAttr("style", "width: 90%");
                        zs.addAttr("fieldType", "text");
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
                <td width="10%" align="right" nowrap="nowrap" class="lbl_right_padding">
                    项目简称
                </td>
                <td width="20%" align="right" nowrap="nowrap" class="data_input">
                    <input type="text" id="proj_name_abbr" name="proj_name_abbr" style="width:90%">
                </td>
                <td width="10%" nowrap="nowrap" class="lbl_right_padding">业务类型</td>
                <td width="20%" nowrap="nowrap" class="data_input">
                    <%
                        zs = new ZtSelect("APPTBIZCODE", "APPTBIZCODE", "10");
                        zs.addAttr("style", "width: 90%");
                        zs.addAttr("fieldType", "text");
                        //zs.addOption("", "");
                        out.print(zs);
                    %>
                </td>
                <td width="10%" nowrap="nowrap"></td>
                <td width="20%" nowrap="nowrap"></td>

                <td align="center" nowrap="nowrap">
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
