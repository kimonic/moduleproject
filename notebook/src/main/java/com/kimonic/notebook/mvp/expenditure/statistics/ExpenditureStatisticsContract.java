package com.kimonic.notebook.mvp.expenditure.statistics;

import com.kimonic.utilsmodule.mvp.BasePresenter;
import com.kimonic.utilsmodule.mvp.BaseView;

import java.util.List;

/**
 * * ===============================================================
 * name:             ExpenditureStatisticsContract
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/29
 * method:
 * <p>
 * <p>
 * description：支出统计契约类
 * history：
 * *==================================================================
 */

public class ExpenditureStatisticsContract {


    public interface Presenter extends BasePresenter {
        void init();
        /**设置上一个月文本*/
        void setPrevious();
        /**设置下一个月文本*/
        void setNext();

    }

    public interface VIew extends BaseView<Presenter> {
        void setTvCurrenr(String str);
        void setListView(List<ExpenditureStatisticsPresenter.SizeBean> list);
        void setTotal(String str);
        /**设置无数据展示*/
        void showNothing(boolean flag);
    }


}
