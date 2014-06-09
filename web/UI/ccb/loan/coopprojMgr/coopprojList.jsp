<!--
/*********************************************************************
* 功能描述: 合作项目管理列表
* 作者:
* 开发日期: 2010/01/24
* 修改人:
* 修改日期:
* 版权:
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
    <script language="javascript" src="coopprojList.js"></script>
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
//         if ( isAutoRelease )
        cm.release();
    }

    deptAll = deptAll.deleteCharAt(deptAll.length() - 1);


    DBGrid dbGrid = new DBGrid();
    dbGrid.setGridID("coopprojTable");
    dbGrid.setGridType("edit");

    /*
       ?	合作协议种类
       ?	合作协议编号
       (?	其他情况  ?)
       ?	合作机构
       ?	合作项目名称
       ?	合作项目简称
       ?	约定放款方式
       ?	最高贷款比例
       ?	合作期限（具体日期）
       ?	合作额度
       ?	合作项目编号
       ?	经办行

        */

    String sql = "select proj_nbxh," +
//            "rownum," +
            "(select enuitemlabel from ptenudetail where enutype='COOPAGREEMENTCD' and enuitemvalue=a.AGREEMENTCD)||AGREEMENTNO as AGREEMENTCD," +
//            "AGREEMENTNO," +
            "otherpromise," +
            "corpname," +
            "proj_name," +
            "proj_name_abbr," +
            "(select enuitemlabel from ptenudetail where enutype='RELEASECONDCD' and enuitemvalue=a.RELEASECONDCD)as RELEASECONDCD," +
            "MAXLNPERCENT," +
            "coopperiod, " +
            "COOPLIMITAMT," +
            "proj_no,  " +
            "(select deptname from ptdept where deptid=a.bankid)as bankid," +
            "corpid,builaddr,inputdate,assustartdate,assuenddate,maxlnperiod," +
            "assuperiod,followupmortperiod,bankflag,devlnbankcd,DEVLNTIMELIMITTYE," +
            "devlnstartdate,devlnenddate,assuamtpercent,assuamt,presellid,adminacct," +
            "adminacctbank,APPRBILLCD,apprbillno,remarks " +
            "from ln_coopproj a where 1=1  " +
            " ";
//            " a.bankid in(select deptid from ptdept start with deptid='"+omgr.getOperator().getDeptid()+"' connect by prior deptid=parentdeptid) ";

//    sql = "select proj_nbxh,rownum,AGREEMENTCD,AGREEMENTNO,corpname,proj_name,proj_name_abbr, RELEASECONDCD,MAXLNPERCENT,coopperiod,COOPLIMITAMT,proj_no, bankid from (" + sql+" order by proj_no asc )";
    dbGrid.setfieldSQL(sql);

    dbGrid.setField("内部序号", "center", "10", "proj_nbxh", "false", "-1");
//    dbGrid.setField("序号", "center", "5", "rownum", "true", "0");
    dbGrid.setField("合作协议", "text", "24", "agreementcd", "true", "0");
