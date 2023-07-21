package com.example.swlibrary.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class StarshipModel(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<StarshipResults>
)

@Entity(tableName = "starship_table")
data class StarshipResults(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "model") val model: String,
    @ColumnInfo(name = "manufacturer") val manufacturer: String,
    @ColumnInfo(name = "pilots") @SerializedName("pilots") val pilots: List<String>,
    @ColumnInfo(name = "favorite") var favorite: Boolean
) {
    constructor(name: String, model: String, manufacturer: String, pilots: List<String>, favorite: Boolean) : this(
        0,
        name,
        model,
        manufacturer,
        pilots,
        favorite
    )
}