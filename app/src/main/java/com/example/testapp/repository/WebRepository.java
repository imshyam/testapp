package com.example.testapp.repository;

import android.util.Log;

import com.example.testapp.dao.FavoriteDao;
import com.example.testapp.dao.MoviesDao;
import com.example.testapp.model.FavoriteItem;
import com.example.testapp.model.MovieItem;
import com.example.testapp.model.ResponseMovieJson;
import com.example.testapp.service.WebService;

import java.util.List;
import java.util.concurrent.Executor;

import androidx.lifecycle.LiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.testapp.URLs.BASE_URL;

public class WebRepository {

    private WebService webService;
    private static WebRepository repository;
    private MoviesDao moviesDao;
    private FavoriteDao favoriteDao;
    private Executor executor;

    private WebRepository(MoviesDao moviesDao, FavoriteDao favoriteDao, Executor executor) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webService = retrofit.create(WebService.class);
        this.moviesDao = moviesDao;
        this.favoriteDao = favoriteDao;
        this.executor = executor;
    }

    public static WebRepository init(MoviesDao moviesDao, FavoriteDao favoriteDao, Executor executor) {
        if(repository == null) {
            repository = new WebRepository(moviesDao, favoriteDao, executor);
        }
        return repository;
    }

    private void refreshMovies() {
        webService.getTrendingMoviesWeek().enqueue(new Callback<ResponseMovieJson>() {
            @Override
            public void onResponse(Call<ResponseMovieJson> call, Response<ResponseMovieJson> response) {
                List<MovieItem> movieItems = response.body().getResults();
                executor.execute(() -> moviesDao.insertAll(movieItems));
            }

            @Override
            public void onFailure(Call<ResponseMovieJson> call, Throwable t) {
                Log.e("RETROFIT", t.getMessage());
            }
        });
    }

    private void refreshTvSeries() {
        webService.getTrendingTvSeriesWeek().enqueue(new Callback<ResponseMovieJson>() {
            @Override
            public void onResponse(Call<ResponseMovieJson> call, Response<ResponseMovieJson> response) {
                List<MovieItem> movieItems = response.body().getResults();
                executor.execute(() -> moviesDao.insertAll(movieItems));
            }

            @Override
            public void onFailure(Call<ResponseMovieJson> call, Throwable t) {
                Log.e("RETROFIT", t.getMessage());
            }
        });
    }


    public LiveData<List<MovieItem>> loadMovies() {
        refreshMovies();
        return moviesDao.getMovies();
    }

    public LiveData<List<MovieItem>> loadTvSeries() {
        refreshTvSeries();
        return moviesDao.getMovies();
    }

    public LiveData<List<FavoriteItem>> loadFavorites() {
        return favoriteDao.getAll();
    }



}
