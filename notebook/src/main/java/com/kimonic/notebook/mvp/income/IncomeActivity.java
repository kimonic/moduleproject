package com.kimonic.notebook.mvp.income;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.mapp.MApp;
import com.kimonic.notebook.mvp.income.add.IncomeAddActivity;
import com.kimonic.notebook.mvp.income.query.IncomeQueryActivity;
import com.kimonic.notebook.mvp.income.statistics.IncomeStatisticsActivity;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.ui.MTopBarView;
import com.lzy.okgo.model.Response;

import butterknife.BindView;

/**
 * * ===============================================================
 * name:             IncomeActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/23
 * method:
 * <p>
 * <p>
 * description：收入activity
 * history：
 * *==================================================================
 */

public class IncomeActivity extends BaseActivity {
    @BindView(R.id.mtb_act_income)
    MTopBarView mtb;
    @BindView(R.id.tv_act_income_chakanshourujilu)
    TextView tvQuery;
    @BindView(R.id.tv_act_income_tianjaishourujilu)
    TextView tvAdd;
    @BindView(R.id.tv_act_income_shourujilutongji)
    TextView tvStatistics;//统计
    @BindView(R.id.tv_act_income_beifenshourujilu)
    TextView tvBackup;
    @BindView(R.id.iv_act_income_test)
    ImageView iv;

    @Override
    public int getLayoutResId() {
        return R.layout.act_income;
    }

    @Override
    protected int setStatusBarColor() {
        return getColorRes(R.color.colorQianLan);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_act_income_chakanshourujilu://查看
                openActivity(IncomeQueryActivity.class);
                break;
            case R.id.tv_act_income_tianjaishourujilu://添加
                openActivity(IncomeAddActivity.class);
                break;
            case R.id.tv_act_income_shourujilutongji://统计
                openActivity(IncomeStatisticsActivity.class);
                break;
            case R.id.tv_act_income_beifenshourujilu://备份
                break;
//                 case R.id.:break;
//                 case R.id.:break;
        }
    }

    @Override
    public void initDataFromIntent() {

    }

    @Override
    public void initView() {
        setTopMargin(mtb, MApp.STATUS_BAE_HEIGHT);
        iv.setBackground(getWindow().getDecorView().getBackground());
    }

    @Override
    public void initListener() {
        tvAdd.setOnClickListener(this);
        tvBackup.setOnClickListener(this);
        tvQuery.setOnClickListener(this);
        tvStatistics.setOnClickListener(this);
        setCloseLisenter(mtb);
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
