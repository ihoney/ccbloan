/*********************************************************************
 *    功能描述: Odsb 数据读入
 *    作    者: leonwoo
 *    开发日期: 2010/01/16
 *    修 改 人:
 *    修改日期:
 *    版    权: 公司
 ***********************************************************************/
/**
 * 数据检查 ①根据ln_loanapply中“待补充资料标志”为“1”的记录， 与ln_odsb_loanapply中相同贷款申请号的记录比较
 * “姓名”“金额”“机构”， 如有不同，弹出excel显示。<br>
 * ②查询ln_odsb_loanapply中的proj_no是否在抵押系统中存在（合作项目表），如果不存在则弹出excel。
 */
function ODSBCheck() {
    if (confirm(MSG_ODSB_CHECK_CONFIRM)) {
        show_status_label(window, "正在检查数据...", true);
        // 检查金额、姓名等结果
        var checkResult = 0;
        // 检查proj_no合作方编号结果
        var checkProj = 0;
        // var rtnXml = createselectArr("odsbCheck", "text", "1,", "odsb01",
        // "ODSBCheck");
        var rtnXml = createExecuteform(queryForm, "update", "odsb01", "ODSBCheck")
        // if (rtnXml != "false") {
        if (analyzeReturnXML(rtnXml) != "false") {
            var dom = createDomDocument();
            dom.loadXML(rtnXml);
            var fieldList = dom.getElementsByTagName("record")[0];
            for ( var i = 0; i < fieldList.childNodes.length; i++) {
                if (fieldList.childNodes[i].nodeType == 1) {
                    oneRecord = fieldList.childNodes[i];
                    attrName = oneRecord.getAttribute("name");
                    if (attrName == "checkResult") {
                        checkResult = decode(oneRecord.getAttribute("value"));
                    }
                    if (attrName == "checkProj") {
                        checkProj = decode(oneRecord.getAttribute("value"));
                    }
                }
            }
        }
        if (checkResult > 0 || checkProj > 0) {
            hide_status_label(window);
            // 弹出检查结果excel
            if (checkResult > 0) {
                document.getElementById("queryForm").target = "_blank";
                document.getElementById("queryForm").action = "ODSBUpdateCheckReport.jsp";
                document.getElementById("queryForm").submit();
            } else if (checkProj > 0) {
                // ODSB合作方在本系统中不存在
                document.getElementById("queryForm").target = "_blank";
                document.getElementById("queryForm").action = "ODSBUpdateCheckProj.jsp";
                document.getElementById("queryForm").submit();
            }
        } else {
            hide_status_label(window);
            alert(MSG_ODSB_CHECK_RESULT);
        }
    }
}
/*******************************************************************************
 * 根据ODSB跟新贷款信息表
 * 
 * @return 更新记录数
 * @return 新增记录数
 * @return 更新抵押到期日记录数
 * @return 更新待补充资料标志记录数
 */
function ODSBUpdate() {
    var updateCnt = 0;
    var addCnt = 0;
    var updateMortDateCnt = 0;
    var updateNeedCDCnt = 0;
    if (confirm(MSG_ODSB_UPDATE_CONFIRM)) {
        show_status_label(window, "正在更新数据...", true);
        // 保存到隐藏变量中提交后台
        var rtnXml = createExecuteform(queryForm, "update", "odsb01", "ODSBUpdate")
        // if (analyzeReturnXML(retxml) != "false") {
        // hide_status_label(window);
        // alert(MSG_SUCCESS);
        // }
        if (analyzeReturnXML(rtnXml) != "false") {
            hide_status_label(window);
            var dom = createDomDocument();
            dom.loadXML(rtnXml);
            var fieldList = dom.getElementsByTagName("record")[0];
            for ( var i = 0; i < fieldList.childNodes.length; i++) {
                if (fieldList.childNodes[i].nodeType == 1) {
                    oneRecord = fieldList.childNodes[i];
                    attrName = oneRecord.getAttribute("name");
                    // 更新记录数
                    if (attrName == "updateCnt") {
                        updateCnt = decode(oneRecord.getAttribute("value"));
                    }
                    // 新增记录数
                    if (attrName == "addCnt") {
                        addCnt = decode(oneRecord.getAttribute("value"));
                    }
                    // 更新抵押到期日记录数
                    if (attrName == "updateMortDateCnt") {
                        updateMortDateCnt = decode(oneRecord.getAttribute("value"));
                    }
                    // 更新待补充资料标志记录数
                    if (attrName == "updateNeedCDCnt") {
                        updateNeedCDCnt = decode(oneRecord.getAttribute("value"));
                    }
                }
            }
            // 显示提示信息
            document.getElementById("divResultInfo").style.display = "block";
            document.getElementById("_cell_updateCnt").innerHTML = updateCnt;
            document.getElementById("_cell_addCnt").innerHTML = addCnt;
            document.getElementById("_cell_updateMortDateCnt").innerHTML = updateMortDateCnt;
            document.getElementById("_cell_updateNeedCDCnt").innerHTML = updateNeedCDCnt;
        } else {
            hide_status_label(window);
        }
    }
}
