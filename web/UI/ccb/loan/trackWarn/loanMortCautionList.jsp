<!--
  /*********************************************************************
  *    ��������: ��֤�ſ�δ����Ԥ��
  *    ��          ��: leonwoo
  *    ��������: 2010/01/16
  *    ��   ��  ��:
  *    �޸�����:
  *    ��          Ȩ: ��˾
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
        //----------------------------------------------- ��֤�ſ�δ����Ԥ��-------------------------------------------------
        String currentDate = BusinessDate.getToday();        
        // ��ǰ���ڴ��ڵ��ڵ�Ѻ�����ա�Ԥ��
        String tempWhere2 = " and b.MORTEXPIREDATE <='"+currentDate+"' ";
        String sql2 = comSql + comWhere + tempWhere2;
        
        String totalSql = sql2 +" order by MORTID ";
        dbGrid.setfieldSQL(totalSql);
        //��Ѻ��Ϣ 
        dbGrid.setField("��Ѻ��������", "center", "10", "MORTDATE", "true", "0");
        dbGrid.setField("��Ѻ��������", "center", "10", "MORTEXPIREDATE", "true", "0");
        dbGrid.setField("��������", "center", "10", "MORTECENTERCD", "true", "0");
        dbGrid.setField("��Ѻ���", "text", "10", "MORTID", "true", "0");
        dbGrid.setField("������", "center", "10", "deptname", "true", "0");
        dbGrid.setField("���������", "text", "10", "cust_name", "true", "0");
        dbGrid.setField("��������", "text", "16", "ln_typ", "true", "0");
        dbGrid.setField("������", "money", "10", "RT_ORIG_LOAN_AMT", "true", "0");
        dbGrid.setField("��������", "text", "10", "RT_TERM_INCR", "true", "0");
        dbGrid.setField("�ſ���ʽ", "dropdown", "10", "RELEASECONDCD", "true", "RELEASECONDCD");
        dbGrid.setField("������Ŀ����", "text", "20", "PROJ_NAME", "true", "0");
        dbGrid.setField("δ������Ѻԭ��", "dropdown", "16", "NOMORTREASONCD", "true", "NOMORTREASONCD");
        dbGrid.setField("�ͻ�����", "text", "10", "custmgr_name", "true", "0");
        dbGrid.setField("�����������", "text", "18", "loanid", "true", "0");
        
        dbGrid.setpagesize(30);
        dbGrid.setdataPilotID("datapilot");
        dbGrid.setbuttons("����Excel=excel,moveFirst,prevPage,nextPage,moveLast");
        
  %>
<body bgcolor="#ffffff" onLoad="body_resize()" onResize="body_resize();" class="Bodydefault">

<fieldset>
<legend>��֤�ſ�δ����Ԥ��</legend>
<table width="100%">
  <tr>
    <td><%=dbGrid.getDBGrid()%> </td>
  </tr>
</table>
</fieldset>
<fieldset>
<legend> ���� </legend>
<table width="100%">
  <tr>
    <td align="right"><%=dbGrid.getDataPilot()%> </td>
  </tr>
</table>
</fieldset>
</body>
</html>