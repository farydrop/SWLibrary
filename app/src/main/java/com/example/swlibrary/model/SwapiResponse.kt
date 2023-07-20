package com.example.swlibrary.model

data class SwapiResponse<T>(
    val results: List<T>,
    val next: String?
)
