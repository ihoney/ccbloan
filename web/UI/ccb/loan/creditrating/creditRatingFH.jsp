<!--
/*********************************************************************
* ��������: ������������
* �޸���: nanmeiying
* �޸�����: 2013/09/01
***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK" %>
<%@include file="/global.jsp" %>
<%@page import="pub.platform.db.DBGrid" %>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>�����������а�</title>
    <script language="javascript" src="creditRatingFH.js"></script>
    <script language="javascript" src="/UI/support/pub.js"></script>
    <script type="text/javascript">
        function checkDateEnd(input) {
            var ibdStr = document.getElementById("queryDateBeg").value;
            var iedStr = input.value;
            if (iedStr.length == 0) {
                return;
            }
            if (iedStr <= ibdStr) {
                alert("Ӧ���ڳ�ʼ���ڣ�");
                input.value = "";
                return;
            }
        }
    </script>
</head>
<%
    DBGrid dbGrid = new DBGrid();
    dbGrid.setGridID("creditraTable");
    dbGrid.setGridType("edit");
    String sql = "select a.creditratingno,a.custno,a.idno,a.custname,a.basescore,a.baselevel,a.iniscore,a.inilevel,a.iniamt,a.inioperid,a.inidate,a.inibegdate,a.inienddate,a.inideptid,a.finscore,a.finlevel,a.finamt,a.finoperid,a.findate,a.finbegdate,a.finenddate,a.findeptid,a.timelimit,b.validitytime,b.validitytimetwo,sysdate,a.docid from ln_pscoredetail a,ln_pcif b where a.idno = b.idno and b.recsta = '1' ";
    dbGrid.setfieldSQL(sql);
    dbGrid.setField("����������", "center", "9", "creditratingno", "true", "-1");
    dbGrid.setField("�ͻ���", "center", "9", "custno", "false", "-1");
    dbGrid.setField("֤������", "center", "8", "idno", "true", "0");
    dbGrid.setField("�ͻ�����", "text", "5", "custname", "true", "0");
    dbGrid.setField("�����÷�", "number", "5", "basescore", "true", "0");
    dbGrid.setField("�����ȼ�", "center", "5", "baselevel", "true", "0");
    dbGrid.setField("�����÷�", "number", "5", "iniscore", "true", "0");
    dbGrid.setField("�����ȼ�", "center", "5", "inilevel", "true", "0");
    dbGrid.setField("�������(��Ԫ)", "number", "6", "iniamt", "true", "0");
    dbGrid.setField("��������Ա", "center", "7", "inioperid", "true", "0");
    dbGrid.setField("��������", "center", "6", "inidate", "true", "0");
    dbGrid.setField("������Ч������", "center", "8", "inibegdate", "true", "0");
    dbGrid.setField("������Ч��ֹ��", "center", "8", "inienddate", "true", "0");
    dbGrid.setField("����������", "center", "6", "inideptid", "true", "0");
    dbGrid.setField("�����÷�", "number", "5", "finscore", "true", "0");
    dbGrid.setField("�����ȼ�", "center", "5", "finlevel", "true", "0");
    dbGrid.setField("�������(��Ԫ)", "number", "6", "finamt", "true", "0");
    dbGrid.setField("��������Ա", "center", "6", "finoperid", "true", "0");
    dbGrid.setField("��������", "center", "5", "findate", "true", "0");
    dbGrid.setField("������Ч������", "center", "8", "finbegdate", "true", "0");
    dbGrid.setField("������Ч��ֹ��", "center", "8", "finenddate", "true", "0");
    dbGrid.setField("����������", "center", "6", "findeptid", "true", "0");
    dbGrid.setField("����(��)", "number", "4", "timelimit", "true", "0");
    dbGrid.setField("��Ч����", "center", "18", "validitytime", "false", "0");
    dbGrid.setField("��Ч���ڶ�", "center", "18", "validitytimetwo", "false", "0");
    dbGrid.setField("��ǰ����", "center", "18", "sysdate", "false", "0");
    dbGrid.setField("������", "center", "9", "docid", "true", "0");
    dbGrid.setWhereStr(" order by inidate desc ");
    dbGrid.setpagesize(50);
    dbGrid.setdataPilotID("datapilot");
    dbGrid.setbuttons("����Excel=excel,��������=creditRating,moveFirst,prevPage,nextPage,moveLast");
%>
<body bgcolor="#ffffff" onLoad="body_resize()" onResize="body_resize();" class="Bodydefault">
<fieldset>
    <legend> ��ѯ����</legend>
    <table border="0" cellspacing="0" cellpadding="0" width="100%">
        <form id="queryForm" name="queryForm">
            <!-- ϵͳ��־��ʹ�� -->
            <input type="hidden" id="busiNode"/>
            <tr>
                <td width="20%" class="lbl_right_padding">����������</td>
                <td width="30%" align="right" nowrap="nowrap" class="data_input">
                    <input type="text" id="creditratingno" size="30" style="width:90% ">
                </td>
                <td width="20%" align="right" nowrap="nowrap" class="lbl_right_padding">֤������</td>
                <td width="30%" align="right" nowrap="nowrap" class="data_input">
                    <input type="text" id="idno" size="60" style="width:90% ">
                </td>
            </tr>
            <tr>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">�ͻ�����</td>
                <td width="30%" class="data_input">
                    <input type="text" id="custname" size="60" style="width:90% ">
                </td>
                <td width="20%" align="right" nowrap="nowrap" class="lbl_right_padding"> ����������</td>
                <td width="30%" class="data_input">
                    <input type="text" id="inideptid" size="60" value="" style="width:90% ">
                </td>
                <td width="10%" align="right" nowrap="nowrap">
                    <input name="cbRetrieve" type="button" class="buttonGrooveDisable" id="button"
                           onClick="queryClick();" onMouseOver="button_onmouseover()" onMouseOut="button_onmouseout()"
                           value="�� ��">
                </td>
            </tr>
            <tr>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">��������Ա</td>
                <td width="30%" class="data_input">
                    <input type="text" id="inioperid" size="60" style="width:90% ">
                </td>
                <td width="20%" nowrap="nowrap" class="lbl_right_padding">��������Ա</td>
                <td width="30%" class="data_input">
                    <input type="text" id="finoperid" size="60" style="width:90% ">
                </td>
                <td width="10%" align="right" nowrap="nowrap">
                    <input name="Input" class="buttonGrooveDisable" type="reset" value="�� ��"
                           onMouseOver="button_onmouseover()" onMouseOut="button_onmouseout()">
                </td>
            </tr>
            <tr>
                <td width="20%" class="lbl_right_padding">����������</td>
                <td width="30%" align="right" nowrap="nowrap" class="data_input">
                    <input type="text" id="queryDateBeg" onClick="WdatePicker()" size="30" style="width:90% ">
                </td>
                <td width="20%" align="right" nowrap="nowrap" class="lbl_right_padding">��������ֹ</td>
                <td width="30%" align="right" nowrap="nowrap" class="data_input">
                    <input type="text" id="queryDateEnd" onClick="WdatePicker()" onchange="checkDateEnd(this)" size="60"
                           style="width:90% ">
                </td>
            </tr>
        </form>
    </table>
</fieldset>
<fieldset>
    <legend> �ͻ���Ϣ</legend>
    <table width="100%">
        <tr>
            <td><%=dbGrid.getDBGrid()%>
            </td>
        </tr>
    </table>
</fieldset>
<FIELDSET>
    <LEGEND> ����</LEGEND>
    <table width="100%" class="title1">
        <tr>
            <td align="right"><%=dbGrid.getDataPilot()%>
            </td>
        </tr>
    </table>
</FIELDSET>
</body>
</html>