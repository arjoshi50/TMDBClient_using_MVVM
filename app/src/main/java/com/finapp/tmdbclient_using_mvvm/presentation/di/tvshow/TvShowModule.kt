package com.finapp.tmdbclient_using_mvvm.presentation.di.tvshow

import com.finapp.tmdbclient_using_mvvm.domain.usecase.GetArtistUseCase
import com.finapp.tmdbclient_using_mvvm.domain.usecase.GetTvShowUseCase
import com.finapp.tmdbclient_using_mvvm.domain.usecase.UpdateArtistUseCase
import com.finapp.tmdbclient_using_mvvm.domain.usecase.UpdateTvShowUsecase
import com.finapp.tmdbclient_using_mvvm.presentation.artist.ArtistViewModelFactory
import com.finapp.tmdbclient_using_mvvm.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowUseCase: GetTvShowUseCase,
        updateTvShowUsecase: UpdateTvShowUsecase
    ):TvShowViewModelFactory{
        return TvShowViewModelFactory(
            getTvShowUseCase, updateTvShowUsecase
        )
    }
}