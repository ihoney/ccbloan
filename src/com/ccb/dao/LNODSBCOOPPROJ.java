package com.ccb.dao;
import java.util.*;
import pub.platform.db.*;
import pub.platform.utils.*;
import pub.platform.db.AbstractBasicBean;
public class LNODSBCOOPPROJ extends AbstractBasicBean implements Cloneable {
     public static List find(String sSqlWhere) {           return new LNODSBCOOPPROJ().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere) {           return new LNODSBCOOPPROJ().findAndLockByWhere(sSqlWhere);      }       public static LNODSBCOOPPROJ findFirst(String sSqlWhere) {           return (LNODSBCOOPPROJ)new LNODSBCOOPPROJ().findFirstByWhere(sSqlWhere);      }       public static LNODSBCOOPPROJ findFirstAndLock(String sSqlWhere) {           return (LNODSBCOOPPROJ)new LNODSBCOOPPROJ().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) {           return new LNODSBCOOPPROJ().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease) {           LNODSBCOOPPROJ bean = new LNODSBCOOPPROJ();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) {           LNODSBCOOPPROJ bean = new LNODSBCOOPPROJ();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static LNODSBCOOPPROJ findFirst(String sSqlWhere,boolean isAutoRelease) {           LNODSBCOOPPROJ bean = new LNODSBCOOPPROJ();           bean.setAutoRelease(isAutoRelease);           return (LNODSBCOOPPROJ)bean.findFirstByWhere(sSqlWhere);      }       public static LNODSBCOOPPROJ findFirstAndLock(String sSqlWhere,boolean isAutoRelease) {           LNODSBCOOPPROJ bean = new LNODSBCOOPPROJ();           bean.setAutoRelease(isAutoRelease);           return (LNODSBCOOPPROJ)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease) {           LNODSBCOOPPROJ bean = new LNODSBCOOPPROJ();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      }      public static List findByRow(String sSqlWhere,int row) {           return new LNODSBCOOPPROJ().findByWhereByRow(sSqlWhere,row);      } String proj_no;
String ods_src_dt;
String corpid;
String corpname;
String proj_name;
String builaddr;
String outliceno;
String paperno;
double inveamt;
String remarks;
String bankid;
String std_opun_cod;
String operid;
int invenum;
int usetimelimt;
public static final String TABLENAME ="ln_odsb_coopproj";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
public void addObject(List list,RecordSet rs) {
LNODSBCOOPPROJ abb = new LNODSBCOOPPROJ();
abb.proj_no=rs.getString("proj_no");abb.setKeyValue("PROJ_NO",""+abb.getProj_no());
abb.ods_src_dt=rs.getString("ods_src_dt");abb.setKeyValue("ODS_SRC_DT",""+abb.getOds_src_dt());
abb.corpid=rs.getString("corpid");abb.setKeyValue("CORPID",""+abb.getCorpid());
abb.corpname=rs.getString("corpname");abb.setKeyValue("CORPNAME",""+abb.getCorpname());
abb.proj_name=rs.getString("proj_name");abb.setKeyValue("PROJ_NAME",""+abb.getProj_name());
abb.builaddr=rs.getString("builaddr");abb.setKeyValue("BUILADDR",""+abb.getBuiladdr());
abb.outliceno=rs.getString("outliceno");abb.setKeyValue("OUTLICENO",""+abb.getOutliceno());
abb.paperno=rs.getString("paperno");abb.setKeyValue("PAPERNO",""+abb.getPaperno());
abb.inveamt=rs.getDouble("inveamt");abb.setKeyValue("INVEAMT",""+abb.getInveamt());
abb.remarks=rs.getString("remarks");abb.setKeyValue("REMARKS",""+abb.getRemarks());
abb.bankid=rs.getString("bankid");abb.setKeyValue("BANKID",""+abb.getBankid());
abb.std_opun_cod=rs.getString("std_opun_cod");abb.setKeyValue("STD_OPUN_COD",""+abb.getStd_opun_cod());
abb.operid=rs.getString("operid");abb.setKeyValue("OPERID",""+abb.getOperid());
abb.invenum=rs.getInt("invenum");abb.setKeyValue("INVENUM",""+abb.getInvenum());
abb.usetimelimt=rs.getInt("usetimelimt");abb.setKeyValue("USETIMELIMT",""+abb.getUsetimelimt());
list.add(abb);
abb.operate_mode = "edit";
}public String getProj_no() { if ( this.proj_no == null ) return ""; return this.proj_no;}
public String getOds_src_dt() { if ( this.ods_src_dt == null ) return ""; return this.ods_src_dt;}
public String getCorpid() { if ( this.corpid == null ) return ""; return this.corpid;}
public String getCorpname() { if ( this.corpname == null ) return ""; return this.corpname;}
public String getProj_name() { if ( this.proj_name == null ) return ""; return this.proj_name;}
public String getBuiladdr() { if ( this.builaddr == null ) return ""; return this.builaddr;}
public String getOutliceno() { if ( this.outliceno == null ) return ""; return this.outliceno;}
public String getPaperno() { if ( this.paperno == null ) return ""; return this.paperno;}
public double getInveamt() { return this.inveamt;}
public String getRemarks() { if ( this.remarks == null ) return ""; return this.remarks;}
public String getBankid() { if ( this.bankid == null ) return ""; return this.bankid;}
public String getStd_opun_cod() { if ( this.std_opun_cod == null ) return ""; return this.std_opun_cod;}
public String getOperid() { if ( this.operid == null ) return ""; return this.operid;}
public int getInvenum() { return this.invenum;}
public int getUsetimelimt() { return this.usetimelimt;}
public void setProj_no(String proj_no) { sqlMaker.setField("proj_no",proj_no,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getProj_no().equals(proj_no)) cf.add("proj_no",this.proj_no,proj_no); } this.proj_no=proj_no;}
public void setOds_src_dt(String ods_src_dt) { sqlMaker.setField("ods_src_dt",ods_src_dt,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getOds_src_dt().equals(ods_src_dt)) cf.add("ods_src_dt",this.ods_src_dt,ods_src_dt); } this.ods_src_dt=ods_src_dt;}
public void setCorpid(String corpid) { sqlMaker.setField("corpid",corpid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCorpid().equals(corpid)) cf.add("corpid",this.corpid,corpid); } this.corpid=corpid;}
public void setCorpname(String corpname) { sqlMaker.setField("corpname",corpname,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCorpname().equals(corpname)) cf.add("corpname",this.corpname,corpname); } this.corpname=corpname;}
public void setProj_name(String proj_name) { sqlMaker.setField("proj_name",proj_name,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getProj_name().equals(proj_name)) cf.add("proj_name",this.proj_name,proj_name); } this.proj_name=proj_name;}
public void setBuiladdr(String builaddr) { sqlMaker.setField("builaddr",builaddr,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getBuiladdr().equals(builaddr)) cf.add("builaddr",this.builaddr,builaddr); } this.builaddr=builaddr;}
public void setOutliceno(String outliceno) { sqlMaker.setField("outliceno",outliceno,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getOutliceno().equals(outliceno)) cf.add("outliceno",this.outliceno,outliceno); } this.outliceno=outliceno;}
public void setPaperno(String paperno) { sqlMaker.setField("paperno",paperno,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getPaperno().equals(paperno)) cf.add("paperno",this.paperno,paperno); } this.paperno=paperno;}
public void setInveamt(double inveamt) { sqlMaker.setField("inveamt",""+inveamt,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getInveamt()!=inveamt) cf.add("inveamt",this.inveamt+"",inveamt+""); } this.inveamt=inveamt;}
public void setRemarks(String remarks) { sqlMaker.setField("remarks",remarks,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getRemarks().equals(remarks)) cf.add("remarks",this.remarks,remarks); } this.remarks=remarks;}
public void setBankid(String bankid) { sqlMaker.setField("bankid",bankid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getBankid().equals(bankid)) cf.add("bankid",this.bankid,bankid); } this.bankid=bankid;}
public void setStd_opun_cod(String std_opun_cod) { sqlMaker.setField("std_opun_cod",std_opun_cod,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getStd_opun_cod().equals(std_opun_cod)) cf.add("std_opun_cod",this.std_opun_cod,std_opun_cod); } this.std_opun_cod=std_opun_cod;}
public void setOperid(String operid) { sqlMaker.setField("operid",operid,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getOperid().equals(operid)) cf.add("operid",this.operid,operid); } this.operid=operid;}
public void setInvenum(int invenum) { sqlMaker.setField("invenum",""+invenum,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getInvenum()!=invenum) cf.add("invenum",this.invenum+"",invenum+""); } this.invenum=invenum;}
public void setUsetimelimt(int usetimelimt) { sqlMaker.setField("usetimelimt",""+usetimelimt,Field.NUMBER); if (this.operate_mode.equals("edit")) { if (this.getUsetimelimt()!=usetimelimt) cf.add("usetimelimt",this.usetimelimt+"",usetimelimt+""); } this.usetimelimt=usetimelimt;}
public void init(int i,ActionRequest actionRequest) throws Exception { if ( actionRequest.getFieldValue(i,"proj_no") !=null ) {this.setProj_no(actionRequest.getFieldValue(i,"proj_no"));}
if ( actionRequest.getFieldValue(i,"ods_src_dt") !=null ) {this.setOds_src_dt(actionRequest.getFieldValue(i,"ods_src_dt"));}
if ( actionRequest.getFieldValue(i,"corpid") !=null ) {this.setCorpid(actionRequest.getFieldValue(i,"corpid"));}
if ( actionRequest.getFieldValue(i,"corpname") !=null ) {this.setCorpname(actionRequest.getFieldValue(i,"corpname"));}
if ( actionRequest.getFieldValue(i,"proj_name") !=null ) {this.setProj_name(actionRequest.getFieldValue(i,"proj_name"));}
if ( actionRequest.getFieldValue(i,"builaddr") !=null ) {this.setBuiladdr(actionRequest.getFieldValue(i,"builaddr"));}
if ( actionRequest.getFieldValue(i,"outliceno") !=null ) {this.setOutliceno(actionRequest.getFieldValue(i,"outliceno"));}
if ( actionRequest.getFieldValue(i,"paperno") !=null ) {this.setPaperno(actionRequest.getFieldValue(i,"paperno"));}
if ( actionRequest.getFieldValue(i,"inveamt") !=null && actionRequest.getFieldValue(i,"inveamt").trim().length() > 0 ) {this.setInveamt(Double.parseDouble(actionRequest.getFieldValue(i,"inveamt")));}
if ( actionRequest.getFieldValue(i,"remarks") !=null ) {this.setRemarks(actionRequest.getFieldValue(i,"remarks"));}
if ( actionRequest.getFieldValue(i,"bankid") !=null ) {this.setBankid(actionRequest.getFieldValue(i,"bankid"));}
if ( actionRequest.getFieldValue(i,"std_opun_cod") !=null ) {this.setStd_opun_cod(actionRequest.getFieldValue(i,"std_opun_cod"));}
if ( actionRequest.getFieldValue(i,"operid") !=null ) {this.setOperid(actionRequest.getFieldValue(i,"operid"));}
if ( actionRequest.getFieldValue(i,"invenum") !=null && actionRequest.getFieldValue(i,"invenum").trim().length() > 0 ) {this.setInvenum(Integer.parseInt(actionRequest.getFieldValue(i,"invenum")));}
if ( actionRequest.getFieldValue(i,"usetimelimt") !=null && actionRequest.getFieldValue(i,"usetimelimt").trim().length() > 0 ) {this.setUsetimelimt(Integer.parseInt(actionRequest.getFieldValue(i,"usetimelimt")));}
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { LNODSBCOOPPROJ obj = (LNODSBCOOPPROJ)super.clone();obj.setProj_no(obj.proj_no);
obj.setOds_src_dt(obj.ods_src_dt);
obj.setCorpid(obj.corpid);
obj.setCorpname(obj.corpname);
obj.setProj_name(obj.proj_name);
obj.setBuiladdr(obj.builaddr);
obj.setOutliceno(obj.outliceno);
obj.setPaperno(obj.paperno);
obj.setInveamt(obj.inveamt);
obj.setRemarks(obj.remarks);
obj.setBankid(obj.bankid);
obj.setStd_opun_cod(obj.std_opun_cod);
obj.setOperid(obj.operid);
obj.setInvenum(obj.invenum);
obj.setUsetimelimt(obj.usetimelimt);
return obj;}}