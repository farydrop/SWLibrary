package com.example.swlibrary.data.repository

import com.example.swlibrary.data.api.ApiService
import com.example.swlibrary.data.api.RetrofitInstance
import com.example.swlibrary.model.CharacterModel
import com.example.swlibrary.model.CharacterResults
import com.example.swlibrary.model.PlanetModel
import com.example.swlibrary.model.PlanetResults
import com.example.swlibrary.model.StarshipModel
import com.example.swlibrary.model.StarshipResults
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Url

class GetStarWarsApiRepository() {

    fun getCharacter(url: String): Call<CharacterModel> {
        return RetrofitInstance.apiService.searchCharacters(url)
    }

    fun getStarship(url: String): Call<StarshipModel> {
        return RetrofitInstance.apiService.searchStarships(url)
    }

     fun getPlanet(url: String): Call<PlanetModel> {
        return RetrofitInstance.apiService.searchPlanets(url)
    }


}