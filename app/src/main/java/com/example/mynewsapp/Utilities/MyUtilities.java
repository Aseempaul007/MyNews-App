package com.example.mynewsapp.Utilities;

import com.example.mynewsapp.RetrofitInterface;

import retrofit2.Retrofit;

public class MyUtilities {

    Retrofit retrofit = null;


    public Retrofit getRetrofitInstance(Retrofit retrofit){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(RetrofitInterface.baseurl)
                    .addConverterFactory(Gso)
                    .build();
        }
        return retrofit;
    }
}
