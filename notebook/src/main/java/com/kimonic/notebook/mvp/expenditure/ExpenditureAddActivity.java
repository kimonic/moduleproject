package com.kimonic.notebook.mvp.expenditure;

import android.view.View;

import com.kimonic.notebook.R;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.lzy.okgo.model.Response;

/**
 * * ===============================================================
 * name:             ExpenditureAddActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/21
 * method:
 * <p>
 * <p>
 * description：
 * history：
 * *==================================================================
 */

public class ExpenditureAddActivity extends BaseActivity implements ExpenditureContract.View{

    private ExpenditureContract.Presenter presenter;

    @Override
    public int getLayoutResId() {
        return R.layout.act_expenditure_add;
    }

    @Override
    protected int setStatusBarColor() {
        return 0;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initDataFromIntent() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initDataFromInternet() {

    }

    @Override
    public void loadInternetDataToUi(Response<String> response) {

    }

    @Override
    public void loadInternetDataToUi() {

    }

    @Override
    public void setPresenter(ExpenditureContract.Presenter presenter) {
        this.presenter=presenter;
    }
}
