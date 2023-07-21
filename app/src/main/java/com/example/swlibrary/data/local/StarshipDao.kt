package com.example.swlibrary.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.swlibrary.model.CharacterResults
import com.example.swlibrary.model.PlanetResults
import com.example.swlibrary.model.StarshipResults

@Dao
interface StarshipDao {
    @Query("SELECT * FROM starship_table")
    fun getAllStarship(): List<StarshipResults>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStarships(planets: List<StarshipResults>)

    @Query("DELETE FROM starship_table")
    suspend fun deleteAll()
}