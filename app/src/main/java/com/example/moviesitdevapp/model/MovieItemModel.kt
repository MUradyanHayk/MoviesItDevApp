package com.example.moviesitdevapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
@Entity(tableName = "_movies_table")
data class MovieItemModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo
    val adult: Boolean,
    @ColumnInfo
    val backdrop_path: String,
    @ColumnInfo
    val genre_ids: List<Int>,
    @ColumnInfo
    val original_language: String,
    @ColumnInfo
    val original_title: String,
    @ColumnInfo
    val overview: String,
    @ColumnInfo
    val popularity: Double,
    @ColumnInfo
    val poster_path: String,
    @ColumnInfo
    val release_date: String,
    @ColumnInfo
    val title: String,
    @ColumnInfo
    val video: Boolean,
    @ColumnInfo
    val vote_average: Double,
    @ColumnInfo
    val vote_count: Int
) : Serializable