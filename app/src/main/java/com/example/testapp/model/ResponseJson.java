package com.example.testapp.model;

import java.util.List;

import lombok.Data;

@Data
public class ResponseJson {

    long page;
    List<MovieItem> results;

}
