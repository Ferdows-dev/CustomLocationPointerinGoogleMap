package com.learning.newproject;

import android.database.Observable;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PlaceHolderApi {

    @GET("api/points")
    Call<List<Pointers>> getPoints();


    @GET("api/activities")
    Call<Activities> getActivities();



}
