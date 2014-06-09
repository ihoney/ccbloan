<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="java.util.*" %>
<%@ page import="weblogic.servlet.internal.WebAppServletContext" %>
<%@ page import="weblogic.management.runtime.ServletRuntimeMBean" %>
<%@ page import="weblogic.servlet.internal.session.SessionContext" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="pub.platform.form.config.SystemAttributeNames" %>
<%@ page import="pub.platform.security.*" %>
<%@ page import="pub.platform.system.manage.dao.*" %>
<%
  String kickid   = request.getParameter("kickid");
  String kicktime = request.getParameter("kicktime");
  
  List users = new ArrayList();
  try {
    WebAppServletContext ctx  = (WebAppServletContext)pageContext.getServletConfig().getServletContext();
    SessionContext       ctx1 =  ctx.getSessionContext();
    ctx1.deleteInvalidSessions();
    
    Hashtable set = ctx1.getOpenSessions();
    for ( Enumeration  elements = set.elements() ;  elements.hasMoreElements() ; ) {
      HttpSession session1 = (HttpSession)elements.nextElement();
      OperatorManager um = (OperatorManager)session1.getAttribute(SystemAttributeNames.USER_INFO_NAME);
      if ( um != null ) {
         ;
        if ( um.getOperator() == null ) {
             session1.removeAttribute(SystemAttributeNames.USER_INFO_NAME);
             continue;
        }

        if ( kickid != null && kicktime != null ) {
            if ( kickid.trim().equals(um.getOperator().getOperid().trim()) ) {
                session1.removeAttribute(SystemAttributeNames.USER_INFO_NAME);
                continue;
            }
        }
    
        users.add(um.getOperator());
      }
    }
  } catch ( Exception ex ) { 
    
  }
  //java.util.Collections.sort(users,new Operator());
  
  /*
  PtOperBean aoper ;
  PtOperBean boper ;
  
  for(int i=0; i< users.size();i++)
  	for (int j=i+1;j<users.size();j++){
  		aoper = (PtOperBean)users.get(i);
  		boper = (PtOperBean)users.get(j);
  		
  		if(!aoper.getOperid().equalsIgnoreCase("jimowjmj")&&!aoper.getOperid().equalsIgnoreCase("test")&&
  		!boper.getOperid().equalsIgnoreCase("jimowjmj")&&!boper.getOperid().equalsIgnoreCase("test")
  		){
  		if (aoper != null && boper != null&& Integer.parseInt(aoper.getOperid()) > Integer.parseInt(boper.getOperid()))
  		//if (aoper != null&&boper!=null)
  		{
  			users.set(i,boper);
  			users.set(j,aoper);
  		}
  	}
  	}
  	
  	*/
%>
<html>
<head>
<title>在线用户列表</title>
<link href="../../css/ccb.css" rel="stylesheet" type="text/css">
</head>
<body>
<div style='overflow:auto;height:520px;top:0px;width:100%;position:absolute;'>
  <table align="center"  width="100%">
    <tr align="left">
      <td height="30">&nbsp;在线人数：<font color="red" size="1"><%=users.size()%></font> </td>
    </tr>
    <tr align="center">
      <td><table width='100%'>
          <tr>
            <td><table width='100%'  class="borderGroove">
                <tr class="borderGrooveB" >
                  <td width='15%'  align="center" class="borderGrooveBR">所属部门</td>
                  <td width='15%'  align="center" class="borderGrooveBR">操作员姓名</td>
                  <td width='10%'  align="center" class="borderGrooveBR">操作员标识</td>
                  <td width='60%'  align="center" class="borderGrooveBR">操作员信息</td>
                  
                </tr>
                <%                                                
                         for ( int i = 0 ; i < users.size() ; i++ ) {
                             PtOperBean vu = (PtOperBean)users.get(i);
%>
                <tr >
                  <td class="borderGrooveBR" ><%=vu.getPtDeptBean().getDeptname()%></td>
                  <td class="borderGrooveBR" ><%=vu.getOpername()%></td>
                  <td align="center" class="borderGrooveBR"><%=vu.getOperid()%></td>
                  <td class="borderGrooveBR" ><%=vu.getFillstr600()%> </td>
                </tr>
                <%
                         }
                        
%>
              </table></td>
          </tr>
        </table></td>
    </tr>
  </table>
</div>
</body>
</html>
