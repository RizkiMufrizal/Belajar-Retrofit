package com.rizkimufrizal.belajar.retrofit.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by rizkimufrizal on 3/8/17.
 */

public class Image implements Serializable {

    public Image() {
    }

    public Image(String url, Integer height, Integer width) {
        this.url = url;
        this.height = height;
        this.width = width;
    }

    @SerializedName("url")
    private String url;

    @SerializedName("height")
    private Integer height;

    @SerializedName("width")
    private Integer width;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }
}
