package com.kimonic.notebook.mvp.memorandum.add;

import android.support.annotation.StringRes;
import android.widget.EditText;

import com.kimonic.notebook.litemapbean.memorandum.MemorandumLMBean;
import com.kimonic.utilsmodule.mvp.BasePresenter;
import com.kimonic.utilsmodule.mvp.BaseView;

import java.util.Map;

/**
 * * ===============================================================
 * name:             MemorandumAddContract
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/26
 * method:
 * <p>
 * <p>
 * description：
 * history：
 * *==================================================================
 */

public interface MemorandumAddContract {

    interface View extends BaseView<Presenter>{

        /**清空已输入信息*/
        void clear();
        /**初始化所有控件*/
        void init(MemorandumLMBean bean);
        /**设置保存按钮文本*/
        void setSaveText(@StringRes int strRes);
    }
    interface Presenter extends BasePresenter{
        /**保存数据*/
        void save(Map<String,EditText> map);
        /**备份收入记录*/
        void backup();
        /**清空已保存记录*/
        void clear();
        /**带参初始化数据*/
        void init(long id);
    }
}
