package com.ccb.servlet;

import com.ccb.creditrating.FieldUtil;
import com.ccb.dao.LNUNCOMCREDIT;
import com.ccb.dao.PTDEPT;
import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.rtf.RtfWriter2;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jbarcode.JBarcode;
import org.jbarcode.encode.Code128Encoder;
import org.jbarcode.encode.EAN13Encoder;
import org.jbarcode.paint.BaseLineTextPainter;
import org.jbarcode.paint.EAN13TextPainter;
import org.jbarcode.paint.WidthCodedPainter;
import org.jbarcode.util.ImageUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class UnCommonTiaoXMServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Log logger = LogFactory.getLog(UnCommonTiaoXMServlet.class);
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String pkid = request.getParameter("pkid");
            String operName = new String(request.getParameter("opername").getBytes("iso8859-1"), "gbk");
            LNUNCOMCREDIT lnuncomcredit = LNUNCOMCREDIT.findFirst("where pkid ='" + pkid + "'");
            String judgeType = FieldUtil.getValue("judgetype", lnuncomcredit.getJudgetype());//评信种类
            PTDEPT ptdept = PTDEPT.findFirst("where deptid='" + lnuncomcredit.getJudgedeptid() + "'");
            String timeLimit = lnuncomcredit.getTimelimit();//期限
            String iniamt = lnuncomcredit.getJudgeprice() + "";//金额
            String custName = lnuncomcredit.getCustname();//客户名称
            String creditratingno = lnuncomcredit.getCreditratingno();
            String deptName = ptdept.getDeptname();
            String savePath = this.getServletContext().getRealPath(
                    "/images/tiaoxingma/");
            File file = new File(savePath);
            if (!file.exists()) {
                file.mkdirs();
            }
            JBarcode localJBarcode = new JBarcode(EAN13Encoder.getInstance(),
                    WidthCodedPainter.getInstance(),
                    EAN13TextPainter.getInstance());
            localJBarcode.setBarHeight(17.0D);
            localJBarcode.setXDimension(0.264583333D);
            localJBarcode.setWideRatio(2.0D);
            localJBarcode.setShowText(false);
            localJBarcode.setShowCheckDigit(false);
            localJBarcode.setEncoder(Code128Encoder.getInstance());
            localJBarcode.setPainter(WidthCodedPainter.getInstance());
            BufferedImage localBufferedImage = localJBarcode.createBarcode(creditratingno);
            localJBarcode.setTextPainter(BaseLineTextPainter.getInstance());
            String fileName = "untxm_ " + creditratingno + ".png";
            saveToFile(response, localBufferedImage, fileName, savePath, creditratingno, custName, judgeType, deptName, timeLimit, iniamt, operName);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("写入excel出现错误！");
            logger.error(e.getMessage());
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public void saveToFile(HttpServletResponse response, BufferedImage image,
                           String fileName, String savePath, String custno, String custName, String judgeType, String deptName, String timeLimit, String price, String operName) throws IOException {
        FileOutputStream outputStream = null;
        try {
            String filePath = savePath + "\\" + fileName;
            outputStream = new FileOutputStream(filePath);
            ImageUtil.encodeAndWrite(image, "png", outputStream, 96, 96);
            docOper(response, savePath, fileName, custno, custName, judgeType, deptName, timeLimit, price, operName);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("将条形码写入文件出现错误！");
            logger.error(e.getMessage());
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    public void docOper(HttpServletResponse response, String picPath,
                        String picName, String custno, String custName, String judgeType, String deptName, String timeLimit, String price, String operName) {
        try {
            Document doc = new Document(PageSize.A4);
            response.setHeader("Content-Disposition",
                    "attachment;filename=untxm_" + custno + ".doc");
            response.setContentType("application/msword");

            RtfWriter2.getInstance(doc, response.getOutputStream());
            doc.open();
            Image png = Image.getInstance(picPath + "\\" + picName);
            doc.add(png);

            Paragraph IDElement = new Paragraph(custno);
            Paragraph custNameElement = new Paragraph("客户名称：" + custName + "    客户经理：" + operName);
            Paragraph loanTypeElement = new Paragraph("评信种类：" + judgeType);
            Paragraph timeAndPriceElement = new Paragraph("期限：" + timeLimit + "月    金额：" + price + "万元");
            Paragraph deptElement = new Paragraph("机构：" + deptName);
            doc.add(IDElement);
            doc.add(custNameElement);
            doc.add(loanTypeElement);
            doc.add(timeAndPriceElement);
            doc.add(deptElement);
            doc.close();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("将条形码写入word出现错误！");
            logger.error(e.getMessage());
        }
    }
}
