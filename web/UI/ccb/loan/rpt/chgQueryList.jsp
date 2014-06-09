<%@ page import="jxl.write.DateTime" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!--
/*********************************************************************
* 功能描述: 统计：借证原因为“预抵转现抵”且借证领用日期比统计当日早90天（含）且未借证归还的明细。
* 作 者: zhanrui
* 开发日期: 2012/06/10
* 修 改 人:
* 修改日期:
* 版 权: 公司
***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK" %>
<%@include file="/global.jsp" %>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title></title>
    <script language="javascript" src="chgQueryList.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
    <script language="javascript">
        <%
            OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
            String deptId = omgr.getOperator().getPtDeptBean().getDeptid();

        %>
        var deptid ='<%=deptId%>';
    </script>
</head>
    <%
        //OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
        //String deptId = omgr.getOperator().getPtDeptBean().getDeptid();

        int daynum = 90;
        String currdate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DAY_OF_MONTH, - daynum);

        String chgdate =new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
        System.out.println(chgdate);

        DBGrid dbGrid = new DBGrid();
        dbGrid.setGridID("loanTab");
        dbGrid.setGridType("edit");

        // 只统计已经做过抵押登记的记录
        String sql = ""
                // 贷款信息
                + "select "
                //+ "(select deptname from ptdept where deptid=a.bankid) as bankname,"
                + " d.deptname as bankname,"
                + "a.cust_name,"
                + "(select code_desc from ln_odsb_code_desc where code_type_id='053' and code_id=a.LN_TYP) as ln_typ_name,"
                + "a.RT_ORIG_LOAN_AMT,a.RT_TERM_INCR,a.RATECALEVALUE,"
                + "(select enuitemlabel from ptenudetail where enutype='RELEASECONDCD' and enuitemvalue=b.RELEASECONDCD)as RELEASECONDCD,"
                + " a.CUST_OPEN_DT,a.EXPIRING_DT,"
                + "(select code_desc from ln_odsb_code_desc where code_type_id='807' and code_id = a.GUARANTY_TYPE)as GUARANTY_TYPE,"
                //+ "a.RT_TERM_INCR,"
                + "a.PROJ_NO,"
                + "c.proj_name,"
                + "c.PROJ_NAME_ABBR,"
                + "c.CORPNAME,"
                + "(select opername from ptoper where operid=a.custmgr_id) as custmgr_name, "
                //抵押信息

                + "b.MORTDATE,b.MORTID,"
                + "(select enuitemlabel from ptenudetail where enutype='MORTECENTERCD' and enuitemvalue=b.MORTECENTERCD)as MORTECENTERCD,"
                + "(select enuitemlabel from ptenudetail where enutype='MORTREGSTATUS' and enuitemvalue=b.MORTREGSTATUS) as MORTREGSTATUS,"
                + "(select enuitemlabel from ptenudetail where enutype='NOMORTREASONCD' and enuitemvalue=b.NOMORTREASONCD) as NOMORTREASONCD,"
                + "(select enuitemlabel from ptenudetail where enutype='KEEPCONT' and enuitemvalue=b.KEEPCONT)as keepcont,"
                + "b.EXPRESSNO,b.EXPRESSENDSDATE,b.EXPRESSRTNDATE,"
                + " b.EXPRESSNOTE,"
    //            +"(select enuitemlabel from ptenudetail where enutype='RELAYFLAG' and enuitemvalue=b.RELAYFLAG) as RELAYFLAG,"
                + "(select enuitemlabel from ptenudetail where enutype='SENDFLAG' and enuitemvalue=b.SENDFLAG) as SENDFLAG,"
                + "b.MORTEXPIREDATE,b.MORTOVERRTNDATE,"
                + "b.PAPERRTNDATE,b.CHGPAPERDATE,b.CHGPAPERRTNDATE,b.CLRPAPERDATE,"
                + "(select enuitemlabel from ptenudetail where enutype='CHGPAPERREASONCD' and enuitemvalue=b.CHGPAPERREASONCD) as CHGPAPERREASONCD, "
                + "(select enuitemlabel from ptenudetail where enutype='CLRREASONCD' and enuitemvalue=b.CLRREASONCD) as CLRREASONCD, "
                + " b.CLRREASONREMARK,"
                + " b.DOCUMENTID,"
                + "(select enuitemlabel from ptenudetail where enutype='MORTSTATUS' and enuitemvalue=b.MORTSTATUS) as MORTSTATUS "
                + " from ln_loanapply a inner join ln_mortinfo b on a.loanid=b.loanid   "
                + " left join ln_coopproj c on a.PROJ_NO=c.PROJ_NO "
                + " left join ptdept d on a.bankid=d.deptid "
                + " where  1=1 ";

        dbGrid.setfieldSQL(sql);
        // 贷款信息
        dbGrid.setField("经办机构", "text", "8", "bankname", "true", "0");
        dbGrid.setField("借款人姓名", "text", "8", "cust_name", "true", "0");
        dbGrid.setField("贷款种类", "text", "8", "ln_typ_name", "true", "0");
        dbGrid.setField("贷款金额", "money", "8", "RT_ORIG_LOAN_AMT", "true", "0");
        dbGrid.setField("贷款期限", "text", "8", "RT_TERM_INCR", "true", "0");
        dbGrid.setField("利率浮动比例", "text", "8", "RATECALEVALUE", "true", "0");
        dbGrid.setField("放款方式", "text", "8", "RELEASECONDCD", "true", "0");
        dbGrid.setField("开户日期", "text", "8", "CUST_OPEN_DT", "true", "0");
        dbGrid.setField("到期日期", "text", "8", "EXPIRING_DT", "true", "0");
        dbGrid.setField("担保方式", "text", "8", "GUARANTY_TYPE", "true", "0");
        //dbGrid.setField("担保物价值", "text", "8", "RT_TERM_INCR", "true", "0");
        dbGrid.setField("合作项目编号", "text", "10", "PROJ_NO", "true", "0");
        dbGrid.setField("合作项目名称", "text", "12", "proj_name", "true", "0");
        dbGrid.setField("合作项目简称", "text", "8", "PROJ_NAME_ABBR", "true", "0");
        dbGrid.setField("合作方名称", "text", "12", "CORPNAME", "true", "0");
        dbGrid.setField("客户经理", "text", "6", "custmgr_name", "true", "0");
        //抵押信息

        dbGrid.setField("抵押接收日期", "text", "8", "MORTDATE", "true", "0");
        dbGrid.setField("抵押编号", "text", "8", "MORTID", "true", "0");
        dbGrid.setField("抵押交易中心", "text", "8", "MORTECENTERCD", "true", "0");
        dbGrid.setField("抵押登记状态", "text", "8", "MORTREGSTATUS", "true", "0");
        dbGrid.setField("未办理抵押原因 ", "text", "8", "NOMORTREASONCD", "true", "0");
        dbGrid.setField("保管内容", "text", "8", "KEEPCONT", "true", "0");
        dbGrid.setField("快递编号", "text", "8", "EXPRESSNO", "true", "0");
        dbGrid.setField("快递发出日期", "text", "8", "EXPRESSENDSDATE", "true", "0");
        dbGrid.setField("快递回证日期", "text", "8", "EXPRESSRTNDATE", "true", "0");
        dbGrid.setField("快递备注", "text", "8", "EXPRESSNOTE", "true", "0");
    //    dbGrid.setField("不可报抵押标志", "text", "8", "RELAYFLAG", "true", "0");
        dbGrid.setField("可报/不可报", "text", "8", "SENDFLAG", "true", "0");
        dbGrid.setField("抵押到期日", "text", "8", "MORTEXPIREDATE", "true", "0");
        dbGrid.setField("抵押超批复日期", "text", "8", "MORTOVERRTNDATE", "true", "0");
        dbGrid.setField("入库日期", "text", "8", "PAPERRTNDATE", "true", "0");
        dbGrid.setField("借证领用日期", "text", "8", "CHGPAPERDATE", "true", "0");
        dbGrid.setField("借证归还日期", "text", "8", "CHGPAPERRTNDATE", "true", "0");
        dbGrid.setField("清退取证日期", "text", "8", "CLRPAPERDATE", "true", "0");
        dbGrid.setField("借证原因", "text", "8", "CHGPAPERREASONCD", "true", "0");
        dbGrid.setField("清退取证原因", "text", "8", "CLRREASONCD", "true", "0");
        dbGrid.setField("清退取证原因备注", "text", "12", "CLRREASONREMARK", "true", "0");
        dbGrid.setField("重要档案编号", "text", "8", "DOCUMENTID", "true", "0");
        dbGrid.setField("抵押流转状态", "text", "8", "MORTSTATUS", "true", "0");

        //dbGrid.setWhereStr("and floor(to_date('" + currdate + "','yyyy-mm-dd') - to_date(b.chgpaperdate,'yyyy-mm-dd')) >= " + daynum
        //    + "and (b.chgpaperrtndate is  null or b.chgpaperrtndate > '" +  currdate  + "' )"
        //    +" and b.chgpaperreasoncd = '01' and a.bankid in(select deptid from ptdept start with deptid='" + omgr.getOperator().getDeptid() + "' connect by prior deptid=parentdeptid) order by b.mortecentercd,a.bankid,a.cust_name  ");
        dbGrid.setWhereStr("  and floor(to_date('" + currdate + "','yyyy-mm-dd') - to_date(b.chgpaperdate,'yyyy-mm-dd')) >= " + daynum
            + "and (b.chgpaperrtndate is  null or b.chgpaperrtndate > '" +  currdate  + "' )"
            +" and b.chgpaperreasoncd = '01' and a.bankid in(select deptid from ptdept start with deptid='" + deptId + "' connect by prior deptid=parentdeptid) order by b.mortecentercd,a.bankid,a.cust_name  ");

        dbGrid.setpagesize(30);
        dbGrid.setdataPilotID("datapilot");
        dbGrid.setbuttons("导出excel=excel,moveFirst,prevPage,nextPage,moveLast");


    %>
<body bgcolor="#ffffff" onLoad="body_resize()" onResize="body_resize();" class="Bodydefault">
<fieldset style="padding-top:-5px;padding-bottom:0px;margin-top:0px">
    <legend>查询条件</legend>
    <table border="0" cellspacing="0" cellpadding="0" width="100%">
        <form id="queryForm" name="queryForm">
            <tr>
                <td width="30%" nowrap="nowrap" class="lbl_right_padding">报表日期</td>
                <td width="70%" nowrap="nowrap" class="data_input"><input type="text" id="REPORTDATE"
                                                                          value="<%=currdate%>"
                                                                          name="REPORTDATE" onClick="WdatePicker()"
                                                                          fieldType="date" style="width:30%"></td>
                <td nowrap="nowrap" align="right"><input class="buttonGrooveDisable" name="cbRetrieve"
                                                         type="button" id="button"
                                                         onClick="cbRetrieve_Click(document.queryForm)"
                                                         onMouseOver="button_onmouseover()"
                                                         onMouseOut="button_onmouseout()" value="检索">
                </td>
            </tr>
            <tr>
                <td width="30%" nowrap="nowrap" class="lbl_right_padding">借证领用日期比报表日期早</td>
                <td width="70%" nowrap="nowrap" class="data_input">
                    <input type="text" id="DAYNUM" name="DAYNUM" value="<%=daynum%>" style="width:30%">
                    <span>天（含）</span>
                </td>
                <td nowrap="nowrap" align="right">
                    <input class="buttonGrooveDisable" name="Input" type="reset" value="重填"
                           onMouseOver="button_onmouseover()" onMouseOut="button_onmouseout()">
                </td>
            </tr>
        </form>
    </table>
</fieldset>
<fieldset>
    <legend> 详细信息</legend>
    <table width="100%">
        <tr>
            <td><%=dbGrid.getDBGrid()%>
            </td>
        </tr>
    </table>
</fieldset>
<FIELDSET>
    <LEGEND> 操作</LEGEND>
    <table width="100%" class="title1">
        <tr>
            <td align="right"><%=dbGrid.getDataPilot()%>
            </td>
        </tr>
    </table>
</FIELDSET>
</body>
</html>
