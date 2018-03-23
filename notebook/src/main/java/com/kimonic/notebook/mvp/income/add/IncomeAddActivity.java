package com.kimonic.notebook.mvp.income.add;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.litemapbean.daily.IncomeLMBean;
import com.kimonic.notebook.mapp.MApp;
import com.kimonic.notebook.mvp.income.IncomeRepository;
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
 * name:             IncomeAddActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/23
 * method:
 * <p>
 * <p>
 * description：添加收入记录activity
 * history：
 * *==================================================================
 */

public class IncomeAddActivity extends BaseActivity implements IncomeContract.View{
    @BindView(R.id.mtb_act_income_add)
    MTopBarView mtb;
    @BindView(R.id.et_act_income_add_name)
    EditText etName;
    @BindView(R.id.et_act_income_add_amount)
    EditText etAmount;
    @BindView(R.id.et_act_income_add_type)
    EditText etType;
    @BindView(R.id.et_act_income_add_datee)
    EditText etDate;
    @BindView(R.id.et_act_income_add_mark)
    EditText etMark;
    @BindView(R.id.tv_act_income_add_save)
    TextView tvSave;

    private IncomeContract.Presenter presenter;
    private Map<String, EditText> tvMap;
    private boolean addFlag = true;

    public static final int TYPE_EDIT = 2;
    public static final int TYPE_INSERT = 1;
    private int type = 1;
    private long id = -1;
    @Override
    public int getLayoutResId() {
        return R.layout.act_income_add;
    }

    @Override
    protected int setStatusBarColor() {
        return getColorRes(R.color.colorQianLan);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_act_income_add_save:
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
            //
        }
    }

    @Override
    public void initDataFromIntent() {
        presenter = new IncomePresenter(this, new IncomeRepository());
        tvMap = new TreeMap<>();
        tvMap.put("name", etName);
        tvMap.put("amount", etAmount);
        tvMap.put("date", etDate);
        tvMap.put("mark", etMark);
        tvMap.put("type", etType);

        type = getIntent().getIntExtra("type", TYPE_INSERT);
        id = getIntent().getLongExtra("id", -1);
    }

    @Override
    public void initView() {
        setTopMargin(mtb, MApp.STATUS_BAE_HEIGHT);
        if (type == TYPE_EDIT) {
            mtb.setCenterTitle(R.string.bianjishourujilu);
            tvSave.setText(R.string.xiugaishourujilu);
            presenter.init(id);
        } else {
            etDate.setText(TimeUtils.getNowDateShort());
        }
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

    @Override
    public void setPresenter(IncomeContract.Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void showToast(int resStr) {
        ToastUtils.showToast(this, resStr);
    }

    @Override
    public void setSave(int strRes) {
        addFlag = !addFlag;
        tvSave.setText(strRes);
    }

    @Override
    public void clear() {
        etAmount.setText("");
        etName.setText("");
        etMark.setText("");
        etType.setText("");

    }

    @Override
    public void init(IncomeLMBean bean) {
        etName.setText(bean.getItemName());
        etMark.setText(bean.getMark());
        etAmount.setText(("" + bean.getAmount()));
        etDate.setText(bean.getCompleteDate());
        etType.setText(bean.getType());
    }

    @Override
    public void onBackPressed() {
        setResult(2);
        super.onBackPressed();
    }

    @Override
    public void handleBackup() {
        setResult(2);
    }
}
