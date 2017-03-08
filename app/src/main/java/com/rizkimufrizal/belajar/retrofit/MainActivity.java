package com.rizkimufrizal.belajar.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.rizkimufrizal.belajar.retrofit.configuration.RetrofitConfiguration;
import com.rizkimufrizal.belajar.retrofit.helper.ConvertEmptyStringToStringPlus;
import com.rizkimufrizal.belajar.retrofit.model.response.TrackResponse;
import com.rizkimufrizal.belajar.retrofit.repository.TrackRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TrackRepository trackRepository = RetrofitConfiguration.getConfigurationRetrofit().create(TrackRepository.class);
        Call<TrackResponse> trackResponseCall = trackRepository.getTrackResponseCall(ConvertEmptyStringToStringPlus.toStringPlus("Linkin Park"), "track", 10, 1);
        trackResponseCall.enqueue(new Callback<TrackResponse>() {
            @Override
            public void onResponse(Call<TrackResponse> call, Response<TrackResponse> response) {
                try {
                    Toast.makeText(MainActivity.this, " response version " + response.body().getTrack().getItems().get(0).getName(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<TrackResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
