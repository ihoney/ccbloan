<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="/pages/security/loginassistor.jsp" %>
<%
    OperatorManager omgr = (OperatorManager) session
            .getAttribute(SystemAttributeNames.USER_INFO_NAME);
%>
<%--<script language="javascript" src="<%=request.getContextPath() %>/js/basic.js"></script>--%>
<script language="javascript" src="./js/basic.js"></script>
<html>
<head>
    <title>个人信贷管理支持系统</title>
    <link href="/css/ccb.css" type="text/css" rel="stylesheet">
    <meta content="mshtml 6.00.2800.1106" name="generator">
</head>
<script>
    function unloadevent() {
    }
    function promtMsg() {
    }
</script>
<frameset rows="80px,*" border="0" framespacing="0" frameborder="0" noresize="noresize" scrolling="no"
          onload="promtMsg()" onunload="unloadevent()">
    <frame name="roofFrame" src="roofPage.jsp" frameborder="0" noresize="noresize" scrolling="no">
    <frameset id="menuFrame" framespacing="0" cols="200,12,*" frameborder="0" framespacing="0">
        <frame id="menuList" src="menuPage.jsp" frameborder="0" noresize="noresize" scrolling="no" style="display: ">
        <frame id="dockFrame" src="dockPage.jsp" frameborder="0" noresize="noresize" scrolling="no">
        <frame id="workFrame" src="trackMisc.jsp" frameborder="0" noresize="noresize" scrolling="auto">
    </frameset>
</frameset>          
</html>
