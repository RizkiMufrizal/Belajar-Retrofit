package com.rizkimufrizal.belajar.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rizkimufrizal.belajar.retrofit.adapter.AdapterRowItem;
import com.rizkimufrizal.belajar.retrofit.configuration.RetrofitConfiguration;
import com.rizkimufrizal.belajar.retrofit.helper.ConvertEmptyStringToStringPlus;
import com.rizkimufrizal.belajar.retrofit.model.Item;
import com.rizkimufrizal.belajar.retrofit.model.response.TrackResponse;
import com.rizkimufrizal.belajar.retrofit.repository.TrackRepository;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterRowItem adapterRowItem = new AdapterRowItem();
    private List<Item> itemList = new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;
    private static final Integer PAGE_SIZE = 10;
    private static Integer currentPage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        recyclerView.setAdapter(adapterRowItem);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addOnScrollListener(recyclerViewOnScrollListener);
        loadItems();
    }

    private RecyclerView.OnScrollListener recyclerViewOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            Integer visibleItemCount = linearLayoutManager.getChildCount();
            Integer totalItemCount = linearLayoutManager.getItemCount();
            Integer firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                    && firstVisibleItemPosition >= 0
                    && totalItemCount >= PAGE_SIZE) {
                currentPage = currentPage + PAGE_SIZE;
                loadItems();
            }
        }
    };

    private void loadItems() {
        TrackRepository trackRepository = RetrofitConfiguration.getConfigurationRetrofit().create(TrackRepository.class);
        Call<TrackResponse> trackResponseCall = trackRepository.getTrackResponseCall(ConvertEmptyStringToStringPlus.toStringPlus("Linkin Park"), "track", currentPage, PAGE_SIZE);
        trackResponseCall.enqueue(new Callback<TrackResponse>() {
            @Override
            public void onResponse(Call<TrackResponse> call, Response<TrackResponse> response) {
                try {
                    for (Item item : response.body().getTrack().getItems()) {
                        itemList.add(item);
                    }
                    adapterRowItem.addItem(itemList);
                    recyclerView.setAdapter(adapterRowItem);
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
