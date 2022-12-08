package com.example.mynewsapp;

import com.example.mynewsapp.Models.ModelClass;
import com.example.mynewsapp.Models.UpperModelClass;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface RetrofitInterface {

    public static String baseurl = "https://newsapi.org/v2/";

    @GET("top-headlines")
    Call<UpperModelClass> getNews(
            @Query("country") String country,
            @Query("pagesize") int pagesize,
            @Query("apiKey") String apiKey,
            @Query("category") String category


    );

    @GET("top-headlines")
    Call<UpperModelClass> getCategoryNews(
            @Query("country") String country,
            @Query("pagesize") int pagesize,
            @Query("apiKey") String apikey,
            @Query("category") String category
    );

    @GET("top-headlines")
    Call<UpperModelClass> getMyNews(
            @Query("country") String country,
            @Query("apiKey") String apikey
    );
}
