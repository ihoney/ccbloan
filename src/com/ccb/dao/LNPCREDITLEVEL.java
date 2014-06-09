package com.ccb.dao;

import pub.platform.db.AbstractBasicBean;
import pub.platform.db.RecordSet;
import pub.platform.utils.ActionRequest;
import pub.platform.utils.ChangeFileds;
import pub.platform.utils.Field;

import java.util.List;

public class LNPCREDITLEVEL extends AbstractBasicBean implements Cloneable {
    public static List find(String sSqlWhere) {
        return new LNPCREDITLEVEL().findByWhere(sSqlWhere);
    }

    public static List findAndLock(String sSqlWhere) {
        return new LNPCREDITLEVEL().findAndLockByWhere(sSqlWhere);
    }

    public static LNPCREDITLEVEL findFirst(String sSqlWhere) {
        return (LNPCREDITLEVEL) new LNPCREDITLEVEL().findFirstByWhere(sSqlWhere);
    }

    public static LNPCREDITLEVEL findFirstAndLock(String sSqlWhere) {
        return (LNPCREDITLEVEL) new LNPCREDITLEVEL().findFirstAndLockByWhere(sSqlWhere);
    }

    public static RecordSet findRecordSet(String sSqlWhere) {
        return new LNPCREDITLEVEL().findRecordSetByWhere(sSqlWhere);
    }

    public static List find(String sSqlWhere, boolean isAutoRelease) {
        LNPCREDITLEVEL bean = new LNPCREDITLEVEL();
        bean.setAutoRelease(isAutoRelease);
        return bean.findByWhere(sSqlWhere);
    }

    public static List findAndLock(String sSqlWhere, boolean isAutoRelease) {
        LNPCREDITLEVEL bean = new LNPCREDITLEVEL();
        bean.setAutoRelease(isAutoRelease);
        return bean.findAndLockByWhere(sSqlWhere);
    }

    public static LNPCREDITLEVEL findFirst(String sSqlWhere, boolean isAutoRelease) {
        LNPCREDITLEVEL bean = new LNPCREDITLEVEL();
        bean.setAutoRelease(isAutoRelease);
        return (LNPCREDITLEVEL) bean.findFirstByWhere(sSqlWhere);
    }

    public static LNPCREDITLEVEL findFirstAndLock(String sSqlWhere, boolean isAutoRelease) {
        LNPCREDITLEVEL bean = new LNPCREDITLEVEL();
        bean.setAutoRelease(isAutoRelease);
        return (LNPCREDITLEVEL) bean.findFirstAndLockByWhere(sSqlWhere);
    }

    public static RecordSet findRecordSet(String sSqlWhere, boolean isAutoRelease) {
        LNPCREDITLEVEL bean = new LNPCREDITLEVEL();
        bean.setAutoRelease(isAutoRelease);
        return bean.findRecordSetByWhere(sSqlWhere);
    }

    public static List findByRow(String sSqlWhere, int row) {
        return new LNPCREDITLEVEL().findByWhereByRow(sSqlWhere, row);
    }

    String preditlevelid;
    String preditlevelname;
    int minamt;
    int maxamt;
    String minflg;
    String maxflg;
    double rate;
    int altertimes;
    public static final String TABLENAME = "ln_pcreditlevel";
    private String operate_mode = "add";
    public ChangeFileds cf = new ChangeFileds();

    public String getTableName() {
        return TABLENAME;
    }

    public void addObject(List list, RecordSet rs) {
        LNPCREDITLEVEL abb = new LNPCREDITLEVEL();
        abb.preditlevelid = rs.getString("preditlevelid");
        abb.setKeyValue("PREDITLEVELID", "" + abb.getPreditlevelid());
        abb.preditlevelname = rs.getString("preditlevelname");
        abb.setKeyValue("PREDITLEVELNAME", "" + abb.getPreditlevelname());
        abb.minamt = rs.getInt("minamt");
        abb.setKeyValue("MINAMT", "" + abb.getMinamt());
        abb.maxamt = rs.getInt("maxamt");
        abb.setKeyValue("MAXAMT", "" + abb.getMaxamt());
        abb.minflg = rs.getString("minflg");
        abb.setKeyValue("MINFLG", "" + abb.getMinflg());
        abb.maxflg = rs.getString("maxflg");
        abb.setKeyValue("MAXFLG", "" + abb.getMaxflg());
        abb.rate = rs.getDouble("rate");
        abb.setKeyValue("RATE", "" + abb.getRate());
        abb.altertimes = rs.getInt("altertimes");
        abb.setKeyValue("ALTERTIMES", "" + abb.getAltertimes());
        list.add(abb);
        abb.operate_mode = "edit";
    }

    public String getPreditlevelid() {
        if (this.preditlevelid == null) return "";
        return this.preditlevelid;
    }

    public String getPreditlevelname() {
        if (this.preditlevelname == null) return "";
        return this.preditlevelname;
    }

    public int getMinamt() {
        return this.minamt;
    }

    public int getMaxamt() {
        return this.maxamt;
    }

    public String getMinflg() {
        if (this.minflg == null) return "";
        return this.minflg;
    }

    public String getMaxflg() {
        if (this.maxflg == null) return "";
        return this.maxflg;
    }

    public double getRate() {
        return this.rate;
    }

    public int getAltertimes() {
        return this.altertimes;
    }

