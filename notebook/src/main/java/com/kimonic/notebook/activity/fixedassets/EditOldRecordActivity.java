package com.kimonic.notebook.activity.fixedassets;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.litemapbean.fixedassets.SaveDataLMBean;
import com.kimonic.notebook.mapp.MApp;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.ui.MTopBarView;
import com.kimonic.utilsmodule.utils.DialogUtils;
import com.kimonic.utilsmodule.utils.TimeUtils;
import com.kimonic.utilsmodule.utils.ToastUtils;
import com.lzy.okgo.model.Response;

import org.litepal.crud.DataSupport;

import butterknife.BindView;

/**
 * * ===============================================================
 * name:             EditOldRecordActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/8
 * description：   重新编辑原来的记录activity
 * history：
 * *==================================================================
 */

public class EditOldRecordActivity extends BaseActivity {

    @BindView(R.id.et_act_editoldrecord_label)
    EditText etLabel;
    @BindView(R.id.et_act_editoldrecord_shuzhi)
    EditText etShuzhi;
    @BindView(R.id.et_act_editoldrecord_record)
    TextView etRecord;
    @BindView(R.id.et_act_editoldrecord_mark)
    EditText etMark;
    @BindView(R.id.tv_act_editoldrecord_save)
    TextView tvSave;
    @BindView(R.id.tv_act_editoldrecord_modifytimes)
    TextView tvModifyTimes;
     @BindView(R.id.tv_act_editoldrecord_lastmodify)
    TextView tvLastModify;
    @BindView(R.id.mtb_act_editoldrecord)
    MTopBarView mtb;
    private long id;
    private SaveDataLMBean bean;

    @Override
    public int getLayoutResId() {
        return R.layout.act_editoldrecrod;
    }

    @Override
    protected int setStatusBarColor() {
        return getColorRes(R.color.colorQianLan);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_act_editoldrecord_save:
                DialogUtils.showPromptDialog(this, getString(R.string.bunenghuifu), new DialogUtils.DialogUtilsCallBack() {
                    @Override
                    public void cancel() {

                    }

                    @Override
                    public void affirm() {
                        bean.setItemFlag(etLabel.getText().toString().trim());
                        bean.setMark(etMark.getText().toString().trim());
                        bean.setValue(Float.parseFloat(etShuzhi.getText().toString().trim()));
                        bean.setLastModify(TimeUtils.getNowDateShort());
                        bean.setFrequencyOfModification(bean.getFrequencyOfModification() + 1);
                        bean.save();
                        ToastUtils.showToast(EditOldRecordActivity.this, R.string.baocunchenggong);
                    }
                }, null, null, null);

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
        id = getIntent().getLongExtra("id", 0);
        bean = DataSupport.find(SaveDataLMBean.class, id);
    }

    @Override
    public void initView() {
        setTopMargin(mtb, MApp.STATUS_BAE_HEIGHT);
        if (bean != null) {
            etLabel.setText(bean.getItem());
            etMark.setText(bean.getMark());
            etShuzhi.setText(String.valueOf(bean.getValue()));
            etRecord.setText(bean.getDateFlag());
            tvLastModify.setText(bean.getLastModify());
            tvModifyTimes.setText(String.valueOf(bean.getFrequencyOfModification()));
        }


    }

    @Override
    public void initListener() {
        tvSave.setOnClickListener(this);

        mtb.getLeftTV().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeActivity();
            }
        });
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
