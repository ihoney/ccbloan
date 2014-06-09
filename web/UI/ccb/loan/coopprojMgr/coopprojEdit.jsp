<!--
/*********************************************************************
* 功能描述: 合作项目管理详细页面
*
* 作 者:
* 开发日期: 2010/01/21
* 修 改 人:
* 修改日期:
* 版 权:
***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK" %>
<%@include file="/global.jsp" %>
<%@page import="pub.platform.security.OperatorManager" %>
<%@page import="pub.platform.form.config.SystemAttributeNames" %>
<%@page import="pub.platform.utils.*" %>
<%@page import="com.ccb.dao.*" %>
<%@page import="com.ccb.util.*" %>
<%
    // 内部序号
    String proj_nbxh = "";
    // 操作类型
    String doType = "";

    //是否显示 开发贷抵押办理时限方式 字段
    boolean isShowDevlntimelimittye = false;

    if (request.getParameter("proj_nbxh") != null) {
        proj_nbxh = request.getParameter("proj_nbxh");
    }

    if (request.getParameter("doType") != null)
        doType = request.getParameter("doType");

    //异常处理？
    LNCOOPPROJ bean = new LNCOOPPROJ();

    // 初始化页面
    if (proj_nbxh != null) {
        bean = LNCOOPPROJ.findFirst("where proj_nbxh='" + proj_nbxh + "'");
        if (bean != null) {
            StringUtils.getLoadForm(bean, out);
        }
    }

    if (bean != null) {
        if ((!"".equals(bean.getBankflag())) && (!"0".equals(bean.getBankflag()))) {
            isShowDevlntimelimittye = true;
        }
    } else {
        isShowDevlntimelimittye = true;
    }

    OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);

%>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>合作项目信息登记</title>
    <script language="javascript" src="/UI/support/tabpane.js"></script>
    <script language="javascript" src="/UI/support/common.js"></script>
    <script language="javascript" src="/UI/support/DataWindow.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
    <script language="javascript" src="coopprojEdit.js"></script>
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
        <input type="hidden" id="proj_nbxh" value="<%=proj_nbxh%>"/>
        <!-- 系统日志使用 -->
        <input type="hidden" id="busiNode"/>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">合作项目编号</td>
            <td width="80%" colspan="3" class="data_input"><input type="text" id="proj_no" name="proj_no"
                                                                  value=""
                                                                  textLength="20" style="width:33.5%"
                                                                  isNull="false">
                <span class="red_star">*</span></td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">合作项目名称</td>
            <td width="30%" colspan="3" class="data_input"><input type="text" id="proj_name" name="proj_name"
                                                                  value=""
                                                                  textLength="200" style="width:96.4% "
                                                                  isNull="false">
                <span class="red_star">*</span></td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">合作项目简称</td>
            <td width="30%" colspan="3" class="data_input"><input type="text" id="proj_name_abbr" name="proj_name_abbr"
                                                                  value=""
                                                                  textLength="50" style="width:33.5% "
                                                                  isNull="false">
                <span class="red_star">*</span></td>
        </tr>
        <%--

                <tr>
                    <td width="20%" nowrap="nowrap" class="lbl_right_padding">合作项目状态</td>
                    <td width="80%" colspan="3" class="data_input"><input type="text" id="projstatus" name="projstatus"
                                                                          value=""
                                                                          textLength="100" style="width:20% "
                            ></td>
                </tr>

        --%>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">合作方编号</td>
            <td width="30%" colspan="3" class="data_input"><input type="text" id="corpid" name="corpid"
                                                                  value="" textLength="20" style="width:33.5%"
                                                                  isNull="false">
                <span class="red_star">*</span></td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">合作方名称</td>
            <td width="30%" colspan="3" class="data_input"><input type="text" id="corpname" name="corpname"
                                                                  value="" textLength="100" style="width:96.4%"
                                                                  isNull="false">
                <span class="red_star">*</span></td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">楼盘坐落位置</td>
            <td width="30%" colspan="3" class="data_input"><input type="text" id="builaddr" name="builaddr"
                                                                  value="" textLength="200" style="width:96.4%"
                                                                  isNull="false">
                <span class="red_star">*</span></td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">经营中心</td>
            <td width="30%" class="data_input">
                <%
                    ZtSelect zs = new ZtSelect("CUST_BANKID", "", "");
                    zs.setSqlString("select deptid, deptname  from ptdept where FILLSTR10='3'"
                            + " start with deptid = '" + omgr.getOperator().getDeptid() + "'"
                            + " connect by prior deptid = parentdeptid  order by deptid");
                    zs.addAttr("style", "width: 90%");
                    zs.addAttr("fieldType", "text");
                    zs.addAttr("isNull", "false");
                    zs.addOption("", "");
                    out.print(zs);
                %> <span class="red_star">*</span>
            </td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">经办行</td>
            <td width="30%" class="data_input"><%
                zs = new ZtSelect("BANKID", "", omgr.getOperator().getDeptid());
                zs.setSqlString("select deptid, LPad('&nbsp;', (level - 1) * 36, '&nbsp;') || deptname  from ptdept"
                        + " start with deptid = '" + omgr.getOperator().getDeptid() + "'"
                        + " connect by prior deptid = parentdeptid");
                zs.addAttr("style", "width: 90%");
                zs.addAttr("fieldType", "text");
                zs.addAttr("isNull", "false");
                zs.addOption("", "");
                out.print(zs);
            %>
                <span class="red_star">*</span></td>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">录入日期</td>
            <td width="30%" class="data_input"><input type="text" id="inputdate" name="inputdate" value=""
                                                      style="width:33.5%" onClick="WdatePicker()" fieldType="date"
                                                      isNull="false">
                <span class="red_star">*</span></td>
        </tr>
        </tr>

    </table>
</fieldset>
<br>
<fieldset>
    <legend>附加信息一</legend>
    <table width="100%" cellspacing="0" border="0">
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">被保证债权起始日期</td>
            <td width="30%" class="data_input"><input type="text" id="assustartdate" name="assustartdate" value=""
                                                      style="width:90%" onClick="WdatePicker()" fieldType="date"
                    ></td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">被保证债权截止日期</td>
            <td width="30%" class="data_input"><input type="text" id="assuenddate" name="assuenddate" value=""
                                                      style="width:90%" onClick="WdatePicker()" fieldType="date"
                    ></td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">合作期限(年)</td>
            <td width="30%" class="data_input"><input type="text" id="coopperiod" name="coopperiod"
                                                      value="" textLength="5"
                                                      style="width:90% "></td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">合作额度(万元)</td>
            <td width="30%" class="data_input"><input type="text" id="cooplimitamt" name="cooplimitamt"
                                                      value="" textLength="10"
                                                      style="width:90% "></td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">最高贷款比例(%)</td>
            <td width="30%" class="data_input"><input type="text" id="maxlnpercent" name="maxlnpercent"
                                                      value="" textLength="10"
                                                      style="width:90% " intLength="2" floatLength="3"></td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">最长贷款期限(年)</td>
            <td width="30%" class="data_input"><input type="text" id="maxlnperiod" name="maxlnperiod"
                                                      value="" textLength="5"
                                                      style="width:90% "></td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">保证期间说明</td>
            <td width="30%" colspan="3" class="data_input"><textarea name="assuperiod" rows="5" id="assuperiod"
                                                                     value=""
                                                                     style="width:96.4%" textLength="2000"></textarea>
            </td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">合作协议种类</td>
            <td width="30%" class="data_input"><%
                zs = new ZtSelect("AGREEMENTCD", "COOPAGREEMENTCD", "1");
                zs.addAttr("style", "width: 90%");
                zs.addAttr("fieldType", "text");
                zs.addAttr("isNull", "false");
                zs.addOption("", "");
                out.print(zs);
            %>
                <span class="red_star">*</span></td>
            <%--</tr>--%>
            <%----%>
            <%--<tr>--%>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">合作协议编号</td>
            <td width="30%" colspan="3" class="data_input"><input type="text" name="agreementno" id="agreementno"
                                                                  value=""
                                                                  style="width:90%" textLength="100">
            </td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">约定放款方式</td>
            <td width="30%" class="data_input"><%
                zs = new ZtSelect("RELEASECONDCD", "RELEASECONDCD", "01");
                zs.addAttr("style", "width: 90%");
                zs.addAttr("fieldType", "text");
                zs.addAttr("isNull", "false");
                zs.addOption("", "");
                out.print(zs);
            %>
                <span class="red_star">*</span></td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">后续抵押办理时限(天)</td>
            <td width="30%" class="data_input"><input type="text" id="followupmortperiod" name="followupmortperiod"
                                                      value="" textLength="10"
                                                      style="width:90%" intLength="10" floatLength="0"
                                                      isNull="false">
                <span class="red_star">*</span></td>
        </tr>
    </table>
</fieldset>
<br>
<fieldset>
    <legend>附加信息二</legend>
    <table width="100%" cellspacing="0" border="0">
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">项目开发贷款</td>
            <td width="30%" class="data_input"><%
                zs = new ZtSelect("BANKFLAG", "BANKFLAG", "1");
                zs.addAttr("style", "width: 90%");
                zs.addAttr("fieldType", "text");
                zs.addAttr("isNull", "false");
                zs.addAttr("onchange", "bankFlagSelect()");
                zs.addOption("", "");
                out.print(zs);
            %>
                <span class="red_star">*</span></td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">开发贷款贷款行</td>
            <td width="30%" colspan="3" class="data_input"><input type="text" id="devlnbankcd" name="devlnbankcd"
                                                                  value="" textLength="50"
                                                                  style="width:90% "></td>
        </tr>
        <%
            if (isShowDevlntimelimittye) {
        %>
        <tr id="devlntimelimittye_tr">
                <%
            } else {
            %>
        <tr id="devlntimelimittye_tr" style="display:none">
            <%
                }
            %>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">开发贷抵押办理时限方式</td>
            <td width="30%" class="data_input"><%
                zs = new ZtSelect("DEVLNTIMELIMITTYE", "DEVLNTIMELIMITTYE", "1");
                zs.addAttr("style", "width: 90%");
                zs.addAttr("fieldType", "text");
                zs.addAttr("isNull", "false");
                zs.addAttr("onchange", "devlntimelimittyeSelect()");
                zs.addOption("", "");
                out.print(zs);
            %>
                <span class="red_star">*</span></td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding"></td>
            <td width="30%" class="data_input"></td>

        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">开发贷款起始日期</td>
            <td width="30%" class="data_input"><input type="text" id="devlnstartdate" name="devlnstartdate" value=""
                                                      style="width:90%" onClick="WdatePicker()" fieldType="date"
                    ></td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">开发贷款截止日期</td>
            <td width="30%" class="data_input"><input type="text" id="devlnenddate" name="devlnenddate" value=""
                                                      style="width:90%" onClick="WdatePicker()" fieldType="date"
                    ></td>
        </tr>
        <tr>
            <%--
                        <td width="20%" nowrap="nowrap" class="lbl_right_padding">差别化服务保证金比例(%)</td>
                        <td width="30%" class="data_input"><input type="text" id="assuamtpercent" name="assuamtpercent"
                                                                  value="" textLength="10"
                                                                  style="width:90% "></td>
            --%>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">保证金比例(%)</td>
            <td width="30%" class="data_input"><input type="text" id="assuamtpercent" name="assuamtpercent"
                                                      value="" textLength="16"
                                                      style="width:90% " intLength="13" floatLength="2"></td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">保证金账号</td>
            <td width="30%" class="data_input"><input type="text" id="assuamt" name="assuamt"
                                                      value="" textLength="30"
                                                      style="width:90% "></td>
        </tr>
        <%--
                <tr>
                    <td width="20%" nowrap="nowrap" class="lbl_right_padding">是否提供承诺书</td>
                    <td width="30%" class="data_input"><input type="text" id="commitmentflag"
                                                              value=""  textLength="2"
                                                              style="width:90%" ></td>
                </tr>
        --%>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">预售许可证号码</td>
            <td width="30%" class="data_input"><input type="text" id="presellid" name="presellid"
                                                      value="" textLength="100"
                                                      style="width:90% "></td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding"></td>
            <td width="30%" class="data_input"></td>

        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">监管账户账号</td>
            <td width="30%" class="data_input"><input type="text" id="adminacct" name="adminacct"
                                                      value="" textLength="50"
                                                      style="width:90% "></td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">监管账户开户银行</td>
            <td width="30%" class="data_input"><input type="text" id="adminacctbank" name="adminacctbank"
                                                      value="" textLength="50"
                                                      style="width:90% "></td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">审批单类别</td>
            <td width="30%" class="data_input"><%
                zs = new ZtSelect("APPRBILLCD", "COOPAPPRBILLCD", "1");
                zs.addAttr("style", "width: 90%");
                zs.addAttr("fieldType", "text");
//                    zs.addAttr("isNull", "false");
                zs.addOption("", "");
                out.print(zs);
            %>
            </td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">审批单编号</td>
            <td width="30%" class="data_input"><input type="text" id="apprbillno" name="apprbillno"
                                                      value="" textLength="50"
                                                      style="width:90% "></td>
        </tr>
        <%--

                <tr>
                    <td width="20%" nowrap="nowrap" class="lbl_right_padding">项目开发贷款情况</td>
                    <td width="30%" colspan="3" class="data_input"><textarea name="projdevlninfo" rows="3" id="projdevlninfo"
                                                                             value=""
                                                                             style="width:96%" textLength="500"></textarea></td>
                </tr>
        --%>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">其它特殊约定</td>
            <td width="30%" colspan="3" class="data_input"><textarea name="otherpromise" rows="10" id="otherpromise"
                                                                     value=""
                                                                     style="width:96.4%" textLength="2000"></textarea>
            </td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">备注</td>
            <td width="30%" colspan="3" class="data_input"><textarea name="remarks" rows="8" id="remarks"
                                                                     value=""
                                                                     style="width:96.4%" textLength="2000"></textarea>
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
            <td width="30%" class="data_input"><input type="text" value="<%=omgr.getOperatorName()%>"
                                                      style="width:90%" readonly="readonly"></td>
            <td width="20%" nowrap="nowrap" class="lbl_right_padding">操作时间</td>
            <td width="30%" class="data_input"><input type="text" value="<%=BusinessDate.getToday() %>"
                                                      style="width:90%" readonly="readonly"></td>
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
                <%} else if (doType.equals("edit") || doType.equals("add")) { %>
                <!--增加，修改-->
                <input id="savebut" class="buttonGrooveDisable" onMouseOver="button_onmouseover()"
                       onmouseout="button_onmouseout()" type="button" value="&nbsp;&nbsp;&nbsp;保存&nbsp;&nbsp;&nbsp;"
                       onclick="saveClick();">
                <input id="closebut" class="buttonGrooveDisable" onMouseOver="button_onmouseover()"
                       onmouseout="button_onmouseout()" type="button" value="&nbsp;&nbsp;&nbsp;取消&nbsp;&nbsp;&nbsp;"
                       onclick="window.close();">
                <%} else if (doType.equals("delete")) { %>
                <!--删除-->
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
