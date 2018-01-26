package com.kimonic.myutilsproject.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * * ===============================================================
 * name:             VerificationCodeView
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/1/25
 * description：  验证码生成view,控件宽高比最好为3:1
 * history：
 * *==================================================================
 */

public class VerificationCodeView extends View {

    /**
     * 生成的并显示的验证码
     */
    private String showCode = "";
    /**
     * 验证码画笔
     */
    private Paint codePaint;

    /**
     * 圆角矩形画笔
     */
    private Paint bacPaint;
    /**
     * 背景圆角矩形
     */
    private RectF rectF;

    /**
     * 文字矩形
     */
    private Rect bounds;
    /**背景角矩形圆角半径*/
    private float radious=6;

    public String getShowCode() {
        return showCode;
    }

    public void setShowCode(String showCode) {
        this.showCode = showCode;
    }

    public VerificationCodeView(Context context) {
        this(context, null, 0);
    }

    public VerificationCodeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VerificationCodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @TargetApi(21)
    public VerificationCodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
    }

    private void initView() {
        rectF = new RectF();
        bounds = new Rect();

        showCode = generateCode();

        codePaint = new Paint();
        codePaint.setAntiAlias(true);
        codePaint.setColor(Color.parseColor("#46B5E5"));
        codePaint.setStyle(Paint.Style.FILL);


        bacPaint = new Paint();
        bacPaint.setAntiAlias(true);
        bacPaint.setColor(Color.WHITE);
        bacPaint.setStyle(Paint.Style.FILL);
        bacPaint.setStrokeWidth(10);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();

        rectF.top = 0;
        rectF.left = 0;
        rectF.right = width;
        rectF.bottom = height;
        canvas.drawRoundRect(rectF, radious, radious, bacPaint);

        codePaint.setTextSize(height * 0.6f);

        float textLength = codePaint.measureText(showCode);
        float spacing = (width - textLength) / 3;

        float startX = width * 0.15f;
        float startY = height * 0.7f;


        for (int i = 0; i < 4; i++) {
            codePaint.getTextBounds(String.valueOf(showCode.charAt(i)), 0, 1, bounds);//获取文字的实际大小
            canvas.save();//文字绘制以左下角的点为基准
            canvas.rotate(getDegress(), startX + spacing * i + Math.abs(bounds.left - bounds.right) / 2, startY - Math.abs(bounds.bottom - bounds.top) / 2);
            canvas.drawText(String.valueOf(showCode.charAt(i)), startX + spacing * i, startY, codePaint);
            canvas.restore();
        }


    }

    private float getDegress() {
        return (float) (Math.pow(-1, (int) (Math.random() * 10)) * Math.random() * 30);
    }

    private String generateCode() {
        return String.valueOf((int) (Math.random() * 10)) +
                (int) (Math.random() * 10) +
                (int) (Math.random() * 10) +
                (int) (Math.random() * 10);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                return true;
            case MotionEvent.ACTION_UP:
                showCode = generateCode();
                invalidate();
                return true;
        }
        return super.onTouchEvent(event);
    }
}
