<!--
/*********************************************************************
* 功能描述: 抵押超批复时限预警
* 作 者: leonwoo
* 开发日期: 2010/01/16
* 修 改 人:
* 修改日期:
* 版 权: 公司
***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@include file="/global.jsp" %>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title></title>
    <script language="javascript" src="mortOverCautionList.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
</head>
<%
    OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
    String deptId = omgr.getOperator().getPtDeptBean().getDeptid();

    DBGrid dbGrid = new DBGrid();
    dbGrid.setGridID("loanTab");
    dbGrid.setGridType("read");
    // 抵押超批复日期=当前日期 ，进行抵押超批复时限预警
    String comSql = ""
            // 签约放款，账户必须为：已开户，放款方式：签约放款的数据
            + " select * from ( "
            + " select b.MORTDATE,"
            //2011-06-14 zhanrui
            //  + " to_date(c.cust_open_dt, 'yyyy-mm-dd') + decode(trim(x.FOLLOWUPMORTPERIOD), null, 0, x.FOLLOWUPMORTPERIOD)  as overdate,"
            + " nvl(b.mortexpiredate, '2999-12-31') as overdate,"
            + " (select enuitemlabel from ptenudetail where enutype='MORTECENTERCD' and enuitemvalue=b.MORTECENTERCD)as MORTECENTERCD,"
            + " b.MORTID,"
            + " (select deptname from ptdept where deptid=c.bankid) as deptname, "
            + " c.cust_name,"
            + " (select code_desc from ln_odsb_code_desc where code_type_id='053' and code_id=c.ln_typ) as ln_typ, "
            + " c.RT_ORIG_LOAN_AMT,c.RT_TERM_INCR,b.RELEASECONDCD,x.PROJ_NAME,x.CORPNAME,b.NOMORTREASONCD,"
            + " (select opername from ptoper where operid=c.custmgr_id) as custmgr_name,"
            + " c.loanid,b.mortstatus,c.bankid,c.LOANSTATE,  "
            + " (select code_desc  from ln_odsb_code_desc where code_type_id='149' and code_id='1' ) as LOANSTATNAME "
            + " from ln_mortinfo b left join ln_loanapply c on b.loanid=c.loanid "
            + " left join ln_coopproj x on c.proj_no=x.proj_no "
            + " ) ";
    String comWhere = ""
            + " where bankid in(select deptid from ptdept start with deptid='" + omgr.getOperator().getDeptid() + "' connect by prior deptid=parentdeptid) "
            + " and MORTSTATUS  in('10','20') and LOANSTATE ='1' and RELEASECONDCD in ('03','06') "
            + " and NOMORTREASONCD not in('08', '17') ";

    //----------------------------------------------- 抵押超批复时限预警---------------------------------------------
    // 抵押超批复日期 = 当前日期→预警功能
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Calendar calendar = new GregorianCalendar();
    String currentDate = BusinessDate.getToday();
    int year = Integer.parseInt(currentDate.substring(0, 4));
    int month = Integer.parseInt(currentDate.substring(5, 7));
    int day = Integer.parseInt(currentDate.substring(8, 10));
    calendar.set(Calendar.YEAR, year);
    calendar.set(Calendar.MONTH, month - 1);
    calendar.set(Calendar.DAY_OF_MONTH, day);
    // 当前日期= 抵押超批复日期
    String tempDate1 = df.format(calendar.getTime());
    //2011-06-14
    // String tempWhere1 = " and to_char(overdate,'yyyy-mm-dd') <= '" + currentDate + "'";
    String tempWhere1 = " and overdate <= '" + currentDate + "'";
    String sql1 = comSql + comWhere + tempWhere1;


    String totalSql = sql1 + " order by mortid asc ";

    dbGrid.setfieldSQL(totalSql);
    dbGrid.setField("抵押接收日期", "center", "10", "MORTDATE", "true", "0");
    dbGrid.setField("超批复日期", "center", "10", "MORTEXPIREDATE", "true", "0");
    dbGrid.setField("交易中心", "center", "10", "MORTECENTERCD", "true", "0");
    dbGrid.setField("抵押编号", "text", "10", "MORTID", "true", "0");
    dbGrid.setField("经办行", "center", "10", "deptname", "true", "0");
    dbGrid.setField("借款人姓名", "text", "10", "cust_name", "true", "0");
    dbGrid.setField("贷款种类", "text", "16", "ln_typ", "true", "0");
    dbGrid.setField("贷款金额", "money", "10", "RT_ORIG_LOAN_AMT", "true", "0");
    dbGrid.setField("贷款期限", "text", "10", "RT_TERM_INCR", "true", "0");
    dbGrid.setField("放款方式", "dropdown", "10", "RELEASECONDCD", "true", "RELEASECONDCD");
    dbGrid.setField("合作项目名称", "text", "40", "PROJ_NAME", "true", "0");
    dbGrid.setField("合作方名称", "text", "30", "CORPNAME", "true", "0");
    dbGrid.setField("未办理抵押原因", "dropdown", "16", "NOMORTREASONCD", "true", "NOMORTREASONCD");
    dbGrid.setField("客户经理", "text", "10", "custmgr_name", "true", "0");
    dbGrid.setField("贷款申请序号", "text", "18", "loanid", "true", "0");
    dbGrid.setField("抵押流程状态", "dropdown", "8", "mortstatus", "false", "MORTSTATUS");
    dbGrid.setField("机构号", "text", "8", "deptid", "false", "0");
    dbGrid.setField("贷款状态码", "text", "8", "LOANSTATE", "false", "0");
    dbGrid.setField("贷款状态", "text", "8", "LOANSTATENAME", "false", "0");
    dbGrid.setpagesize(30);
    dbGrid.setdataPilotID("datapilot");
    dbGrid.setbuttons("导出Excel=excel,moveFirst,prevPage,nextPage,moveLast");

%>
<body bgcolor="#ffffff" onLoad="body_resize()" onResize="body_resize();" class="Bodydefault">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <form id="queryForm" name="queryForm">
        <!-- 部门隐藏字段，为了查询使用 -->
        <input type="hidden" id="deptid" value="<%=omgr.getOperator().getDeptid()%>">
        <input type="hidden" id="tempWhere1" value="<%=tempWhere1 %>"/>
    </form>
</table>
<fieldset>
    <legend> 抵押超批复时限预警</legend>
    <table width="100%">
        <tr>
            <td><%=dbGrid.getDBGrid()%>
            </td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <legend> 操作</legend>
    <table width="100%">
        <tr>
            <td align="right"><%=dbGrid.getDataPilot()%>
            </td>
        </tr>
    </table>
</fieldset>
</body>
</html>
