package com.kimonic.test;

import android.util.Log;

/**
 * * ===============================================================
 * name:             FanSheTest
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/2
 * method:
 * <p>
 * <p>
 * description：
 * history：
 * *==================================================================
 */

public class FanSheTest {
    private String name;
    private String grade;
    private int age;
    private int height;

    private static String HHHHH="这是私有静态字段";

    public FanSheTest() {
    }

    public FanSheTest(String name) {
        this.name = name;
    }

    public FanSheTest(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    public FanSheTest(String name, String grade, int age) {
        this.name = name;
        this.grade = grade;
        this.age = age;
    }

    public FanSheTest(String name, String grade, int age, int height) {
        this.name = name;
        this.grade = grade;
        this.age = age;
        this.height = height;
    }

    public void outName(){
        Log.e("TAG", "outName: ---反射测试--"+name);

    }

    private void outAge(int n){
        Log.e("TAG", "outAge: --反射测试---"+n);
    }

    private void outConstant(){
        Log.e("TAG", "outAge: --反射测试---"+HHHHH);
    }

}
