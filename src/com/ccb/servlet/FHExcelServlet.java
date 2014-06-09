package com.ccb.servlet;

import com.ccb.creditrating.CreditBean;
import com.ccb.creditrating.CreditBeanUtil;
import com.ccb.creditrating.FieldUtil;
import com.ccb.dao.LNPCIF;
import com.ccb.dao.LNPSCOREDETAIL;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import pub.platform.advance.utils.PropertyManager;
import pub.platform.form.config.SystemAttributeNames;
import pub.platform.security.OperatorManager;
import pub.platform.system.manage.dao.PtDeptBean;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FHExcelServlet extends HttpServlet {
    private static final Log logger = LogFactory.getLog(FHExcelServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletOutputStream os = response.getOutputStream();
        response.setContentType("text/html");
        String custno = request.getParameter("custno");
        String iniLevel = request.getParameter("iniLevel");
        String addScore = request.getParameter("addScore");
        String creditratingno = request.getParameter("creditratingno");
        LNPSCOREDETAIL lnpscoredetail = LNPSCOREDETAIL.findFirst("where creditratingno ='" + creditratingno + "'");
        String resultFileName = "分行客户评价报告_" + creditratingno + ".xls";
        String templateFileName = PropertyManager.getProperty("REPORT_ROOTPATH") + "credit_template_fenhang.xls";
        Map<String, Object> attrsMaps = new HashMap<String, Object>();//存储属性和值
        LNPCIF lnpcif = LNPCIF.findFirst("where custno ='" + custno + "'");
        //封面信息
        attrsMaps.put("custSeqNum", creditratingno);
        attrsMaps.put("idType", FieldUtil.getValue("idtype", lnpcif.getIdtype()));
        attrsMaps.put("idNo", lnpscoredetail.getIdno());
        attrsMaps.put("custName", lnpscoredetail.getCustname());

        //客户基本信息
        try {
            BeanInfo info = Introspector.getBeanInfo(LNPCIF.class, Object.class);
            PropertyDescriptor[] pds = info.getPropertyDescriptors();
            ArrayList<String> attrList = FieldUtil.getAttrList();
            for (PropertyDescriptor pd : pds) {
                String attrName = pd.getName();
                if (attrList.contains(attrName)) {
                    String value = FieldUtil.getValue(attrName, pd.getReadMethod().invoke(lnpcif, null).toString());
                    if (value == null || value.equals("")) {
                        value = "无";
                    }
                    attrsMaps.put(attrName, value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("封装评信信息出现错误！");
            logger.error(e.getMessage());
        }

        //评定意见表

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy年MM月dd日");
        String iniBegDate = "";//初评有效起日
        String iniEndDate1 = "";//初评有效止日
        String iniEndDate2 = ""; //初评有效止日2
        try {
            iniBegDate = format1.format(new Date(format.parse(lnpscoredetail.getInibegdate()).getTime()));
            Date tempDate = new Date(format.parse(lnpscoredetail.getInibegdate()).getTime());
            tempDate.setYear(tempDate.getYear() + 1);
            iniEndDate1 = format1.format(tempDate);
            tempDate.setYear(tempDate.getYear() + 1);
            iniEndDate2 = format1.format(tempDate);
        } catch (ParseException e) {
            e.printStackTrace();
            logger.error("日期解析出现错误！");
            logger.error(e.getMessage());
        }

        OperatorManager omgr = (OperatorManager) request.getSession().getAttribute(SystemAttributeNames.USER_INFO_NAME);
        PtDeptBean ptOperBean = omgr.getOperator().getPtDeptBean();
        String finOperatorId = "";
        try {
            finOperatorId = omgr.getOperatorId();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取操作员ID出现错误！");
            logger.error(e.getMessage());
        }
        String deptid = ptOperBean.getDeptid();
        if (addScore.equals("")) {
            lnpscoredetail.setFinscore(lnpscoredetail.getBasescore());
        } else {
            lnpscoredetail.setFinscore((Integer.parseInt(lnpscoredetail.getBasescore()) + Integer.parseInt(addScore)) + "");
        }
        lnpscoredetail.setFinlevel(iniLevel);
        lnpscoredetail.setFinoperid(finOperatorId);
        lnpscoredetail.setFindeptid(deptid);
        lnpscoredetail.setFindate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        lnpscoredetail.setFinbegdate(lnpscoredetail.getInibegdate());
        lnpscoredetail.setFinenddate(lnpscoredetail.getInienddate());
        lnpscoredetail.updateByWhere("  where creditratingno = '" + creditratingno + "'");
        if (addScore.equals("")) {
            attrsMaps.put("iniScore", lnpscoredetail.getBasescore());
        } else {
            attrsMaps.put("iniScore", lnpscoredetail.getBasescore() + "+" + addScore);
        }
        attrsMaps.put("iniLevel", iniLevel);
        attrsMaps.put("iniBegDate", iniBegDate);
        attrsMaps.put("iniEndDate1", iniEndDate1);
        attrsMaps.put("iniEndDate2", iniEndDate2);
        ArrayList<CreditBean> creditBeanArrayList = null;
        try {
            creditBeanArrayList = CreditBeanUtil.getCreditBean(custno);
            creditBeanArrayList.remove(creditBeanArrayList.size() - 1);
            creditBeanArrayList.remove(creditBeanArrayList.size() - 1);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取评信信息出现错误！");
            logger.error(e.getMessage());
        }
        //格式化一下内容
        for (int i = 0; i < creditBeanArrayList.size() && creditBeanArrayList != null; i++) {
            CreditBean creditBeanTemp = creditBeanArrayList.get(i);
            if (creditBeanTemp.getSituation().equals("&nbsp;")) {
                creditBeanArrayList.get(i).setSituation("");
            }
            if (creditBeanTemp.getItem().equals("&nbsp;")) {
                creditBeanArrayList.get(i).setItem("");
            }
            if (creditBeanTemp.getStand1().equals("&nbsp;")) {
                creditBeanArrayList.get(i).setStand1("");
            }
            if (creditBeanTemp.getStand2().equals("&nbsp;")) {
                creditBeanArrayList.get(i).setStand2("");
            }
            if (creditBeanTemp.getStand3().equals("&nbsp;")) {
                creditBeanArrayList.get(i).setStand3("");
            }
            if (creditBeanTemp.getStand4().equals("&nbsp;")) {
                creditBeanArrayList.get(i).setStand4("");
            }
            if (creditBeanTemp.getScore().equals("&nbsp;")) {
                creditBeanArrayList.get(i).setScore("");
            }
        }

        attrsMaps.put("creditBeans", creditBeanArrayList);
        InputStream is = null;
        try {
            XLSTransformer transformer = new XLSTransformer();
            is = new BufferedInputStream(new FileInputStream(templateFileName));
            HSSFWorkbook wb = transformer.transformXLS(is, attrsMaps);
            response.reset();
            response.setHeader("Content-disposition", "attachment; filename=" + java.net.URLEncoder.encode(resultFileName, "UTF-8"));
            response.setContentType("application/msexcel");
            wb.write(os);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("写入excel出现错误！");
            logger.error(e.getMessage());
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
