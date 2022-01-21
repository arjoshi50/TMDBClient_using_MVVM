package com.finapp.tmdbclient_using_mvvm.data.repository.tvshow.datasource

import com.finapp.tmdbclient_using_mvvm.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {

    suspend fun getTvShow(): Response<TvShowList>
}