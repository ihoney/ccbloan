<%
String path = request.getContextPath();
%>

<%@ include file="/pages/security/online.jsp"%>
<%
      response.setHeader("Cache-Control", "no-store");
      response.setHeader("Pragma", "no-cache");
      response.setDateHeader("Expires", 0);
      response.setHeader("Expires", "0");
%>

<LINK href="<%=path %>/css/ccb.css" type="text/css" rel="stylesheet">
<%@ page import="pub.platform.db.*"%>
<%@ page import="pub.platform.html.*"%>
<%@ page import="pub.platform.form.config.EnumerationType"%>
<%@ page import="pub.platform.utils.*"%>
<%@ page import="java.util.*"%>
<%@page import="pub.platform.security.OperatorManager"%>
<%@page import="pub.platform.form.config.SystemAttributeNames"%>

<script language="javascript" src="<%=path %>/js/basic.js"></script>
<script language="javascript" src="<%=path %>/js/xmlHttp.js"></script>
<script language="javascript" src="<%=path %>/js/dbgrid.js"></script>
<script language="javascript" src="<%=path %>/js/dbutil.js"></script>
<script language="JavaScript" src="<%=path %>/js/compack.js"></script>
<script language="javascript" src="<%=path %>/js/menu.js"></script>
<script language="javascript" src="<%=path %>/js/tree.js"></script>
<script language="javascript" src="<%=path %>/js/loadform.js"></script>
<script language="javascript" src="<%=path %>/js/dropdownData.js"></script>
<script language="javascript" type="text/javascript" src="<%=path %>/DatePicker/WdatePicker.js"></script>




