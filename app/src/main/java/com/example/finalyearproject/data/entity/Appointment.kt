package com.example.finalyearproject.data.entity

import androidx.room.PrimaryKey
import java.util.Date

data class Appointment(
    @PrimaryKey(autoGenerate = false)
    val name: String = "",
    val date: Date?,
    val slots: List<Boolean> = List(10) {false}
)