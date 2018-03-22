package com.kimonic.notebook.mvp.expenditure.add;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.mapp.MApp;
import com.kimonic.notebook.mvp.expenditure.ExpenditureReository;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.ui.MTopBarView;
import com.kimonic.utilsmodule.utils.TimeUtils;
import com.kimonic.utilsmodule.utils.ToastUtils;
import com.lzy.okgo.model.Response;

import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;

/**
 * * ===============================================================
 * name:             ExpenditureAddActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/21
 * method:
 * <p>
 * <p>
 * description：
 * history：
 * *==================================================================
 */

public class ExpenditureAddActivity extends BaseActivity implements ExpenditureContract.View {

    @BindView(R.id.mtb_act_expenditure_add)
    MTopBarView mtb;
    @BindView(R.id.et_act_expenditure_add_name)
    EditText etName;
    @BindView(R.id.et_act_expenditure_add_amount)
    EditText etAmount;
    @BindView(R.id.et_act_expenditure_add_datee)
    EditText etDate;
    @BindView(R.id.et_act_expenditure_add_mark)
    EditText etMark;
    @BindView(R.id.tv_act_expenditure_add_save)
    TextView tvSave;
    private ExpenditureContract.Presenter presenter;
    private Map<String, EditText> tvMap;
    private boolean addFlag = true;

    @Override
    public int getLayoutResId() {
        return R.layout.act_expenditure_add;
    }

    @Override
    protected int setStatusBarColor() {
        return getColorRes(R.color.colorQianLan);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_act_expenditure_add_save:
                if (addFlag) {
                    presenter.save(tvMap);
                } else {
                    presenter.clear();
                }
                break;
//                 case R.id.:break;
//                 case R.id.:break;
//                 case R.id.:break;
//                 case R.id.:break;
//                 case R.id.:break;
        }

    }

    @Override
    public void initDataFromIntent() {
        presenter = new ExpenditurePresenter(this, new ExpenditureReository());
        tvMap = new TreeMap<>();
        tvMap.put("name", etName);
        tvMap.put("amount", etAmount);
        tvMap.put("date", etDate);
        tvMap.put("mark", etMark);

    }

    @Override
    public void initView() {
        setTopMargin(mtb, MApp.STATUS_BAE_HEIGHT);
        etDate.setText(TimeUtils.getNowDateShort());
    }

    @Override
    public void initListener() {
        tvSave.setOnClickListener(this);
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

    @Override
    public void setPresenter(ExpenditureContract.Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void showToast(int resStr) {
        ToastUtils.showToast(this, resStr);
    }

    @Override
    public void setSave(int strRes) {
        addFlag=!addFlag;
        tvSave.setText(strRes);
    }

    @Override
    public void clear() {
        etAmount.setText("");
        etName.setText("");
        etMark.setText("");
    }
}
