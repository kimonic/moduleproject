package com.kimonic.notebook.litemapbean.invest;

import org.litepal.crud.DataSupport;

/**
 * * ===============================================================
 * name:             InvestDateLMBean
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/11
 * description：  投资平台表
 * history：
 * *==================================================================
 */

public class InvestPlateformLMBean extends DataSupport {
    /**
     * 投资平台
     */
    private String investPlateform;
    /**
     * 用户名
     */
    private String userName;

    public String getInvestPlateform() {
        return investPlateform;
    }

    public void setInvestPlateform(String investPlateform) {
        this.investPlateform = investPlateform;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
