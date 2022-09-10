package com.edloca.sya.data.model

import com.google.gson.annotations.SerializedName

data class PaginationInfo (
    @SerializedName("last_visible_page") var lastVisiblePage:Int,
    @SerializedName("has_next_page") var anotherPage:Boolean,
    @SerializedName("current_page") var actualPag:Int,
    @SerializedName("items") var itemsInfo: PaginationMoreInfo
)