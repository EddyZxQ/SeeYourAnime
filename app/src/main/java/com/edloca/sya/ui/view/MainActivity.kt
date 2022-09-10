package com.edloca.sya.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.edloca.sya.databinding.ActivityMainBinding
import com.edloca.sya.data.model.Anime
import com.edloca.sya.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener, SearchView.OnCloseListener,
    RecyclerAnime.onItemAnimeClickListener {

    private lateinit var binding: ActivityMainBinding
    private  lateinit var adapter: RecyclerAnime
    private  var animeList = mutableListOf<Anime>()

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.getTopAnimes()


        binding.searchAnime.setOnQueryTextListener(this)
        binding.searchAnime.setOnCloseListener(this)


        mainViewModel.animelist.observe(this, Observer {
            adapter = RecyclerAnime(this, it, this)
            binding.rvAnimes.layoutManager = GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false)
            binding.rvAnimes.setHasFixedSize(true)
            binding.rvAnimes.adapter = adapter

        })

        mainViewModel.isLoading.observe(this, Observer {
            if (it) {
                binding.rvAnimes.visibility = View.GONE
                binding.shimmer.visibility = View.VISIBLE

                hideKeyboard()
            }else{
                binding.shimmer.visibility = View.GONE
                binding.rvAnimes.visibility = View.VISIBLE
            }

        })


        mainViewModel.isError.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })


        binding.btnClear.setOnClickListener { mainViewModel.getTopAnimes() }


    }


    private fun hideKeyboard() {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.viewRoot.windowToken, 0)
    }


    override fun onQueryTextSubmit(query: String?): Boolean {
        if (!query.isNullOrEmpty()){
            mainViewModel.getAnimeRelatedSearch(query)
        }
        return true
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        return true
    }

    override fun onClose(): Boolean {
        mainViewModel.getTopAnimes()
        return false
    }

    override fun onAnimeClick(anime: Anime) {

        CoroutineScope(Dispatchers.IO).launch {
            var intent = Intent(this@MainActivity, AnimePageActivity::class.java)
            intent.putExtra("anime", anime)

            runOnUiThread {
                startActivity(intent)
            }
        }


    }


}