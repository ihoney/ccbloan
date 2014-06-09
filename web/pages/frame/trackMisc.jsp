<%--
*******************************************************************
*    功能描述:    跟踪提醒综合页面
*    连接网页:    青岛市
*    传递参数:
*    作   者:
*    开发日期:    2003-05-29
*    修 改 人:
*    修改日期:
*    版   权:   	  leonwoo
*
*
*******************************************************************
--%>
<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="pub.platform.security.OperatorManager" %>
<%@page import="pub.platform.form.config.SystemAttributeNames" %>
<%@page import="pub.platform.db.DBGrid" %>
<%@page import="pub.platform.html.ZtSelect" %>
<%@page import="java.util.*" %>
<%@page import="pub.platform.db.RecordSet" %>
<%@page import="pub.platform.db.ConnectionManager" %>
<%@page import="pub.platform.db.DatabaseConnection" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="pub.platform.utils.BusinessDate" %>
<%@page import="pub.platform.db.DBUtil"%>
<%
    OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
    DatabaseConnection conn = ConnectionManager.getInstance().get();
    String cnt1 = "";
    double amt1 = 0;
    String cnt2 = "";
    double amt2 = 0;
    String cnt3 = "";
    double amt3 = 0;
    String cnt4 = "";
    double amt4 = 0;
    String cnt5 = "";
    double amt5 = 0;
    String cnt6 = "";
    double amt6 = 0;
    String cnt7 = "";
    String cnt8 = "";
    try {
        //----------------------------------------------- 见证放款未办妥提醒---------------------------------------------
        String comSql = ""
                // 见证放款未办妥提醒
                + " select count(*)cnt,sum(c.RT_ORIG_LOAN_AMT)amt ";
        String comWhere = ""
                + " from ln_mortinfo b left join ln_loanapply c on b.loanid=c.loanid "
                + " where c.bankid in(select deptid from ptdept start with deptid='" + omgr.getOperator().getDeptid() + "' connect by prior deptid=parentdeptid) "
				+ " and b.MORTSTATUS  in('10','20') ";
        
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = new GregorianCalendar();
        String currentDate = BusinessDate.getToday();
        int year = Integer.parseInt(currentDate.substring(0, 4));
        int month = Integer.parseInt(currentDate.substring(5, 7));
        int day = Integer.parseInt(currentDate.substring(8, 10));
        /*
        // 设置日期
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        // 当前日期+7 = 抵押到期日
        calendar.add(Calendar.DATE, 7);
        String tempDate1 = df.format(calendar.getTime());
        String tempWhere1 = " and b.MORTEXPIREDATE = '" + tempDate1 + "' and b.RELEASECONDCD in ('01')";
        String sql1 = comSql + comWhere + tempWhere1;
        RecordSet rs = conn.executeQuery(sql1);
        while (rs.next()) {
            cnt1 = rs.getString("cnt");
            amt1 = rs.getDouble("amt");
        }
        */
        //--------------------------------------------见证放款未办妥预警----------------------------------------------------
        // 当前日期大于等于抵押到期日→预警
        String tempWhere2 = " and b.MORTEXPIREDATE <='" + currentDate + "' and b.RELEASECONDCD in ('01','04')";
        String sql2 = comSql + comWhere + tempWhere2;
        RecordSet rs = conn.executeQuery(sql2);
        while (rs.next()) {
            cnt2 = rs.getString("cnt");
            amt2 = rs.getDouble("amt");
        }

        //--------------------------------------------- 见回执放款未回执预警-------------------------------------------------
        // 抵押接收日期 +5 <= 当天日期，进行见回执放款未回执 预警
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.add(Calendar.DATE, -5);
        String tempDate3 = df.format(calendar.getTime());
        String tempWhere3 = " and b.MORTDATE <= '" + tempDate3 + "' and b.RELEASECONDCD in ('02','05')";
        String sql3 = comSql + comWhere + tempWhere3;
        rs = conn.executeQuery(sql3);
        while (rs.next()) {
            cnt3 = rs.getString("cnt");
            amt3 = rs.getDouble("amt");
        }
        //--------------------------------------------- 见回执放款未回证预警-------------------------------------------------
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        // 当前日期 > = 抵押到期日
        String tempDate4 = df.format(calendar.getTime());
        String tempWhere4 = " and b.MORTEXPIREDATE <= '" + tempDate4 + "' and b.RELEASECONDCD in ('02','05')";
        String sql4 = comSql + comWhere + tempWhere4;
        rs = conn.executeQuery(sql4);
        while (rs.next()) {
            cnt4 = rs.getString("cnt");
            amt4 = rs.getDouble("amt");
        }
        //----------------------------------------------- 抵押超批复时限提醒---------------------------------------------
        comSql = ""
                + " select count(*)cnt,sum(RT_ORIG_LOAN_AMT) amt "
                + " from (select a.RT_ORIG_LOAN_AMT,"
				+ "       nvl(c.mortexpiredate, '2999-12-31') as overdate,"
                + "       c.mortstatus,a.bankid,a.LOANSTATE,c.RELEASECONDCD,c.NOMORTREASONCD "
                + "         from ln_loanapply a"
                + "         left join ln_coopproj b"
                + "           on a.proj_no = b.proj_no left join ln_mortinfo c on a.loanid=c.loanid)";
        comWhere = ""
                + " where bankid in(select deptid from ptdept start with deptid='" + omgr.getOperator().getDeptid() + "' connect by prior deptid=parentdeptid) "
                + " and MORTSTATUS  in('10','20') and LOANSTATE ='1' and RELEASECONDCD in ('03','06') "
                + " and NOMORTREASONCD not in('08', '17') ";
        // 抵押超批复日期-5天的日期 = 当前日期→提醒功能
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.add(Calendar.DATE, 5);
        String tempDate5 = df.format(calendar.getTime());
        String tempWhere5 = " and overdate <= '" + tempDate5 + "' and overdate > '" + currentDate + "'";
        String sql5 = comSql + comWhere + tempWhere5;
        rs = conn.executeQuery(sql5);
        while (rs.next()) {
            cnt5 = rs.getString("cnt");
            amt5 = rs.getDouble("amt");
        }
        //----------------------------------------------- 抵押超批复时限预警---------------------------------------------
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        // 当前日期>= 抵押超批复日期
        String tempDate6 = df.format(calendar.getTime());
        String tempWhere6 = " and overdate  <= '" + currentDate + "'";
        String sql6 = comSql + comWhere + tempWhere6;
        rs = conn.executeQuery(sql6);
        while (rs.next()) {
            cnt6 = rs.getString("cnt");
            amt6 = rs.getDouble("amt");
        }
        //----------------------------------------------- 被保证债券到期提醒---------------------------------------------
        ///UI/ccb/loan/trackWarn/coopprojWarnList.jsp?qrytype=assu&warntype=warn
        comSql = "select count(*) cnt "
                + " from ln_coopproj a  "
                + " where a.bankid in(select deptid from ptdept start with deptid='" + omgr.getOperator().getDeptid() + "' connect by prior deptid=parentdeptid) ";
        calendar.add(Calendar.MONTH, 1);
        String beginDate = df.format(calendar.getTime());
        String sqlwhere = comSql + " and a.assuenddate < '" + beginDate + "' and a.assuenddate > '" + currentDate + "'";
        rs = conn.executeQuery(sqlwhere);
        while (rs.next()) {
            cnt7 = rs.getString("cnt");
        }
        //----------------------------------------------- 被保证债券到期预警---------------------------------------------
        //----------------------------------------------- 他行开发贷到期提醒---------------------------------------------
        ///UI/ccb/loan/trackWarn/coopprojWarnList.jsp?qrytype=devloan&warntype=warn
        sqlwhere = comSql + " and a.bankflag = '2'  and a.devlnenddate < '" + beginDate + "' and a.devlnenddate > '" + currentDate + "'";
        rs = conn.executeQuery(sqlwhere);
        while (rs.next()) {
            cnt8 = rs.getString("cnt");
        }
        //----------------------------------------------- 他行开发贷到期预警---------------------------------------------
    } catch (Exception e) {

    } finally {
        // 释放数据库连接
        ConnectionManager.getInstance().release();
    }


