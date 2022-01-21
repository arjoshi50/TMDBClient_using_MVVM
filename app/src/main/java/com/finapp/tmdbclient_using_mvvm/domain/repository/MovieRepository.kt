package com.finapp.tmdbclient_using_mvvm.domain.repository

import com.finapp.tmdbclient_using_mvvm.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?

}