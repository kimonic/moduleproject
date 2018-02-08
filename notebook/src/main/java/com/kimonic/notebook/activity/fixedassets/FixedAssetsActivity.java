package com.kimonic.notebook.activity.fixedassets;

import android.view.View;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.mapp.MApp;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.ui.MTopBarView;
import com.lzy.okgo.model.Response;

import butterknife.BindView;

/**
 * * ===============================================================
 * name:             FixedAssetsActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/8
 * description：  固定资产记录activity
 * history：
 * *==================================================================
 */

public class FixedAssetsActivity extends BaseActivity {
    @BindView(R.id.mtb_act_fixedassets)
    MTopBarView mtb;
    @BindView(R.id.tv_act_fixedassets_chakangudingzichan)
    TextView tvLook;
    @BindView(R.id.tv_act_fixedassets_jilugudingzichan)
    TextView tvTakeNotes;
    @BindView(R.id.tv_act_fixedassets_gudingzichanjiluchaxun)
    TextView tvQuery;
    @BindView(R.id.tv_act_fixedassets_daochugudingzichanjilu)
    TextView tvExport;


    @Override
    public int getLayoutResId() {
        return R.layout.act_fixedassets;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_act_fixedassets_chakangudingzichan://查看
                openActivity(FindDataActivity.class);
                break;
            case R.id.tv_act_fixedassets_jilugudingzichan://记录
                break;
            case R.id.tv_act_fixedassets_gudingzichanjiluchaxun://查询
                break;
            case R.id.tv_act_fixedassets_daochugudingzichanjilu://导出
                break;
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
        mtb.getLeftTV().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeActivity();
            }
        });
        tvLook.setOnClickListener(this);
        tvTakeNotes.setOnClickListener(this);
        tvQuery.setOnClickListener(this);
        tvExport.setOnClickListener(this);

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
    protected int setStatusBarColor() {
        return getColorRes(R.color.colorQianLan);
    }


}
