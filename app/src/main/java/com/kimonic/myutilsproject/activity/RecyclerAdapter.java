package com.kimonic.myutilsproject.activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kimonic.myutilsproject.R;

import java.util.List;

/**
 * * ===============================================================
 * name:             RecyclerAdapter
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/30
 * method:
 * <p>
 * <p>
 * description：
 * history：
 * *==================================================================
 */
public class RecyclerAdapter<T> extends RecyclerView.Adapter {

//    private final static int HEAD_COUNT = 1;
//    private final static int FOOT_COUNT = 1;

    private final static int TYPE_HEAD = 0;
    private final static int TYPE_CONTENT = 1;
    private final static int TYPE_FOOTER = 2;

    private List<T> list;
    private Context context;
    private int resHeader = -1;
    private int resFooter = -1;
    private int resItem;
    private int headCount = 0;
    private int footerCount = 0;

    /**
     * 构造函数
     */
    public RecyclerAdapter(List<T> list, Context context, int resHeader, int resFooter, int resItem) {
        this.list = list;
        this.context = context;
        this.resHeader = resHeader;
        this.resFooter = resFooter;
        this.resItem = resItem;
    }

    private int getContentSize() {
        return list.size();
    }

    public boolean isHead(int position) {
        return resHeader != -1 && position == 0;
    }

    public boolean isFoot(int position) {
        return resFooter != -1 && position == getContentSize() + headCount;
    }

    @Override
    public int getItemViewType(int position) {

        if (isHead(position)) { // 头部
            return TYPE_HEAD;
        } else if (isFoot(position)) { // 尾部
            return TYPE_FOOTER;
        } else {
            return TYPE_CONTENT;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_CONTENT) {//内容视图
            View itemView = LayoutInflater.from(context).inflate(resItem, parent, false);
            return new RecyclerAdapter.ContentHolder(itemView);
        } else if (viewType == TYPE_HEAD) {//头部视图
            View itemView = LayoutInflater.from(context).inflate(resHeader, null, false);
            //处理点击事件
            return new RecyclerAdapter.HeadHolder(itemView);
        } else {//底部视图
            View itemView = LayoutInflater.from(context).inflate(resFooter, null, false);
            return new RecyclerAdapter.FootHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RecyclerAdapter.ContentHolder) { // 内容
            RecyclerAdapter.ContentHolder myHolder = (RecyclerAdapter.ContentHolder) holder;
            ((ContentHolder) holder).itemText.setText((CharSequence) list.get(position - headCount));
            //内容视图相关设置
        } else if (holder instanceof RecyclerAdapter.HeadHolder) { // 头部

        } else { // 尾部

        }
    }

    @Override
    public int getItemCount() {
        if (resHeader == -1) {
            headCount = 0;
        }
        if (resFooter == -1) {
            resFooter = 0;
        }
        return list.size() + headCount + footerCount;
    }

    // 头部
    private class HeadHolder extends RecyclerView.ViewHolder {
        public HeadHolder(View itemView) {
            super(itemView);
        }
    }

    // 内容--视图
    private class ContentHolder extends RecyclerView.ViewHolder {
        TextView itemText;

        public ContentHolder(View itemView) {
            super(itemView);
            itemText = itemView.findViewById(R.id.tv_rv_item);
        }
    }

    // 尾部
    private class FootHolder extends RecyclerView.ViewHolder {
        public FootHolder(View itemView) {
            super(itemView);
        }
    }

}