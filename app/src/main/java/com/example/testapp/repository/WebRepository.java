package com.example.testapp.repository;

import android.util.Log;

import com.example.testapp.model.MovieItem;
import com.example.testapp.model.ResponseJson;
import com.example.testapp.service.WebService;

import java.util.List;

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

    public LiveData<ResponseJson> getMovies() {
        final MutableLiveData<ResponseJson> responseJson = new MutableLiveData<>();
        webService.getTrendingWeek().enqueue(new Callback<ResponseJson>() {
            @Override
            public void onResponse(Call<ResponseJson> call, Response<ResponseJson> response) {
                responseJson.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseJson> call, Throwable t) {
                Log.e("RETROFIT", t.getMessage());
            }
        });
        return responseJson;
    }

}
