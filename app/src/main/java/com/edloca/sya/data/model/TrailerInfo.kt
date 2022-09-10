package com.edloca.sya.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TrailerInfo( @SerializedName("url") var url:String?): Parcelable{

    constructor():this(null)
}