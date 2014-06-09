package com.ccb.dao;
import java.util.*;
import pub.platform.db.*;
import pub.platform.utils.*;
import pub.platform.db.AbstractBasicBean;
public class LNODSBIEMPTLR extends AbstractBasicBean implements Cloneable {
     public static List find(String sSqlWhere) {           return new LNODSBIEMPTLR().findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere) {           return new LNODSBIEMPTLR().findAndLockByWhere(sSqlWhere);      }       public static LNODSBIEMPTLR findFirst(String sSqlWhere) {           return (LNODSBIEMPTLR)new LNODSBIEMPTLR().findFirstByWhere(sSqlWhere);      }       public static LNODSBIEMPTLR findFirstAndLock(String sSqlWhere) {           return (LNODSBIEMPTLR)new LNODSBIEMPTLR().findFirstAndLockByWhere(sSqlWhere);      }            public static RecordSet findRecordSet(String sSqlWhere) {           return new LNODSBIEMPTLR().findRecordSetByWhere(sSqlWhere);      }       public static List find(String sSqlWhere,boolean isAutoRelease) {           LNODSBIEMPTLR bean = new LNODSBIEMPTLR();           bean.setAutoRelease(isAutoRelease);           return bean.findByWhere(sSqlWhere);      }       public static List findAndLock(String sSqlWhere,boolean isAutoRelease) {           LNODSBIEMPTLR bean = new LNODSBIEMPTLR();           bean.setAutoRelease(isAutoRelease);           return bean.findAndLockByWhere(sSqlWhere);      }       public static LNODSBIEMPTLR findFirst(String sSqlWhere,boolean isAutoRelease) {           LNODSBIEMPTLR bean = new LNODSBIEMPTLR();           bean.setAutoRelease(isAutoRelease);           return (LNODSBIEMPTLR)bean.findFirstByWhere(sSqlWhere);      }       public static LNODSBIEMPTLR findFirstAndLock(String sSqlWhere,boolean isAutoRelease) {           LNODSBIEMPTLR bean = new LNODSBIEMPTLR();           bean.setAutoRelease(isAutoRelease);           return (LNODSBIEMPTLR)bean.findFirstAndLockByWhere(sSqlWhere);      }       public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease) {           LNODSBIEMPTLR bean = new LNODSBIEMPTLR();           bean.setAutoRelease(isAutoRelease);           return bean.findRecordSetByWhere(sSqlWhere);      }      public static List findByRow(String sSqlWhere,int row) {           return new LNODSBIEMPTLR().findByWhereByRow(sSqlWhere,row);      } String teller_id;
