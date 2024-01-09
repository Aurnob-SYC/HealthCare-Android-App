package com.example.finalyearproject.data.typeConverter

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*

class AppointmentListTypeConverter {
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())

    @TypeConverter
    fun fromAppointmentList(appointment: List<Pair<String, Date>>): String {
        return appointment.joinToString(separator = ";") { "${it.first}:${dateFormat.format(it.second)}" }
    }

    @TypeConverter
    fun toAppointmentList(data: String): List<Pair<String, Date>> {
        val pairs = data.split(";")
        return pairs.map {
            val pairValues = it.split(":")
            pairValues[0] to dateFormat.parse(pairValues[1])!!
        }
    }
}