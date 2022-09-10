package com.edloca.sya.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize

data class ImagesAnime (
    @SerializedName("jpg") var jpg: ImagesType?,
    @SerializedName("webp") var webp: ImagesType?):Parcelable{

        constructor():this(null, null)
}