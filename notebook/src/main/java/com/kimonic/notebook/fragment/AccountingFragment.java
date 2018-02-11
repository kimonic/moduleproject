package com.kimonic.notebook.fragment;

import android.view.View;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.activity.fixedassets.FixedAssetsActivity;
import com.kimonic.notebook.activity.investment.InvestmentHomeActivity;
import com.kimonic.utilsmodule.base.BaseFragment;
import com.kimonic.utilsmodule.utils.TimeUtils;
import com.lzy.okgo.model.Response;

import butterknife.BindView;

/**
 * * ===============================================================
 * name:             AccountingFragment
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/8
 * description： 记账fragment
 * history：
 * *==================================================================
 */

public class AccountingFragment extends BaseFragment {
    @BindView(R.id.tv_frag_accounting_dangqiantongji)
    TextView tvDangQianTongJi;
    @BindView(R.id.tv_frag_accounting_benyueyingkui)
    TextView tvBenYueYingKui;
    @BindView(R.id.tv_frag_accounting_benyueshouru)
    TextView tvBenYueShouRu;
    @BindView(R.id.tv_frag_accounting_benyuezhichu)
    TextView tvBenYueZhiChu;
    @BindView(R.id.tv_frag_accounting_shourujilu)
    TextView tvShouRuJiLu;
    @BindView(R.id.tv_frag_accounting_zhichujilu)
    TextView tvZhiChuJiLu;
    @BindView(R.id.tv_frag_accounting_gudingzichan)
    TextView tvGuDingZiChan;
    @BindView(R.id.tv_frag_accounting_suoshizaji)
    TextView tvSuoShiZaJi;
    @BindView(R.id.tv_frag_accounting_beiwanglu)
    TextView tvBeiWangLu;
    @BindView(R.id.tv_frag_accounting_shujudaochu)
    TextView tvShuJuDaoChu;
    @BindView(R.id.tv_frag_accounting_touzijizhang)
    TextView tvTouZIJiZhang;

    @Override
    public int layoutRes() {
        return R.layout.frag_accounting_notebook;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_frag_accounting_shourujilu://收入记录
                break;
            case R.id.tv_frag_accounting_zhichujilu://支出记录
                break;
            case R.id.tv_frag_accounting_gudingzichan://固定资产
                openActivity(FixedAssetsActivity.class);
                break;
            case R.id.tv_frag_accounting_suoshizaji://琐事杂记
                break;
            case R.id.tv_frag_accounting_beiwanglu://备忘录
                break;
            case R.id.tv_frag_accounting_shujudaochu://数据导出
                break;
            case R.id.tv_frag_accounting_touzijizhang://投资记账
                openActivity(InvestmentHomeActivity.class);
                break;
        }
    }

    @Override
    public void initDataFromIntent() {
    }

    @Override
    public void initView() {
        tvDangQianTongJi.setText((TimeUtils.getCurrentYearMonth() + getString(R.string.yingkuizongji)));
    }

    @Override
    public void initListener() {
        tvShouRuJiLu.setOnClickListener(this);
        tvZhiChuJiLu.setOnClickListener(this);
        tvGuDingZiChan.setOnClickListener(this);

        tvSuoShiZaJi.setOnClickListener(this);
        tvBeiWangLu.setOnClickListener(this);
        tvShuJuDaoChu.setOnClickListener(this);
        tvTouZIJiZhang.setOnClickListener(this);
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
