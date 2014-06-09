
var dw_column;
var operation = "add";

// tab enter键 zhan
document.onkeydown = function(evt) {
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
        if (srcobj.id == "FLOWSN") {
            onSearch();
            return;
        }
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
    divfd_loanTab.style.height = document.body.clientHeight - 330;
    loanTab.fdwidth = "100%";
    initDBGrid("loanTab");
    // 初始化页面焦点
    //body_init(queryForm, "cbRetrieve");
    document.getElementById("FLOWSN").focus();
    document.getElementById("FLOWSN").select();
    // 初始化数据窗口，校验的时候用
    dw_column = new DataWindow(document.getElementById("queryForm"), "form");
    resetDialogHeight();
    document.getElementById("FLOWSN").value = trimStr(document.getElementById("FLOWSN").value)
    document.getElementById("AF_REMARK").value = trimStr(document.getElementById("AF_REMARK").value)
}


function onSearch() {
    // 增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }

    var flowsn = trimStr(document.getElementById("FLOWSN").value);
    if (flowsn == "") {
        alert('请输入流水号.');
        return;
    }

    var retxml = createselect(queryForm, "com.ccb.flowmng.ArchiveInfoSelectOneAction");
    //alert(retxml);
    if (analyzeReturnXML(retxml) != "false") {
        fillform(queryForm, analyzeReturnXML(retxml));
        reselectRealCustMgr();
        reSelect();

        //更新 CUSTMGR_ID和REALCUSTMGR_ID
        var xmlDoc = createDomDocument();
        xmlDoc.loadXML(retxml);
        var nodes = xmlDoc.selectNodes("/root/action/record/field");
        for (var i= 0, l = nodes.length; i<l;i++){
            if (decode(nodes[i].getAttribute("name")) == "CUSTMGR_ID"){
                document.getElementById("CUSTMGR_ID").value =  decode(nodes[i].getAttribute("value"));
            }
            if (nodes[i].getAttribute("name") == "REALCUSTMGR_ID"){
                document.getElementById("REALCUSTMGR_ID").value =  decode(nodes[i].getAttribute("value"));
            }
        }

        document.getElementById("AF_REMARK").value = "";
    }else{
        document.getElementById("queryForm").reset();
        document.getElementById("FLOWSN").value = flowsn;
        reselectRealCustMgr();
        reSelect();
        return;
    }

    var whereStr = " and 1=1 and a.flowsn = '" + flowsn + "'" ;
    whereStr += " order by a.operdate desc ,a.opertime desc ";
    document.all["loanTab"].whereStr = whereStr;
    document.all["loanTab"].RecordCount = "0";
    document.all["loanTab"].AbsolutePage = "1";
    Table_Refresh("loanTab", false, body_resize);
}


function loanTab_TRDbclick() {
    loanTab_select_click();
}

function loanTab_select_click() {
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
        Table_Refresh("promotionTab",false);
    }
}


function saveClick() {
    if (dw_column.validate() != null)
        return;

    var flowstat_radio = document.getElementsByName("FLOWSTAT");
    for (var i = 0; i<flowstat_radio.length;i++){
        if (flowstat_radio[i].checked == true) {
            if (flowstat_radio[i].value == '20') {
                if (trimStr(document.getElementById("AF_REMARK").value) == "") {
                    alert("请在备注中输入挂起原因。");
                    return;
                }
            }
        }
    }

    var flowNo = document.getElementById("FLOWSN").value;
    flowNo = flowNo.replace(/[\$\￥]/g,'');
    document.getElementById("FLOWSN").value = flowNo;

    var retxml = "";
    // 贷款管理
    document.getElementById("busiNode").value = BUSINODE_130;
    retxml = createExecuteform(queryForm, "insert", "com.ccb.flowmng.ArchiveFlowAction", "add");

    document.all["loanTab"].RecordCount = "0";
    document.all["loanTab"].AbsolutePage = "1";
    Table_Refresh("loanTab", false, body_resize);

    if (analyzeReturnXML(retxml) + "" == "true") {
        document.getElementById("queryForm").reset();
        document.getElementById("FLOWSN").value = trimStr(document.getElementById("FLOWSN").value)
        document.getElementById("AF_REMARK").value = trimStr(document.getElementById("AF_REMARK").value)
    }
}



