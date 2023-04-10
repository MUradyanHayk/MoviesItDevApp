package com.example.moviesitdevapp.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.moviesitdevapp.model.MovieItemModel

@Dao
interface MoviesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(model: MovieItemModel)

    @Delete
    suspend fun delete(model: MovieItemModel)

    @Query("SELECT * FROM _movies_table")
    fun getAllMovies(): LiveData<List<MovieItemModel>>
}