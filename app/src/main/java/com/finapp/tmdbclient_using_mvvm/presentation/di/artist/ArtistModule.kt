package com.finapp.tmdbclient_using_mvvm.presentation.di.artist

import com.finapp.tmdbclient_using_mvvm.domain.usecase.GetArtistUseCase
import com.finapp.tmdbclient_using_mvvm.domain.usecase.UpdateArtistUseCase
import com.finapp.tmdbclient_using_mvvm.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ):ArtistViewModelFactory{
        return ArtistViewModelFactory(
            getArtistUseCase, updateArtistUseCase
        )
    }
}