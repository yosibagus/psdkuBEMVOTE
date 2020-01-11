package com.bagusyosi.psdkubemvote.api;

import com.bagusyosi.psdkubemvote.response.ResponseCapres;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BaseApiService {

    @GET("select_itemvote.php")
    Call<ResponseCapres> getAllCapresOnVoting();

}
