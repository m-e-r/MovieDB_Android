
package com.example.moviedb_android

import android.util.Log
import androidx.annotation.UiThread
import network.RetrofitCalls
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

object MovieLoader {
    private var jsonData : MovieResponse? = null
    lateinit var adapter: MovieAdapter

    fun getMovies() : MovieResponse? {
        loadMovies()
        return jsonData
    }

    fun loadMovies() {

        val jsonAPI = RetrofitCalls.getInstance().create(MovieService::class.java)
        Log.d("1", jsonAPI.toString())
        val call : Call<MovieResponse> = jsonAPI.getPopularMovies()

        call.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(
                call: Call<MovieResponse>,
                response: Response<MovieResponse>
            ) {
                Log.i("netlog0.5", response.body().toString())
                //check if successful and save data
                if(!response.isSuccessful){
                    Log.i("netlog1", "Code: " + response.code())
                    return
                }
                jsonData = response.body()
                Log.i("netlog2", response.body()?.results.toString())
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.i("netlog3", t.message.toString())
            }

        })

    }

}
