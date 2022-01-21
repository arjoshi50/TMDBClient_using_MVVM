package com.finapp.tmdbclient_using_mvvm.data.repository.artist.daasource

import com.finapp.tmdbclient_using_mvvm.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistFromCache(): List<Artist>
    suspend fun saveArtistToCache(artist: List<Artist>)
}