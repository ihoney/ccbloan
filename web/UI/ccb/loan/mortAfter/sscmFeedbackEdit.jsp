<!--
/*********************************************************************
* 功能描述: 抵押预约处理结果反馈
***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK" %>
<%@include file="/global.jsp" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="org.joda.time.DateTime" %>
<%
    String doType = "";
    String clientNames = "";
    if (request.getParameter("doType") != null)
        doType = request.getParameter("doType");

%>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>单方撤押信息</title>
    <script language="javascript" src="/UI/support/tabpane.js"></script>
    <script language="javascript" src="/UI/support/common.js"></script>
    <script language="javascript" src="/UI/support/DataWindow.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
    <script language="javascript" src="sscmFeedbackEdit.js"></script>
</head>
<body bgcolor="#ffffff" onLoad="formInit();" class="Bodydefault">
<div id="container">
    <form id="editForm" name="editForm">
        <fieldset>
            <legend>预约处理结果反馈</legend>
            <table width="100%" cellspacing="0" border="0">
                <!-- 操作类型 -->
                <input type="hidden" id="doType" value="<%=doType%>">
                <tr>
                    <td width="15%" nowrap="nowrap" class="lbl_right_padding">单方撤押状态</td>
                    <td width="15%" nowrap="nowrap" class="data_input">
                        <%
                            ZtSelect zs = new ZtSelect("SSCM_STATUS", "SSCM_STATUS", "10");
                            zs.addAttr("style", "width: 90%");
                            zs.addAttr("fieldType", "text");
                            //zs.addOption("", "");
                            out.print(zs);
                        %>
                    </td>
                </tr>
                <tr>
                    <td width="15%" nowrap="nowrap" class="lbl_right_padding">未撤押原因</td>
                    <td width="35%" colspan="3" class="data_input"><textarea name="SSCM_NOCANCEL_REASON" rows="10"
                                                                             id="SSCM_NOCANCEL_REASON" style="width:90.4%"
                                                                             textLength="200"></textarea></td>
                </tr>
                <tr>
                    <td width="20%" class="lbl_right_padding">单方撤押时间</td>
                    <td width="30%" class="data_input"><input name="SSCM_DATE" type="text" id="SSCM_DATE"
                                                              style="width:90.4%" onClick="WdatePicker()" fieldType="date"
                                                              isNull="false"><span class="red_star">*</span></td>
                </tr>
                <tr>
                    <td width="15%" nowrap="nowrap" class="lbl_right_padding">借款人姓名</td>
                    <td width="35%" colspan="3" class="data_input"><textarea name="clientNames" rows="2"
                                                                             id="clientNames" style="width:90.4%" readonly="true"
                                                                             ></textarea></td>
                </tr>
            </table>
        </fieldset>
        <fieldset>
            <legend>操作</legend>
            <table width="100%" class="title1" cellspacing="0">
                <tr>
                    <td align="center">
                        <input id="savebut" class="buttonGrooveDisable" onMouseOver="button_onmouseover()"
                               onMouseOut="button_onmouseout()" type="button" value="保存" onClick="saveClick();">
                        <input id="closebut" class="buttonGrooveDisable" onMouseOver="button_onmouseover()"
                               onMouseOut="button_onmouseout()" type="button" value="取消" onClick="window.close();">
                    </td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>
</body>
</html>
