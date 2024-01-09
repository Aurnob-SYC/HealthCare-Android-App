package com.example.finalyearproject.data.entity.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.finalyearproject.data.entity.Appointment
import com.example.finalyearproject.data.entity.Doctor


data class DoctorAndAppointment(
    @Embedded val doctor: Doctor,
    @Relation(
        parentColumn = "name",
        entityColumn = "name"
    )
    val list: List<Appointment>
)
