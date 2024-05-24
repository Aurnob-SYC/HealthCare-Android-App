package com.example.finalyearproject.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class HealthArticles(
    @PrimaryKey(autoGenerate = false)
    val name: String = "",
    val imageURL: String = ""
)

