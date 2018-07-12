package com.dwist.mvp.core.network;

import com.dwist.mvp.core.data.remote.home.Books;
import com.dwist.mvp.core.data.remote.home.Item;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface NetworkStores {
    @GET("volumes")
    Observable<Books> getTopBooks(@Query("q") String key);

    @GET("volumes/{id}")
    Observable<Item> getDetailBook(@Path("id") String id);
}