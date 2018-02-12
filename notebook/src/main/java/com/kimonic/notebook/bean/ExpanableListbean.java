package com.kimonic.notebook.bean;

import java.util.List;

/**
 * * ===============================================================
 * name:             ExpanableListbean
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/12
 * description：
 * history：
 * *==================================================================
 */

public class ExpanableListbean {
    private String  title;
    private List<String>  child;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getChild() {
        return child;
    }

    public void setChild(List<String> child) {
        this.child = child;
    }
}
