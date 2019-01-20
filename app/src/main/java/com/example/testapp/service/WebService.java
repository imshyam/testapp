package com.example.testapp.service;

import com.example.testapp.model.ResponseMovieJson;
import com.example.testapp.model.ResponseTvJson;

import retrofit2.Call;
import retrofit2.http.GET;

import static com.example.testapp.URLs.TRENDING_MOVIES_WEEK;
import static com.example.testapp.URLs.TRENDING_TV_WEEK;

public interface WebService {

    @GET(value = TRENDING_MOVIES_WEEK)
    Call<ResponseMovieJson> getTrendingMoviesWeek();

    @GET(value = TRENDING_TV_WEEK)
    Call<ResponseTvJson> getTrendingTvSeriesWeek();
}
