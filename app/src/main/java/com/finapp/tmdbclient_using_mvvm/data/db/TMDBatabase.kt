package com.finapp.tmdbclient_using_mvvm.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.finapp.tmdbclient_using_mvvm.data.model.artist.Artist
import com.finapp.tmdbclient_using_mvvm.data.model.movie.Movie
import com.finapp.tmdbclient_using_mvvm.data.model.tvshow.TvShow

@Database(entities = [Movie::class,TvShow::class,Artist::class],
version = 1,exportSchema = false)
abstract class TMDBatabase : RoomDatabase(){

    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}