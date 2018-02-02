package com.kimonic.notebook.litemapbean;

import org.litepal.crud.DataSupport;

/**
 * * ===============================================================
 * name:             DataNameTableLMBean
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/2
 * description：
 * history：
 * *==================================================================
 */

public class DataNameTableLMBean extends DataSupport {

    /**
     *
     */
    private String  passWord;
    private String user;

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
