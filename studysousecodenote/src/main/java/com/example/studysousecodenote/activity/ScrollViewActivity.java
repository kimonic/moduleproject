package com.example.studysousecodenote.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.studysousecodenote.R;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.lzy.okgo.model.Response;

import butterknife.BindView;

/**
 * * ===============================================================
 * name:             ScrollViewActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/12
 * method:
 * <p>
 * <p>
 * description：
 * history：
 * *==================================================================
 */

public class ScrollViewActivity extends BaseActivity {
    @BindView(R.id.sv_act_scrollview_soursecode)
    ScrollView sv;
    @BindView(R.id.bt_act_scrollview_soursecode_up)
    Button btUp;
    @BindView(R.id.bt_act_scrollview_soursecode_down)
    Button btDown;
    @BindView(R.id.tv_act_scrollview_soursecode)
    TextView tv;

    @Override
    public int getLayoutResId() {
        return R.layout.act_scrollview_soursecode;
    }

    @Override
    protected int setStatusBarColor() {
        return 0;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_act_scrollview_soursecode_up:
/**
 */

                break;
            case R.id.bt_act_scrollview_soursecode_down:
                sv.setOverScrollMode(View.OVER_SCROLL_ALWAYS);//内容滚动时允许scrollview有边界溢出
                break;
//         case R.id.:break;
//         case R.id.:break;
//         case R.id.:break;
//         case R.id.:break;
        }
    }

    @Override
    public void initDataFromIntent() {
        sv.getHeight();//scrollview在屏幕中的显示高度
        sv.getScrollY();//scrollview当前显示的视图位于自身坐标系中的顶部Y坐标
        sv.getScrollX();//scrollview当前显示的视图位于自身坐标系中的顶部X坐标
        sv.getMaxScrollAmount();//固定值scrollview高度的一半
        sv.arrowScroll(View.FOCUS_DOWN);//下翻scrollview高度的一半
        sv.arrowScroll(View.FOCUS_UP);//上翻scrollview高度的一半
        sv.fullScroll(View.FOCUS_UP);//上翻到顶部
        sv.fullScroll(View.FOCUS_DOWN);//下翻到底部
        sv.pageScroll(View.FOCUS_UP);//scrollview上翻一屏
        sv.pageScroll(View.FOCUS_DOWN);//scrollview下翻一屏
        sv.smoothScrollBy(0, 0);//平滑滚动从指定坐标点
        sv.scrollBy(0, 0);//立即滚动从指定坐标点
        sv.smoothScrollTo(0, 0);//平滑滚动到指定坐标点
        sv.scrollTo(0, 0);//立即滚动到指定坐标点
        sv.fling(10000);//以指定出事速度抛掷scrollview,正值向下,负值向上
        sv.setOverScrollMode(View.OVER_SCROLL_NEVER);//不允许scrollview有边界溢出,边界阴影效果
        sv.setOverScrollMode(View.OVER_SCROLL_ALWAYS);//总是允许scrollview有边界溢出
        //内容滚动时允许scrollview有边界溢出,当显示内容没有滚动时不会有边界溢出效果
        sv.setOverScrollMode(View.OVER_SCROLL_IF_CONTENT_SCROLLS);

//        解决scrollview中嵌套listview  GridView时,自动滑动到listview或GridView开始处的问题:
//        在scrollview的嵌套子view中添加,android:descendantFocusability="blocksDescendants"   属性即可
//        descendantFocusability有三种属性
//        beforeDescendants ：viewgroup会优先其子类控件而获取到焦点
//        afterDescendants：viewgroup只有当其子类控件不需要获取焦点时才获取焦点
//        blocksDescendants：viewgroup会覆盖子类控件而直接获得焦点
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        btUp.setOnClickListener(this);
        btDown.setOnClickListener(this);
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
