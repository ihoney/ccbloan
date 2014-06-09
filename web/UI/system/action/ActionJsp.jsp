<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/pages/security/online.jsp"%>
<%@ page import="pub.platform.db.*"%>
<html>
  <head>
    <title></title>
    <LINK href="/css/ccb.css" type="text/css" rel="stylesheet">
    <script language="javascript" src="/js/basic.js"></script>
    <script language="javascript" src="/js/xmlHttp.js"></script>
    <script language="javascript" src="/js/dbgrid.js"></script>
    <script language="javascript" src="/js/dropdownData.js"></script>
    <script language="javascript" src="/js/dbutil.js"></script>
    <script language="javascript" src="ActionJsp.js"></script>
    <script language="javascript" src="/js/menu.js"></script>
  </head>
  <%
        DBGrid dbGrid = new DBGrid();
        dbGrid.setGridID("ActionTable");
        //dbGrid.setGridTitleVisible(false);

        //dbGrid.setGridBottomVisible(false);

        dbGrid.setGridType("edit");
        dbGrid
            .setfieldSQL("select LogicCode as keycode, LogicCode,LogicClass,LogicMethod,LogicDesc from PTLogicAct where  (1=1) ");
        dbGrid.setenumType("-1,0,0,0,0");
        dbGrid.setvisible("false,true,true,true,true");
        dbGrid.setfieldcn("主健,功能标记,功能类,功能方法,功能描述");

        dbGrid.setfieldWidth("5,0,15,40,20,10");
        dbGrid.setfieldName("keycode,LogicCode,LogicClass,LogicMethod,LogicDesc");

        dbGrid.setfieldType("text,text,text,text,text");
        dbGrid.setfieldCheck(";isNull=false,textLength=6;isNull=false,textLength=200;textLength=50;textLength=200");
        dbGrid.setpagesize(18);
        dbGrid.setCheck(true);
        dbGrid.setWhereStr("  order by 1");

        //////数据集按钮
        dbGrid.setdataPilotID("datapilot");
        dbGrid.setbuttons("default");
  %>
  <body onload="body_load()" onresize="body_load()" class="Bodydefault">
    <fieldset>
      <legend>
        查询条件
      </legend>
      <table style=" width:100%" border="0" cellspacing="0" cellpadding="0">
        <form id="deptform">
        <tr height="20">
          <td width="80" class="lbl_right_padding">
            功能标记
          </td>
          <td width="80" class="data_input">
            <input id="cationid" type="text">
          </td>
          <td width="80" class="lbl_right_padding">
            功能类
          </td>
          <td width="60" class="data_input">
            <input id="actionclass" type="text">
          </td>
          <td width="80" class="lbl_right_padding">
            功能描述
          </td>
          <td width="80" class="data_input">
            <input id="actiondes" type="text">
          </td>
          <td>
            &nbsp;
          </td>
          <td>
            <input id="savebut" class="buttonGrooveDisable" onmouseover="button_onmouseover()" onmouseout="button_onmouseout()" type="button" value="查询" onclick="queryClick();">
            <input name="" class="buttonGrooveDisable" type="reset" value="重填" onmouseover="button_onmouseover()" onmouseout="button_onmouseout()">
          </td>
        </tr>
        </form>
      </table>
    </fieldset>
    <fieldset>
      <legend>
        会话列表
      </legend>
      <table width="100%">
        <tr>
          <td>
            <%=dbGrid.getDBGrid()%>
          </td>
        </tr>
      </table>
    </fieldset>
    <fieldset>
      <legend>
        操作
      </legend>
      <table width="100%" rules="border" class="title1">
        <tr>
          <td>
            <span id="title"></span>
          </td>
          <td align="right">
            <%=dbGrid.getDataPilot()%>
          </td>
        </tr>
      </table>
    </fieldset>
  </body>
</html>
