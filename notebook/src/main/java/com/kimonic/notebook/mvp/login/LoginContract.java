package com.kimonic.notebook.mvp.login;

import android.widget.EditText;

import com.kimonic.utilsmodule.mvp.BasePresenter;
import com.kimonic.utilsmodule.mvp.BaseView;

import java.util.Map;

/**
 * * ===============================================================
 * name:             LoginContract
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/27
 * method:
 * <p>
 * <p>
 * description： 登陆页面契约类
 * history：
 * *==================================================================
 */

public interface LoginContract {


    interface Presenter extends BasePresenter {

        /**校验用户名密码*/
        boolean check(Map<String,EditText> map);

    }

    interface View extends BaseView<Presenter> {

    }
}