%>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../../css/ccb.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
        /**
         * 数据钻取函数
         * @param pageID
         */
        function goDetail(pageID) {
            if (pageID == "1") {
                window.location.replace("/UI/ccb/loan/trackWarn/loanMortWarnList.jsp");
            } else if (pageID == "2") {
                window.location.replace("/UI/ccb/loan/trackWarn/loanMortCautionList.jsp");
            } else if (pageID == "3") {
                window.location.replace("/UI/ccb/loan/trackWarn/loanMortCautionList2.jsp");
            } else if (pageID == "4") {
                window.location.replace("/UI/ccb/loan/trackWarn/loanMortCautionList3.jsp");
            } else if (pageID == "5") {
                window.location.replace("/UI/ccb/loan/trackWarn/mortOverWarnList.jsp");
            } else if (pageID == "6") {
                window.location.replace("/UI/ccb/loan/trackWarn/mortOverCautionList.jsp");
            } else if (pageID == "7") {
                window.location.replace("/UI/ccb/loan/trackWarn/coopprojWarnList.jsp?qrytype=assu&warntype=warn");
            } else if (pageID == "8") {
                window.location.replace("/UI/ccb/loan/trackWarn/coopprojWarnList.jsp?qrytype=devloan&warntype=warn");
            }
        }
    </script>
