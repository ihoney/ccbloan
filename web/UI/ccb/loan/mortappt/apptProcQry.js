var SQLStr;
var gWhereStr = "";
var dw_form;

/**
 * 初始化form函数
 */
function body_resize() {
    divfd_mainTab.style.height = document.body.clientHeight - 220;
    mainTab.fdwidth = 2600;
    mainTab.actionname = "com.ccb.mortgage.AppointmentAction";
    mainTab.delmethodname = "batchEdit";
    initDBGrid("mainTab");
    //初始化页面焦点
    body_init(queryForm, "cbRetrieve");
    document.getElementById("cust_name").focus();
    document.getElementById("cust_name").select();
    //生成数据窗口校验使用
    dw_form = new DataWindow(document.getElementById("queryForm"), "form");
}


function cbRetrieve_Click(formname) {
    // 增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }

    if (checkForm(queryForm) == "false")
        return;

    var whereStr = "";
    if (trimStr(document.getElementById("cust_name").value) != "") {
        whereStr += " and ((a.cust_name like'" + trimStr(document.getElementById("cust_name").value) + "%')";
        whereStr += " or (a.cust_py  like'" + trimStr(document.getElementById("cust_name").value) + "%'))";
    }

/*
    if (trimStr(document.getElementById("mortecentercd").value) != "") {
        whereStr += " and b.mortecentercd ='" + trimStr(document.getElementById("mortecentercd").value) + "' ";
    }
    if (trimStr(document.getElementById("bankid").value) != "") {
        //whereStr += " and a.bankid in(select deptid from ptdept start with deptid='" + document.getElementById("bankid").value + "' connect by prior deptid=parentdeptid)";
        whereStr += " and (a.bankid in(select deptid from ptdept start with deptid='" + document.getElementById("bankid").value + "' connect by prior deptid=parentdeptid) " +
            " and b.mortecentercd in (select mortecentercd from ln_morttype where deptid='" + document.getElementById("user_deptid").value +"' and typeflag='0')) ";
    }
*/
    if (trimStr(document.getElementById("bankid").value) != "") {
        whereStr += " and a.bankid in(select deptid from ptdept start with deptid='" + document.getElementById("bankid").value + "' connect by prior deptid=parentdeptid) ";
    }
    if (trimStr(document.getElementById("mortecentercd").value) != "") {
        whereStr += " and b.mortecentercd ='" + trimStr(document.getElementById("mortecentercd").value) + "' ";
    }else{
        if (trimStr(document.getElementById("ploanProxyDept").value) == "1") {
            whereStr +=  " and b.mortecentercd in (select mortecentercd from LN_MORTCENTER_APPT where deptid='" + document.getElementById("user_deptid").value +"' and typeflag='0') ";
        }
    }

    if (trimStr(document.getElementById("APPTSTATUS").value) != "") {
        whereStr += " and b.APPTSTATUS ='" + trimStr(document.getElementById("APPTSTATUS").value) + "' ";
    }
    if (trimStr(document.getElementById("APPT_FEEDBACK_RESULT").value) != "") {
        whereStr += " and b.APPT_FEEDBACK_RESULT ='" + trimStr(document.getElementById("APPT_FEEDBACK_RESULT").value) + "' ";
    }
    if (trimStr(document.getElementById("proj_name_abbr").value) != "") {
        whereStr += " and a.proj_name_abbr like '%" + document.getElementById("proj_name_abbr").value + "%' ";
    }
    if (trimStr(document.getElementById("APPTBIZCODE").value) != "") {
        whereStr += " and b.appt_biz_code ='" + trimStr(document.getElementById("APPTBIZCODE").value) + "' ";
    }

    whereStr += getWhereString_oper_str("b", "APPT_HDL_DATE", ">=", "STARTDATE");
    whereStr += getWhereString_oper_str("b", "APPT_HDL_DATE", "<=", "ENDDATE");

    whereStr += " order by b.appt_date_apply desc, b.appt_time_apply desc,b.mortecentercd, a.bankid, b.mortid ";
    document.all["mainTab"].whereStr = whereStr;

    document.all["mainTab"].RecordCount = "0";
    document.all["mainTab"].AbsolutePage = "1";
    // Table_Refresh in dbgrid.js pack
    Table_Refresh("mainTab", false, body_resize);
}

function getWhereString_oper_str(tableName, dbFieldName, operator, uiFieldName) {
    if (trimStr(document.getElementById(uiFieldName).value) != "") {
        return  " and " + tableName + "." + dbFieldName + operator + "'" + trimStr(document.getElementById(uiFieldName).value) + "'";
    } else {
        return "";
    }
}

/**
 * 察看抵押详细函数
 *
 * @param mortid：抵押编号
 * @param doType:select
 *            操作类型
 */
function mainTab_query_click() {
    // 增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }

    var sfeature = "dialogwidth:800px; dialogheight:600px;center:yes;help:no;resizable:yes;scroll:yes;status:no";
    var tab = document.all["mainTab"];
    var trobj = tab.rows[tab.activeIndex];
    // 抵押编号
    var mortID = "";

    if (tab.rows.length <= 0) {
        alert(MSG_NORECORD);
        return;
    }

    if ((trobj.ValueStr != undefined) && (trobj.ValueStr != "")) {
        var tmp = trobj.ValueStr.split(";");
        mortID = tmp[7];
        //alert(mortID);
    }
    var arg = new Object();
    arg.doType = "select";
    dialog("/UI/ccb/loan/mortReg/mortgageEdit.jsp?mortID=" + mortID + "&doType=select", arg, sfeature);
}

/**
 * 双击表格弹出详细信息查看画面 调用查看函数
 */
function mainTab_TRDbclick() {
    mainTab_query_click();
}

/**
 * 察看贷款详细函数
 */
function mainTab_loanQuery_click() {

    // 增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }

    var sfeature = "dialogwidth:800px; dialogheight:520px;center:yes;help:no;resizable:yes;scroll:yes;status:no";
    var tab = document.all["mainTab"];
    var trobj = tab.rows[tab.activeIndex];
    var nbxh = "";

    if (tab.rows.length <= 0) {
        alert(MSG_NORECORD);
        return;
    }

    if ((trobj.ValueStr != undefined) && (trobj.ValueStr != "")) {
        var tmp = trobj.ValueStr.split(";");
        nbxh = tmp[0];

    }
    var arg = new Object();
    arg.doType = "select";
    dialog("/UI/ccb/loan/loanMgr/loanEdit.jsp?nbxh=" + nbxh + "&doType=select", arg, sfeature);
}

