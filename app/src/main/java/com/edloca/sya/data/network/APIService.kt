package com.edloca.sya.data.network

import com.edloca.sya.core.RetrofitHelper
import com.edloca.sya.data.model.Anime
import com.edloca.sya.data.model.AnimeResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

class APIService @Inject constructor (
    private val retrofit: Retrofit
    ){

    suspend fun getAnimes():List<Anime>{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(APIClient::class.java).getAnime("anime")
            response.body()?.search ?: emptyList()
        }

    }

    suspend fun getSearchedAnime(query:String):List<Anime>{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(APIClient::class.java).getAnime(" anime?q=$query")
            response.body()?.search ?: emptyList()
        }

    }
}