package com.kimonic.notebook.backup;

import com.kimonic.notebook.litemapbean.memorandum.MemorandumLMBean;

import java.util.List;

/**
 * * ================================================
 * name:            BeiWangLuBeiFen
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：            2019/3/14
 * description：
 * history：
 * ===================================================
 */
public class BeiWangLuBeiFen {
    private List<MemorandumLMBean> list;

    public BeiWangLuBeiFen(List<MemorandumLMBean> list) {
        this.list = list;
    }

    public List<MemorandumLMBean> getList() {
        return list;
    }

    public void setList(List<MemorandumLMBean> list) {
        this.list = list;
    }
}
