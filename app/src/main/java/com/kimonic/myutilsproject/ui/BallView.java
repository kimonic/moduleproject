package com.kimonic.myutilsproject.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.kimonic.myutilsproject.R;


/**
 * * ====================================================================
 * name:            BallView
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：            2017/7/31
 * description：  预期年化收益信息展示view  首页中展示
 * history：
 * * ====================================================================
 */

public class BallView extends View {


    private Paint circlePaint, linePaint, textPaint, shadowpaint, testPaint;

    /**
     * 类直线路径
     */
    private Path pathLine;


    private RectF rectF = new RectF();

    private int circleBorderWidth = 4;
    private int lineBorderWidth = 20;
    private String text = "11.00%";
    private float duandianbuchang = 10;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public BallView(Context context) {
        this(context, null, 0);
    }

    public BallView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BallView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @TargetApi(21)
    public BallView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
    }

    private void initView() {
        pathLine = new Path();

        circlePaint = new Paint();
        circlePaint.setAntiAlias(true);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setColor(Color.parseColor("#169CBC"));
        circlePaint.setStrokeWidth(circleBorderWidth);

        linePaint = new Paint();
        linePaint.setAntiAlias(true);
        linePaint.setStyle(Paint.Style.FILL);
        linePaint.setStrokeCap(Paint.Cap.ROUND);
        linePaint.setColor(Color.parseColor("#45C1E0"));
//        linePaint.setStrokeWidth(lineBorderWidth);

        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(Color.parseColor("#FFFFFF"));
        textPaint.setStrokeWidth(10);

        testPaint = new Paint();
        testPaint.setAntiAlias(true);
        testPaint.setColor(Color.parseColor("#21B7DA"));
        testPaint.setStyle(Paint.Style.FILL);


        shadowpaint = new Paint();
        shadowpaint.setAntiAlias(true);
        shadowpaint.setStyle(Paint.Style.FILL);
        shadowpaint.setColor(Color.parseColor("#149BBC"));


    }

    @Override
    protected void onDraw(Canvas canvas) {

        int width = getWidth();
        int height = getHeight();

        int length = Math.min(width, height);//取宽高的最小值


        //绘制阴影圆弧的角度
        float angle = (float) (360 * Math.asin((0.1 * length - lineBorderWidth) / (0.5 * length)) / (2 * Math.PI));//三角函数计算夹角
        rectF.left = width / 2 - length / 2 + 5;
        rectF.top = height / 2 - length / 2 + 5;
        rectF.right = width / 2 + length / 2 - 5;
        rectF.bottom = height / 2 + length / 2 - 5;

//        canvas.drawRect(rectF,testPaint);
//        //绘制直线
//        canvas.drawArc(rectF, 180-angle/2, -angle/2, false, linePaint);
//        canvas.drawArc(rectF, 0+angle/2, angle/2, false, linePaint);
//
//        Log.e("TAG", "onDraw: 绘制直线--angle---" + angle);
//
//        float temp = (float) ((length - 2 * Math.sqrt(0.24f * length * length)) / 2);
//        pathLine.moveTo(2, height / 2+length*0.03f);
//        pathLine.lineTo(width-2 , height / 2+length*0.03f);
//        pathLine.lineTo(width -temp-2, height / 2+ 0.1f * length);
//        pathLine.lineTo(temp+2, height / 2+ 0.1f * length);
////        pathLine.addArc(rectF, 0, angle);
////        pathLine.moveTo((float) (length-(length-2*Math.sqrt(0.24f*length*length))/2),height/2+0.1f*length);
////        pathLine.lineTo((float) ((length - 2 * Math.sqrt(0.24f * length * length)) / 2), height / 2 + 0.1f * length);
////        pathLine.addArc(rectF, 180, -angle);
//
//        pathLine.close();
//
//
//        canvas.drawPath(pathLine, linePaint);



        canvas.drawArc(rectF, angle/2, 180-angle , false, linePaint);
        canvas.drawArc(rectF, angle, 180 - 2 * angle, false, shadowpaint);




//        float lineStartX = (float) (width / 2 - Math.sqrt(length * length / 4 - length * length * 0.01));
//        float lineEndX = (float) (width / 2 + Math.sqrt(length * length / 4 - length * length * 0.01));
//        float lineHeight = height / 2 + 0.1f * length / 2;
//        linePaint.setStrokeWidth(length*0.1f);
//        canvas.drawLine(lineStartX+duandianbuchang, lineHeight, lineEndX-duandianbuchang, lineHeight, linePaint);


        //绘制上半部分文本
        float textY = height / 2 - length * 0.11f;
        shadowpaint.setTextSize(68);
        float textLength = shadowpaint.measureText(text);
        float textX = width / 2 - textLength / 2;
        canvas.drawText(text, textX, textY, shadowpaint);


        //绘制下半部分文本
        textPaint.setTextSize(37);
        float bottomTextLength = textPaint.measureText(getResources().getString(R.string.yuqinianhuashouyi));
        float textX1 = width / 2 - bottomTextLength / 2;
        float textY1 = height / 2 + length * 0.32f;
        canvas.drawText(getResources().getString(R.string.yuqinianhuashouyi), textX1, textY1, textPaint);


        //绘制外圈圆
        canvas.drawCircle(width / 2, height / 2, length / 2 - circleBorderWidth, circlePaint);


    }
}
