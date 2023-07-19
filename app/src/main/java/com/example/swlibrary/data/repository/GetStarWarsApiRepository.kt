package com.example.swlibrary.data.repository

import com.example.swlibrary.data.api.RetrofitInstance
import com.example.swlibrary.model.CharacterModel
import com.example.swlibrary.model.PlanetModel
import com.example.swlibrary.model.StarshipModel
import retrofit2.Response

class GetStarWarsApiRepository {


    suspend fun getCharacter(): Response<CharacterModel> {
        return RetrofitInstance.apiService.searchCharacters()
    }

    suspend fun getStarship(): Response<StarshipModel> {
        return RetrofitInstance.apiService.searchStarships()
    }

    suspend fun getPlanet(): Response<PlanetModel> {
        return RetrofitInstance.apiService.searchPlanets()
    }


}