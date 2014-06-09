package com.ccb.creditrating;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-9-3
 * Time: 下午5:57
 * To change this template use File | Settings | File Templates.
 */
public class CreditBean {
    private String situation; //指标代码
    private String item;  //指标元素值
    private String stand1;    //标准一
    private String stand2;    //标准一
    private String stand3;    //标准一
    private String stand4;    //标准一
    private String score;//初评分

    public CreditBean() {
    }

    public CreditBean(String situation, String item, String stand1, String stand2, String stand3, String stand4, String score) {
        this.situation = situation;
        this.item = item;
        this.stand1 = stand1;
        this.stand2 = stand2;
        this.stand3 = stand3;
        this.stand4 = stand4;
        this.score = score;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getStand1() {
        return stand1;
    }

    public void setStand1(String stand1) {
        this.stand1 = stand1;
    }

    public String getStand2() {
        return stand2;
    }

    public void setStand2(String stand2) {
        this.stand2 = stand2;
    }

    public String getStand3() {
        return stand3;
    }

    public void setStand3(String stand3) {
        this.stand3 = stand3;
    }

    public String getStand4() {
        return stand4;
    }

    public void setStand4(String stand4) {
        this.stand4 = stand4;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
