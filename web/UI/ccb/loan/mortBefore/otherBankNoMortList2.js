var SQLStr;
var gWhereStr = "";

/**
 * ��ʼ��form����,
 * <p>
 * ����ʼ�����㶨λ�ڲ�ѯ������һ���ؼ���;
 * <p>
 * ��ÿ�β�ѯ��Ϻ󽹵��Զ���λ����һ���ؼ�����ȫѡ��
 *
 */
function body_resize() {
    divfd_loanRegistedTab.style.height = document.body.clientHeight - 200;
    loanRegistedTab.fdwidth = "1200";
    loanRegistedTab.actionname = "mort01";
    loanRegistedTab.delmethodname = "edit";
    initDBGrid("loanRegistedTab");
    // ��ʼ��ҳ�潹��
    body_init(queryForm, "cbRetrieve");
//    document.getElementById("proj_name").focus();
//    document.getElementById("proj_name").select();
}

/**
 * <p>
 * ������������������ɺ󽹵��Զ���λ�����������һ�������У� ����ȫѡ��;
 * <p>
 * ��ϵͳ��������������ĺ��ֻ���ƴ����ѯ ������ƴ����ѯ�ǡ�or���Ĺ�ϵ;
 * <p>
 * ��������ƴ����֧��ǰ��һ�¡����ģ����ѯ��
 * <p>
 * �����»س����Զ�֧�ֲ�ѯ��
 * </p>
 * ��ϵͳ��Ϊ1��ʱ��ϵͳ������0��ʱ��δ����
 * @param ��form���ֻ���ID
 */

function cbRetrieve_Click(formname) {
    // ����ϵͳ�����
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }

    if (checkForm(queryForm) == "false")
        return;
    var whereStr = "";
    /*if (trimStr(document.getElementById("proj_name").value) != "") {
        whereStr += " and c.proj_name like '" + trimStr(document.getElementById("proj_name").value) + "%'";
    }*/
    if (trimStr(document.getElementById("proj_no").value) != "") {
        whereStr += " and c.proj_no ='" + trimStr(document.getElementById("proj_no").value) + "'";
    }

    if (trimStr(document.getElementById("bankflag").value) != "") {
        whereStr += " and c.bankflag='" + document.getElementById("bankflag").value + "'";
    }
    if (trimStr(document.getElementById("bankid").value) != "") {
        whereStr += " and a.bankid in(select deptid from ptdept start with deptid='" + document.getElementById("bankid").value + "' connect by prior deptid=parentdeptid)";
    }

    whereStr += " order by b.mortecentercd, a.bankid, b.mortid ";
    document.all["loanRegistedTab"].whereStr = whereStr;

    /*
     whereStr += " order by a.cust_py asc";
     document.all["loanRegistedTab"].whereStr = whereStr;
     */
    document.all["loanRegistedTab"].RecordCount = "0";
    document.all["loanRegistedTab"].AbsolutePage = "1";
    // Table_Refresh in dbgrid.js pack
    Table_Refresh("loanRegistedTab", false, body_resize);
}

/**
 * �쿴��Ѻ��ϸ����
 *
 * @param mortid����Ѻ���
 * @param doType:select
 *          ��������
 */
function loanRegistedTab_query_click() {
    //����ϵͳ�����
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }

    var sfeature = "dialogwidth:800px; dialogheight:600px;center:yes;help:no;resizable:yes;scroll:yes;status:no";
    var tab = document.all["loanRegistedTab"];
    var trobj = tab.rows[tab.activeIndex];
    // ��Ѻ���
    var mortID = "";

    if (tab.rows.length <= 0) {
        alert(MSG_NORECORD);
        return;
    }

    if ((trobj.ValueStr != undefined) && (trobj.ValueStr != "")) {
        var tmp = trobj.ValueStr.split(";");
        mortID = tmp[5];

    }
    var arg = new Object();
    arg.doType = "select";
    dialog("/UI/ccb/loan/mortReg/mortgageEdit.jsp?mortID=" + mortID + "&doType=select", arg, sfeature);
}

/**
 * ˫�����񵯳���ϸ��Ϣ�鿴���� ���ò鿴����
 *
 * @return ��
 */
function loanRegistedTab_TRDbclick() {
    loanRegistedTab_query_click();
}

/**
 * �༭��Ѻ����ǰ ���п�����δ����Ѻ���Ͻ��ӱ�־
 *
 *         �����޸� batchedit
 * @param mortid:��Ѻ���
 */
