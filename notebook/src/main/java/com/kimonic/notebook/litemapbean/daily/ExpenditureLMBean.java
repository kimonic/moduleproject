package com.kimonic.notebook.litemapbean.daily;

import org.litepal.crud.DataSupport;

/**
 * * ===============================================================
 * name:             ExpenditureLMBean
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/2
 * description：  支出记录保存
 * history：
 * *==================================================================
 */

public class ExpenditureLMBean extends DataSupport {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 标签名
     */
    private String itemName;
    /**
     * 创建年份
     */
    private String year;
    /**
     * 创建月份
     */
    private String month;
    /**
     * 创建日期
     */
    private String date;
    /**
     * 消费金额
     */
    private float amount;
    /**
     * 消费备注
     */
    private String mark;
    /**
     * 标签唯一id
     */
    private long itemFlag;

    /**完整日期*/
    private String completeDate;

    public String getCompleteDate() {
        return year+"-"+month+"-"+date;
    }

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public long getItemFlag() {
        return getBaseObjId();
    }
}
