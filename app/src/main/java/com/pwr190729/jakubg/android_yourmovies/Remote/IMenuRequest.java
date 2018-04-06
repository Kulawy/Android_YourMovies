package com.pwr190729.jakubg.android_yourmovies.Remote;

import com.pwr190729.jakubg.android_yourmovies.Movie;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by JakubG on 06.04.2018.
 */

public interface IMenuRequest {
    @GET
    Call<List<Movie>> getMenuList(@Url String url);
}
