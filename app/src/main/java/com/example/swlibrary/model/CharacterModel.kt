package com.example.swlibrary.model

data class CharacterModel(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<CharacterResults>
)

data class CharacterResults(
    val name: String,
    val gender: String,
    //val starships: List<String>
)