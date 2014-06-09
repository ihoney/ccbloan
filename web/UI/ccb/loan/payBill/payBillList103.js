var dw_form;

/**
 * 初始化
 *
 * @return
 */
function payBillInit() {
    body_init(queryForm, "expExcel");
    // 初始化数据窗口，校验的时候用
    dw_form = new DataWindow(document.getElementById("queryForm"), "form");
}

/**
 * report
 */
function loanTab_expExcel_click() {

    // 增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }
    if (dw_form.validate() != null)
        return;


    var beginDate = new Date(document.getElementById("CUST_OPEN_DT").value.replace(/-/g, "/"));
    var endDate = new Date(document.getElementById("CUST_OPEN_DT2").value.replace(/-/g, "/"));
    if (beginDate > endDate) {
        alert("结束时间必须大于开始时间！");
        return false;
    }
    if (trimStr(document.getElementById("ods_src_dt").value) != "") {
        var ods_src_dt = new Date(document.getElementById("ods_src_dt").value.replace(/-/g, "/"));
        if (endDate > ods_src_dt) {
            alert("输入的截止日期不可超过当前总行已返还的贷款数据截止时间:" + document.getElementById("ods_src_dt").value);
            return false;
        }
    }

    document.getElementById("queryForm").target = "_blank";
    document.getElementById("queryForm").action = "payBillReport103.jsp";
    document.getElementById("queryForm").submit();
}