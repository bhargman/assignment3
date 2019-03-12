package com.csci38004.assignment3.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceCreator {

    public static SpotifyService createSpotifyService() {
        return new Retrofit.Builder()
                .baseUrl("https://api.spotify.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SpotifyService.class);
    }
}
