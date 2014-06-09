<!--
  /*********************************************************************
  *    功能描述: 系统日志
  *    作          者: leonwoo
  *    开发日期: 2010/01/16
  *    修   改  人:
  *    修改日期:
  *    版          权: 公司
  ***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK"%>
<%@include file="/global.jsp"%>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=GBK">
<title></title>
<script language="javascript" src="logList.js"></script>
<script language="javascript" src="/UI/support/pub.js"></script>
</head>
<%
        OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
        String deptId = omgr.getOperator().getPtDeptBean().getDeptid();

        DBGrid dbGrid = new DBGrid();
        dbGrid.setGridID("loanTab");
        dbGrid.setGridType("edit");
        
        //只能编辑那些未做过抵押登记的
        String sql = "select taskid,"
        +" (select deptname from ptdept where deptid=bankid)as bankid,"
        +" (select opername from ptoper t where t.operid=a.operid)as operid,"
        +" loanRecordid,"
        +" (select enuitemlabel from ptenudetail where enutype='BUSINODE' and enuitemvalue =tasktype) as tasktype,"
        +" to_char(tasktime,'YYYY-MM-DD HH24:mi:ss'),loan_id from ln_taskinfo a where 1=1  ";
        dbGrid.setfieldSQL(sql);
        
        dbGrid.setField("内部序号", "center", "2", "taskid", "false", "-1");
        dbGrid.setField("机构", "center", "12", "bankid", "true", "0");
        dbGrid.setField("操作用户", "center", "10", "operid", "true", "0");
        dbGrid.setField("操作", "center", "6", "loanRecordid", "true", "0");
        dbGrid.setField("业务类型", "text", "12", "tasktype", "true", "0");
        dbGrid.setField("操作时间", "center", "10", "tasktime", "true", "0");
        dbGrid.setField("业务主键", "center", "12", "loan_id", "true", "0");
        
        
        dbGrid.setWhereStr(" and a.bankid in(select deptid from ptdept start with deptid='"+omgr.getOperator().getDeptid()+"' connect by prior deptid=parentdeptid) order by tasktime desc");
        dbGrid.setpagesize(50);
        dbGrid.setdataPilotID("datapilot");
        dbGrid.setbuttons("moveFirst,prevPage,nextPage,moveLast");
  %>
<body bgcolor="#ffffff" onLoad="body_resize()" onResize="body_resize();" class="Bodydefault">
<fieldset>
<legend> 查询条件 </legend>
<table border="0" cellspacing="0" cellpadding="0" width="100%" >
  <form id="queryForm" name="queryForm">
    <input id="defaultBankID" type="hidden" value="<%=deptId%>"/>
    <tr height="20">
      <td width="8%" class="lbl_right_padding"> 操作时间 </td>
      <td width="16%" class="data_input" ><input type="text" id="TASKTIME" name="TASKTIME" value="" style="width:90%"
                                                      onClick="WdatePicker()" fieldType="date"/>
      </td>
      <td width="1%" class="lbl_right_padding">至</td>
      <td width="16%" class="data_input" ><input type="text" id="TASKTIME2" name="TASKTIME2" value="" style="width:90%"
                                                      onClick="WdatePicker()" fieldType="date"/>
      </td>
      <td width="8%"  class="lbl_right_padding">机构</td>
      <td width="18%"  class="data_input"><%
                        ZtSelect zs = new ZtSelect("BANKID", "", omgr.getOperator().getDeptid());
                        zs.setSqlString("select deptid, LPad('&nbsp;', (level - 1) * 36, '&nbsp;') || deptname  from ptdept"
                                + " start with deptid = '"+omgr.getOperator().getDeptid()+"'"
                                + " connect by prior deptid = parentdeptid");
                        zs.addAttr("style", "width: 90%");
                        zs.addAttr("fieldType", "text");
                        zs.addAttr("onchange", "reSelect()");
                        out.print(zs);
                    %>
      </td>
      <td width="8%" class="lbl_right_padding">操作员</td>
      <td width="10%" class="data_input"><%
                        zs = new ZtSelect("operid", "", "");
                        zs.addAttr("style", "width: 90%");
                        zs.addAttr("fieldType", "text");
                        zs.addOption("", "");
                        out.print(zs);
                    %>
      </td>
      <td  align="center" nowrap="nowrap"><input name="cbRetrieve" type="button" class="buttonGrooveDisable" id="button" onClick="cbRetrieve_Click(document.queryForm)" value="检索">
        <input name="Input" class="buttonGrooveDisable" type="reset" value="重填" >
      </td>
    </tr>
  </form>
</table>
</fieldset>
<fieldset>
<legend> 贷款信息 </legend>
<table width="100%">
  <tr>
    <td><%=dbGrid.getDBGrid()%> </td>
  </tr>
</table>
</fieldset>
<FIELDSET>
<LEGEND> 操作 </LEGEND>
<table width="100%" class="title1">
  <tr>
    <td align="right"><%=dbGrid.getDataPilot()%> </td>
  </tr>
</table>
</FIELDSET>
</body>
</html>
