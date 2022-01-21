package com.finapp.tmdbclient_using_mvvm.data.repository.movie

import com.finapp.tmdbclient_using_mvvm.data.model.movie.Movie
import com.finapp.tmdbclient_using_mvvm.domain.repository.MovieRepository

class FakeMovieRepository: MovieRepository {

    private val movies = mutableListOf<Movie>()

    init {
        movies.add(Movie(1,"overview1","path1","data1","title1"))
        movies.add(Movie(2,"overview2","path2","data2","title2"))
    }
    override suspend fun getMovies(): List<Movie>? {
        return movies
    }

    override suspend fun updateMovies(): List<Movie>? {
        movies.clear()
        movies.add(Movie(3,"overview3","path3","data3","title3"))
        movies.add(Movie(4,"overview4","path4","data4","title4"))
        return movies
    }
}