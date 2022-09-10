package com.edloca.sya.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize

data class Anime (
    @SerializedName("mal_id") var id:String?,
    @SerializedName("url") var urlAnime:String?,
    @SerializedName("images")  var images: ImagesAnime?,
    @SerializedName("trailer") var trailer: TrailerInfo?,
    @SerializedName("approved") var approved:Boolean?,
    @SerializedName("title") var title:String?,
    @SerializedName("title_english") var title_english:String?,
    @SerializedName("title_japanese") var title_japanese:String?,
    @SerializedName("status") var status:String?,
    @SerializedName("airing") var active:Boolean?,
    @SerializedName("duration") var duration:String?,
    @SerializedName("rating") var rating:String?,
    @SerializedName("score") var score:Float?,
    @SerializedName("scored_by") var scored_by:String?,
    @SerializedName("rank") var rank:Int?,
    @SerializedName("popularity") var popularity:String?,
    @SerializedName("synopsis") var synopsis:String?,
    @SerializedName("background") var background:String?,
    @SerializedName("year") var year:String?,
    @SerializedName("genres") var genres:List<GenresAnime>?,
):Parcelable{
    constructor():this(null,null,null,null,
        null,null,null,null,
        null,null,null,null,
        null,null,null,null,
        null,null,null,null)
}