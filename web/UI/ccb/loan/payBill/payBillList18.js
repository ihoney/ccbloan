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

function loanTab_expExcel_click(flag) {

  // 增加系统锁检查
  if (getSysLockStatus() == "1") {
    alert(MSG_SYSLOCK);
    return;
  }
  if (dw_form.validate() != null)
    return;

  document.getElementById("queryForm").target = "_blank";
  if (flag == 1)
    document.getElementById("queryForm").action = "payBillReport18.jsp";
  else if (flag == 2)
    document.getElementById("queryForm").action = "payBillReport21.jsp";
  else if (flag == 3)
    document.getElementById("queryForm").action = "payBillReport22.jsp";
  document.getElementById("queryForm").submit();
}