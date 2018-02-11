package com.kimonic.notebook.litemapbean.invest;

import org.litepal.crud.DataSupport;

/**
 * * ===============================================================
 * name:             InvestDateLMBean
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/11
 * description：  投资时间表
 * history：
 * *==================================================================
 */

public class InvestDateLMBean extends DataSupport {
    /**投资时间*/
    private  String  investDate;
    /**用户名*/
    private  String  userName;

    public String getInvestDate() {
        return investDate;
    }

    public void setInvestDate(String investDate) {
        this.investDate = investDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
