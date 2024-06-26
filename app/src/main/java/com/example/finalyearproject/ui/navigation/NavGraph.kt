package com.example.finalyearproject.ui.navigation

import DoctorScreen
import LabTestScreen
import MedicineScreen


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.finalyearproject.ui.screen.OrderDetailsScreen
import com.example.finalyearproject.ui.screen.viewModel.UserAccountViewModel
import com.example.finalyearproject.ui.screen.homeScreen
import com.example.finalyearproject.ui.screen.logInScreen
import com.example.finalyearproject.ui.screen.signUpScreen
import healthArticleScreen


@Composable
fun navGraph(
    navController: NavHostController,
    userAccountViewModel: UserAccountViewModel,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = "LogIn",
        modifier = modifier
    ) {

        composable(route = "LogIn") {
            logInScreen(navController = navController, viewModel = userAccountViewModel)
        }

        composable(route = "SignUp") {
            signUpScreen(navController = navController, viewModel = userAccountViewModel)
        }
        
        composable(route = "Home") {
            homeScreen(navController = navController, viewModel = userAccountViewModel)
        }

        composable(route = "HealthArticle") {
            healthArticleScreen(navController = navController, viewModel = userAccountViewModel)
        }

        composable(route = "Medicine") {
            MedicineScreen(navController = navController, viewModel = userAccountViewModel)
        }

        composable(route = "LabTest") {
            LabTestScreen(navController = navController, viewModel = userAccountViewModel)
        }

        composable(route = "Doctor") {
            DoctorScreen(navController = navController, viewModel = userAccountViewModel)
        }
        composable(route = "OrderDetails") {
            OrderDetailsScreen(navController = navController, viewModel = userAccountViewModel)
        }
    }
}