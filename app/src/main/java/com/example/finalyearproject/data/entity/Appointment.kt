package com.example.finalyearproject.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.finalyearproject.data.typeConverter.BooleanListTypeConverter
import com.example.finalyearproject.data.typeConverter.DateTypeConverter
import java.util.Date
@Entity
@TypeConverters(DateTypeConverter::class, BooleanListTypeConverter::class)
data class Appointment(
    @PrimaryKey(autoGenerate = false)
    val name: String = "",
    val date: Date?,
    val slots: List<Boolean>?
)