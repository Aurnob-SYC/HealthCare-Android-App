package com.example.finalyearproject.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.finalyearproject.data.typeConverter.AppointmentListTypeConverter
import com.example.finalyearproject.data.typeConverter.ProductsListTypeConverter
import java.util.Date

@Entity
@TypeConverters(ProductsListTypeConverter::class, AppointmentListTypeConverter::class)
data class OrderDetails(
    @PrimaryKey(autoGenerate = false)
    val email: String = "",
    val products: List<Pair<String, Int>>,
    val appointment: List<Pair<String, Date>>
)
