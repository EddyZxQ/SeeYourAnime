package com.edloca.sya.data

import com.edloca.sya.data.model.Anime
import com.edloca.sya.data.model.AnimeResponse
import com.edloca.sya.data.network.APIService
import javax.inject.Inject

class AnimeRepository @Inject constructor(private val api:APIService){
    suspend fun getAnimes():List<Anime> = api.getAnimes()
    suspend fun getAnimeByName(name:String):List<Anime> = api.getSearchedAnime(name)
}