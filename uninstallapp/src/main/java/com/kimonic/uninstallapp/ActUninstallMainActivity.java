package com.kimonic.uninstallapp;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.utils.ImageGlideUtils;
import com.lzy.okgo.model.Response;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActUninstallMainActivity extends BaseActivity {


    @BindView(R.id.lv_act_uninstall_main)
    ListView lv;
    @BindView(R.id.iv_act_uninstall)
    ImageView iv;
    private List<PackageInfo> packages;

    @Override
    public int getLayoutResId() {
        return R.layout.act_uninstall_main;
    }

    @Override
    protected int setStatusBarColor() {
        return 0;
    }

    //卸载应用程序
    public void unstallApp(String packageName) {
        Intent uninstall_intent = new Intent();
        uninstall_intent.setAction(Intent.ACTION_DELETE);
        uninstall_intent.setData(Uri.parse("package:" + packageName));
        startActivity(uninstall_intent);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initDataFromIntent() {
        ImageGlideUtils.loadCircularImage(iv,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1525687212951&di=e40bc402436481d4eb0019b00435f146&imgtype=0&src=http%3A%2F%2F2t.5068.com%2Fuploads%2Fallimg%2F151024%2F48-151024111511-50.jpg");



        packages = getPackageManager().getInstalledPackages(0);
        for (int i = 0; i < packages.size(); i++) {
            PackageInfo packageInfo = packages.get(i);
            Log.e("packageInfo", "initDataFromIntent: -----" + packageInfo.applicationInfo.loadLabel(getPackageManager()).toString());
            Log.e("packageInfo", "initDataFromIntent: -----" + packageInfo.packageName);
        }
        lv.setAdapter(getAdapter());
    }

    @Override
    public void initView() {

        BufferedReader reader = null;
        String content = "";
        try {
            //("ps -P|grep bg")执行失败，PC端adb shell ps -P|grep bg执行成功
            //Process process = Runtime.getRuntime().exec("ps -P|grep tv");
            //-P 显示程序调度状态，通常是bg或fg，获取失败返回un和er
            // Process process = Runtime.getRuntime().exec("ps -P");adb uninstall com.android.flysilkworm
            //打印进程信息，不过滤任何条件com.android.flysilkworm
            Process process = Runtime.getRuntime().exec("ps");
//            Process process = Runtime.getRuntime().exec("adb  uninstall com.android.flysilkworm ");
            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuffer output = new StringBuffer();
            int read;
            char[] buffer = new char[4096];
            while ((read = reader.read(buffer)) > 0) {
                output.append(buffer, 0, read);
            }
            reader.close();
            content = output.toString();
            Log.e("ActnActivity", "initView: -----" + content);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    @Override
    public void initListener() {

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                unstallApp(packages.get(position).packageName);
            }
        });
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

    private CommonAdapter<PackageInfo> getAdapter() {
        return new CommonAdapter<PackageInfo>(this, R.layout.lv_uninstall, packages) {
            @Override
            protected void convert(ViewHolder viewHolder, PackageInfo item, int position) {
                viewHolder.setText(R.id.tv_appname, item.applicationInfo.loadLabel(getPackageManager()).toString());
                viewHolder.setText(R.id.tv_packagename, item.packageName);
            }
        };
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
