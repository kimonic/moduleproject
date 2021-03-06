package com.kimonic.notebook.activity.fixedassets;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.litemapbean.fixedassets.DateRecordLMBean;
import com.kimonic.notebook.litemapbean.fixedassets.ItemFlagLMBean;
import com.kimonic.notebook.litemapbean.fixedassets.SaveDataLMBean;
import com.kimonic.notebook.mapp.MApp;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.ui.MTopBarView;
import com.kimonic.utilsmodule.utils.DialogUtils;
import com.kimonic.utilsmodule.utils.StringUtils;
import com.kimonic.utilsmodule.utils.TimeUtils;
import com.kimonic.utilsmodule.utils.ToastUtils;
import com.lzy.okgo.model.Response;

import org.litepal.crud.DataSupport;

import java.util.List;

import butterknife.BindView;

/**
 * * ===============================================================
 * name:             SaveDataDetailsActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/6
 * description：保存用户下相应标签的详细数据
 * history：
 * *==================================================================
 */

public class SaveDataDetailsActivity extends BaseActivity {

    @BindView(R.id.mtb_act_savedatadetails)
    MTopBarView mtb;
    @BindView(R.id.et_act_savedatadetails_label)
    EditText etLabel;
    @BindView(R.id.et_act_savedatadetails_shuzhi)
    EditText etShuzhi;
    @BindView(R.id.et_act_savedatadetails_record)
    EditText etRecord;
    @BindView(R.id.et_act_savedatadetails_mark)
    EditText etMark;
    @BindView(R.id.tv_act_savedatadetails_save)
    TextView tvSave;
    private String label;
    private String itemFlag;
    private String userName;
    private float vaule;
    private String typeName;
    private String date;
    private List<SaveDataLMBean> listItem;
    private String mark;
    /**返回刷新标志*/
    private boolean resultFlag=false;

    @Override
    public int getLayoutResId() {
        return R.layout.act_savedatadetails_notebook;
    }

    @Override
    protected int setStatusBarColor() {
        return getColorRes(R.color.colorQianLan);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_act_savedatadetails_save://保存
                if ("".equals(etRecord.getText().toString().trim())) {
                    date = TimeUtils.getNowDateShort();//记录日期
                } else {
                    date = etRecord.getText().toString().trim();
                }

                if ("".equals(etLabel.getText().toString().trim())) {
                    ToastUtils.showToast(SaveDataDetailsActivity.this, R.string.zichanleibiebunengweikong);
                } else if ("".equals(etShuzhi.getText().toString().trim())) {
                    ToastUtils.showToast(SaveDataDetailsActivity.this, R.string.zichanjiazhibunengweikong);
                } else {
                    typeName = etLabel.getText().toString().trim();//资产类别
                    vaule = StringUtils.string2Float(etShuzhi.getText().toString().trim());//资产价值
                    mark = etMark.getText().toString().trim();//备注
                    if (itemFlag != null) {
                        listItem = DataSupport.where("userName = ? and dateFlag = ? and " +
                                "itemFlag = ?", userName, date, itemFlag).find(SaveDataLMBean.class);
                    }

                    if (listItem != null && listItem.size() > 0) {//当天修改
                        DialogUtils.showPromptDialog(this, getString(R.string.gaileibieyicunzai), new DialogUtils.DialogUtilsCallBack() {
                            @Override
                            public void cancel() {

                            }

                            @Override
                            public void affirm() {
                                listItem.get(0).setValue(vaule);
                                listItem.get(0).setMark(mark);
                                listItem.get(0).setLastModify(TimeUtils.getNowDateShort());
                                listItem.get(0).setFrequencyOfModification(listItem.get(0).getFrequencyOfModification() + 1);
                                listItem.get(0).save();
                                List<DateRecordLMBean> listDate = DataSupport.where("userName = ? and date = ? "
                                        , userName, date).find(DateRecordLMBean.class);
                                if (listDate == null || listDate.size() == 0) {
                                    DateRecordLMBean bean1 = new DateRecordLMBean();
                                    bean1.setUserName(userName);
                                    bean1.setDate(date);
                                    bean1.save();
                                }

                                ToastUtils.showToast(SaveDataDetailsActivity.this, R.string.baocunchenggong);
                            }
                        }, null, null, null);

                    } else {//新建
                        label = typeName;
                        itemFlag = addItem(typeName);
                        SaveDataLMBean bean = new SaveDataLMBean();
                        bean.setValue(vaule);
                        bean.setDateFlag(date);
                        bean.setItem(typeName);//资产类别
                        bean.setUserName(userName);
//                         TODO: 2018/3/1 itemflag为null时需要确定当前标签的itemflag
                        bean.setItemFlag(itemFlag);
                        bean.setMark(mark);
                        bean.setLastModify(date);
                        bean.setYear(String.valueOf(TimeUtils.getCurrentYear()));
                        bean.setMonth(TimeUtils.getCurrentMonthStr());
                        bean.save();

                        List<DateRecordLMBean> listDate = DataSupport.where("userName = ? and date = ? "
                                , userName, date).find(DateRecordLMBean.class);
                        if (listDate == null || listDate.size() == 0) {
                            DateRecordLMBean bean1 = new DateRecordLMBean();
                            bean1.setUserName(userName);
                            bean1.setDate(date);
                            bean1.save();
                        }

                        ToastUtils.showToast(SaveDataDetailsActivity.this, R.string.baocunchenggong);
                    }


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
        label = getIntent().getStringExtra("label");
        itemFlag = getIntent().getStringExtra("itemFlag");

        if (label != null && (!"".equals(label))) {
            etLabel.setEnabled(false);
            etLabel.setFocusable(false);
            etLabel.setKeyListener(null);
        }

    }

    @Override
    public void initView() {
        setTopMargin(mtb, MApp.STATUS_BAE_HEIGHT);
        etLabel.setText(label);
        etRecord.setText(TimeUtils.getNowDateShort());
    }

    @Override
    public void initListener() {
        setCloseLisenter(mtb);
        tvSave.setOnClickListener(this);
    }

    /**
     * 添加资产类别
     */
    private String addItem(String item) {
        List<ItemFlagLMBean> list = DataSupport.findAll(ItemFlagLMBean.class);
        List<ItemFlagLMBean> listItem = DataSupport.where("itemName = ? and userName = ?",
                item, userName).find(ItemFlagLMBean.class);

        if (listItem != null && listItem.size() == 0) {
            ItemFlagLMBean bean = new ItemFlagLMBean();
            bean.setItemName(item);
            bean.setItemFlag((list.size() + 1));
            bean.setUserName(userName);
            bean.save();
            resultFlag=true;
            return "" + bean.getItemFlag();
        } else if (listItem != null) {
            return "" + listItem.get(0).getItemFlag();
        }
        return "";
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
    public void handleBackup() {
        if (resultFlag){
            setResult(1);
        }
        closeActivity();
    }
}
