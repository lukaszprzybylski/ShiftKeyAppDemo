package com.example.shiftkeydemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shiftkeydemo.presentation.navigation.NavGraph
import com.example.shiftkeydemo.ui.theme.ShiftKeyDemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShiftKeyDemoTheme {
                navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}
