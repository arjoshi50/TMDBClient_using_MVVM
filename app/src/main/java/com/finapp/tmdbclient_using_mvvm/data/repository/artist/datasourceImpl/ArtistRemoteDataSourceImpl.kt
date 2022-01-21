package com.finapp.tmdbclient_using_mvvm.data.repository.artist.datasourceImpl

import com.finapp.tmdbclient_using_mvvm.data.api.TMDBService
import com.finapp.tmdbclient_using_mvvm.data.model.artist.ArtistList
import com.finapp.tmdbclient_using_mvvm.data.repository.artist.daasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
    ): ArtistRemoteDataSource {
    override suspend fun getArtist(): Response<ArtistList> =
        tmdbService.getPopularArtistList(apiKey)

}