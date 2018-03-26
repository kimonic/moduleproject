package com.kimonic.notebook.mvp.memorandum.query;

import android.content.Context;
import android.content.Intent;

import com.kimonic.notebook.R;
import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.litemapbean.memorandum.MemorandumLMBean;
import com.kimonic.notebook.mvp.income.query.IncomeQueryActivity;
import com.kimonic.notebook.mvp.memorandum.MemorandumRespository;
import com.kimonic.notebook.mvp.memorandum.add.MemorandumAddActivity;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.utils.TimeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * * ===============================================================
 * name:             MemorandumQueryPresenter
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/26
 * method:
 * <p>
 * <p>
 * description：备忘录列表activity presenter
 * history：
 * *==================================================================
 */

public class MemorandumQueryPresenter implements MemorandumQueryContract.Presenter {

    private MemorandumQueryContract.View view;
    private MemorandumRespository<MemorandumLMBean> respository;
    private String userName;
    private int currentYear, fixYear;
    private int currentMonth, fixMonth;
    private int count = 0;
    private List<MemorandumLMBean> list;
    private boolean nothingFlag = false;

    public MemorandumQueryPresenter(MemorandumQueryContract.View view, MemorandumRespository<MemorandumLMBean> respository) {
        this.view = view;
        this.respository = respository;
        userName= UserConfig.getInstance().getUserName((Context) view);
    }

    @Override
    public void start() {
        list = new ArrayList<>();
        list.addAll(respository.loadData(userName, currentYear, currentMonth));
        if (list.size() == 0) {
            view.showNothing(true);
        } else {
            view.setList(list, MemorandumQueryActivity.ADAPTER_SET);
        }
    }

    @Override
    public void updateData() {
        list.clear();
        list.addAll(respository.loadData(userName, currentYear, currentMonth));
        if (list.size() == 0) {
            view.showNothing(true);
        } else {
            view.showNothing(false);
            view.setList(list, IncomeQueryActivity.ADAPTER_UPDATE);
        }
    }

    @Override
    public void setPrevious() {
        currentYear = TimeUtils.getYearOfLastMonth(currentYear, currentMonth);
        currentMonth = TimeUtils.getLastMonth(currentMonth);
        view.setCurrent(currentYear + "年" + currentMonth + "月");
        updateData();
    }

    @Override
    public void setNext() {
        currentYear = TimeUtils.getYearOfNextMonth(currentYear, currentMonth);
        currentMonth = TimeUtils.getNextMonth(currentMonth);
        if (currentYear > fixYear || (currentYear == fixYear && currentMonth > fixMonth)) {
            currentYear = fixYear;
            currentMonth = fixMonth;
            if (count == 0) {
                view.showToast(R.string.yijingshizuihouyigeyuela);
            }
            count++;
        } else {
            if (count != 0) {
                count = 0;
            }
            view.setCurrent(currentYear + "年" + currentMonth + "月");
            updateData();
        }
    }

    @Override
    public void setCurrent() {
        currentYear = fixYear = TimeUtils.getCurrentYear();
        currentMonth = fixMonth = TimeUtils.getCurrentMonthInt();
        view.setCurrent(currentYear + "年" + currentMonth + "月");
        start();
    }

    @Override
    public void remove(int position) {
        if (respository.delete(list.get(position).getId())) {
            view.showToast(R.string.shanchuchenggong);
        } else {
            view.showToast(R.string.shanchushibai);
        }
        list.remove(position);
        if (list.size() == 0) {
            view.showNothing(true);
        } else {
            view.setList(list, IncomeQueryActivity.ADAPTER_UPDATE);
        }
    }

    @Override
    public void startNextAct(int position) {
        Intent intent=new Intent((BaseActivity) view, MemorandumAddActivity.class);
        intent.putExtra("type", MemorandumAddActivity.TYPE_EDIT);
        intent.putExtra("id",list.get(position).getId());
        ((BaseActivity) view).startActivityForResult(intent,2);
    }
}
