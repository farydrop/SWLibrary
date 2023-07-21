package com.example.swlibrary.view

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.swlibrary.R
import com.example.swlibrary.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.reflect.Type


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var starWarsAdapter: StarWarsItemAdapter? = null
    private val viewModel: MainViewModel by viewModel()
    private lateinit var fullItemList: List<Any>
    var progressDialog: Dialog? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupBottomNavigation()

        viewModel.showProgress.observe(this) { isVisible ->
            progressDialog?.dismiss()
            if (isVisible) {
                progressDialog = Dialog(this@MainActivity, android.R.style.Theme_Translucent_NoTitleBar)
                    .apply {
                        setContentView(
                            layoutInflater.inflate(
                                R.layout.progress_bar,
                                null
                            )
                        )
                        setCancelable(false)
                        show()
                    }
            }
        }

        viewModel.getAllLists()
        viewModel.combinedList.observe(this){
            fullItemList = it
            starWarsAdapter = StarWarsItemAdapter(fullItemList)
            binding.rv.adapter = starWarsAdapter
            binding.rv.layoutManager = LinearLayoutManager(this)
        }

        /*binding.etSearch.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                val inputText = binding.etSearch.text.toString()
                val sortedList = fullItemList.filter { it.toString().contains(inputText, ignoreCase = true) }
                starWarsAdapter = StarWarsItemAdapter(sortedList)
                binding.rv.adapter = starWarsAdapter
                binding.rv.layoutManager = LinearLayoutManager(this)

                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(binding.etSearch.windowToken, 0)

                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        }*/

        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if ((s?.length ?: 0) >= 2) {
                    val inputText = s.toString()
                    val sortedList = fullItemList.filter { it.toString().contains(inputText, ignoreCase = true) }
                    starWarsAdapter = StarWarsItemAdapter(sortedList)
                    binding.rv.adapter = starWarsAdapter
                    binding.rv.layoutManager = LinearLayoutManager(this@MainActivity)
                    binding.rv.recycledViewPool.setMaxRecycledViews(1, 100);
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

        binding.etSearch.setOnEditorActionListener {  _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                // Hide the keyboard
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(binding.etSearch.windowToken, 0)
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
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
                            val intent = Intent(this@MainActivity, FavoritesActivity::class.java)
                            startActivity(intent)
                        }
                    }
                    false
                }
            )
        }
    }
}