package com.example.testapp.repository;

import android.content.Context;

import com.example.testapp.model.MovieItem;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = MovieItem.class, version = 1)
public abstract class TvSeriesDatabase extends RoomDatabase {

    public abstract TvSeriesDao tvSeriesDao();
    private static final String DATABASE_NAME = "tv_series";

    private static final Object LOCK = new Object();
    private static volatile TvSeriesDatabase tvSeriesDatabase;

    public static TvSeriesDatabase getInstance(Context context) {

        if(tvSeriesDatabase == null) {
            synchronized (LOCK) {
                if(tvSeriesDatabase == null) {
                    tvSeriesDatabase = Room.databaseBuilder(context.getApplicationContext(),
                            TvSeriesDatabase.class, DATABASE_NAME).build();
                }
            }
        }
        return tvSeriesDatabase;
    }

}
