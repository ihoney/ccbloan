package com.ccb.util;

import java.util.Date;

import pub.platform.db.SequenceManager;
import pub.platform.utils.StringUtils;

public class SeqUtil {

    // 生成内部序号
    // 
    public static String getNbxh() {
        String temp = "" + SequenceManager.nextID(CcbLoanConst.NBXH);
        String rtn = StringUtils.toDateFormat(new Date(), "yyyyMMdd") + StringUtils.addPrefix(temp, "0", 7);
        return rtn;
    }

    // 生成抵押编号
    public static String getMortID() {
        String temp = "" + SequenceManager.nextID(CcbLoanConst.MORTTYPE);
        String rtn = StringUtils.toDateFormat(new Date(), "yyyy") + StringUtils.addPrefix(temp, "0", 5);
        return rtn;
    }

    // 合作项目编号
    public static String getCoop() {
        String temp = "" + SequenceManager.nextID(CcbLoanConst.COOPTYPE);
        String rtn = StringUtils.toDateFormat(new Date(), "yyyyMMdd") + StringUtils.addPrefix(temp, "0", 5);
        return rtn;
    }
    //推介客户顺序号
    public static String getPromontioncustno() {
        String temp = "" + SequenceManager.nextID(CcbLoanConst.PROMONTIONNO);
        String rtn = StringUtils.toDateFormat(new Date(),"yyyyMMdd") + StringUtils.addPrefix(temp,"0",5);
        return rtn;
    }
    //营销客户经理ID
    public static String getPrommgrid() {
        String temp = "" + SequenceManager.nextID(CcbLoanConst.PROMMGR_ID);
        String rtn = StringUtils.toDateFormat(new Date(),"yyyyMMdd") + StringUtils.addPrefix(temp,"0",5);
        return rtn;
    }
    // 生成流水序号
    public static String getTaskSeq() {
        String temp = "" + SequenceManager.nextID(CcbLoanConst.TASKSEQ);
        String rtn = StringUtils.toDateFormat(new Date(), "yyyyMMdd") + StringUtils.addPrefix(temp, "0", 7);
        return rtn;
    }

    /*
     * 生成业务需要的唯一序号
     */

    // public static String getSeq(String seqName) {
    //
    // DatabaseConnection dc = null;
    // String seq = "";
    // dc = ConnectionManager.getInstance().getConnection();
    // Connection conn = dc.getConnection();
    // Statement st = null;
    // ResultSet rs = null;
    // StringBuffer sb = null;
    //
    // // 检查废弃表有无可用序号
    // RecordSet recSet =
    // dc.executeQuery("select discardno from sys_seq_discard where bhlx='" +
    // CcbLoanConst.MORTTYPE
    // + "' and useflg='0' order by discardno asc ");
    // if (recSet.next()) {
    // seq = recSet.getString("discardno");
    // }
    // // 在seq为null的情况下重新生成新的序号
    // if(seq.equals("")||seq.equals("null")){
    // // 新生成序号
    // // 当前编号、编号位数
    // int dqbh;
    // int bhws = 0;
    // String rq = "";
    // String[] rq2 = null;
    // try {
    // st = conn.createStatement();
    // sb = new StringBuffer();
    // rs = st.executeQuery("select DQBH,BHWS,RQ from sys_seq where bhlx='" +
    // seqName + "'");
    //
    // rs.next();
    // // 当前编号
    // dqbh = rs.getInt("DQBH");
    // // 编号位数
    // bhws = rs.getInt("BHWS");
    // // 最后更新日期
    // rq2 = rs.getString("RQ").toString().trim().split(" ");
    // rq = rq2[0].substring(0, 4);
    // // yyyy-mm-dd format
    // // 如果年份变化，则从0重新开始编号
    // if (BusinessDate.getYear().equals(rq)) {
    // int len = String.valueOf(dqbh).length();
    // if (len < bhws) {
    // for (int i = 0; i < (bhws - len); i++) {
    // sb.append("0");
    // }
    // }
    // seq = StringUtils.toDateFormat(new Date(), "yyyy") + sb.toString() +
    // String.valueOf(dqbh);
    // dqbh += 1;
    // } else {
    // dqbh = 1;
    // seq = StringUtils.toDateFormat(new Date(), "yyyy") + "00001";
    // dqbh += 1;
    // }
    // // yyyy 格式更新年份，则更新后的日期为年份后带-01-01 不影响判断
    // dc.executeUpdate("update sys_seq set dqbh=" + dqbh + ",rq=to_date('" +
    // BusinessDate.getYear()
    // + "','yyyy') where bhlx='" + seqName + "'");
    //
    // } catch (SQLException ex) {
    // System.out.println(ex.getSQLState());
    // } finally {
    // ConnectionManager.getInstance().releaseConnection(dc);
    // }
    // }else{
    // return seq;
    // }
    //    
    // return seq;
    // }

    public static void main(String[] args) throws Exception {
        System.out.println(getCoop());
    }
}
