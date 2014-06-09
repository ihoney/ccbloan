<!--
  /*********************************************************************
  *    功能描述: 客户经理认领，suggestion功能
  *    作    者:    吴业元
  *    开发日期:  2010/01/16
  *    修 改 人:
  *    修改日期:
  *    版    权:    吴业元
  ***********************************************************************/
-->

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="pub.platform.db.ConnectionManager"%>
<%@ page import="pub.platform.db.DatabaseConnection"%>
<%@ page import="pub.platform.db.RecordSet"%>
<%@ page import="pub.platform.utils.Basic"%>
<%@page import="com.ccb.util.CcbLoanConst"%>
<%@page import="pub.platform.security.OperatorManager"%>
<%@page import="pub.platform.form.config.SystemAttributeNames"%>

<%
  OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
  request.setCharacterEncoding("GBK");
  // 取得ajaxSuggestion 的查询字符串
  String strPara = request.getParameter("search").toLowerCase();
  DatabaseConnection conn = ConnectionManager.getInstance().get();
  // 模糊查询匹配规则：前端一致
  RecordSet rs=conn.executeQuery("select * from (select a.loanid,a.cust_name,a.cust_py rowno from ln_loanapply  a where "
      +" not exists (select 1 from ln_mortinfo b where b.loanid=a.loanid) "
      +" and a.bankid ='"+omgr.getOperator().getDeptid()+"' "
      +" and ((a.cust_name like'"+strPara+"%') or (a.cust_py  like'"+strPara+"%')) "
      +" and (trim(a.custmgr_id) is null or a.custmgr_id='"+omgr.getOperatorId()+"')"
      +" order by a.CUST_OPEN_DT desc,APLY_DT desc,a.cust_py asc "
      +" )c where rownum<="+CcbLoanConst.PULLDOWN_PAGE_CNT );
  while(rs.next()){
     out.println("<table border=\"0\" width=\"100%\"><tr style=\"width:100%\"><td>");
     out.println("<li><a href=\"#\" class=\"item choose-value\" onclick=\"setPullToInput(this)\">"+rs.getString("cust_name")+"</a></li>");
     out.println("</td></tr></table>");
  }
  // 释放数据库连接
  ConnectionManager.getInstance().release();
%>
