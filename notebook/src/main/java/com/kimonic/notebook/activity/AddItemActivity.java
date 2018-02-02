package com.kimonic.notebook.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.litemapbean.ItemFlagLMBean;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.ui.MTopBarView;
import com.kimonic.utilsmodule.utils.ToastUtils;
import com.lzy.okgo.model.Response;

import org.litepal.crud.DataSupport;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * * ===============================================================
 * name:             AddItemActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/2
 * description：
 * history：
 * *==================================================================
 */

public class AddItemActivity extends BaseActivity {
    @BindView(R.id.mtb_act_additem)
    MTopBarView mtb;
    @BindView(R.id.tv_act_additem_user_name)
    TextView tvUserName;
    @BindView(R.id.et_act_additem)
    EditText et;
    @BindView(R.id.tv_act_additem_add)
    TextView tvAdd;
    private  String  userName;

    @Override
    public int getLayoutResId() {
        return R.layout.act_additem;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_act_additem_add://确认添加
                String item = et.getText().toString().trim();
                if ("".equals(item)) {
                    ToastUtils.showToast(AddItemActivity.this, R.string.qingshurubiaoqianmingcheng);
                }else {
                    List<ItemFlagLMBean>  listItem= DataSupport.where("itemName = ?",item).find(ItemFlagLMBean.class);
                    if (listItem!=null&&listItem.size()>0){
                        ToastUtils.showToast(AddItemActivity.this, R.string.dangqianbiaoqianyicunzai);
                    }else {
                        List<ItemFlagLMBean>  list= DataSupport.where("userName = ?",userName).find(ItemFlagLMBean.class);
                        if (list==null){
                            ItemFlagLMBean bean=new ItemFlagLMBean();
                            bean.setItemFlag("1");
                            bean.setItemName(item);
                            bean.setUserName(userName);
                            bean.save();
                        }else {
                            ItemFlagLMBean bean=new ItemFlagLMBean();
                            bean.setItemFlag(""+(list.size()+1));
                            bean.setItemName(item);
                            bean.setUserName(userName);
                            bean.save();
                        }
                        ToastUtils.showToast(AddItemActivity.this, R.string.baocunchenggong);

                    }
                }
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
        userName=UserConfig.getInstance().getUserName(this);
    }

    @Override
    public void initView() {
        tvUserName.setText(userName);
    }

    @Override
    public void initListener() {
        tvAdd.setOnClickListener(this);
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
