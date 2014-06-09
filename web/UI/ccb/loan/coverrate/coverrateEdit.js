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
        // 初始化数据窗口，校验的时候用
        dw_column = new DataWindow(document.getElementById("editForm"), "form");
    }
}

function saveClick() {
    if (dw_column.validate() != null)
		return;
	var retxml = "";
    retxml = createExecuteform(editForm,"update","cvrt01","edit");
    if (analyzeReturnXML(retxml) + "" == "true") {
        window.returnValue = "1";
        window.close();
    }
}