package com.example.testapp.model;

public enum HistoryItemTypeEnum {

    MOVIE_ITEM (1),
    TV_SERIES_ITEM(2);

    private int id;

    HistoryItemTypeEnum(int id){
        this.id = id;
    }


    public int getId() {
        return id;
    }
}
