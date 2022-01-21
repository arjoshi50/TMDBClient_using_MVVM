package com.finapp.tmdbclient_using_mvvm.presentation.di.movie

import com.finapp.tmdbclient_using_mvvm.domain.usecase.GetArtistUseCase
import com.finapp.tmdbclient_using_mvvm.domain.usecase.GetMoviesUseCase
import com.finapp.tmdbclient_using_mvvm.domain.usecase.UpdateArtistUseCase
import com.finapp.tmdbclient_using_mvvm.domain.usecase.UpdateMoviesUsecase
import com.finapp.tmdbclient_using_mvvm.presentation.artist.ArtistViewModelFactory
import com.finapp.tmdbclient_using_mvvm.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUsecase: UpdateMoviesUsecase
    ):MovieViewModelFactory{
        return MovieViewModelFactory(
            getMoviesUseCase, updateMoviesUsecase
        )
    }
}