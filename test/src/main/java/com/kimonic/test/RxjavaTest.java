package com.kimonic.test;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * * ===============================================================
 * name:             RxjavaTest
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/4/9
 * method:
 * <p>
 * <p>
 * description：
 * history：
 * *==================================================================
 */

public class RxjavaTest {

    public void useRxJava(Observer observer){
        Observable.just("one","two","three","four","five")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);


    }
}
