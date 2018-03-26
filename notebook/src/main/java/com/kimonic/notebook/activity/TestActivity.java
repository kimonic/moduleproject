package com.kimonic.notebook.activity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.mapp.MApp;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.ui.MTopBarView;
import com.lzy.okgo.model.Response;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * * ===============================================================
 * name:             TestActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/26
 * method:
 * <p>
 * <p>
 * description：
 * history：
 * *==================================================================
 */

public class TestActivity extends BaseActivity {
    @BindView(R.id.mtb_act_test)
    MTopBarView mtb;
    @BindView(R.id.bt_act_test)
    Button bt;
    @BindView(R.id.tv_act_test)
    TextView tv;

    @Override
    public int getLayoutResId() {
        return R.layout.act_test;
    }

    @Override
    protected int setStatusBarColor() {
        return getColorRes(R.color.colorQianLan);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_act_test:
                clickEvent();
                break;
//                 case R.id.:break;
//                 case R.id.:break;
//                 case R.id.:break;
//                 case R.id.:break;
//                 case R.id.:break;
        }

    }

    private void clickEvent() {
        String path="存储路径"+Environment.getExternalStorageDirectory().getPath()+"\n";
        File file = new File(Environment.getExternalStorageDirectory().getPath());
        String wenjian="文件"+file+"\n";
        File[] files = file.listFiles();
        String liebiao="文件列表"+files+"\n";
        tv.setText((path+wenjian+liebiao));
//
//
//        for (int i = 0; i < files.length; i++) {
//            if (files[i].isDirectory()) {
//                Log.e("MainActivity", "initDataFromIntent: -文件夹----" + files[i].getName());
//            } else {
//                Log.e("MainActivity", "initDataFromIntent: ---文件--" + files[i].getName());
//                if (files[i].getName().contains(".png")) {
//                    files[i].delete();
//                }
//            }
//        }
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
        bt.setOnClickListener(this);
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
