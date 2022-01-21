package com.finapp.tmdbclient_using_mvvm.data.repository.movie.datasourceImpl

import com.finapp.tmdbclient_using_mvvm.data.model.movie.Movie
import com.finapp.tmdbclient_using_mvvm.data.repository.movie.datasource.MovieCacheDataSource

class MovieCachelDataSourceImpl: MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movie: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movie)
    }
}