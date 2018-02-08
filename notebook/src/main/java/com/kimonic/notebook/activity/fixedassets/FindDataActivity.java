package com.kimonic.notebook.activity.fixedassets;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.litemapbean.DateRecordLMBean;
import com.kimonic.notebook.mapp.MApp;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.ui.MTopBarView;
import com.lzy.okgo.model.Response;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import org.litepal.crud.DataSupport;

import java.util.List;

import butterknife.BindView;

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
    @BindView(R.id.lv_act_finddata)
    ListView lv;
    @BindView(R.id.mtb_act_finddata)
    MTopBarView mtb;

    private String userName;
    private List<DateRecordLMBean> listDate;
    private CommonAdapter<DateRecordLMBean> adapter;

    @Override
    public int getLayoutResId() {
        return R.layout.act_finddata_notebook;
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
        setTopMargin(mtb, MApp.STATUS_BAE_HEIGHT);
        listDate = DataSupport.where("userName = ? ", userName).find(DateRecordLMBean.class);
        adapter = getAdapter();
        lv.setAdapter(adapter);
    }

    @Override
    public void initListener() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openActivityForResult(FindDataDetailsActivity.class, "date", listDate.get(position).getDate(), 666);
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


    private CommonAdapter<DateRecordLMBean> getAdapter() {
        return new CommonAdapter<DateRecordLMBean>(this, R.layout.lv_daterecordbean_notebook, listDate) {
            @Override
            protected void convert(ViewHolder viewHolder, DateRecordLMBean item, int position) {
                viewHolder.setText(R.id.tv_lv_daterecordbean, item.getDate());
            }
        };
    }


    @Override
    protected int setStatusBarColor() {
        return getColorRes(R.color.colorQianLan);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == 666) {//下级页面对日期列表有删除操作,所以要刷新数据源
           List<DateRecordLMBean> list = DataSupport.where("userName = ? ", userName).find(DateRecordLMBean.class);
           listDate.clear();
           listDate.addAll(list);
           adapter.notifyDataSetChanged();
        }

    }
}
