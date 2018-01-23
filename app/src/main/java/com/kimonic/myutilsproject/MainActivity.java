package com.kimonic.myutilsproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kimonic.myutilsproject.activity.TestActivity;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.lzy.okgo.model.Response;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.btn_act_main_1)
    Button btnActMain1;

    @Override
    public int getLayoutResId() {
        return R.layout.act_main;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_act_main_1:
                openActivity(TestActivity.class);
                break;
//                 case R.id.:break;
//                 case R.id.:break;
//                 case R.id.:break;
//                 case R.id.:break;
//                 case R.id.:break;
        }
    }

    @Override
    public void initDataFromIntent() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
//        if (btnActMain1 != null)
            btnActMain1.setOnClickListener(this);

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
