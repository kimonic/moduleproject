package com.kimonic.notebook.activity;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.litemapbean.SaveDataLMBean;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.lzy.okgo.model.Response;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import org.litepal.crud.DataSupport;

import java.util.List;

import butterknife.BindView;

/**
 * * ===============================================================
 * name:             FindDataDetailsActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/6
 * description：   某一天的记录详情
 * history：
 * *==================================================================
 */

public class FindDataDetailsActivity extends BaseActivity {
    @BindView(R.id.tv_act_finddatadetails_current_user)
    TextView tvCurrentUser;
    @BindView(R.id.tv_act_finddatadetails_total)
    TextView tvTotal;
    @BindView(R.id.lv_act_finddatadetails)
    ListView lv;
    private  String  userName;
    private String date;
    private List<SaveDataLMBean> listDate;

    @Override
    public int getLayoutResId() {
        return R.layout.act_finddatadetails_notebook;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initDataFromIntent() {
        userName= UserConfig.getInstance().getUserName(this);
        date=getIntent().getStringExtra("date");
    }

    @Override
    public void initView() {
        tvCurrentUser.setText(userName);

       listDate= DataSupport.where("userName = ? and dateFlag = ? "
                ,userName,date).find(SaveDataLMBean.class);

       float  total=0;

        for (int i = 0; i < listDate.size(); i++) {
            total+=listDate.get(i).getValue();
        }

       tvTotal.setText(String.valueOf(total));
       lv.setAdapter(getAdapter());


    }

    @Override
    public void initListener() {

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

    private CommonAdapter<SaveDataLMBean> getAdapter(){
        return new CommonAdapter<SaveDataLMBean>(this,R.layout.lv_savedatabean_notebook,listDate) {
            @Override
            protected void convert(ViewHolder viewHolder, SaveDataLMBean item, int position) {
                viewHolder.setText(R.id.tv_lv_savedatabean_shuzhi,String.valueOf(item.getValue()));
                viewHolder.setText(R.id.tv_lv_savedatabean_record,item.getDateFlag());
                viewHolder.setText(R.id.tv_lv_savedatabean_label,item.getItem());
            }
        };
    }
}
