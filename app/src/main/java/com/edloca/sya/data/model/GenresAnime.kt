package com.edloca.sya.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize

data class GenresAnime (
    @SerializedName("mal_id") var mal_id:Int?,
    @SerializedName("type") var type:String?,
    @SerializedName("name") var name:String?,
    @SerializedName("url") var url:String?
):Parcelable{
    constructor():this(null,null,null, null)
}