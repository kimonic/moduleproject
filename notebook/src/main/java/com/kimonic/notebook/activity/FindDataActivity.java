package com.kimonic.notebook.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.litemapbean.DateRecordLMBean;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.lzy.okgo.model.Response;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import org.litepal.crud.DataSupport;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * * ===============================================================
 * name:             FindDataActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/6
 * description：
 * history：
 * *==================================================================
 */

public class FindDataActivity extends BaseActivity {
    @BindView(R.id.tv_act_finddata_current_user)
    TextView tvCurrentUser;
    @BindView(R.id.lv_act_finddata)
    ListView lv;

    private String userName;
    private List<DateRecordLMBean> listDate;

    @Override
    public int getLayoutResId() {
        return R.layout.act_finddata;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initDataFromIntent() {
        userName = UserConfig.getInstance().getUserName(this);
    }

    @Override
    public void initView() {
        tvCurrentUser.setText(userName);
        listDate = DataSupport.where("userName = ? ", userName).find(DateRecordLMBean.class);


        lv.setAdapter(getAdapter());
    }

    @Override
    public void initListener() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openActivityParams(FindDataDetailsActivity.class,"date",listDate.get(position).getDate());
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
    public void loadInternetDataToUi() {

    }


    private CommonAdapter<DateRecordLMBean>  getAdapter(){
        return new CommonAdapter<DateRecordLMBean>(this,R.layout.lv_daterecordbean,listDate) {
            @Override
            protected void convert(ViewHolder viewHolder, DateRecordLMBean item, int position) {
                viewHolder.setText(R.id.tv_lv_daterecordbean,item.getDate());
            }
        };
    }


}
