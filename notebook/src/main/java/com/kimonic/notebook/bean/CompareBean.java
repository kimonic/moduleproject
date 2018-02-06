package com.kimonic.notebook.bean;

/**
 * * ===============================================================
 * name:             CompareBean
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/6
 * description：
 * history：
 * *==================================================================
 */

public class CompareBean {

    /**用户名*/
    private  String  userName;
    /**标签名*/
    private  String  item;
    /**item唯一标识*/
    private  String  itemFlag;

    /**标签数值*/
    private  float   value1;
    /**创建日期标签*/
    private  String  dateFlag1;



    /**标签数值*/
    private  float   value2;
    /**创建日期标签*/
    private  String  dateFlag2;

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

    public String getItemFlag() {
        return itemFlag;
    }

    public void setItemFlag(String itemFlag) {
        this.itemFlag = itemFlag;
    }

    public float getValue1() {
        return value1;
    }

    public void setValue1(float value1) {
        this.value1 = value1;
    }

    public String getDateFlag1() {
        return dateFlag1;
    }

    public void setDateFlag1(String dateFlag1) {
        this.dateFlag1 = dateFlag1;
    }

    public float getValue2() {
        return value2;
    }

    public void setValue2(float value2) {
        this.value2 = value2;
    }

    public String getDateFlag2() {
        return dateFlag2;
    }

    public void setDateFlag2(String dateFlag2) {
        this.dateFlag2 = dateFlag2;
    }
}
