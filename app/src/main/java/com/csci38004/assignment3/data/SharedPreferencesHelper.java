package com.csci38004.assignment3.data;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesHelper {

    private static SharedPreferences get(final Context context) {
        return context.getSharedPreferences("spotify_browser", Context.MODE_PRIVATE);
    }

    /**
     * Use the {@link SharedPreferencesHelper#get(Context)} method above to get an instance of
     * SharedPreferences, and persist the categoryId that's passed into this method.
     */
    public void saveCategoryId(final Context context,
                               final String categoryId) {

    }

    /**
     * Replace the return statement below by using the
     * {@link SharedPreferencesHelper#get(Context)} method above to get an instance of
     * SharedPreferences, and reading the persisted categoryId.
     */
    public String readCategoryId(final Context context) {
        return "";
    }
}
