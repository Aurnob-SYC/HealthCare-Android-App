package com.example.finalyearproject.data.entity

import androidx.room.PrimaryKey

data class HealthArticles(
    @PrimaryKey(autoGenerate = false)
    val name: String = "",
    val imageURL: String = ""
)