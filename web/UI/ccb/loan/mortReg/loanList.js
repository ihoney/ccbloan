var SQLStr;
var gWhereStr = "";


document.onkeydown = function (evt) {
    var key = event.keyCode;
    var srcobj = event.srcElement;
    if (key == 13 && srcobj.type != 'button' && srcobj.type != 'submit' && srcobj.type != 'reset'
        && srcobj.type != 'textarea' && srcobj.type != '') {
        if (srcobj.id == "FLOWSN") {
            var searchResult = onSearchArchiveInfo();
            if (searchResult != -1) {
                addMortInfoByArchiveInfo(searchResult);
            }
        }
    }
}

function onSearchArchiveInfo() {
    // 增加系统锁检查
    /*if (getSysLockStatus() == "1") {
     alert(MSG_SYSLOCK);
     return;
     }*/

    var flowsn = trimStr(document.getElementById("FLOWSN").value);
    if (flowsn == "") {
        alert('请输入流水号.');
        return -1;
    }

    var flowNo = document.getElementById("FLOWSN").value;
    flowNo = flowNo.replace(/[\$\￥]/g,'');
    document.getElementById("FLOWSN").value = flowNo;

    //检查是否已做过抵押处理 TODO
    var retxml = createselect(queryForm, "com.ccb.flowmng.SelectMortIDAction");
    if (retxml == "false") {
        alert("此贷款资料不存在。");
        return -1;
    }
    var xmlDoc = createDomDocument();
    xmlDoc.loadXML(retxml);
    var rootNode = xmlDoc.documentElement.firstChild;
    if (rootNode != null) {
        if (rootNode.getAttribute("result") == "true" && rootNode.firstChild.xml != "null") {
            alert("该笔贷款已做过抵押登记。");
            return -1;
        }
    } else {
        alert("此贷款资料不存在。");
        return -1;
    }

    //获取loanid
    retxml = createselect(queryForm, "com.ccb.flowmng.SelectLoanIDAction");
    if (retxml == "false") {
        alert("此贷款资料不存在。");
        return -1;
    }
    xmlDoc = createDomDocument();
    xmlDoc.loadXML(retxml);
    rootNode = xmlDoc.documentElement.firstChild;
    if (rootNode != null && rootNode.getAttribute("result") == "true" && rootNode.firstChild.xml != "null") {
        return(rootNode.firstChild.xml);
    } else {
        alert("此贷款资料不存在或未补充贷款申请顺序号...");
        return -1;
    }
}

function addMortInfoByArchiveInfo(loanID) {
    // 增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }

    var sfeature = "dialogwidth:600px; dialogheight:360px;center:yes;help:no;resizable:yes;scroll:no;status:no";

    var arg = new Object();
    // 操作类型：add
    arg.doType = "add";
    // 贷款申请序号
    arg.loanID = loanID;
    arg.flowSn = trimStr(document.getElementById("FLOWSN").value);
    var ret = dialog("mortRegEdit.jsp?loanID=" + loanID + "&doType=add", arg, sfeature);

    if (ret == "1") {
        document.getElementById("loanTab").RecordCount = "0";
        Table_Refresh("loanTab", false, body_resize);
    }

}


/**
 * 初始化form函数,
 * <p>
 * ■初始化焦点定位在查询条件第一个控件上;
 * <p>
 * ■每次查询完毕后焦点自动定位到第一个控件，且全选；
 *
 * @return
 */
