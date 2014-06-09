package com.ccb.mortgage;

import com.ccb.dao.LNTASKINFO;
import com.ccb.util.SeqUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import pub.platform.db.DatabaseConnection;
import pub.platform.db.RecordSet;
import pub.platform.utils.BusinessDate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MortUtil {
    private static final Log logger = LogFactory.getLog(MortUtil.class);

    /**
     * �����Ѻ������
     *
     * @param p_releaseConCd �ſʽ
     * @param p_mortDate     ��Ѻ����
     * @param dc             ���ݿ����Ӷ���
     * @param p_loanid       ��ѺID
     * @param p_center       ��Ѻ��������
     * @return
     */
    public static String getMortExpireDate(String p_releaseConCd, String p_mortDate, DatabaseConnection dc,
                                           String p_loanid, String p_center) {
        // ��Ѻ������
        String mortExpireDate = "";
        // �ſʽ
        String releaseConCD = p_releaseConCd;
        // ��Ѻ��������
        String mortDate = p_mortDate;

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = null;

        // ����ִ�ſ�
        // ��ϻ�ִ�ſ�
        // ��Ѻ��������+2��=��Ѻ������
        // if (releaseConCD.equals("02") || releaseConCD.equals("05")) {
        // calendar = new GregorianCalendar();
        // int year = Integer.parseInt(mortDate.substring(0, 4));
        // int month = Integer.parseInt(mortDate.substring(5, 7));
        // int day = Integer.parseInt(mortDate.substring(8, 10));
        // calendar.set(Calendar.YEAR, year);
        // calendar.set(Calendar.MONTH, month - 1);
        // calendar.set(Calendar.DAY_OF_MONTH, day);
        // calendar.add(Calendar.DATE, 2);
        // mortExpireDate = df.format(calendar.getTime());
        // }


        // ǩԼ�ſ�
        // ���ǩԼ�ſ�
        // ���÷ſ�
        // �������ڣ�������Ŀ������ڣ�+���ݺ�����Ŀ���ƴ�¥�̹���һ������ȡ�õİ���ʱ��(��������������Ѻ����ʱ�ޣ��죩)=��Ѻ������
        if (releaseConCD.equals("03") || releaseConCD.equals("06")) {
            // ȡ������Ŀ�������
            String openDate = "";
            // ��Ŀ���
            String projNo = "";
            // ������Ѻ����ʱ��
            String mortPeriod = "";
            calendar = new GregorianCalendar();
            RecordSet rs = dc.executeQuery(" select CUST_OPEN_DT,PROJ_NO from LN_LOANAPPLY where loanid='" + p_loanid
                    + "'");
            if (rs.next()) {
                openDate = rs.getString("CUST_OPEN_DT");
                projNo = rs.getString("PROJ_NO");
                // ��Ŀ���
                if (projNo == null || projNo.equals("")) {
                    return "";
                }
            }

            //zhanrui 20110307 �޸Ķ��ڿ������ĺ�����Ŀ  ��Ѻ��ʱ�޼��㷽ʽ
            String devlnBankFlag = "";
            String devlnTimeLimitType = "";
            String devlnEndDate = "";
            rs = dc.executeQuery("select FOLLOWUPMORTPERIOD, DEVLNENDDATE, BANKFLAG, DEVLNTIMELIMITTYE  from LN_COOPPROJ where proj_no='" + projNo + "'");
            // ��������ʱ��
            if (rs.next()) {
                mortPeriod = rs.getString("FOLLOWUPMORTPERIOD");
                devlnTimeLimitType = rs.getString("DEVLNTIMELIMITTYE");
                devlnEndDate = rs.getString("DEVLNENDDATE");
                //�����ֶ�У��
                if (mortPeriod == null || mortPeriod.equals("")) {
                    return "";
                }
                devlnBankFlag = rs.getString("BANKFLAG");
                if (devlnBankFlag == null || devlnBankFlag.equals("0")) {//�޿����������
                    //;
                } else {
                    if (devlnTimeLimitType == null || devlnTimeLimitType.equals("")) {
                        logger.error("��ȡ��������Ѻ����ʱ�޷�ʽ���ִ����ֶ�����Ϊ�գ�");
                        return "";
                    }
                    if ("2".equals(devlnTimeLimitType)) {//������ǰ������Ѻ
                        if (devlnEndDate == null || devlnEndDate.equals("")) {
                            logger.error("������ǰ������Ѻʱ��������ֹ���ڲ���Ϊ�գ�");
                            return "";
                        }
                    }
                }
            }
            // rs�ر�
            if (rs != null) {
                rs.close();
            }
            // ��������
            if (openDate == null || openDate.equals("")) {
                return "";
            } else {
                // ��������
                if (openDate.length() == 10) {
                    int year = Integer.parseInt(openDate.substring(0, 4));
                    int month = Integer.parseInt(openDate.substring(5, 7));
                    int day = Integer.parseInt(openDate.substring(8, 10));
                    calendar.set(Calendar.YEAR, year);
                    calendar.set(Calendar.MONTH, month - 1);
                    calendar.set(Calendar.DAY_OF_MONTH, day);
                    if (!"".equals(mortPeriod)) {
                        // 20100722  zhanrui  ��ǰ�޽ڼ���ά��
                        // ��ǩԼ�����ǩԼ�ĵ�Ѻ�����պͳ���������ͳһ��6��
                        int days_delay = 6;
                        int intMortperiod = Integer.parseInt(mortPeriod) + days_delay;
                        if (devlnBankFlag == null || devlnBankFlag.equals("") || devlnBankFlag.equals("0")) {
                            calendar.add(Calendar.DATE, intMortperiod);
                            mortExpireDate = df.format(calendar.getTime());
                        } else { //���л����п�����
                            if ("2".equals(devlnTimeLimitType)) {//������ǰ������Ѻ
                                Calendar cal_devlnend = new GregorianCalendar();
                                int year_devlnend = Integer.parseInt(devlnEndDate.substring(0, 4));
                                int month_devlnend = Integer.parseInt(devlnEndDate.substring(5, 7));
                                int day_devlnend = Integer.parseInt(devlnEndDate.substring(8, 10));
                                cal_devlnend.set(Calendar.YEAR, year_devlnend);
                                cal_devlnend.set(Calendar.MONTH, month_devlnend - 1);
                                cal_devlnend.set(Calendar.DAY_OF_MONTH, day_devlnend);
                                /*
                                    ������������ �� ��������ֹ����
                                    ���������� = ��������ֹ���� + ������Ѻ����ʱ��
                                    ������������ �� ��������ֹ����
                                    ���������� = ��������� + ������Ѻ����ʱ��
                                 */
                                if (calendar.before(cal_devlnend) || calendar.equals(cal_devlnend)) {
                                    cal_devlnend.add(Calendar.DATE, intMortperiod);
                                    mortExpireDate = df.format(cal_devlnend.getTime());
                                } else {
                                    calendar.add(Calendar.DATE, intMortperiod);
                                    mortExpireDate = df.format(calendar.getTime());
                                }
                            } else {
                                calendar.add(Calendar.DATE, intMortperiod);
                                mortExpireDate = df.format(calendar.getTime());
                            }
                        }
                    }
                }
            }
        }
        // ����ִ
        // ��ϻ�ִ
        // ��֤�ſ�Ĵ���
        // ��ϼ�֤�ſ�
        // �õ�Ѻ��������+1+����������Ϊ��Ѻ������
        else if (releaseConCD.equals("01") || releaseConCD.equals("04") || releaseConCD.equals("02")
                || releaseConCD.equals("05")) {
            // ��������
            String mortCenterCD = p_center;

/*

            // ��������
            String loanType = "";
            RecordSet rs = dc.executeQuery("select LN_TYP from LN_LOANAPPLY where loanid='" + p_loanid + "'");
            if (rs.next()) {
                loanType = rs.getString("LN_TYP");
            }
            // ��������
            String limitDate = "";
            // ����������������
            String limit_ln_typ = "";

            // 2010-3-10
            if (loanType != null) {
                if (loanType.equals("011") || loanType.equals("013")) { // 011����ס������
                    // 013�����ٽ���ס������
                    // ����ס������
                    limit_ln_typ = "001";
                } else {
                    // �Ǹ���ס������
                    limit_ln_typ = "002";
                }
            } else {
                // Ĭ��Ϊ����ס������
                limit_ln_typ = "001";
            }

*/
/*
   20100403 zhan
   limit_ln_typ = "001" �������ʱ������
*/
            // ��������
            String limitDate = "";

            // ����������������
            String limit_ln_typ = "002";
            RecordSet rs = dc.executeQuery("select LIMITDATE from LN_MORTLIMIT where LN_TYP='" + limit_ln_typ
                    + "' and MORTECENTERCD='" + mortCenterCD + "'");
            if (rs.next()) {
                limitDate = rs.getString("LIMITDATE");
            }
            // rs�ر�
            if (rs != null) {
                rs.close();
            }
            // ����ʱ��
            if (limitDate == null || limitDate.equals("")) {
                return "";
            } else {
                // ��Ѻ��������
                calendar = new GregorianCalendar();
                int year = Integer.parseInt(mortDate.substring(0, 4));
                int month = Integer.parseInt(mortDate.substring(5, 7));
                int day = Integer.parseInt(mortDate.substring(8, 10));
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month - 1);
                calendar.set(Calendar.DAY_OF_MONTH, day);
                calendar.add(Calendar.DATE, 1);
                calendar.add(Calendar.DATE, Integer.parseInt(limitDate));
                mortExpireDate = df.format(calendar.getTime());
            }
        } else {
            // do nothing
        }
        return mortExpireDate;
    }

    /**
     * ������־��ˮ����
     *
     * @param busiKey  ҵ������
     * @param busiNode �˵�ID
     * @param operType ��������(add��edit��delete)
     */

    public static LNTASKINFO getTaskObj(String busiKey, String busiNode, String operType) {
        // д��ˮ��¼��
        LNTASKINFO task = new LNTASKINFO();
        try {
            // ��ˮID
            task.setTaskid(SeqUtil.getTaskSeq());
            // ҵ������
            task.setLoan_id(busiKey);
            // ��Ѻ��Ϣ�Ǽǡ�ҵ�����̽ڵ�
            task.setTasktype(busiNode);
            // ��Ѻ�Ǽ�ʱ��
            task.setTasktime(BusinessDate.getTodaytime());
            task.setRemarks(operType);
            task.setLoanrecordid(operType);
        } catch (Exception e) {
            // logger.error(e.getMessage());
            e.printStackTrace();
        }
        return task;
    }
}