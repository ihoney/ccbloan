package com.ccb.datatrans;

/**
 * Created by IntelliJ IDEA.
 * User: zhanrui
 * Date: 2010-3-20
 * Time: 16:07:03
 * To change this template use File | Settings | File Templates.
 */
public class LoanResultBean {
    String loanid;
    String name;
    double amt;
    String bankid;


    public LoanResultBean(String loanid, String name, double amt, String bankid) {
        this.loanid = loanid;
        this.name = name;
        this.amt = amt;
        this.bankid = bankid;
    }

    public String getLoanid() {
        return loanid;
    }

    public void setLoanid(String loanid) {
        this.loanid = loanid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }

    public String getBankid() {
        return bankid;
    }

    public void setBankid(String bankid) {
        this.bankid = bankid;
    }

}