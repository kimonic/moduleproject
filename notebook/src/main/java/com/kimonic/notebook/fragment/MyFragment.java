package com.kimonic.notebook.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.kimonic.notebook.R;
import com.kimonic.notebook.bean.MyFragBean;
import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.mvp.loginandregister.login.LoginActivity;
import com.kimonic.utilsmodule.base.BaseFragment;
import com.kimonic.utilsmodule.utils.HeightUtils;
import com.lzy.okgo.model.Response;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * * ===============================================================
 * name:             MyFragment
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/26
 * method:
 * <p>
 * <p>
 * description：我的fragment
 * history：
 * *==================================================================
 */

public class MyFragment extends BaseFragment {
    @BindView(R.id.iv_frag_my_icon)
    ImageView ivIcon;
    @BindView(R.id.tv_frag_my_username)
    TextView tvUserName;
    @BindView(R.id.lv_frag_my)
    ListView lv;

    private List<MyFragBean> list;

    private int[] imgRes = {R.drawable.frag_my_ic001,
            R.drawable.frag_my_ic002,
            R.drawable.frag_my_ic003,
            R.drawable.frag_my_ic004,
            R.drawable.frag_my_ic005,
            R.drawable.frag_my_ic006

    };
    private int[] item = {R.string.shiyongjiaocheng,
            R.string.yinsibaohu,
            R.string.zhognyaotishi,
            R.string.lianxizuozhe,
            R.string.banbengengxin,
            R.string.tuichudenglu
    };
    //使用教程
    //隐私保护
    //版本更新
    //重要提示
    //联系作者
    //退出登陆


    @Override
    public int layoutRes() {
        return R.layout.frag_my;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initDataFromIntent() {
        list = new ArrayList<>(5);
        for (int i = 0; i < imgRes.length; i++) {
            MyFragBean bean = new MyFragBean();
            bean.setImgRes(imgRes[i]);
            bean.setStrRes(item[i]);
            list.add(bean);
        }
    }

    @Override
    public void initView() {
        tvUserName.setText(UserConfig.getInstance().getUserName(getActivity()));
        lv.setAdapter(getAdapter(list));
        HeightUtils.setListviewHeight(lv);
    }

    @Override
    public void initListener() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5://退出登陆
                        UserConfig.getInstance().clear(getActivity());
                        openActivity(LoginActivity.class);
                        closeActivity();
                        break;
                }
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

    /**
     * 获得适配器
     */
    private CommonAdapter<MyFragBean> getAdapter(List<MyFragBean> list) {
        return new CommonAdapter<MyFragBean>(getActivity(), R.layout.lv_frag_my, list) {
            @Override
            protected void convert(ViewHolder viewHolder, MyFragBean item, int position) {
                viewHolder.setImageResource(R.id.iv_lv_frag_my, item.getImgRes());
                viewHolder.setText(R.id.tv_lv_frag_my, getString(item.getStrRes()));
            }
        };
    }

}
