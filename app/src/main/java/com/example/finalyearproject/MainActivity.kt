package com.example.finalyearproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.finalyearproject.data.UserAccountDatabase
import com.example.finalyearproject.ui.screen.viewModel.OthersViewModel
import com.example.finalyearproject.ui.screen.viewModel.UserAccountViewModel
import com.example.finalyearproject.ui.theme.FinalYearProjectTheme

class MainActivity : ComponentActivity() {
    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            UserAccountDatabase::class.java,
            "contacts.db"
        ).build()
    }
    private val viewModel by viewModels<UserAccountViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return UserAccountViewModel(db.userAccountDao) as T
                }
            }
        }
    )
    private val viewModelOthers by viewModels<OthersViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return OthersViewModel(db.othersDao) as T
                }
            }
        }
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalYearProjectTheme {

                //viewModel.deleteAll()
                appStart(viewModel = viewModel)

            }
        }
    }
}

