<!--
  /*********************************************************************
  *    功能描述: 抵押信息管理抵押详细页面;快递登记/柜号输入
  *
  *    作    者:    leonwoo
  *    开发日期:  2010/01/16
  *    修 改 人:
  *    修改日期:
  *    版    权:    公司
  ***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK"%>
<%@include file="/global.jsp"%>
<%@ page import="com.ccb.dao.*" %>
<%@ page import="com.ccb.util.*"%>
<%
  // 操作类型
  String doType = "";
  
  if (request.getParameter("doType") != null)
    doType = request.getParameter("doType");
%>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=GBK">
<title>柜号信息</title>
<script language="javascript" src="/UI/support/tabpane.js"></script>
<script language="javascript" src="/UI/support/common.js"></script>
<script language="javascript" src="/UI/support/DataWindow.js"></script>
<script language="javascript" src="/UI/support/pub.js"></script>
<script language="javascript" src="beforeExpressBox.js"></script>
</head>
<body bgcolor="#ffffff" onLoad="formInit();"  class="Bodydefault" >
<div id="container">
  <form id="editForm" name="editForm" >
    <fieldset >
    <legend>柜号信息</legend>
    <table width="100%"  cellspacing="0" border="0">
      <!-- 操作类型 -->
      <input type="hidden" id="doType" value="<%=doType%>">
      <tr>
        <td width="15%"  nowrap="nowrap" class="lbl_right_padding">柜号</td>
        <td width="35%"  class="data_input" ><input type="text" id="BOXID" name="BOXID"  value=""  style="width:90% " textLength="10" >
        </td>
      </tr>
      <tr>
        <td width="15%" nowrap="nowrap" class="lbl_right_padding">快递备注</td>
        <td width="35%" colspan="3" class="data_input"><textarea name="EXPRESSNOTE" rows="3"
                                                                   id="EXPRESSNOTE" style="width:96.4%"
                                                                   textLength="500"></textarea></td>
      </tr>
    </table>
    </fieldset>
    <fieldset >
    <legend>操作</legend>
    <table width="100%" class="title1"  cellspacing="0">
      <tr >
        <td align="center" ><!--查询-->
          <%if (doType.equals("select")) {      %>
          <input id="closebut" class="buttonGrooveDisable" onMouseOver="button_onmouseover()" onMouseOut="button_onmouseout()" type="button" value="关闭" onClick="window.close();">
          <%} else if (doType.equals("edit") || doType.equals("add")) {      %>
          <!--增加，修改-->
          <input id="savebut" class="buttonGrooveDisable" onMouseOver="button_onmouseover()" onMouseOut="button_onmouseout()" type="button" value="保存" onClick="saveClick();">
          <input id="closebut" class="buttonGrooveDisable" onMouseOver="button_onmouseover()" onMouseOut="button_onmouseout()" type="button" value="取消" onClick="window.close();">
          <%} else if (doType.equals("delete")) {      %>
          <!--删除-->
          <input id="deletebut" class="buttonGrooveDisable" onMouseOver="button_onmouseover()" onMouseOut="button_onmouseout()" type="button" value="删除" onClick="deleteClick();">
          <input id="closebut" class="buttonGrooveDisable" onMouseOver="button_onmouseover()" onMouseOut="button_onmouseout()" type="button" value="取消" onClick="window.close();">
          <%}      %>
        </td>
      </tr>
    </table>
    </fieldset>
  </form>
</div>
</body>
</html>
