package com.ccb.datatrans;

import com.ccb.dao.LNMORTINFO;
import com.ccb.mortgage.MortUtil;
import pub.platform.db.ConnectionManager;
import pub.platform.db.DatabaseConnection;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhanrui
 * Date: 2010-3-27
 * Time: 22:18:22
 * To change this template use File | Settings | File Templates.
 */
public class UpdateMortDate {

    //更新抵押表中所有记录的抵押到期日

    public static void updateMortExpireDate() {
        ConnectionManager cm = ConnectionManager.getInstance();
        DatabaseConnection dc = cm.getConnection();

        LNMORTINFO mortinfo = new LNMORTINFO();
        List<LNMORTINFO> mortinfos = mortinfo.findByWhere(" where 1=1 ");

        String expireDate = null;
        String releasecondCD = null;
        String mortDate = null;
        String loanID = null;
        String mortCenterCD = null;
        int i = 0;
        int j = 0;

        dc.setAuto(false);
        dc.begin();
        for (LNMORTINFO mort : mortinfos) {
            releasecondCD = mort.getReleasecondcd();
            mortDate = mort.getMortdate();
            loanID = mort.getLoanid();
            mortCenterCD = mort.getMortecentercd();

            if (releasecondCD == null
                    || mortDate == null || loanID == null
                    || mortCenterCD == null ) {
                j++;
            } else {
                expireDate = MortUtil.getMortExpireDate(releasecondCD, mortDate,
                        dc, loanID, mortCenterCD);
                mort.setMortexpiredate(expireDate);
                mort.updateByWhere(" where mortid='" + mort.getMortid()+"'");
                i++;
            }
            System.out.println("step=" + i + " jump=" + j + expireDate);
        }
        dc.commit();
        dc.close();

    }

    public static void main(String argv[]) {
        updateMortExpireDate();
    }
}
