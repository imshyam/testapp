package com.example.testapp.dao;

import android.content.Context;

import com.example.testapp.model.FavoriteItem;
import com.example.testapp.model.MovieItem;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = { FavoriteItem.class, MovieItem.class}, version = 1, exportSchema = false)
@TypeConverters({HistoryItemTypeConverter.class, GenreTypeConverter.class})
public abstract class FavoriteDatabase extends RoomDatabase {

    public abstract FavoriteDao favoriteDao();

    private static final String DB_NAME = "favorite";

    private static final Object LOCK = new Object();
    private static volatile FavoriteDatabase favoriteDatabase;

    public static FavoriteDatabase getInstance(Context context) {

        if(favoriteDatabase == null) {
            synchronized (LOCK) {
                if(favoriteDatabase == null) {
                    favoriteDatabase = Room.databaseBuilder(context.getApplicationContext(),
                            FavoriteDatabase.class, DB_NAME).build();
                }
            }
        }
        return favoriteDatabase;
    }

}
