package com.example.testapp.model;

import java.util.List;

import lombok.Data;

@Data
public class ResponseMovieJson {

    long page;
    List<MovieItem> results;

}
