package com.kimonic.notebook.activity.investment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.adapter.ExpanableAdapter;
import com.kimonic.notebook.bean.ExpanableListbean;
import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.litemapbean.invest.InvestDateLMBean;
import com.kimonic.notebook.litemapbean.invest.InvestPlateformLMBean;
import com.kimonic.notebook.litemapbean.invest.RepayDateLMBean;
import com.kimonic.notebook.mapp.MApp;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.ui.MTopBarView;
import com.kimonic.utilsmodule.utils.StringUtils;
import com.lzy.okgo.model.Response;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;

/**
 * * ===============================================================
 * name:             SeeInvestRecordActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/12
 * description：   查看投资记录activity
 * history：
 * *==================================================================
 */

public class SeeInvestRecordActivity extends BaseActivity {
    @BindView(R.id.mtb_act_seeinvestrecord)
    MTopBarView mtb;
    @BindView(R.id.elv_act_seeinvestrecord)
    ExpandableListView elv;

    private List<ExpanableListbean> list;
    private String userName;
    private ExpanableAdapter adapter;
    private AdapterView.OnItemClickListener  listener;
    private int groupPosition;

    @Override
    public int getLayoutResId() {
        return R.layout.act_seeinvestrecord;
    }

    @Override
    protected int setStatusBarColor() {
        return getColorRes(R.color.colorQianLan);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initDataFromIntent() {
        userName = UserConfig.getInstance().getUserName(this);
        List<InvestDateLMBean> list1 = DataSupport.where("userName = ?", userName).find(InvestDateLMBean.class);
        List<RepayDateLMBean> list2 = DataSupport.where("userName = ?", userName).find(RepayDateLMBean.class);
        List<InvestPlateformLMBean> list3 = DataSupport.where("userName = ?", userName).find(InvestPlateformLMBean.class);
        list = new ArrayList<>();
        List<String> lis11 = new ArrayList<>();
        List<String> lis22 = new ArrayList<>();
        List<String> lis33 = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            lis11.add("      " + list1.get(i).getInvestDate());
        }

        for (int i = 0; i < list2.size(); i++) {
            lis22.add("      " + list2.get(i).getRepayDate());
        }

        for (int i = 0; i < list3.size(); i++) {
            lis33.add("      " + list3.get(i).getInvestPlateform());
        }

        sortList(lis11);
        sortList(lis22);

        ExpanableListbean listbean1 = new ExpanableListbean();
        listbean1.setTitle(getString(R.string.genjutouziriqichakan));
        listbean1.setChild(lis11);


        ExpanableListbean listbean2 = new ExpanableListbean();
        listbean2.setTitle(getString(R.string.genjuhuikuanriqichaxun));
        listbean2.setChild(lis22);

        ExpanableListbean listbean3 = new ExpanableListbean();
        listbean3.setTitle(getString(R.string.genjutouzipingtaichakan));
        listbean3.setChild(lis33);


        list.add(listbean1);
        list.add(listbean2);
        list.add(listbean3);


    }

    private void sortList(List<String> list) {
        Collections.sort(list,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (StringUtils.string2Integer(o1.replace("-",""))
                        <StringUtils.string2Integer(o2.replace("-",""))){
                    return 1;
                }else if (StringUtils.string2Integer(o1.replace("-",""))
                        >StringUtils.string2Integer(o2.replace("-",""))){
                    return -1;
                }else {
                    return 0;
                }
            }
        });
    }

    @Override
    public void initView() {

        setTopMargin(mtb, MApp.STATUS_BAE_HEIGHT);
        listener=new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                ToastUtils.showToast(SeeInvestRecordActivity.this, list.get(groupPosition).getChild().get(position));
                openActivityParams(SeeInvestRecordDetailsActivity.class,"type",""+(groupPosition+1),"condition",
                        list.get(groupPosition).getChild().get(position).trim());
                // TODO: 2018/2/13 启动查看数据界面
            }
        };

        elv.setGroupIndicator(null);
        elv.setChildIndicator(null);
        adapter = new ExpanableAdapter(this, list);
        elv.setAdapter(adapter);

    }

    @Override
    public void initListener() {
        //组标签自动收起
        elv.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                int count = elv.getExpandableListAdapter().getGroupCount();
                for (int j = 0; j < count; j++) {
                    if (j != groupPosition) {
                        elv.collapseGroup(j);
                    }
                }
            }
        });
        adapter.setListener(new ExpanableAdapter.OnAdapterItemListener() {
            @Override
            public void onClick(final int groupPosition, View view) {
                SeeInvestRecordActivity.this.groupPosition=groupPosition;
                ((ListView)view).setOnItemClickListener(listener);
            }
        });

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


}
