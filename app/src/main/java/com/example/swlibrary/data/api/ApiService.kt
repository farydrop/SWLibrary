package com.example.swlibrary.data.api

import com.example.swlibrary.model.CharacterModel
import com.example.swlibrary.model.CharacterResults
import com.example.swlibrary.model.PlanetModel
import com.example.swlibrary.model.PlanetResults
import com.example.swlibrary.model.StarshipModel
import com.example.swlibrary.model.StarshipResults
import com.example.swlibrary.model.SwapiResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {

    @GET
    fun searchCharacters(@Url url: String): Call<CharacterModel>

    @GET
    fun searchStarships(@Url url: String): Call<StarshipModel>

    @GET
    fun searchPlanets(@Url url: String): Call<PlanetModel>


}