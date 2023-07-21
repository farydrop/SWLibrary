package com.example.swlibrary.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.swlibrary.model.CharacterResults
import com.example.swlibrary.model.PlanetResults
import com.example.swlibrary.model.StarshipResults

@Database(entities = [CharacterResults::class, PlanetResults::class, StarshipResults::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    /*abstract fun characterDao(): CharacterDao
    abstract fun planetDao(): PlanetDao
    abstract fun starshipDao(): StarshipDao*/
    abstract fun starWarsDao(): StarWarsDao
}