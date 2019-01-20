package com.example.testapp.model;

import java.util.List;

import lombok.Data;

@Data
public class ResponseTvJson {

    long page;
    List<TvSeriesItem> results;

}
