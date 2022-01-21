package com.finapp.tmdbclient_using_mvvm.presentation.di.core

import com.finapp.tmdbclient_using_mvvm.data.repository.artist.ArtistRepositoryImpl
import com.finapp.tmdbclient_using_mvvm.data.repository.artist.daasource.ArtistCacheDataSource
import com.finapp.tmdbclient_using_mvvm.data.repository.artist.daasource.ArtistLocalDataSource
import com.finapp.tmdbclient_using_mvvm.data.repository.artist.daasource.ArtistRemoteDataSource
import com.finapp.tmdbclient_using_mvvm.data.repository.movie.MovieRepositoryImpl
import com.finapp.tmdbclient_using_mvvm.data.repository.movie.datasource.MovieCacheDataSource
import com.finapp.tmdbclient_using_mvvm.data.repository.movie.datasource.MovieLocalDataSource
import com.finapp.tmdbclient_using_mvvm.data.repository.movie.datasource.MovieRemoteDataSource
import com.finapp.tmdbclient_using_mvvm.data.repository.tvshow.TvShowRepositoryImpl
import com.finapp.tmdbclient_using_mvvm.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.finapp.tmdbclient_using_mvvm.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.finapp.tmdbclient_using_mvvm.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.finapp.tmdbclient_using_mvvm.domain.repository.ArtistRepository
import com.finapp.tmdbclient_using_mvvm.domain.repository.MovieRepository
import com.finapp.tmdbclient_using_mvvm.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ):MovieRepository{
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ):TvShowRepository{
        return TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ):ArtistRepository{
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }
}