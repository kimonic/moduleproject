package com.kimonic.notebook.mvp.memorandum.add;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.litemapbean.memorandum.MemorandumLMBean;
import com.kimonic.notebook.mapp.MApp;
import com.kimonic.notebook.mvp.memorandum.MemorandumRespository;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.ui.MTopBarView;
import com.kimonic.utilsmodule.utils.TimeUtils;
import com.kimonic.utilsmodule.utils.ToastUtils;
import com.lzy.okgo.model.Response;

import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;

/**
 * * ===============================================================
 * name:             MemorandumAddActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/26
 * method:
 * <p>
 * <p>
 * description：备忘录activity
 * history：
 * *==================================================================
 */

public class MemorandumAddActivity extends BaseActivity implements MemorandumAddContract.View {

    @BindView(R.id.mtb_act_memorandumadd)
    MTopBarView mtb;
    @BindView(R.id.et_act_memorandumadd_title)
    EditText etTitle;
    @BindView(R.id.et_act_memorandumadd_flag)
    EditText etFlag;
    @BindView(R.id.et_act_memorandumadd_datee)
    EditText etDate;
    @BindView(R.id.et_act_memorandumadd_content)
    EditText etContent;
    @BindView(R.id.tv_act_memorandumadd_save)
    TextView tvSave;
    private MemorandumAddContract.Presenter presenter;
    private Map<String, EditText> map;
    private boolean isEdit = true;
    public static final int TYPE_EDIT = 2;
    public static final int TYPE_INSERT = 1;
    private int type = 1;
    private long id = -1;
    @Override
    public int getLayoutResId() {
        return R.layout.act_memorandum_add;
    }

    @Override
    protected int setStatusBarColor() {
        return getColorRes(R.color.colorQianLan);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_act_memorandumadd_save:
                if (isEdit) {
                    presenter.save(map);
                } else {
                    setSaveText(R.string.baocunjilu);
                }
                break;
//         case R.id.:break;
//         case R.id.:break;
//         case R.id.:break;
//         case R.id.:break;
//         case R.id.:break;
        }
    }

    @Override
    public void initDataFromIntent() {
        presenter = new MemorandumAddPresenter<>(this, new MemorandumRespository<MemorandumLMBean>());
        map = new TreeMap<>();
        map.put("title", etTitle);
        map.put("date", etDate);
        map.put("flag", etFlag);
        map.put("content", etContent);

        type = getIntent().getIntExtra("type", TYPE_INSERT);
        id = getIntent().getLongExtra("id", -1);
    }

    @Override
    public void initView() {
        setTopMargin(mtb, MApp.STATUS_BAE_HEIGHT);

        if (type == TYPE_EDIT) {
            mtb.setCenterTitle(R.string.bianjibeiwanglu);
            tvSave.setText(R.string.xiugaibeiwanglu);
            presenter.init(id);
        } else {
            etDate.setText(TimeUtils.getNowDateShort());
        }
    }

    @Override
    public void initListener() {
        tvSave.setOnClickListener(this);
        setCloseLisenter(mtb);

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
    public void setPresenter(MemorandumAddContract.Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void showToast(int strRes) {
        ToastUtils.showToast(MemorandumAddActivity.this, strRes);
    }

    @Override
    public void clear() {

    }

    @Override
    public void init(MemorandumLMBean bean) {
        etTitle.setText(bean.getTitle());
        etDate.setText(bean.getCompleteDate());
        etContent.setText(bean.getContent());
        etFlag.setText(bean.getFlag());

    }

    @Override
    public void setSaveText(int strRes) {
        isEdit = !isEdit;
        tvSave.setText(strRes);
    }
}
