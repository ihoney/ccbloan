<!--
/*********************************************************************
* 功能描述: 系统日志
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
    <script language="javascript" src="promotionList.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
</head>
<%
    OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
//    String deptId = omgr.getOperator().getPtDeptBean().getDeptid();
//    String

    DBGrid dbGrid = new DBGrid();
    dbGrid.setGridID("promotionTab");
    dbGrid.setGridType("edit");

    //只能编辑那些未做过抵押登记的
    String sql = "select t.PROMCUST_NO,t.cust_name,CUST_ID," +
            " (select code_desc from ln_odsb_code_desc where code_type_id='053' and code_id = t.ln_typ) as ln_typ," +
            " t.rt_orig_loan_amt,RT_TERM_INCR,(select deptname from ptdept where deptid=t.bankid)as deptname," +
            " t.prommgr_name,status,CUST_PHONE,OPERDATE " +
            " from ln_promotioncustomers t where status=0 " +
            " and t.bankid in(select deptid from ptdept start with deptid='" + omgr.getOperator().getDeptid() + "' connect by prior deptid=parentdeptid) ";
    dbGrid.setfieldSQL(sql);
    dbGrid.setField("客户编号", "text", "2", "PROMCUST_NO", "false", "-1");
    dbGrid.setField("客户姓名", "center", "8", "cust_name", "true", "0");
    dbGrid.setField("证件号码", "center", "14", "CUST_ID", "true", "0");
    dbGrid.setField("贷款种类", "center", "12", "ln_typ", "true", "0");
    dbGrid.setField("贷款金额", "money", "10", "rt_orig_loan_amt", "true", "0");
    dbGrid.setField("贷款期限", "center", "8", "RT_TERM_INCR", "true", "0");
    dbGrid.setField("营销机构", "center", "10", "deptname", "true", "0");
    dbGrid.setField("营销经理", "center", "8", "prommgr_name", "true", "0");;
    dbGrid.setField("审核状态", "dropdown", "8", "status", "true", "RELEASECHECK");
    dbGrid.setField("客户电话", "text", "9", "CUST_PHONE", "true", "0");
    dbGrid.setField("提交时间", "text", "14", "OPERDATE", "true", "0");
    dbGrid.setWhereStr(" order by OPERDATE desc");
    dbGrid.setpagesize(50);
    dbGrid.setdataPilotID("datapilot");
    dbGrid.setbuttons("导出Excel=excel,添加=appendRecord,修改=editRecord,moveFirst,prevPage,nextPage,moveLast");
%>
<body bgcolor="#ffffff" onLoad="body_resize()" onResize="body_resize();" class="Bodydefault">
<fieldset>
    <legend> 查询条件</legend>
    <table border="0" cellspacing="0" cellpadding="0" width="100%">
        <form id="queryForm" name="queryForm">
            <tr height="20">
                <td width="10%" align="right" nowrap="nowrap" class="lbl_right_padding">
                    借款人姓名
                </td>
                <td width="20%" align="right" nowrap="nowrap" class="data_input">
                    <input type="text" id="cust_name" name="cust_name" style="width:90%">
                </td>

                <td width="10%" nowrap="nowrap" class="lbl_right_padding">机构</td>
                <td width="20%" nowrap="nowrap" class="data_input">
                    <%
                        ZtSelect zs = new ZtSelect("bankid", "", omgr.getOperator().getDeptid());
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
