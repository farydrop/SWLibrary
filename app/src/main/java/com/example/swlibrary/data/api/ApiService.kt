package com.example.swlibrary.data.api

import com.example.swlibrary.model.CharacterModel
import com.example.swlibrary.model.PlanetModel
import com.example.swlibrary.model.StarshipModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("people/")
    suspend fun searchCharacters(): Response<CharacterModel>

    @GET("starships/")
    suspend fun searchStarships(): Response<StarshipModel>

    @GET("planets/")
    suspend fun searchPlanets(): Response<PlanetModel>

}