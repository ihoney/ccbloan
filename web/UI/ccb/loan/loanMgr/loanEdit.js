/*******************************************************************************
 *
 * 文件名： 贷款详细管理
 *
 * 作 用：
 *
 * 作 者： leonwoo
 *
 * 时 间： 2010-01-16
 *
 * 版 权： leonwoo
 *
 ******************************************************************************/
var dw_column;

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
            if (onSearchArchiveInfo() == 0){
                event.keyCode = 9;
            }else{
                return;
            }
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

/**
 * 初始化form表单内容，根据主键取出详细信息，包括查询、删除、修改
 */
function formInit() {
    var arg = window.dialogArguments;
    if (arg) {
        operation = arg.doType;
        if (operation != "add") {
            load_form();
            operReSelectCustMgr();
            reselectRealCustMgr();
            // 营销经理初始化
            document.getElementById("CUSTMGR_ID").value = document.getElementById("custMgrID").value;
            //客户经理初始化
            document.getElementById("REALCUSTMGR_ID").value = document.getElementById("realcustMgrID").value;

            //document.getElementById("FLOWSN").readOnly = true;
            document.getElementById("FLOWSN").disabled = true;
            document.getElementById("loanId").focus();
            if(operation == "edit"){
                document.getElementById("FLOWSN").disabled = false;
                document.getElementById("FLOWSN").focus();
            }
        } else {
            //新增贷款时 显示推介信息
            //divfd_promotionTab.style.height = 100;
            //promotionTab.fdwidth = "1200px";
            //initDBGrid("promotionTab");
        }

        // 只读情况下，页面所有空间禁止修改
        if (operation == "select" || operation == "delete") {
            readFun(document.getElementById("editForm"));
        }
    }
    // 初始化数据窗口，校验的时候用
    dw_column = new DataWindow(document.getElementById("editForm"), "form");
    // fm_ini();

    resetDialogHeight();
}

// window.onload=fn_ini;
function fm_ini() {
    var fm, i, j;
    for (i = 0; i < document.forms.length; i++) {
        fm = document.forms[i]
        for (j = 0; j < fm.length; j++) {
            // 这段是input框加入把回车替换成Tab的函数
            if (fm[j].tagName == "INPUT")
                if (fm[j].getAttribute("type").toLowerCase() != "button")
                    addKeyDownEvent(fm[j]);
        }

    }
}
/**
 * 把输入框的onkedown调用函数队列里加入回车键等于Tab键
 */
function addKeyDownEvent(iupt) {
    var oldpress = iupt.onkeydown;
    if (typeof iupt.onkeydown != "function") {
        iupt.onkeydown = jumpNext;
    } else {
        iupt.onkeydown = function() {
            oldpress();
            jumpNext();
        };
    }
}
function jumpNext() {
    if (event.keyCode == 13) {
        event.keyCode = 9;
    }

}

/**
 * 根据经办行联动
 */
function reSelect() {
    operReSelectCustMgr();
//    if (operation == "add") {
////        queryPromotionInfo();
//    }
}

/**
 * 根据经办行联动下拉项目:营销经理ID
 *
 * @return
 */
function operReSelectCustMgr() {
    refresh_select("CUSTMGR_ID", "select t.prommgr_id as value,t.prommgr_name as text from ln_prommgrinfo t " +
            "where t.deptid='" + document.getElementById("BANKID").value + "' order by prommgr_id desc", "1", "1");
    var objPrommgrid = document.getElementById("CUSTMGR_ID");
    if (objPrommgrid.children.length < 1) {
        var optnull = document.createElement("OPTION");
        optnull.setAttribute("text", " ");
        optnull.setAttribute("value", "");
        optnull.setAttribute("selectedIndex", "0");
        objPrommgrid.add(optnull);
    }
    var opt = document.createElement("OPTION");
    opt.setAttribute("text", "新增...");
    opt.setAttribute("value", "newadd");
    objPrommgrid.add(opt);

}
/**
 * 新增营销经理*/
function promMgrReSelect() {
    if (document.getElementById("CUSTMGR_ID").value == "newadd") {
        var sfeature = "dialogwidth:300px; dialogheight:220px;center:yes;help:no;resizable:yes;scroll:yes;status:no";
        var deptid = "";
        if (document.getElementById("BANKID").value != "") {
            deptid = document.getElementById("BANKID").value;
        }
        var arg = new Object();
        var rtn = dialog("/UI/ccb/loan/promotionReg/promMgradd.jsp?doType=add&deptid=" + deptid, arg, sfeature);
        if (rtn == "1") {
            operReSelectCustMgr();
        }
    }
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
            whereStr += " and bankid ='" + trimStr(document.getElementById("bankid").value) + "'";
            whereStr += " and prommgr_id ='" + trimStr(document.getElementById("CUSTMGR_ID").value) + "'";
        }
        document.all["promotionTab"].whereStr = whereStr;
        document.all["promotionTab"].RecordCount = "0";
        document.all["promotionTab"].AbsolutePage = "1";
        Table_Refresh("promotionTab",false);
    }
}

