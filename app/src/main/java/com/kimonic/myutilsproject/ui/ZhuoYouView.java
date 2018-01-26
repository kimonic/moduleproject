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
import android.support.annotation.Nullable;
import android.support.constraint.solver.widgets.ConstraintWidget;
import android.util.AttributeSet;
import android.view.View;

import com.kimonic.myutilsproject.R;

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
        bitmap= BitmapFactory.decodeResource(getResources(), R.drawable.zhuoyou001);
        rectF=new RectF();
        path=new Path();
        /**
         *515,735

         */



        shadePaint=new Paint();
        shadePaint.setColor(Color.parseColor("#007000"));
        shadePaint.setStyle(Paint.Style.FILL);

    }

    @Override
    protected void onDraw(Canvas canvas) {

        int width=getWidth();
        int height=getHeight();
        rectF.top=0;
        rectF.left=0;
        rectF.right=515;
        rectF.bottom=735;

        float scaleX=width/515;
        float scaleY=height/735;


        path.moveTo(283,322);
        path.lineTo(269,321);
        path.lineTo( 204,404);
        path.lineTo(281,404);
        path.lineTo(311,423);
        path.lineTo(405,425);
        path.lineTo(433,405);
        path.lineTo(511,405);
        path.lineTo(510,396);
        path.lineTo(450,321);
        path.lineTo( 430,321);
        path.lineTo(432,369);
        path.lineTo(293,366 );
        path.lineTo( 286,366);
        path.lineTo(286,322);
        path.close();

        path.offset(-100,150);


//        path.moveTo(283*scaleX,322);
//        path.lineTo(269*scaleX,321);
//        path.lineTo( 204*scaleX,404);
//        path.lineTo(281*scaleX,404);
//        path.lineTo(311*scaleX,423);
//        path.lineTo(405*scaleX,425);
//        path.lineTo(433*scaleX,405);
//        path.lineTo(511*scaleX,405);
//        path.lineTo(510*scaleX,396);
//        path.lineTo(450*scaleX,321);
//        path.lineTo( 430*scaleX,321);
//        path.lineTo(432*scaleX,369);
//        path.lineTo(293*scaleX,366 );
//        path.lineTo( 286*scaleX,366);
//        path.lineTo(286*scaleX,322);
//        path.close();

        canvas.drawBitmap(bitmap,null,rectF,null);
        canvas.drawPath(path,shadePaint);
    }
}
