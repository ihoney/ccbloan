var dw_column;
/**
 * 初始化form表单内容，根据主键取出详细信息，包括查询、删除、修改
 */
function formInit() {
    dw_column = new DataWindow(document.getElementById("editForm"), "form");
    // 设置默认焦点
    document.getElementById("APPT_FEEDBACK_RESULT").focus();
    document.getElementById("clientNames").value = window.dialogArguments.clientNames;
}

function saveClick() {

    var doType = document.all.doType.value;
    if (dw_column.validate() != null)
        return;
    var retxml = "";

    if (document.getElementById("APPT_FEEDBACK_RESULT").value == '99') {  //其它
        if (document.getElementById("APPT_FEEDBACK_REMARK").value == "") {
            alert("请在备注中输入原因说明。");
            return;
        }
    }

    var arg = new Object();
    if (operation = "edit") {
        arg.appt_feedback_result = document.getElementById("appt_feedback_result").value;
        arg.appt_feedback_remark = document.getElementById("appt_feedback_remark").value;
        window.returnValue = arg;
        window.close();
    }
}
