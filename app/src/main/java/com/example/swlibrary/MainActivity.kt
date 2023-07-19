package com.example.swlibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.swlibrary.databinding.ActivityMainBinding
import com.example.swlibrary.model.CharacterResults
import com.example.swlibrary.model.PlanetModel
import com.example.swlibrary.model.PlanetResults
import com.example.swlibrary.model.StarshipResults
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var starWarsAdapter: StarWarsItemAdapter? = null
    private val viewModel: MainViewModel by lazy {                  // lazy опускает применение свойства quizViewModel ак val, а не var.
        ViewModelProvider(this).get(MainViewModel::class.java)    // Потому что нужно захватить и сохранить QuizViewModel, лишь когда создается экземпляр activity, поэтому quizViewModel получает значение только один раз.
    }


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
        //recyclerView = v.rv_sta

        val dataList2: List<Any> = listOf(
            CharacterResults("Luke", "female"),
            PlanetResults("Moon", "128000", "200000"),
            StarshipResults("Mercedes", "Модель 1 - Элемент 2", "fffff"),
        )

        viewModel.getCharacterList()
        viewModel.getPlanetList()
        viewModel.getStarshipList()

        viewModel.characterList.observe(this) { list ->
            list.body()?.let {
                starWarsAdapter = StarWarsItemAdapter(it.results)
                binding.rv.adapter = starWarsAdapter
                binding.rv.layoutManager = LinearLayoutManager(this)
            }
        }
        viewModel.planetList.observe(this) { list ->
            list.body()?.let {
                starWarsAdapter = StarWarsItemAdapter(it.results)
                binding.rv.adapter = starWarsAdapter
                binding.rv.layoutManager = LinearLayoutManager(this)
            }
        }
        viewModel.starshipList.observe(this) { list ->
            list.body()?.let {
                starWarsAdapter = StarWarsItemAdapter(it.results)
                binding.rv.adapter = starWarsAdapter
                binding.rv.layoutManager = LinearLayoutManager(this)
            }
        }

        /*starWarsAdapter = StarWarsItemAdapter(dataList)
        binding.rv.adapter = starWarsAdapter
        binding.rv.layoutManager = LinearLayoutManager(this)*/

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