package com.example.finalyearproject.data.typeConverter

import androidx.room.TypeConverter

class ProductsListTypeConverter {
    @TypeConverter
    fun fromProductsList(products: List<Pair<String, Int>>): String {
        return products.joinToString(separator = ";") { "${it.first}:${it.second}" }
    }

    @TypeConverter
    fun toProductsList(data: String): List<Pair<String, Int>> {
        val pairs = data.split(";")
        return pairs.map {
            val pairValues = it.split(":")
            pairValues[0] to pairValues[1].toInt()
        }
    }
}