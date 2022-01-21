package com.finapp.tmdbclient_using_mvvm.presentation.di.core

import com.finapp.tmdbclient_using_mvvm.domain.repository.ArtistRepository
import com.finapp.tmdbclient_using_mvvm.domain.repository.MovieRepository
import com.finapp.tmdbclient_using_mvvm.domain.repository.TvShowRepository
import com.finapp.tmdbclient_using_mvvm.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository):GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository):UpdateMoviesUsecase{
        return UpdateMoviesUsecase(movieRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository):GetTvShowUseCase{
        return GetTvShowUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository):UpdateTvShowUsecase{
        return UpdateTvShowUsecase(tvShowRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository):GetArtistUseCase{
        return GetArtistUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository):UpdateArtistUseCase{
        return UpdateArtistUseCase(artistRepository)
    }
}