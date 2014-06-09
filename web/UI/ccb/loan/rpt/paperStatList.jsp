<!--
/*********************************************************************
* 功能描述: 权证库存统计
* 作 者: leonwoo
* 开发日期: 2010/01/16
* 修 改 人:
* 修改日期:
* 版 权: 公司
***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK" %>
<%@include file="/global.jsp" %>
<%
    OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
%>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title></title>
    <script language="javascript" src="paperStatList.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
    <script language="javascript" src="/UI/support/common.js"></script>
    <script language="javascript" src="/UI/support/DataWindow.js"></script>
</head>
<body onload="formInit()" bgcolor="#ffffff" class="Bodydefault">

<fieldset style="padding:40px 25px 0px 25px;margin:0px 20px 0px 20px">
    <%--<div class="title">根据入库日期、贷款结清取证日期、借证领用日期、借证归还日期计算权证库存量</div>--%>
    <legend>查询条件</legend>
        <br>
    <table border="0" cellspacing="0" cellpadding="0" width="100%">
        <form id="queryForm" name="queryForm">
            <!-- 组合查询统计类型一 -->
            <input type="hidden" value="miscRpt03" id="rptType" name="rptType"/>
            <tr>
                <td width="30%" nowrap="nowrap" class="lbl_right_padding">截止日期</td>
                <td width="70%" nowrap="nowrap" class="data_input"><input type="text" id="MORTEXPIREDATE"
                                                                          name="MORTEXPIREDATE" onClick="WdatePicker()"
                                                                          fieldType="date" style="width:35%"
                                                                          isNull="false"><span class="red_star">*</span>
                </td>

            </tr>
            <tr>
                <td width="30%" nowrap="nowrap" class="lbl_right_padding">机构</td>
                <td width="70%" nowrap="nowrap" class="data_input">
                    <%
                        ZtSelect zs = new ZtSelect("bankid", "", omgr.getOperator().getDeptid());
                        zs.setSqlString("select deptid, LPad('&nbsp;', (level - 1) * 36, '&nbsp;') || deptname  from ptdept"
                                + " start with deptid = '" + omgr.getOperator().getDeptid() + "'"
                                + " connect by prior deptid = parentdeptid");
                        zs.addAttr("style", "width: 35%");
                        zs.addAttr("fieldType", "text");
                        out.print(zs);
                    %>
                </td>
            </tr>
            <tr>
                <td colspan="2" nowrap="nowrap" align="center" style="padding:20px">
                    <input name="expExcel" class="buttonGrooveDisableExcel" type="button"
                           onClick="loanTab_expExcel_click()" value="导出excel">
                    <input type="reset" value="重填" class="buttonGrooveDisable">
                </td>
            </tr>
        </form>
    </table>
</fieldset>
</body>
</html>
