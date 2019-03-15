package com.kimonic.notebook.mvp.memorandum;

import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.litemapbean.memorandum.MemorandumLMBean;
import com.kimonic.utilsmodule.utils.StringUtils;
import com.kimonic.utilsmodule.utils.TimeUtils;

import org.litepal.crud.DataSupport;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * * ===============================================================
 * name:             MemorandumRespository
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/26
 * method:
 * <p>
 * <p>
 * description： 备忘录数据库操作类
 * history：
 * *==================================================================
 */

public class MemorandumRespository<T> {

    /**获取该用户下所有数据*/
    public List<MemorandumLMBean> loadData(String userName) {

        List<MemorandumLMBean> listDate = DataSupport.where("userName = ?"
                , userName).find(MemorandumLMBean.class);

        if (listDate.size() < 2) {
            return listDate;
        }

        Collections.sort(listDate, new ReositoryComparator());

        return listDate;
    }

        /**加载数据*/
    public List<MemorandumLMBean> loadData(String userName, int year, int month) {


        List<MemorandumLMBean> listDate = DataSupport.where("userName = ? and year = ? and month =?"
                , userName, "" + year, TimeUtils.getCurrentMonthStr(month)).find(MemorandumLMBean.class);

        if (listDate.size() < 2) {
            return listDate;
        }

        Collections.sort(listDate, new ReositoryComparator());

        return listDate;
    }

    /**删除某一项数据*/
    public boolean delete(long id){
        UserConfig.getInstance().setMemorandumChange(true);
        return DataSupport.delete(MemorandumLMBean.class,id)>0;
    }
    /**查询某一条数据*/
    public MemorandumLMBean query(long id){
        return DataSupport.find(MemorandumLMBean.class,id);
    }

    /**
     * 按照日期排序
     */
    private class ReositoryComparator implements Comparator<MemorandumLMBean> {
        @Override
        public int compare(MemorandumLMBean o1, MemorandumLMBean o2) {
            return StringUtils.string2Integer(o2.getDay())-StringUtils.string2Integer(o1.getDay());
        }
    }
}
