var SQLStr;
var gWhereStr = "";
function body_resize() {
    divfd_creditraTable.style.height = document.body.clientHeight - 255 + "px";
    creditraTable.fdwidth = "2280px";
    initDBGrid("creditraTable");
    body_init(queryForm, "queryClick");
    document.getElementById("custno").focus();
}

// //////查询函数  查询条件的append
function queryClick() {
    var whereStr = "";
    if (trimStr(document.all["custno"].value) != "")
        whereStr += " and ( custno like '" + document.all.custno.value + "%')";
    if (trimStr(document.all["idno"].value) != "") {
        var idnoStr = document.all.idno.value;
        if(idnoStr.length == 18){
            var id1 = idnoStr.substr(0,6);
            var id2 = idnoStr.substr(8, 9);
            var idnoStr2 = id1 + id2;
            whereStr += " and ( idno like '%" + document.all.idno.value + "%') or ( idno like '%" + idnoStr2 + "%')";
        } else{
            whereStr += " and ( idno like '%" + document.all.idno.value + "%')";
        }
    }
    if (trimStr(document.all["custname"].value) != "")
        whereStr += " and ( custname like '%" + document.all.custname.value + "%')";
    if (trimStr(document.all["deptid"].value) != "")
        whereStr += " and ( deptid like '%" + document.all.deptid.value + "%')";
    if (trimStr(document.all["operid"].value) != "")
        whereStr += " and ( operid like '%" + document.all.operid.value + "%')";
    if (trimStr(document.all["updoperid"].value) != "")
        whereStr += " and ( updoperid like '%" + document.all.updoperid.value + "%')";
    if (whereStr != document.all["creditraTable"].whereStr) {
        document.all["creditraTable"].whereStr = whereStr + " order by custno ";
        document.all["creditraTable"].RecordCount = "0";
        document.all["creditraTable"].AbsolutePage = "1";
        Table_Refresh("creditraTable"); //刷新表格的内容
    }
}

/**
 * ■检索函数，检索完成后焦点自动定位到检索区域第一个条件中， 并且全选中;
 */

function cbRetrieve_Click(formname) {
    // 增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }

    if (checkForm(queryForm) == "false")
        return;
    var whereStr = "";
    if (trimStr(document.getElementById("custname").value) != "") {
        whereStr += " and ((a.custname like'" + trimStr(document.getElementById("custname").value) + "%')";
        whereStr += " or (a.cust_py  like'" + trimStr(document.getElementById("custname").value) + "%'))";
    }
    whereStr += " order by a.cust_py asc";
    document.all["creditraTable"].whereStr = whereStr;
    document.all["creditraTable"].RecordCount = "0";
    document.all["creditraTable"].AbsolutePage = "1";
    Table_Refresh("creditraTable", false, body_resize);
}

/**
 * 查看客户列表详细信息
 */
function creditraTable_query_click() {
    // 增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }

    var sfeature = "dialogwidth:800px; dialogheight:620px;center:yes;help:no;resizable:yes;scroll:yes;status:no";
    var tab = document.all["creditraTable"];
    var trobj = tab.rows[tab.activeIndex];
    var custno = "";
    if (tab.rows.length <= 0) {
        alert(MSG_NORECORD);
        return;
    }

    if ((trobj.ValueStr != undefined) && (trobj.ValueStr != "")) {
        var tmp = trobj.ValueStr.split(";");
        custno = tmp[0];
    }
    var arg = new Object();
    arg.doType = "select";
    dialog("/UI/ccb/loan/creditrating/custManageEdit.jsp?custno=" + custno + "&doType=select", arg, sfeature);
}

/**
 * 双击表格弹出详细信息查看画面 调用查看函数
 *
 */
function creditraTable_TRDbclick() {
    creditraTable_query_click();
}

/**
 * 添加信息
 */
function creditraTable_appendRecod_click() {
    // 增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }
    var sfeature = "dialogwidth:800px; dialogheight:620px;center:yes;help:no;resizable:yes;scroll:yes;status:no";
    var tab = document.all["creditraTable"];
    var trobj = tab.rows[tab.activeIndex];

    var custno = "";
    var arg = new Object();
    arg.doType = "add";  // 操作类型：add
    arg.custno = "";
    var ret = dialog("/UI/ccb/loan/creditrating/custManageEdit.jsp?custno=" + custno + "&doType=add", arg, sfeature);
    if (ret == "1") {
        document.getElementById("creditraTable").RecordCount = "0";
        Table_Refresh("creditraTable", false, body_resize);
    }
}

/**
 * 编辑信息
 */
function creditraTable_editRecord_click() {
    // 增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }
    var sfeature = "dialogwidth:800px; dialogheight:620px;center:yes;help:no;resizable:yes;scroll:yes;status:no";
    var tab = document.all["creditraTable"];
    var trobj = tab.rows[tab.activeIndex];
    var custno = "";
    var validitytime = "";
    var validitytimetwo = "";
    var currentDate = "";
    if (tab.rows.length <= 0) {
        alert(MSG_NORECORD);
        return;
    }

    if ((trobj.ValueStr != undefined) && (trobj.ValueStr != "")) {
        var tmp = trobj.ValueStr.split(";");
        custno = tmp[0];
        validitytime = tmp[27];
        validitytimetwo = tmp[29];
        currentDate = tmp[28];
    }

    if (validitytime != "") {
        if(currentDate <= validitytimetwo){
            alert("客户已评信(有效期截止到" + validitytime + ")！\r\n若贷款已还清，请联系分行！");
            return;
        }else if(currentDate > validitytimetwo && currentDate <= validitytime){
            alert("客户已评信(有效期截止到" + validitytime + ")！\r\n但可以提前修改客户资料！");
        }
    }
    var arg = new Object();
    arg.doType = "edit";  // 操作类型：edit
    arg.proj_no = custno;
    var ret = dialog("/UI/ccb/loan/creditrating/custManageEdit.jsp?custno=" + custno + "&doType=edit", arg, sfeature);
    if (ret == "1") {
        document.getElementById("creditraTable").RecordCount = "0";
        Table_Refresh("creditraTable", false, body_resize);
    }
}

/**
 * 删除函数
 */
function creditraTable_deleteRecord_click() {
    // 增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }
    var tab = document.all["creditraTable"];
    var trobj = tab.rows[tab.activeIndex];
    var custno = "";
    var validitytime = "";
    var currentDate = "";
    if (tab.rows.length <= 0) {
        alert(MSG_NORECORD);
        return;
    }
    if ((trobj.ValueStr != undefined) && (trobj.ValueStr != "")) {
        var tmp = trobj.ValueStr.split(";");
        custno = tmp[0];
        validitytime = tmp[27];
        currentDate = tmp[28];
    }

    if (validitytime != "") {
        if (currentDate <= validitytime) {
            alert("客户已评信(有效期截止到" + validitytime + ")！");
            return;
        }
    }

    if (confirm("确定删除该条信息？\r\n客户号：" + custno)) {
        document.getElementById("busiNode").value = BUSINODE_190;
        document.all.custno.value = custno;
        var retxml = createExecuteform(queryForm, "delete", "crdt01", "delete");
        if (analyzeReturnXML(retxml) != "false") {
            alert(MSG_DEL_SUCCESS);
            document.getElementById("creditraTable").RecordCount = "0";
            Table_Refresh("creditraTable", false, body_resize);
        }
    }
}

