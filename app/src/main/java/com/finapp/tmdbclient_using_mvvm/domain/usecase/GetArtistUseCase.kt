package com.finapp.tmdbclient_using_mvvm.domain.usecase

import com.finapp.tmdbclient_using_mvvm.data.model.artist.Artist
import com.finapp.tmdbclient_using_mvvm.domain.repository.ArtistRepository

class GetArtistUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>? = artistRepository.getArtist()
}