package com.kimonic.notebook.mvp.loginandregister.register;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;

import com.kimonic.notebook.R;
import com.kimonic.notebook.mvp.loginandregister.LoginRegisterRespository;

import java.util.Map;

/**
 * * ===============================================================
 * name:             RegisterPresenter
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

public class RegisterPresenter implements RegisterContract.Presenter {
    private RegisterContract.View view;
    private LoginRegisterRespository respository;

    public RegisterPresenter(RegisterContract.View view, LoginRegisterRespository respository) {
        this.view = view;
        this.respository = respository;
    }

    @Override
    public void start() {

    }

    @Override
    public boolean save(Map<String, EditText> map) {

        String username = map.get("username").getText().toString().trim();
        String password = map.get("password").getText().toString().trim();
        String passwordagain = map.get("passwordagain").getText().toString().trim();
        if (TextUtils.isEmpty(username)) {
            view.showToast(R.string.qingshuruyonghuming);
        } else if (respository.checkUserName(username)>0){
            view.showToast(R.string.yognhumingyicunzai);
        }else if (TextUtils.isEmpty(password)) {
            view.showToast(R.string.qingshurumima);
        } else if (TextUtils.isEmpty(passwordagain)) {
            view.showToast(R.string.act_register_password_again);
        } else if (password.length() < 6 || passwordagain.length() < 6) {
            view.showToast(R.string.mimachangdubunengxiaoyu);
        } else if (!password.equals(passwordagain)) {
            view.showToast(R.string.qianhouliangcimimashurubuyizhi);
        } else {
            respository.saveUserNamePassWord(username,password, (Context) view);
            view.showToast(R.string.zhucechenggong);
            return true;
        }
        return false;
    }
}
