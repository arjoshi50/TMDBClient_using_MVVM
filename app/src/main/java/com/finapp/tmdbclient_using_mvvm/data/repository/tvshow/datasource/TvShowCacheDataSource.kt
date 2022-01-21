package com.finapp.tmdbclient_using_mvvm.data.repository.tvshow.datasource


import com.finapp.tmdbclient_using_mvvm.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowFromCache(): List<TvShow>
    suspend fun saveTvShowToCache(tvShow: List<TvShow>)
}