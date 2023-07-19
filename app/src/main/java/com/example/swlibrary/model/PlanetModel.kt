package com.example.swlibrary.model

data class PlanetModel(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<PlanetResults>
)

data class PlanetResults(
    val name: String,
    val diameter: String,
    val population: String
)
