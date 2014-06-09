<!--
/*********************************************************************
* 功能描述: 个贷客户列表
* 修改人: nanmeiying
* 修改日期: 2013/09/01
***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK" %>
<%@include file="/global.jsp" %>
<%@page import="pub.platform.db.DBGrid" %>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>非普通资信评定</title>
    <script language="javascript" src="uncomcreditList.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>

    <script type="text/javascript">
        function checkDateEnd(input) {
            var ibdStr = document.getElementById("queryDateBeg").value;
            var iedStr = input.value;
            if (iedStr.length == 0) {
                return;
            }
            if (iedStr <= ibdStr) {
                alert("应大于初始日期！");
                input.value = "";
                return;
            }
        }
    </script>
</head>
<%
    DBGrid dbGrid = new DBGrid();
    dbGrid.setGridID("creditraTable");
    dbGrid.setGridType("edit");
    String sql = "select t.pkid,t.creditratingno," +
            "(select ENUITEMLABEL from ptenudetail where ENUTYPE='IDTYPE' and ENUITEMVALUE = t.idtype) as idtype," +
            "t.idno,t.custname," +
            "(select ENUITEMLABEL from ptenudetail where ENUTYPE='JUDGETYPE' and ENUITEMVALUE = t.judgetype) as judgetype," +
            "t.judgelevel,t.judgeprice,t.timelimit,t.begdate,t.enddate,t.birthday,t.age," +
            "decode(t.sex,'1','男','0','女') as sex," +
            "t.post,t.income,t.formalworker,t.judgeoperid," +
            "(select opername from ptoper where operid = t.JUDGEOPERID) as opername," +
            "t.judgedate,t.judgedeptid," +
            "(select deptname from ptdept where deptid = t.judgedeptid ) as deptname,t.docid " +
            "from ln_uncomcredit t where recsta = '1' ";
    dbGrid.setfieldSQL(sql);
    dbGrid.setField("主键", "center", "7", "pkid", "false", "-1");
    dbGrid.setField("资信评定号", "center", "7", "creditratingno", "true", "-1");
    dbGrid.setField("证件类型", "center", "9", "idtype", "true", "0");
    dbGrid.setField("证件号码", "center", "8", "idno", "true", "0");
    dbGrid.setField("客户名称", "text", "4", "custname", "true", "0");
    dbGrid.setField("评信方式", "center", "4", "judgetype", "true", "0");
    dbGrid.setField("评信等级", "center", "4", "judgelevel", "true", "0");
    dbGrid.setField("评信金额(万)", "number", "5", "judgeprice", "true", "0");
    dbGrid.setField("期限(月)", "number", "3", "timelimit", "true", "0");
    dbGrid.setField("有效日期起日", "center", "5", "begdate", "true", "0");
    dbGrid.setField("有效日期止日", "center", "5", "enddate", "true", "0");
    dbGrid.setField("出生日期", "center", "5", "birthday", "true", "0");
    dbGrid.setField("年龄", "center", "2", "age", "true", "0");
    dbGrid.setField("性别", "center", "2", "sex", "true", "0");
    dbGrid.setField("职务", "center", "4", "post", "true", "0");
    dbGrid.setField("月收入(元)", "center", "4", "income", "true", "0");
    dbGrid.setField("是否正式员工", "center", "5", "formalworker", "true", "0");
    dbGrid.setField("操作员代码", "center", "4", "judgeoperid", "false", "0");
    dbGrid.setField("操作员名称", "center", "4", "opername", "true", "0");
    dbGrid.setField("评信日期", "center", "5", "judgedate", "true", "0");
    dbGrid.setField("评信机构号", "center", "4", "judgedeptid", "false", "0");
    dbGrid.setField("评信机构", "center", "4", "deptname", "true", "0");
    dbGrid.setField("档案号", "center", "9", "docid", "true", "0");
    dbGrid.setWhereStr(" order by judgedate desc ");
    dbGrid.setpagesize(50);
    dbGrid.setdataPilotID("datapilot");
    dbGrid.setbuttons("导出Excel=excel,查看客户详情=query,新增客户=insertRecord,追加客户=appendRecord,修改客户=editRecord,删除客户=deleteRecord,输出条形码=barCodeManage,moveFirst,prevPage,nextPage,moveLast");
%>
<body bgcolor="#ffffff" onLoad="body_resize()" onResize="body_resize();" class="Bodydefault">
<fieldset>
    <legend> 查询条件</legend>
    <table border="0" cellspacing="0" cellpadding="0" width="100%">
        <form id="queryForm" name="queryForm">
            <!-- 系统日志表使用 -->
            <input type="hidden" id="busiNode"/>
            <input type="hidden" id="pkid" name="pkid" value="">
            <tr>
                <td width="20%" class="lbl_right_padding">资信评定号</td>
                <td width="30%" align="right" nowrap="nowrap" class="data_input">
                    <input type="text" id="creditratingno" size="30" style="width:90% ">
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
                <td width="20%" align="right" nowrap="nowrap" class="lbl_right_padding">评信机构号</td>
                <td width="30%" class="data_input">
                    <input type="text" id="judgedeptid" size="60" value="" style="width:90% ">
                </td>
                <td width="10%" align="right" nowrap="nowrap">
                    <input name="cbRetrieve" type="button" class="buttonGrooveDisable" id="button"
                           onClick="queryClick();" onMouseOver="button_onmouseover()" onMouseOut="button_onmouseout()"
                           value="检 索">
                </td>
            </tr>
            <tr>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">操作员代码</td>
                <td width="30%" class="data_input">
                    <input type="text" id="judgeoperid" size="60" style="width:90% ">
                </td>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">评信方式</td>
                <td width="30%" class="data_input">
                    <select id="judgetype">
                        <option value="" selected="true"></option>
                        <option value="01">集体评信</option>
                        <option value="02">高端评信</option>
                        <option value="03">简化评信</option>
                        <option value="04">存量评信</option>
                        <option value="05">其它评信</option>
                    </select>
                </td>
                <td width="10%" align="right" nowrap="nowrap">
                    <input name="Input" class="buttonGrooveDisable" type="reset" value="重 填"
                           onMouseOver="button_onmouseover()" onMouseOut="button_onmouseout()">
                </td>
            </tr>
            <tr>
                <td width="20%" class="lbl_right_padding">检索日期起</td>
                <td width="30%" align="right" nowrap="nowrap" class="data_input">
                    <input type="text" id="queryDateBeg"
                           onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'queryDateEnd\')}'})"
                           size="30" style="width:90% ">
                </td>
                <td width="20%" align="right" nowrap="nowrap" class="lbl_right_padding">检索日期止</td>
                <td width="30%" align="right" nowrap="nowrap" class="data_input">
                    <input type="text" id="queryDateEnd"
                           onFocus="WdatePicker({minDate:'#F{$dp.$D(\'queryDateBeg\')}'})"
                           size="60" style="width:90% ">
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
