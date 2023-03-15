package com.example.shiftkeydemo.presentation.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object ShiftDetails : Screen("details_screen")
}
