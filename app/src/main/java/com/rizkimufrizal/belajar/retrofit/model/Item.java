package com.rizkimufrizal.belajar.retrofit.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by rizkimufrizal on 3/8/17.
 */

public class Item implements Serializable {

    @SerializedName("name")
    private String name;

    @SerializedName("album")
    private Album album;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
