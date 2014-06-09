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
  divfd_loanTab.style.height = document.body.offsetHeight-130;
  //divfd_loanTab.style.height = "350px";
  loanTab.fdwidth="2400px";
  initDBGrid("loanTab");
  // 初始化页面焦点
  body_init(queryForm, "cbRetrieve");
  //document.getElementById("MORTDATE").focus();
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
  //增加系统锁检查
  if(getSysLockStatus() == "1"){
    alert(MSG_SYSLOCK);
    return;
  }
  
  var comSql = ""
    // 见证放款未办妥
    +" select b.MORTDATE,b.MORTID,"
    +" mortexpireDate,RELEASECONDCD,"
    +"(select enuitemlabel from ptenudetail where enutype='MORTECENTERCD' and enuitemvalue=b.MORTECENTERCD)as MORTECENTERCD,"
    +"(select enuitemlabel from ptenudetail where enutype='SENDFLAG' and enuitemvalue=b.SENDFLAG) as SENDFLAG,"
    +" (select deptname from ptdept where deptid=b.deptid) as deptname ";
  var comWhere = ""  
    +" from ln_mortinfo b    "          
    +" where b.deptid in(select deptid from ptdept start with deptid='"+document.getElementById("deptid").value+"' connect by prior deptid=parentdeptid) ";
  
  var releaseCD = document.getElementById("RELEASECONDCD").value;
  var tempWhere1 = "";
  var tempWhere4 = "";
  var sql1 = "";
  var sql4 = "";
  var totalSql = "";
  
  if(releaseCD == ""){
    tempWhere1 = document.getElementById("tempWhere1").value + "and RELEASECONDCD in ('01')"; 
    tempWhere4 = document.getElementById("tempWhere4").value + "and RELEASECONDCD in ('02')";
    sql1 = comSql + comWhere + tempWhere1;
    sql4 = comSql + comWhere + tempWhere4;
    totalSql = "select * from (("+sql1+") union ("+ sql4 +")) order by RELEASECONDCD,MORTEXPIREDATE ";
  }
  // 见证放款
  else if(releaseCD == "01"){
    tempWhere1 = document.getElementById("tempWhere1").value + " and RELEASECONDCD = '01'"; 
    sql1 = comSql + comWhere + tempWhere1;
    totalSql = sql1 + " order by RELEASECONDCD,MORTEXPIREDATE ";
  }
  // 见回执放款
  else if(releaseCD == "02"){
    tempWhere4 = document.getElementById("tempWhere4").value + " and RELEASECONDCD = '02'";
    sql4 = comSql + comWhere + tempWhere4;
    totalSql = sql4 + " order by RELEASECONDCD,MORTEXPIREDATE ";
  }
  
  //whereStr += " order by mortid asc ";
  //document.all["loanTab"].whereStr = whereStr;
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
function loanTab_TRDbclick(){
  
}

