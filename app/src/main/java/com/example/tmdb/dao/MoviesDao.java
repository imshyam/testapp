package com.example.tmdb.dao;

import com.example.tmdb.model.MovieItem;

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

    @Query(value = "select * from movies_tv_series;")
    LiveData<List<MovieItem>> getMovies();

    @Query(value = "delete from movies_tv_series;")
    void deleteAll();
}
