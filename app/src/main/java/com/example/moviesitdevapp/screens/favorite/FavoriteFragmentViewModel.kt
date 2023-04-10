package com.example.moviesitdevapp.screens.favorite

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.moviesitdevapp.data.room.repository.MoviesRepositoryImpl
import com.example.moviesitdevapp.model.MovieItemModel
import com.example.moviesitdevapp.utils.dbRepository

class FavoriteFragmentViewModel(application: Application) : AndroidViewModel(application) {
    fun getAllMoviesFromDB(): LiveData<List<MovieItemModel>> {
        return dbRepository.allMovies
    }

}