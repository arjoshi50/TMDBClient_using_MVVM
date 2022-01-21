package com.finapp.tmdbclient_using_mvvm.data.repository.movie.datasource

import com.finapp.tmdbclient_using_mvvm.data.model.movie.Movie

interface MovieLocalDataSource {

    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movie: List<Movie>)
    suspend fun clearAll()
}