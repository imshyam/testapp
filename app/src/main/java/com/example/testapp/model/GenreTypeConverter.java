package com.example.testapp.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import androidx.room.TypeConverter;

public class GenreTypeConverter {

    static Gson gson = new Gson();

    @TypeConverter
    public static String toCommaSaparatedString(List<String> genres) {
        return gson.toJson(genres);
    }

    @TypeConverter
    public static List<String> listGenreToString(String genres) {
        if (genres == null) {
            return Collections.emptyList();
        }
        Type listType = new TypeToken<List<Long>>() {}.getType();
        return gson.fromJson(genres, listType);
    }
}
