package com.finapp.tmdbclient_using_mvvm.data.model.movie


import com.finapp.tmdbclient_using_mvvm.data.model.movie.Movie
import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>
)