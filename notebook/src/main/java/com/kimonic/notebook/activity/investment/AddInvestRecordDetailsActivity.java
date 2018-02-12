package com.kimonic.notebook.activity.investment;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.litemapbean.invest.InvestDateLMBean;
import com.kimonic.notebook.litemapbean.invest.InvestPlateformLMBean;
import com.kimonic.notebook.litemapbean.invest.InvestmentRecordDetailsLMBean;
import com.kimonic.notebook.litemapbean.invest.RepayDateLMBean;
import com.kimonic.notebook.mapp.MApp;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.ui.MTopBarView;
import com.kimonic.utilsmodule.utils.DialogUtils;
import com.kimonic.utilsmodule.utils.StringUtils;
import com.kimonic.utilsmodule.utils.TimeUtils;
import com.kimonic.utilsmodule.utils.ToastUtils;
import com.lzy.okgo.model.Response;

import org.litepal.crud.DataSupport;

import java.util.List;

import butterknife.BindView;

/**
 * * ===============================================================
 * name:             AddInvestRecordActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/12
 * description：添加投资记录详情activity
 * history：
 * *==================================================================
 */

public class AddInvestRecordDetailsActivity extends BaseActivity {
    @BindView(R.id.mtb_act_addinvestrecorddetails)
    MTopBarView mtb;
    @BindView(R.id.et_act_addinvestrecorddetails_invest_plateform)
    EditText etInvestPlateform;
    @BindView(R.id.et_act_addinvestrecorddetails_invest_amount)
    EditText etInvestAmount;
    @BindView(R.id.et_act_addinvestrecorddetails_investdate)
    EditText etInvestdate;
    @BindView(R.id.et_act_addinvestrecorddetails_repaydate)
    EditText etRepaydate;
    @BindView(R.id.et_act_addinvestrecorddetails_invest_mark)
    EditText etInvestMark;
    @BindView(R.id.et_act_addinvestrecorddetails_invest_acounts)
    EditText etInvestAcounts;
    @BindView(R.id.et_act_addinvestrecorddetails_phone_number)
    EditText etPhoneNumber;
    @BindView(R.id.et_act_addinvestrecorddetails_repay_amount)
    EditText etRepayAmount;
    @BindView(R.id.et_act_addinvestrecorddetails_valid_flag)
    EditText etValidFlag;
    @BindView(R.id.et_act_addinvestrecorddetails_cash_back)
    EditText etCashBack;
    @BindView(R.id.et_act_addinvestrecorddetails_invest_numberof_days)
    EditText etInvestNumberofDays;
    @BindView(R.id.et_act_addinvestrecorddetails_extra_annual_income)
    EditText etExtraAnnualIncome;
    @BindView(R.id.et_act_addinvestrecorddetails_fixed_annual_income)
    EditText etFixedAnnualIncome;
    @BindView(R.id.et_act_addinvestrecorddetails_total_income)
    EditText etTotalIncome;
    @BindView(R.id.et_act_addinvestrecorddetails_total_annual_income)
    EditText etTotalAnnualIncome;
    @BindView(R.id.tv_act_addinvestrecorddetails_save)
    TextView tvSave;

    private String investPlateform;
    private String investDate;
    private String repayDate;
    private String investAcount;
    private String userName;
    private String currentDay;
    private String cashBack;
    private String extraAnnualIncome;
    private String fixedAnnualIncome;
    private String investAcounts;
    private String investNumberOfDays;
    private String investMark;
    private String phoneNumber;
    private String repayAcount;
    private String totalAnnualIncome;
    private String totalIncome;
    private String validFlag;
    private List<InvestmentRecordDetailsLMBean> list;


    @Override
    public int getLayoutResId() {
        return R.layout.act_addinvestrecorddetails;
    }

