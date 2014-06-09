<!--
/*********************************************************************
* 功能描述: 个贷客户信息操作
* 修改人: nanmeiying
* 修改日期: 2013/09/01
***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK" %>
<%@include file="/global.jsp" %>
<%@page import="com.ccb.dao.LNUNCOMCREDIT" %>
<%@page import="pub.platform.utils.BusinessDate" %>
<%@page import="pub.platform.utils.StringUtils" %>

<%
    String pkid = "";  //客户号
    String doType = "";   // 操作类型
    String appendNo = request.getParameter("appendNo");
    if (request.getParameter("pkid") != null) {
        pkid = request.getParameter("pkid");
    }
    if (request.getParameter("doType") != null)
        doType = request.getParameter("doType");

    LNUNCOMCREDIT bean = new LNUNCOMCREDIT();
    if (pkid != "") {
        bean = LNUNCOMCREDIT.findFirst("where pkid='" + pkid + "'");
        if (bean != null) {
            StringUtils.getLoadForm(bean, out);
        }
    }
    OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
%>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>非普通资信评定登记表</title>
    <script language="javascript" src="/UI/support/tabpane.js"></script>
    <script language="javascript" src="/UI/support/common.js"></script>
    <script language="javascript" src="/UI/support/DataWindow.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
    <script language="javascript" src="uncomcreditEdit.js"></script>
    <script type="text/javascript">
        document.onkeydown = function TabReplace() {
            if (event.keyCode == 13) {
                if (event.srcElement.tagName != 'BUTTON')
                    event.keyCode = 9;
                else
                    event.srcElement.click();
            }
        }
        function checkID(input) {
            var idType = document.getElementById("idtype").value;
            if (idType != "01") {
                return;
            }
            var idStr = input.value;
            var re = new RegExp("\\d{17}([0-9]|X)");
            var b = re.test(idStr);
            if (!b || idStr.length > 18) {
                alert("输入身份证号格式不对，请重新输入！");
                input.focus();
                return;
            }
            var ageNode = document.getElementById("age");
            var birthdayNode = document.getElementById("birthday");
            var sexNode = document.getElementById("sex");
            var year = idStr.substr(6, 4);
            var month = idStr.substr(10, 2);
            var date = idStr.substr(12, 2);
            ageNode.value = new Date().getFullYear() - parseInt(year);
            birthdayNode.value = year + "-" + month + "-" + date;
            var sexValue = parseInt(idStr.charAt(16));
            if (sexValue % 2 == 0) {
                sexNode.value = "0";
            } else {
                sexNode.value = "1";
            }
        }

        function setAge(input) {
            var btValue = input.value;
            var ageNode = document.getElementById("age");
            ageNode.value = new Date().getFullYear() - parseInt(btValue.substring(0, 4));
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
            var ibdStr = document.getElementById("begdate").value;
            var iedStr = input.value;
            var timelimit = (parseInt(iedStr.substring(0, 4)) - parseInt(ibdStr.substring(0, 4))) * 12 + (parseInt(iedStr.substring(5, 7)) - parseInt(ibdStr.substring(5, 7)));
            document.getElementById("timelimit").value = timelimit;
        }

        function parseToInt(input) {
            input.value = parseInt(input.value);
        }
    </script>
</head>
<body bgcolor="#ffffff" onLoad="formInit();" class="Bodydefault">
<form id="editForm" name="editForm">
<!-- 合作项目状态 -->
<input type="hidden" id="MYPROJSTATUS">
<br>
<fieldset>
    <legend>客户信息</legend>
    <table width="100%" cellspacing="0" border="0">
        <!-- 操作类型 -->
        <input type="hidden" id="doType" value="<%=doType%>">
        <!-- 版本号 -->
        <input type="hidden" id="recVersion" value="">
        <!-- 系统日志使用 -->
        <input type="hidden" id="busiNode"/>
        <tr>

            <td width="20%" nowrap="nowrap" class="lbl_right_padding">资信评定号</td>
            <input type="hidden" id="appendNo" name="appendNo" value="<%=appendNo%>">
            <input type="hidden" id="pkid" name="pkid" value="">
            <td width="30%" class="data_input">
                <input type="text" id="creditratingno" name="creditratingno" value="auto" textLength="200"
                       style="width:90%"
                       isNull="false" disabled="disabled">
                <span class="red_star">*</span>
            </td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">客户名</td>
            <td width="30%" class="data_input">
                <input type="text" id="custname" name="custname" value="" textLength="200" style="width:90%"
                       isNull="false">
                <span class="red_star">*</span>
            </td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">证件类型</td>
            <td width="30%" class="data_input">
                <%
                    ZtSelect zs = new ZtSelect("idtype", "idtype", "");
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
                    zs.addAttr("isNull", "false");
                    zs.addOption("", "");
                    out.print(zs);
                %>
                <span class="red_star">*</span>
            </td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">证件号码</td>
            <td width="30%" class="data_input">
                <input type="text" id="idno" name="idno" value="" textLength="200" style="width:90% " isNull="false"
                       onchange="checkID(this);">
                <span class="red_star">*</span>
            </td>
        </tr>
        <tr>

            <td width="20%" nowrap="nowrap" class="lbl_right_padding">出生日期</td>
            <td width="30%" class="data_input">
                <input type="text" id="birthday" name="birthday" value="" style="width:90%" onClick="WdatePicker()"
                       fieldType="date" isNull="false" onchange="setAge(this);">
                <span class="red_star">*</span>
            </td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">年龄</td>
            <td width="30%" class="data_input">
                <input type="text" id="age" name="age" value="" textLength="200" style="width:90% " isNull="false"
                       disabled="disabled">
                <span class="red_star">*</span>
            </td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">性别</td>
            <td width="30%" class="data_input">
                <%
                    zs = new ZtSelect("sex", "sex", "");
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
                    zs.addAttr("isNull", "false");
                    zs.addOption("", "");
                    out.print(zs);
                %>
                <span class="red_star">*</span>
            </td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">评信方式</td>
            <td width="30%" class="data_input">
                <%
                    zs = new ZtSelect("judgetype", "judgetype", "");
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
                    zs.addAttr("isNull", "false");
                    zs.addOption("", "");
                    out.print(zs);
                %>
                <span class="red_star">*</span>
            </td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">职务</td>
            <td width="30%" class="data_input">
                <input type="text" id="post" name="post" value="" style="width:90%">
            </td>

            <td width="20%" nowrap="nowrap" class="lbl_right_padding">个人月收入</td>
            <td width="30%" class="data_input">
                <input type="text" id="income" name="income" value="" onchange="parseToInt(this);" style="width:90%">
            </td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">评信等级</td>
            <td width="30%" class="data_input">
                <input type="hidden" id="judgelevel" name="judgelevel" value="">
                <select id="judgelevel2" name="judgelevel2"
                        onchange="document.getElementById('judgelevel').value = this.value;">
                    <option value=""></option>
                    <option value="A">A</option>
                    <option value="AA">AA</option>
                    <option value="AAA">AAA</option>
                    <option value="nolevel">nolevel</option>
                </select>
            </td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">是否正式员工</td>
            <td width="30%" class="data_input">
                <select id="formalworker" name="formalworker">
                    <option value=""></option>
                    <option value="是">是</option>
                    <option value="否">否</option>
                </select>
            </td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">有效日期起日</td>
            <td width="30%" class="data_input">
                <input type="text" id="begdate" name="begdate" value="" style="width:90%"
                       onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'enddate\',{d:-1});}'})"
                       fieldType="date" isNull="false">
                <span class="red_star">*</span>
            </td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">有效日期止日</td>
            <td width="30%" class="data_input">
                <input type="text" id="enddate" name="enddate" value="" style="width:90%"
                       onFocus="WdatePicker({minDate:'#F{$dp.$D(\'begdate\',{d:1});}'})"
                       fieldType="date" isNull="false" onchange="setTimelimit(this);">
                <span class="red_star">*</span>
            </td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">期限</td>
            <td width="30%" class="data_input">
                <input type="text" id="timelimit" name="timelimit" value="" style="width:60%"
                       onchange="checkNumber(this);" isNull="false" disabled="disabled">(单位:月)
                <span class="red_star">*</span>
            </td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">评信金额</td>
            <td width="30%" class="data_input">
                <input type="text" id="judgeprice" name="judgeprice" value="" textLength="200" style="width:60% "
                       isNull="false" onchange="checkNumber(this);">(单位:万)
                <span class="red_star">*</span>
            </td>

            <input type="hidden" id="docid" name="docid" value="">
        </tr>

    </table>
</fieldset>
<br/>
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
                <%if (doType.equals("select")) { %><!--查询-->
                <input id="closebut" class="buttonGrooveDisable" onMouseOver="button_onmouseover()"
                       onmouseout="button_onmouseout()" type="button" value="&nbsp;&nbsp;&nbsp;关闭&nbsp;&nbsp;&nbsp;"
                       onclick="window.close();">
                <%} else if (doType.equals("add") || doType.equals("append")) { %>
                <!--增加，追加-->
                <input id="savebut" class="buttonGrooveDisable" onMouseOver="button_onmouseover()"
                       onmouseout="button_onmouseout()" type="button" value="&nbsp;&nbsp;&nbsp;添加&nbsp;&nbsp;&nbsp;"
                       onclick="saveClick();">
                <%} else if (doType.equals("delete")) { %>  <!--删除-->
                <input id="deletebut" class="buttonGrooveDisable" onMouseOver="button_onmouseover()"
                       onmouseout="button_onmouseout()" type="button" value="&nbsp;&nbsp;&nbsp;删除&nbsp;&nbsp;&nbsp;"
                       onclick="deleteClick();">
                <%} else if (doType.equals("edit")) {%>
                <!--修改-->
                <input id="savebut" class="buttonGrooveDisable" onMouseOver="button_onmouseover()"
                       onmouseout="button_onmouseout()" type="button" value="&nbsp;&nbsp;&nbsp;保存&nbsp;&nbsp;&nbsp;"
                       onclick="saveClick();">
                <%}%>
                <input id="closebut" class="buttonGrooveDisable" onMouseOver="button_onmouseover()"
                       onmouseout="button_onmouseout()" type="button" value="&nbsp;&nbsp;&nbsp;取消&nbsp;&nbsp;&nbsp;"
                       onclick="window.close();">
            </td>
        </tr>
    </table>
</fieldset>
<br>
</form>


</body>
</html>
