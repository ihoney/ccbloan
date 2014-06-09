<%@ page import="com.ccb.creditrating.CountModel" %>
<%@page contentType="text/html; charset=GBK" %>
<%@include file="/global.jsp" %>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>资信评定报告显示页</title>
    <style type="text/css">
        .tdclass {
            text-align: center;
            color: #ffffff;
            width: 12.5%;
        }
    </style>
</head>
<body bgcolor="#ffffff" class="Bodydefault">
<fieldset>
    <legend> 统计信息</legend>
    <table width="100%" align="center" border="1" cellpadding="3" cellspacing="0">
        <tr style="background-color: #7D91AB">
            <td class="tdclass">经办行</td>
            <td class="tdclass">普通评信</td>
            <td class="tdclass">集体评信</td>
            <td class="tdclass">高端评信</td>
            <td class="tdclass">简化评信</td>
            <td class="tdclass">存量评信</td>
            <td class="tdclass">其他评信</td>
            <td class="tdclass">合计</td>
        </tr>

        <%
            List<CountModel> countModelList = (List<CountModel>) request.getAttribute("countModelList");
            for (CountModel countModel : countModelList) { %>
        <tr align="center">
            <td style="text-align: center"><%=countModel.getDeptName()%>
            </td>
            <td style="text-align: center"><%=countModel.getPtNum()%>
            </td>
            <td style="text-align: center"><%=countModel.getJtNum()%>
            </td>
            <td style="text-align: center"><%=countModel.getGdNum()%>
            </td>
            <td style="text-align: center"><%=countModel.getJhNum()%>
            </td>
            <td style="text-align: center"><%=countModel.getClNum()%>
            </td>
            <td style="text-align: center"><%=countModel.getQtNum()%>
            </td>
            <td style="text-align: center"><%=countModel.getHjNum()%>
            </td>
        </tr>
        <% } %>
    </table>
</fieldset>
</body>
</html>
