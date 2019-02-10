package com.example.tmdb.dao;

import com.example.tmdb.model.HistoryItemTypeEnum;

import androidx.room.TypeConverter;

public class HistoryItemTypeConverter {

    @TypeConverter
    public static String toString(HistoryItemTypeEnum typeEnum) {
        return typeEnum.toString();
    }

    @TypeConverter
    public static HistoryItemTypeEnum toEnum(String type) {
        return HistoryItemTypeEnum.valueOf(type);
    }
}