    @Override
    protected int setStatusBarColor() {
        return getColorRes(R.color.colorQianLan);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_act_addinvestrecorddetails_save:
                if (checkContent()) {
                    saveData();
                }
                break;
//                 case R.id.:break;
//                 case R.id.:break;
//                 case R.id.:break;
//                 case R.id.:break;
//                 case R.id.:break;
        }

    }

    private void saveData() {


        cashBack = etCashBack.getText().toString().trim();
        extraAnnualIncome = etExtraAnnualIncome.getText().toString().trim();
        fixedAnnualIncome = etFixedAnnualIncome.getText().toString().trim();

        investAcounts = etInvestAcounts.getText().toString().trim();
        investAcount = etInvestAmount.getText().toString().trim();
        investNumberOfDays = etInvestNumberofDays.getText().toString().trim();

        investMark = etInvestMark.getText().toString().trim();
        phoneNumber = etPhoneNumber.getText().toString().trim();
        repayAcount = etRepayAmount.getText().toString().trim();

        totalAnnualIncome = etTotalAnnualIncome.getText().toString().trim();
        totalIncome = etTotalIncome.getText().toString().trim();
        validFlag = etValidFlag.getText().toString().trim();
//        String cashBack=etCashBack.getText().toString().trim();
//        String cashBack=etCashBack.getText().toString().trim();
//        String cashBack=etCashBack.getText().toString().trim();
        list = DataSupport.where("userName = ? and  " +//investPlateform--userName--investDate
                "investPlateform = ? and investDate = ?", userName, investPlateform, investDate).find(InvestmentRecordDetailsLMBean.class);

        if (list.size() == 0) {
            InvestmentRecordDetailsLMBean bean = new InvestmentRecordDetailsLMBean();

            bean.setUserName(userName);//用户名
            bean.setInvestPlateform(investPlateform);//平台名称
            bean.setInvestDate(investDate);//投资日期,默认当天
            bean.setRepayDate(repayDate);//回款日期
            bean.setCashBack(StringUtils.string2Float(cashBack));//额外收益


            bean.setExtraAnnualIncome(extraAnnualIncome);//额外年化收益
            bean.setFixedAnnualIncom(fixedAnnualIncome);//固定年化收益
            bean.setInvestAcounts(investAcounts);//投资账号
            bean.setInvestAmount(StringUtils.string2Float(investAcount));//投资金额
            bean.setInvestNumberOfDays(StringUtils.string2Integer(investNumberOfDays));//投资天数

            bean.setLastModifyDate(currentDay);//最后修改日期
            bean.setMark(investMark);//投资备注
//            bean.setMatureFlag();//是否到期
//            bean.setModifyNumber();//修改次数
            bean.setMonth(investDate.substring(5, 6));//投资月份2018-01-01
            bean.setYear(investDate.substring(0, 3));//投资年份

            bean.setPhoneNumer(phoneNumber);//关联手机号
            bean.setRepayAmount(StringUtils.string2Float(repayAcount));//回款金额
            bean.setTotalAnnualIncome(totalAnnualIncome);//总年化收益
            bean.setTotalIncome(StringUtils.string2Float(totalIncome));//总收益
//            bean.setValidFlag(!"无效".equals(validFlag));//统计标识
            bean.save();
            ToastUtils.showToast(AddInvestRecordDetailsActivity.this, R.string.baocunchenggong);
            saveOthers();

        } else {

            DialogUtils.showPromptDialog(this, getString(R.string.dangqianjilupingtai), new DialogUtils.DialogUtilsCallBack() {
                @Override
                public void cancel() {

                }

                @Override
                public void affirm() {
                    list.get(0).setRepayDate(repayDate);//回款日期
                    list.get(0).setCashBack(StringUtils.string2Float(cashBack));//额外收益


                    list.get(0).setExtraAnnualIncome(extraAnnualIncome);//额外年化收益
                    list.get(0).setFixedAnnualIncom(fixedAnnualIncome);//固定年化收益
                    list.get(0).setInvestAcounts(investAcounts);//投资账号
                    list.get(0).setInvestAmount(StringUtils.string2Float(investAcount));//投资金额
                    list.get(0).setInvestNumberOfDays(StringUtils.string2Integer(investNumberOfDays));//投资天数

                    list.get(0).setLastModifyDate(currentDay);//最后修改日期
                    list.get(0).setMark(investMark);//投资备注
//            list.get(0).setMatureFlag();//是否到期
                    list.get(0).setModifyNumber(list.get(0).getModifyNumber() + 1);//修改次数
//                    list.get(0).setMonth(investDate.substring(5, 6));//投资月份2018-01-01
//                    list.get(0).setYear(investDate.substring(0, 3));//投资年份

                    list.get(0).setPhoneNumer(phoneNumber);//关联手机号
                    list.get(0).setRepayAmount(StringUtils.string2Float(repayAcount));//回款金额
                    list.get(0).setTotalAnnualIncome(totalAnnualIncome);//总年化收益
                    list.get(0).setTotalIncome(StringUtils.string2Float(totalIncome));//总收益
                    list.get(0).setValidFlag(!"无效".equals(validFlag));//统计标识

                    list.get(0).save();
                    saveOthers();
                    ToastUtils.showToast(AddInvestRecordDetailsActivity.this, R.string.baocunchenggong);


                }
            }, null, null, null);
        }
    }

    private void saveOthers() {
        List<InvestDateLMBean> list1 = DataSupport.where("userName = ? and investDate = ?", userName,investDate).find(InvestDateLMBean.class);
        List<RepayDateLMBean> list2 = DataSupport.where("userName = ? and repayDate = ?", userName,repayDate).find(RepayDateLMBean.class);
        List<InvestPlateformLMBean> list3 = DataSupport.where("userName = ? and investPlateform = ?", userName,investPlateform).find(InvestPlateformLMBean.class);
        if (list1.size() == 0) {
            InvestDateLMBean bean1=new InvestDateLMBean();
            bean1.setUserName(userName);
            bean1.setInvestDate(investDate);
            bean1.save();
        }
        if (list2.size() == 0) {
            RepayDateLMBean bean2=new RepayDateLMBean();
            bean2.setUserName(userName);
            bean2.setRepayDate(repayDate);
            bean2.save();
        }
        if (list3.size() == 0) {
            InvestPlateformLMBean bean3=new InvestPlateformLMBean();
            bean3.setUserName(userName);
            bean3.setInvestPlateform(investPlateform);
            bean3.save();
        }


    }

    /**
     * 检查内容是否已填写
     */
    private boolean checkContent() {
        investPlateform = etInvestPlateform.getText().toString().trim();
        repayDate = etRepaydate.getText().toString().trim();
        investAcount = etInvestAmount.getText().toString().trim();

        investDate = etInvestdate.getText().toString().trim();
        if ("".equals(investDate)) {
            investDate = currentDay;
        }

        if (!checkDateStyle(investDate)) {
            ToastUtils.showToast(AddInvestRecordDetailsActivity.this, R.string.qingshuruzhengquedetouziriqi);
            return false;
        }

        if (!checkDateStyle(repayDate)) {
            ToastUtils.showToast(AddInvestRecordDetailsActivity.this, R.string.qingshuruzhengquedehuikuanriqi);
            return false;
        }

        if ("".equals(investPlateform)) {
            ToastUtils.showToast(AddInvestRecordDetailsActivity.this, R.string.qingshurutouzipingtai);
            return false;
        }else if ("".equals(investAcount)) {
            ToastUtils.showToast(AddInvestRecordDetailsActivity.this, R.string.qingshuruhuikuanriqi);
            return false;
        } else {
            return true;
        }

    }

    /**
     * 检查日期格式是否正确
     */
    private boolean checkDateStyle(String date) {
        String temp[] = date.split("-");
        if (temp.length != 3 || temp[0].length() != 4 || temp[1].length() != 2 ||
                StringUtils.string2Integer(temp[1]) > 12 || temp[2].length() != 2 || StringUtils.string2Integer(temp[2]) > 31) {
            return false;
        }
        return true;
    }


    @Override
    public void initDataFromIntent() {
        userName = UserConfig.getInstance().getUserName(this);
        currentDay = TimeUtils.getNowDateShort();
        investPlateform=getIntent().getStringExtra("plateform");

        if (investPlateform != null && (!"".equals(investPlateform))) {
            etInvestPlateform.setText(investPlateform);
            etInvestPlateform.setEnabled(false);
            etInvestPlateform.setFocusable(false);
            etInvestPlateform.setKeyListener(null);
        }
    }

    @Override
    public void initView() {
        setTopMargin(mtb, MApp.STATUS_BAE_HEIGHT);

    }

    @Override
    public void initListener() {
        setCloseLisenter(mtb);

        tvSave.setOnClickListener(this);


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
