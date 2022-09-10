package com.edloca.sya.data.model

import com.google.gson.annotations.SerializedName

data class PaginationMoreInfo (
    @SerializedName("count") var count:Int,
    @SerializedName("total") var total:Int,
    @SerializedName("per_page") var per_page:Int)