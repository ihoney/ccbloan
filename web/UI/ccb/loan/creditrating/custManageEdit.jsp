<!--
/*********************************************************************
* 功能描述: 个贷客户信息操作
* 修改人: nanmeiying
* 修改日期: 2013/09/01
***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK" %>
<%@include file="/global.jsp" %>
<%@page import="com.ccb.dao.LNPCIF" %>
<%@page import="pub.platform.utils.BusinessDate" %>
<%@page import="pub.platform.utils.StringUtils" %>

<%
    OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
    String custno = "";  //客户号
    String doType = "";   // 操作类型

    if (request.getParameter("custno") != null) {
        custno = request.getParameter("custno");
    }
    if (request.getParameter("doType") != null)
        doType = request.getParameter("doType");

    LNPCIF bean = new LNPCIF();
    if (custno != null) {
        bean = LNPCIF.findFirst("where custno='" + custno + "'");
        if (bean != null) {
            bean.setAge(Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(bean.getBirthday().substring(0, 4)));
            StringUtils.getLoadForm(bean, out);
        }
    }
%>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>客户信息登记表</title>
    <script language="javascript" src="/UI/support/tabpane.js"></script>
    <script language="javascript" src="/UI/support/common.js"></script>
    <script language="javascript" src="/UI/support/DataWindow.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
    <script language="javascript" src="custManageEdit.js"></script>
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
            if (btValue == "") {
                ageNode.value = 0;
            } else {
                ageNode.value = new Date().getFullYear() - parseInt(btValue.substring(0, 4));
            }
        }

        function setHouseAveIncome(input) {
            var homeincomeValue = document.getElementById("homeincome").value;
            var homepersonsValue = parseInt(input.value);
            input.value = homepersonsValue;
            document.getElementById("homeaveincome").value = parseInt(homeincomeValue / homepersonsValue);
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
    <legend>基本信息</legend>
    <table width="100%" cellspacing="0" border="0">
        <!-- 操作类型 -->
        <input type="hidden" id="doType" value="<%=doType%>">
        <!-- 版本号 -->
        <input type="hidden" id="recVersion" value="">
        <!-- 系统日志使用 -->
        <input type="hidden" id="busiNode"/>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">客户号</td>
            <td width="30%" class="data_input">
                <input type="text" id="custno" name="custno" value="auto" textLength="200" style="width:90%"
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
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">家庭地址</td>
            <td width="30%" class="data_input">
                <input type="text" id="homeaddr" name="homeaddr" value="" textLength="200" style="width:90% "
                       isNull="false">
                <span class="red_star">*</span>
            </td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">手机1</td>
            <td width="30%" class="data_input">
                <input type="text" id="mobile1" name="mobile1" value="" textLength="200" style="width:90% "
                       isNull="false">
                <span class="red_star">*</span>
            </td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">手机2</td>
            <td width="30%" class="data_input">
                <input type="text" id="mobile2" name="mobile2" value="" textLength="200" style="width:90% ">
            </td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">其他电话1</td>
            <td width="30%" class="data_input">
                <input type="text" id="tel1" name="tel1" value="" textLength="200" style="width:90% " isNull="false">
                <span class="red_star">*</span>
            </td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">其他电话2</td>
            <td width="30%" class="data_input">
                <input type="text" id="tel2" name="tel2" value="" textLength="200" style="width:90% ">
            </td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">户口性质</td>
            <td width="30%" class="data_input">
                <%
                    zs = new ZtSelect("livetype", "livetype", "");
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
                    zs.addAttr("isNull", "false");
                    zs.addOption("", "");
                    out.print(zs);
                %>
                <span class="red_star">*</span>
            </td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">文化程度</td>
            <td width="30%" class="data_input">
                <%
                    zs = new ZtSelect("education", "education", "");
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
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">婚姻状况</td>
            <td width="30%" class="data_input">
                <%
                    zs = new ZtSelect("marista", "marista", "");
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
                    zs.addAttr("isNull", "false");
                    zs.addOption("", "");
                    out.print(zs);
                %>
                <span class="red_star">*</span>
            </td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">健康状况</td>
            <td width="30%" class="data_input">
                <%
                    zs = new ZtSelect("health", "health", "");
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
                    zs.addAttr("isNull", "false");
                    zs.addOption("", "");
                    out.print(zs);
                %>
                <span class="red_star">*</span>
            </td>
        </tr>
    </table>
</fieldset>
<br>
<fieldset>
    <legend>附加信息一</legend>
    <table width="100%" cellspacing="0" border="0">
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">单位类别</td>
            <td width="30%" class="data_input">
                <%
                    zs = new ZtSelect("corptype", "corptype", "");
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
                    zs.addAttr("isNull", "false");
                    zs.addOption("", "");
                    out.print(zs);
                %>
                <span class="red_star">*</span>
            </td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">单位名称</td>
            <td width="30%" class="data_input">
                <input type="text" id="corpname" name="corpname" value="" textLength="200" style="width:90% "
                       isNull="false">
                <span class="red_star">*</span>
            </td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">单位电话</td>
            <td width="30%" class="data_input">
                <input type="text" id="corptel" name="corptel" value="" textLength="200" style="width:90% ">
            </td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">单位地址</td>
            <td width="30%" class="data_input">
                <input type="text" id="corpaddr" name="corpaddr" value="" textLength="200" style="width:90% "
                       isNull="false">
                <span class="red_star">*</span>
            </td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">单位邮编</td>
            <td width="30%" class="data_input">
                <input type="text" id="corpzip" name="corpzip" value="" textLength="200" style="width:90% ">
            </td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">单位经济状况</td>
            <td width="30%" class="data_input">
                <%
                    zs = new ZtSelect("corpfin", "corpfin", "");
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
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">从事行业发展情况</td>
            <td width="30%" class="data_input">
                <%
                    zs = new ZtSelect("busifuture", "busifuture", "");
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
                    zs.addAttr("isNull", "false");
                    zs.addOption("", "");
                    out.print(zs);
                %>
                <span class="red_star">*</span>
            </td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">本岗位工作年限</td>
            <td width="30%" class="data_input">
                <input type="text" id="workyears" name="workyears" value="" textLength="200" style="width:90% "
                       isNull="false" onchange="parseToInt(this);">
                <span class="red_star">*</span>
            </td>

        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">所在部门</td>
            <td width="30%" class="data_input">
                <input type="text" id="deptname" name="deptname" value="" textLength="200" style="width:90% "
                       isNull="false">
                <span class="red_star">*</span>
            </td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">职务级别</td>
            <td width="30%" class="data_input">
                <%
                    zs = new ZtSelect("posttype", "posttype", "");
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
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">现任职位</td>
            <td width="30%" class="data_input">
                <input type="text" id="post" name="post" value="" textLength="200" style="width:90% " isNull="false">
                <span class="red_star">*</span>
            </td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">职称</td>
            <td width="30%" class="data_input">
                <%
                    zs = new ZtSelect("postlevel", "postlevel", "");
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
                    zs.addAttr("isNull", "false");
                    zs.addOption("", "");
                    out.print(zs);
                %>
                <span class="red_star">*</span>
            </td>
        </tr>
    </table>
</fieldset>
<br>
<fieldset>
    <legend>附加信息二</legend>
    <table width="100%" cellspacing="0" border="0">
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">个人月收入</td>
            <td width="30%" class="data_input">
                <input type="text" id="income" name="income" value="" textLength="50" onchange="parseToInt(this);"
                       style="width:90% " isNull="false">
                <span class="red_star">*</span>
            </td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">家庭月收入</td>
            <td width="30%" class="data_input">
                <input type="text" id="homeincome" name="homeincome" onchange="parseToInt(this);" value=""
                       textLength="50" style="width:90% "
                       isNull="false">
                <span class="red_star">*</span>
            </td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">家庭人口数</td>
            <td width="30%" class="data_input">
                <input type="text" id="homepersons" name="homepersons" value="" textLength="50" style="width:90% "
                       isNull="false" onchange="setHouseAveIncome(this);">
                <span class="red_star">*</span>
            </td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">家庭人均月收入</td>
            <td width="30%" class="data_input">
                <input type="text" id="homeaveincome" name="homeaveincome" value="" textLength="50" style="width:90% "
                       isNull="false" disabled="disabled">
                <span class="red_star">*</span>
            </td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">是否本行员工</td>
            <td width="30%" class="data_input">
                <%
                    zs = new ZtSelect("memberflg", "memberflg", "");
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
                    zs.addAttr("isNull", "false");
                    zs.addOption("", "");
                    out.print(zs);
                %>
                <span class="red_star">*</span>
            </td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">本行账户</td>
            <td width="30%" class="data_input">
                <%
                    zs = new ZtSelect("actflg", "actflg", "");
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
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">本行存款余额</td>
            <td width="30%" class="data_input">
                <%
                    zs = new ZtSelect("savbal", "savbal", "");
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
                    zs.addAttr("isNull", "false");
                    zs.addOption("", "");
                    out.print(zs);
                %>
                <span class="red_star">*</span>
            </td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">本行业务往来</td>
            <td width="30%" class="data_input">
                <%
                    zs = new ZtSelect("busirate", "busirate", "");
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
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">家庭邮编</td>
            <td width="30%" class="data_input">
                <input type="text" id="homezip" name="homezip" value="" textLength="50" style="width:90% ">
            </td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">本行借款情况</td>
            <td width="30%" class="data_input">
                <%
                    zs = new ZtSelect("loansta", "loansta", "");
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
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">他行信用情况</td>
            <td width="30%" class="data_input">
                <%
                    zs = new ZtSelect("otherloansta", "otherloansta", "");
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
                    zs.addAttr("isNull", "false");
                    zs.addOption("", "");
                    out.print(zs);
                %>
                <span class="red_star">*</span>
            </td>
        </tr>
    </table>
</fieldset>
<br>
<fieldset>
    <legend>附加信息三</legend>
    <table width="100%" cellspacing="0" border="0">
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">配偶姓名</td>
            <td width="30%" class="data_input">
                <input type="text" id="spousename" name="spousename" value="" textLength="50" style="width:90% ">
            </td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">配偶电话</td>
            <td width="30%" class="data_input">
                <input type="text" id="spousetel" name="spousetel" value="" textLength="50" style="width:90% ">
            </td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">配偶身份证号</td>
            <td width="30%" class="data_input">
                <input type="text" id="spouseidno" name="spouseidno" value="" textLength="50" style="width:90% ">
            </td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">配偶单位地址</td>
            <td width="30%" class="data_input">
                <input type="text" id="spousecorpaddr" name="spousecorpaddr" value="" textLength="50"
                       style="width:90% ">
            </td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">配偶月收入</td>
            <td width="30%" class="data_input">
                <input type="text" id="spouseincome" name="spouseincome" onchange="parseToInt(this);" value=""
                       textLength="50" style="width:90% ">
            </td>
        </tr>
    </table>
</fieldset>
<br>
<fieldset>
    <legend>附加信息四</legend>
    <table width="100%" cellspacing="0" border="0">
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">税务登记证号</td>
            <td width="30%" class="data_input">
                <input type="text" id="taxregno" name="taxregno" value="" textLength="50" style="width:90% ">
            </td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">营业执照号</td>
            <td width="30%" class="data_input">
                <input type="text" id="busilicno" name="busilicno" value="" textLength="50" style="width:90% ">
            </td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">组织机构代码证号</td>
            <td width="30%" class="data_input">
                <input type="text" id="orgcode" name="orgcode" value="" textLength="50" style="width:90% ">
            </td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">建立机构号</td>
            <td width="30%" class="data_input">
                <input type="text" id="deptid" name="deptid" value=""
                       textLength="50" style="width:90% " disabled="disabled">
            </td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">建立柜员</td>
            <td width="30%" class="data_input">
                <input type="text" id="operid" name="operid" value="" textLength="50" style="width:90% "
                       disabled="disabled">
            </td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">修改柜员</td>
            <td width="30%" class="data_input">
                <input type="text" id="updoperid" name="updoperid"
                       value="" textLength="50" style="width:90% " disabled="disabled">
            </td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">建立日期</td>
            <td width="30%" class="data_input">
                <input type="text" id="operdate" name="operdate"
                       value="" style="width:90%" fieldType="date" disabled="disabled">
            </td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">修改日期</td>
            <td width="30%" class="data_input">
                <input type="text" id="upddate" name="upddate" disabled="disabled" value="" style="width:90%"
                       fieldType="date">
            </td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">备注</td>
            <td width="30%" colspan="3" class="data_input">
                <textarea name="remark" rows="8" id="remark" value="" style="width:90%" textLength="2000"></textarea>
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
                <%if (doType.equals("select")) { %><!--查询-->
                <input id="closebut" class="buttonGrooveDisable" onMouseOver="button_onmouseover()"
                       onmouseout="button_onmouseout()" type="button" value="&nbsp;&nbsp;&nbsp;关闭&nbsp;&nbsp;&nbsp;"
                       onclick="window.close();">
                <%} else if (doType.equals("edit") || doType.equals("add")) { %>   <!--增加，修改-->
                <input id="savebut" class="buttonGrooveDisable" onMouseOver="button_onmouseover()"
                       onmouseout="button_onmouseout()" type="button" value="&nbsp;&nbsp;&nbsp;保存&nbsp;&nbsp;&nbsp;"
                       onclick="saveClick();">
                <input id="closebut" class="buttonGrooveDisable" onMouseOver="button_onmouseover()"
                       onmouseout="button_onmouseout()" type="button" value="&nbsp;&nbsp;&nbsp;取消&nbsp;&nbsp;&nbsp;"
                       onclick="window.close();">
                <%} else if (doType.equals("delete")) { %>  <!--删除-->
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
<br>
</form>
</body>
</html>
