package com.example.testapp.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import lombok.Data;

@Entity(tableName = "favorite",
        indices = @Index(value = {"itemId"}, unique = true),
        foreignKeys = @ForeignKey(
            entity = MovieItem.class,
            parentColumns = "id",
            childColumns = "itemId",
            onDelete = ForeignKey.CASCADE))
@Data
public class FavoriteItem {
    @PrimaryKey
    long id;

    private String itemId;
    private HistoryItemTypeEnum itemType;
    public FavoriteItem() {}

    @Ignore
    public FavoriteItem(String itemId, HistoryItemTypeEnum itemType) {
        this.itemId = itemId;
        this.itemType = itemType;
    }
}
