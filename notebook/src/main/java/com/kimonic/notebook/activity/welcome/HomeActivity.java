package com.kimonic.notebook.activity.welcome;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.kimonic.notebook.R;
import com.kimonic.notebook.fragment.AccountingFragment;
import com.kimonic.notebook.fragment.HomeFragment;
import com.kimonic.notebook.mapp.MApp;
import com.kimonic.notebook.ui.BubbleView;
import com.kimonic.utilsmodule.adapter.FragmentVPAdapter;
import com.kimonic.utilsmodule.base.BaseActivity;
import com.kimonic.utilsmodule.ui.NaviButtonView;
import com.kimonic.utilsmodule.ui.NoScrollViewPager;
import com.kimonic.utilsmodule.utils.AppKidUtils;
import com.kimonic.utilsmodule.utils.ToastUtils;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import butterknife.BindView;

public class HomeActivity extends BaseActivity {


    @BindView(R.id.vp_act_home)
    NoScrollViewPager vpActHome;
    @BindView(R.id.nbv_act_home)
    NaviButtonView nbvActHome;

    private List<Fragment> list;
    private int beforePosition = 0;


    public ViewPager getVpActHome() {
        return vpActHome;
    }


    @Override
    public int getLayoutResId() {
        return R.layout.act_home_notebook;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initDataFromIntent() {
        getConstant();
//        insertConstacts();
        testDelete();
        getDataList();
        /**
         * {
         "contact0": {
         "lastname": "钉钉专属顾问",
         "mobile": "057156215888"
         },
         "contact1": {
         "mobile": "150 2418 7788",
         "homeNum": "0532-85215235",
         "jobNum": "0532-98521473",
         "homeEmail": "dfswfds@qq.com",
         "jobEmail": "dfgsdgd@qq.com",
         "firstName": "二",
         "lastname": "牛",
         "phoneticFirstName": "erniu",
         "company": "蔡森",
         "nickName": "傻逼",
         "homeStreet": "住宅地址",
         "street": "东莞",
         "otherStreet": "蔡森"
         },
         "contact2": {}
         }
         */
    }

    @Override
    public void initView() {
        setTopMargin(vpActHome, MApp.STATUS_BAE_HEIGHT);
        initFragmentList();
        FragmentVPAdapter adapter = new FragmentVPAdapter(getSupportFragmentManager(), list);
        vpActHome.setAdapter(adapter);
        nbvActHome.setViewPager(vpActHome);
        vpActHome.setOffscreenPageLimit(4);


        BubbleView view = new BubbleView(this);
        ((FrameLayout) (getWindow().getDecorView())).addView(view);
    }

    private void initFragmentList() {
        list = new ArrayList<>();


        AccountingFragment fragment1 = new AccountingFragment();
        list.add(fragment1);


        HomeFragment fragment2 = new HomeFragment();
        list.add(fragment2);

        HomeFragment fragment3 = new HomeFragment();
        list.add(fragment3);

        HomeFragment fragment4 = new HomeFragment();
        list.add(fragment4);

    }

    @Override
    public void initListener() {
        nbvActHome.setListener(new NaviButtonView.CurrentPositionListener() {
            @Override
            public boolean currentPosition(int position) {

                return true;

            }
        });

        vpActHome.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {


            }
        });
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


    private void getConstant() {

        try {
           Log.e("TAG", "getConstant: -----"+ AppKidUtils.getContactInfo(this,new JSONObject()));

        } catch (JSONException e) {
            e.printStackTrace();
        }
//        Cursor cursor = null;
//        try {
//            Cursor cursor1 = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
//                    null, null, null, null);
//            //cursor指针 query询问 contract协议 kinds种类
//
//            cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
//                    null, null, null, ContactsContract.Data.RAW_CONTACT_ID);
////
//            if (cursor != null) {
//                while (cursor.moveToNext()) {
//                    String displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
//                    String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
//                    String workAddress = cursor.getString(cursor.getColumnIndex(
//                            ContactsContract.CommonDataKinds.Phone.RAW_CONTACT_ID));
//
//                    String mimetype = cursor.getString(cursor.getColumnIndex(ContactsContract.Data.MIMETYPE));
//
//                    Log.e("TAG", "getConstant: --displayName---" + displayName);
//                    Log.e("TAG", "getConstant: --number---" + number);
//                    Log.e("TAG", "getConstant: --workAddress---" + workAddress);
//                    Log.e("TAG", "getConstant: --mimetype---" + mimetype);
//
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (cursor != null) {
//                cursor.close();
//            }
//        }

    }

    public void insertConstacts() {

        ContentValues values = new ContentValues();
        Uri rawContactUri = getContentResolver().insert(
                ContactsContract.RawContacts.CONTENT_URI, values);//先创建一个空的联系人
        Log.e("TAG", "getConstant: --rawContactUri---" + rawContactUri);
        long rawContactId = ContentUris.parseId(rawContactUri);//获得新建空的联系人的ID
        Log.e("TAG", "getConstant: --rawContactId---" + rawContactId);

        // 表插入姓名数据
        values.clear();//清空values
        values.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);//赋值ID
        values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE);// 插入的值的mime内容类型
        values.put(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME, "维拉报警电话");//联系人姓名
        getContentResolver().insert(ContactsContract.Data.CONTENT_URI, values);//插入联系人姓名

