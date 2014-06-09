var SQLStr;
var gWhereStr = "";

/**
 * 初始化form函数,
 * <p>
 * ■初始化焦点定位在查询条件第一个控件上;
 * <p>
 * ■每次查询完毕后焦点自动定位到第一个控件，且全选；
 *
 */
function body_resize() {
    divfd_loanRegistedTab.style.height = document.body.clientHeight - 180;
    loanRegistedTab.fdwidth = "100%";
    initDBGrid("loanRegistedTab");
    // 初始化页面焦点
    body_init(queryForm, "cbRetrieve");
    document.getElementById("cust_name").focus();
    document.getElementById("cust_name").select();
}

/**
 * <p>
 * ■检索函数，检索完成后焦点自动定位到检索区域第一个条件中， 并且全选中;
 * <p>
 * ■系统根据姓名处输入的汉字或者拼音查询 汉字与拼音查询是“or”的关系;
 * <p>
 * ■汉字与拼音都支持前端一致、后端模糊查询；
 * <p>
 * ■按下回车键自动支持查询；
 * </p>
 * ■系统锁为1的时候，系统锁定，0的时候未锁定
 *
 * @param ：form名字或者ID
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
    if (trimStr(document.getElementById("cust_name").value) != "") {
        whereStr += " and ((a.cust_name like'" + trimStr(document.getElementById("cust_name").value) + "%')";
        whereStr += " or (a.cust_py  like'" + trimStr(document.getElementById("cust_name").value) + "%'))";
    }

    if (trimStr(document.getElementById("mortecentercd").value) != "") {
        whereStr += " and b.mortecentercd ='" + trimStr(document.getElementById("mortecentercd").value) + "' ";
    }
    if (trimStr(document.getElementById("bankid").value) != "") {
        whereStr += " and a.bankid in(select deptid from ptdept start with deptid='"+document.getElementById("bankid").value+"' connect by prior deptid=parentdeptid)";
    }

    whereStr += " order by b.mortecentercd, a.bankid, b.mortid ";
    document.all["loanRegistedTab"].whereStr = whereStr;
    /*
     *
     * whereStr += " order by b.mortdate desc,a.cust_py asc";
     *
     * document.all["loanRegistedTab"].whereStr = whereStr;
     */
    document.all["loanRegistedTab"].RecordCount = "0";
    document.all["loanRegistedTab"].AbsolutePage = "1";
    // Table_Refresh in dbgrid.js pack
    Table_Refresh("loanRegistedTab", false, body_resize);
}

/**
 * 察看抵押详细函数
 *
 * @param mortid：抵押编号
 * @param doType:select
 *            操作类型
 */
function loanRegistedTab_query_click() {
    // 增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }

    var sfeature = "dialogwidth:800px; dialogheight:600px;center:yes;help:no;resizable:yes;scroll:yes;status:no";
    var tab = document.all["loanRegistedTab"];
    var trobj = tab.rows[tab.activeIndex];
    // 抵押编号
    var mortID = "";

    if (tab.rows.length <= 0) {
        alert(MSG_NORECORD);
        return;
    }

    if ((trobj.ValueStr != undefined) && (trobj.ValueStr != "")) {
        var tmp = trobj.ValueStr.split(";");
        mortID = tmp[5];

    }
    var arg = new Object();
    arg.doType = "select";
    dialog("/UI/ccb/loan/mortReg/mortgageEdit.jsp?mortID=" + mortID + "&doType=select", arg, sfeature);
}

/**
 * 双击表格弹出详细信息查看画面 调用查看函数
 *
 */
function loanRegistedTab_TRDbclick() {
    loanRegistedTab_query_click();
}

/**
 * 添加抵押信息
 *
 * @param doType:操作类型
 *            增加（add）
 * @param loanid:贷款申请序号
 */
function loanRegistedTab_appendRecod_click() {

    // 增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }

    var sfeature = "dialogwidth:600px; dialogheight:260px;center:yes;help:no;resizable:yes;scroll:no;status:no";
    var tab = document.all["loanRegistedTab"];
    var trobj = tab.rows[tab.activeIndex];

    var loanID = "";

    if (tab.rows.length <= 0) {
        alert(MSG_NORECORD);
        return;
    }

    if ((trobj.ValueStr != undefined) && (trobj.ValueStr != "")) {
        var tmp = trobj.ValueStr.split(";");
        loanID = tmp[2];
    }
    var arg = new Object();
    // 操作类型：add
    arg.doType = "add";
    // 贷款申请序号

    arg.loanID = loanID;
    var ret = dialog("/UI/ccb/loan/mortReg/mortRegEdit.jsp?loanID=" + loanID + "&doType=add", arg, sfeature);

    if (ret == "1") {
        document.getElementById("loanRegistedTab").RecordCount = "0";
        Table_Refresh("loanRegistedTab", false, body_resize);
    }
}