function body_resize() {
    divfd_loanTab.style.height = document.body.clientHeight - 180;
    loanTab.fdwidth = "100%";
    initDBGrid("loanTab");
    // 初始化页面焦点
    body_init(queryForm, "cbRetrieve");
    document.getElementById("FLOWSN").focus();
    document.getElementById("FLOWSN").select();
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
 *
 * @param ：form名字或者ID
 * @return
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
    if (trimStr(document.getElementById("bankid").value) != "") {
        // whereStr += " and a.bankid ='" +
        // trimStr(document.getElementById("bankid").value) + "' ";
        whereStr += " and a.bankid in(select deptid from ptdept start with deptid='" + document.getElementById("bankid").value + "' connect by prior deptid=parentdeptid)";
    }


    whereStr += " order by a.CUST_OPEN_DT desc,APLY_DT desc,a.cust_py asc ";

    document.all["loanTab"].whereStr = whereStr;
    document.all["loanTab"].RecordCount = "0";
    document.all["loanTab"].AbsolutePage = "1";
    // Table_Refresh in dbgrid.js pack
    Table_Refresh("loanTab", false, body_resize);

    // 判断有无贷款记录返回，如果没有则提示是否增加贷款信息
    // 必须延迟实现才可实现
    window.clearTimeout();
    window.setTimeout("addMortWin()", 500);
    window.clearTimeout();
}

/**
 * 贷款增加
 *
 * @param 窗体对象
 */
function addMortWin() {
    var tab = document.all["loanTab"];
    if (tab.rows.length <= 0) {
        if (confirm(MSG_ADDMORTINFO)) {
            var sfeature = "dialogwidth:800px; dialogheight:520px;center:yes;help:no;resizable:yes;scroll:no;status:no";
            var arg = new Object();
            // 操作类型：add
            arg.doType = "add";
            var ret = dialog("/UI/ccb/loan/loanMgr/loanEdit.jsp?doType=add", arg, sfeature);
            if (ret == "1") {
                // document.getElementById("loanTab").RecordCount = "0";
                Table_Refresh("loanTab", false, body_resize);
            }
        }
    }
}

/**
 * 添加抵押信息
 *
 * @param doType:操作类型
 * @param loanid:贷款申请序号
 * @return
 */
function loanTab_appendRecod_click() {
// 增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }

    var sfeature = "dialogwidth:600px; dialogheight:360px;center:yes;help:no;resizable:yes;scroll:no;status:no";
    var tab = document.all["loanTab"];
    var trobj = tab.rows[tab.activeIndex];

    var loanID = "";

    if (tab.rows.length <= 0) {
        alert(MSG_NORECORD);
        return;
    }

    if ((trobj.ValueStr != undefined) && (trobj.ValueStr != "")) {
        var tmp = trobj.ValueStr.split(";");
        loanID = tmp[1];
    }
    var arg = new Object();
    // 操作类型：add
    arg.doType = "add";
    // 贷款申请序号
    arg.loanID = loanID;
    arg.flowSn = trimStr(document.getElementById("FLOWSN").value);
    var ret = dialog("mortRegEdit.jsp?loanID=" + loanID + "&doType=add", arg, sfeature);

    if (ret == "1") {
        document.getElementById("loanTab").RecordCount = "0";
        Table_Refresh("loanTab", false, body_resize);
    }

}

/**
 * 察看贷款详细函数
 *
 * @param loanID：贷款申请序号
 * @param doType:select
 *            操作类型
 * @return
 */
function loanTab_query_click() {

// 增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }

    var sfeature = "dialogwidth:800px; dialogheight:520px;center:yes;help:no;resizable:yes;scroll:yes;status:no";
    var tab = document.all["loanTab"];
    var trobj = tab.rows[tab.activeIndex];
    var loanID = "";
    var nbxh = "";

    if (tab.rows.length <= 0) {
        alert(MSG_NORECORD);
        return;
    }

    if ((trobj.ValueStr != undefined) && (trobj.ValueStr != "")) {
        var tmp = trobj.ValueStr.split(";");
        nbxh = tmp[0];
        loanID = tmp[1];

    }
    var arg = new Object();
    arg.doType = "select";
    dialog("/UI/ccb/loan/loanMgr/loanEdit.jsp?nbxh=" + nbxh + "&loanID=" + loanID + "&doType=select", arg, sfeature);
}

/**
 * 双击表格弹出抵押登记信息
 *
 * @return
 */
function loanTab_TRDbclick() {
    // loanTab_query_click();
    loanTab_appendRecod_click();
}
