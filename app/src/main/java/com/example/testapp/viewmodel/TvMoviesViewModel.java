package com.example.testapp.viewmodel;

import com.example.testapp.dao.FavoriteDao;
import com.example.testapp.dao.MoviesDao;
import com.example.testapp.model.FavoriteItem;
import com.example.testapp.model.MovieItem;
import com.example.testapp.repository.WebRepository;

import java.util.List;
import java.util.concurrent.Executor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TvMoviesViewModel extends ViewModel {

    private LiveData<List<MovieItem>> movies;
    private LiveData<List<MovieItem>> tvSeries;
    private WebRepository repository;

    TvMoviesViewModel(MoviesDao moviesDao, FavoriteDao favoriteDao, Executor executor) {
        repository = WebRepository.init(moviesDao, favoriteDao, executor);
    }

    public LiveData<List<MovieItem>> getMovies() {

        if(movies == null) {
            movies = new MutableLiveData<>();
            loadMovies();
        }
        return movies;
    }

    private void loadMovies() {
        movies = repository.loadMovies();
    }

    public LiveData<List<MovieItem>> getTvSeries() {
        if(tvSeries == null) {
            tvSeries = new MutableLiveData<>();
            loadTvSeries();
        }
        return tvSeries;
    }

    private void loadTvSeries() {
        tvSeries = repository.loadTvSeries();
    }

}
