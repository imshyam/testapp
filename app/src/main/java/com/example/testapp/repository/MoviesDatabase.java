package com.example.testapp.repository;

import android.content.Context;

import com.example.testapp.model.MovieItem;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = MovieItem.class, version = 1)
public abstract class MoviesDatabase extends RoomDatabase {

    public abstract MoviesDao moviesDao();
    private static final String DATABASE_NAME = "movies";

    private static final Object LOCK = new Object();
    private static volatile MoviesDatabase moviesDatabase;

    public static MoviesDatabase getInstance(Context context) {

        if(moviesDatabase == null) {
            synchronized (LOCK) {
                if(moviesDatabase == null) {
                    moviesDatabase = Room.databaseBuilder(context.getApplicationContext(),
                            MoviesDatabase.class, DATABASE_NAME).build();
                }
            }
        }
        return moviesDatabase;
    }

}
