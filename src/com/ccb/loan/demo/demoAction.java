package com.ccb.loan.demo;

import com.ccb.dao.*;
import com.ccb.util.SeqUtil;

import pub.platform.form.control.Action;
import pub.platform.utils.BusinessDate;

public class demoAction extends Action {
  PTDEMO file = null;

  /*
   * 删除记录
   */
  public int delete() {
    try {
      String fileId = req.getFieldValue("fileId");
      dc.executeUpdate("delete from ptdemo where file_id='" + fileId + "'");

    } catch (Exception e) {
      e.printStackTrace();
      this.res.setType(0);
      this.res.setResult(false);
      this.res.setMessage("删除记录失败!");
      return -1;
    }

    this.res.setType(0);
    return 0;
  }

  // /文字发布增加接口
  public int add() {
    String file_id = "";
      //SeqUtil.getSeq("file");
    file = new PTDEMO();
    for (int i = 0; i < this.req.getRecorderCount(); i++) {
      try {

        file.initAll(i, req);
        file.setFile_id(file_id);
        // file.setfileinfo_content(StringUtil.parseStr(req.getFieldValue("fileinfo_content")));
        file.setFile_userid(this.getOperator().getFillint6());
        file.setFile_deptid(this.getDept().getDeptid());
        file.setFile_date(BusinessDate.getToday());

        if (file.insert() < 0) {
          this.res.setType(0);
          this.res.setResult(false);
          this.res.setMessage("文件发布失败!");
          return -1;
        }

      } catch (Exception ex1) {
        ex1.printStackTrace();
        this.res.setType(0);
        this.res.setResult(false);
        this.res.setMessage("文件发布失败!");
        return -1;
      }
    }
    this.res.setType(0);
    this.res.setResult(true);
    this.res.setMessage("文件发布成功!");
    return 0;
  }

  // /文字发布编辑接口
  public int edit() {

    file = new PTDEMO();
    for (int i = 0; i < this.req.getRecorderCount(); i++) {
      try {
        file.initAll(i, req);

        if (file.updateByWhere(" where file_id='" + req.getFieldValue(i, "file_id") + "'") < 0) {
          this.res.setType(0);
          this.res.setResult(false);
          this.res.setMessage("文件发布失败!");
          return -1;
        }

      } catch (Exception ex1) {
        ex1.printStackTrace();
        this.res.setType(0);
        this.res.setResult(false);
        this.res.setMessage("文件发布失败!");
        return -1;
      }
    }
    this.res.setType(0);
    this.res.setResult(true);
    this.res.setMessage("文件发布成功!");
    return 0;
  }

}
