package com.finapp.tmdbclient_using_mvvm.domain.repository

import com.finapp.tmdbclient_using_mvvm.data.model.artist.Artist

interface ArtistRepository  {

    suspend fun getArtist(): List<Artist>?
    suspend fun updateArtist(): List<Artist>?

}