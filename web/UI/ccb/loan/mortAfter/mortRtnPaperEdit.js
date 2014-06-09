/*******************************************************************************
 *
 * 文件名： 抵押详细管理
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
var operation;
/**
 * 初始化form表单内容，根据主键取出详细信息，包括查询、删除、修改
 */
function formInit() {
    // 初始化事件
    var arg = window.dialogArguments;

    if (arg) {
        operation = arg.doType;
        if (operation != "add") {
            load_form();
        }

        // 入库日期默认为系统时间
        if (document.getElementById("PAPERRTNDATE").value == "") {
            var date = new Date();
            document.getElementById("PAPERRTNDATE").value = getDateString(date);
            document.getElementById("PAPERRTNDATE").readOnly = "readOnly";
        }
        // 抵押登记状态为：已登记
        document.getElementById("MORTREGSTATUS").value = "3";

        if (document.getElementById("KEEPCONT").value == "") {
            document.getElementById("KEEPCONT").value = "10";
        }

        // 只读情况下，页面所有空间禁止修改
        if (operation == "select" || operation == "delete") {
            readFun(document.getElementById("editForm"));
        }

    }
    // 初始化数据窗口，校验的时候用
    dw_column = new DataWindow(document.getElementById("editForm"), "form");
    // 设置默认焦点；入库日期
    if (operation != "select") {
        document.getElementById("PAPERRTNDATE").focus();
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
    if (document.getElementById("documentid").value == "") {
        if (!confirm("重要档案编号为空，确认吗?")) {
            return;
        }
    }

    var doType = document.all.doType.value;
    if (dw_column.validate() != null)
        return;
    var retxml = "";
    if (operation == "add") {
        retxml = createExecuteform(editForm, "insert", "mort01", "add");
    } else if (operation = "edit") {
        // 权证已入库 30
        var MORT_FLOW_SAVED = "30";
        document.getElementById("MORTSTATUS").value = MORT_FLOW_SAVED;
        document.getElementById("busiNode").value = BUSINODE_080;
        retxml = createExecuteform(editForm, "update", "mort01", "edit");
    }

    if (analyzeReturnXML(retxml) + "" == "true") {
        window.returnValue = "1";
        window.close();
    }
}
function newDocId_Click() {
    var retxml = createselect(editForm, "com.ccb.mortgage.mortgageAction", "generateDocumentID");
    if (analyzeReturnXML(retxml) != "false") {
        var dom = createDomDocument();
        dom.loadXML(retxml);
        var fieldList = dom.getElementsByTagName("record")[0];
        for (var i = 0; i < fieldList.childNodes.length; i++) {
            if (fieldList.childNodes[i].nodeType == 1) {
                var oneRecord = fieldList.childNodes[i];
                var attrName = oneRecord.getAttribute("name");
                if (attrName == "docid") {
                    document.getElementById("documentid").value = oneRecord.getAttribute("value");
                }
            }
        }
    }
}
