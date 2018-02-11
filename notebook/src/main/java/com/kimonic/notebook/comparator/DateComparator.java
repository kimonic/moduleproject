package com.kimonic.notebook.comparator;

import com.kimonic.notebook.litemapbean.fixedassets.DateRecordLMBean;
import com.kimonic.utilsmodule.utils.StringUtils;

import java.util.Comparator;

/**
 * * ===============================================================
 * name:             DateComparator
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/11
 * description：  日期比较,最近日期在上
 * history：
 * *==================================================================
 */

public class DateComparator implements Comparator<DateRecordLMBean> {


    @Override
    public int compare(DateRecordLMBean o1, DateRecordLMBean o2) {
        if (StringUtils.string2Integer(o1.getDate().replace("-", ""))
                < StringUtils.string2Integer(o2.getDate().replace("-", ""))
                ) {
            return 1;
        } else if (StringUtils.string2Integer(o1.getDate().replace("-", ""))
                == StringUtils.string2Integer(o2.getDate().replace("-", ""))
                ) {
            return 0;
        } else {
            return -1;
        }
    }
}
