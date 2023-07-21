package com.example.swlibrary.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.swlibrary.databinding.ActivityFavoritesBinding

class FavoritesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoritesBinding
    private var favoritesAdapter: FavoritesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoritesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getStringExtra("LIST")

        val list = mutableListOf<Any>()
        if (data != null) {
            list.add(data)
        }

        favoritesAdapter = FavoritesAdapter(list)
        binding.rvFavorites.adapter = favoritesAdapter
        binding.rvFavorites.layoutManager = LinearLayoutManager(this)
    }
}