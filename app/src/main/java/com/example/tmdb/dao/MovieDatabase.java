package com.example.tmdb.dao;

import android.content.Context;

import com.example.tmdb.model.FavoriteItem;
import com.example.tmdb.model.MovieItem;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {MovieItem.class, FavoriteItem.class}, version = 1, exportSchema = false)
@TypeConverters({GenreTypeConverter.class, HistoryItemTypeConverter.class})
public abstract class MovieDatabase extends RoomDatabase {

    public abstract FavoriteDao favoriteDao();
    public abstract MoviesDao moviesDao();
    private static final String DATABASE_NAME = "movies";

    private static final Object LOCK = new Object();
    private static volatile MovieDatabase moviesDatabase;

    public static MovieDatabase getInstance(Context context) {

        if(moviesDatabase == null) {
            synchronized (LOCK) {
                if(moviesDatabase == null) {
                    moviesDatabase = Room.databaseBuilder(context.getApplicationContext(),
                            MovieDatabase.class, DATABASE_NAME).build();
                }
            }
        }
        return moviesDatabase;
    }

}
