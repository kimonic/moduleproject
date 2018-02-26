package com.kimonic.utilsmodule.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;

import java.io.File;

/**
 * * ===============================================================
 * name:             AppKidUtils
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/26
 * description：  APP工具辅助类
 * history：
 * *==================================================================
 */

public class AppKidUtils {

    /**
     * 通过apk的存储目录安装apk
     */
    public static void installApk(Context context, String apkPath) {
        if (context == null || TextUtils.isEmpty(apkPath)) {
            return;
        }


        File file = new File(apkPath);
        Intent intent = new Intent(Intent.ACTION_VIEW);

        //判读版本是否在7.0以上
        if (Build.VERSION.SDK_INT >= 24) {
            //provider authorities
            Uri apkUri = FileProvider.getUriForFile(context, "com.mydomain.fileprovider", file);
            //Granting Temporary Permissions to a URI
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        }

        context.startActivity(intent);
    }

    /**
     * 卸载应用程序,无法卸载系统级apk
     */
    public void uninstallApp(Context context, String packageName) {
        Intent uninstall_intent = new Intent();
        uninstall_intent.setAction(Intent.ACTION_DELETE);
        uninstall_intent.setData(Uri.parse("package:" + packageName));
        context.startActivity(uninstall_intent);
    }
}
