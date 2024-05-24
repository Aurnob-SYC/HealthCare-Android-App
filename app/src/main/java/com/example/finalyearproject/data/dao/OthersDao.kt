package com.example.finalyearproject.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.finalyearproject.data.entity.HealthArticles
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
    /*fun getAllLabTests(): List<LabTest>
    abstract fun updateLabTest(labTest: LabTest)
    fun getAllMedicines(): List<Medicine>
    abstract fun updateMedicine(medicine: Medicine)
    abstract fun getAllHealthArticles(): List<HealthArticles>
    abstract fun insertHealthArticle(healthArticle: HealthArticles)
    abstract fun updateHealthArticle(healthArticle: HealthArticles)
    abstract fun deleteHealthArticle(healthArticle: HealthArticles)*/

}

