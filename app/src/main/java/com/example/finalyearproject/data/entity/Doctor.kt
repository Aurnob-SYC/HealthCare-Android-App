package com.example.finalyearproject.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Doctor(
    @PrimaryKey(autoGenerate = false)
    val name: String = "",
    val price: Int = 0
)
