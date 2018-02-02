package com.kimonic.notebook.litemapbean;

import org.litepal.crud.DataSupport;

/**
 * * ===============================================================
 * name:             ItemFlagLMBean
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/2
 * description：
 * history：
 * *==================================================================
 */

public class ItemFlagLMBean extends DataSupport {
    /**用户名*/
    private  String  userName;
    /**标签名*/
    private  String  itemName;
    /**标签唯一id*/
    private  String  itemFlag;

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

    public String getItemFlag() {
        return itemFlag;
    }

    public void setItemFlag(String itemFlag) {
        this.itemFlag = itemFlag;
    }
}
