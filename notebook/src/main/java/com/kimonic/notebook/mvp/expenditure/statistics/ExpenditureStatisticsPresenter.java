package com.kimonic.notebook.mvp.expenditure.statistics;

import android.content.Context;

import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.litemapbean.daily.ExpenditureLMBean;
import com.kimonic.notebook.mvp.expenditure.ExpenditureReository;
import com.kimonic.utilsmodule.utils.TimeUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * * ===============================================================
 * name:             ExpenditureStatisticsPresenter
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/29
 * method:
 * <p>
 * <p>
 * description：
 * history：
 * *==================================================================
 */

public class ExpenditureStatisticsPresenter implements ExpenditureStatisticsContract.Presenter {

    private ExpenditureReository reository;
    private ExpenditureStatisticsContract.VIew view;
    private int year;
    private int month;
    private int day;
    private String userName;
    private List<ExpenditureLMBean> list;
    private Set<String> set;

    private List<String> type;
    private List<Float> sumType;
    private List<SizeBean> sizeBeanList;

    public ExpenditureStatisticsPresenter(ExpenditureStatisticsContract.VIew view) {
        this.view = view;
        reository = new ExpenditureReository();
        userName = UserConfig.getInstance().getUserName((Context) view);
        set = new HashSet<>();
        type = new ArrayList<>();
        sumType = new ArrayList<>();
        sizeBeanList = new ArrayList<>();
        list = new ArrayList<>();
    }

    @Override
    public void init() {
        year = TimeUtils.getCurrentYear();
        month = TimeUtils.getCurrentMonthInt();
        day = TimeUtils.getCurrentDayInt();
        view.setTvCurrenr(year + "年" + month + "月");
        list.addAll(reository.loadData(userName, year, month));


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
        view.setListView(sizeBeanList);


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
