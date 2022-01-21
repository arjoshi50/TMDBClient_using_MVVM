package com.finapp.tmdbclient_using_mvvm.data.repository.tvshow

import android.util.Log
import com.finapp.tmdbclient_using_mvvm.data.model.tvshow.TvShow
import com.finapp.tmdbclient_using_mvvm.data.model.tvshow.TvShowList
import com.finapp.tmdbclient_using_mvvm.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.finapp.tmdbclient_using_mvvm.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.finapp.tmdbclient_using_mvvm.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.finapp.tmdbclient_using_mvvm.domain.repository.TvShowRepository
import retrofit2.Response
import java.lang.Exception

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
): TvShowRepository {

    override suspend fun getTvShow(): List<TvShow>? {
        return getTvShowFromCaChe()
    }

    override suspend fun updateTvShow(): List<TvShow>? {
        val newListOfTvShow = getTvShowFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowToDB(newListOfTvShow)
        tvShowCacheDataSource.saveTvShowToCache(newListOfTvShow)
        return newListOfTvShow
    }

    suspend fun getTvShowFromAPI():List<TvShow>{
        lateinit var tvShowList: List<TvShow>
        try {
            val response: Response<TvShowList> = tvShowRemoteDataSource.getTvShow()
            val body=response.body()
            if (body!=null){
                tvShowList= body.tvShow
            }
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowFromDB():List<TvShow>{
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowLocalDataSource.getTvShowFromDB()

        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if (tvShowList.size>0){
            return tvShowList
        }else{
            tvShowList=getTvShowFromAPI()
            tvShowLocalDataSource.saveTvShowToDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowFromCaChe():List<TvShow>{
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShowFromCache()

        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if (tvShowList.size>0){
            return tvShowList
        }else{
            tvShowList=getTvShowFromDB()
            tvShowCacheDataSource.saveTvShowToCache(tvShowList)
        }
        return tvShowList
    }
}