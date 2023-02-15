package com.example.moviedb_android

import retrofit2.Call
import retrofit2.http.GET

const val API_KEY = "756bf827e49cc2458663de986947eadd"

interface MovieService {

    @GET("popular?api_key=$API_KEY")
    fun getPopularMovies() : Call<MovieResponse>

}