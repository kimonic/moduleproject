package com.kimonic.notebook.activity.fixedassets;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.config.Constants;
import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.litemapbean.fixedassets.DateRecordLMBean;
import com.kimonic.notebook.litemapbean.fixedassets.SaveDataLMBean;
import com.kimonic.notebook.mapp.MApp;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.ui.MTopBarView;
import com.kimonic.utilsmodule.utils.DialogUtils;
import com.kimonic.utilsmodule.utils.StringUtils;
import com.kimonic.utilsmodule.utils.ToastUtils;
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

    @BindView(R.id.tv_act_finddatadetails_total)
    TextView tvTotal;
    @BindView(R.id.lv_act_finddatadetails)
    ListView lv;
    @BindView(R.id.mtb_act_finddatadetails)
    MTopBarView mtb;
    private String userName;
    private String date;
    private List<SaveDataLMBean> listDate;
    private CommonAdapter<SaveDataLMBean> adapter;

    @Override
    public int getLayoutResId() {
        return R.layout.act_finddatadetails_notebook;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initDataFromIntent() {
        userName = UserConfig.getInstance().getUserName(this);
        date = getIntent().getStringExtra("date");
    }

    @Override
    public void initView() {
        setTopMargin(mtb, MApp.STATUS_BAE_HEIGHT);

        listDate = DataSupport.where("userName = ? and dateFlag = ? "
                , userName, date).find(SaveDataLMBean.class);


        float total = 0;

        for (int i = 0; i < listDate.size(); i++) {
            total += listDate.get(i).getValue();
        }

        tvTotal.setText(StringUtils.getCommaDecimalsStr(""+total));
        adapter = getAdapter();
        lv.setAdapter(adapter);


    }

    @Override
    public void initListener() {

        mtb.getLeftTV().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeActivity();
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                DialogUtils.showPromptDialog(FindDataDetailsActivity.this, getString(R.string.quedingyaoshanchugaitiaojilume),
                        new DialogUtils.DialogUtilsCallBack() {
                            @Override
                            public void cancel() {

                            }

                            @Override
                            public void affirm() {
                                listDate.get(position).delete();
                                if (listDate.size() - 1 == 0) {
                                    DataSupport.deleteAll(DateRecordLMBean.class, "date = ?", listDate.get(position).getDateFlag());
                                    setResult(666);
                                }

                                float total = 0;

                                for (int i = 0; i < listDate.size(); i++) {
                                    total += listDate.get(i).getValue();
                                }

                                tvTotal.setText(StringUtils.getCommaDecimalsStr(""+total));


                                listDate.remove(position);
                                adapter.notifyDataSetChanged();
                                ToastUtils.showToast(FindDataDetailsActivity.this, R.string.shanchuchenggong);


                            }
                        }, null, null, null);

                return true;
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FindDataDetailsActivity.this, EditOldRecordActivity.class);
                intent.putExtra("id", listDate.get(position).getMyExtendId());
                startActivityForResult(intent, Constants.REQUEST_RESULT_1);
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

    private CommonAdapter<SaveDataLMBean> getAdapter() {
        return new CommonAdapter<SaveDataLMBean>(this, R.layout.lv_savedatabean_notebook, listDate) {
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

    @Override
    protected int setStatusBarColor() {
        return getColorRes(R.color.colorQianLan);
    }
}
