package com.kimonic.notebook.mvp.loginandregister.login;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.activity.welcome.HomeActivity;
import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.mvp.loginandregister.LoginRegisterRespository;
import com.kimonic.notebook.mvp.loginandregister.register.RegisterActivity;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.lzy.okgo.model.Response;

import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;

/**
 * * ===============================================================
 * name:             LoginActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/27
 * method:
 * <p>
 * <p>
 * description：登陆页面activity
 * history：
 * * ==================================================================
 */

public class LoginActivity extends BaseActivity implements LoginContract.View {

    @BindView(R.id.frame_login)
    FrameLayout frame;
    @BindView(R.id.et_act_login_username)
    EditText etUserName;
    @BindView(R.id.et_act_login_password)
    EditText etPassword;
    @BindView(R.id.tv_act_login_forgetpassword)
    TextView tvForgetPassword;
    @BindView(R.id.tv_act_login_register)
    TextView tvRegister;
    @BindView(R.id.tv_act_login_login)
    TextView tvLogin;
    @BindView(R.id.scroll)
    View scroll;
    @BindView(R.id.login_root)
    ScrollView loginRoot;

    private Map<String, EditText> map;

    private LoginContract.Presenter presenter;

    @Override
    public int getLayoutResId() {
        return R.layout.act_login;
    }

    @Override
    protected int setStatusBarColor() {
        return 0;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_act_login_login:
                if (presenter.check(map)) {
                    openActivity(HomeActivity.class);
                    closeActivity();
                }
                break;
            case R.id.tv_act_login_forgetpassword:
                break;
            case R.id.tv_act_login_register:
                openActivity(RegisterActivity.class);
                closeActivity();
                break;
//            case R.id.: break;
//            case R.id.: break;
//            case R.id.: break;
        }
    }

    @Override
    public void initDataFromIntent() {

        map = new TreeMap<>();
        map.put("username", etUserName);
        map.put("password", etPassword);

        presenter = new LoginPresenter(this, new LoginRegisterRespository());

    }

    @Override
    public void initView() {
        etUserName.setText(UserConfig.getInstance().getUserName(this));
    }

    @Override
    public void initListener() {
        tvLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
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
    public void setPresenter(LoginContract.Presenter presenter) {

    }


}
