# CSCI 380-01: Assignment 3 - Due by 11:59 PM, Nov 20th, 2019
* * * 

	 By now, you should have Android Studio setup with an emulator. This assignment will let you play 
	 around with the data layer using Spotify's public API.
	 
	 Make sure to follow the same naming conventions for all of your projects:
	 (https://google.github.io/styleguide/javaguide.html#s5-naming).
	 
	 Also make sure to complete each part in different git commits! 
	 See Lecture 7 (https://bhargman.github.io/csci-380-04/docs/CSCI-380-04-Lecture-7.pdf) 
	 slides to learn about the APIs needed for this assignment. 

# Part 0 - Github Setup - 5%
+ Setup this assignment the same way you did for your previous assignments (see [https://github.com/bhargman/assignment1#part-1---github-setup---5](https://github.com/bhargman/assignment1#part-1---github-setup---5). Name your repo
`assignment3` this time)
+ Add me as a collaborator (username : `bhargman`) to your private repo (see [https://help.github.com/articles/inviting-collaborators-to-a-personal-repository/](https://help.github.com/articles/inviting-collaborators-to-a-personal-repository/)).
    + **If you don't do this step, I'll have no way of grading your assignment**

# Part 1 - Spotify API_KEY - 10%
+ You will need to create a Spotify account in order to get a developer API_KEY (expires every hour, so repeat these steps if you have an expired API_KEY)
    + Create a Spotify account at [https://www.spotify.com/us/signup/](https://www.spotify.com/us/signup/) (or login with an existing account if you don't mind
    using the same account for development).
    + Once logged in, go to any Spotify API console, for example [https://developer.spotify.com/console/get-browse-categories/](https://developer.spotify.com/console/get-browse-categories/)
    + Tap on `GET TOKEN`:\
        <img src="/images/get_token_before.png" width="480">
    + Tap on `REQUEST TOKEN` (leave all boxes unchecked):\
        <img src="/images/request_token.png" width="480">
    + Tap on `AGREE`:\
        <img src="/images/agree.png" width="480">
    + You should now have an API_KEY populated on your console. You'll be using this API_KEY in `SpotifyService.java`. Tap `TRY IT` to try a request.:\
        <img src="/images/get_token_after.png" width="480">
    
+ **NOTE: Your API_KEY will expire every hour, so make sure to repeat these steps every hour to
generate and use a new API_KEY! You'll know your API_KEY is expired if you get an unsuccessful Retrofit response,
or if you try it in the API console and you get this:**

<img src="/images/401.png" width="480">

# Part 2 - Android Studio - 5%
+ Import your `assignment3` repo into Android Studio
    + In the main Android Studio window, tap on "Open an existing Android Studio project"
    + Browse to your `assignment3` folder and select to open it
    + Android Studio will now load the project and you should be able to do the rest of this assignment
        + Note: This may take a few minutes, wait until the processes/indexing spinner in the lower right hand corner is complete
        + Make sure to let Android Studio have access to the internet while it loads the project, so it can fetch dependencies
        + If you get any pop up asking you to update the `Android Gradle Plugin`, please select `Don't remind me again for this project`
    + Browse the code to see what sort of classes are available for you. Specifically, compare the `Categories` models
    to the JSON output from the Spotify API console [https://developer.spotify.com/console/get-browse-categories/](https://developer.spotify.com/console/get-browse-categories/)
    + Use [https://jsonlint.com/](https://jsonlint.com/) if you need to view the JSON output in a cleaner view.

# Part 3 - PlaylistsResponseModel - 15%
+ Try out the API for category playlists at [https://developer.spotify.com/console/get-category-playlists/](https://developer.spotify.com/console/get-category-playlists/)
+ Analyze the JSON response to figure out how the objects are architected. Use [https://jsonlint.com/](https://jsonlint.com/) if you need to view the JSON output in a cleaner view.
    + Remember that lists are enclosed in [...] and objects are enclosed in {...}
    + Compare the output with the categories API and its existing models in this project if it helps: [https://developer.spotify.com/console/get-browse-categories/](https://developer.spotify.com/console/get-browse-categories/)
+ Update `PlaylistsResponseModel` to have enough information to get a playlist item, its name, and its images.


# Part 4 - SharedPreferencesHelper - 10%
+ Open up `SharedPreferencesHelper`
+ Update `saveCategoryId()` and `readCategoryId()` as described. Make sure to use the same key when saving/reading the category id!

# Part 5 - SpotifyService - 5%
+ Update `API_KEY` with your API_KEY (refreshing it as needed)
+ Update the annotations on `getCategoryPlaylist()` to make sure it has the proper headers and URL value

# Part 6 - CategoryItemUtil - 10%
+ Open up `CategoryItemUtil`
+ Update `getRandomCategoryItem()` and `getRandomCategoryIcon()` as described. You MUST return a random value using `Random#nextInt()`! 

# Part 7 - PlaylistItemUtil - 10%
+ By now, you should have a model representing a playlist item and playlist item's image.
+ Update `getRandomPlaylistItem()` to return a random playlist item with the given `PlaylistsResponseModel`. Make sure to also update the method signature to return your
playlist item, instead of `Object`.
+ Update `getRandomPlaylistImage()` to return a random playlist item's image. You'll need to update the parameter's type from `Object` to whatever class you created to represent
a playlist item. Make sure to also update the method signature to return your playlist item's image, instead of `Object`.

# Part 8 - MainActivity - 15%
+ Open up `MainActivity` and look through its layout (`activity_main`). Its views have already been initialized for you.
+ Update `loadImage()` and `getRandomCategory()` as described

# Part 9 - PlaylistActivity - 15%
+ Open up `PlaylistActivity` and look through its layout (`activity_playlist`). Its views have already been initialized for you.
+ Update `loadImage()` and `getRandomPlaylist()` as described 