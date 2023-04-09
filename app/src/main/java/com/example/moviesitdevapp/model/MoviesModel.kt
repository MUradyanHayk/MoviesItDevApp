package com.example.moviesitdevapp.model

import com.google.gson.annotations.SerializedName

data class MoviesModel(
    val page: Int,
    @SerializedName("results")
    val movieItemModels: List<MovieItemModel>,
    val total_pages: Int,
    val total_results: Int
)