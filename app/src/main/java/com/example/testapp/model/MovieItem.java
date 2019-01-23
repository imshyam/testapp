package com.example.testapp.model;

import java.util.List;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import lombok.Data;

@Entity(tableName = "movies")
@Data
public class MovieItem {
    @PrimaryKey
    long id;

    String original_title;
    String poster_path;
    boolean adult;
    List<String> genre_ids;
    String original_language;
    String release_date;
    double vote_average;
    double popularity;
    String overview;

}
