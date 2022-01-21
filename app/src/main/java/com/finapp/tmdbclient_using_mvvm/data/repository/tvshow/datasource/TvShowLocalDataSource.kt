package com.finapp.tmdbclient_using_mvvm.data.repository.tvshow.datasource

import com.finapp.tmdbclient_using_mvvm.data.model.tvshow.TvShow


interface TvShowLocalDataSource {

    suspend fun getTvShowFromDB(): List<TvShow>
    suspend fun saveTvShowToDB(tvShow: List<TvShow>)
    suspend fun clearAll()
}