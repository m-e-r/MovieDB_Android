package com.example.moviedb_android

import java.util.*

data class Movie(
    val title: String,
    val poster_path: String,
    val overview: String,
    val id: String)

data class MovieResponse (val page:Int,
                          val total_results:Int,
                          val total_pages:Int,
                          val results:List<Movie>,
)