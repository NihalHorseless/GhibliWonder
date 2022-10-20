package com.example.ghibliwonder

import com.example.ghibliwonder.models.Movies
import retrofit2.Call
import retrofit2.http.GET

interface MovieAPI {
    @GET("films")
    fun getMovies(): Call<Movies>
}