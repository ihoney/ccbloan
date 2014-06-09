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
    divfd_loanRegistedTab.style.height = document.body.clientHeight - 200;
    loanRegistedTab.fdwidth = "1500px";
    initDBGrid("loanRegistedTab");
    // 初始化页面焦点
    body_init(queryForm, "cbRetrieve");
    //    document.getElementById("cust_name").focus();
    //    document.getElementById("cust_name").select();
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
 * @param ：form名字或者ID
 */

function cbRetrieve_Click(formname) {
    // 增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }

    //    if (checkForm(queryForm) == "false")
    //        return;
    var whereStr = "";
     //- 20110701增加合作方编号、合作方名称、合作项目编号、合作项目名称--
    if (trimStr(document.all["corp_id"].value) != "")
        whereStr += " and (  c.corpid like '%" + document.getElementById("corp_id").value + "%')";
    if (trimStr(document.all["corp_name"].value) != "")
        whereStr += " and ( c.corpname like '%" + document.getElementById("corp_name").value + "%')";
    if (trimStr(document.all["proj_no"].value) != "")
        whereStr += " and ( c.proj_no like '%" + document.getElementById("proj_no").value + "%')";
    if (trimStr(document.all["proj_name"].value) != "")
        whereStr += " and ( c.proj_name like '%" + document.getElementById("proj_name").value + "%')";

/*
    if (trimStr(document.getElementById("cust_name").value) != "") {
        whereStr += " and ((a.cust_name like'" + trimStr(document.getElementById("cust_name").value) + "%')";
        whereStr += " or (a.cust_py  like'" + trimStr(document.getElementById("cust_name").value) + "%'))";
    }

    if (trimStr(document.getElementById("mortecentercd").value) != "") {
        whereStr += " and b.mortecentercd ='" + trimStr(document.getElementById("mortecentercd").value) + "' ";
    }
*/
    if (trimStr(document.getElementById("bankid").value) != "") {
        whereStr += " and a.bankid in(select deptid from ptdept start with deptid='"+document.getElementById("bankid").value+"' connect by prior deptid=parentdeptid)";
    }

    if (trimStr(document.all["releasecondcd"].value) != "")
        whereStr += " and ( b.releasecondcd like '%" + document.getElementById("releasecondcd").value + "%')";

    if (trimStr(document.all["ln_typ"].value) != "")
        whereStr += " and ( a.ln_typ like '%" + document.getElementById("ln_typ").value + "%')";

    var assuamt = trimStr(document.all["booltype"].value);
    if (assuamt != "") {
        if (assuamt == "1") { // 为零
            whereStr += " and ( c.assuamtpercent = 0  or c.assuamtpercent is null ) ";
        } else {
            whereStr += " and ( c.assuamtpercent != 0 ) ";
        }
    }

    whereStr += " order by a.bankid, c.proj_no, a.loanid  ";
    document.all["loanRegistedTab"].whereStr = whereStr;
    /*

     whereStr += " order by b.mortdate desc,a.cust_py asc";

     document.all["loanRegistedTab"].whereStr = whereStr;
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
 *          操作类型
 */
function loanRegistedTab_query_click() {
    //增加系统锁检查
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
        mortID = tmp[11];
//        alert(mortID);

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
 * 察看贷款详细函数
 *
 * @param loanID：贷款申请序号
 * @param doType:select
 *          操作类型
 */
function loanRegistedTab_loanQuery_click() {

    //增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }

    var sfeature = "dialogwidth:800px; dialogheight:520px;center:yes;help:no;resizable:yes;scroll:yes;status:no";
    var tab = document.all["loanRegistedTab"];
    var trobj = tab.rows[tab.activeIndex];
    var nbxh = "";

    if (tab.rows.length <= 0) {
        alert(MSG_NORECORD);
        return;
    }

    if ((trobj.ValueStr != undefined) && (trobj.ValueStr != "")) {
        var tmp = trobj.ValueStr.split(";");
        nbxh = tmp[12];
        if (nbxh == "") {
            alert(MSG_LOANNULL);
            return;
        }
    }
    var arg = new Object();
    arg.doType = "select";
    dialog("/UI/ccb/loan/loanMgr/loanEdit.jsp?nbxh=" + nbxh + "&doType=select", arg, sfeature);
}


/*
查看合作项目
 */
function loanRegistedTab_projQuery_click() {
    // 增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }

    var sfeature = "dialogwidth:800px; dialogheight:620px;center:yes;help:no;resizable:yes;scroll:yes;status:no";
    var tab = document.all["loanRegistedTab"];
    var trobj = tab.rows[tab.activeIndex];
    var proj_nbxh = "";

    if (tab.rows.length <= 0) {
        alert(MSG_NORECORD);
        return;
    }

    if ((trobj.ValueStr != undefined) && (trobj.ValueStr != "")) {
        var tmp = trobj.ValueStr.split(";");
        proj_nbxh = tmp[13];
//        alert(proj_nbxh);
//        alert(tmp);

    }
    var arg = new Object();
    arg.doType = "select";
    dialog("/UI/ccb/loan/coopprojMgr/coopprojEdit.jsp?proj_nbxh=" + proj_nbxh + "&doType=select", arg, sfeature);
}
