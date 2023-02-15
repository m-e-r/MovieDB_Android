package com.example.moviedb_android

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import network.RetrofitCalls
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : Activity() {

    lateinit var adapter: MovieAdapter
    var movieList : ArrayList<Movie>? = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        //Log.i("last", MovieLoader.getMovies()!!.results.toString())
        var movieList2 = MovieLoader.getMovies()

        adapter = MovieAdapter(movieList!!)
        var recyclerView: RecyclerView = findViewById(R.id.movies)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }

    private fun OnDataReady() {
        while (MovieLoader.getMovies() != null) {
            for (Movie in MovieLoader.getMovies()!!.results) {
                movieList!!.add(Movie)
                adapter.notifyItemInserted(movieList!!.lastIndex)
            }
        }
    }

}