package com.kimonic.myutilsproject.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.kimonic.myutilsproject.R;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * * ===============================================================
 * name:             TestActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/1/23
 * description：
 * history：
 * *==================================================================
 */

public class TestActivity extends BaseActivity {
    public static int DEVICE_DENSITY=132;


    @BindView(R.id.rv_act_test)
    RecyclerView rv;
//    @BindView(R.id.tv_act_integralrecode_integralrecode)
//    TextView tvActIntegralrecodeIntegralrecode;
//    @BindView(R.id.iv_act_integralrecode_filtrate)
//    ImageView ivActIntegralrecodeFiltrate;
//    @BindView(R.id.lv_act_integralrecode)
//    ListView lvActIntegralrecode;
//    @BindView(R.id.srl_fact_integralrecode)
//    com.scwang.smartrefresh.layout.SmartRefreshLayout srlFactIntegralrecode;
    private int page=1;

    @Override
    public int getLayoutResId() {
        return R.layout.act_test;
    }

    @Override
    protected int setStatusBarColor() {
        return 0;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//                 case R.id.btn_act_test_1:
//                     break;
//                 case R.id.:break;
//                 case R.id.:break;
//                 case R.id.:break;
//                 case R.id.:break;
//                 case R.id.:break;
        }

    }

    @Override
    public void initDataFromIntent() {
        final GridLayoutManager manager = new GridLayoutManager(this,3);






//        LinearLayoutManager manager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rv.setLayoutManager(manager);
        List<String> list=new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add("这是第"+i+"个item");
        }
        final RecyclerAdapter<String> adapter=new RecyclerAdapter<>(list,this,R.layout.rv_header
        ,-1,R.layout.rv_item);
        rv.setAdapter(adapter);

        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return adapter.isFoot(position) || adapter.isHead(position) ||position==10? manager.getSpanCount() : 1;
            }
        });

    }

    @Override
    public void initView() {
//        //设置全区背景色
//        srlFactIntegralrecode.setPrimaryColorsId(R.color.global_theme_background_color);
//        //设置 Header 为 Material风格
//        srlFactIntegralrecode.setEnableRefresh(false);
//        //设置 Footer 为 球脉冲
//        srlFactIntegralrecode.setRefreshFooter(new BallPulseFooter(this).setSpinnerStyle(SpinnerStyle.Scale));
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initDataFromInternet() {
//        TreeMap<String, String> map = new TreeMap<>();
//
////        map.put("login_token", UserConfig.getInstance().getLoginToken(this));
////        Log.e(TAG, "initDataFromInternet: ------获取的logintoken-----------" + UserConfig.getInstance().getLoginToken(this));
//        map.put("login_token", "12267");
//        map.put("start_time", "");
//        map.put("end_time", "");
//        map.put("page_count", "");//待删除字段
//        map.put("page", "" + page);
////        Log.e("TAG", "initDataFromInternet: ---------------------??" + paramsStartTime);
////        Log.e("TAG", "initDataFromInternet: ---------------------??" + paramsEndTime);
//        showPDialog();
//
//        HttpUtils.getInstance().POST(this, Constants.INTEGRAL_LIST, map, "IntegralRecodeActivity", getStringCallback());


//                new StringCallback() {
//            @Override
//            public void onSuccess(Response<String> response) {
//                dismissPDialog();
//                String result = StringUtils.getDecodeString(response.body());
//                Log.e(TAG, "onSuccess: ----------消息接口请求返回数据-----------------" + result);
//                BaseBean bean1 = ParseJson.getJsonResult(response.body(), new TypeToken<IntegralRecodeBean>() {
//                }.getType(), IntegralRecodeBean.class, IntegralRecodeActivity.this);
//
//                if (page == 1 && bean1 != null) {
////                    dialog.dismiss();
//                    bean = (IntegralRecodeBean) bean1;
//                    LoadInternetDataToUi();
//                } else if (page > 1 && bean1 != null) {
//                    srlIntegralRecode.finishLoadmore();
//                    bean = (IntegralRecodeBean) bean1;
//                    LoadInternetDataToUi();
//                }
//            }
//
//            @Override
//            public void onError(Response<String> response) {
//                Log.e("TAG", "onSuccess: ----------消息接口请求返回错误信息-----------------" + response.message());
////                dialog.dismiss();
//                dismissPDialog();
//                super.onError(response);
//            }
//        });
    }

    @Override
    public void loadInternetDataToUi(Response<String> response) {
//        String result = StringUtils.getDecodeString(response.body());
//        Log.e("TAG", "loadInternetDataToUi: ---请求获取的数据--"+result);

    }

    @Override
    public void loadInternetDataToUi() {

    }


}
