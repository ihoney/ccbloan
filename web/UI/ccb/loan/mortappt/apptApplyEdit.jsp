        <!--
/*********************************************************************
* 功能描述: 抵押预约信息录入
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

    String predays;
    ConnectionManager cm = null;
    try {
        cm = ConnectionManager.getInstance();
        DatabaseConnection dc = cm.get();
        RecordSet chrs = dc.executeQuery("select t.enuitemexpand from ptenudetail t where t.enutype='APPTPARAM' and t.enuitemvalue = 'APPT_APPLY_DAYS'");
        predays = "0";
        if (chrs != null && chrs.next()) {
            predays = chrs.getString("enuitemexpand");
        }
        //提前预约天数对 抵押外勤岗（role:WF0006） 不控制
        OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
        chrs = dc.executeQuery("select roleid from ptoperrole where operid = '" + omgr.getOperatorId() + "' and roleid = 'WF0006'");
        if (chrs != null && chrs.next()) {
            predays = "0";
        }
    } finally {
        if (cm != null) {
            cm.release();
        }
    }

    DateTime dateTime = new DateTime().plusDays(Integer.valueOf(predays));
    String startdate = dateTime.toString("yyyy-MM-dd");

%>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>预约信息</title>
    <script language="javascript" src="/UI/support/tabpane.js"></script>
    <script language="javascript" src="/UI/support/common.js"></script>
    <script language="javascript" src="/UI/support/DataWindow.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
    <script language="javascript" src="apptApplyEdit.js"></script>
</head>
<body bgcolor="#ffffff" onLoad="formInit();" class="Bodydefault">
<div id="container">
    <form id="editForm" name="editForm">
        <fieldset>
            <legend>预约申请信息</legend>
            <table width="100%" cellspacing="0" border="0">
                <!-- 操作类型 -->
                <input type="hidden" id="doType" value="<%=doType%>">
                <input type="hidden" id="appt_date_init" value="<%=startdate%>">
                <input type="hidden" id="appt_date_pre" value="<%=predays%>">
                <tr>
                    <td width="15%" nowrap="nowrap" class="lbl_right_padding">预约日期</td>
                    <td width="35%" class="data_input"><input type="text" id="appt_date" name="appt_date" value="<%=startdate%>"
                                                              onClick="WdatePicker()"
                                                              fieldType="date"
                                                              style="width:90% ">
                    </td>
                </tr>

                <tr>
                    <td width="15%" nowrap="nowrap" class="lbl_right_padding">预约时间</td>
                    <td width="35%" class="data_input" colspan="3">
                        <input id="appt_time1" type="radio" checked="checked" name="appt_time" value="01"/>上午
                        <input id="appt_time2" type="radio" name="appt_time" value="02"/>下午
                    </td>
                </tr>
                </tr>
                <tr>
                    <td width="15%" nowrap="nowrap" class="lbl_right_padding">备注</td>
                    <td width="35%" colspan="3" class="data_input"><textarea name="appt_remark" rows="10"
                                                                             id="appt_remark" style="width:90.4%"
                                                                             textLength="500"></textarea></td>
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
