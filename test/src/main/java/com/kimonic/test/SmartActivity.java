package com.kimonic.test;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.utils.LUtils;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/**
 * * ===============================================================
 * name:             SmartActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/4/20
 * method:
 * <p>
 * <p>
 * description：
 * history：
 * *==================================================================
 */

public class SmartActivity extends BaseActivity {
    private ListView lvFragDiscover;
    private SmartRefreshLayout srl;
    private List<String> list;
    private MAdapter adapter;

    @Override
    public int getLayoutResId() {
        return R.layout.act_smart;
    }

    @Override
    protected int setStatusBarColor() {
        return 0;
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void initDataFromIntent() {

    }

    @Override
    public void initView() {
        lvFragDiscover=findViewById(R.id.lv_frag_discover);
        srl=findViewById(R.id.srl_frag_discover);

        list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(""+i);
        }
        TextView view = new TextView(this);
        view.setText("header");
        lvFragDiscover.addHeaderView(view);

         adapter=new MAdapter(list, this);
        lvFragDiscover.setAdapter(adapter);


        srl.setPrimaryColors(Color.RED);
        srl.setRefreshHeader(new BezierRadarHeader(this));
//        srl.setRefreshHeader(new TuDouHeader(getActivity()));
//        srl.setRefreshFooter(new BallPulseFooter(getActivity()));
        srl.setEnableLoadmore(false);
    }

    @Override
    public void initListener() {
        srl.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                list.clear();
                new Thread(){
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                loadInternetDataToUi();

                            }
                        });

                    }
                }.start();
//                finishRL();
            }
        });
    }

    @Override
    public void initDataFromInternet() {

    }

    @Override
    public void loadInternetDataToUi(Response<String> response) {

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        LUtils.e(SmartActivity.class,"logflag---保存状态"+outState);

        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        LUtils.e(SmartActivity.class,"logflag--savedInstanceState-保存状态"+savedInstanceState.getString("state","取出失败"));
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        LUtils.e(SmartActivity.class,"logflag--outState-保存状态"+outState);
        outState.putString("state","保存的状态");
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        LUtils.e(SmartActivity.class,"logflag---保存状态");
        super.onRestoreInstanceState(savedInstanceState, persistentState);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState!=null){
            LUtils.e(SmartActivity.class,"logflag---保存状态"+savedInstanceState.getString("state","取出失败"));
        }else {
            LUtils.e(SmartActivity.class,"logflag---保存状态");
        }
    }

    @Override
    public void loadInternetDataToUi() {
        List<String>  list1=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list1.add(""+i*2);
        }
        srl.finishRefresh();
        list.addAll(list1);
        adapter.notifyDataSetChanged();


    }

    private class MAdapter extends BaseAdapter {
        private List<String> list;
        private Context context;

        public MAdapter(List<String> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return 0==list.size()?null:list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            ViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                view = new TextView(context);
                viewHolder.textView = (TextView) view;
                view.setTag(viewHolder);

            }else {
                view=convertView;
                viewHolder= (ViewHolder) view.getTag();
            }

            viewHolder.textView.setText(list.get(position));
            return view;
        }

        private class ViewHolder {
            TextView textView;
        }
    }

}
