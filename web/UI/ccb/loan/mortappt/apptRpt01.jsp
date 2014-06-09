<!--
/*********************************************************************
* 功能描述: 抵押预约按抵押中心统计总数和明细
* 开发日期: 2013/06/22
***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK" %>
<%@page import="com.ccb.util.CcbLoanConst" %>
<%@include file="/global.jsp" %>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title></title>

    <script language="javascript" src="apptRpt01.js"></script>
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

    DBGrid dbGrid = new DBGrid();
    dbGrid.setGridID("mainTab");
    dbGrid.setGridType("edit");

    String sql = "select a.nbxh, b.mortecentercd, "
            + "     (select deptname from ptdept where deptid=a.bankid) as deptname,"
            + "     a.loanid,a.cust_name, "
            + "     (select code_desc as text  from ln_odsb_code_desc where code_type_id='053' and code_id = a.ln_typ) as ln_typ,"
            + "     a.RT_ORIG_LOAN_AMT, b.mortid,"
            + "     c.PROJ_NAME_ABBR, b.mortstatus, b.apptstatus,"
            + "     b.APPT_BIZ_CODE, (b.APPT_HDL_DATE||decode(b.APPT_HDL_TIME,'01','上午','下午')) APPT_HDL_DATE,  "
            + "     b.recVersion, b.FLOWSN, b.APPT_CONFIRM_RESULT, b.APPT_DATE_CONFIRM,b.APPT_FEEDBACK_RESULT  "
            + " from ln_loanapply a,ln_mortinfo b,ln_coopproj c  "
            + "  where a.loanid = b.loanid "
            + "   and a.proj_no = c.proj_no "
            + "   and b.apptstatus is not null and b.apptstatus >= '20' "
            + "   and b.APPT_VALID_FLAG = '1' " //有效预约
            + "";
    dbGrid.setfieldSQL(sql);

    dbGrid.setField("nbxh", "center", "0", "nbxh", "false", "0");
    dbGrid.setField("交易中心", "dropdown", "8", "MORTECENTERCD", "true", "MORTECENTERCD");
    dbGrid.setField("机构", "center", "10", "deptname", "true", "0");
    dbGrid.setField("贷款申请号", "text", "12", "loanid", "true", "0");
    dbGrid.setField("借款人", "center", "8", "cust_name", "true", "0");
    dbGrid.setField("贷款种类", "center", "10", "ln_typ", "true", "0");
    dbGrid.setField("贷款金额", "money", "10", "RT_ORIG_LOAN_AMT", "true", "0");
    dbGrid.setField("抵押编号", "center", "8", "mortid", "true", "-1");
    dbGrid.setField("项目简称", "center", "12", "PROJ_NAME", "true", "0");
    dbGrid.setField("抵押状态", "dropdown", "8", "MORTSTATUS", "true", "MORTSTATUS");
    dbGrid.setField("预约状态", "dropdown", "10", "APPTSTATUS", "true", "APPTSTATUS");
    dbGrid.setField("业务类型", "dropdown", "12", "APPT_BIZ_CODE", "true", "APPTBIZCODE");
    dbGrid.setField("预约时间", "center", "12", "APPT_HDL_DATE", "true", "0");
    // 该字段是批量更新防止并发问题关键字段，不能删除，且顺序号固定：11
    dbGrid.setField("版本号", "text", "4", "recVersion", "false", "0");
    dbGrid.setField("业务流水号", "center", "12", "FLOWSN", "false", "0");
    dbGrid.setField("确认结果", "dropdown", "8", "APPT_CONFIRM_RESULT", "true", "APPT_CONFIRM_RESULT");
    dbGrid.setField("确认日期", "center", "8", "APPT_DATE_CONFIRM", "true", "0");
    dbGrid.setField("办理结果", "dropdown", "10", "APPT_FEEDBACK_RESULT", "true", "APPT_FEEDBACK_RESULT");

    dbGrid.setWhereStr(" order by b.appt_date_apply desc, b.appt_time_apply desc, b.mortecentercd, a.bankid, b.mortid ");
    dbGrid.setpagesize(30);
    dbGrid.setdataPilotID("datapilot");
    dbGrid.setCheck(false);
    dbGrid.setbuttons("导出Excel=excel,查看贷款=loanQuery,查看抵押=query,moveFirst,prevPage,nextPage,moveLast");

    //汇总
    DBGrid sumDbGrid = new DBGrid();
    sumDbGrid.setGridID("sumTab");
    sumDbGrid.setGridType("edit");

    String sumSql = "select b.mortecentercd, count(*) as tot\n" +
            "  from ln_loanapply a, ln_mortinfo b\n" +
            " where a.loanid = b.loanid\n" +
            "   and b.apptstatus is not null\n" +
            "   and b.apptstatus >= '20'\n" +
            "   and b.APPT_VALID_FLAG = '1'\n" +
            " ";
    sumDbGrid.setfieldSQL(sumSql);

    sumDbGrid.setField("交易中心", "dropdown", "20", "MORTECENTERCD", "true", "MORTECENTERCD");
    sumDbGrid.setField("预约确认笔数合计", "center", "10", "tot", "true", "0");

    sumDbGrid.setWhereStr(" group by mortecentercd ");
    sumDbGrid.setpagesize(10);
    sumDbGrid.setdataPilotID("datapilot");
    sumDbGrid.setCheck(false);
    sumDbGrid.setbuttons("导出Excel=excel,moveFirst,prevPage,nextPage,moveLast");
%>
<body bgcolor="#ffffff" onload="body_resize()" onresize="body_resize();" class="Bodydefault">

<fieldset>
    <legend>
        查询条件
    </legend>
    <table border="0" cellspacing="0" cellpadding="0" width="100%">
        <form id="queryForm" name="queryForm">
            <input type="hidden" id="user_deptid" name="user_deptid"  value="<%=deptId%>"/>
            <tr height="20">
                <td width="10%" nowrap="nowrap" class="lbl_right_padding">交易中心</td>
                <td width="20%" nowrap="nowrap" class="data_input">
                    <%
                        ZtSelect zs = new ZtSelect("mortecentercd", "mortecentercd", "");
                        zs.addAttr("style", "width: 90%");
                        zs.addAttr("fieldType", "text");
                        zs.addOption("", "");
                        out.print(zs);
                    %>
                </td>
                <td width="10%" nowrap="nowrap" class="lbl_right_padding">预约起始日期</td>
                <td width="20%" class="data_input"><input type="text" id="STARTDATE" name="STARTDATE" value=""
                                                          onClick="WdatePicker()"
                                                          fieldType="date"
                                                          style="width:90% ">
                </td>
                <td width="10%" nowrap="nowrap" class="lbl_right_padding">预约截止日期</td>
                <td width="20%" class="data_input"><input type="text" id="ENDDATE" name="ENDDATE"
                                                          onClick="WdatePicker()"
                                                          fieldType="date"
                                                          style="width:90% " >
                </td>
                <td align="right" nowrap="nowrap">
                    <input name="cbRetrieve" type="button" class="buttonGrooveDisable" id="button" style="margin-right: 20px;margin-left: 20px;"
                           onClick="cbRetrieve_Click(document.queryForm)" onMouseOver="button_onmouseover()"
                           onMouseOut="button_onmouseout()" value="检索">
                </td>
            </tr>
        </form>
    </table>
</fieldset>
<fieldset>
    <legend>
        抵押预约信息
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
<fieldset>
    <legend>
        汇总统计信息
    </legend>
    <table width="100%">
        <tr>
            <td>
                <%=sumDbGrid.getDBGrid()%>
            </td>
        </tr>
    </table>
</fieldset>
<FIELDSET style="margin-top: 15px">
    <LEGEND>
        操作
    </LEGEND>
    <table width="100%" class="title1">
        <tr>
            <td align="right">
                <%=sumDbGrid.getDataPilot()%>
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
