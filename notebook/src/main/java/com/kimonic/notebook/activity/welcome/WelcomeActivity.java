package com.kimonic.notebook.activity.welcome;

import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.activity.HomeActivity;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.lzy.okgo.model.Response;

import butterknife.BindView;

/**
 * * ===============================================================
 * name:             WelcomeActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/7
 * description：
 * history：
 * *==================================================================
 */

public class WelcomeActivity extends BaseActivity {
    @BindView(R.id.iv_act_welcome)
    ImageView ivActWelcome;

    @Override
    public int getLayoutResId() {
        return R.layout.act_welcome_notebook;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initDataFromIntent() {

    }

    @Override
    public void initView() {
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                openActivity(HomeActivity.class);
                closeActivity();
            }
        },2000);

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
    public boolean isHideStatusBar() {
        return true;
    }
}
