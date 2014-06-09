/*********************************************************************
 *    功能描述: Odsb 数据读入
 *    作    者: leonwoo
 *    开发日期: 2010/01/16
 *    修 改 人:
 *    修改日期:
 *    版    权: 公司
 ***********************************************************************/
/**
 * 从ODSB数据导入
 */
function readFromODSB() {
  var importCnt = 0;
  if (confirm(MSG_ODSB_READ_CONFIRM)) {
    show_status_label(window, "正在读入数据...", true);
    // formelement, exctype, actionName, methodname
    rtnXml = createExecuteform(queryForm, "update", "odsb01", "readFromODSB");
    //if (analyzeReturnXML(retxml) + "" == "true") {
    //  hide_status_label(window);
    //}else{
    //  hide_status_label(window);
    //}
   // if (rtnXml != "false") {
    if (analyzeReturnXML(rtnXml) != "false") {
      hide_status_label(window);
      var dom = createDomDocument();
      dom.loadXML(rtnXml);
      var fieldList = dom.getElementsByTagName("record")[0];
      for ( var i = 0; i < fieldList.childNodes.length; i++) {
        if (fieldList.childNodes[i].nodeType == 1) {
          oneRecord = fieldList.childNodes[i];
          attrName = oneRecord.getAttribute("name");
          // 记录数
          if (attrName == "importCnt") {
            importCnt = decode(oneRecord.getAttribute("value"));
          }
        }
      }
      // 显示提示信息
      document.getElementById("divResultInfo").style.display = "block";
      document.getElementById("_cell_importCnt").innerHTML = importCnt;
    }else{
      hide_status_label(window);
    }
  }

}
