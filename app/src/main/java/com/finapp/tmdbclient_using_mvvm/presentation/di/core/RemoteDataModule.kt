package com.finapp.tmdbclient_using_mvvm.presentation.di.core

import com.finapp.tmdbclient_using_mvvm.data.api.TMDBService
import com.finapp.tmdbclient_using_mvvm.data.repository.artist.daasource.ArtistRemoteDataSource
import com.finapp.tmdbclient_using_mvvm.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.finapp.tmdbclient_using_mvvm.data.repository.movie.datasource.MovieRemoteDataSource
import com.finapp.tmdbclient_using_mvvm.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.finapp.tmdbclient_using_mvvm.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.finapp.tmdbclient_using_mvvm.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource{
        return TvShowRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource{
        return ArtistRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }
}