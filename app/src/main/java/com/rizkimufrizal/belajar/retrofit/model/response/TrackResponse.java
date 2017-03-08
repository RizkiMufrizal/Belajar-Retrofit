package com.rizkimufrizal.belajar.retrofit.model.response;

import com.google.gson.annotations.SerializedName;
import com.rizkimufrizal.belajar.retrofit.model.Track;

/**
 * Created by rizkimufrizal on 3/8/17.
 */

public class TrackResponse {

    @SerializedName("tracks")
    private Track track;

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }
}
