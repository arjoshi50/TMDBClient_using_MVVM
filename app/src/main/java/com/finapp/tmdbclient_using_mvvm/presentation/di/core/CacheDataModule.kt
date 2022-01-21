package com.finapp.tmdbclient_using_mvvm.presentation.di.core

import com.finapp.tmdbclient_using_mvvm.data.repository.artist.daasource.ArtistCacheDataSource
import com.finapp.tmdbclient_using_mvvm.data.repository.artist.datasourceImpl.ArtistCachelDataSourceImpl
import com.finapp.tmdbclient_using_mvvm.data.repository.movie.datasource.MovieCacheDataSource
import com.finapp.tmdbclient_using_mvvm.data.repository.movie.datasourceImpl.MovieCachelDataSourceImpl
import com.finapp.tmdbclient_using_mvvm.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.finapp.tmdbclient_using_mvvm.data.repository.tvshow.datasourceImpl.TvShowCachelDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource():MovieCacheDataSource{
        return MovieCachelDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource():TvShowCacheDataSource{
        return TvShowCachelDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource():ArtistCacheDataSource{
        return ArtistCachelDataSourceImpl()
    }

}