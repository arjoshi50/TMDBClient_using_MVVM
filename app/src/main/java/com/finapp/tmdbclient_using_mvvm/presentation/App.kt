package com.finapp.tmdbclient_using_mvvm.presentation

import android.app.Application
import com.finapp.tmdbclient_using_mvvm.BuildConfig
import com.finapp.tmdbclient_using_mvvm.presentation.di.Injector
import com.finapp.tmdbclient_using_mvvm.presentation.di.artist.ArtistSubComponent
import com.finapp.tmdbclient_using_mvvm.presentation.di.core.*
import com.finapp.tmdbclient_using_mvvm.presentation.di.movie.MovieSubComponent
import com.finapp.tmdbclient_using_mvvm.presentation.di.tvshow.TvShowSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}