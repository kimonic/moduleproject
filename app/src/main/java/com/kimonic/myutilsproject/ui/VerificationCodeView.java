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

/**
 * * ===============================================================
 * name:             VerificationCodeView
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/1/25
 * description：  验证码生成view
 * history：
 * *==================================================================
 */

public class VerificationCodeView extends View {

    /**生成的并显示的验证码*/
    private String showCode="";
    /**验证码画笔*/
    private Paint codePaint;
    /**文本绘制的路径*/
    private Path path;
    /**圆角矩形画笔*/
    private Paint bacPaint;
    /**背景圆角矩形*/
    private RectF rectF;

    private StringBuilder builder;

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
        rectF=new RectF();
        builder=new StringBuilder();

        showCode=generateCode();
        Log.e("TAG", "initView: VerificationCodeView-----"+showCode);


        path=new Path();

        codePaint=new Paint();
        codePaint.setAntiAlias(true);
        codePaint.setColor(Color.parseColor("#46B5E5"));
        codePaint.setStyle(Paint.Style.FILL);

        bacPaint=new Paint();
        bacPaint.setAntiAlias(true);
        bacPaint.setColor(Color.WHITE);
        bacPaint.setStyle(Paint.Style.FILL);
        bacPaint.setStrokeWidth(10);



    }

    @Override
    protected void onDraw(Canvas canvas) {
        int width=getWidth();
        int height=getHeight();
        rectF.top=0;
        rectF.left=0;
        rectF.right=width;
        rectF.bottom=height;
        canvas.drawRoundRect(rectF,6,6,bacPaint);
        codePaint.setTextSize(height*0.6f);

        float  textLength=codePaint.measureText(showCode);
        float  spacing=(width-textLength)/3;

        float  startX=width*0.2f;
        float startY=height*0.8f;

        path.moveTo(startX,height/2);
        path.lineTo(startX+30,height*0.8f);


        canvas.drawTextOnPath(String.valueOf(showCode.charAt(0)),path,0,0,codePaint);
        canvas.drawText(String.valueOf(showCode.charAt(1)),startX+spacing,startY,codePaint);
//        canvas.drawText(String.valueOf(showCode.charAt(2)),startX,startY,codePaint);
//        canvas.drawText(String.valueOf(showCode.charAt(3)),startX,startY,codePaint);


//        canvas.drawText(String.valueOf(showCode.charAt(0)),startX,startY,codePaint);
//        canvas.save();
//        canvas.rotate(-15,width/2,height/2);
//        canvas.restore();
//
//        canvas.drawText(String.valueOf(showCode.charAt(1)),startX+spacing,startY,codePaint);
//
//        canvas.save();
//        canvas.rotate(15,width/2,(startX+spacing*2)/2);
//        canvas.drawText(String.valueOf(showCode.charAt(2)),startX+spacing*2,startY,codePaint);
//        canvas.restore();
//
//        canvas.save();
//        canvas.rotate(-15,width/2,height+100);
//        canvas.drawText(String.valueOf(showCode.charAt(3)),startX+spacing*3,startY,codePaint);
//        canvas.restore();



//        canvas.drawCircle(width/2,height/2,width/2-10,codePaint);
//
//        canvas.save();
//        canvas.drawLine(width/2,height/2-width/2,width/2,height/2-width/2+150,bacPaint);
//        canvas.rotate(90,width/2,height/2);
//        canvas.restore();
//
//        canvas.save();
//        canvas.drawLine(width/2,height/2-width/2,width/2,height/2-width/2+150,bacPaint);
//        canvas.rotate(180,width/2,height/2);
//        canvas.restore();
//
//
//        canvas.drawLine(width/2,height/2-width/2,width/2,height/2-width/2+150,bacPaint);
//        canvas.save();
//        canvas.rotate(270,width/2,height/2);
//        canvas.restore();
//
//        canvas.save();
//        canvas.drawLine(width/2,height/2-width/2,width/2,height/2-width/2+150,bacPaint);
//        canvas.rotate(360,width/2,height/2);
//        canvas.restore();

//        canvas.save();
//        canvas.restore();
//
//        canvas.save();
//        canvas.restore();
//
//
//        canvas.save();
//        canvas.restore();



    }

    private String generateCode(){
        return builder.append((int)(Math.random()*10))
                .append((int)(Math.random()*10))
                .append((int)(Math.random()*10))
                .append((int)(Math.random()*10)).toString();
    }
}
