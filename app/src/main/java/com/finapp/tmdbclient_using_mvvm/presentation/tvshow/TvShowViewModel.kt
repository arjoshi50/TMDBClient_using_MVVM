package com.finapp.tmdbclient_using_mvvm.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.finapp.tmdbclient_using_mvvm.domain.usecase.GetTvShowUseCase
import com.finapp.tmdbclient_using_mvvm.domain.usecase.UpdateTvShowUsecase

class TvShowViewModel(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUsecase: UpdateTvShowUsecase
) : ViewModel() {

    fun getTvShow() = liveData {
        val tvShowList = getTvShowUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShow() = liveData {
        val tvShowList = updateTvShowUsecase.execute()
        emit(tvShowList)
    }
}