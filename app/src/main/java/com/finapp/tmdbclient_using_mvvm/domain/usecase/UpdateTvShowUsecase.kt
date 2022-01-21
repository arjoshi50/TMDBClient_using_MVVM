package com.finapp.tmdbclient_using_mvvm.domain.usecase

import com.finapp.tmdbclient_using_mvvm.data.model.tvshow.TvShow
import com.finapp.tmdbclient_using_mvvm.domain.repository.TvShowRepository

class UpdateTvShowUsecase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute(): List<TvShow>? = tvShowRepository.updateTvShow()
}