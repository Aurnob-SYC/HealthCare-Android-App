package com.example.finalyearproject.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.finalyearproject.data.dao.OthersDao
import com.example.finalyearproject.data.dao.UserAccountDao
import com.example.finalyearproject.data.entity.Appointment
import com.example.finalyearproject.data.entity.Doctor
import com.example.finalyearproject.data.entity.HealthArticles
import com.example.finalyearproject.data.entity.LabTest
import com.example.finalyearproject.data.entity.Medicine
import com.example.finalyearproject.data.entity.OrderDetails
import com.example.finalyearproject.data.entity.UserAccount
import com.example.finalyearproject.data.typeConverter.AppointmentListTypeConverter
import com.example.finalyearproject.data.typeConverter.BooleanListTypeConverter
import com.example.finalyearproject.data.typeConverter.DateTypeConverter
import com.example.finalyearproject.data.typeConverter.ProductsListTypeConverter

@Database(entities =[UserAccount::class, Appointment::class, Doctor::class, HealthArticles::class, LabTest::class, Medicine::class, OrderDetails::class],version = 3, exportSchema = false)
@TypeConverters(AppointmentListTypeConverter::class, BooleanListTypeConverter::class, DateTypeConverter::class, ProductsListTypeConverter::class)
abstract class UserAccountDatabase: RoomDatabase() {
    abstract val userAccountDao: UserAccountDao
    abstract val othersDao: OthersDao
}