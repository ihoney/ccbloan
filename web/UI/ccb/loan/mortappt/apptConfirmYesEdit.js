var dw_column;
/**
 * 初始化form表单内容，根据主键取出详细信息，包括查询、删除、修改
 */
function formInit() {
    dw_column = new DataWindow(document.getElementById("editForm"), "form");
    // 设置默认焦点
    document.getElementById("appt_sendback_remark").focus();
    document.getElementById("clientNames").value = window.dialogArguments.clientNames;
}

function saveClick() {

    var doType = document.all.doType.value;
    if (dw_column.validate() != null)
        return;
    var retxml = "";
    var arg = new Object();
    if (operation = "edit") {
        //arg.appt_remark = document.getElementById("appt_remark").value;
        arg.appt_sendback_remark = document.getElementById("appt_sendback_remark").value;
        window.returnValue = arg;
        window.close();
    }
}
