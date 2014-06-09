package com.ccb.creditrating;

import com.ccb.dao.LNPCIF;
import com.ccb.dao.LNPSCOREMODEL;
import pub.platform.advance.utils.PropertyManager;
import pub.platform.db.ConnectionManager;
import pub.platform.db.DatabaseConnection;
import pub.platform.db.RecordSet;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-9-6
 * Time: 上午12:09
 * To change this template use File | Settings | File Templates.
 */
public class CreditBeanUtil {

    public static ArrayList<CreditBean> getCreditBean(String custno) throws Exception {
        ConnectionManager cm = ConnectionManager.getInstance();
        DatabaseConnection dc = cm.get();
        LNPCIF lnpcif = LNPCIF.findFirst("where custno = '" + custno + "'");
        String standard = PropertyManager.getProperty("standard");
        String[] standards = standard.split(",");
        List<String> standardList = Arrays.asList(standards);
        Map<String, String> lnpcifMaps = new HashMap<String, String>();
        BeanInfo info2 = Introspector.getBeanInfo(LNPCIF.class, Object.class);
        PropertyDescriptor[] pds2 = info2.getPropertyDescriptors();
        for (PropertyDescriptor pd : pds2) {
            String attrName2 = pd.getName().toUpperCase();
            if (standardList.contains(attrName2.toUpperCase())) {
                lnpcifMaps.put(pd.getName().toUpperCase(), pd.getReadMethod().invoke(lnpcif, null).toString());
            }
        }
        for (int i = 0; i < standardList.size(); i++) {
            String standardTemp = standardList.get(i);
            int srcScore = Integer.parseInt(lnpcifMaps.get(standardTemp));
            int goal = 0;
            RecordSet rs = dc.executeQuery("select p.ENUSCORE from ln_pscoremodel p where p.enuitemvalue = '" + standardTemp.toUpperCase() + "'and " + srcScore + " <= p.ENUMAXVALUE  and " + srcScore + " >=p.ENUMINVALUE");
            while (rs.next()) {
                goal = rs.getInt("ENUSCORE");
            }
            lnpcifMaps.put(standardTemp, goal + "");
        }
        List<LNPSCOREMODEL> lnpscoremodelList = new ArrayList<LNPSCOREMODEL>();
        RecordSet rs = dc.executeQuery("select lp.enuType,lp.enuItemValue,lp.enuMinValue,lp.enuMaxValue,lp.enuScore,lp.enuRemark from ln_pscoremodel lp order by lp.enuType,lp.enuItemValue,lp.enuScore");
        while (rs.next()) {
            LNPSCOREMODEL lnpscoremodel = new LNPSCOREMODEL();
            lnpscoremodel.setEnutype(rs.getString("enuType"));
            lnpscoremodel.setEnuitemvalue(rs.getString("enuItemValue"));
            lnpscoremodel.setEnuminvalue(rs.getInt("enuMinValue"));
            lnpscoremodel.setEnumaxvalue(rs.getInt("enuMaxValue"));
            lnpscoremodel.setEnuscore(rs.getInt("enuScore"));
            lnpscoremodel.setEnuremark(rs.getString("enuRemark"));
            lnpscoremodelList.add(lnpscoremodel);
        }
        CreditBean creditBean1 = null, creditBean2 = null;
        ArrayList<CreditBean> creditBeans = new ArrayList<CreditBean>();
        String str1 = "", str2 = "";
        LNPSCOREMODEL lnpscoremodelTemp;
        int count = 0;
        Map<String, String> fieldNameMaps = FieldUtil.getFieldNameMaps();
        int sum = 0;
        for (int i = 0; i < lnpscoremodelList.size(); i++) {
            lnpscoremodelTemp = lnpscoremodelList.get(i);
            if (!str2.equals(lnpscoremodelTemp.getEnuitemvalue()) || count % 4 == 0) {
                if (count != 0) {
                    count = 0;
                    creditBeans.add(creditBean1);
                    creditBeans.add(creditBean2);
                }
                count++;
                String score = "&nbsp;";  //得分<td>
                String enuitemvalueType = "&nbsp;";
                if (!str2.equals(lnpscoremodelTemp.getEnuitemvalue())) {
                    enuitemvalueType = lnpscoremodelTemp.getEnuitemvalue();
                    score = lnpcifMaps.get(enuitemvalueType);
                    sum += Integer.parseInt(score);
                }
                String enuType = "&nbsp;";
                if (!str1.equals(lnpscoremodelTemp.getEnutype())) {
                    enuType = lnpscoremodelTemp.getEnutype();
                }
                str1 = lnpscoremodelTemp.getEnutype();
                str2 = lnpscoremodelTemp.getEnuitemvalue();
                creditBean1 = new CreditBean(enuType, enuitemvalueType, "&nbsp;", "&nbsp;", "&nbsp;", "&nbsp;", score);
                creditBean2 = new CreditBean("&nbsp;", "&nbsp;", "&nbsp;", "&nbsp;", "&nbsp;", "&nbsp;", "&nbsp;");
                creditBean1.setSituation(fieldNameMaps.get(enuType) == null ? enuType : fieldNameMaps.get(enuType));
                creditBean1.setItem(fieldNameMaps.get(enuitemvalueType) == null ? enuitemvalueType : fieldNameMaps.get(enuitemvalueType));
                creditBean1.setStand1(lnpscoremodelTemp.getEnuremark());
                creditBean2.setStand1(lnpscoremodelTemp.getEnuscore() + "");
            } else {
                count++;
                switch (count) {
                    case 2:
                        creditBean1.setStand2(lnpscoremodelTemp.getEnuremark());
                        creditBean2.setStand2(lnpscoremodelTemp.getEnuscore() + "");
                        break;
                    case 3:
                        creditBean1.setStand3(lnpscoremodelTemp.getEnuremark());
                        creditBean2.setStand3(lnpscoremodelTemp.getEnuscore() + "");
                        break;
                    case 4:
                        creditBean1.setStand4(lnpscoremodelTemp.getEnuremark());
                        creditBean2.setStand4(lnpscoremodelTemp.getEnuscore() + "");
                        break;
                }
            }
            if (count % 4 == 0) {
                count = 0;
                creditBeans.add(creditBean1);
                creditBeans.add(creditBean2);
            }
        }
        creditBeans.add(creditBean1);
        creditBeans.add(creditBean2);
        creditBeans.add(new CreditBean("总分", "&nbsp;", "&nbsp;", "&nbsp;", "&nbsp;", "&nbsp;", sum + ""));

        String sql = "select levelcode from creditlevel c where " + sum + " <=SCORETOP and " + sum + " >= SCOREBOTTOME";
        RecordSet recordSet = dc.executeQuery(sql);
        String iniLevel = "nolevel";
        while (recordSet.next()) {
            iniLevel = recordSet.getString("levelcode");
        }
        creditBeans.add(new CreditBean("等级", "&nbsp;", "&nbsp;", "&nbsp;", "&nbsp;", "&nbsp;", iniLevel));
        creditBeans.add(new CreditBean("加分", "&nbsp;", "&nbsp;", "&nbsp;", "&nbsp;", "&nbsp;", ""));
        return creditBeans;
    }
}
