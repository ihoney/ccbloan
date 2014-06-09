<!--
/*********************************************************************
* 功能描述: 抵押信息管理贷款详细页面
*
* 作 者: leonwoo
* 开发日期: 2010/01/16
* 修 改 人:
* 修改日期:
* 版 权: 公司
***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK" %>
<%@include file="/global.jsp" %>

<%@ page import="com.ccb.dao.*" %>
<%@ page import="com.ccb.util.*" %>

<%
    // 内部序号
    String nbxh = "";
    //业务流水号
    String flowsnHidden = "";
    // 操作类型
    String doType = "";
    // 用户对象
    PTOPER oper = null;
    // 客户经理ID-营销经理ID
    String custMgrID = "";
    //营销客户序号
    String promcust_no = "";
    //经营中心
    String custbankid = "";
    //客户经理id - 真正的客户经理ID 来自营销信息表
    String realcustMgrid = "";
    //客户姓名
    String custname = "";
    //经办行
    String bankid = "";


    if (request.getParameter("nbxh") != null)
        nbxh = request.getParameter("nbxh");
    if (request.getParameter("doType") != null){
        doType = request.getParameter("doType");
    }
    LNARCHIVEINFO info = null;

    if ("add".equalsIgnoreCase(doType)) {
        info = LNARCHIVEINFO.findFirst("where flowsn='" + nbxh + "'");
        if (info != null){
            custname = info.getCust_name();
            custMgrID = info.getCustmgr_id();
            bankid = info.getBankid();
        } else{
            info = new LNARCHIVEINFO();
        }
    } else {
        // 初始化页面
        LNLOANAPPLY bean = LNLOANAPPLY.findFirst("where loanid='" + nbxh + "'");
        if (bean != null) {
            LNPROMOTIONCUSTOMERS promBean = LNPROMOTIONCUSTOMERS.findFirst("where loanID='" + bean.getLoanid() + "'");
            if (promBean != null) {
                promcust_no = promBean.getPromcust_no();
                custbankid = promBean.getCust_bankid();
                realcustMgrid = promBean.getCustmgr_id();
                bankid = promBean.getBankid();
                custname = promBean.getCust_name();
            }
            custMgrID = bean.getCustmgr_id();
            StringUtils.getLoadForm(bean, out);
        }
    }
    flowsnHidden = nbxh;
    OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
    //取出用户的姓名
    if (info != null) {
        oper = PTOPER.findFirst("where operid='" + info.getOperid() + "'");
    }
    if (oper == null) {
        oper = new PTOPER();
    }

%>
<html>

<head>

    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>贷款信息</title>

    <script language="javascript" src="/UI/support/tabpane.js"></script>
    <script language="javascript" src="/UI/support/common.js"></script>
    <script language="javascript" src="/UI/support/DataWindow.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
    <script language="javascript" src="loanEditReg.js"></script>


</head>
<body onload="formInit();" class="Bodydefault">

<form id="editForm" name="editForm">
<fieldset style="padding: 15px">
    <legend style="margin-bottom: 10px">贷款基本信息</legend>
    <table width="100%" cellspacing="0" border="0">

        <input type="hidden" id="doType" value="<%=doType%>">
        <input type="hidden" id="recversion" value=""/>
        <input type="hidden" id="nbxh" value="<%=nbxh%>"/>
        <input type="hidden" id="flowsnHidden" value="<%=flowsnHidden%>"/>
        <input type="hidden" id="deptid" value="<%=omgr.getOperator().getDeptid()%>"/>
        <!-- 编辑的时候显示营销经理ID使用 -->
        <input type="hidden" id="custMgrID" value="<%=custMgrID%>"/>
        <!-- 编辑的时候显示客户经理ID使用 -->
        <input type="hidden" id="realcustMgrID" value="<%=realcustMgrid%>"/>
        <!-- 流水日志表使用 -->
        <input type="hidden" id="busiNode" name="busiNode" value=""/>
        <!-- 前营销客户信息序号 读取 -->
        <input type="hidden" id="prev_promcust_no" name="prev_promcust_no" value="<%=promcust_no%>"/>
        <tr>
            <td width="15%" nowrap="nowrap" class="lbl_right_padding">业务流水号</td>
            <td width="30%" class="data_input"><input type="text" id="FLOWSN" name="FLOWSN" value="<%=flowsnHidden%>"
                                                      textLength="100"
                                                      style="width:90% " isNull="true">
            </td>

            <td width="15%" nowrap="nowrap" class="lbl_right_padding">贷款申请号</td>
            <td width="30%" class="data_input" colspan="3"><input type="text" id="loanID" name="loanID" value=""
                                                                  intLength="24"
                                                                  style="width:90% " isNull="false"><span
                    class="red_star">*</span>
            </td>
        </tr>
        <tr>
            <td width="15%" nowrap="nowrap" class="lbl_right_padding">贷款人姓名</td>
            <td width="35%" class="data_input"><input type="text" id="CUST_NAME" name="CUST_NAME" style="width:90%"
                                                      value="<%=custname %>"
                                                      textLength="40" isNull="false"><span class="red_star">*</span>
            </td>
            <td width="15%" nowrap="nowrap" class="lbl_right_padding">贷款金额</td>
            <td width="35%" class="data_input"><input type="text" id="RT_ORIG_LOAN_AMT" name="RT_ORIG_LOAN_AMT" value=""
                                                      onblur="Txn_GotFocus(this);" style="width:90%" intLength="18"
                                                      floatLength="2"
                                                      isNull="false"><span class="red_star">*</span></td>

        </tr>
        <tr>
            <td width="15%" nowrap="nowrap" class="lbl_right_padding">经办行</td>
            <td width="35%" class="data_input">
                <%
                    ZtSelect zs = new ZtSelect("BANKID", "", bankid);
                    zs.setSqlString("select deptid, deptname  from ptdept"
                            + " start with deptid = '" + omgr.getOperator().getDeptid() + "'"
                            + " connect by prior deptid = parentdeptid  order by deptid");
                    //zs.setSqlString("select deptid, LPad('&nbsp;', (level - 1) * 36, '&nbsp;') || deptname  from ptdept"
                    //        + " start with deptid = '" + omgr.getOperator().getDeptid() + "'"
                    //        + " connect by prior deptid = parentdeptid");
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
                    zs.addAttr("onchange", "reSelect()");
                    //zs.setDefValue("371980000");
                    zs.addOption("", "");
                    zs.addAttr("isNull", "false");
                    out.print(zs);
                %><span class="red_star">*</span>
            </td>
            <td width="15%" nowrap="nowrap" class="lbl_right_padding">营销经理</td>
            <td width="35%" class="data_input">
                <%
                    zs = new ZtSelect("CUSTMGR_ID", "", custMgrID);
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
                    /*if (doType.equals("add") || doType.equals("edit")) {
                        zs.addAttr("onchange", "custMgrReSelect()");
                    }*/
