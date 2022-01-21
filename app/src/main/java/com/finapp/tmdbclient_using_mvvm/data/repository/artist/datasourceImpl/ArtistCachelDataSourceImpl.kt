package com.finapp.tmdbclient_using_mvvm.data.repository.artist.datasourceImpl

import com.finapp.tmdbclient_using_mvvm.data.model.artist.Artist
import com.finapp.tmdbclient_using_mvvm.data.repository.artist.daasource.ArtistCacheDataSource

class ArtistCachelDataSourceImpl: ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()
    override suspend fun getArtistFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistToCache(artist: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artist)
    }
}