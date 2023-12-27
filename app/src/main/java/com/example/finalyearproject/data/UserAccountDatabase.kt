package com.example.finalyearproject.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.finalyearproject.data.dao.UserAccountDao
import com.example.finalyearproject.data.entity.UserAccount

@Database(entities =[UserAccount::class],version = 1, exportSchema = false)
abstract class UserAccountDatabase: RoomDatabase() {
    abstract val userAccountDao: UserAccountDao

    /* companion object {
         @Volatile
         private var INSTANCE: UserAccountDatabase? = null

         fun getInstance(context: Context): UserAccountDatabase {
             synchronized(this) {
                 return INSTANCE ?: Room.databaseBuilder(
                     context.applicationContext,
                     UserAccountDatabase::class.java,
                     "healthCareApp_db"
                 ).build().also {
                     INSTANCE = it
                 }
             }
         }
     }*/

}