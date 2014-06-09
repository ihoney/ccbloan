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
    // var wheight = document.body.clientHeight - 300;
    divfd_coopprojTable.style.height = document.body.clientHeight - 255 + "px";
    coopprojTable.fdwidth = "2280px";
    initDBGrid("coopprojTable");
    // 初始化页面焦点
    // body_init(queryForm, "cbRetrieve");
    body_init(queryForm, "queryClick");
    document.getElementById("proj_no").focus();

}

// //////查询函数
function queryClick() {
    var whereStr = "";

    if (trimStr(document.all["proj_no"].value) != "")
        whereStr += " and ( proj_no like '" + document.all.proj_no.value + "%')";

    if (trimStr(document.all["bankid"].value) != ""){
//        whereStr += " and bankid in(select deptid from ptdept start with deptid='"+document.getElementById("bankid").value+"' connect by prior deptid=parentdeptid)";
        whereStr += " and bankid='"+document.getElementById("bankid").value+"'";
    }
    if (trimStr(document.all["cust_bankid"].value) != ""){
        whereStr += " and cust_bankid in(select deptid from ptdept start with deptid='"+document.getElementById("cust_bankid").value+"' connect by prior deptid=parentdeptid)";
    }
    if (trimStr(document.all["releasecondcd"].value) != "")
        whereStr += " and ( releasecondcd like '%" + document.all.releasecondcd.value + "%')";

    if (trimStr(document.all["corpname"].value) != "")
        whereStr += " and ( corpname like '%" + document.all.corpname.value + "%')";

    /*
     * if (trimStr(document.all["corpid"].value) != "") whereStr += " and (
     * corpid like '%"+document.all.corpid.value+"%')";
     */
    var maturityflag = trimStr(document.all["maturityflag"].value);
    if (maturityflag != "") {
        var date = new Date();
        if (maturityflag == "1") { // 已到期
            whereStr += " and ( assuenddate < '" + getDateString(date) + "') ";
        } else {
            whereStr += " and ( assuenddate >= '" + getDateString(date) + "') ";
        }
    }

    if (trimStr(document.all["bankflag"].value) != "")
        whereStr += " and ( bankflag = '" + document.all.bankflag.value + "')";

    if (trimStr(document.all["proj_name"].value) != "")
        whereStr += " and ( proj_name like '%" + document.all.proj_name.value + "%')";

    var assuamt = trimStr(document.all["booltype"].value);
    if (assuamt != "") {
        if (assuamt == "1") { // 为零
            whereStr += " and ( assuamtpercent = 0  or assuamtpercent is null ) ";
        } else {
            whereStr += " and ( assuamtpercent != 0 ) ";
        }
    }

    /*
     * if (trimStr(document.all["inputdate1"].value) != "") whereStr += " and (
     * inputdate1 >= '"+document.all.inputdate1.value+"')";
     * 
     * if (trimStr(document.all["inputdate2"].value) != "") whereStr += " and (
     * inputdate2 <= '"+document.all.inputdate2.value+"')";
     */

    if (whereStr != document.all["coopprojTable"].whereStr) {
        document.all["coopprojTable"].whereStr = whereStr + " order by proj_no ";
        document.all["coopprojTable"].RecordCount = "0";
        document.all["coopprojTable"].AbsolutePage = "1";

//         alert(whereStr);
        Table_Refresh("coopprojTable");
    }

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
    whereStr += " order by a.cust_py asc";

    document.all["coopprojTable"].whereStr = whereStr;
    document.all["coopprojTable"].RecordCount = "0";
    document.all["coopprojTable"].AbsolutePage = "1";
    // Table_Refresh in dbgrid.js pack
    Table_Refresh("coopprojTable", false, body_resize);
}

/**
 * 查看合作项目详细信息
 */
function coopprojTable_query_click() {
    // 增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }

    var sfeature = "dialogwidth:800px; dialogheight:620px;center:yes;help:no;resizable:yes;scroll:yes;status:no";
    var tab = document.all["coopprojTable"];
    var trobj = tab.rows[tab.activeIndex];
    var proj_nbxh = "";

    if (tab.rows.length <= 0) {
        alert(MSG_NORECORD);
        return;
    }

    if ((trobj.ValueStr != undefined) && (trobj.ValueStr != "")) {
        var tmp = trobj.ValueStr.split(";");
        proj_nbxh = tmp[0];
        // alert(proj_no);

    }
    var arg = new Object();
    arg.doType = "select";
    // dialog("/UI/ccb/loan/mortReg/mortgageEdit.jsp?mortID=" + mortID +
    // "&doType=select", arg, sfeature);
    dialog("/UI/ccb/loan/coopprojMgr/coopprojEdit.jsp?proj_nbxh=" + proj_nbxh + "&doType=select", arg, sfeature);
    // window.open("/UI/ccb/loan/coopprojMgr/coopprojEdit.jsp?proj_no=" +
    // proj_no + "&doType=select");
}

/**
 * 双击表格弹出详细信息查看画面 调用查看函数
 * 
 */
function coopprojTable_TRDbclick() {
    coopprojTable_query_click();
}

