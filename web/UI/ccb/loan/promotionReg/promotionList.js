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
    divfd_promotionTab.style.height = document.body.clientHeight - 180;

    promotionTab.fdwidth = "100%";
    initDBGrid("promotionTab");
    // 初始化页面焦点
    body_init(queryForm, "cbRetrieve");
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
        whereStr += " and cust_name like '" + trimStr(document.getElementById("cust_name").value) + "%'";
    }
    if (trimStr(document.getElementById("bankid").value) != "") {
        whereStr += " and bankid  in(select deptid from ptdept start with deptid='"+document.getElementById("bankid").value+"' connect by prior deptid=parentdeptid)";
    }

    document.all["promotionTab"].whereStr = whereStr + " order by OPERDATE desc ";
    document.all["promotionTab"].RecordCount = "0";
    document.all["promotionTab"].AbsolutePage = "1";
    // Table_Refresh in dbgrid.js pack
    Table_Refresh("promotionTab", false);
}

function promotionTab_appendRecord_click() {
    //增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }

    var sfeature = "dialogwidth:800px; dialogheight:520px;center:yes;help:no;resizable:yes;scroll:yes;status:no";
    var arg = new Object();
    arg.doType = "add";
    var rtn = dialog("promotionEdit.jsp?doType=add", arg, sfeature);
    if (rtn == "1") {
        document.getElementById("promotionTab").RecordCount = "0";
        Table_Refresh("promotionTab", false, body_resize);
    }
}

/**
 * 双击表格弹出详细信息查看画面 调用查看函数
 *
 */
function promotionTab_TRDbclick() {
  promotionTab_editRecord_click();
}

function promotionTab_editRecord_click() {
    //增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }

    var sfeature = "dialogwidth:800px; dialogheight:520px;center:yes;help:no;resizable:yes;scroll:yes;status:no";
    var tab = document.all["promotionTab"];
    var trobj = tab.rows[tab.activeIndex];
    var promcustno = "";
    if (tab.rows.length <= 0) {
        alert(MSG_NORECORD);
        return;
    }
    if ((trobj.ValueStr != undefined) && (trobj.ValueStr != "")) {
        var tmp = trobj.ValueStr.split(";");
        promcustno = tmp[0];
    }
    var arg = new Object();
    arg.doType = "edit";
    var rtn = dialog("promotionEdit.jsp?promcustno=" + promcustno + "&doType=edit", arg, sfeature);
    if (rtn == "1") {
        document.getElementById("promotionTab").RecordCount = "0";
        Table_Refresh("promotionTab", false, body_resize);
    }
}
