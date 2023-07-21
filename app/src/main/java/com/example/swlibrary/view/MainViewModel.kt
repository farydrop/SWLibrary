package com.example.swlibrary.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swlibrary.data.local.StarWarsRepository
import com.example.swlibrary.data.repository.GetStarWarsApiRepository
import com.example.swlibrary.model.CharacterResults
import com.example.swlibrary.model.PlanetResults
import com.example.swlibrary.model.StarshipResults
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.awaitResponse

class MainViewModel(private val repository: StarWarsRepository) : ViewModel() {

    private var repo = GetStarWarsApiRepository()
    val combinedList: MutableLiveData<List<Any>> = MutableLiveData()
    val showProgress: MutableLiveData<Boolean> = MutableLiveData()
    private val allItems = mutableListOf<Any>()

    fun getAllLists() {
        viewModelScope.launch {
            showProgress.value = true

            val characterList = repository.getCharacters()
            val planetList = repository.getPlanets()
            val starshipList = repository.getStarships()

            allItems.addAll(characterList)
            allItems.addAll(planetList)
            allItems.addAll(starshipList)

            if (characterList.isEmpty() && planetList.isEmpty() && starshipList.isEmpty()) {
                insertAll()
            }

            combinedList.value = allItems
            showProgress.postValue(false)
        }

    }

    private suspend fun insertAll() {
        characterList()?.let {
            repository.insertCharacter(it)
            allItems.addAll(it)
        }
        planetList()?.let {
            repository.insertPlanets(it)
            allItems.addAll(it)
        }
        starshipList()?.let {
            repository.insertStarships(it)
            allItems.addAll(it)
        }
        combinedList.value = allItems
    }

    private suspend fun planetList(url: String = "https://swapi.dev/api/planets/"): List<PlanetResults>? {
        val planetResponse = repo.getPlanet(url).awaitResponse()
        if (planetResponse.isSuccessful) {
            val planetData = planetResponse.body()
            val nextUrl = planetData?.next
            val results = planetData?.results

            // If there are more pages (nextUrl is not null), recursively fetch and append the results
            return if (nextUrl != null) {
                val remainingResults = planetList(nextUrl)
                if (remainingResults != null) {
                    results?.plus(remainingResults)
                } else {
                    results
                }
            } else {
                results
            }
        } else {
            // Handle API error, return null or empty list based on your requirements
            return null
        }
    }

    private suspend fun characterList(url: String = "https://swapi.dev/api/people/"): List<CharacterResults>? {
        val characterResponse = repo.getCharacter(url).awaitResponse()
        if (characterResponse.isSuccessful) {
            val characterData = characterResponse.body()
            val nextUrl = characterData?.next
            val results = characterData?.results

            // If there are more pages (nextUrl is not null), recursively fetch and append the results
            return if (nextUrl != null) {
                val remainingResults = characterList(nextUrl)
                if (remainingResults != null) {
                    results?.plus(remainingResults)
                } else {
                    results
                }
            } else {
                results
            }
        } else {
            // Handle API error, return null or empty list based on your requirements
            return null
        }
    }

    private suspend fun starshipList(url: String = "https://swapi.dev/api/starships/"): List<StarshipResults>? {
        val starshipResponse = repo.getStarship(url).awaitResponse()
        if (starshipResponse.isSuccessful) {
            val starshipData = starshipResponse.body()
            val nextUrl = starshipData?.next
            val results = starshipData?.results

            // If there are more pages (nextUrl is not null), recursively fetch and append the results
            return if (nextUrl != null) {
                val remainingResults = starshipList(nextUrl)
                if (remainingResults != null) {
                    results?.plus(remainingResults)
                } else {
                    results
                }
            } else {
                results
            }
        } else {
            // Handle API error, return null or empty list based on your requirements
            return null
        }
    }

}