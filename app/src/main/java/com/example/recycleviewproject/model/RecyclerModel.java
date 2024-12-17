package com.example.recycleviewproject.model;

import android.widget.ImageView;

public class RecyclerModel {
    private int date;
    private String title;
    private String description;

    public RecyclerModel(int date, String title, String description) {
        this.date = date;
        this.title = title;
        this.description = description;
    }

    public int getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }


}
