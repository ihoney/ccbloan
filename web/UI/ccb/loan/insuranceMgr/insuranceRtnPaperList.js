function body_resize() {
    divfd_loanRegistedTab.style.height = document.body.clientHeight - 180;
    loanRegistedTab.fdwidth="100%";

    initDBGrid("loanRegistedTab");
    // 初始化页面焦点
    body_init(queryForm, "cbRetrieve");
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
    if (trimStr(document.getElementById("mortid").value) != "") {
        whereStr += " and t.mortid='" + trimStr(document.getElementById("mortid").value) + "'";
    }
    if (trimStr(document.getElementById("INSURANCESTS").value) != "") {
        whereStr += " and t.INSURANCESTS ='" + trimStr(document.getElementById("INSURANCESTS").value) + "' ";
    }
    if (trimStr(document.getElementById("bankid").value) != "") {
        whereStr += " and a.bankid in(select deptid from ptdept start with deptid='"+document.getElementById("bankid").value+"' connect by prior deptid=parentdeptid)";
    }

    whereStr += " order by t.paperrtndate, a.bankid, t.mortid  ";
    document.all["loanRegistedTab"].whereStr = whereStr;


    /*
     whereStr += " order by a.cust_py asc";

     document.all["loanRegistedTab"].whereStr = whereStr;
     */
    document.all["loanRegistedTab"].RecordCount = "0";
    document.all["loanRegistedTab"].AbsolutePage = "1";
    // Table_Refresh in dbgrid.js pack
    Table_Refresh("loanRegistedTab", false, body_resize);
}

function loanRegistedTab_editRecord_click() {
    //增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }
    var sfeature = "dialogwidth:800px; dialogheight:350px;center:yes;help:no;resizable:yes;scroll:no;status:no";
    var tab = document.all["loanRegistedTab"];
    var trobj = tab.rows[tab.activeIndex];

    var mortID = "";

    if (tab.rows.length <= 0) {
        alert(MSG_NORECORD);
        return;
    }

    if ((trobj.ValueStr != undefined) && (trobj.ValueStr != "")) {
        var tmp = trobj.ValueStr.split(";");
        mortID = tmp[0];
        loanID = tmp[1];
    }
    var arg = new Object();
    // 操作类型：edit
    arg.doType = "edit";
    // 抵押编号
    arg.mortID = mortID;
    var ret = dialog("insuranceRtnPaperEdit.jsp?mortID=" + mortID + "&loanID=" + loanID + "&doType=edit", arg, sfeature);

    if (ret == "1") {
        document.getElementById("loanRegistedTab").RecordCount = "0";
        Table_Refresh("loanRegistedTab", false, body_resize);
    }
}