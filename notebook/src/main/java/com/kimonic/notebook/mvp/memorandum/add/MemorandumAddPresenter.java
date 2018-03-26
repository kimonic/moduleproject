package com.kimonic.notebook.mvp.memorandum.add;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;

import com.kimonic.notebook.R;
import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.litemapbean.memorandum.MemorandumLMBean;
import com.kimonic.notebook.mvp.memorandum.MemorandumRespository;
import com.kimonic.utilsmodule.utils.CheckUtils;
import com.kimonic.utilsmodule.utils.TimeUtils;

import java.util.Map;

/**
 * * ===============================================================
 * name:             MemorandumAddPresenter
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/26
 * method:
 * <p>
 * <p>
 * description：
 * history：
 * *==================================================================
 */

public class MemorandumAddPresenter<T> implements MemorandumAddContract.Presenter {

    private MemorandumAddContract.View view;
    private MemorandumRespository<T> respository;
    private MemorandumLMBean bean;
    private String userName;
    private boolean editMod;

    public MemorandumAddPresenter(MemorandumAddContract.View view, MemorandumRespository<T> respository) {
        this.view = view;
        this.respository = respository;
        userName = UserConfig.getInstance().getUserName((Context) view);
    }

    @Override
    public void start() {

    }

    @Override
    public void save(Map<String, EditText> map) {
        String title = map.get("title").getText().toString().trim();
        String flag = map.get("flag").getText().toString().trim();
        String date = map.get("date").getText().toString().trim();
        String content = map.get("content").getText().toString().trim();

        if (TextUtils.isEmpty(title)) {
            view.showToast(R.string.qingshurubiaoti);
            return;
        } else if (TextUtils.isEmpty(flag)) {
            view.showToast(R.string.qingshurubiaoqianmingcheng);
            return;
        } else if (TextUtils.isEmpty(content)) {
            view.showToast(R.string.qingshurujiluneirong);
            return;
        } else if (TextUtils.isEmpty(date)) {
            date = TimeUtils.getNowDateShort();
        } else if (CheckUtils.checkDate(date)) {
            view.showToast(R.string.riqigeshicuowu);
            return;
        }

        if (bean == null) {
            bean = new MemorandumLMBean();
        }

        String[] dateFull = date.split("-");
        bean.setTitle(title);
        bean.setContent(content);
        bean.setFlag(flag);
        bean.setUserName(userName);
        bean.setDay(dateFull[2]);
        bean.setMonth(dateFull[1]);
        bean.setYear(dateFull[0]);
        bean.save();
        view.showToast(R.string.baocunchenggong);
        view.setSaveText(R.string.jixubianji);

    }

    @Override
    public void backup() {

    }

    @Override
    public void clear() {
        if (bean != null && !editMod) {
            bean = null;
            view.clear();
            view.setSaveText(R.string.baocunjilu);
        } else {
            view.setSaveText(R.string.xiugaijilu);
        }
    }

    @Override
    public void init(long id) {
        bean = respository.query(id);
        editMod = true;
        if (bean != null) {
            view.init(bean);
        }
    }


}
