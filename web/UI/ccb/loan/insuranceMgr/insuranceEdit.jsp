<%@page contentType="text/html; charset=GBK" %>
<%@include file="/global.jsp" %>
<%@ page import="com.ccb.dao.*" %>
<%@ page import="com.ccb.util.*" %>
<%
    // 贷款申请序号
    String loanID = "";
    // 操作类型
    String doType = "";
    // 抵押编号
    String mortID = "";
    // 合作项目对象
    LNLOANAPPLY loan = null;

    if (request.getParameter("loanID") != null)
        loanID = request.getParameter("loanID");

    if (request.getParameter("doType") != null)
        doType = request.getParameter("doType");


        // 初始化页面
        LNMORTINFO bean = LNMORTINFO.findFirst("where loanid='" + loanID + "'");
        if (bean != null) {
            StringUtils.getLoadForm(bean, out);
        }
    if (doType.equals("edit")) {
        LNINSURANCE insurance = LNINSURANCE.findFirst(" where loanid='" + loanID + "'");
        if (insurance != null) {
            StringUtils.getLoadForm(insurance,out);
        }
    }

    OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);

%>
<html>


<head>

    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>抵押信息登记</title>

    <script language="javascript" src="/UI/support/tabpane.js"></script>
    <script language="javascript" src="/UI/support/common.js"></script>
    <script language="javascript" src="/UI/support/DataWindow.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
    <script language="javascript" src="insuranceEdit.js"></script>

</head>
<body bgcolor="#ffffff" onload="formInit();" class="Bodydefault">
<br>

<div id="container">
    <form id="editForm" name="editForm">
        <fieldset>
            <legend>抵押信息登记</legend>
            <table width="100%" cellspacing="0" border="0">
                <!-- 操作类型 -->
                <input type="hidden" id="doType" value="<%=doType%>">
                <!-- 贷款申请顺序号 -->
                <input type="hidden" id="loanid" name="loanid" value=""/>
                <!-- 抵押编号 -->
                <input type="hidden" id="mortid" name="mortid" value=""/>
                <input type="hidden" id="insurancests" name="insurancests" value=""/>
                <tr>
                    <td width="20%" class="lbl_right_padding">是否办理保险</td>
                    <td width="30%" class="data_input">
                        <%
                            ZtSelect zs = new ZtSelect("attendflag", "BOOLTYPE", "");
                            zs.addAttr("style", "width: 40%");
                            zs.addAttr("fieldType", "text");
                            //zs.addAttr("isNull","false");
                            out.print(zs);
                        %>
                    </td>
                </tr>

            </table>
        </fieldset>

        <br>
        <fieldset>
            <legend>操作信息</legend>

            <table width="100%" cellspacing="0" border="0">

                <tr>
                    <td width="20%" nowrap="nowrap" class="lbl_right_padding">操作人员</td>
                    <td width="30%" class="data_input"><input type="text" value="<%=omgr.getOperatorName()%>"
                                                              style="width:90%" disabled="disabled"></td>
                    <td width="20%" nowrap="nowrap" class="lbl_right_padding">操作时间</td>
                    <td width="30%" class="data_input"><input type="text" value="<%=BusinessDate.getToday() %>"
                                                              style="width:90%" disabled="disabled"></td>
                </tr>
            </table>
        </fieldset>
        <br>
        <fieldset>
            <legend>操作</legend>
            <table width="100%" class="title1" cellspacing="0">
                <tr>
                    <td align="center">

                        <input id="savebut" class="buttonGrooveDisable" onmouseover="button_onmouseover()"
                               onmouseout="button_onmouseout()" type="button" value="保存" onclick="saveClick();">
                        <input id="closebut" class="buttonGrooveDisable" onmouseover="button_onmouseover()"
                               onmouseout="button_onmouseout()" type="button" value="取消" onclick="window.close();">

                    </td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>
</body>
</html>