//                    zs.addAttr("onchange", "promMgrReSelect()");
                    zs.addOption("", "");
                    zs.addAttr("isNull", "false");
                    out.print(zs);
                %><span class="red_star">*</span>
            </td>
        </tr>
        <tr>
            <td width="15%" nowrap="nowrap" class="lbl_right_padding">经营中心</td>
            <td width="35%" class="data_input">
                <%
                    zs = new ZtSelect("CUST_BANKID", "", custbankid);
                    zs.setSqlString("select deptid, deptname  from ptdept where FILLSTR10='3'"
                            + " start with deptid = '" + omgr.getOperator().getDeptid() + "'"
                            + " connect by prior deptid = parentdeptid order by deptid");
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
                    zs.addAttr("onchange", "reSelectCustBank()");
                    zs.addOption("", "");
                    zs.addAttr("isNull", "false");
                    out.print(zs);
                %><span class="red_star">*</span>
            </td>
            <td width="15%" nowrap="nowrap" class="lbl_right_padding">客户经理</td>
            <td width="35%" class="data_input">
                <%
                    zs = new ZtSelect("REALCUSTMGR_ID", "", "");
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
                    /*if (doType.equals("add") || doType.equals("edit")) {
                        zs.addAttr("onchange", "custMgrReSelect()");
                    }*/
                    zs.addAttr("isNull", "false");
                    zs.addOption("", "");
                    out.print(zs);
                %><span class="red_star">*</span>
            </td>
        </tr>
        <tr>
            <td width="15%" nowrap="nowrap" class="lbl_right_padding">贷款种类</td>
            <td width="35%" class="data_input">
                <%
                    zs = new ZtSelect("LN_TYP", "", "");
                    zs.setSqlString("select code_id as value ,code_desc as text  from ln_odsb_code_desc where code_type_id='053'");
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
                    zs.addAttr("isNull","false");
                    zs.addOption("", "");
                    out.print(zs);
                %><span class="red_star">*</span>
            </td>
            <td width="15%" nowrap="nowrap" class="lbl_right_padding">放款方式</td>
            <td width="35%" class="data_input">
                <%
                    zs = new ZtSelect("RELEASECONDCD", "RELEASECONDCD", "");
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
                    //zs.addAttr("isNull","false");
                    zs.addOption("", "");
                    out.print(zs);
                %>
            </td>
        </tr>
        <tr>
            <td width="15%" nowrap="nowrap" class="lbl_right_padding">合作项目编号</td>
            <td width="35%" class="data_input"><input type="text" id="PROJ_NO" name="PROJ_NO" value="" style="width:90%"
                                                      textLength="20"></td>

            <td width="15%" nowrap="nowrap" class="lbl_right_padding">合作方编号</td>
            <td width="35%" class="data_input"><input type="text" id="CORPID" name="CORPID" value="" style="width:90%"
                                                      textLength="20"></td>
        </tr>
        <tr>
            <td width="15%" nowrap="nowrap" class="lbl_right_padding">申请日期</td>
            <td width="35%" class="data_input"><input type="text" id="APLY_DT" name="APLY_DT" value="" style="width:90%"
                                                      onClick="WdatePicker()" fieldType="date"></td>

            <td width="15%" nowrap="nowrap" class="lbl_right_padding">开户日期</td>
            <td width="35%" class="data_input"><input type="text" id="CUST_OPEN_DT" name="CUST_OPEN_DT" value=""
                                                      style="width:90%" onClick="WdatePicker()" fieldType="date"></td>
        </tr>
    </table>
