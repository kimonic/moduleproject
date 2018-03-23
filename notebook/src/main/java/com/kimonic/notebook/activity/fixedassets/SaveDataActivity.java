package com.kimonic.notebook.activity.fixedassets;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.litemapbean.fixedassets.ItemFlagLMBean;
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
 * name:             SaveDataActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/2
 * description：  资产记录
 * history：
 * *==================================================================
 */

public class SaveDataActivity extends BaseActivity {


    @BindView(R.id.lv_act_savedata)
    ListView lv;
    @BindView(R.id.tv_act_savedata_addnew)
    TextView tv;
    @BindView(R.id.mtb_act_savedata)
    MTopBarView mtb;
    /**
     * 添加到的用户名
     */
    private String userName;
    private List<ItemFlagLMBean> listItem;

    @Override
    public int getLayoutResId() {
        return R.layout.act_savedata_notebook;
    }

    @Override
    protected int setStatusBarColor() {
        return getColorRes(R.color.colorQianLan);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_act_savedata_addnew:
                openActivity(SaveDataDetailsActivity.class);
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
    }

    @Override
    public void initView() {
        setTopMargin(mtb, MApp.STATUS_BAE_HEIGHT);

    }

    @Override
    public void initListener() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openActivityParams(SaveDataDetailsActivity.class, "label", listItem.get(position).getItemName(),
                        "itemFlag", ""+listItem.get(position).getItemFlag());
            }
        });
        tv.setOnClickListener(this);
        setCloseLisenter(mtb);
    }

    @Override
    public void initDataFromInternet() {
        listItem = DataSupport.where("userName = ?", userName).find(ItemFlagLMBean.class);
        loadInternetDataToUi();

    }

    @Override
    public void loadInternetDataToUi(Response<String> response) {


    }

    @Override
    public void loadInternetDataToUi() {
        lv.setAdapter(getAdapter());
    }

    private CommonAdapter<ItemFlagLMBean> getAdapter() {
        return new CommonAdapter<ItemFlagLMBean>(this, R.layout.lv_itemflagbean_notebook, listItem) {
            @Override
            protected void convert(ViewHolder viewHolder, ItemFlagLMBean item, int position) {
                viewHolder.setText(R.id.tv_lv_itemflagbean, "        " + item.getItemName());
            }
        };
    }


}
