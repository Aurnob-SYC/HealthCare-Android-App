package com.example.finalyearproject.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.finalyearproject.data.dao.OthersDao
import com.example.finalyearproject.data.dao.UserAccountDao
import com.example.finalyearproject.data.entity.UserAccount

@Database(entities =[UserAccount::class],version = 1, exportSchema = false)
abstract class UserAccountDatabase: RoomDatabase() {
    abstract val userAccountDao: UserAccountDao
    abstract val othersDao: OthersDao
}