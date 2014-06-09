var dw_column;
var operation = "add";

// tab enter键 zhan
document.onkeydown = function (evt) {
    var isie = (document.all) ? true : false;
    var key;
    var srcobj;
    if (isie) {
        key = event.keyCode;
        srcobj = event.srcElement;
    } else {
        key = evt.which;
        srcobj = evt.target;
    }
    if (key == 13 && srcobj.type != 'button' && srcobj.type != 'submit' && srcobj.type != 'reset'
        && srcobj.type != 'textarea' && srcobj.type != '') {
        if (isie) {
            event.keyCode = 9;
        } else {
            var el = getNextElement(evt.target);
            if (el.type != 'hidden')
                el.focus();
            else
                while (el.type == 'hidden')
                    el = getNextElement(el);
            el.focus();
            return false;
        }
    }
}
function getNextElement(field) {
    var form = field.form;
    for (var e = 0; e < form.elements.length; e++) {
        if (field == form.elements[e])
            break;
    }
    return form.elements[++e % form.elements.length];
}


function body_resize() {
    //divfd_loanTab.style.height = document.body.clientHeight - 330;
    //loanTab.fdwidth = "100%";
    initDBGrid("flowInfoTab");
    initDBGrid("flowNodeTab");
    // 初始化页面焦点
    //body_init(queryForm, "cbRetrieve");
    document.getElementById("FLOWSN").focus();
    document.getElementById("FLOWSN").select();
    // 初始化数据窗口，校验的时候用
    dw_column = new DataWindow(document.getElementById("queryForm"), "form");
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

    var flowNo = document.getElementById("FLOWSN").value;
    flowNo = flowNo.replace(/[\$\￥]/g,'');
    document.getElementById("FLOWSN").value = flowNo;

    //alert(document.getElementById("loanTab").attributes["whereStr"].nodeValue);
    //alert(document.getElementById("loanTab").SQLStr);

    var whereStr = "";
    whereStr += getWhereString_like("a", "FLOWSN");
    whereStr += getWhereString_like("a", "CUST_NAME");
//    whereStr += getWhereString_eq_num("a", "RT_ORIG_LOAN_AMT");
//    whereStr += getWhereString_eq_num("a", "RT_TERM_INCR");
    whereStr += getWhereString_eq_str("a", "BANKID");
    whereStr += getWhereString_eq_str("a", "CUSTMGR_ID");
//    whereStr += getWhereString_eq_str("a", "CUST_BANKID");
//    whereStr += getWhereString_eq_str("a", "REALCUSTMGR_ID");

    whereStr += " order by a.operdate desc ";
    document.getElementById("flowInfoTab").whereStr = whereStr;
    Table_Refresh("flowInfoTab", false, body_resize);
}

function getWhereString_like(tableName, fieldName) {
    if (trimStr(document.getElementById(fieldName).value) != "") {
        return  " and " + tableName + "." + fieldName + " like '%" + trimStr(document.getElementById(fieldName).value) + "%'";
    } else {
        return "";
    }
}
function getWhereString_eq_str(tableName, fieldName) {
    if (trimStr(document.getElementById(fieldName).value) != "") {
        return  " and " + tableName + "." + fieldName + " = '" + trimStr(document.getElementById(fieldName).value) + "'";
    } else {
        return "";
    }
}
function getWhereString_eq_num(tableName, fieldName) {
    if (trimStr(document.getElementById(fieldName).value) != "") {
        return  " and " + tableName + "." + fieldName + " = " + trimStr(document.getElementById(fieldName).value) + "";
    } else {
        return "";
    }
}


function reSelect() {
    operReSelectCustMgr();
}

/**
 * 根据经办行联动下拉项目:营销经理ID
 */
function operReSelectCustMgr() {
    refresh_select("CUSTMGR_ID", "select t.prommgr_id as value,t.prommgr_name as text from ln_prommgrinfo t " +
        "where t.deptid='" + document.getElementById("BANKID").value + "'");
    var objPrommgrid = document.getElementById("CUSTMGR_ID");
    var optnull = document.createElement("OPTION");
    optnull.setAttribute("text", "");
    optnull.setAttribute("value", "");
    optnull.setAttribute("selected", "true");
    objPrommgrid.add(optnull);
}
/**
 * 根据经营中心联动*/

function reSelectCustBank() {
    reselectRealCustMgr();
}
/**
 * 根据经营中心选择客户经理下拉菜单*/

function reselectRealCustMgr() {
    refresh_select("REALCUSTMGR_ID", "select OPERID as value ,OPERNAME as text  from ptoper t " +
        "where t.deptid='" + document.getElementById("CUST_BANKID").value + "'");
    var objPrommgrid = document.getElementById("REALCUSTMGR_ID");
    var optnull = document.createElement("OPTION");
    optnull.setAttribute("text", "");
    optnull.setAttribute("value", "");
    optnull.setAttribute("selected", "true");
    objPrommgrid.add(optnull);
}
/**
 * 根据客户经理和经办行*/
function custMgrReSelect() {
    queryPromotionInfo();
}

function queryPromotionInfo() {
    var whereStr = "";
    if (trimStr(document.getElementById("CUST_NAME").value) != "") {
        whereStr += " and cust_name like '" + trimStr(document.getElementById("CUST_NAME").value) + "%'";
        if ((trimStr(document.all["BANKID"].value) != "" && trimStr(document.all["CUSTMGR_ID"].value) != "")) {
            whereStr += " and bankid ='" + trimStr(document.getElementById("BANKID").value) + "'";
            whereStr += " and prommgr_id ='" + trimStr(document.getElementById("CUSTMGR_ID").value) + "'";
        }
        document.all["promotionTab"].whereStr = whereStr;
        document.all["promotionTab"].RecordCount = "0";
        document.all["promotionTab"].AbsolutePage = "1";
        Table_Refresh("promotionTab", false);
    }
}


function flowInfoTab_TDclick(el) {
    flowInfoTab_TRDbclick(el);
}

function flowInfoTab_TRDbclick(el) {
    ///获取主健信息
    var whArr = flowInfoTab.rows[flowInfoTab.activeIndex].whStr.split("&");

    ///分解主健信息构造查询条件
    var whereStr = "and(flowsn = '" + whArr[2] + "') order by a.operdate desc,a.opertime desc";
    ///给从表添加查询条件
    flowNodeTab.whereStr = whereStr;

    ///刷新从表记录
    flowNodeTab.AbsolutePage = "1";
    flowNodeTab.RecordCount = "0";
    Table_Refresh("flowNodeTab", true, body_resize);
}

//function flowNodeTab_TDclick(el) {
//    flowNodeTab_TRDbclick(el);
//}
//显示业务流程信息列表中的备注信息 2013-04-01 linyong
function flowNodeTab_TRDbclick(el) {
    //增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }

    var sfeature = "dialogwidth:600px; dialogheight:400px;center:yes;help:no;resizable:yes;scroll:yes;status:no";
    var tab = document.all["flowNodeTab"];
    var trobj = tab.rows[tab.activeIndex];
    var remark = "";

    if (tab.rows.length <= 0) {
        alert(MSG_NORECORD);
        return;
    }

    if ((trobj.ValueStr != undefined) && (trobj.ValueStr != "")) {
        var tmp = trobj.ValueStr.split(";");
        remark = tmp[5];
    }

    var arg = new Object();
    arg.doType = "select";
    dialog("flowInfoRemark.jsp?remark=" + remark + "&doType=select", arg, sfeature);
}



