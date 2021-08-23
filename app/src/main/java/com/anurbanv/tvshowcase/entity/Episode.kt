package com.anurbanv.tvshowcase.entity

data class Episode(
    val season: Int, val number: Int, val name: String, val imageUrl: String, val summary: String
)