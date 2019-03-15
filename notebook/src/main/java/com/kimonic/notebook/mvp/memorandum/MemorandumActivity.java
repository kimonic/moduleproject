package com.kimonic.notebook.mvp.memorandum;

import android.app.Instrumentation;
import android.content.Context;
import android.os.PowerManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.backup.BackupUtil;
import com.kimonic.notebook.mapp.MApp;
import com.kimonic.notebook.mvp.memorandum.add.MemorandumAddActivity;
import com.kimonic.notebook.mvp.memorandum.query.MemorandumQueryActivity;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.ui.MTopBarView;
import com.kimonic.utilsmodule.utils.FileUtils;
import com.kimonic.utilsmodule.utils.ToastUtils;
import com.lzy.okgo.model.Response;

import java.lang.reflect.Method;

import butterknife.BindView;

/**
 * * ===============================================================
 * name:             MemorandumActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/26
 * method:
 * <p>
 * <p>
 * description：备忘录activity
 * history：
 * *==================================================================
 */

public class MemorandumActivity extends BaseActivity {
    @BindView(R.id.mtb_act_memorandum)
    MTopBarView mtb;
    @BindView(R.id.tv_act_memorandum_chakanbeiwanglu)
    TextView tvFind;
    @BindView(R.id.tv_act_memorandum_tianjiabeiwanglu)
    TextView tvAdd;
    @BindView(R.id.tv_act_memorandum_beifenbeiwanglu)
    TextView tvBackup;
    @BindView(R.id.tv_act_memorandum_cunchumulu)
    TextView tvPath;

    @Override
    public int getLayoutResId() {
        return R.layout.act_memorandum;
    }

    @Override
    protected int setStatusBarColor() {
        return getColorRes(R.color.colorQianLan);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_act_memorandum_chakanbeiwanglu:
                openActivity(MemorandumQueryActivity.class);
                break;
            case R.id.tv_act_memorandum_tianjiabeiwanglu:
                openActivity(MemorandumAddActivity.class);
                break;
            case R.id.tv_act_memorandum_beifenbeiwanglu:
                BackupUtil.saveBeiWangLu(this);
                break;
            case R.id.tv_act_memorandum_cunchumulu:
//                new Thread() {
//                    @Override
//                    public void run() {
//                        //模拟关机
//                        Instrumentation instrumentation = new Instrumentation();
//                        instrumentation.sendKeyDownUpSync(KeyEvent.KEYCODE_POWER);
//                    }
//                }.start();
//                PowerManager pManager = (PowerManager) getSystemService(Context.POWER_SERVICE); //重启到fastboot模式
//                pManager.reboot("重启");

//                shutDowm();
                ToastUtils.showToastLong(this, FileUtils.getSavePath(this, "1xiaomaomi"));
                break;
//            case R.id.: break;
//            case R.id.: break;
        }
    }

    @Override
    public void initDataFromIntent() {

    }

    @Override
    public void initView() {
        setTopMargin(mtb, MApp.STATUS_BAE_HEIGHT);
    }

    @Override
    public void initListener() {
        setCloseLisenter(mtb);
        tvAdd.setOnClickListener(this);
        tvBackup.setOnClickListener(this);
        tvFind.setOnClickListener(this);
        tvPath.setOnClickListener(this);
    }

    @Override
    public void initDataFromInternet() {

    }

    @Override
    public void loadInternetDataToUi(Response<String> response) {

    }

    @Override
    public void loadInternetDataToUi() {

    }

    /**
     * 关机,不能实现
     */
    private void shutDowm() {
        try {
            //获得ServiceManager类
            Class ServiceManager = Class.forName("android.os.ServiceManager");
            //获得ServiceManager的getService方法
            Method getService = ServiceManager.getMethod("getService", java.lang.String.class);
            //调用getService获取RemoteService
            Object oRemoteService = getService.invoke(null, Context.POWER_SERVICE);
            //获得IPowerManager.Stub类
            Class cStub = Class.forName("android.os.IPowerManager$Stub");
            //获得asInterface方法
            Method asInterface = cStub.getMethod("asInterface", android.os.IBinder.class);
            //调用asInterface方法获取IPowerManager对象
            Object oIPowerManager = asInterface.invoke(null, oRemoteService);
            //获得shutdown()方法
            Method shutdown = oIPowerManager.getClass().getMethod("shutdown", boolean.class, boolean.class);
            //调用shutdown()方法
            shutdown.invoke(oIPowerManager, false, true);
        } catch (Exception e) {
            Log.e("RunTest", "--------异常终止-----???");
        }


    }
}
