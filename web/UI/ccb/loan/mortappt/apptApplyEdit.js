var dw_column;
/**
 * 初始化form表单内容，根据主键取出详细信息，包括查询、删除、修改
 */
function formInit() {

    // 初始化数据窗口，校验的时候用
    dw_column = new DataWindow(document.getElementById("editForm"), "form");
    // 设置默认焦点；柜号
    document.getElementById("appt_date").focus();
    document.getElementById("clientNames").value = window.dialogArguments.clientNames;
}

function saveClick() {

    var doType = document.all.doType.value;
    if (dw_column.validate() != null)
        return;
    var retxml = "";
    var arg = new Object();
    if (operation = "edit") {
        arg.appt_date = document.getElementById("appt_date").value;
        var  appt_date_init = document.getElementById("appt_date_init").value;
        var  appt_date_pre = document.getElementById("appt_date_pre").value;
        if (arg.appt_date < appt_date_init) {
            alert("请提前 " + appt_date_pre +  " 天进行抵押处理预约...");
            return;
        }
        var appt_times = document.getElementsByName("appt_time");
        for (var i = 0; i < appt_times.length; i++) {
            if (appt_times[i].checked) {
                arg.appt_time = appt_times[i].value;
            }
        }
        arg.appt_remark = document.getElementById("appt_remark").value;
        window.returnValue = arg;
        window.close();
    }
}
