package com.vogella.java.projetmobile;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vogella.java.projetmobile.model.Anime;
import com.vogella.java.projetmobile.model.RestAnimeResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailsController {
    private DetailsActivity activity;

    public DetailsController(DetailsActivity detailsActivity) {
        this.activity = detailsActivity;
    }

    public void onStart(){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.jikan.moe/v3/anime/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        JikanAPI restAnimeApi = retrofit.create(JikanAPI.class);

        /*Call<RestAnimeResponse> call = restAnimeApi.getListAnime();
        call.enqueue(new Callback<RestAnimeResponse>() {
            @Override
            public void onResponse(Call<RestAnimeResponse> call,
                                   Response<RestAnimeResponse> response) {
                RestAnimeResponse restAnimeResponse = response.body();
                List<Anime> listAnime = restAnimeResponse.getResults();
                activity.showList(listAnime);
            }

            @Override
            public void onFailure(Call<RestAnimeResponse> call, Throwable t) {
                Log.d("ERROR", "Api Error");
            }
        });*/
    }
}
