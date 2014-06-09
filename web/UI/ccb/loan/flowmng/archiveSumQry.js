
function body_resize() {
    divfd_tab1.style.height = 400;
    divfd_tab2.style.height = 200;
    tab1.fdwidth = "100%";
    tab2.fdwidth = "100%";
    initDBGrid("tab1");
    initDBGrid("tab2");
    // 初始化数据窗口，校验的时候用
    var dw_column = new DataWindow(document.getElementById("queryForm"), "form");
    resetDialogHeight();
}


function onSearch() {
    // 增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }
    if (checkForm(queryForm) == "false")
        return;

    var tab1Sql = document.getElementById("tab1Sql").value;
    tab1Sql = tab1Sql.replace("{startDate}", document.getElementById("STARTDATE").value);
    tab1Sql = tab1Sql.replace("{endDate}", document.getElementById("ENDDATE").value);

    var tab2Sql = document.getElementById("tab2Sql").value;
    tab2Sql = tab2Sql.replace("{startDate}", document.getElementById("STARTDATE").value);
    tab2Sql = tab2Sql.replace("{endDate}", document.getElementById("ENDDATE").value);

    document.getElementById("tab1").SQLStr = tab1Sql;
    document.getElementById("tab2").SQLStr = tab2Sql;
    document.all["tab1"].RecordCount = "0";
    document.all["tab2"].RecordCount = "0";
    document.all["tab1"].AbsolutePage = "1";
    document.all["tab2"].AbsolutePage = "1";

    Table_Refresh_asy("tab1");
    Table_Refresh_asy("tab2");
}



