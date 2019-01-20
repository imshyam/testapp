package com.example.testapp.repository;

import android.util.Log;

import com.example.testapp.model.ResponseMovieJson;
import com.example.testapp.model.ResponseTvJson;
import com.example.testapp.service.WebService;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.testapp.URLs.BASE_URL;

public class WebRepository {

    private WebService webService;
    private static WebRepository repository;

    private WebRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webService = retrofit.create(WebService.class);
    }

    public static WebRepository init() {
        if(repository == null) {
            repository = new WebRepository();
        }
        return repository;
    }

    public LiveData<ResponseMovieJson> getMovies() {
        final MutableLiveData<ResponseMovieJson> responseJson = new MutableLiveData<>();
        webService.getTrendingMoviesWeek().enqueue(new Callback<ResponseMovieJson>() {
            @Override
            public void onResponse(Call<ResponseMovieJson> call, Response<ResponseMovieJson> response) {
                responseJson.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseMovieJson> call, Throwable t) {
                Log.e("RETROFIT", t.getMessage());
            }
        });
        return responseJson;
    }

    public LiveData<ResponseTvJson> getTvSeries() {
        final MutableLiveData<ResponseTvJson> responseJson = new MutableLiveData<>();
        webService.getTrendingTvSeriesWeek().enqueue(new Callback<ResponseTvJson>() {
            @Override
            public void onResponse(Call<ResponseTvJson> call, Response<ResponseTvJson> response) {
                responseJson.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseTvJson> call, Throwable t) {
                Log.e("RETROFIT", t.getMessage());
            }
        });
        return responseJson;
    }
}
