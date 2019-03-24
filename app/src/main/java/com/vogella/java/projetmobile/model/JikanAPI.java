package com.vogella.java.projetmobile.model;


import retrofit2.Call;
import retrofit2.http.GET;

public interface JikanAPI {

    @GET("top/anime/"+"1")
    Call<RestAnimeResponse> getListAnime();
}
