package com.example.testapp.viewmodel;

import com.example.testapp.model.ResponseMovieJson;
import com.example.testapp.model.ResponseTvJson;
import com.example.testapp.repository.WebRepository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MoviesViewModel extends ViewModel {

    private LiveData<ResponseMovieJson> movies;
    private LiveData<ResponseTvJson> tvSeries;
    private WebRepository repository;

    MoviesViewModel() {
        repository = WebRepository.init();
    }

    public LiveData<ResponseMovieJson> getMovies() {

        if(movies == null) {
            movies = new MutableLiveData<>();
            loadMovies();
        }
        return movies;
    }

    private void loadMovies() {
        movies = repository.getMovies();
    }

    public LiveData<ResponseTvJson> getTvSeries() {
        if(tvSeries == null) {
            tvSeries = new MutableLiveData<>();
            loadTvSeries();
        }
        return tvSeries;
    }

    private void loadTvSeries() {
        tvSeries = repository.getTvSeries();
    }
}
