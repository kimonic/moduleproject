package com.kimonic.notebook.mvp.expenditure.add;

import android.support.annotation.StringRes;
import android.widget.EditText;

import com.kimonic.utilsmodule.mvp.BasePresenter;
import com.kimonic.utilsmodule.mvp.BaseView;

import java.util.Map;

/**
 * * ===============================================================
 * name:             ExpenditureContract
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/21
 * method:
 * <p>
 * <p>
 * description：  支出activity契约类
 * history：
 * *==================================================================
 */

public interface ExpenditureContract {
    interface View extends BaseView<Presenter>{
        /**展示提示信息*/
        void showToast(@StringRes int resStr);
        /**设置按钮信息*/
        void setSave(@StringRes int strRes);
        /**清空已输入信息*/
        void clear();

    }
    interface Presenter extends BasePresenter{
        /**备份支出记录*/
        void backup();
        /**保存支出记录*/
        void save(Map<String,EditText> map);
        /**清空已保存记录*/
        void clear();

    }
}
