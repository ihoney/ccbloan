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
    // 备注
    String remark = "";
    // 操作类型
    String doType = "";


    if (request.getParameter("remark") != null)
        remark=new String(request.getParameter("remark").getBytes("ISO8859-1"),"GBK");
    if (request.getParameter("doType") != null){
        doType = request.getParameter("doType");
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
</head>
<body class="Bodydefault">

<form id="editForm" name="editForm">
<fieldset style="padding: 15px">
    <legend style="margin-bottom: 10px">业务流程备注</legend>
    <textarea rows="20" cols="80" id="remark"><%=remark%></textarea>
</fieldset>
<fieldset>
    <legend>操作</legend>
    <table width="100%" class="title1" cellspacing="0">
        <tr>
            <td align="center">
                <input id="closebut" class="buttonGrooveDisable" onmouseover="button_onmouseover()"
                       onmouseout="button_onmouseout()" type="button" value="关闭" onclick="window.close();">
            </td>
        </tr>
    </table>
</fieldset>
</form>
</body>
</html>
