package com.example.swlibrary.data.api

import com.example.swlibrary.model.CharacterModel
import com.example.swlibrary.model.PlanetModel
import com.example.swlibrary.model.StarshipModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    @GET
    fun searchCharacters(@Url url: String): Call<CharacterModel>

    @GET
    fun searchStarships(@Url url: String): Call<StarshipModel>

    @GET
    fun searchPlanets(@Url url: String): Call<PlanetModel>


}