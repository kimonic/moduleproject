package com.kimonic.notebook.activity.fixedassets;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.kimonic.notebook.R;
import com.kimonic.notebook.activity.CompareDataActivity;
import com.kimonic.notebook.backup.BackupUtil;
import com.kimonic.notebook.litemapbean.fixedassets.BackupsBean;
import com.kimonic.notebook.litemapbean.fixedassets.DataNameTableLMBean;
import com.kimonic.notebook.litemapbean.fixedassets.DateRecordLMBean;
import com.kimonic.notebook.litemapbean.fixedassets.ItemFlagLMBean;
import com.kimonic.notebook.litemapbean.fixedassets.SaveDataLMBean;
import com.kimonic.notebook.mapp.MApp;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.ui.MTopBarView;
import com.kimonic.utilsmodule.utils.FileUtils;
import com.kimonic.utilsmodule.utils.ToastUtils;
import com.lzy.okgo.model.Response;

import java.util.List;

import butterknife.BindView;

/**
 * * ===============================================================
 * name:             FixedAssetsActivity
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/8
 * description：  固定资产记录activity
 * history：
 * *==================================================================
 */

public class FixedAssetsActivity extends BaseActivity {
    @BindView(R.id.mtb_act_fixedassets)
    MTopBarView mtb;
    @BindView(R.id.tv_act_fixedassets_chakangudingzichan)
    TextView tvLook;
    @BindView(R.id.tv_act_fixedassets_jilugudingzichan)
    TextView tvTakeNotes;
    @BindView(R.id.tv_act_fixedassets_gudingzichanjiluchaxun)
    TextView tvQuery;
    @BindView(R.id.tv_act_fixedassets_daochugudingzichanjilu)
    TextView tvExport;
    @BindView(R.id.tv_act_fixedassets_daorugudingzichanjilu)
    TextView tvImport;

    @BindView(R.id.tv_act_fixedassets_duibizichanjilu)
    TextView tvCompare;