</fieldset>

<fieldset style="margin-top: 0px; padding: 15px">
    <legend style="margin-bottom: 10px">贷款附加信息</legend>
    <table width="100%" cellspacing="0" border="0">
        <tr>
            <td width="15%" nowrap="nowrap" class="lbl_right_padding">产品代码</td>
            <td width="35%" class="data_input">
                <%
                    zs = new ZtSelect("LN_PROD_COD", "", "");
                    zs.setSqlString("select code_id as value ,code_desc as text  from ln_odsb_code_desc where code_type_id='420'");
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
                    //zs.addAttr("isNull","false");
                    zs.addOption("", "");
                    out.print(zs);
                %>
            </td>
            <td width="15%" nowrap="nowrap" class="lbl_right_padding">贷款期限</td>
            <td width="35%" class="data_input"><input type="text" id="RT_TERM_INCR" name="RT_TERM_INCR" value=""
                                                      style="width:90%" intLength="12"></td>

        </tr>
        <tr>
            <td width="15%" nowrap="nowrap" class="lbl_right_padding">担保方式</td>
            <td width="35%" class="data_input">
                <%
                    zs = new ZtSelect("GUARANTY_TYPE", "", "");
                    zs.setSqlString("select t.source_cd,t.source_cd_desc from ln_odsb_std_code t where category_cd = 'ACC0600002' and system_id = '09'");
