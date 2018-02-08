package com.kimonic.notebook.activity.fixedassets;

import android.view.View;

import com.kimonic.notebook.R;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.lzy.okgo.model.Response;

/**
 * * ===============================================================
 * name:             EditOldRecordActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/8
 * description：   重新编辑原来的记录activity
 * history：
 * *==================================================================
 */

public class EditOldRecordActivity extends BaseActivity {

    private long id;
    @Override
    public int getLayoutResId() {
        return R.layout.act_editoldrecrod;
    }

    @Override
    protected int setStatusBarColor() {
        return getColorRes(R.color.colorQianLan);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initDataFromIntent() {
        id=getIntent().getLongExtra("id",0);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

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