String bus_inst_no;
String src_sys_no;
String teller_name;
String begin_date;
String end_date;
String teller_card_no;
String dept_cd;
String stuff_no;
String teller_pos_code;
String cert_id;
String teller_stat_cd;
String teller_level_cd;
String teller_type_cd;
String teller_attr_cd;
String tlr_dcrt_sgn;
public static final String TABLENAME ="ln_odsb_iemp_tlr";
private String operate_mode = "add";
public ChangeFileds cf = new ChangeFileds();
public String getTableName() {return TABLENAME;}
public void addObject(List list,RecordSet rs) {
LNODSBIEMPTLR abb = new LNODSBIEMPTLR();
abb.teller_id=rs.getString("teller_id");abb.setKeyValue("TELLER_ID",""+abb.getTeller_id());
abb.bus_inst_no=rs.getString("bus_inst_no");abb.setKeyValue("BUS_INST_NO",""+abb.getBus_inst_no());
abb.src_sys_no=rs.getString("src_sys_no");abb.setKeyValue("SRC_SYS_NO",""+abb.getSrc_sys_no());
abb.teller_name=rs.getString("teller_name");abb.setKeyValue("TELLER_NAME",""+abb.getTeller_name());
abb.begin_date=rs.getString("begin_date");abb.setKeyValue("BEGIN_DATE",""+abb.getBegin_date());
abb.end_date=rs.getString("end_date");abb.setKeyValue("END_DATE",""+abb.getEnd_date());
abb.teller_card_no=rs.getString("teller_card_no");abb.setKeyValue("TELLER_CARD_NO",""+abb.getTeller_card_no());
abb.dept_cd=rs.getString("dept_cd");abb.setKeyValue("DEPT_CD",""+abb.getDept_cd());
abb.stuff_no=rs.getString("stuff_no");abb.setKeyValue("STUFF_NO",""+abb.getStuff_no());
abb.teller_pos_code=rs.getString("teller_pos_code");abb.setKeyValue("TELLER_POS_CODE",""+abb.getTeller_pos_code());
abb.cert_id=rs.getString("cert_id");abb.setKeyValue("CERT_ID",""+abb.getCert_id());
abb.teller_stat_cd=rs.getString("teller_stat_cd");abb.setKeyValue("TELLER_STAT_CD",""+abb.getTeller_stat_cd());
abb.teller_level_cd=rs.getString("teller_level_cd");abb.setKeyValue("TELLER_LEVEL_CD",""+abb.getTeller_level_cd());
abb.teller_type_cd=rs.getString("teller_type_cd");abb.setKeyValue("TELLER_TYPE_CD",""+abb.getTeller_type_cd());
abb.teller_attr_cd=rs.getString("teller_attr_cd");abb.setKeyValue("TELLER_ATTR_CD",""+abb.getTeller_attr_cd());
abb.tlr_dcrt_sgn=rs.getString("tlr_dcrt_sgn");abb.setKeyValue("TLR_DCRT_SGN",""+abb.getTlr_dcrt_sgn());
list.add(abb);
abb.operate_mode = "edit";
}public String getTeller_id() { if ( this.teller_id == null ) return ""; return this.teller_id;}
public String getBus_inst_no() { if ( this.bus_inst_no == null ) return ""; return this.bus_inst_no;}
public String getSrc_sys_no() { if ( this.src_sys_no == null ) return ""; return this.src_sys_no;}
public String getTeller_name() { if ( this.teller_name == null ) return ""; return this.teller_name;}
public String getBegin_date() { if ( this.begin_date == null ) return ""; return this.begin_date;}
public String getEnd_date() { if ( this.end_date == null ) return ""; return this.end_date;}
public String getTeller_card_no() { if ( this.teller_card_no == null ) return ""; return this.teller_card_no;}
public String getDept_cd() { if ( this.dept_cd == null ) return ""; return this.dept_cd;}
public String getStuff_no() { if ( this.stuff_no == null ) return ""; return this.stuff_no;}
public String getTeller_pos_code() { if ( this.teller_pos_code == null ) return ""; return this.teller_pos_code;}
public String getCert_id() { if ( this.cert_id == null ) return ""; return this.cert_id;}
public String getTeller_stat_cd() { if ( this.teller_stat_cd == null ) return ""; return this.teller_stat_cd;}
public String getTeller_level_cd() { if ( this.teller_level_cd == null ) return ""; return this.teller_level_cd;}
public String getTeller_type_cd() { if ( this.teller_type_cd == null ) return ""; return this.teller_type_cd;}
public String getTeller_attr_cd() { if ( this.teller_attr_cd == null ) return ""; return this.teller_attr_cd;}
public String getTlr_dcrt_sgn() { if ( this.tlr_dcrt_sgn == null ) return ""; return this.tlr_dcrt_sgn;}
public void setTeller_id(String teller_id) { sqlMaker.setField("teller_id",teller_id,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getTeller_id().equals(teller_id)) cf.add("teller_id",this.teller_id,teller_id); } this.teller_id=teller_id;}
public void setBus_inst_no(String bus_inst_no) { sqlMaker.setField("bus_inst_no",bus_inst_no,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getBus_inst_no().equals(bus_inst_no)) cf.add("bus_inst_no",this.bus_inst_no,bus_inst_no); } this.bus_inst_no=bus_inst_no;}
public void setSrc_sys_no(String src_sys_no) { sqlMaker.setField("src_sys_no",src_sys_no,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getSrc_sys_no().equals(src_sys_no)) cf.add("src_sys_no",this.src_sys_no,src_sys_no); } this.src_sys_no=src_sys_no;}
public void setTeller_name(String teller_name) { sqlMaker.setField("teller_name",teller_name,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getTeller_name().equals(teller_name)) cf.add("teller_name",this.teller_name,teller_name); } this.teller_name=teller_name;}
public void setBegin_date(String begin_date) { sqlMaker.setField("begin_date",begin_date,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getBegin_date().equals(begin_date)) cf.add("begin_date",this.begin_date,begin_date); } this.begin_date=begin_date;}
public void setEnd_date(String end_date) { sqlMaker.setField("end_date",end_date,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getEnd_date().equals(end_date)) cf.add("end_date",this.end_date,end_date); } this.end_date=end_date;}
public void setTeller_card_no(String teller_card_no) { sqlMaker.setField("teller_card_no",teller_card_no,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getTeller_card_no().equals(teller_card_no)) cf.add("teller_card_no",this.teller_card_no,teller_card_no); } this.teller_card_no=teller_card_no;}
public void setDept_cd(String dept_cd) { sqlMaker.setField("dept_cd",dept_cd,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getDept_cd().equals(dept_cd)) cf.add("dept_cd",this.dept_cd,dept_cd); } this.dept_cd=dept_cd;}
public void setStuff_no(String stuff_no) { sqlMaker.setField("stuff_no",stuff_no,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getStuff_no().equals(stuff_no)) cf.add("stuff_no",this.stuff_no,stuff_no); } this.stuff_no=stuff_no;}
public void setTeller_pos_code(String teller_pos_code) { sqlMaker.setField("teller_pos_code",teller_pos_code,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getTeller_pos_code().equals(teller_pos_code)) cf.add("teller_pos_code",this.teller_pos_code,teller_pos_code); } this.teller_pos_code=teller_pos_code;}
public void setCert_id(String cert_id) { sqlMaker.setField("cert_id",cert_id,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getCert_id().equals(cert_id)) cf.add("cert_id",this.cert_id,cert_id); } this.cert_id=cert_id;}
public void setTeller_stat_cd(String teller_stat_cd) { sqlMaker.setField("teller_stat_cd",teller_stat_cd,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getTeller_stat_cd().equals(teller_stat_cd)) cf.add("teller_stat_cd",this.teller_stat_cd,teller_stat_cd); } this.teller_stat_cd=teller_stat_cd;}
public void setTeller_level_cd(String teller_level_cd) { sqlMaker.setField("teller_level_cd",teller_level_cd,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getTeller_level_cd().equals(teller_level_cd)) cf.add("teller_level_cd",this.teller_level_cd,teller_level_cd); } this.teller_level_cd=teller_level_cd;}
public void setTeller_type_cd(String teller_type_cd) { sqlMaker.setField("teller_type_cd",teller_type_cd,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getTeller_type_cd().equals(teller_type_cd)) cf.add("teller_type_cd",this.teller_type_cd,teller_type_cd); } this.teller_type_cd=teller_type_cd;}
public void setTeller_attr_cd(String teller_attr_cd) { sqlMaker.setField("teller_attr_cd",teller_attr_cd,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getTeller_attr_cd().equals(teller_attr_cd)) cf.add("teller_attr_cd",this.teller_attr_cd,teller_attr_cd); } this.teller_attr_cd=teller_attr_cd;}
public void setTlr_dcrt_sgn(String tlr_dcrt_sgn) { sqlMaker.setField("tlr_dcrt_sgn",tlr_dcrt_sgn,Field.TEXT); if (this.operate_mode.equals("edit")) { if (!this.getTlr_dcrt_sgn().equals(tlr_dcrt_sgn)) cf.add("tlr_dcrt_sgn",this.tlr_dcrt_sgn,tlr_dcrt_sgn); } this.tlr_dcrt_sgn=tlr_dcrt_sgn;}
public void init(int i,ActionRequest actionRequest) throws Exception { if ( actionRequest.getFieldValue(i,"teller_id") !=null ) {this.setTeller_id(actionRequest.getFieldValue(i,"teller_id"));}
if ( actionRequest.getFieldValue(i,"bus_inst_no") !=null ) {this.setBus_inst_no(actionRequest.getFieldValue(i,"bus_inst_no"));}
if ( actionRequest.getFieldValue(i,"src_sys_no") !=null ) {this.setSrc_sys_no(actionRequest.getFieldValue(i,"src_sys_no"));}
if ( actionRequest.getFieldValue(i,"teller_name") !=null ) {this.setTeller_name(actionRequest.getFieldValue(i,"teller_name"));}
if ( actionRequest.getFieldValue(i,"begin_date") !=null ) {this.setBegin_date(actionRequest.getFieldValue(i,"begin_date"));}
if ( actionRequest.getFieldValue(i,"end_date") !=null ) {this.setEnd_date(actionRequest.getFieldValue(i,"end_date"));}
if ( actionRequest.getFieldValue(i,"teller_card_no") !=null ) {this.setTeller_card_no(actionRequest.getFieldValue(i,"teller_card_no"));}
if ( actionRequest.getFieldValue(i,"dept_cd") !=null ) {this.setDept_cd(actionRequest.getFieldValue(i,"dept_cd"));}
if ( actionRequest.getFieldValue(i,"stuff_no") !=null ) {this.setStuff_no(actionRequest.getFieldValue(i,"stuff_no"));}
if ( actionRequest.getFieldValue(i,"teller_pos_code") !=null ) {this.setTeller_pos_code(actionRequest.getFieldValue(i,"teller_pos_code"));}
if ( actionRequest.getFieldValue(i,"cert_id") !=null ) {this.setCert_id(actionRequest.getFieldValue(i,"cert_id"));}
if ( actionRequest.getFieldValue(i,"teller_stat_cd") !=null ) {this.setTeller_stat_cd(actionRequest.getFieldValue(i,"teller_stat_cd"));}
if ( actionRequest.getFieldValue(i,"teller_level_cd") !=null ) {this.setTeller_level_cd(actionRequest.getFieldValue(i,"teller_level_cd"));}
if ( actionRequest.getFieldValue(i,"teller_type_cd") !=null ) {this.setTeller_type_cd(actionRequest.getFieldValue(i,"teller_type_cd"));}
if ( actionRequest.getFieldValue(i,"teller_attr_cd") !=null ) {this.setTeller_attr_cd(actionRequest.getFieldValue(i,"teller_attr_cd"));}
if ( actionRequest.getFieldValue(i,"tlr_dcrt_sgn") !=null ) {this.setTlr_dcrt_sgn(actionRequest.getFieldValue(i,"tlr_dcrt_sgn"));}
}public void init(ActionRequest actionRequest) throws Exception { this.init(0,actionRequest);}public void initAll(int i,ActionRequest actionRequest) throws Exception { this.init(i,actionRequest);}public void initAll(ActionRequest actionRequest) throws Exception { this.initAll(0,actionRequest);}public Object clone() throws CloneNotSupportedException { LNODSBIEMPTLR obj = (LNODSBIEMPTLR)super.clone();obj.setTeller_id(obj.teller_id);
obj.setBus_inst_no(obj.bus_inst_no);
obj.setSrc_sys_no(obj.src_sys_no);
obj.setTeller_name(obj.teller_name);
obj.setBegin_date(obj.begin_date);
obj.setEnd_date(obj.end_date);
obj.setTeller_card_no(obj.teller_card_no);
obj.setDept_cd(obj.dept_cd);
obj.setStuff_no(obj.stuff_no);
obj.setTeller_pos_code(obj.teller_pos_code);
obj.setCert_id(obj.cert_id);
obj.setTeller_stat_cd(obj.teller_stat_cd);
obj.setTeller_level_cd(obj.teller_level_cd);
obj.setTeller_type_cd(obj.teller_type_cd);
obj.setTeller_attr_cd(obj.teller_attr_cd);
obj.setTlr_dcrt_sgn(obj.tlr_dcrt_sgn);
return obj;}}