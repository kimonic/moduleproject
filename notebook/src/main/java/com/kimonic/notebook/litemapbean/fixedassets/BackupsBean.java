package com.kimonic.notebook.litemapbean.fixedassets;

import java.util.List;

/**
 * * ===============================================================
 * name:             BackupsBean
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/5
 * method:
 * <p>
 * <p>
 * description：
 * history：
 * *==================================================================
 */

public class BackupsBean {
    private List<SaveDataLMBean>  listSaveData;
    private List<DataNameTableLMBean>  listDataNameTable;
    private List<ItemFlagLMBean>  listItemFlag;
    private List<DateRecordLMBean>  listDateRecord;

    public List<SaveDataLMBean> getListSaveData() {
        return listSaveData;
    }

    public void setListSaveData(List<SaveDataLMBean> listSaveData) {
        this.listSaveData = listSaveData;
    }

    public List<DataNameTableLMBean> getListDataNameTable() {
        return listDataNameTable;
    }

    public void setListDataNameTable(List<DataNameTableLMBean> listDataNameTable) {
        this.listDataNameTable = listDataNameTable;
    }

    public List<ItemFlagLMBean> getListItemFlag() {
        return listItemFlag;
    }

    public void setListItemFlag(List<ItemFlagLMBean> listItemFlag) {
        this.listItemFlag = listItemFlag;
    }

    public List<DateRecordLMBean> getListDateRecord() {
        return listDateRecord;
    }

    public void setListDateRecord(List<DateRecordLMBean> listDateRecord) {
        this.listDateRecord = listDateRecord;
    }
}
