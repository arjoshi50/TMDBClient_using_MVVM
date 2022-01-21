package com.finapp.tmdbclient_using_mvvm.data.repository.movie.datasource

import com.finapp.tmdbclient_using_mvvm.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movie: List<Movie>)
}