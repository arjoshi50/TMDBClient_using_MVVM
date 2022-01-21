package com.finapp.tmdbclient_using_mvvm.domain.usecase

import com.finapp.tmdbclient_using_mvvm.data.model.movie.Movie
import com.finapp.tmdbclient_using_mvvm.domain.repository.MovieRepository

class UpdateMoviesUsecase(private val movieRepository: MovieRepository) {

    suspend fun execute():List<Movie>? = movieRepository.updateMovies()
}