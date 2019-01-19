package com.example.testapp.service;

import com.example.testapp.model.MovieItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

import static com.example.testapp.URLs.TRENDING_WEEK;

public interface WebService {

    @GET(value = TRENDING_WEEK)
    Call<List<MovieItem>> getTrendingWeek();

}
