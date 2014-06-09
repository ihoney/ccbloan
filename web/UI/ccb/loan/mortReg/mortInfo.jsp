<!--
  /*********************************************************************
  *    功能描述: 抵押信息管理抵押详细页面
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
  // 贷款申请序号
  String loanID = "";
  // 操作类型
  String doType = "";
  // 抵押编号
  String mortID = "";
  // 抵押对象
  LNMORTINFO bean = null;
  // 用户对象
  PTOPER oper = null;
  
  if (request.getParameter("loanID") != null)
    loanID = request.getParameter("loanID");

  if (request.getParameter("doType") != null)
    doType = request.getParameter("doType");
  if ("add".equalsIgnoreCase(doType)) {
     // 自动取出抵押编号
     //mortID = SeqUtil.getSeq(CcbLoanConst.MORTTYPE);
  } else {
    if (request.getParameter("mortID") != null)
      mortID = request.getParameter("mortID");
    // 初始化页面
    bean = LNMORTINFO.findFirst("where mortid='" + mortID + "'");
    if (bean != null){
      StringUtils.getLoadForm(bean,out);
    }
  }

  OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
  //取出用户的姓名
  if(bean != null){
    oper=PTOPER.findFirst("where operid='"+bean.getOperid()+"'");
  }
%>
<html>


<head>

<META http-equiv="Content-Type" content="text/html; charset=GBK">
<title>抵押信息登记</title>

<script language="javascript" src="/UI/support/tabpane.js"></script>
<script language="javascript" src="/UI/support/common.js"></script>
<script language="javascript" src="/UI/support/DataWindow.js"></script>
<script language="javascript" src="/UI/support/pub.js"></script>
<script language="javascript" src="mortgageEdit.js"></script>

</head>
<body bgcolor="#ffffff" onload="formInit();"  class="Bodydefault" > 
<form id="editForm" name="editForm" >
<!-- 抵押流程状态 -->
<input type="hidden" id="MORTSTATUS">
<fieldset > 
  <legend>抵押信息登记</legend>     
  <table width="100%"  cellspacing="0" border="0"> 
  	<!-- 操作类型 -->
   	<input type="hidden" id="doType" value="<%=doType%>">
    <!-- 版本号 -->
    <input type="hidden" id="recVersion" value="">
    <tr> 
      <td width="20%"  nowrap="nowrap" class="lbl_right_padding">贷款申请序号</td> 
      <td width="30%"  class="data_input" > <input type="text" id="loanID" name="loanID"  value="<%=loanID%>"  style="width:90% " readonly="readonly"> </td>
      <td width="20%"  nowrap="nowrap" class="lbl_right_padding">抵押编号</td> 
      <td width="30%"  class="data_input" > <input type="text" id="mortID" name="mortID"  value="<%=mortID%>" style="width:90%" readonly="readonly"> </td> 
    </tr> 
    <tr>
      <td width="20%"  nowrap="nowrap" class="lbl_right_padding">抵押交易中心</td>
      <td width="30%"  class="data_input"><%
        ZtSelect zs = new ZtSelect("MORTECENTERCD", "MORTECENTERCD", "1");
        zs.addAttr("style", "width: 90%");
        zs.addAttr("fieldType", "text");
        zs.addAttr("isNull", "false");
        //zs.addOption("", ""); 
        //zs.setDisplayAll(false); 
        out.print(zs);
      %><span class="red_star">*</span></td>
      <td width="20%"  class="lbl_right_padding" >抵押接收日期      </td>
      <td width="30%"  class="data_input"><input  name="MORTDATE"  type="text" id="MORTDATE"  style="width:90%" onClick="WdatePicker()" fieldType="date" isNull="false" ><span class="red_star">*</span></td>
    </tr>
    <tr>
      <td width="20%"  nowrap="nowrap" class="lbl_right_padding">放款方式</td>
      <td width="30%"  class="data_input"><% 
        zs = new ZtSelect("RELEASECONDCD", "RELEASECONDCD", "1"); 
        zs.addAttr("style", "width: 90%"); 
        zs.addAttr("fieldType", "text"); 
        //zs.addAttr("isNull","false"); 
        zs.addOption("","");
        out.print(zs); 
      %></td>
      <td width="20%"  class="lbl_right_padding">保管内容</td>
      <td width="30%"  class="data_input"><% 
        zs = new ZtSelect("KEEPCONT", "KEEPCONT", "1"); 
        zs.addAttr("style", "width: 90%"); 
        zs.addAttr("fieldType", "text"); 
        //zs.addAttr("isNull","false");
        zs.addOption("","");
        out.print(zs); 
      %></td>
    </tr> 
    <tr> 
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">快递编号</td> 
      <td width="30%" class="data_input"><input name="EXPRESSNO" type="text" id="EXPRESSNO" style="width:90%" textLength="30" ></td> 
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">快递发出日期  </td> 
      <td width="30%" class="data_input"><input  name="EXPRESSENDSDATE"  type="text" id="EXPRESSENDSDATE"  style="width:90%" onClick="WdatePicker()" fieldType="date" ></td>
    </tr> 
    <tr>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">快递备注</td> 
      <td width="30%" colspan="3" class="data_input"><textarea name="EXPRESSNOTE" rows="3" id="EXPRESSNOTE" style="width:96%" textLength="500"></textarea> </td>
    </tr>
    <tr> 
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">入库日期</td> 
      <td width="30%" class="data_input"><input  name="PAPERRTNDATE"  type="text" id="PAPERRTNDATE"  style="width:90%"  onClick="WdatePicker()" fieldType="date" isNull="false"><span class="red_star">*</span></td> 
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">抵押登记状态</td> 
      <td width="30%" class="data_input">
         <% 
        zs = new ZtSelect("MORTSTATUS", "MORTSTATUS", "1"); 
        zs.addAttr("style", "width: 90%"); 
        zs.addAttr("fieldType", "text"); 
        //zs.addAttr("isNull","false");
        zs.addOption("","");
        out.print(zs); 
        %>
      </td> 
    </tr>
    <tr>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">是否他行</td>
      <td width="30%" class="data_input">
        <% 
        zs = new ZtSelect("BANKFLAG", "BANKFLAG", "1"); 
        zs.addAttr("style", "width: 90%"); 
        zs.addAttr("fieldType", "text"); 
        //zs.addAttr("isNull","false");
        zs.addOption("","");
        out.print(zs); 
        %>
      </td>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">未办理抵押原因</td> 
      <td width="30%" class="data_input">
      <% 
        zs = new ZtSelect("NOMORTREASONCD", "NOMORTREASONCD", "1"); 
        zs.addAttr("style", "width: 90%"); 
        zs.addAttr("fieldType", "text"); 
        //zs.addAttr("isNull","false");
        zs.addOption("","");
        out.print(zs); 
        %>      
      </td>
    </tr>
    <tr>
      <td width="20%" class="lbl_right_padding">未办理抵押原因备注</td>
      <td colspan="3" class="data_input"> <textarea name="NOMORTREASON" rows="3" id="NOMORTREASON" style="width:96%" textLength="500"></textarea> </td>
    </tr>
    <tr>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">是否可报送</td> 
      <td width="30%" class="data_input">
         <% 
        zs = new ZtSelect("SENDFLAG", "SENDFLAG", "1"); 
        zs.addAttr("style", "width: 90%"); 
        zs.addAttr("fieldType", "text"); 
        //zs.addAttr("isNull","false");
        zs.addOption("","");
        out.print(zs); 
        %>      
      </td> 
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">不可报抵押资料交接标志</td> 
      <td width="30%" class="data_input">
         <% 
        zs = new ZtSelect("RELAYFLAG", "RELAYFLAG", "1"); 
        zs.addAttr("style", "width: 90%"); 
        zs.addAttr("fieldType", "text"); 
        //zs.addAttr("isNull","false");
        zs.addOption("","");
        out.print(zs); 
        %>
      </td>
    </tr>
    <tr>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">借证领用日期</td> 
      <td width="30%" class="data_input"><input  name="CHGPAPERDATE"  type="text" id="CHGPAPERDATE"  style="width:90%"  onClick="WdatePicker()" fieldType="date" isNull="false"><span class="red_star">*</span></td>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">借证原因</td> 
      <td width="30%" class="data_input">
         <% 
        zs = new ZtSelect("CHGPAPERREASONCD", "CHGPAPERREASONCD", "1"); 
        zs.addAttr("style", "width: 90%"); 
        zs.addAttr("fieldType", "text"); 
        //zs.addAttr("isNull","false");
        zs.addOption("","");
        out.print(zs); 
        %>
      </td>
    </tr>
    <tr>
       <td width="20%" class="lbl_right_padding">借证原因备注</td>
      <td colspan="3" class="data_input"> <textarea name="CHGPAPERREASON" rows="3" id="CHGPAPERREASON" style="width:96%" textLength="300"></textarea> </td>
    </tr>
    <tr>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">借证归还日期</td> 
      <td width="30%" class="data_input"><input  name="CHGPAPERRTNDATE"  type="text" id="CHGPAPERRTNDATE"  style="width:90%"  onClick="WdatePicker()" fieldType="date" isNull="false"><span class="red_star">*</span></td>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">清退取证日期</td>
      <td width="30%" class="data_input"><input  name="CLRPAPERDATE"  type="text" id="CLRPAPERDATE"  style="width:90%"  onClick="WdatePicker()" fieldType="date" isNull="false"><span class="red_star">*</span></td>
    </tr>
    <tr>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">抵押到期日期</td> 
      <td width="30%" class="data_input"><input  name="MORTEXPIREDATE"  type="text" id="MORTEXPIREDATE"  style="width:90%"  onClick="WdatePicker()" fieldType="date" isNull="false"><span class="red_star">*</span></td>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">超批复日期</td> 
      <td width="30%" class="data_input"><input  name="MORTOVERRTNDATE"  type="text" id="MORTOVERRTNDATE"  style="width:90%"  onClick="WdatePicker()" fieldType="date" isNull="false"><span class="red_star">*</span></td>
    </tr>
    <tr>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">抵押登记状态</td> 
      <td width="30%" class="data_input">
        <% 
        zs = new ZtSelect("MORTREGSTATUS", "MORTREGSTATUS", "1"); 
        zs.addAttr("style", "width: 90%"); 
        zs.addAttr("fieldType", "text"); 
        //zs.addAttr("isNull","false");
        zs.addOption("","");
        out.print(zs); 
        %>
      </td>
      <td width="20%" nowrap="nowrap" class="lbl_right_padding">取回回执日期</td> 
      <td width="30%" class="data_input"><input  name="RECEIPTDATE"  type="text" id="RECEIPTDATE"  style="width:90%"  onClick="WdatePicker()" fieldType="date" isNull="false"><span class="red_star">*</span></td>
    </tr>
    <tr>
      <td width="20%" class="lbl_right_padding">可报抵押接收时间</td>
       <td width="30%" class="data_input" colspan="3"><input  name="RPTMORTDATE"  type="text" id="RPTMORTDATE"  style="width:33%"  onClick="WdatePicker()" fieldType="date" isNull="false"><span class="red_star">*</span></td>
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
