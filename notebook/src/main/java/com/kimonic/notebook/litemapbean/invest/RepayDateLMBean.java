package com.kimonic.notebook.litemapbean.invest;

import org.litepal.crud.DataSupport;

/**
 * * ===============================================================
 * name:             InvestDateLMBean
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/11
 * description：  回款时间时间表
 * history：
 * *==================================================================
 */

public class RepayDateLMBean extends DataSupport {
    /**
     * 回款时间
     */
    private String repayDate;
    /**
     * 用户名
     */
    private String userName;


    public String getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(String repayDate) {
        this.repayDate = repayDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
