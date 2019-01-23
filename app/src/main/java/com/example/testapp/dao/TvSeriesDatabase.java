package com.example.testapp.dao;

import android.content.Context;

import com.example.testapp.model.TvSeriesItem;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = TvSeriesItem.class, version = 1, exportSchema = false)
@TypeConverters(GenreTypeConverter.class)
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
