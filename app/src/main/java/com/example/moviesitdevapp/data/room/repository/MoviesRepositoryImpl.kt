package com.example.moviesitdevapp.data.room.repository

import androidx.lifecycle.LiveData
import com.example.moviesitdevapp.model.MovieItemModel

class MoviesRepositoryImpl :IMoviesRepository {
    override val allMovies: LiveData<List<MovieItemModel>>
        get() = TODO("Not yet implemented")

    override suspend fun insertMovie(movieItemModel: MovieItemModel, onSuccess: () -> Unit) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteMovie(movieItemModel: MovieItemModel, onSuccess: () -> Unit) {
        TODO("Not yet implemented")
    }
}