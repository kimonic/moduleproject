package com.kimonic.myutilsproject.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.support.annotation.Nullable;
import android.support.constraint.solver.widgets.ConstraintWidget;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.kimonic.myutilsproject.R;
import com.kimonic.utilsmodule.utils.ToastUtils;

/**
 * * ===============================================================
 * name:             ZhuoYouView
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/1/26
 * description：
 * history：
 * *==================================================================
 */

public class ZhuoYouView extends View {

    private Bitmap bitmap;
    private RectF rectF;

    private Path path;
    private Paint shadePaint;

    public ZhuoYouView(Context context) {
        this(context, null, 0);
    }

    public ZhuoYouView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ZhuoYouView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @TargetApi(21)
    public ZhuoYouView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
    }

    private void initView() {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.zhuoyou001);
        rectF = new RectF();
        path = new Path();
        shadePaint = new Paint();
        shadePaint.setColor(Color.parseColor("#007000"));
        shadePaint.setStyle(Paint.Style.FILL);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.e("TAG", "onDraw: -----绘制图形-------111");

        int width = getWidth();
        int height = getHeight();
        rectF.top = 0;
        rectF.left = 0;
//
//        rectF.right = 515;
//        rectF.bottom = 735;

//        width=500;
//        height=1800;

        rectF.right = width;
        rectF.bottom = height;

        float scaleX = width / 515f;
        float scaleY = height / 735f;

        Log.e("TAG", "onDraw: 绘制图形----width-"+width);
        Log.e("TAG", "onDraw: 绘制图形----height-"+height);
        Log.e("TAG", "onDraw: 绘制图形----scaleX-"+scaleX);
        Log.e("TAG", "onDraw: 绘制图形----scaleY-"+scaleY);


//        float scaleX = 1;
//        float scaleY = 1;

//        float scale = 1.5f * scaleX;
//        float scale1 = 1.5f * scaleY;

//        path.offset(0 * scaleX, 150 * scaleY);

        path.moveTo(134 * scaleX, 459 * scaleY);
        path.lineTo(156 * scaleX, 459 * scaleY);
        path.lineTo(163 * scaleX, 520 * scaleY);
        path.lineTo(356 * scaleX, 520 * scaleY);
        path.lineTo(356 * scaleX, 460 * scaleY);
        path.lineTo(381 * scaleX, 460 * scaleY);
        path.lineTo(461 * scaleX, 558 * scaleY);
        path.lineTo(461 * scaleX, 570 * scaleY);
        path.lineTo(360 * scaleX, 570 * scaleY);
        path.lineTo(319 * scaleX, 600 * scaleY);
        path.lineTo(195 * scaleX, 600 * scaleY);
        path.lineTo(155 * scaleX, 570 * scaleY);
        path.lineTo(52 * scaleX, 570 * scaleY);
        path.lineTo(52 * scaleX, 558 * scaleY);
        path.close();
        Log.e("TAG", "onDraw: -----绘制图形-------222");

        canvas.drawBitmap(bitmap, null, rectF, null);
        canvas.drawPath(path, shadePaint);
        Log.e("TAG", "onDraw: -----绘制图形-------333");

        /**
         * 134,459
         156,459
         163,520
         356,520
         356,460
         381,460
         461,558
         461,570
         360,570
         319,600
         195,600
         155,570
         52,570
         52,558
         */


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            RectF r=new RectF();
            path.computeBounds(r, true);
            Region region=new Region();
            region.setPath(path, new Region((int)r.left,(int)r.top,(int)r.right,(int)r.bottom));
            if (region.contains((int)event.getX(), (int)event.getY())){
                ToastUtils.showToast(getContext(), "包含该点");
            }else {
                ToastUtils.showToast(getContext(), "不包含该点");

            }
            Log.e("","--判断点是否则范围内----"+region.contains((int)event.getX(), (int)event.getY()));
        }


        return super.onTouchEvent(event);
    }
}
