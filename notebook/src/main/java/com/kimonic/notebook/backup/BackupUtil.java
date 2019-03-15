package com.kimonic.notebook.backup;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.litemapbean.fixedassets.DateRecordLMBean;
import com.kimonic.notebook.litemapbean.fixedassets.SaveDataLMBean;
import com.kimonic.notebook.litemapbean.memorandum.MemorandumLMBean;
import com.kimonic.notebook.mvp.memorandum.MemorandumRespository;
import com.kimonic.utilsmodule.utils.FileUtils;
import com.kimonic.utilsmodule.utils.TimeUtils;

import org.litepal.crud.DataSupport;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * * ================================================
 * name:            BackupUtil
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：            2019/3/14
 * description：
 * history：
 * ===================================================
 */
public class BackupUtil {
    /**
     * 备份备忘录信息
     */
    public static void saveBeiWangLu(Context context) {
        MemorandumRespository memorandumRespository = new MemorandumRespository<MemorandumLMBean>();
        @SuppressWarnings("unchecked") List<MemorandumLMBean> list = memorandumRespository.loadData(UserConfig.getInstance().getUserName(context));
        Gson gson = new Gson();
        String beiwanglu = gson.toJson(new BeiWangLuBeiFen(list));
        String time = TimeUtils.getCurrentYearMonth2();
        File file = new File(FileUtils.getSavePath(context, "1xiaomaomi"), "beiwanglu" + time + ".txt");
        if (file.exists()) {
            FileUtils.saveJsonToSDCard(context, "1xiaomaomi", "beiwanglu" + time + "01" + ".txt", beiwanglu);
        } else {
            FileUtils.saveJsonToSDCard(context, "1xiaomaomi", "beiwanglu" + time + ".txt", beiwanglu);
        }
    }

    @SuppressWarnings("unchecked")
    public static void savaZiChan(Context context) {
        String userName = UserConfig.getInstance().getUserName(context);
        List listDate = DataSupport.where("userName = ? ", userName).find(DateRecordLMBean.class);
        List<List<SaveDataLMBean>> collections = new ArrayList<>();
        List listDate1 = DataSupport.where("userName = ? ", userName).find(SaveDataLMBean.class);
        collections.add(listDate1);

        FixedZiChanBeiFen fixedZiChanBeiFen = new FixedZiChanBeiFen(listDate, collections);
        Gson gson = new Gson();
        String zichan = gson.toJson(fixedZiChanBeiFen);
        Log.e("RunTest", "-------资产------???" + zichan);
        String time = TimeUtils.getCurrentYearMonth2();
        File file = new File(FileUtils.getSavePath(context, "1xiaomaomi"), "zichan" + time + ".txt");
        if (file.exists()) {
            FileUtils.saveJsonToSDCard(context, "1xiaomaomi", "zichan" + time + "01" + ".txt", zichan);
        } else {
            FileUtils.saveJsonToSDCard(context, "1xiaomaomi", "zichan" + time + ".txt", zichan);
        }

    }
}
