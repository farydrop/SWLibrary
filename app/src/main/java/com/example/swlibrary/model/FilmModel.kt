package com.example.swlibrary.model

data class FilmModel(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<FilmResults>
)

data class FilmResults(
    val title: String,
    val director: String,
    val producer: String
)