package com.example.tmdb;

import static com.example.tmdb.ApiKeys.API_KEY;

public class URLs {

    public final static String BASE_URL = "https://api.themoviedb.org/3/";
    public final static String IMAGE_BASE = "https://image.tmdb.org/t/p/w500/";

    public final static String TRENDING_MOVIES_WEEK = "trending/movie/week?api_key=" + API_KEY;
    public final static String TRENDING_TV_WEEK = "trending/tv/week?api_key=" + API_KEY;
    final static String GENRE_LIST = "genre/movie/list?api_key=" + API_KEY;
}
