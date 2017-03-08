package com.rizkimufrizal.belajar.retrofit.repository;

import com.rizkimufrizal.belajar.retrofit.model.response.TrackResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rizkimufrizal on 3/8/17.
 */

public interface TrackRepository {
    @GET("search")
    Call<TrackResponse> getTrackResponseCall(@Query("q") String q, @Query("type") String type, @Query("offset") Integer offset, @Query("limit") Integer limit);
}
