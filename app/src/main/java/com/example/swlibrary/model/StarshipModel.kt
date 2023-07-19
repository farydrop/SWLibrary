package com.example.swlibrary.model

data class StarshipModel(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<StarshipResults>
)

data class StarshipResults(
    val name: String,
    val model: String,
    val manufacturer: String,
    //val pilots: List<CharacterResults>
)