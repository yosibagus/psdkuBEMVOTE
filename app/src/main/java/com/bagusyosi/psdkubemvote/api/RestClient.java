package com.bagusyosi.psdkubemvote.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    public static final String BASE_URL = "http://192.168.43.241/vote-request/";
    public static final String IMG_URL = "http://192.168.43.241/vote/AKNS-VOTE/assets/img/";

    public static BaseApiService getApiService() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(30000, TimeUnit.MILLISECONDS);
        builder.connectTimeout(30000, TimeUnit.MILLISECONDS);
        BaseApiService retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(BaseApiService.class);
        return retrofit;
    }
}
