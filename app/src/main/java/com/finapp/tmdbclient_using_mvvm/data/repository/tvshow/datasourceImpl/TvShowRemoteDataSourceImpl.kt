package com.finapp.tmdbclient_using_mvvm.data.repository.tvshow.datasourceImpl

import com.finapp.tmdbclient_using_mvvm.data.api.TMDBService
import com.finapp.tmdbclient_using_mvvm.data.model.movie.MovieList
import com.finapp.tmdbclient_using_mvvm.data.model.tvshow.TvShowList
import com.finapp.tmdbclient_using_mvvm.data.repository.movie.datasource.MovieRemoteDataSource
import com.finapp.tmdbclient_using_mvvm.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
    ): TvShowRemoteDataSource {
    override suspend fun getTvShow(): Response<TvShowList> =
        tmdbService.getPopularTvShow(apiKey)

}