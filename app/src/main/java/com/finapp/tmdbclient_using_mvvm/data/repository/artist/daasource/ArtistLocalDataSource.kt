package com.finapp.tmdbclient_using_mvvm.data.repository.artist.daasource

import com.finapp.tmdbclient_using_mvvm.data.model.artist.Artist
import com.finapp.tmdbclient_using_mvvm.data.model.movie.Movie

interface ArtistLocalDataSource {

    suspend fun getArtistFromDB(): List<Artist>
    suspend fun saveArtistToDB(movie: List<Artist>)
    suspend fun clearAll()
}