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
            if (operation == "edit") {
                document.getElementById("bankflag").value = arg.bankflag;
            }
        }

        // if (document.getElementById("SENDFLAG").value == "") {
        document.getElementById("SENDFLAG").value = "0";
        document.getElementById("SENDFLAG").disabled = "true";
        // }

        // if (document.getElementById("RPTMORTDATE").value == "") {
        // 快递日期自动反显
        var date = new Date();
        document.getElementById("RPTNOMORTDATE").value = getDateString(date);
        // document.getElementById("RPTMORTDATE").readOnly = "readOnly";
        // }

        // 只读情况下，页面所有空间禁止修改
        if (operation == "select" || operation == "delete") {
            readFun(document.getElementById("editForm"));
        }

    }
    // 初始化数据窗口，校验的时候用
    dw_column = new DataWindow(document.getElementById("editForm"), "form");
    // 设置默认焦点；抵押交接标志
    if (operation != "select") {
        document.getElementById("RPTNOMORTDATE").focus();
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
    if (dw_column.validate() != null)
        return;
    var retxml = "";
    if (operation == "add") {
        retxml = createExecuteform(editForm, "insert", "mort01", "add");
    } else if (operation = "edit") {
        document.getElementById("busiNode").value = BUSINODE_030;
        retxml = createExecuteform(editForm, "update", "mort01", "edit");
    }

    if (analyzeReturnXML(retxml) + "" == "true") {
        window.returnValue = "1";
        window.close();
    }
}
