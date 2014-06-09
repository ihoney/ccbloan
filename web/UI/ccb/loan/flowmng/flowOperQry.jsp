<!--
/*********************************************************************
* 功能描述: 流程处理综合查询
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

    //流程基本信息表
    DBGrid dbGrid = new DBGrid();
    dbGrid.setGridID("flowInfoTab");
    dbGrid.setGridType("edit");
    String infoSql = "select " +
            "       (select opername from ptoper where operid = d.operid) as opername," +
            "       (select roledesc from ptrole where roleid = (select min(roleid) from ptoperrole where operid = d.operid and roleid like 'WF%')) as roledesc," +
            "       d.operdate," +
            "       d.opertime," +
            "       d.flowstat," +
            "       d.remark," +
            "       a.flowsn as keycode," +
            "       decode(b.loanid, null, a.cust_name, b.cust_name) cust_name," +
            "       decode(b.loanid, null, a.rt_orig_loan_amt, b.rt_orig_loan_amt) rt_orig_loan_amt," +
            "       decode(b.loanid, null, a.rt_term_incr, b.rt_term_incr)  rt_term_incr," +
            "       (select deptname from ptdept where deptid = decode(b.loanid, null, a.bankid, b.bankid)) as bankname," +
            "       (select prommgr_name  from ln_prommgrinfo where prommgr_id = decode(b.loanid, null, a.custmgr_id, b.custmgr_id)) as custmgr_name," +
            "       (select deptname from ptdept where deptid = decode(b.loanid, null, a.cust_bankid, c.cust_bankid)) as cust_bankname," +
            "       (select opername from ptoper where operid = decode(b.loanid, null, a.realcustmgr_id, c.custmgr_id)) as realcustmgr_name," +
            "       (select  code_desc  from ln_odsb_code_desc where code_type_id='053' and code_id = c.ln_typ) as ln_typ" +
            "  from ln_archive_info a, ln_loanapply b, ln_promotioncustomers c, ln_archive_flow d " +
            "  where 1 = 1" +
            "   and d.flowsn = a.flowsn" +
            "   and a.loanid = b.loanid(+)" +
            "   and a.loanid = c.loanid(+)" +
            " ";

    infoSql += "  and exists (select  1 from (select deptid from ptdept start with deptid = '" + omgr.getOperator().getDeptid() + "' connect by prior deptid = parentdeptid)  where a.bankid = deptid) ";

    dbGrid.setfieldSQL(infoSql);

    dbGrid.setField("操作人员", "center", "5", "opername", "true", "0");
    dbGrid.setField("岗位名称", "center", "5", "roledesc", "true", "0");
    dbGrid.setField("交接日期", "center", "5", "operdate", "true", "0");
    dbGrid.setField("交接时间", "center", "5", "opertime", "true", "0");
    dbGrid.setField("处理状态", "dropdown", "5", "flowstat", "true", "ARCHIVEFLOW");
    dbGrid.setField("操作说明", "center", "10", "remark", "true", "0");

    dbGrid.setField("业务流水号", "center", "5", "keycode", "false", "-1");
    dbGrid.setField("借款人", "center", "5", "cust_name", "true", "0");
    dbGrid.setField("贷款金额", "money", "5", "rt_orig_loan_amt", "true", "0");
    dbGrid.setField("贷款期限", "center", "5", "rt_term_incr", "false", "0");
    dbGrid.setField("经办机构", "center", "5", "bankname", "true", "0");
    dbGrid.setField("营销经理", "center", "5", "custmgr_name", "true", "0");
    dbGrid.setField("经营中心", "center", "5", "cust_bankname", "true", "0");
    dbGrid.setField("客户经理", "center", "5", "realcustmgr_name", "true", "0");
    //dbGrid.setField("贷款种类", "center", "5", "ln_typ", "true", "0");

    dbGrid.setWhereStr(" and d.operid ='" +  omgr.getOperator().getOperid()   +"'  order by d.operdate desc,d.opertime desc ");
    dbGrid.setpagesize(10);
    dbGrid.setdataPilotID("datapilot");
    dbGrid.setbuttons("导出Excel=expExcel,moveFirst,prevPage,nextPage,moveLast");


%>
<html>

<head>

    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>贷款信息</title>

    <script language="javascript" src="/UI/support/pub.js"></script>
    <script language="javascript" src="/UI/support/DataWindow.js"></script>
    <script language="javascript" src="/js/basic.js"></script>
    <script language="javascript" src="/js/xmlHttp.js"></script>
    <script language="javascript" src="/js/dbgrid.js"></script>
    <script language="javascript" src="/js/dbutil.js"></script>
    <script language="javascript" src="flowOperQry.js"></script>

</head>
<body bgcolor="#ffffff" onLoad="body_resize()" onResize="body_resize();" class="Bodydefault">

<form id="queryForm" name="queryForm">
    <fieldset style="padding: 15px">
        <legend style="margin-bottom: 10px">查询条件</legend>
        <table width="100%" cellspacing="0" border="0">

            <input type="hidden" id="recversion" value=""/>
            <input type="hidden" id="operid" value="<%=omgr.getOperator().getOperid()%>"/>
            <input type="hidden" id="deptid" value="<%=omgr.getOperator().getDeptid()%>"/>
            <input type="hidden" id="busiNode" name="busiNode" value=""/>
            <tr>
                <td width="15%" nowrap="nowrap" class="lbl_right_padding">经营中心</td>
                <td width="35%" class="data_input">
                    <%
                        ZtSelect zs = new ZtSelect("CUST_BANKID", "", "");
                        zs.setSqlString("select deptid, deptname  from ptdept where FILLSTR10='3'"
                                + " start with deptid = '" + omgr.getOperator().getDeptid() + "'"
                                + " connect by prior deptid = parentdeptid order by deptid");
                        zs.addAttr("style", "width: 90%");
                        zs.addAttr("fieldType", "text");
                        zs.addAttr("onchange", "reSelectCustBank()");
                        zs.addOption("", "");
                        zs.addAttr("isNull", "false");
                        out.print(zs);
                    %>
                </td>
                <td width="15%" nowrap="nowrap" class="lbl_right_padding">操作人员</td>
                <td width="35%" class="data_input">
                    <%
                        zs = new ZtSelect("REALCUSTMGR_ID", "", "");
                        zs.addAttr("style", "width: 90%");
                        zs.addAttr("fieldType", "text");
                        zs.addAttr("isNull", "false");
                        zs.addOption("", "");
                        out.print(zs);
                    %>
                </td>
            </tr>
            <tr>
                <td width="15%" nowrap="nowrap" class="lbl_right_padding">起始操作日期</td>
                <td width="30%" class="data_input"><input type="text" id="STARTDATE" name="STARTDATE" value=""
                                                          onClick="WdatePicker()"
                                                          fieldType="date"
                                                          style="width:90% ">
                </td>
                <td width="15%" nowrap="nowrap" class="lbl_right_padding">截止操作日期</td>
                <td width="35%" class="data_input"><input type="text" id="ENDDATE" name="ENDDATE"
                                                          onClick="WdatePicker()"
                                                          fieldType="date"
                                                          style="width:90% " >
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
                           onmouseout="button_onmouseout()" type="button" value="检索" onclick="onSearch();">
                    <input name="" class="buttonGrooveDisable" type="reset" value="重填" onmouseover="button_onmouseover()" onmouseout="button_onmouseout()">
                </td>
            </tr>
        </table>
    </fieldset>
</form>

<fieldset>
    <LEGEND> 贷款申请资料信息列表</LEGEND>
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
