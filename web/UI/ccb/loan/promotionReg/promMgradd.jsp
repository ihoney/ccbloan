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
<%
    String doType = request.getParameter("doType");
     String deptid = request.getParameter("deptid");
%>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>客户信息</title>
    <script language="javascript" src="/UI/support/tabpane.js"></script>
    <script language="javascript" src="/UI/support/common.js"></script>
    <script language="javascript" src="/UI/support/DataWindow.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
    <script language="javascript" src="promMgradd.js"></script>
</head>
<body bgcolor="#ffffff" onLoad="formInit();" class="Bodydefault">
<div id="container"><br>
    <form id="editForm" name="editForm">
        <fieldset>
            <legend>客户经理修改推介信息</legend>
            <table width="100%" cellspacing="0" border="0">
                <!-- 操作类型 -->
                <input type="hidden" id="deptid" value="<%=deptid%>">
                <tr>
                    <td width="15%" nowrap="nowrap" class="lbl_right_padding">营销经理名</td>
                    <td class="data_input"><input type="text" id="PROMMGR_NAME" name="PROMMGR_NAME" value=""
                                                              style="width:90% " isNull="false">
                        <span class="red_star">*</span>
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