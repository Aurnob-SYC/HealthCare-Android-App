package com.example.finalyearproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.finalyearproject.data.UserAccountDatabase
import com.example.finalyearproject.data.entity.UserAccount
import com.example.finalyearproject.ui.screen.UserAccountViewModel
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

