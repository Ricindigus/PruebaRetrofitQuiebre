package com.example.ricindigus.pruebaretrofitquiebre;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface WebServiceApi {
    @GET("network")
    Call<RedObject> getTiposRed();

    @POST("break")
    Call<Quiebre> setQuiebre(@Body Quiebre quiebre);
}
