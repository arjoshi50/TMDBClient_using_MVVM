package com.finapp.tmdbclient_using_mvvm.data.repository.movie.datasourceImpl

import com.finapp.tmdbclient_using_mvvm.data.api.TMDBService
import com.finapp.tmdbclient_using_mvvm.data.model.movie.MovieList
import com.finapp.tmdbclient_using_mvvm.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
    ): MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> =
        tmdbService.getPopularMovies(apiKey)

}