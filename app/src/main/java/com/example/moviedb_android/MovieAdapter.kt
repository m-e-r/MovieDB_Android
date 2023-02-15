package com.example.moviedb_android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MovieAdapter(private val data: ArrayList<Movie>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    inner class ViewHolder(item : View): RecyclerView.ViewHolder(item){
        val movieTitle : TextView = item.findViewById(R.id.title)
        val movieDesc : TextView = item.findViewById(R.id.desc)
        val image : ImageView = item.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_details, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.movieTitle.text = data[position].title
        holder.movieDesc.text = data[position].overview
        Picasso.get().load(data[position].poster_path).into(holder.image)
    }

    override fun getItemCount(): Int {
        return data.size
    }

}