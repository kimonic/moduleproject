package com.kimonic.notebook.mvp.expenditure.add;

import android.view.View;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.litemapbean.daily.ExpenditureLMBean;
import com.kimonic.notebook.mapp.MApp;
import com.kimonic.notebook.mvp.expenditure.ExpenditureReository;
import com.kimonic.notebook.mvp.expenditure.query.ExpenditureQueryActivity;
import com.kimonic.notebook.mvp.expenditure.statistics.ExpenditureStatisticsActivity;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.ui.MTopBarView;
import com.kimonic.utilsmodule.utils.ToastUtils;
import com.lzy.okgo.model.Response;

import butterknife.BindView;

/**
 * * ===============================================================
 * name:             ExpenditureActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/21
 * method:
 * <p>
 * <p>
 * description：  支出activity
 * history：
 * *==================================================================
 */

public class ExpenditureActivity extends BaseActivity implements ExpenditureContract.View {

    @BindView(R.id.mtb_act_expenditure)
    MTopBarView mtb;
    @BindView(R.id.tv_act_expenditure_chakanzhichujilu)
    TextView tvLook;//查看
    @BindView(R.id.tv_act_expenditure_tianjaizhichujilu)
    TextView tvAdd;//添加
    @BindView(R.id.tv_act_expenditure_zhichujilutongji)
    TextView tvStatistics;//统计
    @BindView(R.id.tv_act_expenditure_beifenzhichujilu)
    TextView tvBackup;//备份
    private ExpenditureContract.Presenter presenter;

    @Override
    public int getLayoutResId() {
        return R.layout.act_expenditure;
    }

    @Override
    protected int setStatusBarColor() {
        return getColorRes(R.color.colorQianLan);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_act_expenditure_chakanzhichujilu://查看
                openActivity(ExpenditureQueryActivity.class);
                break;
            case R.id.tv_act_expenditure_tianjaizhichujilu://添加
                openActivity(ExpenditureAddActivity.class);
                break;
            case R.id.tv_act_expenditure_zhichujilutongji://统计
                openActivity(ExpenditureStatisticsActivity.class);
                break;
            case R.id.tv_act_expenditure_beifenzhichujilu://备份
                presenter.backup();
                break;
//                 case R.id.:break;
//                 case R.id.:break;
        }

    }

    @Override
    public void initDataFromIntent() {
        presenter=new ExpenditurePresenter(this,new ExpenditureReository());
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
        tvLook.setOnClickListener(this);
        tvStatistics.setOnClickListener(this);
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
    public void setPresenter(ExpenditureContract.Presenter presenter) {
        this.presenter=presenter;
    }


    @Override
    public void showToast(int resStr) {
        ToastUtils.showToast(this,resStr);
    }

    @Override
    public void setSave(int strRes) {

    }

    @Override
    public void clear() {

    }

    @Override
    public void init(ExpenditureLMBean bean) {

    }
}
