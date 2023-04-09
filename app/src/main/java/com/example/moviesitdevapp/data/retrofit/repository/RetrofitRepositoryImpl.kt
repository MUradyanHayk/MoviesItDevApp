package com.example.moviesitdevapp.data.retrofit.repository

import com.example.moviesitdevapp.data.retrofit.api.RetrofitInstance
import com.example.moviesitdevapp.model.MoviesModel
import retrofit2.Response

class RetrofitRepositoryImpl: IRetrofitRepository {
    override suspend fun getMovies(): Response<MoviesModel> {
        return RetrofitInstance.api.getPopularMovies()
    }
}