package com.example.finalyearproject.data.typeConverter

import androidx.room.TypeConverter

class BooleanListTypeConverter {
    @TypeConverter
    fun fromBooleanList(booleanList: List<Boolean>): String {
        return booleanList.joinToString(separator = ",") { if (it) "1" else "0" }
    }

    @TypeConverter
    fun toBooleanList(data: String): List<Boolean> {
        val elements = data.split(",")
        return elements.map { it == "1" }
    }
}