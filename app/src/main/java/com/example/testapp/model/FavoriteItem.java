package com.example.testapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favorite")
public class FavoriteItem {
    @PrimaryKey
    long id;

    String itemId;
    HistoryItemTypeEnum itemType;
}