//                    zs.setSqlString("select t.ods_standard_cd as value,t.source_cd_desc as text from ln_odsb_std_code t where t.category_cd='ACC0600002' and t.system_id='15'");
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
                    //zs.addAttr("isNull","false");
                    zs.addOption("", "");
                    out.print(zs);
                %>
            </td>
            <td width="15%" nowrap="nowrap" class="lbl_right_padding">到期日期</td>
            <td width="35%" class="data_input"><input type="text" id="EXPIRING_DT" name="EXPIRING_DT" value=""
                                                      style="width:90%"
                                                      onClick="WdatePicker()" fieldType="date"></td>
        </tr>
        <tr>
            <td width="15%" nowrap="nowrap" class="lbl_right_padding">贷款账号</td>
            <td width="35%" class="data_input"><input type="text" id="LN_ACCT_NO" name="LN_ACCT_NO" value=""
                                                      style="width:90%"
                                                      intLength="30"></td>
            <td width="15%" nowrap="nowrap" class="lbl_right_padding">币种</td>
            <td width="35%" class="data_input">
                <%
                    zs = new ZtSelect("CURR_CD", "", "");
//                    zs.setSqlString("select code_id as value ,code_desc as text  from ln_odsb_code_desc where code_type_id='808'");
                    zs.setSqlString("select t.ods_standard_cd as value,t.source_cd_desc as text from ln_odsb_std_code t where t.category_cd='ACC1300012' and t.system_id='15'");
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
                    //zs.addAttr("isNull","false");
                    zs.addOption("", "");
                    out.print(zs);
                %>
            </td>
        </tr>
        <tr>
            <td width="15%" nowrap="nowrap" class="lbl_right_padding">还款方式</td>
            <td width="35%" class="data_input">
                <%
                    zs = new ZtSelect("PAY_TYPE", "", "");
                    zs.setSqlString("select t.ods_standard_cd as value,t.source_cd_desc as text from ln_odsb_std_code t where t.category_cd='ACC0600018' and t.system_id='15' ");
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
                    zs.addOption("", "");
                    out.print(zs);
                %>
            </td>
            <td width="15%" nowrap="nowrap" class="lbl_right_padding">执行利率</td>
            <td width="35%" class="data_input"><input type="text" id="INTERATE" name="INTERATE" value=""
                                                      style="width:90%"
                                                      intLength="5" floatLength="7"></td>
        </tr>
        <tr>
            <td width="15%" nowrap="nowrap" class="lbl_right_padding">利率代码</td>
            <td width="35%" class="data_input">
                <input type="text" id="RATECODE" name="RATECODE" value="" style="width:90%" textLength="3">
            </td>
            <td width="15%" nowrap="nowrap" class="lbl_right_padding">贷款基准利率</td>
            <td width="35%" class="data_input"><input type="text" id="BASICINTERATE" name="BASICINTERATE" value=""
                                                      style="width:90%" intLength="5" floatLength="7"></td>
        </tr>
        <tr>
            <td width="15%" nowrap="nowrap" class="lbl_right_padding">利率运算代码</td>
            <td width="35%" class="data_input">
                <%
                    zs = new ZtSelect("RATEACT", "", "");
                    zs.setSqlString("select code_id as value ,code_desc as text  from ln_odsb_code_desc where code_type_id='411'");
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
                    zs.addOption("", "");
                    out.print(zs);
                %>
            </td>
            <td width="15%" nowrap="nowrap" class="lbl_right_padding">利率运算值</td>
            <td width="35%" class="data_input"><input type="text" id="RATECALEVALUE" name="RATECALEVALUE" value=""
                                                      style="width:90%" intLength="5" floatLength="7"></td>
        </tr>

        <tr>
            <td width="15%" nowrap="nowrap" class="lbl_right_padding">客户编号</td>
            <td width="35%" class="data_input"><input name="CUST_NO" type="text" id="CUST_NO" style="width:90%"
                                                      textLength="20">
            </td>

            <td width="15%" nowrap="nowrap" class="lbl_right_padding">额度编号</td>
            <td width="35%" class="data_input"><input name="CRLMT_NO" type="text" id="CRLMT_NO" style="width:90%"
                                                      textLength="20"></td>
        </tr>
        <tr>
            <td width="15%" nowrap="nowrap" class="lbl_right_padding">审批状态</td>
            <td width="35%" class="data_input">
                <%
                    zs = new ZtSelect("APPRSTATE", "", "");
                    zs.setSqlString("select code_id as value ,code_desc as text  from ln_odsb_code_desc where code_type_id='192'");
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
                    //zs.addAttr("isNull","false");
                    zs.addOption("", "");
                    out.print(zs);
                %>
            </td>
            <td width="15%" nowrap="nowrap" class="lbl_right_padding">贷款状态</td>
            <td width="35%" class="data_input">
                <%
                    zs = new ZtSelect("LOANSTATE", "", "");
                    zs.setSqlString("select code_id as value ,code_desc as text  from ln_odsb_code_desc where code_type_id='149'");
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
                    //zs.addAttr("isNull","false");
                    zs.addOption("", "");
                    out.print(zs);
                %>
            </td>
        </tr>

        <tr>
            <%if (doType.equals("select")) { %>
            <td width="15%" nowrap="nowrap" class="lbl_right_padding">操作人员</td>
            <td width="35%" class="data_input"><input type="text" value="<%=oper.getOpername()%>" style="width:90%"
                                                      disabled="disabled"></td>
            <td width="15%" nowrap="nowrap" class="lbl_right_padding">操作时间</td>
            <td width="35%" class="data_input"><input type="text" id="OPERDATE" value="" style="width:90%"
                                                      disabled="disabled">
            </td>
            <%} else { %>
            <td width="15%" nowrap="nowrap" class="lbl_right_padding">操作人员</td>
            <td width="35%" class="data_input"><input type="text" value="<%=omgr.getOperatorName()%>" style="width:90%"
                                                      disabled="disabled"></td>
            <td width="15%" nowrap="nowrap" class="lbl_right_padding">操作时间</td>
            <td width="35%" class="data_input"><input type="text" value="<%=BusinessDate.getToday() %>"
                                                      style="width:90%"
                                                      disabled="disabled"></td>
            <%} %>
        </tr>
    </table>
