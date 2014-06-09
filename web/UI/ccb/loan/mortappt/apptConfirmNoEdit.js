var dw_column;
/**
 * 初始化form表单内容，根据主键取出详细信息，包括查询、删除、修改
 */
function formInit() {
    dw_column = new DataWindow(document.getElementById("editForm"), "form");
    // 设置默认焦点
    document.getElementById("APPT_SENDBACK_REASON").focus();
    document.getElementById("clientNames").value = window.dialogArguments.clientNames;
}

function saveClick() {

    var doType = document.all.doType.value;
    if (dw_column.validate() != null)
        return;
    var retxml = "";

    if (document.getElementById("APPT_SENDBACK_REASON").value == '99') {  //其它
        if (document.getElementById("APPT_SENDBACK_REMARK").value == "") {
            alert("请在备注中输入退回原因说明。");
            return;
        }
    }

    var arg = new Object();
    if (operation = "edit") {
        arg.appt_sendback_reason = document.getElementById("APPT_SENDBACK_REASON").value;
        arg.appt_sendback_remark = document.getElementById("APPT_SENDBACK_REMARK").value;
        window.returnValue = arg;
        window.close();
    }
}
