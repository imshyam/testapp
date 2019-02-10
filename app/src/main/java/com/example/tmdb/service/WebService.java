package com.example.tmdb.service;

import com.example.tmdb.model.ResponseMovieJson;

import retrofit2.Call;
import retrofit2.http.GET;

import static com.example.tmdb.URLs.TRENDING_MOVIES_WEEK;
import static com.example.tmdb.URLs.TRENDING_TV_WEEK;

public interface WebService {

    @GET(value = TRENDING_MOVIES_WEEK)
    Call<ResponseMovieJson> getTrendingMoviesWeek();

    @GET(value = TRENDING_TV_WEEK)
    Call<ResponseMovieJson> getTrendingTvSeriesWeek();
}
