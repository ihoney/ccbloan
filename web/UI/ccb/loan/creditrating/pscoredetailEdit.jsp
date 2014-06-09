<!--
/*********************************************************************
* 功能描述: 客户评分等级维护
*
* 作 者: nanmeiying
* 开发日期: 2013/09/03
***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK" %>
<%@include file="/global.jsp" %>
<%@page import="com.ccb.dao.LNPSCOREDETAIL" %>
<%@page import="pub.platform.utils.BusinessDate" %>
<%@page import="pub.platform.utils.StringUtils" %>
<%
    String creditratingno = "";  // 内部序号
    String doType = "";  // 操作类型
    if (request.getParameter("creditratingno") != null) {
        creditratingno = request.getParameter("creditratingno");
    }
    if (request.getParameter("doType") != null)
        doType = request.getParameter("doType");
    LNPSCOREDETAIL bean = new LNPSCOREDETAIL();
    if (creditratingno != null) {
        bean = LNPSCOREDETAIL.findFirst("where creditratingno='" + creditratingno + "'");
        if (bean != null) {
            StringUtils.getLoadForm(bean, out);
        }
    }
    OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
%>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>终评录入页面</title>
    <script type="text/javascript" src="/UI/support/tabpane.js"></script>
    <script type="text/javascript" src="/UI/support/common.js"></script>
    <script type="text/javascript" src="/UI/support/DataWindow.js"></script>
    <script type="text/javascript" src="/UI/support/pub.js"></script>
    <script type="text/javascript" src="pscoredetailEdit.js"></script>
    <script type="text/javascript">
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
    </script>
</head>
<body bgcolor="#ffffff" onLoad="formInit();" class="Bodydefault">
<form id="editForm" name="editForm">
    <!-- 合作项目状态 -->
    <input type="hidden" id="MYPROJSTATUS">
    <br>
    <fieldset>
        <legend>终评信息</legend>
        <table width="100%" cellspacing="0" border="0">
            <input type="hidden" id="doType" value="<%=doType%>">
            <!-- 版本号 -->
            <input type="hidden" id="recVersion" value="">
            <!-- 系统日志使用 -->
            <input type="hidden" id="busiNode"/>
            <tr>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">资信评定号</td>

                <td width="30%" class="data_input">
                    <input type="hidden" id="idno" name="idno"/>
                    <input type="text" id="creditratingno" name="creditratingno" value="" textLength="200"
                           style="width:90%"
                           isNull="false"
                           disabled="disabled">
                    <span class="red_star">*</span>
                </td>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">客户号</td>
                <td width="30%" class="data_input">
                    <input type="text" id="custno" name="custno" value="" textLength="200" style="width:90%"
                           disabled="disabled">
                    <span class="red_star">*</span>
                </td>
            </tr>
            <tr>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">终评得分</td>
                <td width="30%" class="data_input">
                    <input type="text" id="finscore" name="finscore" value="" textLength="200"
                           style="width:90%"
                           disabled="disabled">
                    <span class="red_star">*</span>
                </td>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">终评等级</td>
                <td width="30%" class="data_input">
                    <input type="text" id="finlevel" name="finlevel" value="" textLength="200"
                           style="width:90% "
                           disabled="disabled">
                    <span class="red_star">*</span>
                </td>
            </tr>
            <tr>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">终评额度</td>
                <td width="30%" class="data_input">
                    <input type="text" id="finamt" name="finamt" value="" textLength="200"
                           style="width:60% "
                           onchange="checkNumber(this);">(单位:万)
                    <span class="red_star">*</span>
                </td>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">终评操作员</td>
                <td width="30%" class="data_input">
                    <input type="text" id="finoperid" name="finoperid" value="" textLength="200" style="width:90% "
                           disabled="disabled">
                    <span class="red_star">*</span>
                </td>
            </tr>
            <tr>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">终评日期</td>
                <td width="30%" class="data_input">
                    <input type="text" id="findate" name="findate" value="" style="width:90%" onClick="WdatePicker()"
                           fieldType="date" disabled="disabled">
                    <span class="red_star">*</span>
                </td>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">终评机构号</td>
                <td width="30%" class="data_input">
                    <input type="text" id="findeptid" name="findeptid" value="" textLength="200" style="width:90% "
                           disabled="disabled">
                    <span class="red_star">*</span>
                </td>
            </tr>
            <tr>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">终评有效期起日</td>
                <td width="30%" class="data_input">
                    <input type="text" id="finbegdate" name="finbegdate" value="" style="width:90%"
                           onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'finenddate\',{d:-1});}'})"
                           fieldType="date">
                    <span class="red_star">*</span>
                </td>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">终评有效期止日</td>
                <td width="30%" class="data_input">
                    <input type="text" id="finenddate" name="finenddate" value="" style="width:90%"
                           onFocus="WdatePicker({minDate:'#F{$dp.$D(\'finbegdate\',{d:1});}'})"
                           fieldType="date">
                    <span class="red_star">*</span>
                    <input type="hidden" id="docid" name="docid" value="">
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
                <td align="center"><!--查询-->
                    <%if (doType.equals("select")) { %>
                    <input id="closebut" class="buttonGrooveDisable" onMouseOver="button_onmouseover()"
                           onmouseout="button_onmouseout()" type="button" value="&nbsp;&nbsp;&nbsp;关闭&nbsp;&nbsp;&nbsp;"
                           onclick="window.close();">
                    <%} else if (doType.equals("edit") || doType.equals("add")) { %> <!--增加，修改-->
                    <input id="savebut" class="buttonGrooveDisable" onMouseOver="button_onmouseover()"
                           onmouseout="button_onmouseout()" type="button" value="&nbsp;&nbsp;&nbsp;保存&nbsp;&nbsp;&nbsp;"
                           onclick="saveClick();">
                    <input id="closebut" class="buttonGrooveDisable" onMouseOver="button_onmouseover()"
                           onmouseout="button_onmouseout()" type="button" value="&nbsp;&nbsp;&nbsp;取消&nbsp;&nbsp;&nbsp;"
                           onclick="window.close();">
                    <%} else if (doType.equals("delete")) { %> <!--删除-->
                    <input id="deletebut" class="buttonGrooveDisable" onMouseOver="button_onmouseover()"
                           onmouseout="button_onmouseout()" type="button" value="&nbsp;&nbsp;&nbsp;删除&nbsp;&nbsp;&nbsp;"
                           onclick="deleteClick();">
                    <input id="closebut" class="buttonGrooveDisable" onMouseOver="button_onmouseover()"
                           onmouseout="button_onmouseout()" type="button" value="&nbsp;&nbsp;&nbsp;取消&nbsp;&nbsp;&nbsp;"
                           onclick="window.close();">
                    <%} %>
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
