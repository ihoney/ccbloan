<!--
  /*********************************************************************
  *    功能描述: 见证放款未办妥预警
  *    作          者: leonwoo
  *    开发日期: 2010/01/16
  *    修   改  人:
  *    修改日期:
  *    版          权: 公司
  ***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@include file="/global.jsp"%>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=GBK">
<title></title>
<script language="javascript" src="loanMortCautionList.js"></script>
<script language="javascript" src="/UI/support/pub.js"></script>
</head>
<%
        OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
        String deptId = omgr.getOperator().getPtDeptBean().getDeptid();

        DBGrid dbGrid = new DBGrid();
        dbGrid.setGridID("loanTab");
        dbGrid.setGridType("read");
        String comSql = ""
            +" select b.MORTDATE,b.MORTEXPIREDATE,"
            +" (select enuitemlabel from ptenudetail where enutype='MORTECENTERCD' and enuitemvalue=b.MORTECENTERCD)as MORTECENTERCD,"
            +" b.MORTID,"
            +" (select deptname from ptdept where deptid=c.bankid) as deptname, "
            +" c.cust_name,"
            +" (select code_desc from ln_odsb_code_desc where code_type_id='053' and code_id=c.ln_typ) as ln_typ, "
            +" c.RT_ORIG_LOAN_AMT,c.RT_TERM_INCR,b.RELEASECONDCD,x.PROJ_NAME,b.NOMORTREASONCD,"
            +" (select opername from ptoper where operid=c.custmgr_id) as custmgr_name,"
            +" c.loanid "
  		  +" ";          
          String comWhere = ""  
            +" from ln_mortinfo b left join ln_loanapply c on b.loanid=c.loanid "
            +" left join ln_coopproj x on c.proj_no=x.proj_no "
            +" where c.bankid in(select deptid from ptdept start with deptid='"+omgr.getOperator().getDeptid()+"' connect by prior deptid=parentdeptid) "
         	+" and b.MORTSTATUS  in('10','20') and b.RELEASECONDCD in ('01','04')  ";
        //----------------------------------------------- 见证放款未办妥预警-------------------------------------------------
        String currentDate = BusinessDate.getToday();        
        // 当前日期大于等于抵押到期日→预警
        String tempWhere2 = " and b.MORTEXPIREDATE <='"+currentDate+"' ";
        String sql2 = comSql + comWhere + tempWhere2;
        
        String totalSql = sql2 +" order by MORTID ";
        dbGrid.setfieldSQL(totalSql);
        //抵押信息 
        dbGrid.setField("抵押接收日期", "center", "10", "MORTDATE", "true", "0");
        dbGrid.setField("抵押到期日期", "center", "10", "MORTEXPIREDATE", "true", "0");
        dbGrid.setField("交易中心", "center", "10", "MORTECENTERCD", "true", "0");
        dbGrid.setField("抵押编号", "text", "10", "MORTID", "true", "0");
        dbGrid.setField("经办行", "center", "10", "deptname", "true", "0");
        dbGrid.setField("借款人姓名", "text", "10", "cust_name", "true", "0");
        dbGrid.setField("贷款种类", "text", "16", "ln_typ", "true", "0");
        dbGrid.setField("贷款金额", "money", "10", "RT_ORIG_LOAN_AMT", "true", "0");
        dbGrid.setField("贷款期限", "text", "10", "RT_TERM_INCR", "true", "0");
        dbGrid.setField("放款形式", "dropdown", "10", "RELEASECONDCD", "true", "RELEASECONDCD");
        dbGrid.setField("合作项目名称", "text", "20", "PROJ_NAME", "true", "0");
        dbGrid.setField("未办理抵押原因", "dropdown", "16", "NOMORTREASONCD", "true", "NOMORTREASONCD");
        dbGrid.setField("客户经理", "text", "10", "custmgr_name", "true", "0");
        dbGrid.setField("贷款申请序号", "text", "18", "loanid", "true", "0");
        
        dbGrid.setpagesize(30);
        dbGrid.setdataPilotID("datapilot");
        dbGrid.setbuttons("导出Excel=excel,moveFirst,prevPage,nextPage,moveLast");
        
  %>
<body bgcolor="#ffffff" onLoad="body_resize()" onResize="body_resize();" class="Bodydefault">

<fieldset>
<legend>见证放款未办妥预警</legend>
<table width="100%">
  <tr>
    <td><%=dbGrid.getDBGrid()%> </td>
  </tr>
</table>
</fieldset>
<fieldset>
<legend> 操作 </legend>
<table width="100%">
  <tr>
    <td align="right"><%=dbGrid.getDataPilot()%> </td>
  </tr>
</table>
</fieldset>
</body>
</html>
