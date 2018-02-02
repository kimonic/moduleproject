package com.kimonic.notebook.litemapbean;

import org.litepal.crud.DataSupport;

/**
 * * ===============================================================
 * name:             SaveDataLMBean
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/2
 * description：
 * history：
 * *==================================================================
 */

public class SaveDataLMBean extends DataSupport {

    /**用户名*/
    private  String  userName;
    /**标签名*/
    private  String  item;
    /**标签数值*/
    private  float   value;
    /**创建日期标签*/
    private  String  dataFlag;
    /**item唯一标识*/
    private  String  itemFlag;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getDataFlag() {
        return dataFlag;
    }

    public void setDataFlag(String dataFlag) {
        this.dataFlag = dataFlag;
    }

    public String getItemFlag() {
        return itemFlag;
    }

    public void setItemFlag(String itemFlag) {
        this.itemFlag = itemFlag;
    }
}
