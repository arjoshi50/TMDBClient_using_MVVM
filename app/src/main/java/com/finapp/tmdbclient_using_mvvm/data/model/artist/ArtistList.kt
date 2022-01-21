package com.finapp.tmdbclient_using_mvvm.data.model.artist


import com.finapp.tmdbclient_using_mvvm.data.model.artist.Artist
import com.google.gson.annotations.SerializedName

data class ArtistList(

    @SerializedName("results")
    val artist: List<Artist>
)