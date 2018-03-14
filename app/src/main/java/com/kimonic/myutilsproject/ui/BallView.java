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

    /**波浪偏移量*/
    private  float offset=0;
    /**空间圆直径的1/6*/
    private  float  radious;


    private RectF rectF = new RectF();

    private int circleBorderWidth = 4;
    private int lineBorderWidth = 20;
    private String text = "11.00%";
    private float duandianbuchang = 10;


    /**整个空间矩形*/
    RectF rectFAll;


    private boolean  openAnim=true;

    public boolean isOpenAnim() {
        return openAnim;
    }

    public void setOpenAnim(boolean openAnim) {
        this.openAnim = openAnim;
    }

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
        rectFAll=new RectF();

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
        testPaint.setColor(Color.parseColor("#F1F0E7"));
        testPaint.setStyle(Paint.Style.FILL);
        testPaint.setStrokeWidth(10);


        shadowpaint = new Paint();
        shadowpaint.setAntiAlias(true);
        shadowpaint.setStyle(Paint.Style.FILL);
        shadowpaint.setColor(Color.parseColor("#149BBC"));
        animThread();

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

        //两个扇形叠加形成水层效果



        //---------------------------绘制波浪--------------------------------------------------------
        float  boFeng=height/2-80;
        float  shuiPing=height/2+50;
        float  boGu=height/2+100;
        float  weiYi=length/6;
        radious=weiYi;

        for (int i = 0; i < 8; i++) {
            pathLine.reset();
            pathLine.moveTo(weiYi*(i-2)+offset,shuiPing);
            pathLine.quadTo(weiYi*(i-1)+offset,boFeng,weiYi*i+offset,shuiPing);
            pathLine.close();
            canvas.drawPath(pathLine,linePaint);
        }

        //---------------------------绘制波浪--------------------------------------------------------




        canvas.drawArc(rectF, angle/2, 180-angle , false, linePaint);
        canvas.drawArc(rectF, angle, 180 - 2 * angle, false, shadowpaint);
//        canvas.drawArc(rectF, 0, 180, false, shadowpaint);





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



        pathLine.reset();
        pathLine.moveTo(0,height/2);
        pathLine.arcTo(rectF,180,-90);
        pathLine.lineTo(0,height/2+length/2);
        pathLine.close();
        canvas.drawPath(pathLine,testPaint);

        pathLine.reset();
        pathLine.moveTo(length,height/2);
        pathLine.arcTo(rectF,0,90);
        pathLine.lineTo(length,height/2+length/2);
        pathLine.close();
        canvas.drawPath(pathLine,testPaint);
/**
 如果“从零开始”，用什么设计架构的问题属于想得太多做得太少的问题。

 从零开始意味着一个项目的主要技术难点是基本功能实现。当每一个功能都需要考虑如何做到的时候，我觉得一般人都没办法考虑如何做好。

 因为，所有的优化都是站在最上层进行统筹规划。在这之前，你必须对下层的每一个模块都非常熟悉，进而提炼可复用的代码、规划逻辑流程。

 所以，如果真的是从零开始，别想太多了
 */

//        canvas.drawLine(0,0,0,height,testPaint);
//        canvas.drawLine(width,0,width,height,testPaint);





        //绘制外圈圆
        canvas.drawCircle(width / 2, height / 2, length / 2 - circleBorderWidth, circlePaint);


    }

    public void  animThread(){
        new Thread(){
            @Override
            public void run() {

                while (openAnim){
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (offset>radious){
                        offset=offset-radious+10;
                    }else {
                        offset=offset+10;
                    }
                    postInvalidate();
                }
            }
        }.start();
    }



}
