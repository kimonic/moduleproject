package com.kimonic.notebook.activity.fixedassets;

import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.litemapbean.fixedassets.SaveDataLMBean;
import com.kimonic.notebook.mapp.MApp;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.ui.MTopBarView;
import com.kimonic.utilsmodule.utils.StringUtils;
import com.kimonic.utilsmodule.utils.ToastUtils;
import com.lzy.okgo.model.Response;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;

/**
 * * ===============================================================
 * name:             QueryDataDetailsActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/11
 * description：
 * history：
 * *==================================================================
 */

public class QueryDataDetailsActivity extends BaseActivity {
    @BindView(R.id.mtb_act_querydatadetails)
    MTopBarView mtb;
    @BindView(R.id.et_act_querydatadetails_content)
    EditText etContent;
    @BindView(R.id.tv_act_querydatadetails_query)
    TextView tvQuery;
    @BindView(R.id.tv_act_querydatadetails_shengxu)
    TextView tvShengxu;
    @BindView(R.id.tv_act_querydatadetails_jiangxu)
    TextView tvJiangxu;
    @BindView(R.id.lv_act_querydatadetails)
    ListView lv;
    private int type = 1;
    private String userName;
    private List<SaveDataLMBean> listQuery;
    private List<SaveDataLMBean> list;
    private CommonAdapter<SaveDataLMBean> adapter;
    private int order = 1;

    @Override
    public int getLayoutResId() {
        return R.layout.act_querydatadetails;
    }

