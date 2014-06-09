<!--
/*********************************************************************
* 功能描述: Odsb 根据ODSB更新贷款表
* 作 者: leonwoo
* 开发日期: 2010/01/16
* 修 改 人:
* 修改日期:
* 版 权: 公司
***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK" %>
<%@page import="com.ccb.util.CcbLoanConst" %>
<%@include file="/global.jsp" %>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=GBK">
<title></title>
<script language="javascript" src="ODSBUpdate.js"></script>
<script language="javascript" src="/UI/support/pub.js"></script>
<script language="javascript">     
    var checkSubmitFlg = false;     
    function checkSubmit() {     
      if (checkSubmitFlg == true) {     
         return false;     
      }     
      checkSubmitFlg = true;     
      return true;     
   }     
   document.ondblclick = function docondblclick() {     
    window.event.returnValue = false;     
   }     
   document.onclick = function doconclick() {     
       if (checkSubmitFlg) {     
         window.event.returnValue = false;     
       }     
   }     
</script>
</head>
<body bgcolor="#ffffff" class="Bodydefault">
<div class="queryPanalDiv">
  <fieldset style="padding:30px 10px 10px 10px;margin:0px 20px 0px 20px">
  <legend>ODSB数据检查及导入</legend>
  <br/>
  <table border="0" cellspacing="0" cellpadding="0" width="100%">
    <form id="queryForm" name="queryForm" onsubmit="return checkSubmit();">
      <!-- 仅作为平台打包数据之用 -->
      <input type="hidden" id="operType" name="operType" value="readFromODSB"/>
      <tr>
        <td align="center" nowrap="nowrap"><input type="button" id="odsbCheck" onClick="ODSBCheck()" value="已录入数据检查">
          <input type="button" id="odsbUpdate" onClick="ODSBUpdate()" value="贷款信息自动补充">
        </td>
      </tr>
    </form>
  </table>
  <br/>
  </fieldset>
<br/>
  </div>
<div style="display:none" id="divResultInfo" class="queryPanalDiv">
  <fieldset style="padding:30px 25px 10px 25px;margin:0px 20px 0px 20px">
  <legend>ODSB数据检查及检查导入结果</legend>
      <br>
  <table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr>
      <td width="50%" class="lbl_right_padding">更新数据记录数</td>
      <td width="50%" class="data_input" id="_cell_updateCnt"></td>
    </tr>
    <tr>
      <td width="50%" class="lbl_right_padding">新增数据记录数</td>
      <td width="50%" class="data_input" id="_cell_addCnt"></td>
    </tr>
    <tr>
      <td width="50%" class="lbl_right_padding">更新抵押到期日数据记录数</td>
      <td width="50%" class="data_input" id="_cell_updateMortDateCnt"></td>
    </tr>
    <tr>
      <td width="50%" class="lbl_right_padding">更新数据待补充标志数据记录数</td>
      <td width="50%" class="data_input" id="_cell_updateNeedCDCnt"></td>
    </tr>
  </table>
      <br>
  </fieldset>
</div>
</body>
</html>
