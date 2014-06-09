<%@page contentType="text/html; charset=GBK" %>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>警告信息</title>
    <style type="text/css">
        <!--
        BODY {
            BORDER-BOTTOM: 0px;
            BORDER-LEFT: 0px;
            BORDER-RIGHT: 0px;
            BORDER-TOP: 0px;
            FONT-FAMILY: "宋体";
            FONT-SIZE: 14px;
            font-weight: bold;
            MARGIN: 0px;
            text-align: center;
            color: #404040;
        }

        img {
            border: 0px;
        }

        .errmain {
            width: 528px;
            height: 326px;
            margin: 100px auto;
        }

        .errhead {
            width: 528px;
            height: 29px;
            border: #bababa 1px solid;
            background: #eaf3fa;
            text-align: left;
            line-height: 29px;
        }

        .errbody {
            width: 526px;
            height: 200px;
            border: #bababa 1px solid;
            border-top-width: 0px;
        }

        .errlogo {
            width: 526px;
            height: 74px;
            text-align: left;
        }

        .errlogo img {
            margin-top: 15px;
            margin-left: 30px;
        }

        .errmsg {
            width: 526px;
            height: 75px;
            background: url(/images/ico_warn.jpg) no-repeat 30px 22px;
            line-height: 75px;
        }

        .errothermsg {
            width: 526px;
            height: 40px;
            line-height: 15px;
            text-align: left;
            font-size: 12px;
            font-weight: normal;
        }
        -->
    </style>

</head>
<body class="Bodydefault">

<div class="errmain">
    <div class="errhead">&nbsp;&nbsp;提示信息</div>
    <div class="errbody">
        <%--<div class="errlogo"><img src="/images/support.png"></a>--%>
        <%--</div>--%>
        <div class="errmsg"><p style="margin-left:80px;text-align:left;">本功能开放受限！</p></div>
        <div class="errothermsg">
            <p style="margin-left:82px;text-align:left;">客户经理认领功能目前只对以下机构开放：</p>
            <p style="margin-left:110px;text-align:left;">1：即墨支行。</p>
            <p style="margin-left:110px;text-align:left;">2：胶州支行。</p>
            <p style="margin-left:110px;text-align:left;">3：平度支行。</p>
            <p style="margin-left:110px;text-align:left;">4：莱西支行。</p>
            <br/>
        </div>
    </div>
</div>

</body>
</html>