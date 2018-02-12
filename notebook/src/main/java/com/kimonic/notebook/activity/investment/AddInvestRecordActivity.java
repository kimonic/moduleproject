package com.kimonic.notebook.activity.investment;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.litemapbean.invest.InvestPlateformLMBean;
import com.kimonic.notebook.mapp.MApp;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.ui.MTopBarView;
import com.lzy.okgo.model.Response;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import org.litepal.crud.DataSupport;

import java.util.List;

import butterknife.BindView;

/**
 * * ===============================================================
 * name:             AddInvestRecordActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/12
 * description：添加投资记录activity
 * history：
 * *==================================================================
 */

public class AddInvestRecordActivity extends BaseActivity {
    @BindView(R.id.mtb_act_addinvestrecord)
    MTopBarView mtb;
    @BindView(R.id.tv_act_addinvestrecord_addnew)
    TextView tvAddnew;
    @BindView(R.id.lv_act_addinvestrecord)
    ListView lv;
    private String userName;
    private List<InvestPlateformLMBean> list;

    @Override
    public int getLayoutResId() {
        return R.layout.act_addinvestrecord;
    }

    @Override
    protected int setStatusBarColor() {
        return getColorRes(R.color.colorQianLan);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_act_addinvestrecord_addnew:
                openActivity(AddInvestRecordDetailsActivity.class);
                break;
//                 case R.id.:break;
//                 case R.id.:break;
//                 case R.id.:break;
//                 case R.id.:break;
//                 case R.id.:break;
        }

    }

    @Override
    public void initDataFromIntent() {
        userName = UserConfig.getInstance().getUserName(this);
        list = DataSupport.where("userName = ?", userName).find(InvestPlateformLMBean.class);

    }

    @Override
    public void initView() {
        setTopMargin(mtb, MApp.STATUS_BAE_HEIGHT);
        lv.setAdapter(getAdapter());
        
        Log.e("AddInvestRecordActivity", "initView: -list----"+list.size());


    }

    @Override
    public void initListener() {
        setCloseLisenter(mtb);
        tvAddnew.setOnClickListener(this);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openActivityParams(AddInvestRecordDetailsActivity.class,"plateform",list.get(position).getInvestPlateform());

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

    private CommonAdapter<InvestPlateformLMBean> getAdapter() {
        return new CommonAdapter<InvestPlateformLMBean>(this, R.layout.lv_itemflagbean_notebook, list) {
            @Override
            protected void convert(ViewHolder viewHolder, InvestPlateformLMBean item, int position) {
                viewHolder.setText(R.id.tv_lv_itemflagbean, "        " + item.getInvestPlateform());
            }
        };
    }
}
