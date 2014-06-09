<!--
  /*********************************************************************
  *    功能描述:    1.
  *
  *    作    者:    leonwoo
  *    开发日期:    2005/01/28
  *    修 改 人:
  *    修改日期:
  *    版    权:    leonwoo
  ***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK"%>
<%@include file="/global.jsp"%>
<%@page import="pub.platform.security.OperatorManager"%>
<%@page import="pub.platform.form.config.SystemAttributeNames"%>
<%@page import="pub.platform.db.DBGrid"%>
<%@page import="pub.platform.html.ZtSelect"%>
<html>
  <head>
    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title></title>
 
    <script language="javascript" src="js/fileList.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
    <script language="javascript" src="/UI/support/suggest/js/ajaxSuggestions.js"></script>
    <style type="text/css" media="screen">
        @import url("/UI/support/suggest/css/ajax-suggestions.css");
    </style>
     <script type="text/javascript">
     // 把pulldown值复制到input中
      function setPullToInput(elm){
        document.getElementById("file_name").value=elm.innerText;
        document.getElementById("file_name").focus();
       }
    </script> 
  </head>
  <%
        OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
        String deptId = omgr.getOperator().getPtDeptBean().getDeptid();

        DBGrid dbGrid = new DBGrid();
        dbGrid.setGridID("itemTab");
        dbGrid.setGridType("edit");

        String sql = "select  file_id,file_name,impawnNoReason,file_date,file_lastdate,isvisibled,file_type from ptdemo where 1=1 ";
        dbGrid.setfieldSQL(sql);

        dbGrid.setField("唯一序号", "text", "5", "file_id", "false", "-1");
        dbGrid.setField("文件名称", "text", "10", "file_name", "true", "0");
        dbGrid.setField("未办理抵押原因", "text", "10", "impawnNoReason", "true", "0");
        dbGrid.setField("文件发布时间", "text", "8", "file_date", "true", "0");
        dbGrid.setField("文件有效期限", "text", "8", "file_lastdate", "true", "0");

        dbGrid.setField("文件是否显示", "dropdown", "8", "isvisibled", "true", "BOOLTYPE");
        dbGrid.setField("放款形式", "dropdown", "8", "file_type", "true", "impawnLoanType");

        dbGrid.setWhereStr(" order by file_date desc ");
        dbGrid.setpagesize(17);
        dbGrid.setdataPilotID("datapilot");
        dbGrid.setbuttons("查看=query,添加=appendRecod,编辑=editRecord,删除=deleteRecord,moveFirst,prevPage,nextPage,moveLast");
  %>
  <body bgcolor="#ffffff" onload="body_resize()" onresize="body_resize();" class="Bodydefault">
    <fieldset>
      <legend>
        查询条件
      </legend>
      <table border="0" cellspacing="0" cellpadding="0" width="100%" >
        <form id="queryForm" name="queryForm">
          <input type="hidden" id="fileId" value="">
        <tr height="20">
          <td width="14%" align="right" nowrap="nowrap" class="lbl_right_padding">
            文件名称
          </td>
          <td align="right" nowrap="nowrap" class="data_input">
            
            <input type="text" id="file_name" class="ajax-suggestion url-getPull.jsp">
          </td>
          <td width="15%" align="right" nowrap="nowrap" class="lbl_right_padding">
          放款形式
          </td>
          <td width="20%" class="data_input">
            <%
                  ZtSelect zs = new ZtSelect("file_type", "impawnLoanType", "");
                  //ZtSelect zs = new ZtSelect("file_type", "");
                  //zs
                  //    .setSqlString("select a.loanType as value ,(select enuitemlabel from ptenudetail where enutype='loanType' and enuitemvalue=a.file_id) as text  from aic_file_userpower a where a.deptid='"
                  //        + deptId + "' order by file_id");
                  //zs.setSqlString("select ENUITEMVALUE as value ,ENUITEMLABEL as text  from PTENUDETAIL where enutype='QYLB'"
                  //+" and enuitemvalue not in('4','5')");
                  zs.addAttr("style", "width: 100%");

                  zs.addAttr("fieldtype", "text");
                  //zs.addAttr("isNull","false");
                  //zs.addAttr("onchange","fulx()");
                  //zs.addAttr("alertTitle","行业类型");
                  zs.addOption("", "");
                  zs.setDisplayAll(false);
                  out.print(zs);
            %>
          </td>
          <td width="14%" align="center" nowrap="nowrap">
            <input name="cbRetrieve" type="button" class="buttonGrooveDisable" id="button" onClick="cbRetrieve_Click(document.queryForm)" onMouseOver="button_onmouseover()"
              onMouseOut="button_onmouseout()" value="检索">
            <input name="Input" class="buttonGrooveDisable" type="reset" value="重填" onMouseOver="button_onmouseover()" onMouseOut="button_onmouseout()">
          </td>
        </tr>
        </form>
      </table>
    </fieldset>

    <fieldset>
      <legend>
        文件列表
      </legend>
      <table width="100%">
        <tr>
          <td>
            <%=dbGrid.getDBGrid()%>
          </td>
        </tr>
      </table>
    </fieldset>
    <FIELDSET>
      <LEGEND>
        操作
      </LEGEND>
      <table width="100%" class="title1">
        <tr>
          <td align="right">
            <%=dbGrid.getDataPilot()%>
          </td>
        </tr>
      </table>
    </FIELDSET>
    
    <div id="search-result-suggestions">
      <div id="search-results">
      </div>      
     </div>
    
  </body>
</html>
