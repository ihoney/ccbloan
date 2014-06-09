var SQLStr;
var gWhereStr = "";
function body_resize() {
    divfd_creditraTable.style.height = document.body.clientHeight - 255 + "px";
    creditraTable.fdwidth = "2280px";
    initDBGrid("creditraTable");
    body_init(queryForm, "queryClick");
    document.getElementById("creditratingno").focus();

}

// //////��ѯ����  ��ѯ������append
function queryClick() {
    var whereStr = "";
    if (trimStr(document.all["creditratingno"].value) != "")
        whereStr += " and ( creditratingno like '" + document.all.creditratingno.value + "%')";
    if (trimStr(document.all["idno"].value) != "") {
        var idnoStr = document.all.idno.value;
        if (idnoStr.length == 18) {
            var id1 = idnoStr.substr(0, 6);
            var id2 = idnoStr.substr(8, 9);
            var idnoStr2 = id1 + id2;
            whereStr += " and ( idno like '%" + document.all.idno.value + "%') or ( idno like '%" + idnoStr2 + "%')";
        } else {
            whereStr += " and ( idno like '%" + document.all.idno.value + "%')";
        }
    }
    if (trimStr(document.all["custname"].value) != "")
        whereStr += " and ( custname like '%" + document.all.custname.value + "%')";
    if (trimStr(document.all["inideptid"].value) != "")
        whereStr += " and ( inideptid like '%" + document.all.inideptid.value + "%')";
    //
    if (trimStr(document.all["inioperid"].value) != "")
        whereStr += " and ( inioperid like '%" + document.all.inioperid.value + "%')";
    if (trimStr(document.all["finoperid"].value) != "")
        whereStr += " and ( finoperid like '%" + document.all.finoperid.value + "%')";
    if (trimStr(document.all["queryDateBeg"].value) != "")
        whereStr += " and ( to_char(finbegdate,'yyyy-mm-dd') >= '" + document.all.queryDateBeg.value + "') ";
    if (trimStr(document.all["queryDateEnd"].value) != "")
        whereStr += " and ( to_char(finbegdate,'yyyy-mm-dd') <= '" + document.all.queryDateEnd.value + "') ";
    if (whereStr != document.all["creditraTable"].whereStr) {
        document.all["creditraTable"].whereStr = whereStr + " order by inidate desc ";
        document.all["creditraTable"].RecordCount = "0";
        document.all["creditraTable"].AbsolutePage = "1";
        Table_Refresh("creditraTable"); //ˢ�±��������
    }
}

/**
 * ������������������ɺ󽹵��Զ���λ�����������һ�������У� ����ȫѡ��;
 */
function cbRetrieve_Click(formname) {
    // ����ϵͳ�����
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
 * ������������
 */
function creditraTable_creditRating_click() {
    // ����ϵͳ�����
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }

    var sfeature = "dialogwidth:800px; dialogheight:620px;center:yes;help:no;resizable:yes;scroll:yes;status:no";
    var tab = document.all["creditraTable"];
    var trobj = tab.rows[tab.activeIndex];
    var creditratingno = "";
    var custno = "";
    var creditratingno = "";
    var validitytime = "";
    var validitytimetwo = "";
    var currentDate = "";
    if (tab.rows.length <= 0) {
        alert(MSG_NORECORD);
        return;
    }
    if ((trobj.ValueStr != undefined) && (trobj.ValueStr != "")) {
        var tmp = trobj.ValueStr.split(";");
        creditratingno = tmp[0];
        custno = tmp[1]
        validitytime = tmp[23];
        validitytimetwo = tmp[24];
        currentDate = tmp[25];
    }
    if (validitytime != "") {
        if (currentDate <= validitytimetwo) {
            alert("�ͻ�������(��Ч�ڽ�ֹ��" + validitytime + ")��\r\n�������ѻ��壬�����������Ч�ڣ�");
            return;
        } else if (currentDate > validitytimetwo && currentDate <= validitytime) {
            alert("�ͻ�������(��Ч�ڽ�ֹ��" + validitytime + ")��\r\n��������ǰ����������");
        }
    }

    var arg = new Object();
    arg.doType = "edit";// �������ͣ�edit
    arg.proj_no = creditratingno;
    var ret = dialog("/UI/ccb/loan/creditrating/gradestandFH.jsp?custno=" + custno + "&doType=edit&creditratingno=" + creditratingno, arg, sfeature);
    if (ret == "1") {
        document.getElementById("creditraTable").RecordCount = "0";
        Table_Refresh("creditraTable", false, body_resize);
    }
}