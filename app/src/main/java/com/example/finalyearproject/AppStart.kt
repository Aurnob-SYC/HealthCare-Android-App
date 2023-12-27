package com.example.finalyearproject

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.finalyearproject.ui.navigation.navGraph
import com.example.finalyearproject.ui.screen.UserAccountViewModel

@Composable
fun appStart(
    navController: NavHostController = rememberNavController(),
    viewModel: UserAccountViewModel
) {
    navGraph(navController = navController, viewModel = viewModel)
}