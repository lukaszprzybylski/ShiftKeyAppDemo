package com.example.shiftkeydemo.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shiftkeydemo.presentation.details.DetailsScreen
import com.example.shiftkeydemo.presentation.screen.home.HomeScreen
import com.example.shiftkeydemo.presentation.screen.home.ShiftViewModel

@Composable
fun NavGraph(navController: NavHostController) {

    val shiftViewModel: ShiftViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController, viewModel = shiftViewModel)
        }
        composable(route = Screen.ShiftDetails.route) {
            DetailsScreen(viewModel = shiftViewModel)
        }
    }
}
