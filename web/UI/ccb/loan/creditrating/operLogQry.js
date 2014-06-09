var SQLStr;
var gWhereStr = "";
function body_resize() {
    divfd_creditraTable.style.height = document.body.clientHeight - 255 + "px";
    creditraTable.fdwidth = "100%";
    initDBGrid("creditraTable");
    body_init(queryForm, "queryClick");
    document.getElementById("creditratingno").focus();

}

// //////查询函数  查询条件的append
function queryClick() {
    var whereStr = "";
    if (trimStr(document.all["creditratingno"].value) != "")
        whereStr += " and ( creditratingno like '" + document.all.creditratingno.value + "%')";
    if (trimStr(document.all["opername"].value) != "")
        whereStr += " and ( opername like '%" + document.all.opername.value + "%')";
    if (trimStr(document.all["creattype"].value) != "")
        whereStr += " and ( creattype = '" + document.all.creattype.value + "')";
    if (whereStr != document.all["creditraTable"].whereStr) {
        document.all["creditraTable"].whereStr = whereStr + " order by opertime desc ";
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
    if (trimStr(document.getElementById("opername").value) != "") {
        whereStr += " and ((a.opername like'" + trimStr(document.getElementById("opername").value) + "%')";
        whereStr += " or (a.cust_py  like'" + trimStr(document.getElementById("opername").value) + "%'))";
    }
    whereStr += " order by a.cust_py asc";
    document.all["creditraTable"].whereStr = whereStr;
    document.all["creditraTable"].RecordCount = "0";
    document.all["creditraTable"].AbsolutePage = "1";
    Table_Refresh("creditraTable", false, body_resize);
}