        //写入电话
        values.clear();
        values.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);
        values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
        values.put(ContactsContract.CommonDataKinds.Phone.NUMBER, "95213176");//插入电话号码
        values.put(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE);
        getContentResolver().insert(android.provider.ContactsContract.Data.CONTENT_URI, values);

        //写入头像
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
        try {
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        values.clear();
        values.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);
        values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Photo.CONTENT_ITEM_TYPE);
        values.put(ContactsContract.CommonDataKinds.Photo.PHOTO, out.toByteArray());
        getContentResolver().insert(ContactsContract.Data.CONTENT_URI, values);
    }

    /**
     * 读取数据
     *
     * @return 读取到的数据
     */
    private List<Map<String, String>> getDataList() {
        // 1.获得ContentResolver
        ContentResolver resolver = getContentResolver();
        // 2.利用ContentResolver的query方法查询通话记录数据库
//        /**
//         * @param uri 需要查询的URI，（这个URI是ContentProvider提供的）
//         * @param projection 需要查询的字段
//         * @param selection sql语句where之后的语句
//         * @param selectionArgs ?占位符代表的数据
//         * @param sortOrder 排序方式
//         *
//         */
        List<Map<String, String>> list = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CALL_LOG}, 1111);
            Log.e("TAG", "getDataList: -----请求授权");
            ToastUtils.showToast(HomeActivity.this, R.string.weishouyuduqutonghuajiluquanxian);
        } else {
            Log.e("TAG", "getDataList: -----直接运行");
            @SuppressLint("MissingPermission") Cursor cursor = resolver.query(CallLog.Calls.CONTENT_URI, // 查询通话记录的URI
                    new String[]{CallLog.Calls.CACHED_NAME// 通话记录的联系人
                            , CallLog.Calls.NUMBER// 通话记录的电话号码
                            , CallLog.Calls.DATE// 通话记录的日期
                            , CallLog.Calls.DURATION// 通话时长
                            , CallLog.Calls.TYPE}// 通话类型
                    , null, null, CallLog.Calls.DEFAULT_SORT_ORDER// 按照时间逆序排列，最近打的最先显示
            );
            try {
                // 3.通过Cursor获得数据
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        String name = cursor.getString(cursor.getColumnIndex(CallLog.Calls.CACHED_NAME));
                        String number = cursor.getString(cursor.getColumnIndex(CallLog.Calls.NUMBER));
                        long dateLong = cursor.getLong(cursor.getColumnIndex(CallLog.Calls.DATE));
                        String date = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss", Locale.getDefault()).format(new Date(dateLong));
                        int duration = cursor.getInt(cursor.getColumnIndex(CallLog.Calls.DURATION));
                        int type = cursor.getInt(cursor.getColumnIndex(CallLog.Calls.TYPE));
                        String typeString = "";
                        switch (type) {
                            case CallLog.Calls.INCOMING_TYPE:
                                typeString = "打入";
                                break;
                            case CallLog.Calls.OUTGOING_TYPE:
                                typeString = "打出";
                                break;
                            case CallLog.Calls.MISSED_TYPE:
                                typeString = "未接";
                                break;
                            default:
                                break;
                        }
                        Map<String, String> map = new HashMap<String, String>();
                        map.put("name", (name == null) ? "未备注联系人" : name);
                        map.put("number", number);
                        map.put("date", date);
                        map.put("duration", duration + "秒");
                        map.put("type", typeString);
                        Log.e("TAG", "getDataList: -----" + map);
                        list.add(map);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }


        }

        return list;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.e("TAG", "onRequestPermissionsResult: ----授权返回-");
        if (requestCode == 1111) {//权限申请请求码
            if (permissions[0].equals("Manifest.permission.READ_CALL_LOG")) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.e("TAG", "onRequestPermissionsResult: ----授权通过-" + grantResults[0]);
                    getDataList();
                } else {
                    Log.e("TAG", "onRequestPermissionsResult: ----授权失败-" + grantResults[0]);
                    getDataList();
                }
            }

        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


/**
    核心思想：
            (1)先在raw_contacts表根据姓名(此处的姓名为name记录的data2的数据而不是data1的数据)查出id；
            (2)在data表中只要raw_contact_id匹配的都删除；
    复制代码*/
    public void testDelete(){
        String name = "维拉报警电话";
        //根据姓名求id
        Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(uri, new String[]{ContactsContract.Data._ID},"display_name=?", new String[]{name}, null);
        if (cursor!=null){
            while (cursor.moveToFirst()){
                int id = cursor.getInt(0);
                //根据id删除data中的相应数据
                resolver.delete(uri, "display_name=?", new String[]{name});
                uri = Uri.parse("content://com.android.contacts/data");
                resolver.delete(uri, "raw_contact_id=?", new String[]{id+""});
            }
        }

    }
}



