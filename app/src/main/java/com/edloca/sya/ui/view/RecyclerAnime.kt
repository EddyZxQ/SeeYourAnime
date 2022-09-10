package com.edloca.sya.ui.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.edloca.sya.R
import com.edloca.sya.data.model.Anime

class RecyclerAnime (var context: Context, var animes:List<Anime>, var animeListener: onItemAnimeClickListener):RecyclerView.Adapter<RecyclerAnime.AnimeHolder>(){


    interface onItemAnimeClickListener{
        fun onAnimeClick(anime: Anime)
    }

    inner class AnimeHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        var imgAnime = itemView.findViewById<ImageView>(R.id.contenedor)
        var tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)

        fun bind(animes: List<Anime>, position:Int){
            itemView.setOnClickListener { animeListener.onAnimeClick(animes[position]) }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeHolder {
       val itemView = LayoutInflater.from(context).inflate(R.layout.anime_item, parent, false)
       return AnimeHolder(itemView)
    }

    override fun onBindViewHolder(holder: AnimeHolder, position: Int) {

        var anime = animes[position]
        Glide.with(context).load(anime.images?.jpg?.image_url).placeholder(R.drawable.notfoundimage).into(holder.imgAnime)
        holder.tvTitle.text = anime.title
        holder.bind(animes, position)
    }

    override fun getItemCount(): Int = animes.size
}