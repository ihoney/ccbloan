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
    divfd_loanTab.style.height = document.body.offsetHeight - 130;
    // divfd_loanTab.style.height = "350px";
    loanTab.fdwidth = "1700px";
    initDBGrid("loanTab");
    // 初始化页面焦点
    //body_init(queryForm, "cbRetrieve");
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

    var comSql = ""
            // 见证放款未办妥
            + " select b.MORTDATE,b.MORTID,"
            + " mortexpireDate,RELEASECONDCD,"
            + "(select enuitemlabel from ptenudetail where enutype='MORTECENTERCD' and enuitemvalue=b.MORTECENTERCD)as MORTECENTERCD,"
            + "(select enuitemlabel from ptenudetail where enutype='SENDFLAG' and enuitemvalue=b.SENDFLAG) as SENDFLAG,"
            + " (select deptname from ptdept where deptid=b.deptid) as deptname ";
    var comWhere = "" + " from ln_mortinfo b  where b.deptid in(select deptid from ptdept start with deptid='"
            + document.getElementById("deptid").value + "' connect by prior deptid=parentdeptid) ";

    var cautionType = document.getElementById("CAUTIONTYPE").value;
    var tempWhere2 = "";
    var tempWhere3 = "";
    var tempWhere4 = "";
    var sql2 = "";
    var sql3 = "";
    var sql4 = "";
    var totalSql = "";

    tempWhere2 = document.getElementById("tempWhere2").value + "and RELEASECONDCD in ('01')";
    tempWhere3 = document.getElementById("tempWhere3").value + "and RELEASECONDCD in ('02')";
    tempWhere4 = document.getElementById("tempWhere4").value + "and RELEASECONDCD in ('02')";
    sql2 = comSql + ",'见证放款未办妥' as cautionType " + comWhere + tempWhere2;
    sql3 = comSql + ",'见回执放款未回执' as cautionType " + comWhere + tempWhere3;
    sql4 = comSql + ",'见回执放款未回证' as cautionType " + comWhere + tempWhere4;

    if (cautionType == "") {
        totalSql = "select * from ((" + sql2 + ") union (" + sql3 + ") union (" + sql4
                + ")) order by cautionType,MORTEXPIREDATE,MORTDATE,MORTID ";
    }
    // 见证放款未办妥
    else if (cautionType == "3") {
        totalSql = sql2 + " order by cautionType,MORTEXPIREDATE,MORTDATE,MORTID  ";
    }
    // 见回执放款未回执
    else if (cautionType == "1") {
        totalSql = sql3 + " order by cautionType,MORTEXPIREDATE,MORTDATE,MORTID  ";
    }
    //见回执放款未回证
    else if (cautionType == "2") {
        totalSql = sql4 + " order by cautionType,MORTEXPIREDATE,MORTDATE,MORTID  ";
    }
    // whereStr += " order by mortid asc ";
    // document.all["loanTab"].whereStr = whereStr;
    document.all["loanTab"].SQLStr = totalSql;
    document.all["loanTab"].RecordCount = "0";
    document.all["loanTab"].AbsolutePage = "1";
    // Table_Refresh in dbgrid.js pack
    Table_Refresh("loanTab", false, body_resize);
}

/**
 * 
 * @return
 */
function loanTab_TRDbclick() {

}
