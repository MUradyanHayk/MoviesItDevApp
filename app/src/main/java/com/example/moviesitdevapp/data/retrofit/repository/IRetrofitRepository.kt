package com.example.moviesitdevapp.data.retrofit.repository

import com.example.moviesitdevapp.model.MoviesModel
import retrofit2.Response

interface IRetrofitRepository {
    suspend fun getMovies(): Response<MoviesModel>
}