package com.kimonic.notebook.mvp.expenditure.query;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.litemapbean.daily.ExpenditureLMBean;
import com.kimonic.notebook.mapp.MApp;
import com.kimonic.notebook.mvp.expenditure.ExpenditureReository;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.ui.MTopBarView;
import com.kimonic.utilsmodule.utils.ToastUtils;
import com.lzy.okgo.model.Response;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.List;

import butterknife.BindView;

/**
 * * ===============================================================
 * name:             ExpenditureQueryActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/21
 * method:
 * <p>
 * <p>
 * description：  按月查看支出记录activity
 * history：
 * *==================================================================
 */

public class ExpenditureQueryActivity extends BaseActivity implements ExpenditureQueryContract.View {

    @BindView(R.id.mtb_act_expenditure_query)
    MTopBarView mtb;
    @BindView(R.id.tv_act_expenditure_query_previous)
    TextView tvPrevious;
    @BindView(R.id.tv_act_expenditure_query_current)
    TextView tvCurrent;
    @BindView(R.id.tv_act_expenditure_query_next)
    TextView tvNext;
    @BindView(R.id.lv_act_expenditure_query)
    ListView lv;
    @BindView(R.id.tv_act_expenditure_query_hint)
    TextView tvHint;
    private ExpenditureQueryContract.Presenter presenter;

//    public static final int ADAPTER_SET = 1;
//    public static final int ADAPTER_UPDATE = 2;
    private CommonAdapter<ExpenditureLMBean> adapter;


    @Override
    public int getLayoutResId() {
        return R.layout.act_expenditure_query;
    }

    @Override
    protected int setStatusBarColor() {
        return getColorRes(R.color.colorQianLan);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_act_expenditure_query_previous://上一个月
                presenter.setPrevious();
                break;
            case R.id.tv_act_expenditure_query_next://下一个月
                presenter.setNext();
                break;
//            case R.id.: break;
//            case R.id.: break;
//            case R.id.: break;
//            case R.id.: break;
        }

    }

    @Override
    public void initDataFromIntent() {
        presenter = new ExpenditureQueryPresenter(this, new ExpenditureReository());
    }

    @Override
    public void initView() {
        setTopMargin(mtb, MApp.STATUS_BAE_HEIGHT);
        presenter.setCurrent();

    }

    @Override
    public void initListener() {
        setCloseLisenter(mtb);
        tvPrevious.setOnClickListener(this);
        tvNext.setOnClickListener(this);


        lv.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                menu.setHeaderTitle(R.string.qingxuanzexuyaodecaozuo);
                //groupId:组ID
//                itemId:菜单项ID，我们上面讲了，整个activity中，这个ID值必须是唯一的。先记住即可，后面我们会讲为什么要唯一。
//                order:是在一个菜单中的排序顺序，一个菜单的排序顺序会根据这个值，由小到大排列菜单项。所以，仔细看上面的排序方式，
//                 我故意把排序顺序改成了，1，3，2，4；但界面中菜单的排序应该是按1，2，3，4 这样排序的：
//              （从效果图可以看到，菜单的排序是按order的大小排列的！）
                menu.add(0, 0, 0, R.string.gengxingaijilu);
                menu.add(0, 1, 0, R.string.shanchugaijilu);
            }
        });
    }

    //给菜单项添加事件
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //获取点击的item的位置
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;
        switch (item.getItemId()) {
            case 0:
                presenter.startNextAct(position);
                return true;
            case 1:
                presenter.remove(position);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
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
    public void setPresenter(ExpenditureQueryContract.Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void setList(List<ExpenditureLMBean> list) {
        if (adapter == null) {
            adapter = getAdapter(list);
            lv.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void setCurrent(String str) {
        tvCurrent.setText(str);
    }

    /**
     * @param flag false--显示listview
     */
    @Override
    public void showNothing(boolean flag) {
        if (flag) {
            lv.setVisibility(View.GONE);
            tvHint.setVisibility(View.VISIBLE);
        } else {
            lv.setVisibility(View.VISIBLE);
            tvHint.setVisibility(View.GONE);
        }
    }

    @Override
    public void showToast(int strRes) {
        ToastUtils.showToast(ExpenditureQueryActivity.this, strRes);
    }

    /**
     * 获得适配器
     */
    private CommonAdapter<ExpenditureLMBean> getAdapter(List<ExpenditureLMBean> list) {
        return new CommonAdapter<ExpenditureLMBean>(this, R.layout.lv_expenditure_query, list) {
            @Override
            protected void convert(ViewHolder viewHolder, ExpenditureLMBean item, int position) {
                viewHolder.setText(R.id.et_act_expenditure_query_name, item.getItemName());
                viewHolder.setText(R.id.et_act_expenditure_query_mark, item.getMark());
                viewHolder.setText(R.id.et_act_expenditure_query_datee, item.getCompleteDate());
                viewHolder.setText(R.id.et_act_expenditure_query_amount, "" + item.getAmount());
                viewHolder.setText(R.id.et_act_expenditure_query_type, item.getType());
            }
        };
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 2) {
            presenter.updateData();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
