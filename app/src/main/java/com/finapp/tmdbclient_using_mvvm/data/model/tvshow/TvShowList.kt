package com.finapp.tmdbclient_using_mvvm.data.model.tvshow


import com.finapp.tmdbclient_using_mvvm.data.model.tvshow.TvShow
import com.google.gson.annotations.SerializedName

data class TvShowList(

    @SerializedName("results")
    val tvShow: List<TvShow>
)