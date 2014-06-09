<!--
/*********************************************************************
* 功能描述: 基本查询统计
* 作 者: leonwoo
* 开发日期: 2010/01/16
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
    <script language="javascript" src="basicQueryList.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
</head>
<%
    OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
    String deptId = omgr.getOperator().getPtDeptBean().getDeptid();

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
            + " b.EXP_DATA_SIGNIN_DATE,b.EXP_DATA_SIGNIN_REMARK,b.EXP_PAPER_SIGNIN_DATE,b.EXP_PAPER_SIGNIN_REMARK,"
            + " b.DOCUMENTID,"
            + "(select enuitemlabel from ptenudetail where enutype='MORTSTATUS' and enuitemvalue=b.MORTSTATUS) as MORTSTATUS "
            + " from ln_loanapply a inner join ln_mortinfo b on a.loanid=b.loanid   "
            + " left join ln_coopproj c on a.PROJ_NO=c.PROJ_NO "
            + " left join ptdept d on a.bankid=d.deptid "
            + " where 1=1  ";

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
    dbGrid.setField("快递资料签收日期", "text", "12", "EXP_DATA_SIGNIN_DATE", "true", "0");
    dbGrid.setField("快递资料签收备注", "text", "12", "EXP_DATA_SIGNIN_REMARK", "true", "0");
    dbGrid.setField("快递权证签收日期", "text", "12", "EXP_PAPER_SIGNIN_DATE", "true", "0");
    dbGrid.setField("快递权证签收备注", "text", "12", "EXP_PAPER_SIGNIN_REMARK", "true", "0");
    dbGrid.setField("重要档案编号", "text", "8", "DOCUMENTID", "true", "0");
    dbGrid.setField("抵押流转状态", "text", "8", "MORTSTATUS", "true", "0");

    dbGrid.setWhereStr(" and a.bankid in(select deptid from ptdept start with deptid='" + omgr.getOperator().getDeptid() + "' connect by prior deptid=parentdeptid) order by b.mortecentercd,a.bankid,a.cust_name  ");
    dbGrid.setpagesize(15);
    dbGrid.setdataPilotID("datapilot");
    dbGrid.setbuttons("导出excel=excel,moveFirst,prevPage,nextPage,moveLast");

%>
<body bgcolor="#ffffff" onLoad="body_resize()" onResize="body_resize();" class="Bodydefault">
<fieldset style="padding-top:-5px;padding-bottom:0px;margin-top:0px">
<legend>查询条件</legend>
<table border="0" cellspacing="0" cellpadding="0" width="100%">
<form id="queryForm" name="queryForm">
<tr>
    <td width="20%" nowrap="nowrap" class="lbl_right_padding">抵押接收日期起</td>
    <td width="14%" nowrap="nowrap" class="data_input"><input type="text" id="MORTDATE" name="MORTDATE"
                                                              onClick="WdatePicker()" fieldType="date"
                                                              style="width:90%"></td>
    <td width="2%" nowrap="nowrap" class="lbl_right_padding">至</td>
    <td width="14%" nowrap="nowrap" class="data_input"><input type="text" id="MORTDATE2" name="MORTDATE2"
                                                              onClick="WdatePicker()" fieldType="date"
                                                              style="width:90%"></td>
    <td width="20%" nowrap="nowrap" class="lbl_right_padding">放款方式</td>
    <td width="30%" nowrap="nowrap" class="data_input" colspan="3"><%
        ZtSelect zs = new ZtSelect("RELEASECONDCD", "RELEASECONDCD", "");
        zs.addAttr("style", "width: 95%");
        zs.addAttr("fieldType", "text");
        zs.addOption("", "");
        out.print(zs);
    %>
    </td>
</tr>
<tr>
    <td width="20%" nowrap="nowrap" class="lbl_right_padding">抵押登记状态</td>
    <td width="30%" nowrap="nowrap" class="data_input" colspan="3">
        <%
            zs = new ZtSelect("MORTREGSTATUS", "MORTREGSTATUS", "");
            zs.addAttr("style", "width: 95.4%");
            zs.addAttr("fieldType", "text");
            zs.addOption("", "");
            out.print(zs);
        %>
    </td>
    <td width="20%" nowrap="nowrap" class="lbl_right_padding">是否已登记未办理抵押原因</td>
    <td width="30%" nowrap="nowrap" class="data_input" colspan="3"><%
        zs = new ZtSelect("NOMORTREASONCD", "BOOLTYPE", "");
        zs.addAttr("style", "width: 95%");
        zs.addAttr("fieldType", "text");
        zs.addOption("", "");
        out.print(zs);
    %>
    </td>
</tr>
<tr>
    <td width="20%" nowrap="nowrap" class="lbl_right_padding">借证原因</td>
    <td width="30%" nowrap="nowrap" class="data_input" colspan="3"><%
        zs = new ZtSelect("CHGPAPERREASONCD", "CHGPAPERREASONCD", "");
        zs.addAttr("style", "width: 95.4%");
        zs.addAttr("fieldType", "text");
        zs.addOption("", "");
        out.print(zs);
    %>
    </td>
    <td width="20%" nowrap="nowrap" class="lbl_right_padding">经办行名称</td>
    <td width="30%" nowrap="nowrap" class="data_input" colspan="3">
        <%
            zs = new ZtSelect("bankid", "", omgr.getOperator().getDeptid());
            zs.setSqlString("select deptid, LPad('&nbsp;', (level - 1) * 36, '&nbsp;') || deptname  from ptdept"
                    + " start with deptid = '" + omgr.getOperator().getDeptid() + "'"
                    + " connect by prior deptid = parentdeptid");
            zs.addAttr("style", "width: 95.4%");
            zs.addAttr("fieldType", "text");
            out.print(zs);
        %>
    </td>
</tr>
<tr>
    <td width="20%" nowrap="nowrap" class="lbl_right_padding">合作项目简称</td>
    <td width="30%" nowrap="nowrap" class="data_input" colspan="3"><input type="text" id="PROJ_NAME_ABBR"
                                                                          name="PROJ_NAME_ABBR" fieldType="text"
                                                                          style="width:95%">
    </td>
    <td width="20%" nowrap="nowrap" class="lbl_right_padding">合作方名称</td>
    <td width="30%" nowrap="nowrap" class="data_input" colspan="3"><input type="text" id="CORPNAME"
                                                                          name="CORPNAME" fieldType="text"
                                                                          style="width:95%">
    </td>
</tr>
<tr>
    <td width="20%" nowrap="nowrap" class="lbl_right_padding">取得回执日期起</td>
    <td width="14%" nowrap="nowrap" class="data_input"><input type="text" id="RECEIPTDATE"
                                                              name="RECEIPTDATE" onClick="WdatePicker()"
                                                              fieldType="date" style="width:90%"></td>
    <td width="2%" nowrap="nowrap" class="lbl_right_padding">至</td>
    <td width="14%" nowrap="nowrap" class="data_input"><input type="text" id="RECEIPTDATE2"
                                                              name="RECEIPTDATE2" onClick="WdatePicker()"
                                                              fieldType="date" style="width:90%"></td>
    <td width="20%" nowrap="nowrap" class="lbl_right_padding">抵押超批复日期起</td>
    <td width="14%" nowrap="nowrap" class="data_input"><input type="text" id="MORTOVERRTNDATE"
                                                              name="MORTOVERRTNDATE" onClick="WdatePicker()"
                                                              fieldType="date" style="width:90%"></td>
    <td width="2%" nowrap="nowrap" class="lbl_right_padding">至</td>
    <td width="14%" nowrap="nowrap" class="data_input"><input type="text" id="MORTOVERRTNDATE2"
                                                              name="MORTOVERRTNDATE2"
                                                              onClick="WdatePicker()" fieldType="date"
                                                              style="width:90%"></td>
</tr>
<tr>
    <td width="20%" nowrap="nowrap" class="lbl_right_padding">开发贷是否可报抵押</td>
    <td width="30%" nowrap="nowrap" class="data_input" colspan="3"><%
        zs = new ZtSelect("SENDFLAG", "SENDFLAG", "");
        zs.addAttr("style", "width: 95%");
        zs.addAttr("fieldType", "text");
        zs.addOption("", "");
        out.print(zs);
    %>
    </td>
    <td width="20%" nowrap="nowrap" class="lbl_right_padding">开发贷种类</td>
    <td width="30%" nowrap="nowrap" class="data_input" colspan="3">
        <%
            ZtSelect zsbankflag = new ZtSelect("BANKFLAG", "BANKFLAG", "");
            zsbankflag.addAttr("style", "width: 95%");
            zsbankflag.addAttr("fieldType", "text");
            zsbankflag.addOption("", "");
            zsbankflag.addAttr("isNull", "false");
            out.print(zsbankflag);
        %>
    </td>
</tr>
<tr style="height:10px">
    <td></td>
</tr>
<tr>
    <td width="20%" nowrap="nowrap" class="lbl_right_padding">入库日期起</td>
    <td width="14%" nowrap="nowrap" class="data_input"><input type="text" id="PAPERRTNDATE"
                                                              name="PAPERRTNDATE" onClick="WdatePicker()"
                                                              fieldType="date" style="width:90%"></td>
    <td width="2%" nowrap="nowrap" class="lbl_right_padding">至</td>
    <td width="14%" nowrap="nowrap" class="data_input"><input type="text" id="PAPERRTNDATE2"
                                                              name="PAPERRTNDATE2" onClick="WdatePicker()"
                                                              fieldType="date" style="width:90%"></td>
    <td width="20%" nowrap="nowrap" class="lbl_right_padding">清退取证日期起</td>
    <td width="14%" nowrap="nowrap" class="data_input"><input type="text" id="CLRPAPERDATE"
                                                              name="CLRPAPERDATE" onClick="WdatePicker()"
                                                              fieldType="date" style="width:90%"></td>
    <td width="2%" nowrap="nowrap" class="lbl_right_padding">至</td>
    <td width="14%" nowrap="nowrap" class="data_input"><input type="text" id="CLRPAPERDATE2"
                                                              name="CLRPAPERDATE2" onClick="WdatePicker()"
                                                              fieldType="date" style="width:90%"></td>
</tr>
<tr>
    <td width="20%" nowrap="nowrap" class="lbl_right_padding">借证领用日期起</td>
    <td width="14%" nowrap="nowrap" class="data_input"><input type="text" id="CHGPAPERDATE"
                                                              name="CHGPAPERDATE" onClick="WdatePicker()"
                                                              fieldType="date" style="width:90%"></td>
    <td width="2%" nowrap="nowrap" class="lbl_right_padding">至</td>
    <td width="14%" nowrap="nowrap" class="data_input"><input type="text" id="CHGPAPERDATE2"
                                                              name="CHGPAPERDATE2" onClick="WdatePicker()"
                                                              fieldType="date" style="width:90%"></td>
    <td width="20%" nowrap="nowrap" class="lbl_right_padding">借证归还日期起</td>
    <td width="14%" nowrap="nowrap" class="data_input"><input type="text" id="CHGPAPERRTNDATE"
                                                              name="CHGPAPERRTNDATE" onClick="WdatePicker()"
                                                              fieldType="date" style="width:90%"></td>
    <td width="2%" nowrap="nowrap" class="lbl_right_padding">至</td>
    <td width="14%" nowrap="nowrap" class="data_input"><input type="text" id="CHGPAPERRTNDATE2"
                                                              name="CHGPAPERRTNDATE2" onClick="WdatePicker()"
                                                              fieldType="date" style="width:90%"></td>
</tr>
<tr>
    <td width="20%" nowrap="nowrap" class="lbl_right_padding">快递发出日期起</td>
    <td width="14%" nowrap="nowrap" class="data_input"><input type="text" id="EXPRESSENDSDATE"
                                                              name="EXPRESSENDSDATE" onClick="WdatePicker()"
                                                              fieldType="date" style="width:90%"></td>
    <td width="2%" nowrap="nowrap" class="lbl_right_padding">至</td>
    <td width="14%" nowrap="nowrap" class="data_input"><input type="text" id="EXPRESSENDSDATE2"
                                                              name="EXPRESSENDSDATE2"
                                                              onClick="WdatePicker()" fieldType="date"
                                                              style="width:90%"></td>
    <td width="20%" nowrap="nowrap" class="lbl_right_padding">快递回证日期起</td>
    <td width="14%" nowrap="nowrap" class="data_input"><input type="text" id="EXPRESSRTNDATE"
                                                              name="EXPRESSRTNDATE" onClick="WdatePicker()"
                                                              fieldType="date" style="width:90%"></td>
    <td width="2%" nowrap="nowrap" class="lbl_right_padding">至</td>
    <td width="14%" nowrap="nowrap" class="data_input"><input type="text" id="EXPRESSRTNDATE2"
                                                              name="EXPRESSRTNDATE2"
                                                              onClick="WdatePicker()" fieldType="date"
                                                              style="width:90%"></td>
</tr>
<tr>
    <td width="20%" nowrap="nowrap" class="lbl_right_padding">快递资料签收日期起</td>
    <td width="14%" nowrap="nowrap" class="data_input"><input type="text" id="EXP_DATA_SIGNIN_DATE"
                                                              name="EXP_DATA_SIGNIN_DATE" onClick="WdatePicker()"
                                                              fieldType="date" style="width:90%"></td>
    <td width="2%" nowrap="nowrap" class="lbl_right_padding">至</td>
    <td width="14%" nowrap="nowrap" class="data_input"><input type="text" id="EXP_DATA_SIGNIN_DATE2"
                                                              name="EXP_DATA_SIGNIN_DATE2"
                                                              onClick="WdatePicker()" fieldType="date"
                                                              style="width:90%"></td>
    <td width="20%" nowrap="nowrap" class="lbl_right_padding">快递权证签收日期起</td>
    <td width="14%" nowrap="nowrap" class="data_input"><input type="text" id="EXP_PAPER_SIGNIN_DATE"
                                                              name="EXP_PAPER_SIGNIN_DATE" onClick="WdatePicker()"
                                                              fieldType="date" style="width:90%"></td>
    <td width="2%" nowrap="nowrap" class="lbl_right_padding">至</td>
    <td width="14%" nowrap="nowrap" class="data_input"><input type="text" id="EXP_PAPER_SIGNIN_DATE2"
                                                              name="EXP_PAPER_SIGNIN_DATE2"
                                                              onClick="WdatePicker()" fieldType="date"
                                                              style="width:90%"></td>
</tr>
<tr>
    <td width="20%" nowrap="nowrap" class="lbl_right_padding">开发贷不可报抵押日期起</td>
    <td width="14%" nowrap="nowrap" class="data_input"><input type="text" id="RPTNOMORTDATE"
                                                              name="RPTNOMORTDATE" onClick="WdatePicker()"
                                                              fieldType="date" style="width:90%"></td>
    <td width="2%" nowrap="nowrap" class="lbl_right_padding">至</td>
    <td width="14%" nowrap="nowrap" class="data_input"><input type="text" id="RPTNOMORTDATE2"
                                                              name="RPTNOMORTDATE2"
                                                              onClick="WdatePicker()" fieldType="date"
                                                              style="width:90%"></td>
    <td width="20%" nowrap="nowrap" class="lbl_right_padding">开发贷可报抵押日期起</td>
    <td width="14%" nowrap="nowrap" class="data_input"><input type="text" id="RPTMORTDATE"
                                                              name="RPTMORTDATE" onClick="WdatePicker()"
                                                              fieldType="date" style="width:90%"></td>
    <td width="2%" nowrap="nowrap" class="lbl_right_padding">至</td>
    <td width="14%" nowrap="nowrap" class="data_input"><input type="text" id="RPTMORTDATE2"
                                                              name="RPTMORTDATE2"
                                                              onClick="WdatePicker()" fieldType="date"
                                                              style="width:90%"></td>
</tr>
<tr>
    <td width="20%" nowrap="nowrap" class="lbl_right_padding">快递抵押柜号</td>
    <td width="30%" nowrap="nowrap" class="data_input" colspan="3">
        <input type="text" id="BOXID" name="BOXID" fieldType="text" style="width:95.3%" >
    </td>
    <td width="20%" nowrap="nowrap" class="lbl_right_padding">抵押流转状态</td>
    <td width="14%" nowrap="nowrap" class="data_input">
        <%
            zs = new ZtSelect("MORTSTATUS1", "MORTSTATUS", "");
            zs.addAttr("style", "width: 91%");
            zs.addAttr("fieldType", "text");
            zs.addOption("", "");
            out.print(zs);
        %>
    </td>
    <td width="2%" nowrap="nowrap" class="lbl_right_padding">至</td>
    <td width="14%" nowrap="nowrap" class="data_input">
        <%
            zs = new ZtSelect("MORTSTATUS2", "MORTSTATUS", "");
            zs.addAttr("style", "width: 91%");
            zs.addAttr("fieldType", "text");
            zs.addOption("", "");
            out.print(zs);
        %>
    </td>
    </td>
</tr>
<tr>
    <td width="20%" nowrap="nowrap" class="lbl_right_padding">贷款清退原因</td>
    <td width="30%" nowrap="nowrap" class="data_input" colspan="3"><%
        zs = new ZtSelect("CLRREASONCD", "CLRREASONCD", "");
        zs.addAttr("style", "width: 95.4%");
        zs.addAttr("fieldType", "text");
        zs.addOption("", "");
        out.print(zs);
    %>
    </td>
    <td width="20%" nowrap="nowrap" class="lbl_right_padding">特殊事项是否处理完毕</td>
    <td width="30%" nowrap="nowrap" class="data_input" colspan="3"><%
        zs = new ZtSelect("SPECIALBIZOVERFLAG", "BOOLTYPE", "");
        zs.addAttr("style", "width: 95.4%");
        zs.addAttr("fieldType", "text");
        zs.addOption("", "");
        out.print(zs);
    %>
    </td>
</tr>
<tr>
    <td width="20%" nowrap="nowrap" class="lbl_right_padding">抵押交易中心</td>
    <td width="30%" nowrap="nowrap" class="data_input" colspan="3">
        <%
            zs = new ZtSelect("MORTECENTERCD", "MORTECENTERCD", "1");
            zs.addAttr("style", "width: 95.4%");
            zs.addAttr("fieldType", "text");
            //zs.addAttr("isNull", "false");
            zs.addOption("", "");
            //zs.setDisplayAll(false);
            out.print(zs);
        %>
    </td>
</tr>

<tr>
    <td colspan="8" nowrap="nowrap" align="right"><input class="buttonGrooveDisable" name="cbRetrieve"
                                                         type="button" id="button"
                                                         onClick="cbRetrieve_Click(document.queryForm)"
                                                         onMouseOver="button_onmouseover()"
                                                         onMouseOut="button_onmouseout()" value="检索">
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