//    dbGrid.setField("合作协议编号", "text", "10", "agreementno", "true", "0");
    dbGrid.setField("其他特殊约定", "text", "14", "otherpromise", "true", "0");
    dbGrid.setField("合作机构名称", "text", "18", "corpname", "true", "0");
    dbGrid.setField("合作项目名称", "text", "18", "proj_name", "true", "0");
    dbGrid.setField("合作项目简称", "text", "18", "proj_name_abbr", "true", "0");
    dbGrid.setField("约定放款方式", "center", "13", "releasecondcd", "true", "0");
    dbGrid.setField("最高贷款比例", "number", "10", "maxlnpercent", "true", "0");
    dbGrid.setField("合作期限(年)", "number", "10", "coopperiod", "true", "0");
    dbGrid.setField("合作额度", "number", "13", "cooplimitamt", "true", "0");
    dbGrid.setField("合作项目编号", "center", "16", "proj_no", "true", "0");
    dbGrid.setField("经办行", "center", "12", "bankid", "true", "0");
    dbGrid.setField("合作方编号", "center", "10", "corpid", "true", "0");
    dbGrid.setField("楼盘坐落位置", "center", "26", "builaddr", "true", "0");
    dbGrid.setField("录入日期", "center", "8", "inputdate", "true", "0");
    dbGrid.setField("被保证债权起始日期", "center", "8", "assustartdate", "true", "0");
    dbGrid.setField("被保证债权截止日期", "center", "8", "assuenddate", "true", "0");
    dbGrid.setField("最长贷款期限(年)", "center", "8", "maxlnperiod", "true", "0");
    dbGrid.setField("保证期间说明", "center", "28", "assuperiod", "true", "0");
    dbGrid.setField("后续抵押办理时限(天)", "center", "8", "followupmortperiod", "true", "0");
    dbGrid.setField("项目开发贷款", "dropdown", "10", "bankflag", "true", "BANKFLAG");
    dbGrid.setField("开发贷款贷款行", "center", "12", "devlnbankcd", "true", "0");
    dbGrid.setField("开发贷抵押办理时限方式", "dropdown", "10", "DEVLNTIMELIMITTYE", "true", "DEVLNTIMELIMITTYE");
    dbGrid.setField("开发贷款起始日期", "center", "8", "devlnstartdate", "true", "0");
    dbGrid.setField("开发贷款截止日期", "center", "8", "devlnenddate", "true", "0");
    dbGrid.setField("保证金比例(%)", "money", "8", "assuamtpercent", "true", "0");
    dbGrid.setField("保证金账号", "center", "12", "assuamt", "true", "0");
    dbGrid.setField("预售许可证号码", "center", "12", "presellid", "true", "0");
    dbGrid.setField("监管账户账号", "center", "12", "adminacct", "true", "0");
    dbGrid.setField("监管账户开户银行", "center", "12", "adminacctbank", "true", "0");
    dbGrid.setField("审批单类别", "dropdown", "9", "APPRBILLCD", "true", "COOPAPPRBILLCD");
    dbGrid.setField("审批单编号", "center", "9", "apprbillno", "true", "0");
    dbGrid.setField("备注", "center", "20", "remarks", "true", "0");
    dbGrid.setWhereStr(" and a.bankid in(" + deptAll + ") order by proj_no asc ");
    dbGrid.setpagesize(50);
    dbGrid.setdataPilotID("datapilot");

    String menutype = request.getParameter("menutype");
//    if (menutype == null) {
//        dbGrid.setbuttons("查看项目=query,新增项目=appendRecod,修改项目=editRecord,删除项目=deleteRecord,moveFirst,prevPage,nextPage,moveLast");
//    } else {
    if ("query".equals(menutype)) {
        dbGrid.setbuttons("导出Excel=excel,查看抵押=queryMort,查看项目=query,moveFirst,prevPage,nextPage,moveLast");
    } else {
        dbGrid.setbuttons("导出Excel=excel,查看抵押=queryMort,查看项目=query,新增项目=appendRecod,修改项目=editRecord,删除项目=deleteRecord,moveFirst,prevPage,nextPage,moveLast");
    }
//    }

