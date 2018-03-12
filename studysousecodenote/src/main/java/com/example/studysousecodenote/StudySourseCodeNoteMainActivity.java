package com.example.studysousecodenote;

import android.view.View;
import android.widget.TextView;

import com.example.studysousecodenote.activity.ScrollViewActivity;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.lzy.okgo.model.Response;

import butterknife.BindView;

public class StudySourseCodeNoteMainActivity extends BaseActivity {


    @BindView(R.id.tv_act_study_main_scrollview)
    TextView tvScrollview;

    @Override
    public int getLayoutResId() {
        return R.layout.act_study_sourse_code_note_main;
    }

    @Override
    protected int setStatusBarColor() {
        return 0;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_act_study_main_scrollview:
                openActivity(ScrollViewActivity.class);
                break;
//         case R.id.:break;
//         case R.id.:break;
//         case R.id.:break;
//         case R.id.:break;
//         case R.id.:break;
        }
    }

    @Override
    public void initDataFromIntent() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        tvScrollview.setOnClickListener(this);
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


}
