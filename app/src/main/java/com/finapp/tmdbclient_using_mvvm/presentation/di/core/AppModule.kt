package com.finapp.tmdbclient_using_mvvm.presentation.di.core

import android.content.Context
import com.finapp.tmdbclient_using_mvvm.presentation.di.artist.ArtistSubComponent
import com.finapp.tmdbclient_using_mvvm.presentation.di.movie.MovieSubComponent
import com.finapp.tmdbclient_using_mvvm.presentation.di.tvshow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [
    MovieSubComponent::class,
    TvShowSubComponent::class,
    ArtistSubComponent::class
])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext():Context{
        return context.applicationContext
    }
}