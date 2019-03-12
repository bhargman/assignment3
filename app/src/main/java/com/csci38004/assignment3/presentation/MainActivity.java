package com.csci38004.assignment3.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.csci38004.assignment3.R;
import com.csci38004.assignment3.data.ServiceCreator;
import com.csci38004.assignment3.data.SharedPreferencesHelper;
import com.csci38004.assignment3.data.model.CategoriesResponseModel;
import com.csci38004.assignment3.data.model.CategoryIcon;
import com.csci38004.assignment3.data.model.CategoryItem;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ImageView categoryIconImageView;
    private TextView categoryNameTextView;
    private Button randomButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        getRandomCategory();
    }

    private void initViews() {
        categoryIconImageView = findViewById(R.id.categoryIconImageView);
        categoryNameTextView = findViewById(R.id.categoryNameTextView);
        randomButton = findViewById(R.id.randomButton);
        randomButton.setOnClickListener(v -> startActivity(new Intent(this, PlaylistActivity.class)));
    }

    /**
     * Update this method to load url into categoryIconImageView using {@link Glide}.
     */
    private void loadImage(String url) {

    }

    /**
     * - Update the if(response.isSuccessful()) block to:
     *      - populate categoryNameTextView with {@link CategoryItem#getName()}
     *      - call {@link this#loadImage(String)} with {@link CategoryIcon#getUrl()}
     *      - call {@link this#saveCategoryId(String)} with {@link CategoryItem#getId()}
     */
    private void getRandomCategory() {
        ServiceCreator.createSpotifyService()
                .getCategories()
                .enqueue(new Callback<CategoriesResponseModel>() {
                    @Override
                    public void onResponse(Call<CategoriesResponseModel> call,
                                           Response<CategoriesResponseModel> response) {
                        if (response.isSuccessful()) {
                            final CategoryItem categoryItem = CategoryItemUtil.getRandomCategoryItem(response.body());
                            final CategoryIcon categoryIcon = CategoryItemUtil.getRandomCategoryIcon(categoryItem);
                        } else {
                            Log.e(MainActivity.class.getSimpleName(), "Unsuccessful response!");
                        }
                    }

                    @Override
                    public void onFailure(Call<CategoriesResponseModel> call, Throwable t) {

                    }
                });
    }

    private void saveCategoryId(String categoryId) {
        final SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper();
        sharedPreferencesHelper.saveCategoryId(this, categoryId);
    }
}
