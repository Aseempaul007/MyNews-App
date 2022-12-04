package com.example.mynewsapp;

import com.example.mynewsapp.Models.ModelClass;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface RetrofitInterface {

    public static String baseurl = "https://newsapi.org/v2/";

    @GET("top-headlines")
    Call<ModelClass> getNews(
            @Query("country") String country,
            @Query("apiKey") String apiKey
            
    );

    @GET("top-headlines")
    Call<ModelClass> getCategoryNews(
            @Query("country") String country,
            @Query("apiKey") String apikey,
            @Query("category") String category
    );
}
