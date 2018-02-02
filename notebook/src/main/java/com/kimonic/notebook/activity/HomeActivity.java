package com.kimonic.notebook.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.config.UserConfig;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.lzy.okgo.model.Response;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {


    @BindView(R.id.tv_act_home_current_user)
    TextView tvCurrentUser;
    @BindView(R.id.tv_act_home_add_new_user)
    TextView tvAddNewUser;
    @BindView(R.id.tv_act_home_sel_user)
    TextView tvSelUser;
    @BindView(R.id.tv_act_home_query_data)
    TextView tvQueryData;
    @BindView(R.id.tv_act_home_compare_data)
    TextView tvCompareData;
    @BindView(R.id.tv_act_home_update_data)
    TextView tvUpdateData;
    @BindView(R.id.tv_act_home_save_data)
    TextView tvSaveData;
    @BindView(R.id.tv_act_home_del_data)
    TextView tvDelData;
    @BindView(R.id.tv_act_home_add_item)
    TextView tvAddItem;
    private String userName;

    @Override
    public int getLayoutResId() {
        return R.layout.act_home_notebook;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_act_home_add_new_user://添加新用户
                openActivity(AddNewUserActivity.class);
                break;
            case R.id.tv_act_home_sel_user://选择用户
                break;
            case R.id.tv_act_home_query_data://查询数据
                break;
            case R.id.tv_act_home_compare_data://比较数据
                break;
            case R.id.tv_act_home_update_data://更新数据
                break;
            case R.id.tv_act_home_save_data://保存数据
                openActivityParams(SaveDataActivity.class, "username", userName);
                break;
            case R.id.tv_act_home_del_data://删除数据
                break;
            case R.id.tv_act_home_add_item://添加标签

                break;
//            case R.id.: break;
//            case R.id.: break;
//            case R.id.: break;
        }

    }

    @Override
    public void initDataFromIntent() {
        userName = UserConfig.getInstance().getUserName(this);
        if ("".equals(userName)) {
            userName = "亦筝笙";
            UserConfig.getInstance().setUserName(this, "亦筝笙");
        }
    }

    @Override
    public void initView() {
        tvCurrentUser.setText((getString(R.string.dangqiandengluyognhuming) + ":" + userName));

    }

    @Override
    public void initListener() {
        tvAddNewUser.setOnClickListener(this);
        tvSelUser.setOnClickListener(this);
        tvCompareData.setOnClickListener(this);

        tvDelData.setOnClickListener(this);
        tvQueryData.setOnClickListener(this);
        tvSaveData.setOnClickListener(this);
        tvUpdateData.setOnClickListener(this);
        tvAddItem.setOnClickListener(this);
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
