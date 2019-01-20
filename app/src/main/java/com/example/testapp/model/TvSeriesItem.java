package com.example.testapp.model;

import java.util.List;

import lombok.Data;

//@Entity(tableName = "movies")
@Data
public class TvSeriesItem {
//    @PrimaryKey
    long id;

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
