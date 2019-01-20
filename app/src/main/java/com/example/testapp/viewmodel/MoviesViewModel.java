package com.example.testapp.viewmodel;

import com.example.testapp.model.MovieItem;
import com.example.testapp.model.ResponseJson;
import com.example.testapp.repository.WebRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MoviesViewModel extends ViewModel {

    private LiveData<ResponseJson> movies;
    private WebRepository repository;

    MoviesViewModel() {
        repository = WebRepository.init();
    }

    public LiveData<ResponseJson> getMovies() {

        if(movies == null) {
            movies = new MutableLiveData<>();
            loadMovies();
        }
        return movies;
    }

    private void loadMovies() {
        movies = repository.getMovies();
    }

}
