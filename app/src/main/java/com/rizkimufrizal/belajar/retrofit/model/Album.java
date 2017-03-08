package com.rizkimufrizal.belajar.retrofit.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rizkimufrizal on 3/8/17.
 */

public class Album implements Serializable {

    @SerializedName("name")
    private String name;

    @SerializedName("album_type")
    private String albumType;

    @SerializedName("images")
    private List<Image> images;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlbumType() {
        return albumType;
    }

    public void setAlbumType(String albumType) {
        this.albumType = albumType;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
