package com.edloca.sya.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImagesType (
    @SerializedName("image_url") var image_url:String?,
    @SerializedName("small_image_url") var small_image_url:String?,
    @SerializedName("large_image_url") var large_image_url:String?
): Parcelable{
    constructor():this(null,null,null)
}