package com.example.testapp.dao;

import com.example.testapp.model.FavoriteItem;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;

public interface FavoriteDao {
    @Insert
    void insertAll(FavoriteItem... favoriteItems);

    @Query(value = "select * from favorite;")
    LiveData<List<FavoriteItem>> getAll();

    @Query(value = "delete from favorite where itemId =:itemId;")
    void deleteItem(String itemId);
}
