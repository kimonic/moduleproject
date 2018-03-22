package com.kimonic.notebook.litemapbean.fixedassets;

import org.litepal.crud.DataSupport;

/**
 * * ===============================================================
 * name:             ExpenditureLMBean
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/2
 * description：  固定资产资产类别记录表
 * history：
 * *==================================================================
 */

public class ItemFlagLMBean extends DataSupport {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 标签名
     */
    private String itemName;
    /**
     * 标签唯一id
     */
    private long itemFlag;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public long getItemFlag() {
        return itemFlag;
    }

    public void setItemFlag(long itemFlag) {
        this.itemFlag = itemFlag;
    }
}
