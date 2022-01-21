package com.finapp.tmdbclient_using_mvvm.data.repository.movie.datasource

import com.finapp.tmdbclient_using_mvvm.data.model.movie.Movie
import com.finapp.tmdbclient_using_mvvm.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies(): Response<MovieList>
}