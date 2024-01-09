package com.example.finalyearproject.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
@Entity
data class Appointment(
    @PrimaryKey(autoGenerate = false)
    val name: String = "",
    val date: Date?,
    val slots: List<Boolean> = List(10) {false}
)