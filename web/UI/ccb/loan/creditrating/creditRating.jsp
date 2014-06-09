<!--
/*********************************************************************
* 功能描述: 资信评定页面支行
* 修改人: nanmeiying
* 修改日期: 2013/09/01
***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK" %>
<%@include file="/global.jsp" %>
<%@page import="pub.platform.db.DBGrid" %>
<%@page import="pub.platform.system.manage.dao.PtDeptBean" %>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>资信评定</title>
    <script language="javascript" src="creditRating.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
</head>
<%
    OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
    PtDeptBean ptOperBean = omgr.getOperator().getPtDeptBean();
    DBGrid dbGrid = new DBGrid();
    String deptid = ptOperBean.getDeptid();
    dbGrid.setGridID("creditraTable");
    dbGrid.setGridType("edit");
    String sql = "select a.CUSTNO,a.CUSTNAME,a.AGE,decode(a.sex,'1','男','0','女') as SEX," +
            "a.BIRTHDAY,a.IDNO,a.CORPTEL,a.CORPADDR,a.HOMEADDR,a.TEL1,a.MOBILE1," +
            "(select ENUITEMLABEL from ptenudetail where ENUTYPE='EDUCATION' and ENUITEMVALUE = a.EDUCATION) as EDUCATION," +
            "(select ENUITEMLABEL from ptenudetail where ENUTYPE='MARISTA' and ENUITEMVALUE = a.MARISTA) as MARISTA," +
            "a.WORKYEARS,a.INCOME,a.HOMEPERSONS," +
            "decode(a.HEALTH,'01','良好','02','一般','03','较差') as HEALTH," +
            "decode(a.MEMBERFLG,'1','是','0','否') as MEMBERFLG," +
            "a.SPOUSENAME,a.SPOUSETEL,a.REMARK,a.DEPTID," +
            "(select DEPTNAME || '('|| DEPTID || ')' from ptdept where DEPTID = a.DEPTID) as DEPTNAME," +
            "a.OPERID,a.OPERDATE,a.UPDOPERID,a.UPDDATE,a.VALIDITYTIME,SYSDATE,a.VALIDITYTIMETWO from ln_pcif a where recsta = '1' ";
    dbGrid.setfieldSQL(sql);
    dbGrid.setField("客户号", "center", "18", "custno", "true", "-1");
    dbGrid.setField("客户名", "text", "16", "custname", "true", "0");
    dbGrid.setField("年龄", "center", "10", "age", "true", "0");
    dbGrid.setField("性别", "center", "10", "sex", "true", "0");
    dbGrid.setField("出生日期", "center", "18", "birthday", "true", "0");
    dbGrid.setField("证件号码", "center", "26", "idno", "true", "0");
    dbGrid.setField("单位电话", "center", "16", "corptel", "true", "0");
    dbGrid.setField("单位地址", "text", "17", "corpaddr", "true", "0");
    dbGrid.setField("家庭地址", "text", "17", "homeaddr", "true", "0");
    dbGrid.setField("其他电话1", "center", "16", "tel1", "true", "0");
    dbGrid.setField("手机1", "center", "16", "mobile1", "true", "0");
    dbGrid.setField("文化程度", "text", "15", "education", "true", "0");
    dbGrid.setField("婚姻状况", "text", "15", "marista", "true", "0");
    dbGrid.setField("本岗位工作年限", "number", "10", "workyears", "true", "0");
    dbGrid.setField("个人月收入", "number", "16", "income", "true", "0");
    dbGrid.setField("家庭人口数", "number", "10", "homepersons", "true", "0");
    dbGrid.setField("借款人健康状况", "center", "20", "health", "true", "0");
    dbGrid.setField("是否本行员工", "center", "12", "memberflg", "true", "0");
    dbGrid.setField("配偶姓名", "text", "14", "spousename", "true", "0");
    dbGrid.setField("配偶电话", "center", "16", "spousetel", "true", "0");
    dbGrid.setField("备注", "text", "12", "remark", "true", "0");
    dbGrid.setField("建立机构号", "center", "16", "deptid", "false", "0");
    dbGrid.setField("建立机构", "text", "30", "deptname", "true", "0");
    dbGrid.setField("建立柜员", "text", "14", "operid", "true", "0");
    dbGrid.setField("建立日期", "center", "18", "operdate", "true", "0");
    dbGrid.setField("修改柜员", "text", "14", "updoperid", "true", "0");
    dbGrid.setField("修改日期", "center", "18", "upddate", "true", "0");
    dbGrid.setField("有效日期", "center", "18", "validitytime", "false", "0");
    dbGrid.setField("当前日期", "center", "18", "sysdate", "false", "0");
    dbGrid.setField("有效日期二", "center", "18", "validitytimetwo", "false", "0");
    dbGrid.setWhereStr(" order by operdate desc ");
    dbGrid.setpagesize(50);
    dbGrid.setdataPilotID("datapilot");
    dbGrid.setbuttons("导出Excel=excel,查看客户详情=query,资信评定=creditRating,moveFirst,prevPage,nextPage,moveLast");
%>
<body bgcolor="#ffffff" onLoad="body_resize()" onResize="body_resize();" class="Bodydefault">
<fieldset>
    <legend> 查询条件</legend>
    <table border="0" cellspacing="0" cellpadding="0" width="100%">
        <form id="queryForm" name="queryForm">
            <!-- 系统日志表使用 -->
            <input type="hidden" id="busiNode"/>
            <tr>
                <td width="20%" class="lbl_right_padding"> 客户号</td>
                <td width="30%" align="right" nowrap="nowrap" class="data_input">
                    <input type="text" id="custno" size="30" style="width:90% ">
                </td>
                <td width="20%" align="right" nowrap="nowrap" class="lbl_right_padding">证件号码</td>
                <td width="30%" align="right" nowrap="nowrap" class="data_input">
                    <input type="text" id="idno" size="60" style="width:90% ">
                </td>
            </tr>
            <tr>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">客户姓名</td>
                <td width="30%" class="data_input">
                    <input type="text" id="custname" size="60" style="width:90% ">
                </td>
                <td width="20%" align="right" nowrap="nowrap" class="lbl_right_padding"> 建立机构号</td>
                <td width="30%" class="data_input">
                    <input type="text" id="deptid" size="60" value="<%=deptid%>" style="width:90% ">
                </td>
                <td width="10%" align="right" nowrap="nowrap">
                    <input name="cbRetrieve" type="button" class="buttonGrooveDisable" id="button"
                           onClick="queryClick();" onMouseOver="button_onmouseover()" onMouseOut="button_onmouseout()"
                           value="检 索">
                </td>
            </tr>
            <tr>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">建立柜员</td>
                <td width="30%" class="data_input">
                    <input type="text" id="operid" size="60" style="width:90% ">
                </td>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">修改柜员</td>
                <td width="30%" class="data_input">
                    <input type="text" id="updoperid" size="60" style="width:90% ">
                </td>
                <td width="10%" align="right" nowrap="nowrap">
                    <input name="Input" class="buttonGrooveDisable" type="reset" value="重 填"
                           onMouseOver="button_onmouseover()" onMouseOut="button_onmouseout()">
                </td>
            </tr>
        </form>
    </table>
</fieldset>
<fieldset>
    <legend> 客户信息</legend>
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
