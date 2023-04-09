package com.example.moviesitdevapp.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.moviesitdevapp.data.retrofit.repository.RetrofitRepositoryImpl
import com.example.moviesitdevapp.model.MoviesModel
import kotlinx.coroutines.launch
import retrofit2.Response

class MainFragmentViewModel(application: Application) : AndroidViewModel(application) {
    val repository = RetrofitRepositoryImpl()
    val movies: MutableLiveData<Response<MoviesModel>> = MutableLiveData()

    fun getMovies() {
        viewModelScope.launch {
            movies.value = repository.getMovies()
        }
    }
}