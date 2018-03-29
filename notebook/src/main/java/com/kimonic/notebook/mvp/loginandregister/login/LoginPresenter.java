package com.kimonic.notebook.mvp.loginandregister.login;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;

import com.kimonic.notebook.R;
import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.mvp.loginandregister.LoginRegisterRespository;

import java.util.Map;

/**
 * * ===============================================================
 * name:             LoginPresenter
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/27
 * method:
 * <p>
 * <p>
 * description：
 * history：
 * *==================================================================
 */

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;
    private LoginRegisterRespository respository;

    public LoginPresenter(LoginContract.View view, LoginRegisterRespository respository) {
        this.view = view;
        this.respository = respository;
    }

    @Override
    public boolean check(Map<String, EditText> map) {
        String userName = map.get("username").getText().toString().trim();
        String password = map.get("password").getText().toString().trim();

        if (TextUtils.isEmpty(userName)){
            view.showToast(R.string.qingshuruyonghuming);
        }else if (TextUtils.isEmpty(password)){
            view.showToast(R.string.qingshurumima);
        }else {
            int flag=respository.checkPassword(userName,password);
            if (flag==1){
                UserConfig.getInstance().setUserName((Context) view,userName);
                UserConfig.getInstance().setLoginDate((Context) view);
                UserConfig.getInstance().setLogin((Context) view,true);
                return true;
            }else {
                view.showToast(R.string.yonghumingmimacuowu);
            }
        }
        return false;
    }

    @Override
    public void start() {

    }
}
