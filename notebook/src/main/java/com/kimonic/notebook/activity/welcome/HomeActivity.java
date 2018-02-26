package com.kimonic.notebook.activity.welcome;

import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.fragment.AccountingFragment;
import com.kimonic.notebook.fragment.HomeFragment;
import com.kimonic.notebook.mapp.MApp;
import com.kimonic.notebook.ui.BubbleView;
import com.kimonic.utilsmodule.adapter.FragmentVPAdapter;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.ui.NaviButtonView;
import com.kimonic.utilsmodule.ui.NoScrollViewPager;
import com.kimonic.utilsmodule.utils.AppKidUtils;
import com.kimonic.utilsmodule.utils.DialogUtils;
import com.kimonic.utilsmodule.utils.HttpUtils;
import com.kimonic.utilsmodule.utils.StringUtils;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeActivity extends BaseActivity {


    @BindView(R.id.vp_act_home)
    NoScrollViewPager vpActHome;
    @BindView(R.id.nbv_act_home)
    NaviButtonView nbvActHome;

    private List<Fragment> list;
    private int beforePosition = 0;
    private TextView tvProgress;
    private AlertDialog dialog;

    public ViewPager getVpActHome() {
        return vpActHome;
    }


    @Override
    public int getLayoutResId() {
        return R.layout.act_home_notebook;
    }

    @Override
    public void onClick(View v) {


    }

    @Override
    public void initDataFromIntent() {

    }

    @Override
    public void initView() {
        setTopMargin(vpActHome, MApp.STATUS_BAE_HEIGHT);
        initFragmentList();
        FragmentVPAdapter adapter = new FragmentVPAdapter(getSupportFragmentManager(), list);
        vpActHome.setAdapter(adapter);
        nbvActHome.setViewPager(vpActHome);
        vpActHome.setOffscreenPageLimit(4);


        BubbleView view = new BubbleView(this);
        ((FrameLayout) (getWindow().getDecorView())).addView(view);
    }

    private void initFragmentList() {
        list = new ArrayList<>();


        AccountingFragment fragment1 = new AccountingFragment();
        list.add(fragment1);


        HomeFragment fragment2 = new HomeFragment();
        list.add(fragment2);

        HomeFragment fragment3 = new HomeFragment();
        list.add(fragment3);

        HomeFragment fragment4 = new HomeFragment();
        list.add(fragment4);

    }

    @Override
    public void initListener() {
        nbvActHome.setListener(new NaviButtonView.CurrentPositionListener() {
            @Override
            public boolean currentPosition(int position) {

                return true;

            }
        });

        vpActHome.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {


            }
        });
    }

    @Override
    public void initDataFromInternet() {



        String url="http://app.mi.com/download/26";
        final String dir=Environment.getExternalStorageDirectory().getAbsolutePath()+"/apkdownload";
        final String fileName="mydownload.apk";
        String filePath=dir+"/"+fileName;
        File file=new File(filePath);
        if (file.exists()){
            AppKidUtils.installApk(HomeActivity.this, filePath);
        }else {
            Log.e("HttpUtils", "downloadProgress: -下载----"+url);
            Log.e("HttpUtils", "downloadProgress: -下载----"+dir);
            dialog=DialogUtils.showDownloadDialog(HomeActivity.this, new DialogUtils.ProgressCallback() {
                @Override
                public void getProgressView(TextView textView) {
                    tvProgress=textView;
                }
            });

            HttpUtils.getInstance().downloadFile(url, new FileCallback(dir,fileName) {
                @Override
                public void onSuccess(Response<File> response) {
                    AppKidUtils.installApk(HomeActivity.this, dir +"/"+ fileName);
                }

                @Override
                public void downloadProgress(final Progress progress) {
                    Log.e("HttpUtils", "downloadProgress: -下载进度----" + progress.fraction);

                    if (tvProgress!=null)
                        tvProgress.setText(StringUtils.getTwoDecimalsStr(""+progress.fraction*100));
                    super.downloadProgress(progress);
                }

                @Override
                public void onError(Response<File> response) {
                    super.onError(response);
                    Log.e("HttpUtils", "downloadProgress: -未知错误----" + response.toString());

                }
            });

        }



    }

    @Override
    public void loadInternetDataToUi(Response<String> response) {

    }

    @Override
    public void loadInternetDataToUi() {

    }

    @Override
    protected int setStatusBarColor() {
        return getColorRes(R.color.colorQianLan);
    }
}
