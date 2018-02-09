package com.kimonic.notebook.fragment;

import android.view.View;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.activity.AddItemActivity;
import com.kimonic.notebook.activity.AddNewUserActivity;
import com.kimonic.notebook.activity.CompareDataActivity;
import com.kimonic.notebook.activity.fixedassets.FindDataActivity;
import com.kimonic.notebook.activity.fixedassets.SaveDataActivity;
import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.litemapbean.SaveDataLMBean;
import com.kimonic.utilsmodule.base.BaseFragment;
import com.kimonic.utilsmodule.utils.FileUtils;
import com.kimonic.utilsmodule.utils.TimeUtils;
import com.lzy.okgo.model.Response;

import org.litepal.crud.DataSupport;

import java.util.List;

import butterknife.BindView;

/**
 * * ===============================================================
 * name:             HomeFragment
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/7
 * description：
 * history：
 * *==================================================================
 */

public class HomeFragment extends BaseFragment {


    @BindView(R.id.tv_act_home_current_user)
    TextView tvCurrentUser;
    @BindView(R.id.tv_act_home_add_new_user)
    TextView tvAddNewUser;
    @BindView(R.id.tv_act_home_sel_user)
    TextView tvSelUser;
    @BindView(R.id.tv_act_home_query_data)
    TextView tvQueryData;
    @BindView(R.id.tv_act_home_compare_data)
    TextView tvCompareData;
    @BindView(R.id.tv_act_home_update_data)
    TextView tvUpdateData;
    @BindView(R.id.tv_act_home_save_data)
    TextView tvSaveData;
    @BindView(R.id.tv_act_home_del_data)
    TextView tvDelData;
    @BindView(R.id.tv_act_home_add_item)
    TextView tvAddItem;
    @BindView(R.id.tv_act_home_disk_save)
    TextView tvDiskSave;
    private String userName;

    @Override
    public int layoutRes() {
        return R.layout.frag_home_notebook;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_act_home_add_new_user://添加新用户
                openActivity(AddNewUserActivity.class);
                break;
            case R.id.tv_act_home_sel_user://选择用户
                break;
            case R.id.tv_act_home_query_data://查询数据
                openActivity(FindDataActivity.class);
                break;
            case R.id.tv_act_home_compare_data://比较数据
                openActivity(CompareDataActivity.class);
                break;
            case R.id.tv_act_home_update_data://更新数据
                break;
            case R.id.tv_act_home_save_data://保存数据
                openActivityParams(SaveDataActivity.class, "username", userName);
                break;
            case R.id.tv_act_home_del_data://删除数据
                break;
            case R.id.tv_act_home_add_item://添加标签
                openActivityParams(AddItemActivity.class, "username", userName);

                break;
            case R.id.tv_act_home_disk_save://导出数据
                List<SaveDataLMBean> listDate = DataSupport.where("userName = ?"
                        , userName).find(SaveDataLMBean.class);
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < listDate.size(); i++) {
                    builder.append(listDate.get(i).toString());
                }

                FileUtils.saveJsonToSDCard(getActivity(), "mynotebookdata", TimeUtils.getStringDateShort() + userName + ".txt", builder.toString());
                break;
//            case R.id.: break;
//            case R.id.: break;
        }
    }

    @Override
    public void initDataFromIntent() {
        userName = UserConfig.getInstance().getUserName(getActivity());
        if ("".equals(userName)) {
            userName = "亦筝笙";
            UserConfig.getInstance().setUserName(getActivity(), "亦筝笙");
        }
    }

    @Override
    public void initView() {
        tvCurrentUser.setText((getString(R.string.dangqiandengluyognhuming) + ":" + userName));

    }

    @Override
    public void initListener() {
        tvAddNewUser.setOnClickListener(this);
        tvSelUser.setOnClickListener(this);
        tvCompareData.setOnClickListener(this);

        tvDelData.setOnClickListener(this);
        tvQueryData.setOnClickListener(this);
        tvSaveData.setOnClickListener(this);
        tvUpdateData.setOnClickListener(this);
        tvAddItem.setOnClickListener(this);
        tvDiskSave.setOnClickListener(this);
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
