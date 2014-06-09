<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="java.util.*" %>
<%@ page import="pub.platform.form.config.SystemAttributeNames" %>
<%@ page import="pub.platform.security.OperatorManager" %>


<%
    request.setCharacterEncoding("GBK");
    OperatorManager om = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);

    if (om == null) {

        om = new OperatorManager();
        session.setAttribute(SystemAttributeNames.USER_INFO_NAME, om);
    }

//    String username = request.getParameter("username");
//    String password = request.getParameter("password");
    String username = (String) session.getAttribute("uaapuser");
    String password = "tiankun";
    boolean isLogin = false;


    try {
        om.setRemoteAddr(request.getRemoteAddr());
        om.setRemoteHost(request.getRemoteHost());
        isLogin = om.login(username, password);
       /* if (!isLogin) {
//            out.println("<script language=\"javascript\">alert ('输入用户名或密码有误！'); if(top){ top.location.href='/login.jsp'; } else { location.href = '/login.jsp';} </script>");
            out.println("<script language=\"javascript\">alert ('输入用户名或密码有误！'); if(top){ top.location.href='/qdgddy'; } else { location.href = '/qdgddy';} </script>");
        }*/
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

