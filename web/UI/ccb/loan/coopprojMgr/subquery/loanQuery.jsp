<!--
/*********************************************************************
* 功能描述: 贷款保证金明细情况查询
* 作 者:
* 开发日期: 2010/01/16
* 修 改 人:
* 修改日期:
* 版 权: 公司
***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK" %>
<%@page import="com.ccb.util.CcbLoanConst" %>
<%@include file="/global.jsp" %>

<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title></title>

    <script language="javascript" src="loanQuery.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
</head>
<%
        String proj_nbxh = "";
    if (request.getParameter("proj_nbxh") != null) {
        proj_nbxh = request.getParameter("proj_nbxh");
    }
    OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
    String deptId = omgr.getOperator().getPtDeptBean().getDeptid();

    DBGrid dbGrid = new DBGrid();
    dbGrid.setGridID("loanRegistedTab");
    dbGrid.setGridType("edit");

    // 右连接，以抵押信息表为主表
    String sql = "select " +
            "       (select deptname from ptdept where deptid=a.bankid)as bankid ," +
            "       c.corpname," +
            "       c.proj_name," +
            "       a.cust_name," +
            "       a.rt_orig_loan_amt," +
            "       (select code_desc from ln_odsb_code_desc where code_type_id='053' and code_id=a.LN_TYP) as ln_typ_name," +
            "       c.assuamtpercent," +
            "       (a.rt_orig_loan_amt * c.assuamtpercent/100) as assuamttemp," +
            "       c.assuamt," +
            "       0 as assuacctbal," +
            "       0 as oweassuamt," +
//            "       c.bankflag," +
//            "       a.proj_no," +
            "       b.mortid," +
//            "       a.loanid," +
            "       a.nbxh," +
            "       c.proj_nbxh" +
            "  from ln_loanapply a, ln_mortinfo b, ln_coopproj c" +
            " where a.loanid = b.loanid" +
            "   and a.proj_no = c.proj_no" +
//            "   and (b.mortstatus = '10' or b.mortstatus = '20')" +
            "   and c.proj_nbxh ='" + proj_nbxh + "' " +
			"  ";

    dbGrid.setfieldSQL(sql);

//    dbGrid.setField("交易中心", "dropdown", "10", "MORTECENTERCD", "true", "MORTECENTERCD");
    dbGrid.setField("机构", "center", "12", "bankid", "true", "0");
    dbGrid.setField("合作方名称", "text", "25", "corpname", "true", "0");
    dbGrid.setField("合作项目", "text", "30", "proj_name", "true", "0");
    dbGrid.setField("借款人姓名", "center", "15", "cust_name", "true", "0");
    dbGrid.setField("贷款金额", "money", "15", "rt_orig_loan_amt", "true", "0");
    dbGrid.setField("贷款种类", "center", "15", "ln_typ_name", "true", "0");
    dbGrid.setField("保证金比例", "money", "12", "assuamtpercent", "true", "0");
    dbGrid.setField("应交保证金", "money", "12", "assuamttemp", "true", "0");
    dbGrid.setField("保证金账号", "center", "20", "assuamt", "true", "0");
    dbGrid.setField("保证金账户余额", "money", "15", "assuacctbal", "true", "0");
    dbGrid.setField("欠交保证金", "money", "15", "oweassuamt", "true", "0");
//    dbGrid.setField("项目开发贷款", "dropdown", "15", "bankflag", "true", "BANKFLAG");
//    dbGrid.setField("合作项目编号", "text", "15", "proj_no", "true", "0");
    dbGrid.setField("抵押编号", "text", "10", "mortid", "false", "0");
//    dbGrid.setField("贷款申请号", "text", "15", "loanid", "true", "0");
    dbGrid.setField("贷款内部序号", "text", "12", "nbxh", "false", "0");
    dbGrid.setField("项目内部序号", "text", "12", "proj_nbxh", "false", "0");

//    dbGrid.setWhereStr(" order by b.mortdate desc,a.cust_py asc ");
    dbGrid.setWhereStr(" and a.bankid in(select deptid from ptdept start with deptid='"+omgr.getOperator().getDeptid()+"' connect by prior deptid=parentdeptid) order by a.bankid, c.proj_no, a.loanid ");

    dbGrid.setpagesize(50);
    dbGrid.setdataPilotID("datapilot");
    dbGrid.setbuttons("导出Excel=excel,查看贷款=loanQuery,查看抵押=query,查看项目=projQuery,moveFirst,prevPage,nextPage,moveLast");
%>
<body bgcolor="#ffffff" onload="body_resize()" onresize="body_resize();" class="Bodydefault">

<fieldset>
    <legend>
        查询条件
    </legend>
    <table border="0" cellspacing="0" cellpadding="0" width="100%">
        <form id="queryForm" name="queryForm">
            <input type="hidden" id="mortID" name="mortID" value="">
            <input type="hidden" id="loanID" name="loanID" value="">
            
            <tr height="20">
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">机构</td>
                <td width="30%" nowrap="nowrap" class="data_input">
                    <%
                        ZtSelect zs = new ZtSelect("bankid", "", omgr.getOperator().getDeptid());
                        zs.setSqlString("select deptid, LPad('&nbsp;', (level - 1) * 36, '&nbsp;') || deptname  from ptdept"
                                + " start with deptid = '" + omgr.getOperator().getDeptid() + "'"
                                + " connect by prior deptid = parentdeptid");
                        zs.addAttr("style", "width: 90%");
                        zs.addAttr("fieldType", "text");
                        out.print(zs);
                    %>
                </td>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">放款方式</td>
                <td width="30%" nowrap="nowrap" class="data_input" >
                    <%
                        zs = new ZtSelect("releasecondcd", "releasecondcd", "");
                        zs.addAttr("style", "width: 90%");
                        zs.addAttr("fieldType", "text");
                        //zs.addAttr("isNull","false");
                        zs.addOption("", "");
                        out.print(zs);
                    %>
                </td>


            <td align="center" nowrap="nowrap">
                <input name="cbRetrieve" type="button" class="buttonGrooveDisable" id="button"
                       onClick="cbRetrieve_Click(document.queryForm)" onMouseOver="button_onmouseover()"
                       onMouseOut="button_onmouseout()" value="检索">
            </td>
            </tr>

            <tr>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">保证金比例是否为零</td>
                <td width="30%" class="data_input"><%
                    zs = new ZtSelect("booltype", "booltype", "");
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
                    //zs.addAttr("isNull","false");
                    zs.addOption("", "");
                    out.print(zs);
                %>
                </td>

                <td width="20%" nowrap="nowrap" class="lbl_right_padding">贷款种类</td>
                <td width="30%" nowrap="nowrap" class="data_input">
                    <%
                        zs = new ZtSelect("ln_typ", "", "");
                        zs.setSqlString("select code_id,code_desc from ln_odsb_code_desc where code_type_id='053' order by code_id");
                        zs.addAttr("style", "width: 90%");
                        zs.addAttr("fieldType", "text");
                        zs.addOption("", "");
                        out.print(zs);
                    %>
                </td>

                <%--

                                <td width="10%" align="right" nowrap="nowrap" class="lbl_right_padding">
                                    借款人姓名
                                </td>
                                <td width="20%" align="right" nowrap="nowrap" class="data_input">
                                    <input type="text" id="cust_name" name="cust_name" style="width:90%"
                                           class="ajax-suggestion url-getPull.jsp">
                                </td>

                                <td width="10%" nowrap="nowrap" class="lbl_right_padding">交易中心</td>
                                <td width="20%" nowrap="nowrap" class="data_input">
                                    <%
                                         zs = new ZtSelect("mortecentercd", "mortecentercd", "");
                                        zs.addAttr("style", "width: 90%");
                                        zs.addAttr("fieldType", "text");
                                        zs.addOption("", "");
                                        zs.addAttr("isNull", "false");
                                        out.print(zs);
                                    %>
                                </td>

                --%>


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
        详细信息
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
