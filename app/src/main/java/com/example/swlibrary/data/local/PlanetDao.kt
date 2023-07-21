package com.example.swlibrary.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.swlibrary.model.CharacterResults
import com.example.swlibrary.model.PlanetResults

@Dao
interface PlanetDao {
    @Query("SELECT * FROM planet_table")
    fun getAllPlanet(): List<PlanetResults>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlanet(planets: List<PlanetResults>)

    @Query("DELETE FROM planet_table")
    suspend fun deleteAllPlanet()
}