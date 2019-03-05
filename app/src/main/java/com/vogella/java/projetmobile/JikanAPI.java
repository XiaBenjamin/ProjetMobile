package com.vogella.java.projetmobile;


import com.vogella.java.projetmobile.model.RestAnimeResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JikanAPI {

    @GET("top/anime/1/favorite")
    Call<RestAnimeResponse> getListAnime();
}
