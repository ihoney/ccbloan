var SQLStr;
var gWhereStr = "";
var dw_form;

/**
 * 初始化form函数
 */
function body_resize() {
    divfd_mainTab.style.height = document.body.clientHeight - 210;
    mainTab.fdwidth = "100%";
    mainTab.actionname = "com.ccb.mortgage.mortgageAction";
    mainTab.delmethodname = "edit";
    initDBGrid("mainTab");
    //初始化页面焦点
    body_init(queryForm, "cbRetrieve");
    document.getElementById("cust_name").focus();
    document.getElementById("cust_name").select();
    //生成数据窗口校验使用
    dw_form = new DataWindow(document.getElementById("queryForm"), "form");
}


function clear_Click(formname) {
    document.getElementById("cust_name").value = "";
    document.getElementById("clrreasonremark").value = "";
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

    if (trimStr(document.getElementById("mortecentercd").value) != "") {
        whereStr += " and b.mortecentercd ='" + trimStr(document.getElementById("mortecentercd").value) + "' ";
    }
    if (trimStr(document.getElementById("bankid").value) != "") {
        whereStr += " and a.bankid in(select deptid from ptdept start with deptid='" + document.getElementById("bankid").value + "' connect by prior deptid=parentdeptid)";
    }

    if (trimStr(document.getElementById("clrreasonremark").value) != "") {
        whereStr += " and b.clrreasonremark like '%" + trimStr(document.getElementById("clrreasonremark").value) + "%' ";
    }

    whereStr += " order by b.mortid, a.bankid, b.CLRPAPERDATE desc ";
    document.all["mainTab"].whereStr = whereStr;

    document.all["mainTab"].RecordCount = "0";
    document.all["mainTab"].AbsolutePage = "1";
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
        nbxh = tmp[1];

    }
    var arg = new Object();
    arg.doType = "select";
    dialog("/UI/ccb/loan/loanMgr/loanEdit.jsp?nbxh=" + nbxh + "&doType=select", arg, sfeature);
}

/**
 * 批量更新
 */
function mainTab_batchEdit_click() {
    // 选取数据标志
    var checked = false;
    var tab = document.all.mainTab;
    var clientNames = "";
    var count = 0;
    for (i = 0; i < tab.rows.length; i++) {
        if (tab.rows[i].cells[0].children[0] != undefined && tab.rows[i].cells[0].children[0].checked) {
            checked = true;
            count++;
            clientNames += "" + count + "." + tab.rows[i].ValueStr.split(";")[5] + " ";
        }
    }
    if (!checked) {
        alert(MSG_NORECORD);
        return;
    }
    // ---信息输入---
    var sfeature = "dialogwidth:800px; dialogheight:400px;center:yes;help:no;resizable:yes;scroll:yes;status:no";
    var arg = {};
    arg.doType = "edit";
    arg.clientNames = clientNames;
    var rtn = dialog("sscmFeedbackEdit.jsp?doType=edit", arg, sfeature);

    function appendOneTdIntoRow(fieldname, oldvalue) {
        _cell = document.createElement("td");
        _cell.setAttribute("fieldname", fieldname);
        _cell.style.display = "none";
        _cell.setAttribute("fieldtype", "text");
        _cell.setAttribute("oldvalue", oldvalue);
        tab.rows[i].appendChild(_cell);
    }

    if (rtn != undefined) {
        for (var i = 0; i < tab.rows.length; i++) {
            if (tab.rows[i].cells[0].children[0] != undefined && tab.rows[i].cells[0].children[0].checked) {
                tab.rows[i].operate = "delete";
                checked = true;
                var _cell;
                appendOneTdIntoRow("recversion", tab.rows[i].ValueStr.split(";")[0]);
                appendOneTdIntoRow("sscm_status", rtn.sscm_status);
                appendOneTdIntoRow("sscm_date", rtn.sscm_date);
                appendOneTdIntoRow("sscm_nocancel_reason", rtn.sscm_nocancel_reason);
                appendOneTdIntoRow("busiNode", "SSCM");
            } else {
                tab.rows[i].operate = "";
            }
        }

        // 提交后台进行批量修改
        var retxml = postGridRecord(tab);
        if (retxml + "" == "true") {
            window.returnValue = "1";
        }
    }
}
