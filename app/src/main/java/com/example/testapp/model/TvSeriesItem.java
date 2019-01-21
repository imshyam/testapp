package com.example.testapp.model;

import java.util.List;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import lombok.Data;

@Entity(tableName = "tv_series")
@Data
public class TvSeriesItem {
    @PrimaryKey
    long id;

    String original_name;
    String poster_path;
    boolean adult;
    @TypeConverters(GenreTypeConverter.class)
    List<String> genre_ids;
    String original_language;
    String release_date;
    double vote_average;
    double popularity;
    String overview;

}
