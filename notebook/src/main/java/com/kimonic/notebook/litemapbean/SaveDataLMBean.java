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
    /**资产类别*/
    private  String  item;
    /**资产价值*/
    private  float   value;
    /**创建日期*/
    private  String  dateFlag;
    /**item唯一标识*/
    private  String  itemFlag;
    /**保存数据年份*/
    private String  year;
    /**保存数据月份*/
    private  String  month;
    /**资产备注*/
    private  String  mark;
    /**唯一标识id*/
    public  long  myExtendId;

    public long getMyExtendId() {
        return getBaseObjId();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

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

    public String getDateFlag() {
        return dateFlag;
    }

    public void setDateFlag(String dateFlag) {
        this.dateFlag = dateFlag;
    }

    public String getItemFlag() {
        return itemFlag;
    }

    public void setItemFlag(String itemFlag) {
        this.itemFlag = itemFlag;
    }

    @Override
    public String toString() {
        return "{用户名--" +
                userName +
                ",标签名--" +
                item +
                ",标签数值--" +
                String.valueOf(value) +
                ",创建日期--" +
                dateFlag +
                "}\n\n";
    }
}
