package com.ccb.coverrate;

import com.ccb.dao.PTDEPT;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import pub.platform.advance.utils.PropertyManager;
import pub.platform.form.control.Action;

/**
 * Created by IntelliJ IDEA.
 * User: haiyuhuang
 * Date: 11-8-8
 * Time: 下午4:50
 * To change this template use File | Settings | File Templates.
 */
public class coverrateAction extends Action {
    // 日志对象
    private static final Log logger = LogFactory.getLog(coverrateAction.class);
    //部门对象
    PTDEPT ptdept = null;

    public int edit() {
        ptdept = new PTDEPT();
        for (int i = 0; i < this.req.getRecorderCount(); i++) {
            try {
                ptdept.init(i, req);
                if (ptdept.updateByWhere(" where deptid='" + req.getFieldValue(i, "dept_id") + "'") < 0) {
                    this.res.setType(0);
                    this.res.setResult(false);
                    this.res.setMessage(PropertyManager.getProperty("300"));
                    return -1;
                }

            } catch (Exception ex1) {
                ex1.printStackTrace();
                logger.error(ex1.getMessage());
                this.res.setType(0);
                this.res.setResult(false);
                this.res.setMessage(PropertyManager.getProperty("300"));
                return -1;
            }

        }
        this.res.setType(0);
        this.res.setResult(true);
        this.res.setMessage(PropertyManager.getProperty("200"));
        return 0;
    }
}
