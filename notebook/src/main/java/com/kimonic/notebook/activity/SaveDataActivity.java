package com.kimonic.notebook.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.lzy.okgo.model.Response;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * * ===============================================================
 * name:             SaveDataActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/2
 * description：
 * history：
 * *==================================================================
 */

public class SaveDataActivity extends BaseActivity {

    @BindView(R.id.tv_act_savedata_current_user)
    TextView tvCurrentUser;
    @BindView(R.id.lv_act_savedata)
    ListView lv;
    /**
     * 添加到的用户名
     */
    private String userName;

    @Override
    public int getLayoutResId() {
        return R.layout.act_savedata;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initDataFromIntent() {
        userName = getIntent().getStringExtra("username");

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
