package com.kimonic.notebook.mvp.expenditure.statistics;

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
 * name:             ExpenditureStatisticsActivity
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

public class ExpenditureStatisticsActivity extends BaseActivity implements ExpenditureStatisticsContract.VIew {
    @BindView(R.id.mtb_act_expenditure_statisttics)
    MTopBarView mtb;
    @BindView(R.id.tv_act_expenditure_statisttics_previous)
    TextView tvPrevious;
    @BindView(R.id.tv_act_expenditure_statisttics_current)
    TextView tvCurrent;
    @BindView(R.id.tv_act_expenditure_statisttics_next)
    TextView tvNext;
    @BindView(R.id.tv_act_expenditure_statisttics_total)
    TextView tvTotal;
    @BindView(R.id.lv_act_expenditure_statisttics)
    ListView lv;

    private ExpenditureStatisticsContract.Presenter presenter;
    private CommonAdapter adapter;

    @Override
    public int getLayoutResId() {
        return R.layout.act_expenditure_statistics;
    }

    @Override
    protected int setStatusBarColor() {
        return getColorRes(R.color.colorQianLan);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_act_expenditure_statisttics_previous:
                break;
            case R.id.tv_act_expenditure_statisttics_current:
                break;
            case R.id.tv_act_expenditure_statisttics_next:
                break;
//            case R.id.: break;
//            case R.id.: break;
//            case R.id.: break;
        }
    }

    @Override
    public void initDataFromIntent() {
        presenter = new ExpenditureStatisticsPresenter(this);
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
    public void setPresenter(ExpenditureStatisticsContract.Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void setTvCurrenr(String str) {
        tvCurrent.setText(str);
    }

    @Override
    public void setListView(List<ExpenditureStatisticsPresenter.SizeBean> list) {
        if (adapter==null){
            adapter=getAdapter(list);
            lv.setAdapter(adapter);
        }else {
            adapter.notifyDataSetChanged();
        }
        
    }

    @Override
    public void setTotal(String str) {
        tvTotal.setText((getString(R.string.benyuezhichuzongji)+str));
    }

    /**
     * 获得适配器
     */
    private CommonAdapter<ExpenditureStatisticsPresenter.SizeBean> getAdapter(List<ExpenditureStatisticsPresenter.SizeBean> list) {
        return new CommonAdapter<ExpenditureStatisticsPresenter.SizeBean>(this, R.layout.lv_expenditure_statistics, list) {
            @Override
            protected void convert(ViewHolder viewHolder, ExpenditureStatisticsPresenter.SizeBean item, int position) {
                viewHolder.setText(R.id.tv_lv_act_expenditure_statisttics_type, "消费第"+(position+1)+"名");
                viewHolder.setText(R.id.tv_lv_act_expenditure_statisttics_typename, item.getType());
                viewHolder.setText(R.id.tv_lv_act_expenditure_statisttics_total, ""+item.getTotal());

            }
        };
    }

}
