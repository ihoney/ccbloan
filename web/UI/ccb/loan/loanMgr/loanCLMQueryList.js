/*******************************************************************************
 * 
 * 作 用： 客户经理贷款认领查询
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
    loanTab.fdwidth = "100%";
    initDBGrid("loanTab");
    reSelect();
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
    // 机构
    if (trimStr(document.getElementById("BANKID").value) != "") {
        whereStr += " and a.BANKID ='" + trimStr(document.getElementById("BANKID").value) + "'";
    }
    // 客户经理
    if (trimStr(document.getElementById("CUSTMGR_ID").value) != "") {
        whereStr += " and a.CUSTMGR_ID ='" + trimStr(document.getElementById("CUSTMGR_ID").value) + "'";
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
 * 根据经办行联动下拉项目:客户经理ID
 * 
 * @return
 */
function reSelect() {
    refresh_select("CUSTMGR_ID", "select OPERID as value ,OPERNAME as text  from ptoper where" + " deptid='"
                    + document.getElementById("BANKID").value + "'");
    var _cell = document.getElementById("CUSTMGR_ID");
    // 创建默认空值
    var _option = document.createElement("option");
    _option.value = "";
    _option.text = "";
    _cell.appendChild(_option);
    _cell.value = "";

}
