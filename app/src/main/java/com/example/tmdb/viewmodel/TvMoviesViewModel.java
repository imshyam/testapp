package com.example.tmdb.viewmodel;

import com.example.tmdb.dao.FavoriteDao;
import com.example.tmdb.dao.MoviesDao;
import com.example.tmdb.model.MovieItem;
import com.example.tmdb.repository.WebRepository;

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
