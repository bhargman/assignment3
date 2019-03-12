package com.csci38004.assignment3.presentation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.csci38004.assignment3.R;
import com.csci38004.assignment3.data.ServiceCreator;
import com.csci38004.assignment3.data.SharedPreferencesHelper;
import com.csci38004.assignment3.data.model.PlaylistsResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlaylistActivity extends AppCompatActivity {

    private ImageView playlistImageView;
    private TextView playlistNameTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        initViews();
        getRandomPlaylist();
    }

    private void initViews() {
        playlistImageView = findViewById(R.id.playlistImageView);
        playlistNameTextView = findViewById(R.id.playlistNameTextView);
    }

    /**
     * Update this method to load url into playlistImageView using {@link Glide}.
     */
    private void loadImage(String url) {

    }

    /**
     * - Update the if(response.isSuccessful()) block to:
     *      - Get a random playlist item using {@link PlaylistItemUtil#getRandomPlaylistItem(PlaylistsResponseModel)}
     *      - Get a random playlist item image using {@link PlaylistItemUtil#getRandomPlaylistImage}
     *      - populate playlistNameTextView with the playlist item's name
     *      - call {@link this#loadImage(String)} with the playlist item's image's url
     */
    private void getRandomPlaylist() {
        final SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper();
        ServiceCreator.createSpotifyService()
                .getCategoryPlaylist(sharedPreferencesHelper.readCategoryId(this))
                .enqueue(new Callback<PlaylistsResponseModel>() {
                    @Override
                    public void onResponse(Call<PlaylistsResponseModel> call,
                                           Response<PlaylistsResponseModel> response) {
                        if (response.isSuccessful()) {

                        } else {
                            Log.e(PlaylistActivity.class.getSimpleName(), "Unsuccessful response!");
                        }
                    }

                    @Override
                    public void onFailure(Call<PlaylistsResponseModel> call, Throwable t) {

                    }
                });
    }
}
