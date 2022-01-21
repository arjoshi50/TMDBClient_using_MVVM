package com.finapp.tmdbclient_using_mvvm.domain.repository

import com.finapp.tmdbclient_using_mvvm.data.model.tvshow.TvShow

interface TvShowRepository {

    suspend fun getTvShow(): List<TvShow>?
    suspend fun updateTvShow(): List<TvShow>?
}