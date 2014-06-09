<!--
/*********************************************************************
* 功能描述: 抵押信息管理抵押详细页面;抵押信息登记
*
* 作 者: leonwoo
* 开发日期: 2010/01/16
* 修 改 人:
* 修改日期:
* 版 权: 公司
***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK" %>
<%@include file="/global.jsp" %>
<%@ page import="com.ccb.dao.*" %>
<%@ page import="com.ccb.util.*" %>

<%
    // 贷款申请序号
    String loanID = "";
    // 操作类型
    String doType = "";
    // 抵押编号
    String mortID = "";
    // 合作项目对象
    LNLOANAPPLY loan = null;

    if (request.getParameter("loanID") != null)
        loanID = request.getParameter("loanID");

    if (request.getParameter("doType") != null)
        doType = request.getParameter("doType");
    if ("add".equalsIgnoreCase(doType)) {
        // 自动取出抵押编号
        // //mortID = SeqUtil.getSeq(CcbLoanConst.MORTTYPE);
        // 取出放款方式
        loan = LNLOANAPPLY.findFirst(" where loanid='" + loanID + "'");

        if (loan == null) {
            loan = new LNLOANAPPLY();
        }
    } else {
        if (request.getParameter("mortID") != null)
            mortID = request.getParameter("mortID");
        // 初始化页面
        LNMORTINFO bean = LNMORTINFO.findFirst("where mortid='" + mortID + "'");
        if (bean != null) {
            StringUtils.getLoadForm(bean, out);
        }
    }

    OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);

%>
<html>


<head>

    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>抵押信息登记</title>

    <script language="javascript" src="/UI/support/tabpane.js"></script>
    <script language="javascript" src="/UI/support/common.js"></script>
    <script language="javascript" src="/UI/support/DataWindow.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
    <script language="javascript" src="mortRegEdit.js"></script>

</head>
<body bgcolor="#ffffff" onload="formInit();" class="Bodydefault">
<br>

<div id="container">
    <form id="editForm" name="editForm">
        <fieldset>
            <legend>抵押信息登记</legend>
            <table width="100%" cellspacing="0" border="0">
                <!-- 操作类型 -->
                <input type="hidden" id="doType" value="<%=doType%>">
                <!-- 版本号 -->
                <input type="hidden" id="recVersion" value="">
                <tr>
                    <td width="20%" nowrap="nowrap" class="lbl_right_padding">业务流水号</td>
                    <td width="30%" class="data_input"><input type="text" id="FLOWSN" name="FLOWSN" value="<%=loanID%>"
                                                              style="width:96% " disabled="disabled"></td>
                </tr>
                <tr>
                    <td width="20%" nowrap="nowrap" class="lbl_right_padding">贷款申请序号</td>
                    <td width="30%" class="data_input"><input type="text" id="loanID" name="loanID" value="<%=loanID%>"
                                                              style="width:96% " disabled="disabled"></td>
                </tr>
                <tr>
                    <td width="20%" nowrap="nowrap" class="lbl_right_padding">抵押交易中心</td>
                    <td width="30%" class="data_input"><%
                        ZtSelect zs = new ZtSelect("MORTECENTERCD", "MORTECENTERCD", "01");
                        zs.addAttr("style", "width: 40%");
                        zs.addAttr("fieldType", "text");
                        zs.addAttr("isNull", "false");
                        //zs.addOption("", "");
                        //zs.setDisplayAll(false);
                        out.print(zs);
                    %><span class="red_star">*</span></td>
                </tr>
                <tr>
                    <td width="20%" nowrap="nowrap" class="lbl_right_padding">放款方式</td>
                    <td width="30%" class="data_input"><%
                        if ("add".equalsIgnoreCase(doType)) {
                            zs = new ZtSelect("RELEASECONDCD", "RELEASECONDCD", loan.getReleasecondcd());
                            //zs.addAttr("disabled","disabled");
                        } else {
                            zs = new ZtSelect("RELEASECONDCD", "RELEASECONDCD");
                            //zs.addAttr("disabled","disabled");
                        }
                        zs.addAttr("style", "width: 40%");
                        zs.addAttr("fieldType", "text");
                        zs.addAttr("isNull", "false");
                        zs.addOption("", "");
                        out.print(zs);
                    %><span class="red_star">*</span></td>
                </tr>
                <%--
                  <tr>
                    <td width="20%"  class="lbl_right_padding">保管内容</td>
                  <td width="30%"  class="data_input"><%
                    zs = new ZtSelect("KEEPCONT", "KEEPCONT", "01");
                    zs.addAttr("style", "width: 40%");
                    zs.addAttr("fieldType", "text");
                    //zs.addAttr("isNull","false");
                    zs.addOption("","");
                    out.print(zs);
                  %></td>
                </tr>--%>

                <tr>
                    <td width="20%" class="lbl_right_padding">抵押接收日期</td>
                    <td width="30%" class="data_input"><input name="MORTDATE" type="text" id="MORTDATE"
                                                              style="width:40%" onClick="WdatePicker()" fieldType="date"
                                                              isNull="false"><span class="red_star">*</span></td>

                </tr>
                <tr>
                    <td width="20%" class="lbl_right_padding">是否办理保险</td>
                    <td width="30%" class="data_input">
                        <%
                            zs = new ZtSelect("attendflag", "BOOLTYPE", "0");
                            zs.addAttr("style", "width: 40%");
                            zs.addAttr("fieldType", "text");
                            //zs.addAttr("isNull","false");
                            out.print(zs);
                        %>
                    </td>
                </tr>

            </table>
        </fieldset>

        <br>
        <fieldset>
            <legend>操作信息</legend>

            <table width="100%" cellspacing="0" border="0">

                <tr>
                    <td width="20%" nowrap="nowrap" class="lbl_right_padding">操作人员</td>
                    <td width="30%" class="data_input"><input type="text" value="<%=omgr.getOperatorName()%>"
                                                              style="width:90%" disabled="disabled"></td>
                    <td width="20%" nowrap="nowrap" class="lbl_right_padding">操作时间</td>
                    <td width="30%" class="data_input"><input type="text" value="<%=BusinessDate.getToday() %>"
                                                              style="width:90%" disabled="disabled"></td>
                </tr>
            </table>
        </fieldset>
        <br>
        <fieldset>
            <legend>操作</legend>
            <table width="100%" class="title1" cellspacing="0">
                <tr>
                    <td align="center">
                        <!--查询-->
                        <%if (doType.equals("select")) { %>
                        <input id="closebut" class="buttonGrooveDisable" onmouseover="button_onmouseover()"
                               onmouseout="button_onmouseout()" type="button" value="关闭" onclick="window.close();">
                        <%} else if (doType.equals("edit") || doType.equals("add")) { %>
                        <!--增加，修改-->
                        <input id="savebut" class="buttonGrooveDisable" onmouseover="button_onmouseover()"
                               onmouseout="button_onmouseout()" type="button" value="保存" onclick="saveClick();">
                        <input id="closebut" class="buttonGrooveDisable" onmouseover="button_onmouseover()"
                               onmouseout="button_onmouseout()" type="button" value="取消" onclick="window.close();">
                        <%} else if (doType.equals("delete")) { %>
                        <!--删除-->
                        <input id="deletebut" class="buttonGrooveDisable" onmouseover="button_onmouseover()"
                               onmouseout="button_onmouseout()" type="button" value="删除" onclick="deleteClick();">
                        <input id="closebut" class="buttonGrooveDisable" onmouseover="button_onmouseover()"
                               onmouseout="button_onmouseout()" type="button" value="取消" onclick="window.close();">
                        <%} %>
                    </td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>
</body>
</html>
