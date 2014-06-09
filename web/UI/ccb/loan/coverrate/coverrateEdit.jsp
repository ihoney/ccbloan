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
<%
    String dept_id = "";
    PTDEPT bean = PTDEPT.findFirst("where deptid='" + request.getParameter("deptid") + "'");
    if (bean != null) {
        dept_id = bean.getDeptid();
        StringUtils.getLoadForm(bean, out);
    }
%>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>客户信息</title>
    <script language="javascript" src="/UI/support/tabpane.js"></script>
    <script language="javascript" src="/UI/support/common.js"></script>
    <script language="javascript" src="/UI/support/DataWindow.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
    <script language="javascript" src="coverrateEdit.js"></script>
</head>
<body bgcolor="#ffffff" onLoad="formInit();" class="Bodydefault">
<div id="container"><br>

    <form id="editForm" name="editForm">
        <input type="hidden" id="dept_id" value="<%=dept_id%>"/>
        <fieldset>
            <legend>客户经理修改推介信息</legend>
            <table width="100%" cellspacing="0" border="0">
                <tr>
                    <td width="15%" nowrap="nowrap" class="lbl_right_padding">经办行</td>
                    <td width="35%" class="data_input">
                        <input id="deptname" value="" readonly="true" style="width:90%">
                    </td>
                    <td width="15%" nowrap="nowrap" class="lbl_right_padding">覆盖率(%)</td>
                    <td width="35%" class="data_input">
                        <input id="filldbl2" value="" isNull="false"/><span class="red_star">*</span>
                    </td>
                </tr>
            </table>
        </fieldset>
        <br>
        <fieldset>
            <legend>操作</legend>
            <table width="100%" class="title1" cellspacing="0">
                <tr>
                    <td align="center"><!--查询-->
                        <input id="savebut" class="buttonGrooveDisable" onMouseOver="button_onmouseover()"
                               onMouseOut="button_onmouseout()" type="button" value="保存" onClick="saveClick();">
                        <input id="closebut" class="buttonGrooveDisable" onMouseOver="button_onmouseover()"
                               onMouseOut="button_onmouseout()" type="button" value="取消" onClick="window.close();">
                    </td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>
</body>
</html>
