package com.kimonic.notebook.backup;

import com.kimonic.notebook.litemapbean.fixedassets.DateRecordLMBean;
import com.kimonic.notebook.litemapbean.fixedassets.SaveDataLMBean;

import java.util.List;

/**
 * * ================================================
 * name:            FixedZiChanBeiFen
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：            2019/3/14
 * description：
 * history：
 * ===================================================
 */
public class FixedZiChanBeiFen {

    private List<DateRecordLMBean> dateRecordLMBeans;
    private List<List<SaveDataLMBean>> saveDataLMBeans;

    public FixedZiChanBeiFen(List<DateRecordLMBean> dateRecordLMBeans, List<List<SaveDataLMBean>> saveDataLMBeans) {
        this.dateRecordLMBeans = dateRecordLMBeans;
        this.saveDataLMBeans = saveDataLMBeans;
    }

    public List<DateRecordLMBean> getDateRecordLMBeans() {
        return dateRecordLMBeans;
    }

    public void setDateRecordLMBeans(List<DateRecordLMBean> dateRecordLMBeans) {
        this.dateRecordLMBeans = dateRecordLMBeans;
    }

    public List<List<SaveDataLMBean>> getSaveDataLMBeans() {
        return saveDataLMBeans;
    }

    public void setSaveDataLMBeans(List<List<SaveDataLMBean>> saveDataLMBeans) {
        this.saveDataLMBeans = saveDataLMBeans;
    }
}
