package com.example.swlibrary.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class PlanetModel(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<PlanetResults>
)

@Entity(tableName = "planet_table")
data class PlanetResults(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "diameter") val diameter: String,
    @ColumnInfo(name = "population") val population: String,
    @ColumnInfo(name = "favorite") var favorite: Boolean
) {
    constructor(name: String, diameter: String, population: String, favorite: Boolean) : this(
        0,
        name,
        diameter,
        population,
        favorite
    )
}
