package com.kimonic.notebook.mvp.expenditure;

import com.kimonic.utilsmodule.mvp.BasePresenter;
import com.kimonic.utilsmodule.mvp.BaseView;

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

    }
    interface Presenter extends BasePresenter{
        /**备份支出记录*/
        void backup();

    }
}
