<!--
  /*********************************************************************
  *    功能描述: 权证库存统计
  *    作    者:    
  *    开发日期:  2010/02/03
  *    修 改 人:
  *    修改日期:
  *    版    权:    
  ***********************************************************************/
-->
<%@page contentType="text/html; charset=GBK"%>
<%@page import="pub.platform.db.ConnectionManager"%>
<%@page import="pub.platform.db.DatabaseConnection"%>
<%@page import="pub.platform.db.RecordSet"%>
<%@page import="pub.platform.utils.Basic"%>
<%@page import="com.ccb.util.*"%>
<%@page import="java.io.File"%>
<%@page import="pub.platform.advance.utils.PropertyManager"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="jxl.Workbook"%>
<%@page import="jxl.write.WritableWorkbook"%>
<%@page import="java.io.OutputStream"%>
<%@page import="jxl.write.Label"%>
<%@page import="jxl.write.WritableSheet"%>
<%@page import="jxl.write.Number"%>
<%@page import="jxl.write.WritableCellFormat"%>
<%@page import="jxl.write.WritableFont"%>
<%@page import="jxl.WorkbookSettings"%>
<%@page import="java.util.Locale"%>
<%@page import="pub.platform.security.OperatorManager"%>
<%@page import="pub.platform.form.config.SystemAttributeNames"%>
<%@page import="jxl.format.Border"%>
<%@page import="jxl.format.BorderLineStyle"%>
<%@page import="jxl.format.Alignment"%>
<%@page import="jxl.format.VerticalAlignment"%>
<%

OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);
//采用do while结构便于在主流程中监测错误发生后退出主程序；
try{
  do{
    // 输出报表
    response.reset();
    response.setContentType("application/vnd.ms-excel");
    response.addHeader("Content-Disposition", "attachment; filename=" + CcbLoanConst.MISC_RPT_PAPER_STAT+".xls");
    // ----------------------------根据模板创建输出流----------------------------------------------------------------
    //得到报表模板
    String rptModelPath = PropertyManager.getProperty("REPORT_ROOTPATH");
    String rptName = rptModelPath + CcbLoanConst.MISC_RPT_PAPER_STAT+".xls";   
    File file = new File(rptName);
    // 判断模板是否存在,不存在则退出
    if(!file.exists()){
      out.println(rptName+PropertyManager.getProperty("304"));
      break;
    } 
    WorkbookSettings setting = new WorkbookSettings();
    Locale locale = new Locale("zh","CN");
    setting.setLocale(locale);
    setting.setEncoding("ISO-8859-1");
    // 得到excel的sheet
    File fileInput = new File(rptName);
    Workbook rw=Workbook.getWorkbook(fileInput,setting);
    WritableWorkbook wwb=Workbook.createWorkbook(response.getOutputStream(),rw,setting);
    // 得到第一个工作表
    WritableSheet ws = wwb.getSheet(0);
    
    // ----------------从数据库读取数据写入excel中-------------------------------------------------------------------------------- 
    // 查询字符串
    String date = request.getParameter("MORTEXPIREDATE");
    String bankid = "";
    if(request.getParameter("bankid") != null){
        bankid = request.getParameter("bankid");
    }
    DatabaseConnection conn = ConnectionManager.getInstance().get();  
    
    String prefixSQL = " "
      +" select (select deptname from ptdept where deptid=t.deptid)as deptname,t.deptid,"
      +" sum((CASE"
      +"      WHEN t.PAPERRTNDATE <= '"+date+"' AND trim(t.PAPERRTNDATE) IS NOT NULL THEN"
      +"       1"
      +"      ELSE"
      +"       0"
      +"    END)) as paperRtn,"
      +" sum((CASE"
      +"      WHEN t.CLRPAPERDATE <= '"+date+"' AND trim(t.CLRPAPERDATE) IS NOT NULL THEN"
      +"       1"
      +"      ELSE"
      +"       0"
      +"    END)) as clsPaper,"
      +" sum((CASE"
      +"      WHEN t.CHGPAPERDATE <= '"+date+"' AND trim(t.CHGPAPERDATE) IS NOT NULL THEN"
      +"       1"
      +"      ELSE"
      +"       0"
      +"    END)) as chgPaper,"
      +" sum((CASE"
      +"      WHEN t.CHGPAPERRTNDATE <= '"+date+"' AND trim(t.CHGPAPERRTNDATE) IS NOT NULL THEN"
      +"       1"
      +"      ELSE"
      +"       0"
      +"    END)) as chgPaperRtn"
      +" FROM ln_mortinfo t"
      +" where t.deptid in(select deptid from ptdept start with deptid='"+bankid+"' connect by prior deptid=parentdeptid) "
      +" group by t.deptid ";
    
    
    // 模糊查询匹配规则：前端一致
    RecordSet rs=conn.executeQuery(prefixSQL);
    // 输出记录笔数
    int i = 0;
    // 行高 
    int rowHeight = 500;
    // 行笔数合计(库存)
    int lagerCnt = 0;
    // 列笔数合计
    int totalCnt01 = 0;
    int totalCnt02 = 0;
    int totalCnt03 = 0;
    int totalCnt04 = 0;
    int totalLager = 0;
    
    // 单元格设置格式：边框
    WritableCellFormat wcf_center = new WritableCellFormat(new WritableFont(WritableFont.COURIER,11,WritableFont.NO_BOLD,false));   
    wcf_center.setBorder(Border.ALL,BorderLineStyle.THIN);
    // 居中对齐
    wcf_center.setAlignment(Alignment.CENTRE);
    wcf_center.setVerticalAlignment(VerticalAlignment.CENTRE);
    
    // 居右对齐
    WritableCellFormat wcf_right = new WritableCellFormat(new WritableFont(WritableFont.COURIER,11,WritableFont.NO_BOLD,false));   
    wcf_right.setBorder(Border.ALL,BorderLineStyle.THIN);
    // 居中对齐
    wcf_right.setAlignment(Alignment.RIGHT);
    wcf_right.setVerticalAlignment(VerticalAlignment.CENTRE);
    
    // 开始行
    int beginRow = 2;
    // 开始列
    int beginCol = 1;
    while(rs.next()){
      // 行合计清零初始化
      lagerCnt = 0;
      // 从第3行开始写数据
      // 设置行高
      ws.setRowView(i+beginRow,rowHeight,false);
      // 机构
      Label lbl  = new Label(beginCol+0,i+beginRow,rs.getString("deptname"),wcf_center);
      ws.addCell(lbl);
      // 日期
      lbl = new Label(beginCol+1,i+beginRow,date,wcf_center);
      ws.addCell(lbl);      
      // 回证
      Number label  = new Number(beginCol+2,i+beginRow,rs.getInt("paperRtn"),wcf_right);
      ws.addCell(label);
      lagerCnt += rs.getInt("paperRtn");
      totalCnt01 += rs.getInt("paperRtn");
      // 结清取证
      label  = new Number(beginCol+3,i+beginRow,rs.getInt("clsPaper"),wcf_right);
      ws.addCell(label);      
      lagerCnt -= rs.getInt("clsPaper");
      totalCnt02 += rs.getInt("clsPaper");
      // 借证领用
      label  = new Number(beginCol+4,i+beginRow,rs.getInt("chgPaper"),wcf_right);
      ws.addCell(label);
      lagerCnt -= rs.getInt("chgPaper");
      totalCnt03 += rs.getInt("chgPaper");
      // 借证归还
      label  = new Number(beginCol+5,i+beginRow,rs.getInt("chgPaperRtn"),wcf_right);
      ws.addCell(label);
      lagerCnt += rs.getInt("chgPaperRtn");
      totalCnt04 += rs.getInt("chgPaperRtn");
      
      label  = new Number(beginCol+6,i+beginRow,lagerCnt,wcf_right);
      ws.addCell(label);
      totalLager += lagerCnt;
      
      // 行计数器加1
      i++;
    }  
    //------------------------- 输出合计行--------------------------------------------------------------------------------
    // 居中对齐
    wcf_center = new WritableCellFormat(new WritableFont(WritableFont.COURIER,11,WritableFont.BOLD,false));
    wcf_center.setBorder(Border.ALL,BorderLineStyle.THIN);
    wcf_center.setAlignment(Alignment.CENTRE);
    wcf_center.setVerticalAlignment(VerticalAlignment.CENTRE);
    // 居右对齐
    wcf_right = new WritableCellFormat(new WritableFont(WritableFont.COURIER,11,WritableFont.BOLD,false));   
    wcf_right.setBorder(Border.ALL,BorderLineStyle.THIN);
    // 居中对齐
    wcf_right.setAlignment(Alignment.RIGHT);
    wcf_right.setVerticalAlignment(VerticalAlignment.CENTRE);
    // 设置行高
    ws.setRowView(i+beginRow,rowHeight,false);
    // 日期
    Label lbl = new Label(beginCol+0,i+beginRow,"合计",wcf_center);
    ws.addCell(lbl);
    // 空格
    lbl = new Label(beginCol+1,i+beginRow,"",wcf_center);
    ws.addCell(lbl);
    // 回证
    Number label  = new Number(beginCol+2,i+beginRow,totalCnt01,wcf_right);
    ws.addCell(label);
    // 结清取证
    label  = new Number(beginCol+3,i+beginRow,totalCnt02,wcf_right);
    ws.addCell(label);      
    // 借证领用
    label  = new Number(beginCol+4,i+beginRow,totalCnt03,wcf_right);
    ws.addCell(label);
    // 借证归还
    label  = new Number(beginCol+5,i+beginRow,totalCnt04,wcf_right);
    ws.addCell(label);
    // 库存
    label  = new Number(beginCol+6,i+beginRow,totalLager,wcf_right);
    ws.addCell(label);
    // -------------------------------------------合计输出结束-------------------------------------------------------------    
    //--------------------------------关闭excel操作------------------------------------------------------------------------
    // 关闭excel
    wwb.write();
    wwb.close(); 
    rw.close();
    
    //--------------------------------输出报表-----------------------------------------------------------------------------
    // 输出报表
    out.flush();
    out.close();
  }while(false);
}catch(Exception e){
  e.printStackTrace();
} finally {
    // 释放数据库连接
    ConnectionManager.getInstance().release();
}
%>
