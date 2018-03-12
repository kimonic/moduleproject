package com.kimonic.test;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;

/**
 * * ===============================================================
 * name:             TestView
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/7
 * method:
 * <p>
 * <p>
 * description：
 * history：
 * *==================================================================
 */

public class TestView extends View {
    public TestView(Context context) {
        this(context, null, 0);
    }

    public TestView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initTestView();
    }


    @TargetApi(21)
    public TestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initTestView();
    }

    private void initTestView() {
        final ViewConfiguration configuration = ViewConfiguration.get(getContext());
        int mTouchSlop = configuration.getScaledTouchSlop();
        int mMinimumVelocity = configuration.getScaledMinimumFlingVelocity();
        int mMaximumVelocity = configuration.getScaledMaximumFlingVelocity();
        int mOverscrollDistance = configuration.getScaledOverscrollDistance();
        int mOverflingDistance = configuration.getScaledOverflingDistance();
        Log.e("TAG", "initTestView: -mTouchSlop----"+mTouchSlop);
        Log.e("TAG", "initTestView: ---mMinimumVelocity--"+mMinimumVelocity);
        Log.e("TAG", "initTestView: ---mMaximumVelocity--"+mMaximumVelocity);
        Log.e("TAG", "initTestView: --mOverscrollDistance---"+mOverscrollDistance);
        Log.e("TAG", "initTestView: ----mOverflingDistance-"+mOverflingDistance);
//        Log.e("TAG", "initTestView: -----"+);
//        Log.e("TAG", "initTestView: -----"+);

//        mVerticalScrollFactor = configuration.getScaledVerticalScrollFactor();
    }
}
