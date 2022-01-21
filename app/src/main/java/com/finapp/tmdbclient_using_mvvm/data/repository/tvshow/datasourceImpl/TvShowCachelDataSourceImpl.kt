package com.finapp.tmdbclient_using_mvvm.data.repository.tvshow.datasourceImpl

import com.finapp.tmdbclient_using_mvvm.data.model.movie.Movie
import com.finapp.tmdbclient_using_mvvm.data.model.tvshow.TvShow
import com.finapp.tmdbclient_using_mvvm.data.repository.movie.datasource.MovieCacheDataSource
import com.finapp.tmdbclient_using_mvvm.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCachelDataSourceImpl: TvShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()
    override suspend fun getTvShowFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowToCache(tvShow: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShow)
    }
}