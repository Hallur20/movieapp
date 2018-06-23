package com.example.hvn15.shownotifier;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface MyApiEndpointInterface {
    // Request method and URL specified in the annotation
    @GET("3/configuration/countries")
    Call<List<Country>> getUser(@Query("api_key") String key);
    @GET("3/search/movie")
    Call<Movie>getMovie(
            @Query("api_key") String key,
            @Query("language") String language,
            @Query("query") String query,
            @Query("page") int page,
            @Query("include_adult") boolean include_adult
    );
}
