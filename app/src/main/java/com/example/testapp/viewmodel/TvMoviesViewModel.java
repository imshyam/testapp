package com.example.testapp.viewmodel;

import com.example.testapp.model.MovieItem;
import com.example.testapp.model.ResponseMovieJson;
import com.example.testapp.model.ResponseTvJson;
import com.example.testapp.model.TvSeriesItem;
import com.example.testapp.repository.MoviesDao;
import com.example.testapp.repository.TvSeriesDao;
import com.example.testapp.repository.WebRepository;

import java.util.List;
import java.util.concurrent.Executor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TvMoviesViewModel extends ViewModel {

    private LiveData<List<MovieItem>> movies;
    private LiveData<List<TvSeriesItem>> tvSeries;
    private WebRepository repository;

    TvMoviesViewModel(MoviesDao moviesDao, TvSeriesDao tvSeriesDao, Executor executor) {
        repository = WebRepository.init(moviesDao, tvSeriesDao, executor);
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

    public LiveData<List<TvSeriesItem>> getTvSeries() {
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
