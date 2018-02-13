package com.kimonic.notebook.activity.investment;

import android.view.View;
import android.widget.ListView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.litemapbean.invest.InvestmentRecordDetailsLMBean;
import com.kimonic.notebook.mapp.MApp;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.ui.MTopBarView;
import com.kimonic.utilsmodule.utils.StringUtils;
import com.lzy.okgo.model.Response;

import org.litepal.crud.DataSupport;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;

/**
 * * ===============================================================
 * name:             SeeInvestRecordActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/12
 * description：   查看投资记录详情activity
 * history：
 * *==================================================================
 */

public class SeeInvestRecordDetailsActivity extends BaseActivity {
    @BindView(R.id.mtb_act_seeinvestrecorddetails)
    MTopBarView mtb;
    @BindView(R.id.lv_act_seeinvestrecorddetails)
    ListView lv;

    private String type;
    private String condition;
    private String userName;

    private List<InvestmentRecordDetailsLMBean> list;


    @Override
    public int getLayoutResId() {
        return R.layout.act_seeinvestrecorddetails;
    }

    @Override
    protected int setStatusBarColor() {
        return getColorRes(R.color.colorQianLan);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initDataFromIntent() {
        type = getIntent().getStringExtra("type");
        condition = getIntent().getStringExtra("condition");
        userName = UserConfig.getInstance().getUserName(this);
        initList();


    }

    private void initList() {
        switch (StringUtils.string2Integer(type)) {
            case 1:
                list= DataSupport.where("userName = ? and investDate = ?",userName
                ,condition).find(InvestmentRecordDetailsLMBean.class);
                break;
            case 2:

                list= DataSupport.where("userName = ? and repayDate = ?",userName
                        ,condition).find(InvestmentRecordDetailsLMBean.class);
                break;
            case 3:
                list= DataSupport.where("userName = ? and investPlateform = ?",userName
                        ,condition).find(InvestmentRecordDetailsLMBean.class);
                break;
        }
    }

    private void sortList(List<String> list) {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (StringUtils.string2Integer(o1.replace("-", ""))
                        < StringUtils.string2Integer(o2.replace("-", ""))) {
                    return 1;
                } else if (StringUtils.string2Integer(o1.replace("-", ""))
                        > StringUtils.string2Integer(o2.replace("-", ""))) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
    }

    @Override
    public void initView() {

        setTopMargin(mtb, MApp.STATUS_BAE_HEIGHT);


    }

    @Override
    public void initListener() {
        setCloseLisenter(mtb);

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
