package com.finapp.tmdbclient_using_mvvm.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.finapp.tmdbclient_using_mvvm.data.model.artist.Artist

@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtist(artist: List<Artist>)

    @Query("DELETE FROM popular_tvShows")
    suspend fun deleteAllArtist()

    @Query("SELECT * FROM popular_tvShows")
    suspend fun getArtist(): List<Artist>
}