package com.example.tmdb.model;

import java.util.List;

import lombok.Data;

@Data
public class ResponseMovieJson {

    long page;
    List<MovieItem> results;

}
