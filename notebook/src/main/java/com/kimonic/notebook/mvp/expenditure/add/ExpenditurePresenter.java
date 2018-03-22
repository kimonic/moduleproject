package com.kimonic.notebook.mvp.expenditure.add;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;

import com.kimonic.notebook.R;
import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.litemapbean.daily.ExpenditureLMBean;
import com.kimonic.notebook.mvp.expenditure.ExpenditureReository;
import com.kimonic.utilsmodule.utils.CheckUtils;
import com.kimonic.utilsmodule.utils.StringUtils;
import com.kimonic.utilsmodule.utils.TimeUtils;

import java.util.Map;

/**
 * * ===============================================================
 * name:             ExpenditurePresenter
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/21
 * method:
 * <p>
 * <p>
 * description： 支出activity Presenter
 * history：
 * *==================================================================
 */

public class ExpenditurePresenter implements ExpenditureContract.Presenter {

    /**
     * 视图
     */
    private ExpenditureContract.View view;
    /**
     * 数据源
     */
    private ExpenditureReository reository;
    /**
     * 实体数据,在本类中充当了数据源的作用
     */
    private ExpenditureLMBean bean;

    public ExpenditurePresenter(ExpenditureContract.View view, ExpenditureReository reository) {
        this.view = view;
        this.reository = reository;
    }

    @Override
    public void start() {
        // TODO: 2018/3/21 加载本地或网络数据
    }

    @Override
    public void backup() {
        // TODO: 2018/3/21 备份支出记录 
    }

    @Override
    public void save(Map<String, EditText> map) {

        String name = map.get("name").getText().toString().trim();
        String amount = map.get("amount").getText().toString().trim();
        String date = map.get("date").getText().toString().trim();
        String mark = map.get("mark").getText().toString().trim();

        if (TextUtils.isEmpty(name)) {
            view.showToast(R.string.qingshuruzhichumingcheng);
            return;
        } else if (TextUtils.isEmpty(amount)) {
            view.showToast(R.string.qingshuruzhichujine);
            return;
        } else if (TextUtils.isEmpty(date)) {
            date = TimeUtils.getNowDateShort();
        } else if (CheckUtils.checkDate(date)) {
            view.showToast(R.string.riqigeshicuowu);
            return;
        }

        String[] dateSplit = date.split("-");
        if (bean == null) {//重复保存时只保存一个,若有修改则保存修改值
            bean = new ExpenditureLMBean();
        }
        bean.setUserName(UserConfig.getInstance().getUserName((Context) view));
        bean.setAmount(StringUtils.string2Float(amount));
        bean.setDate(dateSplit[2]);
        bean.setYear(dateSplit[0]);
        bean.setMonth(dateSplit[1]);
        bean.setItemName(name);
        bean.setMark(mark);
        bean.save();
        view.setSave(R.string.zaicitianjia);
        view.showToast(R.string.baocunchenggong);
    }

    @Override
    public void clear() {
        if (bean != null) {
            bean = null;
            view.setSave(R.string.baocunzhichujilu);
            view.clear();
        }
    }
}
