package com.kimonic.notebook.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.litemapbean.DataNameTableLMBean;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.ui.MTopBarView;
import com.kimonic.utilsmodule.utils.ToastUtils;
import com.lzy.okgo.model.Response;

import org.litepal.crud.DataSupport;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * * ===============================================================
 * name:             AddNewUserActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/2
 * description：
 * history：
 * *==================================================================
 */

public class AddNewUserActivity extends BaseActivity {
    @BindView(R.id.mtb_act_addnewuser)
    MTopBarView mtb;
    @BindView(R.id.et_act_addnewuser_name)
    EditText etName;
    @BindView(R.id.et_act_addnewuser_pw)
    EditText etPw;
    @BindView(R.id.tv_act_addnewuser_add)
    TextView tvAdd;

    @Override
    public int getLayoutResId() {
        return R.layout.act_addnewuser;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_act_addnewuser_add://确认添加
                String userName = etName.getText().toString().trim();
                if (!"".equals(userName)) {
                    String pw = etPw.getText().toString().trim();
                    if (!"".equals(pw)) {
                        List<DataNameTableLMBean> list = DataSupport.where(
                                "user = ?", userName)
                                .find(DataNameTableLMBean.class);
                        if (list.size()>0){
                            ToastUtils.showToast(AddNewUserActivity.this, R.string.yognhumingyicunzai);
                        }else {
                            DataNameTableLMBean bean = new DataNameTableLMBean();
                            bean.setUser(userName);
                            bean.setPassWord(pw);
                            bean.save();
                            ToastUtils.showToast(AddNewUserActivity.this, R.string.baocunchenggong);
                        }

                    } else {
                        ToastUtils.showToast(AddNewUserActivity.this, R.string.qingshuruzhengquedemima);
                    }
                } else {
                    ToastUtils.showToast(AddNewUserActivity.this, R.string.yonghumingbunengweikong);
                }
                break;
//         case R.id.:break;
//         case R.id.:break;
//         case R.id.:break;
//         case R.id.:break;
//         case R.id.:break;
        }
    }

    @Override
    public void initDataFromIntent() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        tvAdd.setOnClickListener(this);
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