    @Override
    public int getLayoutResId() {
        return R.layout.act_fixedassets;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_act_fixedassets_chakangudingzichan://查看
                openActivity(FindDataActivity.class);
                break;
            case R.id.tv_act_fixedassets_jilugudingzichan://记录
                openActivity(SaveDataActivity.class);
                break;
            case R.id.tv_act_fixedassets_gudingzichanjiluchaxun://查询
                openActivity(QueryDataActivity.class);
                break;
            case R.id.tv_act_fixedassets_daochugudingzichanjilu://导出
                BackupUtil.savaZiChan(this);
                //gson到处某个Java对象时排除某个字段不导出的配置策略
//                ExclusionStrategy myExclusionStrategy = new ExclusionStrategy() {
//                    @Override
//                    public boolean shouldSkipField(FieldAttributes fa) {
//                        return fa.getName().startsWith("baseObjId");
//                    }
//
//                    @Override
//                    public boolean shouldSkipClass(Class<?> clazz) {
//                        return false;
//                    }
//                };
//
//                Gson gson = new GsonBuilder().setExclusionStrategies(myExclusionStrategy).create();
//
//                BackupsBean bean = new BackupsBean();
//                List<SaveDataLMBean> list = DataSupport.findAll(SaveDataLMBean.class);
//                List<DataNameTableLMBean> list1 = DataSupport.findAll(DataNameTableLMBean.class);
//                List<ItemFlagLMBean> list2 = DataSupport.findAll(ItemFlagLMBean.class);
//                List<DateRecordLMBean> list3 = DataSupport.findAll(DateRecordLMBean.class);
//                bean.setListSaveData(list);
//                bean.setListDataNameTable(list1);
//                bean.setListItemFlag(list2);
//                bean.setListDateRecord(list3);
//
//                String json = gson.toJson(bean);
//                FileUtils.saveJsonToSDCard(this, "notebookbackup", TimeUtils.getNowDateShort() + "notebook.txt", json);
                break;
            case R.id.tv_act_fixedassets_duibizichanjilu://对比
                openActivity(CompareDataActivity.class);
                break;
            case R.id.tv_act_fixedassets_daorugudingzichanjilu://导入
//                String json1=FileUtils.readFileContent();
                //发送短信
//                Intent sms = new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:18765218309"));
//                startActivity(sms);
                openFileManager();
                break;
        }
    }

    /**
     * 打开文件管理器
     */
    private void openFileManager() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        //intent.setType(“image/*”);//选择图片
        //intent.setType(“audio/*”); //选择音频
        //intent.setType(“video/*”); //选择视频 （mp4 3gp 是android支持的视频格式）
        //intent.setType(“video/*;image/*”);//同时选择视频和图片
        intent.setType("*/*");//无类型限制
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, 1);
    }

    @Override
    public void initDataFromIntent() {

    }

    @Override
    public void initView() {
        setTopMargin(mtb, MApp.STATUS_BAE_HEIGHT);
    }

    @Override
    public void initListener() {
        setCloseLisenter(mtb);

        tvLook.setOnClickListener(this);
        tvTakeNotes.setOnClickListener(this);
        tvQuery.setOnClickListener(this);
        tvExport.setOnClickListener(this);
        tvCompare.setOnClickListener(this);
        tvImport.setOnClickListener(this);
    }

    @Override
    public void initDataFromInternet() {

    }

    @Override
    public void loadInternetDataToUi(Response<String> response) {

    }

    @Override
    public void loadInternetDataToUi() {

    }

    @Override
    protected int setStatusBarColor() {
        return getColorRes(R.color.colorQianLan);
    }

    private void importFile(String filePath) {
        String json = FileUtils.readFileContent(filePath);
        if (!"".equals(json)) {
            Gson gson = new Gson();
            BackupsBean bean = null;
            try {
                bean = gson.fromJson(json, BackupsBean.class);
            } catch (JsonSyntaxException e) {
                ToastUtils.showToast(FixedAssetsActivity.this, "导入文件出错!");
            }
            if (bean != null) {
                List<SaveDataLMBean> list = bean.getListSaveData();
                List<DataNameTableLMBean> list1 = bean.getListDataNameTable();
                List<ItemFlagLMBean> list2 = bean.getListItemFlag();
                List<DateRecordLMBean> list3 = bean.getListDateRecord();
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {//当备份数据中的litepalbean中包含字段baseObjId时,
                        // 直接保存显示成功但是查询不到数据
                        Log.e("TAG", "importFile: ---11111--" + list.get(i).save());
                    }
                }
                if (list1 != null) {
                    for (int i = 0; i < list1.size(); i++) {
                        Log.e("TAG", "importFile: ---2222--" + list1.get(i).save());
                    }
                }
                if (list2 != null) {
                    for (int i = 0; i < list2.size(); i++) {
                        Log.e("TAG", "importFile: ---3333--" + list2.get(i).save());
                    }
                }
                if (list3 != null) {
                    for (int i = 0; i < list3.size(); i++) {
                        Log.e("TAG", "importFile: ---44444--" + list3.get(i).save());
                    }
                }
            } else {
                ToastUtils.showToast(FixedAssetsActivity.this, "导入文件出错!");
            }

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            String path;
            Uri uri = data.getData();
            if (uri != null && "file".equalsIgnoreCase(uri.getScheme())) {//使用第三方应用打开
                path = uri.getPath();
                importFile(path);
                Log.e("TAG", "onActivityResult: ---111--" + path);
                return;
            }
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {//4.4以后
                path = getPath(this, uri);
                Log.e("TAG", "onActivityResult: --222---" + path);
                importFile(path);
            } else {//4.4以下下系统调用方法
                path = getRealPathFromURI(uri);
                Log.e("TAG", "onActivityResult: ---333--" + path);
                importFile(path);
            }
        }
    }


    /**
     * 专为Android4.4设计的从Uri获取文件绝对路径，以前的方法已不好使
     */
    @SuppressLint("NewApi")
    public String getPath(final Context context, final Uri uri) {

        final boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;

        // DocumentProvider
        if (isKitKat && DocumentsContract.isDocumentUri(context, uri)) {
            // ExternalStorageProvider
            if (isExternalStorageDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];
                if ("primary".equalsIgnoreCase(type)) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            } else if (isDownloadsDocument(uri)) { // DownloadsProvider

                final String id = DocumentsContract.getDocumentId(uri);
                final Uri contentUri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));

                return getDataColumn(context, contentUri, null, null);
            } else if (isMediaDocument(uri)) {  // MediaProvider
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                Uri contentUri = null;
                if ("image".equals(type)) {
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(type)) {
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(type)) {
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }

                final String selection = "_id=?";
                final String[] selectionArgs = new String[]{split[1]};

                return getDataColumn(context, contentUri, selection, selectionArgs);
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) { // MediaStore (and general)
            return getDataColumn(context, uri, null, null);
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {  // File
            return uri.getPath();
        }
        return null;
    }

    public String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs) {

        Cursor cursor = null;
        final String column = "_data";
        final String[] projection = {column};

        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs,
                    null);
            if (cursor != null && cursor.moveToFirst()) {
                final int column_index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(column_index);
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is ExternalStorageProvider.
     */
    public boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is MediaProvider.
     */
    public boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public String getRealPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (null != cursor && cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
            cursor.close();
        }
        return res;
    }
}
