var dw_column;
var operation;
/**
 * 初始化form表单内容，根据主键取出详细信息，包括查询、删除、修改
 */
function formInit() {
    var arg = window.dialogArguments;
    var doType = document.getElementById("doType").value;
    if (doType == 'edit') {
        document.getElementById("idno").disabled = "true";
    }
    if (arg) {
        operation = arg.doType;
        if (operation != "add") {
            load_form();
        } else {
            var date = new Date();
        }

        // 只读情况下，页面所有空间禁止修改
        if (operation == "select" || operation == "delete") {
            readFun(document.getElementById("editForm"));
            //setReadonlyFunc(document.getElementById("editForm"));
        }

    }
    // 初始化数据窗口，校验的时候用
    dw_column = new DataWindow(document.getElementById("editForm"), "form");
}

/**
 * 保存函数，包括增加、修改都调用该函数
 */
function saveClick() {

    var doType = document.all.doType.value;
    if (dw_column.validate() != null)
        return;
    var retxml = "";
    document.getElementById("busiNode").value = BUSINODE_190;
    if (operation == "add") {

        retxml = createExecuteform(editForm, "insert", "crdt01", "add");
    } else if (operation = "edit") {
        retxml = createExecuteform(editForm, "update", "crdt01", "edit");
    }

    if (analyzeReturnXML(retxml) + "" == "true") {
        window.returnValue = "1";
        window.close();
    }
}

// 循环使得form内容不可修改
function setReadonlyFunc(userTab) {
    for (var i = 0; i < userTab.length; i++) {
        var obj = userTab.item(i);
        // if(obj.type=="text"||obj.type=="textarea"||obj.type=="button"){
        if (obj.type == "text" || obj.type == "textarea") {
            //            obj.disabled = true;
            obj.className = "inputReadonly";
            obj.readOnly = true;
        } else if (obj.type == "select-one") {
            obj.disabled = true;
        }
    }
}

/**
 * 开发贷 选择后的联动
 */
function bankFlagSelect() {
    var bankflag = document.getElementById("BANKFLAG").value;
    if (bankflag == "" || bankflag == "0") {
        document.getElementById("devlntimelimittye_tr").style.display = "none";
        document.getElementById("DEVLNTIMELIMITTYE").value = "";
        document.getElementById("DEVLNTIMELIMITTYE").isNull = "true";
        document.getElementById("devlnenddate").isNull = "true";
    } else {
        document.getElementById("devlntimelimittye_tr").style.display = "inline";
    }
}

/**
 * 开发贷抵押办理时限方式 选择后的联动
 */
function devlntimelimittyeSelect() {
    var type = document.getElementById("DEVLNTIMELIMITTYE").value;
    if (type == "2") {
        document.getElementById("devlnenddate").isNull = "false";
    } else {
        document.getElementById("devlnenddate").isNull = "true";
    }
}

