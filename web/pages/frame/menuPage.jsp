<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/pages/security/online.jsp"%>
<%@ page import="pub.platform.security.OperatorManager"%>
<%@ page import="pub.platform.form.config.SystemAttributeNames"%>
<%@ page import="pub.platform.security.OperatorManager"%>
<%@ page import="pub.platform.utils.Basic"%>
<%
response.setContentType("text/html; charset=GBK");
%>
<html xmlns:hGui>
  <head>
    <link href="/css/ccb.css" type="text/css" rel="stylesheet">
    <script language="javascript" src="/js/xmlHttp.js"></script>
    <script language="javascript" src="/js/basic.js"></script>
    <script language="javascript" src="/js/menuPage.js"></script>
    <script language="javascript" src="/js/tree.js"></script>
    <script language="javascript" src="/js/dbutil.js"></script>
    <script language="javascript">

			<%
               String xmlString = null;
				 // 从上下文中取到OperatorManger object， 就是从login.jsp中产生的那个OperatorManger。
				 OperatorManager om = (OperatorManager)session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
				 try {
					xmlString =om.getXmlString();
									
                        System.out.println( om.getOperator().getPtDeptBean().getSuperdqdm());

                         System.out.println( om.getOperator().getPtDeptBean().getSuperdqmc());
				 } catch(Exception e) {
					 System.out.println("jsp" +e +"\n");
				 }
			%>
			var xmlStr ='<%=xmlString%>';
               function changeheigth(){

                   //document.all("rootUl").style.height=document.body.offsetHeight -90;
                 document.all("rootUl").style.height=document.body.offsetHeight-3 ;
               }

		</script>

  </head>
 
  <body onload="changeheigth();StartMenu();" onresize="changeheigth()" onKeyDown="tvNodeSelected()" onselectstart="event.returnValue=false;"
    oncontextmenu="event.returnValue=false;" class="Bodydefault" style="margin:0px;padding:0px;WIDTH:100%;height:100%;">
      <table  cellspacing="0" cellpadding="5" border="0" style="WIDTH:105%;height:100%;">
        <tr>
          <td >
            <ul id="rootUl" style="OVERFLOW:auto;WIDTH:100%;height:100%;left:-38px;POSITION:absolute;top:5px" onmousemove="tv_OnMouseMove()" onmousedown="tv_OnMouseDown()" onmouseup="tv_OnMouseUp()"></ul>
          </td>
        </tr>
      </table>
  </body>
 
</html>
