package com.zybooks.taltonsflixster

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter(private val context: Context, private val movies: List<Movie>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        // Return a new holder instance
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        // Set item views based on views and data model
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val poster = itemView.findViewById<ImageView>(R.id.ivPoster)
        private val overview = itemView.findViewById<TextView>(R.id.tvOverview)
        private val movieTitle = itemView.findViewById<TextView>(R.id.tvTitle)

        fun bind(movie : Movie) {
            movieTitle.text = movie.title
            overview.text = movie.overview
            Glide.with(context).load(movie.posterImageUrl).into(poster)

        }
    }
}