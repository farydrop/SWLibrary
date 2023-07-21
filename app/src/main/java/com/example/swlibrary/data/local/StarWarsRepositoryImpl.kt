package com.example.swlibrary.data.local

import com.example.swlibrary.model.CharacterResults
import com.example.swlibrary.model.PlanetResults
import com.example.swlibrary.model.StarshipResults

class StarWarsRepositoryImpl(private val starWarsDao: StarWarsDao):StarWarsRepository {

    override suspend fun insertCharacter(characters: List<CharacterResults>) {
        starWarsDao.insertCharacters(characters)
    }

    override suspend fun insertPlanets(planets: List<PlanetResults>) {
        starWarsDao.insertPlanets(planets)
    }

    override suspend fun insertStarships(starships: List<StarshipResults>) {
        starWarsDao.insertStarships(starships)
    }

    override suspend fun getCharacters(): List<CharacterResults> = starWarsDao.getCharacters()

    override suspend fun getPlanets(): List<PlanetResults> = starWarsDao.getPlanets()

    override suspend fun getStarships(): List<StarshipResults> = starWarsDao.getStarships()
}