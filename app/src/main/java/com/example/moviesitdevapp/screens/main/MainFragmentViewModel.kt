package com.example.moviesitdevapp.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.moviesitdevapp.data.retrofit.repository.RetrofitRepositoryImpl
import com.example.moviesitdevapp.data.room.db.MoviesRoomDatabase
import com.example.moviesitdevapp.data.room.repository.MoviesRepositoryImpl
import com.example.moviesitdevapp.model.MoviesModel
import com.example.moviesitdevapp.utils.dbRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainFragmentViewModel(application: Application) : AndroidViewModel(application) {
    val retrofitRepository = RetrofitRepositoryImpl()
    val movies: MutableLiveData<Response<MoviesModel>> = MutableLiveData()
    val context = application
    fun getMoviesFromServer() {
        viewModelScope.launch {
            movies.value = retrofitRepository.getMovies()
        }
    }

    fun initDatabase() {
        val movieDao = MoviesRoomDatabase.getInstance(context).getMovieDao()
        dbRepository = MoviesRepositoryImpl(movieDao)
    }


}