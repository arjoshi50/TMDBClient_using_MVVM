package com.finapp.tmdbclient_using_mvvm.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.finapp.tmdbclient_using_mvvm.data.db.ArtistDao
import com.finapp.tmdbclient_using_mvvm.data.db.MovieDao
import com.finapp.tmdbclient_using_mvvm.data.db.TMDBatabase
import com.finapp.tmdbclient_using_mvvm.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun providerMovieDataBase(context: Context): TMDBatabase{
        return Room.databaseBuilder(context,TMDBatabase::class.java,"tmdbclient")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBatabase):MovieDao{
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBatabase):TvShowDao{
        return tmdbDatabase.tvShowDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBatabase):ArtistDao{
        return tmdbDatabase.artistDao()
    }
}