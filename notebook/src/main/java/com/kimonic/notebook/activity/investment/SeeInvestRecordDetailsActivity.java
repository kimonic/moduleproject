package com.kimonic.notebook.activity.investment;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.litemapbean.invest.InvestmentRecordDetailsLMBean;
import com.kimonic.notebook.mapp.MApp;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.ui.MTopBarView;
import com.lzy.okgo.model.Response;

import org.litepal.crud.DataSupport;

import butterknife.BindView;

/**
 * * ===============================================================
 * name:             SeeInvestRecordDetailsActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/22
 * description：查看投资记录详情activity
 * history：
 * *==================================================================
 */

public class SeeInvestRecordDetailsActivity extends BaseActivity {

    @BindView(R.id.tv_act_seeinvestrecorddetails_invest_plateform)
    TextView tvInvestPlateform;
    @BindView(R.id.tv_act_seeinvestrecorddetails_invest_amount)
    TextView tvInvestAmount;
    @BindView(R.id.tv_act_seeinvestrecorddetails_investdate)
    TextView tvInvestdate;
    @BindView(R.id.tv_act_seeinvestrecorddetails_repaydate)
    TextView tvRepaydate;
    @BindView(R.id.tv_act_seeinvestrecorddetails_invest_mark)
    TextView tvInvestMark;
    @BindView(R.id.tv_act_seeinvestrecorddetails_invest_acounts)
    TextView tvInvestAcounts;
    @BindView(R.id.tv_act_seeinvestrecorddetails_phone_number)
    TextView tvPhoneNumber;
    @BindView(R.id.tv_act_seeinvestrecorddetails_repay_amount)
    TextView tvRepayAmount;
    @BindView(R.id.tv_act_seeinvestrecorddetails_valid_flag)
    TextView tvValidFlag;
    @BindView(R.id.tv_act_seeinvestrecorddetails_cash_back)
    TextView tvCashBack;
    @BindView(R.id.tv_act_seeinvestrecorddetails_invest_numberof_days)
    TextView tvInvestNumberofDays;
    @BindView(R.id.tv_act_seeinvestrecorddetails_extra_annual_income)
    TextView tvExtraAnnualIncome;
    @BindView(R.id.tv_act_seeinvestrecorddetails_fixed_annual_income)
    TextView tvFixedAnnualIncome;
    @BindView(R.id.tv_act_seeinvestrecorddetails_total_income)
    TextView tvTotalIncome;
    @BindView(R.id.tv_act_seeinvestrecorddetails_total_annual_income)
    TextView tvTotalAnnualIncome;
    @BindView(R.id.mtb_act_seeinvestrecorddetails)
    MTopBarView mtb;

    private long id;

    @Override
    public int getLayoutResId() {
        return R.layout.act_seeinvestrecorddetails;

    }

    @Override
    protected int setStatusBarColor() {
        return getColorRes(R.color.colorQianLan);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initDataFromIntent() {
        String temp = getIntent().getStringExtra("id");
        if (temp != null) {
            id = Long.parseLong(temp);
        } else {
            id = -1;
        }

    }

    @Override
    public void initView() {

        setTopMargin(mtb, MApp.STATUS_BAE_HEIGHT);
        loadInternetDataToUi();
    }

    @Override
    public void initListener() {
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
        Log.e("SetailsActivity", "loadInternetDataToUi: -----"+id);

        if (id != -1) {
            InvestmentRecordDetailsLMBean bean = DataSupport.find(InvestmentRecordDetailsLMBean.class, id);
            tvInvestPlateform.setText(bean.getInvestPlateform());
            tvCashBack.setText(("" + bean.getCashBack()));
            tvExtraAnnualIncome.setText(bean.getExtraAnnualIncome());

            tvFixedAnnualIncome.setText(bean.getFixedAnnualIncom());
            tvInvestAcounts.setText(bean.getInvestAcounts());
            tvInvestAmount.setText(("" + bean.getInvestAmount()));

            tvInvestdate.setText(bean.getInvestDate());
            tvInvestMark.setText(bean.getMark());
            tvInvestNumberofDays.setText(("" + bean.getInvestNumberOfDays()));

            tvPhoneNumber.setText(bean.getPhoneNumer());
            tvRepayAmount.setText(("" + bean.getRepayAmount()));
            tvRepaydate.setText(bean.getRepayDate());

            tvTotalAnnualIncome.setText(bean.getTotalAnnualIncome());
            tvTotalIncome.setText(("" + bean.getTotalIncome()));
            if (bean.isValidFlag()){
                tvValidFlag.setText(R.string.tongjiyouxiao);
            }else {
                tvValidFlag.setText(R.string.tongjiwuxiao);
            }

//            tvInvestPlateform.setText(bean.getInvestPlateform());
//            tvInvestPlateform.setText(bean.getInvestPlateform());
//            tvInvestPlateform.setText(bean.getInvestPlateform());
        }

    }


}
