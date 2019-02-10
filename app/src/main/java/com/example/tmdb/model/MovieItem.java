package com.example.tmdb.model;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import lombok.Data;

@Entity(tableName = "movies_tv_series", indices = {@Index("id")})
@Data
public class MovieItem {
    @PrimaryKey @NonNull
    String id;
    String original_title;
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
