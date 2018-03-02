package com.kimonic.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_test_main);
        Class<FanSheTest> clz = FanSheTest.class;

        FanSheTest fanSheTest=new FanSheTest("小明");
//        Method method[] = clz.getDeclaredMethods();
//        for (int i = 0; i < method.length; i++) {
//            Log.e("TAG", "onCreate: -全部方法-反射测试---" + method[i].getName());
//
//        }
//
//        Method method1[] = clz.getMethods();
//        for (int i = 0; i < method1.length; i++) {
//            Log.e("TAG", "onCreate: -共有方法-反射测试---" + method1[i].getName());
//        }

        try {
            Method method2 = clz.getDeclaredMethod("outAge", int.class);
            method2.setAccessible(true);
            method2.invoke(clz.newInstance(),10);
            Log.e("TAG", "onCreate: 反射测试---33--调用结束");

            Field field=clz.getField("HHHHH");
//            field.getInt();

        } catch (NoSuchMethodException e) {
            Log.e("TAG", "onCreate: 反射测试--错误1");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            Log.e("TAG", "onCreate: 反射测试-错误2");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            Log.e("TAG", "onCreate: 反射测试--错误3");
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
