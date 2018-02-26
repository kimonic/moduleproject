package com.kimonic.notebook.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.kimonic.notebook.mapp.MApp;

import java.util.ArrayList;
import java.util.List;

/**
 * * ===============================================================
 * name:             BubbleView
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/24
 * description：
 * history：
 * *==================================================================
 */

public class BubbleView extends View {

    private float x = 0, y = 0;
    private int width;
    private int height;
    private boolean flag = true;
    private Paint paint;
    private Paint paintRed;
    private boolean increasing = true;
    private List<Float> listX;
    private List<Float> listY;
    private int position = 0;
    private float radius = 10;
    private boolean radiusFlag = true;

    public BubbleView(Context context) {
        this(context, null, 0);
    }

    public BubbleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BubbleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @TargetApi(21)
    public BubbleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
    }

    private void initView() {
        width = MApp.DEVICE_WIDTH;
        height = MApp.DEVICE_HEIGHT;

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GREEN);

        paintRed = new Paint();
        paintRed.setAntiAlias(true);
        paintRed.setStyle(Paint.Style.FILL);
        paintRed.setColor(Color.RED);
//        x = width / 2;
        x = 0;
        listX = new ArrayList<>();
        listY = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            listX.add((float) i);
            listY.add((float) (100 * Math.sin(i * Math.PI / 180)));
        }
        start();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (int i = 0; i < listX.size(); i++) {
            canvas.drawCircle(listX.get(i), listY.get(i) + 800, 2, paint);
//            canvas.drawPoint(listX.get(i), listY.get(i)+800,paint);

        }
        canvas.drawCircle(listX.get(position), listY.get(position) + 800, radius, paintRed);

    }

    private void start() {
        new Thread() {
            @Override
            public void run() {
                while (flag) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    position++;
                    if (increasing) {
                        position = position + 5;
                    } else {
                        position = position - 5;
                    }
                    if (position > width-1) {
                        increasing = false;
                        position = width - 1;
                    } else if (position < 1) {
                        increasing = true;
                        position = 0;
                    }

                    if (radius < 10) {
                        radiusFlag = true;
                    } else if (radius > 30) {
                        radiusFlag = false;
                    }


                    if (radiusFlag) {
                        radius = radius + 1;
                    } else {
                        radius = radius - 1;
                    }
//                    y = (float) (600 * Math.sin(x / Math.PI * 180));
                    postInvalidate();


                    /**
                     * 二次方公式
                     二次方贝兹曲线的路径由给定点P0、P1、P2的函数B（t）追踪：
                     b(t)=(1-t)^2P0+2t(1-t)P1+t*t*p2,t-->[0,1]
                     TrueType字型就运用了以贝兹样条组成的二次贝兹曲线。
                     public static PointF CalculateBezierPointForQuadratic(float t, PointF p0, PointF p1, PointF p2) {
                     PointF point = new PointF();
                     float temp = 1 - t;
                     point.x = temp * temp * p0.x + 2 * t * temp * p1.x + t * t * p2.x;
                     point.y = temp * temp * p0.y + 2 * t * temp * p1.y + t * t * p2.y;
                     return point;
                     }
                     y=ax+b
                     py0=a*px0+b
                     py1=a*px1+b
                     a=(py0-py1)/(px0-px1)

                     PT.x = powf(1 - t, 3) * P1.x + 3.0f * powf(1 - t, 2) * t * P2.x + 3.0f * (1 - t) * t * t * P3.x + t * t * t * P4.x;
                     PT.y = powf(1 - t, 3) * P1.y + 3.0f * powf(1 - t, 2) * t * P2.y + 3.0f * (1 - t) * t * t * P3.y + t * t * t * P4.y;
                     注：
                     t >= 0, t < 1;
                     powf(x, y) 是计算以x为底数的y次幂。
                     追问
                     谢谢你的回答，很抽象  最后贝塞尔曲线方程到底是怎么样的呢
                     */


                }

            }
        }.start();
    }
}