%>
<body bgcolor="#ffffff" onLoad="body_resize()" onResize="body_resize();" class="Bodydefault">
<%--<div id="aa">--%>
<%--<br>--%>
<fieldset>
    <legend> 查询条件</legend>
    <%--<div class="queryPanalDiv">--%>
    <%--<div class="queryDiv">--%>
    <table border="0" cellspacing="0" cellpadding="0" width="100%">
        <form id="queryForm" name="queryForm">
            <!-- 编号  该隐藏字段是为了删除之用 -->
            <input type="hidden" id="proj_nbxh" value="">
            <!-- 系统日志表使用 -->
            <input type="hidden" id="busiNode"/>
            <tr>
                <td width="20%" class="lbl_right_padding"> 合作项目编号</td>
                <td width="30%" align="right" nowrap="nowrap"
                    class="data_input"><%--<input type="text" id="proj_name" size="40" class="ajax-suggestion url-getPull.jsp">--%>
                    <input type="text" id="proj_no" size="30" style="width:90% ">
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
                <td width="10%" align="right" nowrap="nowrap"><input name="cbRetrieve" type="button"
                                                                     class="buttonGrooveDisable" id="button"
                                                                     onClick="queryClick()"
                                                                     onMouseOver="button_onmouseover()"
                                                                     onMouseOut="button_onmouseout()" value="检 索">
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" nowrap="nowrap" class="lbl_right_padding"> 经办行</td>
                <td width="30%" class="data_input"><%
                    //                        zs = new ZtSelect("bankid", "", omgr.getOperator().getDeptid());
                    zs = new ZtSelect("bankid", "", "");
                    zs.setSqlString("select deptid, LPad('&nbsp;', (level - 1) * 36, '&nbsp;') || deptname  from ptdept"
                            + " start with deptid = '" + omgr.getOperator().getDeptid() + "'"
                            + " connect by prior deptid = parentdeptid");
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
                    out.print(zs);
                %>
                </td>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">约定放款方式</td>
                <td width="30%" class="data_input"><%
                    zs = new ZtSelect("releasecondcd", "releasecondcd", "");
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
                    //zs.addAttr("isNull","false");
                    zs.addOption("", "");
                    out.print(zs);
                %>
                </td>
                <td width="10%" align="right" nowrap="nowrap"><input name="Input"
                                                                     class="buttonGrooveDisable"
                                                                     type="reset"
                                                                     value="重 填"
                                                                     onMouseOver="button_onmouseover()"
                                                                     onMouseOut="button_onmouseout()">
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
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">项目开发贷款</td>
                <td width="30%" class="data_input"><%
                    zs = new ZtSelect("bankflag", "bankflag", "");
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
//                        zs.addAttr("isNull", "false");
                    zs.addOption("", "");
                    out.print(zs);
                %>
                </td>
            </tr>
            <tr>
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
                </td>
            </tr>
            <%--

                        <tr>
                            <td width="20%" nowrap="nowrap" class="lbl_right_padding">起始录入日期</td>
                            <td width="30%" class="data_input"><input type="text" id="inputdate1" name="inputdate1" value=""
                                                                      style="width:90%" onClick="WdatePicker()" fieldType="date"
                                    ></td>
                            <td width="20%" nowrap="nowrap" class="lbl_right_padding">截至录入日期</td>
                            <td width="30%" class="data_input"><input type="text" id="inputdate2" name="inputdate2" value=""
                                                                      style="width:90%" onClick="WdatePicker()" fieldType="date"
                                    ></td>
                        </tr>

            --%>
        </form>
    </table>
    <%--</div>--%>
    <%--</div>--%>
    <%--

                <div class="queryButtonDiv">
                    <table>
                        <tr>
                            <td width="10%" align="Right" nowrap="nowrap">
                                <input name="cbRetrieve" type="button" class="buttonGrooveDisable" id="button"
                                       onClick="queryClick()" onMouseOver="button_onmouseover()"
                                       onMouseOut="button_onmouseout()" value="&nbsp;&nbsp;&nbsp;检 索&nbsp;&nbsp;&nbsp;">
                                <input name="Input" class="buttonGrooveDisable" type="reset"
                                       value="&nbsp;&nbsp;&nbsp;重 填&nbsp;&nbsp;&nbsp;"
                                       onMouseOver="button_onmouseover()" onMouseOut="button_onmouseout()">
                            </td>
                        </tr>
                    </table>
                </div>

    --%>
</fieldset>
<%--<div class="listPanalDiv">--%>
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
