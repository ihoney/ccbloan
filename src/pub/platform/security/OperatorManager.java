package pub.platform.security;

import pub.platform.advance.utils.PropertyManager;
import pub.platform.db.ConnectionManager;
import pub.platform.db.DatabaseConnection;
import pub.platform.system.manage.dao.PtDeptBean;
import pub.platform.system.manage.dao.PtOperBean;
import pub.platform.utils.BusinessDate;
import pub.platform.utils.ImgSign;

import java.io.File;
import java.io.Serializable;
import java.util.List;



/**
 * <p>
 * Title: OperatorManager.java
 * </p>
 * <p>
 * Description: This class includes the basic behaviors of operator.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2003
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author WangHaiLei
 * @version 1.6 $ UpdateDate: Y-M-D-H-M: 2003-12-02-09-50 2004-03-01-20-35 $
 */
public class OperatorManager implements Serializable {

	/**
	 * operatorid�Ǵ�login(operatorid, password)�еõ��ġ�
	 */
	private String fimgSign = "";

	
	
	
	private String operatorname = null;

	private String operatorid = null;

	private String xmlString = null;

	private Resources resources;

	private String[] roles = new String[] {};

	private MenuBean mb;

	private List jsplist = null;

	private PtOperBean operator;

	private String remoteAddr = null;

	private String remoteHost = null;

	private String loginTime = BusinessDate.getTodaytime();

	private boolean isLogin = false;

	private String filePath = "";

	private String safySign = "";

	public OperatorManager() {

		// //����ͼƬ��ʾ
		createImgSign();
	}

	/**
	 * 
	 * @return
	 */
	public String getXmlString() {
		return (this.xmlString);
	}

	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * ����һ��Operator Object�����Ojbect�а����ò���Ա�Ļ�����Ϣ��������operid, email, enabled, sex,
	 * status, opername��
	 * 
	 * @return Operator Ojbect.
	 */
	public PtOperBean getOperator() {
		return operator;
	}

	public String filePath() {
		return filePath;
	}

	/**
	 * �õ���ǰ����Ա��operatorname��
	 * 
	 * @return
	 */
	public String getOperatorName() {
		return operator.getOpername();
	}

	/**
	 * ��MethodĿǰӦ��û�������ˣ�ԭ����Ϊ�˸���username�õ��ò���Ա��userId�� ����ֱ����operid����ʾһ��Operator��
	 * 
	 * @return
	 */
	public String getOperatorId() throws Exception {
		return operatorid;
	}

