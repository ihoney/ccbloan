<!--
  /*********************************************************************
  *    功能描述: 抵押信息管理贷款详细页面
  *
  *    作    者:    leonwoo
  *    开发日期:  2010/01/16
  *    修 改 人:
  *    修改日期:
  *    版    权:    公司
  ***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK"%>
<%@include file="/global.jsp"%>

<%@ page import="com.ccb.dao.*" %>
<%@ page import="com.ccb.util.*"%>

<%
  // 内部序号
  String nbxh = "";
  // 操作类型
  String doType = "";
  // 用户对象  
  PTOPER oper = null;
  if (request.getParameter("nbxh") != null)
    nbxh = request.getParameter("nbxh");
  if (request.getParameter("doType") != null)
    doType = request.getParameter("doType");

  // 初始化页面
  LNLOANAPPLY bean = LNLOANAPPLY.findFirst("where nbxh='" + nbxh + "'");
  if (bean != null) {
    StringUtils.getLoadForm(bean, out);
  }

  OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
  //取出用户的姓名
  if(bean != null){
    oper=PTOPER.findFirst("where operid='"+bean.getOperid2()+"'");
  }

%>
<html>

<head>

<META http-equiv="Content-Type" content="text/html; charset=GBK">
<title>贷款信息</title>

<script language="javascript" src="/UI/support/tabpane.js"></script>
<script language="javascript" src="/UI/support/common.js"></script>
<script language="javascript" src="/UI/support/DataWindow.js"></script>
<script language="javascript" src="/UI/support/pub.js"></script>
<script language="javascript" src="loanEdit.js"></script>
  
</head>
<body onload="formInit();"  class="Bodydefault"> 
<form id="editForm" name="editForm" >
<fieldset > 
  <legend>贷款信息</legend>     
  <table width="100%"  cellspacing="0" border="0"> 
  	
   	<input type="hidden" id="doType" value="<%=doType%>">
    <input type="hidden" id="recversion" value=""/>
    <input type="hidden" id="nbxh" value="<%=nbxh%>"/>
    <tr> 
      <td width="20%"  nowrap="nowrap" class="lbl_right_padding">贷款申请序号</td> 
      <td width="30%"  class="data_input" > <input type="text" id="loanID" name="loanID"  value="" intLength="24" style="width:90% " isNull="false" ><span class="red_star">*</span> </td>
      <td width="20%"  nowrap="nowrap" class="lbl_right_padding">贷款账号</td> 
      <td width="30%"  class="data_input" > <input type="text" id="LN_ACCT_NO" name="LN_ACCT_NO"  value="" style="width:90%" intLength="30" isNull="false"><span class="red_star">*</span> </td> 
    </tr> 
    <tr>
      <td width="20%"  nowrap="nowrap" class="lbl_right_padding">贷款人姓名</td>
      <td width="30%"  class="data_input"><input type="text" id="cust_name" name="cust_name"   style="width:90%" textLength="40" isNull="false"><span class="red_star">*</span></td>
      <td width="20%"  class="lbl_right_padding" >贷款人姓名拼音 </td>
      <td width="30%"  class="data_input"><input  name="cust_py"  type="text" id="cust_py"  style="width:90%" textLength="100" ></td>
    </tr>
    <tr> 
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">原系统业务日期</td> 
      <td width="30%" class="data_input"><input type="text" id="ODS_SRC_DT" name="ODS_SRC_DT"  value="" style="width:90%" onClick="WdatePicker()" fieldType="date" isNull="false"><span class="red_star">*</span></td> 
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">客户编号</td> 
      <td width="30%" class="data_input"><input  name="CUST_NO"  type="text" id="CUST_NO"  style="width:90%" textLength="20"></td>
    </tr> 
    <tr> 
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">额度编号</td> 
      <td width="30%" class="data_input"><input  name="CRLMT_NO"  type="text" id="CRLMT_NO"  style="width:90%" textLength="20" ></td> 
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">币种</td>
      <td width="30%" class="data_input">
      <% 
        ZtSelect zs = new ZtSelect("CURR_CD", "", "1000590156"); 
//        zs.setSqlString("select code_id as value ,code_desc as text  from ln_odsb_code_desc where code_type_id='808'");
        zs.setSqlString("select t.ods_standard_cd as value,t.source_cd_desc as text from ln_odsb_std_code t where t.category_cd='ACC1300012' and t.system_id='15'");
        zs.addAttr("style", "width: 90%"); 
        zs.addAttr("fieldType", "text"); 
        //zs.addAttr("isNull","false");
        zs.addOption("","");
        out.print(zs); 
        %>
      </td>
     </tr>
    <tr>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">贷款种类</td> 
      <td width="30%" class="data_input">
        <% 
        zs = new ZtSelect("LN_TYP", "", ""); 
        zs.setSqlString("select code_id as value ,code_desc as text  from ln_odsb_code_desc where code_type_id='663'");
        zs.addAttr("style", "width: 90%"); 
        zs.addAttr("fieldType", "text"); 
        //zs.addAttr("isNull","false");
        zs.addOption("","");
        out.print(zs); 
        %>
      </td> 
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">产品代码</td> 
      <td width="30%" class="data_input">
        <% 
        zs = new ZtSelect("LN_PROD_COD", "", ""); 
        zs.setSqlString("select code_id as value ,code_desc as text  from ln_odsb_code_desc where code_type_id='420'");
        zs.addAttr("style", "width: 90%"); 
        zs.addAttr("fieldType", "text"); 
        //zs.addAttr("isNull","false");
        zs.addOption("","");
        out.print(zs); 
        %>
      </td>
    </tr>
    <tr>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">担保方式</td> 
      <td width="30%"  class="data_input">
        <% 
        zs = new ZtSelect("GUARANTY_TYPE", "", ""); 
        zs.setSqlString("select code_id as value ,code_desc as text  from ln_odsb_code_desc where code_type_id='807'");
        zs.addAttr("style", "width: 90%"); 
        zs.addAttr("fieldType", "text"); 
        //zs.addAttr("isNull","false");
        zs.addOption("","");
        out.print(zs); 
        %>
      </td>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">申请日期</td> 
      <td width="30%"  class="data_input"><input type="text" id="APLY_DT" name="APLY_DT"  value="" style="width:90%" onClick="WdatePicker()" fieldType="date"> </td>
    </tr>
    <tr>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">贷款金额</td> 
      <td width="30%"  class="data_input"><input type="text" id="RT_ORIG_LOAN_AMT" name="RT_ORIG_LOAN_AMT"  value="" style="width:90%"  intLength="18" floatLength="2"> </td>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">贷款期限</td> 
      <td width="30%"  class="data_input"><input type="text" id="RT_TERM_INCR" name="RT_TERM_INCR"  value="" style="width:90%" intLength="12"> </td>
    </tr>
    <tr>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">还款方式</td> 
      <td width="30%"  class="data_input">
        <% 
        zs = new ZtSelect("PAY_TYPE", "", ""); 
//        zs.setSqlString("select code_id as value ,code_desc as text  from ln_odsb_code_desc where code_type_id='293'");
        zs.setSqlString("select t.ods_standard_cd as value,t.source_cd_desc as text from ln_odsb_std_code t where t.category_cd='ACC0600018' and t.system_id='15' ");
        zs.addAttr("style", "width: 90%");
        zs.addAttr("fieldType", "text"); 
        //zs.addAttr("isNull","false");
        zs.addOption("","");
        out.print(zs); 
        %>
      </td>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">项目编号</td> 
      <td width="30%"  class="data_input"><input type="text" id="PROJ_NO" name="PROJ_NO"  value="" style="width:90%" textLength="20"> </td>
    </tr>
    <tr>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">利率代码</td> 
      <td width="30%"  class="data_input">
        <% 
        zs = new ZtSelect("RATECODE", "", ""); 
        zs.setSqlString("select code_id as value ,code_desc as text  from ln_odsb_code_desc where code_type_id='122'");
        zs.addAttr("style", "width: 90%"); 
        zs.addAttr("fieldType", "text"); 
        //zs.addAttr("isNull","false");
        zs.addOption("","");
        out.print(zs); 
        %>
      </td>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">贷款基准利率</td> 
      <td width="30%"  class="data_input"><input type="text" id="BASICINTERATE" name="BASICINTERATE"  value="" style="width:90%" intLength="5" floatLength="7"> </td>
    </tr>
    <tr>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">利率运算代码</td> 
      <td width="30%"  class="data_input">
        <% 
        zs = new ZtSelect("RATEACT", "", ""); 
        zs.setSqlString("select code_id as value ,code_desc as text  from ln_odsb_code_desc where code_type_id='411'");
        zs.addAttr("style", "width: 90%"); 
        zs.addAttr("fieldType", "text"); 
        //zs.addAttr("isNull","false");
        zs.addOption("","");
        out.print(zs); 
        %>
      </td>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">利率运算值(利率浮动比例)</td> 
      <td width="30%"  class="data_input"><input type="text" id="RATECALEVALUE" name="RATECALEVALUE"  value="" style="width:90%" intLength="5" floatLength="7"> </td>
    </tr>
    <tr>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">执行利率</td> 
      <td width="30%"  class="data_input"><input type="text" id="INTERATE" name="INTERATE"  value="" style="width:90%" intLength="5" floatLength="7"> </td>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">开户日期</td> 
      <td width="30%"  class="data_input"><input type="text" id="CUST_OPEN_DT" name="CUST_OPEN_DT"  value="" style="width:90%" onClick="WdatePicker()" fieldType="date"> </td>
    </tr>    
     <tr>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">经办行</td> 
      <td width="30%" colspan="3" class="data_input">
        <% 
        zs = new ZtSelect("BANKID", "", ""); 
        //zs.setSqlString("select deptid as value ,deptname as text  from ptdept");
        zs.setSqlString("select deptid, LPad('&nbsp;', (level - 1) * 36, '&nbsp;') || deptname  from ptdept"
            +" start with deptid = '371980000'"
            +" connect by prior deptid = parentdeptid");
        zs.addAttr("style", "width: 63%"); 
        zs.addAttr("fieldType", "text"); 
        zs.addAttr("onchange","operReSelect()");
        //zs.setDefValue("371980000");
        zs.addOption("","");
        out.print(zs); 
        %>
      </td>
    </tr>
    <tr>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">经办人</td> 
      <td width="30%"  class="data_input">
        <% 
        zs = new ZtSelect("OPERID", "", ""); 
        zs.setSqlString("select OPERID as value ,OPERNAME as text  from ptoper");
        zs.addAttr("style", "width: 90%"); 
        zs.addAttr("fieldType", "text"); 
        //zs.addAttr("isNull","false");
        zs.addOption("","");
        out.print(zs); 
        %>
      </td>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">到期日期</td> 
      <td width="30%" class="data_input"><input type="text" id="EXPIRING_DT" name="EXPIRING_DT"  value="" style="width:90%" onClick="WdatePicker()" fieldType="date"> </td>
    </tr>
    <tr>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">审批状态</td> 
      <td width="30%"  class="data_input">
        <% 
        zs = new ZtSelect("APPRSTATE", "", ""); 
        zs.setSqlString("select code_id as value ,code_desc as text  from ln_odsb_code_desc where code_type_id='652'");
        zs.addAttr("style", "width: 90%"); 
        zs.addAttr("fieldType", "text"); 
        //zs.addAttr("isNull","false");
        zs.addOption("","");
        out.print(zs); 
        %>
      </td>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">贷款状态</td> 
      <td width="30%"  class="data_input">
        <% 
        zs = new ZtSelect("LOANSTATE", "", ""); 
        zs.setSqlString("select code_id as value ,code_desc as text  from ln_odsb_code_desc where code_type_id='149'");
        zs.addAttr("style", "width: 90%"); 
        zs.addAttr("fieldType", "text"); 
        //zs.addAttr("isNull","false");
        zs.addOption("","");
        out.print(zs); 
        %>
      </td>
    </tr>
    <tr>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">合作方编号</td> 
      <td width="30%"  class="data_input"><input type="text" id="CORPID" name="CORPID"  value="" style="width:90%" textLength="20"> </td>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">客户经理ID</td> 
      <td width="30%"  class="data_input"><input type="text" id="CUSTMGR_ID" name="CUSTMGR_ID"  value="" style="width:90%" textLength="20"> </td>
    </tr>
    
    <tr>
      <%if (doType.equals("select")) {      %> 
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">操作人员</td> 
      <td width="30%" class="data_input"><input type="text"   value="<%=oper.getOpername()%>" style="width:90%" readonly="readonly"></td>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">操作时间</td> 
      <td width="30%" class="data_input"><input type="text" id="OPERDATE" value="" style="width:90%" readonly="readonly" ></td>
     <%}else{ %>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">操作人员</td> 
      <td width="30%" class="data_input"><input type="text"  value="<%=omgr.getOperatorName()%>" style="width:90%" readonly="readonly"></td>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">操作时间</td> 
      <td width="30%" class="data_input"><input type="text" value="<%=BusinessDate.getToday() %>" style="width:90%" readonly="readonly" ></td>
    <%} %>
    </tr>
  </table> 
  </fieldset> 
  
 </form> 
 
</body>
</html>
