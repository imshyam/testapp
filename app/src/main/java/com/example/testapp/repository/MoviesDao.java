package com.example.testapp.repository;

import com.example.testapp.model.MovieItem;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<MovieItem> movieItems);

    @Query(value = "select * from movies;")
    LiveData<List<MovieItem>> getMovies();

    @Query(value = "delete from movies;")
    void deleteAll();
}
