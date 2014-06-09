<!--
/*********************************************************************
* 功能描述: 营销经理录入推介的信息
*
* 作 者: haiyuhuang
* 开发日期: 2011/07/22
* 修 改 人:
* 修改日期:
* 版 权:
***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK" %>
<%@include file="/global.jsp" %>
<%@ page import="com.ccb.dao.*" %>
<%@ page import="com.ccb.util.*" %>
<%
    //操作类型
    String doType = "";
    //促销客户顺序号
    String promcustid = "";
    // 客户经理ID
    String custMgrID = "";

    if (request.getParameter("doType") != null) {
        doType = request.getParameter("doType");
    }
    if (request.getParameter("promcustno") != null) {
        promcustid = request.getParameter("promcustno");
    }
    if (!"add".equalsIgnoreCase(doType)) {
        LNPROMOTIONCUSTOMERS bean = LNPROMOTIONCUSTOMERS.findFirst("where PROMCUST_NO='" + promcustid + "'");
        if (bean != null) {
            custMgrID = bean.getCustmgr_id();
            StringUtils.getLoadForm(bean, out);
        }
    }
    OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
%>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>客户信息</title>
    <script language="javascript" src="/UI/support/tabpane.js"></script>
    <script language="javascript" src="/UI/support/common.js"></script>
    <script language="javascript" src="/UI/support/DataWindow.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
    <script language="javascript" src="custMgrEdit.js"></script>
</head>
<body bgcolor="#ffffff" onLoad="formInit();" class="Bodydefault">
<div id="container"><br>

    <form id="editForm" name="editForm">
        <input type="hidden" id="recVersion" value=""/>
        <input type="hidden" id="PROMCUST_NO" value="<%=promcustid%>"/>
        <!-- 编辑的时候显示客户经理ID使用 -->
        <input type="hidden" id="custMgrID" value="<%=custMgrID%>"/>
        <!-- 流水日志表使用 -->
        <input type="hidden" id="busiNode" name="busiNode" value=""/>
        <input type="hidden" id="custbankid" name="custbankid" value="<%=omgr.getOperator().getDeptid()%>"/>
        <fieldset>
            <legend>客户经理修改推介信息</legend>
            <table width="100%" cellspacing="0" border="0">
                <!-- 操作类型 -->
                <input type="hidden" id="doType" value="<%=doType%>">
                <tr>
                    <td width="15%" nowrap="nowrap" class="lbl_right_padding">经营中心</td>
                    <td width="35%" class="data_input">
                        <%
                            ZtSelect zs = new ZtSelect("CUST_BANKID", "", omgr.getOperator().getDeptid());
                            zs.setSqlString("select deptid, deptname  from ptdept where FILLSTR10='3'"
                                    + " start with deptid = '" + omgr.getOperator().getDeptid() + "'"
                                    + " connect by prior deptid = parentdeptid");
                            zs.addAttr("style", "width: 90%");
                            zs.addAttr("fieldType", "text");
                            zs.addAttr("onchange", "reSelect()");
//                            zs.addOption("", "");
                            zs.addAttr("isNull", "false");
                            out.print(zs);
                        %><span class="red_star">*</span>
                    </td>
                    <td width="15%" nowrap="nowrap" class="lbl_right_padding">客户经理</td>
                    <td width="35%" class="data_input">
                        <%
                            zs = new ZtSelect("CUSTMGR_ID", "", "");
                            zs.addAttr("style", "width: 90%");
                            zs.addAttr("fieldType", "text");
                            zs.addAttr("isNull", "false");
                            zs.addOption("", "");
                            out.print(zs);
                        %><span class="red_star">*</span>
                    </td>
                </tr>
                <tr>
                    <td width="15%" nowrap="nowrap" class="lbl_right_padding">贷款金额</td>
                    <td width="35%" class="data_input">
                        <input type="text" id="rt_orig_loan_amt" name="rt_orig_loan_amt" value=""
                               style="width:90%">
                    </td>
                    <td width="15%" nowrap="nowrap" class="lbl_right_padding">审核状态</td>
                    <td width="35%" class="data_input">
                        <%
                            zs = new ZtSelect("STATUS", "RELEASECHECK", "");
                            zs.addAttr("style", "width: 90%");
                            zs.addAttr("fieldType", "text");
                            zs.addAttr("isNull", "false");
                            out.print(zs);
                        %><span class="red_star">*</span>
                    </td>
                </tr>
                <tr>
                    <td width="15%" nowrap="nowrap" class="lbl_right_padding">备注</td>
                    <td colspan="3" class="data_input">
                        <input type="text" id="REMARK" name="REMARK" value=""
                               style="width:96.4%"></td>
                </tr>
                <tr>
                    <td width="15%" nowrap="nowrap" class="lbl_right_padding">操作人员</td>
                    <td width="35%" class="data_input"><input type="text" value="<%=omgr.getOperatorName()%>"
                                                              style="width:90%" disabled="disabled"></td>
                    <td width="15%" nowrap="nowrap" class="lbl_right_padding">操作时间</td>
                    <td width="35%" class="data_input"><input type="text" value="<%=BusinessDate.getToday() %>"
                                                              style="width:90%" disabled="disabled"></td>
                </tr>
            </table>
        </fieldset>
        <br>
        <fieldset>
            <legend>操作</legend>
            <table width="100%" class="title1" cellspacing="0">
                <tr>
                    <td align="center"><!--查询-->
                        <%if (doType.equals("select")) { %>
                        <input id="closebut" class="buttonGrooveDisable" onMouseOver="button_onmouseover()"
                               onMouseOut="button_onmouseout()" type="button" value="关闭" onClick="window.close();">
                        <%} else if (doType.equals("edit") || doType.equals("add")) { %>
                        <!--增加，修改-->
                        <input id="savebut" class="buttonGrooveDisable" onMouseOver="button_onmouseover()"
                               onMouseOut="button_onmouseout()" type="button" value="保存" onClick="saveClick();">
                        <input id="closebut" class="buttonGrooveDisable" onMouseOver="button_onmouseover()"
                               onMouseOut="button_onmouseout()" type="button" value="取消" onClick="window.close();">
                        <%} else if (doType.equals("delete")) { %>
                        <!--删除-->
                        <input id="deletebut" class="buttonGrooveDisable" onMouseOver="button_onmouseover()"
                               onMouseOut="button_onmouseout()" type="button" value="删除" onClick="deleteClick();">
                        <input id="closebut" class="buttonGrooveDisable" onMouseOver="button_onmouseover()"
                               onMouseOut="button_onmouseout()" type="button" value="取消" onClick="window.close();">
                        <%} %>
                    </td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>
<div id="search-result-suggestions">
    <div id="search-results"></div>
</div>
</body>
</html>
