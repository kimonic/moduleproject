package com.kimonic.notebook.mvp.expenditure;

import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.litemapbean.daily.ExpenditureLMBean;
import com.kimonic.utilsmodule.utils.StringUtils;
import com.kimonic.utilsmodule.utils.TimeUtils;

import org.litepal.crud.DataSupport;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * * ===============================================================
 * name:             ExpenditureReository
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/21
 * method:
 * <p>
 * <p>
 * description：  支出activity的数据源
 * history：
 * *==================================================================
 */

public class ExpenditureReository {

    /**加载数据*/
    public List<ExpenditureLMBean> loadData(String userName, int year, int month) {


        List<ExpenditureLMBean> listDate = DataSupport.where("userName = ? and year = ? and month =?"
                , userName, "" + year, TimeUtils.getCurrentMonthStr(month)).find(ExpenditureLMBean.class);

        if (listDate.size() < 2) {
            return listDate;
        }

        Collections.sort(listDate, new ReositoryComparator());

        return listDate;
    }

    /**删除某一项数据*/
    public boolean delete(long id){
        UserConfig.getInstance().setExpenditureChange(true);
        return DataSupport.delete(ExpenditureLMBean.class,id)>0;
    }
    /**查询某一条数据*/
    public ExpenditureLMBean query(long id){
        return DataSupport.find(ExpenditureLMBean.class,id);
    }

    /**
     * 按照日期排序
     */
    private class ReositoryComparator implements Comparator<ExpenditureLMBean> {
        @Override
        public int compare(ExpenditureLMBean o1, ExpenditureLMBean o2) {
            return StringUtils.string2Integer(o2.getDate())-StringUtils.string2Integer(o1.getDate());
        }
    }
}
