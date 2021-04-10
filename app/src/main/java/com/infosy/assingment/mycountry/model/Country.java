package com.infosy.assingment.mycountry.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Country {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("rows")
    @Expose
    private List<CountryDetails> rows = null;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<CountryDetails> getRows() {
        return rows;
    }

    public void setRows(List<CountryDetails> rows) {
        this.rows = rows;
    }
}
