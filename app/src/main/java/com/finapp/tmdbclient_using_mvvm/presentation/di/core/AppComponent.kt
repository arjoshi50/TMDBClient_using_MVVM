package com.finapp.tmdbclient_using_mvvm.presentation.di.core

import com.finapp.tmdbclient_using_mvvm.presentation.di.artist.ArtistSubComponent
import com.finapp.tmdbclient_using_mvvm.presentation.di.movie.MovieSubComponent
import com.finapp.tmdbclient_using_mvvm.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DataBaseModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class
])
interface AppComponent {

    fun movieSubComponent():MovieSubComponent.Factory
    fun tvShowSubComponent():TvShowSubComponent.Factory
    fun artistSubComponent():ArtistSubComponent.Factory
}