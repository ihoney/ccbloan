<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="pub.platform.db.ConnectionManager"%>
<%@ page import="pub.platform.db.DatabaseConnection"%>
<%@ page import="pub.platform.db.RecordSet"%>
<%@ page import="pub.platform.utils.Basic;"%>
<%
  request.setCharacterEncoding("GBK");
  // 取得ajaxSuggestion 的查询字符串
  String strFileName = request.getParameter("search");
  ConnectionManager manager;
  manager = ConnectionManager.getInstance();
  DatabaseConnection  conn = manager.getConnection();  
  // 模糊查询匹配规则：前端一致
  RecordSet rs=conn.executeQuery("select file_name from (select file_name,rownum as rowno from ptdemo where file_name like '"+strFileName+"%'"
      +" order by file_name )a where  a.rowno<=5");
  while(rs.next()){
     out.println("<table><tr><td>");
     out.println("<li><a href=\"#\" class=\"item choose-value\" onclick=\"setPullToInput(this)\">"+rs.getString("file_name")+"</a></li>");
     out.println("</td></tr></table>");
  }
  // 释放数据库连接
  manager.releaseConnection(conn);
%>
