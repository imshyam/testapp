package com.example.testapp.viewmodel;

import com.example.testapp.dao.FavoriteDao;
import com.example.testapp.dao.MoviesDao;

import java.util.concurrent.Executor;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private MoviesDao moviesDao;
    private FavoriteDao favoriteDao;
    private Executor executor;

    public ViewModelFactory(MoviesDao moviesDao, FavoriteDao favoriteDao, Executor executor) {
        this.moviesDao = moviesDao;
        this.favoriteDao = favoriteDao;
        this.executor = executor;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new TvMoviesViewModel(moviesDao, favoriteDao, executor);
    }
}
