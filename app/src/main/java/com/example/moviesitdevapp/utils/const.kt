package com.example.moviesitdevapp.utils

import com.example.moviesitdevapp.MainActivity
import com.example.moviesitdevapp.data.room.repository.MoviesRepositoryImpl

lateinit var MAIN: MainActivity
lateinit var dbRepository: MoviesRepositoryImpl

const val BASE_URL = "https://api.themoviedb.org/"
//const val BASE_URL = "https://api.themoviedb.org/3/movie/popular?api_key=d7208cee460231fc7f8afb079ae2abbf&language=en-US"