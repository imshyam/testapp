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

    String originalTitle;
    String posterPath;
    boolean adult;
    List<String> genreIds;
    String originalLanguage;
    String releaseDate;
    double voteAverage;
    double popularity;
    String overview;

}
