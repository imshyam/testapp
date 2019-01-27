package com.example.testapp.dao;

import com.example.testapp.model.FavoriteItem;
import com.example.testapp.model.MovieItem;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface FavoriteDao {
    @Insert
    void insertAll(FavoriteItem... favoriteItems);

    @Query(value = "select * from favorite;")
    LiveData<List<FavoriteItem>> getAll();

    @Query(value = "select * from movies_tv_series inner join favorite on favorite.itemId = movies_tv_series.id;")
    LiveData<List<MovieItem>> getFavoriteMovies();

    @Query(value = "delete from favorite where itemId =:itemId;")
    void deleteItem(String itemId);
}
