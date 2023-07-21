package com.example.swlibrary.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class CharacterModel(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<CharacterResults>
)

@Entity(tableName = "character_table")
data class CharacterResults(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "gender") val gender: String,
    @ColumnInfo(name = "starships") @SerializedName("starships") val starships: List<String> = listOf(),
    @ColumnInfo(name = "favorite") var favorite: Boolean
) {
    constructor(name: String, gender: String, starships: List<String>, favorite: Boolean) : this(
        0,
        name,
        gender,
        starships,
        favorite
    )
}