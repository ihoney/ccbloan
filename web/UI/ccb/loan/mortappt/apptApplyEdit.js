var dw_column;
/**
 * ��ʼ��form�����ݣ���������ȡ����ϸ��Ϣ��������ѯ��ɾ�����޸�
 */
function formInit() {

    // ��ʼ�����ݴ��ڣ�У���ʱ����
    dw_column = new DataWindow(document.getElementById("editForm"), "form");
    // ����Ĭ�Ͻ��㣻���
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
            alert("����ǰ " + appt_date_pre +  " ����е�Ѻ����ԤԼ...");
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
