package com.edloca.sya.domain

import com.edloca.sya.data.AnimeRepository
import com.edloca.sya.data.model.Anime
import javax.inject.Inject

class GetAnimeByName @Inject constructor(private val repository : AnimeRepository) {
    suspend operator fun invoke(name:String): List<Anime> = repository.getAnimeByName(name)
}