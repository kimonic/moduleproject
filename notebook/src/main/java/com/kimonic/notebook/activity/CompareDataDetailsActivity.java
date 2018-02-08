package com.kimonic.notebook.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.bean.CompareBean;
import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.litemapbean.SaveDataLMBean;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.utils.TimeUtils;
import com.lzy.okgo.model.Response;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * * ===============================================================
 * name:             CompareDataDetailsActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/6
 * description：比较不同日期的记录数据详情
 * history：
 * *==================================================================
 */

public class CompareDataDetailsActivity extends BaseActivity {
    @BindView(R.id.tv_act_comeparedatadetails_current_user)
    TextView tvCurrentUser;
    @BindView(R.id.lv_act_comparedatadetails)
    ListView lvAct;
    @BindView(R.id.tv_act_comeparedatadetails_shuzhizongji1)
    TextView tvShuzhizongji1;
    @BindView(R.id.tv_act_comeparedatadetails_shuzhizongji2)
    TextView tvShuzhizongji2;
    @BindView(R.id.tv_act_comeparedatadetails_shuzhizongji3)
    TextView tvShuzhizongji3;
    @BindView(R.id.tv_act_comeparedatadetails_shuzhizongji4)
    TextView tvShuzhizongji4;
    @BindView(R.id.tv_act_comeparedatadetails_shuzhizongji5)
    TextView tvShuzhizongji5;
    @BindView(R.id.tv_act_comeparedatadetails_shuzhizongji6)
    TextView tvShuzhizongji6;

    private String date1;
    private String date2;
    private String userName;
    private List<SaveDataLMBean> list1;
    private List<SaveDataLMBean> list2;
    private List<CompareBean> list;

    @Override
    public int getLayoutResId() {
        return R.layout.act_comparedatadetails_notebook;
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
        userName = UserConfig.getInstance().getUserName(this);
        date1 = getIntent().getStringExtra("date1");
        date2 = getIntent().getStringExtra("date2");

        list = new ArrayList<>();

    }

    @Override
    public void initView() {

        tvShuzhizongji1.setText((date1+"总计:    "));
        tvShuzhizongji3.setText((date2+"总计:    "));

        float total1=0;
        float total2=0;
        float total3=0;

        list1 = DataSupport.where("userName = ? and dateFlag = ? "
                , userName, date1).find(SaveDataLMBean.class);
        list2 = DataSupport.where("userName = ? and dateFlag = ? "
                , userName, date2).find(SaveDataLMBean.class);


        for (int i = 0; i < list1.size(); i++) {
            total1+=list1.get(i).getValue();
        }

        for (int i = 0; i < list2.size(); i++) {
            total2+=list2.get(i).getValue();
        }

        total3=total2-total1;

        tvShuzhizongji2.setText(String.valueOf(total1));
        tvShuzhizongji4.setText(String.valueOf(total2));
        tvShuzhizongji6.setText(String.valueOf(total3));




        if (list1.size() > list2.size()) {
            createNewData(list1, list2, date1);
        } else {
            createNewData(list2, list1, date1);
        }

        lvAct.setAdapter(getAdapter());

    }

    private void createNewData(List<SaveDataLMBean> list1, List<SaveDataLMBean> list2, String date1) {
        boolean flag;
        flag = list1.get(0).getDateFlag().equals(date1);
        for (int i = 0; i < list1.size(); i++) {
            CompareBean bean = new CompareBean();
            bean.setItem(list1.get(i).getItem());
            bean.setItemFlag(list1.get(i).getItemFlag());
            bean.setUserName(list1.get(i).getUserName());
            if (flag) {
                bean.setDateFlag1(list1.get(i).getDateFlag());
                bean.setValue1(list1.get(i).getValue());
            } else {
                bean.setDateFlag2(list1.get(i).getDateFlag());
                bean.setValue2(list1.get(i).getValue());
            }

            for (int j = 0; j < list2.size(); j++) {

                if (flag && list1.get(i).getItemFlag().equals(list2.get(j).getItemFlag())) {
                    bean.setDateFlag2(list2.get(j).getDateFlag());
                    bean.setValue2(list2.get(j).getValue());
                } else if (list1.get(i).getItemFlag().equals(list2.get(j).getItemFlag())) {
                    bean.setDateFlag1(list2.get(j).getDateFlag());
                    bean.setValue1(list2.get(j).getValue());
                }
            }

            list.add(bean);

        }
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


    private CommonAdapter<CompareBean> getAdapter() {
        return new CommonAdapter<CompareBean>(this, R.layout.lv_comparebean_notebook, list) {
            @Override
            protected void convert(ViewHolder viewHolder, CompareBean item, int position) {
                viewHolder.setText(R.id.tv_lv_comparebean_label, item.getItem());
                viewHolder.setText(R.id.tv_lv_comparebean_shuzhi1, String.valueOf(item.getValue1()));
                viewHolder.setText(R.id.tv_lv_comparebean_shuzhi2, String.valueOf(item.getValue2()));
                viewHolder.setText(R.id.tv_lv_comparebean_shuzhi3, String.valueOf(item.getValue2() - item.getValue1()));

                viewHolder.setText(R.id.tv_lv_comparebean_record1, item.getDateFlag1());
                viewHolder.setText(R.id.tv_lv_comparebean_record2, item.getDateFlag2());

                viewHolder.setText(R.id.tv_lv_comparebean_record3, TimeUtils.getNowDateShort());

            }
        };
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
