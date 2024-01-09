package com.example.finalyearproject.data.entity

import androidx.room.PrimaryKey

data class Medicine(
    @PrimaryKey(autoGenerate = false)
    val name: String = "",
    val price: Int = 0
)