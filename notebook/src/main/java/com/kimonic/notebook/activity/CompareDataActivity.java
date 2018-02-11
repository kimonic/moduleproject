package com.kimonic.notebook.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.comparator.DateComparator;
import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.litemapbean.fixedassets.DateRecordLMBean;
import com.kimonic.notebook.mapp.MApp;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.ui.MTopBarView;
import com.kimonic.utilsmodule.utils.ToastUtils;
import com.lzy.okgo.model.Response;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import org.litepal.crud.DataSupport;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;

/**
 * * ===============================================================
 * name:             CompareDataActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/6
 * description：比较不同日期的记录数据
 * history：
 * *==================================================================
 */

public class CompareDataActivity extends BaseActivity {
    @BindView(R.id.et_act_comparedata_first)
    EditText etFirst;
    @BindView(R.id.et_act_comparedata_second)
    EditText etSecond;
    @BindView(R.id.tv_act_comeparedata_compare)
    TextView tvCompare;
    @BindView(R.id.lv_act_comparedata)
    ListView lv;
    @BindView(R.id.mtb_act_comparedata)
    MTopBarView mtb;


    private String userName;
    private List<DateRecordLMBean> listDate;

    @Override
    public int getLayoutResId() {
        return R.layout.act_comparedata_notebook;
    }

    @Override
    protected int setStatusBarColor() {
        return getColorRes(R.color.colorQianLan);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_act_comeparedata_compare:
                String date1 = etFirst.getText().toString().trim();
                String date2 = etSecond.getText().toString().trim();
                if ("".equals(date1) && "".equals(date2)) {
                    ToastUtils.showToast(CompareDataActivity.this, R.string.bijiaoriqibunengweikong);
                } else {
                    openActivityParams(CompareDataDetailsActivity.class, "date1", date1, "date2", date2);
                }
                break;
//            case R.id.: break;
//            case R.id.: break;
//            case R.id.: break;
//            case R.id.: break;
//            case R.id.: break;
        }
    }

    @Override
    public void initDataFromIntent() {
        userName = UserConfig.getInstance().getUserName(this);
    }

    @Override
    public void initView() {
        setTopMargin(mtb, MApp.STATUS_BAE_HEIGHT);

        listDate = DataSupport.where("userName = ? ", userName).find(DateRecordLMBean.class);
        Collections.sort(listDate, new DateComparator());

        lv.setAdapter(getAdapter());
    }

    @Override
    public void initListener() {
        setCloseLisenter(mtb);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (etFirst.isFocused()) {
                    etFirst.setText(listDate.get(position).getDate());
                } else if (etSecond.isFocused()) {
                    etSecond.setText(listDate.get(position).getDate());
                }
            }
        });

        tvCompare.setOnClickListener(this);
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


    private CommonAdapter<DateRecordLMBean> getAdapter() {
        return new CommonAdapter<DateRecordLMBean>(this, R.layout.lv_daterecordbean_notebook, listDate) {
            @Override
            protected void convert(ViewHolder viewHolder, DateRecordLMBean item, int position) {
                viewHolder.setText(R.id.tv_lv_daterecordbean, item.getDate());
            }
        };
    }


}