	/**
	 * ����Աǩ������֤operid+passwd�Ƿ���ȷ ǩ���ɹ��� 1.isLogin=true 2.ȡ�øò���Ա��ص����н�ɫ 3.��ʼ����Դ�б�
	 * 4.ȡ�ò���Ա�Ĳ˵�
	 * 
	 * @param operid
	 * @param password
	 * @return boolean
	 * @roseuid 3F80B6360281
	 */
	public boolean login(String operid, String password) {

		ConnectionManager cm = ConnectionManager.getInstance();
		DatabaseConnection dc = cm.get();
		try {
/*
			String loginWhere = "where operid='" + operid
					+ "' and operpasswd ='" + password + "'and operenabled='1'";
*/
            //zhan 20100415 for UAAP
            if (operid == null) {
                isLogin = false;
                return false;
            }
            String loginWhere = "where operid='" + operid
                    + "' and operenabled='1'";
            this.operatorid = operid;
            operator = new PtOperBean();
            operator = (PtOperBean) operator.findFirstByWhere(loginWhere);
            if (operator == null) {
                isLogin = false;
                return false;
            }
            String sss = "��¼ʱ�� :" + loginTime + " IP: " + remoteAddr
                    + " �������� : " + remoteHost;

            operator.setFillstr600(sss);

            PtDeptBean ptpdet = new PtDeptBean();

            operator.setPtDeptBean((PtDeptBean) ptpdet
                    .findFirstByWhere("where deptid='" + operator.getDeptid()
                            + "'"));

            this.operatorname = operator.getOpername();
            isLogin = true;
            // ȡ�øò���Ա�����н�ɫ��dep
            // PtOperRoleBean porb = new PtOperRoleBean();
            // List porbs = porb.findByWhere("where operid='"+operid+"'");
            // roles = new String[porbs.size()];
            // for ( int i = 0 ; i < porbs.size() ; i++ ) {
            // roles[i] = ((PtOperRoleBean)porbs.get(i)).getRoleid();
            // }
            // ��ʼ����Դ�б���
            resources = new Resources(operid);
            // ��ʼ���˵���
            try {
                mb = new MenuBean();

                this.xmlString = mb.generateStream(operid);

            } catch (Exception ex3) {
                ex3.printStackTrace();
                System.err.println("Wrong when getting menus of operator: [ "
                        + ex3 + "]");
            }

            // ��ʼ��jsp��Դ
            // PtMenuBean pmb = new PtMenuBean();
            // List pmbs = pmb.findByWhere("where menuid in (select resname from
            // ptresource where restype='2' and resid in (select resid from
            // ptroleres where roleid in (select roleid from ptoperrole where
            // operid='"+operid+"')))");
            // jsplist = new ArrayList();
            // for ( int i = 0 ; i < pmbs.size() ; i++ ) {
            // pmb = (PtMenuBean)pmbs.get(i);
            // jsplist.add(pmb.getMenuaction());
            // }
            return isLogin;
        } catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			cm.release();
		}

	}

	/**
	 * @return ArrayList
	 * @roseuid 3F80B71A01BC
	 */
	public List getJspList() {
		return jsplist;
	}

	/**
	 * @return boolean
	 * @roseuid 3F80B71A00BC
	 */
	public boolean isLogin() {
		return isLogin;
	}

	/**
	 * ����Ȩ�� 1��ȡ���Ϸ���Դ��ʶ 2��ʹ��Resources��checkPermission����У��
	 * 
	 * @param resource
	 * @return boolean
	 * @roseuid 3F80B8590151
	 */
	public boolean checkPermission(String resource, int type, String url) {
		boolean permit = resources.checkPermission(resource, type, url);
		return permit;
	}

	/**
	 * ǩ��
	 */
	public void logout() {

		isLogin = false;
		resources = null;
		operator = null;
		operatorname = null;
		operatorid = null;
		roles = null;
		mb = null;
		xmlString = null;
		remoteHost = null;
		remoteAddr = null;
		loginTime = null;
	}

	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}

	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}

	public void createImgSign2() {

		try {
			String deptfillstr100 = PropertyManager.getProperty("cims");
			deptfillstr100 = new String(deptfillstr100.getBytes(), "GBK");
			String lastFile = System.currentTimeMillis() + "";

			ImgSign imgSign = new ImgSign();
			filePath = "/images/" + lastFile + ".jpg";
			safySign = imgSign.creatImgSign(deptfillstr100 + filePath);

		} catch (Exception e) {
		}

		/*
		 * try { String deptfillstr100 = PropertyManager.getProperty("cims");
		 * deptfillstr100 = new String(deptfillstr100.getBytes(), "GBK"); String
		 * lastFile = System.currentTimeMillis() + "";
		 * 
		 * File file = new File(deptfillstr100 + "/images"); if (!file.exists()) {
		 * file.mkdir(); }
		 * 
		 * File f = new File(deptfillstr100 + "/images"); File[] files =
		 * f.listFiles(); for (int i = 0; i < files.length; i++) { if
		 * (files[i].isFile() && files[i].exists()) {
		 * 
		 * if (Integer.parseInt((System.currentTimeMillis() + "") .substring(0,
		 * 5)) - Integer.parseInt(Util.strtoint(files[i].getName() .substring(0,
		 * 5))) > 0) files[i].delete();
		 *  } }
		 * 
		 * ImgSign imgSign = new ImgSign(); filePath = "/images/" + lastFile +
		 * ".jpg"; safySign = imgSign.creatImgSign(deptfillstr100 + filePath);
		 *  } catch (Exception e) {
		 *  }
		 */

	}

	public boolean ImgSign(String sign) {
		boolean retbool = false;

		try {
			ImgSignDel();

			if (sign.equals(safySign))
				retbool = true;

			return retbool;
		} catch (Exception e) {
			return retbool;
		}

	}

	public void ImgSignDel() {
		try {
			String deptfillstr100 = PropertyManager.getProperty("cims");
			deptfillstr100 = new String(deptfillstr100.getBytes(), "GBK");
			File f = new File(deptfillstr100 + filePath);
			if (f.exists())
				f.delete();

		} catch (Exception e) {

		}
	}

	private void createImgSign() {
		fimgSign = "";

		try {

			int rad = (int) Math.round(Math.random() * 10);
			if (rad == 10)
				rad = 9;
			fimgSign += rad;

			rad = (int) Math.round(Math.random() * 10);
			if (rad == 10)
				rad = 9;
			fimgSign += rad;

			rad = (int) Math.round(Math.random() * 10);
			if (rad == 10)
				rad = 9;
			fimgSign += rad;

			rad = (int) Math.round(Math.random() * 10);
			if (rad == 10)
				rad = 9;
			fimgSign += rad;

		} catch (Exception e) {

		}
	}

	public String getImgSign() {

		return fimgSign;
	}

}