/**
 * 编辑抵押信息
 *
 * @param doType:操作类型
 *            修改 edit
 * @param mortid:抵押编号
 */
function loanRegistedTab_editRecord_click() {
    // 增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }
    var sfeature = "dialogwidth:800px; dialogheight:600px;center:yes;help:no;resizable:yes;scroll:no;status:no";
    var tab = document.all["loanRegistedTab"];
    var trobj = tab.rows[tab.activeIndex];

    var mortID = "";

    if (tab.rows.length <= 0) {
        alert(MSG_NORECORD);
        return;
    }

    if ((trobj.ValueStr != undefined) && (trobj.ValueStr != "")) {
        var tmp = trobj.ValueStr.split(";");
        mortID = tmp[5];
    }
    var arg = new Object();
    // 操作类型：edit
    arg.doType = "edit";
    // 抵押编号
    arg.mortID = mortID;
    var ret = dialog("/UI/ccb/loan/mortReg/mortgageEdit.jsp?mortID=" + mortID + "&doType=edit", arg, sfeature);

    if (ret == "1") {
        document.getElementById("loanRegistedTab").RecordCount = "0";
        Table_Refresh("loanRegistedTab", false, body_resize);
    }
}

/**
 * <p>
 * 删除函数
 *
 * @param mortID:抵押编号
 * @param keepCont:保管内容
 * @param loanID：贷款申请序号
 */
function loanRegistedTab_deleteRecord_click() {
    // 增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }

    var tab = document.all["loanRegistedTab"];
    var trobj = tab.rows[tab.activeIndex];

    var mortID = "";
    var loanID = "";

    if (tab.rows.length <= 0) {
        alert(MSG_NORECORD);
        return;
    }

    if ((trobj.ValueStr != undefined) && (trobj.ValueStr != "")) {
        var tmp = trobj.ValueStr.split(";");
        loanID = tmp[2];
        mortID = tmp[5];
    }

    // if (confirm("确定删除该条贷款信息？\r\n保管内容：" + keepCont)) {
    if (confirm(MSG_DELETE_CONFRIM)) {
        // 保存到隐藏变量中提交后台
        document.all.mortID.value = mortID;
        document.all.loanID.value = loanID;
        // 抵押特殊通道
        document.getElementById("busiNode").value = BUSINODE_120;
        var retxml = createExecuteform(queryForm, "delete", "mort01", "delete")
        if (analyzeReturnXML(retxml) != "false") {
            alert(MSG_DEL_SUCCESS);
            document.getElementById("loanRegistedTab").RecordCount = "0";
            Table_Refresh("loanRegistedTab", false, body_resize);
        }
    }
}

/**
 * 察看贷款详细函数
 *
 * @param loanID：贷款申请序号
 * @param doType:select
 *            操作类型
 */
function loanRegistedTab_insuranceEdit_click() {

    // 增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }

    var sfeature = "dialogwidth:800px; dialogheight:520px;center:yes;help:no;resizable:yes;scroll:yes;status:no";
    var tab = document.all["loanRegistedTab"];
    var trobj = tab.rows[tab.activeIndex];
    var loanid = "";
    var attendflag = "";

    if (tab.rows.length <= 0) {
        alert(MSG_NORECORD);
        return;
    }

    if ((trobj.ValueStr != undefined) && (trobj.ValueStr != "")) {
        var tmp = trobj.ValueStr.split(";");
        loanid = tmp[2];
        attendflag = tmp[10];
        if (loanid == "") {
            alert(MSG_LOANNULL);
            return;
        }
    }
    var dtpe="";
    var arg = new Object();
    if (attendflag != "") {
        arg.doType = "edit";
        dtpe = "edit";
    }
    else {
        arg.doType = "add";
        dtpe = "add";
    }
    var ret = dialog("insuranceEdit.jsp?loanID=" + loanid + "&doType=" + dtpe, arg, sfeature);
    if (ret == "1") {
        Table_Refresh("loanRegistedTab", false, body_resize);
    }
}