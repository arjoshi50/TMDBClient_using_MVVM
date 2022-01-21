package com.finapp.tmdbclient_using_mvvm.presentation.di

import com.finapp.tmdbclient_using_mvvm.presentation.di.artist.ArtistSubComponent
import com.finapp.tmdbclient_using_mvvm.presentation.di.movie.MovieSubComponent
import com.finapp.tmdbclient_using_mvvm.presentation.di.tvshow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent():MovieSubComponent
    fun createTvShowSubComponent():TvShowSubComponent
    fun createArtistSubComponent():ArtistSubComponent

}