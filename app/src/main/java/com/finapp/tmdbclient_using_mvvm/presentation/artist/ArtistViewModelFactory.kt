package com.finapp.tmdbclient_using_mvvm.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.finapp.tmdbclient_using_mvvm.domain.usecase.GetArtistUseCase
import com.finapp.tmdbclient_using_mvvm.domain.usecase.UpdateArtistUseCase

class ArtistViewModelFactory(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistUseCase,updateArtistUseCase) as T
    }
}