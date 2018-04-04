package com.kimonic.notebook.mvp.income.query;

import android.content.Context;
import android.content.Intent;

import com.kimonic.notebook.R;
import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.litemapbean.daily.IncomeLMBean;
import com.kimonic.notebook.mvp.income.IncomeRepository;
import com.kimonic.notebook.mvp.income.add.IncomeAddActivity;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.utils.TimeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * * ===============================================================
 * name:             ExpenditureQueryPresenter
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

public class IncomeQueryPresenter implements IncomeQueryContract.Presenter {
    private IncomeQueryContract.View view;
    private IncomeRepository respository;
    private int currentYear, fixYear;
    private int currentMonth, fixMonth;
    private int count = 0;
    private List<IncomeLMBean> list;
    private String userName;

    public IncomeQueryPresenter(IncomeQueryContract.View view, IncomeRepository respository) {
        this.view = view;
        this.respository = respository;
        userName = UserConfig.getInstance().getUserName((Context) view);
    }

    @Override
    public void start() {
        list = new ArrayList<>();
        list.addAll(respository.loadData(userName, currentYear, currentMonth));
        if (list.size() == 0) {
            view.showNothing(true);
        } else {
            view.setList(list);
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
            view.setList(list);
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
        if (respository.delete(list.get(position).getItemFlag())) {
            view.showToast(R.string.shanchuchenggong);
        } else {
            view.showToast(R.string.shanchushibai);
        }
        list.remove(position);
        if (list.size() == 0) {
            view.showNothing(true);
        } else {
            view.setList(list);
        }
    }

    /**启动编辑支出记录*/
    @Override
    public void startNextAct(int position) {
        Intent intent=new Intent((BaseActivity) view, IncomeAddActivity.class);
        intent.putExtra("type", IncomeAddActivity.TYPE_EDIT);
        intent.putExtra("id",list.get(position).getItemFlag());
        ((BaseActivity) view).startActivityForResult(intent,2);
    }


}
