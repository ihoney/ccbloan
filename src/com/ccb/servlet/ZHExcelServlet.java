package com.ccb.servlet;

import com.ccb.creditrating.CreditBean;
import com.ccb.creditrating.CreditBeanUtil;
import com.ccb.creditrating.FieldUtil;
import com.ccb.dao.LNPCIF;
import com.ccb.dao.LNPSCOREDETAIL;
import com.ccb.dao.PTDEPT;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import pub.platform.advance.utils.PropertyManager;
import pub.platform.db.ConnectionManager;
import pub.platform.db.DatabaseConnection;
import pub.platform.db.RecordSet;
import pub.platform.form.config.SystemAttributeNames;
import pub.platform.security.OperatorManager;
import pub.platform.system.manage.dao.PtDeptBean;
import pub.platform.utils.StringUtils;

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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-9-16
 * Time: 下午3:37
 * To change this template use File | Settings | File Templates.
 */
public class ZHExcelServlet extends HttpServlet {
    private static final Log logger = LogFactory.getLog(ZHExcelServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        ServletOutputStream os = response.getOutputStream();
        OperatorManager omgr = (OperatorManager) request.getSession().getAttribute(SystemAttributeNames.USER_INFO_NAME);
        PtDeptBean ptOperBean = omgr.getOperator().getPtDeptBean();
        String deptid = ptOperBean.getDeptid();
        ConnectionManager cm = ConnectionManager.getInstance();
        DatabaseConnection dc = cm.get();
        int seqnum = 0;
        RecordSet rs = dc.executeQuery("select max(lp.seqnum) as custmax from ln_pscoredetail lp where lp.inideptid = '" + deptid + "' and (to_char(sysdate,'yyyy-mm-dd') = to_char(lp.inidate,'yyyy-mm-dd')) ");
        while (rs.next()) {
            seqnum = rs.getInt("custmax") + 1;
        }
        String creditratingno = deptid + StringUtils.toDateFormat(new Date(), "yyyyMMdd") + StringUtils.addPrefix(seqnum + "", "0", 3);
        String custno = request.getParameter("custno");
        String baseLevel = request.getParameter("baselevel");
        String baseScore = request.getParameter("baseScore");
        String addScore = request.getParameter("addScore");
        String iniLevel = request.getParameter("iniLevel");
        String resultFileName = "支行客户评价报告_" + creditratingno + ".xls";
//        String templateFileName = this.getServletContext().getRealPath("/report/credit_template_zhihang.xls");
        String templateFileName = PropertyManager.getProperty("REPORT_ROOTPATH") + "credit_template_zhihang.xls";
        Map<String, Object> attrsMaps = new HashMap<String, Object>();//存储属性和值
        LNPCIF lnpcif = LNPCIF.findFirst("where custno ='" + custno + "'");
        PTDEPT ptdept = PTDEPT.findFirst("where deptid='" + lnpcif.getDeptid() + "'");
        //封面信息
        String idNo = lnpcif.getIdno();
        String custName = lnpcif.getCustname();
        attrsMaps.put("custSeqNum", creditratingno);
        attrsMaps.put("idType", FieldUtil.getValue("idtype", lnpcif.getIdtype()));
        attrsMaps.put("idNo", idNo);
        attrsMaps.put("custName", lnpcif.getCustname());
        attrsMaps.put("deptName", ptdept.getDeptname());

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

        Date dateTemp = new Date();
        Date beginDate = new Date();
        beginDate.setDate(dateTemp.getDate() + 5);
        Date endDate = new Date(beginDate.getYear()+1,beginDate.getMonth(),beginDate.getDate());
        Date endDate2 = new Date(beginDate.getYear()+2,beginDate.getMonth(),beginDate.getDate());
        SimpleDateFormat formatD = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatU = new SimpleDateFormat("yyyy年MM月dd日");

        String iniOperatorId = "";
        try {
            iniOperatorId = omgr.getOperatorId();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取操作员ID出现错误！");
            logger.error(e.getMessage());
        }
        String iniBegDate = formatU.format(beginDate);
        String iniEndDate1 = formatU.format(endDate);
        String iniEndDate2 = formatU.format(endDate2);
        insertScore(creditratingno, seqnum, custno, idNo, custName, baseLevel, baseScore, iniLevel, addScore, deptid, formatD.format(beginDate), formatD.format(endDate), iniOperatorId, formatD.format(dateTemp));
        if (addScore.equals("")) {
            attrsMaps.put("iniScore", baseScore);
        } else {
            attrsMaps.put("iniScore", baseScore + "+" + addScore);
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

    /**
     * 生成一条资信评定记录插入数据库ln_pscoredetail
     *
     * @param custno 客户信息
     * @return
     */
    public int insertScore(String creditratingno, int seqnum, String custno, String idNo, String custName, String baseLevel, String baseScore, String iniLevel, String addScore, String deptid, String inibegdate, String inienddate, String inioperid, String inidate) {
        LNPSCOREDETAIL lnpscoredetail = new LNPSCOREDETAIL();
        lnpscoredetail.setCreditratingno(creditratingno);
        lnpscoredetail.setSeqnum(seqnum);
        lnpscoredetail.setCustno(custno);  //客户号
        lnpscoredetail.setIdno(idNo);      //证件号码
        lnpscoredetail.setCustname(custName);        //客户名称
        lnpscoredetail.setBaselevel(baseLevel);
        lnpscoredetail.setBasescore(baseScore);
        if (addScore.equals("")) {
            lnpscoredetail.setIniscore(baseScore);    //初评得分
        } else {
            lnpscoredetail.setIniscore((Integer.parseInt(baseScore) + Integer.parseInt(addScore)) + "");    //初评得分
        }
        lnpscoredetail.setInideptid(deptid); //初评机构号
        lnpscoredetail.setInilevel(iniLevel);  //初评等级
        lnpscoredetail.setInibegdate(inibegdate);
        lnpscoredetail.setInienddate(inienddate);
        lnpscoredetail.setInioperid(inioperid);
        lnpscoredetail.setInidate(inidate);
        lnpscoredetail.setTimelimit("12");
        lnpscoredetail.setSta("1"); //个人信用评估状态
        return lnpscoredetail.insert();
    }
}
