package com.example.finalyearproject.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.finalyearproject.data.entity.LabTest
import com.example.finalyearproject.data.entity.Medicine
import com.example.finalyearproject.data.entity.UserAccount

@Dao
interface OthersDao {
    // Medicine
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMedicine(medicine: Medicine)

    @Delete
    fun deleteMedicine(medicine: Medicine)

    //Lab Test
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLabTest(labTest: LabTest)

    @Delete
    fun deleteLabTest(labTest: LabTest)

}