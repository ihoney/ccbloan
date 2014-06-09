/*******************************************************************************
 * 
 * 作 用： 客户经理贷款认领
 * 
 * 作 者：
 * 
 * 时 间：
 * 
 * 版 权：
 * 
 ******************************************************************************/
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
    // 高度自动根据窗口大小进行调整
    divfd_loanTab.style.height = document.body.offsetHeight - 180;
    loanTab.actionname = "loan01";
    // loanTab.delmethodname = "confirmCLM";
    loanTab.fdwidth = "100%";
    initDBGrid("loanTab");
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
    whereStr += " order by a.CUST_OPEN_DT desc,APLY_DT desc,a.cust_py asc ";

    document.all["loanTab"].whereStr = whereStr;
    document.all["loanTab"].RecordCount = "0";
    document.all["loanTab"].AbsolutePage = "1";
    // Table_Refresh in dbgrid.js pack
    Table_Refresh("loanTab", false, body_resize);
}

/**
 * 察看贷款详细函数
 * 
 * @param loanID：贷款申请序号
 * @param doType:select
 *            操作类型
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
    var nbxh = "";

    if (tab.rows.length <= 0) {
        alert(MSG_NORECORD);
        return;
    }

    if ((trobj.ValueStr != undefined) && (trobj.ValueStr != "")) {
        var tmp = trobj.ValueStr.split(";");
        nbxh = tmp[0];

    }
    var arg = new Object();
    arg.doType = "select";
    dialog("loanEdit.jsp?nbxh=" + nbxh + "&doType=select", arg, sfeature);
}

/**
 * 双击表格弹出详细信息查看画面 调用查看函数
 * 
 */
function loanTab_TRDbclick() {
    loanTab_query_click();
}

/**
 * 认领
 * 
 * @param doType:操作类型
 *            修改 edit
 * @param nbxh:内部序号
 */
function loanTab_confirmCLM_click() {
    // 增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }

    var tab = document.all["loanTab"];
    var trobj = tab.rows[tab.activeIndex];

    var nbxh = "";
    var recversion = "";
    if (tab.rows.length <= 0) {
        alert(MSG_NORECORD);
        return;
    }

    if ((trobj.ValueStr != undefined) && (trobj.ValueStr != "")) {
        var tmp = trobj.ValueStr.split(";");
        nbxh = tmp[0];
        recversion = tmp[9];
    }

    if (confirm(MSG_CLM_CONFIRM)) {
        // 保存到隐藏变量中提交后台
        document.all.nbxh.value = nbxh;
        // 版本号
        document.all.recversion.value = recversion;
        document.getElementById("busiNode").value = BUSINODE_140;
        var retxml = createExecuteform(queryForm, "update", "loan01", "confirmCLM")
        if (analyzeReturnXML(retxml) != "false") {
            document.getElementById("loanTab").RecordCount = "0";
            Table_Refresh("loanTab", false, body_resize);
        }
    }
}

/**
 * 退回
 * 
 * @param doType:操作类型
 *            修改 edit
 * @param nbxh:内部序号
 */
function loanTab_cancelCLM_click() {
    // 增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }

    var tab = document.all["loanTab"];
    var trobj = tab.rows[tab.activeIndex];

    var nbxh = "";
    var recversion = "";
    if (tab.rows.length <= 0) {
        alert(MSG_NORECORD);
        return;
    }

    if ((trobj.ValueStr != undefined) && (trobj.ValueStr != "")) {
        var tmp = trobj.ValueStr.split(";");
        nbxh = tmp[0];
        recversion = tmp[9];
    }

    if (confirm(MSG_CLM_CANCEL)) {
        // 保存到隐藏变量中提交后台
        document.all.nbxh.value = nbxh;
        // 版本号
        document.all.recversion.value = recversion;
        document.getElementById("busiNode").value = BUSINODE_140;
        var retxml = createExecuteform(queryForm, "update", "loan01", "cancelCLM")
        if (analyzeReturnXML(retxml) != "false") {
            document.getElementById("loanTab").RecordCount = "0";
            Table_Refresh("loanTab", false, body_resize);
        }
    }
}