/**
 * 添加信息
 * 
 * @param doType:操作类型
 *            增加（add）
 * @param loanid:贷款申请序号
 */
function coopprojTable_appendRecod_click() {

    // 增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }

    // var sfeature = "dialogwidth:800px;
    // dialogheight:460px;center:yes;help:no;resizable:yes;scroll:no;status:no";
    var sfeature = "dialogwidth:800px; dialogheight:620px;center:yes;help:no;resizable:yes;scroll:yes;status:no";
    var tab = document.all["coopprojTable"];
    var trobj = tab.rows[tab.activeIndex];

    var proj_nbxh = "";

    // if (tab.rows.length <= 0) {
    // alert(MSG_NORECORD);
    // return;
    // }

    var arg = new Object();
    // 操作类型：add
    arg.doType = "add";
    arg.proj_nbxh = "";
    var ret = dialog("/UI/ccb/loan/coopprojMgr/coopprojEdit.jsp?proj_nbxh=" + proj_nbxh + "&doType=add", arg, sfeature);

    if (ret == "1") {
        document.getElementById("coopprojTable").RecordCount = "0";
        Table_Refresh("coopprojTable", false, body_resize);
    }
}

/**
 * 编辑信息
 * 
 * @param doType:操作类型
 *            修改 edit
 */
function coopprojTable_editRecord_click() {
    // 增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }
    // var sfeature = "dialogwidth:800px;
    // dialogheight:460px;center:yes;help:no;resizable:yes;scroll:no;status:no";
    var sfeature = "dialogwidth:800px; dialogheight:620px;center:yes;help:no;resizable:yes;scroll:yes;status:no";
    var tab = document.all["coopprojTable"];
    var trobj = tab.rows[tab.activeIndex];

    var proj_nbxh = "";

    if (tab.rows.length <= 0) {
        alert(MSG_NORECORD);
        return;
    }

    if ((trobj.ValueStr != undefined) && (trobj.ValueStr != "")) {
        var tmp = trobj.ValueStr.split(";");
        proj_nbxh = tmp[0];
    }
    var arg = new Object();
    // 操作类型：edit
    arg.doType = "edit";
    // 抵押编号
    arg.proj_no = proj_nbxh;
    var ret = dialog("/UI/ccb/loan/coopprojMgr/coopprojEdit.jsp?proj_nbxh=" + proj_nbxh + "&doType=edit", arg, sfeature);
    // var ret =
    // window.open("/UI/ccb/loan/coopprojMgr/coopprojEdit.jsp?proj_no=" +
    // proj_no + "&doType=edit");

    if (ret == "1") {
        document.getElementById("coopprojTable").RecordCount = "0";
        Table_Refresh("coopprojTable", false, body_resize);
    }
}

/**
 * <p>
 * 删除函数
 */
function coopprojTable_deleteRecord_click() {
    // 增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }

    var tab = document.all["coopprojTable"];
    var trobj = tab.rows[tab.activeIndex];

    var proj_nbxh = "";
    var proj_name = "";

    if (tab.rows.length <= 0) {
        alert(MSG_NORECORD);
        return;
    }

    if ((trobj.ValueStr != undefined) && (trobj.ValueStr != "")) {
        var tmp = trobj.ValueStr.split(";");
        proj_nbxh = tmp[0];
        proj_name = tmp[6];
    }

    if (confirm("确定删除该条信息？\r\n项目名称：" + proj_name)) {
        document.getElementById("busiNode").value = BUSINODE_160;
        document.all.proj_nbxh.value = proj_nbxh;
        // alert(document.all.proj_nbxh.value);
        var retxml = createExecuteform(queryForm, "delete", "cc0101", "delete")
        if (analyzeReturnXML(retxml) != "false") {
            alert(MSG_DEL_SUCCESS);
            document.getElementById("coopprojTable").RecordCount = "0";
            Table_Refresh("coopprojTable", false, body_resize);
        }
    }
}

/*
 * 查看该项目下的详细抵押信息
 */
function coopprojTable_queryMort_click() {
    // 增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }

    var sfeature = "dialogwidth:900px; dialogheight:700px;center:yes;help:no;resizable:yes;scroll:yes;status:no";
    var tab = document.all["coopprojTable"];
    var trobj = tab.rows[tab.activeIndex];
    var proj_nbxh = "";

    if (tab.rows.length <= 0) {
        alert(MSG_NORECORD);
        return;
    }

    if ((trobj.ValueStr != undefined) && (trobj.ValueStr != "")) {
        var tmp = trobj.ValueStr.split(";");
        proj_nbxh = tmp[0];
        // alert(proj_no);

    }
    var arg = new Object();
    arg.doType = "select";

    dialog("/UI/ccb/loan/coopprojMgr/subquery/loanQuery.jsp?proj_nbxh=" + proj_nbxh, arg, sfeature);

    // dialog("/UI/ccb/loan/mortReg/mortgageEdit.jsp?mortID=" + mortID +
    // "&doType=select", arg, sfeature);
    // window.open("/UI/ccb/loan/coopprojMgr/coopprojEdit.jsp?proj_no=" +
    // proj_no + "&doType=select");
}
