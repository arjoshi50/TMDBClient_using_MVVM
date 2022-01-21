package com.finapp.tmdbclient_using_mvvm.data.repository.tvshow.datasourceImpl

import com.finapp.tmdbclient_using_mvvm.data.db.MovieDao
import com.finapp.tmdbclient_using_mvvm.data.db.TvShowDao
import com.finapp.tmdbclient_using_mvvm.data.model.movie.Movie
import com.finapp.tmdbclient_using_mvvm.data.model.tvshow.TvShow
import com.finapp.tmdbclient_using_mvvm.data.repository.movie.datasource.MovieLocalDataSource
import com.finapp.tmdbclient_using_mvvm.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao): TvShowLocalDataSource {
    override suspend fun getTvShowFromDB(): List<TvShow> {
        return tvShowDao.getTvShow()
    }

    override suspend fun saveTvShowToDB(tvShow: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShow(tvShow)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShow()
        }
    }
}