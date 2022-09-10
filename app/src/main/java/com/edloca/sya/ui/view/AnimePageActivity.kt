package com.edloca.sya.ui.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.edloca.sya.R
import com.edloca.sya.databinding.ActivityAnimePageBinding
import com.edloca.sya.data.model.Anime
import dagger.hilt.android.AndroidEntryPoint



class AnimePageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimePageBinding
    private lateinit var anime: Anime

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        anime = intent.getParcelableExtra("anime")!!

        cargarInfo()


        binding.btnCompartir.setOnClickListener {
            val intent= Intent().apply{
                action=Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT,anime.urlAnime)
                type="text/plain"
                putExtra(Intent.EXTRA_TITLE,"Comparte el anime con tus amigos")

            }

            val shareIntent=Intent.createChooser(intent,null)
            startActivity(shareIntent)
        }


        binding.btnUrl.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(anime.urlAnime)
            startActivity(i)
        }
    }


    private fun cargarInfo(){

        Glide.with(this)
            .load(anime.images?.jpg?.image_url)
            .placeholder(R.drawable.notfoundimage)
            .into(binding.imgPortada)


        binding.tvTitle.text = anime.title
        binding.tvStatus.text = anime.status

        binding.tvScore.text = anime.score.toString()
        binding.tvScoreBy.text = "${anime.scored_by} votes"
        binding.tvSynopsis.text = anime.synopsis

        binding.tvRank.text = "Rank: ${anime.rank}"

        binding.tvYear.text = anime.year


    }
}