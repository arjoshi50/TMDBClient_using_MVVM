package com.finapp.tmdbclient_using_mvvm.data.repository.artist.daasource

import com.finapp.tmdbclient_using_mvvm.data.model.artist.ArtistList
import com.finapp.tmdbclient_using_mvvm.data.model.movie.Movie
import com.finapp.tmdbclient_using_mvvm.data.model.movie.MovieList
import retrofit2.Response

interface ArtistRemoteDataSource {

    suspend fun getArtist(): Response<ArtistList>
}