package com.kimonic.notebook.mvp.income.statistics;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.mapp.MApp;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.ui.MTopBarView;
import com.lzy.okgo.model.Response;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.List;

import butterknife.BindView;

/**
 * * ===============================================================
 * name:             incomeStatisticsActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/29
 * method:
 * <p>
 * <p>
 * description：支出统计activity
 * history：
 * *==================================================================
 */

public class IncomeStatisticsActivity extends BaseActivity implements IncomeStatisticsContract.View {
    @BindView(R.id.mtb_act_income_statisttics)
    MTopBarView mtb;
    @BindView(R.id.tv_act_income_statisttics_previous)
    TextView tvPrevious;
    @BindView(R.id.tv_act_income_statisttics_current)
    TextView tvCurrent;
    @BindView(R.id.tv_act_income_statisttics_next)
    TextView tvNext;
    @BindView(R.id.tv_act_income_statisttics_total)
    TextView tvTotal;
     @BindView(R.id.tv_act_income_statistics_hint)
    TextView tvHint;
    @BindView(R.id.lv_act_income_statisttics)
    ListView lv;

    private IncomeStatisticsContract.Presenter presenter;
    private CommonAdapter adapter;

    @Override
    public int getLayoutResId() {
        return R.layout.act_income_statistics;
    }

    @Override
    protected int setStatusBarColor() {
        return getColorRes(R.color.colorQianLan);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_act_income_statisttics_previous:
                presenter.setPrevious();
                break;
            case R.id.tv_act_income_statisttics_current:
                break;
            case R.id.tv_act_income_statisttics_next:
                presenter.setNext();
                break;
//            case R.id.: break;
//            case R.id.: break;
//            case R.id.: break;
        }
    }

    @Override
    public void initDataFromIntent() {
        presenter = new IncomeStatisticsPresenter(this);
    }

    @Override
    public void initView() {
        setTopMargin(mtb, MApp.STATUS_BAE_HEIGHT);
    }

    @Override
    public void initListener() {
        setCloseLisenter(mtb);
        tvCurrent.setOnClickListener(this);
        tvNext.setOnClickListener(this);
        tvPrevious.setOnClickListener(this);

    }

    @Override
    public void initDataFromInternet() {
        presenter.init();

    }

    @Override
    public void loadInternetDataToUi(Response<String> response) {

    }

    @Override
    public void loadInternetDataToUi() {

    }

    @Override
    public void setPresenter(IncomeStatisticsContract.Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void setTvCurrenr(String str) {
        tvCurrent.setText(str);
    }

    @Override
    public void setListView(List<IncomeStatisticsPresenter.SizeBean> list) {
        if (adapter==null){
            adapter=getAdapter(list);
            lv.setAdapter(adapter);
        }else {
            adapter.notifyDataSetChanged();
        }
        
    }

    @Override
    public void setTotal(String str) {
        tvTotal.setText((getString(R.string.benyueshouruzongji)+str));
    }

    @Override
    public void showNothing(boolean flag) {
        if (flag) {
            lv.setVisibility(View.GONE);
            tvHint.setVisibility(View.VISIBLE);
        } else {
            lv.setVisibility(View.VISIBLE);
            tvHint.setVisibility(View.GONE);
        }
    }

    /**
     * 获得适配器
     */
    private CommonAdapter<IncomeStatisticsPresenter.SizeBean> getAdapter(List<IncomeStatisticsPresenter.SizeBean> list) {
        return new CommonAdapter<IncomeStatisticsPresenter.SizeBean>(this, R.layout.lv_income_statistics, list) {
            @Override
            protected void convert(ViewHolder viewHolder, IncomeStatisticsPresenter.SizeBean item, int position) {
                viewHolder.setText(R.id.tv_lv_act_income_statisttics_type, "收入第"+(position+1)+"名");
                viewHolder.setText(R.id.tv_lv_act_income_statisttics_typename, item.getType());
                viewHolder.setText(R.id.tv_lv_act_income_statisttics_total, ""+item.getTotal());

            }
        };
    }

}
