package com.example.testapp.repository;

import com.example.testapp.model.MovieItem;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface MoviesDao {

    @Insert
    void insertAll(MovieItem... movieItems);

    @Query(value = "select * from movies;")
    List<MovieItem> getMovies();

    @Query(value = "delete from movies;")
    void deleteAll();
}
