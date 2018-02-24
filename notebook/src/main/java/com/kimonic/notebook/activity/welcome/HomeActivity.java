package com.kimonic.notebook.activity.welcome;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;

import com.kimonic.notebook.R;
import com.kimonic.notebook.fragment.AccountingFragment;
import com.kimonic.notebook.fragment.HomeFragment;
import com.kimonic.notebook.mapp.MApp;
import com.kimonic.notebook.ui.BubbleView;
import com.kimonic.utilsmodule.adapter.FragmentVPAdapter;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.ui.NaviButtonView;
import com.kimonic.utilsmodule.ui.NoScrollViewPager;
import com.lzy.okgo.model.Response;

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


        BubbleView view=new BubbleView(this);
        ((FrameLayout)(getWindow().getDecorView())).addView(view);
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
//----------------------------可能会对页面跳转产生影响-------------------------------------
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
        //----------------------------可能会对页面跳转产生影响-------------------------------------

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

    @Override
    protected int setStatusBarColor() {
        return getColorRes(R.color.colorQianLan);
    }
}
