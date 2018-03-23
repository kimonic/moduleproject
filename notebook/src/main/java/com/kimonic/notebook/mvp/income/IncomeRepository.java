package com.kimonic.notebook.mvp.income;

import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.litemapbean.daily.IncomeLMBean;
import com.kimonic.utilsmodule.utils.StringUtils;
import com.kimonic.utilsmodule.utils.TimeUtils;

import org.litepal.crud.DataSupport;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * * ===============================================================
 * name:             IncomeRepository
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/21
 * method:
 * <p>
 * <p>
 * description：  收入activity的数据源
 * history：
 * *==================================================================
 */

public class IncomeRepository {

    /**加载数据*/
    public List<IncomeLMBean> loadData(String userName, int year, int month) {


        List<IncomeLMBean> listDate = DataSupport.where("userName = ? and year = ? and month =?"
                , userName, "" + year, TimeUtils.getCurrentMonthStr(month)).find(IncomeLMBean.class);

        if (listDate.size() < 2) {
            return listDate;
        }

        Collections.sort(listDate, new ReositoryComparator());

        return listDate;
    }

    /**删除某一项数据*/
    public boolean delete(long id){
        UserConfig.getInstance().setIncomeChange(true);
        return DataSupport.delete(IncomeLMBean.class,id)>0;
    }
    /**查询某一条数据*/
    public IncomeLMBean query(long id){
        return DataSupport.find(IncomeLMBean.class,id);
    }

    /**
     * 按照日期排序
     */
    private class ReositoryComparator implements Comparator<IncomeLMBean> {
        @Override
        public int compare(IncomeLMBean o1, IncomeLMBean o2) {
            return StringUtils.string2Integer(o2.getDate())-StringUtils.string2Integer(o1.getDate());
        }
    }
}