/**
 * 双击表格弹出详细信息查看画面 调用查看函数
 *
 */
function promotionTab_TRDbclick() {
    promotionTab_select_click();
}

function promotionTab_select_click() {
    var tab = document.all["promotionTab"];
    var trobj = tab.rows[tab.activeIndex];
    var promotionNo = "";
    var custName = "";
    var loanAmt = "";
    var bankid = "";
    var prommgr_id = "";
    var custbankid = "";
    var custmgr_id = "";
    if ((trobj.ValueStr != undefined) && (trobj.ValueStr != "")) {
        var tmp = trobj.ValueStr.split(";");
        promotionNo = tmp[0];
        custName = tmp[1];
        loanAmt = tmp[4];
        bankid = tmp[9];
        prommgr_id = tmp[10];
        custbankid = tmp[11];
        custmgr_id = tmp[12];
        document.getElementById("PROMCUST_NO").value = promotionNo;
        document.getElementById("CUST_NAME").value = custName;
        document.getElementById("RT_ORIG_LOAN_AMT").value = loanAmt;
        //经办行
        document.getElementById("BANKID").value = bankid;
        operReSelectCustMgr();  //营销经理list
        // 营销经理
        document.getElementById("CUSTMGR_ID").value = prommgr_id;
        //经营中心
        document.getElementById("CUST_BANKID").value = custbankid;
        reselectRealCustMgr();
        //客户经理
        document.getElementById("REALCUSTMGR_ID").value = custmgr_id;
    }
}

/**
 * <p>
 * 保存函数，包括增加、修改都调用该函数
 * <p>
 * createExecuteform 参数分别为
 * <p>
 * ■editForm :提交的form名称
 * <p>
 * ■insert ：操作类型，必须为insert、update、delete之一；
 * <p>
 * ■mort01 ：会话id，后台业务逻辑组件
 * <p>
 * ■add: : 后台业务组件实际对应方法名称
 *
 * @param doType：操作类型
 *
 */
function saveClick() {

    var doType = document.all.doType.value;
    if (document.getElementById("RELEASECONDCD").value == "03") {
        var waringMsgDate = "放款方式为签约放款，则【开户日期】不能为空！";
        var waringMsgProj = "放款方式为签约放款，则【项目编号】不能为空！";
        if (document.getElementById("CUST_OPEN_DT").value == "") {
            alert(waringMsgDate);
            document.getElementById("CUST_OPEN_DT").focus();
            return;
        }
        if (document.getElementById("PROJ_NO").value == "") {
            alert(waringMsgProj);
            document.getElementById("PROJ_NO").focus();
            return;
        }
    }

    if (dw_column.validate() != null)
        return;

    var flowNo = document.getElementById("FLOWSN").value;
    flowNo = flowNo.replace(/[\$\￥]/g,'');
    document.getElementById("FLOWSN").value = flowNo;

    var retxml = "";
    // 贷款管理
    document.getElementById("busiNode").value = BUSINODE_130;
    if (operation == "add") {
        retxml = createExecuteform(editForm, "insert", "loan01", "add");
    } else if (operation = "edit") {
        retxml = createExecuteform(editForm, "update", "loan01", "edit");
    }

    if (analyzeReturnXML(retxml) + "" == "true") {
        window.returnValue = "1";
        window.close();
    }
}


function onSearchArchiveInfo() {
    // 增加系统锁检查
    /*if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }*/

    var flowsn = trimStr(document.getElementById("FLOWSN").value);
    flowsn = flowsn.replace(/[\$\￥]/g,'');
    document.getElementById("FLOWSN").value = flowsn;

    if (flowsn == "") {
        alert('请输入流水号.');
        return -1;
    }

    var retxml = createselect(editForm, "com.ccb.flowmng.ArchiveInfoSelectOneAction");
    if (analyzeReturnXML(retxml) != "false") {
        fillform(editForm, analyzeReturnXML(retxml));
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

        return 0;
    }else{
        document.getElementById("editForm").reset();
        document.getElementById("FLOWSN").value = flowsn;
        reselectRealCustMgr();
        reSelect();
        return -1;
    }
}
