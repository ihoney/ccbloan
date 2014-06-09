package com.ccb;


import com.ccb.dao.LNUNCOMCREDIT;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import pub.platform.form.control.Action;
import pub.platform.utils.StringUtils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2010-6-23
 * Time: 16:53:25
 * To change this template use File | Settings | File Templates.
 */
public class ReadExcel extends Action {
    public static void main(String[] args) {
        String ss = "F:\\中心评信数据初始化表2.xls";
        getData(ss);
    }


    public static String getData(String path) {


        try {
            LNUNCOMCREDIT lnuncomcredit = new LNUNCOMCREDIT();
            InputStream input = new FileInputStream(path);
            POIFSFileSystem fs = new POIFSFileSystem(input);
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            int rowLen = sheet.getLastRowNum();
            HSSFCell cell0 = null;              //流水号
            HSSFCell cell1 = null;              //经办行ID
            HSSFCell cell2 = null;              //姓名
            HSSFCell cell3 = null;              //证件类型
            HSSFCell cell4 = null;              //证件号码
            HSSFCell cell5 = null;              //评信方式
            HSSFCell cell6 = null;              //评信等级
            HSSFCell cell7 = null;              //有效起始日期
            HSSFCell cell8 = null;              //有效截止日期
            HSSFCell cell9 = null;              //期限
            HSSFCell cell10 = null;              //评信金额

            int myseq = 0;


            //数据插入
            for (int i = 1; i <= rowLen; i++) {

                String creditratingno = "";
                String custname = "";
                String idtype = "";
                String idno = "";
                String birthday = "";
                String sex = "";
                int age = 0;
                String judgetype = "";
                String judgelevel = "";
                String judgeoperid = "tiankun.qd";
                String judgedate = "2013-11-20";
                String begdate = "";
                String enddate = "";
                String judgedeptid = "";
                int judgeprice = 0;
                String timelimit = "";
                int seqnum = 0;
                String docid = "";

                //档案号
                cell0 = sheet.getRow(i).getCell(0);
                docid = ((int) cell0.getNumericCellValue()) + "";

                //经办行
                cell1 = sheet.getRow(i).getCell(1);
                judgedeptid = ((int) cell1.getNumericCellValue()) + "";

                //客户名
                cell2 = sheet.getRow(i).getCell(2);
                custname = cell2.getStringCellValue().trim();
                //证件类型
                cell3 = sheet.getRow(i).getCell(3);
                idtype = cell3.getStringCellValue().trim();
                //证件号码
                cell4 = sheet.getRow(i).getCell(4);
                idno = cell4.getStringCellValue().trim();

                //评信方式
                cell5 = sheet.getRow(i).getCell(5);
                judgetype = cell5.getStringCellValue().trim();

                //评信等级
                cell6 = sheet.getRow(i).getCell(6);
                judgelevel = cell6.getStringCellValue().trim();

                //起始日期
                cell7 = sheet.getRow(i).getCell(7);
                begdate = cell7.getStringCellValue();

                //截止日期
                cell8 = sheet.getRow(i).getCell(8);
                enddate = cell8.getStringCellValue();

                //期限
                cell9 = sheet.getRow(i).getCell(9);
                timelimit = ((int) cell9.getNumericCellValue()) + "";

                //评信金额
                cell10 = sheet.getRow(i).getCell(10);
                judgeprice = (int) cell10.getNumericCellValue();

                myseq++;
                seqnum = myseq;


                //数据载入表对象

                String pkid = UUID.randomUUID().toString();

                if (idtype.equals("01")) {
                    if (idno.length() == 18) {
                        String y = idno.substring(6, 10);
                        String m = idno.substring(10, 12);
                        String d = idno.substring(12, 14);
                        birthday = y + "-" + m + "-" + d;
                        age = 2013 - Integer.parseInt(y);

                        int temp = Integer.parseInt(idno.charAt(16) + "");
                        if (temp % 2 == 0) {
                            sex = "0";
                        } else {
                            sex = "1";
                        }

                    } else if (idno.length() == 15) {
                        String y = idno.substring(6, 8);
                        String m = idno.substring(8, 10);
                        String d = idno.substring(10, 12);
                        birthday = "19" + y + "-" + m + "-" + d;
                        age = 2013 - Integer.parseInt("19" + y);
                        int temp = Integer.parseInt(idno.charAt(14) + "");
                        if (temp % 2 == 0) {
                            sex = "0";
                        } else {
                            sex = "1";
                        }
                    }
                }
                if (begdate != null && !begdate.equals("")) {
                    begdate = begdate.replace('.', '-');
                }

                if (enddate != null && !begdate.equals("")) {
                    enddate = enddate.replace('.', '-');
                }

                lnuncomcredit.setPkid(pkid);
                lnuncomcredit.setCreditratingno(judgedeptid + "20131120" + StringUtils.addPrefix(seqnum + "", "0", 3));
                lnuncomcredit.setSeqnum(seqnum);
                lnuncomcredit.setCustname(custname);
                lnuncomcredit.setIdtype(idtype);
                lnuncomcredit.setIdno(idno);
                lnuncomcredit.setBirthday(birthday);
                lnuncomcredit.setAge(age);
                lnuncomcredit.setSex(sex);


                lnuncomcredit.setBegdate(begdate);
                lnuncomcredit.setEnddate(enddate);
                lnuncomcredit.setDocid(docid);
                lnuncomcredit.setJudgedate(judgedate);
                lnuncomcredit.setFormalworker("是");
                lnuncomcredit.setIncome(0);
                lnuncomcredit.setJudgelevel(judgelevel);
                lnuncomcredit.setJudgeoperid(judgeoperid);
                lnuncomcredit.setJudgetype(judgetype);
                lnuncomcredit.setJudgeprice(judgeprice);
                lnuncomcredit.setJudgedeptid(judgedeptid);
                lnuncomcredit.setPost("");
                lnuncomcredit.setRecsta("1");
                lnuncomcredit.setTimelimit(timelimit);

                if (lnuncomcredit.insert() < 0)
                    return "-1";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return "-1";
        }
        return "0";
    }
}
