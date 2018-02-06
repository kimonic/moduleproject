package com.kimonic.notebook.litemapbean;

import org.litepal.crud.DataSupport;

/**
 * * ===============================================================
 * name:             DateRecordLMBean
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/6
 * description：  用户下日期记录列表
 * history：
 * *==================================================================
 */

public class DateRecordLMBean extends DataSupport {
    /**用户名*/
    private  String  userName;
    /**记录日期*/
    private  String  date;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
