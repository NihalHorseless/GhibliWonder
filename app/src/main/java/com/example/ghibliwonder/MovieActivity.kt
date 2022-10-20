package com.example.ghibliwonder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class MovieActivity : AppCompatActivity() {
   lateinit var movietitle : TextView
   lateinit var movieDesc : TextView
   lateinit var movieBanner : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        movietitle = findViewById(R.id.textTitle)
        movieDesc = findViewById(R.id.textDescription)
        movieBanner = findViewById(R.id.banner)
        val intent = intent
        val tit = intent.getStringExtra("title_key")
        val descp = intent.getStringExtra("desc_key")
        val url = intent.getStringExtra("image_url")
        Glide.with(movieBanner).load(url).into(movieBanner)
        movietitle.text = tit
        movieDesc.text = descp
        movieDesc.movementMethod = ScrollingMovementMethod()

    }

}