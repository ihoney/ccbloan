<%@ include file="/pages/security/online.jsp"%>
<%@ page contentType="text/html; charset=GBK" %>

<html >
<head>

	<title>

	</title>
		<LINK href="/css/ccb.css" type="text/css" rel="stylesheet">
		<script language="javascript" src="/js/basic.js"></script>
		<script language="javascript" src="/js/xmlHttp.js"></script>
		<script language="javascript" src="/js/dbutil.js"></script>
          <script language="javascript" src="/js/tree.js"></script>

		<script language="javascript" src="roleJsp.js"></script>

</head>
<BODY onload="changeheigth();onUserDocumentLoad();"  onresize="changeheigth()"  oncontextmenu="event.returnValue=false;" class="Bodydefault">
		<input type="hidden" id="paramValue" NAME="paramValue">

		<table style="WIDTH:100%;HEIGHT:10%;padding:3px" cellspacing="0" ID="Table1">
			<tr >
				<td colspan="2" class="borderGrooveB">
					<font face="SimSun" style="FONT-WEIGHT: bold; FONT-SIZE: 18pt"><img class="shadowAlpha" align="absMiddle" src="/images/frame/domain.gif" width="48" height="48">½ÇÉ«ÊÚÈ¨</font>
				</td>
			</tr>
		</table>
          <table style="WIDTH:100%;HEIGHT:90%;left:0px" cellspacing="0" ID="Table1">
			<tr>


				<td  class="borderGrooveBRL"  style="WIDTH:320px;" >
					<ul   id="rootUl" style="OVERFLOW:auto;WIDTH:100%;left:-30px;POSITION: absolute;top:12%" onmousemove = "tv_OnMouseMove()"	onmousedown = "tv_OnMouseDown()" onmouseup = "tv_OnMouseUp()"></ul>
				</td>

				<td  id="innerDocTD">
					<iframe bgcolor="#d4d0c8" id='frmContainer' src='/UI/system/blank.html' style="WIDTH: 100%; HEIGHT: 100%" frameborder='0' scrolling='auto'>
					</iframe>
				</td>
			</tr>
		</table>
	</BODY>
</html>
