package com.example.testapp.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity(tableName = "favorite")
@Data
@AllArgsConstructor
public class FavoriteItem {
    @PrimaryKey
    long id;

    private String itemId;
    private HistoryItemTypeEnum itemType;

    @Ignore
    public FavoriteItem(String itemId, HistoryItemTypeEnum itemType) {
        this.itemId = itemId;
        this.itemType = itemType;
    }
}
