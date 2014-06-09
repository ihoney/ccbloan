/*******************************************************************************
 * 功能描述: 系统日志 <br>
 * 作 者: leonwoo <br>
 * 开发日期: 2010/01/16<br>
 * 修 改 人:<br>
 * 修改日期: <br>
 * 版 权: 公司
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
    divfd_loanTab.style.height = document.body.clientHeight - 180;
    refresh_select("operid", "select OPERID as value ,OPERNAME as text  from ptoper where" + " deptid='"
            + document.getElementById("defaultBankID").value + "'");
    var _cell = document.getElementById("operid");
    // 创建默认空值
    var _option = document.createElement("option");
    _option.value = "";
    _option.text = "";
    _cell.appendChild(_option);
    _cell.value = "";

    loanTab.fdwidth = "100%";
    initDBGrid("loanTab");
    // 初始化页面焦点
    body_init(queryForm, "cbRetrieve");
}

/**
 * 根据经办行联动下拉项目:操作员
 * 
 * @return
 */
function reSelect() {
    refresh_select("operid", "select OPERID as value ,OPERNAME as text  from ptoper where" + " deptid='"
            + document.getElementById("BANKID").value + "'");
    var _cell = document.getElementById("operid");
    // 创建默认空值
    var _option = document.createElement("option");
    _option.value = "";
    _option.text = "";
    _cell.appendChild(_option);
    _cell.value = "";
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
    if (trimStr(document.getElementById("TASKTIME").value) != "") {
        whereStr += " and TASKTIME >=to_date('" + trimStr(document.getElementById("TASKTIME").value) + "','YYYY-MM-DD HH24:mi:ss')";
    }
    if (trimStr(document.getElementById("TASKTIME2").value) != "") {
        whereStr += " and TASKTIME <=to_date('" + trimStr(document.getElementById("TASKTIME2").value) + "','YYYY-MM-DD HH24:mi:ss')";
    }
    if (trimStr(document.getElementById("BANKID").value) != "") {
        whereStr += " and a.bankid in(select deptid from ptdept start with deptid='"+document.getElementById("bankid").value+"' connect by prior deptid=parentdeptid)";
    }
    if (trimStr(document.getElementById("operid").value) != "") {
        whereStr += " and operid='" + trimStr(document.getElementById("operid").value) + "'";
    }
    whereStr += " order by tasktime desc";

    document.all["loanTab"].whereStr = whereStr;
    document.all["loanTab"].RecordCount = "0";
    document.all["loanTab"].AbsolutePage = "1";
    // Table_Refresh in dbgrid.js pack
    Table_Refresh("loanTab", false);
}
