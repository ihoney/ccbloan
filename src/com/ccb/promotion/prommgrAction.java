package com.ccb.promotion;

import com.ccb.dao.LNPROMMGRINFO;
import com.ccb.util.SeqUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import pub.platform.advance.utils.PropertyManager;
import pub.platform.form.control.Action;

/**
 * Created by IntelliJ IDEA.
 * User: haiyuhuang
 * Date: 11-8-8
 * Time: 上午9:50
 * To change this template use File | Settings | File Templates.
 */
public class prommgrAction extends Action {
    // 日志对象
    private static final Log logger = LogFactory.getLog(prommgrAction.class);
    //营销经理码表
    LNPROMMGRINFO lnprommgrinfo = null;

    public int add() {
        lnprommgrinfo = new LNPROMMGRINFO();
        for (int i = 0; i < this.req.getRecorderCount(); i++) {
            try {
                lnprommgrinfo.init(i, req);
                String tempprommgrid = SeqUtil.getPrommgrid();
                lnprommgrinfo.setPrommgr_id(tempprommgrid);
                if (lnprommgrinfo.insert() < 0) {
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
