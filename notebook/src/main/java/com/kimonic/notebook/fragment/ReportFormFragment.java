package com.kimonic.notebook.fragment;

import android.view.View;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.utilsmodule.base.BaseFragment;
import com.lzy.okgo.model.Response;

import butterknife.BindView;

/**
 * * ===============================================================
 * name:             ReportFormFragment
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/26
 * method:
 * <p>
 * <p>
 * description：
 * IAE-->income and expenditure-->收支
 * FA-fixed assets-->固定资产
 * history：
 * *==================================================================
 */

public class ReportFormFragment extends BaseFragment {
    @BindView(R.id.tv_frag_reportform_shouzhiyuedutongji)
    TextView tvMonthStatisticsIAE;
    @BindView(R.id.tv_frag_reportform_shouzhiniandutongji)
    TextView tvYearStatisticsIAE;
    @BindView(R.id.tv_frag_reportform_gudingzichantongji)
    TextView tvStatisticsFA;
    @BindView(R.id.tv_frag_reportform_touziyingshouyuedutongji)
    TextView tvMonthStatisticsInvestment;
    @BindView(R.id.tv_frag_reportform_touziyingshouniandutongji)
    TextView tvYearStatisticsInvestment;

    @Override
    public int layoutRes() {
        return R.layout.frag_reportform;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.tv_frag_reportform_shouzhiyuedutongji:
                break;
            case R.id.tv_frag_reportform_shouzhiniandutongji:
                break;
            case R.id.tv_frag_reportform_gudingzichantongji:
                break;
            case R.id.tv_frag_reportform_touziyingshouyuedutongji:
                break;
            case R.id.tv_frag_reportform_touziyingshouniandutongji:
                break;
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
        tvMonthStatisticsIAE.setOnClickListener(this);
        tvMonthStatisticsInvestment.setOnClickListener(this);
        tvStatisticsFA.setOnClickListener(this);
        tvYearStatisticsIAE.setOnClickListener(this);
        tvYearStatisticsInvestment.setOnClickListener(this);
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
