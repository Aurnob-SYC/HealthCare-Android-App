package com.example.finalyearproject.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.finalyearproject.ui.screen.viewModel.UserAccountViewModel
import com.example.finalyearproject.ui.screen.homeScreen
import com.example.finalyearproject.ui.screen.logInScreen
import com.example.finalyearproject.ui.screen.signUpScreen


@Composable
fun navGraph(
    navController: NavHostController,
    viewModel: UserAccountViewModel,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = "LogIn",
        modifier = modifier
    ) {

        composable(route = "LogIn") {
            logInScreen(navController = navController, viewModel = viewModel)
        }

        composable(route = "SignUp") {
            signUpScreen(navController = navController, viewModel = viewModel)
        }
        
        composable(route = "Home") {
            homeScreen(navController = navController, viewModel = viewModel)
        }
    }
}