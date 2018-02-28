package com.kimonic.utilsmodule.utils;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Event;
import android.provider.ContactsContract.CommonDataKinds.Im;
import android.provider.ContactsContract.CommonDataKinds.Nickname;
import android.provider.ContactsContract.CommonDataKinds.Note;
import android.provider.ContactsContract.CommonDataKinds.Organization;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.provider.ContactsContract.CommonDataKinds.StructuredPostal;
import android.provider.ContactsContract.CommonDataKinds.Website;
import android.provider.ContactsContract.Data;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
     * 通过apk的存储目录安装apk，返回安装apk的intent
     */
    public static Intent installApk(Context context, String apkPath) {
        if (context == null || TextUtils.isEmpty(apkPath)) {
            return null;
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
        return intent;
        /**
         * *****************apk的下载及安装**************************************
         *
         *
         *
         *
         *  private NotificationManager manager;
         *  private int Notification_ID = 0;
         *  private Notification.Builder builder;
         *   private Notification notification;
         *   private String filePath;


         *   String url = "http://app.mi.com/download/26";//apk下载地址
         *  final String dir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/.apkdownload";//apk存储目录,隐藏文件夹,不存在时okgo会自动创建
         *  final String fileName = "mydownload.apk";//下载的apk保存文件名,固定名字,重复下载时会被后下载的版本覆盖
         *   filePath = dir + "/" + fileName;//apk文件的全路径
         *    File file = new File(filePath);//根据路径创建apk的File文件
         *   //      NotificationManager导入的包名  import android.app.NotificationManager;
         *    manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);//通过服务获取通知管理者
         *   showNotification();
         *   if (file.exists()) {//检测文件是否存在,存在则直接安装
         *    //此处进行文件及版本检查,如果当前存在的是最新版本的apk,则直接安装无须下载
         *    AppKidUtils.installApk(HomeActivity.this, filePath);
         *    } else {//不存在进行下载
         *   HttpUtils.getInstance().downloadFile(url, new FileCallback(dir, fileName) {//使用okgo的文件下载下载apk
         *      @Override
         *    public void onSuccess(Response<File> response) {//下载成功后打开安装界面
         *   startActivity(AppKidUtils.installApk(HomeActivity.this,filePath));
         *    }

         *   @Override
         *    public void downloadProgress(final Progress progress) {//下载进度更新
         *    Log.e("HttpUtils", "downloadProgress: -下载进度----" + progress.fraction);
         *    int progressInt=(int) (progress.fraction * 100);//下载进度转换为整数
         *    if (progressInt<100){
         *    manager.notify(Notification_ID, builder.setProgress(100, progressInt, false).build());//更新通知
         *    }else {
         *    builder.setProgress(100, 100, false);
         *    builder.setContentTitle("下载已完成");//设置标题
         *    builder.setContentText("点击安装");//设置通知内容
         *     manager.notify(Notification_ID, builder.build());//更新通知,当通知的id相同时即为更新通知
         *    }
         *    super.downloadProgress(progress);
         *    }

         *   @Override
         *    public void onError(Response<File> response) {//下载出错回调
         *    super.onError(response);
         *    Log.e("HttpUtils", "downloadProgress: -未知错误----" + response.toString());
         *    }
         *     });

         *    }



         *    private void showNotification() {
         *  //   Notification导入的包名     import android.app.Notification;
         *  builder = new Notification.Builder(this);
         *  builder.setSmallIcon(R.mipmap.ic_launcher);//设置图标
         *  builder.setTicker("正在下载");//手机状态栏的提示
         *  builder.setContentTitle("正在下载土豆金服app");//设置标题
         *  builder.setContentText("正在下载");//设置通知内容
         *  builder.setWhen(System.currentTimeMillis());//设置通知时间
         *  Intent intent = AppKidUtils.installApk(this, filePath);//获取安装apk的intent
         *  PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);//点击通知打开的activity
         *  builder.setContentIntent(pendingIntent);//点击后的意图
         *   builder.setDefaults(Notification.DEFAULT_LIGHTS);//设置指示灯
         *  builder.setDefaults(Notification.DEFAULT_SOUND);//设置提示声音
         *  builder.setDefaults(Notification.DEFAULT_VIBRATE);//设置震动
         *  builder.setProgress(100, 0, false);
         *   notification = builder.build();//4.1以上，以下要用getNotification()
         *   manager.notify(Notification_ID, notification);//显示通知
         *    }
         *
         */
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

    /**
     *
     */
    private void temp() {

    }

    public static String getContactInfo(Context context,JSONObject jsonObject) throws JSONException {
        // 获得通讯录信息 ，URI是ContactsContract.Contacts.CONTENT_URI
        List list = new ArrayList<ContactsContract.Contacts>();
        JSONObject contactData = new JSONObject();
        String mimetype = "";
        int oldrid = -1;
        int contactId = -1;
        Cursor cursor = context.getContentResolver().query(Data.CONTENT_URI, null, null, null, Data.RAW_CONTACT_ID);
        int numm = 0;
        while (cursor.moveToNext()) {
            contactId = cursor.getInt(cursor.getColumnIndex(Data.RAW_CONTACT_ID));
            if (oldrid != contactId) {
                jsonObject = new JSONObject();
                contactData.put("contact" + numm, jsonObject);
                numm++;
                oldrid = contactId;
            }

            // 取得mimetype类型
            mimetype = cursor.getString(cursor.getColumnIndex(Data.MIMETYPE));
            // 获得通讯录中每个联系人的ID
            // 获得通讯录中联系人的名字
            if (StructuredName.CONTENT_ITEM_TYPE.equals(mimetype)) {
//    String display_name = cursor.getString(cursor.getColumnIndex(StructuredName.DISPLAY_NAME));
                String prefix = cursor.getString(cursor.getColumnIndex(StructuredName.PREFIX));
                jsonObject.put("prefix", prefix);
                String firstName = cursor.getString(cursor.getColumnIndex(StructuredName.FAMILY_NAME));
                jsonObject.put("firstName", firstName);
                String middleName = cursor.getString(cursor.getColumnIndex(StructuredName.MIDDLE_NAME));
                jsonObject.put("middleName", middleName);
                String lastname = cursor.getString(cursor.getColumnIndex(StructuredName.GIVEN_NAME));
                jsonObject.put("lastname", lastname);
                String suffix = cursor.getString(cursor.getColumnIndex(StructuredName.SUFFIX));
                jsonObject.put("suffix", suffix);
                String phoneticFirstName = cursor.getString(cursor.getColumnIndex(StructuredName.PHONETIC_FAMILY_NAME));
                jsonObject.put("phoneticFirstName", phoneticFirstName);
                String phoneticMiddleName = cursor.getString(cursor.getColumnIndex(StructuredName.PHONETIC_MIDDLE_NAME));
                jsonObject.put("phoneticMiddleName", phoneticMiddleName);
                String phoneticLastName = cursor.getString(cursor.getColumnIndex(StructuredName.PHONETIC_GIVEN_NAME));
                jsonObject.put("phoneticLastName", phoneticLastName);
            }
            // 获取电话信息
            if (Phone.CONTENT_ITEM_TYPE.equals(mimetype)) {
                // 取出电话类型
                int phoneType = cursor.getInt(cursor.getColumnIndex(Phone.TYPE));
                // 手机
                if (phoneType == Phone.TYPE_MOBILE) {
                    String mobile = cursor.getString(cursor.getColumnIndex(Phone.NUMBER));
                    jsonObject.put("mobile", mobile);
                }
                // 住宅电话
                if (phoneType == Phone.TYPE_HOME) {
                    String homeNum = cursor.getString(cursor.getColumnIndex(Phone.NUMBER));
                    jsonObject.put("homeNum", homeNum);
                }
                // 单位电话
                if (phoneType == Phone.TYPE_WORK) {
                    String jobNum = cursor.getString(cursor.getColumnIndex(Phone.NUMBER));
                    jsonObject.put("jobNum", jobNum);
                }
                // 单位传真
                if (phoneType == Phone.TYPE_FAX_WORK) {
                    String workFax = cursor.getString(cursor.getColumnIndex(Phone.NUMBER));
                    jsonObject.put("workFax", workFax);
                }
                // 住宅传真
                if (phoneType == Phone.TYPE_FAX_HOME) {
                    String homeFax = cursor.getString(cursor.getColumnIndex(Phone.NUMBER));
                    jsonObject.put("homeFax", homeFax);
                }
                // 寻呼机
                if (phoneType == Phone.TYPE_PAGER) {
                    String pager = cursor.getString(cursor.getColumnIndex(Phone.NUMBER));
                    jsonObject.put("pager", pager);
                }
                // 回拨号码
                if (phoneType == Phone.TYPE_CALLBACK) {
                    String quickNum = cursor.getString(cursor.getColumnIndex(Phone.NUMBER));
                    jsonObject.put("quickNum", quickNum);
                }
                // 公司总机
                if (phoneType == Phone.TYPE_COMPANY_MAIN) {
                    String jobTel = cursor.getString(cursor.getColumnIndex(Phone.NUMBER));
                    jsonObject.put("jobTel", jobTel);
                }
                // 车载电话
                if (phoneType == Phone.TYPE_CAR) {
                    String carNum = cursor.getString(cursor.getColumnIndex(Phone.NUMBER));
                    jsonObject.put("carNum", carNum);
                }
                // ISDN
                if (phoneType == Phone.TYPE_ISDN) {
                    String isdn = cursor.getString(cursor.getColumnIndex(Phone.NUMBER));
                    jsonObject.put("isdn", isdn);
                }
                // 总机
                if (phoneType == Phone.TYPE_MAIN) {
                    String tel = cursor.getString(cursor.getColumnIndex(Phone.NUMBER));
                    jsonObject.put("tel", tel);
                }
                // 无线装置
                if (phoneType == Phone.TYPE_RADIO) {
                    String wirelessDev = cursor.getString(cursor.getColumnIndex(Phone.NUMBER));
                    jsonObject.put("wirelessDev", wirelessDev);
                }
                // 电报
                if (phoneType == Phone.TYPE_TELEX) {
                    String telegram = cursor.getString(cursor.getColumnIndex(Phone.NUMBER));
                    jsonObject.put("telegram", telegram);
                }
                // TTY_TDD
                if (phoneType == Phone.TYPE_TTY_TDD) {
                    String tty_tdd = cursor.getString(cursor.getColumnIndex(Phone.NUMBER));
                    jsonObject.put("tty_tdd", tty_tdd);
                }
                // 单位手机
                if (phoneType == Phone.TYPE_WORK_MOBILE) {
                    String jobMobile = cursor.getString(cursor.getColumnIndex(Phone.NUMBER));
                    jsonObject.put("jobMobile", jobMobile);
                }
                // 单位寻呼机
                if (phoneType == Phone.TYPE_WORK_PAGER) {
                    String jobPager = cursor.getString(cursor.getColumnIndex(Phone.NUMBER));
                    jsonObject.put("jobPager", jobPager);
                }
                // 助理
                if (phoneType == Phone.TYPE_ASSISTANT) {
                    String assistantNum = cursor.getString(cursor.getColumnIndex(Phone.NUMBER));
                    jsonObject.put("assistantNum", assistantNum);
                }
                // 彩信
                if (phoneType == Phone.TYPE_MMS) {
                    String mms = cursor.getString(cursor.getColumnIndex(Phone.NUMBER));
                    jsonObject.put("mms", mms);
                }
            }
            // }
            // 查找email地址
            if (Email.CONTENT_ITEM_TYPE.equals(mimetype)) {
                // 取出邮件类型
                int emailType = cursor.getInt(cursor.getColumnIndex(Email.TYPE));

                // 住宅邮件地址
                if (emailType == Email.TYPE_CUSTOM) {
                    String homeEmail = cursor.getString(cursor.getColumnIndex(Email.DATA));
                    jsonObject.put("homeEmail", homeEmail);
                }

                // 住宅邮件地址
                else if (emailType == Email.TYPE_HOME) {
                    String homeEmail = cursor.getString(cursor.getColumnIndex(Email.DATA));
                    jsonObject.put("homeEmail", homeEmail);
                }
                // 单位邮件地址
                if (emailType == Email.TYPE_CUSTOM) {
                    String jobEmail = cursor.getString(cursor.getColumnIndex(Email.DATA));
                    jsonObject.put("jobEmail", jobEmail);
                }

                // 单位邮件地址
                else if (emailType == Email.TYPE_WORK) {
                    String jobEmail = cursor.getString(cursor.getColumnIndex(Email.DATA));
                    jsonObject.put("jobEmail", jobEmail);
                }
                // 手机邮件地址
                if (emailType == Email.TYPE_CUSTOM) {
                    String mobileEmail = cursor.getString(cursor.getColumnIndex(Email.DATA));
                    jsonObject.put("mobileEmail", mobileEmail);
                }

                // 手机邮件地址
                else if (emailType == Email.TYPE_MOBILE) {
                    String mobileEmail = cursor.getString(cursor.getColumnIndex(Email.DATA));
                    jsonObject.put("mobileEmail", mobileEmail);
                }
            }
            // 查找event地址
            if (Event.CONTENT_ITEM_TYPE.equals(mimetype)) {
                // 取出时间类型
                int eventType = cursor.getInt(cursor.getColumnIndex(Event.TYPE));
                // 生日
                if (eventType == Event.TYPE_BIRTHDAY) {
                    String birthday = cursor.getString(cursor.getColumnIndex(Event.START_DATE));
                    jsonObject.put("birthday", birthday);
                }
                // 周年纪念日
                if (eventType == Event.TYPE_ANNIVERSARY) {
                    String anniversary = cursor.getString(cursor.getColumnIndex(Event.START_DATE));
                    jsonObject.put("anniversary", anniversary);
                }
            }
            // 即时消息
            if (Im.CONTENT_ITEM_TYPE.equals(mimetype)) {
                // 取出即时消息类型
                int protocal = cursor.getInt(cursor.getColumnIndex(Im.PROTOCOL));
                if (Im.TYPE_CUSTOM == protocal) {
                    String workMsg = cursor.getString(cursor.getColumnIndex(Im.DATA));
                    jsonObject.put("workMsg", workMsg);
                } else if (Im.PROTOCOL_MSN == protocal) {
                    String workMsg = cursor.getString(cursor.getColumnIndex(Im.DATA));
                    jsonObject.put("workMsg", workMsg);
                }
                if (Im.PROTOCOL_QQ == protocal) {
                    String instantsMsg = cursor.getString(cursor.getColumnIndex(Im.DATA));
                    jsonObject.put("instantsMsg", instantsMsg);
                }
            }
            // 获取备注信息
            if (Note.CONTENT_ITEM_TYPE.equals(mimetype)) {
                String remark = cursor.getString(cursor.getColumnIndex(Note.NOTE));
                jsonObject.put("remark", remark);
            }
            // 获取昵称信息
            if (Nickname.CONTENT_ITEM_TYPE.equals(mimetype)) {
                String nickName = cursor.getString(cursor.getColumnIndex(Nickname.NAME));
                jsonObject.put("nickName", nickName);
            }
            // 获取组织信息
            if (Organization.CONTENT_ITEM_TYPE.equals(mimetype)) {
                // 取出组织类型
                int orgType = cursor.getInt(cursor.getColumnIndex(Organization.TYPE));
                // 单位
                if (orgType == Organization.TYPE_CUSTOM) {
//     if (orgType == Organization.TYPE_WORK) {
                    String company = cursor.getString(cursor.getColumnIndex(Organization.COMPANY));
                    jsonObject.put("company", company);
                    String jobTitle = cursor.getString(cursor.getColumnIndex(Organization.TITLE));
                    jsonObject.put("jobTitle", jobTitle);
                    String department = cursor.getString(cursor.getColumnIndex(Organization.DEPARTMENT));
                    jsonObject.put("department", department);
                }
            }
            // 获取网站信息
            if (Website.CONTENT_ITEM_TYPE.equals(mimetype)) {
                // 取出组织类型
                int webType = cursor.getInt(cursor.getColumnIndex(Website.TYPE));
                // 主页
                if (webType == Website.TYPE_CUSTOM) {
                    String home = cursor.getString(cursor.getColumnIndex(Website.URL));
                    jsonObject.put("home", home);
                }
                // 主页
                else if (webType == Website.TYPE_HOME) {
                    String home = cursor.getString(cursor.getColumnIndex(Website.URL));
                    jsonObject.put("home", home);
                }

                // 个人主页
                if (webType == Website.TYPE_HOMEPAGE) {
                    String homePage = cursor.getString(cursor.getColumnIndex(Website.URL));
                    jsonObject.put("homePage", homePage);
                }
                // 工作主页
                if (webType == Website.TYPE_WORK) {
                    String workPage = cursor.getString(cursor.getColumnIndex(Website.URL));
                    jsonObject.put("workPage", workPage);
                }
            }
            // 查找通讯地址
            if (StructuredPostal.CONTENT_ITEM_TYPE.equals(mimetype)) {
                // 取出邮件类型
                int postalType = cursor.getInt(cursor.getColumnIndex(StructuredPostal.TYPE));
                // 单位通讯地址
                if (postalType == StructuredPostal.TYPE_WORK) {
                    String street = cursor.getString(cursor.getColumnIndex(StructuredPostal.STREET));
                    jsonObject.put("street", street);
                    String ciry = cursor.getString(cursor.getColumnIndex(StructuredPostal.CITY));
                    jsonObject.put("ciry", ciry);
                    String box = cursor.getString(cursor.getColumnIndex(StructuredPostal.POBOX));
                    jsonObject.put("box", box);
                    String area = cursor.getString(cursor.getColumnIndex(StructuredPostal.NEIGHBORHOOD));
                    jsonObject.put("area", area);
                    String state = cursor.getString(cursor.getColumnIndex(StructuredPostal.REGION));
                    jsonObject.put("state", state);
                    String zip = cursor.getString(cursor.getColumnIndex(StructuredPostal.POSTCODE));
                    jsonObject.put("zip", zip);
                    String country = cursor.getString(cursor.getColumnIndex(StructuredPostal.COUNTRY));
                    jsonObject.put("country", country);
                }
                // 住宅通讯地址
                if (postalType == StructuredPostal.TYPE_HOME) {
                    String homeStreet = cursor.getString(cursor.getColumnIndex(StructuredPostal.STREET));
                    jsonObject.put("homeStreet", homeStreet);
                    String homeCity = cursor.getString(cursor.getColumnIndex(StructuredPostal.CITY));
                    jsonObject.put("homeCity", homeCity);
                    String homeBox = cursor.getString(cursor.getColumnIndex(StructuredPostal.POBOX));
                    jsonObject.put("homeBox", homeBox);
                    String homeArea = cursor.getString(cursor.getColumnIndex(StructuredPostal.NEIGHBORHOOD));
                    String homeState = cursor.getString(cursor.getColumnIndex(StructuredPostal.REGION));
                    jsonObject.put("homeState", homeState);
                    String homeZip = cursor.getString(cursor.getColumnIndex(StructuredPostal.POSTCODE));
                    jsonObject.put("homeZip", homeZip);
                    String homeCountry = cursor.getString(cursor.getColumnIndex(StructuredPostal.COUNTRY));
                    jsonObject.put("homeCountry", homeCountry);
                }
                // 其他通讯地址
                if (postalType == StructuredPostal.TYPE_OTHER) {
                    String otherStreet = cursor.getString(cursor.getColumnIndex(StructuredPostal.STREET));
                    jsonObject.put("otherStreet", otherStreet);
                    String otherCity = cursor.getString(cursor.getColumnIndex(StructuredPostal.CITY));
                    jsonObject.put("otherCity", otherCity);
                    String otherBox = cursor.getString(cursor.getColumnIndex(StructuredPostal.POBOX));
                    jsonObject.put("otherBox", otherBox);
                    String otherArea = cursor.getString(cursor.getColumnIndex(StructuredPostal.NEIGHBORHOOD));
                    jsonObject.put("otherArea", otherArea);
                    String otherState = cursor.getString(cursor.getColumnIndex(StructuredPostal.REGION));
                    jsonObject.put("otherState", otherState);
                    String otherZip = cursor.getString(cursor.getColumnIndex(StructuredPostal.POSTCODE));
                    jsonObject.put("otherZip", otherZip);
                    String otherCountry = cursor.getString(cursor.getColumnIndex(StructuredPostal.COUNTRY));
                    jsonObject.put("otherCountry", otherCountry);
                }
            }
        }
        cursor.close();
        return contactData.toString();
    }
}