    @Override
    protected int setStatusBarColor() {
        return getColorRes(R.color.colorQianLan);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_act_querydatadetails_query:
                query();
                break;
            case R.id.tv_act_querydatadetails_shengxu:
                order = 1;
                setBacStyle(tvShengxu, tvJiangxu);
                if (listQuery!=null&&listQuery.size()>0){
                    handleList(order);//集合排序
                    list.clear();
                    list.addAll(listQuery);
                    loadInternetDataToUi();
                }
                break;
            case R.id.tv_act_querydatadetails_jiangxu:
                order = 2;
                setBacStyle(tvJiangxu, tvShengxu);
                if (listQuery!=null&&listQuery.size()>0){
                    handleList(order);//集合排序
                    list.clear();
                    list.addAll(listQuery);
                    loadInternetDataToUi();
                }
                break;
//            case R.id.: break;
//            case R.id.: break;
//            case R.id.: break;
        }
    }

    private void setBacStyle(TextView textView1, TextView textView2) {
        textView1.setBackgroundColor(getColorRes(R.color.colorBac));
        textView1.setTextColor(getColorRes(R.color.colorWhite));

        textView2.setBackgroundColor(getColorRes(R.color.colorWhite));
        textView2.setTextColor(getColorRes(R.color.colorBlack));
    }

    private void query() {
        switch (type) {
            case 1:
                String date = etContent.getText().toString().trim();
                if (checkDateStyle(date)) {
                    listQuery = DataSupport.where("userName = ? and dateFlag = ? "
                            , userName, date).find(SaveDataLMBean.class);
                    if (listQuery.size()>0){
                        handleList(order);//集合排序
                        list.clear();
                        list.addAll(listQuery);
                        loadInternetDataToUi();
                    }else {
                        ToastUtils.showToast(QueryDataDetailsActivity.this, R.string.meiyouchaxunshuju);
                    }

                }
                break;
            case 2:
                String item = etContent.getText().toString().trim();
                if (!"".equals( item)){
                    listQuery = DataSupport.where("userName = ? and item = ? "
                            , userName, item).find(SaveDataLMBean.class);
                    if (listQuery.size()>0){
                        handleList(order);//集合排序
                        list.clear();
                        list.addAll(listQuery);
                        loadInternetDataToUi();
                    }else {
                        ToastUtils.showToast(QueryDataDetailsActivity.this, R.string.meiyouchaxunshuju);
                    }
                }else {
                    ToastUtils.showToast(QueryDataDetailsActivity.this, R.string.qingshuruyaochaxundeleibie);
                }


                break;
            case 3:
                String  temp=etContent.getText().toString().trim();
                String mark = "%"+temp+"%";
                if (!"".equals(temp)){
                    listQuery = DataSupport.where("userName = ? and mark like ? "
                            , userName, mark).find(SaveDataLMBean.class);
                    if (listQuery.size()>0){
                        handleList(order);//集合排序
                        list.clear();
                        list.addAll(listQuery);
                        loadInternetDataToUi();
                    }else {
                        ToastUtils.showToast(QueryDataDetailsActivity.this, R.string.meiyouchaxunshuju);
                    }
                }else {
                    ToastUtils.showToast(QueryDataDetailsActivity.this, R.string.qingshuruyaochaxundebeizhu);
                }

                break;
        }
    }

    @Override
    public void initDataFromIntent() {
        type = getIntent().getIntExtra("type", 1);
        userName = UserConfig.getInstance().getUserName(this);
        list=new ArrayList<>();

    }

    @Override
    public void initView() {
        setTopMargin(mtb, MApp.STATUS_BAE_HEIGHT);
        switch (type) {
            case 1:
                etContent.setHint(R.string.qingshuruyaochaxunderiqi);//日期
                break;
            case 2:
                etContent.setHint(R.string.qingshuruyaochaxundeleibie);//类别
                break;
            case 3:
                etContent.setHint(R.string.qingshuruyaochaxundebeizhu);//备注
                break;
        }
    }

    @Override
    public void initListener() {
        setCloseLisenter(mtb);
        tvQuery.setOnClickListener(this);
        tvShengxu.setOnClickListener(this);
        tvJiangxu.setOnClickListener(this);
    }

    @Override
    public void initDataFromInternet() {

    }

    @Override
    public void loadInternetDataToUi(Response<String> response) {

    }

    private void handleList(int flag) {
        switch (flag) {
            case 1:
                Collections.sort(listQuery, new Comparator<SaveDataLMBean>() {
                    @Override
                    public int compare(SaveDataLMBean o1, SaveDataLMBean o2) {
                        if (StringUtils.string2Integer(o1.getDateFlag().replace("-", ""))
                                > StringUtils.string2Integer(o2.getDateFlag().replace("-", ""))
                                ) {
                            return 1;
                        } else if (StringUtils.string2Integer(o1.getDateFlag().replace("-", ""))
                                == StringUtils.string2Integer(o2.getDateFlag().replace("-", ""))
                                ) {
                            return 0;
                        } else {
                            return -1;
                        }
                    }
                });
                break;
            case 2:
                Collections.sort(listQuery, new Comparator<SaveDataLMBean>() {
                    @Override
                    public int compare(SaveDataLMBean o1, SaveDataLMBean o2) {
                        if (StringUtils.string2Integer(o1.getDateFlag().replace("-", ""))
                                < StringUtils.string2Integer(o2.getDateFlag().replace("-", ""))
                                ) {
                            return 1;
                        } else if (StringUtils.string2Integer(o1.getDateFlag().replace("-", ""))
                                == StringUtils.string2Integer(o2.getDateFlag().replace("-", ""))
                                ) {
                            return 0;
                        } else {
                            return -1;
                        }
                    }
                });
                break;
        }

    }

    @Override
    public void loadInternetDataToUi() {

        if (list != null) {
            if (adapter == null) {
                adapter = getAdapter();
                lv.setAdapter(adapter);
            } else {
                adapter.notifyDataSetChanged();
            }

        }
    }

    /**
     * 检查日期格式是否正确
     */
    private boolean checkDateStyle(String date) {
        String temp[] = date.split("-");
        if (temp.length != 3 || temp[0].length() != 4 || temp[1].length() != 2 ||
                StringUtils.string2Integer(temp[1]) > 12 || temp[2].length() != 2 ||  StringUtils.string2Integer(temp[2]) > 31) {
            ToastUtils.showToast(QueryDataDetailsActivity.this, R.string.qingshuruzhengquederiqigesi);
            return false;
        }
        return true;
    }

    private CommonAdapter<SaveDataLMBean> getAdapter() {
        return new CommonAdapter<SaveDataLMBean>(this, R.layout.lv_savedatabean_notebook, list) {
            @Override
            protected void convert(ViewHolder viewHolder, SaveDataLMBean item, int position) {
                viewHolder.setText(R.id.tv_lv_savedatabean_shuzhi, String.valueOf(item.getValue()));
                viewHolder.setText(R.id.tv_lv_savedatabean_record, item.getDateFlag());
                viewHolder.setText(R.id.tv_lv_savedatabean_label, item.getItem());
                viewHolder.setText(R.id.tv_lv_savedatabean_mark, item.getMark());
                viewHolder.setText(R.id.tv_lv_savedatabean_modifytimes, String.valueOf(item.getFrequencyOfModification()));
                viewHolder.setText(R.id.tv_lv_savedatabean_lastmodify, item.getLastModify());
            }
        };
    }
}
