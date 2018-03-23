package com.kimonic.notebook.mvp.income.query;

import android.support.annotation.StringRes;

import com.kimonic.notebook.litemapbean.daily.IncomeLMBean;
import com.kimonic.utilsmodule.mvp.BasePresenter;
import com.kimonic.utilsmodule.mvp.BaseView;

import java.util.List;

/**
 * * ===============================================================
 * name:             ExpenditureQueryContract
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/22
 * method:
 * <p>
 * <p>
 * description：
 * history：
 * *==================================================================
 */

public class IncomeQueryContract {

    interface View extends BaseView<Presenter> {

        /**设置list*/
        void setList(List<IncomeLMBean> list, int flag);
        /**设置当前展示文本*/
        void setCurrent(String str);
        /**设置无数据展示*/
        void showNothing(boolean flag);
        /**显示提示信息*/
        void showToast(@StringRes int strRes);
    }

    interface Presenter extends BasePresenter {
        /**更新数据*/
        void updateData();
        /**设置上一个月文本*/
        void setPrevious();
        /**设置下一个月文本*/
        void setNext();
        /**设置当前展示文本*/
        void setCurrent();
        /**移除数据源的某一项,并删除本地存储,更新界面*/
        void remove(int position);
        /**启动编辑activity*/
        void startNextAct(int position);

    }
}
