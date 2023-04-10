package com.example.moviesitdevapp.screens.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesitdevapp.data.room.repository.MoviesRepositoryImpl
import com.example.moviesitdevapp.model.MovieItemModel
import com.example.moviesitdevapp.utils.dbRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailFragmentViewModel(application: Application) : AndroidViewModel(application) {
    fun insert(movieItemModel: MovieItemModel, onSuccess: () -> Unit = {}) {
        viewModelScope.launch(Dispatchers.IO) {
            dbRepository.insertMovie(movieItemModel, onSuccess)
        }
    }

    fun delete(movieItemModel: MovieItemModel, onSuccess: () -> Unit = {}) {
        viewModelScope.launch(Dispatchers.IO) {
            dbRepository.deleteMovie(movieItemModel, onSuccess)
        }
    }
}