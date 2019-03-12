package com.csci38004.assignment3.data;

import com.csci38004.assignment3.data.model.CategoriesResponseModel;
import com.csci38004.assignment3.data.model.PlaylistsResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface SpotifyService {

    /**
     * NOTE: Your API_KEY will expire every hour, so if you get a '401 Unauthorized' response error,
     * then make sure to generate a new API_KEY following the steps in Part 1 of the readme file!
     */
    String API_KEY = "";

    @Headers("Authorization: Bearer " + API_KEY)
    @GET("/v1/browse/categories")
    Call<CategoriesResponseModel> getCategories();

    /**
     * Update this method with the proper {@link Headers} and {@link GET} annotations.
     */
    Call<PlaylistsResponseModel> getCategoryPlaylist(@Path("category_id") String categoryId);
}
