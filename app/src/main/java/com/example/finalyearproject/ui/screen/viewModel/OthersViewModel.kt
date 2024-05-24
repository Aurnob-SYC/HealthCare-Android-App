package com.example.finalyearproject.ui.screen.viewModel

import androidx.lifecycle.ViewModel
import com.example.finalyearproject.data.dao.OthersDao
import com.example.finalyearproject.data.entity.HealthArticles
import com.example.finalyearproject.data.entity.LabTest
import com.example.finalyearproject.data.entity.Medicine
import com.example.finalyearproject.data.entity.UserAccount
import java.util.*

class OthersViewModel(val othersDao: OthersDao): ViewModel() {
    // Method to fetch all lab tests from the database
    /*fun getAllLabTests(): List<LabTest> {
        return othersDao.getAllLabTests()
    }

    // Method to add a new lab test to the database
    fun addLabTest(name: String, price: Int) {
        val labTest = LabTest(name = name, price = price)
        othersDao.insertLabTest(labTest)
    }

    // Method to update an existing lab test in the database
    fun updateLabTest(labTest: LabTest) {
        othersDao.updateLabTest(labTest)
    }

    // Method to delete a lab test from the database
    fun deleteLabTest(labTest: LabTest) {
        othersDao.deleteLabTest(labTest)
    }

    fun getAllMedicines(): List<Medicine> {
        return othersDao.getAllMedicines()
    }

    // Method to add a new medicine to the database
    fun addMedicine(name: String, price: Int) {
        val medicine = Medicine(name = name, price = price)
        othersDao.insertMedicine(medicine)
    }

    // Method to update an existing medicine in the database
    fun updateMedicine(medicine: Medicine) {
        othersDao.updateMedicine(medicine)
    }

    // Method to delete a medicine from the database
    fun deleteMedicine(medicine: Medicine) {
        othersDao.deleteMedicine(medicine)
    }

    // Method to fetch all health articles from the database
    fun getAllHealthArticles(): List<HealthArticles> {
        return othersDao.getAllHealthArticles()
    }

    // Method to add a new health article to the database
    fun addHealthArticle(name: String, imageURL: String) {
        val healthArticle = HealthArticles(name = name, imageURL = imageURL)
        othersDao.insertHealthArticle(healthArticle)
    }

    // Method to update an existing health article in the database
    fun updateHealthArticle(healthArticle: HealthArticles) {
        othersDao.updateHealthArticle(healthArticle)
    }

    // Method to delete a health article from the database
    fun deleteHealthArticle(healthArticle: HealthArticles) {
        othersDao.deleteHealthArticle(healthArticle)
    }*/
}

data class CurrentList(
    val email: String = "",
    val products: List<Pair<String, Int>>,
    val appointment: List<Pair<String, Date>>
)