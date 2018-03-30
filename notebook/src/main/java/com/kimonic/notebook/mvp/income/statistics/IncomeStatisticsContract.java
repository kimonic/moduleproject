package com.kimonic.notebook.mvp.income.statistics;

import com.kimonic.utilsmodule.mvp.BasePresenter;
import com.kimonic.utilsmodule.mvp.BaseView;

import java.util.List;

/**
 * * ===============================================================
 * name:             IncomeStatisticsContract
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/30
 * method:
 * <p>
 * <p>
 * description：
 * history：
 * *==================================================================
 */

public class IncomeStatisticsContract {

    public interface Presenter extends BasePresenter {
        void init();
        /**设置上一个月文本*/
        void setPrevious();
        /**设置下一个月文本*/
        void setNext();

    }

    public interface View extends BaseView<Presenter> {
        void setTvCurrenr(String str);
        void setListView(List<IncomeStatisticsPresenter.SizeBean> list);
        void setTotal(String str);
        /**设置无数据展示*/
        void showNothing(boolean flag);
    }
}