/**
 * 批量认领,后台对应action与方法名在该页面初始化的时候指定
 * 
 * @return
 */
function loanTab_batchCLM_click() {
    // 动态修改方法名
    // 选中数据标志位
    var checked = false;
    loanTab.delmethodname = "confirmCLM";
    var tab = document.all.loanTab;
    for ( var i = 0; i < tab.rows.length; i++) {
        if (tab.rows[i].cells[0].children[0] != undefined && tab.rows[i].cells[0].children[0].checked) {
            tab.rows[i].operate = "delete";
            checked = true;
            // ---添加版本号
            // 创建TD的recversion传递到后台以便并发控制；
            var _cell = document.createElement("td");
            _cell.setAttribute("fieldname", "recversion");
            _cell.style.display = "none";
            _cell.setAttribute("fieldtype", "text");
            _cell.setAttribute("oldvalue", tab.rows[i].ValueStr.split(";")[9]);
            tab.rows[i].appendChild(_cell);
            // 内部序号
            _cell = document.createElement("td");
            _cell.setAttribute("fieldname", "nbxh");
            _cell.style.display = "none";
            _cell.setAttribute("fieldtype", "text");
            _cell.setAttribute("oldvalue", tab.rows[i].ValueStr.split(";")[0]);
            tab.rows[i].appendChild(_cell);
            // 操作类型
            _cell = document.createElement("td");
            _cell.setAttribute("fieldname", "busiNode");
            _cell.style.display = "none";
            _cell.setAttribute("fieldtype", "text");
            _cell.setAttribute("oldvalue", BUSINODE_140);
            tab.rows[i].appendChild(_cell);
        } else {
            tab.rows[i].operate = "";
        }
    }
    if (!checked) {
        alert(MSG_NORECORD);
        return;
    }
    // 确认消息框
    if (confirm(MSG_BATCH_CLM_CONFIRM)) {
        var retxml = postGridRecord(tab);
        // analyzeReturnXML in dbutil.js pack
        if (retxml + "" == "true") {
            window.returnValue = "1";
        }
    }
}

/**
 * 批量退回,后台对应action与方法名在该页面初始化的时候指定
 * 
 * @return
 */
function loanTab_batchCancel_click() {
    // 动态修改方法名
    // 选中数据标志位
    var checked = false;
    loanTab.delmethodname = "cancelCLM";
    var tab = document.all.loanTab;
    for ( var i = 0; i < tab.rows.length; i++) {
        if (tab.rows[i].cells[0].children[0] != undefined && tab.rows[i].cells[0].children[0].checked) {
            tab.rows[i].operate = "delete";
            checked = true;

            // ---添加版本号、内部序号
            // 创建TD的recversion传递到后台以便并发控制；
            var _cell = document.createElement("td");
            _cell.setAttribute("fieldname", "recversion");
            _cell.style.display = "none";
            _cell.setAttribute("fieldtype", "text");
            _cell.setAttribute("oldvalue", tab.rows[i].ValueStr.split(";")[9]);
            tab.rows[i].appendChild(_cell);
            // 内部序号
            _cell = document.createElement("td");
            _cell.setAttribute("fieldname", "nbxh");
            _cell.style.display = "none";
            _cell.setAttribute("fieldtype", "text");
            _cell.setAttribute("oldvalue", tab.rows[i].ValueStr.split(";")[0]);
            tab.rows[i].appendChild(_cell);
            // 操作类型
            _cell = document.createElement("td");
            _cell.setAttribute("fieldname", "busiNode");
            _cell.style.display = "none";
            _cell.setAttribute("fieldtype", "text");
            _cell.setAttribute("oldvalue", BUSINODE_140);
            tab.rows[i].appendChild(_cell);
        } else {
            tab.rows[i].operate = "";
        }
    }
    if (!checked) {
        alert(MSG_NORECORD);
        return;
    }
    // 确认消息框
    if (confirm(MSG_BATCH_CLM_CANCEL)) {
        var retxml = postGridRecord(tab);
        // analyzeReturnXML in dbutil.js pack
        if (retxml + "" == "true") {
            window.returnValue = "1";
        }
    }
}