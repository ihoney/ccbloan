<%@ page import="com.ccb.creditrating.CreditBean" %>
<%@ page import="com.ccb.creditrating.CreditBeanUtil" %>
<%@ page import="pub.platform.form.config.SystemAttributeNames" %>
<%@ page import="pub.platform.security.OperatorManager" %>
<%@ page import="pub.platform.system.manage.dao.PtDeptBean" %>
<%@ page import="java.util.ArrayList" %>
<%@include file="/global.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String custno = request.getParameter("custno");
    String creditratingno = request.getParameter("creditratingno");
    ArrayList<CreditBean> creditBeans = CreditBeanUtil.getCreditBean(custno);
    OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
    PtDeptBean ptOperBean = omgr.getOperator().getPtDeptBean();
    String deptid = ptOperBean.getDeptid();
%>
<html>
<head>
    <title></title>

    <script type="text/javascript">
        window.onload = function () {
            /*添加*/
            var levelValue = document.getElementById("inilevel").value;
            var inilevel2 = document.getElementById("inilevel2");
            if (levelValue == "A") {
                option1 = new Option("A", "A");
                option2 = new Option("AA", "AA");
                inilevel2.options.add(option1);
                inilevel2.options.add(option2);
                inilevel2.value = "A";
            } else if (levelValue == "AA") {
                option3 = new Option("AA", "AA");
                option4 = new Option("AAA", "AAA");
                inilevel2.options.add(option3);
                inilevel2.options.add(option4);
                inilevel2.value = "AA";
            } else if (levelValue == "AAA") {
                option5 = new Option("AAA", "AAA");
                inilevel2.options.add(option5);
                inilevel2.value = "AAA";
            } else if (levelValue == "nolevel") {
                option6 = new Option("nolevel", "nolevel");
                option7 = new Option("A", "A");
                inilevel2.options.add(option6);
                inilevel2.options.add(option7);
                inilevel2.value = "nolevel";
            }
        };

        function checkAddScore(input) {
            var val = input.value;
            if (val.length == 0) {
                return;
            }
            var val2 = Math.abs(parseInt(val));
            if (val2 == 0 || val != val2) {
                alert("请输入正整数！");
                input.value = "";
                return;
            }
            input.value = val2;
        }
    </script>
    <style type="text/css">
        td {
            text-align: center;
            font-size: 12px;
            padding: 2px;
        }

        body {
            margin: auto;
            text-align: center;
        }

        table {
            width: 600px;
        }

        .td1 {
            text-align: center;
            border-bottom: none;
        }

        .td2 {
            text-align: center;
            border-top: none;
            border-bottom: none;
        }

        .tdlast {
            border: 1px solid #808080;
        }
    </style>
</head>
<body>
<fieldset>
    <legend>信用评分明细</legend>
    <table border="1" cellspacing="0" cellpadding="0">
        <tr>
            <td colspan="7"><font size="+3">二、客户信用评分</font></td>
        </tr>
        <tr>
            <td width="15%" height="46">分类</td>
            <td width="17%">项目</td>
            <td colspan="4">评分标准</td>
            <td width="8%">初评分</td>
        </tr>
        <%
            for (int i = 0; i < creditBeans.size(); i++) {
        %>
        <tr>
            <td class="<%
                String css = null;
                if(creditBeans.get(i).getSituation().equals("&nbsp;"))
                    css = "td2";
                else
                    css = "td1";
            %><%=css%>"><%=creditBeans.get(i).getSituation()%>
            </td>
            <td class="<%
                if(creditBeans.get(i).getItem().equals("&nbsp;") && i < creditBeans.size()-2)
                    css = "td2";
                else
                    css = "td1";
            %><%=css%>">
                <%=creditBeans.get(i).getItem()%>
            </td>
            <td><%=creditBeans.get(i).getStand1()%>
            </td>
            <td><%=creditBeans.get(i).getStand2()%>
            </td>
            <td><%=creditBeans.get(i).getStand3()%>
            </td>
            <td><%=creditBeans.get(i).getStand4()%>
            </td>

            <%
                if (i < creditBeans.size() - 2) {
            %>

            <td class="<%
                if(creditBeans.get(i).getScore().equals("&nbsp;"))
                    css = "td2";
                else
                    css = "td1";
            %><%=css%>">
                <%=creditBeans.get(i).getScore()%>
            </td>
            <%} else if (i == creditBeans.size() - 2) {%>
            <td class="<%
                if(creditBeans.get(i).getScore().equals("&nbsp;"))
                    css = "td2";
                else
                    css = "td1";
            %><%=css%>">
                <input type="hidden" id="baselevel" name="baselevel" value="<%=creditBeans.get(i).getScore()%>">
                <input type="hidden" id="inilevel" name="inilevel" value="<%=creditBeans.get(i).getScore()%>">
                <select id="inilevel2" name="inilevel2"
                        onchange="document.getElementById('inilevel').value = this.value;"></select>
            </td>
            <%} else {%>
            <td class="<%
                if(creditBeans.get(i).getScore().equals("&nbsp;"))
                    css = "td2";
                else
                    css = "td1";
            %><%=css%>">
                <input type="text" id="addScore" name="addScore" value="" size="3" onchange="checkAddScore(this);">
            </td>
            <%}%>
        </tr>
        <%
            }
        %>
    </table>
</fieldset>
<fieldset>
    <legend>操作</legend>
    <button id="outputReportZH"
            onclick="window.open('${pageContext.request.contextPath}/servlet/ZHExcelServlet?custno=<%=custno%>' + '&iniLevel='+document.getElementById('inilevel').value + '&addScore='+ document.getElementById('addScore').value+'&baseScore=<%=creditBeans.get(creditBeans.size()-3).getScore()%>' + '&baselevel='+ document.getElementById('baselevel').value,null,null);">
        输出报表
    </button>
</fieldset>
</body>
</html>