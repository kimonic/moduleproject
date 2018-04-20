package com.kimonic.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import com.google.gson.GsonBuilder;
import com.kimonic.utilsmodule.utils.LUtils;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;
import retrofit2.http.Query;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ScrollView scrollView;
    private Button button;

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_test_main);

        scrollView = findViewById(R.id.sv_act_test_main);
        button = findViewById(R.id.bt_act_test_main);
        button.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_act_test_main:
                startActivity(new Intent(this,SmartActivity.class));

//                WolfQueen wolfQueen=new WolfQueen();

//                testTudou();

////--------------------------------------RxJava2操作符测试-------------------------------------------
////--------------------------------------RxJava2操作符测试-------------------------------------------
//                Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
//                    @Override
//                    public void subscribe(ObservableEmitter<String> emitter) throws Exception {
//                        LUtils.e(MainActivity.class, "logflag---" + Thread.currentThread().getName());
//
//                        emitter.onNext("我来发射数据");
//                    }
//                });
//
//                Observer<Integer> observer = new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Integer s) {
//                        LUtils.e(MainActivity.class, "logflag---" + Thread.currentThread().getName());
//                        LUtils.e(MainActivity.class, "logflag---" + s);
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                };
//                List<String> list = new ArrayList<>();
//                for (int i = 0; i < 20; i++) {
//                    list.add("我发射的数据是:" + i);
//                }
//                Observable<String> observable1 = Observable.fromIterable(list);
//
//                Observable<String> observable2 = Observable.defer(new Callable<ObservableSource<? extends String>>() {
//                    @Override
//                    public ObservableSource<? extends String> call() throws Exception {
//                        return Observable.just("我返回数据");
//                    }
//                });
//                Observable observable3 = Observable.interval(2, TimeUnit.SECONDS);
////                map()操作符，就是把原来的Observable对象转换成另一个Observable对象，
////              同时将传输的数据进行一些灵活的操作，方便Observer获得想要的数据形式。
//                Observable<Integer> observable4 = Observable.just("hello").map(new Function<String, Integer>() {
//                    @Override
//                    public Integer apply(String s) throws Exception {
//                        LUtils.e(MainActivity.class, "logflag---" + Thread.currentThread().getName());
//                        return s.length();
//                    }
//                })
//                        .subscribeOn(Schedulers.newThread())
//                        .observeOn(AndroidSchedulers.mainThread());
//
//                observable4.subscribe(observer);
////--------------------------------------RxJava2操作符测试-------------------------------------------
////--------------------------------------RxJava2操作符测试-------------------------------------------


//                scrollView.pageScroll(View.FOCUS_DOWN);
//                LUtils.e(MainActivity.class,"logflag---"+button.canScrollVertically(1));
//                count++;
//                scrollView.setTranslationY(100 * count);
//https://api.douban.com/v2/book/search?q=金瓶梅&tag=&start=0&count=1

