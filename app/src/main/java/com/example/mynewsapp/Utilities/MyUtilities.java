package com.example.mynewsapp.Utilities;

import com.example.mynewsapp.RetrofitInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyUtilities {

    public static Retrofit retrofit = null;


    public static RetrofitInterface getRetrofitInstance(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(RetrofitInterface.baseurl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(RetrofitInterface.class);
    }
}
