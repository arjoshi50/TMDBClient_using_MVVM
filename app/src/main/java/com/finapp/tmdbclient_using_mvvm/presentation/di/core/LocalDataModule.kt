package com.finapp.tmdbclient_using_mvvm.presentation.di.core

import com.finapp.tmdbclient_using_mvvm.data.db.ArtistDao
import com.finapp.tmdbclient_using_mvvm.data.db.MovieDao
import com.finapp.tmdbclient_using_mvvm.data.db.TvShowDao
import com.finapp.tmdbclient_using_mvvm.data.repository.artist.daasource.ArtistLocalDataSource
import com.finapp.tmdbclient_using_mvvm.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.finapp.tmdbclient_using_mvvm.data.repository.movie.datasource.MovieLocalDataSource
import com.finapp.tmdbclient_using_mvvm.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.finapp.tmdbclient_using_mvvm.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.finapp.tmdbclient_using_mvvm.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource{
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource{
        return ArtistLocalDataSourceImpl(artistDao)
    }
}
