<!--
  /*********************************************************************
  *    功能描述: ODSB 读取数据前检查结果
  *    作    者:    
  *    开发日期:  2010/02/12
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
<%@page import="jxl.Cell"%>
<%@page import="jxl.format.Alignment"%>
<%@page import="jxl.format.Border"%>
<%@page import="jxl.format.VerticalAlignment"%>
<%@page import="jxl.format.BorderLineStyle"%>
<%@page import="pub.platform.db.DBUtil"%>

<%

OperatorManager omgr = (OperatorManager) session.getAttribute(SystemAttributeNames.USER_INFO_NAME);

//采用do while结构便于在主流程中监测错误发生后退出主程序；
try{
  do{
    // 输出报表
    response.reset();
    response.setContentType("application/vnd.ms-excel");
    response.addHeader("Content-Disposition", "attachment; filename=" + CcbLoanConst.RPT_ODSB_CHECK+".xls");
    // ----------------------------根据模板创建新workbook得到可操作的writableworkbook写到输出流中-----------------------------------
    //得到报表模板
    String rptModelPath = PropertyManager.getProperty("REPORT_ROOTPATH");
    String rptName = rptModelPath + CcbLoanConst.RPT_ODSB_CHECK+".xls";   
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
    //String targetFileName = CcbLoanConst.RPT_PAY_BILL_10+System.currentTimeMillis()+".xls";
    //String targetFile = PropertyManager.getProperty("cims")+"temp\\" + targetFileName;
    //File newFile = new File(targetFile);
    // 写到jsp中的输出流中
    WritableWorkbook wwb=Workbook.createWorkbook(response.getOutputStream(),rw,setting);
    // 得到第一个工作表
    WritableSheet ws = wwb.getSheet(0);
    
    // ----------------从数据库读取数据写入excel中-------------------------------------------------------------------------------- 
    
    DatabaseConnection conn = ConnectionManager.getInstance().get();  
    // 统计查询语句
    // 比较机构、金额、客户姓名
    RecordSet rs=conn.executeQuery(""
       +" select"
       +" a.loanid,"
       +" a.CUST_NAME,"
       +" a.RT_ORIG_LOAN_AMT,"
       +" (select  deptname from ptdept where deptid= a.bankid) bankid,"
       +" b.CUST_NAME odsb_cust_name,"
       +" b.RT_ORIG_LOAN_AMT odsb_amt,"
       +" (select deptname from ptdept where deptid= b.bankid) odsb_bankid "
       +" from LN_LOANAPPLY a"
       +" inner join ln_odsb_loanapply b on a.loanid = b.loanid"
       +" where a.NEEDADDCD='1' and (trim(a.cust_name) <> trim(b.cust_name)"
       +" or a.rt_orig_loan_amt <> b.rt_orig_loan_amt"
       +" or trim(a.bankid) <> trim(b.bankid))"
       +"  " );
    // 行计数器
    int i = 0;
    // 步长（每条记录输出1行）
    int step = 1;
    int cnt = i * step;
    // --------------字体样式--------------------
    // ---文字样式 居中对齐----    
    WritableFont NormalFont  =   new  WritableFont(WritableFont.COURIER,  11 ); 
    // 正常字体
    WritableCellFormat wcf_center  =   new  WritableCellFormat(NormalFont);   
	//  线条    
    wcf_center.setBorder(Border.ALL, BorderLineStyle.THIN);  
	//  垂直对齐    
    wcf_center.setVerticalAlignment(VerticalAlignment.CENTRE);  
  	//水平居中对齐
    wcf_center.setAlignment(Alignment.CENTRE);   
    wcf_center.setWrap( true );  //  是否换行   
    
    // ----数值样式 居右对齐---///统一改为居中对齐
    WritableCellFormat wcf_right = new WritableCellFormat(new WritableFont(WritableFont.COURIER,11,WritableFont.NO_BOLD,false));  
    // 边框样式
    wcf_right.setBorder(jxl.format.Border.ALL,jxl.format.BorderLineStyle.THIN); 
    // 折行
    wcf_right.setWrap(false);
    // 垂直对齐
    wcf_right.setVerticalAlignment(VerticalAlignment.CENTRE);
    // 水平对齐
    wcf_right.setAlignment(Alignment.RIGHT);
    // 行高
    int rowHeight = 500;
    // 开始行
    int beginRow = 4;
    // 开始列
    int beginCol = 1;
    while(rs.next()){
      cnt = i * step;
      if(i > 0){
        cnt = cnt -i;
      }
      
      String bankName = rs.getString("bankname");
   	  // 从第5行开始写数据
   	  //--------------------------第一行--------------------------------
   	  ws.setRowView(i+beginRow+cnt,rowHeight,false);
   	  // 抵押编号 	  
   	  Label lbl = new Label(beginCol,i+beginRow+cnt,rs.getString("loanid"),wcf_center);
      ws.addCell(lbl);    
      //--- 个贷抵押 ---
      // 贷款金额
      Number nLbl = new Number(beginCol+1,i+beginRow+cnt,rs.getDouble("RT_ORIG_LOAN_AMT"),wcf_right);
      ws.addCell(nLbl);
      // 客户名
      lbl = new Label(beginCol+2,i+beginRow+cnt,rs.getString("cust_name"),wcf_center);
      ws.addCell(lbl);
      // 机构
      lbl = new Label(beginCol+3,i+beginRow+cnt,rs.getString("bankid"),wcf_center);
      ws.addCell(lbl);
      
      //---ODSB---
      // 贷款金额
      nLbl = new Number(beginCol+4,i+beginRow+cnt,rs.getDouble("odsb_amt"),wcf_right);
      ws.addCell(nLbl);
      // 客户名
      lbl = new Label(beginCol+5,i+beginRow+cnt,rs.getString("odsb_cust_name"),wcf_center);
      ws.addCell(lbl);
      // 机构
      lbl = new Label(beginCol+6,i+beginRow+cnt,rs.getString("odsb_bankid"),wcf_center);
      ws.addCell(lbl);
      
      i++;
    }  
    
    // 释放数据库连接
    ConnectionManager.getInstance().release();
    
    //--------------------------------关闭excel操作------------------------------------------------------------------------
    // 关闭excel
    wwb.write();
    wwb.close(); 
    rw.close();
    
    //--------------------------------输出报表-----------------------------------------------------------------------------
    out.flush();
    out.close();
  }while(false);
}catch(Exception e){
  e.printStackTrace();
}
%>
