package com.edloca.sya.data.network

import com.edloca.sya.data.model.AnimeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIClient {

    @GET
    suspend fun getAnime(@Url url:String):Response<AnimeResponse>
}