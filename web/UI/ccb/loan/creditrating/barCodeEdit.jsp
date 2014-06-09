<!--
/*********************************************************************
* 功能描述: 条形码编辑
* 修改人: nanmeiying
* 修改日期: 2013/09/01
***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK" %>
<%@include file="/global.jsp" %>
<%@page import="com.ccb.dao.LNPSCOREDETAIL" %>
<%@page import="pub.platform.utils.BusinessDate" %>
<%@page import="pub.platform.utils.StringUtils" %>
<%
    String creditratingno = "";  //客户号
    String doType = "";   // 操作类型
    ConnectionManager cm = ConnectionManager.getInstance();
    DatabaseConnection dc = cm.get();
    if (request.getParameter("creditratingno") != null) {
        creditratingno = request.getParameter("creditratingno");
    }
    if (request.getParameter("doType") != null)
        doType = request.getParameter("doType");

    LNPSCOREDETAIL lnpscoredetail = new LNPSCOREDETAIL();
    String operName = "";
    if (creditratingno != null) {
        lnpscoredetail = LNPSCOREDETAIL.findFirst("where creditratingno='" + creditratingno + "'");
        if (lnpscoredetail != null) {
            RecordSet rs = dc.executeQuery("select opername from ptoper where operid = '" + lnpscoredetail.getInioperid() + "'");
            if (rs.next()) {
                operName = rs.getString("opername");
            }
            StringUtils.getLoadForm(lnpscoredetail, out);
        }
    }
    OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
%>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>条形码编辑</title>
    <script language="javascript" src="/UI/support/tabpane.js"></script>
    <script language="javascript" src="/UI/support/common.js"></script>
    <script language="javascript" src="/UI/support/DataWindow.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
    <script language="javascript" src="barCodeEdit.js"></script>
    <script type="text/javascript" language="javascript">
        document.onkeydown = function TabReplace() {
            if (event.keyCode == 13) {
                if (event.srcElement.tagName != 'BUTTON')
                    event.keyCode = 9;
                else
                    event.srcElement.click();
            }
        }

        function checkNumber(input) {
            var val = input.value;
            var temp = parseInt(val);
            if (val != temp) {
                alert("必须是整数!");
                input.value = "";
                return;
            }
            input.value = temp;
        }

        function setTimelimit(input) {
            var ibdStr = document.getElementById("inibegdate").value;
            var iedStr = input.value;
            if (iedStr <= ibdStr) {
                alert("不得小于初始日期！");
                input.value = "";
                return;
            }

            var timelimit = (parseInt(iedStr.substring(0, 4)) - parseInt(ibdStr.substring(0, 4))) * 12 + (parseInt(iedStr.substring(5, 7)) - parseInt(ibdStr.substring(5, 7)));
            document.getElementById("timelimit").value = timelimit;
        }
    </script>
</head>
<body bgcolor="#ffffff" onLoad="formInit();" class="Bodydefault">
<form id="editForm" name="editForm">
    <!-- 合作项目状态 -->
    <input type="hidden" id="MYPROJSTATUS">
    <br>
    <fieldset>
        <legend>基本信息</legend>
        <table width="100%" cellspacing="0" border="0">
            <!-- 操作类型 -->
            <input type="hidden" id="doType" value="<%=doType%>">
            <!-- 版本号 -->
            <input type="hidden" id="recVersion" value="">
            <!-- 系统日志使用 -->
            <input type="hidden" id="busiNode"/>
            <tr>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">资信评定号</td>
                <td width="30%" class="data_input">
                    <input type="text" id="creditratingno" name="creditratingno" value="" textLength="200"
                           style="width:90%"
                           isNull="false" disabled="disabled">
                </td>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">客户名称</td>
                <td width="30%" class="data_input">
                    <input type="text" id="custname" name="custname" value="" textLength="200" style="width:90%"
                           isNull="false" disabled="disabled">
                </td>
            </tr>
            <tr>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">客户经理</td>
                <td width="30%" class="data_input">
                    <input type="text" id="inioperid" name="inioperid" value="" textLength="200"
                           style="width:90% "
                           isNull="false"
                           disabled="disabled">
                </td>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">评信种类</td>
                <td width="30%" class="data_input">
                    <input type="text" id="loanType" name="loanType" value="普通评信" textLength="200"
                           style="width:90% " isNull="false"
                           disabled="disabled">
                </td>
            </tr>
            <tr>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">初评有效期止日</td>
                <input id="inibegdate" name="inibegdate" type="hidden" value=""/>
                <td width="30%" class="data_input">
                    <input type="text" id="inienddate" name="inienddate" value="" style="width:90%"
                           onClick="WdatePicker()"
                           fieldType="date" onchange="setTimelimit(this);">
                    <span class="red_star">*</span>
                </td>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">期限</td>
                <td width="30%" class="data_input">
                    <input type="text" id="timelimit" name="timelimit" value="" style="width:60%"
                           onchange="checkNumber(this);" isNull="false" disabled="disabled">(单位:月)
                    <span class="red_star">*</span>
                </td>
            </tr>
            <tr>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">金额</td>
                <td width="30%" class="data_input">
                    <input type="text" id="iniamt" name="iniamt" value="" textLength="200" style="width:60% "
                           isNull="false" onchange="checkNumber(this);">(单位:万)
                    <span class="red_star">*</span>
                </td>
            </tr>
        </table>
    </fieldset>
    <br>
    <fieldset>
        <legend>操作信息</legend>
        <table width="100%" class="title1" cellspacing="0">
            <tr>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">操作人员</td>
                <td width="30%" class="data_input">
                    <input type="text" value="<%=omgr.getOperatorName()%>" style="width:90%" disabled="disabled">
                </td>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">操作时间</td>
                <td width="30%" class="data_input">
                    <input type="text" value="<%=BusinessDate.getToday() %>" style="width:90%" disabled="disabled">
                </td>
            </tr>
        </table>
    </fieldset>
    <br>
    <fieldset>
        <legend>操作</legend>
        <table width="100%" class="title1" cellspacing="0">
            <tr>
                <td align="center">
                    <% if (doType.equals("edit")) { %>   <!--增加，修改-->
                    <input id="savebut" class="buttonGrooveDisable" onMouseOver="button_onmouseover()"
                           onmouseout="button_onmouseout()" type="button" value="保存" onclick="saveClick();">
                    <button id="outputReport"
                            onclick="window.open('${pageContext.request.contextPath}/servlet/TiaoXMServlet?creditratingno=<%=creditratingno%>' + '&timelimit='+document.getElementById('timelimit').value + '&iniamt=' + document.getElementById('iniamt').value + '&inienddate=' + document.getElementById('inienddate').value + '&opername=<%=operName%>',null,null);">
                        输出条形码
                    </button>
                    <input id="closebut" class="buttonGrooveDisable" onMouseOver="button_onmouseover()"
                           onmouseout="button_onmouseout()" type="button" value="&nbsp;&nbsp;&nbsp;取消&nbsp;&nbsp;&nbsp;"
                           onclick="window.close();">
                    <%} %>  <!--删除-->
                </td>
            </tr>
        </table>
    </fieldset>
    <br>
</form>
</body>
</html>
