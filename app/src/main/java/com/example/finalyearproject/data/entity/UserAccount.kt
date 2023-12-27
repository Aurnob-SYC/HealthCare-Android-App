package com.example.finalyearproject.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserAccount(
    @PrimaryKey(autoGenerate = false)
    val email: String = "",
    val password: String = "",
    val address: String = "",
    val contact: String = ""
)