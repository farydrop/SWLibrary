package com.example.swlibrary.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.swlibrary.model.CharacterResults

@Dao
interface CharacterDao {
    @Query("SELECT * FROM character_table")
    fun getAllCharacter(): List<CharacterResults>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(characters: List<CharacterResults>)

    @Query("DELETE FROM character_table")
    suspend fun deleteAll()
}