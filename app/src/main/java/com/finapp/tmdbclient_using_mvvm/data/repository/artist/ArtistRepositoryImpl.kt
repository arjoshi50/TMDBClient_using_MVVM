package com.finapp.tmdbclient_using_mvvm.data.repository.artist

import android.util.Log
import com.finapp.tmdbclient_using_mvvm.data.model.artist.Artist
import com.finapp.tmdbclient_using_mvvm.data.model.artist.ArtistList
import com.finapp.tmdbclient_using_mvvm.data.repository.artist.daasource.ArtistCacheDataSource
import com.finapp.tmdbclient_using_mvvm.data.repository.artist.daasource.ArtistLocalDataSource
import com.finapp.tmdbclient_using_mvvm.data.repository.artist.daasource.ArtistRemoteDataSource

import com.finapp.tmdbclient_using_mvvm.domain.repository.ArtistRepository

import retrofit2.Response
import java.lang.Exception

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
): ArtistRepository {

    override suspend fun getArtist(): List<Artist>? {
        return getArtistFromCaChe()
    }

    override suspend fun updateArtist(): List<Artist>? {
        val newListOfArtists= getArtistFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistToDB(newListOfArtists)
        artistCacheDataSource.saveArtistToCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistFromAPI():List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            val response: Response<ArtistList> = artistRemoteDataSource.getArtist()
            val body=response.body()
            if (body!=null){
                artistList= body.artist
            }
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        return artistList
    }

    suspend fun getArtistFromDB():List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistFromDB()

        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if (artistList.size>0){
            return artistList
        }else{
            artistList=getArtistFromAPI()
            artistLocalDataSource.saveArtistToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistFromCaChe():List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistFromCache()

        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if (artistList.size>0){
            return artistList
        }else{
            artistList=getArtistFromDB()
            artistCacheDataSource.saveArtistToCache(artistList)
        }
        return artistList
    }
}