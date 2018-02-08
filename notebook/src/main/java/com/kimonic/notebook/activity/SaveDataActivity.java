package com.kimonic.notebook.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.litemapbean.ItemFlagLMBean;
import com.kimonic.utilsmodule.base.BaseActivity;
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
 * description：  添加数据
 * history：
 * *==================================================================
 */

public class SaveDataActivity extends BaseActivity {

    @BindView(R.id.tv_act_savedata_current_user)
    TextView tvCurrentUser;
    @BindView(R.id.lv_act_savedata)
    ListView lv;
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
        return 0;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initDataFromIntent() {
        userName = getIntent().getStringExtra("username");
    }

    @Override
    public void initView() {
        tvCurrentUser.setText(userName);

    }

    @Override
    public void initListener() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openActivityParams(SaveDataDetailsActivity.class,"label",listItem.get(position).getItemName(),
                "itemFlag",listItem.get(position).getItemFlag());
            }
        });

    }

    @Override
    public void initDataFromInternet() {
       listItem= DataSupport.where("userName = ?",userName).find(ItemFlagLMBean.class);
        loadInternetDataToUi();

    }

    @Override
    public void loadInternetDataToUi(Response<String> response) {



    }

    @Override
    public void loadInternetDataToUi() {
        lv.setAdapter(getAdapter());
    }

    private CommonAdapter<ItemFlagLMBean>  getAdapter(){
        return new CommonAdapter<ItemFlagLMBean>(this,R.layout.lv_itemflagbean_notebook,listItem) {
            @Override
            protected void convert(ViewHolder viewHolder, ItemFlagLMBean item, int position) {
                viewHolder.setText(R.id.tv_lv_itemflagbean,item.getItemName());
            }
        };
    }


}
