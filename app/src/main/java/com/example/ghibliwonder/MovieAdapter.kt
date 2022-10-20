package com.example.ghibliwonder

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ghibliwonder.models.Movies
import com.example.ghibliwonder.models.MoviesItem

class MovieAdapter(val movies: List<MoviesItem>,val activity: Activity) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val txtTitle = itemView.findViewById<TextView>(R.id.txtTitle)
        val img = itemView.findViewById<ImageView>(R.id.image)
        val txtYear = itemView.findViewById<TextView>(R.id.txtYear)

    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie : MoviesItem = movies[position]
        //Main Activity items
        holder.txtTitle.setText(movie.title)
        holder.txtYear.setText(movie.releaseDate)
        Glide.with(activity).load(movie.image).into(holder.img)

        //Movie activity items

        holder.img.setOnClickListener {
            val moviedescp = movie.description
            val movietitle = movie.title
            val movieBannerurl = movie.movieBanner
            val intent = Intent(activity,MovieActivity::class.java )
            intent.putExtra("title_key",movietitle)
            intent.putExtra("desc_key",moviedescp)
            intent.putExtra("image_url",movieBannerurl)
            activity.startActivity(intent)


        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_look,parent,false)
        return ViewHolder(view)
    }

}