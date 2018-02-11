package com.kimonic.notebook.activity.fixedassets;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.mapp.MApp;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.ui.MTopBarView;
import com.lzy.okgo.model.Response;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * * ===============================================================
 * name:             QueryDataActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/11
 * description：  固定资产查询activity
 * history：
 * *==================================================================
 */

public class QueryDataActivity extends BaseActivity {
    @BindView(R.id.mtb_act_querydata)
    MTopBarView mtb;
    @BindView(R.id.tv_act_querydata_date)
    TextView tvDate;
    @BindView(R.id.tv_act_querydata_type)
    TextView tvType;
    @BindView(R.id.tv_act_querydata_mark)
    TextView tvMark;

    @Override
    public int getLayoutResId() {
        return R.layout.act_querydata;
    }

    @Override
    protected int setStatusBarColor() {
        return getColorRes(R.color.colorQianLan);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_act_querydata_date://日期查询
                openActivityParams(QueryDataDetailsActivity.class,"type",1);
                break;
            case R.id.tv_act_querydata_type://类别查询
                openActivityParams(QueryDataDetailsActivity.class,"type",2);
                break;
            case R.id.tv_act_querydata_mark://备注查询
                openActivityParams(QueryDataDetailsActivity.class,"type",3);
                break;
//         case R.id.:break;
//         case R.id.:break;
//         case R.id.:break;
        }
    }

    @Override
    public void initDataFromIntent() {

    }

    @Override
    public void initView() {
        setTopMargin(mtb, MApp.STATUS_BAE_HEIGHT);
    }

    @Override
    public void initListener() {
        setCloseLisenter(mtb);
        tvDate.setOnClickListener(this);
        tvMark.setOnClickListener(this);
        tvType.setOnClickListener(this);
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


}
