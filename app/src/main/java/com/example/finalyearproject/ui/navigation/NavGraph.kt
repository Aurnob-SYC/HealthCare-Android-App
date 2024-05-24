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
    }
}