</head>
<body style="margin:0px;padding:0px" class="Bodydefault">
<%--<br/>--%>
<div class="queryPanalDiv">
    <fieldset style="padding:20px 20px 20px 20px">
    <legend>抵押信息</legend>
    <br>
    <table align="center" width="100%" border="0">
        <tr valign="middle">
            <!--  <td width="5%" height="100">&nbsp;</td> -->
            <td valign="middle"><table align="center" width="100%" border="1">
                    <tr style="background-color: #CFDBEF;color:#0000AA;text-align:center;height: 28px">
                        <td width="50%" style="padding:5px">抵押办理事项</td>
                        <td width="20%" style="padding:5px">笔  数</td>
                        <td width="30%" style="padding:5px">金  额</td>
                    </tr>
                    <!-- 
                    <tr style="height: 25px">
                        <td style="text-align:left" style="padding:5px">见证放款未办妥提醒</td>
                        <td style="text-align:right" style="padding:5px"><a href="#" onClick="goDetail(1)"><%=cnt1 %> </a></td>
                        <td style="text-align:right" style="padding:5px"><%=DBUtil.doubleToStr1(amt1) %></td>
                    </tr>
                    -->
                    <tr style="height: 25px">
                        <td style="text-align:left" style="padding:5px">见证放款未办妥预警</td>
                        <td style="text-align:right" style="padding:5px"><a href="#" onClick="goDetail(2)"><%=cnt2 %> </a></td>
                        <td style="text-align:right" style="padding:5px"><%=DBUtil.doubleToStr1(amt2) %> </td>
                    </tr>
                    <tr style="height: 25px; background-color: #F6F6F6">
                        <td style="text-align:left" style="padding:5px">见回执放款未回执预警</td>
                        <td style="text-align:right" style="padding:5px"><a href="#" onClick="goDetail(3)"><%=cnt3 %> </a></td>
                        <td style="text-align:right" style="padding:5px"><%=DBUtil.doubleToStr1(amt3) %> </td>
                    </tr>
                    <tr style="height: 25px">
                        <td style="text-align:left" style="padding:5px">见回执放款未回证预警</td>
                        <td style="text-align:right" style="padding:5px"><a href="#" onClick="goDetail(4)"><%=cnt4 %></a></td>
                        <td style="text-align:right" style="padding:5px"><%=DBUtil.doubleToStr1(amt4) %> </td>
                    </tr>
                    <tr style="height: 25px; background-color: #F6F6F6">
                        <td style="text-align:left" style="padding:5px">签约放款超批复提醒</td>
                        <td style="text-align:right" style="padding:5px"><a href="#" onClick="goDetail(5)"><%=cnt5 %> </a></td>
                        <td style="text-align:right" style="padding:5px"><%=DBUtil.doubleToStr1(amt5) %> </td>
                    </tr>
                    <tr style="height: 25px">
                        <td style="text-align:left" style="padding:5px">签约放款超批复预警</td>
                        <td style="text-align:right" style="padding:5px"><a href="#" onClick="goDetail(6)"><%=cnt6 %> </a></td>
                        <td style="text-align:right" style="padding:5px"><%=DBUtil.doubleToStr1(amt6) %> </td>
                    </tr>
                </table></td>
        </tr>
    </table>
    </fieldset>
    <br/>
    <fieldset style="padding:20px 20px 20px 20px">
    <legend>合作项目信息</legend>
    <br>
    <table align="center" width="100%" border="0">
        <tr valign="middle">
            <td valign="middle"><table align="center" width="100%" border="1">
                    <tr style="background-color: #CFDBEF;color: #0000AA;text-align:center;height: 28px">
                        <td width="50%" style="padding:5px">合作项目事项</td>
                        <td width="50%" style="padding:5px">笔 数</td>
                    </tr>
                    <tr style="height: 25px">
                        <td style="text-align:left" style="padding:5px">被保证债权到期提醒</td>
                        <td style="text-align:right" style="padding:5px"><a href="#" onClick="goDetail(7)"><%=cnt7 %> </a></td>
                    </tr>
                    <tr style="height: 25px; background-color: #F6F6F6">
                        <td style="text-align:left" style="padding:5px">开发贷到期提醒</td>
                        <td style="text-align:right" style="padding:5px"><a href="#" onClick="goDetail(8)"><%=cnt8 %> </a></td>
                    </tr>
                </table></td>
        </tr>
    </table>
    </fieldset>
</div>
</body>
</html>
