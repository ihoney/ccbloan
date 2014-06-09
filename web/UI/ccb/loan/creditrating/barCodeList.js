var SQLStr;
var gWhereStr = "";
function body_resize() {
    divfd_creditraTable.style.height = document.body.clientHeight - 255 + "px";
    creditraTable.fdwidth = "2228px";
    initDBGrid("creditraTable");
    body_init(queryForm, "queryClick");
    document.getElementById("creditratingno").focus();

}

// //////查询函数  查询条件的append
function queryClick() {
    var whereStr = "";
    if (trimStr(document.all["creditratingno"].value) != "")
        whereStr += " and ( creditratingno like '" + document.all.creditratingno.value + "%')";
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
    if (trimStr(document.all["inideptid"].value) != "")
        whereStr += " and ( inideptid like '%" + document.all.inideptid.value + "%')";
    if (trimStr(document.all["inioperid"].value) != "")
        whereStr += " and ( inioperid like '%" + document.all.inioperid.value + "%')";
    if (trimStr(document.all["finoperid"].value) != "")
        whereStr += " and ( finoperid like '%" + document.all.finoperid.value + "%')";
    if (whereStr != document.all["creditraTable"].whereStr) {
        document.all["creditraTable"].whereStr = whereStr + " order by creditratingno ";
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

//条码管理
function creditraTable_barCodeManage_click() {
    // 增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }
    var sfeature = "dialogwidth:800px; dialogheight:620px;center:yes;help:no;resizable:yes;scroll:yes;status:no";
    var tab = document.all["creditraTable"];
    var trobj = tab.rows[tab.activeIndex];
    var creditratingno = "";
    if (tab.rows.length <= 0) {
        alert(MSG_NORECORD);
        return;
    }

    if ((trobj.ValueStr != undefined) && (trobj.ValueStr != "")) {
        var tmp = trobj.ValueStr.split(";");
        creditratingno = tmp[0];
    }

    var arg = new Object();
    arg.doType = "edit";  // 操作类型：edit
    arg.proj_no = creditratingno;
    var ret = dialog("/UI/ccb/loan/creditrating/barCodeEdit.jsp?creditratingno=" + creditratingno + "&doType=edit", arg, sfeature);
    if (ret == "1") {
        document.getElementById("creditraTable").RecordCount = "0";
        Table_Refresh("creditraTable", false, body_resize);
    }
}


