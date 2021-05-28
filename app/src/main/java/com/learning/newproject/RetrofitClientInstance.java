package com.learning.newproject;



import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    private static Retrofit retrofit;

    public static Retrofit getInstance(){
        if (retrofit == null)


            retrofit = new Retrofit.Builder()
                    .baseUrl("http://e-johns.com/")
                    .addConverterFactory(GsonConverterFactory.create())

                    .build();




        return retrofit;





    }
    private RetrofitClientInstance(){

    }




}
