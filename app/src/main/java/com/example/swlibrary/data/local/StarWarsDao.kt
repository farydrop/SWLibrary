package com.example.swlibrary.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.swlibrary.model.CharacterResults
import com.example.swlibrary.model.PlanetResults
import com.example.swlibrary.model.StarshipResults

@Dao
interface StarWarsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(characters: List<CharacterResults>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlanets(planets: List<PlanetResults>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStarships(starships: List<StarshipResults>)

    @Query("SELECT * FROM character_table")
    suspend fun getCharacters(): List<CharacterResults>

    @Query("SELECT * FROM planet_table")
    suspend fun getPlanets(): List<PlanetResults>

    @Query("SELECT * FROM starship_table")
    suspend fun getStarships(): List<StarshipResults>
}