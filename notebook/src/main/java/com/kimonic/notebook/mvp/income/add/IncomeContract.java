package com.kimonic.notebook.mvp.income.add;

import android.support.annotation.StringRes;
import android.widget.EditText;

import com.kimonic.notebook.litemapbean.daily.IncomeLMBean;
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
 * description：  收入activity契约类
 * history：
 * *==================================================================
 */

public interface IncomeContract {
    interface View extends BaseView<Presenter>{
        /**展示提示信息*/
        void showToast(@StringRes int resStr);
        /**设置按钮信息*/
        void setSave(@StringRes int strRes);
        /**清空已输入信息*/
        void clear();
        /**初始化所有控件*/
        void init(IncomeLMBean bean);

    }
    interface Presenter extends BasePresenter{
        /**备份收入记录*/
        void backup();
        /**保存收入记录*/
        void save(Map<String, EditText> map);
        /**清空已保存记录*/
        void clear();
        /**带参初始化数据*/
        void init(long id);

    }
}
