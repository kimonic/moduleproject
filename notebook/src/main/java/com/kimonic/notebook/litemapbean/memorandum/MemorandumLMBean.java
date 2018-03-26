package com.kimonic.notebook.litemapbean.memorandum;

import org.litepal.crud.DataSupport;

/**
 * * ===============================================================
 * name:             MemorandumLMBean
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/26
 * method:
 * <p>
 * <p>
 * description：
 * history：
 * *==================================================================
 */

public class MemorandumLMBean extends DataSupport {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 标题
     */
    private String title;
    /**
     * 标签
     */
    private String flag;
    /**
     * 内容
     */
    private String content;
    /**
     * 记录日期--日--01
     */
    private String day;
    /**
     * 记录日期--月
     */
    private String month;
    /**
     * 记录日期--年
     */
    private String year;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public long getId() {
        return getBaseObjId();
    }

    public String  getCompleteDate(){
        return year+"-"+month+"-"+day;
    }
}
