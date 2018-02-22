package com.kimonic.notebook.activity.investment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.litemapbean.invest.InvestmentRecordDetailsLMBean;
import com.kimonic.notebook.mapp.MApp;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.ui.MTopBarView;
import com.kimonic.utilsmodule.utils.StringUtils;
import com.lzy.okgo.model.Response;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

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
 * description：   查看投资记录筛选列表activity
 * history：
 * *==================================================================
 */

public class SeeInvestRecordListActivity extends BaseActivity {
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
        return R.layout.act_seeinvestrecordlist;
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
                list = DataSupport.where("userName = ? and investDate = ?", userName
                        , condition).find(InvestmentRecordDetailsLMBean.class);
                break;
            case 2:

                list = DataSupport.where("userName = ? and repayDate = ?", userName
                        , condition).find(InvestmentRecordDetailsLMBean.class);
                break;
            case 3:
                list = DataSupport.where("userName = ? and investPlateform = ?", userName
                        , condition).find(InvestmentRecordDetailsLMBean.class);
                break;
        }
    }

    private void sortList(List<InvestmentRecordDetailsLMBean> list) {
        Collections.sort(list, new Comparator<InvestmentRecordDetailsLMBean>() {
            @Override
            public int compare(InvestmentRecordDetailsLMBean o1, InvestmentRecordDetailsLMBean o2) {
                if (StringUtils.string2Integer(o1.getInvestDate().replace("-", ""))
                        < StringUtils.string2Integer(o2.getInvestDate().replace("-", ""))) {
                    return 1;
                } else if (StringUtils.string2Integer(o1.getInvestDate().replace("-", ""))
                        > StringUtils.string2Integer(o2.getInvestDate().replace("-", ""))) {
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
        sortList(list);
        lv.setAdapter(getAdapter());

        loadInternetDataToUi();
    }

    @Override
    public void initListener() {
        setCloseLisenter(mtb);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openActivityParams(SeeInvestRecordDetailsActivity.class,"id",""+list.get(position).getId());
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


    private CommonAdapter<InvestmentRecordDetailsLMBean> getAdapter() {
        return new CommonAdapter<InvestmentRecordDetailsLMBean>(this, R.layout.lv_seeinvestrecorddetails, list) {
            @Override
            protected void convert(ViewHolder viewHolder, InvestmentRecordDetailsLMBean item, int position) {
                viewHolder.setText(R.id.tv_lv_seeinvestrecorddetails_invest_plateform, item.getInvestPlateform());
                viewHolder.setText(R.id.tv_lv_seeinvestrecorddetails_invest_amount, ""+item.getInvestAmount());
                viewHolder.setText(R.id.tv_lv_seeinvestrecorddetails_investdate, item.getInvestDate());
                viewHolder.setText(R.id.tv_lv_seeinvestrecorddetails_repaydate, item.getRepayDate());
                viewHolder.setText(R.id.tv_lv_seeinvestrecorddetails_invest_mark, item.getMark());
            }
        };
    }


}
