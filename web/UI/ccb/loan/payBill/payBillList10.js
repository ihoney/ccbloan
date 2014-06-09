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
 * 
 * @param doType:select
 *          操作类型
 */
function loanTab_expExcel_click() {

  // 增加系统锁检查
  if (getSysLockStatus() == "1") {
    alert(MSG_SYSLOCK);
    return;   
  }
  if (dw_form.validate() != null)
    return;
  
  document.getElementById("queryForm").target = "_blank";
  document.getElementById("queryForm").action = "payBillReport10.jsp";
  document.getElementById("queryForm").submit();
}