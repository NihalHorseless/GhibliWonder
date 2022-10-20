package com.example.ghibliwonder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ghibliwonder.models.Movies
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://ghibliapi.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val api = retrofit.create(MovieAPI ::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        api.getMovies().enqueue(object : Callback<Movies>{
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
               val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)
                recyclerview.layoutManager = LinearLayoutManager(this@MainActivity)
                val adapter = MovieAdapter(response.body()!!,this@MainActivity)
                recyclerview.adapter = adapter
            }

            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Log.d("It's not working!",t.message!!)
            }

        })
    }
}