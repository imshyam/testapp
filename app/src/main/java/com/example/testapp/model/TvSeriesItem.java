package com.example.testapp.model;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import lombok.Data;

@Entity(tableName = "tv_series")
@Data
public class TvSeriesItem {
    @PrimaryKey @NonNull
    String id;
    String original_name;
    String poster_path;
    boolean adult;
    List<String> genre_ids;
    String original_language;
    String release_date;
    double vote_average;
    double popularity;
    String overview;

}
