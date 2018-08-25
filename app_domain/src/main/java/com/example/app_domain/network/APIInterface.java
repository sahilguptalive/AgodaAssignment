package com.example.app_domain.network;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("nl6jh")
    Observable<ResponseBody> getNewsFeed();
}
