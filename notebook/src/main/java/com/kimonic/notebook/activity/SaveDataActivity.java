package com.kimonic.notebook.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.litemapbean.ItemFlagLMBean;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.lzy.okgo.model.Response;

import org.litepal.crud.DataSupport;

import java.util.List;

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
        tvCurrentUser.setText(userName);

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initDataFromInternet() {
        List<ItemFlagLMBean> listItem= DataSupport.where("userName = ?",userName).find(ItemFlagLMBean.class);


    }

    @Override
    public void loadInternetDataToUi(Response<String> response) {

    }

    @Override
    public void loadInternetDataToUi() {

    }


}
