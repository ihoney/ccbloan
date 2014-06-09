/*******************************************************************************
 * 
 * 文件名： 抵押详细管理
 * 
 * 作 用：
 * 
 * 作 者： leonwoo
 * 
 * 时 间： 2010-01-16
 * 
 * 版 权： leonwoo
 * 
 ******************************************************************************/
var dw_column;
/**
 * 初始化form表单内容，根据主键取出详细信息，包括查询、删除、修改
 */
function formInit() {

  // 初始化数据窗口，校验的时候用
  dw_column = new DataWindow(document.getElementById("editForm"), "form");
  // 设置默认焦点；柜号
  document.getElementById("BOXID").focus();
}

/**
 * <p>
 * 保存函数，包括增加、修改都调用该函数
 * <p>
 * createExecuteform 参数分别为
 * <p>
 * ■editForm :提交的form名称
 * <p>
 * ■insert ：操作类型，必须为insert、update、delete之一；
 * <p>
 * ■mort01 ：会话id，后台业务逻辑组件
 * <p>
 * ■add: : 后台业务组件实际对应方法名称
 * 
 * @param doType：操作类型
 * 
 */
function saveClick() {

  var doType = document.all.doType.value;
  if (dw_column.validate() != null)
    return;
  var retxml = "";
  var arg = new Object();
  if (operation = "edit") {
    arg.boxid = document.getElementById("BOXID").value;
    arg.expressNote = document.getElementById("EXPRESSNOTE").value;
    window.returnValue = arg;
    window.close();
  }
}
