var SQLStr;
var gWhereStr = "";
var dw_form;

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
    loanRegistedTab.actionname = "mort01";
    loanRegistedTab.delmethodname = "batchEdit";
    initDBGrid("loanRegistedTab");
    // 初始化页面焦点
    body_init(queryForm, "cbRetrieve");
    document.getElementById("cust_name").focus();
    document.getElementById("cust_name").select();
    // 生成数据窗口校验使用
    dw_form = new DataWindow(document.getElementById("queryForm"), "form");
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
        mortID = tmp[6];

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
 * 编辑抵押办妥前快递登记信息
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
    var sfeature = "dialogwidth:600px; dialogheight:320px;center:yes;help:no;resizable:yes;scroll:no;status:no";
    var tab = document.all["loanRegistedTab"];
    var trobj = tab.rows[tab.activeIndex];

    var mortID = "";

    if (tab.rows.length <= 0) {
        alert(MSG_NORECORD);
        return;
    }

    if ((trobj.ValueStr != undefined) && (trobj.ValueStr != "")) {
        var tmp = trobj.ValueStr.split(";");
        mortID = tmp[6];
    }
    var arg = new Object();
    // 操作类型：edit
    arg.doType = "edit";
    // 抵押编号
    arg.mortID = mortID;
    var ret = dialog("beforeExpressEdit.jsp?mortID=" + mortID + "&doType=edit", arg, sfeature);

    if (ret == "1") {
        document.getElementById("loanRegistedTab").RecordCount = "0";
        Table_Refresh("loanRegistedTab", false, body_resize);
    }
}

/**
 * 察看贷款详细函数
 * 
 * @param loanID：贷款申请序号
 * @param doType:select
 *            操作类型
 */
function loanRegistedTab_loanQuery_click() {

    // 增加系统锁检查
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
        nbxh = tmp[0];

    }
    var arg = new Object();
    arg.doType = "select";
    dialog("/UI/ccb/loan/loanMgr/loanEdit.jsp?nbxh=" + nbxh + "&doType=select", arg, sfeature);
}
/**
 * 批量更新,后台对应action与方法名在该页面初始化的时候指定
 * 
 */
function loanRegistedTab_batchEdit_click() {

    // 选取数据标志
    var checked = false;
    var tab = document.all.loanRegistedTab;
    for ( var i = 0; i < tab.rows.length; i++) {
        if (tab.rows[i].cells[0].children[0] != undefined && tab.rows[i].cells[0].children[0].checked) {
            tab.rows[i].operate = "delete";
            checked = true;
            // ---
            // 创建TD的recversion传递到后台以便并发控制；
            var _cell = document.createElement("td");
            _cell.setAttribute("fieldname", "recversion");
            // _cell.setAttribute("style","display:none");
            _cell.style.display = "none";
            _cell.setAttribute("fieldtype", "text");
            _cell.setAttribute("oldvalue", tab.rows[i].ValueStr.split(";")[10]);
            tab.rows[i].appendChild(_cell);
            // ---loanid
            _cell = document.createElement("td");
            _cell.setAttribute("fieldname", "loanid");
            // _cell.setAttribute("style","display:none");
            _cell.style.display = "none";
            _cell.setAttribute("fieldtype", "text");
            _cell.setAttribute("oldvalue", tab.rows[i].ValueStr.split(";")[11]);
            tab.rows[i].appendChild(_cell);
        }else{
            tab.rows[i].operate = "";
        }
    }
    if (!checked) {
        alert(MSG_NORECORD);
        return;
    }
    // ---打开柜号输入窗口---
    var sfeature = "dialogwidth:560px; dialogheight:200px;center:yes;help:no;resizable:yes;scroll:yes;status:no";
    var arg = new Object();
    arg.doType = "edit";
    var rtn = dialog("beforeExpressBox.jsp?doType=edit", arg, sfeature);
    var boxID = "";
    var expressNote = "";
    if (rtn != undefined) {
        boxID = rtn.boxid;
        expressNote = rtn.expressNote;
    }

    // ---
    // 如果输入柜号窗口取消，则不进行更新
    if (rtn != undefined) {
        for ( var i = 0; i < tab.rows.length; i++) {
            if (tab.rows[i].cells[0].children[0] != undefined && tab.rows[i].cells[0].children[0].checked) {
                // ---
                // 创建TD的boxid传递到后台以便并发控制；
                var _cell = document.createElement("td");
                _cell.setAttribute("fieldname", "boxid");
                _cell.style.display = "none";
                _cell.setAttribute("fieldtype", "text");
                _cell.setAttribute("oldvalue", boxID);
                tab.rows[i].appendChild(_cell);

                // 抵押流程状态
                _cell = document.createElement("td");
                _cell.setAttribute("fieldname", "MORTSTATUS");
                _cell.style.display = "none";
                _cell.setAttribute("fieldtype", "text");
                var MORT_FLOW_SENT = "20"; // 已发出快递 20
                _cell.setAttribute("oldvalue", MORT_FLOW_SENT);
                tab.rows[i].appendChild(_cell);

                // 当前日期
                _cell = document.createElement("td");
                _cell.setAttribute("fieldname", "EXPRESSENDSDATE");
                _cell.style.display = "none";
                _cell.setAttribute("fieldtype", "text");
                var date = new Date();
                _cell.setAttribute("oldvalue", getDateString(date));
                tab.rows[i].appendChild(_cell);

                // 快递备注
                _cell = document.createElement("td");
                _cell.setAttribute("fieldname", "EXPRESSNOTE");
                _cell.style.display = "none";
                _cell.setAttribute("fieldtype", "text");
                _cell.setAttribute("oldvalue", expressNote);
                tab.rows[i].appendChild(_cell);
                // 业务节点
                _cell = document.createElement("td");
                _cell.setAttribute("fieldname", "busiNode");
                _cell.style.display = "none";
                _cell.setAttribute("fieldtype", "text");
                _cell.setAttribute("oldvalue", BUSINODE_020);
                tab.rows[i].appendChild(_cell);
                // 为抵押原因为 15 已抵押  20120210 add
                _cell = document.createElement("td");
                _cell.setAttribute("fieldname", "NOMORTREASONCD");
                _cell.style.display = "none";
                _cell.setAttribute("fieldtype", "text");
                _cell.setAttribute("oldvalue", "15");
                tab.rows[i].appendChild(_cell);
            } else {
                tab.rows[i].operate = "";
            }
        }
        // ---
        // 提交后台进行批量修改
        var retxml = postGridRecord(tab);
        // analyzeReturnXML in dbutil.js pack
        if (retxml + "" == "true") {
            window.returnValue = "1";
        }
    }
}

/**
 * report
 * 
 */
function loanRegistedTab_expExcel_click() {

    // 增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }
    if (dw_form.validate() != null)
        return;

    document.getElementById("expressType").value = "mortBefore";
    document.getElementById("queryForm").target = "_blank";
    document.getElementById("queryForm").action = "beforeExpressRpt.jsp";
    document.getElementById("queryForm").submit();
}