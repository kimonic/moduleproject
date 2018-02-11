package com.kimonic.notebook.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.kimonic.utilsmodule.base.CommonAdapter;

import java.util.List;

/**
 * * ===============================================================
 * name:             ItemLVAdapter
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/5
 * description：
 * history：
 * *==================================================================
 */

public class ItemLVAdapter<ItemFlagLMBean> extends CommonAdapter {

    public ItemLVAdapter(Context context, @NonNull List<ItemFlagLMBean> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        return super.getView(position, convertView, parent);
    }
}
