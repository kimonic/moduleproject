package com.kimonic.notebook.mvp.expenditure;

/**
 * * ===============================================================
 * name:             ExpenditurePresenter
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/21
 * method:
 * <p>
 * <p>
 * description： 支出activity Presenter
 * history：
 * *==================================================================
 */

public class ExpenditurePresenter implements ExpenditureContract.Presenter {

    private ExpenditureContract.View view;
    private ExpenditureReository reository;

    public ExpenditurePresenter(ExpenditureContract.View view, ExpenditureReository reository) {
        this.view = view;
        this.reository = reository;
    }

    @Override
    public void start() {
        // TODO: 2018/3/21 加载本地或网络数据
    }

    @Override
    public void backup() {
        // TODO: 2018/3/21 备份支出记录 
    }
}