</fieldset>
<fieldset>
    <legend>操作</legend>
    <table width="100%" class="title1" cellspacing="0">
        <tr>
            <td align="center">
                <!--查询-->
                <%if (doType.equals("select")) { %>
                <input id="closebut" class="buttonGrooveDisable" onmouseover="button_onmouseover()"
                       onmouseout="button_onmouseout()" type="button" value="关闭" onclick="window.close();">
                <%} else if (doType.equals("edit") || doType.equals("add") || doType.equals("modify")) { %>
                <!--增加，修改-->
                <input id="savebut" class="buttonGrooveDisable" onmouseover="button_onmouseover()"
                       onmouseout="button_onmouseout()" type="button" value="保存" onclick="saveClick();">
                <input id="closebut" class="buttonGrooveDisable" onmouseover="button_onmouseover()"
                       onmouseout="button_onmouseout()" type="button" value="取消" onclick="window.close();">
                <%} else if (doType.equals("delete")) { %>
                <!--删除-->
                <input id="deletebut" class="buttonGrooveDisable" onmouseover="button_onmouseover()"
                       onmouseout="button_onmouseout()" type="button" value="删除" onclick="deleteClick();">
                <input id="closebut" class="buttonGrooveDisable" onmouseover="button_onmouseover()"
                       onmouseout="button_onmouseout()" type="button" value="取消" onclick="window.close();">
                <%} %>
            </td>
        </tr>
    </table>
</fieldset>

</form>
<%--
    <%if (doType.equals("add") || doType.equals("edit")) {%>
    <fieldset>
        <legend>推介客户信息</legend>
        <table width="100%">
            <tr>
                <td><%=dbGrid.getDBGrid()%>
                </td>
            </tr>
        </table>
    </fieldset>
    <%}%>
--%>
</body>
</html>
