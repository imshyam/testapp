package com.example.testapp.repository;

import com.example.testapp.model.TvSeriesItem;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface TvSeriesDao {

    @Insert
    void insertAll(TvSeriesItem... tvSeriesItems);

    @Query(value = "select * from tv_series;")
    List<TvSeriesItem> getTvSeries();
}
