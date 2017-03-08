package com.rizkimufrizal.belajar.retrofit.configuration;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rizkimufrizal on 3/8/17.
 */

public class RetrofitConfiguration {

    public static Retrofit getConfigurationRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Constant.BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