function loanRegistedTab_batchEditRecord_click() {
    // ѡȡ���ݱ�־
    var checked = false;
    var tab = document.all.loanRegistedTab;
    for (var i = 0; i < tab.rows.length; i++) {
        if (tab.rows[i].cells[0].children[0] != undefined && tab.rows[i].cells[0].children[0].checked) {
            tab.rows[i].operate = "delete";
            checked = true;
            // ---
            // ����TD��recversion���ݵ���̨�Ա㲢�����ƣ�
            var _cell = document.createElement("td");
            _cell.setAttribute("fieldname", "recversion");
            // _cell.setAttribute("style","display:none");
            _cell.style.display = "none";
            _cell.setAttribute("fieldtype", "text");
            _cell.setAttribute("oldvalue", tab.rows[i].ValueStr.split(";")[11]);
            tab.rows[i].appendChild(_cell);
            // ---loanid
            _cell = document.createElement("td");
            _cell.setAttribute("fieldname", "loanid");
            // _cell.setAttribute("style","display:none");
            _cell.style.display = "none";
            _cell.setAttribute("fieldtype", "text");
            _cell.setAttribute("oldvalue", tab.rows[i].ValueStr.split(";")[2]);
            tab.rows[i].appendChild(_cell);
            // ---mortid
            _cell = document.createElement("td");
            _cell.setAttribute("fieldname", "mortid");
            // _cell.setAttribute("style","display:none");
            _cell.style.display = "none";
            _cell.setAttribute("fieldtype", "text");
            _cell.setAttribute("oldvalue", tab.rows[i].ValueStr.split(";")[5]);
            tab.rows[i].appendChild(_cell);
            /* // ---SENDFLAG
             _cell = document.createElement("td");
             _cell.setAttribute("fieldname", "SENDFLAG");
             // _cell.setAttribute("style","display:none");
             _cell.style.display = "none";
             _cell.setAttribute("fieldtype", "text");
             _cell.setAttribute("oldvalue", tab.rows[i].ValueStr.split(";")[7]);
             tab.rows[i].appendChild(_cell);*/
            // ---busiNode
            _cell = document.createElement("td");
            _cell.setAttribute("fieldname", "busiNode");
            // _cell.setAttribute("style","display:none");
            _cell.style.display = "none";
            _cell.setAttribute("fieldtype", "text");
            _cell.setAttribute("oldvalue", BUSINODE_030);
            tab.rows[i].appendChild(_cell);

        } else {
            tab.rows[i].operate = "";
        }
    }
    if (!checked) {
        alert(MSG_NORECORD);
        return;
    }
    var sfeature = "dialogwidth:560px; dialogheight:300px;center:yes;help:no;resizable:yes;scroll:yes;status:no";
    var arg = new Object();
    var rtn = dialog("otherBankNoMortBatchEdit.jsp", arg, sfeature);
    var rptnomortdt = "";
    var sendflag = "";
    if (rtn != undefined) {
        rptnomortdt = rtn.rptnomortdt;
        sendflag = rtn.sendflag;
    }
    if (rtn != undefined) {
        for (var i = 0; i < tab.rows.length; i++) {
            if (tab.rows[i].cells[0].children[0] != undefined && tab.rows[i].cells[0].children[0].checked) {
                var _cell = document.createElement("td");
                _cell.setAttribute("fieldname", "RPTNOMORTDATE");
                _cell.style.display = "none";
                _cell.setAttribute("fieldtype", "text");
                _cell.setAttribute("oldvalue", rptnomortdt);
                tab.rows[i].appendChild(_cell);
                var _cell = document.createElement("td");
                _cell.setAttribute("fieldname", "SENDFLAG");
                _cell.style.display = "none";
                _cell.setAttribute("fieldtype", "text");
                _cell.setAttribute("oldvalue", sendflag);
                tab.rows[i].appendChild(_cell);
            } else {
                tab.rows[i].operate = "";
            }
        }
        // �ύ��̨���������޸�
        var retxml = postGridRecord(tab);
        // analyzeReturnXML in dbutil.js pack
        if (retxml + "" == "true") {
            document.getElementById("loanRegistedTab").RecordCount = "0";
            Table_Refresh("loanRegistedTab", false, body_resize);
            window.returnValue = "1";
        }
    }

}

/**
 * �쿴������ϸ����
 *
 * @param loanID�������������
 * @param doType:select
 *          ��������
 */
function loanRegistedTab_loanQuery_click() {

    //����ϵͳ�����
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }

    var sfeature = "dialogwidth:800px; dialogheight:520px;center:yes;help:no;resizable:yes;scroll:yes;status:no";
    var tab = document.all["loanRegistedTab"];
    var trobj = tab.rows[tab.activeIndex];
    var nbxh = "";

    if (tab.rows.length <= 0) {
        alert(MSG_NORECORD);
        return;
    }

    if ((trobj.ValueStr != undefined) && (trobj.ValueStr != "")) {
        var tmp = trobj.ValueStr.split(";");
        nbxh = tmp[9];

    }
    var arg = new Object();
    arg.doType = "select";
    dialog("/UI/ccb/loan/loanMgr/loanEdit.jsp?nbxh=" + nbxh + "&doType=select", arg, sfeature);
}

//��ѯ��Ŀ���
function queryCoopProjNo(){
    //����ϵͳ�����
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }
    var sfeature = "dialogwidth:800px; dialogheight:600px;center:yes;help:no;resizable:yes;scroll:yes;status:no";
    var arg = new Object();
    arg.doType = "select";
    var projno = dialog("/UI/ccb/loan/common/coopprojQuery.jsp", arg, sfeature);
    //alert(projno);
    if (projno == undefined || projno == null)
       projno = "";
    document.getElementById("proj_no").value = projno;
}