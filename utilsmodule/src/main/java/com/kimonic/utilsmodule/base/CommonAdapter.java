package com.kimonic.utilsmodule.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * * ===============================================================
 * name:             CommonAdapter
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/5
 * description：
 * history：
 * *==================================================================
 */

public abstract class CommonAdapter<T> extends BaseAdapter {
    private Context context;
    private List<T> list;

    public CommonAdapter(Context context, @NonNull List<T> list) {
        this.context = context;
        this.list = list;
    }

    public abstract int  getLayoutRes();

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list == null ? null : list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return null;
    }


}
