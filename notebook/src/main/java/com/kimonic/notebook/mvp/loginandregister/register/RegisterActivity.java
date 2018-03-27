package com.kimonic.notebook.mvp.loginandregister.register;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.activity.welcome.HomeActivity;
import com.kimonic.notebook.mvp.loginandregister.LoginRegisterRespository;
import com.kimonic.notebook.mvp.loginandregister.login.LoginActivity;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.lzy.okgo.model.Response;

import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * * ===============================================================
 * name:             RegisterActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/27
 * method:
 * <p>
 * <p>
 * description：注册activity
 * history：
 * *==================================================================
 */

public class RegisterActivity extends BaseActivity implements RegisterContract.View {

    @BindView(R.id.et_act_register_username)
    EditText etUserName;
    @BindView(R.id.et_act_register_password)
    EditText etPassword;
    @BindView(R.id.et_act_register_password_again)
    EditText etPasswordAgain;
    @BindView(R.id.tv_act_register_login)
    TextView tvLogin;
    @BindView(R.id.tv_act_register_save)
    TextView tvSave;

    private Map<String,EditText> map;
    private RegisterContract.Presenter presenter;

    @Override
    public int getLayoutResId() {
        return R.layout.act_register;
    }

    @Override
    protected int setStatusBarColor() {
        return 0;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_act_register_login:
                openActivity(LoginActivity.class);
                closeActivity();
                break;
            case R.id.tv_act_register_save:
                if (presenter.save(map)){
                    openActivity(HomeActivity.class);
                    closeActivity();
                }
                break;
//         case R.id.:break;
//         case R.id.:break;
//         case R.id.:break;
//         case R.id.:break;
        }
    }

    @Override
    public void initDataFromIntent() {
        map=new TreeMap<>();
        map.put("username",etUserName);
        map.put("password",etPassword);
        map.put("passwordagain",etPasswordAgain);

        presenter=new RegisterPresenter(this,new LoginRegisterRespository());


    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        tvLogin.setOnClickListener(this);
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
    public void setPresenter(RegisterContract.Presenter presenter) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
