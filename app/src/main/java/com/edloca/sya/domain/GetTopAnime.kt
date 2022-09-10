package com.edloca.sya.domain

import com.edloca.sya.data.AnimeRepository
import com.edloca.sya.data.model.Anime
import com.edloca.sya.data.model.AnimeResponse
import javax.inject.Inject

class GetTopAnime @Inject constructor( private val repository: AnimeRepository) {
    suspend operator fun invoke():List<Anime>  = repository.getAnimes()
}