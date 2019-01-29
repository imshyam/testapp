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

    @Query(value = "select mts.id, mts.poster_path, mts.original_title, mts.original_name, " +
            "mts.adult, mts.genre_ids, mts.original_language, mts.overview, mts.popularity, mts.release_date, mts.vote_average" +
            " from movies_tv_series as mts inner join favorite on favorite.itemId = mts.id;")
    LiveData<List<MovieItem>> getFavoriteMovies();

    @Query(value = "delete from favorite where itemId =:itemId;")
    void deleteItem(String itemId);
}
