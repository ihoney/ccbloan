<!--
/*********************************************************************
* 功能描述: 机构买单统计表
***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK" %>
<%@include file="/global.jsp" %>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title></title>
    <script language="javascript" src="payBillList101.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
    <script language="javascript" src="/UI/support/common.js"></script>
    <script language="javascript" src="/UI/support/DataWindow.js"></script>
    <LINK href="/css/newccb.css" type="text/css" rel="stylesheet">

</head>

<%
    ConnectionManager cm = ConnectionManager.getInstance();
    DatabaseConnection dc = cm.get();

    String baseval1="";
    String baseval2="";
    String baseval3="";
    String baseval4="";
//    String baseval5="";
    try {
        RecordSet chrs = dc.executeQuery("select t.enuitemexpand from ptenudetail t where t.enutype='BIZPARAM' and t.enuitemvalue like 'PayBillRpt101_%'");
        if  (chrs != null && chrs.next()) {
            baseval1 =  chrs.getString("enuitemexpand");
        }
        if  (chrs != null && chrs.next()) {
            baseval2 =  chrs.getString("enuitemexpand");
        }
        if  (chrs != null && chrs.next()) {
            baseval3 =  chrs.getString("enuitemexpand");
        }
        if  (chrs != null && chrs.next()) {
            baseval4 =  chrs.getString("enuitemexpand");
        }
/*
        if  (chrs != null && chrs.next()) {
            baseval5 =  chrs.getString("enuitemexpand");
        }
*/
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
//         if ( isAutoRelease )
        cm.release();
    }

%>


<body onload="formInit()" bgcolor="#ffffff" class="Bodydefault">
<form id="queryForm" name="queryForm">
    <fieldset style="padding:40px 25px 0px 25px;margin:0px 20px 0px 20px">
        <legend>报表条件</legend>
        <table border="0" cellspacing="0" cellpadding="0" width="90%" style="margin-top: 25px" align="center">
            <input type="hidden" value="miscRpt03" id="rptType" name="rptType"/>
            <tr>
                <td width="40%" nowrap="nowrap" class="lbl_right_padding">统计起始日期</td>
                <td width="60%" nowrap="nowrap" class="data_input"><input type="text" id="MORTEXPIREDATE"
                                                                          name="MORTEXPIREDATE" onClick="WdatePicker()"
                                                                          fieldType="date" size="20%"></td>
            </tr>
            <tr>
                <td width="40%" nowrap="nowrap" class="lbl_right_padding">统计截止日期</td>
                <td width="60%" nowrap="nowrap" class="data_input"><input type="text" id="MORTEXPIREDATE2"
                                                                          name="MORTEXPIREDATE2" onClick="WdatePicker()"
                                                                          fieldType="date" size="20%"></td>
            </tr>
        </table>
        <table border="0" cellspacing="0" cellpadding="0" width="90%" style="margin-top: 25px" align="center">
            <tr>
                <td width="40%" nowrap="nowrap" class="lbl_right_padding">个人住房贷款 每万元买单价格</td>
                <td width="60%" nowrap="nowrap" class="data_input"><input type="text" id="baseval1" value="<%=baseval1%>"
                                                                          name="baseval1" size="20%" style="text-align: right"></td>
            </tr>
            <tr>
                <td width="40%" nowrap="nowrap" class="lbl_right_padding">个人再交易贷款 每万元买单价格</td>
                <td width="60%" nowrap="nowrap" class="data_input"><input type="text" id="baseval2" value="<%=baseval2%>"
                                                                          name="baseval2" size="20%" style="text-align: right"></td>
            </tr>
            <tr>
                <td width="40%" nowrap="nowrap" class="lbl_right_padding">个人支农贷款 每万元买单价格</td>
                <td width="60%" nowrap="nowrap" class="data_input"><input type="text" id="baseval3" value="<%=baseval3%>"
                                                                          name="baseval3" size="20%" style="text-align: right" ></td>
            </tr>
            <tr>
                <td width="40%" nowrap="nowrap" class="lbl_right_padding">其它个人类贷款 每万元买单价格</td>
                <td width="60%" nowrap="nowrap" class="data_input"><input type="text" id="baseval4" value="<%=baseval4%>"
                                                                          name="baseval4" size="20%" style="text-align: right"></td>
            </tr>
<%--
            <tr>
                <td width="40%" nowrap="nowrap" class="lbl_right_padding">其他个人类贷款 每万元买单价格</td>
                <td width="60%" nowrap="nowrap" class="data_input"><input type="text" id="baseval5"  value="<%=baseval5%>"
                                                                          name="baseval5" size="20%" style="text-align: right"></td>
            </tr>
--%>
            <tr>
                <td colspan="4" nowrap="nowrap" align="center" style="padding:20px">
                    <input name="expExcel" class="buttonGrooveDisableExcel" type="button"
                           onClick="loanTab_expExcel_click()" value="导出excel">
                    <input type="reset" value="重填" class="buttonGrooveDisable">
                </td>
            </tr>
        </table>
    </fieldset>
</form>

<br/>
<br/>
<br/>

<div class="help-window">
    <DIV class=formSeparator>
        <H2>[买单数据统计]</H2>
    </DIV>
    <div class="help-info">
        <ul>
            <li>第七版：2013-07-30.</li>
            <li>第七版：由原来的两种变为四种：个人住房贷款（一手房、二手房）分成个人住房贷款和个人再交易贷款。其他个人类贷款分成个人支农贷款和其他个人类贷款.</li>
            <li>第七版：根据贷款种类，买单价格进行变化.</li>
            <li>第六版：2013-04-27.</li>
            <li>第六版：贷款类别重新划分 1、个人住房贷款（仅含一手房、二手房）和其它贷款.</li>
            <li>第六版：机构管理层级重新划分.</li>
            <li>第五版：2012-09-18.</li>
            <li>第五版：分别计算个人住房贷款（仅含一手房、二手房）和个人商业用房贷款绩效工资.</li>
            <li>第五版：个人住房贷款利率执行水平调节系数 = 1 +（本单位个人住房贷款加权平均上浮率 - 全行个人住房贷款平均上浮率）× 3.5.</li>
            <li>第四版：2012-07-20.</li>
            <li>第四版：修改排版，增加Excel计算公式.</li>
            <li>第三版：2012-06-25.</li>
            <li>第三版：增加个人住房贷款类别.</li>
            <li>第三版：按九支行、五市支行、全功能支行、网管一、网管二进行分组输出报表.</li>
            <li>第二版：2012-05-25.</li>
            <li>第二版：增加支农贷款类别.</li>
            <li>初版：2012-05-05.</li>
            <li>EXCEL重算说明：导出完毕后，打开EXCEL文件，按 Ctrl+Alt+Shift+F9 进行公式计算.</li>
        </ul>
    </div>
</div>


</body>
</html>
