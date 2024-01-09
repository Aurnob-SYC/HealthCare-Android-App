package com.example.finalyearproject.data.entity

import androidx.room.PrimaryKey
import java.util.Date

data class OrderDetails(
    @PrimaryKey(autoGenerate = false)
    val email: String = "",
    val products: List<Pair<String, Int>>,
    val appointment: List<Pair<String, Date>>
)
