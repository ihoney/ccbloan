var SQLStr;
var gWhereStr = "";

/**
 * 初始化form函数,
 * <p>
 * ■初始化焦点定位在查询条件第一个控件上;
 * <p>
 * ■每次查询完毕后焦点自动定位到第一个控件，且全选；
 * 
 */
function body_resize() {
    divfd_loanTab.style.height = document.body.offsetHeight - 200;
    // divfd_loanTab.style.height = "350px";
    loanTab.fdwidth = "4800px";
    initDBGrid("loanTab");
    // 初始化页面焦点
    body_init(queryForm, "cbRetrieve");
    // document.getElementById("MORTDATE").focus();
}

/**
 * <p>
 * ■检索函数，检索完成后焦点自动定位到检索区域第一个条件中， 并且全选中;
 * <p>
 * ■系统根据姓名处输入的汉字或者拼音查询 汉字与拼音查询是“or”的关系;
 * <p>
 * ■汉字与拼音都支持前端一致、后端模糊查询；
 * <p>
 * ■按下回车键自动支持查询；
 * </p>
 * 
 * @param ：form名字或者ID
 */

function cbRetrieve_Click(formname) {
    // 增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }

    if (checkForm(queryForm) == "false")
        return;
    var whereStr = "";
    // 抵押接收日期
    if (trimStr(document.getElementById("MORTDATE").value) != "") {
        whereStr += " and b.MORTDATE >='" + trimStr(document.getElementById("MORTDATE").value) + "'";
    }
    if (trimStr(document.getElementById("MORTDATE2").value) != "") {
        whereStr += " and b.MORTDATE <='" + trimStr(document.getElementById("MORTDATE2").value) + "'";
    }
    // 放款方式
    if (trimStr(document.getElementById("RELEASECONDCD").value) != "") {
        whereStr += " and b.RELEASECONDCD ='" + trimStr(document.getElementById("RELEASECONDCD").value) + "'";
    }
    // 贷款清退原因
    if (trimStr(document.getElementById("CLRREASONCD").value) != "") {
        whereStr += " and b.CLRREASONCD ='" + trimStr(document.getElementById("CLRREASONCD").value) + "'";
    }
    // 抵押登记状态
    if (trimStr(document.getElementById("MORTREGSTATUS").value) != "") {
        whereStr += " and b.MORTREGSTATUS ='" + trimStr(document.getElementById("MORTREGSTATUS").value) + "'";
    }

    // 是否已登记未办理抵押原因
    // 有抵押原因
    if (trimStr(document.getElementById("NOMORTREASONCD").value) == "1") {
        whereStr += " and trim(b.NOMORTREASONCD) is not null ";
    }
    // 无抵押原因
    else if (trimStr(document.getElementById("NOMORTREASONCD").value) == "0") {
        whereStr += " and trim(b.NOMORTREASONCD) is  null ";
    }

/*

    //20100403 zhan
    // 有抵押原因     (枚举“抵押中”：14   需特殊处理)
    if (trimStr(document.getElementById("NOMORTREASONCD").value) == "1") {
        whereStr += " and trim(b.NOMORTREASONCD) is not null and trim(b.NOMORTREASONCD) <>'14' ";
    }
    // 无抵押原因
    else if (trimStr(document.getElementById("NOMORTREASONCD").value) == "0") {
        whereStr += " and (trim(b.NOMORTREASONCD) is  null  or trim(b.NOMORTREASONCD) = '14') ";
    }

*/

    // 借证原因
    if (trimStr(document.getElementById("CHGPAPERREASONCD").value) != "") {
        whereStr += " and b.CHGPAPERREASONCD ='" + trimStr(document.getElementById("CHGPAPERREASONCD").value) + "'";
    }
    // 经办行id
    if (trimStr(document.getElementById("bankid").value) != "") {
        whereStr += " and a.bankid in(select deptid from ptdept start with deptid='"+document.getElementById("bankid").value+"' connect by prior deptid=parentdeptid)";
    }
    // 合作项目简称
    if (trimStr(document.getElementById("PROJ_NAME_ABBR").value) != "") {
        whereStr += " and c.PROJ_NAME_ABBR like '%" + trimStr(document.getElementById("PROJ_NAME_ABBR").value) + "%'";
    }
    // 合作方名称
    if (trimStr(document.getElementById("CORPNAME").value) != "") {
        whereStr += " and c.CORPNAME like '%" + trimStr(document.getElementById("CORPNAME").value) + "%'";
    }
    // 取得回执日期起
    // 取得回执日期
    if (trimStr(document.getElementById("RECEIPTDATE").value) != "") {
        whereStr += " and b.RECEIPTDATE >='" + trimStr(document.getElementById("RECEIPTDATE").value) + "'";
    }
    if (trimStr(document.getElementById("RECEIPTDATE2").value) != "") {
        whereStr += " and b.RECEIPTDATE <='" + trimStr(document.getElementById("RECEIPTDATE2").value) + "'";
    }
    // 抵押超批复日期起
    if (trimStr(document.getElementById("MORTOVERRTNDATE").value) != "") {
        whereStr += " and b.MORTOVERRTNDATE >='" + trimStr(document.getElementById("MORTOVERRTNDATE").value) + "'";
    }
    if (trimStr(document.getElementById("MORTOVERRTNDATE2").value) != "") {
        whereStr += " and b.MORTOVERRTNDATE <='" + trimStr(document.getElementById("MORTOVERRTNDATE2").value) + "'";
    }
    // 他行开发贷是否可报抵押
    if (trimStr(document.getElementById("SENDFLAG").value) != "") {
        whereStr += " and b.SENDFLAG ='" + trimStr(document.getElementById("SENDFLAG").value) + "'";
    }
    if (trimStr(document.getElementById("bankflag").value) != "") {
        whereStr += " and c.bankflag='" + document.getElementById("bankflag").value + "'";
    }
    // 入库日期
    if (trimStr(document.getElementById("PAPERRTNDATE").value) != "") {
        whereStr += " and b.PAPERRTNDATE >='" + trimStr(document.getElementById("PAPERRTNDATE").value) + "'";
    }
    if (trimStr(document.getElementById("PAPERRTNDATE2").value) != "") {
        whereStr += " and b.PAPERRTNDATE <='" + trimStr(document.getElementById("PAPERRTNDATE2").value) + "'";
    }
    // 结清取证日期起
    if (trimStr(document.getElementById("CLRPAPERDATE").value) != "") {
        whereStr += " and b.CLRPAPERDATE >='" + trimStr(document.getElementById("CLRPAPERDATE").value) + "'";
    }
    if (trimStr(document.getElementById("CLRPAPERDATE2").value) != "") {
        whereStr += " and b.CLRPAPERDATE <='" + trimStr(document.getElementById("CLRPAPERDATE2").value) + "'";
    }
    // 借证领用日期起
    if (trimStr(document.getElementById("CHGPAPERDATE").value) != "") {
        whereStr += " and b.CHGPAPERDATE >='" + trimStr(document.getElementById("CHGPAPERDATE").value) + "'";
    }
    if (trimStr(document.getElementById("CHGPAPERDATE2").value) != "") {
        whereStr += " and b.CHGPAPERDATE <='" + trimStr(document.getElementById("CHGPAPERDATE2").value) + "'";
    }
    // 借证归还日期起
    if (trimStr(document.getElementById("CHGPAPERRTNDATE").value) != "") {
        whereStr += " and b.CHGPAPERRTNDATE >='" + trimStr(document.getElementById("CHGPAPERRTNDATE").value) + "'";
    }
    if (trimStr(document.getElementById("CHGPAPERRTNDATE2").value) != "") {
        whereStr += " and b.CHGPAPERRTNDATE <='" + trimStr(document.getElementById("CHGPAPERRTNDATE2").value) + "'";
    }
    // 快递发出日期起
    if (trimStr(document.getElementById("EXPRESSENDSDATE").value) != "") {
        whereStr += " and b.EXPRESSENDSDATE >='" + trimStr(document.getElementById("EXPRESSENDSDATE").value) + "'";
    }
    if (trimStr(document.getElementById("EXPRESSENDSDATE2").value) != "") {
        whereStr += " and b.EXPRESSENDSDATE <='" + trimStr(document.getElementById("EXPRESSENDSDATE2").value) + "'";
    }
    // 快递回证日期起
    if (trimStr(document.getElementById("EXPRESSRTNDATE").value) != "") {
        whereStr += " and b.EXPRESSRTNDATE >='" + trimStr(document.getElementById("EXPRESSRTNDATE").value) + "'";
    }
    if (trimStr(document.getElementById("EXPRESSRTNDATE2").value) != "") {
        whereStr += " and b.EXPRESSRTNDATE <='" + trimStr(document.getElementById("EXPRESSRTNDATE2").value) + "'";
    }

    // 快递资料签收日期 2013-04-01 linyong
    if (trimStr(document.getElementById("EXP_DATA_SIGNIN_DATE").value) != "") {
        whereStr += " and b.EXP_DATA_SIGNIN_DATE >='" + trimStr(document.getElementById("EXP_DATA_SIGNIN_DATE").value) + "'";
    }
    if (trimStr(document.getElementById("EXP_DATA_SIGNIN_DATE2").value) != "") {
        whereStr += " and b.EXP_DATA_SIGNIN_DATE <='" + trimStr(document.getElementById("EXP_DATA_SIGNIN_DATE2").value) + "'";
    }
    // 快递权证签收日期 2013-04-01 linyong
    if (trimStr(document.getElementById("EXP_PAPER_SIGNIN_DATE").value) != "") {
        whereStr += " and b.EXP_PAPER_SIGNIN_DATE >='" + trimStr(document.getElementById("EXP_PAPER_SIGNIN_DATE").value) + "'";
    }
    if (trimStr(document.getElementById("EXP_PAPER_SIGNIN_DATE2").value) != "") {
        whereStr += " and b.EXP_PAPER_SIGNIN_DATE <='" + trimStr(document.getElementById("EXP_PAPER_SIGNIN_DATE2").value) + "'";
    }

    // 他行开发贷未报抵押日期起

    if (trimStr(document.getElementById("RPTNOMORTDATE").value) != "") {
        whereStr += " and b.RPTNOMORTDATE >='" + trimStr(document.getElementById("RPTNOMORTDATE").value) + "'";
    }
    if (trimStr(document.getElementById("RPTNOMORTDATE2").value) != "") {
        whereStr += " and b.RPTNOMORTDATE <='" + trimStr(document.getElementById("RPTNOMORTDATE2").value) + "'";
    }
    // 他行开发贷可报抵押日期起
    if (trimStr(document.getElementById("RPTMORTDATE").value) != "") {
        whereStr += " and b.RPTMORTDATE >='" + trimStr(document.getElementById("RPTMORTDATE").value) + "'";
    }
    if (trimStr(document.getElementById("RPTMORTDATE2").value) != "") {
        whereStr += " and b.RPTMORTDATE <='" + trimStr(document.getElementById("RPTMORTDATE2").value) + "'";
    }
    if (trimStr(document.getElementById("BOXID").value) != "") {
        whereStr += " and b.BOXID ='" + trimStr(document.getElementById("BOXID").value) + "'";
    }

    //抵押流程状态 mortstatus
    if (trimStr(document.getElementById("MORTSTATUS1").value) != "") {
        whereStr += " and b.MORTSTATUS >='" + trimStr(document.getElementById("MORTSTATUS1").value) + "'";
    }
    if (trimStr(document.getElementById("MORTSTATUS2").value) != "") {
        whereStr += " and b.MORTSTATUS <='" + trimStr(document.getElementById("MORTSTATUS2").value) + "'";
    }
    // 贷款清退原因
    if (trimStr(document.getElementById("CLRREASONCD").value) != "") {
        whereStr += " and b.CLRREASONCD ='" + trimStr(document.getElementById("CLRREASONCD").value) + "'";
    }
    // 特殊事项是否处理完毕 zhanrui 20121105  注意此字段存在null值得情况
    if (trimStr(document.getElementById("SPECIALBIZOVERFLAG").value) == "1") {
        whereStr += " and b.SPECIALBIZOVERFLAG ='" + trimStr(document.getElementById("SPECIALBIZOVERFLAG").value) + "'";
    }

    // 交易中心
    if (trimStr(document.getElementById("MORTECENTERCD").value) != "") {
        whereStr += " and b.MORTECENTERCD ='" + trimStr(document.getElementById("MORTECENTERCD").value) + "'";
    }


    whereStr += " order by b.mortecentercd,a.bankid,a.cust_name   ";

    document.all["loanTab"].whereStr = whereStr;
    document.all["loanTab"].RecordCount = "0";
    document.all["loanTab"].AbsolutePage = "1";
    // Table_Refresh in dbgrid.js pack
    Table_Refresh("loanTab", false, body_resize);
}

/**
 * report
 */
function loanTab_expExcel_click() {

    // 增加系统锁检查
    if (getSysLockStatus() == "1") {
        alert(MSG_SYSLOCK);
        return;
    }
    document.getElementById("queryForm").target = "_blank";
    document.getElementById("queryForm").action = "basicReport.jsp";
    document.getElementById("queryForm").submit();
}