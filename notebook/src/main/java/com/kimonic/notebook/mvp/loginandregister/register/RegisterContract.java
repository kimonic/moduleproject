package com.kimonic.notebook.mvp.loginandregister.register;

import android.widget.EditText;

import com.kimonic.utilsmodule.mvp.BasePresenter;
import com.kimonic.utilsmodule.mvp.BaseView;

import java.util.Map;

/**
 * * ===============================================================
 * name:             RegisterContract
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

public interface RegisterContract {
    interface Presenter extends BasePresenter{
        /**保存用户名密码*/
        boolean save(Map<String,EditText> map);

    }
    interface View extends BaseView<Presenter>{

    }
}
