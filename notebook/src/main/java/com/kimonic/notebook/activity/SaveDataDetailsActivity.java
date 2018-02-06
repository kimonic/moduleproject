package com.kimonic.notebook.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.litemapbean.DateRecordLMBean;
import com.kimonic.notebook.litemapbean.ItemFlagLMBean;
import com.kimonic.notebook.litemapbean.SaveDataLMBean;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.utils.StringUtils;
import com.kimonic.utilsmodule.utils.TimeUtils;
import com.kimonic.utilsmodule.utils.ToastUtils;
import com.lzy.okgo.model.Response;

import org.litepal.crud.DataSupport;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * * ===============================================================
 * name:             SaveDataDetailsActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/6
 * description：保存用户下相应标签的详细数据
 * history：
 * *==================================================================
 */

public class SaveDataDetailsActivity extends BaseActivity {
    @BindView(R.id.tv_act_savedatadetails_current_user)
    TextView tvCurrentUser;
    @BindView(R.id.tv_act_savedatadetails_label)
    TextView tvLabel;
    @BindView(R.id.tv_act_savedatadetails_save)
    TextView tvSave;
    @BindView(R.id.et_act_savedatadetails_content)
    EditText etContent;
   @BindView(R.id.et_act_savedatadetails_riqi)
    EditText etRiQi;
    private String label;
    private String itemFlag;
    private String userName;

    @Override
    public int getLayoutResId() {
        return R.layout.act_savedatadetails;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_act_savedatadetails_save://保存
                String  date;
                if ("".equals(etRiQi.getText().toString().trim())){
                     date= TimeUtils.getNowDateShort();
                }else {
                     date=etRiQi.getText().toString().trim();
                }

                float vaule= StringUtils.string2Float(etContent.getText().toString().trim());
                List<SaveDataLMBean> listItem= DataSupport.where("userName = ? and dateFlag = ? and " +
                        "itemFlag = ?",userName,date,itemFlag).find(SaveDataLMBean.class);
                if (listItem!=null&&listItem.size()>0){
                    listItem.get(0).setValue(vaule);
                    listItem.get(0).save();
                }else {
                    SaveDataLMBean bean=new SaveDataLMBean();
                    bean.setValue(vaule);
                    bean.setDateFlag(date);
                    bean.setItem(label);
                    bean.setUserName(userName);
                    bean.setItemFlag(itemFlag);
                    bean.save();
                }

                List<DateRecordLMBean> listDate= DataSupport.where("userName = ? and date = ? "
                        ,userName,date).find(DateRecordLMBean.class);
                if (listDate==null||listDate.size()==0){
                    DateRecordLMBean bean1=new DateRecordLMBean();
                    bean1.setUserName(userName);
                    bean1.setDate(date);
                    bean1.save();
                }

                ToastUtils.showToast(SaveDataDetailsActivity.this, R.string.baocunchenggong);

                break;
//            case R.id.: break;
//            case R.id.: break;
//            case R.id.: break;
//            case R.id.: break;
//            case R.id.: break;
        }
    }

    @Override
    public void initDataFromIntent() {

        userName=UserConfig.getInstance().getUserName(this);
        label = getIntent().getStringExtra("label");
        itemFlag = getIntent().getStringExtra("itemFlag");
    }

    @Override
    public void initView() {

        tvCurrentUser.setText(userName);
        tvLabel.setText(label);
    }

    @Override
    public void initListener() {
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
