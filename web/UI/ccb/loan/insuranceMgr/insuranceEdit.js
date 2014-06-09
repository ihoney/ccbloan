
var dw_column;
var operation;
function formInit() {
    var arg = window.dialogArguments;
    if (arg) {
        operation = arg.doType;
            load_form();

    }
    // 初始化数据窗口，校验的时候用
    dw_column = new DataWindow(document.getElementById("editForm"), "form");
}

function saveClick() {
    var doType = document.all.doType.value;
    if (dw_column.validate() != null)
        return;
    var retxml = "";
    document.getElementById("insurancests").value = "0"; //已入库
    if (operation == "add") {
        retxml = createExecuteform(editForm, "insert", "insu01", "add");
        if (analyzeReturnXML(retxml) + "" == "true") {
            window.returnValue = "1";
            window.close();
        }
    } else if (operation = "edit") {
        retxml = createExecuteform(editForm, "update", "insu01", "edit");
        if (analyzeReturnXML(retxml) + "" == "true") {
            window.returnValue = "1";
            window.close();
        }
    }
}