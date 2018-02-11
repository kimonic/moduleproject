package com.kimonic.notebook.activity.investment;

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
 * name:             InvestmentHomeActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/11
 * description：投资记账主页activity
 * history：
 * *==================================================================
 */

public class InvestmentHomeActivity extends BaseActivity {
    @BindView(R.id.mtb_act_investmenthome)
    MTopBarView mtb;
    @BindView(R.id.tv_act_investmenthome_chakantouzijilu)
    TextView tvChaKan;
    @BindView(R.id.tv_act_investmenthome_tianjiatouzijilu)
    TextView tvTianJia;
    @BindView(R.id.tv_act_investmenthome_touzijiluchaxun)
    TextView tvChaXun;
    @BindView(R.id.tv_act_investmenthome_touzihuikuanjilu)
    TextView tvHuiKuan;
    @BindView(R.id.tv_act_investmenthome_daochutouzijilushuju)
    TextView tvDaoChu;

    @Override
    public int getLayoutResId() {
        return R.layout.act_investmenthome;
    }

    @Override
    protected int setStatusBarColor() {
        return getColorRes(R.color.colorQianLan);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_act_investmenthome_chakantouzijilu://查看
                break;
            case R.id.tv_act_investmenthome_tianjiatouzijilu://添加
                break;
            case R.id.tv_act_investmenthome_touzijiluchaxun://查询
                break;
            case R.id.tv_act_investmenthome_touzihuikuanjilu://回款
                break;
            case R.id.tv_act_investmenthome_daochutouzijilushuju://导出
                break;
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
        tvChaKan.setOnClickListener(this);
        tvChaXun.setOnClickListener(this);
        tvDaoChu.setOnClickListener(this);
        tvHuiKuan.setOnClickListener(this);
        tvTianJia.setOnClickListener(this);
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
