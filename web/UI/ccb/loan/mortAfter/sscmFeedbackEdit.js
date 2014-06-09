var dw_column;
/**
 * 初始化form表单内容，根据主键取出详细信息，包括查询、删除、修改
 */
function formInit() {
    dw_column = new DataWindow(document.getElementById("editForm"), "form");
    // 设置默认焦点
    document.getElementById("SSCM_STATUS").focus();
    var date = new Date();
    document.getElementById("SSCM_DATE").value = getDateString(date);
    //document.getElementById("SSCM_DATE").readOnly = "readOnly";
    document.getElementById("clientNames").value = window.dialogArguments.clientNames;
}

function saveClick() {

    var doType = document.all.doType.value;
    if (dw_column.validate() != null)
        return;
    var retxml = "";

    if (document.getElementById("SSCM_STATUS").value == '20') {  //未撤押
        if (document.getElementById("SSCM_NOCANCEL_REASON").value == "") {
            alert("请输入未撤押原因说明...");
            return;
        }
    }

    var arg = new Object();
    if (operation = "edit") {
        arg.sscm_status = document.getElementById("SSCM_STATUS").value;
        arg.sscm_date = document.getElementById("SSCM_DATE").value;
        arg.sscm_nocancel_reason = document.getElementById("SSCM_NOCANCEL_REASON").value;
        window.returnValue = arg;
        window.close();
    }
}
