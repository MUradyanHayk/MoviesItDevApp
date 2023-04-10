package com.example.moviesitdevapp.data.room.repository

import androidx.lifecycle.LiveData
import com.example.moviesitdevapp.model.MovieItemModel

interface IMoviesRepository {
    val allMovies: LiveData<List<MovieItemModel>>
    suspend fun insertMovie(movieItemModel: MovieItemModel, onSuccess: () -> Unit = {})
    suspend fun deleteMovie(movieItemModel: MovieItemModel, onSuccess: () -> Unit = {})
}