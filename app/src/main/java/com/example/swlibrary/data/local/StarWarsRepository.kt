package com.example.swlibrary.data.local

import androidx.annotation.MainThread
import com.example.swlibrary.model.CharacterResults
import com.example.swlibrary.model.PlanetResults
import com.example.swlibrary.model.StarshipResults

interface StarWarsRepository {

    @MainThread
    suspend fun insertCharacter(characters: List<CharacterResults>)

    @MainThread
    suspend fun insertPlanets(planets: List<PlanetResults>)

    @MainThread
    suspend fun insertStarships(starships: List<StarshipResults>)

    suspend fun getCharacters(): List<CharacterResults>

    suspend fun getPlanets(): List<PlanetResults>

    suspend fun getStarships(): List<StarshipResults>
}