package com.kimonic.test;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * * ===============================================================
 * name:             RetrofitService
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

public interface RetrofitService {

    @GET("book/search")//基准url后面的节点url
    Observable<Book> getSearchBooks(@Query("q") String name,//url?后面的参数键值对模式q="金瓶梅"
                                    @Query("tag") String tag,//tag=tag
                                    @Query("start") int start,
                                    @Query("count")  int count
                                    );


}
