package com.kimonic.notebook.mvp.income.statistics;

import android.content.Context;

import com.kimonic.notebook.R;
import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.litemapbean.daily.IncomeLMBean;
import com.kimonic.notebook.mvp.income.IncomeRepository;
import com.kimonic.utilsmodule.utils.TimeUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * * ===============================================================
 * name:             IncomeStatisticsPresenter
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/29
 * method:
 * <p>
 * <p>
 * description：  支出统计presenter
 * history：
 * *==================================================================
 */

public class IncomeStatisticsPresenter implements IncomeStatisticsContract.Presenter {

    private IncomeRepository reository;
    private IncomeStatisticsContract.View view;
    private int year;
    private int month;
    private String userName;
    private List<IncomeLMBean> list;
    private Set<String> set;

    private List<String> type;
    private List<Float> sumType;
    private List<SizeBean> sizeBeanList;
    /**是否第一次进入*/
    private boolean isFirst=true;
    private int fixYear;
    private int fixMonth;
    private int count=0;

    public IncomeStatisticsPresenter(IncomeStatisticsContract.View view) {
        this.view = view;
        reository = new IncomeRepository();
        userName = UserConfig.getInstance().getUserName((Context) view);
        set = new HashSet<>();
        type = new ArrayList<>();
        sumType = new ArrayList<>();
        sizeBeanList = new ArrayList<>();
        list = new ArrayList<>();
        fixYear=year = TimeUtils.getCurrentYear();
        fixMonth=month = TimeUtils.getCurrentMonthInt();
    }

    @Override
    public void init() {

        view.setTvCurrenr(year + "年" + month + "月");
        if (isFirst){
            list.addAll(reository.loadData(userName, year, month));
            isFirst=false;
        }else {
            list.clear();
            set.clear();
            type.clear();
            sumType.clear();
            sizeBeanList.clear();
            list.addAll(reository.loadData(userName, year, month));
        }

        //筛选出所有的类型
        for (int i = 0; i < list.size(); i++) {
            set.add(list.get(i).getType());
        }


        //将类型放置到有序集合并初始化原始和0
        for (String str : set) {
            type.add(str);
            sumType.add(0.0f);
        }

        //根据类型求和
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < type.size(); j++) {
                if (list.get(i).getType().equals(type.get(j))) {
                    sumType.set(j, sumType.get(j) + list.get(i).getAmount());
                }
            }
        }


        //构建存储bean
        float sum = 0;
        for (int i = 0; i < type.size(); i++) {
            SizeBean bean = new SizeBean();
            bean.setType(type.get(i));
            bean.setTotal(sumType.get(i));
            sum += sumType.get(i);
            sizeBeanList.add(bean);
        }

        //排序
        Collections.sort(sizeBeanList, new Comparator<SizeBean>() {
            @Override
            public int compare(SizeBean o1, SizeBean o2) {
                if (o1.getTotal() - o2.getTotal() > 0) {
                    return -1;
                }
                return 1;
            }
        });
        view.setTotal("" + sum);
        if (sizeBeanList.size()==0){
            view.showNothing(true);
        }else {
            view.showNothing(false);
            view.setListView(sizeBeanList);
        }


    }

    @Override
    public void setPrevious() {
        year = TimeUtils.getYearOfLastMonth(year, month);
        month = TimeUtils.getLastMonth(month);
        view.setTvCurrenr(year + "年" + month + "月");
        init();
    }

    @Override
    public void setNext() {
        year = TimeUtils.getYearOfNextMonth(year, month);
        month = TimeUtils.getNextMonth(month);
        if (year > fixYear || (year == fixYear && month > fixMonth)) {
            year = fixYear;
            month = fixMonth;
            if (count == 0) {
                view.showToast(R.string.yijingshizuihouyigeyuela);
            }
            count++;
        } else {
            if (count != 0) {
                count = 0;
            }
            init();
        }
    }

    @Override
    public void start() {

    }

    public class SizeBean {
        private String type;
        private float total;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public float getTotal() {
            return total;
        }

        public void setTotal(float total) {
            this.total = total;
        }
    }
}
