package com.finapp.tmdbclient_using_mvvm.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.finapp.tmdbclient_using_mvvm.domain.usecase.GetTvShowUseCase
import com.finapp.tmdbclient_using_mvvm.domain.usecase.UpdateTvShowUsecase

class TvShowViewModelFactory(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUsecase: UpdateTvShowUsecase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowUseCase,updateTvShowUsecase) as T
    }


}