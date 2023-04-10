package com.example.moviesitdevapp.screens.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.moviesitdevapp.model.MovieItemModel
import com.example.moviesitdevapp.utils.MAIN
import com.example.moviesitdevapp.utils.SaveSharedManager
import com.example.moviesitdevapp.utils.dbRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailFragmentViewModel(application: Application) : AndroidViewModel(application) {

    val isFavorite = MutableLiveData<Boolean>()

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


    fun onFavoriteClick(currentMovie: MovieItemModel, isFavorite: Boolean) {
        if (!isFavorite) {
            insert(currentMovie) {
                viewModelScope.launch(Dispatchers.Main) {
                    SaveSharedManager.setFavorite(MAIN, currentMovie.id.toString(), !isFavorite)
                    this@DetailFragmentViewModel.isFavorite.value = !isFavorite
                }
            }
        } else {
            delete(currentMovie) {
                viewModelScope.launch(Dispatchers.Main) {
                    SaveSharedManager.setFavorite(MAIN, currentMovie.id.toString(), !isFavorite)
                    this@DetailFragmentViewModel.isFavorite.value = !isFavorite
                }
            }
        }
    }

}