package com.kimonic.notebook.mvp.expenditure.query;

import android.content.Context;

import com.kimonic.notebook.R;
import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.litemapbean.daily.ExpenditureLMBean;
import com.kimonic.notebook.mvp.expenditure.ExpenditureReository;
import com.kimonic.utilsmodule.utils.LUtils;
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

public class ExpenditureQueryPresenter implements ExpenditureQueryContract.Presenter {
    private ExpenditureQueryContract.View view;
    private ExpenditureReository reository;
    private int currentYear, fixYear;
    private int currentMonth, fixMonth;
    private int count = 0;
    private List<ExpenditureLMBean> list;
    private boolean nothingFlag=false;
    private String userName;

    public ExpenditureQueryPresenter(ExpenditureQueryContract.View view, ExpenditureReository reository) {
        this.view = view;
        this.reository = reository;
        userName= UserConfig.getInstance().getUserName((Context) view);
    }

    @Override
    public void start() {
        list=new ArrayList<>();
        list.addAll(reository.loadData(userName,currentYear,currentMonth));
        LUtils.e(ExpenditureQueryPresenter.class,"logflag-???--"+list.size());
        if (list.size()==0){
            view.showNothing(true);
        }else {
            view.setList(list,ExpenditureQueryActivity.ADAPTER_SET);
        }
    }
    @Override
    public void updateData() {
        list.clear();
        list.addAll(reository.loadData(userName,currentYear,currentMonth));
        if (list.size()==0){
            view.showNothing(true);
        }else {
            view.showNothing(false);
            view.setList(list,ExpenditureQueryActivity.ADAPTER_UPDATE);
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


}