    public void setPreditlevelid(String preditlevelid) {
        sqlMaker.setField("preditlevelid", preditlevelid, Field.TEXT);
        if (this.operate_mode.equals("edit")) {
            if (!this.getPreditlevelid().equals(preditlevelid))
                cf.add("preditlevelid", this.preditlevelid, preditlevelid);
        }
        this.preditlevelid = preditlevelid;
    }

    public void setPreditlevelname(String preditlevelname) {
        sqlMaker.setField("preditlevelname", preditlevelname, Field.TEXT);
        if (this.operate_mode.equals("edit")) {
            if (!this.getPreditlevelname().equals(preditlevelname))
                cf.add("preditlevelname", this.preditlevelname, preditlevelname);
        }
        this.preditlevelname = preditlevelname;
    }

    public void setMinamt(int minamt) {
        sqlMaker.setField("minamt", "" + minamt, Field.NUMBER);
        if (this.operate_mode.equals("edit")) {
            if (this.getMinamt() != minamt) cf.add("minamt", this.minamt + "", minamt + "");
        }
        this.minamt = minamt;
    }

    public void setMaxamt(int maxamt) {
        sqlMaker.setField("maxamt", "" + maxamt, Field.NUMBER);
        if (this.operate_mode.equals("edit")) {
            if (this.getMaxamt() != maxamt) cf.add("maxamt", this.maxamt + "", maxamt + "");
        }
        this.maxamt = maxamt;
    }

    public void setMinflg(String minflg) {
        sqlMaker.setField("minflg", minflg, Field.TEXT);
        if (this.operate_mode.equals("edit")) {
            if (!this.getMinflg().equals(minflg)) cf.add("minflg", this.minflg, minflg);
        }
        this.minflg = minflg;
    }

    public void setMaxflg(String maxflg) {
        sqlMaker.setField("maxflg", maxflg, Field.TEXT);
        if (this.operate_mode.equals("edit")) {
            if (!this.getMaxflg().equals(maxflg)) cf.add("maxflg", this.maxflg, maxflg);
        }
        this.maxflg = maxflg;
    }

    public void setRate(double rate) {
        sqlMaker.setField("rate", "" + rate, Field.NUMBER);
        if (this.operate_mode.equals("edit")) {
            if (this.getRate() != rate) cf.add("rate", this.rate + "", rate + "");
        }
        this.rate = rate;
    }

    public void setAltertimes(int altertimes) {
        sqlMaker.setField("altertimes", "" + altertimes, Field.NUMBER);
        if (this.operate_mode.equals("edit")) {
            if (this.getAltertimes() != altertimes) cf.add("altertimes", this.altertimes + "", altertimes + "");
        }
        this.altertimes = altertimes;
    }

    public void init(int i, ActionRequest actionRequest) throws Exception {
        if (actionRequest.getFieldValue(i, "preditlevelid") != null) {
            this.setPreditlevelid(actionRequest.getFieldValue(i, "preditlevelid"));
        }
        if (actionRequest.getFieldValue(i, "preditlevelname") != null) {
            this.setPreditlevelname(actionRequest.getFieldValue(i, "preditlevelname"));
        }
        if (actionRequest.getFieldValue(i, "minamt") != null && actionRequest.getFieldValue(i, "minamt").trim().length() > 0) {
            this.setMinamt(Integer.parseInt(actionRequest.getFieldValue(i, "minamt")));
        }
        if (actionRequest.getFieldValue(i, "maxamt") != null && actionRequest.getFieldValue(i, "maxamt").trim().length() > 0) {
            this.setMaxamt(Integer.parseInt(actionRequest.getFieldValue(i, "maxamt")));
        }
        if (actionRequest.getFieldValue(i, "minflg") != null) {
            this.setMinflg(actionRequest.getFieldValue(i, "minflg"));
        }
        if (actionRequest.getFieldValue(i, "maxflg") != null) {
            this.setMaxflg(actionRequest.getFieldValue(i, "maxflg"));
        }
        if (actionRequest.getFieldValue(i, "rate") != null && actionRequest.getFieldValue(i, "rate").trim().length() > 0) {
            this.setRate(Double.parseDouble(actionRequest.getFieldValue(i, "rate")));
        }
        if (actionRequest.getFieldValue(i, "altertimes") != null && actionRequest.getFieldValue(i, "altertimes").trim().length() > 0) {
            this.setAltertimes(Integer.parseInt(actionRequest.getFieldValue(i, "altertimes")));
        }
    }

    public void init(ActionRequest actionRequest) throws Exception {
        this.init(0, actionRequest);
    }

    public void initAll(int i, ActionRequest actionRequest) throws Exception {
        this.init(i, actionRequest);
    }

    public void initAll(ActionRequest actionRequest) throws Exception {
        this.initAll(0, actionRequest);
    }

    public Object clone() throws CloneNotSupportedException {
        LNPCREDITLEVEL obj = (LNPCREDITLEVEL) super.clone();
        obj.setPreditlevelid(obj.preditlevelid);
        obj.setPreditlevelname(obj.preditlevelname);
        obj.setMinamt(obj.minamt);
        obj.setMaxamt(obj.maxamt);
        obj.setMinflg(obj.minflg);
        obj.setMaxflg(obj.maxflg);
        obj.setRate(obj.rate);
        obj.setAltertimes(obj.altertimes);
        return obj;
    }
}