package com.edloca.sya.ui.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edloca.sya.data.model.Anime
import com.edloca.sya.domain.GetAnimeByName
import com.edloca.sya.domain.GetTopAnime
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val topAnimes:GetTopAnime,
    private val animeByName:GetAnimeByName
): ViewModel() {

    val isError : MutableLiveData<String> = MutableLiveData()
    val isLoading : MutableLiveData<Boolean> = MutableLiveData()
    var animelist: MutableLiveData<List<Anime>> = MutableLiveData()


    fun getTopAnimes() {

        isLoading.postValue(true)

        viewModelScope.launch {

            val result =topAnimes()

            if (!result.isNullOrEmpty()){
                animelist.postValue(result)
                isLoading.postValue(false)
            }
        }

    }

    fun getAnimeRelatedSearch(search:String) {

        viewModelScope.launch {
            isLoading.postValue(true)

            val result = animeByName(search)

            if (!result.isNullOrEmpty()){
                animelist.postValue(result)
                isLoading.postValue(false)
            }else{
                isError.postValue("No se ha encontrado el contenido que desea")
            }
        }

    }





}