//                //*-------------------------RxJava2使用---------------------------------------------
//                //*-------------------------RxJava2使用---------------------------------------------
//                //*-------------------------RxJava2使用---------------------------------------------
//                Retrofit retrofit = new Retrofit.Builder()
//                        .baseUrl("http://mob.tudoujf.com")
//                        .client(new OkHttpClient.Builder().build())
//                        .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))//添加json转化器
//                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                        .build();
//                CompositeDisposable compositeSubscription = new CompositeDisposable();
//                DisposableObserver disposableObserver = new DisposableObserver<HomeBean>() {
//
//                    @Override
//                    public void onNext(HomeBean book) {
//                        LUtils.e(MainActivity.class, "logflag---" + book.toString());
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        LUtils.e(MainActivity.class, "logflag---" + e);
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        LUtils.e(MainActivity.class, "logflag---" );
//                    }
//                };
//                // RxJava内置容器CompositeDisposable, 每当我们得到一个observer(或者其子类)时就调用
//                // CompositeDisposable.add()将它添加到容器中, 在退出的时候,在ondestroy()方法中
//                // 调用CompositeDisposable.clear() 禁止所有已添加的observer继续节后苏信息.
//                compositeSubscription.add(disposableObserver);
//                //切断observer接收来自observable中的消息,防止因当前activity已销毁引起更新UI时出现崩溃
//                //在onDestroy()中调用
////                compositeSubscription.clear();
//                retrofit.create(HomeRequest.class)//retrofit service接口实例
//                        .getHomeInfo("")//返回一个Observable
//                        .subscribeOn(Schedulers.io())//设置订阅线程,返回observable,observable执行的线程
//                        .observeOn(AndroidSchedulers.mainThread())//设置观察线程,返回observable,observer执行的线程
//                        .subscribeWith(disposableObserver);//返回observer,observable的observer
//
//
//                //*-------------------------RxJava2使用---------------------------------------------
//                //*-------------------------RxJava2使用---------------------------------------------
//                //*-------------------------RxJava2使用---------------------------------------------
//
//----------------------------------RxJava1使用----------------------------------------------------
//----------------------------------RxJava1使用----------------------------------------------------
//----------------------------------RxJava1使用----------------------------------------------------
//                compositeSubscription.add(
//                        retrofit.create(RetrofitService.class)
//                                .getSearchBooks("金瓶梅", null, 0, 1)
//                                .subscribeOn(Schedulers.io())
//                                .observeOn(AndroidSchedulers.mainThread())
//                                .subscribe(new Observer<Book>() {
//
//                                    @Override
//                                    public void onCompleted() {
//                                        LUtils.e(MainActivity.class, "logflag---" +Thread.currentThread().getName());
//
//                                    }
//
//                                    @Override
//                                    public void onError(Throwable e) {
//                                        LUtils.e(MainActivity.class, "logflag---" +e);
//
//                                    }
//
//                                    @Override
//                                    public void onNext(Book book) {
//                                        LUtils.e(MainActivity.class, "logflag---"+
//                                                book.getBooks().get(0).getTags().size());
//
//                                    }
//                                })
//                );
//----------------------------------RxJava1使用----------------------------------------------------
//----------------------------------RxJava1使用----------------------------------------------------
//----------------------------------RxJava1使用----------------------------------------------------
                break;
        }
    }

    private void testTudou() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mob.tudoujf.com")//基础url
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//rxjava转换器
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))//json转换器
                .build();//构建retrofit
        //观察者,接收请求的数据
        DisposableObserver<HomeBean> observer = new DisposableObserver<HomeBean>() {
            @Override
            public void onNext(HomeBean homeBean) {
               //在此接收从网络请求并解析后的数据
                LUtils.e(MainActivity.class,"logflag---");

            }

            @Override
            public void onError(Throwable e) {
              //网络请求出错时会调用次方法
                LUtils.e(MainActivity.class,"logflag---");

            }

            @Override
            public void onComplete() {
               //次方法被调用后,则观察者不再接收来自被观察者的消息
                LUtils.e(MainActivity.class,"logflag---");
            }
        };

        //创建retrofit请求
        HomeRequest homeRequest = retrofit.create(HomeRequest.class);
        homeRequest.getHomeInfo("")//获取被观察者
                .map(new Function<BaseBean, HomeBean>() {
                    @Override
                    public HomeBean apply(BaseBean baseBean) throws Exception {
                        //在此方法中对请求数据进行预处理,并转化为最终需要的被观察者类型
                        LUtils.e(MainActivity.class,"logflag---");
                        return null;
                    }
                })
                .subscribeOn(Schedulers.io())//执行线程
                .observeOn(AndroidSchedulers.mainThread())//观察线程
                .subscribeWith(observer);//订阅观察者

        //一次性观察者容器,用于终止观察者接收信息
        CompositeDisposable compositeDisposable=new CompositeDisposable();
        compositeDisposable.add(observer);
        compositeDisposable.clear();
    }

    /**
     * public void downloadApk(String apkUrl, String title, String desc) {
     // fix bug : 装不了新版本，在下载之前应该删除已有文件
     File apkFile = new File(weakReference.get().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS),
     "test.apk");

     if (apkFile != null && apkFile.exists()) {

     apkFile.delete();

     }

     DownloadManager.Request request = new DownloadManager.Request(Uri.parse(apkUrl));
     //设置title
     request.setTitle(title);
     // 设置描述
     request.setDescription(desc);
     // 完成后显示通知栏
     request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
     request.setDestinationInExternalFilesDir(weakReference.get(), Environment.DIRECTORY_DOWNLOADS,
     "test.apk");
     //在手机SD卡上创建一个download文件夹
     // Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).mkdir() ;
     //指定下载到SD卡的/download/my/目录下
     // request.setDestinationInExternalPublicDir("/codoon/","test.apk");

     request.setMimeType("application/vnd.android.package-archive");
     //记住reqId
     mReqId = mDownloadManager.enqueue(request);
     }


     */
    private interface HomeRequest {
        @POST("/phone/index/index")
        Observable<BaseBean> getHomeInfo(@Query("login_token") String logintoken);
    }

}
