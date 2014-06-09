package com.ccb.creditrating;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-9-5
 * Time: 下午9:23
 * To change this template use File | Settings | File Templates.
 */
public class FieldUtil {
    private static ArrayList<String> attrList;
    private static Map<String, String> fieldNameMaps;
    static {
        fieldNameMaps = new HashMap<String, String>();
        fieldNameMaps.put("AGE", "年龄");
        fieldNameMaps.put("SEX", "性别");
        fieldNameMaps.put("MARISTA", "婚姻状况");
        fieldNameMaps.put("HEALTH", "健康状况");
        fieldNameMaps.put("LIVETYPE", "户口性质");
        fieldNameMaps.put("EDUCATION", "文化程度");
        fieldNameMaps.put("CORPTYPE", "单位类别");
        fieldNameMaps.put("CORPFIN", "单位经济状况");
        fieldNameMaps.put("BUSIFUTURE", "从事行业发展前景");
        fieldNameMaps.put("POSTTYPE", "职务级别");
        fieldNameMaps.put("POSTLEVEL", "职称");
        fieldNameMaps.put("INCOME", "月收入");
        fieldNameMaps.put("HOMEAVEINCOME", "家庭人均月收入");
        fieldNameMaps.put("MEMBERFLG", "是否本行员工");
        fieldNameMaps.put("ACTFLG", "本行账户");
        fieldNameMaps.put("WORKYEARS", "工作年限");
        fieldNameMaps.put("SAVBAL", "本行存款余额");
        fieldNameMaps.put("BUSIRATE", "本行业务往来");
        fieldNameMaps.put("LOANSTA", "本行借款情况");
        fieldNameMaps.put("NATURE_SITUATION", "自然情况");
        fieldNameMaps.put("PROFESSIONAL_SITUATION", "职业情况");
        fieldNameMaps.put("FAMILY_SITUATION", "家庭情况");
        fieldNameMaps.put("BANK_SITUATION", "金融往来情况");
        fieldNameMaps.put("OTHERLOANSTA", "他行信用情况");
        //--------------------评分标准依据----------------------------
        attrList = new ArrayList<String>();
        attrList.add("custname");
        attrList.add("sex");
        attrList.add("birthday");
        attrList.add("idno");
        attrList.add("corptype");
        attrList.add("corpname");
        attrList.add("corpfin");
        attrList.add("busifuture");
        attrList.add("corpzip");
        attrList.add("corptel");
        attrList.add("corpaddr");
        attrList.add("homeaddr");
        attrList.add("homezip");
        attrList.add("tel1");
        attrList.add("tel2");
        attrList.add("mobile1");
        attrList.add("livetype");
        attrList.add("education");
        attrList.add("marista");
        attrList.add("postlevel");
        attrList.add("deptname");
        attrList.add("post");
        attrList.add("posttype");
        attrList.add("workyears");
        attrList.add("income");
        attrList.add("homeincome");
        attrList.add("homepersons");
        attrList.add("homeaveincome");
        attrList.add("health");
        attrList.add("memberflg");
        attrList.add("actflg");
        attrList.add("savbal");
        attrList.add("busirate");
        attrList.add("loansta");
        attrList.add("otherloansta");
        attrList.add("spousename");
        attrList.add("spouseidno");
        attrList.add("spousecorpaddr");
        attrList.add("spousetel");
        attrList.add("spouseincome");
        attrList.add("taxregno");
        attrList.add("busilicno");
        attrList.add("remark");
    }

    public static String getValue(String key, String value) {
        String temp = "";
        if (key.equals("sex")) {
            if (value.equals("0")) temp = "女";
            else temp = "男";
        } else if (key.equals("idtype")) {
            if (value.equals("01")) temp = "身份证";
            else if (value.equals("02")) temp = "军官证";
            else if (value.equals("03")) temp = "武警警官证";
        } else if (key.equals("corptype")) {
            if (value.equals("01")) temp = "机关事业单位";
            else if (value.equals("02")) temp = "军队";
            else if (value.equals("03")) temp = "国有控股公司";
            else if (value.equals("04")) temp = "国有参股公司";
            else if (value.equals("05")) temp = "三资外企";
            else if (value.equals("06")) temp = "民营企业";
            else if (value.equals("07")) temp = "其他";
        } else if (key.equals("corpfin")) {
            if (value.equals("01")) temp = "良好";
            else if (value.equals("02")) temp = "一般";
            else if (value.equals("03")) temp = "较差";
        } else if (key.equals("busifuture")) {
            if (value.equals("01")) temp = "良好";
            else if (value.equals("02")) temp = "一般";
            else if (value.equals("03")) temp = "较差";
        } else if (key.equals("livetype")) {
            if (value.equals("01")) temp = "常住户口";
            else if (value.equals("02")) temp = "外地户口";
        } else if (key.equals("education")) {
            if (value.equals("01")) temp = "研究生以上";
            else if (value.equals("02")) temp = "大学本科";
            else if (value.equals("03")) temp = "大专";
            else if (value.equals("04")) temp = "中专、高中";
            else if (value.equals("05")) temp = "其他";
        } else if (key.equals("marista")) {
            if (value.equals("1")) temp = "已婚有子女";
            else if (value.equals("2")) temp = "已婚无子女";
            else if (value.equals("3")) temp = "未婚";
            else if (value.equals("4")) temp = "其他";
        } else if (key.equals("postlevel")) {
            if (value.equals("0")) temp = "无";
            else if (value.equals("1")) temp = "初级";
            else if (value.equals("2")) temp = "中级";
            else if (value.equals("3")) temp = "高级";
        } else if (key.equals("posttype")) {
            if (value.equals("01")) temp = "单位主管或处级以上";
            else if (value.equals("02")) temp = "部门主管或科级以上";
            else if (value.equals("03")) temp = "其他";
        } else if (key.equals("health")) {
            if (value.equals("01")) temp = "良好";
            else if (value.equals("02")) temp = "一般";
            else if (value.equals("03")) temp = "较差";
        } else if (key.equals("memberflg")) {
            if (value.equals("0")) temp = "否";
            else if (value.equals("1")) temp = "是";
        } else if (key.equals("actflg")) {
            if (value.equals("0")) temp = "无";
            else if (value.equals("1")) temp = "有储蓄卡";
            else if (value.equals("2")) temp = "有信用卡";
        } else if (key.equals("savbal")) {
            if (value.equals("0")) temp = "无";
            else if (value.equals("1")) temp = "较低";
            else if (value.equals("2")) temp = "较高";
        } else if (key.equals("busirate")) {
            if (value.equals("1")) temp = "无";
            else if (value.equals("2")) temp = "一般";
            else if (value.equals("3")) temp = "频繁";
        } else if (key.equals("loansta")) {
            if (value.equals("1")) temp = "从未借款";
            else if (value.equals("2")) temp = "已结清无拖欠";
            else if (value.equals("3")) temp = "有拖欠无不良";
            else if (value.equals("4")) temp = "未结清无拖欠";
        } else if (key.equals("judgetype")) {
            if (value.equals("01")) temp = "集体评信";
            else if (value.equals("02")) temp = "高端评信";
            else if (value.equals("03")) temp = "简化评信";
            else if (value.equals("04")) temp = "存量评信";
            else if (value.equals("05")) temp = "其它评信";
        } else {
            temp = value;
        }
        return temp;
    }

    public static ArrayList<String> getAttrList() {
        return attrList;
    }

    public static Map<String, String> getFieldNameMaps() {
        return fieldNameMaps;
    }
}



