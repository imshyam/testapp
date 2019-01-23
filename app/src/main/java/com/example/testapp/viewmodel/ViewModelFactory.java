package com.example.testapp.viewmodel;

import com.example.testapp.repository.MoviesDao;
import com.example.testapp.repository.TvSeriesDao;

import java.util.concurrent.Executor;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private MoviesDao moviesDao;
    private TvSeriesDao tvSeriesDao;
    private Executor executor;

    public ViewModelFactory(MoviesDao moviesDao, TvSeriesDao tvSeriesDao, Executor executor) {
        this.moviesDao = moviesDao;
        this.tvSeriesDao = tvSeriesDao;
        this.executor = executor;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new TvMoviesViewModel(moviesDao, tvSeriesDao, executor);
    }
}
