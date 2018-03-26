package com.kimonic.notebook.mvp.memorandum;

import android.view.View;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.mapp.MApp;
import com.kimonic.notebook.mvp.memorandum.add.MemorandumAddActivity;
import com.kimonic.notebook.mvp.memorandum.query.MemorandumQueryActivity;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.ui.MTopBarView;
import com.lzy.okgo.model.Response;

import butterknife.BindView;

/**
 * * ===============================================================
 * name:             MemorandumActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/26
 * method:
 * <p>
 * <p>
 * description：备忘录activity
 * history：
 * *==================================================================
 */

public class MemorandumActivity extends BaseActivity {
    @BindView(R.id.mtb_act_memorandum)
    MTopBarView mtb;
    @BindView(R.id.tv_act_memorandum_chakanbeiwanglu)
    TextView tvFind;
    @BindView(R.id.tv_act_memorandum_tianjiabeiwanglu)
    TextView tvAdd;
    @BindView(R.id.tv_act_memorandum_beifenbeiwanglu)
    TextView tvBackup;

    @Override
    public int getLayoutResId() {
        return R.layout.act_memorandum;
    }

    @Override
    protected int setStatusBarColor() {
        return getColorRes(R.color.colorQianLan);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_act_memorandum_chakanbeiwanglu:
                openActivity(MemorandumQueryActivity.class);
                break;
            case R.id.tv_act_memorandum_tianjiabeiwanglu:
                openActivity(MemorandumAddActivity.class);
                break;
            case R.id.tv_act_memorandum_beifenbeiwanglu:
                break;
//            case R.id.: break;
//            case R.id.: break;
//            case R.id.: break;
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
        tvAdd.setOnClickListener(this);
        tvBackup.setOnClickListener(this);
        tvFind.setOnClickListener(this);
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
