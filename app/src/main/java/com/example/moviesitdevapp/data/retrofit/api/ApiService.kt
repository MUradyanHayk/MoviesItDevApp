package com.example.moviesitdevapp.data.retrofit.api

import com.example.moviesitdevapp.model.MoviesModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("3/movie/popular?api_key=d7208cee460231fc7f8afb079ae2abbf&language=en-US")
    suspend fun getPopularMovies(): Response<MoviesModel>
}