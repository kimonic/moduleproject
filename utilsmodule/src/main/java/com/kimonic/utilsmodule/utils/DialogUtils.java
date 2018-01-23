package com.kimonic.utilsmodule.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.kimonic.utilsmodule.R;


/**
 * * ================================================
 * name:            DialogUtils
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：            2017/7/25
 * description： dialog辅助工具类
 * history：
 * ===================================================
 */

public class DialogUtils {


    /**
     * /**
     * 展示土豆进度dialog
     *
     * @param context 上下文
     * @param msg     点击back键的提示信息
     * @return alertdialog
     */
    public static AlertDialog showProgreessDialog(final Context context, final String msg) {
        @SuppressLint("InflateParams") View view = LayoutInflater.from(context).inflate(R.layout.dialog_progress, null);
        AlertDialog dialog = new AlertDialog.Builder(context).create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            private long beforeTime;

            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == MotionEvent.ACTION_UP) {
                    if (System.currentTimeMillis() - beforeTime < 2000) {
                        ((Activity) context).finish();
                    } else {
                        ToastUtils.showToast(context, msg);
                        beforeTime = System.currentTimeMillis();
                    }
                    return true;
                } else {
                    return false; //默认返回 false
                }
            }
        });
        dialog.show();
        //一定得在show完dialog后来set属性
        Window window = dialog.getWindow();
        if (window != null) {
            window.setContentView(view);
            WindowManager.LayoutParams lp = window.getAttributes();
//            Log.e(TAG, "showProgreessDialog: --ScreenSizeUtils.getDensity(this)-"+ ScreenSizeUtils.getDensity(this));
            int wh = 90 * ScreenSizeUtils.getDensity(context);
            lp.width = wh;
            lp.height = wh;
            lp.gravity = Gravity.CENTER;
            window.setAttributes(lp);
        }
        return dialog;
    }



}
