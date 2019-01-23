package com.example.testapp.repository;

import com.example.testapp.model.TvSeriesItem;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface TvSeriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<TvSeriesItem> tvSeriesItems);

    @Query(value = "select * from tv_series;")
    LiveData<List<TvSeriesItem>> getTvSeries();

    @Query(value = "delete from tv_series;")
    void deleteAll();
}
