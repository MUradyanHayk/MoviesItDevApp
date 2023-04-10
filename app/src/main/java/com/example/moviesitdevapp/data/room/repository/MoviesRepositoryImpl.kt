package com.example.moviesitdevapp.data.room.repository

import androidx.lifecycle.LiveData
import com.example.moviesitdevapp.data.room.dao.MoviesDao
import com.example.moviesitdevapp.model.MovieItemModel

class MoviesRepositoryImpl(private val movieDao: MoviesDao) : IMoviesRepository {
    override val allMovies: LiveData<List<MovieItemModel>>
        get() = movieDao.getAllMovies()

    override suspend fun insertMovie(movieItemModel: MovieItemModel, onSuccess: () -> Unit) {
        movieDao.insert(movieItemModel)
        onSuccess()
    }

    override suspend fun deleteMovie(movieItemModel: MovieItemModel, onSuccess: () -> Unit) {
        movieDao.delete(movieItemModel)
        onSuccess()
    }
}