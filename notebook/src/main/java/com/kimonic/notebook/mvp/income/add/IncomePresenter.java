package com.kimonic.notebook.mvp.income.add;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;

import com.kimonic.notebook.R;
import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.litemapbean.daily.IncomeLMBean;
import com.kimonic.notebook.mvp.income.IncomeRepository;
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

public class IncomePresenter implements IncomeContract.Presenter {

    /**
     * 视图
     */
    private IncomeContract.View view;
    /**
     * 数据源
     */
    private IncomeRepository reository;
    /**
     * 实体数据,在本类中充当了数据源的作用
     */
    private IncomeLMBean bean;
    /**
     * 是否是编辑模式
     */
    private boolean editMod = false;

    public IncomePresenter(IncomeContract.View view, IncomeRepository reository) {
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
        String type = map.get("type").getText().toString().trim();

        if (TextUtils.isEmpty(name)) {
            view.showToast(R.string.qingshurushourumingcheng);
            return;
        } else if (TextUtils.isEmpty(amount)) {
            view.showToast(R.string.qingshurushourujine);
            return;
        } else if (TextUtils.isEmpty(date)) {
            date = TimeUtils.getNowDateShort();
        } else if (CheckUtils.checkDate(date)) {
            view.showToast(R.string.riqigeshicuowu);
            return;
        } else if (TextUtils.isEmpty(type)) {
            view.showToast(R.string.qingshurushouruleixing);
            return;
        }

        String[] dateSplit = date.split("-");
        if (bean == null) {//重复保存时只保存一个,若有修改则保存修改值
            bean = new IncomeLMBean();
        }
        bean.setUserName(UserConfig.getInstance().getUserName((Context) view));
        bean.setAmount(StringUtils.string2Float(amount));
        bean.setDate(dateSplit[2]);
        bean.setYear(dateSplit[0]);
        bean.setMonth(dateSplit[1]);
        bean.setType(type);
        bean.setItemName(name);
        bean.setMark(mark);
        bean.save();
        if (editMod) {
            view.setSave(R.string.jixubianji);
        } else {
            view.setSave(R.string.zaicitianjia);
        }
        UserConfig.getInstance().setIncomeChange(true);
        view.showToast(R.string.baocunchenggong);
    }

    @Override
    public void clear() {
        if (bean != null && !editMod) {
            bean = null;
            view.clear();
            view.setSave(R.string.baocunshourujilu);
        } else {
            view.setSave(R.string.xiugaishourujilu);
        }

    }

    @Override
    public void init(long id) {
        bean = reository.query(id);
        editMod = true;
        if (bean != null) {
            view.init(bean);
        }
    }
}
