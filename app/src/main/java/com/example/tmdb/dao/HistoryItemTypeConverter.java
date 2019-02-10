package com.example.testapp.dao;

import com.example.testapp.model.HistoryItemTypeEnum;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

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
