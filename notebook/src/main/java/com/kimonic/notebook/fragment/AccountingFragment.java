package com.kimonic.notebook.fragment;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.activity.fixedassets.FixedAssetsActivity;
import com.kimonic.notebook.activity.investment.InvestmentHomeActivity;
import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.litemapbean.daily.ExpenditureLMBean;
import com.kimonic.notebook.litemapbean.daily.IncomeLMBean;
import com.kimonic.notebook.mvp.expenditure.add.ExpenditureActivity;
import com.kimonic.notebook.mvp.income.IncomeActivity;
import com.kimonic.utilsmodule.base.BaseFragment;
import com.kimonic.utilsmodule.utils.StringUtils;
import com.kimonic.utilsmodule.utils.TimeUtils;
import com.lzy.okgo.model.Response;

import org.litepal.crud.DataSupport;

import java.util.List;

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


    private float income, expenditure;

    @Override
    public int layoutRes() {
        return R.layout.frag_accounting_notebook;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_frag_accounting_shourujilu://收入记录
                openActivity(IncomeActivity.class);
                break;
            case R.id.tv_frag_accounting_zhichujilu://支出记录
                openActivity(ExpenditureActivity.class);
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
        initBenYueShouYu();
        initBenYueZhiChu();
        setYingKui();
    }

    private void setYingKui(){
        float total = income - expenditure;
        if (total < 0) {
            tvBenYueYingKui.setText(StringUtils.getCommaDecimalsStr("" + total));
            tvBenYueYingKui.setTextColor(Color.parseColor("#FF52ED"));
        } else {
            tvBenYueYingKui.setTextColor(Color.WHITE);
            tvBenYueYingKui.setText(StringUtils.getCommaDecimalsStr("" + total));
        }
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

    /**
     * 初始化本月支出
     */
    private void initBenYueZhiChu() {
        String userName = UserConfig.getInstance().getUserName(getActivity());
        String month = TimeUtils.getCurrentMonthStr();
        String year = "" + TimeUtils.getCurrentYear();
        List<ExpenditureLMBean> list = DataSupport.where("userName = ? and year = ? and month = ?", userName, year, month)
                .find(ExpenditureLMBean.class);
        expenditure = 0;
        for (ExpenditureLMBean bean : list) {
            expenditure += bean.getAmount();
        }
        tvBenYueZhiChu.setText(StringUtils.getCommaDecimalsStr("" + expenditure));


    }

    /**
     * 初始化本月收入
     */
    private void initBenYueShouYu() {
        String userName = UserConfig.getInstance().getUserName(getActivity());
        String month = TimeUtils.getCurrentMonthStr();
        String year = "" + TimeUtils.getCurrentYear();
        List<IncomeLMBean> list = DataSupport.where("userName = ? and year = ? and month = ?", userName, year, month)
                .find(IncomeLMBean.class);
        income = 0;
        for (IncomeLMBean bean : list) {
            income += bean.getAmount();
        }
        tvBenYueShouRu.setText(StringUtils.getCommaDecimalsStr("" + income));


    }

    @Override
    public void onResume() {
        if (UserConfig.getInstance().isExpenditureChange()) {
            UserConfig.getInstance().setExpenditureChange(false);
            initBenYueZhiChu();
        }
        if (UserConfig.getInstance().isIncomeChange()) {
            // TODO: 2018/3/23 重新统计收入
            UserConfig.getInstance().setIncomeChange(false);
            initBenYueShouYu();
        }
        setYingKui();
        super.onResume();
    }
}
