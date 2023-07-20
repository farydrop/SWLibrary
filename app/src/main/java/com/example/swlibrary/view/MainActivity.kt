package com.example.swlibrary.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.swlibrary.R
import com.example.swlibrary.data.api.ApiService
import com.example.swlibrary.databinding.ActivityMainBinding
import com.example.swlibrary.model.CharacterResults
import com.example.swlibrary.model.PlanetResults
import com.example.swlibrary.model.StarshipResults
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import org.koin.androidx.viewmodel.ext.android.viewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var starWarsAdapter: StarWarsItemAdapter? = null
    private val viewModel: MainViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupBottomNavigation()

        val dataList= mutableListOf<Any>()

        /*binding.ivSearchButton.setOnClickListener {
            val query = binding.etSearch.text.toString().trim()
            if (query.length >= 2) {
                searchCharactersAndStarships(query)
            } else {
                Toast.makeText(this, "Введите не менее 2 символов", Toast.LENGTH_SHORT).show()
            }
        }*/

        viewModel.getAllLists()
        viewModel.combinedList.observe(this){
            starWarsAdapter = StarWarsItemAdapter(it)
            binding.rv.adapter = starWarsAdapter
            binding.rv.layoutManager = LinearLayoutManager(this)
        }


    }

    private fun setupBottomNavigation() {
        with(binding.bnvNavigation) {
            itemIconTintList = null
            setOnNavigationItemSelectedListener(
                BottomNavigationView.OnNavigationItemSelectedListener { item ->
                    when (item.itemId) {
                        R.id.nav_search_page -> {
                            return@OnNavigationItemSelectedListener true
                        }
                        R.id.nav_favorite_page -> {
                            return@OnNavigationItemSelectedListener true
                        }
                    }
                    false
                }
            )
        }
    }
}