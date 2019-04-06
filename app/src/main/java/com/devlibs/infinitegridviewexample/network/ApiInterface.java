package com.devlibs.infinitegridviewexample.network;

import com.devlibs.infinitegridviewexample.model.RandomUser;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/api/")
    Call<RandomUser> getRandomUser(@Query("results") String results, @Query("inc") String param);
}