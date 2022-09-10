package com.edloca.sya.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class AnimeResponse(
    @SerializedName("pagination") var pagination: PaginationInfo?,
    @SerializedName("data") var search:List<Anime>?
){
    constructor():this(null,null)
}